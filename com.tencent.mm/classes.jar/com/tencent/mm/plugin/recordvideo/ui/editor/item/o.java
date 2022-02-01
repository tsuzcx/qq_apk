package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "pagPath", "", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "drawingRect", "Landroid/graphics/RectF;", "getDrawingRect", "()Landroid/graphics/RectF;", "effectId", "", "getEffectId", "()J", "setEffectId", "(J)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "getPagPath", "()Ljava/lang/String;", "rotate", "getRotate", "setRotate", "scale", "getScale", "setScale", "text", "getText", "setText", "(Ljava/lang/String;)V", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "width", "getWidth", "setWidth", "bringToFront", "", "delete", "getTTSInfo", "isValid", "", "setTTSInfo", "path", "durationMs", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "updateMatrix", "plugin-recordvideo_release"})
public final class o
  extends a
  implements i
{
  public final String Cga;
  public final RectF Cgb;
  private final b Cgc;
  public j Cgd;
  public float centerX;
  public float centerY;
  public int height;
  public float mat;
  public float scale;
  public String text;
  public long wKD;
  public int width;
  
  public o(jn paramjn)
  {
    super(d.CeR);
    AppMethodBeat.i(237823);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.Cgb = new RectF();
    this.Cgc = new b();
    Object localObject1 = (com.tencent.mm.bw.a)new cyg();
    paramjn = paramjn.KOd;
    p.g(paramjn, "proto.itemData");
    paramjn = paramjn.getBufferToBytes();
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom(paramjn);
      paramjn = (jn)localObject1;
    }
    catch (Exception paramjn)
    {
      for (;;)
      {
        Object localObject2;
        erc localerc;
        Log.printDebugStack("safeParser", "", new Object[] { paramjn });
        paramjn = null;
        continue;
        paramjn = "";
      }
    }
    localObject1 = (cyg)paramjn;
    if (localObject1 != null)
    {
      paramjn = ((cyg)localObject1).Cga;
      p.g(paramjn, "it.pagPath");
      localObject2 = ((cyg)localObject1).text;
      p.g(localObject2, "it.text");
      this.text = ((String)localObject2);
      localObject2 = this.gT;
      localerc = ((cyg)localObject1).Lce;
      p.g(localerc, "it.matrix");
      ((Matrix)localObject2).setValues(a(localerc));
      g(this.gT);
      a(((cyg)localObject1).Cgj);
      this.Cga = paramjn;
      AppMethodBeat.o(237823);
      return;
    }
  }
  
  private o(String paramString, Matrix paramMatrix)
  {
    super(d.CeR);
    AppMethodBeat.i(237821);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.Cgb = new RectF();
    this.Cgc = new b();
    this.Cga = paramString;
    this.gT.set(paramMatrix);
    AppMethodBeat.o(237821);
  }
  
  public final void bh(String paramString, long paramLong)
  {
    AppMethodBeat.i(237820);
    p.h(paramString, "path");
    this.Cgc.setPath(paramString);
    this.Cgc.durationMs = paramLong;
    AppMethodBeat.o(237820);
  }
  
  public final com.tencent.mm.bw.a eMk()
  {
    AppMethodBeat.i(237819);
    Object localObject = new cyg();
    ((cyg)localObject).Cga = this.Cga;
    ((cyg)localObject).text = this.text;
    ((cyg)localObject).Lce = f(this.gT);
    ((cyg)localObject).Cgj = eMi();
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(237819);
    return localObject;
  }
  
  public final b eMp()
  {
    return this.Cgc;
  }
  
  public final boolean eMq()
  {
    AppMethodBeat.i(237824);
    boolean bool = i.a.a(this);
    AppMethodBeat.o(237824);
    return bool;
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(237818);
    p.h(paramMatrix, "matrix");
    float f1 = this.width / 2.0F;
    float f2 = this.height / 2.0F;
    float[] arrayOfFloat = new float[2];
    float[] tmp37_35 = arrayOfFloat;
    tmp37_35[0] = 0.0F;
    float[] tmp41_37 = tmp37_35;
    tmp41_37[1] = 0.0F;
    tmp41_37;
    paramMatrix.mapPoints(arrayOfFloat, new float[] { tmp37_35, tmp41_37 });
    this.centerX = arrayOfFloat[0];
    this.centerY = (arrayOfFloat[1] - this.Cgb.top);
    arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    double d3 = arrayOfFloat[4];
    this.scale = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.mat = ((float)Math.atan2(d2, d3));
    paramMatrix = this.Cgd;
    if (paramMatrix != null)
    {
      paramMatrix.q(this.centerX, this.centerY, this.scale, this.mat);
      AppMethodBeat.o(237818);
      return;
    }
    AppMethodBeat.o(237818);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(237817);
    p.h(paramString, "<set-?>");
    this.text = paramString;
    AppMethodBeat.o(237817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.o
 * JD-Core Version:    0.7.0.1
 */