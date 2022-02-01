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
  static final int BfB = 2131234743;
  int BfA = 0;
  private boolean BfC = false;
  private float BfD = 0.0F;
  private ValueAnimator BfE;
  private ViewPropertyAnimator BfF;
  private float BfG;
  View BfH;
  View BfI;
  TextView BfJ;
  boolean BfK = true;
  boolean BfL = false;
  private boolean BfM = false;
  a Bfx;
  ImageView Bfy;
  LogoWebViewWrapper Bfz;
  private boolean aLQ = false;
  boolean jbY = false;
  private int tik = 0;
  
  public final void S(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.Bfy == null)
    {
      localObject = "null";
      if (this.Bfy != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.Bfy != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.Bfy.getAlpha()))
    {
      ad.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.jbY) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.Bfy.getVisibility());
      break;
      str1 = this.Bfy.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.BfC = false;
    }
    if (this.Bfy == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.BfA) && (!this.aLQ))
      {
        ad.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(79933);
        return;
      }
      if (this.aLQ) {
        AppMethodBeat.o(79933);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.BfA) {
        break label458;
      }
      if (this.Bfz != null) {
        this.Bfz.setReleaseTargetHeight(this.BfA);
      }
    }
    if ((this.Bfy != null) && (this.Bfy.getAlpha() < 1.0F) && (this.BfF == null) && (paramBoolean))
    {
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.BfF = this.Bfy.animate().alpha(1.0F).setDuration(500L);
      this.BfF.setListener(new AnimatorListenerAdapter()
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
      this.BfF.start();
    }
    int i;
    if (!this.BfC)
    {
      i = -paramInt - this.tik;
      if (Math.abs(paramInt) < this.BfA) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.tik = (-paramInt);
      float f1 = this.Bfy.getHeight() / 2.0F;
      float f2 = this.Bfy.getWidth() / 2.0F;
      this.BfD -= i;
      this.Bfy.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.Bfy.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.Bfy.setImageMatrix((Matrix)localObject);
      this.Bfy.setImageResource(BfB);
      this.Bfy.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.Bfz == null) {
        break;
      }
      this.Bfz.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final void Tz(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.BfH != null)
    {
      this.BfH.setBackgroundColor(paramInt);
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void eoc()
  {
    AppMethodBeat.i(79923);
    this.jbY = false;
    stopLoading();
    if ((this.BfK) && (this.BfI != null) && (!this.BfL))
    {
      tr(false);
      this.Bfz.setReleaseTargetHeight(0);
      eof();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void eod()
  {
    this.BfM = true;
  }
  
  public final void eoe()
  {
    AppMethodBeat.i(79931);
    if (this.BfI != null) {
      this.BfI.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void eof()
  {
    AppMethodBeat.i(79932);
    if ((this.BfI != null) && (!this.BfM)) {
      this.BfI.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final float getStartLoadingStep()
  {
    return this.BfG;
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.Bfz != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.Bfz;
      if (localLogoWebViewWrapper.BcW != null)
      {
        localLogoWebViewWrapper.BcW.removeView(localLogoWebViewWrapper.ftD);
        localLogoWebViewWrapper.ftD = null;
      }
      localLogoWebViewWrapper = this.Bfz;
      localLogoWebViewWrapper.Bdg = null;
      localLogoWebViewWrapper.Bdf = null;
    }
    if (this.BfH != null) {
      ((ViewGroup)this.BfH).removeAllViews();
    }
    this.Bfz = null;
    this.Bfy = null;
    this.tik = 0;
    if (this.BfE != null)
    {
      this.BfE.cancel();
      this.BfE = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.BfK) || (this.BfL))
    {
      tr(true);
      if ((this.BfI != null) && (this.BfI.getVisibility() == 0)) {
        eoe();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.BfJ != null)
    {
      if (!bt.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!bt.isNullOrNil(paramString))
        {
          paramString = this.BfJ.getContext().getString(2131766116, new Object[] { paramString });
          this.BfJ.setVisibility(0);
          this.BfJ.setText(paramString);
          tr(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.BfJ.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    AppMethodBeat.i(79924);
    if (this.Bfz != null) {
      this.Bfz.setMMOverScrollOffsetListener(paramb);
    }
    AppMethodBeat.o(79924);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.BfG = paramFloat;
    this.Bfy.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.Bfy.getImageMatrix();
    float f1;
    if (this.Bfy == null)
    {
      f1 = 0.0F;
      if (this.Bfy != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.BfD = paramFloat;
      this.Bfy.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.Bfy.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.Bfy.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(79926);
    if (this.aLQ)
    {
      AppMethodBeat.o(79926);
      return;
    }
    if ((this.Bfy == null) || (this.Bfz == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.aLQ = true;
    this.Bfz.tr(true);
    this.Bfy.clearAnimation();
    if (this.BfE != null) {
      this.BfE.cancel();
    }
    this.BfE = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.BfD + 0.0F, this.BfD + 354.0F });
    this.BfE.setDuration(960L);
    this.BfE.setRepeatMode(1);
    this.BfE.setRepeatCount(-1);
    this.BfE.setInterpolator(new LinearInterpolator());
    this.BfE.start();
    if (this.Bfx != null) {
      this.Bfx.eog();
    }
    AppMethodBeat.o(79926);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(79927);
    if (!this.aLQ)
    {
      AppMethodBeat.o(79927);
      return;
    }
    ad.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.BfC = true;
    this.aLQ = false;
    if ((this.Bfz != null) && (this.jbY)) {
      this.Bfz.tr(false);
    }
    if (this.BfE != null) {
      this.BfE.cancel();
    }
    if (this.Bfz != null) {
      this.Bfz.r(0, 250L);
    }
    if (this.Bfy != null)
    {
      ad.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.Bfy.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public final void tr(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.Bfz != null) && (this.Bfz.Bdc != paramBoolean))
    {
      this.Bfz.tr(paramBoolean);
      eoe();
      this.BfL = paramBoolean;
    }
    AppMethodBeat.o(79935);
  }
  
  public static abstract interface a
  {
    public abstract void eog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j
 * JD-Core Version:    0.7.0.1
 */