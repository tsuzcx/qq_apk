package com.tencent.ttpic.util.youtu;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.manager.FeatureManager;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
  private static final float[] CLASSIFY_THRESHOLD;
  private static final float DETECT_THRESHOLD = 0.9F;
  public static int THREAD_NUM = 0;
  protected static final int TOP_K = 61;
  private static boolean mIS_BUSY;
  private static GestureDetector mInstance;
  public final String COLLECT_PATH;
  public Bitmap mBitmapCollect;
  protected float[] mClassifyOutputConfidence;
  public FileWriter mCollectInfoOut;
  private Handler mDetectHandler;
  private YtHandLabel mDetectedGestureLabel;
  private YtHandBox mDetectedHandBox;
  protected float[] mDetectorOutputConfidence;
  protected float[] mDetectorOutputXMax;
  protected float[] mDetectorOutputXMin;
  protected float[] mDetectorOutputYMax;
  protected float[] mDetectorOutputYMin;
  private boolean mEnableInterpolation;
  protected final Map<Integer, HandActionCounter> mHandActionCounter;
  private int mImageHeight;
  private int mImageWidth;
  private volatile boolean mInited;
  protected int[] mLabelIndex;
  protected boolean mUpdateActionCounter;
  
  static
  {
    AppMethodBeat.i(84364);
    THREAD_NUM = 2;
    mIS_BUSY = false;
    CLASSIFY_THRESHOLD = new float[] { 0.95F, 0.6F, 0.6F, 0.7F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.6F, 0.7F };
    if (FeatureManager.isGestureDetectionReady()) {
      try
      {
        System.loadLibrary("XGestureSDK");
        System.loadLibrary("pt_handdetector");
        AppMethodBeat.o(84364);
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        AppMethodBeat.o(84364);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(84364);
  }
  
  public GestureDetector()
  {
    AppMethodBeat.i(84349);
    this.COLLECT_PATH = (Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "Collect");
    this.mCollectInfoOut = null;
    this.mInited = false;
    this.mDetectedGestureLabel = new YtHandLabel();
    this.mDetectedHandBox = new YtHandBox();
    this.mEnableInterpolation = true;
    this.mHandActionCounter = new HashMap();
    AppMethodBeat.o(84349);
  }
  
  public static boolean copyAsset(AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    AppMethodBeat.i(84355);
    try
    {
      System.out.println(paramString2);
      paramAssetManager = paramAssetManager.open(paramString1);
      new File(paramString2).createNewFile();
      paramString1 = new FileOutputStream(paramString2);
      FileUtils.copyFile(paramAssetManager, paramString1);
      paramAssetManager.close();
      paramString1.flush();
      paramString1.close();
      AppMethodBeat.o(84355);
      return true;
    }
    catch (Exception paramAssetManager)
    {
      AppMethodBeat.o(84355);
    }
    return false;
  }
  
  private void deleteDirectory(File paramFile)
  {
    AppMethodBeat.i(84354);
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      int i = 0;
      while (i < paramFile.length)
      {
        paramFile[i].delete();
        i += 1;
      }
    }
    AppMethodBeat.o(84354);
  }
  
  public static GestureDetector getInstance()
  {
    try
    {
      AppMethodBeat.i(84350);
      if (mInstance == null) {
        mInstance = new GestureDetector();
      }
      if (!mInstance.mInited) {
        mInstance.init();
      }
      GestureDetector localGestureDetector = mInstance;
      AppMethodBeat.o(84350);
      return localGestureDetector;
    }
    finally {}
  }
  
  private PointF getMidPoint(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(84363);
    paramPointF1 = new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
    AppMethodBeat.o(84363);
    return paramPointF1;
  }
  
  public native boolean Gesture(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, int[] paramArrayOfInt1, int[] paramArrayOfInt2, float[] paramArrayOfFloat6);
  
  public native int Init(String paramString1, String paramString2, int paramInt);
  
  public native boolean Uninit();
  
  public void clearActionCounter()
  {
    AppMethodBeat.i(84362);
    this.mUpdateActionCounter = true;
    Iterator localIterator = this.mHandActionCounter.values().iterator();
    while (localIterator.hasNext()) {
      ((HandActionCounter)localIterator.next()).clear();
    }
    AppMethodBeat.o(84362);
  }
  
  public void clearPicture()
  {
    AppMethodBeat.i(84353);
    deleteDirectory(new File(this.COLLECT_PATH));
    AppMethodBeat.o(84353);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(84356);
    if (this.mInited)
    {
      Uninit();
      if (this.mDetectHandler != null) {
        this.mDetectHandler.getLooper().quit();
      }
      this.mInited = false;
      mInstance = null;
    }
    if (this.mBitmapCollect != null) {
      this.mBitmapCollect.recycle();
    }
    if (this.mCollectInfoOut != null) {
      try
      {
        this.mCollectInfoOut.close();
        AppMethodBeat.o(84356);
        return;
      }
      catch (IOException localIOException) {}
    }
    AppMethodBeat.o(84356);
  }
  
  public void detectHand(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84357);
    if ((!this.mInited) || (mIS_BUSY))
    {
      AppMethodBeat.o(84357);
      return;
    }
    this.mDetectHandler.post(new GestureDetector.1(this, paramArrayOfByte, paramInt1, paramInt2));
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
    AppMethodBeat.o(84357);
  }
  
  public Map<Integer, HandActionCounter> getHandActionCounter()
  {
    return this.mHandActionCounter;
  }
  
  public List<float[]> getHandAngles()
  {
    AppMethodBeat.i(84360);
    if (!this.mInited)
    {
      AppMethodBeat.o(84360);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= 0)
    {
      localArrayList.add(new float[] { 0.0F, 0.0F, 0.0F });
      i += 1;
    }
    AppMethodBeat.o(84360);
    return localArrayList;
  }
  
  public List<PointF> getHandPoints()
  {
    AppMethodBeat.i(84359);
    if (!this.mInited)
    {
      AppMethodBeat.o(84359);
      return null;
    }
    if (this.mDetectorOutputXMin[0] < 0.0F) {
      this.mDetectorOutputXMin[0] = 0.0F;
    }
    if (this.mDetectorOutputYMin[0] < 0.0F) {
      this.mDetectorOutputYMin[0] = 0.0F;
    }
    if (this.mDetectorOutputXMax[0] > this.mImageWidth) {
      this.mDetectorOutputXMax[0] = (this.mImageWidth - 1);
    }
    if (this.mDetectorOutputYMax[0] > this.mImageHeight) {
      this.mDetectorOutputYMax[0] = (this.mImageHeight - 1);
    }
    ArrayList localArrayList = new ArrayList();
    PointF localPointF1 = new PointF(this.mDetectorOutputXMin[0], this.mDetectorOutputYMin[0]);
    PointF localPointF2 = new PointF(this.mDetectorOutputXMax[0], this.mDetectorOutputYMin[0]);
    PointF localPointF3 = new PointF(this.mDetectorOutputXMin[0], this.mDetectorOutputYMax[0]);
    PointF localPointF4 = new PointF(this.mDetectorOutputXMax[0], this.mDetectorOutputYMax[0]);
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
    this.mDetectedHandBox.x = this.mDetectorOutputXMin[0];
    this.mDetectedHandBox.y = this.mDetectorOutputYMin[0];
    this.mDetectedHandBox.width = (this.mDetectorOutputXMax[0] - this.mDetectorOutputXMin[0]);
    this.mDetectedHandBox.height = (this.mDetectorOutputYMax[0] - this.mDetectorOutputYMin[0]);
    AppMethodBeat.o(84359);
    return localArrayList;
  }
  
  public void init()
  {
    AppMethodBeat.i(84351);
    if ((this.mInited) || (!FeatureManager.isGestureDetectionReady()))
    {
      AppMethodBeat.o(84351);
      return;
    }
    String str1 = VideoGlobalContext.getContext().getFilesDir().getAbsolutePath();
    String str3 = str1 + "/" + "cls.xnet";
    String str2 = str1 + "/" + "det.xnet";
    if (!new File(str3).exists())
    {
      String str4 = ResourcePathMapper.getModelResPath("cls.xnet");
      LogUtils.e("resPath", "resPath = ".concat(String.valueOf(str4)));
      if ((str4 == null) || (str4.startsWith("assets://"))) {
        break label312;
      }
      FileUtils.copyFile(str4 + "cls.xnet", str3);
    }
    for (;;)
    {
      if (!new File(str2).exists())
      {
        str3 = ResourcePathMapper.getModelResPath("det.xnet");
        if ((str3 == null) || (str3.startsWith("assets://"))) {
          break label339;
        }
        FileUtils.copyFile(str3 + "det.xnet", str2);
      }
      try
      {
        for (;;)
        {
          i = Init(str1 + "/" + "cls.xnet", str1 + "/" + "det.xnet", THREAD_NUM);
          if (i == 0) {
            break label449;
          }
          AppMethodBeat.o(84351);
          return;
          label312:
          copyAsset(VideoGlobalContext.getContext().getAssets(), "xlabHandmodel/".concat(String.valueOf("cls.xnet")), str3);
          break;
          label339:
          copyAsset(VideoGlobalContext.getContext().getAssets(), "xlabHandmodel/".concat(String.valueOf("det.xnet")), str2);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        try
        {
          System.loadLibrary("XGestureSDK");
          System.loadLibrary("pt_handdetector");
          i = Init(str1 + "/" + "cls.xnet", str1 + "/" + "det.xnet", THREAD_NUM);
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(84351);
          return;
        }
        label449:
        Object localObject1 = new HandlerThread("HandDetectThread");
        ((HandlerThread)localObject1).start();
        this.mDetectHandler = new Handler(((HandlerThread)localObject1).getLooper());
        this.mDetectorOutputConfidence = new float[61];
        this.mDetectorOutputXMin = new float[61];
        this.mDetectorOutputYMin = new float[61];
        this.mDetectorOutputXMax = new float[61];
        this.mDetectorOutputYMax = new float[61];
        this.mClassifyOutputConfidence = new float[61];
        this.mLabelIndex = new int[1];
        localObject1 = PTFaceAttr.PTExpression.values();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          this.mHandActionCounter.put(Integer.valueOf(localObject2.value), new HandActionCounter(0, -1L));
          i += 1;
        }
        this.mInited = true;
        AppMethodBeat.o(84351);
      }
    }
  }
  
  public void initWriteFile()
  {
    AppMethodBeat.i(84352);
    File localFile = new File(this.COLLECT_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    try
    {
      this.mCollectInfoOut = new FileWriter(this.COLLECT_PATH + File.separator + "xlabCollect.txt", true);
      AppMethodBeat.o(84352);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(84352);
    }
  }
  
  public boolean isGestureTriggered(int paramInt)
  {
    AppMethodBeat.i(84358);
    if ((this.mDetectedGestureLabel.value == paramInt) || ((this.mDetectedHandBox.isValid()) && (paramInt == PTFaceAttr.PTExpression.HAND_LABEL_HAND.value)) || (paramInt == PTFaceAttr.PTExpression.ALWAYS.value) || (this.mEnableInterpolation))
    {
      AppMethodBeat.o(84358);
      return true;
    }
    AppMethodBeat.o(84358);
    return false;
  }
  
  public void lockActionCounter()
  {
    this.mUpdateActionCounter = false;
  }
  
  public void setConfig(int paramInt)
  {
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mEnableInterpolation = bool;
      return;
    }
  }
  
  public void unlockActionCounter()
  {
    this.mUpdateActionCounter = true;
  }
  
  protected void updateActionCount()
  {
    AppMethodBeat.i(84361);
    if (!this.mUpdateActionCounter)
    {
      AppMethodBeat.o(84361);
      return;
    }
    long l = System.currentTimeMillis();
    PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.values();
    int j = arrayOfPTExpression.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfPTExpression[i];
      if (this.mDetectedGestureLabel.value == ((PTFaceAttr.PTExpression)localObject).value)
      {
        localObject = (HandActionCounter)this.mHandActionCounter.get(Integer.valueOf(((PTFaceAttr.PTExpression)localObject).value));
        if (l - ((HandActionCounter)localObject).updateTime > 1000L)
        {
          ((HandActionCounter)localObject).count += 1;
          ((HandActionCounter)localObject).updateTime = l;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(84361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GestureDetector
 * JD-Core Version:    0.7.0.1
 */