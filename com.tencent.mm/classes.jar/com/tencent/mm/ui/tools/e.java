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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.f;

public final class e
{
  private int Af;
  private int Ag;
  boolean Aya;
  boolean Ayb;
  boolean Ayc;
  private int LeA;
  private int LeB;
  float LeC;
  float LeD;
  private float LeE;
  public float LeF;
  private int LeG;
  int LeH;
  float LeI;
  public int LeJ;
  int LeK;
  int LeL;
  int LeM;
  int LeN;
  private int LeO;
  private int LeP;
  int LeQ;
  int LeR;
  int LeS;
  int LeT;
  int LeU;
  int LeV;
  d LeW;
  f LeX;
  private e.e LeY;
  b LeZ;
  int Ley;
  int Lez;
  private float aYU;
  private float aYV;
  float aZk;
  float aZl;
  private final Context context;
  private aq mHandler;
  int mHeight;
  VelocityTracker mVelocityTracker;
  int mWidth;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(143093);
    this.Af = 0;
    this.Ag = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.Ley = 0;
    this.Lez = 0;
    this.LeA = 0;
    this.LeB = 0;
    this.aYU = 0.0F;
    this.aYV = 0.0F;
    this.LeC = 0.0F;
    this.LeD = 0.0F;
    this.LeE = 1.0F;
    this.LeF = 1.0F;
    this.LeG = 0;
    this.LeH = 0;
    this.LeI = 1.0F;
    this.LeJ = 0;
    this.LeK = 0;
    this.LeL = 0;
    this.LeM = 0;
    this.LeN = 0;
    this.LeO = 300;
    this.LeP = 10;
    this.LeQ = 0;
    this.LeR = 1;
    this.LeS = 2;
    this.LeT = 3;
    this.LeU = 4;
    this.LeV = this.LeQ;
    this.mHandler = new aq();
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.Aya = false;
    this.Ayb = false;
    this.Ayc = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void O(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.Af == 0) && (this.Ag == 0))
    {
      this.Af = (paramView.getWidth() / 2);
      this.Ag = (paramView.getHeight() / 2);
    }
    this.LeA = (this.Af - arrayOfInt[0]);
    this.LeB = (this.Ag - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.Ley;
      j = this.Lez;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aYU = (this.mWidth / i);
        this.aYV = (this.mHeight / j);
      }
      float f1 = this.LeE;
      if ((this.LeK != 0) || (this.LeL != 0) || (this.LeM != 0) || (this.LeN != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.Ley != 0)
        {
          f1 = f2;
          if (this.Lez != 0)
          {
            this.aYU = (this.mWidth / this.Ley);
            this.aYV = (this.mHeight / this.Lez);
            f1 = f2;
          }
        }
      }
      if (this.LeF != 1.0D)
      {
        this.LeA += arrayOfInt[0];
        this.LeB += arrayOfInt[1];
        this.LeC = (this.aYU * this.LeF);
        this.LeD = this.LeC;
        this.LeB = ((int)(this.LeB - this.LeH * this.LeC));
        this.LeA = ((int)(this.LeA - this.LeG * this.LeC));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.aYU > this.aYV)
      {
        this.LeC = (this.aYU * f1);
        this.LeB = ((int)(this.LeB - (j * this.LeC - this.mHeight * f1) / 2.0F));
        this.LeB = ((int)(this.LeB - this.mHeight * (f1 - 1.0F) / 2.0F - this.LeJ * this.LeC / 2.0F));
        this.LeA = ((int)(this.LeA - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.Lez == 0) || (this.Ag >= (j - this.Lez) / 2)) {
          break label677;
        }
        f2 = this.LeB;
      }
      for (this.LeB = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.LeB = ((int)(this.LeB - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label677:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.LeC = 0.5F;
            this.LeI = 0.0F;
            this.LeA = ((int)(this.LeA - i * this.LeC / 2.0F));
            this.LeB = ((int)(this.LeB - j * this.LeC / 2.0F - this.LeJ * this.LeC / 2.0F));
          }
          AppMethodBeat.o(143094);
          return;
          this.LeC = (this.aYV * f1);
          this.LeA = ((int)(this.LeA - (i * this.LeC - this.mWidth * f1) / 2.0F));
          if ((this.Lez == 0) || (this.Lez >= j)) {
            break;
          }
          this.LeB = ((int)(this.LeB - (j * this.LeC - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.Lez == 0) || (this.Ag + this.mHeight <= (this.Lez + j) / 2));
      }
    }
  }
  
  public final void R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Af = paramInt1;
    this.Ag = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.LeV == this.LeS) || (this.LeV == this.LeU) || (this.LeV == this.LeT))
    {
      ae.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.LeV), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    if (Float.isNaN(this.LeC))
    {
      AppMethodBeat.o(143095);
      return;
    }
    O(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.LeC);
    paramView1.setScaleY(this.LeC);
    paramView1.setTranslationX(this.LeA);
    paramView1.setTranslationY(this.LeB);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.LeO).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new e.1(this, paramView2));
    }
    paramView1.animate().setDuration(this.LeO).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        e.this.LeV = e.this.LeT;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.LeV = e.this.LeT;
        ae.i("MicroMsg.ImagePreviewAnimation", "pennqin, gallery animation result, sx %s, sy %s, tx %s, ty %s.", new Object[] { Float.valueOf(paramView1.getScaleX()), Float.valueOf(paramView1.getScaleY()), Float.valueOf(paramView1.getTranslationX()), Float.valueOf(paramView1.getTranslationY()) });
        AppMethodBeat.o(143083);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143082);
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.LeV = e.this.LeS;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143084);
        if (e.this.LeV == e.this.LeQ)
        {
          ae.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        AppMethodBeat.o(143084);
      }
    }, this.LeP);
    AppMethodBeat.o(143095);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.c paramc, final e.a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.LeV == this.LeS) || (this.LeV == this.LeU) || (this.LeV == this.LeR))
    {
      ae.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.LeV), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    O(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F).setListener(new e.4(this, paramView2));
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.LeC, this.LeC, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((e.this.Ley != 0) && (e.this.Lez != 0) && (e.this.LeF == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + e.this.LeJ) / 2;
          k = (int)(((e.this.Ley - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
          i = (int)(((e.this.Lez - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
          if (e.this.LeF != 1.0F)
          {
            e.this.LeC = (e.this.LeD / e.this.LeF);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = e.this.LeH - localRect.top + (int)(e.this.Lez / 2.0F);
            k = (int)(((e.this.Ley - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
            i = (int)(((e.this.Lez - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + e.this.LeK * paramAnonymousFloat / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - e.this.LeJ * (1.0F - paramAnonymousFloat) / 2.0F + e.this.LeM * paramAnonymousFloat / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
          k = (int)(k / 2 + m - e.this.LeL * paramAnonymousFloat / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
          i = (int)(i / 2 + j - e.this.LeN * paramAnonymousFloat / (1.0F - (1.0F - e.this.LeC) * paramAnonymousFloat));
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
    parama = new TranslateAnimation(0.0F, this.LeA, 0.0F, this.LeB);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.LeI);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143089);
        ae.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.LeV = e.this.LeR;
        AppMethodBeat.o(143089);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143088);
        ae.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.LeV = e.this.LeU;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void a(b paramb)
  {
    this.LeZ = paramb;
  }
  
  public final void a(d paramd)
  {
    this.LeW = paramd;
  }
  
  public final void a(e.e parame)
  {
    this.LeY = parame;
  }
  
  public final void a(f paramf)
  {
    this.LeX = paramf;
  }
  
  public final void b(final View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(143097);
    paramView1.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193749);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193749);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193748);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193748);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143090);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        e.this.Ayc = true;
        if (e.this.LeW != null) {
          e.this.LeW.aRP();
        }
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(143090);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143091);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (e.this.LeX != null) {
          e.this.LeX.onClick();
        }
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143091);
        return bool;
      }
    }
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143092);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahF());
        paramAnonymousView = this.Lff;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (e.this.mVelocityTracker == null) {
          e.this.mVelocityTracker = VelocityTracker.obtain();
        }
        e.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          e.this.aZk = paramAnonymousMotionEvent.getX();
          e.this.aZl = paramAnonymousMotionEvent.getY();
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if ((!e.this.Ayb) || (!e.this.Aya)) {
            break label273;
          }
          e.a(e.this, 0.0F, 0.0F, paramView1, paramView2, paramView3);
          e.this.Aya = false;
        }
        label273:
        while (!e.this.Aya)
        {
          e.this.Ayc = false;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break label525;
          }
          if (f.ab(paramAnonymousMotionEvent) != 2) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143092);
          return false;
        }
        if (e.this.LeZ != null) {
          e.this.LeZ.onExit();
        }
        for (;;)
        {
          e.this.Aya = false;
          e.this.Ayb = false;
          break;
          e.this.a(paramView1, paramView2, this.Lfc, null);
        }
        paramAnonymousView = e.this.mVelocityTracker;
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - e.this.aZk;
        float f2 = paramAnonymousMotionEvent.getY() - e.this.aZl;
        if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!e.this.Ayc)) || (e.this.Aya))
        {
          e.a(e.this, f1, f2, paramView1, paramView2, paramView3);
          e.this.Aya = true;
          if (f2 <= 200.0F) {
            break label556;
          }
        }
        label525:
        label556:
        for (e.this.Ayb = false;; e.this.Ayb = true)
        {
          if (e.this.mVelocityTracker != null)
          {
            e.this.mVelocityTracker.recycle();
            e.this.mVelocityTracker = null;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143092);
          return false;
          e.this.Aya = false;
          break;
        }
      }
    });
    AppMethodBeat.o(143097);
  }
  
  public final void fOM()
  {
    this.LeF = 1.0F;
  }
  
  public final void kg(int paramInt1, int paramInt2)
  {
    this.Ley = paramInt1;
    this.Lez = paramInt2;
  }
  
  public final void kh(int paramInt1, int paramInt2)
  {
    this.LeK = paramInt1;
    this.LeL = paramInt2;
    this.LeM = 0;
    this.LeN = 0;
  }
  
  public final void ki(int paramInt1, int paramInt2)
  {
    this.LeG = paramInt1;
    this.LeH = paramInt2;
  }
  
  public static abstract interface b
  {
    public abstract void onExit();
  }
  
  public static abstract interface d
  {
    public abstract void aRP();
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