package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.RetrieveDataManager;
import com.tencent.ttpic.util.RetrieveDataManager.DATA_TYPE;
import java.util.Random;

public class VideoPreviewFaceOutlineDetector
  extends FaceDetector
{
  private static final PointF POINT_ZERO = new PointF();
  private static final String TAG = VideoPreviewFaceOutlineDetector.class.getSimpleName();
  private static final VideoPreviewFaceOutlineDetector mVideoPreviewFaceOutlineDetector = new VideoPreviewFaceOutlineDetector();
  private boolean isRunning = false;
  private int mDetectType = FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
  
  private float getFakeFaceValues(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0.0F;
    case 1: 
      return 0.18F + new Random().nextFloat() * 0.12F;
    case 2: 
      return new Random().nextFloat();
    case 4: 
      return new Random().nextFloat() * 0.2F + 0.8F;
    }
    return new Random().nextFloat() * 0.2F + 0.8F;
  }
  
  public static VideoPreviewFaceOutlineDetector getInstance()
  {
    return mVideoPreviewFaceOutlineDetector;
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void doFaceDetect(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != paramInt1 * paramInt2 * 4)) {}
  }
  
  public void doFaceDetectByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != paramInt1 * paramInt2)) {}
  }
  
  public void doTrack(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void doTrackByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BenchUtil.benchStart("FaceTrack");
    doTrack(paramArrayOfByte, paramInt1, paramInt2);
    BenchUtil.benchEnd("FaceTrack");
    if ((needDetectFace()) && (!this.isRunning))
    {
      this.isRunning = true;
      postJob(new VideoPreviewFaceOutlineDetector.2(this, paramArrayOfByte, paramInt1, paramInt2));
    }
  }
  
  public byte[] doTrackByTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, paramInt1, paramInt2, paramInt3);
    doTrack(arrayOfByte, paramInt2, paramInt3);
    if (needDetectFace()) {
      postJob(new VideoPreviewFaceOutlineDetector.1(this, arrayOfByte, paramInt2, paramInt3));
    }
    return arrayOfByte;
  }
  
  public void doTrackProcesesByY(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public RetrieveDataManager.DATA_TYPE getDataType()
  {
    return RetrieveDataManager.DATA_TYPE.RGBA;
  }
  
  public float getFaceValues(int paramInt1, int paramInt2)
  {
    return getFakeFaceValues(paramInt2);
  }
  
  public int init()
  {
    return super.init();
  }
  
  public boolean needDetectFaceValue()
  {
    return this.mDetectType != FaceDetector.DETECT_TYPE.DETECT_TYPE_NONE.value;
  }
  
  public void setFaceValueDetectType(int paramInt)
  {
    this.mDetectType = paramInt;
  }
  
  public void setRefine(boolean paramBoolean)
  {
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector
 * JD-Core Version:    0.7.0.1
 */