package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.protocal.protobuf.fxy;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "pagPath", "", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "drawingRect", "Landroid/graphics/RectF;", "getDrawingRect", "()Landroid/graphics/RectF;", "effectId", "", "getEffectId", "()J", "setEffectId", "(J)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "getPagPath", "()Ljava/lang/String;", "rotate", "getRotate", "setRotate", "scale", "getScale", "setScale", "text", "getText", "setText", "(Ljava/lang/String;)V", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "width", "getWidth", "setWidth", "bringToFront", "", "delete", "getTTSInfo", "isValid", "", "setTTSInfo", "path", "durationMs", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "updateMatrix", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends a
  implements j
{
  public final String LWN;
  public long NZm;
  public final RectF NZn;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b NZo;
  public k NZp;
  public float aBi;
  public float centerX;
  public float centerY;
  public int height;
  public float scale;
  public String text;
  public int width;
  
  public p(jy paramjy)
  {
    super(d.NYk);
    AppMethodBeat.i(280277);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.NZn = new RectF();
    this.NZo = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    Object localObject1 = "";
    Object localObject2 = (com.tencent.mm.bx.a)new eac();
    paramjy = paramjy.YMl.aaxD.Op;
    try
    {
      ((com.tencent.mm.bx.a)localObject2).parseFrom(paramjy);
      paramjy = (jy)localObject2;
    }
    catch (Exception paramjy)
    {
      for (;;)
      {
        fxy localfxy;
        Log.printDebugStack("safeParser", "", new Object[] { paramjy });
        paramjy = null;
      }
    }
    localObject2 = (eac)paramjy;
    paramjy = (jy)localObject1;
    if (localObject2 != null)
    {
      paramjy = ((eac)localObject2).LWN;
      s.s(paramjy, "it.pagPath");
      localObject1 = ((eac)localObject2).text;
      s.s(localObject1, "it.text");
      setText((String)localObject1);
      localObject1 = this.matrix;
      localfxy = ((eac)localObject2).Zbl;
      s.s(localfxy, "it.matrix");
      ((Matrix)localObject1).setValues(a(localfxy));
      i(this.matrix);
      a(((eac)localObject2).NZv);
    }
    this.LWN = paramjy;
    AppMethodBeat.o(280277);
  }
  
  private p(String paramString, Matrix paramMatrix)
  {
    super(d.NYk);
    AppMethodBeat.i(280262);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.NZn = new RectF();
    this.NZo = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.LWN = paramString;
    this.matrix.set(paramMatrix);
    AppMethodBeat.o(280262);
  }
  
  public final void bv(String paramString, long paramLong)
  {
    AppMethodBeat.i(280306);
    s.u(paramString, "path");
    this.NZo.setPath(paramString);
    this.NZo.durationMs = paramLong;
    AppMethodBeat.o(280306);
  }
  
  public final boolean gKA()
  {
    AppMethodBeat.i(280320);
    boolean bool = j.a.a(this);
    AppMethodBeat.o(280320);
    return bool;
  }
  
  public final long gKE()
  {
    return this.NZm;
  }
  
  public final com.tencent.mm.bx.a gKs()
  {
    AppMethodBeat.i(280300);
    Object localObject = new eac();
    ((eac)localObject).LWN = this.LWN;
    ((eac)localObject).text = this.text;
    ((eac)localObject).Zbl = h(this.matrix);
    ((eac)localObject).NZv = gKq();
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(280300);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b gKz()
  {
    return this.NZo;
  }
  
  public final void i(Matrix paramMatrix)
  {
    AppMethodBeat.i(280290);
    s.u(paramMatrix, "matrix");
    float f1 = this.width / 2.0F;
    float f2 = this.height / 2.0F;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    paramMatrix.mapPoints(arrayOfFloat, new float[] { f1, f2 });
    this.centerX = arrayOfFloat[0];
    this.centerY = (arrayOfFloat[1] - this.NZn.top);
    arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    double d3 = arrayOfFloat[4];
    this.scale = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.aBi = ((float)Math.atan2(d2, d3));
    paramMatrix = this.NZp;
    if (paramMatrix != null) {
      paramMatrix.v(this.centerX, this.centerY, this.scale, this.aBi);
    }
    AppMethodBeat.o(280290);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(280285);
    s.u(paramString, "<set-?>");
    this.text = paramString;
    AppMethodBeat.o(280285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.p
 * JD-Core Version:    0.7.0.1
 */