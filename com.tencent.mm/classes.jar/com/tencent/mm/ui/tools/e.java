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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.f;

public final class e
{
  private int Af;
  private int Ag;
  boolean AgO;
  boolean AgP;
  boolean AgQ;
  int KIA;
  int KIB;
  d KIC;
  f KID;
  private e.e KIE;
  b KIF;
  int KIe;
  int KIf;
  private int KIg;
  private int KIh;
  float KIi;
  float KIj;
  private float KIk;
  public float KIl;
  private int KIm;
  int KIn;
  float KIo;
  public int KIp;
  int KIq;
  int KIr;
  int KIs;
  int KIt;
  private int KIu;
  private int KIv;
  int KIw;
  int KIx;
  int KIy;
  int KIz;
  private float aYU;
  private float aYV;
  float aZk;
  float aZl;
  private final Context context;
  private ap mHandler;
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
    this.KIe = 0;
    this.KIf = 0;
    this.KIg = 0;
    this.KIh = 0;
    this.aYU = 0.0F;
    this.aYV = 0.0F;
    this.KIi = 0.0F;
    this.KIj = 0.0F;
    this.KIk = 1.0F;
    this.KIl = 1.0F;
    this.KIm = 0;
    this.KIn = 0;
    this.KIo = 1.0F;
    this.KIp = 0;
    this.KIq = 0;
    this.KIr = 0;
    this.KIs = 0;
    this.KIt = 0;
    this.KIu = 300;
    this.KIv = 10;
    this.KIw = 0;
    this.KIx = 1;
    this.KIy = 2;
    this.KIz = 3;
    this.KIA = 4;
    this.KIB = this.KIw;
    this.mHandler = new ap();
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.AgO = false;
    this.AgP = false;
    this.AgQ = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void J(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.Af == 0) && (this.Ag == 0))
    {
      this.Af = (paramView.getWidth() / 2);
      this.Ag = (paramView.getHeight() / 2);
    }
    this.KIg = (this.Af - arrayOfInt[0]);
    this.KIh = (this.Ag - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.KIe;
      j = this.KIf;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.aYU = (this.mWidth / i);
        this.aYV = (this.mHeight / j);
      }
      float f1 = this.KIk;
      if ((this.KIq != 0) || (this.KIr != 0) || (this.KIs != 0) || (this.KIt != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.KIe != 0)
        {
          f1 = f2;
          if (this.KIf != 0)
          {
            this.aYU = (this.mWidth / this.KIe);
            this.aYV = (this.mHeight / this.KIf);
            f1 = f2;
          }
        }
      }
      if (this.KIl != 1.0D)
      {
        this.KIg += arrayOfInt[0];
        this.KIh += arrayOfInt[1];
        this.KIi = (this.aYU * this.KIl);
        this.KIj = this.KIi;
        this.KIh = ((int)(this.KIh - this.KIn * this.KIi));
        this.KIg = ((int)(this.KIg - this.KIm * this.KIi));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.aYU > this.aYV)
      {
        this.KIi = (this.aYU * f1);
        this.KIh = ((int)(this.KIh - (j * this.KIi - this.mHeight * f1) / 2.0F));
        this.KIh = ((int)(this.KIh - this.mHeight * (f1 - 1.0F) / 2.0F - this.KIp * this.KIi / 2.0F));
        this.KIg = ((int)(this.KIg - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.KIf == 0) || (this.Ag >= (j - this.KIf) / 2)) {
          break label677;
        }
        f2 = this.KIh;
      }
      for (this.KIh = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.KIh = ((int)(this.KIh - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label677:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.KIi = 0.5F;
            this.KIo = 0.0F;
            this.KIg = ((int)(this.KIg - i * this.KIi / 2.0F));
            this.KIh = ((int)(this.KIh - j * this.KIi / 2.0F - this.KIp * this.KIi / 2.0F));
          }
          AppMethodBeat.o(143094);
          return;
          this.KIi = (this.aYV * f1);
          this.KIg = ((int)(this.KIg - (i * this.KIi - this.mWidth * f1) / 2.0F));
          if ((this.KIf == 0) || (this.KIf >= j)) {
            break;
          }
          this.KIh = ((int)(this.KIh - (j * this.KIi - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.KIf == 0) || (this.Ag + this.mHeight <= (this.KIf + j) / 2));
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
  public final void a(final View paramView1, final View paramView2, final e.c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.KIB == this.KIy) || (this.KIB == this.KIA) || (this.KIB == this.KIz))
    {
      ad.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.KIB), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    if (Float.isNaN(this.KIi))
    {
      AppMethodBeat.o(143095);
      return;
    }
    J(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.KIi);
    paramView1.setScaleY(this.KIi);
    paramView1.setTranslationX(this.KIg);
    paramView1.setTranslationY(this.KIh);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.KIu).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new Animator.AnimatorListener()
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
    paramView1.animate().setDuration(this.KIu).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        e.this.KIB = e.this.KIz;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        e.this.KIB = e.this.KIz;
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
        e.this.KIB = e.this.KIy;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143084);
        if (e.this.KIB == e.this.KIw)
        {
          ad.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        AppMethodBeat.o(143084);
      }
    }, this.KIv);
    AppMethodBeat.o(143095);
  }
  
  @TargetApi(16)
  public final void a(final View paramView1, final View paramView2, final e.c paramc, final a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.KIB == this.KIy) || (this.KIB == this.KIA) || (this.KIB == this.KIx))
    {
      ad.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.KIB), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    J(paramView1, true);
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
    parama = new ScaleAnimation(this.KIi, this.KIi, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((e.this.KIe != 0) && (e.this.KIf != 0) && (e.this.KIl == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + e.this.KIp) / 2;
          k = (int)(((e.this.KIe - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
          i = (int)(((e.this.KIf - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
          if (e.this.KIl != 1.0F)
          {
            e.this.KIi = (e.this.KIj / e.this.KIl);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = e.this.KIn - localRect.top + (int)(e.this.KIf / 2.0F);
            k = (int)(((e.this.KIe - e.this.mWidth) * (1.0F - paramAnonymousFloat) + e.this.mWidth) / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
            i = (int)(((e.this.KIf - e.this.mHeight) * (1.0F - paramAnonymousFloat) + e.this.mHeight) / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + e.this.KIq * paramAnonymousFloat / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - e.this.KIp * (1.0F - paramAnonymousFloat) / 2.0F + e.this.KIs * paramAnonymousFloat / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
          k = (int)(k / 2 + m - e.this.KIr * paramAnonymousFloat / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
          i = (int)(i / 2 + j - e.this.KIt * paramAnonymousFloat / (1.0F - (1.0F - e.this.KIi) * paramAnonymousFloat));
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
    parama = new TranslateAnimation(0.0F, this.KIg, 0.0F, this.KIh);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.KIo);
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
        e.this.KIB = e.this.KIx;
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
        e.this.KIB = e.this.KIA;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void a(b paramb)
  {
    this.KIF = paramb;
  }
  
  public final void a(d paramd)
  {
    this.KIC = paramd;
  }
  
  public final void a(e.e parame)
  {
    this.KIE = parame;
  }
  
  public final void a(f paramf)
  {
    this.KID = paramf;
  }
  
  public final void b(final View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(143097);
    paramView1.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186492);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186492);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186491);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186491);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143090);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        e.this.AgQ = true;
        if (e.this.KIC != null) {
          e.this.KIC.aRq();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$7", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (e.this.KID != null) {
          e.this.KID.onClick();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahq());
        paramAnonymousView = this.KIL;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)), "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
          if ((!e.this.AgP) || (!e.this.AgO)) {
            break label273;
          }
          e.a(e.this, 0.0F, 0.0F, paramView1, paramView2, paramView3);
          e.this.AgO = false;
        }
        label273:
        while (!e.this.AgO)
        {
          e.this.AgQ = false;
          if (paramAnonymousMotionEvent.getAction() != 2) {
            break label525;
          }
          if (f.ad(paramAnonymousMotionEvent) != 2) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143092);
          return false;
        }
        if (e.this.KIF != null) {
          e.this.KIF.onExit();
        }
        for (;;)
        {
          e.this.AgO = false;
          e.this.AgP = false;
          break;
          e.this.a(paramView1, paramView2, this.KII, null);
        }
        paramAnonymousView = e.this.mVelocityTracker;
        paramAnonymousView.computeCurrentVelocity(1000);
        int i = (int)paramAnonymousView.getXVelocity();
        int j = (int)paramAnonymousView.getYVelocity();
        float f1 = paramAnonymousMotionEvent.getX() - e.this.aZk;
        float f2 = paramAnonymousMotionEvent.getY() - e.this.aZl;
        if (((Math.abs(f1) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (j > 0) && (!e.this.AgQ)) || (e.this.AgO))
        {
          e.a(e.this, f1, f2, paramView1, paramView2, paramView3);
          e.this.AgO = true;
          if (f2 <= 200.0F) {
            break label556;
          }
        }
        label525:
        label556:
        for (e.this.AgP = false;; e.this.AgP = true)
        {
          if (e.this.mVelocityTracker != null)
          {
            e.this.mVelocityTracker.recycle();
            e.this.mVelocityTracker = null;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/tools/ImagePreviewAnimation$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143092);
          return false;
          e.this.AgO = false;
          break;
        }
      }
    });
    AppMethodBeat.o(143097);
  }
  
  public final void fKv()
  {
    this.KIl = 1.0F;
  }
  
  public final void jZ(int paramInt1, int paramInt2)
  {
    this.KIe = paramInt1;
    this.KIf = paramInt2;
  }
  
  public final void ka(int paramInt1, int paramInt2)
  {
    this.KIq = paramInt1;
    this.KIr = paramInt2;
    this.KIs = 0;
    this.KIt = 0;
  }
  
  public final void kb(int paramInt1, int paramInt2)
  {
    this.KIm = paramInt1;
    this.KIn = paramInt2;
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
    public abstract void aRq();
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