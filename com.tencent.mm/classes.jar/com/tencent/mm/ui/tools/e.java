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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.f;

public final class e
{
  private e.e IRA;
  b IRB;
  int IRa;
  int IRb;
  private int IRc;
  private int IRd;
  float IRe;
  float IRf;
  private float IRg;
  public float IRh;
  private int IRi;
  int IRj;
  float IRk;
  public int IRl;
  int IRm;
  int IRn;
  int IRo;
  int IRp;
  private int IRq;
  private int IRr;
  int IRs;
  int IRt;
  int IRu;
  int IRv;
  int IRw;
  int IRx;
  d IRy;
  f IRz;
  private float aOA;
  private float aOB;
  float aOQ;
  float aOR;
  private final Context context;
  private ao mHandler;
  int mHeight;
  VelocityTracker mVelocityTracker;
  int mWidth;
  boolean yPs;
  boolean yPt;
  boolean yPu;
  private int ym;
  private int yn;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(143093);
    this.ym = 0;
    this.yn = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.IRa = 0;
    this.IRb = 0;
    this.IRc = 0;
    this.IRd = 0;
    this.aOA = 0.0F;
    this.aOB = 0.0F;
    this.IRe = 0.0F;
    this.IRf = 0.0F;
    this.IRg = 1.0F;
    this.IRh = 1.0F;
    this.IRi = 0;
    this.IRj = 0;
    this.IRk = 1.0F;
    this.IRl = 0;
    this.IRm = 0;
    this.IRn = 0;
    this.IRo = 0;
    this.IRp = 0;
    this.IRq = 300;
    this.IRr = 10;
    this.IRs = 0;
    this.IRt = 1;
    this.IRu = 2;
    this.IRv = 3;
    this.IRw = 4;
    this.IRx = this.IRs;
    this.mHandler = new ao();
    this.aOQ = 0.0F;
    this.aOR = 0.0F;
    this.yPs = false;
    this.yPt = false;
    this.yPu = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void I(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.ym == 0) && (this.yn == 0))
    {
      this.ym = (paramView.getWidth() / 2);
      this.yn = (paramView.getHeight() / 2);
    }
    this.IRc = (this.ym - arrayOfInt[0]);
    this.IRd = (this.yn - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.IRa;
      j = this.IRb;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aOA = (this.mWidth / i);
        this.aOB = (this.mHeight / j);
      }
      float f1 = this.IRg;
      if ((this.IRm != 0) || (this.IRn != 0) || (this.IRo != 0) || (this.IRp != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.IRa != 0)
        {
          f1 = f2;
          if (this.IRb != 0)
          {
            this.aOA = (this.mWidth / this.IRa);
            this.aOB = (this.mHeight / this.IRb);
            f1 = f2;
          }
        }
      }
      if (this.IRh != 1.0D)
      {
        this.IRc += arrayOfInt[0];
        this.IRd += arrayOfInt[1];
        this.IRe = (this.aOA * this.IRh);
        this.IRf = this.IRe;
        this.IRd = ((int)(this.IRd - this.IRj * this.IRe));
        this.IRc = ((int)(this.IRc - this.IRi * this.IRe));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.aOA > this.aOB)
      {
        this.IRe = (this.aOA * f1);
        this.IRd = ((int)(this.IRd - (j * this.IRe - this.mHeight * f1) / 2.0F));
        this.IRd = ((int)(this.IRd - this.mHeight * (f1 - 1.0F) / 2.0F - this.IRl * this.IRe / 2.0F));
        this.IRc = ((int)(this.IRc - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.IRb == 0) || (this.yn >= (j - this.IRb) / 2)) {
          break label677;
        }
        f2 = this.IRd;
      }
      for (this.IRd = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.IRd = ((int)(this.IRd - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label677:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.IRe = 0.5F;
            this.IRk = 0.0F;
            this.IRc = ((int)(this.IRc - i * this.IRe / 2.0F));
            this.IRd = ((int)(this.IRd - j * this.IRe / 2.0F - this.IRl * this.IRe / 2.0F));
          }
          AppMethodBeat.o(143094);
          return;
          this.IRe = (this.aOB * f1);
          this.IRc = ((int)(this.IRc - (i * this.IRe - this.mWidth * f1) / 2.0F));
          if ((this.IRb == 0) || (this.IRb >= j)) {
            break;
          }
          this.IRd = ((int)(this.IRd - (j * this.IRe - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.IRb == 0) || (this.yn + this.mHeight <= (this.IRb + j) / 2));
      }
    }
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ym = paramInt1;
    this.yn = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.IRx == this.IRu) || (this.IRx == this.IRw) || (this.IRx == this.IRv))
    {
      ac.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.IRx), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    I(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.IRe);
    paramView1.setScaleY(this.IRe);
    paramView1.setTranslationX(this.IRc);
    paramView1.setTranslationY(this.IRd);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.IRq).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new e.1(this, paramView2));
    }
    paramView1.animate().setDuration(this.IRq).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        e.this.IRx = e.this.IRv;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.IRx = e.this.IRv;
        ac.i("MicroMsg.ImagePreviewAnimation", "pennqin, gallery animation result, sx %s, sy %s, tx %s, ty %s.", new Object[] { Float.valueOf(paramView1.getScaleX()), Float.valueOf(paramView1.getScaleY()), Float.valueOf(paramView1.getTranslationX()), Float.valueOf(paramView1.getTranslationY()) });
        AppMethodBeat.o(143083);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143082);
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.IRx = e.this.IRu;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143084);
        if (e.this.IRx == e.this.IRs)
        {
          ac.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        AppMethodBeat.o(143084);
      }
    }, this.IRr);
    AppMethodBeat.o(143095);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.c paramc, final a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.IRx == this.IRu) || (this.IRx == this.IRw) || (this.IRx == this.IRt))
    {
      ac.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.IRx), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    I(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F).setListener(new e.4(this, paramView2));
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.IRe, this.IRe, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((e.this.IRa != 0) && (e.this.IRb != 0) && (e.this.IRh == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + e.this.IRl) / 2;
          k = (int)(((e.this.IRa - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
          i = (int)(((e.this.IRb - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
          if (e.this.IRh != 1.0F)
          {
            e.this.IRe = (e.this.IRf / e.this.IRh);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = e.this.IRj - localRect.top + (int)(e.this.IRb / 2.0F);
            k = (int)(((e.this.IRa - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
            i = (int)(((e.this.IRb - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + e.this.IRm * paramAnonymousFloat / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - e.this.IRl * (1.0F - paramAnonymousFloat) / 2.0F + e.this.IRo * paramAnonymousFloat / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
          k = (int)(k / 2 + m - e.this.IRn * paramAnonymousFloat / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
          i = (int)(i / 2 + j - e.this.IRp * paramAnonymousFloat / (1.0F - (1.0F - e.this.IRe) * paramAnonymousFloat));
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
              parama.K(n, i1, k, i);
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
    parama = new TranslateAnimation(0.0F, this.IRc, 0.0F, this.IRd);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.IRk);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143089);
        ac.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.IRx = e.this.IRt;
        AppMethodBeat.o(143089);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143088);
        ac.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.IRx = e.this.IRw;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void a(b paramb)
  {
    this.IRB = paramb;
  }
  
  public final void a(d paramd)
  {
    this.IRy = paramd;
  }
  
  public final void a(e.e parame)
  {
    this.IRA = parame;
  }
  
  public final void a(f paramf)
  {
    this.IRz = paramf;
  }
  
  public final void b(final View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(143097);
    paramView1.setOnTouchListener(new View.OnTouchListener()
    {
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143090);
        e.this.yPu = true;
        if (e.this.IRy != null) {
          e.this.IRy.aOe();
        }
        super.onLongPress(paramAnonymousMotionEvent);
        AppMethodBeat.o(143090);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143091);
        if (e.this.IRz != null) {
          e.this.IRz.onClick();
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
        this.IRH.onTouchEvent(paramAnonymousMotionEvent);
        if (e.this.mVelocityTracker == null) {
          e.this.mVelocityTracker = VelocityTracker.obtain();
        }
        e.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          e.this.aOQ = paramAnonymousMotionEvent.getX();
          e.this.aOR = paramAnonymousMotionEvent.getY();
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if ((!e.this.yPt) || (!e.this.yPs)) {
            break label162;
          }
          e.a(e.this, 0.0F, 0.0F, paramView1, paramView2, paramView3);
          e.this.yPs = false;
        }
        label162:
        while (!e.this.yPs)
        {
          e.this.yPu = false;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break label414;
          }
          if (f.ab(paramAnonymousMotionEvent) != 2) {
            break;
          }
          AppMethodBeat.o(143092);
          return false;
        }
        if (e.this.IRB != null) {
          e.this.IRB.onExit();
        }
        for (;;)
        {
          e.this.yPs = false;
          e.this.yPt = false;
          break;
          e.this.a(paramView1, paramView2, this.IRE, null);
        }
        paramAnonymousView = e.this.mVelocityTracker;
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - e.this.aOQ;
        float f2 = paramAnonymousMotionEvent.getY() - e.this.aOR;
        if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!e.this.yPu)) || (e.this.yPs))
        {
          e.a(e.this, f1, f2, paramView1, paramView2, paramView3);
          e.this.yPs = true;
          if (f2 <= 200.0F) {
            break label432;
          }
        }
        label414:
        label432:
        for (e.this.yPt = false;; e.this.yPt = true)
        {
          if (e.this.mVelocityTracker != null)
          {
            e.this.mVelocityTracker.recycle();
            e.this.mVelocityTracker = null;
          }
          AppMethodBeat.o(143092);
          return false;
          e.this.yPs = false;
          break;
        }
      }
    });
    AppMethodBeat.o(143097);
  }
  
  public final void ftI()
  {
    this.IRh = 1.0F;
  }
  
  public final void jN(int paramInt1, int paramInt2)
  {
    this.IRa = paramInt1;
    this.IRb = paramInt2;
  }
  
  public final void jO(int paramInt1, int paramInt2)
  {
    this.IRm = paramInt1;
    this.IRn = paramInt2;
    this.IRo = 0;
    this.IRp = 0;
  }
  
  public final void jP(int paramInt1, int paramInt2)
  {
    this.IRi = paramInt1;
    this.IRj = paramInt2;
  }
  
  @TargetApi(18)
  public static abstract interface a
  {
    public abstract void K(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface b
  {
    public abstract void onExit();
  }
  
  public static abstract interface d
  {
    public abstract void aOe();
  }
  
  public static abstract interface f
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */