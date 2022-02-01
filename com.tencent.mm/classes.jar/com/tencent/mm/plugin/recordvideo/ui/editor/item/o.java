package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "pagPath", "", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "drawingRect", "Landroid/graphics/RectF;", "getDrawingRect", "()Landroid/graphics/RectF;", "effectId", "", "getEffectId", "()J", "setEffectId", "(J)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "getPagPath", "()Ljava/lang/String;", "rotate", "getRotate", "setRotate", "scale", "getScale", "setScale", "stickerId", "getStickerId", "setStickerId", "text", "getText", "setText", "(Ljava/lang/String;)V", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "width", "getWidth", "setWidth", "bringToFront", "", "delete", "getTTSInfo", "isValid", "", "setTTSInfo", "path", "durationMs", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "updateMatrix", "plugin-recordvideo_release"})
public final class o
  extends a
  implements i
{
  public float centerX;
  public float centerY;
  public int height;
  public float kRD;
  public float scale;
  public String text;
  public int width;
  public final String xPf;
  public long xPg;
  public long xPh;
  public final RectF xPi;
  private final b xPj;
  public j xPk;
  
  public o(ja paramja)
  {
    super(d.xNW);
    AppMethodBeat.i(200724);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.xPi = new RectF();
    this.xPj = new b();
    Object localObject1 = (com.tencent.mm.bx.a)new chf();
    paramja = paramja.FCa;
    p.g(paramja, "proto.itemData");
    paramja = paramja.getBufferToBytes();
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom(paramja);
      paramja = (ja)localObject1;
    }
    catch (Exception paramja)
    {
      for (;;)
      {
        Object localObject2;
        dwb localdwb;
        ad.l("safeParser", "", new Object[] { paramja });
        paramja = null;
        continue;
        paramja = "";
      }
    }
    localObject1 = (chf)paramja;
    if (localObject1 != null)
    {
      paramja = ((chf)localObject1).xPf;
      p.g(paramja, "it.pagPath");
      localObject2 = ((chf)localObject1).text;
      p.g(localObject2, "it.text");
      this.text = ((String)localObject2);
      localObject2 = this.gR;
      localdwb = ((chf)localObject1).FPc;
      p.g(localdwb, "it.matrix");
      ((Matrix)localObject2).setValues(a(localdwb));
      g(this.gR);
      a(((chf)localObject1).xPq);
      this.xPf = paramja;
      AppMethodBeat.o(200724);
      return;
    }
  }
  
  private o(String paramString, Matrix paramMatrix)
  {
    super(d.xNW);
    AppMethodBeat.i(200722);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.xPi = new RectF();
    this.xPj = new b();
    this.xPf = paramString;
    this.gR.set(paramMatrix);
    AppMethodBeat.o(200722);
  }
  
  public final void be(String paramString, long paramLong)
  {
    AppMethodBeat.i(200721);
    p.h(paramString, "path");
    this.xPj.setPath(paramString);
    this.xPj.bup = paramLong;
    AppMethodBeat.o(200721);
  }
  
  public final com.tencent.mm.bx.a dHT()
  {
    AppMethodBeat.i(200720);
    Object localObject = new chf();
    ((chf)localObject).xPf = this.xPf;
    ((chf)localObject).text = this.text;
    ((chf)localObject).FPc = f(this.gR);
    ((chf)localObject).xPq = dHR();
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(200720);
    return localObject;
  }
  
  public final b dHY()
  {
    return this.xPj;
  }
  
  public final boolean dHZ()
  {
    AppMethodBeat.i(200725);
    boolean bool = i.a.a(this);
    AppMethodBeat.o(200725);
    return bool;
  }
  
  public final long dId()
  {
    return this.xPg;
  }
  
  public final long dIe()
  {
    return this.xPh;
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(200719);
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
    this.centerY = (arrayOfFloat[1] - this.xPi.top);
    arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    double d3 = arrayOfFloat[4];
    this.scale = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.kRD = ((float)Math.atan2(d2, d3));
    paramMatrix = this.xPk;
    if (paramMatrix != null)
    {
      paramMatrix.n(this.centerX, this.centerY, this.scale, this.kRD);
      AppMethodBeat.o(200719);
      return;
    }
    AppMethodBeat.o(200719);
  }
  
  public final float getCenterX()
  {
    return this.centerX;
  }
  
  public final float getCenterY()
  {
    return this.centerY;
  }
  
  public final float getRotate()
  {
    return this.kRD;
  }
  
  public final float getScale()
  {
    return this.scale;
  }
  
  public final String getText()
  {
    return this.text;
  }
  
  public final void setText(String paramString)
  {
    AppMethodBeat.i(200718);
    p.h(paramString, "<set-?>");
    this.text = paramString;
    AppMethodBeat.o(200718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.o
 * JD-Core Version:    0.7.0.1
 */