package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILandroid/graphics/Matrix;)V", "font", "", "(Ljava/lang/CharSequence;IILjava/lang/String;ILandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "<set-?>", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "getTTSInfo", "isValid", "", "setTTSInfo", "", "path", "durationMs", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/TextItemData;", "toString", "update", "item", "Companion", "plugin-recordvideo_release"})
public final class r
  extends a
  implements j
{
  public static final a IcX;
  public String IbE;
  int Ibx;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b IcS;
  public int IcW;
  public CharSequence LV;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(221080);
    IcX = new a((byte)0);
    AppMethodBeat.o(221080);
  }
  
  public r(jc paramjc)
  {
    super(d.IbG);
    AppMethodBeat.i(221079);
    this.IbE = "";
    this.IcS = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    try
    {
      Object localObject = (com.tencent.mm.cd.a)new erf();
      paramjc = paramjc.ROY;
      p.j(paramjc, "proto.itemData");
      paramjc = paramjc.Tkb;
      p.j(paramjc, "proto.itemData.buffer");
      paramjc = paramjc.UH;
      try
      {
        ((com.tencent.mm.cd.a)localObject).parseFrom(paramjc);
        paramjc = (jc)localObject;
      }
      catch (Exception paramjc)
      {
        for (;;)
        {
          fbn localfbn;
          Log.printDebugStack("safeParser", "", new Object[] { paramjc });
          paramjc = null;
        }
        AppMethodBeat.o(221079);
        return;
      }
      paramjc = (erf)paramjc;
      if (paramjc != null)
      {
        this.LV = ((CharSequence)paramjc.text);
        this.textColor = paramjc.textColor;
        this.IcW = paramjc.IcW;
        this.Ibx = paramjc.Ibx;
        localObject = this.aHZ;
        localfbn = paramjc.Sdr;
        p.j(localfbn, "it.matrix");
        ((Matrix)localObject).setValues(a(localfbn));
        localObject = paramjc.IbE;
        p.j(localObject, "it.font");
        this.IbE = ((String)localObject);
        a(paramjc.IcZ);
        Log.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(221079);
        return;
      }
      return;
    }
    catch (IOException paramjc)
    {
      Log.printErrStackTrace("MicroMsg.TextItem", (Throwable)paramjc, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(221079);
    }
  }
  
  public r(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    super(d.IbG);
    AppMethodBeat.i(221061);
    this.IbE = "";
    this.IcS = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.LV = paramCharSequence;
    this.textColor = paramInt1;
    this.IcW = paramInt2;
    this.Ibx = paramInt3;
    this.aHZ.set(paramMatrix);
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(221061);
  }
  
  private r(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString, Matrix paramMatrix)
  {
    super(d.IbG);
    AppMethodBeat.i(221066);
    this.IbE = "";
    this.IcS = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.LV = paramCharSequence;
    this.textColor = paramInt1;
    this.IcW = paramInt2;
    this.IbE = paramString;
    this.Ibx = 0;
    this.aHZ.set(paramMatrix);
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(221066);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(221036);
    p.k(paramr, "item");
    this.LV = paramr.LV;
    this.textColor = paramr.textColor;
    this.IcW = paramr.IcW;
    this.Ibx = paramr.Ibx;
    this.aHZ.set(paramr.aHZ);
    this.IbE = paramr.IbE;
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(221036);
  }
  
  public final void bj(String paramString, long paramLong)
  {
    AppMethodBeat.i(221050);
    p.k(paramString, "path");
    this.IcS.setPath(paramString);
    this.IcS.durationMs = paramLong;
    AppMethodBeat.o(221050);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b fyN()
  {
    return this.IcS;
  }
  
  public final boolean fyO()
  {
    AppMethodBeat.i(221081);
    boolean bool = j.a.a(this);
    AppMethodBeat.o(221081);
    return bool;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(221046);
    if (!TextUtils.isEmpty(this.LV))
    {
      AppMethodBeat.o(221046);
      return true;
    }
    AppMethodBeat.o(221046);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221054);
    String str = "[" + hashCode() + "]text:" + this.LV + " color:" + this.textColor + " bgColor:" + this.IcW;
    AppMethodBeat.o(221054);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.r
 * JD-Core Version:    0.7.0.1
 */