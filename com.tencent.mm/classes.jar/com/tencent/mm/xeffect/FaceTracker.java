package com.tencent.mm.xeffect;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.k;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/FaceTracker;", "", "modelMap", "", "", "(Ljava/util/Map;)V", "nPtr", "", "getNPtr", "()J", "setNPtr", "(J)V", "destroy", "", "detect", "", "data", "Ljava/nio/Buffer;", "width", "height", "getAlignments", "", "", "Landroid/graphics/PointF;", "getFaceAngles", "Lcom/tencent/mm/xeffect/FacePosAngle;", "getFacePartConf", "", "getFaceRect", "Landroid/graphics/RectF;", "getFaceRects", "getPoints", "()[Landroid/graphics/PointF;", "nDestroy", "nDetect", "nGetAlignments", "nGetFaceAngles", "nGetFacePartConf", "nGetFaceRect", "nGetFaceRects", "nInitWithMap", "([Ljava/lang/String;)J", "Companion", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class FaceTracker
{
  public static final FaceTracker.a agWO;
  public long nNg;
  
  static
  {
    AppMethodBeat.i(234544);
    agWO = new FaceTracker.a((byte)0);
    f.load("xlabeffect");
    AppMethodBeat.o(234544);
  }
  
  public FaceTracker(Map<String, String> paramMap)
  {
    AppMethodBeat.i(234539);
    d.a locala = d.agXC;
    this.nNg = nInitWithMap(d.a.cX(paramMap));
    AppMethodBeat.o(234539);
  }
  
  private final native float[] nGetAlignments(long paramLong);
  
  private final native float[] nGetFaceAngles(long paramLong);
  
  private final native float[] nGetFacePartConf(long paramLong);
  
  private final native float[] nGetFaceRect(long paramLong);
  
  private final native float[] nGetFaceRects(long paramLong);
  
  private final native long nInitWithMap(String[] paramArrayOfString);
  
  public final List<a> jQa()
  {
    int i = 0;
    AppMethodBeat.i(234552);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetFaceAngles(this.nNg);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(234552);
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
    AppMethodBeat.o(234552);
    return localObject;
  }
  
  public final List<RectF> jQb()
  {
    int i = 0;
    AppMethodBeat.i(234555);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetFaceRects(this.nNg);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(234555);
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
    AppMethodBeat.o(234555);
    return localObject;
  }
  
  public final List<PointF[]> jQc()
  {
    AppMethodBeat.i(234563);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetAlignments(this.nNg);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(234563);
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
    AppMethodBeat.o(234563);
    return localObject;
  }
  
  public final List<float[]> jQd()
  {
    int i = 0;
    AppMethodBeat.i(234571);
    Object localObject = new ArrayList();
    float[] arrayOfFloat = nGetFacePartConf(this.nNg);
    if (arrayOfFloat == null)
    {
      localObject = (List)localObject;
      AppMethodBeat.o(234571);
      return localObject;
    }
    int m = arrayOfFloat.length;
    if (m < 2)
    {
      XEffectLog.w("FaceTracker", "part conf data no face count", new Object[0]);
      localObject = (List)localObject;
      AppMethodBeat.o(234571);
      return localObject;
    }
    int j = (int)arrayOfFloat[0];
    int k = (int)arrayOfFloat[1];
    if (m != j * k + 2)
    {
      XEffectLog.w("FaceTracker", "part conf data size error, face:" + j + ", conf:" + k + ", float:" + m, new Object[0]);
      localObject = (List)localObject;
      AppMethodBeat.o(234571);
      return localObject;
    }
    while (i < j)
    {
      ((ArrayList)localObject).add(k.a(arrayOfFloat, i * j + 2, i * j + 2 + k));
      i += 1;
    }
    localObject = (List)localObject;
    AppMethodBeat.o(234571);
    return localObject;
  }
  
  public final native void nDestroy(long paramLong);
  
  public final native int nDetect(long paramLong, Buffer paramBuffer, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.FaceTracker
 * JD-Core Version:    0.7.0.1
 */