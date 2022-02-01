package com.tencent.mm.ui.chatting.gallery.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager;", "", "context", "Landroid/app/Activity;", "enableScan", "", "(Landroid/app/Activity;Z)V", "handleCodeCallbackListMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeHandleCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "handleCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "mNotifyDealQBarStrResultListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1;", "mScanQRCodeFailEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1;", "mScanQRCodeResultEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1;", "scanCodeCallbackListMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeCallback;", "scanCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "scanCodeResultCache", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "canUseCache", "request", "cancelHandleCode", "", "cancelScanCode", "clearScanCodeResult", "doHandleCode", "codeResult", "callback", "doScanCode", "getScanCodeResultFromCache", "handleCode", "currentImageView", "Landroid/view/View;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "isCacheValid", "result", "onHandleCodeNotifyEvent", "event", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "onScanCodeFailedWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "onScanCodeSuccessWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "release", "releaseHandleCode", "releaseScanCode", "removeScanCodeCache", "imagePath", "scanCode", "bitmap", "Landroid/graphics/Bitmap;", "getCodePosition", "recognizeType", "", "updateFailedResultCache", "key", "updateSuccessResultCache", "Companion", "ScanCodeRequest", "ScanCodeResultWrapper", "app_release"})
public final class j
{
  public static final j.a PCB;
  public final e PCA;
  public boolean PCs;
  public HashMap<String, b> PCt;
  public HashMap<String, ArrayList<h>> PCu;
  public HashMap<String, c> PCv;
  public HashMap<String, n> PCw;
  public HashMap<String, ArrayList<i>> PCx;
  public final g PCy;
  public final f PCz;
  public Activity dKq;
  
  static
  {
    AppMethodBeat.i(231272);
    PCB = new j.a((byte)0);
    AppMethodBeat.o(231272);
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(231271);
    this.PCs = true;
    this.PCt = new HashMap();
    this.PCu = new HashMap();
    this.PCv = new HashMap();
    this.PCw = new HashMap();
    this.PCx = new HashMap();
    this.PCy = new g(this);
    this.PCz = new f(this);
    this.PCA = new e(this);
    this.dKq = paramActivity;
    this.PCs = paramBoolean;
    Log.i("MicroMsg.ImageScanCodeManager", "scanCode enableScan: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.PCy.alive();
      this.PCz.alive();
      this.PCA.alive();
    }
    AppMethodBeat.o(231271);
  }
  
  private final c a(b paramb)
  {
    AppMethodBeat.i(231269);
    paramb = (c)this.PCv.get(paramb.imagePath);
    AppMethodBeat.o(231269);
    return paramb;
  }
  
  private final void a(b paramb, h paramh)
  {
    AppMethodBeat.i(231267);
    Object localObject1;
    if (paramb.PCC)
    {
      localObject1 = a(paramb);
      if ((localObject1 != null) && (a(paramb, (c)localObject1)))
      {
        Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode get result from cache %s", new Object[] { paramb.imagePath });
        if ((((c)localObject1).success) && (((c)localObject1).PCE != null))
        {
          if (paramh != null)
          {
            paramb = ((c)localObject1).PCE;
            if (paramb == null) {
              p.hyc();
            }
            paramh.b(paramb);
            AppMethodBeat.o(231267);
            return;
          }
          AppMethodBeat.o(231267);
          return;
        }
        if ((!((c)localObject1).success) && (((c)localObject1).PCF != null))
        {
          if (paramh != null)
          {
            paramb = ((c)localObject1).PCF;
            if (paramb == null) {
              p.hyc();
            }
            paramh.b(paramb);
            AppMethodBeat.o(231267);
            return;
          }
          AppMethodBeat.o(231267);
          return;
        }
        bnd(paramb.imagePath);
      }
    }
    if (!Util.isNullOrNil(paramb.imagePath))
    {
      localObject1 = paramb.imagePath;
      if (!this.PCu.containsKey(localObject1)) {
        ((Map)this.PCu).put(localObject1, new ArrayList());
      }
      Object localObject2 = this.PCu.get(localObject1);
      if (localObject2 == null) {
        p.hyc();
      }
      if (!((ArrayList)localObject2).contains(paramh))
      {
        localObject2 = this.PCu.get(localObject1);
        if (localObject2 == null) {
          p.hyc();
        }
        ((ArrayList)localObject2).add(paramh);
      }
      if (this.PCt.containsKey(localObject1))
      {
        Log.w("MicroMsg.ImageScanCodeManager", "alvinluo scanCode image %s is already decoding and ignore", new Object[] { paramb.imagePath });
        AppMethodBeat.o(231267);
        return;
      }
      ((Map)this.PCt).put(localObject1, paramb);
      paramh = new qx();
      paramh.dXu.dDZ = paramb.dDZ;
      paramh.dXu.filePath = paramb.imagePath;
      paramh.dXu.bitmap = paramb.bitmap;
      paramh.dXu.dXw = paramb.PCC;
      paramh.dXu.dXx = paramb.dXx;
      EventCenter.instance.publish((IEvent)paramh);
    }
    AppMethodBeat.o(231267);
  }
  
  private static boolean a(b paramb, c paramc)
  {
    AppMethodBeat.i(231268);
    Log.d("MicroMsg.ImageScanCodeManager", "alvinluo isCacheValid request.getCodePosition: " + paramb.PCC + ", request.isVerticalLong: " + paramb.PCD + ", request.bitmap: " + paramb.bitmap + ", result.isVerticalLong: " + paramc.PCD);
    if ((paramb.PCC) && (paramb.PCD) && (paramb.bitmap != null))
    {
      bool = paramc.PCD;
      AppMethodBeat.o(231268);
      return bool;
    }
    boolean bool = paramb.PCC;
    AppMethodBeat.o(231268);
    return bool;
  }
  
  private final void bnd(String paramString)
  {
    AppMethodBeat.i(231270);
    this.PCv.remove(paramString);
    AppMethodBeat.o(231270);
  }
  
  public final void a(View paramView, String paramString, Bitmap paramBitmap, boolean paramBoolean, int paramInt, h paramh)
  {
    AppMethodBeat.i(231266);
    if (!this.PCs)
    {
      AppMethodBeat.o(231266);
      return;
    }
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(231266);
      return;
    }
    localObject = new b();
    ((b)localObject).dDZ = System.currentTimeMillis();
    ((b)localObject).setImagePath(paramString);
    ((b)localObject).bitmap = paramBitmap;
    ((b)localObject).PCC = paramBoolean;
    ((b)localObject).dXx = paramInt;
    ((b)localObject).PCD = false;
    Log.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode session: %d, imagePath: %s, bitmap: %s, getCodePosition: %b", new Object[] { Long.valueOf(((b)localObject).dDZ), paramString, paramBitmap, Boolean.valueOf(paramBoolean) });
    int j;
    int k;
    if ((paramView instanceof g))
    {
      paramInt = ((g)paramView).getImageWidth();
      i = ((g)paramView).getImageHeight();
      j = a.jn((Context)this.dKq);
      k = a.jo((Context)this.dKq);
      if (1.0F * i / paramInt < 2.0F * k / j) {
        break label346;
      }
    }
    label346:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((b)localObject).PCD = paramBoolean;
      Log.d("MicroMsg.ImageScanCodeManager", "alvinluo scanCode imageSize: %d, %d, screen: %d, %d, current: %s, verticalLong: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramView, Boolean.valueOf(((b)localObject).PCD) });
      if ((paramBitmap == null) || (!(paramView instanceof g)) || (!((b)localObject).PCD)) {
        break;
      }
      ((b)localObject).bitmap = o.j(paramBitmap, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      a((b)localObject, paramh);
      AppMethodBeat.o(231266);
      return;
    }
    ((b)localObject).bitmap = null;
    a((b)localObject, paramh);
    AppMethodBeat.o(231266);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getCodePosition", "", "getGetCodePosition", "()Z", "setGetCodePosition", "(Z)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "isVerticalLong", "setVerticalLong", "recognizeType", "", "getRecognizeType", "()I", "setRecognizeType", "(I)V", "session", "", "getSession", "()J", "setSession", "(J)V", "app_release"})
  public static final class b
  {
    boolean PCC;
    boolean PCD;
    Bitmap bitmap;
    public long dDZ;
    int dXx;
    String imagePath = "";
    
    public final void setImagePath(String paramString)
    {
      AppMethodBeat.i(231261);
      p.h(paramString, "<set-?>");
      this.imagePath = paramString;
      AppMethodBeat.o(231261);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "", "()V", "failedResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "getFailedResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "setFailedResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;)V", "isVerticalLong", "", "()Z", "setVerticalLong", "(Z)V", "success", "getSuccess", "setSuccess", "successResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getSuccessResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "setSuccessResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;)V", "app_release"})
  static final class c
  {
    boolean PCD;
    qz PCE;
    qy PCF;
    boolean success;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$handleCode$codeHandler$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "handleCode", "", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "app_release"})
  public static final class d
    implements d
  {
    public d(i parami) {}
    
    public final void a(n paramn)
    {
      AppMethodBeat.i(231262);
      p.h(paramn, "codeResult");
      j.a(this.PCG, paramn, this.PCH);
      AppMethodBeat.o(231262);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "callback", "", "event", "app_release"})
  public static final class e
    extends IListener<np>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "callback", "", "event", "app_release"})
  public static final class f
    extends IListener<qy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "app_release"})
  public static final class g
    extends IListener<qz>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.j
 * JD-Core Version:    0.7.0.1
 */