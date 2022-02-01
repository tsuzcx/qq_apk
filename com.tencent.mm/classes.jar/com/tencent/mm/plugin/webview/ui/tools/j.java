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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  implements LogoWebViewWrapper.b
{
  static final int Ebw = 2131234743;
  private ViewPropertyAnimator EbA;
  private float EbB;
  View EbC;
  View EbD;
  TextView EbE;
  boolean EbF = true;
  boolean EbG = false;
  private boolean EbH = false;
  a Ebs;
  ImageView Ebt;
  LogoWebViewWrapper Ebu;
  int Ebv = 0;
  private boolean Ebx = false;
  private float Eby = 0.0F;
  private ValueAnimator Ebz;
  private boolean aWX = false;
  boolean jWh = false;
  private int vte = 0;
  
  public final void S(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.Ebt == null)
    {
      localObject = "null";
      if (this.Ebt != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.Ebt != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.Ebt.getAlpha()))
    {
      ad.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.jWh) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.Ebt.getVisibility());
      break;
      str1 = this.Ebt.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.Ebx = false;
    }
    if (this.Ebt == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.Ebv) && (!this.aWX))
      {
        ad.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(79933);
        return;
      }
      if (this.aWX) {
        AppMethodBeat.o(79933);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.Ebv) {
        break label458;
      }
      if (this.Ebu != null) {
        this.Ebu.setReleaseTargetHeight(this.Ebv);
      }
    }
    if ((this.Ebt != null) && (this.Ebt.getAlpha() < 1.0F) && (this.EbA == null) && (paramBoolean))
    {
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.EbA = this.Ebt.animate().alpha(1.0F).setDuration(500L);
      this.EbA.setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79921);
          super.onAnimationCancel(paramAnonymousAnimator);
          j.a(j.this);
          AppMethodBeat.o(79921);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79922);
          super.onAnimationEnd(paramAnonymousAnimator);
          j.a(j.this);
          AppMethodBeat.o(79922);
        }
      });
      this.EbA.start();
    }
    int i;
    if (!this.Ebx)
    {
      i = -paramInt - this.vte;
      if (Math.abs(paramInt) < this.Ebv) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.vte = (-paramInt);
      float f1 = this.Ebt.getHeight() / 2.0F;
      float f2 = this.Ebt.getWidth() / 2.0F;
      this.Eby -= i;
      this.Ebt.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.Ebt.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.Ebt.setImageMatrix((Matrix)localObject);
      this.Ebt.setImageResource(Ebw);
      this.Ebt.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.Ebu == null) {
        break;
      }
      this.Ebu.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final void Xw(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.EbC != null)
    {
      this.EbC.setBackgroundColor(paramInt);
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void eSn()
  {
    AppMethodBeat.i(79923);
    this.jWh = false;
    stopLoading();
    if ((this.EbF) && (this.EbD != null) && (!this.EbG))
    {
      ve(false);
      this.Ebu.setReleaseTargetHeight(0);
      eSq();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void eSo()
  {
    this.EbH = true;
  }
  
  public final void eSp()
  {
    AppMethodBeat.i(79931);
    if (this.EbD != null) {
      this.EbD.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void eSq()
  {
    AppMethodBeat.i(79932);
    if ((this.EbD != null) && (!this.EbH)) {
      this.EbD.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final float getStartLoadingStep()
  {
    return this.EbB;
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.Ebu != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.Ebu;
      if (localLogoWebViewWrapper.DYP != null)
      {
        localLogoWebViewWrapper.DYP.removeView(localLogoWebViewWrapper.fQx);
        localLogoWebViewWrapper.fQx = null;
      }
      localLogoWebViewWrapper = this.Ebu;
      localLogoWebViewWrapper.DYY = null;
      localLogoWebViewWrapper.DYX = null;
    }
    if (this.EbC != null) {
      ((ViewGroup)this.EbC).removeAllViews();
    }
    this.Ebu = null;
    this.Ebt = null;
    this.vte = 0;
    if (this.Ebz != null)
    {
      this.Ebz.cancel();
      this.Ebz = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.EbF) || (this.EbG))
    {
      ve(true);
      if ((this.EbD != null) && (this.EbD.getVisibility() == 0)) {
        eSp();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.EbE != null)
    {
      if (!bt.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!bt.isNullOrNil(paramString))
        {
          paramString = this.EbE.getContext().getString(2131766116, new Object[] { paramString });
          this.EbE.setVisibility(0);
          this.EbE.setText(paramString);
          ve(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.EbE.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    AppMethodBeat.i(79924);
    if (this.Ebu != null) {
      this.Ebu.setMMOverScrollOffsetListener(paramb);
    }
    AppMethodBeat.o(79924);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.EbB = paramFloat;
    this.Ebt.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.Ebt.getImageMatrix();
    float f1;
    if (this.Ebt == null)
    {
      f1 = 0.0F;
      if (this.Ebt != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.Eby = paramFloat;
      this.Ebt.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.Ebt.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.Ebt.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(79926);
    if (this.aWX)
    {
      AppMethodBeat.o(79926);
      return;
    }
    if ((this.Ebt == null) || (this.Ebu == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.aWX = true;
    this.Ebu.ve(true);
    this.Ebt.clearAnimation();
    if (this.Ebz != null) {
      this.Ebz.cancel();
    }
    this.Ebz = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.Eby + 0.0F, this.Eby + 354.0F });
    this.Ebz.setDuration(960L);
    this.Ebz.setRepeatMode(1);
    this.Ebz.setRepeatCount(-1);
    this.Ebz.setInterpolator(new LinearInterpolator());
    this.Ebz.start();
    if (this.Ebs != null) {
      this.Ebs.eSr();
    }
    AppMethodBeat.o(79926);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(79927);
    if (!this.aWX)
    {
      AppMethodBeat.o(79927);
      return;
    }
    ad.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.Ebx = true;
    this.aWX = false;
    if ((this.Ebu != null) && (this.jWh)) {
      this.Ebu.ve(false);
    }
    if (this.Ebz != null) {
      this.Ebz.cancel();
    }
    if (this.Ebu != null) {
      this.Ebu.q(0, 250L);
    }
    if (this.Ebt != null)
    {
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.Ebt.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public final void ve(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.Ebu != null) && (this.Ebu.DYU != paramBoolean))
    {
      this.Ebu.ve(paramBoolean);
      eSp();
      this.EbG = paramBoolean;
    }
    AppMethodBeat.o(79935);
  }
  
  public static abstract interface a
  {
    public abstract void eSr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */