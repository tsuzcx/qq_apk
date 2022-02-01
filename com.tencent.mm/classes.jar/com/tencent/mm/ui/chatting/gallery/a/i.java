package com.tencent.mm.ui.chatting.gallery.a;

import android.graphics.PointF;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "", "()V", "codePointInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "getCodePointInfo", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "setCodePointInfo", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;)V", "codeString", "", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "codeType", "", "getCodeType", "()I", "setCodeType", "(I)V", "codeVersion", "getCodeVersion", "setCodeVersion", "fromScanCodeButton", "", "getFromScanCodeButton", "()Z", "setFromScanCodeButton", "(Z)V", "imageKey", "getImageKey", "setImageKey", "imagePath", "getImagePath", "setImagePath", "source", "getSource", "setSource", "sourceType", "getSourceType", "setSourceType", "statObj", "Landroid/os/Bundle;", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "convertFrom", "", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "reset", "CodePointInfo", "Companion", "app_release"})
public final class i
{
  public static final i.b JUO;
  public a JUM;
  public boolean JUN;
  public int dnt;
  public int dnu;
  public String dnw = "";
  public Bundle dnx;
  public String imagePath = "";
  public String source = "";
  public int sourceType;
  public String ymV;
  
  static
  {
    AppMethodBeat.i(194909);
    JUO = new i.b((byte)0);
    AppMethodBeat.o(194909);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "", "()V", "codePoint", "Landroid/graphics/PointF;", "getCodePoint", "()Landroid/graphics/PointF;", "setCodePoint", "(Landroid/graphics/PointF;)V", "decodeImageHeight", "", "getDecodeImageHeight", "()I", "setDecodeImageHeight", "(I)V", "decodeImageWidth", "getDecodeImageWidth", "setDecodeImageWidth", "toString", "", "app_release"})
  public static final class a
  {
    public PointF JUP;
    public int JUQ;
    public int JUR;
    
    public final String toString()
    {
      AppMethodBeat.i(194908);
      String str = "codePoint: " + this.JUP + ", imageWidth: " + this.JUQ + ", imageHeight: " + this.JUR;
      AppMethodBeat.o(194908);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.i
 * JD-Core Version:    0.7.0.1
 */