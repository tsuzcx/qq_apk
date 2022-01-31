package com.tencent.ttpic.gles;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SegmentDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  public static final String TAG;
  private static float[] sMtxIdentity;
  public List<float[]> allFaceAngles;
  public List<List<PointF>> allFacePoints;
  public List<float[]> allHandAngles;
  public List<PointF> allHandPoints;
  public List<List<PointF>> allIrisPoints;
  public List<BodyDetectResult> bodyDetectResults;
  public int[] brightnessAdjustmentCurve;
  public Map<Integer, FaceActionCounter> faceActionCounter;
  public List<FaceStatus> faceStatus;
  public Pair<Integer, int[]> histogram;
  public byte[] mData;
  public h mMaskFrame;
  public h mTexFrame;
  public AtomicInteger mTextureDataFlag;
  public long mTimestamp;
  public Set<Integer> mTriggeredExpressionType;
  
  static
  {
    AppMethodBeat.i(83258);
    TAG = SegmentDataPipe.class.getSimpleName();
    sMtxIdentity = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    AppMethodBeat.o(83258);
  }
  
  public SegmentDataPipe()
  {
    AppMethodBeat.i(83249);
    this.mTextureDataFlag = new AtomicInteger(0);
    this.mTriggeredExpressionType = new HashSet();
    this.mTexFrame = new h();
    this.mMaskFrame = new h();
    AppMethodBeat.o(83249);
  }
  
  public int getTexureCurrentStatus()
  {
    AppMethodBeat.i(83257);
    int i = this.mTextureDataFlag.getAndAdd(0);
    AppMethodBeat.o(83257);
    return i;
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83250);
    if (paramArrayOfFloat.length != 16)
    {
      paramArrayOfFloat = new IllegalArgumentException();
      AppMethodBeat.o(83250);
      throw paramArrayOfFloat;
    }
    System.arraycopy(sMtxIdentity, 0, paramArrayOfFloat, 0, sMtxIdentity.length);
    AppMethodBeat.o(83250);
  }
  
  public boolean isBusy()
  {
    AppMethodBeat.i(83251);
    if (this.mTextureDataFlag.get() == 1)
    {
      AppMethodBeat.o(83251);
      return true;
    }
    AppMethodBeat.o(83251);
    return false;
  }
  
  public boolean isReady()
  {
    AppMethodBeat.i(83252);
    if (this.mTextureDataFlag.get() == 2)
    {
      AppMethodBeat.o(83252);
      return true;
    }
    AppMethodBeat.o(83252);
    return false;
  }
  
  public void makeBusy()
  {
    AppMethodBeat.i(83255);
    this.mTextureDataFlag.getAndSet(1);
    AppMethodBeat.o(83255);
  }
  
  public void makeDataReady()
  {
    AppMethodBeat.i(83256);
    this.mTextureDataFlag.getAndSet(2);
    AppMethodBeat.o(83256);
  }
  
  public void makeFree()
  {
    AppMethodBeat.i(83254);
    this.mTextureDataFlag.getAndSet(0);
    AppMethodBeat.o(83254);
  }
  
  public void release()
  {
    AppMethodBeat.i(83253);
    this.mTexFrame.clear();
    this.mMaskFrame.clear();
    AppMethodBeat.o(83253);
  }
  
  public static abstract interface OnFrameAvailableListener
  {
    public abstract void onFrameAvailable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.gles.SegmentDataPipe
 * JD-Core Version:    0.7.0.1
 */