package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.fbn;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorData;", "dataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setDataType", "enableTimeEdit", "", "getEnableTimeEdit", "()Z", "setEnableTimeEdit", "(Z)V", "<set-?>", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "modTimeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getModTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "setModTimeRange", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "timeRange", "getTimeRange", "getTimeRangeProto", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "matrixToProto", "Lcom/tencent/mm/protocal/protobuf/ViewMatrix;", "protoToMatrix", "", "viewMatrix", "setTimeRange", "", "range", "setTimeRangeProto", "showAtObjectId", "objID", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract class a
  implements i
{
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d Ibq;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d Ibr;
  public boolean Ibs;
  public d Ibt;
  public Matrix aHZ;
  public String objectId;
  
  public a(d paramd)
  {
    this.Ibt = paramd;
    this.Ibr = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(2147483647L, false, 2);
    this.Ibs = true;
    this.aHZ = new Matrix();
  }
  
  protected static float[] a(fbn paramfbn)
  {
    p.k(paramfbn, "viewMatrix");
    float[] arrayOfFloat = new float[9];
    int i = 0;
    paramfbn = paramfbn.SWx;
    p.j(paramfbn, "viewMatrix.value");
    paramfbn = ((Iterable)paramfbn).iterator();
    while (paramfbn.hasNext())
    {
      Float localFloat = (Float)paramfbn.next();
      p.j(localFloat, "data");
      arrayOfFloat[i] = localFloat.floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  protected static fbn f(Matrix paramMatrix)
  {
    p.k(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    fbn localfbn = new fbn();
    paramMatrix.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localfbn.SWx.add(Float.valueOf(f));
      i += 1;
    }
    return localfbn;
  }
  
  public final boolean PA(long paramLong)
  {
    return (paramLong >= this.Ibr.Ido.getTime()) && (paramLong <= this.Ibr.Idp.getTime());
  }
  
  protected final void a(ajc paramajc)
  {
    if (paramajc != null) {
      this.Ibr.ar(paramajc.start, paramajc.aYz);
    }
  }
  
  public final boolean aWf(String paramString)
  {
    p.k(paramString, "objID");
    return p.h(paramString, this.objectId);
  }
  
  public final void b(d paramd)
  {
    p.k(paramd, "<set-?>");
    this.Ibt = paramd;
  }
  
  protected final ajc fyE()
  {
    ajc localajc = new ajc();
    localajc.start = this.Ibr.Ido.getTime();
    localajc.aYz = this.Ibr.Idp.getTime();
    return localajc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */