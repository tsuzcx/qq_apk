package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.ui.base.g;

public final class f
{
  boolean Rvo;
  boolean Rvp;
  boolean Rvq;
  int afHZ;
  public b afIA;
  int afIa;
  private int afIb;
  private int afIc;
  float afId;
  float afIe;
  private float afIf;
  public float afIg;
  private int afIh;
  int afIi;
  float afIj;
  public int afIk;
  int afIl;
  int afIm;
  int afIn;
  int afIo;
  private int afIp;
  private int afIq;
  int afIr;
  int afIs;
  int afIt;
  int afIu;
  int afIv;
  int afIw;
  public d afIx;
  public f afIy;
  public e afIz;
  private int cey;
  public final Context context;
  private MMHandler mHandler;
  int mHeight;
  private float mHeightScale;
  VelocityTracker mVelocityTracker;
  int mWidth;
  private float mWidthScale;
  private int uE;
  float x_down;
  float y_down;
  
  public f(Context paramContext)
  {
    AppMethodBeat.i(143093);
    this.uE = 0;
    this.cey = 0;
    this.mWidth = 0;
    this.mHeight = 0;
    this.afHZ = 0;
    this.afIa = 0;
    this.afIb = 0;
    this.afIc = 0;
    this.mWidthScale = 0.0F;
    this.mHeightScale = 0.0F;
    this.afId = 0.0F;
    this.afIe = 0.0F;
    this.afIf = 1.0F;
    this.afIg = 1.0F;
    this.afIh = 0;
    this.afIi = 0;
    this.afIj = 1.0F;
    this.afIk = 0;
    this.afIl = 0;
    this.afIm = 0;
    this.afIn = 0;
    this.afIo = 0;
    this.afIp = 300;
    this.afIq = 10;
    this.afIr = 0;
    this.afIs = 1;
    this.afIt = 2;
    this.afIu = 3;
    this.afIv = 4;
    this.afIw = this.afIr;
    this.mHandler = new MMHandler();
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.context = paramContext;
    AppMethodBeat.o(143093);
  }
  
  private void ae(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(143094);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if ((this.uE == 0) && (this.cey == 0))
    {
      this.uE = (paramView.getWidth() / 2);
      this.cey = (paramView.getHeight() / 2);
    }
    this.afIb = (this.uE - arrayOfInt[0]);
    this.afIc = (this.cey - arrayOfInt[1]);
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((i == 0) || (j == 0))
    {
      i = this.afHZ;
      j = this.afIa;
    }
    for (;;)
    {
      if ((i != 0) && (j != 0))
      {
        this.mWidthScale = (this.mWidth / i);
        this.mHeightScale = (this.mHeight / j);
      }
      float f1 = this.afIf;
      if ((this.afIl != 0) || (this.afIm != 0) || (this.afIn != 0) || (this.afIo != 0)) {
        f1 = 1.1F;
      }
      float f2;
      if (paramBoolean)
      {
        f2 = 1.0F;
        f1 = f2;
        if (this.afHZ != 0)
        {
          f1 = f2;
          if (this.afIa != 0)
          {
            this.mWidthScale = (this.mWidth / this.afHZ);
            this.mHeightScale = (this.mHeight / this.afIa);
            f1 = f2;
          }
        }
      }
      if (this.afIg != 1.0D)
      {
        this.afIb += arrayOfInt[0];
        this.afIc += arrayOfInt[1];
        this.afId = (this.mWidthScale * this.afIg);
        this.afIe = this.afId;
        this.afIc = ((int)(this.afIc - this.afIi * this.afId));
        this.afIb = ((int)(this.afIb - this.afIh * this.afId));
        AppMethodBeat.o(143094);
        return;
      }
      if (this.mWidthScale > this.mHeightScale)
      {
        this.afId = (this.mWidthScale * f1);
        this.afIc = ((int)(this.afIc - (j * this.afId - this.mHeight * f1) / 2.0F));
        this.afIc = ((int)(this.afIc - this.mHeight * (f1 - 1.0F) / 2.0F - this.afIk * this.afId / 2.0F));
        this.afIb = ((int)(this.afIb - this.mWidth * (f1 - 1.0F) / 2.0F));
        if ((this.afIa == 0) || (this.cey >= (j - this.afIa) / 2)) {
          break label760;
        }
        f2 = this.afIc;
      }
      for (this.afIc = ((int)((f1 - 1.0F) * this.mHeight / 2.0F + f2));; this.afIc = ((int)(this.afIc - (f1 - 1.0F) * this.mHeight / 2.0F))) {
        label760:
        do
        {
          if ((this.mWidth == 0) && (this.mHeight == 0))
          {
            this.afId = 0.5F;
            this.afIj = 0.0F;
            this.afIb = ((int)(this.afIb - i * this.afId / 2.0F));
            this.afIc = ((int)(this.afIc - j * this.afId / 2.0F - this.afIk * this.afId / 2.0F));
          }
          Log.i("MicroMsg.ImagePreviewAnimation", "left: %s; top: %s; width: %s; height: %s; zoomScale: %s; LeftDelta: %s; TopDelta: %s", new Object[] { Integer.valueOf(this.uE), Integer.valueOf(this.cey), Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Float.valueOf(this.afId), Integer.valueOf(this.afIb), Integer.valueOf(this.afIc) });
          AppMethodBeat.o(143094);
          return;
          this.afId = (this.mHeightScale * f1);
          this.afIb = ((int)(this.afIb - (i * this.afId - this.mWidth * f1) / 2.0F));
          if ((this.afIa == 0) || (this.afIa >= j)) {
            break;
          }
          this.afIc = ((int)(this.afIc - (j * this.afId - this.mHeight * f1) / 2.0F));
          break;
        } while ((this.afIa == 0) || (this.cey + this.mHeight <= (this.afIa + j) / 2));
      }
    }
  }
  
  public final void a(final View paramView1, View paramView2, final c paramc)
  {
    AppMethodBeat.i(143095);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.afIw == this.afIt) || (this.afIw == this.afIv) || (this.afIw == this.afIu))
    {
      Log.e("MicroMsg.ImagePreviewAnimation", "[runEnterAnimation] %s %s ", new Object[] { Integer.valueOf(this.afIw), paramView1 });
      AppMethodBeat.o(143095);
      return;
    }
    if (Float.isNaN(this.afId))
    {
      AppMethodBeat.o(143095);
      return;
    }
    ae(paramView1, false);
    paramView1.setPivotX(0.0F);
    paramView1.setPivotY(0.0F);
    paramView1.setScaleX(this.afId);
    paramView1.setScaleY(this.afId);
    paramView1.setTranslationX(this.afIb);
    paramView1.setTranslationY(this.afIc);
    if (paramView2 != null)
    {
      paramView2.setAlpha(0.0F);
      paramView2.animate().setDuration(this.afIp).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(1.0F).setListener(new f.1(this, paramView2));
    }
    paramView1.animate().setDuration(this.afIp).setInterpolator(new DecelerateInterpolator(1.2F)).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        f.this.afIw = f.this.afIu;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(143083);
        if (paramc != null) {
          paramc.onAnimationEnd();
        }
        f.this.afIw = f.this.afIu;
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
        f.this.afIw = f.this.afIt;
        AppMethodBeat.o(143082);
      }
    });
    this.mHandler.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143084);
        if (f.this.afIw == f.this.afIr)
        {
          Log.i("MicroMsg.ImagePreviewAnimation", "dancy enter Animation not Start!");
          paramView1.requestLayout();
        }
        AppMethodBeat.o(143084);
      }
    }, this.afIq);
    AppMethodBeat.o(143095);
  }
  
  public final void a(final View paramView1, View paramView2, final c paramc, final f.a parama)
  {
    AppMethodBeat.i(143096);
    if ((Build.VERSION.SDK_INT < 12) || (paramView1 == null) || (this.afIw == this.afIt) || (this.afIw == this.afIv) || (this.afIw == this.afIs))
    {
      Log.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[] { Integer.valueOf(this.afIw), paramView1 });
      AppMethodBeat.o(143096);
      return;
    }
    ae(paramView1, true);
    if (paramView2 != null) {
      paramView2.animate().setDuration(200L).setInterpolator(new DecelerateInterpolator(1.2F)).alpha(0.0F).setListener(new f.4(this, paramView2));
    }
    paramView2 = new AnimationSet(true);
    parama = new ScaleAnimation(this.afId, this.afId, paramView1, parama)
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(143087);
        int k;
        int i;
        int n;
        int i1;
        if ((f.this.afHZ != 0) && (f.this.afIa != 0) && (f.this.afIg == 1.0F))
        {
          Rect localRect = new Rect();
          paramView1.getGlobalVisibleRect(localRect);
          int m = (localRect.right - localRect.left) / 2;
          int j = (localRect.bottom - localRect.top + f.this.afIk) / 2;
          k = (int)(((f.this.afHZ - f.this.mWidth) * (1.0F - paramAnonymousFloat) + f.this.mWidth) / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
          i = (int)(((f.this.afIa - f.this.mHeight) * (1.0F - paramAnonymousFloat) + f.this.mHeight) / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
          if (f.this.afIg != 1.0F)
          {
            f.this.afId = (f.this.afIe / f.this.afIg);
            i = localRect.right;
            i = localRect.left;
            m = (localRect.right + localRect.left) / 2;
            j = f.this.afIi - localRect.top + (int)(f.this.afIa / 2.0F);
            k = (int)(((f.this.afHZ - f.this.mWidth) * (1.0F - paramAnonymousFloat) + f.this.mWidth) / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
            i = (int)(((f.this.afIa - f.this.mHeight) * (1.0F - paramAnonymousFloat) + f.this.mHeight) / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
          }
          n = (int)(m - k / 2 + f.this.afIl * paramAnonymousFloat / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
          i1 = (int)(j - i / 2 - f.this.afIk * (1.0F - paramAnonymousFloat) / 2.0F + f.this.afIn * paramAnonymousFloat / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
          k = (int)(k / 2 + m - f.this.afIm * paramAnonymousFloat / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
          i = (int)(i / 2 + j - f.this.afIo * paramAnonymousFloat / (1.0F - (1.0F - f.this.afId) * paramAnonymousFloat));
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
              parama.Z(n, i1, k, i);
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
    parama = new TranslateAnimation(0.0F, this.afIb, 0.0F, this.afIc);
    parama.setDuration(200L);
    parama.setInterpolator(new DecelerateInterpolator(1.2F));
    paramView2.addAnimation(parama);
    parama = new AlphaAnimation(1.0F, this.afIj);
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
        f.this.afIw = f.this.afIs;
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
        f.this.afIw = f.this.afIv;
        AppMethodBeat.o(143088);
      }
    });
    paramView1.startAnimation(paramView2);
    AppMethodBeat.o(143096);
  }
  
  public final void af(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251049);
    this.uE = paramInt1;
    this.cey = paramInt2;
    this.mWidth = paramInt3;
    this.mHeight = paramInt4;
    Log.i("MicroMsg.ImagePreviewAnimation", "setAnimationParam: left=%d, top=%d, width=%d, height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(251049);
  }
  
  public final void oC(int paramInt1, int paramInt2)
  {
    this.afHZ = paramInt1;
    this.afIa = paramInt2;
  }
  
  public final void oD(int paramInt1, int paramInt2)
  {
    this.afIl = paramInt1;
    this.afIm = paramInt2;
    this.afIn = 0;
    this.afIo = 0;
  }
  
  public final void oE(int paramInt1, int paramInt2)
  {
    this.afIh = paramInt1;
    this.afIi = paramInt2;
  }
  
  public static abstract interface b
  {
    public abstract void onExit();
  }
  
  public static abstract interface c
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
  
  public static abstract interface d
  {
    public abstract void longClickOver();
  }
  
  public static abstract interface e
  {
    public abstract void onGalleryScale(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface f
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */