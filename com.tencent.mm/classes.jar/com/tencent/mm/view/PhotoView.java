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
import com.tencent.mm.sdk.platformtools.ad;

public class PhotoView
  extends AppCompatImageView
{
  private Matrix Gbz;
  private boolean HBc;
  private ImageView.ScaleType HVA;
  private boolean HVB;
  private boolean HVC;
  private boolean HVD;
  private boolean HVE;
  private boolean HVF;
  private boolean HVG;
  private boolean HVH;
  private boolean HVI;
  private boolean HVJ;
  private float HVK;
  private float HVL;
  private int HVM;
  private int HVN;
  private float HVO;
  private float HVP;
  private RectF HVQ;
  private RectF HVR;
  private RectF HVS;
  private PointF HVT;
  private PointF HVU;
  private PointF HVV;
  private h HVW;
  private RectF HVX;
  private Info HVY;
  private long HVZ;
  private int HVp;
  private int HVq;
  private float HVr;
  private int HVs;
  private int HVt;
  private int HVu;
  private int HVv;
  private Matrix HVw;
  private Matrix HVx;
  private f HVy;
  private ScaleGestureDetector HVz;
  private Runnable HWa;
  private View.OnLongClickListener HWb;
  private i HWc;
  private e HWd;
  private ScaleGestureDetector.OnScaleGestureListener HWe;
  private Runnable HWf;
  private GestureDetector.OnGestureListener HWg;
  private Rect HWh;
  private GestureDetector MQ;
  private boolean cEP;
  private RectF cHC;
  private float cHQ;
  private boolean csX;
  private View.OnClickListener pgj;
  private RectF rMx;
  private Matrix uv;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.HVs = 0;
    this.HVt = 0;
    this.HVu = 0;
    this.HVv = 500;
    this.Gbz = new Matrix();
    this.HVw = new Matrix();
    this.HVx = new Matrix();
    this.uv = new Matrix();
    this.cEP = false;
    this.HVF = false;
    this.cHQ = 1.0F;
    this.rMx = new RectF();
    this.HVQ = new RectF();
    this.HVR = new RectF();
    this.cHC = new RectF();
    this.HVS = new RectF();
    this.HVT = new PointF();
    this.HVU = new PointF();
    this.HVV = new PointF();
    this.HVW = new h();
    this.HWd = new e()
    {
      public final void q(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
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
    this.HWe = new ScaleGestureDetector.OnScaleGestureListener()
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
    this.HWf = new Runnable()
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
    this.HWg = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
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
            break label454;
          }
        }
        label454:
        for (boolean bool = true;; bool = false)
        {
          PhotoView.c(paramAnonymousMotionEvent, bool);
          PhotoView.o(PhotoView.this).ak(f2, f1);
          PhotoView.o(PhotoView.this).start();
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
                PhotoView.o(PhotoView.this).jU((int)PhotoView.c(PhotoView.this), (int)f1);
                PhotoView.b(PhotoView.this, f1);
              }
            }
            else
            {
              PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this));
              localh = PhotoView.o(PhotoView.this);
              if (f2 >= 0.0F) {
                break label685;
              }
              i = 2147483647;
              localh.arE = i;
              if (f2 <= 0.0F) {
                break label691;
              }
              f1 = Math.abs(PhotoView.p(localh.HWi).left);
              j = (int)f1;
              i = j;
              if (f2 < 0.0F) {
                i = 2147483647 - j;
              }
              if (f2 >= 0.0F) {
                break label719;
              }
              j = i;
              if (f2 >= 0.0F) {
                break label725;
              }
              k = 2147483647;
              if (f2 >= 0.0F) {
                break label732;
              }
              i1 = 2147483647 - j;
              if (f3 >= 0.0F) {
                break label739;
              }
              i = 2147483647;
              localh.arF = i;
              if (f3 <= 0.0F) {
                break label745;
              }
              f1 = Math.abs(PhotoView.p(localh.HWi).top);
              m = (int)f1;
              i = m;
              if (f3 < 0.0F) {
                i = 2147483647 - m;
              }
              if (f3 >= 0.0F) {
                break label773;
              }
              m = i;
              if (f3 >= 0.0F) {
                break label779;
              }
              n = 2147483647;
              if (f3 >= 0.0F) {
                break label786;
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
              localOverScroller = localh.rMv;
              i2 = localh.arE;
              i3 = localh.arF;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.HWi) * 2) {
                break label789;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.HWi) * 2) {
                break label802;
              }
            }
            label773:
            label779:
            label786:
            label789:
            label802:
            for (int i = 0;; i = PhotoView.G(localh.HWi))
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
              label685:
              i = 0;
              break label321;
              label691:
              f1 = PhotoView.p(localh.HWi).right - PhotoView.q(localh.HWi).right;
              break label351;
              label719:
              j = 0;
              break label385;
              label725:
              k = i;
              break label396;
              label732:
              i1 = i;
              break label410;
              label739:
              i = 0;
              break label421;
              label745:
              f1 = PhotoView.p(localh.HWi).bottom - PhotoView.q(localh.HWi).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.HWi);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        if (PhotoView.i(PhotoView.this) != null) {
          PhotoView.i(PhotoView.this).onLongClick(PhotoView.this);
        }
        AppMethodBeat.o(164253);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164256);
        if (PhotoView.o(PhotoView.this).isRunning) {
          PhotoView.o(PhotoView.this).stop();
        }
        if (PhotoView.this.bQ(paramAnonymousFloat1))
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
          if (PhotoView.this.bR(paramAnonymousFloat2)) {
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
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.HWh = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.HVs = 0;
    this.HVt = 0;
    this.HVu = 0;
    this.HVv = 500;
    this.Gbz = new Matrix();
    this.HVw = new Matrix();
    this.HVx = new Matrix();
    this.uv = new Matrix();
    this.cEP = false;
    this.HVF = false;
    this.cHQ = 1.0F;
    this.rMx = new RectF();
    this.HVQ = new RectF();
    this.HVR = new RectF();
    this.cHC = new RectF();
    this.HVS = new RectF();
    this.HVT = new PointF();
    this.HVU = new PointF();
    this.HVV = new PointF();
    this.HVW = new h();
    this.HWd = new e()
    {
      public final void q(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
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
    this.HWe = new ScaleGestureDetector.OnScaleGestureListener()
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
    this.HWf = new Runnable()
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
    this.HWg = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
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
            break label454;
          }
        }
        label454:
        for (boolean bool = true;; bool = false)
        {
          PhotoView.c(paramAnonymousMotionEvent, bool);
          PhotoView.o(PhotoView.this).ak(f2, f1);
          PhotoView.o(PhotoView.this).start();
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
                PhotoView.o(PhotoView.this).jU((int)PhotoView.c(PhotoView.this), (int)f1);
                PhotoView.b(PhotoView.this, f1);
              }
            }
            else
            {
              PhotoView.a(PhotoView.this, PhotoView.p(PhotoView.this));
              localh = PhotoView.o(PhotoView.this);
              if (f2 >= 0.0F) {
                break label685;
              }
              i = 2147483647;
              localh.arE = i;
              if (f2 <= 0.0F) {
                break label691;
              }
              f1 = Math.abs(PhotoView.p(localh.HWi).left);
              j = (int)f1;
              i = j;
              if (f2 < 0.0F) {
                i = 2147483647 - j;
              }
              if (f2 >= 0.0F) {
                break label719;
              }
              j = i;
              if (f2 >= 0.0F) {
                break label725;
              }
              k = 2147483647;
              if (f2 >= 0.0F) {
                break label732;
              }
              i1 = 2147483647 - j;
              if (f3 >= 0.0F) {
                break label739;
              }
              i = 2147483647;
              localh.arF = i;
              if (f3 <= 0.0F) {
                break label745;
              }
              f1 = Math.abs(PhotoView.p(localh.HWi).top);
              m = (int)f1;
              i = m;
              if (f3 < 0.0F) {
                i = 2147483647 - m;
              }
              if (f3 >= 0.0F) {
                break label773;
              }
              m = i;
              if (f3 >= 0.0F) {
                break label779;
              }
              n = 2147483647;
              if (f3 >= 0.0F) {
                break label786;
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
              localOverScroller = localh.rMv;
              i2 = localh.arE;
              i3 = localh.arF;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.HWi) * 2) {
                break label789;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.HWi) * 2) {
                break label802;
              }
            }
            label773:
            label779:
            label786:
            label789:
            label802:
            for (int i = 0;; i = PhotoView.G(localh.HWi))
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
              label685:
              i = 0;
              break label321;
              label691:
              f1 = PhotoView.p(localh.HWi).right - PhotoView.q(localh.HWi).right;
              break label351;
              label719:
              j = 0;
              break label385;
              label725:
              k = i;
              break label396;
              label732:
              i1 = i;
              break label410;
              label739:
              i = 0;
              break label421;
              label745:
              f1 = PhotoView.p(localh.HWi).bottom - PhotoView.q(localh.HWi).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.HWi);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        if (PhotoView.i(PhotoView.this) != null) {
          PhotoView.i(PhotoView.this).onLongClick(PhotoView.this);
        }
        AppMethodBeat.o(164253);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164256);
        if (PhotoView.o(PhotoView.this).isRunning) {
          PhotoView.o(PhotoView.this).stop();
        }
        if (PhotoView.this.bQ(paramAnonymousFloat1))
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
          if (PhotoView.this.bR(paramAnonymousFloat2)) {
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
        PhotoView.this.postDelayed(PhotoView.k(PhotoView.this), 250L);
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.HWh = new Rect();
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
  
  private void a(Info paramInfo)
  {
    AppMethodBeat.i(164318);
    if (this.csX)
    {
      reset();
      this.HWh.set(paramInfo.HWh);
      Info localInfo = getInfo();
      float f1 = paramInfo.HVR.width() / localInfo.HVR.width();
      float f2 = paramInfo.HVR.height() / localInfo.HVR.height();
      if (f1 < f2)
      {
        f2 = paramInfo.lEo.left + paramInfo.lEo.width() / 2.0F;
        float f3 = paramInfo.lEo.top + paramInfo.lEo.height() / 2.0F;
        float f4 = localInfo.lEo.left + localInfo.lEo.width() / 2.0F;
        float f5 = localInfo.lEo.top;
        f5 = localInfo.lEo.height() / 2.0F + f5;
        this.HVw.reset();
        this.HVw.postTranslate(f2 - f4, f3 - f5);
        this.HVw.postScale(f1, f1, f2, f3);
        this.HVw.postRotate(paramInfo.HVL, f2, f3);
        fiA();
        this.HVU.set(f2, f3);
        this.HVV.set(f2, f3);
        this.HVW.jT((int)-(f2 - f4), (int)-(f3 - f5));
        this.HVW.ak(f1, 1.0F);
        this.HVW.jU((int)paramInfo.HVL, 0);
        if ((paramInfo.rMx.width() < paramInfo.HVR.width()) || (paramInfo.rMx.height() < paramInfo.HVR.height()))
        {
          f2 = paramInfo.rMx.width() / paramInfo.HVR.width();
          f3 = paramInfo.rMx.height() / paramInfo.HVR.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.HVA != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.HVW.a(f1, f2, 1.0F - f1, 1.0F - f2, this.HVq / 3, paramInfo);
        this.uv.setScale(f1, f2, (this.HVR.left + this.HVR.right) / 2.0F, paramInfo.fiB());
        this.uv.mapRect(this.HVW.HWt, this.HVR);
        this.HVX = this.HVW.HWt;
        this.HVW.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.HVA == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.HVY = paramInfo;
    this.HVZ = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(164302);
    this.HVx = parami.HWx;
    this.HVw = parami.HWw;
    this.Gbz = parami.HWy;
    this.uv = parami.oQ;
    this.HVO = (parami.HWz.width() / 2.0F);
    this.HVP = (parami.HWz.height() / 2.0F);
    if (!this.rMx.isEmpty())
    {
      parami.rFY.set(this.rMx);
      parami.HWD = this.HVT;
    }
    this.rMx = parami.rFY;
    this.HVQ = parami.HWz;
    this.HVR = parami.HWA;
    this.cHC = parami.HWB;
    this.HVS = parami.HWC;
    this.HVT = parami.HWD;
    this.HVU = parami.HWE;
    this.HVV = parami.HWF;
    AppMethodBeat.o(164302);
  }
  
  private void fiA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.HVx.set(this.Gbz);
    this.HVx.postConcat(this.HVw);
    setImageMatrix(this.HVx);
    this.HVw.mapRect(this.HVR, this.HVQ);
    if (this.HVR.width() > this.rMx.width())
    {
      bool1 = true;
      this.HVI = bool1;
      if (this.HVR.height() <= this.rMx.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HVJ = bool1;
      AppMethodBeat.o(164301);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void fir()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.HVC)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.HVD)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.HVX != null) {
      this.HVX.setEmpty();
    }
    this.Gbz.reset();
    this.HVw.reset();
    this.HVx.reset();
    this.uv.reset();
    this.HVG = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = I(localDrawable);
    int m = J(localDrawable);
    this.HVQ.set(0.0F, 0.0F, k, m);
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
        this.Gbz.reset();
        this.Gbz.postTranslate(n, i1);
        this.Gbz.postScale(f1, f1, this.HVT.x, this.HVT.y);
        this.Gbz.mapRect(this.HVQ);
        this.HVO = (this.HVQ.width() / 2.0F);
        this.HVP = (this.HVQ.height() / 2.0F);
        this.HVU.set(this.HVT);
        this.HVV.set(this.HVU);
        fiA();
        switch (PhotoView.5.xy[this.HVA.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.csX = true;
        if ((this.HVY != null) && (System.currentTimeMillis() - this.HVZ < this.HVv)) {
          a(this.HVY);
        }
        this.HVY = null;
        if (this.HWc != null)
        {
          a(this.HWc);
          setImageMatrix(this.HVx);
          this.HWc = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        fis();
        continue;
        fit();
        continue;
        fiu();
        continue;
        fiv();
        continue;
        fiw();
        continue;
        fix();
        continue;
        fiy();
      }
    }
  }
  
  private void fis()
  {
    AppMethodBeat.i(164293);
    if (!this.HVC)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.HVD)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = I(localDrawable);
    int j = J(localDrawable);
    float f1;
    float f2;
    if ((i > this.rMx.width()) || (j > this.rMx.height()))
    {
      f1 = i / this.HVR.width();
      f2 = j / this.HVR.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.cHQ = f1;
      this.HVw.postScale(this.cHQ, this.cHQ, this.HVT.x, this.HVT.y);
      fiA();
      fiz();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void fit()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.HVR.width() < this.rMx.width()) || (this.HVR.height() < this.rMx.height()))
    {
      f1 = this.rMx.width() / this.HVR.width();
      f2 = this.rMx.height() / this.HVR.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cHQ = f1;
      this.HVw.postScale(this.cHQ, this.cHQ, this.HVT.x, this.HVT.y);
      fiA();
      fiz();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fiu()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.HVR.width() > this.rMx.width()) || (this.HVR.height() > this.rMx.height()))
    {
      f1 = this.rMx.width() / this.HVR.width();
      f2 = this.rMx.height() / this.HVR.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cHQ = f1;
      this.HVw.postScale(this.cHQ, this.cHQ, this.HVT.x, this.HVT.y);
      fiA();
      fiz();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fiv()
  {
    AppMethodBeat.i(164296);
    if (this.HVR.width() < this.rMx.width())
    {
      this.cHQ = (this.rMx.width() / this.HVR.width());
      this.HVw.postScale(this.cHQ, this.cHQ, this.HVT.x, this.HVT.y);
      fiA();
      fiz();
    }
    AppMethodBeat.o(164296);
  }
  
  private void fiw()
  {
    AppMethodBeat.i(164297);
    fiv();
    float f = -this.HVR.top;
    this.HVw.postTranslate(0.0F, f);
    fiA();
    fiz();
    this.HVN = ((int)(f + this.HVN));
    AppMethodBeat.o(164297);
  }
  
  private void fix()
  {
    AppMethodBeat.i(164298);
    fiv();
    float f = this.rMx.bottom - this.HVR.bottom;
    this.HVN = ((int)(this.HVN + f));
    this.HVw.postTranslate(0.0F, f);
    fiA();
    fiz();
    AppMethodBeat.o(164298);
  }
  
  private void fiy()
  {
    AppMethodBeat.i(164299);
    float f1 = this.rMx.width() / this.HVR.width();
    float f2 = this.rMx.height() / this.HVR.height();
    this.HVw.postScale(f1, f2, this.HVT.x, this.HVT.y);
    fiA();
    fiz();
    AppMethodBeat.o(164299);
  }
  
  private void fiz()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = I(localDrawable);
    int j = J(localDrawable);
    this.HVQ.set(0.0F, 0.0F, i, j);
    this.Gbz.set(this.HVx);
    this.Gbz.mapRect(this.HVQ);
    this.HVO = (this.HVQ.width() / 2.0F);
    this.HVP = (this.HVQ.height() / 2.0F);
    this.cHQ = 1.0F;
    this.HVM = 0;
    this.HVN = 0;
    this.HVw.reset();
    AppMethodBeat.o(164300);
  }
  
  private void init()
  {
    AppMethodBeat.i(164285);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.HVA == null) {
      this.HVA = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.HVy = new f(this.HWd);
    this.MQ = new GestureDetector(getContext(), this.HWg);
    this.HVz = new ScaleGestureDetector(getContext(), this.HWe);
    float f = getResources().getDisplayMetrics().density;
    this.HVs = ((int)(f * 30.0F));
    this.HVt = ((int)(f * 30.0F));
    this.HVu = ((int)(f * 140.0F));
    this.HVp = 35;
    this.HVq = 200;
    this.HVr = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void k(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.rMx.width())
    {
      if (m(paramRectF)) {
        break label275;
      }
      i = -(int)((this.rMx.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.rMx.height()) {
        if (!l(paramRectF)) {
          j = -(int)((this.rMx.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.HVW.rMv.isFinished()) {
            this.HVW.rMv.abortAnimation();
          }
          this.HVW.jT(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.rMx.left)
        {
          i = (int)(paramRectF.left - this.rMx.left);
          break;
        }
        if (paramRectF.right >= this.rMx.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.rMx.right);
        break;
        if (paramRectF.top > this.rMx.top) {
          j = (int)(paramRectF.top - this.rMx.top);
        } else if (paramRectF.bottom < this.rMx.bottom) {
          j = (int)(paramRectF.bottom - this.rMx.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean l(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.rMx.height() - paramRectF.height()) / 2.0F) < 1.0F)
    {
      AppMethodBeat.o(164309);
      return true;
    }
    AppMethodBeat.o(164309);
    return false;
  }
  
  private boolean m(RectF paramRectF)
  {
    AppMethodBeat.i(164310);
    if (Math.abs(Math.round(paramRectF.left) - (this.rMx.width() - paramRectF.width()) / 2.0F) < 1.0F)
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
    this.HVw.reset();
    fiA();
    this.cHQ = 1.0F;
    this.HVM = 0;
    this.HVN = 0;
    AppMethodBeat.o(164317);
  }
  
  public final boolean bQ(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.HVR.width() <= this.rMx.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.HVR.left) - paramFloat >= this.rMx.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.HVR.right) - paramFloat <= this.rMx.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean bR(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.HVR.height() <= this.rMx.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.HVR.top) - paramFloat >= this.rMx.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.HVR.bottom) - paramFloat <= this.rMx.bottom))
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
    if (this.HVB)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = bQ(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.HVB)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = bR(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164306);
    paramCanvas.save();
    if (this.HVX != null) {
      paramCanvas.clipRect(this.HVX);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public int getAnimaDuring()
  {
    return this.HVq;
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
    Rect localRect1 = this.HWh;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.HVR.left, arrayOfInt[1] + (int)this.HVR.top, arrayOfInt[0] + (int)this.HVR.right, arrayOfInt[1] + (int)this.HVR.bottom);
    localObject = new Info((Rect)localObject, this.HVR, this.rMx, this.HVQ, this.HVT, this.cHQ, this.HVL, this.HVA, this.HWh);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.HVr;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.HVC)
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
      if (this.HBc)
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
    this.rMx.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.HVT.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.HVD)
    {
      this.HVD = true;
      fir();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.cEP)
    {
      this.HVX = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.HVB = true;
      }
      this.MQ.onTouchEvent(paramMotionEvent);
      f localf;
      if (this.HVF) {
        localf = this.HVy;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.HVz.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.HVW.isRunning))
        {
          if ((this.HVH) || (this.HVL % 90.0F != 0.0F))
          {
            f2 = (int)(this.HVL / 90.0F) * 90;
            f3 = this.HVL % 90.0F;
            if (f3 <= 45.0F) {
              break label563;
            }
            f1 = f2 + 90.0F;
            label189:
            this.HVW.jU((int)this.HVL, (int)f1);
            this.HVL = f1;
          }
          f1 = this.cHQ;
          if (this.cHQ >= 1.0F) {
            break label587;
          }
          this.HVW.ak(this.cHQ, 1.0F);
          f1 = 1.0F;
        }
        break;
      }
      for (;;)
      {
        f2 = this.HVR.left + this.HVR.width() / 2.0F;
        f3 = this.HVR.top + this.HVR.height() / 2.0F;
        this.HVU.set(f2, f3);
        this.HVV.set(f2, f3);
        this.HVM = 0;
        this.HVN = 0;
        this.uv.reset();
        this.uv.postTranslate(-this.HVQ.left, -this.HVQ.top);
        this.uv.postTranslate(f2 - this.HVO, f3 - this.HVP);
        this.uv.postScale(f1, f1, f2, f3);
        this.uv.postRotate(this.HVL, f2, f3);
        this.uv.mapRect(this.cHC, this.HVQ);
        k(this.cHC);
        this.HVW.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        localf.HWl = localf.al(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        localf.HWm = localf.al(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(localf.HWm)) - Math.toDegrees(Math.atan(localf.HWl));
        if (Math.abs(d) <= 120.0D) {
          localf.HWk.q((float)d, (localf.x2 + localf.x1) / 2.0F, (localf.y2 + localf.y1) / 2.0F);
        }
        localf.HWl = localf.HWm;
        break;
        label563:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label189;
        }
        f1 = f2 - 90.0F;
        break label189;
        label587:
        if (this.cHQ > this.HVr)
        {
          f1 = this.HVr;
          this.HVW.ak(this.cHQ, this.HVr);
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
    this.HBc = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.HVq = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.HWh);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.HVC = false;
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
    if (!this.HVC) {
      this.HVC = true;
    }
    fir();
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
    this.HVW.HWu.HWj = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.HVv = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.HVr = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.pgj = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.HWb = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.HVA)
    {
      this.HVA = paramScaleType;
      if (this.csX) {
        fir();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    ImageView.ScaleType HVA;
    float HVL;
    RectF HVQ;
    RectF HVR;
    PointF HVT;
    Rect HWh;
    float cHQ;
    public RectF lEo;
    RectF rMx;
    
    static
    {
      AppMethodBeat.i(164266);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(164266);
    }
    
    public Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
    {
      AppMethodBeat.i(164262);
      this.lEo = new RectF();
      this.HVR = new RectF();
      this.rMx = new RectF();
      this.HVQ = new RectF();
      this.HVT = new PointF();
      this.HWh = new Rect();
      this.lEo.set(paramRect1);
      this.HVR.set(paramRectF1);
      this.rMx.set(paramRectF2);
      this.cHQ = paramFloat1;
      this.HVA = paramScaleType;
      this.HVL = paramFloat2;
      this.HVQ.set(paramRectF3);
      this.HVT.set(paramPointF);
      this.HWh.set(paramRect2);
      AppMethodBeat.o(164262);
    }
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(164265);
      this.lEo = new RectF();
      this.HVR = new RectF();
      this.rMx = new RectF();
      this.HVQ = new RectF();
      this.HVT = new PointF();
      this.HWh = new Rect();
      this.lEo = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.HVR = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.rMx = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.HVQ = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.HVT = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
      this.HWh = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      this.cHQ = paramParcel.readFloat();
      this.HVL = paramParcel.readFloat();
      int i = paramParcel.readInt();
      if (i == -1) {}
      for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
      {
        this.HVA = paramParcel;
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
      String str = "Info{mRect=" + this.lEo + ", mImgRect=" + this.HVR + ", mWidgetRect=" + this.rMx + ", mBaseRect=" + this.HVQ + ", mScale=" + this.cHQ + '}';
      AppMethodBeat.o(164263);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(164264);
      paramParcel.writeParcelable(this.lEo, paramInt);
      paramParcel.writeParcelable(this.HVR, paramInt);
      paramParcel.writeParcelable(this.rMx, paramInt);
      paramParcel.writeParcelable(this.HVQ, paramInt);
      paramParcel.writeParcelable(this.HVT, paramInt);
      paramParcel.writeParcelable(this.HWh, paramInt);
      paramParcel.writeFloat(this.cHQ);
      paramParcel.writeFloat(this.HVL);
      if (this.HVA == null) {}
      for (paramInt = -1;; paramInt = this.HVA.ordinal())
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(164264);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract float fiB();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float fiB()
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
    Interpolator HWj;
    
    private c()
    {
      AppMethodBeat.i(164267);
      this.HWj = new DecelerateInterpolator();
      AppMethodBeat.o(164267);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      AppMethodBeat.i(164268);
      if (this.HWj != null)
      {
        paramFloat = this.HWj.getInterpolation(paramFloat);
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
    
    public final float fiB()
    {
      AppMethodBeat.i(164269);
      float f = (PhotoView.p(PhotoView.this).top + PhotoView.p(PhotoView.this).bottom) / 2.0F;
      AppMethodBeat.o(164269);
      return f;
    }
  }
  
  static abstract interface e
  {
    public abstract void q(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public final class f
  {
    PhotoView.e HWk;
    float HWl;
    float HWm;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.HWk = parame;
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
    
    public final float fiB()
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
    OverScroller HWn;
    Scroller HWo;
    Scroller HWp;
    PhotoView.a HWq;
    int HWr;
    int HWs;
    RectF HWt;
    PhotoView.c HWu;
    int arE;
    int arF;
    boolean isRunning;
    OverScroller rMv;
    Scroller xYX;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.HWt = new RectF();
      this.HWu = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.HWn = new OverScroller(PhotoView.this, this.HWu);
      this.xYX = new Scroller(PhotoView.this, this.HWu);
      this.rMv = new OverScroller(PhotoView.this, this.HWu);
      this.HWo = new Scroller(PhotoView.this, this.HWu);
      this.HWp = new Scroller(PhotoView.this, this.HWu);
      AppMethodBeat.o(164273);
    }
    
    private void fiC()
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
    
    private void fiD()
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
      this.HWo.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.HWq = parama;
      AppMethodBeat.o(164276);
    }
    
    final void ak(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.xYX.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void jT(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.HWr = 0;
      this.HWs = 0;
      this.HWn.startScroll(0, 0, paramInt1, paramInt2, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void jU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.HWp.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.xYX.computeScrollOffset()) {
        PhotoView.c(PhotoView.this, this.xYX.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.HWn.computeScrollOffset())
        {
          i = this.HWn.getCurrX();
          m = this.HWr;
          n = this.HWn.getCurrY();
          i1 = this.HWs;
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          this.HWr = this.HWn.getCurrX();
          this.HWs = this.HWn.getCurrY();
          i = 0;
        }
        if (this.rMv.computeScrollOffset())
        {
          i = this.rMv.getCurrX();
          m = this.arE;
          n = this.rMv.getCurrY();
          i1 = this.arF;
          this.arE = this.rMv.getCurrX();
          this.arF = this.rMv.getCurrY();
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          i = 0;
        }
        if (this.HWp.computeScrollOffset())
        {
          PhotoView.b(PhotoView.this, this.HWp.getCurrX());
          i = 0;
        }
        if ((this.HWo.computeScrollOffset()) || (PhotoView.H(PhotoView.this) != null))
        {
          float f1 = this.HWo.getCurrX() / 10000.0F;
          float f2 = this.HWo.getCurrY() / 10000.0F;
          PhotoView.A(PhotoView.this).setScale(f1, f2, (PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).right) / 2.0F, this.HWq.fiB());
          PhotoView.A(PhotoView.this).mapRect(this.HWt, PhotoView.p(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.HWt.left = PhotoView.q(PhotoView.this).left;
            this.HWt.right = PhotoView.q(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.HWt.top = PhotoView.q(PhotoView.this).top;
            this.HWt.bottom = PhotoView.q(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.HWt);
        }
        if (i == 0)
        {
          fiC();
          fiD();
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
            fiC();
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
      fiD();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.HWn.abortAnimation();
      this.xYX.abortAnimation();
      this.rMv.abortAnimation();
      this.HWp.abortAnimation();
      this.isRunning = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i
  {
    public RectF HWA;
    RectF HWB;
    RectF HWC;
    PointF HWD;
    PointF HWE;
    PointF HWF;
    Matrix HWw;
    public Matrix HWx;
    Matrix HWy;
    RectF HWz;
    Matrix oQ;
    public RectF rFY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */