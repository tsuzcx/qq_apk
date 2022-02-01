package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.c;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.erc;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorData;", "dataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "getDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setDataType", "enableTimeEdit", "", "getEnableTimeEdit", "()Z", "setEnableTimeEdit", "(Z)V", "<set-?>", "Landroid/graphics/Matrix;", "matrix", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "modTimeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getModTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "setModTimeRange", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;)V", "objectId", "", "getObjectId", "()Ljava/lang/String;", "setObjectId", "(Ljava/lang/String;)V", "timeRange", "getTimeRange", "getTimeRangeProto", "Lcom/tencent/mm/protocal/protobuf/EditTimeRange;", "matrixToProto", "Lcom/tencent/mm/protocal/protobuf/ViewMatrix;", "protoToMatrix", "", "viewMatrix", "setTimeRange", "", "range", "setTimeRangeProto", "showAtObjectId", "objID", "showAtTime", "currentMs", "", "plugin-recordvideo_release"})
public abstract class a
  implements h
{
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d Ceu;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d Cev;
  public boolean Cew;
  public d Cex;
  public Matrix gT;
  public String objectId;
  
  public a(d paramd)
  {
    this.Cex = paramd;
    this.Cev = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d(2147483647L, false, 2);
    this.Cew = true;
    this.gT = new Matrix();
  }
  
  protected static float[] a(erc paramerc)
  {
    p.h(paramerc, "viewMatrix");
    float[] arrayOfFloat = new float[9];
    int i = 0;
    paramerc = paramerc.LOe;
    p.g(paramerc, "viewMatrix.value");
    paramerc = ((Iterable)paramerc).iterator();
    while (paramerc.hasNext())
    {
      Float localFloat = (Float)paramerc.next();
      p.g(localFloat, "data");
      arrayOfFloat[i] = localFloat.floatValue();
      i += 1;
    }
    return arrayOfFloat;
  }
  
  protected static erc f(Matrix paramMatrix)
  {
    p.h(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    erc localerc = new erc();
    paramMatrix.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localerc.LOe.add(Float.valueOf(f));
      i += 1;
    }
    return localerc;
  }
  
  public final boolean Ig(long paramLong)
  {
    return (paramLong >= this.Cev.Cgx.getTime()) && (paramLong <= this.Cev.Cgy.getTime());
  }
  
  protected final void a(ain paramain)
  {
    if (paramain != null) {
      this.Cev.ai(paramain.start, paramain.boX);
    }
  }
  
  public final boolean aLB(String paramString)
  {
    p.h(paramString, "objID");
    return p.j(paramString, this.objectId);
  }
  
  public final void b(d paramd)
  {
    p.h(paramd, "<set-?>");
    this.Cex = paramd;
  }
  
  protected final ain eMi()
  {
    ain localain = new ain();
    localain.start = this.Cev.Cgx.getTime();
    localain.boX = this.Cev.Cgy.getTime();
    return localain;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */