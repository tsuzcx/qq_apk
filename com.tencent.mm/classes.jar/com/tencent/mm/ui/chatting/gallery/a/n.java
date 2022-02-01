package com.tencent.mm.ui.chatting.gallery.a;

import android.graphics.PointF;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "", "()V", "codePointInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "getCodePointInfo", "()Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "setCodePointInfo", "(Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;)V", "codeString", "", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "codeType", "", "getCodeType", "()I", "setCodeType", "(I)V", "codeVersion", "getCodeVersion", "setCodeVersion", "fromScanCodeButton", "", "getFromScanCodeButton", "()Z", "setFromScanCodeButton", "(Z)V", "imageKey", "getImageKey", "setImageKey", "imagePath", "getImagePath", "setImagePath", "source", "getSource", "setSource", "sourceType", "getSourceType", "setSourceType", "statObj", "Landroid/os/Bundle;", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "convertFrom", "", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "reset", "CodePointInfo", "Companion", "app_release"})
public final class n
{
  public static final n.b PDe;
  public String CFJ;
  public a PDc;
  public boolean PDd;
  public int dFL;
  public int dFM;
  public String dFO = "";
  public Bundle dFP;
  public String imagePath = "";
  public String source = "";
  public int sourceType;
  
  static
  {
    AppMethodBeat.i(231308);
    PDe = new n.b((byte)0);
    AppMethodBeat.o(231308);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult$CodePointInfo;", "", "()V", "codePoint", "Landroid/graphics/PointF;", "getCodePoint", "()Landroid/graphics/PointF;", "setCodePoint", "(Landroid/graphics/PointF;)V", "decodeImageHeight", "", "getDecodeImageHeight", "()I", "setDecodeImageHeight", "(I)V", "decodeImageWidth", "getDecodeImageWidth", "setDecodeImageWidth", "toString", "", "app_release"})
  public static final class a
  {
    public PointF PDf;
    public int PDg;
    public int PDh;
    
    public final String toString()
    {
      AppMethodBeat.i(231307);
      String str = "codePoint: " + this.PDf + ", imageWidth: " + this.PDg + ", imageHeight: " + this.PDh;
      AppMethodBeat.o(231307);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.n
 * JD-Core Version:    0.7.0.1
 */