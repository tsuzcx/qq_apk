package com.tencent.ttpic.gles;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.ttpic.facedetect.FaceStatus;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SegmentDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  public static final String TAG = SegmentDataPipe.class.getSimpleName();
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public List<float[]> allFaceAngles;
  public List<List<PointF>> allFacePoints;
  public List<float[]> allHandAngles;
  public List<PointF> allHandPoints;
  public List<FaceStatus> faceStatus;
  public byte[] mData;
  public h mMaskFrame = new h();
  public h mTexFrame = new h();
  public AtomicInteger mTextureDataFlag = new AtomicInteger(0);
  public long mTimestamp;
  public Set<Integer> mTriggeredExpressionType = new HashSet();
  
  public int getTexureCurrentStatus()
  {
    return this.mTextureDataFlag.getAndAdd(0);
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 16) {
      throw new IllegalArgumentException();
    }
    System.arraycopy(sMtxIdentity, 0, paramArrayOfFloat, 0, sMtxIdentity.length);
  }
  
  public boolean isBusy()
  {
    return this.mTextureDataFlag.get() == 1;
  }
  
  public boolean isReady()
  {
    return this.mTextureDataFlag.get() == 2;
  }
  
  public void makeBusy()
  {
    this.mTextureDataFlag.getAndSet(1);
  }
  
  public void makeDataReady()
  {
    this.mTextureDataFlag.getAndSet(2);
  }
  
  public void makeFree()
  {
    this.mTextureDataFlag.getAndSet(0);
  }
  
  public void release()
  {
    this.mTexFrame.clear();
    this.mMaskFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.gles.SegmentDataPipe
 * JD-Core Version:    0.7.0.1
 */