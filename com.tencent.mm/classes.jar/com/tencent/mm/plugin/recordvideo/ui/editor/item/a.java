package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.dww;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorData;", "dataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setDataType", "enableTimeEdit", "", "getEnableTimeEdit", "()Z", "setEnableTimeEdit", "(Z)V", "<set-?>", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "modTimeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getModTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "setModTimeRange", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "timeRange", "getTimeRange", "getTimeRangeProto", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "matrixToProto", "Lcom/tencent/mm/protocal/protobuf/ViewMatrix;", "protoToMatrix", "", "viewMatrix", "setTimeRange", "", "range", "setTimeRangeProto", "showAtObjectId", "objID", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract class a
  implements h
{
  public Matrix gR;
  public String objectId;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d yds;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d ydt;
  public boolean ydu;
  public d ydv;
  
  public a(d paramd)
  {
    this.ydv = paramd;
    this.ydt = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(2147483647L, false, 2);
    this.ydu = true;
    this.gR = new Matrix();
  }
  
  protected static float[] a(dww paramdww)
  {
    p.h(paramdww, "viewMatrix");
    float[] arrayOfFloat = new float[9];
    int i = 0;
    paramdww = paramdww.GKl;
    p.g(paramdww, "viewMatrix.value");
    paramdww = ((Iterable)paramdww).iterator();
    while (paramdww.hasNext())
    {
      Float localFloat = (Float)paramdww.next();
      p.g(localFloat, "data");
      arrayOfFloat[i] = localFloat.floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  protected static dww f(Matrix paramMatrix)
  {
    p.h(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    dww localdww = new dww();
    paramMatrix.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localdww.GKl.add(Float.valueOf(f));
      i += 1;
    }
    return localdww;
  }
  
  protected final void a(agg paramagg)
  {
    if (paramagg != null) {
      this.ydt.ae(paramagg.start, paramagg.bpc);
    }
  }
  
  public final boolean axd(String paramString)
  {
    p.h(paramString, "objID");
    return p.i(paramString, this.objectId);
  }
  
  public final void b(d paramd)
  {
    p.h(paramd, "<set-?>");
    this.ydv = paramd;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dLh()
  {
    return this.ydt;
  }
  
  protected final agg dLi()
  {
    agg localagg = new agg();
    localagg.start = this.ydt.yfy.getTime();
    localagg.bpc = this.ydt.yfz.getTime();
    return localagg;
  }
  
  public final boolean zi(long paramLong)
  {
    return (paramLong >= this.ydt.yfy.getTime()) && (paramLong <= this.ydt.yfz.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */