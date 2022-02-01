package com.tencent.mm.plugin.scanner.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.scanner.box.ScanOCRDialogBackgroundOpView;
import com.tencent.mm.plugin.scanner.box.l;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "context", "Landroid/content/Context;", "scene", "", "(Landroid/content/Context;I)V", "backgroundOpListener", "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1;", "backgroundOpView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "currentImageView", "Landroid/view/View;", "dialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "gallery", "imageZoomHelper", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper;", "isTouchHandledByBackground", "", "isUploadFinish", "mBackgroundTouchListener", "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1", "Lcom/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1;", "mBoxDialog", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "mBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRResultDialogMoveListener;", "mImageOCRListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "mOcrResultCallback", "Lcom/tencent/mm/plugin/scanner/api/ocr/ImageOcrResultCallback;", "onScaleChangedListener", "Lcom/tencent/mm/ui/base/IZoomableImageView$ZoomScaleChangedListener;", "showParams", "Lcom/tencent/mm/plugin/scanner/api/ScanBoxDialogShowParams;", "uploadSessionId", "", "attachGallery", "", "attachImageView", "image", "cancelImageOCR", "sessionId", "checkNetWorkConnected", "getAnimationType", "isLandscape", "getBackgroundOpView", "getDialogHeightRate", "", "getImageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "isDialogMoving", "isLocalError", "errCode", "isShowingOCRResult", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDoubleTap", "event", "Landroid/view/MotionEvent;", "onError", "errType", "onOcrErrorWrapper", "release", "releaseImageView", "reset", "resetGallerySize", "resetWhenTouchUp", "showBackgroundOpView", "show", "showErrorTips", "errTips", "", "showImageOCRResult", "request", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "startImageOCR", "callback", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.scanner.api.a.a, g
{
  public static final b.a OUk;
  private com.tencent.mm.plugin.scanner.box.b OMX;
  private com.tencent.mm.plugin.scanner.api.d OUl;
  private View OUm;
  private View OUn;
  private long OUo;
  private boolean OUp;
  private com.tencent.mm.plugin.scanner.api.a.c OUq;
  private c OUr;
  private f OUs;
  private h OUt;
  private com.tencent.mm.plugin.scanner.box.i OUu;
  private final com.tencent.mm.plugin.scanner.box.g OUv;
  private final c OUw;
  private final i.a OUx;
  private boolean OUy;
  private final e OUz;
  private final Context context;
  private final int scene;
  
  static
  {
    AppMethodBeat.i(313577);
    OUk = new b.a((byte)0);
    AppMethodBeat.o(313577);
  }
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(313480);
    this.OUr = ((c)new d());
    this.OUt = new h((g)this);
    this.OUv = ((com.tencent.mm.plugin.scanner.box.g)new d(this));
    this.OUw = new c(this);
    this.OUx = new b..ExternalSyntheticLambda1(this);
    this.OUz = new e(this);
    this.context = paramContext;
    this.scene = paramInt;
    this.OUs = new f(paramContext, (g)this);
    AppMethodBeat.o(313480);
  }
  
  private static final void a(b paramb, e parame, long paramLong, com.tencent.mm.plugin.scanner.api.f paramf)
  {
    AppMethodBeat.i(313538);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramf, "result");
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo dealWithImageOcr onCallback session: %s, success: %b, errType: %s, errCode: %s, errMsg: %s, result: %s, reqKey: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramf.success), Integer.valueOf(paramf.errType), Integer.valueOf(paramf.errCode), paramf.errMsg, paramf.hZD, paramf.hAT });
    paramb.OUp = true;
    Object localObject = paramb.OUr;
    if (localObject != null) {
      ((c)localObject).a(paramf);
    }
    if (paramf.success)
    {
      localObject = (CharSequence)paramf.hZD;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; (i != 0) || (paramf.OMQ); i = 0)
      {
        paramb.onError(4, 202);
        AppMethodBeat.o(313538);
        return;
      }
      boolean bool;
      float f;
      if (paramb.context.getResources().getConfiguration().orientation == 2)
      {
        bool = true;
        if (bool) {
          break label689;
        }
        f = 0.7F;
        label219:
        if (bool) {
          break label695;
        }
        i = 1;
        label227:
        Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo showImageOCRResult isLandscape: %s, dialogHeightRate: %f, animationType: %s", new Object[] { Boolean.valueOf(bool), Float.valueOf(f), Integer.valueOf(i) });
        localObject = new Bundle();
        ((Bundle)localObject).putLong("session_id", paramf.hBk);
        ((Bundle)localObject).putString("req_key", paramf.hAT);
        ((Bundle)localObject).putInt("scene", parame.source);
        ((Bundle)localObject).putInt("template_type", 2);
        ((Bundle)localObject).putFloat("fixed_dialog_height_rate", f);
        ((Bundle)localObject).putBoolean("enable_dialog_scroll", false);
        ((Bundle)localObject).putBoolean("enable_cancel_outside", false);
        ((Bundle)localObject).putBoolean("show_after_webview_ready", true);
        parame = paramb.OUl;
        if (parame != null) {
          break label701;
        }
        bool = true;
        label368:
        ((Bundle)localObject).putBoolean("enable_full_screen", bool);
        parame = paramb.OUl;
        if (parame != null) {
          break label710;
        }
        bool = false;
        label390:
        ((Bundle)localObject).putBoolean("enable_scroll_right_close", bool);
        paramf = paramb.OUs;
        if (paramf != null)
        {
          parame = paramb.OUn;
          paramf.OUn = parame;
          if (parame != null)
          {
            paramf.OUH = parame.getMeasuredWidth();
            paramf.OUG = parame.getMeasuredHeight();
          }
          paramf.OUm = paramb.OUm;
          paramf.OUN = i;
          switch (i)
          {
          default: 
            parame = null;
          }
        }
      }
      for (;;)
      {
        paramf.OUM = parame;
        paramf.OUl = paramb.OUl;
        parame = l.a(paramb.context, (Bundle)localObject, paramb.OUv);
        paramf = paramb.OUs;
        kotlin.g.b.s.checkNotNull(paramf);
        parame.a((com.tencent.mm.plugin.scanner.box.f)paramf);
        paramf = (com.tencent.mm.plugin.scanner.box.c)paramb.OUz;
        kotlin.g.b.s.u(paramf, "listener");
        localObject = parame.ONn;
        if (localObject != null) {
          ((BaseBoxDialogView)localObject).setBackgroundTouchListener(paramf);
        }
        if (i == 1)
        {
          paramf = parame.getContext();
          kotlin.g.b.s.s(paramf, "context");
          paramb.OMX = ((com.tencent.mm.plugin.scanner.box.b)new ScanOCRDialogBackgroundOpView(paramf));
          paramf = paramb.OMX;
          if (paramf != null) {
            paramf.setOpListener((com.tencent.mm.plugin.scanner.box.b.a)paramb.OUw);
          }
          paramf = paramb.OMX;
          kotlin.g.b.s.checkNotNull(paramf);
          kotlin.g.b.s.u(paramf, "opView");
          localObject = parame.ONn;
          if (localObject != null) {
            ((BaseBoxDialogView)localObject).setBackgroundOpView(paramf);
          }
        }
        paramf = ah.aiuX;
        paramb.OUu = parame;
        AppMethodBeat.o(313538);
        return;
        bool = false;
        break;
        label689:
        f = 1.0F;
        break label219;
        label695:
        i = 2;
        break label227;
        label701:
        bool = parame.OMy;
        break label368;
        label710:
        bool = parame.pvC;
        break label390;
        parame = (com.tencent.mm.plugin.scanner.f.a.c)new com.tencent.mm.plugin.scanner.f.a.d(paramf.context, i);
        continue;
        parame = (com.tencent.mm.plugin.scanner.f.a.c)new com.tencent.mm.plugin.scanner.f.a.a(i);
      }
    }
    paramb.onError(paramf.errType, paramf.errCode);
    AppMethodBeat.o(313538);
  }
  
  private static final void a(b paramb, Float paramFloat1, Float paramFloat2)
  {
    int i = 1;
    AppMethodBeat.i(313521);
    kotlin.g.b.s.u(paramb, "this$0");
    if ((paramFloat1 != null) && (paramFloat2 != null))
    {
      paramb = paramb.OUt;
      float f2 = paramFloat1.floatValue();
      float f1 = paramFloat2.floatValue();
      if (paramb.OUm != null)
      {
        if (paramb.OUL == null) {
          paramb.OUL = paramb.OUF.gRz();
        }
        float f3 = paramb.OUY.targetScale;
        paramFloat1 = paramb.OUm;
        if (paramFloat1 == null)
        {
          paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
          AppMethodBeat.o(313521);
          throw paramb;
        }
        Log.v("MicroMsg.ImageOCRZoomHelper", "alvinluo onScaleChanged old: %s, new: %s, targetScale: %s, scaleRate: %s, isZoomAnimating: %s", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(((com.tencent.mm.ui.base.i)paramFloat1).getScaleRate()), Boolean.valueOf(paramb.gRH()) });
        Log.v("MicroMsg.ImageOCRZoomHelper", "alvinluo onZoomScaleChanged currentScale: %s, currentZoomScale: %s, curretnZooming: %s, isZoomAnimating: %s", new Object[] { Float.valueOf(f1), Float.valueOf(paramb.OUW), Integer.valueOf(paramb.OUX), Boolean.valueOf(paramb.gRH()) });
        if (f1 - paramb.OUW > 0.01F)
        {
          paramb.OUW = f1;
          if (paramb.OUX != 1)
          {
            paramb.OUX = 1;
            paramFloat1 = paramb.OUr;
            if (paramFloat1 != null)
            {
              if (!paramb.gRH()) {
                break label343;
              }
              i = 1;
              paramFloat1.aig(i);
            }
          }
        }
        for (;;)
        {
          if ((paramb.OUY.OUZ) && (Math.abs(paramb.OUY.targetScale - f1) <= 0.001D))
          {
            paramb.OUY.OUZ = false;
            paramb.OUX = 0;
          }
          paramFloat1 = paramb.OUm;
          if (paramFloat1 != null) {
            break label446;
          }
          paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
          AppMethodBeat.o(313521);
          throw paramb;
          label343:
          i = 2;
          break;
          if (paramb.OUW - f1 > 0.01F)
          {
            paramb.OUW = f1;
            if (paramb.OUX != 2)
            {
              paramb.OUX = 2;
              paramFloat1 = paramb.OUr;
              if (paramFloat1 != null)
              {
                if (paramb.gRH()) {}
                for (;;)
                {
                  paramFloat1.aih(i);
                  break;
                  i = 2;
                }
              }
            }
          }
          else
          {
            Log.d("MicroMsg.ImageOCRZoomHelper", "alvinluo onZoomScaleChanged ignore, %s, %s", new Object[] { Float.valueOf(f1), Float.valueOf(paramb.OUW) });
          }
        }
        label446:
        f2 = ((com.tencent.mm.ui.base.i)paramFloat1).getScaleRate();
        paramFloat1 = (kotlin.g.a.a)new h.c(paramb);
        paramFloat2 = (kotlin.g.a.a)new h.d(paramb);
        g.a locala = paramb.OUL;
        kotlin.g.b.s.checkNotNull(locala);
        if (locala.OUR)
        {
          locala = paramb.OUL;
          kotlin.g.b.s.checkNotNull(locala);
          if (f1 - locala.OUT > 0.01F)
          {
            paramFloat1.invoke();
            AppMethodBeat.o(313521);
            return;
          }
          paramb = paramb.OUL;
          kotlin.g.b.s.checkNotNull(paramb);
          if (f1 - paramb.OUS > 0.01F)
          {
            paramFloat1.invoke();
            AppMethodBeat.o(313521);
            return;
          }
          paramFloat2.invoke();
          AppMethodBeat.o(313521);
          return;
        }
        if (f1 - f2 > 0.01F)
        {
          paramFloat1.invoke();
          AppMethodBeat.o(313521);
          return;
        }
        paramFloat2.invoke();
      }
    }
    AppMethodBeat.o(313521);
  }
  
  private final void afy(String paramString)
  {
    AppMethodBeat.i(313512);
    k.a(this.context, paramString, "", this.context.getResources().getString(l.i.app_i_known), false, null);
    AppMethodBeat.o(313512);
  }
  
  private static boolean aie(int paramInt)
  {
    return (paramInt == 101) || (paramInt == 102) || (paramInt == 999);
  }
  
  private static boolean gRB()
  {
    AppMethodBeat.i(313489);
    if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4))
    {
      AppMethodBeat.o(313489);
      return true;
    }
    AppMethodBeat.o(313489);
    return false;
  }
  
  private final void kO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(313504);
    Object localObject = this.OUq;
    if (localObject != null) {
      ((com.tencent.mm.plugin.scanner.api.a.c)localObject).gPI();
    }
    localObject = this.OUr;
    if (localObject != null) {
      ((c)localObject).onError(paramInt1, paramInt2);
    }
    AppMethodBeat.o(313504);
  }
  
  private final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(313498);
    Log.e("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onError errType: " + paramInt1 + ", errCode: " + paramInt2);
    kO(paramInt1, paramInt2);
    if (gRB())
    {
      boolean bool = aie(paramInt2);
      if (paramInt1 == 4)
      {
        if (bool)
        {
          str = this.context.getString(l.i.OLb);
          kotlin.g.b.s.s(str, "context.getString(R.stri…an_image_ocr_local_error)");
          afy(str);
          AppMethodBeat.o(313498);
          return;
        }
        str = this.context.getString(l.i.OLd);
        kotlin.g.b.s.s(str, "context.getString(R.stri…image_ocr_result_invalid)");
        afy(str);
        AppMethodBeat.o(313498);
        return;
      }
      if ((paramInt1 == 3) && (bool))
      {
        str = this.context.getString(l.i.OLb);
        kotlin.g.b.s.s(str, "context.getString(R.stri…an_image_ocr_local_error)");
        afy(str);
        AppMethodBeat.o(313498);
        return;
      }
      str = this.context.getString(l.i.OLc);
      kotlin.g.b.s.s(str, "context.getString(R.stri…image_ocr_network_failed)");
      afy(str);
      AppMethodBeat.o(313498);
      return;
    }
    String str = this.context.getString(l.i.OLc);
    kotlin.g.b.s.s(str, "context.getString(R.stri…image_ocr_network_failed)");
    afy(str);
    AppMethodBeat.o(313498);
  }
  
  public final void Cc(boolean paramBoolean)
  {
    AppMethodBeat.i(313666);
    View localView;
    if ((this.OMX instanceof View))
    {
      localView = (View)this.OMX;
      if (localView != null) {
        if (!paramBoolean) {
          break label46;
        }
      }
    }
    label46:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(313666);
      return;
    }
  }
  
  public final long a(e parame, com.tencent.mm.plugin.scanner.api.d paramd, com.tencent.mm.plugin.scanner.api.a.c paramc)
  {
    AppMethodBeat.i(313612);
    this.OUp = false;
    this.OUl = paramd;
    this.OUq = paramc;
    this.OUo = parame.sessionId;
    paramd = this.OUq;
    if (paramd != null) {
      paramd.gPE();
    }
    paramd = this.OUr;
    if (paramd != null) {
      paramd.rl(this.OUo);
    }
    if (!gRB())
    {
      onError(3, 301);
      AppMethodBeat.o(313612);
      return 0L;
    }
    if ((this.OUn == null) || (this.OUm == null))
    {
      Log.e("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo startImageOCR gallery null or currentImageView null");
      onError(3, 999);
      AppMethodBeat.o(313612);
      return 0L;
    }
    paramd = this.OUt;
    paramd.OUm = this.OUm;
    paramd.OUr = this.OUr;
    if ((this.OUm instanceof com.tencent.mm.ui.base.i))
    {
      paramd = this.OUm;
      if (paramd == null)
      {
        parame = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313612);
        throw parame;
      }
      ((com.tencent.mm.ui.base.i)paramd).jma();
    }
    this.OUo = ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).b(parame, new b..ExternalSyntheticLambda0(this, parame));
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo startImageOCR uploadSessionId: %s, scene: %s", new Object[] { Long.valueOf(this.OUo), Integer.valueOf(this.scene) });
    long l = this.OUo;
    AppMethodBeat.o(313612);
    return l;
  }
  
  public final boolean gPD()
  {
    AppMethodBeat.i(313627);
    if (this.OUu != null)
    {
      com.tencent.mm.plugin.scanner.box.i locali = this.OUu;
      kotlin.g.b.s.checkNotNull(locali);
      if (locali.isShowing())
      {
        AppMethodBeat.o(313627);
        return true;
      }
    }
    AppMethodBeat.o(313627);
    return false;
  }
  
  public final com.tencent.mm.plugin.scanner.box.b gRA()
  {
    return this.OMX;
  }
  
  public final boolean gRy()
  {
    AppMethodBeat.i(313643);
    if (this.OUs != null)
    {
      f localf = this.OUs;
      kotlin.g.b.s.checkNotNull(localf);
      boolean bool = localf.OUQ;
      AppMethodBeat.o(313643);
      return bool;
    }
    AppMethodBeat.o(313643);
    return false;
  }
  
  public final g.a gRz()
  {
    AppMethodBeat.i(313650);
    if (this.OUs != null)
    {
      localObject = this.OUs;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((f)localObject).OUL;
      AppMethodBeat.o(313650);
      return localObject;
    }
    Object localObject = new g.a();
    AppMethodBeat.o(313650);
    return localObject;
  }
  
  public final void iT(View paramView)
  {
    this.OUn = paramView;
  }
  
  public final void iU(View paramView)
  {
    AppMethodBeat.i(313605);
    this.OUm = paramView;
    if ((this.OUm instanceof WxImageView))
    {
      paramView = this.OUm;
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(313605);
        throw paramView;
      }
      ((WxImageView)paramView).setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new b(this));
    }
    if ((this.OUm instanceof com.tencent.mm.ui.base.i))
    {
      paramView = this.OUm;
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313605);
        throw paramView;
      }
      ((com.tencent.mm.ui.base.i)paramView).setOnZoomScaleChangedListener(this.OUx);
    }
    AppMethodBeat.o(313605);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(313599);
    int i;
    if (paramConfiguration == null)
    {
      localObject = null;
      Log.d("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo onConfigurationChanged new: %s", new Object[] { localObject });
      if (this.OUu == null) {
        break label373;
      }
      localObject = this.OUu;
      kotlin.g.b.s.checkNotNull(localObject);
      if (!((com.tencent.mm.plugin.scanner.box.i)localObject).gPQ()) {
        break label373;
      }
      localObject = this.OUs;
      if (localObject == null) {
        break label398;
      }
      if ((paramConfiguration == null) || (paramConfiguration.orientation != 2)) {
        break label140;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ((f)localObject).Cc(false);
        if (((f)localObject).OUN == 1)
        {
          if ((((f)localObject).OUm instanceof com.tencent.mm.ui.base.i))
          {
            paramConfiguration = ((f)localObject).OUm;
            if (paramConfiguration == null)
            {
              paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
              AppMethodBeat.o(313599);
              throw paramConfiguration;
              localObject = Integer.valueOf(paramConfiguration.orientation);
              break;
              label140:
              i = 0;
              continue;
            }
            ((com.tencent.mm.ui.base.i)paramConfiguration).jmd();
          }
          ((f)localObject).kP(-1, -1);
        }
        for (;;)
        {
          if (!(((f)localObject).OUm instanceof com.tencent.mm.ui.base.i)) {
            break label366;
          }
          ((f)localObject).setCanRefresh(true);
          paramConfiguration = ((f)localObject).OUm;
          if (paramConfiguration != null) {
            break;
          }
          paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
          AppMethodBeat.o(313599);
          throw paramConfiguration;
          if (((f)localObject).OUN == 2) {
            ((f)localObject).kP(-1, -1);
          }
        }
        ((com.tencent.mm.ui.base.i)paramConfiguration).jma();
        AppMethodBeat.o(313599);
        return;
      }
    }
    if ((paramConfiguration != null) && (paramConfiguration.orientation == 1))
    {
      i = 1;
      if (i == 0) {
        break label366;
      }
      if (((f)localObject).OUN != 1) {
        break label335;
      }
      ((f)localObject).gRD();
      ((f)localObject).gRC();
      ((f)localObject).Cc(true);
      ((f)localObject).kP(((f)localObject).gRF(), ((f)localObject).gRG());
    }
    for (;;)
    {
      if ((((f)localObject).OUm instanceof com.tencent.mm.ui.base.i))
      {
        ((f)localObject).setCanRefresh(true);
        paramConfiguration = ((f)localObject).OUm;
        if (paramConfiguration == null)
        {
          paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
          AppMethodBeat.o(313599);
          throw paramConfiguration;
          i = 0;
          break;
          label335:
          if (((f)localObject).OUN != 2) {
            continue;
          }
          ((f)localObject).Cc(false);
          ((f)localObject).kP(-1, -1);
          continue;
        }
        ((com.tencent.mm.ui.base.i)paramConfiguration).jma();
      }
    }
    label366:
    AppMethodBeat.o(313599);
    return;
    label373:
    Object localObject = this.OUn;
    if (localObject != null)
    {
      paramConfiguration = this.OUn;
      if (paramConfiguration != null) {
        break label405;
      }
      paramConfiguration = null;
    }
    for (;;)
    {
      ((View)localObject).setLayoutParams(paramConfiguration);
      label398:
      AppMethodBeat.o(313599);
      return;
      label405:
      paramConfiguration = paramConfiguration.getLayoutParams();
      if (paramConfiguration == null)
      {
        paramConfiguration = null;
      }
      else
      {
        paramConfiguration.width = -1;
        paramConfiguration.height = -1;
        ah localah = ah.aiuX;
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(313634);
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(313634);
      return false;
    }
    if (this.OUu != null)
    {
      com.tencent.mm.plugin.scanner.box.i locali = this.OUu;
      kotlin.g.b.s.checkNotNull(locali);
      if (locali.isShowing()) {}
    }
    else
    {
      AppMethodBeat.o(313634);
      return false;
    }
    if ((this.OUm instanceof com.tencent.mm.ui.base.i))
    {
      this.OUt.aP(com.tencent.mm.ui.base.g.k(paramMotionEvent, 0), com.tencent.mm.ui.base.g.l(paramMotionEvent, 0));
      AppMethodBeat.o(313634);
      return true;
    }
    AppMethodBeat.o(313634);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(313677);
    Object localObject = this.OUs;
    if (localObject != null) {
      ((f)localObject).OUP = false;
    }
    localObject = this.OUt;
    ((h)localObject).OUW = 0.0F;
    ((h)localObject).OUV = 0;
    ((h)localObject).OUX = 0;
    localObject = this.OMX;
    if (localObject != null) {
      ((com.tencent.mm.plugin.scanner.box.b)localObject).release();
    }
    this.OMX = null;
    this.OUu = null;
    if ((this.OUm instanceof WxImageView))
    {
      localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.WxImageView");
        AppMethodBeat.o(313677);
        throw ((Throwable)localObject);
      }
      ((WxImageView)localObject).setOnDoubleTapListener(null);
    }
    if ((this.OUm instanceof com.tencent.mm.ui.base.i))
    {
      localObject = this.OUm;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
        AppMethodBeat.o(313677);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.ui.base.i)localObject).setOnZoomScaleChangedListener(null);
    }
    this.OUm = null;
    if (this.OUo != 0L)
    {
      ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).tN(this.OUo);
      this.OUo = 0L;
    }
    AppMethodBeat.o(313677);
  }
  
  public final void reset()
  {
    this.OUy = false;
  }
  
  public final boolean tP(long paramLong)
  {
    boolean bool = false;
    int j = 1;
    AppMethodBeat.i(313620);
    Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo cancelImageOCR sessionId: %s, uploadFinish: %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(this.OUp) });
    if ((paramLong != 0L) && (!this.OUp)) {
      ((com.tencent.mm.plugin.scanner.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.scanner.api.c.class)).tN(paramLong);
    }
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if (this.OUu != null)
      {
        localObject = this.OUu;
        kotlin.g.b.s.checkNotNull(localObject);
        if (((com.tencent.mm.plugin.scanner.box.i)localObject).gPQ())
        {
          localObject = this.OUu;
          kotlin.g.b.s.checkNotNull(localObject);
          if (((com.tencent.mm.plugin.scanner.box.i)localObject).isShowing())
          {
            bool = true;
            Log.i("MicroMsg.ImageGalleryImageOCRHelper", "alvinluo cancelImageOCR dismiss dialog handled: %s", new Object[] { Boolean.valueOf(bool) });
            localObject = this.OUu;
            kotlin.g.b.s.checkNotNull(localObject);
            ((com.tencent.mm.plugin.scanner.box.i)localObject).dismiss();
            i = j;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          localObject = this.OUr;
          if (localObject != null) {
            ((c)localObject).tZ(paramLong);
          }
        }
        AppMethodBeat.o(313620);
        return bool;
        bool = false;
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onSingleTapConfirmed", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements GestureDetector.OnDoubleTapListener
  {
    b(b paramb) {}
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(313500);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = this.OUA.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(313500);
      return bool;
    }
    
    public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$backgroundOpListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "onClick", "", "view", "Landroid/view/View;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.scanner.box.b.a
  {
    c(b paramb) {}
    
    public final void bVr()
    {
      AppMethodBeat.i(313481);
      if (((b.c(this.OUA) instanceof com.tencent.mm.ui.base.i)) && (b.d(this.OUA) != null))
      {
        h localh = b.e(this.OUA);
        f localf = b.d(this.OUA);
        kotlin.g.b.s.checkNotNull(localf);
        localh.aP(localf.gRF() / 2.0F, 0.0F);
      }
      AppMethodBeat.o(313481);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$dialogOnShowListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "exitType", "", "onShow", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.scanner.box.g
  {
    d(b paramb) {}
    
    public final void L(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(313490);
      paramDialogInterface = b.a(this.OUA);
      if (paramDialogInterface != null) {
        paramDialogInterface.gPH();
      }
      paramDialogInterface = b.b(this.OUA);
      if (paramDialogInterface != null) {
        paramDialogInterface.aif(paramInt);
      }
      this.OUA.release();
      AppMethodBeat.o(313490);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(313497);
      paramDialogInterface = b.a(this.OUA);
      if (paramDialogInterface != null) {
        paramDialogInterface.gPG();
      }
      b.b(this.OUA);
      this.OUA.release();
      AppMethodBeat.o(313497);
    }
    
    public final void onShow(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(313484);
      paramDialogInterface = b.a(this.OUA);
      if (paramDialogInterface != null) {
        paramDialogInterface.gPF();
      }
      paramDialogInterface = b.b(this.OUA);
      if (paramDialogInterface != null) {
        paramDialogInterface.gPF();
      }
      AppMethodBeat.o(313484);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$mBackgroundTouchListener$1", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "onBackgroundTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "dialogOffsetY", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.scanner.box.c
  {
    e(b paramb) {}
    
    public final boolean j(MotionEvent paramMotionEvent, int paramInt)
    {
      AppMethodBeat.i(313501);
      boolean bool2 = false;
      Object localObject;
      boolean bool1;
      if (b.f(this.OUA))
      {
        localObject = b.g(this.OUA);
        kotlin.g.b.s.checkNotNull(localObject);
        bool1 = ((View)localObject).dispatchTouchEvent(paramMotionEvent);
        if (paramMotionEvent != null)
        {
          localObject = this.OUA;
          switch (paramMotionEvent.getAction() & 0xFF)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(313501);
        return bool1;
        bool1 = bool2;
        if (paramMotionEvent == null) {
          break;
        }
        bool1 = bool2;
        if (paramMotionEvent.getRawY() > paramInt) {
          break;
        }
        localObject = b.g(this.OUA);
        kotlin.g.b.s.checkNotNull(localObject);
        bool2 = ((View)localObject).dispatchTouchEvent(paramMotionEvent);
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        b.h(this.OUA);
        bool1 = bool2;
        break;
        b.i((b)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b
 * JD-Core Version:    0.7.0.1
 */