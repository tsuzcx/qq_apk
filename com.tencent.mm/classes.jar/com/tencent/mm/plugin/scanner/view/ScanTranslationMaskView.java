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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.am.a.d;
import com.tencent.mm.plugin.am.a.e;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.model.ao;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/view/ScanTranslationMaskView;", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "Landroid/hardware/Camera$PreviewCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "captureBtn", "Landroid/view/View;", "captureTime", "", "isDestroyed", "", "startTimeArray", "", "translateHandler", "Lcom/tencent/mm/plugin/scanner/model/ScanTranslateHandler;", "init", "", "initView", "rootView", "onNetworkChange", "state", "onPreviewFrame", "bytes", "", "camera", "Landroid/hardware/Camera;", "onPreviewReady", "isSwitchTab", "onResume", "onViewDestroy", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "onViewReady", "processFrame", "setBottomExtraHeight", "bottomHeight", "updateViewByNetwork", "Companion", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanTranslationMaskView
  extends BaseScanMaskView<BaseScanRequest>
  implements Camera.PreviewCallback
{
  public static final ScanTranslationMaskView.a PkX;
  private View PaU;
  private final long[] Pbo;
  private ao PkY;
  private boolean aUP;
  private long captureTime;
  
  static
  {
    AppMethodBeat.i(121028);
    PkX = new ScanTranslationMaskView.a((byte)0);
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
    this.Pbo = new long[2];
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(a.e.layout_scan_translation_mask_view, (ViewGroup)this);
    s.s(paramAttributeSet, "view");
    paramAttributeSet = paramAttributeSet.findViewById(a.d.scan_capture_btn);
    s.s(paramAttributeSet, "rootView.findViewById(R.id.scan_capture_btn)");
    this.PaU = paramAttributeSet;
    View localView = this.PaU;
    paramAttributeSet = localView;
    if (localView == null)
    {
      s.bIx("captureBtn");
      paramAttributeSet = null;
    }
    paramAttributeSet.setEnabled(false);
    paramAttributeSet = this.PaU;
    if (paramAttributeSet == null)
    {
      s.bIx("captureBtn");
      paramAttributeSet = localObject;
    }
    for (;;)
    {
      paramAttributeSet.setOnClickListener(new ScanTranslationMaskView..ExternalSyntheticLambda0(this));
      this.PkY = new ao(paramContext);
      AppMethodBeat.o(121027);
      return;
    }
  }
  
  private static final void a(ScanTranslationMaskView paramScanTranslationMaskView, View paramView)
  {
    AppMethodBeat.i(314091);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramScanTranslationMaskView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramScanTranslationMaskView, "this$0");
    Log.d("MicroMsg.ScanTranslationMaskView", "alvinluo onCaptureBtn click");
    paramView = paramScanTranslationMaskView.getScanCamera();
    if (paramView != null) {
      paramView.c((Camera.PreviewCallback)paramScanTranslationMaskView);
    }
    paramScanTranslationMaskView.captureTime = ((int)(System.currentTimeMillis() - paramScanTranslationMaskView.Pbo[0]));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/view/ScanTranslationMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314091);
  }
  
  private final void gUu()
  {
    View localView2 = null;
    View localView1 = null;
    AppMethodBeat.i(121024);
    if (getCurrentNetworkAvailable())
    {
      localView2 = this.PaU;
      if (localView2 == null) {
        s.bIx("captureBtn");
      }
      for (;;)
      {
        localView1.setVisibility(0);
        AppMethodBeat.o(121024);
        return;
        localView1 = localView2;
      }
    }
    localView1 = this.PaU;
    if (localView1 == null)
    {
      s.bIx("captureBtn");
      localView1 = localView2;
    }
    for (;;)
    {
      localView1.setVisibility(8);
      AppMethodBeat.o(121024);
      return;
    }
  }
  
  public final void Ck(boolean paramBoolean)
  {
    AppMethodBeat.i(121021);
    super.Ck(paramBoolean);
    View localView2 = this.PaU;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("captureBtn");
      localView1 = null;
    }
    localView1.setEnabled(true);
    this.Pbo[0] = System.currentTimeMillis();
    setVisibility(0);
    if (getCurrentNetworkAvailable()) {
      p.a((View)this, 0.0F, 1.0F, 200L, null);
    }
    AppMethodBeat.o(121021);
  }
  
  public final void a(Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(121020);
    synchronized (Boolean.valueOf(this.aUP))
    {
      this.aUP = true;
      ah localah = ah.aiuX;
      p.a((View)this, 1.0F, 0.0F, 200L, paramAnimatorListener);
      AppMethodBeat.o(121020);
      return;
    }
  }
  
  public final void gTe()
  {
    AppMethodBeat.i(121019);
    super.gTe();
    synchronized (Boolean.valueOf(this.aUP))
    {
      this.aUP = false;
      ah localah = ah.aiuX;
      gUu();
      AppMethodBeat.o(121019);
      return;
    }
  }
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(121023);
    super.onNetworkChange(paramInt);
    Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onNetworkChange state: %d, currentNetworkAvailable: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(getCurrentNetworkAvailable()) });
    gUu();
    AppMethodBeat.o(121023);
  }
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(121017);
    if (paramArrayOfByte == null) {}
    for (paramCamera = null;; paramCamera = Integer.valueOf(paramArrayOfByte.length))
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
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (getScanCamera() != null))
      {
        paramCamera = new Bundle();
        paramCamera.putByteArray("key_translate_yuv_byte_array", paramArrayOfByte);
        paramArrayOfByte = getScanCamera();
        s.checkNotNull(paramArrayOfByte);
        paramCamera.putParcelable("key_translate_camera_resolution", (Parcelable)paramArrayOfByte.jXF());
        paramArrayOfByte = getScanCamera();
        s.checkNotNull(paramArrayOfByte);
        paramCamera.putInt("key_translate_camera_rotation", paramArrayOfByte.getCameraRotation());
        paramCamera.putLong("key_translate_capture_time", this.captureTime);
        paramArrayOfByte = this.PkY;
        if (paramArrayOfByte != null)
        {
          System.currentTimeMillis();
          paramArrayOfByte.aS(paramCamera);
        }
      }
      AppMethodBeat.o(121017);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(121022);
    super.onResume();
    Log.i("MicroMsg.ScanTranslationMaskView", "alvinluo onResume");
    this.Pbo[0] = System.currentTimeMillis();
    AppMethodBeat.o(121022);
  }
  
  public final void setBottomExtraHeight(int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(121016);
    super.setBottomExtraHeight(paramInt);
    View localView = this.PaU;
    Object localObject2;
    if (localView == null)
    {
      s.bIx("captureBtn");
      localView = null;
      localObject2 = this.PaU;
      if (localObject2 != null) {
        break label98;
      }
      s.bIx("captureBtn");
    }
    for (;;)
    {
      localObject1 = ((View)localObject1).getLayoutParams();
      if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(getContext(), 24) + getMBottomExtraHeight());
      }
      localObject2 = ah.aiuX;
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      AppMethodBeat.o(121016);
      return;
      break;
      label98:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView
 * JD-Core Version:    0.7.0.1
 */