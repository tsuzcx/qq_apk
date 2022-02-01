package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.f;

public final class e
{
  int HqD;
  int HqE;
  private int HqF;
  private int HqG;
  float HqH;
  float HqI;
  private float HqJ;
  public float HqK;
  private int HqL;
  int HqM;
  float HqN;
  public int HqO;
  int HqP;
  int HqQ;
  int HqR;
  int HqS;
  private int HqT;
  private int HqU;
  int HqV;
  int HqW;
  int HqX;
  int HqY;
  int HqZ;
  int Hra;
  d Hrb;
  f Hrc;
  private e.e Hrd;
  b Hre;
  private float aNK;
  private float aNL;
  float aOa;
  float aOb;
  private final Context context;
  private ap mHandler;
  int mHeight;
  VelocityTracker mVelocityTracker;
  int mWidth;
  boolean xCE;
  boolean xCF;
  boolean xCG;
  private int xo;
  private int xp;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(143093);
    this.xo = 0;
    this.xp = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.HqD = 0;
    this.HqE = 0;
    this.HqF = 0;
    this.HqG = 0;
    this.aNK = 0.0F;
    this.aNL = 0.0F;
    this.HqH = 0.0F;
    this.HqI = 0.0F;
    this.HqJ = 1.0F;
    this.HqK = 1.0F;
    this.HqL = 0;
    this.HqM = 0;
    this.HqN = 1.0F;
    this.HqO = 0;
    this.HqP = 0;
    this.HqQ = 0;
    this.HqR = 0;
    this.HqS = 0;
    this.HqT = 300;
    this.HqU = 10;
    this.HqV = 0;
    this.HqW = 1;
    this.HqX = 2;
    this.HqY = 3;
    this.HqZ = 4;
    this.Hra = this.HqV;
    this.mHandler = new ap();
    this.aOa = 0.0F;
    this.aOb = 0.0F;
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void I(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.xo == 0) && (this.xp == 0))
    {
      this.xo = (paramView.getWidth() / 2);
      this.xp = (paramView.getHeight() / 2);
    }
    this.HqF = (this.xo - arrayOfInt[0]);
    this.HqG = (this.xp - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.HqD;
      j = this.HqE;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aNK = (this.mWidth / i);
        this.aNL = (this.mHeight / j);
      }
      float f1 = this.HqJ;
      if ((this.HqP != 0) || (this.HqQ != 0) || (this.HqR != 0) || (this.HqS != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.HqD != 0)
        {
          f1 = f2;
          if (this.HqE != 0)
          {
            this.aNK = (this.mWidth / this.HqD);
            this.aNL = (this.mHeight / this.HqE);
            f1 = f2;
          }
        }
      }
      if (this.HqK != 1.0D)
      {
        this.HqF += arrayOfInt[0];
        this.HqG += arrayOfInt[1];
        this.HqH = (this.aNK * this.HqK);
        this.HqI = this.HqH;
        this.HqG = ((int)(this.HqG - this.HqM * this.HqH));
        this.HqF = ((int)(this.HqF - this.HqL * this.HqH));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.aNK > this.aNL)
      {
        this.HqH = (this.aNK * f1);
        this.HqG = ((int)(this.HqG - (j * this.HqH - this.mHeight * f1) / 2.0F));
        this.HqG = ((int)(this.HqG - this.mHeight * (f1 - 1.0F) / 2.0F - this.HqO * this.HqH / 2.0F));
        this.HqF = ((int)(this.HqF - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.HqE == 0) || (this.xp >= (j - this.HqE) / 2)) {
          break label677;
        }
        f2 = this.HqG;
      }
      for (this.HqG = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.HqG = ((int)(this.HqG - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label677:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.HqH = 0.5F;
            this.HqN = 0.0F;
            this.HqF = ((int)(this.HqF - i * this.HqH / 2.0F));
            this.HqG = ((int)(this.HqG - j * this.HqH / 2.0F - this.HqO * this.HqH / 2.0F));
          }
          AppMethodBeat.o(143094);
          return;
          this.HqH = (this.aNL * f1);
          this.HqF = ((int)(this.HqF - (i * this.HqH - this.mWidth * f1) / 2.0F));
          if ((this.HqE == 0) || (this.HqE >= j)) {
            break;
          }
          this.HqG = ((int)(this.HqG - (j * this.HqH - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.HqE == 0) || (this.xp + this.mHeight <= (this.HqE + j) / 2));
      }
    }
  }
  
  public final void P(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.xo = paramInt1;
    this.xp = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, final View paramView2, final e.c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.Hra == this.HqX) || (this.Hra == this.HqZ) || (this.Hra == this.HqY))
    {
      ad.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.Hra), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    I(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.HqH);
    paramView1.setScaleY(this.HqH);
    paramView1.setTranslationX(this.HqF);
    paramView1.setTranslationY(this.HqG);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.HqT).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(143081);
          paramView2.setLayerType(0, null);
          ad.i("MicroMsg.ImagePreviewAnimation", "pennqin, bg animation result, alpha %s.", new Object[] { Float.valueOf(paramView2.getAlpha()) });
          AppMethodBeat.o(143081);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(143080);
          paramView2.setLayerType(2, null);
          AppMethodBeat.o(143080);
        }
      });
    }
    paramView1.animate().setDuration(this.HqT).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        e.this.Hra = e.this.HqY;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.Hra = e.this.HqY;
        ad.i("MicroMsg.ImagePreviewAnimation", "pennqin, gallery animation result, sx %s, sy %s, tx %s, ty %s.", new Object[] { Float.valueOf(paramView1.getScaleX()), Float.valueOf(paramView1.getScaleY()), Float.valueOf(paramView1.getTranslationX()), Float.valueOf(paramView1.getTranslationY()) });
        AppMethodBeat.o(143083);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143082);
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.Hra = e.this.HqX;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143084);
        if (e.this.Hra == e.this.HqV)
        {
          ad.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        AppMethodBeat.o(143084);
      }
    }, this.HqU);
    AppMethodBeat.o(143095);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, final View paramView2, final e.c paramc, final a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.Hra == this.HqX) || (this.Hra == this.HqZ) || (this.Hra == this.HqW))
    {
      ad.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.Hra), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    I(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(143086);
          paramView2.setLayerType(0, null);
          AppMethodBeat.o(143086);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(143085);
          paramView2.setLayerType(2, null);
          AppMethodBeat.o(143085);
        }
      });
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.HqH, this.HqH, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((e.this.HqD != 0) && (e.this.HqE != 0) && (e.this.HqK == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + e.this.HqO) / 2;
          k = (int)(((e.this.HqD - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          i = (int)(((e.this.HqE - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          if (e.this.HqK != 1.0F)
          {
            e.this.HqH = (e.this.HqI / e.this.HqK);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = e.this.HqM - localRect.top + (int)(e.this.HqE / 2.0F);
            k = (int)(((e.this.HqD - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
            i = (int)(((e.this.HqE - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + e.this.HqP * paramAnonymousFloat / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - e.this.HqO * (1.0F - paramAnonymousFloat) / 2.0F + e.this.HqR * paramAnonymousFloat / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          k = (int)(k / 2 + m - e.this.HqQ * paramAnonymousFloat / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          i = (int)(i / 2 + j - e.this.HqS * paramAnonymousFloat / (1.0F - (1.0F - e.this.HqH) * paramAnonymousFloat));
          if (Build.VERSION.SDK_INT < 21) {
            break label561;
          }
          paramView1.setClipBounds(new Rect(n, i1, k, i));
        }
        for (;;)
        {
          super.applyTransformation(paramAnonymousFloat, paramAnonymousTransformation);
          AppMethodBeat.o(143087);
          return;
          label561:
          if (Build.VERSION.SDK_INT >= 18) {
            if (parama != null) {
              parama.I(n, i1, k, i);
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
    parama = new TranslateAnimation(0.0F, this.HqF, 0.0F, this.HqG);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.HqN);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143089);
        ad.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.Hra = e.this.HqW;
        AppMethodBeat.o(143089);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143088);
        ad.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.Hra = e.this.HqZ;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void a(b paramb)
  {
    this.Hre = paramb;
  }
  
  public final void a(d paramd)
  {
    this.Hrb = paramd;
  }
  
  public final void a(e.e parame)
  {
    this.Hrd = parame;
  }
  
  public final void a(f paramf)
  {
    this.Hrc = paramf;
  }
  
  public final void b(final View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(143097);
    paramView1.setOnTouchListener(new View.OnTouchListener()
    {
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143090);
        e.this.xCG = true;
        if (e.this.Hrb != null) {
          e.this.Hrb.aHp();
        }
        super.onLongPress(paramAnonymousMotionEvent);
        AppMethodBeat.o(143090);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143091);
        if (e.this.Hrc != null) {
          e.this.Hrc.onClick();
        }
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        AppMethodBeat.o(143091);
        return bool;
      }
    }
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143092);
        this.Hrk.onTouchEvent(paramAnonymousMotionEvent);
        if (e.this.mVelocityTracker == null) {
          e.this.mVelocityTracker = VelocityTracker.obtain();
        }
        e.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          e.this.aOa = paramAnonymousMotionEvent.getX();
          e.this.aOb = paramAnonymousMotionEvent.getY();
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if ((!e.this.xCF) || (!e.this.xCE)) {
            break label162;
          }
          e.a(e.this, 0.0F, 0.0F, paramView1, paramView2, paramView3);
          e.this.xCE = false;
        }
        label162:
        while (!e.this.xCE)
        {
          e.this.xCG = false;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break label414;
          }
          if (f.ab(paramAnonymousMotionEvent) != 2) {
            break;
          }
          AppMethodBeat.o(143092);
          return false;
        }
        if (e.this.Hre != null) {
          e.this.Hre.onExit();
        }
        for (;;)
        {
          e.this.xCE = false;
          e.this.xCF = false;
          break;
          e.this.a(paramView1, paramView2, this.Hrh, null);
        }
        paramAnonymousView = e.this.mVelocityTracker;
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - e.this.aOa;
        float f2 = paramAnonymousMotionEvent.getY() - e.this.aOb;
        if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!e.this.xCG)) || (e.this.xCE))
        {
          e.a(e.this, f1, f2, paramView1, paramView2, paramView3);
          e.this.xCE = true;
          if (f2 <= 200.0F) {
            break label432;
          }
        }
        label414:
        label432:
        for (e.this.xCF = false;; e.this.xCF = true)
        {
          if (e.this.mVelocityTracker != null)
          {
            e.this.mVelocityTracker.recycle();
            e.this.mVelocityTracker = null;
          }
          AppMethodBeat.o(143092);
          return false;
          e.this.xCE = false;
          break;
        }
      }
    });
    AppMethodBeat.o(143097);
  }
  
  public final void fdN()
  {
    this.HqK = 1.0F;
  }
  
  public final void jB(int paramInt1, int paramInt2)
  {
    this.HqD = paramInt1;
    this.HqE = paramInt2;
  }
  
  public final void jC(int paramInt1, int paramInt2)
  {
    this.HqP = paramInt1;
    this.HqQ = paramInt2;
    this.HqR = 0;
    this.HqS = 0;
  }
  
  public final void jD(int paramInt1, int paramInt2)
  {
    this.HqL = paramInt1;
    this.HqM = paramInt2;
  }
  
  @TargetApi(18)
  public static abstract interface a
  {
    public abstract void I(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface b
  {
    public abstract void onExit();
  }
  
  public static abstract interface d
  {
    public abstract void aHp();
  }
  
  public static abstract interface f
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */