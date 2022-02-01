package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "pagPath", "", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/String;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "callback", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "getCallback", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;", "setCallback", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/ItemEditCallback;)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "drawingRect", "Landroid/graphics/RectF;", "getDrawingRect", "()Landroid/graphics/RectF;", "effectId", "", "getEffectId", "()J", "setEffectId", "(J)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "getPagPath", "()Ljava/lang/String;", "rotate", "getRotate", "setRotate", "scale", "getScale", "setScale", "stickerId", "getStickerId", "setStickerId", "text", "getText", "setText", "(Ljava/lang/String;)V", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "width", "getWidth", "setWidth", "bringToFront", "", "delete", "getTTSInfo", "isValid", "", "setTTSInfo", "path", "durationMs", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "updateMatrix", "plugin-recordvideo_release"})
public final class o
  extends a
  implements i
{
  public float centerX;
  public float centerY;
  public int height;
  public float kVl;
  public float scale;
  public String text;
  public int width;
  public final String yeY;
  public long yeZ;
  public long yfa;
  public final RectF yfb;
  private final b yfc;
  public j yfd;
  
  public o(ja paramja)
  {
    super(d.ydP);
    AppMethodBeat.i(206982);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.yfb = new RectF();
    this.yfc = new b();
    Object localObject1 = (com.tencent.mm.bw.a)new chz();
    paramja = paramja.FUv;
    p.g(paramja, "proto.itemData");
    paramja = paramja.getBufferToBytes();
    try
    {
      ((com.tencent.mm.bw.a)localObject1).parseFrom(paramja);
      paramja = (ja)localObject1;
    }
    catch (Exception paramja)
    {
      for (;;)
      {
        Object localObject2;
        dww localdww;
        ae.l("safeParser", "", new Object[] { paramja });
        paramja = null;
        continue;
        paramja = "";
      }
    }
    localObject1 = (chz)paramja;
    if (localObject1 != null)
    {
      paramja = ((chz)localObject1).yeY;
      p.g(paramja, "it.pagPath");
      localObject2 = ((chz)localObject1).text;
      p.g(localObject2, "it.text");
      this.text = ((String)localObject2);
      localObject2 = this.gR;
      localdww = ((chz)localObject1).GhB;
      p.g(localdww, "it.matrix");
      ((Matrix)localObject2).setValues(a(localdww));
      g(this.gR);
      a(((chz)localObject1).yfj);
      this.yeY = paramja;
      AppMethodBeat.o(206982);
      return;
    }
  }
  
  private o(String paramString, Matrix paramMatrix)
  {
    super(d.ydP);
    AppMethodBeat.i(206980);
    this.text = "";
    this.width = 160;
    this.height = 160;
    this.scale = 1.0F;
    this.yfb = new RectF();
    this.yfc = new b();
    this.yeY = paramString;
    this.gR.set(paramMatrix);
    AppMethodBeat.o(206980);
  }
  
  public final void bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(206979);
    p.h(paramString, "path");
    this.yfc.setPath(paramString);
    this.yfc.bup = paramLong;
    AppMethodBeat.o(206979);
  }
  
  public final com.tencent.mm.bw.a dLk()
  {
    AppMethodBeat.i(206978);
    Object localObject = new chz();
    ((chz)localObject).yeY = this.yeY;
    ((chz)localObject).text = this.text;
    ((chz)localObject).GhB = f(this.gR);
    ((chz)localObject).yfj = dLi();
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(206978);
    return localObject;
  }
  
  public final b dLp()
  {
    return this.yfc;
  }
  
  public final boolean dLq()
  {
    AppMethodBeat.i(206983);
    boolean bool = i.a.a(this);
    AppMethodBeat.o(206983);
    return bool;
  }
  
  public final long dLu()
  {
    return this.yeZ;
  }
  
  public final long dLv()
  {
    return this.yfa;
  }
  
  public final void g(Matrix paramMatrix)
  {
    AppMethodBeat.i(206977);
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
    this.centerY = (arrayOfFloat[1] - this.yfb.top);
    arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    double d3 = arrayOfFloat[4];
    this.scale = ((float)Math.sqrt(d1 * d1 + d2 * d2));
    this.kVl = ((float)Math.atan2(d2, d3));
    paramMatrix = this.yfd;
    if (paramMatrix != null)
    {
      paramMatrix.n(this.centerX, this.centerY, this.scale, this.kVl);
      AppMethodBeat.o(206977);
      return;
    }
    AppMethodBeat.o(206977);
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
    return this.kVl;
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
    AppMethodBeat.i(206976);
    p.h(paramString, "<set-?>");
    this.text = paramString;
    AppMethodBeat.o(206976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.o
 * JD-Core Version:    0.7.0.1
 */