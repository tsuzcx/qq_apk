package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILandroid/graphics/Matrix;)V", "font", "", "(Ljava/lang/CharSequence;IILjava/lang/String;ILandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "<set-?>", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "getTTSInfo", "isValid", "", "setTTSInfo", "", "path", "durationMs", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/TextItemData;", "toString", "update", "item", "Companion", "plugin-recordvideo_release"})
public final class q
  extends a
  implements i
{
  public static final q.a Cgh;
  int CeB;
  public String CeI;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b Cgc;
  public int Cgg;
  public CharSequence text;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(237837);
    Cgh = new q.a((byte)0);
    AppMethodBeat.o(237837);
  }
  
  public q(jn paramjn)
  {
    super(d.CeK);
    AppMethodBeat.i(237836);
    this.CeI = "";
    this.Cgc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new ehd();
      paramjn = paramjn.KOd;
      p.g(paramjn, "proto.itemData");
      paramjn = paramjn.getBuffer();
      p.g(paramjn, "proto.itemData.buffer");
      paramjn = paramjn.zy;
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramjn);
        paramjn = (jn)localObject;
      }
      catch (Exception paramjn)
      {
        for (;;)
        {
          erc localerc;
          Log.printDebugStack("safeParser", "", new Object[] { paramjn });
          paramjn = null;
        }
        AppMethodBeat.o(237836);
        return;
      }
      paramjn = (ehd)paramjn;
      if (paramjn != null)
      {
        this.text = ((CharSequence)paramjn.text);
        this.textColor = paramjn.textColor;
        this.Cgg = paramjn.Cgg;
        this.CeB = paramjn.CeB;
        localObject = this.gT;
        localerc = paramjn.Lce;
        p.g(localerc, "it.matrix");
        ((Matrix)localObject).setValues(a(localerc));
        localObject = paramjn.CeI;
        p.g(localObject, "it.font");
        this.CeI = ((String)localObject);
        a(paramjn.Cgj);
        Log.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(237836);
        return;
      }
      return;
    }
    catch (IOException paramjn)
    {
      Log.printErrStackTrace("MicroMsg.TextItem", (Throwable)paramjn, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(237836);
    }
  }
  
  public q(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    super(d.CeK);
    AppMethodBeat.i(237832);
    this.CeI = "";
    this.Cgc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.Cgg = paramInt2;
    this.CeB = paramInt3;
    this.gT.set(paramMatrix);
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(237832);
  }
  
  private q(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString, Matrix paramMatrix)
  {
    super(d.CeK);
    AppMethodBeat.i(237834);
    this.CeI = "";
    this.Cgc = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.text = paramCharSequence;
    this.textColor = paramInt1;
    this.Cgg = paramInt2;
    this.CeI = paramString;
    this.CeB = 0;
    this.gT.set(paramMatrix);
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(237834);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(237827);
    p.h(paramq, "item");
    this.text = paramq.text;
    this.textColor = paramq.textColor;
    this.Cgg = paramq.Cgg;
    this.CeB = paramq.CeB;
    this.gT.set(paramq.gT);
    this.CeI = paramq.CeI;
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(237827);
  }
  
  public final void bh(String paramString, long paramLong)
  {
    AppMethodBeat.i(237830);
    p.h(paramString, "path");
    this.Cgc.setPath(paramString);
    this.Cgc.durationMs = paramLong;
    AppMethodBeat.o(237830);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b eMp()
  {
    return this.Cgc;
  }
  
  public final boolean eMq()
  {
    AppMethodBeat.i(237838);
    boolean bool = i.a.a(this);
    AppMethodBeat.o(237838);
    return bool;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(237829);
    if (!TextUtils.isEmpty(this.text))
    {
      AppMethodBeat.o(237829);
      return true;
    }
    AppMethodBeat.o(237829);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237831);
    String str = "[" + hashCode() + "]text:" + this.text + " color:" + this.textColor + " bgColor:" + this.Cgg;
    AppMethodBeat.o(237831);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.q
 * JD-Core Version:    0.7.0.1
 */