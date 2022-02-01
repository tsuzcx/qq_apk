package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILandroid/graphics/Matrix;)V", "font", "", "(Ljava/lang/CharSequence;IILjava/lang/String;ILandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "<set-?>", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "getTTSInfo", "isValid", "", "setTTSInfo", "", "path", "durationMs", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/TextItemData;", "toString", "update", "item", "Companion", "plugin-recordvideo_release"})
public final class q
  extends a
  implements i
{
  public static final q.a xPo;
  public CharSequence text;
  public int textColor;
  int xNG;
  public String xNN;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b xPj;
  public int xPn;
  
  static
  {
    AppMethodBeat.i(200738);
    xPo = new q.a((byte)0);
    AppMethodBeat.o(200738);
  }
  
  public q(ja paramja)
  {
    super(d.xNP);
    AppMethodBeat.i(200737);
    this.xNN = "";
    this.xPj = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new dmm();
      paramja = paramja.FCa;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          dwb localdwb;
          ad.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
        AppMethodBeat.o(200737);
        return;
      }
      paramja = (dmm)paramja;
      if (paramja != null)
      {
        this.text = ((CharSequence)paramja.text);
        this.textColor = paramja.textColor;
        this.xPn = paramja.xPn;
        this.xNG = paramja.xNG;
        localObject = this.gR;
        localdwb = paramja.FPc;
        p.g(localdwb, "it.matrix");
        ((Matrix)localObject).setValues(a(localdwb));
        localObject = paramja.xNN;
        p.g(localObject, "it.font");
        this.xNN = ((String)localObject);
        a(paramja.xPq);
        ad.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(200737);
        return;
      }
      return;
    }
    catch (IOException paramja)
    {
      ad.printErrStackTrace("MicroMsg.TextItem", (Throwable)paramja, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(200737);
    }
  }
  
  public q(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    super(d.xNP);
    AppMethodBeat.i(200733);
    this.xNN = "";
    this.xPj = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.xPn = paramInt2;
    this.xNG = paramInt3;
    this.gR.set(paramMatrix);
    ad.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(200733);
  }
  
  private q(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString, Matrix paramMatrix)
  {
    super(d.xNP);
    AppMethodBeat.i(200735);
    this.xNN = "";
    this.xPj = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.xPn = paramInt2;
    this.xNN = paramString;
    this.xNG = 0;
    this.gR.set(paramMatrix);
    ad.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(200735);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(200728);
    p.h(paramq, "item");
    this.text = paramq.text;
    this.textColor = paramq.textColor;
    this.xPn = paramq.xPn;
    this.xNG = paramq.xNG;
    this.gR.set(paramq.gR);
    this.xNN = paramq.xNN;
    ad.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(200728);
  }
  
  public final void be(String paramString, long paramLong)
  {
    AppMethodBeat.i(200731);
    p.h(paramString, "path");
    this.xPj.setPath(paramString);
    this.xPj.bup = paramLong;
    AppMethodBeat.o(200731);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b dHY()
  {
    return this.xPj;
  }
  
  public final boolean dHZ()
  {
    AppMethodBeat.i(200739);
    boolean bool = i.a.a(this);
    AppMethodBeat.o(200739);
    return bool;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(200730);
    if (!TextUtils.isEmpty(this.text))
    {
      AppMethodBeat.o(200730);
      return true;
    }
    AppMethodBeat.o(200730);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200732);
    String str = "[" + hashCode() + "]text:" + this.text + " color:" + this.textColor + " bgColor:" + this.xPn;
    AppMethodBeat.o(200732);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.q
 * JD-Core Version:    0.7.0.1
 */