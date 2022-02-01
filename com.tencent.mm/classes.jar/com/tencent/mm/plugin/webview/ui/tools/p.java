package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;

public final class p
  implements LogoWebViewWrapper.b
{
  static final int WVY = c.e.webview_pulldown_refresh;
  private int ESj;
  a WVU;
  ImageView WVV;
  LogoWebViewWrapper WVW;
  int WVX;
  private boolean WVZ;
  private float WWa;
  private ValueAnimator WWb;
  private ViewPropertyAnimator WWc;
  private float WWd;
  View WWe;
  View WWf;
  TextView WWg;
  TextView WWh;
  boolean WWi;
  boolean WWj;
  private boolean WWk;
  private boolean loading;
  boolean qWv;
  
  public p()
  {
    AppMethodBeat.i(296095);
    this.WVX = 0;
    this.qWv = false;
    this.loading = false;
    this.WVZ = false;
    this.ESj = 0;
    this.WWa = 0.0F;
    this.WWi = true;
    if (!WeChatBrands.AppInfo.current().isMainland()) {}
    for (;;)
    {
      this.WWj = bool;
      this.WWk = false;
      AppMethodBeat.o(296095);
      return;
      bool = false;
    }
  }
  
  public final void IJ(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.WVW != null) && (this.WVW.WSo != paramBoolean))
    {
      this.WVW.IJ(paramBoolean);
      iyb();
      if ((WeChatBrands.AppInfo.current().isMainland()) && (!paramBoolean)) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.WWj = paramBoolean;
      AppMethodBeat.o(79935);
      return;
    }
  }
  
  public final void aut(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.WWe != null)
    {
      this.WWe.setBackgroundColor(paramInt);
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void blL(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.WWi) || (this.WWj))
    {
      IJ(true);
      if ((this.WWf != null) && (this.WWf.getVisibility() == 0)) {
        iyb();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.WWg != null)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!Util.isNullOrNil(paramString))
        {
          paramString = this.WWg.getContext().getString(c.i.webview_logo_url, new Object[] { paramString });
          this.WWg.setVisibility(0);
          this.WWg.setText(paramString);
          IJ(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.WWg.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void cm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.WVV == null)
    {
      localObject = "null";
      if (this.WVV != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.WVV != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.WVV.getAlpha()))
    {
      Log.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.qWv) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.WVV.getVisibility());
      break;
      str1 = this.WVV.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.WVZ = false;
    }
    if (this.WVV == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.WVX) && (!this.loading))
      {
        Log.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(79933);
        return;
      }
      if (this.loading) {
        AppMethodBeat.o(79933);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.WVX) {
        break label458;
      }
      if (this.WVW != null) {
        this.WVW.setReleaseTargetHeight(this.WVX);
      }
    }
    if ((this.WVV != null) && (this.WVV.getAlpha() < 1.0F) && (this.WWc == null) && (paramBoolean))
    {
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.WWc = this.WVV.animate().alpha(1.0F).setDuration(500L);
      this.WWc.setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79921);
          super.onAnimationCancel(paramAnonymousAnimator);
          p.a(p.this);
          AppMethodBeat.o(79921);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79922);
          super.onAnimationEnd(paramAnonymousAnimator);
          p.a(p.this);
          AppMethodBeat.o(79922);
        }
      });
      this.WWc.start();
    }
    int i;
    if (!this.WVZ)
    {
      i = -paramInt - this.ESj;
      if (Math.abs(paramInt) < this.WVX) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.ESj = (-paramInt);
      float f1 = this.WVV.getHeight() / 2.0F;
      float f2 = this.WVV.getWidth() / 2.0F;
      this.WWa -= i;
      this.WVV.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.WVV.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.WVV.setImageMatrix((Matrix)localObject);
      this.WVV.setImageResource(WVY);
      this.WVV.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.WVW == null) {
        break;
      }
      this.WVW.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final float getStartLoadingStep()
  {
    return this.WWd;
  }
  
  public final boolean ixm()
  {
    return false;
  }
  
  public final void iya()
  {
    AppMethodBeat.i(79923);
    this.qWv = false;
    stopLoading();
    if ((this.WWi) && (this.WWf != null) && (!this.WWj))
    {
      IJ(false);
      if (this.WVW != null) {
        this.WVW.setReleaseTargetHeight(0);
      }
      iyc();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void iyb()
  {
    AppMethodBeat.i(79931);
    if (this.WWf != null) {
      this.WWf.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void iyc()
  {
    AppMethodBeat.i(79932);
    if ((this.WWf != null) && (!this.WWk)) {
      this.WWf.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final void iyd()
  {
    AppMethodBeat.i(296139);
    WeChatBrands.AppInfo.current().isMainland();
    this.WWj = true;
    AppMethodBeat.o(296139);
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.WVW != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.WVW;
      if (localLogoWebViewWrapper.WSl != null)
      {
        localLogoWebViewWrapper.WSl.removeView(localLogoWebViewWrapper.lKd);
        localLogoWebViewWrapper.lKd = null;
      }
      localLogoWebViewWrapper = this.WVW;
      localLogoWebViewWrapper.WSs = null;
      localLogoWebViewWrapper.WSr = null;
    }
    if (this.WWe != null) {
      ((ViewGroup)this.WWe).removeAllViews();
    }
    this.WVW = null;
    this.WVV = null;
    this.ESj = 0;
    if (this.WWb != null)
    {
      this.WWb.cancel();
      this.WWb = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.WWd = paramFloat;
    this.WVV.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.WVV.getImageMatrix();
    float f1;
    if (this.WVV == null)
    {
      f1 = 0.0F;
      if (this.WVV != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.WWa = paramFloat;
      this.WVV.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.WVV.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.WVV.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(79926);
    if (this.loading)
    {
      AppMethodBeat.o(79926);
      return;
    }
    if ((this.WVV == null) || (this.WVW == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.loading = true;
    this.WVW.IJ(true);
    this.WVV.clearAnimation();
    if (this.WWb != null) {
      this.WWb.cancel();
    }
    this.WWb = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.WWa + 0.0F, this.WWa + 354.0F });
    this.WWb.setDuration(960L);
    this.WWb.setRepeatMode(1);
    this.WWb.setRepeatCount(-1);
    this.WWb.setInterpolator(new LinearInterpolator());
    this.WWb.start();
    if (this.WVU != null) {
      this.WVU.iye();
    }
    AppMethodBeat.o(79926);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(79927);
    if (!this.loading)
    {
      AppMethodBeat.o(79927);
      return;
    }
    Log.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.WVZ = true;
    this.loading = false;
    if ((this.WVW != null) && (this.qWv)) {
      this.WVW.IJ(false);
    }
    if (this.WWb != null) {
      this.WWb.cancel();
    }
    if (this.WVW != null) {
      this.WVW.w(0, 250L);
    }
    if (this.WVV != null)
    {
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.WVV.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public static abstract interface a
  {
    public abstract void iye();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.p
 * JD-Core Version:    0.7.0.1
 */