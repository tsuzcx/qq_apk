package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  implements LogoWebViewWrapper.b
{
  static final int rmZ = R.g.webview_pulldown_refresh;
  private boolean aoK = false;
  boolean fOd = false;
  g.a rmV;
  ImageView rmW;
  LogoWebViewWrapper rmX;
  int rmY = 0;
  private boolean rna = false;
  private int rnb = 0;
  private float rnc = 0.0F;
  private ValueAnimator rnd;
  private ViewPropertyAnimator rne;
  private float rnf;
  View rng;
  View rnh;
  TextView rni;
  boolean rnj = true;
  boolean rnk = false;
  
  public final void CC(int paramInt)
  {
    if (this.rng != null) {
      this.rng.setBackgroundColor(paramInt);
    }
  }
  
  public final void ae(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    String str1;
    label22:
    String str2;
    if (this.rmW == null)
    {
      localObject = "null";
      if (this.rmW != null) {
        break label96;
      }
      str1 = "null";
      if (this.rmW != null) {
        break label111;
      }
      str2 = "null";
      label33:
      y.v("MicroMsg.WebViewPullDownLogoDelegate", "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localObject, str1, str2 });
      if (this.fOd) {
        break label126;
      }
    }
    label96:
    label111:
    label126:
    do
    {
      do
      {
        return;
        localObject = String.valueOf(this.rmW.getVisibility());
        break;
        str1 = this.rmW.getDrawable().toString();
        break label22;
        str2 = String.valueOf(this.rmW.getAlpha());
        break label33;
        if (paramInt == 0) {
          this.rna = false;
        }
      } while (this.rmW == null);
      if (paramBoolean) {
        break label397;
      }
      if ((Math.abs(paramInt) > this.rmY) && (!this.aoK))
      {
        y.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
        startLoading();
        return;
      }
    } while (this.aoK);
    if ((this.rmW != null) && (this.rmW.getAlpha() < 1.0F) && (this.rne == null) && (paramBoolean))
    {
      y.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
      this.rne = this.rmW.animate().alpha(1.0F).setDuration(500L);
      this.rne.setListener(new g.1(this));
      this.rne.start();
    }
    int i;
    if (!this.rna)
    {
      i = -paramInt - this.rnb;
      if (Math.abs(paramInt) < this.rmY) {
        break label447;
      }
      i *= 5;
    }
    for (;;)
    {
      this.rnb = (-paramInt);
      float f1 = this.rmW.getHeight() / 2.0F;
      float f2 = this.rmW.getWidth() / 2.0F;
      this.rnc -= i;
      this.rmW.setScaleType(ImageView.ScaleType.MATRIX);
      localObject = this.rmW.getImageMatrix();
      ((Matrix)localObject).postRotate(-i, f2, f1);
      this.rmW.setImageMatrix((Matrix)localObject);
      this.rmW.setImageResource(rmZ);
      this.rmW.invalidate();
      return;
      label397:
      if (Math.abs(paramInt) >= this.rmY)
      {
        if (this.rmX == null) {
          break;
        }
        this.rmX.setReleaseTargetHeight(this.rmY);
        break;
      }
      if (this.rmX == null) {
        break;
      }
      this.rmX.setReleaseTargetHeight(0);
      break;
      label447:
      i *= 2;
    }
  }
  
  public final void cdL()
  {
    this.fOd = false;
    stopLoading();
    if ((this.rnj) && (this.rnh != null) && (!this.rnk))
    {
      lh(false);
      this.rmX.setReleaseTargetHeight(0);
      this.rnh.setVisibility(0);
    }
  }
  
  public final float getStartLoadingStep()
  {
    return this.rnf;
  }
  
  public final void lh(boolean paramBoolean)
  {
    if ((this.rmX != null) && (this.rmX.rkS != paramBoolean))
    {
      this.rmX.lh(paramBoolean);
      if (this.rnh != null) {
        this.rnh.setVisibility(8);
      }
      this.rnk = paramBoolean;
    }
  }
  
  public final void release()
  {
    if (this.rmX != null)
    {
      LogoWebViewWrapper localLogoWebViewWrapper = this.rmX;
      if (localLogoWebViewWrapper.rkM != null)
      {
        localLogoWebViewWrapper.rkM.removeView(localLogoWebViewWrapper.dpt);
        localLogoWebViewWrapper.dpt = null;
      }
      localLogoWebViewWrapper = this.rmX;
      localLogoWebViewWrapper.rkW = null;
      localLogoWebViewWrapper.rkV = null;
    }
    if (this.rng != null) {
      ((ViewGroup)this.rng).removeAllViews();
    }
    this.rmX = null;
    this.rmW = null;
    this.rnb = 0;
    if (this.rnd != null)
    {
      this.rnd.cancel();
      this.rnd = null;
    }
  }
  
  public final void setCurrentURL(String paramString)
  {
    if ((!this.rnj) || (this.rnk))
    {
      lh(true);
      if ((this.rnh != null) && (this.rnh.getVisibility() == 0)) {
        this.rnh.setVisibility(8);
      }
    }
    while (this.rni == null) {
      return;
    }
    if (!bk.bl(paramString))
    {
      paramString = Uri.parse(paramString).getHost();
      if (!bk.bl(paramString))
      {
        paramString = this.rni.getContext().getString(R.l.webview_logo_url, new Object[] { paramString });
        this.rni.setVisibility(0);
        this.rni.setText(paramString);
        lh(false);
        return;
      }
    }
    this.rni.setVisibility(8);
  }
  
  public final void setStartLoadingStep(float paramFloat)
  {
    float f2 = 0.0F;
    this.rnf = paramFloat;
    this.rmW.setScaleType(ImageView.ScaleType.MATRIX);
    Matrix localMatrix = this.rmW.getImageMatrix();
    float f1;
    if (this.rmW == null)
    {
      f1 = 0.0F;
      if (this.rmW != null) {
        break label77;
      }
    }
    for (;;)
    {
      localMatrix.setRotate(paramFloat, f1, f2);
      this.rnc = paramFloat;
      this.rmW.invalidate();
      return;
      f1 = this.rmW.getWidth() / 2.0F;
      break;
      label77:
      f2 = this.rmW.getHeight() / 2.0F;
    }
  }
  
  public final void startLoading()
  {
    if (this.aoK) {}
    do
    {
      do
      {
        return;
      } while ((this.rmW == null) || (this.rmX == null));
      this.aoK = true;
      this.rmX.lh(true);
      this.rmW.clearAnimation();
      if (this.rnd != null) {
        this.rnd.cancel();
      }
      this.rnd = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[] { this.rnc + 0.0F, this.rnc + 354.0F });
      this.rnd.setDuration(960L);
      this.rnd.setRepeatMode(1);
      this.rnd.setRepeatCount(-1);
      this.rnd.setInterpolator(new LinearInterpolator());
      this.rnd.start();
    } while (this.rmV == null);
    this.rmV.cdM();
  }
  
  public final void stopLoading()
  {
    if (!this.aoK) {}
    do
    {
      return;
      y.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
      this.rna = true;
      this.aoK = false;
      if ((this.rmX != null) && (this.fOd)) {
        this.rmX.lh(false);
      }
      if (this.rnd != null) {
        this.rnd.cancel();
      }
      if (this.rmX != null) {
        this.rmX.o(0, 250L);
      }
    } while (this.rmW == null);
    y.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
    this.rmW.animate().alpha(0.0F).setDuration(500L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.g
 * JD-Core Version:    0.7.0.1
 */