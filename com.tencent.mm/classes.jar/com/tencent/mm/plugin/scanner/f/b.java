package com.tencent.mm.plugin.scanner.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.a.a;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.box.i;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.WxImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "context", "Landroid/content/Context;", "scene", "", "(Landroid/content/Context;I)V", "backgroundOpListener", "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1;", "backgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "currentImageView", "Landroid/view/View;", "dialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "gallery", "Lcom/tencent/mm/ui/base/MMViewPager;", "imageZoomHelper", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper;", "isTouchHandledByBackground", "", "isUploadFinish", "mBackgroundTouchListener", "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1;", "mBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "mBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRResultDialogMoveListener;", "mImageOCRListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "mOcrResultCallback", "Lcom/tencent/mm/plugin/scanner/api/ocr/ImageOcrResultCallback;", "onScaleChangedListener", "Lcom/tencent/mm/ui/base/IZoomableImageView$ZoomScaleChangedListener;", "showParams", "Lcom/tencent/mm/plugin/scanner/api/ScanBoxDialogShowParams;", "uploadSessionId", "", "attachGallery", "", "attachImageView", "image", "cancelImageOCR", "sessionId", "checkNetWorkConnected", "getAnimationType", "isLandscape", "getBackgroundOpView", "getDialogHeightRate", "", "getImageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "isDialogMoving", "isLocalError", "errCode", "isShowingOCRResult", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onError", "errType", "onOcrErrorWrapper", "release", "releaseImageView", "reset", "resetGallerySize", "resetWhenTouchUp", "showBackgroundOpView", "show", "showErrorTips", "errTips", "", "showImageOCRResult", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "startImageOCR", "callback", "Companion", "plugin-scan_release"})
public final class b
  implements a, g
{
  public static final b.a INv;
  private MMViewPager CcM;
  private com.tencent.mm.plugin.scanner.box.b IGO;
  private com.tencent.mm.plugin.scanner.api.d INh;
  private View INi;
  private long INj;
  private boolean INk;
  private com.tencent.mm.plugin.scanner.api.a.c INl;
  private c INm;
  private f INn;
  private h INo;
  private i INp;
  private final com.tencent.mm.plugin.scanner.box.g INq;
  private final c INr;
  private final com.tencent.mm.ui.base.g.a INs;
  private boolean INt;
  private final e INu;
  private final Context context;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(223873);
    INv = new b.a((byte)0);
    AppMethodBeat.o(223873);
  }
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(223872);
    this.INm = ((c)new d());
    this.INo = new h((g)this);
    this.INq = ((com.tencent.mm.plugin.scanner.box.g)new d(this));
    this.INr = new c(this);
    this.INs = ((com.tencent.mm.ui.base.g.a)new f(this));
    this.INu = new e(this);
    this.context = paramContext;
    this.scene = paramInt;
    this.INn = new f(paramContext, (g)this);
    AppMethodBeat.o(223872);
  }
  
  private static boolean adH(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 102) || (paramInt == 999);
  }
  
  private final void amo(String paramString)
  {
    AppMethodBeat.i(223854);
    com.tencent.mm.ui.base.h.a(this.context, paramString, "", this.context.getResources().getString(l.i.app_i_known), false, null);
    AppMethodBeat.o(223854);
  }
  
  private static boolean fDp()
  {
    AppMethodBeat.i(223848);
    com.tencent.mm.an.t localt = com.tencent.mm.kernel.h.aGY();
    p.j(localt, "MMKernel.getNetSceneQueue()");
    if (localt.bih() != 6)
    {
      localt = com.tencent.mm.kernel.h.aGY();
      p.j(localt, "MMKernel.getNetSceneQueue()");
      if (localt.bih() != 4) {}
    }
    else
    {
      AppMethodBeat.o(223848);
      return true;
    }
    AppMethodBeat.o(223848);
    return false;
  }
  
  private final void jh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223852);
    Object localObject = this.INl;
    if (localObject != null) {
      ((com.tencent.mm.plugin.scanner.api.a.c)localObject).fCb();
    }
    localObject = this.INm;
    if (localObject != null)
    {
      ((c)localObject).onError(paramInt1, paramInt2);
      AppMethodBeat.o(223852);
      return;
    }
    AppMethodBeat.o(223852);
  }
  
  private final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223850);
    Log.e("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onError errType: " + paramInt1 + ", errCode: " + paramInt2);
    jh(paramInt1, paramInt2);
    if (fDp())
    {
      boolean bool = adH(paramInt2);
      if (paramInt1 == 4)
      {
        if (bool)
        {
          str = this.context.getString(l.i.IEU);
          p.j(str, "context.getString(R.stri…an_image_ocr_local_error)");
          amo(str);
          AppMethodBeat.o(223850);
          return;
        }
        str = this.context.getString(l.i.IEW);
        p.j(str, "context.getString(R.stri…image_ocr_result_invalid)");
        amo(str);
        AppMethodBeat.o(223850);
        return;
      }
      if ((paramInt1 == 3) && (bool))
      {
        str = this.context.getString(l.i.IEU);
        p.j(str, "context.getString(R.stri…an_image_ocr_local_error)");
        amo(str);
        AppMethodBeat.o(223850);
        return;
      }
      str = this.context.getString(l.i.IEV);
      p.j(str, "context.getString(R.stri…image_ocr_network_failed)");
      amo(str);
      AppMethodBeat.o(223850);
      return;
    }
    String str = this.context.getString(l.i.IEV);
    p.j(str, "context.getString(R.stri…image_ocr_network_failed)");
    amo(str);
    AppMethodBeat.o(223850);
  }
  
  public final boolean PN(long paramLong)
  {
    boolean bool = false;
    int j = 1;
    AppMethodBeat.i(223841);
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo cancelImageOCR sessionId: %s, uploadFinish: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.INk) });
    if ((paramLong != 0L) && (!this.INk)) {
      ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.c.class)).PL(paramLong);
    }
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if (this.INp != null)
      {
        localObject = this.INp;
        if (localObject == null) {
          p.iCn();
        }
        if (((i)localObject).isShowingDialog())
        {
          localObject = this.INp;
          if (localObject == null) {
            p.iCn();
          }
          if (((i)localObject).isShowing())
          {
            bool = true;
            Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo cancelImageOCR dismiss dialog handled: %s", new Object[] { Boolean.valueOf(bool) });
            localObject = this.INp;
            if (localObject == null) {
              p.iCn();
            }
            ((i)localObject).dismiss();
            i = j;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = this.INm;
          if (localObject != null) {
            ((c)localObject).PV(paramLong);
          }
        }
        AppMethodBeat.o(223841);
        return bool;
        bool = false;
        break;
      }
    }
  }
  
  public final long a(e parame, com.tencent.mm.plugin.scanner.api.d paramd, com.tencent.mm.plugin.scanner.api.a.c paramc)
  {
    AppMethodBeat.i(223832);
    this.INk = false;
    this.INh = paramd;
    this.INl = paramc;
    this.INj = parame.sessionId;
    paramd = this.INl;
    if (paramd != null) {
      paramd.fBY();
    }
    paramd = this.INm;
    if (paramd != null) {
      paramd.PU(this.INj);
    }
    if (!fDp())
    {
      onError(3, 301);
      AppMethodBeat.o(223832);
      return 0L;
    }
    if ((this.CcM == null) || (this.INi == null))
    {
      Log.e("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo startImageOCR gallery null or currentImageView null");
      onError(3, 999);
      AppMethodBeat.o(223832);
      return 0L;
    }
    paramd = this.INo;
    paramd.INi = this.INi;
    paramd.INm = this.INm;
    if ((this.INi instanceof com.tencent.mm.ui.base.g))
    {
      paramd = this.INi;
      if (paramd == null)
      {
        parame = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(223832);
        throw parame;
      }
      ((com.tencent.mm.ui.base.g)paramd).hJx();
    }
    this.INj = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.c.class)).b(parame, (com.tencent.mm.plugin.scanner.api.g)new b.g(this, parame));
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo startImageOCR uploadSessionId: %s, scene: %s", new Object[] { Long.valueOf(this.INj), Integer.valueOf(this.scene) });
    long l = this.INj;
    AppMethodBeat.o(223832);
    return l;
  }
  
  public final boolean fBX()
  {
    AppMethodBeat.i(223842);
    if (this.INp != null)
    {
      i locali = this.INp;
      if (locali == null) {
        p.iCn();
      }
      if (locali.isShowing())
      {
        AppMethodBeat.o(223842);
        return true;
      }
    }
    AppMethodBeat.o(223842);
    return false;
  }
  
  public final boolean fDm()
  {
    AppMethodBeat.i(223844);
    if (this.INn != null)
    {
      f localf = this.INn;
      if (localf == null) {
        p.iCn();
      }
      boolean bool = localf.INL;
      AppMethodBeat.o(223844);
      return bool;
    }
    AppMethodBeat.o(223844);
    return false;
  }
  
  public final g.a fDn()
  {
    AppMethodBeat.i(223846);
    if (this.INn != null)
    {
      localObject = this.INn;
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((f)localObject).ING;
      AppMethodBeat.o(223846);
      return localObject;
    }
    Object localObject = new g.a();
    AppMethodBeat.o(223846);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.scanner.box.b fDo()
  {
    return this.IGO;
  }
  
  public final void fS(View paramView)
  {
    if ((paramView instanceof MMViewPager)) {
      this.CcM = ((MMViewPager)paramView);
    }
  }
  
  public final void fT(View paramView)
  {
    AppMethodBeat.i(223827);
    this.INi = paramView;
    if ((this.INi instanceof WxImageView))
    {
      paramView = this.INi;
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(223827);
        throw paramView;
      }
      ((WxImageView)paramView).setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new b.b(this));
    }
    if ((this.INi instanceof com.tencent.mm.ui.base.g))
    {
      paramView = this.INi;
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(223827);
        throw paramView;
      }
      ((com.tencent.mm.ui.base.g)paramView).setOnZoomScaleChangedListener(this.INs);
    }
    AppMethodBeat.o(223827);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(223823);
    if (paramConfiguration != null) {}
    for (Object localObject = Integer.valueOf(paramConfiguration.orientation);; localObject = null)
    {
      Log.d("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onConfigurationChanged new: %s", new Object[] { localObject });
      if (this.INp == null) {
        break label369;
      }
      localObject = this.INp;
      if (localObject == null) {
        p.iCn();
      }
      if (!((i)localObject).isShowingDialog()) {
        break label369;
      }
      localObject = this.INn;
      if (localObject == null) {
        break label362;
      }
      if ((paramConfiguration == null) || (paramConfiguration.orientation != 2)) {
        break label229;
      }
      ((f)localObject).xn(false);
      if (((f)localObject).INI != 1) {
        break label196;
      }
      if (!(((f)localObject).INi instanceof com.tencent.mm.ui.base.g)) {
        break label147;
      }
      paramConfiguration = ((f)localObject).INi;
      if (paramConfiguration != null) {
        break;
      }
      paramConfiguration = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(223823);
      throw paramConfiguration;
    }
    ((com.tencent.mm.ui.base.g)paramConfiguration).hJA();
    label147:
    ((f)localObject).ji(-1, -1);
    while ((((f)localObject).INi instanceof com.tencent.mm.ui.base.g))
    {
      ((f)localObject).setCanRefresh(true);
      paramConfiguration = ((f)localObject).INi;
      if (paramConfiguration == null)
      {
        paramConfiguration = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(223823);
        throw paramConfiguration;
        label196:
        if (((f)localObject).INI == 2) {
          ((f)localObject).ji(-1, -1);
        }
      }
      else
      {
        ((com.tencent.mm.ui.base.g)paramConfiguration).hJx();
        AppMethodBeat.o(223823);
        return;
        label229:
        if (paramConfiguration != null)
        {
          if (paramConfiguration.orientation != 1) {
            break;
          }
          if (((f)localObject).INI != 1) {
            break label324;
          }
          ((f)localObject).fDr();
          ((f)localObject).fDq();
          ((f)localObject).xn(true);
          ((f)localObject).ji(((f)localObject).fDt(), ((f)localObject).fDu());
        }
        while ((((f)localObject).INi instanceof com.tencent.mm.ui.base.g))
        {
          ((f)localObject).setCanRefresh(true);
          paramConfiguration = ((f)localObject).INi;
          if (paramConfiguration == null)
          {
            paramConfiguration = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
            AppMethodBeat.o(223823);
            throw paramConfiguration;
            AppMethodBeat.o(223823);
            return;
            label324:
            if (((f)localObject).INI == 2)
            {
              ((f)localObject).xn(false);
              ((f)localObject).ji(-1, -1);
            }
          }
          else
          {
            ((com.tencent.mm.ui.base.g)paramConfiguration).hJx();
          }
        }
      }
    }
    AppMethodBeat.o(223823);
    return;
    label362:
    AppMethodBeat.o(223823);
    return;
    label369:
    localObject = this.CcM;
    if (localObject != null)
    {
      paramConfiguration = this.CcM;
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.getLayoutParams();
        if (paramConfiguration != null)
        {
          paramConfiguration.width = -1;
          paramConfiguration.height = -1;
        }
      }
      for (;;)
      {
        ((MMViewPager)localObject).setLayoutParams(paramConfiguration);
        AppMethodBeat.o(223823);
        return;
        paramConfiguration = null;
      }
    }
    AppMethodBeat.o(223823);
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223843);
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(223843);
      return false;
    }
    if (this.INp != null)
    {
      i locali = this.INp;
      if (locali == null) {
        p.iCn();
      }
      if (locali.isShowing()) {}
    }
    else
    {
      AppMethodBeat.o(223843);
      return false;
    }
    if ((this.INi instanceof com.tencent.mm.ui.base.g))
    {
      this.INo.al(com.tencent.mm.ui.base.f.j(paramMotionEvent, 0), com.tencent.mm.ui.base.f.k(paramMotionEvent, 0));
      AppMethodBeat.o(223843);
      return true;
    }
    AppMethodBeat.o(223843);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(223865);
    Object localObject = this.INn;
    if (localObject != null) {
      ((f)localObject).INK = false;
    }
    localObject = this.INo;
    ((h)localObject).INS = 0.0F;
    ((h)localObject).INR = 0;
    ((h)localObject).INU = 0;
    localObject = this.IGO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.scanner.box.b)localObject).release();
    }
    this.IGO = null;
    this.INp = null;
    if ((this.INi instanceof WxImageView))
    {
      localObject = this.INi;
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(223865);
        throw ((Throwable)localObject);
      }
      ((WxImageView)localObject).setOnDoubleTapListener(null);
    }
    if ((this.INi instanceof com.tencent.mm.ui.base.g))
    {
      localObject = this.INi;
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(223865);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.ui.base.g)localObject).setOnZoomScaleChangedListener(null);
    }
    this.INi = null;
    if (this.INj != 0L)
    {
      ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.scanner.api.c.class)).PL(this.INj);
      this.INj = 0L;
    }
    AppMethodBeat.o(223865);
  }
  
  public final void reset()
  {
    this.INt = false;
  }
  
  public final void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(223847);
    if ((this.IGO instanceof View))
    {
      View localView = (View)this.IGO;
      if (localView != null)
      {
        if (paramBoolean) {}
        for (int i = 0;; i = 8)
        {
          localView.setVisibility(i);
          AppMethodBeat.o(223847);
          return;
        }
      }
    }
    AppMethodBeat.o(223847);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "onClick", "", "view", "Landroid/view/View;", "plugin-scan_release"})
  public static final class c
    implements com.tencent.mm.plugin.scanner.box.b.a
  {
    public final void bwz()
    {
      AppMethodBeat.i(219332);
      if (((b.e(this.INw) instanceof com.tencent.mm.ui.base.g)) && (b.d(this.INw) != null))
      {
        h localh = b.f(this.INw);
        f localf = b.d(this.INw);
        if (localf == null) {
          p.iCn();
        }
        localh.al(localf.fDt() / 2.0F, 0.0F);
      }
      AppMethodBeat.o(219332);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$dialogOnShowListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"})
  public static final class d
    implements com.tencent.mm.plugin.scanner.box.g
  {
    public final void a(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(219264);
      paramDialogInterface = b.c(this.INw);
      if (paramDialogInterface != null) {
        paramDialogInterface.fCa();
      }
      paramDialogInterface = b.b(this.INw);
      if (paramDialogInterface != null) {
        paramDialogInterface.adI(paramInt);
      }
      this.INw.release();
      AppMethodBeat.o(219264);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(219267);
      b.c(this.INw);
      b.b(this.INw);
      this.INw.release();
      AppMethodBeat.o(219267);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(219263);
      paramDialogInterface = b.c(this.INw);
      if (paramDialogInterface != null) {
        paramDialogInterface.fBZ();
      }
      paramDialogInterface = b.b(this.INw);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.fBZ();
        AppMethodBeat.o(219263);
        return;
      }
      AppMethodBeat.o(219263);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "onBackgroundTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "dialogOffsetY", "", "plugin-scan_release"})
  public static final class e
    implements com.tencent.mm.plugin.scanner.box.c
  {
    public final boolean i(MotionEvent paramMotionEvent, int paramInt)
    {
      AppMethodBeat.i(217037);
      boolean bool2 = false;
      MMViewPager localMMViewPager;
      boolean bool1;
      if (b.g(this.INw))
      {
        localMMViewPager = b.i(this.INw);
        if (localMMViewPager == null) {
          p.iCn();
        }
        bool1 = localMMViewPager.dispatchTouchEvent(paramMotionEvent);
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          paramInt = paramMotionEvent.getAction() & 0xFF;
          if ((paramInt == 1) || (paramInt == 6)) {
            b.j(this.INw);
          }
        }
        AppMethodBeat.o(217037);
        return bool1;
        bool1 = bool2;
        if (paramMotionEvent != null)
        {
          bool1 = bool2;
          if (paramMotionEvent.getRawY() <= paramInt)
          {
            localMMViewPager = b.i(this.INw);
            if (localMMViewPager == null) {
              p.iCn();
            }
            bool2 = localMMViewPager.dispatchTouchEvent(paramMotionEvent);
            bool1 = bool2;
            if (bool2)
            {
              b.h(this.INw);
              bool1 = bool2;
            }
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "oldScale", "", "newScale", "onScaleChanged", "(Ljava/lang/Float;Ljava/lang/Float;)V"})
  static final class f
    implements com.tencent.mm.ui.base.g.a
  {
    f(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b
 * JD-Core Version:    0.7.0.1
 */