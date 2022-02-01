package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "pagPath", "", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "drawingRect", "Landroid/graphics/RectF;", "getDrawingRect", "()Landroid/graphics/RectF;", "effectId", "", "getEffectId", "()J", "setEffectId", "(J)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "getPagPath", "()Ljava/lang/String;", "rotate", "getRotate", "setRotate", "scale", "getScale", "setScale", "text", "getText", "setText", "(Ljava/lang/String;)V", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "width", "getWidth", "setWidth", "bringToFront", "", "delete", "getTTSInfo", "isValid", "", "setTTSInfo", "path", "durationMs", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "updateMatrix", "plugin-recordvideo_release"})
public final class p
  extends a
  implements j
{
  public final String GaM;
  public long IcQ;
  public final RectF IcR;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b IcS;
  public k IcT;
  public float aGt;
  public float aGu;
  public int height;
  public float oYk;
  public float scale;
  public String text;
  public int width;
  
  public p(jc paramjc)
  {
    super(d.IbN);
    AppMethodBeat.i(222675);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.IcR = new RectF();
    this.IcS = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    Object localObject1 = (com.tencent.mm.cd.a)new dhs();
    paramjc = paramjc.ROY;
    kotlin.g.b.p.j(paramjc, "proto.itemData");
    paramjc = paramjc.Tkb.UH;
    try
    {
      ((com.tencent.mm.cd.a)localObject1).parseFrom(paramjc);
      paramjc = (jc)localObject1;
    }
    catch (Exception paramjc)
    {
      for (;;)
      {
        Object localObject2;
        fbn localfbn;
        Log.printDebugStack("safeParser", "", new Object[] { paramjc });
        paramjc = null;
        continue;
        paramjc = "";
      }
    }
    localObject1 = (dhs)paramjc;
    if (localObject1 != null)
    {
      paramjc = ((dhs)localObject1).GaM;
      kotlin.g.b.p.j(paramjc, "it.pagPath");
      localObject2 = ((dhs)localObject1).text;
      kotlin.g.b.p.j(localObject2, "it.text");
      this.text = ((String)localObject2);
      localObject2 = this.aHZ;
      localfbn = ((dhs)localObject1).Sdr;
      kotlin.g.b.p.j(localfbn, "it.matrix");
      ((Matrix)localObject2).setValues(a(localfbn));
      g(this.aHZ);
      a(((dhs)localObject1).IcZ);
      this.GaM = paramjc;
      AppMethodBeat.o(222675);
      return;
    }
  }
  
  private p(String paramString, Matrix paramMatrix)
  {
    super(d.IbN);
    AppMethodBeat.i(222666);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.IcR = new RectF();
    this.IcS = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.GaM = paramString;
    this.aHZ.set(paramMatrix);
    AppMethodBeat.o(222666);
  }
  
  public final void bj(String paramString, long paramLong)
  {
    AppMethodBeat.i(222662);
    kotlin.g.b.p.k(paramString, "path");
    this.IcS.setPath(paramString);
    this.IcS.durationMs = paramLong;
    AppMethodBeat.o(222662);
  }
  
  public final com.tencent.mm.cd.a fyG()
  {
    AppMethodBeat.i(222661);
    Object localObject = new dhs();
    ((dhs)localObject).GaM = this.GaM;
    ((dhs)localObject).text = this.text;
    ((dhs)localObject).Sdr = f(this.aHZ);
    ((dhs)localObject).IcZ = fyE();
    localObject = (com.tencent.mm.cd.a)localObject;
    AppMethodBeat.o(222661);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b fyN()
  {
    return this.IcS;
  }
  
  public final boolean fyO()
  {
    AppMethodBeat.i(222677);
    boolean bool = j.a.a(this);
    AppMethodBeat.o(222677);
    return bool;
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(222659);
    kotlin.g.b.p.k(paramMatrix, "matrix");
    float f1 = this.width / 2.0F;
    float f2 = this.height / 2.0F;
    float[] arrayOfFloat = new float[2];
    float[] tmp37_35 = arrayOfFloat;
    tmp37_35[0] = 0.0F;
    float[] tmp41_37 = tmp37_35;
    tmp41_37[1] = 0.0F;
    tmp41_37;
    paramMatrix.mapPoints(arrayOfFloat, new float[] { tmp37_35, tmp41_37 });
    this.aGt = arrayOfFloat[0];
    this.aGu = (arrayOfFloat[1] - this.IcR.top);
    arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    double d3 = arrayOfFloat[4];
    this.scale = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.oYk = ((float)Math.atan2(d2, d3));
    paramMatrix = this.IcT;
    if (paramMatrix != null)
    {
      paramMatrix.r(this.aGt, this.aGu, this.scale, this.oYk);
      AppMethodBeat.o(222659);
      return;
    }
    AppMethodBeat.o(222659);
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(222653);
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.text = paramString;
    AppMethodBeat.o(222653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.p
 * JD-Core Version:    0.7.0.1
 */