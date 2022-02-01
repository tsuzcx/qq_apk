package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILandroid/graphics/Matrix;)V", "font", "", "(Ljava/lang/CharSequence;IILjava/lang/String;ILandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "<set-?>", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "getTTSInfo", "isValid", "", "setTTSInfo", "", "path", "durationMs", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/TextItemData;", "toString", "update", "item", "Companion", "plugin-recordvideo_release"})
public final class q
  extends a
  implements i
{
  public static final q.a yfh;
  public CharSequence text;
  public int textColor;
  public String ydG;
  int ydz;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b yfc;
  public int yfg;
  
  static
  {
    AppMethodBeat.i(206996);
    yfh = new q.a((byte)0);
    AppMethodBeat.o(206996);
  }
  
  public q(ja paramja)
  {
    super(d.ydI);
    AppMethodBeat.i(206995);
    this.ydG = "";
    this.yfc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new dnj();
      paramja = paramja.FUv;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          dww localdww;
          ae.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
        AppMethodBeat.o(206995);
        return;
      }
      paramja = (dnj)paramja;
      if (paramja != null)
      {
        this.text = ((CharSequence)paramja.text);
        this.textColor = paramja.textColor;
        this.yfg = paramja.yfg;
        this.ydz = paramja.ydz;
        localObject = this.gR;
        localdww = paramja.GhB;
        p.g(localdww, "it.matrix");
        ((Matrix)localObject).setValues(a(localdww));
        localObject = paramja.ydG;
        p.g(localObject, "it.font");
        this.ydG = ((String)localObject);
        a(paramja.yfj);
        ae.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(206995);
        return;
      }
      return;
    }
    catch (IOException paramja)
    {
      ae.printErrStackTrace("MicroMsg.TextItem", (Throwable)paramja, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(206995);
    }
  }
  
  public q(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    super(d.ydI);
    AppMethodBeat.i(206991);
    this.ydG = "";
    this.yfc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.yfg = paramInt2;
    this.ydz = paramInt3;
    this.gR.set(paramMatrix);
    ae.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(206991);
  }
  
  private q(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString, Matrix paramMatrix)
  {
    super(d.ydI);
    AppMethodBeat.i(206993);
    this.ydG = "";
    this.yfc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.yfg = paramInt2;
    this.ydG = paramString;
    this.ydz = 0;
    this.gR.set(paramMatrix);
    ae.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(206993);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(206986);
    p.h(paramq, "item");
    this.text = paramq.text;
    this.textColor = paramq.textColor;
    this.yfg = paramq.yfg;
    this.ydz = paramq.ydz;
    this.gR.set(paramq.gR);
    this.ydG = paramq.ydG;
    ae.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(206986);
  }
  
  public final void bf(String paramString, long paramLong)
  {
    AppMethodBeat.i(206989);
    p.h(paramString, "path");
    this.yfc.setPath(paramString);
    this.yfc.bup = paramLong;
    AppMethodBeat.o(206989);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b dLp()
  {
    return this.yfc;
  }
  
  public final boolean dLq()
  {
    AppMethodBeat.i(206997);
    boolean bool = i.a.a(this);
    AppMethodBeat.o(206997);
    return bool;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(206988);
    if (!TextUtils.isEmpty(this.text))
    {
      AppMethodBeat.o(206988);
      return true;
    }
    AppMethodBeat.o(206988);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206990);
    String str = "[" + hashCode() + "]text:" + this.text + " color:" + this.textColor + " bgColor:" + this.yfg;
    AppMethodBeat.o(206990);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.q
 * JD-Core Version:    0.7.0.1
 */