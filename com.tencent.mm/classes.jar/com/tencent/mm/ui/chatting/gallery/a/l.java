package com.tencent.mm.ui.chatting.gallery.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import java.util.ArrayList;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "", "()V", "currentFetchInfoData", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "getCurrentFetchInfoData", "()Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "setCurrentFetchInfoData", "(Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;)V", "currentOnlyGreenPointData", "getCurrentOnlyGreenPointData", "setCurrentOnlyGreenPointData", "fromScanCodeButton", "", "getFromScanCodeButton", "()Z", "setFromScanCodeButton", "(Z)V", "imageKey", "", "getImageKey", "()Ljava/lang/String;", "setImageKey", "(Ljava/lang/String;)V", "imagePath", "getImagePath", "setImagePath", "originalImagePath", "getOriginalImagePath", "setOriginalImagePath", "qBarDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getQBarDataList", "()Ljava/util/ArrayList;", "setQBarDataList", "(Ljava/util/ArrayList;)V", "source", "getSource", "setSource", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "statObj", "Landroid/os/Bundle;", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "convertFrom", "", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "reset", "Companion", "app_release"})
public final class l
{
  public static final l.a WXX;
  public ArrayList<ImageQBarDataBean> WXT;
  public ImageQBarDataBean WXU;
  public ImageQBarDataBean WXV;
  public boolean WXW;
  public String fyv;
  public Bundle fyw;
  public String fyx;
  public String imagePath;
  public String source;
  public int sourceType;
  
  static
  {
    AppMethodBeat.i(270067);
    WXX = new l.a((byte)0);
    AppMethodBeat.o(270067);
  }
  
  public l()
  {
    AppMethodBeat.i(270066);
    this.WXT = new ArrayList();
    this.source = "";
    this.fyv = "";
    this.imagePath = "";
    this.fyx = "";
    AppMethodBeat.o(270066);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(270065);
    this.WXT.clear();
    this.WXU = null;
    this.WXV = null;
    AppMethodBeat.o(270065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.l
 * JD-Core Version:    0.7.0.1
 */