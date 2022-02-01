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

public final class f
{
  boolean KVq;
  boolean KVr;
  boolean KVs;
  int XRL;
  int XRM;
  private int XRN;
  private int XRO;
  float XRP;
  float XRQ;
  private float XRR;
  public float XRS;
  private int XRT;
  int XRU;
  float XRV;
  public int XRW;
  int XRX;
  int XRY;
  int XRZ;
  int XSa;
  private int XSb;
  private int XSc;
  int XSd;
  int XSe;
  int XSf;
  int XSg;
  int XSh;
  int XSi;
  d XSj;
  f XSk;
  private f.e XSl;
  b XSm;
  float aIC;
  float aID;
  private float aIl;
  private float aIm;
  private int apP;
  private final Context context;
  private MMHandler mHandler;
  int mHeight;
  VelocityTracker mVelocityTracker;
  int mWidth;
  private int tF;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(143093);
    this.tF = 0;
    this.apP = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.XRL = 0;
    this.XRM = 0;
    this.XRN = 0;
    this.XRO = 0;
    this.aIl = 0.0F;
    this.aIm = 0.0F;
    this.XRP = 0.0F;
    this.XRQ = 0.0F;
    this.XRR = 1.0F;
    this.XRS = 1.0F;
    this.XRT = 0;
    this.XRU = 0;
    this.XRV = 1.0F;
    this.XRW = 0;
    this.XRX = 0;
    this.XRY = 0;
    this.XRZ = 0;
    this.XSa = 0;
    this.XSb = 300;
    this.XSc = 10;
    this.XSd = 0;
    this.XSe = 1;
    this.XSf = 2;
    this.XSg = 3;
    this.XSh = 4;
    this.XSi = this.XSd;
    this.mHandler = new MMHandler();
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void Y(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.tF == 0) && (this.apP == 0))
    {
      this.tF = (paramView.getWidth() / 2);
      this.apP = (paramView.getHeight() / 2);
    }
    this.XRN = (this.tF - arrayOfInt[0]);
    this.XRO = (this.apP - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.XRL;
      j = this.XRM;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aIl = (this.mWidth / i);
        this.aIm = (this.mHeight / j);
      }
      float f1 = this.XRR;
      if ((this.XRX != 0) || (this.XRY != 0) || (this.XRZ != 0) || (this.XSa != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.XRL != 0)
        {
          f1 = f2;
          if (this.XRM != 0)
          {
            this.aIl = (this.mWidth / this.XRL);
            this.aIm = (this.mHeight / this.XRM);
            f1 = f2;
          }
        }
      }
      if (this.XRS != 1.0D)
      {
        this.XRN += arrayOfInt[0];
        this.XRO += arrayOfInt[1];
        this.XRP = (this.aIl * this.XRS);
        this.XRQ = this.XRP;
        this.XRO = ((int)(this.XRO - this.XRU * this.XRP));
        this.XRN = ((int)(this.XRN - this.XRT * this.XRP));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.aIl > this.aIm)
      {
        this.XRP = (this.aIl * f1);
        this.XRO = ((int)(this.XRO - (j * this.XRP - this.mHeight * f1) / 2.0F));
        this.XRO = ((int)(this.XRO - this.mHeight * (f1 - 1.0F) / 2.0F - this.XRW * this.XRP / 2.0F));
        this.XRN = ((int)(this.XRN - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.XRM == 0) || (this.apP >= (j - this.XRM) / 2)) {
          break label760;
        }
        f2 = this.XRO;
      }
      for (this.XRO = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.XRO = ((int)(this.XRO - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label760:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.XRP = 0.5F;
            this.XRV = 0.0F;
            this.XRN = ((int)(this.XRN - i * this.XRP / 2.0F));
            this.XRO = ((int)(this.XRO - j * this.XRP / 2.0F - this.XRW * this.XRP / 2.0F));
          }
          Log.i("MicroMsg.ImagePreviewAnimation", "left: %s; top: %s; width: %s; height: %s; zoomScale: %s; LeftDelta: %s; TopDelta: %s", new Object[] { Integer.valueOf(this.tF), Integer.valueOf(this.apP), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Float.valueOf(this.XRP), Integer.valueOf(this.XRN), Integer.valueOf(this.XRO) });
          AppMethodBeat.o(143094);
          return;
          this.XRP = (this.aIm * f1);
          this.XRN = ((int)(this.XRN - (i * this.XRP - this.mWidth * f1) / 2.0F));
          if ((this.XRM == 0) || (this.XRM >= j)) {
            break;
          }
          this.XRO = ((int)(this.XRO - (j * this.XRP - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.XRM == 0) || (this.apP + this.mHeight <= (this.XRM + j) / 2));
      }
    }
  }
  
  public final void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(211586);
    this.tF = paramInt1;
    this.apP = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    Log.i("MicroMsg.ImagePreviewAnimation", "setAnimationParam: left=%d, top=%d, width=%d, height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(211586);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final f.c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.XSi == this.XSf) || (this.XSi == this.XSh) || (this.XSi == this.XSg))
    {
      Log.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.XSi), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    if (Float.isNaN(this.XRP))
    {
      AppMethodBeat.o(143095);
      return;
    }
    Y(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.XRP);
    paramView1.setScaleY(this.XRP);
    paramView1.setTranslationX(this.XRN);
    paramView1.setTranslationY(this.XRO);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.XSb).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new f.1(this, paramView2));
    }
    paramView1.animate().setDuration(this.XSb).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.this.XSi = f.this.XSg;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        f.this.XSi = f.this.XSg;
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
        f.this.XSi = f.this.XSf;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new f.3(this, paramView1), this.XSc);
    AppMethodBeat.o(143095);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, View paramView2, final f.c paramc, final f.a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.XSi == this.XSf) || (this.XSi == this.XSh) || (this.XSi == this.XSe))
    {
      Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.XSi), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    Y(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F).setListener(new f.4(this, paramView2));
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.XRP, this.XRP, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((f.this.XRL != 0) && (f.this.XRM != 0) && (f.this.XRS == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + f.this.XRW) / 2;
          k = (int)(((f.this.XRL - f.this.mWidth) * (1.0F - paramAnonymousFloat) + f.this.mWidth) / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
          i = (int)(((f.this.XRM - f.this.mHeight) * (1.0F - paramAnonymousFloat) + f.this.mHeight) / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
          if (f.this.XRS != 1.0F)
          {
            f.this.XRP = (f.this.XRQ / f.this.XRS);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = f.this.XRU - localRect.top + (int)(f.this.XRM / 2.0F);
            k = (int)(((f.this.XRL - f.this.mWidth) * (1.0F - paramAnonymousFloat) + f.this.mWidth) / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
            i = (int)(((f.this.XRM - f.this.mHeight) * (1.0F - paramAnonymousFloat) + f.this.mHeight) / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + f.this.XRX * paramAnonymousFloat / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - f.this.XRW * (1.0F - paramAnonymousFloat) / 2.0F + f.this.XRZ * paramAnonymousFloat / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
          k = (int)(k / 2 + m - f.this.XRY * paramAnonymousFloat / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
          i = (int)(i / 2 + j - f.this.XSa * paramAnonymousFloat / (1.0F - (1.0F - f.this.XRP) * paramAnonymousFloat));
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
              parama.Q(n, i1, k, i);
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
    parama = new TranslateAnimation(0.0F, this.XRN, 0.0F, this.XRO);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.XRV);
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
        f.this.XSi = f.this.XSe;
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
        f.this.XSi = f.this.XSh;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void a(b paramb)
  {
    this.XSm = paramb;
  }
  
  public final void a(d paramd)
  {
    this.XSj = paramd;
  }
  
  public final void a(f.e parame)
  {
    this.XSl = parame;
  }
  
  public final void a(f paramf)
  {
    this.XSk = paramf;
  }
  
  public final void b(final View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(143097);
    paramView1.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(215180);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(215180);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(215179);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(215179);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143090);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        f.this.KVs = true;
        if (f.this.XSj != null) {
          f.this.XSj.bwC();
        }
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(143090);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143091);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        if (f.this.XSk != null) {
          f.this.XSk.onClick();
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
        paramAnonymousView = this.XSs;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, locala.aFh(), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (f.this.mVelocityTracker == null) {
          f.this.mVelocityTracker = VelocityTracker.obtain();
        }
        f.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          f.this.aIC = paramAnonymousMotionEvent.getX();
          f.this.aID = paramAnonymousMotionEvent.getY();
        }
        if (paramAnonymousMotionEvent.getAction() == 1)
        {
          if ((!f.this.KVr) || (!f.this.KVq)) {
            break label222;
          }
          f.a(f.this, 0.0F, 0.0F, paramView1, paramView2, paramView3);
          f.this.KVq = false;
        }
        label222:
        while (!f.this.KVq)
        {
          f.this.KVs = false;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break label474;
          }
          if (com.tencent.mm.ui.base.f.ar(paramAnonymousMotionEvent) != 2) {
            break;
          }
          AppMethodBeat.o(143092);
          return false;
        }
        if (f.this.XSm != null) {
          f.this.XSm.onExit();
        }
        for (;;)
        {
          f.this.KVq = false;
          f.this.KVr = false;
          break;
          f.this.a(paramView1, paramView2, this.XSp, null);
        }
        paramAnonymousView = f.this.mVelocityTracker;
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - f.this.aIC;
        float f2 = paramAnonymousMotionEvent.getY() - f.this.aID;
        if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!f.this.KVs)) || (f.this.KVq))
        {
          f.a(f.this, f1, f2, paramView1, paramView2, paramView3);
          f.this.KVq = true;
          if (f2 <= 200.0F) {
            break label492;
          }
        }
        label474:
        label492:
        for (f.this.KVr = false;; f.this.KVr = true)
        {
          if (f.this.mVelocityTracker != null)
          {
            f.this.mVelocityTracker.recycle();
            f.this.mVelocityTracker = null;
          }
          AppMethodBeat.o(143092);
          return false;
          f.this.KVq = false;
          break;
        }
      }
    });
    AppMethodBeat.o(143097);
  }
  
  public final void hYr()
  {
    this.XRS = 1.0F;
  }
  
  public final void mJ(int paramInt1, int paramInt2)
  {
    this.XRL = paramInt1;
    this.XRM = paramInt2;
  }
  
  public final void mK(int paramInt1, int paramInt2)
  {
    this.XRX = paramInt1;
    this.XRY = paramInt2;
    this.XRZ = 0;
    this.XSa = 0;
  }
  
  public final void mL(int paramInt1, int paramInt2)
  {
    this.XRT = paramInt1;
    this.XRU = paramInt2;
  }
  
  public static abstract interface b
  {
    public abstract void onExit();
  }
  
  public static abstract interface d
  {
    public abstract void bwC();
  }
  
  public static abstract interface f
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */