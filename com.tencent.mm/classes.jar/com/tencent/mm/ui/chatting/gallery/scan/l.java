package com.tencent.mm.ui.chatting.gallery.scan;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "", "()V", "currentFetchInfoData", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "getCurrentFetchInfoData", "()Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "setCurrentFetchInfoData", "(Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;)V", "currentOnlyGreenPointData", "getCurrentOnlyGreenPointData", "setCurrentOnlyGreenPointData", "fromScanCodeButton", "", "getFromScanCodeButton", "()Z", "setFromScanCodeButton", "(Z)V", "imageKey", "", "getImageKey", "()Ljava/lang/String;", "setImageKey", "(Ljava/lang/String;)V", "imagePath", "getImagePath", "setImagePath", "originalImagePath", "getOriginalImagePath", "setOriginalImagePath", "qBarDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getQBarDataList", "()Ljava/util/ArrayList;", "setQBarDataList", "(Ljava/util/ArrayList;)V", "source", "getSource", "setSource", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "statObj", "Landroid/os/Bundle;", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", "convertFrom", "", "event", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "reset", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a aeHq;
  public ArrayList<ImageQBarDataBean> aeHr;
  public ImageQBarDataBean aeHs;
  public ImageQBarDataBean aeHt;
  public boolean aeHu;
  public String hDe;
  public Bundle hDf;
  public String hDg;
  public String imagePath;
  public String source;
  public int sourceType;
  
  static
  {
    AppMethodBeat.i(254834);
    aeHq = new l.a((byte)0);
    AppMethodBeat.o(254834);
  }
  
  public l()
  {
    AppMethodBeat.i(254830);
    this.aeHr = new ArrayList();
    this.source = "";
    this.hDe = "";
    this.imagePath = "";
    this.hDg = "";
    AppMethodBeat.o(254830);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(254840);
    this.aeHr.clear();
    this.aeHs = null;
    this.aeHt = null;
    AppMethodBeat.o(254840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.l
 * JD-Core Version:    0.7.0.1
 */