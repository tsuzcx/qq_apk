package com.tencent.mm.ui.chatting.gallery.a;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager;", "", "context", "Landroid/app/Activity;", "enableScan", "", "(Landroid/app/Activity;Z)V", "handleCodeCallbackListMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeHandleCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "handleCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "mNotifyDealQBarStrResultListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1;", "mScanQRCodeFailEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1;", "mScanQRCodeResultEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1;", "scanCodeCallbackListMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeCallback;", "scanCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "scanCodeResultCache", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "canUseCache", "request", "cancelHandleCode", "", "cancelScanCode", "clearScanCodeResult", "doHandleCode", "codeResult", "codePointInfo", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "callback", "doScanCode", "getScanCodeResultFromCache", "handleCode", "currentImageView", "Landroid/view/View;", "handleListener", "Lcom/tencent/mm/plugin/scanner/ImageCodeHandleListener;", "onHandleCodeNotifyEvent", "event", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "onScanCodeFailedWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "onScanCodeSuccessWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "release", "releaseHandleCode", "releaseScanCode", "removeScanCodeCache", "imagePath", "scanCode", "bitmap", "Landroid/graphics/Bitmap;", "getCodePosition", "recognizeType", "", "updateFailedResultCache", "key", "updateSuccessResultCache", "Companion", "ScanCodeRequest", "ScanCodeResultWrapper", "app_release"})
public final class i
{
  public static final i.a WXx;
  public boolean WXo;
  public HashMap<String, b> WXp;
  public HashMap<String, ArrayList<g>> WXq;
  public HashMap<String, c> WXr;
  public HashMap<String, l> WXs;
  public HashMap<String, ArrayList<h>> WXt;
  public final f WXu;
  public final e WXv;
  public final d WXw;
  public Activity fDf;
  
  static
  {
    AppMethodBeat.i(279049);
    WXx = new i.a((byte)0);
    AppMethodBeat.o(279049);
  }
  
  public i(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(279048);
    this.WXo = true;
    this.WXp = new HashMap();
    this.WXq = new HashMap();
    this.WXr = new HashMap();
    this.WXs = new HashMap();
    this.WXt = new HashMap();
    this.WXu = new f(this);
    this.WXv = new e(this);
    this.WXw = new d(this);
    this.fDf = paramActivity;
    this.WXo = paramBoolean;
    Log.i("MicroMsg.ImageScanCodeManager", "scanCode enableScan: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.WXu.alive();
      this.WXv.alive();
      this.WXw.alive();
    }
    AppMethodBeat.o(279048);
  }
  
  public static boolean a(b paramb)
  {
    return (paramb != null) && (paramb.fRj == 1);
  }
  
  public final void a(l paraml, ImageQBarDataBean paramImageQBarDataBean, h paramh)
  {
    AppMethodBeat.i(279047);
    p.k(paraml, "codeResult");
    p.k(paramImageQBarDataBean, "codePointInfo");
    String str = paramImageQBarDataBean.IAH;
    if (str == null) {
      str = "";
    }
    for (;;)
    {
      if (!this.WXt.containsKey(str)) {
        ((Map)this.WXt).put(str, new ArrayList());
      }
      Object localObject = this.WXt.get(str);
      if (localObject == null) {
        p.iCn();
      }
      if (!((ArrayList)localObject).contains(paramh))
      {
        localObject = this.WXt.get(str);
        if (localObject == null) {
          p.iCn();
        }
        ((ArrayList)localObject).add(paramh);
      }
      ((Map)this.WXs).put(str, paraml);
      paramh = new cv();
      paramh.fyr.activity = this.fDf;
      paramh.fyr.fwI = paramImageQBarDataBean.IAH;
      paramh.fyr.fys = paramImageQBarDataBean.fys;
      paramh.fyr.fyt = paramImageQBarDataBean.fyt;
      paramh.fyr.scene = 37;
      paramh.fyr.source = paraml.source;
      paramh.fyr.sourceType = paraml.sourceType;
      paramh.fyr.fyv = paraml.fyv;
      paramh.fyr.imagePath = paraml.imagePath;
      paramh.fyr.fyw = paraml.fyw;
      paramh.fyr.fyx = paraml.fyx;
      EventCenter.instance.publish((IEvent)paramh);
      AppMethodBeat.o(279047);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "recognizeType", "", "getRecognizeType", "()I", "setRecognizeType", "(I)V", "session", "", "getSession", "()J", "setSession", "(J)V", "app_release"})
  public static final class b
  {
    public Bitmap bitmap;
    public int fRj;
    public long fwK;
    public String imagePath = "";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "", "()V", "failedResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "getFailedResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "setFailedResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "successResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getSuccessResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "setSuccessResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;)V", "app_release"})
  public static final class c
  {
    public rz WXy;
    public ry WXz;
    public boolean success;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "callback", "", "event", "app_release"})
  public static final class d
    extends IListener<ol>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "callback", "", "event", "app_release"})
  public static final class e
    extends IListener<ry>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "app_release"})
  public static final class f
    extends IListener<rz>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.i
 * JD-Core Version:    0.7.0.1
 */