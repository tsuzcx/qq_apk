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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.f;

public final class e
{
  private int Al;
  private int Am;
  boolean EHq;
  boolean EHr;
  boolean EHs;
  int QtA;
  private int QtB;
  private int QtC;
  float QtD;
  float QtE;
  private float QtF;
  public float QtG;
  private int QtH;
  int QtI;
  float QtJ;
  public int QtK;
  int QtL;
  int QtM;
  int QtN;
  int QtO;
  public int QtP;
  private int QtQ;
  int QtR;
  int QtS;
  int QtT;
  int QtU;
  int QtV;
  int QtW;
  d QtX;
  f QtY;
  private e.e QtZ;
  int Qtz;
  b Qua;
  private float aYP;
  private float aYQ;
  float aZg;
  float aZh;
  private final Context context;
  private MMHandler mHandler;
  int mHeight;
  VelocityTracker mVelocityTracker;
  int mWidth;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(143093);
    this.Al = 0;
    this.Am = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.Qtz = 0;
    this.QtA = 0;
    this.QtB = 0;
    this.QtC = 0;
    this.aYP = 0.0F;
    this.aYQ = 0.0F;
    this.QtD = 0.0F;
    this.QtE = 0.0F;
    this.QtF = 1.0F;
    this.QtG = 1.0F;
    this.QtH = 0;
    this.QtI = 0;
    this.QtJ = 1.0F;
    this.QtK = 0;
    this.QtL = 0;
    this.QtM = 0;
    this.QtN = 0;
    this.QtO = 0;
    this.QtP = 300;
    this.QtQ = 10;
    this.QtR = 0;
    this.QtS = 1;
    this.QtT = 2;
    this.QtU = 3;
    this.QtV = 4;
    this.QtW = this.QtR;
    this.mHandler = new MMHandler();
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void U(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.Al == 0) && (this.Am == 0))
    {
      this.Al = (paramView.getWidth() / 2);
      this.Am = (paramView.getHeight() / 2);
    }
    this.QtB = (this.Al - arrayOfInt[0]);
    this.QtC = (this.Am - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.Qtz;
      j = this.QtA;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aYP = (this.mWidth / i);
        this.aYQ = (this.mHeight / j);
      }
      float f1 = this.QtF;
      if ((this.QtL != 0) || (this.QtM != 0) || (this.QtN != 0) || (this.QtO != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.Qtz != 0)
        {
          f1 = f2;
          if (this.QtA != 0)
          {
            this.aYP = (this.mWidth / this.Qtz);
            this.aYQ = (this.mHeight / this.QtA);
            f1 = f2;
          }
        }
      }
      if (this.QtG != 1.0D)
      {
        this.QtB += arrayOfInt[0];
        this.QtC += arrayOfInt[1];
        this.QtD = (this.aYP * this.QtG);
        this.QtE = this.QtD;
        this.QtC = ((int)(this.QtC - this.QtI * this.QtD));
        this.QtB = ((int)(this.QtB - this.QtH * this.QtD));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.aYP > this.aYQ)
      {
        this.QtD = (this.aYP * f1);
        this.QtC = ((int)(this.QtC - (j * this.QtD - this.mHeight * f1) / 2.0F));
        this.QtC = ((int)(this.QtC - this.mHeight * (f1 - 1.0F) / 2.0F - this.QtK * this.QtD / 2.0F));
        this.QtB = ((int)(this.QtB - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.QtA == 0) || (this.Am >= (j - this.QtA) / 2)) {
          break label677;
        }
        f2 = this.QtC;
      }
      for (this.QtC = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.QtC = ((int)(this.QtC - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label677:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.QtD = 0.5F;
            this.QtJ = 0.0F;
            this.QtB = ((int)(this.QtB - i * this.QtD / 2.0F));
            this.QtC = ((int)(this.QtC - j * this.QtD / 2.0F - this.QtK * this.QtD / 2.0F));
          }
          AppMethodBeat.o(143094);
          return;
          this.QtD = (this.aYQ * f1);
          this.QtB = ((int)(this.QtB - (i * this.QtD - this.mWidth * f1) / 2.0F));
          if ((this.QtA == 0) || (this.QtA >= j)) {
            break;
          }
          this.QtC = ((int)(this.QtC - (j * this.QtD - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.QtA == 0) || (this.Am + this.mHeight <= (this.QtA + j) / 2));
      }
    }
  }
  
  public final void Q(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Al = paramInt1;
    this.Am = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.QtW == this.QtT) || (this.QtW == this.QtV) || (this.QtW == this.QtU))
    {
      Log.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.QtW), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    if (Float.isNaN(this.QtD))
    {
      AppMethodBeat.o(143095);
      return;
    }
    U(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.QtD);
    paramView1.setScaleY(this.QtD);
    paramView1.setTranslationX(this.QtB);
    paramView1.setTranslationY(this.QtC);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.QtP).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new e.1(this, paramView2));
    }
    paramView1.animate().setDuration(this.QtP).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        e.this.QtW = e.this.QtU;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.QtW = e.this.QtU;
        Log.i("MicroMsg.ImagePreviewAnimation", "pennqin, gallery animation result, sx %s, sy %s, tx %s, ty %s.", new Object[] { Float.valueOf(paramView1.getScaleX()), Float.valueOf(paramView1.getScaleY()), Float.valueOf(paramView1.getTranslationX()), Float.valueOf(paramView1.getTranslationY()) });
        AppMethodBeat.o(143083);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143082);
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.QtW = e.this.QtT;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143084);
        if (e.this.QtW == e.this.QtR)
        {
          Log.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        AppMethodBeat.o(143084);
      }
    }, this.QtQ);
    AppMethodBeat.o(143095);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final e.c paramc, final e.a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.QtW == this.QtT) || (this.QtW == this.QtV) || (this.QtW == this.QtS))
    {
      Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.QtW), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    U(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F).setListener(new e.4(this, paramView2));
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.QtD, this.QtD, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((e.this.Qtz != 0) && (e.this.QtA != 0) && (e.this.QtG == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + e.this.QtK) / 2;
          k = (int)(((e.this.Qtz - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
          i = (int)(((e.this.QtA - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
          if (e.this.QtG != 1.0F)
          {
            e.this.QtD = (e.this.QtE / e.this.QtG);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = e.this.QtI - localRect.top + (int)(e.this.QtA / 2.0F);
            k = (int)(((e.this.Qtz - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
            i = (int)(((e.this.QtA - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + e.this.QtL * paramAnonymousFloat / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - e.this.QtK * (1.0F - paramAnonymousFloat) / 2.0F + e.this.QtN * paramAnonymousFloat / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
          k = (int)(k / 2 + m - e.this.QtM * paramAnonymousFloat / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
          i = (int)(i / 2 + j - e.this.QtO * paramAnonymousFloat / (1.0F - (1.0F - e.this.QtD) * paramAnonymousFloat));
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
              parama.L(n, i1, k, i);
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
    parama = new TranslateAnimation(0.0F, this.QtB, 0.0F, this.QtC);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.QtJ);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    paramView2.setFillAfter(true);
    paramView2.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143089);
        Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation end!");
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.QtW = e.this.QtS;
        AppMethodBeat.o(143089);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(143088);
        Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation start!");
        if (paramc != null) {
          paramc.onAnimationStart();
        }
        e.this.QtW = e.this.QtV;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void a(b paramb)
  {
    this.Qua = paramb;
  }
  
  public final void a(d paramd)
  {
    this.QtX = paramd;
  }
  
  public final void a(e.e parame)
  {
    this.QtZ = parame;
  }
  
  public final void a(f paramf)
  {
    this.QtY = paramf;
  }
  
  public final void b(final View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(143097);
    paramView1.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205367);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205367);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205366);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205366);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143090);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        e.this.EHs = true;
        if (e.this.QtX != null) {
          e.this.QtX.bmu();
        }
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(143090);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143091);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if (e.this.QtY != null) {
          e.this.QtY.onClick();
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
        paramAnonymousView = this.Qug;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, locala.axQ(), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (e.this.mVelocityTracker == null) {
          e.this.mVelocityTracker = VelocityTracker.obtain();
        }
        e.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          e.this.aZg = paramAnonymousMotionEvent.getX();
          e.this.aZh = paramAnonymousMotionEvent.getY();
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if ((!e.this.EHr) || (!e.this.EHq)) {
            break label222;
          }
          e.a(e.this, 0.0F, 0.0F, paramView1, paramView2, paramView3);
          e.this.EHq = false;
        }
        label222:
        while (!e.this.EHq)
        {
          e.this.EHs = false;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break label474;
          }
          if (f.ai(paramAnonymousMotionEvent) != 2) {
            break;
          }
          AppMethodBeat.o(143092);
          return false;
        }
        if (e.this.Qua != null) {
          e.this.Qua.onExit();
        }
        for (;;)
        {
          e.this.EHq = false;
          e.this.EHr = false;
          break;
          e.this.a(paramView1, paramView2, this.Qud, null);
        }
        paramAnonymousView = e.this.mVelocityTracker;
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - e.this.aZg;
        float f2 = paramAnonymousMotionEvent.getY() - e.this.aZh;
        if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!e.this.EHs)) || (e.this.EHq))
        {
          e.a(e.this, f1, f2, paramView1, paramView2, paramView3);
          e.this.EHq = true;
          if (f2 <= 200.0F) {
            break label492;
          }
        }
        label474:
        label492:
        for (e.this.EHr = false;; e.this.EHr = true)
        {
          if (e.this.mVelocityTracker != null)
          {
            e.this.mVelocityTracker.recycle();
            e.this.mVelocityTracker = null;
          }
          AppMethodBeat.o(143092);
          return false;
          e.this.EHq = false;
          break;
        }
      }
    });
    AppMethodBeat.o(143097);
  }
  
  public final void gXF()
  {
    this.QtG = 1.0F;
  }
  
  public final void ls(int paramInt1, int paramInt2)
  {
    this.Qtz = paramInt1;
    this.QtA = paramInt2;
  }
  
  public final void lt(int paramInt1, int paramInt2)
  {
    this.QtL = paramInt1;
    this.QtM = paramInt2;
    this.QtN = 0;
    this.QtO = 0;
  }
  
  public final void lu(int paramInt1, int paramInt2)
  {
    this.QtH = paramInt1;
    this.QtI = paramInt2;
  }
  
  public static abstract interface b
  {
    public abstract void onExit();
  }
  
  public static abstract interface d
  {
    public abstract void bmu();
  }
  
  public static abstract interface f
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */