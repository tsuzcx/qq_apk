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
import com.tencent.mm.sdk.platformtools.Log;

public class PhotoView
  extends AppCompatImageView
{
  private Matrix OUN;
  private GestureDetector PO;
  private boolean QEq;
  private boolean RkA;
  private boolean RkB;
  private float RkC;
  private float RkD;
  private int RkE;
  private int RkF;
  private float RkG;
  private float RkH;
  private RectF RkI;
  private RectF RkJ;
  private RectF RkK;
  private PointF RkL;
  private PointF RkM;
  private PointF RkN;
  private h RkO;
  private RectF RkP;
  private PhotoView.Info RkQ;
  private long RkR;
  private Runnable RkS;
  private View.OnLongClickListener RkT;
  private i RkU;
  private e RkV;
  private ScaleGestureDetector.OnScaleGestureListener RkW;
  private Runnable RkX;
  private GestureDetector.OnGestureListener RkY;
  private Rect RkZ;
  private int Rkh;
  private int Rki;
  private float Rkj;
  private int Rkk;
  private int Rkl;
  private int Rkm;
  private int Rkn;
  private Matrix Rko;
  private Matrix Rkp;
  private f Rkq;
  private ScaleGestureDetector Rkr;
  private ImageView.ScaleType Rks;
  private boolean Rkt;
  private boolean Rku;
  private boolean Rkv;
  private boolean Rkw;
  private boolean Rkx;
  private boolean Rky;
  private boolean Rkz;
  private boolean ded;
  private RectF dgT;
  private float dhh;
  private View.OnClickListener hEZ;
  private boolean isInit;
  private RectF xsQ;
  private Matrix xt;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.Rkk = 0;
    this.Rkl = 0;
    this.Rkm = 0;
    this.Rkn = 500;
    this.OUN = new Matrix();
    this.Rko = new Matrix();
    this.Rkp = new Matrix();
    this.xt = new Matrix();
    this.ded = false;
    this.Rkx = false;
    this.dhh = 1.0F;
    this.xsQ = new RectF();
    this.RkI = new RectF();
    this.RkJ = new RectF();
    this.dgT = new RectF();
    this.RkK = new RectF();
    this.RkL = new PointF();
    this.RkM = new PointF();
    this.RkN = new PointF();
    this.RkO = new h();
    this.RkV = new e()
    {
      public final void v(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
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
    this.RkW = new PhotoView.2(this);
    this.RkX = new PhotoView.3(this);
    this.RkY = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206183);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206183);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
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
          PhotoView.o(PhotoView.this).aD(f2, f1);
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
                PhotoView.o(PhotoView.this).mb((int)PhotoView.c(PhotoView.this), (int)f1);
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
              localh.auo = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.p(localh.Rla).left);
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
              localh.aup = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.p(localh.Rla).top);
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
              localOverScroller = localh.xsO;
              i2 = localh.auo;
              i3 = localh.aup;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.Rla) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.Rla) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.Rla))
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
              f1 = PhotoView.p(localh.Rla).right - PhotoView.q(localh.Rla).right;
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
              f1 = PhotoView.p(localh.Rla).bottom - PhotoView.q(localh.Rla).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.Rla);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
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
        if (PhotoView.this.cK(paramAnonymousFloat1))
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
          if (PhotoView.this.cL(paramAnonymousFloat2)) {
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.RkZ = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.Rkk = 0;
    this.Rkl = 0;
    this.Rkm = 0;
    this.Rkn = 500;
    this.OUN = new Matrix();
    this.Rko = new Matrix();
    this.Rkp = new Matrix();
    this.xt = new Matrix();
    this.ded = false;
    this.Rkx = false;
    this.dhh = 1.0F;
    this.xsQ = new RectF();
    this.RkI = new RectF();
    this.RkJ = new RectF();
    this.dgT = new RectF();
    this.RkK = new RectF();
    this.RkL = new PointF();
    this.RkM = new PointF();
    this.RkN = new PointF();
    this.RkO = new h();
    this.RkV = new e()
    {
      public final void v(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
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
    this.RkW = new PhotoView.2(this);
    this.RkX = new PhotoView.3(this);
    this.RkY = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206183);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206183);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
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
          PhotoView.o(PhotoView.this).aD(f2, f1);
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
                PhotoView.o(PhotoView.this).mb((int)PhotoView.c(PhotoView.this), (int)f1);
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
              localh.auo = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.p(localh.Rla).left);
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
              localh.aup = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.p(localh.Rla).top);
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
              localOverScroller = localh.xsO;
              i2 = localh.auo;
              i3 = localh.aup;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.Rla) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.Rla) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.G(localh.Rla))
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
              f1 = PhotoView.p(localh.Rla).right - PhotoView.q(localh.Rla).right;
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
              f1 = PhotoView.p(localh.Rla).bottom - PhotoView.q(localh.Rla).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.Rla);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
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
        if (PhotoView.this.cK(paramAnonymousFloat1))
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
          if (PhotoView.this.cL(paramAnonymousFloat2)) {
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.RkZ = new Rect();
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
  
  private void a(PhotoView.Info paramInfo)
  {
    AppMethodBeat.i(164318);
    if (this.isInit)
    {
      reset();
      this.RkZ.set(paramInfo.RkZ);
      PhotoView.Info localInfo = getInfo();
      float f1 = paramInfo.RkJ.width() / localInfo.RkJ.width();
      float f2 = paramInfo.RkJ.height() / localInfo.RkJ.height();
      if (f1 < f2)
      {
        f2 = paramInfo.nYV.left + paramInfo.nYV.width() / 2.0F;
        float f3 = paramInfo.nYV.top + paramInfo.nYV.height() / 2.0F;
        float f4 = localInfo.nYV.left + localInfo.nYV.width() / 2.0F;
        float f5 = localInfo.nYV.top;
        f5 = localInfo.nYV.height() / 2.0F + f5;
        this.Rko.reset();
        this.Rko.postTranslate(f2 - f4, f3 - f5);
        this.Rko.postScale(f1, f1, f2, f3);
        this.Rko.postRotate(paramInfo.RkD, f2, f3);
        hfO();
        this.RkM.set(f2, f3);
        this.RkN.set(f2, f3);
        this.RkO.ma((int)-(f2 - f4), (int)-(f3 - f5));
        this.RkO.aD(f1, 1.0F);
        this.RkO.mb((int)paramInfo.RkD, 0);
        if ((paramInfo.xsQ.width() < paramInfo.RkJ.width()) || (paramInfo.xsQ.height() < paramInfo.RkJ.height()))
        {
          f2 = paramInfo.xsQ.width() / paramInfo.RkJ.width();
          f3 = paramInfo.xsQ.height() / paramInfo.RkJ.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.Rks != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.RkO.a(f1, f2, 1.0F - f1, 1.0F - f2, this.Rki / 3, paramInfo);
        this.xt.setScale(f1, f2, (this.RkJ.left + this.RkJ.right) / 2.0F, paramInfo.hfP());
        this.xt.mapRect(this.RkO.Rlm, this.RkJ);
        this.RkP = this.RkO.Rlm;
        this.RkO.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.Rks == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.RkQ = paramInfo;
    this.RkR = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(164302);
    this.Rkp = parami.Rlq;
    this.Rko = parami.Rlp;
    this.OUN = parami.Rlr;
    this.xt = parami.rM;
    this.RkG = (parami.Rls.width() / 2.0F);
    this.RkH = (parami.Rls.height() / 2.0F);
    if (!this.xsQ.isEmpty())
    {
      parami.BZm.set(this.xsQ);
      parami.Rlw = this.RkL;
    }
    this.xsQ = parami.BZm;
    this.RkI = parami.Rls;
    this.RkJ = parami.Rlt;
    this.dgT = parami.Rlu;
    this.RkK = parami.Rlv;
    this.RkL = parami.Rlw;
    this.RkM = parami.Rlx;
    this.RkN = parami.Rly;
    AppMethodBeat.o(164302);
  }
  
  private void hfF()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.Rku)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.Rkv)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.RkP != null) {
      this.RkP.setEmpty();
    }
    this.OUN.reset();
    this.Rko.reset();
    this.Rkp.reset();
    this.xt.reset();
    this.Rky = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = H(localDrawable);
    int m = I(localDrawable);
    this.RkI.set(0.0F, 0.0F, k, m);
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
        this.OUN.reset();
        this.OUN.postTranslate(n, i1);
        this.OUN.postScale(f1, f1, this.RkL.x, this.RkL.y);
        this.OUN.mapRect(this.RkI);
        this.RkG = (this.RkI.width() / 2.0F);
        this.RkH = (this.RkI.height() / 2.0F);
        this.RkM.set(this.RkL);
        this.RkN.set(this.RkM);
        hfO();
        switch (PhotoView.5.Av[this.Rks.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.isInit = true;
        if ((this.RkQ != null) && (System.currentTimeMillis() - this.RkR < this.Rkn)) {
          a(this.RkQ);
        }
        this.RkQ = null;
        if (this.RkU != null)
        {
          a(this.RkU);
          setImageMatrix(this.Rkp);
          this.RkU = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        hfG();
        continue;
        hfH();
        continue;
        hfI();
        continue;
        hfJ();
        continue;
        hfK();
        continue;
        hfL();
        continue;
        hfM();
      }
    }
  }
  
  private void hfG()
  {
    AppMethodBeat.i(164293);
    if (!this.Rku)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.Rkv)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = H(localDrawable);
    int j = I(localDrawable);
    float f1;
    float f2;
    if ((i > this.xsQ.width()) || (j > this.xsQ.height()))
    {
      f1 = i / this.RkJ.width();
      f2 = j / this.RkJ.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.dhh = f1;
      this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
      hfO();
      hfN();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void hfH()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.RkJ.width() < this.xsQ.width()) || (this.RkJ.height() < this.xsQ.height()))
    {
      f1 = this.xsQ.width() / this.RkJ.width();
      f2 = this.xsQ.height() / this.RkJ.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.dhh = f1;
      this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
      hfO();
      hfN();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void hfI()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.RkJ.width() > this.xsQ.width()) || (this.RkJ.height() > this.xsQ.height()))
    {
      f1 = this.xsQ.width() / this.RkJ.width();
      f2 = this.xsQ.height() / this.RkJ.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.dhh = f1;
      this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
      hfO();
      hfN();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void hfJ()
  {
    AppMethodBeat.i(164296);
    if (this.RkJ.width() < this.xsQ.width())
    {
      this.dhh = (this.xsQ.width() / this.RkJ.width());
      this.Rko.postScale(this.dhh, this.dhh, this.RkL.x, this.RkL.y);
      hfO();
      hfN();
    }
    AppMethodBeat.o(164296);
  }
  
  private void hfK()
  {
    AppMethodBeat.i(164297);
    hfJ();
    float f = -this.RkJ.top;
    this.Rko.postTranslate(0.0F, f);
    hfO();
    hfN();
    this.RkF = ((int)(f + this.RkF));
    AppMethodBeat.o(164297);
  }
  
  private void hfL()
  {
    AppMethodBeat.i(164298);
    hfJ();
    float f = this.xsQ.bottom - this.RkJ.bottom;
    this.RkF = ((int)(this.RkF + f));
    this.Rko.postTranslate(0.0F, f);
    hfO();
    hfN();
    AppMethodBeat.o(164298);
  }
  
  private void hfM()
  {
    AppMethodBeat.i(164299);
    float f1 = this.xsQ.width() / this.RkJ.width();
    float f2 = this.xsQ.height() / this.RkJ.height();
    this.Rko.postScale(f1, f2, this.RkL.x, this.RkL.y);
    hfO();
    hfN();
    AppMethodBeat.o(164299);
  }
  
  private void hfN()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = H(localDrawable);
    int j = I(localDrawable);
    this.RkI.set(0.0F, 0.0F, i, j);
    this.OUN.set(this.Rkp);
    this.OUN.mapRect(this.RkI);
    this.RkG = (this.RkI.width() / 2.0F);
    this.RkH = (this.RkI.height() / 2.0F);
    this.dhh = 1.0F;
    this.RkE = 0;
    this.RkF = 0;
    this.Rko.reset();
    AppMethodBeat.o(164300);
  }
  
  private void hfO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.Rkp.set(this.OUN);
    this.Rkp.postConcat(this.Rko);
    setImageMatrix(this.Rkp);
    this.Rko.mapRect(this.RkJ, this.RkI);
    if (this.RkJ.width() > this.xsQ.width())
    {
      bool1 = true;
      this.RkA = bool1;
      if (this.RkJ.height() <= this.xsQ.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.RkB = bool1;
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
    if (this.Rks == null) {
      this.Rks = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.Rkq = new f(this.RkV);
    this.PO = new GestureDetector(getContext(), this.RkY);
    this.Rkr = new ScaleGestureDetector(getContext(), this.RkW);
    float f = getResources().getDisplayMetrics().density;
    this.Rkk = ((int)(f * 30.0F));
    this.Rkl = ((int)(f * 30.0F));
    this.Rkm = ((int)(f * 140.0F));
    this.Rkh = 35;
    this.Rki = 200;
    this.Rkj = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void n(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.xsQ.width())
    {
      if (p(paramRectF)) {
        break label275;
      }
      i = -(int)((this.xsQ.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.xsQ.height()) {
        if (!o(paramRectF)) {
          j = -(int)((this.xsQ.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.RkO.xsO.isFinished()) {
            this.RkO.xsO.abortAnimation();
          }
          this.RkO.ma(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.xsQ.left)
        {
          i = (int)(paramRectF.left - this.xsQ.left);
          break;
        }
        if (paramRectF.right >= this.xsQ.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.xsQ.right);
        break;
        if (paramRectF.top > this.xsQ.top) {
          j = (int)(paramRectF.top - this.xsQ.top);
        } else if (paramRectF.bottom < this.xsQ.bottom) {
          j = (int)(paramRectF.bottom - this.xsQ.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean o(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.xsQ.height() - paramRectF.height()) / 2.0F) < 1.0F)
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
    if (Math.abs(Math.round(paramRectF.left) - (this.xsQ.width() - paramRectF.width()) / 2.0F) < 1.0F)
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
    this.Rko.reset();
    hfO();
    this.dhh = 1.0F;
    this.RkE = 0;
    this.RkF = 0;
    AppMethodBeat.o(164317);
  }
  
  public final boolean cK(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.RkJ.width() <= this.xsQ.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.RkJ.left) - paramFloat >= this.xsQ.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.RkJ.right) - paramFloat <= this.xsQ.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean cL(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.RkJ.height() <= this.xsQ.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.RkJ.top) - paramFloat >= this.xsQ.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.RkJ.bottom) - paramFloat <= this.xsQ.bottom))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    AppMethodBeat.o(164312);
    return true;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(164313);
    if (this.Rkt)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = cK(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.Rkt)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = cL(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164306);
    paramCanvas.save();
    if (this.RkP != null) {
      paramCanvas.clipRect(this.RkP);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public int getAnimaDuring()
  {
    return this.Rki;
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
    Rect localRect1 = this.RkZ;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.RkJ.left, arrayOfInt[1] + (int)this.RkJ.top, arrayOfInt[0] + (int)this.RkJ.right, arrayOfInt[1] + (int)this.RkJ.bottom);
    localObject = new PhotoView.Info((Rect)localObject, this.RkJ, this.xsQ, this.RkI, this.RkL, this.dhh, this.RkD, this.Rks, this.RkZ);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.Rkj;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.Rku)
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
      if (this.QEq)
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
    this.xsQ.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.RkL.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.Rkv)
    {
      this.Rkv = true;
      hfF();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.ded)
    {
      this.RkP = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.Rkt = true;
      }
      Object localObject = this.PO;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.Rkx) {
        localObject = this.Rkq;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.Rkr.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.RkO.isRunning))
        {
          if ((this.Rkz) || (this.RkD % 90.0F != 0.0F))
          {
            f2 = (int)(this.RkD / 90.0F) * 90;
            f3 = this.RkD % 90.0F;
            if (f3 <= 45.0F) {
              break label639;
            }
            f1 = f2 + 90.0F;
            label265:
            this.RkO.mb((int)this.RkD, (int)f1);
            this.RkD = f1;
          }
          f1 = this.dhh;
          if (this.dhh >= 1.0F) {
            break label663;
          }
          f1 = 1.0F;
          this.RkO.aD(this.dhh, 1.0F);
        }
        break;
      }
      for (;;)
      {
        f2 = this.RkJ.left + this.RkJ.width() / 2.0F;
        f3 = this.RkJ.top + this.RkJ.height() / 2.0F;
        this.RkM.set(f2, f3);
        this.RkN.set(f2, f3);
        this.RkE = 0;
        this.RkF = 0;
        this.xt.reset();
        this.xt.postTranslate(-this.RkI.left, -this.RkI.top);
        this.xt.postTranslate(f2 - this.RkG, f3 - this.RkH);
        this.xt.postScale(f1, f1, f2, f3);
        this.xt.postRotate(this.RkD, f2, f3);
        this.xt.mapRect(this.dgT, this.RkI);
        n(this.dgT);
        this.RkO.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        ((f)localObject).Rld = ((f)localObject).az(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        ((f)localObject).Rle = ((f)localObject).az(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(((f)localObject).Rle)) - Math.toDegrees(Math.atan(((f)localObject).Rld));
        if (Math.abs(d) <= 120.0D) {
          ((f)localObject).Rlc.v((float)d, (((f)localObject).x2 + ((f)localObject).x1) / 2.0F, (((f)localObject).y2 + ((f)localObject).y1) / 2.0F);
        }
        ((f)localObject).Rld = ((f)localObject).Rle;
        break;
        label639:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label265;
        }
        f1 = f2 - 90.0F;
        break label265;
        label663:
        if (this.dhh > this.Rkj)
        {
          f1 = this.Rkj;
          this.RkO.aD(this.dhh, this.Rkj);
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
    this.QEq = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.Rki = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.RkZ);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.Rku = false;
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
    if (!this.Rku) {
      this.Rku = true;
    }
    hfF();
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
    this.RkO.Rln.Rlb = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.Rkn = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.Rkj = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.hEZ = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.RkT = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.Rks)
    {
      this.Rks = paramScaleType;
      if (this.isInit) {
        hfF();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static abstract interface a
  {
    public abstract float hfP();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float hfP()
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
    
    public final float hfP()
    {
      AppMethodBeat.i(164269);
      float f = (PhotoView.p(PhotoView.this).top + PhotoView.p(PhotoView.this).bottom) / 2.0F;
      AppMethodBeat.o(164269);
      return f;
    }
  }
  
  static abstract interface e
  {
    public abstract void v(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public final class f
  {
    PhotoView.e Rlc;
    float Rld;
    float Rle;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.Rlc = parame;
    }
    
    final float az(MotionEvent paramMotionEvent)
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
    
    public final float hfP()
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
    OverScroller Rlf;
    Scroller Rlg;
    Scroller Rlh;
    Scroller Rli;
    PhotoView.a Rlj;
    int Rlk;
    int Rll;
    RectF Rlm;
    PhotoView.c Rln;
    int auo;
    int aup;
    boolean isRunning;
    OverScroller xsO;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.Rlm = new RectF();
      this.Rln = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.Rlf = new OverScroller(PhotoView.this, this.Rln);
      this.Rlg = new Scroller(PhotoView.this, this.Rln);
      this.xsO = new OverScroller(PhotoView.this, this.Rln);
      this.Rlh = new Scroller(PhotoView.this, this.Rln);
      this.Rli = new Scroller(PhotoView.this, this.Rln);
      AppMethodBeat.o(164273);
    }
    
    private void hfQ()
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
    
    private void hfR()
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
      this.Rlh.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.Rlj = parama;
      AppMethodBeat.o(164276);
    }
    
    final void aD(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.Rlg.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void ma(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.Rlk = 0;
      this.Rll = 0;
      this.Rlf.startScroll(0, 0, paramInt1, paramInt2, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void mb(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.Rli.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.Rlg.computeScrollOffset()) {
        PhotoView.c(PhotoView.this, this.Rlg.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.Rlf.computeScrollOffset())
        {
          i = this.Rlf.getCurrX();
          m = this.Rlk;
          n = this.Rlf.getCurrY();
          i1 = this.Rll;
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          this.Rlk = this.Rlf.getCurrX();
          this.Rll = this.Rlf.getCurrY();
          i = 0;
        }
        if (this.xsO.computeScrollOffset())
        {
          i = this.xsO.getCurrX();
          m = this.auo;
          n = this.xsO.getCurrY();
          i1 = this.aup;
          this.auo = this.xsO.getCurrX();
          this.aup = this.xsO.getCurrY();
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          i = 0;
        }
        if (this.Rli.computeScrollOffset())
        {
          PhotoView.b(PhotoView.this, this.Rli.getCurrX());
          i = 0;
        }
        if ((this.Rlh.computeScrollOffset()) || (PhotoView.H(PhotoView.this) != null))
        {
          float f1 = this.Rlh.getCurrX() / 10000.0F;
          float f2 = this.Rlh.getCurrY() / 10000.0F;
          PhotoView.A(PhotoView.this).setScale(f1, f2, (PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).right) / 2.0F, this.Rlj.hfP());
          PhotoView.A(PhotoView.this).mapRect(this.Rlm, PhotoView.p(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.Rlm.left = PhotoView.q(PhotoView.this).left;
            this.Rlm.right = PhotoView.q(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.Rlm.top = PhotoView.q(PhotoView.this).top;
            this.Rlm.bottom = PhotoView.q(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.Rlm);
        }
        if (i == 0)
        {
          hfQ();
          hfR();
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
            hfQ();
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
      hfR();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.Rlf.abortAnimation();
      this.Rlg.abortAnimation();
      this.xsO.abortAnimation();
      this.Rli.abortAnimation();
      this.isRunning = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i
  {
    public RectF BZm;
    Matrix Rlp;
    public Matrix Rlq;
    Matrix Rlr;
    RectF Rls;
    public RectF Rlt;
    RectF Rlu;
    RectF Rlv;
    PointF Rlw;
    PointF Rlx;
    PointF Rly;
    Matrix rM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */