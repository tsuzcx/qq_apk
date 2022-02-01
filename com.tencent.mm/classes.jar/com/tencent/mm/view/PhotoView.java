package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class PhotoView
  extends AppCompatImageView
{
  private RectF Cfp;
  private GestureDetector Nf;
  private Matrix Woa;
  private int YLM;
  private int YLN;
  private float YLO;
  private int YLP;
  private int YLQ;
  private int YLR;
  private int YLS;
  private Matrix YLT;
  private Matrix YLU;
  private f YLV;
  private ScaleGestureDetector YLW;
  private ImageView.ScaleType YLX;
  private boolean YLY;
  private boolean YLZ;
  private e YMA;
  private ScaleGestureDetector.OnScaleGestureListener YMB;
  private Runnable YMC;
  private GestureDetector.OnGestureListener YMD;
  private Rect YME;
  private boolean YMa;
  private boolean YMb;
  private boolean YMc;
  private boolean YMd;
  private boolean YMe;
  private boolean YMf;
  private boolean YMg;
  private float YMh;
  private float YMi;
  private int YMj;
  private int YMk;
  private float YMl;
  private float YMm;
  private RectF YMn;
  private RectF YMo;
  private RectF YMp;
  private PointF YMq;
  private PointF YMr;
  private PointF YMs;
  private h YMt;
  private RectF YMu;
  private PhotoView.Info YMv;
  private long YMw;
  private Runnable YMx;
  private View.OnLongClickListener YMy;
  private i YMz;
  private boolean YcR;
  private Matrix auf;
  private boolean dih;
  private RectF eYA;
  private float eYO;
  private boolean isInit;
  private View.OnClickListener kte;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.YLP = 0;
    this.YLQ = 0;
    this.YLR = 0;
    this.YLS = 500;
    this.Woa = new Matrix();
    this.YLT = new Matrix();
    this.YLU = new Matrix();
    this.auf = new Matrix();
    this.dih = false;
    this.YMc = false;
    this.eYO = 1.0F;
    this.Cfp = new RectF();
    this.YMn = new RectF();
    this.YMo = new RectF();
    this.eYA = new RectF();
    this.YMp = new RectF();
    this.YMq = new PointF();
    this.YMr = new PointF();
    this.YMs = new PointF();
    this.YMt = new h();
    this.YMA = new e()
    {
      public final void w(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(164250);
        PhotoView.a(PhotoView.this, PhotoView.a(PhotoView.this) + paramAnonymousFloat1);
        if (PhotoView.b(PhotoView.this))
        {
          PhotoView.b(PhotoView.this, PhotoView.c(PhotoView.this) + paramAnonymousFloat1);
          PhotoView.d(PhotoView.this).postRotate(paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousFloat3);
          AppMethodBeat.o(164250);
          return;
        }
        if (Math.abs(PhotoView.a(PhotoView.this)) >= PhotoView.e(PhotoView.this))
        {
          PhotoView.a(PhotoView.this, true);
          PhotoView.a(PhotoView.this, 0.0F);
        }
        AppMethodBeat.o(164250);
      }
    };
    this.YMB = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        AppMethodBeat.i(164251);
        float f = paramAnonymousScaleGestureDetector.getScaleFactor();
        if ((Float.isNaN(f)) || (Float.isInfinite(f)))
        {
          AppMethodBeat.o(164251);
          return false;
        }
        PhotoView.c(PhotoView.this, PhotoView.f(PhotoView.this) * f);
        PhotoView.d(PhotoView.this).postScale(f, f, paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
        PhotoView.g(PhotoView.this);
        AppMethodBeat.o(164251);
        return true;
      }
      
      public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    this.YMC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(164252);
        if (PhotoView.h(PhotoView.this) != null) {
          PhotoView.h(PhotoView.this).onClick(PhotoView.this);
        }
        AppMethodBeat.o(164252);
      }
    };
    this.YMD = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213586);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(213586);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        PhotoView.o(PhotoView.this).stop();
        float f1 = PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).width() / 2.0F;
        float f2 = PhotoView.p(PhotoView.this).top + PhotoView.p(PhotoView.this).height() / 2.0F;
        PhotoView.w(PhotoView.this).set(f1, f2);
        PhotoView.x(PhotoView.this).set(f1, f2);
        PhotoView.a(PhotoView.this, 0);
        PhotoView.b(PhotoView.this, 0);
        if (PhotoView.y(PhotoView.this))
        {
          f2 = PhotoView.f(PhotoView.this);
          f1 = 1.0F;
          PhotoView.A(PhotoView.this).reset();
          PhotoView.A(PhotoView.this).postTranslate(-PhotoView.B(PhotoView.this).left, -PhotoView.B(PhotoView.this).top);
          PhotoView.A(PhotoView.this).postTranslate(PhotoView.x(PhotoView.this).x, PhotoView.x(PhotoView.this).y);
          PhotoView.A(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this), -PhotoView.D(PhotoView.this));
          PhotoView.A(PhotoView.this).postRotate(PhotoView.c(PhotoView.this), PhotoView.x(PhotoView.this).x, PhotoView.x(PhotoView.this).y);
          PhotoView.A(PhotoView.this).postScale(f1, f1, PhotoView.w(PhotoView.this).x, PhotoView.w(PhotoView.this).y);
          PhotoView.A(PhotoView.this).postTranslate(PhotoView.r(PhotoView.this), PhotoView.v(PhotoView.this));
          PhotoView.A(PhotoView.this).mapRect(PhotoView.E(PhotoView.this), PhotoView.B(PhotoView.this));
          PhotoView.a(PhotoView.this, PhotoView.E(PhotoView.this));
          paramAnonymousMotionEvent = PhotoView.this;
          if (PhotoView.y(PhotoView.this)) {
            break label499;
          }
        }
        label499:
        for (boolean bool = true;; bool = false)
        {
          PhotoView.c(paramAnonymousMotionEvent, bool);
          PhotoView.o(PhotoView.this).aL(f2, f1);
          PhotoView.o(PhotoView.this).start();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(164258);
          return false;
          f2 = PhotoView.f(PhotoView.this);
          f1 = PhotoView.z(PhotoView.this);
          PhotoView.w(PhotoView.this).set(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
          break;
        }
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164254);
        PhotoView.b(PhotoView.this, false);
        PhotoView.j(PhotoView.this);
        PhotoView.a(PhotoView.this, false);
        PhotoView.this.removeCallbacks(PhotoView.k(PhotoView.this));
        AppMethodBeat.o(164254);
        return false;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164255);
        if (PhotoView.l(PhotoView.this))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((!PhotoView.m(PhotoView.this)) && (!PhotoView.n(PhotoView.this)))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if (PhotoView.o(PhotoView.this).isRunning)
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((Math.round(PhotoView.p(PhotoView.this).left) >= PhotoView.q(PhotoView.this).left) || (Math.round(PhotoView.p(PhotoView.this).right) <= PhotoView.q(PhotoView.this).right)) {}
        for (float f2 = 0.0F;; f2 = paramAnonymousFloat1)
        {
          if ((Math.round(PhotoView.p(PhotoView.this).top) >= PhotoView.q(PhotoView.this).top) || (Math.round(PhotoView.p(PhotoView.this).bottom) <= PhotoView.q(PhotoView.this).bottom)) {}
          for (float f3 = 0.0F;; f3 = paramAnonymousFloat2)
          {
            float f4;
            float f5;
            float f1;
            PhotoView.h localh;
            label321:
            label351:
            int j;
            label385:
            int k;
            label396:
            int i1;
            label410:
            label421:
            label451:
            int m;
            label485:
            int n;
            label496:
            label510:
            OverScroller localOverScroller;
            int i2;
            int i3;
            int i4;
            int i5;
            if ((PhotoView.b(PhotoView.this)) || (PhotoView.c(PhotoView.this) % 90.0F != 0.0F))
            {
              f4 = (int)(PhotoView.c(PhotoView.this) / 90.0F) * 90;
              f5 = PhotoView.c(PhotoView.this) % 90.0F;
              if (f5 > 45.0F)
              {
                f1 = f4 + 90.0F;
                PhotoView.o(PhotoView.this).ns((int)PhotoView.c(PhotoView.this), (int)f1);
                PhotoView.b(PhotoView.this, f1);
              }
            }
            else
            {
              PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this));
              localh = PhotoView.o(PhotoView.this);
              if (f2 >= 0.0F) {
                break label686;
              }
              i = 2147483647;
              localh.amg = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.p(localh.YMF).left);
              j = (int)f1;
              i = j;
              if (f2 < 0.0F) {
                i = 2147483647 - j;
              }
              if (f2 >= 0.0F) {
                break label720;
              }
              j = i;
              if (f2 >= 0.0F) {
                break label726;
              }
              k = 2147483647;
              if (f2 >= 0.0F) {
                break label733;
              }
              i1 = 2147483647 - j;
              if (f3 >= 0.0F) {
                break label740;
              }
              i = 2147483647;
              localh.amh = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.p(localh.YMF).top);
              m = (int)f1;
              i = m;
              if (f3 < 0.0F) {
                i = 2147483647 - m;
              }
              if (f3 >= 0.0F) {
                break label774;
              }
              m = i;
              if (f3 >= 0.0F) {
                break label780;
              }
              n = 2147483647;
              if (f3 >= 0.0F) {
                break label787;
              }
              i = 2147483647 - m;
              if (f2 == 0.0F)
              {
                k = 0;
                j = 0;
              }
              if (f3 == 0.0F)
              {
                n = 0;
                m = 0;
              }
              localOverScroller = localh.Cfn;
              i2 = localh.amg;
              i3 = localh.amh;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.YMF) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.YMF) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.YMF))
            {
              localOverScroller.fling(i2, i3, i4, i5, j, k, m, n, i1, i);
              PhotoView.o(PhotoView.this).start();
              boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
              AppMethodBeat.o(164255);
              return bool;
              f1 = f4;
              if (f5 >= -45.0F) {
                break;
              }
              f1 = f4 - 90.0F;
              break;
              label686:
              i = 0;
              break label321;
              label692:
              f1 = PhotoView.p(localh.YMF).right - PhotoView.q(localh.YMF).right;
              break label351;
              label720:
              j = 0;
              break label385;
              label726:
              k = i;
              break label396;
              label733:
              i1 = i;
              break label410;
              label740:
              i = 0;
              break label421;
              label746:
              f1 = PhotoView.p(localh.YMF).bottom - PhotoView.q(localh.YMF).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.YMF);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        if (PhotoView.i(PhotoView.this) != null) {
          PhotoView.i(PhotoView.this).onLongClick(PhotoView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(164253);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164256);
        if (PhotoView.o(PhotoView.this).isRunning) {
          PhotoView.o(PhotoView.this).stop();
        }
        if (PhotoView.this.df(paramAnonymousFloat1))
        {
          if ((paramAnonymousFloat1 >= 0.0F) || (PhotoView.p(PhotoView.this).left - paramAnonymousFloat1 <= PhotoView.q(PhotoView.this).left)) {
            break label831;
          }
          paramAnonymousFloat1 = PhotoView.p(PhotoView.this).left;
        }
        label825:
        label831:
        for (;;)
        {
          float f1 = paramAnonymousFloat1;
          if (paramAnonymousFloat1 > 0.0F)
          {
            f1 = paramAnonymousFloat1;
            if (PhotoView.p(PhotoView.this).right - paramAnonymousFloat1 < PhotoView.q(PhotoView.this).right) {
              f1 = PhotoView.p(PhotoView.this).right - PhotoView.q(PhotoView.this).right;
            }
          }
          PhotoView.d(PhotoView.this).postTranslate(-f1, 0.0F);
          PhotoView.a(PhotoView.this, (int)(PhotoView.r(PhotoView.this) - f1));
          if (PhotoView.this.dg(paramAnonymousFloat2)) {
            if ((paramAnonymousFloat2 >= 0.0F) || (PhotoView.p(PhotoView.this).top - paramAnonymousFloat2 <= PhotoView.q(PhotoView.this).top)) {
              break label825;
            }
          }
          for (paramAnonymousFloat1 = PhotoView.p(PhotoView.this).top;; paramAnonymousFloat1 = paramAnonymousFloat2)
          {
            paramAnonymousFloat2 = paramAnonymousFloat1;
            if (paramAnonymousFloat1 > 0.0F)
            {
              paramAnonymousFloat2 = paramAnonymousFloat1;
              if (PhotoView.p(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.q(PhotoView.this).bottom) {
                paramAnonymousFloat2 = PhotoView.p(PhotoView.this).bottom - PhotoView.q(PhotoView.this).bottom;
              }
            }
            PhotoView.d(PhotoView.this).postTranslate(0.0F, -paramAnonymousFloat2);
            PhotoView.b(PhotoView.this, (int)(PhotoView.v(PhotoView.this) - paramAnonymousFloat2));
            for (;;)
            {
              PhotoView.g(PhotoView.this);
              AppMethodBeat.o(164256);
              return true;
              if ((!PhotoView.m(PhotoView.this)) && (!PhotoView.l(PhotoView.this)) && (!PhotoView.s(PhotoView.this))) {
                break;
              }
              PhotoView.t(PhotoView.this);
              float f2 = paramAnonymousFloat1;
              if (!PhotoView.l(PhotoView.this))
              {
                f1 = paramAnonymousFloat1;
                if (paramAnonymousFloat1 < 0.0F)
                {
                  f1 = paramAnonymousFloat1;
                  if (PhotoView.p(PhotoView.this).left - paramAnonymousFloat1 > PhotoView.u(PhotoView.this).left) {
                    f1 = PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this).left - PhotoView.u(PhotoView.this).left, paramAnonymousFloat1);
                  }
                }
                f2 = f1;
                if (f1 > 0.0F)
                {
                  f2 = f1;
                  if (PhotoView.p(PhotoView.this).right - f1 < PhotoView.u(PhotoView.this).right) {
                    f2 = PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this).right - PhotoView.u(PhotoView.this).right, f1);
                  }
                }
              }
              PhotoView.a(PhotoView.this, (int)(PhotoView.r(PhotoView.this) - f2));
              PhotoView.d(PhotoView.this).postTranslate(-f2, 0.0F);
              PhotoView.b(PhotoView.this, true);
              break;
              if ((PhotoView.n(PhotoView.this)) || (PhotoView.s(PhotoView.this)) || (PhotoView.l(PhotoView.this)))
              {
                PhotoView.t(PhotoView.this);
                f1 = paramAnonymousFloat2;
                if (!PhotoView.l(PhotoView.this))
                {
                  paramAnonymousFloat1 = paramAnonymousFloat2;
                  if (paramAnonymousFloat2 < 0.0F)
                  {
                    paramAnonymousFloat1 = paramAnonymousFloat2;
                    if (PhotoView.p(PhotoView.this).top - paramAnonymousFloat2 > PhotoView.u(PhotoView.this).top) {
                      paramAnonymousFloat1 = PhotoView.b(PhotoView.this, PhotoView.p(PhotoView.this).top - PhotoView.u(PhotoView.this).top, paramAnonymousFloat2);
                    }
                  }
                  f1 = paramAnonymousFloat1;
                  if (paramAnonymousFloat1 > 0.0F)
                  {
                    f1 = paramAnonymousFloat1;
                    if (PhotoView.p(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.u(PhotoView.this).bottom) {
                      f1 = PhotoView.b(PhotoView.this, PhotoView.p(PhotoView.this).bottom - PhotoView.u(PhotoView.this).bottom, paramAnonymousFloat1);
                    }
                  }
                }
                PhotoView.d(PhotoView.this).postTranslate(0.0F, -f1);
                PhotoView.b(PhotoView.this, (int)(PhotoView.v(PhotoView.this) - f1));
                PhotoView.b(PhotoView.this, true);
              }
            }
          }
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164257);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.YME = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.YLP = 0;
    this.YLQ = 0;
    this.YLR = 0;
    this.YLS = 500;
    this.Woa = new Matrix();
    this.YLT = new Matrix();
    this.YLU = new Matrix();
    this.auf = new Matrix();
    this.dih = false;
    this.YMc = false;
    this.eYO = 1.0F;
    this.Cfp = new RectF();
    this.YMn = new RectF();
    this.YMo = new RectF();
    this.eYA = new RectF();
    this.YMp = new RectF();
    this.YMq = new PointF();
    this.YMr = new PointF();
    this.YMs = new PointF();
    this.YMt = new h();
    this.YMA = new e()
    {
      public final void w(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(164250);
        PhotoView.a(PhotoView.this, PhotoView.a(PhotoView.this) + paramAnonymousFloat1);
        if (PhotoView.b(PhotoView.this))
        {
          PhotoView.b(PhotoView.this, PhotoView.c(PhotoView.this) + paramAnonymousFloat1);
          PhotoView.d(PhotoView.this).postRotate(paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousFloat3);
          AppMethodBeat.o(164250);
          return;
        }
        if (Math.abs(PhotoView.a(PhotoView.this)) >= PhotoView.e(PhotoView.this))
        {
          PhotoView.a(PhotoView.this, true);
          PhotoView.a(PhotoView.this, 0.0F);
        }
        AppMethodBeat.o(164250);
      }
    };
    this.YMB = new ScaleGestureDetector.OnScaleGestureListener()
    {
      public final boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        AppMethodBeat.i(164251);
        float f = paramAnonymousScaleGestureDetector.getScaleFactor();
        if ((Float.isNaN(f)) || (Float.isInfinite(f)))
        {
          AppMethodBeat.o(164251);
          return false;
        }
        PhotoView.c(PhotoView.this, PhotoView.f(PhotoView.this) * f);
        PhotoView.d(PhotoView.this).postScale(f, f, paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
        PhotoView.g(PhotoView.this);
        AppMethodBeat.o(164251);
        return true;
      }
      
      public final boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        return true;
      }
      
      public final void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector) {}
    };
    this.YMC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(164252);
        if (PhotoView.h(PhotoView.this) != null) {
          PhotoView.h(PhotoView.this).onClick(PhotoView.this);
        }
        AppMethodBeat.o(164252);
      }
    };
    this.YMD = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(213586);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(213586);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        PhotoView.o(PhotoView.this).stop();
        float f1 = PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).width() / 2.0F;
        float f2 = PhotoView.p(PhotoView.this).top + PhotoView.p(PhotoView.this).height() / 2.0F;
        PhotoView.w(PhotoView.this).set(f1, f2);
        PhotoView.x(PhotoView.this).set(f1, f2);
        PhotoView.a(PhotoView.this, 0);
        PhotoView.b(PhotoView.this, 0);
        if (PhotoView.y(PhotoView.this))
        {
          f2 = PhotoView.f(PhotoView.this);
          f1 = 1.0F;
          PhotoView.A(PhotoView.this).reset();
          PhotoView.A(PhotoView.this).postTranslate(-PhotoView.B(PhotoView.this).left, -PhotoView.B(PhotoView.this).top);
          PhotoView.A(PhotoView.this).postTranslate(PhotoView.x(PhotoView.this).x, PhotoView.x(PhotoView.this).y);
          PhotoView.A(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this), -PhotoView.D(PhotoView.this));
          PhotoView.A(PhotoView.this).postRotate(PhotoView.c(PhotoView.this), PhotoView.x(PhotoView.this).x, PhotoView.x(PhotoView.this).y);
          PhotoView.A(PhotoView.this).postScale(f1, f1, PhotoView.w(PhotoView.this).x, PhotoView.w(PhotoView.this).y);
          PhotoView.A(PhotoView.this).postTranslate(PhotoView.r(PhotoView.this), PhotoView.v(PhotoView.this));
          PhotoView.A(PhotoView.this).mapRect(PhotoView.E(PhotoView.this), PhotoView.B(PhotoView.this));
          PhotoView.a(PhotoView.this, PhotoView.E(PhotoView.this));
          paramAnonymousMotionEvent = PhotoView.this;
          if (PhotoView.y(PhotoView.this)) {
            break label499;
          }
        }
        label499:
        for (boolean bool = true;; bool = false)
        {
          PhotoView.c(paramAnonymousMotionEvent, bool);
          PhotoView.o(PhotoView.this).aL(f2, f1);
          PhotoView.o(PhotoView.this).start();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(164258);
          return false;
          f2 = PhotoView.f(PhotoView.this);
          f1 = PhotoView.z(PhotoView.this);
          PhotoView.w(PhotoView.this).set(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
          break;
        }
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164254);
        PhotoView.b(PhotoView.this, false);
        PhotoView.j(PhotoView.this);
        PhotoView.a(PhotoView.this, false);
        PhotoView.this.removeCallbacks(PhotoView.k(PhotoView.this));
        AppMethodBeat.o(164254);
        return false;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164255);
        if (PhotoView.l(PhotoView.this))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((!PhotoView.m(PhotoView.this)) && (!PhotoView.n(PhotoView.this)))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if (PhotoView.o(PhotoView.this).isRunning)
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((Math.round(PhotoView.p(PhotoView.this).left) >= PhotoView.q(PhotoView.this).left) || (Math.round(PhotoView.p(PhotoView.this).right) <= PhotoView.q(PhotoView.this).right)) {}
        for (float f2 = 0.0F;; f2 = paramAnonymousFloat1)
        {
          if ((Math.round(PhotoView.p(PhotoView.this).top) >= PhotoView.q(PhotoView.this).top) || (Math.round(PhotoView.p(PhotoView.this).bottom) <= PhotoView.q(PhotoView.this).bottom)) {}
          for (float f3 = 0.0F;; f3 = paramAnonymousFloat2)
          {
            float f4;
            float f5;
            float f1;
            PhotoView.h localh;
            label321:
            label351:
            int j;
            label385:
            int k;
            label396:
            int i1;
            label410:
            label421:
            label451:
            int m;
            label485:
            int n;
            label496:
            label510:
            OverScroller localOverScroller;
            int i2;
            int i3;
            int i4;
            int i5;
            if ((PhotoView.b(PhotoView.this)) || (PhotoView.c(PhotoView.this) % 90.0F != 0.0F))
            {
              f4 = (int)(PhotoView.c(PhotoView.this) / 90.0F) * 90;
              f5 = PhotoView.c(PhotoView.this) % 90.0F;
              if (f5 > 45.0F)
              {
                f1 = f4 + 90.0F;
                PhotoView.o(PhotoView.this).ns((int)PhotoView.c(PhotoView.this), (int)f1);
                PhotoView.b(PhotoView.this, f1);
              }
            }
            else
            {
              PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this));
              localh = PhotoView.o(PhotoView.this);
              if (f2 >= 0.0F) {
                break label686;
              }
              i = 2147483647;
              localh.amg = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.p(localh.YMF).left);
              j = (int)f1;
              i = j;
              if (f2 < 0.0F) {
                i = 2147483647 - j;
              }
              if (f2 >= 0.0F) {
                break label720;
              }
              j = i;
              if (f2 >= 0.0F) {
                break label726;
              }
              k = 2147483647;
              if (f2 >= 0.0F) {
                break label733;
              }
              i1 = 2147483647 - j;
              if (f3 >= 0.0F) {
                break label740;
              }
              i = 2147483647;
              localh.amh = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.p(localh.YMF).top);
              m = (int)f1;
              i = m;
              if (f3 < 0.0F) {
                i = 2147483647 - m;
              }
              if (f3 >= 0.0F) {
                break label774;
              }
              m = i;
              if (f3 >= 0.0F) {
                break label780;
              }
              n = 2147483647;
              if (f3 >= 0.0F) {
                break label787;
              }
              i = 2147483647 - m;
              if (f2 == 0.0F)
              {
                k = 0;
                j = 0;
              }
              if (f3 == 0.0F)
              {
                n = 0;
                m = 0;
              }
              localOverScroller = localh.Cfn;
              i2 = localh.amg;
              i3 = localh.amh;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.YMF) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.YMF) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.YMF))
            {
              localOverScroller.fling(i2, i3, i4, i5, j, k, m, n, i1, i);
              PhotoView.o(PhotoView.this).start();
              boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
              AppMethodBeat.o(164255);
              return bool;
              f1 = f4;
              if (f5 >= -45.0F) {
                break;
              }
              f1 = f4 - 90.0F;
              break;
              label686:
              i = 0;
              break label321;
              label692:
              f1 = PhotoView.p(localh.YMF).right - PhotoView.q(localh.YMF).right;
              break label351;
              label720:
              j = 0;
              break label385;
              label726:
              k = i;
              break label396;
              label733:
              i1 = i;
              break label410;
              label740:
              i = 0;
              break label421;
              label746:
              f1 = PhotoView.p(localh.YMF).bottom - PhotoView.q(localh.YMF).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.YMF);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        if (PhotoView.i(PhotoView.this) != null) {
          PhotoView.i(PhotoView.this).onLongClick(PhotoView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(164253);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164256);
        if (PhotoView.o(PhotoView.this).isRunning) {
          PhotoView.o(PhotoView.this).stop();
        }
        if (PhotoView.this.df(paramAnonymousFloat1))
        {
          if ((paramAnonymousFloat1 >= 0.0F) || (PhotoView.p(PhotoView.this).left - paramAnonymousFloat1 <= PhotoView.q(PhotoView.this).left)) {
            break label831;
          }
          paramAnonymousFloat1 = PhotoView.p(PhotoView.this).left;
        }
        label825:
        label831:
        for (;;)
        {
          float f1 = paramAnonymousFloat1;
          if (paramAnonymousFloat1 > 0.0F)
          {
            f1 = paramAnonymousFloat1;
            if (PhotoView.p(PhotoView.this).right - paramAnonymousFloat1 < PhotoView.q(PhotoView.this).right) {
              f1 = PhotoView.p(PhotoView.this).right - PhotoView.q(PhotoView.this).right;
            }
          }
          PhotoView.d(PhotoView.this).postTranslate(-f1, 0.0F);
          PhotoView.a(PhotoView.this, (int)(PhotoView.r(PhotoView.this) - f1));
          if (PhotoView.this.dg(paramAnonymousFloat2)) {
            if ((paramAnonymousFloat2 >= 0.0F) || (PhotoView.p(PhotoView.this).top - paramAnonymousFloat2 <= PhotoView.q(PhotoView.this).top)) {
              break label825;
            }
          }
          for (paramAnonymousFloat1 = PhotoView.p(PhotoView.this).top;; paramAnonymousFloat1 = paramAnonymousFloat2)
          {
            paramAnonymousFloat2 = paramAnonymousFloat1;
            if (paramAnonymousFloat1 > 0.0F)
            {
              paramAnonymousFloat2 = paramAnonymousFloat1;
              if (PhotoView.p(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.q(PhotoView.this).bottom) {
                paramAnonymousFloat2 = PhotoView.p(PhotoView.this).bottom - PhotoView.q(PhotoView.this).bottom;
              }
            }
            PhotoView.d(PhotoView.this).postTranslate(0.0F, -paramAnonymousFloat2);
            PhotoView.b(PhotoView.this, (int)(PhotoView.v(PhotoView.this) - paramAnonymousFloat2));
            for (;;)
            {
              PhotoView.g(PhotoView.this);
              AppMethodBeat.o(164256);
              return true;
              if ((!PhotoView.m(PhotoView.this)) && (!PhotoView.l(PhotoView.this)) && (!PhotoView.s(PhotoView.this))) {
                break;
              }
              PhotoView.t(PhotoView.this);
              float f2 = paramAnonymousFloat1;
              if (!PhotoView.l(PhotoView.this))
              {
                f1 = paramAnonymousFloat1;
                if (paramAnonymousFloat1 < 0.0F)
                {
                  f1 = paramAnonymousFloat1;
                  if (PhotoView.p(PhotoView.this).left - paramAnonymousFloat1 > PhotoView.u(PhotoView.this).left) {
                    f1 = PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this).left - PhotoView.u(PhotoView.this).left, paramAnonymousFloat1);
                  }
                }
                f2 = f1;
                if (f1 > 0.0F)
                {
                  f2 = f1;
                  if (PhotoView.p(PhotoView.this).right - f1 < PhotoView.u(PhotoView.this).right) {
                    f2 = PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this).right - PhotoView.u(PhotoView.this).right, f1);
                  }
                }
              }
              PhotoView.a(PhotoView.this, (int)(PhotoView.r(PhotoView.this) - f2));
              PhotoView.d(PhotoView.this).postTranslate(-f2, 0.0F);
              PhotoView.b(PhotoView.this, true);
              break;
              if ((PhotoView.n(PhotoView.this)) || (PhotoView.s(PhotoView.this)) || (PhotoView.l(PhotoView.this)))
              {
                PhotoView.t(PhotoView.this);
                f1 = paramAnonymousFloat2;
                if (!PhotoView.l(PhotoView.this))
                {
                  paramAnonymousFloat1 = paramAnonymousFloat2;
                  if (paramAnonymousFloat2 < 0.0F)
                  {
                    paramAnonymousFloat1 = paramAnonymousFloat2;
                    if (PhotoView.p(PhotoView.this).top - paramAnonymousFloat2 > PhotoView.u(PhotoView.this).top) {
                      paramAnonymousFloat1 = PhotoView.b(PhotoView.this, PhotoView.p(PhotoView.this).top - PhotoView.u(PhotoView.this).top, paramAnonymousFloat2);
                    }
                  }
                  f1 = paramAnonymousFloat1;
                  if (paramAnonymousFloat1 > 0.0F)
                  {
                    f1 = paramAnonymousFloat1;
                    if (PhotoView.p(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.u(PhotoView.this).bottom) {
                      f1 = PhotoView.b(PhotoView.this, PhotoView.p(PhotoView.this).bottom - PhotoView.u(PhotoView.this).bottom, paramAnonymousFloat1);
                    }
                  }
                }
                PhotoView.d(PhotoView.this).postTranslate(0.0F, -f1);
                PhotoView.b(PhotoView.this, (int)(PhotoView.v(PhotoView.this) - f1));
                PhotoView.b(PhotoView.this, true);
              }
            }
          }
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164257);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.YME = new Rect();
    init();
    AppMethodBeat.o(164284);
  }
  
  private static int N(Drawable paramDrawable)
  {
    AppMethodBeat.i(164290);
    int j = paramDrawable.getIntrinsicWidth();
    int i = j;
    if (j <= 0) {
      i = paramDrawable.getMinimumWidth();
    }
    j = i;
    if (i <= 0) {
      j = paramDrawable.getBounds().width();
    }
    AppMethodBeat.o(164290);
    return j;
  }
  
  private static int O(Drawable paramDrawable)
  {
    AppMethodBeat.i(164291);
    int j = paramDrawable.getIntrinsicHeight();
    int i = j;
    if (j <= 0) {
      i = paramDrawable.getMinimumHeight();
    }
    j = i;
    if (i <= 0) {
      j = paramDrawable.getBounds().height();
    }
    AppMethodBeat.o(164291);
    return j;
  }
  
  private void a(PhotoView.Info paramInfo)
  {
    AppMethodBeat.i(164318);
    if (this.isInit)
    {
      reset();
      this.YME.set(paramInfo.YME);
      PhotoView.Info localInfo = getInfo();
      float f1 = paramInfo.YMo.width() / localInfo.YMo.width();
      float f2 = paramInfo.YMo.height() / localInfo.YMo.height();
      if (f1 < f2)
      {
        f2 = paramInfo.raG.left + paramInfo.raG.width() / 2.0F;
        float f3 = paramInfo.raG.top + paramInfo.raG.height() / 2.0F;
        float f4 = localInfo.raG.left + localInfo.raG.width() / 2.0F;
        float f5 = localInfo.raG.top;
        f5 = localInfo.raG.height() / 2.0F + f5;
        this.YLT.reset();
        this.YLT.postTranslate(f2 - f4, f3 - f5);
        this.YLT.postScale(f1, f1, f2, f3);
        this.YLT.postRotate(paramInfo.YMi, f2, f3);
        ihm();
        this.YMr.set(f2, f3);
        this.YMs.set(f2, f3);
        this.YMt.nr((int)-(f2 - f4), (int)-(f3 - f5));
        this.YMt.aL(f1, 1.0F);
        this.YMt.ns((int)paramInfo.YMi, 0);
        if ((paramInfo.Cfp.width() < paramInfo.YMo.width()) || (paramInfo.Cfp.height() < paramInfo.YMo.height()))
        {
          f2 = paramInfo.Cfp.width() / paramInfo.YMo.width();
          f3 = paramInfo.Cfp.height() / paramInfo.YMo.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.YLX != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.YMt.a(f1, f2, 1.0F - f1, 1.0F - f2, this.YLN / 3, paramInfo);
        this.auf.setScale(f1, f2, (this.YMo.left + this.YMo.right) / 2.0F, paramInfo.ihn());
        this.auf.mapRect(this.YMt.YMR, this.YMo);
        this.YMu = this.YMt.YMR;
        this.YMt.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.YLX == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.YMv = paramInfo;
    this.YMw = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void ihd()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.YLZ)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.YMa)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.YMu != null) {
      this.YMu.setEmpty();
    }
    this.Woa.reset();
    this.YLT.reset();
    this.YLU.reset();
    this.auf.reset();
    this.YMd = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = N(localDrawable);
    int m = O(localDrawable);
    this.YMn.set(0.0F, 0.0F, k, m);
    int n = (i - k) / 2;
    int i1 = (j - m) / 2;
    if (k > i) {}
    for (float f1 = i / k;; f1 = 1.0F)
    {
      if (m > j) {
        f2 = j / m;
      }
      if (f1 < f2)
      {
        this.Woa.reset();
        this.Woa.postTranslate(n, i1);
        this.Woa.postScale(f1, f1, this.YMq.x, this.YMq.y);
        this.Woa.mapRect(this.YMn);
        this.YMl = (this.YMn.width() / 2.0F);
        this.YMm = (this.YMn.height() / 2.0F);
        this.YMr.set(this.YMq);
        this.YMs.set(this.YMr);
        ihm();
        switch (PhotoView.5.apX[this.YLX.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.isInit = true;
        if ((this.YMv != null) && (System.currentTimeMillis() - this.YMw < this.YLS)) {
          a(this.YMv);
        }
        this.YMv = null;
        if (this.YMz != null)
        {
          setImageMatrix(this.YLU);
          this.YMz = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        ihe();
        continue;
        ihf();
        continue;
        ihg();
        continue;
        ihh();
        continue;
        ihi();
        continue;
        ihj();
        continue;
        ihk();
      }
    }
  }
  
  private void ihe()
  {
    AppMethodBeat.i(164293);
    if (!this.YLZ)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.YMa)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = N(localDrawable);
    int j = O(localDrawable);
    float f1;
    float f2;
    if ((i > this.Cfp.width()) || (j > this.Cfp.height()))
    {
      f1 = i / this.YMo.width();
      f2 = j / this.YMo.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.eYO = f1;
      this.YLT.postScale(this.eYO, this.eYO, this.YMq.x, this.YMq.y);
      ihm();
      ihl();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void ihf()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.YMo.width() < this.Cfp.width()) || (this.YMo.height() < this.Cfp.height()))
    {
      f1 = this.Cfp.width() / this.YMo.width();
      f2 = this.Cfp.height() / this.YMo.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.eYO = f1;
      this.YLT.postScale(this.eYO, this.eYO, this.YMq.x, this.YMq.y);
      ihm();
      ihl();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void ihg()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.YMo.width() > this.Cfp.width()) || (this.YMo.height() > this.Cfp.height()))
    {
      f1 = this.Cfp.width() / this.YMo.width();
      f2 = this.Cfp.height() / this.YMo.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.eYO = f1;
      this.YLT.postScale(this.eYO, this.eYO, this.YMq.x, this.YMq.y);
      ihm();
      ihl();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void ihh()
  {
    AppMethodBeat.i(164296);
    if (this.YMo.width() < this.Cfp.width())
    {
      this.eYO = (this.Cfp.width() / this.YMo.width());
      this.YLT.postScale(this.eYO, this.eYO, this.YMq.x, this.YMq.y);
      ihm();
      ihl();
    }
    AppMethodBeat.o(164296);
  }
  
  private void ihi()
  {
    AppMethodBeat.i(164297);
    ihh();
    float f = -this.YMo.top;
    this.YLT.postTranslate(0.0F, f);
    ihm();
    ihl();
    this.YMk = ((int)(f + this.YMk));
    AppMethodBeat.o(164297);
  }
  
  private void ihj()
  {
    AppMethodBeat.i(164298);
    ihh();
    float f = this.Cfp.bottom - this.YMo.bottom;
    this.YMk = ((int)(this.YMk + f));
    this.YLT.postTranslate(0.0F, f);
    ihm();
    ihl();
    AppMethodBeat.o(164298);
  }
  
  private void ihk()
  {
    AppMethodBeat.i(164299);
    float f1 = this.Cfp.width() / this.YMo.width();
    float f2 = this.Cfp.height() / this.YMo.height();
    this.YLT.postScale(f1, f2, this.YMq.x, this.YMq.y);
    ihm();
    ihl();
    AppMethodBeat.o(164299);
  }
  
  private void ihl()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = N(localDrawable);
    int j = O(localDrawable);
    this.YMn.set(0.0F, 0.0F, i, j);
    this.Woa.set(this.YLU);
    this.Woa.mapRect(this.YMn);
    this.YMl = (this.YMn.width() / 2.0F);
    this.YMm = (this.YMn.height() / 2.0F);
    this.eYO = 1.0F;
    this.YMj = 0;
    this.YMk = 0;
    this.YLT.reset();
    AppMethodBeat.o(164300);
  }
  
  private void ihm()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.YLU.set(this.Woa);
    this.YLU.postConcat(this.YLT);
    setImageMatrix(this.YLU);
    this.YLT.mapRect(this.YMo, this.YMn);
    if (this.YMo.width() > this.Cfp.width())
    {
      bool1 = true;
      this.YMf = bool1;
      if (this.YMo.height() <= this.Cfp.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.YMg = bool1;
      AppMethodBeat.o(164301);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(164285);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.YLX == null) {
      this.YLX = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.YLV = new f(this.YMA);
    this.Nf = new GestureDetector(getContext(), this.YMD);
    this.YLW = new ScaleGestureDetector(getContext(), this.YMB);
    float f = getResources().getDisplayMetrics().density;
    this.YLP = ((int)(f * 30.0F));
    this.YLQ = ((int)(f * 30.0F));
    this.YLR = ((int)(f * 140.0F));
    this.YLM = 35;
    this.YLN = 200;
    this.YLO = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void n(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.Cfp.width())
    {
      if (p(paramRectF)) {
        break label275;
      }
      i = -(int)((this.Cfp.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.Cfp.height()) {
        if (!o(paramRectF)) {
          j = -(int)((this.Cfp.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.YMt.Cfn.isFinished()) {
            this.YMt.Cfn.abortAnimation();
          }
          this.YMt.nr(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.Cfp.left)
        {
          i = (int)(paramRectF.left - this.Cfp.left);
          break;
        }
        if (paramRectF.right >= this.Cfp.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.Cfp.right);
        break;
        if (paramRectF.top > this.Cfp.top) {
          j = (int)(paramRectF.top - this.Cfp.top);
        } else if (paramRectF.bottom < this.Cfp.bottom) {
          j = (int)(paramRectF.bottom - this.Cfp.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean o(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.Cfp.height() - paramRectF.height()) / 2.0F) < 1.0F)
    {
      AppMethodBeat.o(164309);
      return true;
    }
    AppMethodBeat.o(164309);
    return false;
  }
  
  private boolean p(RectF paramRectF)
  {
    AppMethodBeat.i(164310);
    if (Math.abs(Math.round(paramRectF.left) - (this.Cfp.width() - paramRectF.width()) / 2.0F) < 1.0F)
    {
      AppMethodBeat.o(164310);
      return true;
    }
    AppMethodBeat.o(164310);
    return false;
  }
  
  private void reset()
  {
    AppMethodBeat.i(164317);
    this.YLT.reset();
    ihm();
    this.eYO = 1.0F;
    this.YMj = 0;
    this.YMk = 0;
    AppMethodBeat.o(164317);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(164313);
    if (this.YLY)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = df(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.YLY)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = dg(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public final boolean df(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.YMo.width() <= this.Cfp.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.YMo.left) - paramFloat >= this.Cfp.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.YMo.right) - paramFloat <= this.Cfp.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean dg(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.YMo.height() <= this.Cfp.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.YMo.top) - paramFloat >= this.Cfp.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.YMo.bottom) - paramFloat <= this.Cfp.bottom))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    AppMethodBeat.o(164312);
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164306);
    paramCanvas.save();
    if (this.YMu != null) {
      paramCanvas.clipRect(this.YMu);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public int getAnimaDuring()
  {
    return this.YLN;
  }
  
  public long getDefaultAnimDuring()
  {
    return 200L;
  }
  
  public PhotoView.Info getInfo()
  {
    AppMethodBeat.i(164315);
    Object localObject = new Rect();
    int[] arrayOfInt = new int[2];
    Rect localRect1 = this.YME;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.YMo.left, arrayOfInt[1] + (int)this.YMo.top, arrayOfInt[0] + (int)this.YMo.right, arrayOfInt[1] + (int)this.YMo.bottom);
    localObject = new PhotoView.Info((Rect)localObject, this.YMo, this.Cfp, this.YMn, this.YMq, this.eYO, this.YMi, this.YLX, this.YME);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.YLO;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.YLZ)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(164303);
      return;
    }
    Object localObject = getDrawable();
    int j = N((Drawable)localObject);
    int i = O((Drawable)localObject);
    int m = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new ViewGroup.LayoutParams(-2, -2);
    }
    label132:
    float f1;
    float f2;
    if (((ViewGroup.LayoutParams)localObject).width == -1)
    {
      if (i1 == 0) {
        break label263;
      }
      paramInt1 = m;
      if (((ViewGroup.LayoutParams)localObject).height != -1) {
        break label269;
      }
      if (n == 0) {
        break label304;
      }
      paramInt2 = k;
      k = paramInt1;
      m = paramInt2;
      if (this.YcR)
      {
        k = paramInt1;
        m = paramInt2;
        if (j / i != paramInt1 / paramInt2)
        {
          f1 = paramInt2 / i;
          f2 = paramInt1 / j;
          if (f1 >= f2) {
            break label310;
          }
          label189:
          if (((ViewGroup.LayoutParams)localObject).width != -1) {
            break label316;
          }
          label198:
          if (((ViewGroup.LayoutParams)localObject).height != -1) {
            break label326;
          }
          m = paramInt2;
        }
      }
    }
    for (k = paramInt1;; k = paramInt1)
    {
      setMeasuredDimension(k, m);
      AppMethodBeat.o(164303);
      return;
      paramInt1 = m;
      if (i1 == 1073741824) {
        break;
      }
      if (i1 == -2147483648)
      {
        paramInt1 = m;
        if (j > m) {
          break;
        }
        paramInt1 = j;
        break;
      }
      label263:
      paramInt1 = j;
      break;
      label269:
      paramInt2 = k;
      if (n == 1073741824) {
        break label132;
      }
      if (n == -2147483648)
      {
        paramInt2 = k;
        if (i > k) {
          break label132;
        }
        paramInt2 = i;
        break label132;
      }
      label304:
      paramInt2 = i;
      break label132;
      label310:
      f1 = f2;
      break label189;
      label316:
      paramInt1 = (int)(j * f1);
      break label198;
      label326:
      m = (int)(i * f1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164305);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("PhotoView", "[onSizeChanged] w:%s, h:%s, oldw:%s, oldh:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.Cfp.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.YMq.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.YMa)
    {
      this.YMa = true;
      ihd();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.dih)
    {
      this.YMu = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.YLY = true;
      }
      Object localObject = this.Nf;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.YMc) {
        localObject = this.YLV;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.YLW.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.YMt.isRunning))
        {
          if ((this.YMe) || (this.YMi % 90.0F != 0.0F))
          {
            f2 = (int)(this.YMi / 90.0F) * 90;
            f3 = this.YMi % 90.0F;
            if (f3 <= 45.0F) {
              break label639;
            }
            f1 = f2 + 90.0F;
            label265:
            this.YMt.ns((int)this.YMi, (int)f1);
            this.YMi = f1;
          }
          f1 = this.eYO;
          if (this.eYO >= 1.0F) {
            break label663;
          }
          f1 = 1.0F;
          this.YMt.aL(this.eYO, 1.0F);
        }
        break;
      }
      for (;;)
      {
        f2 = this.YMo.left + this.YMo.width() / 2.0F;
        f3 = this.YMo.top + this.YMo.height() / 2.0F;
        this.YMr.set(f2, f3);
        this.YMs.set(f2, f3);
        this.YMj = 0;
        this.YMk = 0;
        this.auf.reset();
        this.auf.postTranslate(-this.YMn.left, -this.YMn.top);
        this.auf.postTranslate(f2 - this.YMl, f3 - this.YMm);
        this.auf.postScale(f1, f1, f2, f3);
        this.auf.postRotate(this.YMi, f2, f3);
        this.auf.mapRect(this.eYA, this.YMn);
        n(this.eYA);
        this.YMt.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        ((f)localObject).YMI = ((f)localObject).aH(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        ((f)localObject).YMJ = ((f)localObject).aH(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(((f)localObject).YMJ)) - Math.toDegrees(Math.atan(((f)localObject).YMI));
        if (Math.abs(d) <= 120.0D) {
          ((f)localObject).YMH.w((float)d, (((f)localObject).x2 + ((f)localObject).x1) / 2.0F, (((f)localObject).y2 + ((f)localObject).y1) / 2.0F);
        }
        ((f)localObject).YMI = ((f)localObject).YMJ;
        break;
        label639:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label265;
        }
        f1 = f2 - 90.0F;
        break label265;
        label663:
        if (this.eYO > this.YLO)
        {
          f1 = this.YLO;
          this.YMt.aL(this.eYO, this.YLO);
        }
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(164307);
    return bool;
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    AppMethodBeat.i(164304);
    super.setAdjustViewBounds(paramBoolean);
    this.YcR = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.YLN = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.YME);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.YLZ = false;
      AppMethodBeat.o(164289);
      return;
    }
    if (((paramDrawable.getIntrinsicHeight() <= 0) || (paramDrawable.getIntrinsicWidth() <= 0)) && ((paramDrawable.getMinimumWidth() <= 0) || (paramDrawable.getMinimumHeight() <= 0)))
    {
      i = j;
      if (paramDrawable.getBounds().width() > 0) {
        if (paramDrawable.getBounds().height() > 0) {
          break label92;
        }
      }
    }
    label92:
    for (int i = j; i == 0; i = 1)
    {
      AppMethodBeat.o(164289);
      return;
    }
    if (!this.YLZ) {
      this.YLZ = true;
    }
    ihd();
    AppMethodBeat.o(164289);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(164288);
    Object localObject = null;
    try
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      localObject = localDrawable;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    setImageDrawable(localObject);
    AppMethodBeat.o(164288);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.YMt.YMS.YMG = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.YLS = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.YLO = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.kte = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.YMy = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.YLX)
    {
      this.YLX = paramScaleType;
      if (this.isInit) {
        ihd();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static abstract interface a
  {
    public abstract float ihn();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float ihn()
    {
      AppMethodBeat.i(164260);
      float f = PhotoView.p(PhotoView.this).bottom;
      AppMethodBeat.o(164260);
      return f;
    }
  }
  
  final class c
    implements Interpolator
  {
    Interpolator YMG;
    
    private c()
    {
      AppMethodBeat.i(164267);
      this.YMG = new DecelerateInterpolator();
      AppMethodBeat.o(164267);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      AppMethodBeat.i(164268);
      if (this.YMG != null)
      {
        paramFloat = this.YMG.getInterpolation(paramFloat);
        AppMethodBeat.o(164268);
        return paramFloat;
      }
      AppMethodBeat.o(164268);
      return paramFloat;
    }
  }
  
  public final class d
    implements PhotoView.a
  {
    public d() {}
    
    public final float ihn()
    {
      AppMethodBeat.i(164269);
      float f = (PhotoView.p(PhotoView.this).top + PhotoView.p(PhotoView.this).bottom) / 2.0F;
      AppMethodBeat.o(164269);
      return f;
    }
  }
  
  static abstract interface e
  {
    public abstract void w(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public final class f
  {
    PhotoView.e YMH;
    float YMI;
    float YMJ;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.YMH = parame;
    }
    
    final float aH(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(164270);
      this.x1 = paramMotionEvent.getX(0);
      this.y1 = paramMotionEvent.getY(0);
      this.x2 = paramMotionEvent.getX(1);
      this.y2 = paramMotionEvent.getY(1);
      float f = (this.y2 - this.y1) / (this.x2 - this.x1);
      AppMethodBeat.o(164270);
      return f;
    }
  }
  
  public final class g
    implements PhotoView.a
  {
    public g() {}
    
    public final float ihn()
    {
      AppMethodBeat.i(164271);
      float f = PhotoView.p(PhotoView.this).top;
      AppMethodBeat.o(164271);
      return f;
    }
  }
  
  final class h
    implements Runnable
  {
    OverScroller Cfn;
    OverScroller YMK;
    Scroller YML;
    Scroller YMM;
    Scroller YMN;
    PhotoView.a YMO;
    int YMP;
    int YMQ;
    RectF YMR;
    PhotoView.c YMS;
    int amg;
    int amh;
    boolean isRunning;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.YMR = new RectF();
      this.YMS = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.YMK = new OverScroller(PhotoView.this, this.YMS);
      this.YML = new Scroller(PhotoView.this, this.YMS);
      this.Cfn = new OverScroller(PhotoView.this, this.YMS);
      this.YMM = new Scroller(PhotoView.this, this.YMS);
      this.YMN = new Scroller(PhotoView.this, this.YMS);
      AppMethodBeat.o(164273);
    }
    
    private void iho()
    {
      AppMethodBeat.i(164281);
      PhotoView.d(PhotoView.this).reset();
      PhotoView.d(PhotoView.this).postTranslate(-PhotoView.B(PhotoView.this).left, -PhotoView.B(PhotoView.this).top);
      PhotoView.d(PhotoView.this).postTranslate(PhotoView.x(PhotoView.this).x, PhotoView.x(PhotoView.this).y);
      PhotoView.d(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this), -PhotoView.D(PhotoView.this));
      PhotoView.d(PhotoView.this).postRotate(PhotoView.c(PhotoView.this), PhotoView.x(PhotoView.this).x, PhotoView.x(PhotoView.this).y);
      PhotoView.d(PhotoView.this).postScale(PhotoView.f(PhotoView.this), PhotoView.f(PhotoView.this), PhotoView.w(PhotoView.this).x, PhotoView.w(PhotoView.this).y);
      PhotoView.d(PhotoView.this).postTranslate(PhotoView.r(PhotoView.this), PhotoView.v(PhotoView.this));
      PhotoView.g(PhotoView.this);
      AppMethodBeat.o(164281);
    }
    
    private void ihp()
    {
      AppMethodBeat.i(164282);
      if (this.isRunning) {
        PhotoView.this.post(this);
      }
      AppMethodBeat.o(164282);
    }
    
    final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, PhotoView.a parama)
    {
      AppMethodBeat.i(164276);
      this.YMM.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.YMO = parama;
      AppMethodBeat.o(164276);
    }
    
    final void aL(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.YML.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void nr(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.YMP = 0;
      this.YMQ = 0;
      this.YMK.startScroll(0, 0, paramInt1, paramInt2, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void ns(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.YMN.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.YML.computeScrollOffset()) {
        PhotoView.c(PhotoView.this, this.YML.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.YMK.computeScrollOffset())
        {
          i = this.YMK.getCurrX();
          m = this.YMP;
          n = this.YMK.getCurrY();
          i1 = this.YMQ;
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          this.YMP = this.YMK.getCurrX();
          this.YMQ = this.YMK.getCurrY();
          i = 0;
        }
        if (this.Cfn.computeScrollOffset())
        {
          i = this.Cfn.getCurrX();
          m = this.amg;
          n = this.Cfn.getCurrY();
          i1 = this.amh;
          this.amg = this.Cfn.getCurrX();
          this.amh = this.Cfn.getCurrY();
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          i = 0;
        }
        if (this.YMN.computeScrollOffset())
        {
          PhotoView.b(PhotoView.this, this.YMN.getCurrX());
          i = 0;
        }
        if ((this.YMM.computeScrollOffset()) || (PhotoView.H(PhotoView.this) != null))
        {
          float f1 = this.YMM.getCurrX() / 10000.0F;
          float f2 = this.YMM.getCurrY() / 10000.0F;
          PhotoView.A(PhotoView.this).setScale(f1, f2, (PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).right) / 2.0F, this.YMO.ihn());
          PhotoView.A(PhotoView.this).mapRect(this.YMR, PhotoView.p(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.YMR.left = PhotoView.q(PhotoView.this).left;
            this.YMR.right = PhotoView.q(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.YMR.top = PhotoView.q(PhotoView.this).top;
            this.YMR.bottom = PhotoView.q(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.YMR);
        }
        if (i == 0)
        {
          iho();
          ihp();
          AppMethodBeat.o(164280);
          return;
        }
        this.isRunning = false;
        i = k;
        if (PhotoView.m(PhotoView.this))
        {
          if (PhotoView.p(PhotoView.this).left > 0.0F)
          {
            PhotoView.a(PhotoView.this, (int)(PhotoView.r(PhotoView.this) - PhotoView.p(PhotoView.this).left));
            i = 1;
          }
        }
        else
        {
          if (!PhotoView.n(PhotoView.this)) {
            break label800;
          }
          if (PhotoView.p(PhotoView.this).top <= 0.0F) {
            break label729;
          }
          PhotoView.b(PhotoView.this, (int)(PhotoView.v(PhotoView.this) - PhotoView.p(PhotoView.this).top));
          i = j;
        }
        label800:
        for (;;)
        {
          if (i != 0) {
            iho();
          }
          PhotoView.this.invalidate();
          if (PhotoView.I(PhotoView.this) != null) {
            PhotoView.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(164272);
                PhotoView.I(PhotoView.this).run();
                PhotoView.J(PhotoView.this);
                PhotoView.this.invalidate();
                AppMethodBeat.o(164272);
              }
            });
          }
          AppMethodBeat.o(164280);
          return;
          if (PhotoView.p(PhotoView.this).right >= PhotoView.q(PhotoView.this).width()) {
            break;
          }
          PhotoView.a(PhotoView.this, PhotoView.r(PhotoView.this) - (int)(PhotoView.q(PhotoView.this).width() - PhotoView.p(PhotoView.this).right));
          break;
          label729:
          i = j;
          if (PhotoView.p(PhotoView.this).bottom < PhotoView.q(PhotoView.this).height())
          {
            PhotoView.b(PhotoView.this, PhotoView.v(PhotoView.this) - (int)(PhotoView.q(PhotoView.this).height() - PhotoView.p(PhotoView.this).bottom));
            i = j;
          }
        }
      }
    }
    
    final void start()
    {
      AppMethodBeat.i(164278);
      this.isRunning = true;
      ihp();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.YMK.abortAnimation();
      this.YML.abortAnimation();
      this.Cfn.abortAnimation();
      this.YMN.abortAnimation();
      this.isRunning = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */