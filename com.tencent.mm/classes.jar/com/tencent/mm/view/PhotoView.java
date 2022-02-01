package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatImageView;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

public class PhotoView
  extends AppCompatImageView
{
  private Matrix Jpf;
  private boolean KSG;
  private boolean LpA;
  private boolean LpB;
  private float LpC;
  private float LpD;
  private int LpE;
  private int LpF;
  private float LpG;
  private float LpH;
  private RectF LpI;
  private RectF LpJ;
  private RectF LpK;
  private PointF LpL;
  private PointF LpM;
  private PointF LpN;
  private h LpO;
  private RectF LpP;
  private Info LpQ;
  private long LpR;
  private Runnable LpS;
  private View.OnLongClickListener LpT;
  private i LpU;
  private e LpV;
  private ScaleGestureDetector.OnScaleGestureListener LpW;
  private Runnable LpX;
  private GestureDetector.OnGestureListener LpY;
  private Rect LpZ;
  private int Lph;
  private int Lpi;
  private float Lpj;
  private int Lpk;
  private int Lpl;
  private int Lpm;
  private int Lpn;
  private Matrix Lpo;
  private Matrix Lpp;
  private f Lpq;
  private ScaleGestureDetector Lpr;
  private ImageView.ScaleType Lps;
  private boolean Lpt;
  private boolean Lpu;
  private boolean Lpv;
  private boolean Lpw;
  private boolean Lpx;
  private boolean Lpy;
  private boolean Lpz;
  private GestureDetector PC;
  private boolean cAX;
  private boolean cMW;
  private RectF cPP;
  private float cQd;
  private View.OnClickListener gMe;
  private RectF tQL;
  private Matrix xm;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.Lpk = 0;
    this.Lpl = 0;
    this.Lpm = 0;
    this.Lpn = 500;
    this.Jpf = new Matrix();
    this.Lpo = new Matrix();
    this.Lpp = new Matrix();
    this.xm = new Matrix();
    this.cMW = false;
    this.Lpx = false;
    this.cQd = 1.0F;
    this.tQL = new RectF();
    this.LpI = new RectF();
    this.LpJ = new RectF();
    this.cPP = new RectF();
    this.LpK = new RectF();
    this.LpL = new PointF();
    this.LpM = new PointF();
    this.LpN = new PointF();
    this.LpO = new h();
    this.LpV = new e()
    {
      public final void s(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
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
    this.LpW = new PhotoView.2(this);
    this.LpX = new Runnable()
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
    this.LpY = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186563);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186563);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
          PhotoView.o(PhotoView.this).as(f2, f1);
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
                PhotoView.o(PhotoView.this).kw((int)PhotoView.c(PhotoView.this), (int)f1);
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
              localh.auq = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.p(localh.Lqa).left);
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
              localh.aur = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.p(localh.Lqa).top);
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
              localOverScroller = localh.tQJ;
              i2 = localh.auq;
              i3 = localh.aur;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.Lqa) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.Lqa) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.Lqa))
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
              f1 = PhotoView.p(localh.Lqa).right - PhotoView.q(localh.Lqa).right;
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
              f1 = PhotoView.p(localh.Lqa).bottom - PhotoView.q(localh.Lqa).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.Lqa);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
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
        if (PhotoView.this.cg(paramAnonymousFloat1))
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
          if (PhotoView.this.ch(paramAnonymousFloat2)) {
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
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.LpZ = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.Lpk = 0;
    this.Lpl = 0;
    this.Lpm = 0;
    this.Lpn = 500;
    this.Jpf = new Matrix();
    this.Lpo = new Matrix();
    this.Lpp = new Matrix();
    this.xm = new Matrix();
    this.cMW = false;
    this.Lpx = false;
    this.cQd = 1.0F;
    this.tQL = new RectF();
    this.LpI = new RectF();
    this.LpJ = new RectF();
    this.cPP = new RectF();
    this.LpK = new RectF();
    this.LpL = new PointF();
    this.LpM = new PointF();
    this.LpN = new PointF();
    this.LpO = new h();
    this.LpV = new e()
    {
      public final void s(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
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
    this.LpW = new PhotoView.2(this);
    this.LpX = new Runnable()
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
    this.LpY = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186563);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186563);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
          PhotoView.o(PhotoView.this).as(f2, f1);
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
                PhotoView.o(PhotoView.this).kw((int)PhotoView.c(PhotoView.this), (int)f1);
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
              localh.auq = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.p(localh.Lqa).left);
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
              localh.aur = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.p(localh.Lqa).top);
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
              localOverScroller = localh.tQJ;
              i2 = localh.auq;
              i3 = localh.aur;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.Lqa) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.Lqa) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.Lqa))
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
              f1 = PhotoView.p(localh.Lqa).right - PhotoView.q(localh.Lqa).right;
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
              f1 = PhotoView.p(localh.Lqa).bottom - PhotoView.q(localh.Lqa).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.Lqa);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
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
        if (PhotoView.this.cg(paramAnonymousFloat1))
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
          if (PhotoView.this.ch(paramAnonymousFloat2)) {
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
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.LpZ = new Rect();
    init();
    AppMethodBeat.o(164284);
  }
  
  private static int H(Drawable paramDrawable)
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
  
  private static int I(Drawable paramDrawable)
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
  
  private void a(Info paramInfo)
  {
    AppMethodBeat.i(164318);
    if (this.cAX)
    {
      reset();
      this.LpZ.set(paramInfo.LpZ);
      Info localInfo = getInfo();
      float f1 = paramInfo.LpJ.width() / localInfo.LpJ.width();
      float f2 = paramInfo.LpJ.height() / localInfo.LpJ.height();
      if (f1 < f2)
      {
        f2 = paramInfo.mGJ.left + paramInfo.mGJ.width() / 2.0F;
        float f3 = paramInfo.mGJ.top + paramInfo.mGJ.height() / 2.0F;
        float f4 = localInfo.mGJ.left + localInfo.mGJ.width() / 2.0F;
        float f5 = localInfo.mGJ.top;
        f5 = localInfo.mGJ.height() / 2.0F + f5;
        this.Lpo.reset();
        this.Lpo.postTranslate(f2 - f4, f3 - f5);
        this.Lpo.postScale(f1, f1, f2, f3);
        this.Lpo.postRotate(paramInfo.LpD, f2, f3);
        fPW();
        this.LpM.set(f2, f3);
        this.LpN.set(f2, f3);
        this.LpO.kv((int)-(f2 - f4), (int)-(f3 - f5));
        this.LpO.as(f1, 1.0F);
        this.LpO.kw((int)paramInfo.LpD, 0);
        if ((paramInfo.tQL.width() < paramInfo.LpJ.width()) || (paramInfo.tQL.height() < paramInfo.LpJ.height()))
        {
          f2 = paramInfo.tQL.width() / paramInfo.LpJ.width();
          f3 = paramInfo.tQL.height() / paramInfo.LpJ.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.Lps != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.LpO.a(f1, f2, 1.0F - f1, 1.0F - f2, this.Lpi / 3, paramInfo);
        this.xm.setScale(f1, f2, (this.LpJ.left + this.LpJ.right) / 2.0F, paramInfo.fPX());
        this.xm.mapRect(this.LpO.Lqm, this.LpJ);
        this.LpP = this.LpO.Lqm;
        this.LpO.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.Lps == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.LpQ = paramInfo;
    this.LpR = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(164302);
    this.Lpp = parami.Lqq;
    this.Lpo = parami.Lqp;
    this.Jpf = parami.Lqr;
    this.xm = parami.rJ;
    this.LpG = (parami.Lqs.width() / 2.0F);
    this.LpH = (parami.Lqs.height() / 2.0F);
    if (!this.tQL.isEmpty())
    {
      parami.xIz.set(this.tQL);
      parami.Lqw = this.LpL;
    }
    this.tQL = parami.xIz;
    this.LpI = parami.Lqs;
    this.LpJ = parami.Lqt;
    this.cPP = parami.Lqu;
    this.LpK = parami.Lqv;
    this.LpL = parami.Lqw;
    this.LpM = parami.Lqx;
    this.LpN = parami.Lqy;
    AppMethodBeat.o(164302);
  }
  
  private void fPN()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.Lpu)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.Lpv)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.LpP != null) {
      this.LpP.setEmpty();
    }
    this.Jpf.reset();
    this.Lpo.reset();
    this.Lpp.reset();
    this.xm.reset();
    this.Lpy = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = H(localDrawable);
    int m = I(localDrawable);
    this.LpI.set(0.0F, 0.0F, k, m);
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
        this.Jpf.reset();
        this.Jpf.postTranslate(n, i1);
        this.Jpf.postScale(f1, f1, this.LpL.x, this.LpL.y);
        this.Jpf.mapRect(this.LpI);
        this.LpG = (this.LpI.width() / 2.0F);
        this.LpH = (this.LpI.height() / 2.0F);
        this.LpM.set(this.LpL);
        this.LpN.set(this.LpM);
        fPW();
        switch (PhotoView.5.Ap[this.Lps.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.cAX = true;
        if ((this.LpQ != null) && (System.currentTimeMillis() - this.LpR < this.Lpn)) {
          a(this.LpQ);
        }
        this.LpQ = null;
        if (this.LpU != null)
        {
          a(this.LpU);
          setImageMatrix(this.Lpp);
          this.LpU = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        fPO();
        continue;
        fPP();
        continue;
        fPQ();
        continue;
        fPR();
        continue;
        fPS();
        continue;
        fPT();
        continue;
        fPU();
      }
    }
  }
  
  private void fPO()
  {
    AppMethodBeat.i(164293);
    if (!this.Lpu)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.Lpv)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = H(localDrawable);
    int j = I(localDrawable);
    float f1;
    float f2;
    if ((i > this.tQL.width()) || (j > this.tQL.height()))
    {
      f1 = i / this.LpJ.width();
      f2 = j / this.LpJ.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.cQd = f1;
      this.Lpo.postScale(this.cQd, this.cQd, this.LpL.x, this.LpL.y);
      fPW();
      fPV();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void fPP()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.LpJ.width() < this.tQL.width()) || (this.LpJ.height() < this.tQL.height()))
    {
      f1 = this.tQL.width() / this.LpJ.width();
      f2 = this.tQL.height() / this.LpJ.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cQd = f1;
      this.Lpo.postScale(this.cQd, this.cQd, this.LpL.x, this.LpL.y);
      fPW();
      fPV();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fPQ()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.LpJ.width() > this.tQL.width()) || (this.LpJ.height() > this.tQL.height()))
    {
      f1 = this.tQL.width() / this.LpJ.width();
      f2 = this.tQL.height() / this.LpJ.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cQd = f1;
      this.Lpo.postScale(this.cQd, this.cQd, this.LpL.x, this.LpL.y);
      fPW();
      fPV();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fPR()
  {
    AppMethodBeat.i(164296);
    if (this.LpJ.width() < this.tQL.width())
    {
      this.cQd = (this.tQL.width() / this.LpJ.width());
      this.Lpo.postScale(this.cQd, this.cQd, this.LpL.x, this.LpL.y);
      fPW();
      fPV();
    }
    AppMethodBeat.o(164296);
  }
  
  private void fPS()
  {
    AppMethodBeat.i(164297);
    fPR();
    float f = -this.LpJ.top;
    this.Lpo.postTranslate(0.0F, f);
    fPW();
    fPV();
    this.LpF = ((int)(f + this.LpF));
    AppMethodBeat.o(164297);
  }
  
  private void fPT()
  {
    AppMethodBeat.i(164298);
    fPR();
    float f = this.tQL.bottom - this.LpJ.bottom;
    this.LpF = ((int)(this.LpF + f));
    this.Lpo.postTranslate(0.0F, f);
    fPW();
    fPV();
    AppMethodBeat.o(164298);
  }
  
  private void fPU()
  {
    AppMethodBeat.i(164299);
    float f1 = this.tQL.width() / this.LpJ.width();
    float f2 = this.tQL.height() / this.LpJ.height();
    this.Lpo.postScale(f1, f2, this.LpL.x, this.LpL.y);
    fPW();
    fPV();
    AppMethodBeat.o(164299);
  }
  
  private void fPV()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = H(localDrawable);
    int j = I(localDrawable);
    this.LpI.set(0.0F, 0.0F, i, j);
    this.Jpf.set(this.Lpp);
    this.Jpf.mapRect(this.LpI);
    this.LpG = (this.LpI.width() / 2.0F);
    this.LpH = (this.LpI.height() / 2.0F);
    this.cQd = 1.0F;
    this.LpE = 0;
    this.LpF = 0;
    this.Lpo.reset();
    AppMethodBeat.o(164300);
  }
  
  private void fPW()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.Lpp.set(this.Jpf);
    this.Lpp.postConcat(this.Lpo);
    setImageMatrix(this.Lpp);
    this.Lpo.mapRect(this.LpJ, this.LpI);
    if (this.LpJ.width() > this.tQL.width())
    {
      bool1 = true;
      this.LpA = bool1;
      if (this.LpJ.height() <= this.tQL.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.LpB = bool1;
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
    if (this.Lps == null) {
      this.Lps = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.Lpq = new f(this.LpV);
    this.PC = new GestureDetector(getContext(), this.LpY);
    this.Lpr = new ScaleGestureDetector(getContext(), this.LpW);
    float f = getResources().getDisplayMetrics().density;
    this.Lpk = ((int)(f * 30.0F));
    this.Lpl = ((int)(f * 30.0F));
    this.Lpm = ((int)(f * 140.0F));
    this.Lph = 35;
    this.Lpi = 200;
    this.Lpj = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void n(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.tQL.width())
    {
      if (p(paramRectF)) {
        break label275;
      }
      i = -(int)((this.tQL.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.tQL.height()) {
        if (!o(paramRectF)) {
          j = -(int)((this.tQL.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.LpO.tQJ.isFinished()) {
            this.LpO.tQJ.abortAnimation();
          }
          this.LpO.kv(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.tQL.left)
        {
          i = (int)(paramRectF.left - this.tQL.left);
          break;
        }
        if (paramRectF.right >= this.tQL.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.tQL.right);
        break;
        if (paramRectF.top > this.tQL.top) {
          j = (int)(paramRectF.top - this.tQL.top);
        } else if (paramRectF.bottom < this.tQL.bottom) {
          j = (int)(paramRectF.bottom - this.tQL.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean o(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.tQL.height() - paramRectF.height()) / 2.0F) < 1.0F)
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
    if (Math.abs(Math.round(paramRectF.left) - (this.tQL.width() - paramRectF.width()) / 2.0F) < 1.0F)
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
    this.Lpo.reset();
    fPW();
    this.cQd = 1.0F;
    this.LpE = 0;
    this.LpF = 0;
    AppMethodBeat.o(164317);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(164313);
    if (this.Lpt)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = cg(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.Lpt)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = ch(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public final boolean cg(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.LpJ.width() <= this.tQL.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.LpJ.left) - paramFloat >= this.tQL.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.LpJ.right) - paramFloat <= this.tQL.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean ch(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.LpJ.height() <= this.tQL.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.LpJ.top) - paramFloat >= this.tQL.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.LpJ.bottom) - paramFloat <= this.tQL.bottom))
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
    if (this.LpP != null) {
      paramCanvas.clipRect(this.LpP);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public int getAnimaDuring()
  {
    return this.Lpi;
  }
  
  public long getDefaultAnimDuring()
  {
    return 200L;
  }
  
  public Info getInfo()
  {
    AppMethodBeat.i(164315);
    Object localObject = new Rect();
    int[] arrayOfInt = new int[2];
    Rect localRect1 = this.LpZ;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.LpJ.left, arrayOfInt[1] + (int)this.LpJ.top, arrayOfInt[0] + (int)this.LpJ.right, arrayOfInt[1] + (int)this.LpJ.bottom);
    localObject = new Info((Rect)localObject, this.LpJ, this.tQL, this.LpI, this.LpL, this.cQd, this.LpD, this.Lps, this.LpZ);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.Lpj;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.Lpu)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(164303);
      return;
    }
    Object localObject = getDrawable();
    int j = H((Drawable)localObject);
    int i = I((Drawable)localObject);
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
      if (this.KSG)
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
    ad.i("PhotoView", "[onSizeChanged] w:%s, h:%s, oldw:%s, oldh:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.tQL.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.LpL.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.Lpv)
    {
      this.Lpv = true;
      fPN();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.cMW)
    {
      this.LpP = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.Lpt = true;
      }
      Object localObject = this.PC;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.Lpx) {
        localObject = this.Lpq;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.Lpr.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.LpO.isRunning))
        {
          if ((this.Lpz) || (this.LpD % 90.0F != 0.0F))
          {
            f2 = (int)(this.LpD / 90.0F) * 90;
            f3 = this.LpD % 90.0F;
            if (f3 <= 45.0F) {
              break label639;
            }
            f1 = f2 + 90.0F;
            label265:
            this.LpO.kw((int)this.LpD, (int)f1);
            this.LpD = f1;
          }
          f1 = this.cQd;
          if (this.cQd >= 1.0F) {
            break label663;
          }
          f1 = 1.0F;
          this.LpO.as(this.cQd, 1.0F);
        }
        break;
      }
      for (;;)
      {
        f2 = this.LpJ.left + this.LpJ.width() / 2.0F;
        f3 = this.LpJ.top + this.LpJ.height() / 2.0F;
        this.LpM.set(f2, f3);
        this.LpN.set(f2, f3);
        this.LpE = 0;
        this.LpF = 0;
        this.xm.reset();
        this.xm.postTranslate(-this.LpI.left, -this.LpI.top);
        this.xm.postTranslate(f2 - this.LpG, f3 - this.LpH);
        this.xm.postScale(f1, f1, f2, f3);
        this.xm.postRotate(this.LpD, f2, f3);
        this.xm.mapRect(this.cPP, this.LpI);
        n(this.cPP);
        this.LpO.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        ((f)localObject).Lqd = ((f)localObject).an(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        ((f)localObject).Lqe = ((f)localObject).an(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(((f)localObject).Lqe)) - Math.toDegrees(Math.atan(((f)localObject).Lqd));
        if (Math.abs(d) <= 120.0D) {
          ((f)localObject).Lqc.s((float)d, (((f)localObject).x2 + ((f)localObject).x1) / 2.0F, (((f)localObject).y2 + ((f)localObject).y1) / 2.0F);
        }
        ((f)localObject).Lqd = ((f)localObject).Lqe;
        break;
        label639:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label265;
        }
        f1 = f2 - 90.0F;
        break label265;
        label663:
        if (this.cQd > this.Lpj)
        {
          f1 = this.Lpj;
          this.LpO.as(this.cQd, this.Lpj);
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
    this.KSG = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.Lpi = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.LpZ);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.Lpu = false;
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
    if (!this.Lpu) {
      this.Lpu = true;
    }
    fPN();
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
    this.LpO.Lqn.Lqb = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.Lpn = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.Lpj = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.gMe = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.LpT = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.Lps)
    {
      this.Lps = paramScaleType;
      if (this.cAX) {
        fPN();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    float LpD;
    RectF LpI;
    RectF LpJ;
    PointF LpL;
    Rect LpZ;
    ImageView.ScaleType Lps;
    float cQd;
    public RectF mGJ;
    RectF tQL;
    
    static
    {
      AppMethodBeat.i(164266);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(164266);
    }
    
    public Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
    {
      AppMethodBeat.i(164262);
      this.mGJ = new RectF();
      this.LpJ = new RectF();
      this.tQL = new RectF();
      this.LpI = new RectF();
      this.LpL = new PointF();
      this.LpZ = new Rect();
      this.mGJ.set(paramRect1);
      this.LpJ.set(paramRectF1);
      this.tQL.set(paramRectF2);
      this.cQd = paramFloat1;
      this.Lps = paramScaleType;
      this.LpD = paramFloat2;
      this.LpI.set(paramRectF3);
      this.LpL.set(paramPointF);
      this.LpZ.set(paramRect2);
      AppMethodBeat.o(164262);
    }
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(164265);
      this.mGJ = new RectF();
      this.LpJ = new RectF();
      this.tQL = new RectF();
      this.LpI = new RectF();
      this.LpL = new PointF();
      this.LpZ = new Rect();
      this.mGJ = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.LpJ = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.tQL = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.LpI = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.LpL = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
      this.LpZ = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      this.cQd = paramParcel.readFloat();
      this.LpD = paramParcel.readFloat();
      int i = paramParcel.readInt();
      if (i == -1) {}
      for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
      {
        this.Lps = paramParcel;
        AppMethodBeat.o(164265);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(164263);
      String str = "Info{mRect=" + this.mGJ + ", mImgRect=" + this.LpJ + ", mWidgetRect=" + this.tQL + ", mBaseRect=" + this.LpI + ", mScale=" + this.cQd + '}';
      AppMethodBeat.o(164263);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(164264);
      paramParcel.writeParcelable(this.mGJ, paramInt);
      paramParcel.writeParcelable(this.LpJ, paramInt);
      paramParcel.writeParcelable(this.tQL, paramInt);
      paramParcel.writeParcelable(this.LpI, paramInt);
      paramParcel.writeParcelable(this.LpL, paramInt);
      paramParcel.writeParcelable(this.LpZ, paramInt);
      paramParcel.writeFloat(this.cQd);
      paramParcel.writeFloat(this.LpD);
      if (this.Lps == null) {}
      for (paramInt = -1;; paramInt = this.Lps.ordinal())
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(164264);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract float fPX();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float fPX()
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
    Interpolator Lqb;
    
    private c()
    {
      AppMethodBeat.i(164267);
      this.Lqb = new DecelerateInterpolator();
      AppMethodBeat.o(164267);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      AppMethodBeat.i(164268);
      if (this.Lqb != null)
      {
        paramFloat = this.Lqb.getInterpolation(paramFloat);
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
    
    public final float fPX()
    {
      AppMethodBeat.i(164269);
      float f = (PhotoView.p(PhotoView.this).top + PhotoView.p(PhotoView.this).bottom) / 2.0F;
      AppMethodBeat.o(164269);
      return f;
    }
  }
  
  static abstract interface e
  {
    public abstract void s(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public final class f
  {
    PhotoView.e Lqc;
    float Lqd;
    float Lqe;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.Lqc = parame;
    }
    
    final float an(MotionEvent paramMotionEvent)
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
    
    public final float fPX()
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
    OverScroller Lqf;
    Scroller Lqg;
    Scroller Lqh;
    Scroller Lqi;
    PhotoView.a Lqj;
    int Lqk;
    int Lql;
    RectF Lqm;
    PhotoView.c Lqn;
    int auq;
    int aur;
    boolean isRunning;
    OverScroller tQJ;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.Lqm = new RectF();
      this.Lqn = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.Lqf = new OverScroller(PhotoView.this, this.Lqn);
      this.Lqg = new Scroller(PhotoView.this, this.Lqn);
      this.tQJ = new OverScroller(PhotoView.this, this.Lqn);
      this.Lqh = new Scroller(PhotoView.this, this.Lqn);
      this.Lqi = new Scroller(PhotoView.this, this.Lqn);
      AppMethodBeat.o(164273);
    }
    
    private void fPY()
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
    
    private void fPZ()
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
      this.Lqh.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.Lqj = parama;
      AppMethodBeat.o(164276);
    }
    
    final void as(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.Lqg.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void kv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.Lqk = 0;
      this.Lql = 0;
      this.Lqf.startScroll(0, 0, paramInt1, paramInt2, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void kw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.Lqi.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.Lqg.computeScrollOffset()) {
        PhotoView.c(PhotoView.this, this.Lqg.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.Lqf.computeScrollOffset())
        {
          i = this.Lqf.getCurrX();
          m = this.Lqk;
          n = this.Lqf.getCurrY();
          i1 = this.Lql;
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          this.Lqk = this.Lqf.getCurrX();
          this.Lql = this.Lqf.getCurrY();
          i = 0;
        }
        if (this.tQJ.computeScrollOffset())
        {
          i = this.tQJ.getCurrX();
          m = this.auq;
          n = this.tQJ.getCurrY();
          i1 = this.aur;
          this.auq = this.tQJ.getCurrX();
          this.aur = this.tQJ.getCurrY();
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          i = 0;
        }
        if (this.Lqi.computeScrollOffset())
        {
          PhotoView.b(PhotoView.this, this.Lqi.getCurrX());
          i = 0;
        }
        if ((this.Lqh.computeScrollOffset()) || (PhotoView.H(PhotoView.this) != null))
        {
          float f1 = this.Lqh.getCurrX() / 10000.0F;
          float f2 = this.Lqh.getCurrY() / 10000.0F;
          PhotoView.A(PhotoView.this).setScale(f1, f2, (PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).right) / 2.0F, this.Lqj.fPX());
          PhotoView.A(PhotoView.this).mapRect(this.Lqm, PhotoView.p(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.Lqm.left = PhotoView.q(PhotoView.this).left;
            this.Lqm.right = PhotoView.q(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.Lqm.top = PhotoView.q(PhotoView.this).top;
            this.Lqm.bottom = PhotoView.q(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.Lqm);
        }
        if (i == 0)
        {
          fPY();
          fPZ();
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
            fPY();
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
      fPZ();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.Lqf.abortAnimation();
      this.Lqg.abortAnimation();
      this.tQJ.abortAnimation();
      this.Lqi.abortAnimation();
      this.isRunning = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i
  {
    Matrix Lqp;
    public Matrix Lqq;
    Matrix Lqr;
    RectF Lqs;
    public RectF Lqt;
    RectF Lqu;
    RectF Lqv;
    PointF Lqw;
    PointF Lqx;
    PointF Lqy;
    Matrix rJ;
    public RectF xIz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */