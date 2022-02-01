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

public final class l
  implements LogoWebViewWrapper.b
{
  static final int Qed = c.e.webview_pulldown_refresh;
  private int Aze;
  a QdZ;
  ImageView Qea;
  LogoWebViewWrapper Qeb;
  int Qec;
  private boolean Qee;
  private float Qef;
  private ValueAnimator Qeg;
  private ViewPropertyAnimator Qeh;
  private float Qei;
  View Qej;
  View Qek;
  TextView Qel;
  TextView Qem;
  boolean Qen;
  boolean Qeo;
  private boolean Qep;
  private boolean aGh;
  boolean nWH;
  
  public l()
  {
    AppMethodBeat.i(267814);
    this.Qec = 0;
    this.nWH = false;
    this.aGh = false;
    this.Qee = false;
    this.Aze = 0;
    this.Qef = 0.0F;
    this.Qen = true;
    if (!WeChatBrands.AppInfo.current().isMainland()) {}
    for (;;)
    {
      this.Qeo = bool;
      this.Qep = false;
      AppMethodBeat.o(267814);
      return;
      bool = false;
    }
  }
  
  static boolean gYh()
  {
    AppMethodBeat.i(293246);
    boolean bool = WeChatBrands.AppInfo.current().isMainland();
    AppMethodBeat.o(293246);
    return bool;
  }
  
  public final void Dc(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.Qeb != null) && (this.Qeb.Qbd != paramBoolean))
    {
      this.Qeb.Dc(paramBoolean);
      gYf();
      if ((WeChatBrands.AppInfo.current().isMainland()) && (!paramBoolean)) {
        break label61;
      }
    }
    label61:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Qeo = paramBoolean;
      AppMethodBeat.o(79935);
      return;
    }
  }
  
  public final void aoA(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.Qej != null)
    {
      this.Qej.setBackgroundColor(paramInt);
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void bE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.Qea == null)
    {
      localObject = "null";
      if (this.Qea != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.Qea != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.Qea.getAlpha()))
    {
      Log.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.nWH) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.Qea.getVisibility());
      break;
      str1 = this.Qea.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.Qee = false;
    }
    if (this.Qea == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.Qec) && (!this.aGh))
      {
        Log.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(79933);
        return;
      }
      if (this.aGh) {
        AppMethodBeat.o(79933);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.Qec) {
        break label458;
      }
      if (this.Qeb != null) {
        this.Qeb.setReleaseTargetHeight(this.Qec);
      }
    }
    if ((this.Qea != null) && (this.Qea.getAlpha() < 1.0F) && (this.Qeh == null) && (paramBoolean))
    {
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.Qeh = this.Qea.animate().alpha(1.0F).setDuration(500L);
      this.Qeh.setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79921);
          super.onAnimationCancel(paramAnonymousAnimator);
          l.a(l.this);
          AppMethodBeat.o(79921);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79922);
          super.onAnimationEnd(paramAnonymousAnimator);
          l.a(l.this);
          AppMethodBeat.o(79922);
        }
      });
      this.Qeh.start();
    }
    int i;
    if (!this.Qee)
    {
      i = -paramInt - this.Aze;
      if (Math.abs(paramInt) < this.Qec) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.Aze = (-paramInt);
      float f1 = this.Qea.getHeight() / 2.0F;
      float f2 = this.Qea.getWidth() / 2.0F;
      this.Qef -= i;
      this.Qea.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.Qea.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.Qea.setImageMatrix((Matrix)localObject);
      this.Qea.setImageResource(Qed);
      this.Qea.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.Qeb == null) {
        break;
      }
      this.Qeb.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final void bmj(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.Qen) || (this.Qeo))
    {
      Dc(true);
      if ((this.Qek != null) && (this.Qek.getVisibility() == 0)) {
        gYf();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.Qel != null)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!Util.isNullOrNil(paramString))
        {
          paramString = this.Qel.getContext().getString(c.i.webview_logo_url, new Object[] { paramString });
          this.Qel.setVisibility(0);
          this.Qel.setText(paramString);
          Dc(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.Qel.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void gYe()
  {
    AppMethodBeat.i(79923);
    this.nWH = false;
    stopLoading();
    if ((this.Qen) && (this.Qek != null) && (!this.Qeo))
    {
      Dc(false);
      if (this.Qeb != null) {
        this.Qeb.setReleaseTargetHeight(0);
      }
      gYg();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void gYf()
  {
    AppMethodBeat.i(79931);
    if (this.Qek != null) {
      this.Qek.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void gYg()
  {
    AppMethodBeat.i(79932);
    if ((this.Qek != null) && (!this.Qep)) {
      this.Qek.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final float getStartLoadingStep()
  {
    return this.Qei;
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.Qeb != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.Qeb;
      if (localLogoWebViewWrapper.Qba != null)
      {
        localLogoWebViewWrapper.Qba.removeView(localLogoWebViewWrapper.jhN);
        localLogoWebViewWrapper.jhN = null;
      }
      localLogoWebViewWrapper = this.Qeb;
      localLogoWebViewWrapper.Qbh = null;
      localLogoWebViewWrapper.Qbg = null;
    }
    if (this.Qej != null) {
      ((ViewGroup)this.Qej).removeAllViews();
    }
    this.Qeb = null;
    this.Qea = null;
    this.Aze = 0;
    if (this.Qeg != null)
    {
      this.Qeg.cancel();
      this.Qeg = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.Qei = paramFloat;
    this.Qea.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.Qea.getImageMatrix();
    float f1;
    if (this.Qea == null)
    {
      f1 = 0.0F;
      if (this.Qea != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.Qef = paramFloat;
      this.Qea.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.Qea.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.Qea.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(79926);
    if (this.aGh)
    {
      AppMethodBeat.o(79926);
      return;
    }
    if ((this.Qea == null) || (this.Qeb == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.aGh = true;
    this.Qeb.Dc(true);
    this.Qea.clearAnimation();
    if (this.Qeg != null) {
      this.Qeg.cancel();
    }
    this.Qeg = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.Qef + 0.0F, this.Qef + 354.0F });
    this.Qeg.setDuration(960L);
    this.Qeg.setRepeatMode(1);
    this.Qeg.setRepeatCount(-1);
    this.Qeg.setInterpolator(new LinearInterpolator());
    this.Qeg.start();
    if (this.QdZ != null) {
      this.QdZ.gYi();
    }
    AppMethodBeat.o(79926);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(79927);
    if (!this.aGh)
    {
      AppMethodBeat.o(79927);
      return;
    }
    Log.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.Qee = true;
    this.aGh = false;
    if ((this.Qeb != null) && (this.nWH)) {
      this.Qeb.Dc(false);
    }
    if (this.Qeg != null) {
      this.Qeg.cancel();
    }
    if (this.Qeb != null) {
      this.Qeb.s(0, 250L);
    }
    if (this.Qea != null)
    {
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.Qea.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public static abstract interface a
  {
    public abstract void gYi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */