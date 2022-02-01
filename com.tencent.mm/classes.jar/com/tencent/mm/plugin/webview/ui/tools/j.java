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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class j
  implements LogoWebViewWrapper.b
{
  static final int CxN = 2131234743;
  a CxJ;
  ImageView CxK;
  LogoWebViewWrapper CxL;
  int CxM = 0;
  private boolean CxO = false;
  private float CxP = 0.0F;
  private ValueAnimator CxQ;
  private ViewPropertyAnimator CxR;
  private float CxS;
  View CxT;
  View CxU;
  TextView CxV;
  boolean CxW = true;
  boolean CxX = false;
  private boolean CxY = false;
  private boolean aMG = false;
  boolean jCl = false;
  private int uqz = 0;
  
  public final void S(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.CxK == null)
    {
      localObject = "null";
      if (this.CxK != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.CxK != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.CxK.getAlpha()))
    {
      ac.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.jCl) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.CxK.getVisibility());
      break;
      str1 = this.CxK.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.CxO = false;
    }
    if (this.CxK == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.CxM) && (!this.aMG))
      {
        ac.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(79933);
        return;
      }
      if (this.aMG) {
        AppMethodBeat.o(79933);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.CxM) {
        break label458;
      }
      if (this.CxL != null) {
        this.CxL.setReleaseTargetHeight(this.CxM);
      }
    }
    if ((this.CxK != null) && (this.CxK.getAlpha() < 1.0F) && (this.CxR == null) && (paramBoolean))
    {
      ac.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.CxR = this.CxK.animate().alpha(1.0F).setDuration(500L);
      this.CxR.setListener(new AnimatorListenerAdapter()
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
      this.CxR.start();
    }
    int i;
    if (!this.CxO)
    {
      i = -paramInt - this.uqz;
      if (Math.abs(paramInt) < this.CxM) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.uqz = (-paramInt);
      float f1 = this.CxK.getHeight() / 2.0F;
      float f2 = this.CxK.getWidth() / 2.0F;
      this.CxP -= i;
      this.CxK.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.CxK.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.CxK.setImageMatrix((Matrix)localObject);
      this.CxK.setImageResource(CxN);
      this.CxK.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.CxL == null) {
        break;
      }
      this.CxL.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final void VH(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.CxT != null)
    {
      this.CxT.setBackgroundColor(paramInt);
      ac.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void eDw()
  {
    AppMethodBeat.i(79923);
    this.jCl = false;
    stopLoading();
    if ((this.CxW) && (this.CxU != null) && (!this.CxX))
    {
      ut(false);
      this.CxL.setReleaseTargetHeight(0);
      eDz();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void eDx()
  {
    this.CxY = true;
  }
  
  public final void eDy()
  {
    AppMethodBeat.i(79931);
    if (this.CxU != null) {
      this.CxU.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void eDz()
  {
    AppMethodBeat.i(79932);
    if ((this.CxU != null) && (!this.CxY)) {
      this.CxU.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final float getStartLoadingStep()
  {
    return this.CxS;
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.CxL != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.CxL;
      if (localLogoWebViewWrapper.Cvi != null)
      {
        localLogoWebViewWrapper.Cvi.removeView(localLogoWebViewWrapper.fxk);
        localLogoWebViewWrapper.fxk = null;
      }
      localLogoWebViewWrapper = this.CxL;
      localLogoWebViewWrapper.Cvr = null;
      localLogoWebViewWrapper.Cvq = null;
    }
    if (this.CxT != null) {
      ((ViewGroup)this.CxT).removeAllViews();
    }
    this.CxL = null;
    this.CxK = null;
    this.uqz = 0;
    if (this.CxQ != null)
    {
      this.CxQ.cancel();
      this.CxQ = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.CxW) || (this.CxX))
    {
      ut(true);
      if ((this.CxU != null) && (this.CxU.getVisibility() == 0)) {
        eDy();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.CxV != null)
    {
      if (!bs.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!bs.isNullOrNil(paramString))
        {
          paramString = this.CxV.getContext().getString(2131766116, new Object[] { paramString });
          this.CxV.setVisibility(0);
          this.CxV.setText(paramString);
          ut(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.CxV.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    AppMethodBeat.i(79924);
    if (this.CxL != null) {
      this.CxL.setMMOverScrollOffsetListener(paramb);
    }
    AppMethodBeat.o(79924);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.CxS = paramFloat;
    this.CxK.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.CxK.getImageMatrix();
    float f1;
    if (this.CxK == null)
    {
      f1 = 0.0F;
      if (this.CxK != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.CxP = paramFloat;
      this.CxK.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.CxK.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.CxK.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(79926);
    if (this.aMG)
    {
      AppMethodBeat.o(79926);
      return;
    }
    if ((this.CxK == null) || (this.CxL == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.aMG = true;
    this.CxL.ut(true);
    this.CxK.clearAnimation();
    if (this.CxQ != null) {
      this.CxQ.cancel();
    }
    this.CxQ = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.CxP + 0.0F, this.CxP + 354.0F });
    this.CxQ.setDuration(960L);
    this.CxQ.setRepeatMode(1);
    this.CxQ.setRepeatCount(-1);
    this.CxQ.setInterpolator(new LinearInterpolator());
    this.CxQ.start();
    if (this.CxJ != null) {
      this.CxJ.eDA();
    }
    AppMethodBeat.o(79926);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(79927);
    if (!this.aMG)
    {
      AppMethodBeat.o(79927);
      return;
    }
    ac.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.CxO = true;
    this.aMG = false;
    if ((this.CxL != null) && (this.jCl)) {
      this.CxL.ut(false);
    }
    if (this.CxQ != null) {
      this.CxQ.cancel();
    }
    if (this.CxL != null) {
      this.CxL.q(0, 250L);
    }
    if (this.CxK != null)
    {
      ac.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.CxK.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public final void ut(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.CxL != null) && (this.CxL.Cvn != paramBoolean))
    {
      this.CxL.ut(paramBoolean);
      eDy();
      this.CxX = paramBoolean;
    }
    AppMethodBeat.o(79935);
  }
  
  public static abstract interface a
  {
    public abstract void eDA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */