package com.tencent.mm.ui.chatting.gallery.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.g;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager;", "", "context", "Landroid/app/Activity;", "enableScan", "", "(Landroid/app/Activity;Z)V", "handleCodeCallbackListMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeHandleCallback;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "handleCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "mNotifyDealQBarStrResultListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1;", "mScanQRCodeFailEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1;", "mScanQRCodeResultEventListener", "com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1;", "scanCodeCallbackListMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeCallback;", "scanCodeRequestMap", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "scanCodeResultCache", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "canUseCache", "request", "cancelHandleCode", "", "cancelScanCode", "clearScanCodeResult", "doHandleCode", "codeResult", "callback", "doScanCode", "getScanCodeResultFromCache", "handleCode", "currentImageView", "Landroid/view/View;", "viewModel", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeViewModel;", "isCacheValid", "result", "onHandleCodeNotifyEvent", "event", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "onScanCodeFailedWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "onScanCodeSuccessWrapper", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "release", "releaseHandleCode", "releaseScanCode", "removeScanCodeCache", "imagePath", "scanCode", "bitmap", "Landroid/graphics/Bitmap;", "getCodePosition", "recognizeType", "", "updateFailedResultCache", "key", "updateSuccessResultCache", "Companion", "ScanCodeRequest", "ScanCodeResultWrapper", "app_release"})
public final class j
{
  public static final j.a Kqs;
  public boolean Kqj;
  public HashMap<String, b> Kqk;
  public HashMap<String, ArrayList<h>> Kql;
  public HashMap<String, c> Kqm;
  public HashMap<String, n> Kqn;
  public HashMap<String, ArrayList<i>> Kqo;
  public final g Kqp;
  public final f Kqq;
  public final e Kqr;
  public Activity dtg;
  
  static
  {
    AppMethodBeat.i(188320);
    Kqs = new j.a((byte)0);
    AppMethodBeat.o(188320);
  }
  
  public j(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(188319);
    this.Kqj = true;
    this.Kqk = new HashMap();
    this.Kql = new HashMap();
    this.Kqm = new HashMap();
    this.Kqn = new HashMap();
    this.Kqo = new HashMap();
    this.Kqp = new g(this);
    this.Kqq = new f(this);
    this.Kqr = new e(this);
    this.dtg = paramActivity;
    this.Kqj = paramBoolean;
    ae.i("MicroMsg.ImageScanCodeManager", "scanCode enableScan: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.Kqp.alive();
      this.Kqq.alive();
      this.Kqr.alive();
    }
    AppMethodBeat.o(188319);
  }
  
  private final c a(b paramb)
  {
    AppMethodBeat.i(188317);
    paramb = (c)this.Kqm.get(paramb.imagePath);
    AppMethodBeat.o(188317);
    return paramb;
  }
  
  private final void a(b paramb, h paramh)
  {
    AppMethodBeat.i(188315);
    Object localObject1;
    if (paramb.Kqt)
    {
      localObject1 = a(paramb);
      if ((localObject1 != null) && (a(paramb, (c)localObject1)))
      {
        ae.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode get result from cache %s", new Object[] { paramb.imagePath });
        if ((((c)localObject1).success) && (((c)localObject1).Kqv != null))
        {
          if (paramh != null)
          {
            paramb = ((c)localObject1).Kqv;
            if (paramb == null) {
              p.gkB();
            }
            paramh.b(paramb);
            AppMethodBeat.o(188315);
            return;
          }
          AppMethodBeat.o(188315);
          return;
        }
        if ((!((c)localObject1).success) && (((c)localObject1).Kqw != null))
        {
          if (paramh != null)
          {
            paramb = ((c)localObject1).Kqw;
            if (paramb == null) {
              p.gkB();
            }
            paramh.b(paramb);
            AppMethodBeat.o(188315);
            return;
          }
          AppMethodBeat.o(188315);
          return;
        }
        aXY(paramb.imagePath);
      }
    }
    if (!bu.isNullOrNil(paramb.imagePath))
    {
      localObject1 = paramb.imagePath;
      if (!this.Kql.containsKey(localObject1)) {
        ((Map)this.Kql).put(localObject1, new ArrayList());
      }
      Object localObject2 = this.Kql.get(localObject1);
      if (localObject2 == null) {
        p.gkB();
      }
      if (!((ArrayList)localObject2).contains(paramh))
      {
        localObject2 = this.Kql.get(localObject1);
        if (localObject2 == null) {
          p.gkB();
        }
        ((ArrayList)localObject2).add(paramh);
      }
      if (this.Kqk.containsKey(localObject1))
      {
        ae.w("MicroMsg.ImageScanCodeManager", "alvinluo scanCode image %s is already decoding and ignore", new Object[] { paramb.imagePath });
        AppMethodBeat.o(188315);
        return;
      }
      ((Map)this.Kqk).put(localObject1, paramb);
      paramh = new qd();
      paramh.dFH.dmK = paramb.dmK;
      paramh.dFH.filePath = paramb.imagePath;
      paramh.dFH.bitmap = paramb.bitmap;
      paramh.dFH.dFJ = paramb.Kqt;
      paramh.dFH.dFK = paramb.dFK;
      com.tencent.mm.sdk.b.a.IvT.l((b)paramh);
    }
    AppMethodBeat.o(188315);
  }
  
  private static boolean a(b paramb, c paramc)
  {
    AppMethodBeat.i(188316);
    ae.d("MicroMsg.ImageScanCodeManager", "alvinluo isCacheValid request.getCodePosition: " + paramb.Kqt + ", request.isVerticalLong: " + paramb.Kqu + ", request.bitmap: " + paramb.bitmap + ", result.isVerticalLong: " + paramc.Kqu);
    if ((paramb.Kqt) && (paramb.Kqu) && (paramb.bitmap != null))
    {
      bool = paramc.Kqu;
      AppMethodBeat.o(188316);
      return bool;
    }
    boolean bool = paramb.Kqt;
    AppMethodBeat.o(188316);
    return bool;
  }
  
  private final void aXY(String paramString)
  {
    AppMethodBeat.i(188318);
    this.Kqm.remove(paramString);
    AppMethodBeat.o(188318);
  }
  
  public final void a(View paramView, String paramString, Bitmap paramBitmap, boolean paramBoolean, int paramInt, h paramh)
  {
    AppMethodBeat.i(188314);
    if (!this.Kqj)
    {
      AppMethodBeat.o(188314);
      return;
    }
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(188314);
      return;
    }
    localObject = new b();
    ((b)localObject).dmK = System.currentTimeMillis();
    ((b)localObject).setImagePath(paramString);
    ((b)localObject).bitmap = paramBitmap;
    ((b)localObject).Kqt = paramBoolean;
    ((b)localObject).dFK = paramInt;
    ((b)localObject).Kqu = false;
    ae.i("MicroMsg.ImageScanCodeManager", "alvinluo scanCode session: %d, imagePath: %s, bitmap: %s, getCodePosition: %b", new Object[] { Long.valueOf(((b)localObject).dmK), paramString, paramBitmap, Boolean.valueOf(paramBoolean) });
    int j;
    int k;
    if ((paramView instanceof g))
    {
      paramInt = ((g)paramView).getImageWidth();
      i = ((g)paramView).getImageHeight();
      j = com.tencent.mm.cb.a.iu((Context)this.dtg);
      k = com.tencent.mm.cb.a.iv((Context)this.dtg);
      if (1.0F * i / paramInt < 2.0F * k / j) {
        break label346;
      }
    }
    label346:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((b)localObject).Kqu = paramBoolean;
      ae.d("MicroMsg.ImageScanCodeManager", "alvinluo scanCode imageSize: %d, %d, screen: %d, %d, current: %s, verticalLong: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), paramView, Boolean.valueOf(((b)localObject).Kqu) });
      if ((paramBitmap == null) || (!(paramView instanceof g)) || (!((b)localObject).Kqu)) {
        break;
      }
      ((b)localObject).bitmap = o.i(paramBitmap, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      a((b)localObject, paramh);
      AppMethodBeat.o(188314);
      return;
    }
    ((b)localObject).bitmap = null;
    a((b)localObject, paramh);
    AppMethodBeat.o(188314);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeRequest;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getCodePosition", "", "getGetCodePosition", "()Z", "setGetCodePosition", "(Z)V", "imagePath", "", "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "isVerticalLong", "setVerticalLong", "recognizeType", "", "getRecognizeType", "()I", "setRecognizeType", "(I)V", "session", "", "getSession", "()J", "setSession", "(J)V", "app_release"})
  public static final class b
  {
    boolean Kqt;
    boolean Kqu;
    Bitmap bitmap;
    int dFK;
    public long dmK;
    String imagePath = "";
    
    public final void setImagePath(String paramString)
    {
      AppMethodBeat.i(188309);
      p.h(paramString, "<set-?>");
      this.imagePath = paramString;
      AppMethodBeat.o(188309);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$ScanCodeResultWrapper;", "", "()V", "failedResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "getFailedResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "setFailedResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;)V", "isVerticalLong", "", "()Z", "setVerticalLong", "(Z)V", "success", "getSuccess", "setSuccess", "successResult", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "getSuccessResult", "()Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "setSuccessResult", "(Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;)V", "app_release"})
  static final class c
  {
    boolean Kqu;
    qf Kqv;
    qe Kqw;
    boolean success;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$handleCode$codeHandler$1", "Lcom/tencent/mm/ui/chatting/gallery/scan/IImageScanCodeHandler;", "handleCode", "", "codeResult", "Lcom/tencent/mm/ui/chatting/gallery/scan/ScanCodeResult;", "app_release"})
  public static final class d
    implements d
  {
    public d(i parami) {}
    
    public final void a(n paramn)
    {
      AppMethodBeat.i(188310);
      p.h(paramn, "codeResult");
      j.a(this.Kqx, paramn, this.Kqy);
      AppMethodBeat.o(188310);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mNotifyDealQBarStrResultListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/NotifyDealQBarStrResultEvent;", "callback", "", "event", "app_release"})
  public static final class e
    extends c<my>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeFailEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileFailedEvent;", "callback", "", "event", "app_release"})
  public static final class f
    extends c<qe>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/ui/chatting/gallery/scan/ImageScanCodeManager$mScanQRCodeResultEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RecogQBarOfImageFileResultEvent;", "callback", "", "event", "app_release"})
  public static final class g
    extends c<qf>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.j
 * JD-Core Version:    0.7.0.1
 */