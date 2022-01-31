package com.tencent.ttpic.util.youtu;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.util.g;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GestureDetector
{
  private static final long CLASSIFY_INTERVAL = 200L;
  private static final long DETECT_INTERVAL = 500L;
  private static final float GESTURE_ACCEPT_CONFIDENCE = 0.5F;
  private static final int HANDBOX_QUEUE_MAX_SIZE = 3;
  private static final String TAG = GestureDetector.class.getSimpleName();
  private static GestureDetector mInstance;
  private boolean bProcessing = false;
  private YtHandBox box = new YtHandBox();
  private long classifyTimestamp;
  private long detectTimestamp;
  private YtHandLabel detectedGestureLabel = new YtHandLabel();
  private YtHandBox detectedHandBox = new YtHandBox();
  private GestureDetector.GestureDetectHandler gestureDetectHandler;
  private GestureTrackHandler gestureTrackHandler;
  protected final Map<Integer, HandActionCounter> mHandActionCounter = new HashMap();
  protected boolean mUpdateActionCounter;
  private YtHandBox stable_box = new YtHandBox();
  
  static
  {
    try
    {
      System.loadLibrary("nnpack");
      System.loadLibrary("YTCommon");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private GestureDetector()
  {
    init();
  }
  
  public static boolean copyAsset(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    try
    {
      System.out.println(paramString2);
      paramAssetManager = paramAssetManager.open(paramString1);
      new File(paramString2).createNewFile();
      paramString1 = new FileOutputStream(paramString2);
      copyFile(paramAssetManager, paramString1);
      paramAssetManager.close();
      paramString1.flush();
      paramString1.close();
      return true;
    }
    catch (Exception paramAssetManager) {}
    return false;
  }
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void deleteFile(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      deleteFile(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  private void doDetect()
  {
    BenchUtil.benchStart("doDetect");
    BenchUtil.benchEnd("doDetect");
  }
  
  public static GestureDetector getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new GestureDetector();
      }
      GestureDetector localGestureDetector = mInstance;
      return localGestureDetector;
    }
    finally {}
  }
  
  private PointF getMidPoint(PointF paramPointF1, PointF paramPointF2)
  {
    return new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
  }
  
  private void init()
  {
    YTCommonInterface.initAuth(VideoGlobalContext.getContext(), "com_tencent.licence", 0, true);
    Object localObject1 = VideoGlobalContext.getContext().getFilesDir().getAbsolutePath();
    copyAsset(VideoGlobalContext.getContext().getAssets(), "model/handdetect/" + "1.7mb-0916-add-ptu.pb.rapidnetmodel_nchw", (String)localObject1 + "/" + "1.7mb-0916-add-ptu.pb.rapidnetmodel_nchw");
    copyAsset(VideoGlobalContext.getContext().getAssets(), "model/handdetect/" + "1.7mb-0916-add-ptu.pb_bin.rapidnetproto_nchw_mod", (String)localObject1 + "/" + "1.7mb-0916-add-ptu.pb_bin.rapidnetproto_nchw_mod");
    copyAsset(VideoGlobalContext.getContext().getAssets(), "model/handclassify/" + "resnet_1.7_0914.rpnmodel", (String)localObject1 + "/" + "resnet_1.7_0914.rpnmodel");
    copyAsset(VideoGlobalContext.getContext().getAssets(), "model/handclassify/" + "resnet_1.7_0914_bin.rpnproto", (String)localObject1 + "/" + "resnet_1.7_0914_bin.rpnproto");
    copyAsset(VideoGlobalContext.getContext().getAssets(), "model/handalignment/" + "addptu300k.rpdm", (String)localObject1 + "/" + "addptu300k.rpdm");
    localObject1 = VideoMaterialUtil.TRIGGER_TYPE.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.mHandActionCounter.put(Integer.valueOf(localObject2.value), new HandActionCounter(0, -1L));
      i += 1;
    }
    localObject1 = new HandlerThread("GestureDetectThread");
    ((HandlerThread)localObject1).start();
    this.gestureDetectHandler = new GestureDetector.GestureDetectHandler(this, ((HandlerThread)localObject1).getLooper());
    localObject1 = new HandlerThread("GestureClassifyThread");
    ((HandlerThread)localObject1).start();
    this.gestureTrackHandler = new GestureTrackHandler(((HandlerThread)localObject1).getLooper());
  }
  
  private void tryLostGestureLabel()
  {
    if ((this.detectedGestureLabel.lostStartTimestamp > 0L) && (this.detectedGestureLabel.isConsiderLost())) {
      this.detectedGestureLabel.reset();
    }
    if (this.detectedGestureLabel.lostStartTimestamp < 0L) {
      this.detectedGestureLabel.lostStartTimestamp = System.currentTimeMillis();
    }
  }
  
  public void clearActionCounter()
  {
    this.mUpdateActionCounter = true;
    Iterator localIterator = this.mHandActionCounter.values().iterator();
    while (localIterator.hasNext()) {
      ((HandActionCounter)localIterator.next()).clear();
    }
  }
  
  public void destroy() {}
  
  public void detectGesture(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.bProcessing)
    {
      this.bProcessing = true;
      if (this.box.confidence < 0.5F) {
        this.gestureDetectHandler.sendEmptyMessage(0);
      }
    }
    else
    {
      return;
    }
    this.gestureTrackHandler.sendEmptyMessage(0);
  }
  
  public String getDetectedGestureLabel()
  {
    return this.detectedGestureLabel.name;
  }
  
  public YtHandBox getDetectedHandBox()
  {
    return this.detectedHandBox;
  }
  
  public Map<Integer, HandActionCounter> getHandActionCounter()
  {
    return this.mHandActionCounter;
  }
  
  public List<float[]> getHandAngles()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= 0)
    {
      localArrayList.add(new float[] { 0.0F, 0.0F, 0.0F });
      i += 1;
    }
    return localArrayList;
  }
  
  public List<PointF> getHandPoints()
  {
    ArrayList localArrayList = new ArrayList();
    PointF localPointF1 = new PointF(this.detectedHandBox.x, this.detectedHandBox.y);
    PointF localPointF2 = new PointF(this.detectedHandBox.x + this.detectedHandBox.width, this.detectedHandBox.y);
    PointF localPointF3 = new PointF(this.detectedHandBox.x, this.detectedHandBox.y + this.detectedHandBox.height);
    PointF localPointF4 = new PointF(this.detectedHandBox.x + this.detectedHandBox.width, this.detectedHandBox.y + this.detectedHandBox.height);
    PointF localPointF5 = getMidPoint(localPointF1, localPointF3);
    PointF localPointF6 = getMidPoint(localPointF1, localPointF2);
    PointF localPointF7 = getMidPoint(localPointF2, localPointF4);
    PointF localPointF8 = getMidPoint(localPointF3, localPointF4);
    localArrayList.add(getMidPoint(localPointF5, localPointF7));
    localArrayList.add(localPointF1);
    localArrayList.add(localPointF6);
    localArrayList.add(localPointF2);
    localArrayList.add(localPointF5);
    localArrayList.add(localPointF7);
    localArrayList.add(localPointF3);
    localArrayList.add(localPointF8);
    localArrayList.add(localPointF4);
    return localArrayList;
  }
  
  public boolean isGestureTriggered(int paramInt)
  {
    return (this.detectedGestureLabel.value == paramInt) || ((this.detectedHandBox.isValid()) && (paramInt == VideoMaterialUtil.TRIGGER_TYPE.HAND_LABEL_HAND.value)) || (paramInt == VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value);
  }
  
  public void lockActionCounter()
  {
    this.mUpdateActionCounter = false;
  }
  
  public void unlockActionCounter()
  {
    this.mUpdateActionCounter = true;
  }
  
  protected void updateActionCount()
  {
    if (!this.mUpdateActionCounter) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      VideoMaterialUtil.TRIGGER_TYPE[] arrayOfTRIGGER_TYPE = VideoMaterialUtil.TRIGGER_TYPE.values();
      int j = arrayOfTRIGGER_TYPE.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfTRIGGER_TYPE[i];
        if (this.detectedGestureLabel.value == ((VideoMaterialUtil.TRIGGER_TYPE)localObject).value)
        {
          localObject = (HandActionCounter)this.mHandActionCounter.get(Integer.valueOf(((VideoMaterialUtil.TRIGGER_TYPE)localObject).value));
          if (l - ((HandActionCounter)localObject).updateTime > 1000L)
          {
            ((HandActionCounter)localObject).count += 1;
            ((HandActionCounter)localObject).updateTime = l;
          }
        }
        i += 1;
      }
    }
  }
  
  private class GestureTrackHandler
    extends Handler
  {
    public GestureTrackHandler(Looper paramLooper)
    {
      super();
    }
    
    private void reset()
    {
      GestureDetector.this.detectedHandBox.reset();
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = new YtHandLabel();
      if (GestureDetector.this.box.confidence >= 0.5F)
      {
        GestureDetector.this.detectedGestureLabel.lostStartTimestamp = -1L;
        BenchUtil.benchStart("doHandAlignment");
        BenchUtil.benchEnd("doHandAlignment");
        g.i(GestureDetector.TAG, "doHandAlignment, box.confidence = " + GestureDetector.this.box.confidence);
        if (GestureDetector.this.box.confidence < 0.5F) {
          break label269;
        }
        GestureDetector.access$602(GestureDetector.this, GestureDetector.this.stable_box);
        long l = System.currentTimeMillis();
        if (l - GestureDetector.this.classifyTimestamp >= 200L)
        {
          GestureDetector.access$802(GestureDetector.this, l);
          BenchUtil.benchStart("doHandClassify");
          BenchUtil.benchEnd("doHandClassify");
          g.i(GestureDetector.TAG, "doHandClassify, label = " + paramMessage.name);
          if (paramMessage.value != 99) {
            break label221;
          }
          GestureDetector.this.tryLostGestureLabel();
          g.i(GestureDetector.TAG, paramMessage.name);
          GestureDetector.this.updateActionCount();
        }
      }
      for (;;)
      {
        GestureDetector.access$402(GestureDetector.this, false);
        return;
        label221:
        GestureDetector.this.detectedGestureLabel.name = paramMessage.name;
        GestureDetector.this.detectedGestureLabel.value = (paramMessage.value + 201);
        GestureDetector.this.detectedGestureLabel.lostStartTimestamp = -1L;
        break;
        label269:
        GestureDetector.this.tryLostGestureLabel();
        reset();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GestureDetector
 * JD-Core Version:    0.7.0.1
 */