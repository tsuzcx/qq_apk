package com.tencent.mm.xeffect;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/FaceTracker;", "", "modelRoot", "", "(Ljava/lang/String;)V", "nPtr", "", "getNPtr", "()J", "setNPtr", "(J)V", "destroy", "", "detect", "", "data", "Ljava/nio/Buffer;", "width", "height", "getAlignments", "", "", "Landroid/graphics/PointF;", "getFaceAngles", "Lcom/tencent/mm/xeffect/FacePosAngle;", "getFacePartConf", "", "getFaceRect", "Landroid/graphics/RectF;", "getFaceRects", "getPoints", "()[Landroid/graphics/PointF;", "nDestroy", "nDetect", "nGetAlignments", "nGetFaceAngles", "nGetFacePartConf", "nGetFaceRect", "nGetFaceRects", "nInit", "Companion", "renderlib_release"})
public final class FaceTracker
{
  public static final a YYD;
  public long NmO;
  
  static
  {
    AppMethodBeat.i(195610);
    YYD = new a((byte)0);
    e.load("xlabeffect");
    AppMethodBeat.o(195610);
  }
  
  public FaceTracker(String paramString)
  {
    AppMethodBeat.i(195607);
    this.NmO = nInit(paramString);
    AppMethodBeat.o(195607);
  }
  
  private final native float[] nGetAlignments(long paramLong);
  
  private final native float[] nGetFaceAngles(long paramLong);
  
  private final native float[] nGetFacePartConf(long paramLong);
  
  private final native float[] nGetFaceRect(long paramLong);
  
  private final native float[] nGetFaceRects(long paramLong);
  
  private final native long nInit(String paramString);
  
  public final List<a> ijS()
  {
    int i = 0;
    AppMethodBeat.i(195587);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetFaceAngles(this.NmO);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(195587);
      return localObject;
    }
    int j = arrayOfFloat.length;
    if (j % 3 != 0) {
      XEffectLog.w("FaceTracker", "angles data size not match ".concat(String.valueOf(j)), new Object[0]);
    }
    j /= 3;
    while (i < j)
    {
      ((ArrayList)localObject).add(new a(arrayOfFloat[(i * 3)], arrayOfFloat[(i * 3 + 1)], arrayOfFloat[(i * 3 + 2)]));
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(195587);
    return localObject;
  }
  
  public final List<RectF> ijT()
  {
    int i = 0;
    AppMethodBeat.i(195593);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetFaceRects(this.NmO);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(195593);
      return localObject;
    }
    int j = arrayOfFloat.length;
    if (j % 4 != 0) {
      XEffectLog.w("FaceTracker", "rects data size not match ".concat(String.valueOf(j)), new Object[0]);
    }
    j /= 4;
    while (i < j)
    {
      float f1 = arrayOfFloat[(i * 4)];
      float f2 = arrayOfFloat[(i * 4 + 1)];
      ((ArrayList)localObject).add(new RectF(f1, f2, arrayOfFloat[(i * 4 + 2)] + f1, arrayOfFloat[(i * 4 + 3)] + f2));
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(195593);
    return localObject;
  }
  
  public final List<PointF[]> ijU()
  {
    AppMethodBeat.i(195595);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetAlignments(this.NmO);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(195595);
      return localObject;
    }
    int i = arrayOfFloat.length;
    if (i < 2) {
      XEffectLog.w("FaceTracker", "alignments data no face count", new Object[0]);
    }
    int k = (int)arrayOfFloat[0];
    int m = (int)arrayOfFloat[1];
    if (i != k * m * 2 + 2) {
      XEffectLog.w("FaceTracker", "alignments data size error, face:" + k + ", point:" + m + ", float:" + i, new Object[0]);
    }
    i = 0;
    while (i < k)
    {
      PointF[] arrayOfPointF = new PointF[m];
      int j = 0;
      while (j < m)
      {
        arrayOfPointF[j] = new PointF();
        j += 1;
      }
      j = 0;
      while (j < m)
      {
        arrayOfPointF[j] = new PointF();
        arrayOfPointF[j].x = arrayOfFloat[(i * k + j * 2 + 2)];
        arrayOfPointF[j].y = arrayOfFloat[(i * k + j * 2 + 3)];
        j += 1;
      }
      ((ArrayList)localObject).add(arrayOfPointF);
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(195595);
    return localObject;
  }
  
  public final List<float[]> ijV()
  {
    int i = 0;
    AppMethodBeat.i(195600);
    Object localObject = new ArrayList();
    float[] arrayOfFloat1 = nGetFacePartConf(this.NmO);
    if (arrayOfFloat1 == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(195600);
      return localObject;
    }
    int m = arrayOfFloat1.length;
    if (m < 2)
    {
      XEffectLog.w("FaceTracker", "part conf data no face count", new Object[0]);
      localObject = (List)localObject;
      AppMethodBeat.o(195600);
      return localObject;
    }
    int j = (int)arrayOfFloat1[0];
    int k = (int)arrayOfFloat1[1];
    if (m != j * k + 2)
    {
      XEffectLog.w("FaceTracker", "part conf data size error, face:" + j + ", conf:" + k + ", float:" + m, new Object[0]);
      localObject = (List)localObject;
      AppMethodBeat.o(195600);
      return localObject;
    }
    while (i < j)
    {
      m = i * j + 2 + k;
      p.k(arrayOfFloat1, "$this$copyOfRangeImpl");
      kotlin.a.e.oq(m, arrayOfFloat1.length);
      float[] arrayOfFloat2 = Arrays.copyOfRange(arrayOfFloat1, i * j + 2, m);
      p.j(arrayOfFloat2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
      ((ArrayList)localObject).add(arrayOfFloat2);
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(195600);
    return localObject;
  }
  
  public final native void nDestroy(long paramLong);
  
  public final native int nDetect(long paramLong, Buffer paramBuffer, int paramInt1, int paramInt2);
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/FaceTracker$Companion;", "", "()V", "TAG", "", "renderlib_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.FaceTracker
 * JD-Core Version:    0.7.0.1
 */