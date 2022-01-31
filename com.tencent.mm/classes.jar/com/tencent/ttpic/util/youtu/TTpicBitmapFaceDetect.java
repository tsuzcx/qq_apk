package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.faceBeauty.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import java.util.List;

public class TTpicBitmapFaceDetect
  extends b
{
  private volatile boolean inited;
  private long mNativeObjPtr;
  
  public TTpicBitmapFaceDetect()
  {
    AppMethodBeat.i(84365);
    if (YTFaceDetectorBase.getInstance().initFaceTrack() != 0)
    {
      this.inited = false;
      AppMethodBeat.o(84365);
      return;
    }
    if (YTFaceDetectorBase.getInstance().initPicFaceDetect() != 0)
    {
      this.inited = false;
      AppMethodBeat.o(84365);
      return;
    }
    nativeConstructor();
    this.inited = true;
    AppMethodBeat.o(84365);
  }
  
  private void detectParam(Bitmap paramBitmap, boolean paramBoolean, Rect paramRect, Point paramPoint1, Point paramPoint2)
  {
    AppMethodBeat.i(84367);
    this.mDetectedFace = false;
    this.mFaceParams.clear();
    this.faceCount = 0;
    if ((!this.inited) || (!BitmapUtils.isLegal(paramBitmap)))
    {
      AppMethodBeat.o(84367);
      return;
    }
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    int i;
    if (m > n)
    {
      i = m;
      i /= 512;
      if (i > 0) {
        break label1049;
      }
      i = 1;
    }
    label1029:
    label1038:
    label1049:
    for (;;)
    {
      Bitmap localBitmap;
      int j;
      try
      {
        localBitmap = Bitmap.createBitmap(m / i, n / i, Bitmap.Config.ARGB_8888);
        new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect(0, 0, m, n), new Rect(0, 0, m / i, n / i), null);
        if (!paramBoolean) {
          break label1018;
        }
        if (paramRect == null)
        {
          paramBitmap = nativeDetectBitmapByEyes(localBitmap, paramPoint1.x / i, paramPoint1.y / i, paramPoint2.x / i, paramPoint2.y / i);
          this.faceCount = size(paramBitmap);
          j = 0;
          if (j >= this.faceCount) {
            break label1038;
          }
          paramPoint1 = paramBitmap[j];
          this.mDetectedFace = true;
          paramRect = new FaceParam();
          paramPoint2 = new Rect();
          paramRect.bsP = paramPoint2;
          paramPoint2.left = (paramPoint1.x * i);
          paramPoint2.top = (paramPoint1.y * i);
          paramPoint2.right = (paramPoint1.x * i + paramPoint1.w * i);
          paramPoint2.bottom = (paramPoint1.y * i + paramPoint1.h * i);
          if (paramPoint2.left < 0) {
            paramPoint2.left = 0;
          }
          if (paramPoint2.top < 0) {
            paramPoint2.top = 0;
          }
          if (paramPoint2.right > m) {
            paramPoint2.right = m;
          }
          if (paramPoint2.bottom > n) {
            paramPoint2.bottom = n;
          }
          int k = (int)(paramPoint1.h * i * 0.16D);
          int i1 = (int)(k * 2.0D);
          paramPoint2 = new Rect();
          paramRect.bsQ = paramPoint2;
          paramPoint2.left = (paramPoint1.leftEyeX * i - i1 / 2);
          paramPoint2.right = (paramPoint2.left + i1);
          paramPoint2.top = (paramPoint1.leftEyeY * i - k / 2);
          paramPoint2.bottom = (paramPoint2.top + k);
          paramRect.bsS = new Point(paramPoint1.leftEyeX * i, paramPoint1.leftEyeY * i);
          Rect localRect1 = new Rect();
          paramRect.bsR = localRect1;
          localRect1.left = (paramPoint1.rightEyeX * i - i1 / 2);
          localRect1.right = (i1 + localRect1.left);
          localRect1.top = (paramPoint1.rightEyeY * i - k / 2);
          localRect1.bottom = (k + localRect1.top);
          paramRect.bsT = new Point(paramPoint1.rightEyeX * i, paramPoint1.rightEyeY * i);
          Rect localRect2 = new Rect();
          paramRect.bsU = localRect2;
          localRect2.left = paramPoint2.left;
          localRect2.top = paramPoint2.top;
          localRect2.right = localRect1.right;
          localRect2.bottom = localRect1.bottom;
          if (localRect2.left < 0) {
            localRect2.left = 0;
          }
          if (localRect2.top < 0) {
            localRect2.top = 0;
          }
          if (localRect2.right > m) {
            localRect2.right = m;
          }
          if (localRect2.bottom > n) {
            localRect2.bottom = n;
          }
          k = (int)(paramPoint1.w * i * 0.4D);
          i1 = (int)(paramPoint1.h * i * 0.16D);
          paramPoint2 = new Rect();
          paramRect.bsV = paramPoint2;
          paramPoint2.left = (paramPoint1.mouthX * i - k / 2);
          paramPoint2.top = (paramPoint1.mouthY * i - i1 / 2);
          paramPoint2.right = (paramPoint2.left + k);
          paramPoint2.bottom = (paramPoint2.top + i1);
          paramRect.width = m;
          paramRect.height = n;
          this.mFaceParams.add(paramRect);
          if (this.mGetFaceGender) {
            this.mFemale.add(Boolean.TRUE);
          }
          if (!this.mGetFaceFeatures) {
            break label1029;
          }
          paramPoint1 = nativeGetFeatures(j);
          paramRect.bsW = paramPoint1;
          i1 = size(paramPoint1);
          k = 0;
          if (k >= i1) {
            break label1029;
          }
          paramPoint1[k][0] *= i;
          paramPoint1[k][1] *= i;
          k += 1;
          continue;
          i = n;
        }
      }
      catch (OutOfMemoryError paramBitmap)
      {
        AppMethodBeat.o(84367);
        return;
      }
      paramBitmap = nativeDetectBitmapByFace(localBitmap, paramRect.left / i, paramRect.top / i, paramRect.width() / i, paramRect.height() / i);
      continue;
      label1018:
      paramBitmap = nativeDetectBitmap(localBitmap, false);
      continue;
      j += 1;
      continue;
      localBitmap.recycle();
      AppMethodBeat.o(84367);
      return;
    }
  }
  
  private native boolean nativeConstructor();
  
  private native void nativeDestructor();
  
  private native TTImageFeature[] nativeDetectBitmap(Bitmap paramBitmap, boolean paramBoolean);
  
  private native TTImageFeature[] nativeDetectBitmapByEyes(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native TTImageFeature[] nativeDetectBitmapByFace(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native float[] nativeGetAngles(int paramInt);
  
  private native int[][] nativeGetFeatures(int paramInt);
  
  private native int[][] nativeGetShapePoints(int paramInt);
  
  private native int nativeInit(String paramString);
  
  public void destroy()
  {
    AppMethodBeat.i(84366);
    if (this.inited)
    {
      nativeDestructor();
      this.inited = false;
    }
    AppMethodBeat.o(84366);
  }
  
  public void detectFaceByManual(Bitmap paramBitmap, Point paramPoint1, Point paramPoint2)
  {
    AppMethodBeat.i(84369);
    detectParam(paramBitmap, true, null, paramPoint1, paramPoint2);
    AppMethodBeat.o(84369);
  }
  
  public void detectFaceByManual(Bitmap paramBitmap, Rect paramRect, Point paramPoint1, Point paramPoint2)
  {
    AppMethodBeat.i(84370);
    detectParam(paramBitmap, true, paramRect, paramPoint1, paramPoint2);
    AppMethodBeat.o(84370);
  }
  
  public void doDetectFace(Bitmap paramBitmap)
  {
    AppMethodBeat.i(84368);
    detectParam(paramBitmap, false, null, null, null);
    AppMethodBeat.o(84368);
  }
  
  public void doInitial() {}
  
  public void doRelease() {}
  
  public float[] getFaceAngles(int paramInt)
  {
    AppMethodBeat.i(84371);
    float[] arrayOfFloat = nativeGetAngles(paramInt);
    paramInt = 0;
    while (paramInt < arrayOfFloat.length)
    {
      arrayOfFloat[paramInt] = ((float)(arrayOfFloat[paramInt] * 3.141592653589793D / 180.0D));
      paramInt += 1;
    }
    AppMethodBeat.o(84371);
    return arrayOfFloat;
  }
  
  public int size(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    return paramArrayOfObject.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.TTpicBitmapFaceDetect
 * JD-Core Version:    0.7.0.1
 */