package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class l
  implements LogoWebViewWrapper.b
{
  static final int vcY = 2130840914;
  private boolean are = false;
  boolean hht = false;
  boolean noZ = false;
  l.a vcU;
  ImageView vcV;
  LogoWebViewWrapper vcW;
  int vcX = 0;
  private boolean vcZ = false;
  private int vda = 0;
  private float vdb = 0.0F;
  private ValueAnimator vdc;
  private ViewPropertyAnimator vdd;
  private float vde;
  View vdf;
  View vdg;
  TextView vdh;
  boolean vdi = true;
  boolean vdj = false;
  private boolean vdk = false;
  
  public final void Kw(int paramInt)
  {
    AppMethodBeat.i(7702);
    if (this.vdf != null) {
      this.vdf.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(7702);
  }
  
  public final void P(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(7703);
    Object localObject;
    String str1;
    if (this.vcV == null)
    {
      localObject = "null";
      if (this.vcV != null) {
        break label108;
      }
      str1 = "null";
      label28:
      if (this.vcV != null) {
        break label123;
      }
    }
    label108:
    label123:
    for (String str2 = "null";; str2 = String.valueOf(this.vcV.getAlpha()))
    {
      ab.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.hht) {
        break label138;
      }
      AppMethodBeat.o(7703);
      return;
      localObject = String.valueOf(this.vcV.getVisibility());
      break;
      str1 = this.vcV.getDrawable().toString();
      break label28;
    }
    label138:
    if (paramInt == 0) {
      this.vcZ = false;
    }
    if (this.vcV == null)
    {
      AppMethodBeat.o(7703);
      return;
    }
    if (!paramBoolean)
    {
      if ((Math.abs(paramInt) > this.vcX) && (!this.are))
      {
        ab.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        AppMethodBeat.o(7703);
        return;
      }
      if (this.are) {
        AppMethodBeat.o(7703);
      }
    }
    else
    {
      if (Math.abs(paramInt) < this.vcX) {
        break label464;
      }
      if (this.vcW != null) {
        this.vcW.setReleaseTargetHeight(this.vcX);
      }
    }
    if ((this.vcV != null) && (this.vcV.getAlpha() < 1.0F) && (this.vdd == null) && (paramBoolean))
    {
      ab.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.vdd = this.vcV.animate().alpha(1.0F).setDuration(500L);
      this.vdd.setListener(new l.1(this));
      this.vdd.start();
    }
    int i;
    if (!this.vcZ)
    {
      i = -paramInt - this.vda;
      if (Math.abs(paramInt) < this.vcX) {
        break label482;
      }
      i *= 5;
    }
    for (;;)
    {
      this.vda = (-paramInt);
      float f1 = this.vcV.getHeight() / 2.0F;
      float f2 = this.vcV.getWidth() / 2.0F;
      this.vdb -= i;
      this.vcV.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.vcV.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.vcV.setImageMatrix((Matrix)localObject);
      this.vcV.setImageResource(vcY);
      this.vcV.invalidate();
      AppMethodBeat.o(7703);
      return;
      label464:
      if (this.vcW == null) {
        break;
      }
      this.vcW.setReleaseTargetHeight(0);
      break;
      label482:
      i *= 2;
    }
  }
  
  public final boolean P(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(153222);
    if (this.vcW != null)
    {
      this.vcW.setForceOverScrollMode(true);
      this.vcW.onInterceptTouchEvent(paramMotionEvent);
      boolean bool = this.vcW.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(153222);
      return bool;
    }
    AppMethodBeat.o(153222);
    return false;
  }
  
  public final boolean aZH()
  {
    return false;
  }
  
  public final void ddX()
  {
    AppMethodBeat.i(7698);
    this.hht = false;
    stopLoading();
    if ((this.vdi) && (this.vdg != null) && (!this.vdj))
    {
      op(false);
      this.vcW.setReleaseTargetHeight(0);
      deb();
    }
    AppMethodBeat.o(7698);
  }
  
  public final void ddY()
  {
    AppMethodBeat.i(153221);
    if (this.vcW != null) {
      this.vcW.setEasyMod(true);
    }
    AppMethodBeat.o(153221);
  }
  
  public final void ddZ()
  {
    this.vdk = true;
  }
  
  public final void dea()
  {
    AppMethodBeat.i(153223);
    if (this.vdg != null) {
      this.vdg.setVisibility(8);
    }
    AppMethodBeat.o(153223);
  }
  
  public final void deb()
  {
    AppMethodBeat.i(153224);
    if ((this.vdg != null) && (!this.vdk)) {
      this.vdg.setVisibility(0);
    }
    AppMethodBeat.o(153224);
  }
  
  public final void dec()
  {
    AppMethodBeat.i(153225);
    this.noZ = true;
    this.vdj = false;
    this.vdi = true;
    if (this.vcW != null) {
      this.vcW.op(false);
    }
    AppMethodBeat.o(153225);
  }
  
  public final float getStartLoadingStep()
  {
    return this.vde;
  }
  
  public final void op(boolean paramBoolean)
  {
    AppMethodBeat.i(7705);
    if ((this.vcW != null) && (this.vcW.vat != paramBoolean))
    {
      this.vcW.op(paramBoolean);
      dea();
      this.vdj = paramBoolean;
    }
    AppMethodBeat.o(7705);
  }
  
  public final void release()
  {
    AppMethodBeat.i(7701);
    if (this.vcW != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.vcW;
      if (localLogoWebViewWrapper.van != null)
      {
        localLogoWebViewWrapper.van.removeView(localLogoWebViewWrapper.egP);
        localLogoWebViewWrapper.egP = null;
      }
      localLogoWebViewWrapper = this.vcW;
      localLogoWebViewWrapper.vax = null;
      localLogoWebViewWrapper.vaw = null;
    }
    if (this.vdf != null) {
      ((ViewGroup)this.vdf).removeAllViews();
    }
    this.vcW = null;
    this.vcV = null;
    this.vda = 0;
    if (this.vdc != null)
    {
      this.vdc.cancel();
      this.vdc = null;
    }
    AppMethodBeat.o(7701);
  }
  
  public final void setCurrentURL(String paramString)
  {
    AppMethodBeat.i(7706);
    if ((!this.vdi) || (this.vdj))
    {
      op(true);
      if ((this.vdg != null) && (this.vdg.getVisibility() == 0)) {
        dea();
      }
      AppMethodBeat.o(7706);
      return;
    }
    if (this.vdh != null)
    {
      if (!bo.isNullOrNil(paramString))
      {
        paramString = Uri.parse(paramString).getHost();
        if (!bo.isNullOrNil(paramString))
        {
          paramString = this.vdh.getContext().getString(2131305882, new Object[] { paramString });
          this.vdh.setVisibility(0);
          this.vdh.setText(paramString);
          op(false);
          AppMethodBeat.o(7706);
          return;
        }
      }
      this.vdh.setVisibility(8);
    }
    AppMethodBeat.o(7706);
  }
  
  public final void setMMOverScrollOffsetListener(LogoWebViewWrapper.b paramb)
  {
    AppMethodBeat.i(153220);
    if (this.vcW != null) {
      this.vcW.setMMOverScrollOffsetListener(paramb);
    }
    AppMethodBeat.o(153220);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(7704);
    this.vde = paramFloat;
    this.vcV.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.vcV.getImageMatrix();
    float f1;
    if (this.vcV == null)
    {
      f1 = 0.0F;
      if (this.vcV != null) {
        break label89;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.vdb = paramFloat;
      this.vcV.invalidate();
      AppMethodBeat.o(7704);
      return;
      f1 = this.vcV.getWidth() / 2.0F;
      break;
      label89:
      f2 = this.vcV.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(7699);
    if (this.are)
    {
      AppMethodBeat.o(7699);
      return;
    }
    if ((this.vcV == null) || (this.vcW == null))
    {
      AppMethodBeat.o(7699);
      return;
    }
    this.are = true;
    this.vcW.op(true);
    this.vcV.clearAnimation();
    if (this.vdc != null) {
      this.vdc.cancel();
    }
    this.vdc = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.vdb + 0.0F, this.vdb + 354.0F });
    this.vdc.setDuration(960L);
    this.vdc.setRepeatMode(1);
    this.vdc.setRepeatCount(-1);
    this.vdc.setInterpolator(new LinearInterpolator());
    this.vdc.start();
    if (this.vcU != null) {
      this.vcU.ded();
    }
    AppMethodBeat.o(7699);
  }
  
  public final void stopLoading()
  {
    AppMethodBeat.i(7700);
    if (!this.are)
    {
      AppMethodBeat.o(7700);
      return;
    }
    ab.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
    this.vcZ = true;
    this.are = false;
    if ((this.vcW != null) && (this.hht)) {
      this.vcW.op(false);
    }
    if (this.vdc != null) {
      this.vdc.cancel();
    }
    if (this.vcW != null) {
      this.vcW.q(0, 250L);
    }
    if (this.vcV != null)
    {
      ab.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
      this.vcV.animate().alpha(0.0F).setDuration(500L).start();
    }
    AppMethodBeat.o(7700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.l
 * JD-Core Version:    0.7.0.1
 */