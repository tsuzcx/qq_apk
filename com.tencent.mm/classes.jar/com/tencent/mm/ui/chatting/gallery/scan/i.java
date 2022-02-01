package com.tencent.mm.ui.chatting.gallery.scan;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager;", "", "context", "Landroid/app/Activity;", "enableScan", "", "(Landroid/app/Activity;Z)V", "handleCodeCallbackListMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeHandleCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "handleCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "mNotifyDealQBarStrResultListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1;", "mScanQRCodeFailEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1;", "mScanQRCodeResultEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1;", "scanCodeCallbackListMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeCallback;", "scanCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "scanCodeResultCache", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "canUseCache", "request", "cancelHandleCode", "", "cancelScanCode", "clearScanCodeResult", "doHandleCode", "codeResult", "codePointInfo", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "callback", "doScanCode", "getScanCodeResultFromCache", "handleCode", "currentImageView", "Landroid/view/View;", "handleListener", "Lcom/tencent/mm/plugin/scanner/ImageCodeHandleListener;", "onHandleCodeNotifyEvent", "event", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "onScanCodeFailedWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "onScanCodeSuccessWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "release", "releaseHandleCode", "releaseScanCode", "removeScanCodeCache", "imagePath", "scanCode", "bitmap", "Landroid/graphics/Bitmap;", "getCodePosition", "recognizeType", "", "updateFailedResultCache", "key", "updateSuccessResultCache", "Companion", "ScanCodeRequest", "ScanCodeResultWrapper", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a aeGQ;
  public boolean aeGR;
  public HashMap<String, b> aeGS;
  public HashMap<String, ArrayList<g>> aeGT;
  public HashMap<String, c> aeGU;
  public HashMap<String, l> aeGV;
  public HashMap<String, ArrayList<h>> aeGW;
  public final ImageScanCodeManager.mScanQRCodeResultEventListener.1 aeGX;
  public final ImageScanCodeManager.mScanQRCodeFailEventListener.1 aeGY;
  public final ImageScanCodeManager.mNotifyDealQBarStrResultListener.1 aeGZ;
  public Activity hHU;
  
  static
  {
    AppMethodBeat.i(254884);
    aeGQ = new i.a((byte)0);
    AppMethodBeat.o(254884);
  }
  
  public i(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(254849);
    this.aeGR = true;
    this.aeGS = new HashMap();
    this.aeGT = new HashMap();
    this.aeGU = new HashMap();
    this.aeGV = new HashMap();
    this.aeGW = new HashMap();
    this.aeGX = new ImageScanCodeManager.mScanQRCodeResultEventListener.1(this, f.hfK);
    this.aeGY = new ImageScanCodeManager.mScanQRCodeFailEventListener.1(this, f.hfK);
    this.aeGZ = new ImageScanCodeManager.mNotifyDealQBarStrResultListener.1(this, f.hfK);
    this.hHU = paramActivity;
    this.aeGR = paramBoolean;
    Log.i("MicroMsg.ImageScanCodeManager", "scanCode enableScan: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.aeGX.alive();
      this.aeGY.alive();
      this.aeGZ.alive();
    }
    AppMethodBeat.o(254849);
  }
  
  public static boolean a(b paramb)
  {
    if ((paramb != null) && (paramb.hXg == 1)) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return false;
  }
  
  public final void a(l paraml, ImageQBarDataBean paramImageQBarDataBean, h paramh)
  {
    AppMethodBeat.i(254890);
    s.u(paraml, "codeResult");
    s.u(paramImageQBarDataBean, "codePointInfo");
    String str = paramImageQBarDataBean.OGQ;
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      if (!this.aeGW.containsKey(str)) {
        ((Map)this.aeGW).put(str, new ArrayList());
      }
      Object localObject = this.aeGW.get(str);
      s.checkNotNull(localObject);
      if (!((ArrayList)localObject).contains(paramh))
      {
        localObject = this.aeGW.get(str);
        s.checkNotNull(localObject);
        ((ArrayList)localObject).add(paramh);
      }
      ((Map)this.aeGV).put(str, paraml);
      paramh = new df();
      paramh.hDa.activity = this.hHU;
      paramh.hDa.hBi = paramImageQBarDataBean.OGQ;
      paramh.hDa.hDb = paramImageQBarDataBean.hDb;
      paramh.hDa.hDc = paramImageQBarDataBean.hDc;
      paramh.hDa.scene = 37;
      paramh.hDa.source = paraml.source;
      paramh.hDa.sourceType = paraml.sourceType;
      paramh.hDa.hDe = paraml.hDe;
      paramh.hDa.imagePath = paraml.imagePath;
      paramh.hDa.hDf = paraml.hDf;
      paramh.hDa.hDg = paraml.hDg;
      paramh.publish();
      AppMethodBeat.o(254890);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "recognizeType", "", "getRecognizeType", "()I", "setRecognizeType", "(I)V", "session", "", "getSession", "()J", "setSession", "(J)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public Bitmap bitmap;
    public long hBk;
    public int hXg;
    public String imagePath = "";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "", "()V", "failedResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "getFailedResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "setFailedResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "successResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getSuccessResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "setSuccessResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public to aeHa;
    public tn aeHb;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.i
 * JD-Core Version:    0.7.0.1
 */