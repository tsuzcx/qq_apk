package com.tencent.ttpic.util;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.FILL_STYLE;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.SizeI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AlgoUtils
{
  private static final Random mRandom;
  
  static
  {
    AppMethodBeat.i(50255);
    mRandom = new Random(System.currentTimeMillis());
    AppMethodBeat.o(50255);
  }
  
  public static native void RGBA2YUV420SP(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void RGBA2YUV420SP3(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static native void YUVNV21TORGBA(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2);
  
  public static native void YUVX2YUV(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2);
  
  public static float[] adjustPosition(float[] paramArrayOfFloat, float paramFloat)
  {
    int i = 0;
    float f1 = (paramArrayOfFloat[0] + paramArrayOfFloat[4]) / 2.0F;
    float f2 = (paramArrayOfFloat[1] + paramArrayOfFloat[3]) / 2.0F;
    while (i < paramArrayOfFloat.length / 2)
    {
      paramArrayOfFloat[(i * 2)] = ((paramArrayOfFloat[(i * 2)] - f1) * paramFloat + f1);
      paramArrayOfFloat[(i * 2 + 1)] = ((paramArrayOfFloat[(i * 2 + 1)] - f2) * paramFloat + f2);
      i += 1;
    }
    return paramArrayOfFloat;
  }
  
  public static float[] adjustPosition(float[] paramArrayOfFloat, float paramFloat, double[] paramArrayOfDouble, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    float f1 = paramArrayOfFloat[0] + (paramArrayOfFloat[4] - paramArrayOfFloat[0]) * (float)paramArrayOfDouble[0];
    float f2 = paramArrayOfFloat[3] + (paramArrayOfFloat[1] - paramArrayOfFloat[3]) * (float)paramArrayOfDouble[1];
    if (paramInt == 0)
    {
      paramInt = i;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 1)
    {
      paramInt = j;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      paramInt = k;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramInt += 1;
      }
    }
    return paramArrayOfFloat;
  }
  
  public static float[] adjustPositionTriangles(float[] paramArrayOfFloat, float paramFloat, double[] paramArrayOfDouble, int paramInt)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    float f1 = paramArrayOfFloat[0] + (paramArrayOfFloat[10] - paramArrayOfFloat[0]) * (float)paramArrayOfDouble[0];
    float f2 = paramArrayOfFloat[1] + (paramArrayOfFloat[3] - paramArrayOfFloat[1]) * (float)paramArrayOfDouble[1];
    if (paramInt == 0)
    {
      paramInt = i;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 1)
    {
      paramInt = j;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2 + 1)] = ((paramArrayOfFloat[(paramInt * 2 + 1)] - f2) * paramFloat + f2);
        paramInt += 1;
      }
    }
    if (paramInt == 2)
    {
      paramInt = k;
      while (paramInt < paramArrayOfFloat.length / 2)
      {
        paramArrayOfFloat[(paramInt * 2)] = ((paramArrayOfFloat[(paramInt * 2)] - f1) * paramFloat + f1);
        paramInt += 1;
      }
    }
    return paramArrayOfFloat;
  }
  
  private static SizeI calCutAspectSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(50239);
    double d4 = paramInt1 / paramInt2;
    double d2 = paramInt4;
    double d3 = (int)(d2 * d4);
    double d1 = d3;
    if (d3 < paramInt3)
    {
      d1 = paramInt3;
      d2 = d1 / d4;
    }
    SizeI localSizeI = new SizeI((int)d1, (int)d2);
    AppMethodBeat.o(50239);
    return localSizeI;
  }
  
  public static SizeI calCutSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(50241);
    if (paramInt1 / paramInt2 >= paramDouble)
    {
      localSizeI = new SizeI((int)(paramInt2 * paramDouble), paramInt2);
      AppMethodBeat.o(50241);
      return localSizeI;
    }
    SizeI localSizeI = new SizeI(paramInt1, (int)(paramInt1 / paramDouble));
    AppMethodBeat.o(50241);
    return localSizeI;
  }
  
  public static float[] calPositions(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat2, paramFloat3, paramFloat4 };
  }
  
  public static float[] calPositions(Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(50237);
    if (paramInt5 == FILL_STYLE.SPACE.value)
    {
      SizeI localSizeI = calSpaceAspectSize(paramInt1, paramInt2, paramRect.width, paramRect.height);
      paramInt1 = paramRect.x + (paramRect.width - localSizeI.width) / 2;
      paramInt2 = paramRect.y;
      paramInt2 = (paramRect.height - localSizeI.height) / 2 + paramInt2;
      paramInt5 = localSizeI.width;
      i = localSizeI.height;
      paramRect = calPositions(paramInt1, paramInt2 + i, paramInt5 + paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(50237);
      return paramRect;
    }
    paramInt1 = paramRect.x;
    paramInt2 = paramRect.y;
    paramInt5 = paramRect.width;
    int i = paramRect.height;
    paramRect = calPositions(paramInt1, i + paramInt2, paramInt1 + paramInt5, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(50237);
    return paramRect;
  }
  
  public static float[] calPositionsTriangles(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    paramFloat1 = paramFloat1 / paramInt1 * 2.0F - 1.0F;
    paramFloat2 = paramFloat2 / paramInt2 * 2.0F - 1.0F;
    paramFloat3 = paramFloat3 / paramInt1 * 2.0F - 1.0F;
    paramFloat4 = paramFloat4 / paramInt2 * 2.0F - 1.0F;
    return new float[] { paramFloat1, paramFloat2, paramFloat1, paramFloat4, paramFloat3, paramFloat4, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat3, paramFloat2 };
  }
  
  private static SizeI calSpaceAspectSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(50240);
    double d4 = paramInt1 / paramInt2;
    double d2 = paramInt4;
    double d3 = (int)(d2 * d4);
    double d1 = d3;
    if (d3 > paramInt3)
    {
      d1 = paramInt3;
      d2 = d1 / d4;
    }
    SizeI localSizeI = new SizeI((int)d1, (int)d2);
    AppMethodBeat.o(50240);
    return localSizeI;
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, double paramDouble)
  {
    int i;
    int j;
    int k;
    int m;
    if (paramInt1 / paramInt2 >= paramDouble)
    {
      i = (int)(paramInt2 * paramDouble);
      j = (paramInt1 - i) / 2;
      i += j;
      k = 0;
      m = paramInt2;
    }
    for (;;)
    {
      float f1 = j / paramInt1;
      float f2 = i / paramInt1;
      float f3 = m / paramInt2;
      float f4 = k / paramInt2;
      return new float[] { f1, f4, f1, f3, f2, f3, f2, f4 };
      i = (int)(paramInt1 / paramDouble);
      k = (paramInt2 - i) / 2;
      m = k + i;
      i = paramInt1;
      j = 0;
    }
  }
  
  public static float[] calTexCoords(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt3 == 90) || (paramInt3 == 270)) {}
    for (;;)
    {
      int k;
      int j;
      int i;
      if (paramInt2 / paramInt1 >= paramDouble)
      {
        paramInt3 = (int)(paramInt1 * paramDouble);
        k = (paramInt2 - paramInt3) / 2;
        j = k + paramInt3;
        paramInt3 = 0;
        i = paramInt1;
      }
      for (;;)
      {
        float f1 = k / paramInt2;
        float f2 = j / paramInt2;
        float f3 = i / paramInt1;
        float f4 = paramInt3 / paramInt1;
        return new float[] { f1, f4, f1, f3, f2, f3, f2, f4 };
        i = (int)(paramInt2 / paramDouble);
        paramInt3 = (paramInt1 - i) / 2;
        i += paramInt3;
        j = paramInt2;
        k = 0;
      }
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt3;
    }
  }
  
  public static float[] calTexCords(Rect paramRect, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50238);
    if ((paramInt3 == FILL_STYLE.CUT.value) || (paramInt3 == FILL_STYLE.FRAME_STYLE_CUT.value))
    {
      paramRect = calTexCoords(paramInt1, paramInt2, paramRect.width / paramRect.height);
      AppMethodBeat.o(50238);
      return paramRect;
    }
    paramRect = GlUtil.ORIGIN_TEX_COORDS;
    AppMethodBeat.o(50238);
    return paramRect;
  }
  
  public static float distanceOfPoint2Line(PointF paramPointF1, PointF paramPointF2, float paramFloat, PointF paramPointF3)
  {
    AppMethodBeat.i(50243);
    float f1 = getDistance(paramPointF1, paramPointF3);
    float f2 = getDistance(paramPointF2, paramPointF3);
    float f3 = (paramFloat + f1 + f2) / 2.0F;
    f1 = (f3 - f1) * ((f3 - paramFloat) * f3) * (f3 - f2);
    if (f1 < 1.0E-006D)
    {
      AppMethodBeat.o(50243);
      return 0.0F;
    }
    paramFloat = (float)Math.sqrt(f1) * 2.0F / paramFloat;
    AppMethodBeat.o(50243);
    return paramFloat;
  }
  
  public static PointF genVector(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(50250);
    paramPointF1 = new PointF(paramPointF2.x - paramPointF1.x, paramPointF2.y - paramPointF1.y);
    AppMethodBeat.o(50250);
    return paramPointF1;
  }
  
  public static float getDistance(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(50242);
    if ((paramPointF1 == null) || (paramPointF2 == null))
    {
      AppMethodBeat.o(50242);
      return 0.0F;
    }
    double d1 = paramPointF1.x - paramPointF2.x;
    double d2 = paramPointF1.y - paramPointF2.y;
    float f = (float)Math.sqrt(d1 * d1 + d2 * d2);
    AppMethodBeat.o(50242);
    return f;
  }
  
  public static RectF getFaceRectF(List<PointF> paramList)
  {
    AppMethodBeat.i(50254);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      float f1 = 1.4E-45F;
      float f2 = 3.4028235E+38F;
      float f3 = 1.4E-45F;
      float f4 = 3.4028235E+38F;
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
        f1 = Math.max(f1, localPointF.y);
      }
      paramList = new RectF(f4, f2, f3, f1);
      AppMethodBeat.o(50254);
      return paramList;
    }
    AppMethodBeat.o(50254);
    return null;
  }
  
  public static float[] linearRegression(List<PointF> paramList)
  {
    AppMethodBeat.i(50251);
    int i = 0;
    float f1 = 0.0F;
    float f2 = 0.0F;
    while (i < paramList.size())
    {
      f2 += ((PointF)paramList.get(i)).x;
      f1 += ((PointF)paramList.get(i)).y;
      i += 1;
    }
    float f3 = f2 / paramList.size();
    float f4 = f1 / paramList.size();
    i = 0;
    f1 = 0.0F;
    f2 = 0.0F;
    while (i < paramList.size())
    {
      float f5 = ((PointF)paramList.get(i)).x;
      f2 += (((PointF)paramList.get(i)).y - f4) * (f5 - f3);
      i += 1;
      f1 += (f5 - f3) * (f5 - f3);
    }
    f1 = f2 / f1;
    AppMethodBeat.o(50251);
    return new float[] { f1, f4 - f1 * f3 };
  }
  
  public static List<PointF> mapPoints(List<PointF> paramList, Matrix paramMatrix)
  {
    AppMethodBeat.i(50252);
    float[] arrayOfFloat1 = new float[2];
    float[] arrayOfFloat2 = new float[2];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      arrayOfFloat1[0] = localPointF.x;
      arrayOfFloat1[1] = localPointF.y;
      paramMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
      localPointF.x = arrayOfFloat2[0];
      localPointF.y = arrayOfFloat2[1];
    }
    AppMethodBeat.o(50252);
    return paramList;
  }
  
  public static PointF middlePoint(PointF paramPointF1, PointF paramPointF2)
  {
    AppMethodBeat.i(50244);
    if ((paramPointF1 == null) || (paramPointF2 == null))
    {
      paramPointF1 = new PointF();
      AppMethodBeat.o(50244);
      return paramPointF1;
    }
    paramPointF1 = new PointF((paramPointF1.x + paramPointF2.x) / 2.0F, (paramPointF1.y + paramPointF2.y) / 2.0F);
    AppMethodBeat.o(50244);
    return paramPointF1;
  }
  
  public static native void nativeRotatePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeScalePlane(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  public static int randValueDiff(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50253);
    if (paramInt2 <= 1)
    {
      AppMethodBeat.o(50253);
      return 1;
    }
    int i;
    do
    {
      i = mRandom.nextInt(paramInt2) + 1;
    } while (paramInt1 == i);
    AppMethodBeat.o(50253);
    return i;
  }
  
  public static List<float[]> rotateAngles(List<float[]> paramList, int paramInt)
  {
    AppMethodBeat.i(50249);
    if (paramList == null)
    {
      AppMethodBeat.o(50249);
      return null;
    }
    paramInt = (paramInt + 360) % 360;
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      float[] arrayOfFloat = (float[])paramList.next();
      if ((paramInt == 90) || (paramInt == 270)) {
        localArrayList.add(new float[] { -arrayOfFloat[1], -arrayOfFloat[0], (float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) });
      } else {
        localArrayList.add(new float[] { arrayOfFloat[0], arrayOfFloat[1], (float)(arrayOfFloat[2] + paramInt * 3.141592653589793D / 180.0D) });
      }
    }
    AppMethodBeat.o(50249);
    return localArrayList;
  }
  
  public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50246);
    if (paramList != null)
    {
      int j = 0;
      int i = paramInt3;
      paramInt3 = j;
      if (paramInt3 < paramList.size())
      {
        FaceStatus localFaceStatus = (FaceStatus)paramList.get(paramInt3);
        i = (i + 360) % 360;
        float f;
        label98:
        Matrix localMatrix;
        if (i == 90)
        {
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = (-localFaceStatus.yaw);
          localFaceStatus.yaw = f;
          localFaceStatus.roll += i;
          localMatrix = new Matrix();
          localMatrix.reset();
          localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
          localMatrix.postRotate(i, 0.0F, 0.0F);
          if ((i != 90) && (i != 270)) {
            break label321;
          }
          localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
        }
        for (;;)
        {
          float[] arrayOfFloat = new float[2];
          localMatrix.mapPoints(arrayOfFloat, new float[] { localFaceStatus.tx, localFaceStatus.ty });
          localFaceStatus.tx = arrayOfFloat[0];
          localFaceStatus.ty = arrayOfFloat[1];
          paramInt3 += 1;
          break;
          if (i == 180)
          {
            localFaceStatus.pitch = (-localFaceStatus.pitch);
            localFaceStatus.yaw = (-localFaceStatus.yaw);
            localFaceStatus.roll += i;
            break label98;
          }
          if (i != 270) {
            break label98;
          }
          f = localFaceStatus.pitch;
          localFaceStatus.pitch = localFaceStatus.yaw;
          localFaceStatus.yaw = (-f);
          localFaceStatus.roll += i;
          break label98;
          label321:
          localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
        }
      }
    }
    AppMethodBeat.o(50246);
    return paramList;
  }
  
  public static List<PointF> rotatePoints(List<PointF> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50248);
    if (paramList == null)
    {
      AppMethodBeat.o(50248);
      return null;
    }
    paramInt3 = (paramInt3 + 360) % 360;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-paramInt1 / 2.0F, -paramInt2 / 2.0F);
    localMatrix.postRotate(paramInt3, 0.0F, 0.0F);
    if ((paramInt3 == 90) || (paramInt3 == 270)) {
      localMatrix.postTranslate(paramInt2 / 2.0F, paramInt1 / 2.0F);
    }
    for (;;)
    {
      float[] arrayOfFloat1 = new float[2];
      float[] arrayOfFloat2 = new float[2];
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        PointF localPointF = (PointF)localIterator.next();
        arrayOfFloat1[0] = localPointF.x;
        arrayOfFloat1[1] = localPointF.y;
        localMatrix.mapPoints(arrayOfFloat2, arrayOfFloat1);
        localPointF.x = arrayOfFloat2[0];
        localPointF.y = arrayOfFloat2[1];
      }
      localMatrix.postTranslate(paramInt1 / 2.0F, paramInt2 / 2.0F);
    }
    AppMethodBeat.o(50248);
    return paramList;
  }
  
  public static List<List<PointF>> rotatePointsForList(List<List<PointF>> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(50247);
    if (paramList == null)
    {
      paramList = new ArrayList();
      AppMethodBeat.o(50247);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(rotatePoints((List)paramList.next(), paramInt1, paramInt2, paramInt3));
    }
    AppMethodBeat.o(50247);
    return localArrayList;
  }
  
  public static List<Float> substract(List<Float> paramList, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(50245);
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramArrayOfFloat == null))
    {
      AppMethodBeat.o(50245);
      return localArrayList;
    }
    int i = 0;
    while (i < Math.min(paramList.size(), paramArrayOfFloat.length))
    {
      localArrayList.add(Float.valueOf(((Float)paramList.get(i)).floatValue() - paramArrayOfFloat[i]));
      i += 1;
    }
    AppMethodBeat.o(50245);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.AlgoUtils
 * JD-Core Version:    0.7.0.1
 */