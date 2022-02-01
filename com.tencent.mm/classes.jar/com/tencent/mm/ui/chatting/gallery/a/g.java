package com.tencent.mm.ui.chatting.gallery.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager;", "", "context", "Landroid/app/Activity;", "enableScan", "", "(Landroid/app/Activity;Z)V", "handleCodeCallbackListMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeHandleCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "handleCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "mNotifyDealQBarStrResultListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1;", "mScanQRCodeFailEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1;", "mScanQRCodeResultEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1;", "scanCodeCallbackListMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeCallback;", "scanCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "scanCodeResultCache", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "canUseCache", "request", "cancelHandleCode", "", "cancelScanCode", "clearScanCodeResult", "doHandleCode", "codeResult", "callback", "doScanCode", "getScanCodeResultFromCache", "handleCode", "currentImageView", "Landroid/view/View;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "isCacheValid", "result", "onHandleCodeNotifyEvent", "event", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "onScanCodeFailedWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "onScanCodeSuccessWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "release", "releaseHandleCode", "releaseScanCode", "removeScanCodeCache", "imagePath", "scanCode", "bitmap", "Landroid/graphics/Bitmap;", "getCodePosition", "recognizeType", "", "updateFailedResultCache", "key", "updateSuccessResultCache", "Companion", "ScanCodeRequest", "ScanCodeResultWrapper", "app_release"})
public final class g
{
  public static final g.a JUF;
  public HashMap<String, i> JUA;
  public HashMap<String, ArrayList<f>> JUB;
  public final g JUC;
  public final f JUD;
  public final e JUE;
  public boolean JUw;
  public HashMap<String, b> JUx;
  public HashMap<String, ArrayList<d>> JUy;
  public HashMap<String, c> JUz;
  public Activity dsa;
  
  static
  {
    AppMethodBeat.i(194903);
    JUF = new g.a((byte)0);
    AppMethodBeat.o(194903);
  }
  
  public g(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(194902);
    this.JUw = true;
    this.JUx = new HashMap();
    this.JUy = new HashMap();
    this.JUz = new HashMap();
    this.JUA = new HashMap();
    this.JUB = new HashMap();
    this.JUC = new g(this);
    this.JUD = new f(this);
    this.JUE = new e(this);
    this.dsa = paramActivity;
    this.JUw = paramBoolean;
    ad.i("MicroMsg.ImageScanCodeManager", "scanCode enableScan: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.JUC.alive();
      this.JUD.alive();
      this.JUE.alive();
    }
    AppMethodBeat.o(194902);
  }
  
  private final c a(b paramb)
  {
    AppMethodBeat.i(194900);
    paramb = (c)this.JUz.get(paramb.imagePath);
    AppMethodBeat.o(194900);
    return paramb;
  }
  
  private final void a(b paramb, d paramd)
  {
    AppMethodBeat.i(194898);
    Object localObject1;
    if (paramb.JUG)
    {
      localObject1 = a(paramb);
      if ((localObject1 != null) && (a(paramb, (c)localObject1)))
      {
        ad.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode get result from cache %s", new Object[] { paramb.imagePath });
        if ((((c)localObject1).success) && (((c)localObject1).JUI != null))
        {
          if (paramd != null)
          {
            paramb = ((c)localObject1).JUI;
            if (paramb == null) {
              p.gfZ();
            }
            paramd.b(paramb);
            AppMethodBeat.o(194898);
            return;
          }
          AppMethodBeat.o(194898);
          return;
        }
        if ((!((c)localObject1).success) && (((c)localObject1).JUJ != null))
        {
          if (paramd != null)
          {
            paramb = ((c)localObject1).JUJ;
            if (paramb == null) {
              p.gfZ();
            }
            paramd.b(paramb);
            AppMethodBeat.o(194898);
            return;
          }
          AppMethodBeat.o(194898);
          return;
        }
        aWw(paramb.imagePath);
      }
    }
    if (!bt.isNullOrNil(paramb.imagePath))
    {
      localObject1 = paramb.imagePath;
      if (!this.JUy.containsKey(localObject1)) {
        ((Map)this.JUy).put(localObject1, new ArrayList());
      }
      Object localObject2 = this.JUy.get(localObject1);
      if (localObject2 == null) {
        p.gfZ();
      }
      if (!((ArrayList)localObject2).contains(paramd))
      {
        localObject2 = this.JUy.get(localObject1);
        if (localObject2 == null) {
          p.gfZ();
        }
        ((ArrayList)localObject2).add(paramd);
      }
      if (this.JUx.containsKey(localObject1))
      {
        ad.w("MicroMsg.ImageScanCodeManager", "alvinluo scanCode image %s is already decoding and ignore", new Object[] { paramb.imagePath });
        AppMethodBeat.o(194898);
        return;
      }
      ((Map)this.JUx).put(localObject1, paramb);
      paramd = new qc();
      paramd.dEC.dlI = paramb.dlI;
      paramd.dEC.filePath = paramb.imagePath;
      paramd.dEC.bitmap = paramb.bitmap;
      paramd.dEC.dEE = paramb.JUG;
      paramd.dEC.dEF = paramb.dEF;
      com.tencent.mm.sdk.b.a.IbL.l((b)paramd);
    }
    AppMethodBeat.o(194898);
  }
  
  private static boolean a(b paramb, c paramc)
  {
    AppMethodBeat.i(194899);
    ad.d("MicroMsg.ImageScanCodeManager", "alvinluo isCacheValid request.getCodePosition: " + paramb.JUG + ", request.isVerticalLong: " + paramb.JUH + ", request.bitmap: " + paramb.bitmap + ", result.isVerticalLong: " + paramc.JUH);
    if ((paramb.JUG) && (paramb.JUH) && (paramb.bitmap != null))
    {
      bool = paramc.JUH;
      AppMethodBeat.o(194899);
      return bool;
    }
    boolean bool = paramb.JUG;
    AppMethodBeat.o(194899);
    return bool;
  }
  
  private final void aWw(String paramString)
  {
    AppMethodBeat.i(194901);
    this.JUz.remove(paramString);
    AppMethodBeat.o(194901);
  }
  
  public final void a(View paramView, String paramString, Bitmap paramBitmap, boolean paramBoolean, int paramInt, d paramd)
  {
    AppMethodBeat.i(194897);
    if (!this.JUw)
    {
      AppMethodBeat.o(194897);
      return;
    }
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(194897);
      return;
    }
    localObject = new b();
    ((b)localObject).dlI = System.currentTimeMillis();
    ((b)localObject).setImagePath(paramString);
    ((b)localObject).bitmap = paramBitmap;
    ((b)localObject).JUG = paramBoolean;
    ((b)localObject).dEF = paramInt;
    ((b)localObject).JUH = false;
    ad.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode session: %d, imagePath: %s, bitmap: %s, getCodePosition: %b", new Object[] { Long.valueOf(((b)localObject).dlI), paramString, paramBitmap, Boolean.valueOf(paramBoolean) });
    int j;
    int k;
    if ((paramView instanceof com.tencent.mm.ui.base.g))
    {
      paramInt = ((com.tencent.mm.ui.base.g)paramView).getImageWidth();
      i = ((com.tencent.mm.ui.base.g)paramView).getImageHeight();
      j = com.tencent.mm.cc.a.ip((Context)this.dsa);
      k = com.tencent.mm.cc.a.iq((Context)this.dsa);
      if (1.0F * i / paramInt < 2.0F * k / j) {
        break label346;
      }
    }
    label346:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((b)localObject).JUH = paramBoolean;
      ad.d("MicroMsg.ImageScanCodeManager", "alvinluo scanCode imageSize: %d, %d, screen: %d, %d, current: %s, verticalLong: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramView, Boolean.valueOf(((b)localObject).JUH) });
      if ((paramBitmap == null) || (!(paramView instanceof com.tencent.mm.ui.base.g)) || (!((b)localObject).JUH)) {
        break;
      }
      ((b)localObject).bitmap = j.i(paramBitmap, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      a((b)localObject, paramd);
      AppMethodBeat.o(194897);
      return;
    }
    ((b)localObject).bitmap = null;
    a((b)localObject, paramd);
    AppMethodBeat.o(194897);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getCodePosition", "", "getGetCodePosition", "()Z", "setGetCodePosition", "(Z)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "isVerticalLong", "setVerticalLong", "recognizeType", "", "getRecognizeType", "()I", "setRecognizeType", "(I)V", "session", "", "getSession", "()J", "setSession", "(J)V", "app_release"})
  public static final class b
  {
    boolean JUG;
    boolean JUH;
    Bitmap bitmap;
    int dEF;
    public long dlI;
    String imagePath = "";
    
    public final void setImagePath(String paramString)
    {
      AppMethodBeat.i(194892);
      p.h(paramString, "<set-?>");
      this.imagePath = paramString;
      AppMethodBeat.o(194892);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "", "()V", "failedResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "getFailedResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "setFailedResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;)V", "isVerticalLong", "", "()Z", "setVerticalLong", "(Z)V", "success", "getSuccess", "setSuccess", "successResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getSuccessResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "setSuccessResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;)V", "app_release"})
  static final class c
  {
    boolean JUH;
    qe JUI;
    qd JUJ;
    boolean success;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$handleCode$codeHandler$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "handleCode", "", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "app_release"})
  public static final class d
    implements a
  {
    public d(f paramf) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(194893);
      p.h(parami, "codeResult");
      g.a(this.JUK, parami, this.JUL);
      AppMethodBeat.o(194893);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "callback", "", "event", "app_release"})
  public static final class e
    extends c<mx>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "callback", "", "event", "app_release"})
  public static final class f
    extends c<qd>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "app_release"})
  public static final class g
    extends c<qe>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.g
 * JD-Core Version:    0.7.0.1
 */