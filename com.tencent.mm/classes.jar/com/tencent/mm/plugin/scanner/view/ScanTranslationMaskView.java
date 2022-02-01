package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.ui.ScanTranslationResultUI;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/view/ScanTranslationMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/hardware/Camera$PreviewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "captureBtn", "Landroid/view/View;", "captureTime", "", "isDestroyed", "", "startTimeArray", "", "attachFlashSwitcherView", "", "flashSwitcher", "attachGalleryButton", "galleryButton", "attachScanTipsView", "tipsView", "Landroid/widget/TextView;", "init", "initView", "rootView", "jumpResultUI", "originPath", "", "source", "originBitmap", "Landroid/graphics/Bitmap;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onNetworkChange", "state", "onPreviewFrame", "bytes", "", "camera", "Landroid/hardware/Camera;", "onPreviewReady", "isSwitchTab", "onResume", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "processFrame", "processImage", "filePath", "setBottomExtraHeight", "bottomHeight", "updateViewByNetwork", "Companion", "scan-translation_release"})
public final class ScanTranslationMaskView
  extends BaseScanMaskView<BaseScanRequest>
  implements Camera.PreviewCallback
{
  public static final ScanTranslationMaskView.a yBh;
  private boolean aMv;
  private long captureTime;
  private View ysM;
  private final long[] ytg;
  
  static
  {
    AppMethodBeat.i(121028);
    yBh = new ScanTranslationMaskView.a((byte)0);
    AppMethodBeat.o(121028);
  }
  
  public ScanTranslationMaskView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(121025);
    AppMethodBeat.o(121025);
  }
  
  public ScanTranslationMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(121026);
    AppMethodBeat.o(121026);
  }
  
  public ScanTranslationMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(121027);
    this.ytg = new long[2];
    paramContext = LayoutInflater.from(paramContext).inflate(2131494569, (ViewGroup)this);
    p.g(paramContext, "view");
    paramContext = paramContext.findViewById(2131304307);
    p.g(paramContext, "rootView.findViewById(R.id.scan_capture_btn)");
    this.ysM = paramContext;
    paramContext = this.ysM;
    if (paramContext == null) {
      p.bcb("captureBtn");
    }
    paramContext.setEnabled(false);
    paramContext = this.ysM;
    if (paramContext == null) {
      p.bcb("captureBtn");
    }
    paramContext.setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(121027);
  }
  
  private final void a(String paramString, int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(121018);
    ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo jumpResultUI originPath: %s", new Object[] { paramString });
    ae.r(paramString, paramBitmap);
    paramBitmap = new Intent();
    paramBitmap.putExtra("key_translation_origin_image_path", paramString);
    paramBitmap.putExtra("key_translation_source", paramInt);
    paramBitmap.putExtra("key_translation_capture_time", this.captureTime);
    paramBitmap.setClass(getContext(), ScanTranslationResultUI.class);
    paramString = getContext();
    paramBitmap = new com.tencent.mm.hellhoundlib.b.a().bc(paramBitmap);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, paramBitmap.ahp(), "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)paramBitmap.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView", "jumpResultUI", "(Ljava/lang/String;ILandroid/graphics/Bitmap;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(121018);
  }
  
  private final void dMo()
  {
    AppMethodBeat.i(121024);
    if (getCurrentNetworkAvailable())
    {
      localObject = getScanTips();
      if (localObject != null) {
        ((TextView)localObject).setText(2131762882);
      }
      localObject = getMGalleryButton();
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.ysM;
      if (localObject == null) {
        p.bcb("captureBtn");
      }
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(121024);
      return;
    }
    Object localObject = getScanTips();
    if (localObject != null) {
      ((TextView)localObject).setText(2131762845);
    }
    localObject = getMGalleryButton();
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.ysM;
    if (localObject == null) {
      p.bcb("captureBtn");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(121024);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(121020);
    synchronized (Boolean.valueOf(this.aMv))
    {
      this.aMv = true;
      z localz = z.MKo;
      a((View)this, 1.0F, 0.0F, paramAnimatorListener);
      AppMethodBeat.o(121020);
      return;
    }
  }
  
  public final void dMn()
  {
    AppMethodBeat.i(121019);
    super.dMn();
    synchronized (Boolean.valueOf(this.aMv))
    {
      this.aMv = false;
      z localz = z.MKo;
      dMo();
      AppMethodBeat.o(121019);
      return;
    }
  }
  
  public final void eH(View paramView)
  {
    AppMethodBeat.i(121013);
    p.h(paramView, "flashSwitcher");
    super.eH(paramView);
    paramView = getFlashSwitcher();
    if (paramView != null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(121013);
      return;
    }
    AppMethodBeat.o(121013);
  }
  
  public final void eJ(View paramView)
  {
    AppMethodBeat.i(121015);
    p.h(paramView, "galleryButton");
    super.eJ(paramView);
    paramView = getMGalleryButton();
    if (paramView != null)
    {
      paramView.setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(121015);
      return;
    }
    AppMethodBeat.o(121015);
  }
  
  public final void o(TextView paramTextView)
  {
    AppMethodBeat.i(121014);
    p.h(paramTextView, "tipsView");
    super.o(paramTextView);
    AppMethodBeat.o(121014);
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(121023);
    super.onNetworkChange(paramInt);
    ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo onNetworkChange state: %d, currentNetworkAvailable: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(getCurrentNetworkAvailable()) });
    dMo();
    AppMethodBeat.o(121023);
  }
  
  public final void onPreviewFrame(final byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(121017);
    if (paramArrayOfByte != null) {}
    for (paramCamera = Integer.valueOf(paramArrayOfByte.length);; paramCamera = null)
    {
      ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo onPreviewFrame data size: %d", new Object[] { paramCamera });
      if (paramArrayOfByte != null) {
        break;
      }
      AppMethodBeat.o(121017);
      return;
    }
    h.LTJ.aR((Runnable)new e(this, paramArrayOfByte));
    AppMethodBeat.o(121017);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121022);
    super.onResume();
    ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo onResume");
    this.ytg[0] = System.currentTimeMillis();
    AppMethodBeat.o(121022);
  }
  
  public final void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(121021);
    super.qz(paramBoolean);
    View localView = this.ysM;
    if (localView == null) {
      p.bcb("captureBtn");
    }
    localView.setEnabled(true);
    this.ytg[0] = System.currentTimeMillis();
    setVisibility(0);
    if (getCurrentNetworkAvailable()) {
      a((View)this, 0.0F, 1.0F, null);
    }
    AppMethodBeat.o(121021);
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(121016);
    super.setBottomExtraHeight(paramInt);
    View localView = this.ysM;
    if (localView == null) {
      p.bcb("captureBtn");
    }
    Object localObject = this.ysM;
    if (localObject == null) {
      p.bcb("captureBtn");
    }
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cc.a.fromDPToPix(getContext(), 24) + getMBottomExtraHeight());
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(121016);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ScanTranslationMaskView paramScanTranslationMaskView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(121009);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$attachGalleryButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if ((this.yBi.getActivity() instanceof MMActivity))
      {
        paramView = this.yBi.getActivity();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(121009);
          throw paramView;
        }
        ((MMActivity)paramView).mmSetOnActivityResultCallback((MMActivity.a)new MMActivity.a()
        {
          public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            boolean bool = true;
            AppMethodBeat.i(121008);
            if (paramAnonymousIntent == null) {}
            for (;;)
            {
              ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo onActivityResult requestCode: %d, resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
              ScanTranslationMaskView.a(this.yBj.yBi, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
              AppMethodBeat.o(121008);
              return;
              bool = false;
            }
          }
        });
      }
      q.a(this.yBi.getActivity(), 561, 1, 0, 1, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$attachGalleryButton$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(121009);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ScanTranslationMaskView paramScanTranslationMaskView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(121010);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.d("MicroMsg.ScanTranslationMaskView", "alvinluo onCaptureBtn click");
      paramView = this.yBi.getScanCamera();
      if (paramView != null) {
        paramView.a((Camera.PreviewCallback)this.yBi);
      }
      ScanTranslationMaskView.a(this.yBi, (int)(System.currentTimeMillis() - ScanTranslationMaskView.a(this.yBi)[0]));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(121010);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(ScanTranslationMaskView paramScanTranslationMaskView, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(121011);
      synchronized (Boolean.valueOf(ScanTranslationMaskView.b(this.yBi)))
      {
        if (ScanTranslationMaskView.b(this.yBi))
        {
          ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo onActivityResult isDestroyed and ignore");
          AppMethodBeat.o(121011);
          return;
        }
        z localz = z.MKo;
        ScanTranslationMaskView.a(this.yBi, this.xRo);
        AppMethodBeat.o(121011);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(ScanTranslationMaskView paramScanTranslationMaskView, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(121012);
      synchronized (Boolean.valueOf(ScanTranslationMaskView.b(this.yBi)))
      {
        if (ScanTranslationMaskView.b(this.yBi))
        {
          ad.i("MicroMsg.ScanTranslationMaskView", "alvinluo onPreviewFrame isDestroyed and ignore");
          AppMethodBeat.o(121012);
          return;
        }
        z localz = z.MKo;
        ScanTranslationMaskView.a(this.yBi, paramArrayOfByte);
        AppMethodBeat.o(121012);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView
 * JD-Core Version:    0.7.0.1
 */