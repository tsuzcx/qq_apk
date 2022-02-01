package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.dwb;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorData;", "dataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setDataType", "enableTimeEdit", "", "getEnableTimeEdit", "()Z", "setEnableTimeEdit", "(Z)V", "<set-?>", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "modTimeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getModTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "setModTimeRange", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "timeRange", "getTimeRange", "getTimeRangeProto", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "matrixToProto", "Lcom/tencent/mm/protocal/protobuf/ViewMatrix;", "protoToMatrix", "", "viewMatrix", "setTimeRange", "", "range", "setTimeRangeProto", "showAtObjectId", "objID", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract class a
  implements h
{
  public Matrix gR;
  public String objectId;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d xNA;
  public boolean xNB;
  public d xNC;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d xNz;
  
  public a(d paramd)
  {
    this.xNC = paramd;
    this.xNA = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(2147483647L, false, 2);
    this.xNB = true;
    this.gR = new Matrix();
  }
  
  protected static float[] a(dwb paramdwb)
  {
    p.h(paramdwb, "viewMatrix");
    float[] arrayOfFloat = new float[9];
    int i = 0;
    paramdwb = paramdwb.GqN;
    p.g(paramdwb, "viewMatrix.value");
    paramdwb = ((Iterable)paramdwb).iterator();
    while (paramdwb.hasNext())
    {
      Float localFloat = (Float)paramdwb.next();
      p.g(localFloat, "data");
      arrayOfFloat[i] = localFloat.floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  protected static dwb f(Matrix paramMatrix)
  {
    p.h(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    dwb localdwb = new dwb();
    paramMatrix.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localdwb.GqN.add(Float.valueOf(f));
      i += 1;
    }
    return localdwb;
  }
  
  protected final void a(afx paramafx)
  {
    if (paramafx != null) {
      this.xNA.af(paramafx.start, paramafx.bpc);
    }
  }
  
  public final boolean avO(String paramString)
  {
    p.h(paramString, "objID");
    return p.i(paramString, this.objectId);
  }
  
  public final void b(d paramd)
  {
    p.h(paramd, "<set-?>");
    this.xNC = paramd;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d dHQ()
  {
    return this.xNA;
  }
  
  protected final afx dHR()
  {
    afx localafx = new afx();
    localafx.start = this.xNA.xPF.getTime();
    localafx.bpc = this.xNA.xPG.getTime();
    return localafx;
  }
  
  public final void qb(boolean paramBoolean)
  {
    this.xNB = paramBoolean;
  }
  
  public final boolean yJ(long paramLong)
  {
    return (paramLong >= this.xNA.xPF.getTime()) && (paramLong <= this.xNA.xPG.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */