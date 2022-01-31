package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GLSegSharedData;
import com.tencent.ttpic.gles.OffscreenSurface;
import com.tencent.ttpic.gles.SegmentDataPipe;
import com.tencent.ttpic.util.youtu.GestureDetector;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TargetApi(18)
public class FaceGestureDetGLThread
{
  public static final long BRIGHTNESS_DURATION = 2000L;
  private ExecutorService SINGLE_THREAD_EXECUTOR;
  private double averageFaceL;
  private int[] brightnessAdjustmentCurve;
  private byte[] brightnessAdjustmentData;
  private int curLevel;
  private int[] his;
  private final Object mBodyDetLock;
  private List<BodyDetectResult> mBodyDetectResults;
  private FaceGestureDetGLThread.OnBodyDetListener mBodyListener;
  private BaseFilter mCopyFilter;
  private h mCopyFrame;
  private EglCore mCore;
  private VideoPreviewFaceOutlineDetector mFaceDetector;
  private GestureDetector mGestureDetector;
  private Handler mHandler;
  private boolean mInitReady;
  private long mLastBrightnessTime;
  private FaceGestureDetGLThread.OnFaceDetListener mListener;
  private OffscreenSurface mOffscreenSurface;
  private GLSegSharedData sharedData;
  
  public FaceGestureDetGLThread(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(83753);
    this.mCopyFilter = new BaseFilter(GLSLRender.btg);
    this.mFaceDetector = new VideoPreviewFaceOutlineDetector();
    this.mGestureDetector = GestureDetector.getInstance();
    this.mLastBrightnessTime = -1L;
    this.mBodyDetLock = new Object();
    this.SINGLE_THREAD_EXECUTOR = Executors.newSingleThreadExecutor();
    this.mBodyListener = new FaceGestureDetGLThread.2(this);
    HandlerThread localHandlerThread = new HandlerThread("FaceGestureDetGLThread" + (int)(Math.random() * 100.0D));
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper());
    this.mHandler.post(new FaceGestureDetGLThread.1(this, paramEGLContext));
    AppMethodBeat.o(83753);
  }
  
  private double[] XYZ2Lab(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(83766);
    double d3 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[1];
    double d1 = paramArrayOfDouble[2];
    double d4 = d3 / 95.040000000000006D;
    d2 /= 100.0D;
    d3 = d1 / 108.89D;
    if (d4 > 0.008855999999999999D)
    {
      d1 = Math.pow(d4, 0.333333D);
      if (d2 <= 0.008855999999999999D) {
        break label157;
      }
      d2 = Math.pow(d2, 0.333333D);
      label79:
      if (d3 <= 0.008855999999999999D) {
        break label172;
      }
    }
    label157:
    label172:
    for (d3 = Math.pow(d3, 0.333333D);; d3 = 7.787D * d3 + 0.137931D)
    {
      AppMethodBeat.o(83766);
      return new double[] { 116.0D * d2 - 16.0D, (d1 - d2) * 500.0D, (d2 - d3) * 200.0D };
      d1 = d4 * 7.787D + 0.137931D;
      break;
      d2 = 7.787D * d2 + 0.137931D;
      break label79;
    }
  }
  
  private void createBrightnessCurve(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(83763);
    double d2 = 0.0D;
    double d1 = 0.0D;
    double d4;
    double d3;
    while (paramInt1 <= paramInt2)
    {
      paramInt6 = paramInt3;
      while (paramInt6 <= paramInt4)
      {
        int k = (paramInt6 * paramInt5 + paramInt1) * 4;
        d4 = d1;
        d3 = d2;
        if (k >= 0)
        {
          d4 = d1;
          d3 = d2;
          if (k + 2 < paramArrayOfByte.length)
          {
            int i = paramArrayOfByte[k];
            int j = paramArrayOfByte[(k + 1)];
            k = paramArrayOfByte[(k + 2)];
            d3 = d2 + XYZ2Lab(sRGB2XYZ(new double[] { i & 0xFF, j & 0xFF, k & 0xFF }))[0];
            d4 = d1 + 1.0D;
          }
        }
        paramInt6 += 1;
        d1 = d4;
        d2 = d3;
      }
      paramInt1 += 1;
    }
    if (d1 != 0.0D)
    {
      this.averageFaceL = (d2 / d1);
      double[] arrayOfDouble;
      ArrayList localArrayList1;
      if (this.averageFaceL < 60.0D)
      {
        d1 = 1.07D * (60.0D - this.averageFaceL) + 128.0D;
        this.brightnessAdjustmentCurve = new int[256];
        d3 = d1 - 128.0D;
        d2 = d3 / 3.0D;
        paramArrayOfByte = new double[3];
        byte[] tmp249_247 = paramArrayOfByte;
        tmp249_247[0] = 128.0D;
        byte[] tmp255_249 = tmp249_247;
        tmp255_249[1] = 64.0D;
        byte[] tmp261_255 = tmp255_249;
        tmp261_255[2] = 63.0D;
        tmp261_255;
        arrayOfDouble = new double[3];
        arrayOfDouble[0] = (d1 / 128.0D);
        arrayOfDouble[1] = ((192.0D + d3 / 3.0D - d1) / 64.0D);
        arrayOfDouble[2] = ((63.0D - d3 / 3.0D) / 63.0D);
        localArrayList1 = new ArrayList();
        localArrayList1.add(Double.valueOf(arrayOfDouble[0]));
        paramInt1 = 0;
        label348:
        if (paramInt1 >= 2) {
          break label474;
        }
        d3 = arrayOfDouble[paramInt1];
        d4 = arrayOfDouble[(paramInt1 + 1)];
        if (d3 * d4 > 0.0D) {
          break label415;
        }
        localArrayList1.add(Double.valueOf(0.0D));
      }
      label415:
      double d5;
      double d6;
      for (;;)
      {
        paramInt1 += 1;
        break label348;
        d1 = 1.0D * (60.0D - this.averageFaceL) + 128.0D;
        break;
        d5 = paramArrayOfByte[paramInt1];
        d6 = paramArrayOfByte[(paramInt1 + 1)];
        double d7 = d5 + d6;
        localArrayList1.add(Double.valueOf(3.0D * d7 / ((d6 + d7) / d3 + (d5 + d7) / d4)));
      }
      label474:
      localArrayList1.add(Double.valueOf(arrayOfDouble[2]));
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      paramInt1 = 0;
      while (paramInt1 < localArrayList1.size() - 1)
      {
        d3 = ((Double)localArrayList1.get(paramInt1)).doubleValue();
        d4 = arrayOfDouble[paramInt1];
        d5 = 1.0D / paramArrayOfByte[paramInt1];
        d6 = ((Double)localArrayList1.get(paramInt1 + 1)).doubleValue() + d3 - d4 - d4;
        localArrayList2.add(Double.valueOf((d4 - d3 - d6) * d5));
        localArrayList3.add(Double.valueOf(d6 * d5 * d5));
        paramInt1 += 1;
      }
      paramInt1 = 0;
      if (paramInt1 <= 255)
      {
        if (paramInt1 == 0) {
          this.brightnessAdjustmentCurve[0] = 0;
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          if (paramInt1 == 255)
          {
            this.brightnessAdjustmentCurve['ÿ'] = 255;
          }
          else
          {
            d3 = getInterpolateValue(paramInt1, new double[] { 0.0D, 128.0D, 192.0D, 255.0D }, new double[] { 0.0D, d1, 192.0D + d2, 255.0D }, localArrayList1, localArrayList2, localArrayList3);
            this.brightnessAdjustmentCurve[paramInt1] = ((int)d3);
          }
        }
      }
    }
    AppMethodBeat.o(83763);
  }
  
  private Pair<Integer, int[]> getHistogram(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83768);
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    Object localObject = this.mFaceDetector.getAllFaces();
    Rect localRect = new Rect();
    if ((localObject == null) || (((List)localObject).size() <= 0) || (((List)((List)localObject).get(0)).size() <= 0))
    {
      localRect.left = 0;
      localRect.right = paramInt1;
      localRect.top = 0;
      localRect.bottom = paramInt2;
      i = 0;
    }
    for (;;)
    {
      if (i >= paramInt1) {
        break label423;
      }
      j = 0;
      label108:
      if (j < paramInt2)
      {
        int n = (j * paramInt1 + i) * 4;
        int k;
        if ((n >= 0) && (n + 2 < paramArrayOfByte.length))
        {
          k = paramArrayOfByte[n];
          m = paramArrayOfByte[(n + 1)];
          n = paramArrayOfByte[(n + 2)];
          double d1 = k & 0xFF;
          double d2 = m & 0xFF;
          k = (int)((n & 0xFF) * 0.11D + (d1 * 0.3D + d2 * 0.59D));
          if (k < 256) {
            break label407;
          }
        }
        for (int m = 255;; m = k)
        {
          arrayOfInt2[m] += 1;
          if (localRect.contains(i, j))
          {
            m = k;
            if (k >= 256) {
              m = 255;
            }
            arrayOfInt1[m] += 1;
          }
          j += 1;
          break label108;
          localObject = new ArrayList((Collection)((List)localObject).get(0));
          i = (int)((PointF)((List)localObject).get(25)).x;
          j = (int)((PointF)((List)localObject).get(33)).x;
          k = (int)((PointF)((List)localObject).get(87)).y;
          m = (int)((PointF)((List)localObject).get(4)).y;
          localRect.left = i;
          localRect.right = j;
          localRect.top = k;
          localRect.bottom = m;
          break;
        }
      }
      label407:
      i += 1;
    }
    label423:
    paramInt2 = 0;
    paramInt1 = 0;
    int j = 255;
    int i = 0;
    while (i < 256)
    {
      paramInt2 += arrayOfInt1[i];
      paramInt1 += arrayOfInt1[i] * i;
      i += 1;
    }
    i = j;
    if (paramInt2 > 0) {
      i = paramInt1 / paramInt2;
    }
    paramArrayOfByte = Pair.create(Integer.valueOf(i), arrayOfInt2);
    AppMethodBeat.o(83768);
    return paramArrayOfByte;
  }
  
  private double getInterpolateValue(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, List<Double> paramList1, List<Double> paramList2, List<Double> paramList3)
  {
    AppMethodBeat.i(83767);
    int i = paramArrayOfDouble1.length - 1;
    if (paramDouble == paramArrayOfDouble1[i])
    {
      paramDouble = paramArrayOfDouble2[i];
      AppMethodBeat.o(83767);
      return paramDouble;
    }
    i = 0;
    int j = paramList3.size() - 1;
    while (i <= j)
    {
      int k = (int)Math.floor(0.5D * (i + j));
      d1 = paramArrayOfDouble1[k];
      if (d1 < paramDouble)
      {
        i = k + 1;
      }
      else if (d1 > paramDouble)
      {
        j = k - 1;
      }
      else
      {
        paramDouble = paramArrayOfDouble2[k];
        AppMethodBeat.o(83767);
        return paramDouble;
      }
    }
    i = Math.max(0, j);
    paramDouble -= paramArrayOfDouble1[i];
    double d1 = paramDouble * paramDouble;
    double d2 = paramArrayOfDouble2[i];
    double d3 = ((Double)paramList1.get(i)).doubleValue();
    double d4 = ((Double)paramList2.get(i)).doubleValue();
    double d5 = ((Double)paramList3.get(i)).doubleValue();
    AppMethodBeat.o(83767);
    return d5 * paramDouble * d1 + (d2 + d3 * paramDouble + d4 * d1);
  }
  
  private double[] sRGB2XYZ(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(83765);
    double d3 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[1];
    double d1 = paramArrayOfDouble[2];
    double d4 = d3 / 255.0D;
    d2 /= 255.0D;
    d3 = d1 / 255.0D;
    if (d4 <= 0.04045D)
    {
      d1 = d4 / 12.92D;
      if (d2 > 0.04045D) {
        break label189;
      }
      d2 /= 12.92D;
      label76:
      if (d3 > 0.04045D) {
        break label210;
      }
    }
    label189:
    label210:
    for (d3 /= 12.92D;; d3 = Math.pow((0.055D + d3) / 1.055D, 2.4D))
    {
      AppMethodBeat.o(83765);
      return new double[] { 41.240000000000002D * d1 + 35.759999999999998D * d2 + 18.050000000000001D * d3, 21.260000000000002D * d1 + 71.519999999999996D * d2 + 7.2D * d3, d3 * 95.049999999999997D + (d2 * 11.92D + d1 * 1.93D) };
      d1 = Math.pow((d4 + 0.055D) / 1.055D, 2.4D);
      break;
      d2 = Math.pow((0.055D + d2) / 1.055D, 2.4D);
      break label76;
    }
  }
  
  private void setBodyResult(List<BodyDetectResult> paramList)
  {
    AppMethodBeat.i(83757);
    synchronized (this.mBodyDetLock)
    {
      this.mBodyDetectResults = paramList;
      this.mBodyDetLock.notifyAll();
      AppMethodBeat.o(83757);
      return;
    }
  }
  
  private void switchBrightnessAdjustment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83762);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(83762);
      return;
    }
    if ((this.brightnessAdjustmentData == null) || (this.brightnessAdjustmentData.length != paramArrayOfByte.length)) {
      this.brightnessAdjustmentData = new byte[paramArrayOfByte.length];
    }
    System.arraycopy(paramArrayOfByte, 0, this.brightnessAdjustmentData, 0, paramArrayOfByte.length);
    if ((this.SINGLE_THREAD_EXECUTOR.isShutdown()) || (this.SINGLE_THREAD_EXECUTOR.isTerminated()))
    {
      AppMethodBeat.o(83762);
      return;
    }
    this.SINGLE_THREAD_EXECUTOR.execute(new FaceGestureDetGLThread.8(this, paramInt1, paramInt2));
    AppMethodBeat.o(83762);
  }
  
  private void switchDenoise(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.his == null) {
      this.his = new int[256];
    }
    for (;;)
    {
      j = paramArrayOfByte.length;
      i = 0;
      while (i < j)
      {
        if (i + 2 < j)
        {
          m = paramArrayOfByte[i];
          int n = paramArrayOfByte[(i + 1)];
          int i1 = paramArrayOfByte[(i + 2)];
          float f1 = m & 0xFF;
          float f2 = n & 0xFF;
          float f3 = i1 & 0xFF;
          int[] arrayOfInt = this.his;
          m = (int)(f1 * 0.3F + f2 * 0.6F + 0.1F * f3);
          arrayOfInt[m] += 1;
        }
        i += 4;
      }
      i = 0;
      while (i < 256)
      {
        this.his[i] = 0;
        i += 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < 256)
    {
      j += this.his[i];
      i += 1;
    }
    int m = (int)(j * 0.03F);
    i = 255;
    j = k;
    while (i >= 0)
    {
      j += this.his[i];
      if (j >= m) {
        break;
      }
      i -= 1;
    }
    this.curLevel = i;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(83759);
    if (this.mHandler != null) {
      this.mHandler.post(new FaceGestureDetGLThread.6(this));
    }
    this.SINGLE_THREAD_EXECUTOR.shutdownNow();
    AppMethodBeat.o(83759);
  }
  
  public VideoPreviewFaceOutlineDetector getDetector()
  {
    return this.mFaceDetector;
  }
  
  public Handler getHandler()
  {
    return this.mHandler;
  }
  
  public String getHistogramInfo()
  {
    AppMethodBeat.i(83764);
    if (this.his == null)
    {
      AppMethodBeat.o(83764);
      return "";
    }
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("hisLevel: " + this.curLevel + "\n");
    ((StringBuffer)localObject).append("averageL: " + (int)this.averageFaceL + "\n");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(83764);
    return localObject;
  }
  
  public boolean isInitReady()
  {
    return this.mInitReady;
  }
  
  public boolean needWait()
  {
    AppMethodBeat.i(83760);
    if (this.sharedData == null)
    {
      AppMethodBeat.o(83760);
      return true;
    }
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.sharedData.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    while (i < j)
    {
      SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[i];
      if ((localSegmentDataPipe.isBusy()) || (localSegmentDataPipe.isReady()))
      {
        AppMethodBeat.o(83760);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(83760);
    return false;
  }
  
  public void postFaceDetectorDestroy()
  {
    AppMethodBeat.i(83756);
    if (this.mHandler == null)
    {
      AppMethodBeat.o(83756);
      return;
    }
    this.mHandler.post(new FaceGestureDetGLThread.4(this));
    AppMethodBeat.o(83756);
  }
  
  public void postFaceGestureDet(h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, double paramDouble)
  {
    AppMethodBeat.i(83754);
    postFaceGestureDet(paramh, paramBoolean1, paramBoolean2, paramBoolean3, paramDouble, false);
    AppMethodBeat.o(83754);
  }
  
  public void postFaceGestureDet(h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, double paramDouble, boolean paramBoolean4)
  {
    AppMethodBeat.i(83755);
    if (this.mHandler == null)
    {
      AppMethodBeat.o(83755);
      return;
    }
    this.mHandler.post(new FaceGestureDetGLThread.3(this, paramh, paramDouble, paramBoolean1, paramBoolean4, paramBoolean2, paramBoolean3));
    AppMethodBeat.o(83755);
  }
  
  public void postUpdateParams(VideoFilterList paramVideoFilterList)
  {
    AppMethodBeat.i(83761);
    if (this.mHandler == null)
    {
      AppMethodBeat.o(83761);
      return;
    }
    this.mHandler.post(new FaceGestureDetGLThread.7(this));
    AppMethodBeat.o(83761);
  }
  
  public void resetBodyDetector()
  {
    AppMethodBeat.i(83758);
    if (this.mHandler != null) {
      this.mHandler.post(new FaceGestureDetGLThread.5(this));
    }
    AppMethodBeat.o(83758);
  }
  
  public void setOnFaceDetListener(FaceGestureDetGLThread.OnFaceDetListener paramOnFaceDetListener)
  {
    this.mListener = paramOnFaceDetListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread
 * JD-Core Version:    0.7.0.1
 */