package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fmm;
import com.tencent.mm.protocal.protobuf.fxy;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/TextItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditorTTSData;", "text", "", "textColor", "", "textBgColor", "marginBottom", "matrix", "Landroid/graphics/Matrix;", "(Ljava/lang/CharSequence;IIILandroid/graphics/Matrix;)V", "font", "", "(Ljava/lang/CharSequence;IILjava/lang/String;ILandroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "<set-?>", "getText", "()Ljava/lang/CharSequence;", "getTextBgColor", "getTextColor", "ttsInfo", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "getTTSInfo", "isValid", "", "setTTSInfo", "", "path", "durationMs", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/TextItemData;", "toString", "update", "item", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends a
  implements j
{
  public static final r.a NZs;
  int CMB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b NZo;
  public int NZt;
  public CharSequence bba;
  public String mAD;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(280299);
    NZs = new r.a((byte)0);
    AppMethodBeat.o(280299);
  }
  
  public r(jy paramjy)
  {
    super(d.NYd);
    AppMethodBeat.i(280291);
    this.mAD = "";
    this.NZo = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new fmm();
      paramjy = paramjy.YMl.aaxD.Op;
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramjy);
        paramjy = (jy)localObject;
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
      paramjy = (fmm)paramjy;
      if (paramjy != null)
      {
        this.bba = ((CharSequence)paramjy.text);
        this.textColor = paramjy.textColor;
        this.NZt = paramjy.NZt;
        this.CMB = paramjy.CMB;
        localObject = this.matrix;
        localfxy = paramjy.Zbl;
        s.s(localfxy, "it.matrix");
        ((Matrix)localObject).setValues(a(localfxy));
        localObject = paramjy.mAD;
        s.s(localObject, "it.font");
        setFont((String)localObject);
        a(paramjy.NZv);
        Log.i("MicroMsg.TextItem", toString());
        AppMethodBeat.o(280291);
        return;
      }
    }
    catch (IOException paramjy)
    {
      Log.printErrStackTrace("MicroMsg.TextItem", (Throwable)paramjy, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(280291);
    }
  }
  
  public r(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, Matrix paramMatrix)
  {
    super(d.NYd);
    AppMethodBeat.i(280269);
    this.mAD = "";
    this.NZo = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.bba = paramCharSequence;
    this.textColor = paramInt1;
    this.NZt = paramInt2;
    this.CMB = paramInt3;
    this.matrix.set(paramMatrix);
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(280269);
  }
  
  private r(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString, Matrix paramMatrix)
  {
    super(d.NYd);
    AppMethodBeat.i(280281);
    this.mAD = "";
    this.NZo = new com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b();
    this.bba = paramCharSequence;
    this.textColor = paramInt1;
    this.NZt = paramInt2;
    this.mAD = paramString;
    this.CMB = 0;
    this.matrix.set(paramMatrix);
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(280281);
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(280311);
    s.u(paramr, "item");
    this.bba = paramr.bba;
    this.textColor = paramr.textColor;
    this.NZt = paramr.NZt;
    this.CMB = paramr.CMB;
    this.matrix.set(paramr.matrix);
    this.mAD = paramr.mAD;
    Log.i("MicroMsg.TextItem", toString());
    AppMethodBeat.o(280311);
  }
  
  public final void bv(String paramString, long paramLong)
  {
    AppMethodBeat.i(280325);
    s.u(paramString, "path");
    this.NZo.setPath(paramString);
    this.NZo.durationMs = paramLong;
    AppMethodBeat.o(280325);
  }
  
  public final boolean gKA()
  {
    AppMethodBeat.i(280346);
    boolean bool = j.a.a(this);
    AppMethodBeat.o(280346);
    return bool;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b gKz()
  {
    return this.NZo;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(280318);
    if (!TextUtils.isEmpty(this.bba))
    {
      AppMethodBeat.o(280318);
      return true;
    }
    AppMethodBeat.o(280318);
    return false;
  }
  
  public final void setFont(String paramString)
  {
    AppMethodBeat.i(280305);
    s.u(paramString, "<set-?>");
    this.mAD = paramString;
    AppMethodBeat.o(280305);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280340);
    String str = "[" + hashCode() + "]text:" + this.bba + " color:" + this.textColor + " bgColor:" + this.NZt;
    AppMethodBeat.o(280340);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.r
 * JD-Core Version:    0.7.0.1
 */