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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
  implements LogoWebViewWrapper.b
{
  static final int Etx = 2131234743;
  private ValueAnimator EtA;
  private ViewPropertyAnimator EtB;
  private float EtC;
  View EtD;
  View EtE;
  TextView EtF;
  boolean EtG = true;
  boolean EtH = false;
  private boolean EtI = false;
  a Ett;
  ImageView Etu;
  LogoWebViewWrapper Etv;
  int Etw = 0;
  private boolean Ety = false;
  private float Etz = 0.0F;
  private boolean aWX = false;
  boolean jZw = false;
  private int vFj = 0;
  
  public final void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.Etu == null)
    {
      localObject = "null";
      if (this.Etu != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.Etu != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.Etu.getAlpha()))
    {
      ae.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.jZw) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.Etu.getVisibility());
      break;
      str1 = this.Etu.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.Ety = false;
    }
    if (this.Etu == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.Etw) && (!this.aWX))
      {
        ae.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
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
      if (Math.abs(paramInt) < this.Etw) {
        break label458;
      }
      if (this.Etv != null) {
        this.Etv.setReleaseTargetHeight(this.Etw);
      }
    }
    if ((this.Etu != null) && (this.Etu.getAlpha() < 1.0F) && (this.EtB == null) && (paramBoolean))
    {
      ae.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.EtB = this.Etu.animate().alpha(1.0F).setDuration(500L);
      this.EtB.setListener(new AnimatorListenerAdapter()
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
      this.EtB.start();
    }
    int i;
    if (!this.Ety)
    {
      i = -paramInt - this.vFj;
      if (Math.abs(paramInt) < this.Etw) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.vFj = (-paramInt);
      float f1 = this.Etu.getHeight() / 2.0F;
      float f2 = this.Etu.getWidth() / 2.0F;
      this.Etz -= i;
      this.Etu.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.Etu.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.Etu.setImageMatrix((Matrix)localObject);
      this.Etu.setImageResource(Etx);
      this.Etu.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.Etv == null) {
        break;
      }
      this.Etv.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final void Yc(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.EtD != null)
    {
      this.EtD.setBackgroundColor(paramInt);
      ae.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void eVZ()
  {
    AppMethodBeat.i(79923);
    this.jZw = false;
    stopLoading();
    if ((this.EtG) && (this.EtE != null) && (!this.EtH))
    {
      vm(false);
      this.Etv.setReleaseTargetHeight(0);
      eWc();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void eWa()
  {
    this.EtI = true;
  }
  
  public final void eWb()
  {
    AppMethodBeat.i(79931);
    if (this.EtE != null) {
      this.EtE.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void eWc()
  {
    AppMethodBeat.i(79932);
    if ((this.EtE != null) && (!this.EtI)) {
      this.EtE.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final float getStartLoadingStep()
  {
    return this.EtC;
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.Etv != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.Etv;
      if (localLogoWebViewWrapper.EqR != null)
      {
        localLogoWebViewWrapper.EqR.removeView(localLogoWebViewWrapper.fSD);
        localLogoWebViewWrapper.fSD = null;
      }
      localLogoWebViewWrapper = this.Etv;
      localLogoWebViewWrapper.Era = null;
      localLogoWebViewWrapper.EqZ = null;
    }
    if (this.EtD != null) {
      ((ViewGroup)this.EtD).removeAllViews();
    }
    this.Etv = null;
    this.Etu = null;
    this.vFj = 0;
    if (this.EtA != null)
    {
      this.EtA.cancel();
      this.EtA = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.EtG) || (this.EtH))
    {
      vm(true);
      if ((this.EtE != null) && (this.EtE.getVisibility() == 0)) {
        eWb();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.EtF != null)
    {
      if (!bu.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!bu.isNullOrNil(paramString))
        {
          paramString = this.EtF.getContext().getString(2131766116, new Object[] { paramString });
          this.EtF.setVisibility(0);
          this.EtF.setText(paramString);
          vm(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.EtF.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    AppMethodBeat.i(79924);
    if (this.Etv != null) {
      this.Etv.setMMOverScrollOffsetListener(paramb);
    }
    AppMethodBeat.o(79924);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.EtC = paramFloat;
    this.Etu.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.Etu.getImageMatrix();
    float f1;
    if (this.Etu == null)
    {
      f1 = 0.0F;
      if (this.Etu != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.Etz = paramFloat;
      this.Etu.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.Etu.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.Etu.getHeight() / 2.0F;
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
    if ((this.Etu == null) || (this.Etv == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.aWX = true;
    this.Etv.vm(true);
    this.Etu.clearAnimation();
    if (this.EtA != null) {
      this.EtA.cancel();
    }
    this.EtA = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.Etz + 0.0F, this.Etz + 354.0F });
    this.EtA.setDuration(960L);
    this.EtA.setRepeatMode(1);
    this.EtA.setRepeatCount(-1);
    this.EtA.setInterpolator(new LinearInterpolator());
    this.EtA.start();
    if (this.Ett != null) {
      this.Ett.eWd();
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
    ae.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.Ety = true;
    this.aWX = false;
    if ((this.Etv != null) && (this.jZw)) {
      this.Etv.vm(false);
    }
    if (this.EtA != null) {
      this.EtA.cancel();
    }
    if (this.Etv != null) {
      this.Etv.q(0, 250L);
    }
    if (this.Etu != null)
    {
      ae.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.Etu.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public final void vm(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.Etv != null) && (this.Etv.EqW != paramBoolean))
    {
      this.Etv.vm(paramBoolean);
      eWb();
      this.EtH = paramBoolean;
    }
    AppMethodBeat.o(79935);
  }
  
  public static abstract interface a
  {
    public abstract void eWd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */