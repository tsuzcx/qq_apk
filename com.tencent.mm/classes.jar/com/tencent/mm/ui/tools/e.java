package com.tencent.mm.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  private float aqH = 0.0F;
  private float aqI = 0.0F;
  private final Context context;
  private ah mHandler = new ah();
  int mHeight = 0;
  int mWidth = 0;
  private int pR = 0;
  private int pS = 0;
  float wcA = 1.0F;
  public int wcB = 0;
  public int wcC = 0;
  public int wcD = 0;
  public int wcE = 0;
  public int wcF = 0;
  private int wcG = 300;
  private int wcH = 10;
  int wcI = 0;
  int wcJ = 1;
  int wcK = 2;
  int wcL = 3;
  int wcM = 4;
  int wcN = this.wcI;
  int wcq = 0;
  int wcr = 0;
  private int wcs = 0;
  private int wct = 0;
  float wcu = 0.0F;
  float wcv = 0.0F;
  private float wcw = 1.0F;
  public float wcx = 1.0F;
  private int wcy = 0;
  int wcz = 0;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void x(View paramView, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.pR == 0) && (this.pS == 0))
    {
      this.pR = (paramView.getWidth() / 2);
      this.pS = (paramView.getHeight() / 2);
    }
    this.wcs = (this.pR - arrayOfInt[0]);
    this.wct = (this.pS - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.wcq;
      j = this.wcr;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aqH = (this.mWidth / i);
        this.aqI = (this.mHeight / j);
      }
      float f1 = this.wcw;
      if ((this.wcC != 0) || (this.wcD != 0) || (this.wcE != 0) || (this.wcF != 0)) {
        f1 = 1.1F;
      }
      if (paramBoolean)
      {
        if ((this.wcq != 0) && (this.wcr != 0))
        {
          this.aqH = (this.mWidth / this.wcq);
          this.aqI = (this.mHeight / this.wcr);
        }
        f1 = 1.0F;
      }
      if (this.wcx != 1.0D)
      {
        this.wcs += arrayOfInt[0];
        this.wct += arrayOfInt[1];
        this.wcu = (this.aqH * this.wcx);
        this.wcv = this.wcu;
        this.wct = ((int)(this.wct - this.wcz * this.wcu));
        this.wcs = ((int)(this.wcs - this.wcy * this.wcu));
      }
      label652:
      label703:
      for (;;)
      {
        return;
        float f2;
        if (this.aqH > this.aqI)
        {
          this.wcu = (this.aqH * f1);
          this.wct = ((int)(this.wct - (j * this.wcu - this.mHeight * f1) / 2.0F));
          this.wct = ((int)(this.wct - this.mHeight * (f1 - 1.0F) / 2.0F - this.wcB * this.wcu / 2.0F));
          this.wcs = ((int)(this.wcs - this.mWidth * (f1 - 1.0F) / 2.0F));
          if ((this.wcr == 0) || (this.pS >= (j - this.wcr) / 2)) {
            break label652;
          }
          f2 = this.wct;
        }
        for (this.wct = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.wct = ((int)(this.wct - (f1 - 1.0F) * this.mHeight / 2.0F))) {
          do
          {
            if ((this.mWidth != 0) || (this.mHeight != 0)) {
              break label703;
            }
            this.wcu = 0.5F;
            this.wcA = 0.0F;
            this.wcs = ((int)(this.wcs - i * this.wcu / 2.0F));
            this.wct = ((int)(this.wct - j * this.wcu / 2.0F - this.wcB * this.wcu / 2.0F));
            return;
            this.wcu = (this.aqI * f1);
            this.wcs = ((int)(this.wcs - (i * this.wcu - this.mWidth * f1) / 2.0F));
            if ((this.wcr == 0) || (this.wcr >= j)) {
              break;
            }
            this.wct = ((int)(this.wct - (j * this.wcu - this.mHeight * f1) / 2.0F));
            break;
          } while ((this.wcr == 0) || (this.pS + this.mHeight <= (this.wcr + j) / 2));
        }
      }
    }
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.pR = paramInt1;
    this.pS = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  @TargetApi(16)
  public final void a(View paramView1, View paramView2, e.b paramb)
  {
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.wcN == this.wcK) || (this.wcN == this.wcM) || (this.wcN == this.wcL)) {
      return;
    }
    x(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.wcu);
    paramView1.setScaleY(this.wcu);
    paramView1.setTranslationX(this.wcs);
    paramView1.setTranslationY(this.wct);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.wcG).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F);
    }
    paramView1.animate().setDuration(this.wcG).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new e.1(this, paramb));
    this.mHandler.postDelayed(new e.2(this, paramView1), this.wcH);
  }
  
  @TargetApi(16)
  public final void a(View paramView1, View paramView2, e.b paramb, e.a parama)
  {
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.wcN == this.wcK) || (this.wcN == this.wcM) || (this.wcN == this.wcJ))
    {
      y.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.wcN), paramView1 });
      return;
    }
    x(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F);
    }
    paramView2 = new AnimationSet(true);
    parama = new e.3(this, this.wcu, this.wcu, paramView1, parama);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new TranslateAnimation(0.0F, this.wcs, 0.0F, this.wct);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.wcA);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new e.4(this, paramb));
    paramView1.startAnimation(paramView2);
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    this.wcq = paramInt1;
    this.wcr = paramInt2;
  }
  
  public final void fI(int paramInt1, int paramInt2)
  {
    this.wcy = paramInt1;
    this.wcz = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */