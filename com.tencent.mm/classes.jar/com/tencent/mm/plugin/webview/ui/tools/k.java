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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;

public final class k
  implements LogoWebViewWrapper.b
{
  static final int JgQ = 2131235711;
  a JgM;
  ImageView JgN;
  LogoWebViewWrapper JgO;
  int JgP;
  private boolean JgR;
  private float JgS;
  private ValueAnimator JgT;
  private ViewPropertyAnimator JgU;
  private float JgV;
  View JgW;
  View JgX;
  TextView JgY;
  boolean JgZ;
  boolean Jha;
  private boolean Jhb;
  private boolean aWP;
  boolean lcy;
  private int zaj;
  
  public k()
  {
    AppMethodBeat.i(211096);
    this.JgP = 0;
    this.lcy = false;
    this.aWP = false;
    this.JgR = false;
    this.zaj = 0;
    this.JgS = 0.0F;
    this.JgZ = true;
    if (!WeChatBrands.AppInfo.current().isMainland()) {}
    for (;;)
    {
      this.Jha = bool;
      this.Jhb = false;
      AppMethodBeat.o(211096);
      return;
      bool = false;
    }
  }
  
  static boolean geY()
  {
    AppMethodBeat.i(258619);
    boolean bool = WeChatBrands.AppInfo.current().isMainland();
    AppMethodBeat.o(258619);
    return bool;
  }
  
  public final void aa(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(79933);
    Object localObject;
    String str1;
    if (this.JgN == null)
    {
      localObject = "null";
      if (this.JgN != null) {
        break label106;
      }
      str1 = "null";
      label27:
      if (this.JgN != null) {
        break label121;
      }
    }
    label106:
    label121:
    for (String str2 = "null";; str2 = String.valueOf(this.JgN.getAlpha()))
    {
      Log.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.lcy) {
        break label136;
      }
      AppMethodBeat.o(79933);
      return;
      localObject = String.valueOf(this.JgN.getVisibility());
      break;
      str1 = this.JgN.getDrawable().toString();
      break label27;
    }
    label136:
    if (paramInt == 0) {
      this.JgR = false;
    }
    if (this.JgN == null)
    {
      AppMethodBeat.o(79933);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.JgP) && (!this.aWP))
      {
        Log.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(79933);
        return;
      }
      if (this.aWP) {
        AppMethodBeat.o(79933);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.JgP) {
        break label458;
      }
      if (this.JgO != null) {
        this.JgO.setReleaseTargetHeight(this.JgP);
      }
    }
    if ((this.JgN != null) && (this.JgN.getAlpha() < 1.0F) && (this.JgU == null) && (paramBoolean))
    {
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.JgU = this.JgN.animate().alpha(1.0F).setDuration(500L);
      this.JgU.setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79921);
          super.onAnimationCancel(paramAnonymousAnimator);
          k.a(k.this);
          AppMethodBeat.o(79921);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(79922);
          super.onAnimationEnd(paramAnonymousAnimator);
          k.a(k.this);
          AppMethodBeat.o(79922);
        }
      });
      this.JgU.start();
    }
    int i;
    if (!this.JgR)
    {
      i = -paramInt - this.zaj;
      if (Math.abs(paramInt) < this.JgP) {
        break label476;
      }
      i *= 5;
    }
    for (;;)
    {
      this.zaj = (-paramInt);
      float f1 = this.JgN.getHeight() / 2.0F;
      float f2 = this.JgN.getWidth() / 2.0F;
      this.JgS -= i;
      this.JgN.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.JgN.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.JgN.setImageMatrix((Matrix)localObject);
      this.JgN.setImageResource(JgQ);
      this.JgN.invalidate();
      AppMethodBeat.o(79933);
      return;
      label458:
      if (this.JgO == null) {
        break;
      }
      this.JgO.setReleaseTargetHeight(0);
      break;
      label476:
      i *= 2;
    }
  }
  
  public final void agK(int paramInt)
  {
    AppMethodBeat.i(79929);
    if (this.JgW != null)
    {
      this.JgW.setBackgroundColor(paramInt);
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "setLogoBackgroundColor %d", new Object[] { Integer.valueOf(paramInt) });
    }
    AppMethodBeat.o(79929);
  }
  
  public final void geU()
  {
    AppMethodBeat.i(79923);
    this.lcy = false;
    stopLoading();
    if ((this.JgZ) && (this.JgX != null) && (!this.Jha))
    {
      zh(false);
      if (this.JgO != null) {
        this.JgO.setReleaseTargetHeight(0);
      }
      geX();
    }
    AppMethodBeat.o(79923);
  }
  
  public final void geV()
  {
    AppMethodBeat.i(211097);
    if (WeChatBrands.AppInfo.current().isMainland()) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jhb = bool;
      AppMethodBeat.o(211097);
      return;
    }
  }
  
  public final void geW()
  {
    AppMethodBeat.i(79931);
    if (this.JgX != null) {
      this.JgX.setVisibility(8);
    }
    AppMethodBeat.o(79931);
  }
  
  public final void geX()
  {
    AppMethodBeat.i(79932);
    if ((this.JgX != null) && (!this.Jhb)) {
      this.JgX.setVisibility(0);
    }
    AppMethodBeat.o(79932);
  }
  
  public final float getStartLoadingStep()
  {
    return this.JgV;
  }
  
  public final void release()
  {
    AppMethodBeat.i(79928);
    if (this.JgO != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.JgO;
      if (localLogoWebViewWrapper.Jea != null)
      {
        localLogoWebViewWrapper.Jea.removeView(localLogoWebViewWrapper.gxL);
        localLogoWebViewWrapper.gxL = null;
      }
      localLogoWebViewWrapper = this.JgO;
      localLogoWebViewWrapper.Jeh = null;
      localLogoWebViewWrapper.Jeg = null;
    }
    if (this.JgW != null) {
      ((ViewGroup)this.JgW).removeAllViews();
    }
    this.JgO = null;
    this.JgN = null;
    this.zaj = 0;
    if (this.JgT != null)
    {
      this.JgT.cancel();
      this.JgT = null;
    }
    AppMethodBeat.o(79928);
  }
  
  public final void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(79937);
    if ((!this.JgZ) || (this.Jha))
    {
      zh(true);
      if ((this.JgX != null) && (this.JgX.getVisibility() == 0)) {
        geW();
      }
      AppMethodBeat.o(79937);
      return;
    }
    if (this.JgY != null)
    {
      if (!Util.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!Util.isNullOrNil(paramString))
        {
          paramString = this.JgY.getContext().getString(2131768587, new Object[] { paramString });
          this.JgY.setVisibility(0);
          this.JgY.setText(paramString);
          zh(false);
          AppMethodBeat.o(79937);
          return;
        }
      }
      this.JgY.setVisibility(8);
    }
    AppMethodBeat.o(79937);
  }
  
  public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    AppMethodBeat.i(79924);
    if (this.JgO != null) {
      this.JgO.setMMOverScrollOffsetListener(paramb);
    }
    AppMethodBeat.o(79924);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(79934);
    this.JgV = paramFloat;
    this.JgN.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.JgN.getImageMatrix();
    float f1;
    if (this.JgN == null)
    {
      f1 = 0.0F;
      if (this.JgN != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.JgS = paramFloat;
      this.JgN.invalidate();
      AppMethodBeat.o(79934);
      return;
      f1 = this.JgN.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.JgN.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(79926);
    if (this.aWP)
    {
      AppMethodBeat.o(79926);
      return;
    }
    if ((this.JgN == null) || (this.JgO == null))
    {
      AppMethodBeat.o(79926);
      return;
    }
    this.aWP = true;
    this.JgO.zh(true);
    this.JgN.clearAnimation();
    if (this.JgT != null) {
      this.JgT.cancel();
    }
    this.JgT = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.JgS + 0.0F, this.JgS + 354.0F });
    this.JgT.setDuration(960L);
    this.JgT.setRepeatMode(1);
    this.JgT.setRepeatCount(-1);
    this.JgT.setInterpolator(new LinearInterpolator());
    this.JgT.start();
    if (this.JgM != null) {
      this.JgM.geZ();
    }
    AppMethodBeat.o(79926);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(79927);
    if (!this.aWP)
    {
      AppMethodBeat.o(79927);
      return;
    }
    Log.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.JgR = true;
    this.aWP = false;
    if ((this.JgO != null) && (this.lcy)) {
      this.JgO.zh(false);
    }
    if (this.JgT != null) {
      this.JgT.cancel();
    }
    if (this.JgO != null) {
      this.JgO.s(0, 250L);
    }
    if (this.JgN != null)
    {
      Log.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.JgN.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(79927);
  }
  
  public final void zh(boolean paramBoolean)
  {
    AppMethodBeat.i(79935);
    if ((this.JgO != null) && (this.JgO.Jed != paramBoolean))
    {
      this.JgO.zh(paramBoolean);
      geW();
      if ((WeChatBrands.AppInfo.current().isMainland()) && (!paramBoolean)) {
        break label63;
      }
    }
    label63:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Jha = paramBoolean;
      AppMethodBeat.o(79935);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void geZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */