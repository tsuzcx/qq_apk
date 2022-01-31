package com.tencent.ttpic.facedetect;

import android.content.Context;
import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.face.LeftEyeRangeDetector;
import com.tencent.ttpic.face.MouthRangeDetector;
import com.tencent.ttpic.face.RightEyeRangeDetector;
import com.tencent.ttpic.model.FabbyFaceActionCounter;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceActionCallback;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.ExpressionDetector;
import com.tencent.ttpic.util.youtu.YoutuPointsUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class FaceDetector
{
  protected static final int FACE_DET_INTERVAL = 7;
  private static final String TAG = FaceDetector.class.getSimpleName();
  protected static final Object mDetectLock = new Object();
  private Sensor accelerometer;
  private double angle = 0.0D;
  private FaceDetector.FACE_DETECT_MODE faceDetectMode = FaceDetector.FACE_DETECT_MODE.MULTIPLE;
  protected List<FaceInfo> faceInfos = new ArrayList();
  protected Handler mDetectorThreadHandler;
  protected final SparseArray<Set<FaceActionCallback>> mFaceActionCallbacks = new SparseArray();
  protected final Map<Integer, FaceActionCounter> mFaceActionCounter = new HashMap();
  protected final Map<Integer, Boolean> mFaceActionStatus = new HashMap();
  private SensorEventListener mSensorEventListener = new FaceDetector.1(this);
  public int mTrackFrameCount;
  protected Set<Integer> mTriggeredExpressionType = new HashSet();
  protected boolean mUpdateActionCounter;
  private SensorManager sensorManager;
  
  public void addFaceActionCallback(int paramInt, FaceActionCallback paramFaceActionCallback)
  {
    if (paramFaceActionCallback == null) {
      return;
    }
    Set localSet = (Set)this.mFaceActionCallbacks.get(paramInt);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.mFaceActionCallbacks.put(paramInt, localObject);
    }
    ((Set)localObject).add(paramFaceActionCallback);
  }
  
  public void clearActionCounter()
  {
    this.mUpdateActionCounter = true;
    Iterator localIterator = this.mFaceActionCounter.values().iterator();
    while (localIterator.hasNext()) {
      ((FaceActionCounter)localIterator.next()).clear();
    }
  }
  
  public void clearSavedTriggeredExpression()
  {
    this.mTriggeredExpressionType.clear();
  }
  
  public void destroy()
  {
    synchronized (mDetectLock)
    {
      if (this.mDetectorThreadHandler != null)
      {
        this.mDetectorThreadHandler.getLooper().quit();
        this.mDetectorThreadHandler = null;
        this.mFaceActionStatus.clear();
        this.mFaceActionCallbacks.clear();
        this.sensorManager.unregisterListener(this.mSensorEventListener);
      }
      return;
    }
  }
  
  public boolean detectExpression(int paramInt)
  {
    return (this.mTriggeredExpressionType.contains(Integer.valueOf(paramInt))) || (paramInt == VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value);
  }
  
  public FaceRangeStatus detectFaceRangeStatus(List<PointF> paramList)
  {
    FaceRangeStatus localFaceRangeStatus = new FaceRangeStatus();
    if ((paramList == null) || (paramList.size() < 90)) {
      return localFaceRangeStatus;
    }
    localFaceRangeStatus.leftEye = LeftEyeRangeDetector.getInstance().detectRange(paramList);
    localFaceRangeStatus.rightEye = RightEyeRangeDetector.getInstance().detectRange(paramList);
    localFaceRangeStatus.mouth = MouthRangeDetector.getInstance().detectRange(paramList);
    if (AlgoUtils.getDistance((PointF)paramList.get(77), (PointF)paramList.get(69)) / AlgoUtils.getDistance((PointF)paramList.get(65), (PointF)paramList.get(66)) >= 0.6F) {}
    for (boolean bool = true;; bool = false)
    {
      localFaceRangeStatus.isKiss = bool;
      return localFaceRangeStatus;
    }
  }
  
  public abstract void doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void doTrackByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract byte[] doTrackByTexture(int paramInt1, int paramInt2, int paramInt3);
  
  public List<float[]> getAllFaceAngles()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getFaceCount())
    {
      localArrayList.add(getFaceAngles(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<List<PointF>> getAllFaces()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < getFaceCount())
    {
      localArrayList.add(getAllPoints(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public List<PointF> getAllPoints(int paramInt)
  {
    try
    {
      if (VideoUtil.indexOutOfBounds(this.faceInfos, paramInt))
      {
        localObject1 = new ArrayList();
        return localObject1;
      }
      Object localObject1 = ((FaceInfo)this.faceInfos.get(paramInt)).points;
      return localObject1;
    }
    finally {}
  }
  
  public abstract RetrieveDataManager.DATA_TYPE getDataType();
  
  public Map<Integer, FaceActionCounter> getFaceActionCounter()
  {
    return this.mFaceActionCounter;
  }
  
  public float[] getFaceAngles(int paramInt)
  {
    try
    {
      if (VideoUtil.indexOutOfBounds(this.faceInfos, paramInt)) {
        return new float[0];
      }
      float[] arrayOfFloat = ((FaceInfo)this.faceInfos.get(paramInt)).angles;
      return arrayOfFloat;
    }
    finally {}
  }
  
  public int getFaceCount()
  {
    return this.faceInfos.size();
  }
  
  public List<FaceStatus> getFaceStatus3Ds()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.faceInfos.iterator();
    while (localIterator.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
      FaceStatus localFaceStatus = new FaceStatus();
      localFaceStatus.pitch = localFaceInfo.pitch;
      localFaceStatus.yaw = localFaceInfo.yaw;
      localFaceStatus.roll = localFaceInfo.roll;
      localFaceStatus.tx = localFaceInfo.tx;
      localFaceStatus.ty = localFaceInfo.ty;
      localFaceStatus.scale = localFaceInfo.scale;
      localFaceStatus.denseFaceModel = localFaceInfo.denseFaceModel;
      localFaceStatus.transform = localFaceInfo.transform;
      localArrayList.add(localFaceStatus);
    }
    return localArrayList;
  }
  
  public float getPhotoAngle()
  {
    return (float)this.angle;
  }
  
  public Set<Integer> getTriggeredExpression()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mTriggeredExpressionType.iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(Integer.valueOf(((Integer)localIterator.next()).intValue()));
    }
    return localHashSet;
  }
  
  public int init()
  {
    if (this.mDetectorThreadHandler == null)
    {
      synchronized (mDetectLock)
      {
        if (this.mDetectorThreadHandler != null) {
          break label257;
        }
        Object localObject1 = VideoMaterialUtil.TRIGGER_TYPE.values();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          arrayOfTRIGGER_TYPE = localObject1[i];
          this.mFaceActionStatus.put(Integer.valueOf(arrayOfTRIGGER_TYPE.value), Boolean.valueOf(false));
          i += 1;
        }
        VideoMaterialUtil.TRIGGER_TYPE[] arrayOfTRIGGER_TYPE = VideoMaterialUtil.TRIGGER_TYPE.values();
        j = arrayOfTRIGGER_TYPE.length;
        i = 0;
        while (i < j)
        {
          localObject1 = arrayOfTRIGGER_TYPE[i];
          Map localMap = this.mFaceActionCounter;
          int k = ((VideoMaterialUtil.TRIGGER_TYPE)localObject1).value;
          if (((VideoMaterialUtil.TRIGGER_TYPE)localObject1).value != VideoMaterialUtil.TRIGGER_TYPE.MV_PART_INDEX.value)
          {
            localObject1 = new FaceActionCounter(0, -1L);
            localMap.put(Integer.valueOf(k), localObject1);
            i += 1;
          }
          else
          {
            localObject1 = new FabbyFaceActionCounter(0, -1L);
          }
        }
      }
      this.sensorManager = ((SensorManager)VideoGlobalContext.getContext().getSystemService("sensor"));
      this.accelerometer = this.sensorManager.getDefaultSensor(1);
      this.sensorManager.registerListener(this.mSensorEventListener, this.accelerometer, 3);
      HandlerThread localHandlerThread = new HandlerThread("VideoPreviewFaceOutlineDetector");
      localHandlerThread.start();
      this.mDetectorThreadHandler = new Handler(localHandlerThread.getLooper());
    }
    label257:
    return 0;
  }
  
  public void lockActionCounter()
  {
    this.mUpdateActionCounter = false;
  }
  
  public boolean needDetectFace()
  {
    if (this.faceDetectMode == FaceDetector.FACE_DETECT_MODE.SINGLE) {
      if (getFaceCount() != 0) {}
    }
    while (this.mTrackFrameCount > 7)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void postJob(Runnable paramRunnable)
  {
    if ((paramRunnable == null) || (this.mDetectorThreadHandler == null)) {
      return;
    }
    this.mDetectorThreadHandler.post(paramRunnable);
  }
  
  public void removeFaceActionCallback(FaceActionCallback paramFaceActionCallback)
  {
    if (paramFaceActionCallback == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mFaceActionCallbacks.size())
      {
        Set localSet = (Set)this.mFaceActionCallbacks.valueAt(i);
        if (localSet != null) {
          localSet.remove(paramFaceActionCallback);
        }
        i += 1;
      }
    }
  }
  
  public void setFaceDetectMode(FaceDetector.FACE_DETECT_MODE paramFACE_DETECT_MODE)
  {
    this.faceDetectMode = paramFACE_DETECT_MODE;
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
        if (this.mTriggeredExpressionType.contains(Integer.valueOf(((VideoMaterialUtil.TRIGGER_TYPE)localObject).value)))
        {
          localObject = (FaceActionCounter)this.mFaceActionCounter.get(Integer.valueOf(((VideoMaterialUtil.TRIGGER_TYPE)localObject).value));
          if (l - ((FaceActionCounter)localObject).updateTime > 1000L)
          {
            ((FaceActionCounter)localObject).count += 1;
            ((FaceActionCounter)localObject).updateTime = l;
          }
        }
        i += 1;
      }
    }
  }
  
  protected void updateActionStatusChanged()
  {
    int i = 0;
    while (i < this.mFaceActionCallbacks.size())
    {
      int j = this.mFaceActionCallbacks.keyAt(i);
      boolean bool1 = ((Boolean)this.mFaceActionStatus.get(Integer.valueOf(j))).booleanValue();
      boolean bool2 = detectExpression(j);
      if (bool1 != bool2)
      {
        Iterator localIterator = ((Set)this.mFaceActionCallbacks.valueAt(i)).iterator();
        while (localIterator.hasNext()) {
          ((FaceActionCallback)localIterator.next()).onActionDetected(j, bool2);
        }
      }
      this.mFaceActionStatus.put(Integer.valueOf(j), Boolean.valueOf(bool2));
      i += 1;
    }
  }
  
  protected void updatePointsAndAngles(FaceStatus[] paramArrayOfFaceStatus, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        this.faceInfos.clear();
        if (paramArrayOfFaceStatus == null) {
          return;
        }
        int k = paramArrayOfFaceStatus.length;
        int i = 0;
        if (i < k)
        {
          FaceStatus localFaceStatus = paramArrayOfFaceStatus[i];
          FaceInfo localFaceInfo = new FaceInfo();
          localFaceInfo.points = YoutuPointsUtil.transformYTPointsToPtuPoints(localFaceStatus.xys);
          localFaceInfo.angles[0] = ((float)(localFaceStatus.pitch * 3.141592653589793D / 180.0D));
          float[] arrayOfFloat = localFaceInfo.angles;
          float f = (float)(localFaceStatus.yaw * 3.141592653589793D / 180.0D);
          if (paramBoolean)
          {
            j = -1;
            arrayOfFloat[1] = (j * f);
            arrayOfFloat = localFaceInfo.angles;
            f = (float)(localFaceStatus.roll * 3.141592653589793D / 180.0D);
            if (!paramBoolean) {
              break label275;
            }
            j = -1;
            arrayOfFloat[2] = (j * f);
            localFaceInfo.scale = localFaceStatus.scale;
            localFaceInfo.pitch = localFaceStatus.pitch;
            localFaceInfo.yaw = localFaceStatus.yaw;
            localFaceInfo.roll = localFaceStatus.roll;
            localFaceInfo.tx = localFaceStatus.tx;
            localFaceInfo.ty = localFaceStatus.ty;
            localFaceInfo.denseFaceModel = localFaceStatus.denseFaceModel;
            localFaceInfo.transform = localFaceStatus.transform;
            this.faceInfos.add(localFaceInfo);
            i += 1;
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      int j = 1;
      continue;
      label275:
      j = 1;
    }
  }
  
  protected void updateTriggerExpression()
  {
    this.mTriggeredExpressionType.clear();
    VideoMaterialUtil.TRIGGER_TYPE[] arrayOfTRIGGER_TYPE = VideoMaterialUtil.TRIGGER_TYPE.values();
    int m = arrayOfTRIGGER_TYPE.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      VideoMaterialUtil.TRIGGER_TYPE localTRIGGER_TYPE = arrayOfTRIGGER_TYPE[i];
      k = j;
      if (ExpressionDetector.getInstance().detectExpression(localTRIGGER_TYPE.value))
      {
        this.mTriggeredExpressionType.add(Integer.valueOf(localTRIGGER_TYPE.value));
        k = j;
        if (ExpressionDetector.needSaveDetectedExpression(localTRIGGER_TYPE.value)) {
          k = 1;
        }
      }
      i += 1;
    }
    if (j != 0) {
      ExpressionDetector.getInstance().clearFaceQueue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.FaceDetector
 * JD-Core Version:    0.7.0.1
 */