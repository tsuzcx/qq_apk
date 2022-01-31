package com.tencent.mm.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
{
  int AuK;
  int AuL;
  private int AuM;
  private int AuN;
  float AuO;
  float AuP;
  private float AuQ;
  public float AuR;
  private int AuS;
  int AuT;
  float AuU;
  public int AuV;
  int AuW;
  int AuX;
  int AuY;
  int AuZ;
  private int Ava;
  private int Avb;
  int Avc;
  int Avd;
  int Ave;
  int Avf;
  int Avg;
  int Avh;
  private float ata;
  private float atb;
  private final Context context;
  private ak mHandler;
  int mHeight;
  int mWidth;
  private int qO;
  private int qP;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(107646);
    this.qO = 0;
    this.qP = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.AuK = 0;
    this.AuL = 0;
    this.AuM = 0;
    this.AuN = 0;
    this.ata = 0.0F;
    this.atb = 0.0F;
    this.AuO = 0.0F;
    this.AuP = 0.0F;
    this.AuQ = 1.0F;
    this.AuR = 1.0F;
    this.AuS = 0;
    this.AuT = 0;
    this.AuU = 1.0F;
    this.AuV = 0;
    this.AuW = 0;
    this.AuX = 0;
    this.AuY = 0;
    this.AuZ = 0;
    this.Ava = 300;
    this.Avb = 10;
    this.Avc = 0;
    this.Avd = 1;
    this.Ave = 2;
    this.Avf = 3;
    this.Avg = 4;
    this.Avh = this.Avc;
    this.mHandler = new ak();
    this.context = paramContext;
    AppMethodBeat.o(107646);
  }
  
  private void F(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(107647);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.qO == 0) && (this.qP == 0))
    {
      this.qO = (paramView.getWidth() / 2);
      this.qP = (paramView.getHeight() / 2);
    }
    this.AuM = (this.qO - arrayOfInt[0]);
    this.AuN = (this.qP - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.AuK;
      j = this.AuL;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.ata = (this.mWidth / i);
        this.atb = (this.mHeight / j);
      }
      float f1 = this.AuQ;
      if ((this.AuW != 0) || (this.AuX != 0) || (this.AuY != 0) || (this.AuZ != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.AuK != 0)
        {
          f1 = f2;
          if (this.AuL != 0)
          {
            this.ata = (this.mWidth / this.AuK);
            this.atb = (this.mHeight / this.AuL);
            f1 = f2;
          }
        }
      }
      if (this.AuR != 1.0D)
      {
        this.AuM += arrayOfInt[0];
        this.AuN += arrayOfInt[1];
        this.AuO = (this.ata * this.AuR);
        this.AuP = this.AuO;
        this.AuN = ((int)(this.AuN - this.AuT * this.AuO));
        this.AuM = ((int)(this.AuM - this.AuS * this.AuO));
        AppMethodBeat.o(107647);
        return;
      }
      if (this.ata > this.atb)
      {
        this.AuO = (this.ata * f1);
        this.AuN = ((int)(this.AuN - (j * this.AuO - this.mHeight * f1) / 2.0F));
        this.AuN = ((int)(this.AuN - this.mHeight * (f1 - 1.0F) / 2.0F - this.AuV * this.AuO / 2.0F));
        this.AuM = ((int)(this.AuM - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.AuL == 0) || (this.qP >= (j - this.AuL) / 2)) {
          break label677;
        }
        f2 = this.AuN;
      }
      for (this.AuN = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.AuN = ((int)(this.AuN - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label677:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.AuO = 0.5F;
            this.AuU = 0.0F;
            this.AuM = ((int)(this.AuM - i * this.AuO / 2.0F));
            this.AuN = ((int)(this.AuN - j * this.AuO / 2.0F - this.AuV * this.AuO / 2.0F));
          }
          AppMethodBeat.o(107647);
          return;
          this.AuO = (this.atb * f1);
          this.AuM = ((int)(this.AuM - (i * this.AuO - this.mWidth * f1) / 2.0F));
          if ((this.AuL == 0) || (this.AuL >= j)) {
            break;
          }
          this.AuN = ((int)(this.AuN - (j * this.AuO - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.AuL == 0) || (this.qP + this.mHeight <= (this.AuL + j) / 2));
      }
    }
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.qO = paramInt1;
    this.qP = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  public final void QP(int paramInt)
  {
    this.Ava = paramInt;
  }
  
  @TargetApi(16)
  public final void a(View paramView1, View paramView2, e.b paramb)
  {
    AppMethodBeat.i(107648);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.Avh == this.Ave) || (this.Avh == this.Avg) || (this.Avh == this.Avf))
    {
      ab.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.Avh), paramView1 });
      AppMethodBeat.o(107648);
      return;
    }
    F(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.AuO);
    paramView1.setScaleY(this.AuO);
    paramView1.setTranslationX(this.AuM);
    paramView1.setTranslationY(this.AuN);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.Ava).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F);
    }
    paramView1.animate().setDuration(this.Ava).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new e.1(this, paramb));
    this.mHandler.postDelayed(new e.2(this, paramView1), this.Avb);
    AppMethodBeat.o(107648);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.b paramb, final e.a parama)
  {
    AppMethodBeat.i(107649);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.Avh == this.Ave) || (this.Avh == this.Avg) || (this.Avh == this.Avd))
    {
      ab.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.Avh), paramView1 });
      AppMethodBeat.o(107649);
      return;
    }
    F(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F);
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.AuO, this.AuO, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(107643);
        int k;
        int i;
        int n;
        int i1;
        if ((e.this.AuK != 0) && (e.this.AuL != 0) && (e.this.AuR == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + e.this.AuV) / 2;
          k = (int)(((e.this.AuK - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          i = (int)(((e.this.AuL - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          if (e.this.AuR != 1.0F)
          {
            e.this.AuO = (e.this.AuP / e.this.AuR);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = e.this.AuT - localRect.top + (int)(e.this.AuL / 2.0F);
            k = (int)(((e.this.AuK - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
            i = (int)(((e.this.AuL - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + e.this.AuW * paramAnonymousFloat / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - e.this.AuV * (1.0F - paramAnonymousFloat) / 2.0F + e.this.AuY * paramAnonymousFloat / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          k = (int)(k / 2 + m - e.this.AuX * paramAnonymousFloat / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          i = (int)(i / 2 + j - e.this.AuZ * paramAnonymousFloat / (1.0F - (1.0F - e.this.AuO) * paramAnonymousFloat));
          if (Build.VERSION.SDK_INT < 21) {
            break label561;
          }
          paramView1.setClipBounds(new Rect(n, i1, k, i));
        }
        for (;;)
        {
          super.applyTransformation(paramAnonymousFloat, paramAnonymousTransformation);
          AppMethodBeat.o(107643);
          return;
          label561:
          if (Build.VERSION.SDK_INT >= 18) {
            if (parama != null) {
              parama.E(n, i1, k, i);
            } else {
              paramView1.setClipBounds(new Rect(n + paramView1.getScrollX(), i1, k + paramView1.getScrollX(), i));
            }
          }
        }
      }
    };
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new TranslateAnimation(0.0F, this.AuM, 0.0F, this.AuN);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.AuU);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(107645);
        ab.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (paramb != null) {
          paramb.onAnimationEnd();
        }
        e.this.Avh = e.this.Avd;
        AppMethodBeat.o(107645);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(107644);
        ab.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (paramb != null) {
          paramb.onAnimationStart();
        }
        e.this.Avh = e.this.Avg;
        AppMethodBeat.o(107644);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(107649);
  }
  
  public final void hO(int paramInt1, int paramInt2)
  {
    this.AuK = paramInt1;
    this.AuL = paramInt2;
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    this.AuW = paramInt1;
    this.AuX = paramInt2;
    this.AuY = 0;
    this.AuZ = 0;
  }
  
  public final void hQ(int paramInt1, int paramInt2)
  {
    this.AuS = paramInt1;
    this.AuT = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */