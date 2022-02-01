package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.fxy;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorData;", "dataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setDataType", "enableTimeEdit", "", "getEnableTimeEdit", "()Z", "setEnableTimeEdit", "(Z)V", "<set-?>", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "modTimeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getModTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "setModTimeRange", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "timeRange", "getTimeRange", "getTimeRangeProto", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "matrixToProto", "Lcom/tencent/mm/protocal/protobuf/ViewMatrix;", "protoToMatrix", "", "viewMatrix", "setTimeRange", "", "range", "setTimeRangeProto", "showAtObjectId", "objID", "showAtTime", "currentMs", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements i
{
  public d NXP;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d NXQ;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d NXR;
  public boolean NXS;
  public Matrix matrix;
  public String objectId;
  
  public a(d paramd)
  {
    this.NXP = paramd;
    this.NXR = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(2147483647L, false, 2);
    this.NXS = true;
    this.matrix = new Matrix();
  }
  
  protected static float[] a(fxy paramfxy)
  {
    s.u(paramfxy, "viewMatrix");
    float[] arrayOfFloat = new float[9];
    int i = 0;
    paramfxy = paramfxy.aaib;
    s.s(paramfxy, "viewMatrix.value");
    paramfxy = ((Iterable)paramfxy).iterator();
    while (paramfxy.hasNext())
    {
      Float localFloat = (Float)paramfxy.next();
      s.s(localFloat, "data");
      arrayOfFloat[i] = localFloat.floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  protected static fxy h(Matrix paramMatrix)
  {
    s.u(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    fxy localfxy = new fxy();
    paramMatrix.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localfxy.aaib.add(Float.valueOf(f));
      i += 1;
    }
    return localfxy;
  }
  
  protected final void a(amh paramamh)
  {
    if (paramamh != null) {
      this.NXR.bb(paramamh.start, paramamh.axI);
    }
  }
  
  public final boolean aTn(String paramString)
  {
    s.u(paramString, "objID");
    return s.p(paramString, this.objectId);
  }
  
  public final void b(d paramd)
  {
    s.u(paramd, "<set-?>");
    this.NXP = paramd;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d gKp()
  {
    return this.NXR;
  }
  
  protected final amh gKq()
  {
    amh localamh = new amh();
    localamh.start = this.NXR.NZL.getTime();
    localamh.axI = this.NXR.NZM.getTime();
    return localamh;
  }
  
  public final boolean tA(long paramLong)
  {
    return (paramLong >= this.NXR.NZL.getTime()) && (paramLong <= this.NXR.NZM.getTime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */