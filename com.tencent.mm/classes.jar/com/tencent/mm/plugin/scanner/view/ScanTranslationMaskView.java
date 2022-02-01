package com.tencent.mm.plugin.scanner.view;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.ah;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/view/ScanTranslationMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/hardware/Camera$PreviewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "captureBtn", "Landroid/view/View;", "captureTime", "", "isDestroyed", "", "startTimeArray", "", "translateHandler", "Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", "init", "", "initView", "rootView", "onNetworkChange", "state", "onPreviewFrame", "bytes", "", "camera", "Landroid/hardware/Camera;", "onPreviewReady", "isSwitchTab", "onResume", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "processFrame", "setBottomExtraHeight", "bottomHeight", "updateViewByNetwork", "Companion", "scan-translation_release"})
public final class ScanTranslationMaskView
  extends BaseScanMaskView<BaseScanRequest>
  implements Camera.PreviewCallback
{
  public static final ScanTranslationMaskView.a CVv;
  private final long[] CMT;
  private View CMz;
  private ah CVu;
  private boolean aMn;
  private long captureTime;
  
  static
  {
    AppMethodBeat.i(121028);
    CVv = new ScanTranslationMaskView.a((byte)0);
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
    this.CMT = new long[2];
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(2131495191, (ViewGroup)this);
    p.g(paramAttributeSet, "view");
    paramAttributeSet = paramAttributeSet.findViewById(2131307235);
    p.g(paramAttributeSet, "rootView.findViewById(R.id.scan_capture_btn)");
    this.CMz = paramAttributeSet;
    paramAttributeSet = this.CMz;
    if (paramAttributeSet == null) {
      p.btv("captureBtn");
    }
    paramAttributeSet.setEnabled(false);
    paramAttributeSet = this.CMz;
    if (paramAttributeSet == null) {
      p.btv("captureBtn");
    }
    paramAttributeSet.setOnClickListener((View.OnClickListener)new b(this));
    this.CVu = new ah(paramContext);
    AppMethodBeat.o(121027);
  }
  
  private final void eSk()
  {
    AppMethodBeat.i(121024);
    if (getCurrentNetworkAvailable())
    {
      localView = this.CMz;
      if (localView == null) {
        p.btv("captureBtn");
      }
      localView.setVisibility(0);
      AppMethodBeat.o(121024);
      return;
    }
    View localView = this.CMz;
    if (localView == null) {
      p.btv("captureBtn");
    }
    localView.setVisibility(8);
    AppMethodBeat.o(121024);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(121020);
    synchronized (Boolean.valueOf(this.aMn))
    {
      this.aMn = true;
      x localx = x.SXb;
      m.a((View)this, 1.0F, 0.0F, 200L, paramAnimatorListener);
      AppMethodBeat.o(121020);
      return;
    }
  }
  
  public final void eRq()
  {
    AppMethodBeat.i(121019);
    super.eRq();
    synchronized (Boolean.valueOf(this.aMn))
    {
      this.aMn = false;
      x localx = x.SXb;
      eSk();
      AppMethodBeat.o(121019);
      return;
    }
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(121023);
    super.onNetworkChange(paramInt);
    Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onNetworkChange state: %d, currentNetworkAvailable: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(getCurrentNetworkAvailable()) });
    eSk();
    AppMethodBeat.o(121023);
  }
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(121017);
    if (paramArrayOfByte != null) {}
    for (paramCamera = Integer.valueOf(paramArrayOfByte.length);; paramCamera = null)
    {
      Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onPreviewFrame data size: %d", new Object[] { paramCamera });
      if (paramArrayOfByte != null) {
        break;
      }
      AppMethodBeat.o(121017);
      return;
    }
    if (paramArrayOfByte.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label171;
      }
    }
    label171:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (getScanCamera() == null)) {
        break label176;
      }
      paramCamera = new Bundle();
      paramCamera.putByteArray("key_translate_yuv_byte_array", paramArrayOfByte);
      paramArrayOfByte = getScanCamera();
      if (paramArrayOfByte == null) {
        p.hyc();
      }
      paramCamera.putParcelable("key_translate_camera_resolution", (Parcelable)paramArrayOfByte.hkU());
      paramArrayOfByte = getScanCamera();
      if (paramArrayOfByte == null) {
        p.hyc();
      }
      paramCamera.putInt("key_translate_camera_rotation", paramArrayOfByte.getCameraRotation());
      paramCamera.putLong("key_translate_capture_time", this.captureTime);
      paramArrayOfByte = this.CVu;
      if (paramArrayOfByte == null) {
        break label176;
      }
      paramArrayOfByte.c(System.currentTimeMillis(), paramCamera);
      AppMethodBeat.o(121017);
      return;
      i = 0;
      break;
    }
    label176:
    AppMethodBeat.o(121017);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121022);
    super.onResume();
    Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onResume");
    this.CMT[0] = System.currentTimeMillis();
    AppMethodBeat.o(121022);
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    AppMethodBeat.i(121016);
    super.setBottomExtraHeight(paramInt);
    View localView = this.CMz;
    if (localView == null) {
      p.btv("captureBtn");
    }
    Object localObject = this.CMz;
    if (localObject == null) {
      p.btv("captureBtn");
    }
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 24) + getMBottomExtraHeight());
    }
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(121016);
  }
  
  public final void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(121021);
    super.tY(paramBoolean);
    View localView = this.CMz;
    if (localView == null) {
      p.btv("captureBtn");
    }
    localView.setEnabled(true);
    this.CMT[0] = System.currentTimeMillis();
    setVisibility(0);
    if (getCurrentNetworkAvailable()) {
      m.a((View)this, 0.0F, 1.0F, 200L, null);
    }
    AppMethodBeat.o(121021);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ScanTranslationMaskView paramScanTranslationMaskView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(121010);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.d("MicroMsg.ScanTranslationMaskView", "alvinluo onCaptureBtn click");
      paramView = this.CVw.getScanCamera();
      if (paramView != null) {
        paramView.a((Camera.PreviewCallback)this.CVw);
      }
      ScanTranslationMaskView.a(this.CVw, (int)(System.currentTimeMillis() - ScanTranslationMaskView.a(this.CVw)[0]));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(121010);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView
 * JD-Core Version:    0.7.0.1
 */