package com.tencent.mm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
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
import android.view.animation.Interpolator;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public class PhotoView
  extends AppCompatImageView
{
  private Matrix JJU;
  private int LLS;
  private int LLT;
  private float LLU;
  private int LLV;
  private int LLW;
  private int LLX;
  private int LLY;
  private Matrix LLZ;
  private RectF LMA;
  private PhotoView.Info LMB;
  private long LMC;
  private Runnable LMD;
  private View.OnLongClickListener LME;
  private i LMF;
  private e LMG;
  private ScaleGestureDetector.OnScaleGestureListener LMH;
  private Runnable LMI;
  private GestureDetector.OnGestureListener LMJ;
  private Rect LMK;
  private Matrix LMa;
  private f LMb;
  private ScaleGestureDetector LMc;
  private ImageView.ScaleType LMd;
  private boolean LMe;
  private boolean LMf;
  private boolean LMg;
  private boolean LMh;
  private boolean LMi;
  private boolean LMj;
  private boolean LMk;
  private boolean LMl;
  private boolean LMm;
  private float LMn;
  private float LMo;
  private int LMp;
  private int LMq;
  private float LMr;
  private float LMs;
  private RectF LMt;
  private RectF LMu;
  private RectF LMv;
  private PointF LMw;
  private PointF LMx;
  private PointF LMy;
  private h LMz;
  private boolean Lpe;
  private GestureDetector PC;
  private boolean cBE;
  private boolean cNF;
  private float cQN;
  private RectF cQz;
  private View.OnClickListener gON;
  private RectF ubC;
  private Matrix xm;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.LLV = 0;
    this.LLW = 0;
    this.LLX = 0;
    this.LLY = 500;
    this.JJU = new Matrix();
    this.LLZ = new Matrix();
    this.LMa = new Matrix();
    this.xm = new Matrix();
    this.cNF = false;
    this.LMi = false;
    this.cQN = 1.0F;
    this.ubC = new RectF();
    this.LMt = new RectF();
    this.LMu = new RectF();
    this.cQz = new RectF();
    this.LMv = new RectF();
    this.LMw = new PointF();
    this.LMx = new PointF();
    this.LMy = new PointF();
    this.LMz = new h();
    this.LMG = new e()
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
    this.LMH = new PhotoView.2(this);
    this.LMI = new Runnable()
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
    this.LMJ = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193821);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193821);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
                PhotoView.o(PhotoView.this).kD((int)PhotoView.c(PhotoView.this), (int)f1);
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
              f1 = Math.abs(PhotoView.p(localh.LML).left);
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
              f1 = Math.abs(PhotoView.p(localh.LML).top);
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
              localOverScroller = localh.ubA;
              i2 = localh.auq;
              i3 = localh.aur;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.LML) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.LML) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.LML))
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
              f1 = PhotoView.p(localh.LML).right - PhotoView.q(localh.LML).right;
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
              f1 = PhotoView.p(localh.LML).bottom - PhotoView.q(localh.LML).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.LML);
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
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
        if (PhotoView.this.ce(paramAnonymousFloat1))
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
          if (PhotoView.this.cf(paramAnonymousFloat2)) {
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.LMK = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.LLV = 0;
    this.LLW = 0;
    this.LLX = 0;
    this.LLY = 500;
    this.JJU = new Matrix();
    this.LLZ = new Matrix();
    this.LMa = new Matrix();
    this.xm = new Matrix();
    this.cNF = false;
    this.LMi = false;
    this.cQN = 1.0F;
    this.ubC = new RectF();
    this.LMt = new RectF();
    this.LMu = new RectF();
    this.cQz = new RectF();
    this.LMv = new RectF();
    this.LMw = new PointF();
    this.LMx = new PointF();
    this.LMy = new PointF();
    this.LMz = new h();
    this.LMG = new e()
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
    this.LMH = new PhotoView.2(this);
    this.LMI = new Runnable()
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
    this.LMJ = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193821);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193821);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
                PhotoView.o(PhotoView.this).kD((int)PhotoView.c(PhotoView.this), (int)f1);
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
              f1 = Math.abs(PhotoView.p(localh.LML).left);
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
              f1 = Math.abs(PhotoView.p(localh.LML).top);
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
              localOverScroller = localh.ubA;
              i2 = localh.auq;
              i3 = localh.aur;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.LML) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.LML) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.LML))
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
              f1 = PhotoView.p(localh.LML).right - PhotoView.q(localh.LML).right;
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
              f1 = PhotoView.p(localh.LML).bottom - PhotoView.q(localh.LML).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.LML);
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
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
        if (PhotoView.this.ce(paramAnonymousFloat1))
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
          if (PhotoView.this.cf(paramAnonymousFloat2)) {
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.LMK = new Rect();
    init();
    AppMethodBeat.o(164284);
  }
  
  private static int I(Drawable paramDrawable)
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
  
  private static int J(Drawable paramDrawable)
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
    if (this.cBE)
    {
      reset();
      this.LMK.set(paramInfo.LMK);
      PhotoView.Info localInfo = getInfo();
      float f1 = paramInfo.LMu.width() / localInfo.LMu.width();
      float f2 = paramInfo.LMu.height() / localInfo.LMu.height();
      if (f1 < f2)
      {
        f2 = paramInfo.mLN.left + paramInfo.mLN.width() / 2.0F;
        float f3 = paramInfo.mLN.top + paramInfo.mLN.height() / 2.0F;
        float f4 = localInfo.mLN.left + localInfo.mLN.width() / 2.0F;
        float f5 = localInfo.mLN.top;
        f5 = localInfo.mLN.height() / 2.0F + f5;
        this.LLZ.reset();
        this.LLZ.postTranslate(f2 - f4, f3 - f5);
        this.LLZ.postScale(f1, f1, f2, f3);
        this.LLZ.postRotate(paramInfo.LMo, f2, f3);
        fUs();
        this.LMx.set(f2, f3);
        this.LMy.set(f2, f3);
        this.LMz.kC((int)-(f2 - f4), (int)-(f3 - f5));
        this.LMz.as(f1, 1.0F);
        this.LMz.kD((int)paramInfo.LMo, 0);
        if ((paramInfo.ubC.width() < paramInfo.LMu.width()) || (paramInfo.ubC.height() < paramInfo.LMu.height()))
        {
          f2 = paramInfo.ubC.width() / paramInfo.LMu.width();
          f3 = paramInfo.ubC.height() / paramInfo.LMu.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.LMd != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.LMz.a(f1, f2, 1.0F - f1, 1.0F - f2, this.LLT / 3, paramInfo);
        this.xm.setScale(f1, f2, (this.LMu.left + this.LMu.right) / 2.0F, paramInfo.fUt());
        this.xm.mapRect(this.LMz.LMX, this.LMu);
        this.LMA = this.LMz.LMX;
        this.LMz.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.LMd == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.LMB = paramInfo;
    this.LMC = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(164302);
    this.LMa = parami.LNb;
    this.LLZ = parami.LNa;
    this.JJU = parami.LNc;
    this.xm = parami.rJ;
    this.LMr = (parami.LNd.width() / 2.0F);
    this.LMs = (parami.LNd.height() / 2.0F);
    if (!this.ubC.isEmpty())
    {
      parami.xYu.set(this.ubC);
      parami.LNh = this.LMw;
    }
    this.ubC = parami.xYu;
    this.LMt = parami.LNd;
    this.LMu = parami.LNe;
    this.cQz = parami.LNf;
    this.LMv = parami.LNg;
    this.LMw = parami.LNh;
    this.LMx = parami.LNi;
    this.LMy = parami.LNj;
    AppMethodBeat.o(164302);
  }
  
  private void fUj()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.LMf)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.LMg)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.LMA != null) {
      this.LMA.setEmpty();
    }
    this.JJU.reset();
    this.LLZ.reset();
    this.LMa.reset();
    this.xm.reset();
    this.LMj = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = I(localDrawable);
    int m = J(localDrawable);
    this.LMt.set(0.0F, 0.0F, k, m);
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
        this.JJU.reset();
        this.JJU.postTranslate(n, i1);
        this.JJU.postScale(f1, f1, this.LMw.x, this.LMw.y);
        this.JJU.mapRect(this.LMt);
        this.LMr = (this.LMt.width() / 2.0F);
        this.LMs = (this.LMt.height() / 2.0F);
        this.LMx.set(this.LMw);
        this.LMy.set(this.LMx);
        fUs();
        switch (PhotoView.5.Ap[this.LMd.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.cBE = true;
        if ((this.LMB != null) && (System.currentTimeMillis() - this.LMC < this.LLY)) {
          a(this.LMB);
        }
        this.LMB = null;
        if (this.LMF != null)
        {
          a(this.LMF);
          setImageMatrix(this.LMa);
          this.LMF = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        fUk();
        continue;
        fUl();
        continue;
        fUm();
        continue;
        fUn();
        continue;
        fUo();
        continue;
        fUp();
        continue;
        fUq();
      }
    }
  }
  
  private void fUk()
  {
    AppMethodBeat.i(164293);
    if (!this.LMf)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.LMg)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = I(localDrawable);
    int j = J(localDrawable);
    float f1;
    float f2;
    if ((i > this.ubC.width()) || (j > this.ubC.height()))
    {
      f1 = i / this.LMu.width();
      f2 = j / this.LMu.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.cQN = f1;
      this.LLZ.postScale(this.cQN, this.cQN, this.LMw.x, this.LMw.y);
      fUs();
      fUr();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void fUl()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.LMu.width() < this.ubC.width()) || (this.LMu.height() < this.ubC.height()))
    {
      f1 = this.ubC.width() / this.LMu.width();
      f2 = this.ubC.height() / this.LMu.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cQN = f1;
      this.LLZ.postScale(this.cQN, this.cQN, this.LMw.x, this.LMw.y);
      fUs();
      fUr();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fUm()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.LMu.width() > this.ubC.width()) || (this.LMu.height() > this.ubC.height()))
    {
      f1 = this.ubC.width() / this.LMu.width();
      f2 = this.ubC.height() / this.LMu.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cQN = f1;
      this.LLZ.postScale(this.cQN, this.cQN, this.LMw.x, this.LMw.y);
      fUs();
      fUr();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fUn()
  {
    AppMethodBeat.i(164296);
    if (this.LMu.width() < this.ubC.width())
    {
      this.cQN = (this.ubC.width() / this.LMu.width());
      this.LLZ.postScale(this.cQN, this.cQN, this.LMw.x, this.LMw.y);
      fUs();
      fUr();
    }
    AppMethodBeat.o(164296);
  }
  
  private void fUo()
  {
    AppMethodBeat.i(164297);
    fUn();
    float f = -this.LMu.top;
    this.LLZ.postTranslate(0.0F, f);
    fUs();
    fUr();
    this.LMq = ((int)(f + this.LMq));
    AppMethodBeat.o(164297);
  }
  
  private void fUp()
  {
    AppMethodBeat.i(164298);
    fUn();
    float f = this.ubC.bottom - this.LMu.bottom;
    this.LMq = ((int)(this.LMq + f));
    this.LLZ.postTranslate(0.0F, f);
    fUs();
    fUr();
    AppMethodBeat.o(164298);
  }
  
  private void fUq()
  {
    AppMethodBeat.i(164299);
    float f1 = this.ubC.width() / this.LMu.width();
    float f2 = this.ubC.height() / this.LMu.height();
    this.LLZ.postScale(f1, f2, this.LMw.x, this.LMw.y);
    fUs();
    fUr();
    AppMethodBeat.o(164299);
  }
  
  private void fUr()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = I(localDrawable);
    int j = J(localDrawable);
    this.LMt.set(0.0F, 0.0F, i, j);
    this.JJU.set(this.LMa);
    this.JJU.mapRect(this.LMt);
    this.LMr = (this.LMt.width() / 2.0F);
    this.LMs = (this.LMt.height() / 2.0F);
    this.cQN = 1.0F;
    this.LMp = 0;
    this.LMq = 0;
    this.LLZ.reset();
    AppMethodBeat.o(164300);
  }
  
  private void fUs()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.LMa.set(this.JJU);
    this.LMa.postConcat(this.LLZ);
    setImageMatrix(this.LMa);
    this.LLZ.mapRect(this.LMu, this.LMt);
    if (this.LMu.width() > this.ubC.width())
    {
      bool1 = true;
      this.LMl = bool1;
      if (this.LMu.height() <= this.ubC.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.LMm = bool1;
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
    if (this.LMd == null) {
      this.LMd = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.LMb = new f(this.LMG);
    this.PC = new GestureDetector(getContext(), this.LMJ);
    this.LMc = new ScaleGestureDetector(getContext(), this.LMH);
    float f = getResources().getDisplayMetrics().density;
    this.LLV = ((int)(f * 30.0F));
    this.LLW = ((int)(f * 30.0F));
    this.LLX = ((int)(f * 140.0F));
    this.LLS = 35;
    this.LLT = 200;
    this.LLU = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void n(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.ubC.width())
    {
      if (p(paramRectF)) {
        break label275;
      }
      i = -(int)((this.ubC.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.ubC.height()) {
        if (!o(paramRectF)) {
          j = -(int)((this.ubC.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.LMz.ubA.isFinished()) {
            this.LMz.ubA.abortAnimation();
          }
          this.LMz.kC(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.ubC.left)
        {
          i = (int)(paramRectF.left - this.ubC.left);
          break;
        }
        if (paramRectF.right >= this.ubC.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.ubC.right);
        break;
        if (paramRectF.top > this.ubC.top) {
          j = (int)(paramRectF.top - this.ubC.top);
        } else if (paramRectF.bottom < this.ubC.bottom) {
          j = (int)(paramRectF.bottom - this.ubC.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean o(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.ubC.height() - paramRectF.height()) / 2.0F) < 1.0F)
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
    if (Math.abs(Math.round(paramRectF.left) - (this.ubC.width() - paramRectF.width()) / 2.0F) < 1.0F)
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
    this.LLZ.reset();
    fUs();
    this.cQN = 1.0F;
    this.LMp = 0;
    this.LMq = 0;
    AppMethodBeat.o(164317);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(164313);
    if (this.LMe)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = ce(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.LMe)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = cf(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public final boolean ce(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.LMu.width() <= this.ubC.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.LMu.left) - paramFloat >= this.ubC.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.LMu.right) - paramFloat <= this.ubC.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean cf(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.LMu.height() <= this.ubC.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.LMu.top) - paramFloat >= this.ubC.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.LMu.bottom) - paramFloat <= this.ubC.bottom))
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
    if (this.LMA != null) {
      paramCanvas.clipRect(this.LMA);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public int getAnimaDuring()
  {
    return this.LLT;
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
    Rect localRect1 = this.LMK;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.LMu.left, arrayOfInt[1] + (int)this.LMu.top, arrayOfInt[0] + (int)this.LMu.right, arrayOfInt[1] + (int)this.LMu.bottom);
    localObject = new PhotoView.Info((Rect)localObject, this.LMu, this.ubC, this.LMt, this.LMw, this.cQN, this.LMo, this.LMd, this.LMK);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.LLU;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.LMf)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(164303);
      return;
    }
    Object localObject = getDrawable();
    int j = I((Drawable)localObject);
    int i = J((Drawable)localObject);
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
      if (this.Lpe)
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
    ae.i("PhotoView", "[onSizeChanged] w:%s, h:%s, oldw:%s, oldh:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.ubC.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.LMw.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.LMg)
    {
      this.LMg = true;
      fUj();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.cNF)
    {
      this.LMA = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.LMe = true;
      }
      Object localObject = this.PC;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.LMi) {
        localObject = this.LMb;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.LMc.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.LMz.isRunning))
        {
          if ((this.LMk) || (this.LMo % 90.0F != 0.0F))
          {
            f2 = (int)(this.LMo / 90.0F) * 90;
            f3 = this.LMo % 90.0F;
            if (f3 <= 45.0F) {
              break label639;
            }
            f1 = f2 + 90.0F;
            label265:
            this.LMz.kD((int)this.LMo, (int)f1);
            this.LMo = f1;
          }
          f1 = this.cQN;
          if (this.cQN >= 1.0F) {
            break label663;
          }
          f1 = 1.0F;
          this.LMz.as(this.cQN, 1.0F);
        }
        break;
      }
      for (;;)
      {
        f2 = this.LMu.left + this.LMu.width() / 2.0F;
        f3 = this.LMu.top + this.LMu.height() / 2.0F;
        this.LMx.set(f2, f3);
        this.LMy.set(f2, f3);
        this.LMp = 0;
        this.LMq = 0;
        this.xm.reset();
        this.xm.postTranslate(-this.LMt.left, -this.LMt.top);
        this.xm.postTranslate(f2 - this.LMr, f3 - this.LMs);
        this.xm.postScale(f1, f1, f2, f3);
        this.xm.postRotate(this.LMo, f2, f3);
        this.xm.mapRect(this.cQz, this.LMt);
        n(this.cQz);
        this.LMz.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        ((f)localObject).LMO = ((f)localObject).al(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        ((f)localObject).LMP = ((f)localObject).al(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(((f)localObject).LMP)) - Math.toDegrees(Math.atan(((f)localObject).LMO));
        if (Math.abs(d) <= 120.0D) {
          ((f)localObject).LMN.s((float)d, (((f)localObject).x2 + ((f)localObject).x1) / 2.0F, (((f)localObject).y2 + ((f)localObject).y1) / 2.0F);
        }
        ((f)localObject).LMO = ((f)localObject).LMP;
        break;
        label639:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label265;
        }
        f1 = f2 - 90.0F;
        break label265;
        label663:
        if (this.cQN > this.LLU)
        {
          f1 = this.LLU;
          this.LMz.as(this.cQN, this.LLU);
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
    this.Lpe = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.LLT = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.LMK);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.LMf = false;
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
    if (!this.LMf) {
      this.LMf = true;
    }
    fUj();
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
    this.LMz.LMY.LMM = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.LLY = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.LLU = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.gON = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.LME = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.LMd)
    {
      this.LMd = paramScaleType;
      if (this.cBE) {
        fUj();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static abstract interface a
  {
    public abstract float fUt();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float fUt()
    {
      AppMethodBeat.i(164260);
      float f = PhotoView.p(PhotoView.this).bottom;
      AppMethodBeat.o(164260);
      return f;
    }
  }
  
  public final class d
    implements PhotoView.a
  {
    public d() {}
    
    public final float fUt()
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
    PhotoView.e LMN;
    float LMO;
    float LMP;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.LMN = parame;
    }
    
    final float al(MotionEvent paramMotionEvent)
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
    
    public final float fUt()
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
    OverScroller LMQ;
    Scroller LMR;
    Scroller LMS;
    Scroller LMT;
    PhotoView.a LMU;
    int LMV;
    int LMW;
    RectF LMX;
    PhotoView.c LMY;
    int auq;
    int aur;
    boolean isRunning;
    OverScroller ubA;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.LMX = new RectF();
      this.LMY = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.LMQ = new OverScroller(PhotoView.this, this.LMY);
      this.LMR = new Scroller(PhotoView.this, this.LMY);
      this.ubA = new OverScroller(PhotoView.this, this.LMY);
      this.LMS = new Scroller(PhotoView.this, this.LMY);
      this.LMT = new Scroller(PhotoView.this, this.LMY);
      AppMethodBeat.o(164273);
    }
    
    private void fUu()
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
    
    private void fUv()
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
      this.LMS.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.LMU = parama;
      AppMethodBeat.o(164276);
    }
    
    final void as(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.LMR.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void kC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.LMV = 0;
      this.LMW = 0;
      this.LMQ.startScroll(0, 0, paramInt1, paramInt2, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void kD(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.LMT.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.LMR.computeScrollOffset()) {
        PhotoView.c(PhotoView.this, this.LMR.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.LMQ.computeScrollOffset())
        {
          i = this.LMQ.getCurrX();
          m = this.LMV;
          n = this.LMQ.getCurrY();
          i1 = this.LMW;
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          this.LMV = this.LMQ.getCurrX();
          this.LMW = this.LMQ.getCurrY();
          i = 0;
        }
        if (this.ubA.computeScrollOffset())
        {
          i = this.ubA.getCurrX();
          m = this.auq;
          n = this.ubA.getCurrY();
          i1 = this.aur;
          this.auq = this.ubA.getCurrX();
          this.aur = this.ubA.getCurrY();
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          i = 0;
        }
        if (this.LMT.computeScrollOffset())
        {
          PhotoView.b(PhotoView.this, this.LMT.getCurrX());
          i = 0;
        }
        if ((this.LMS.computeScrollOffset()) || (PhotoView.H(PhotoView.this) != null))
        {
          float f1 = this.LMS.getCurrX() / 10000.0F;
          float f2 = this.LMS.getCurrY() / 10000.0F;
          PhotoView.A(PhotoView.this).setScale(f1, f2, (PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).right) / 2.0F, this.LMU.fUt());
          PhotoView.A(PhotoView.this).mapRect(this.LMX, PhotoView.p(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.LMX.left = PhotoView.q(PhotoView.this).left;
            this.LMX.right = PhotoView.q(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.LMX.top = PhotoView.q(PhotoView.this).top;
            this.LMX.bottom = PhotoView.q(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.LMX);
        }
        if (i == 0)
        {
          fUu();
          fUv();
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
            fUu();
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
      fUv();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.LMQ.abortAnimation();
      this.LMR.abortAnimation();
      this.ubA.abortAnimation();
      this.LMT.abortAnimation();
      this.isRunning = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i
  {
    Matrix LNa;
    public Matrix LNb;
    Matrix LNc;
    RectF LNd;
    public RectF LNe;
    RectF LNf;
    RectF LNg;
    PointF LNh;
    PointF LNi;
    PointF LNj;
    Matrix rJ;
    public RectF xYu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */