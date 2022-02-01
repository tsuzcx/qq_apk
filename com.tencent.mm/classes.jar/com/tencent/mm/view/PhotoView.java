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
import android.view.animation.Interpolator;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class PhotoView
  extends AppCompatImageView
{
  private Matrix HBo;
  private boolean Jbz;
  private float JwA;
  private RectF JwB;
  private RectF JwC;
  private RectF JwD;
  private PointF JwE;
  private PointF JwF;
  private PointF JwG;
  private h JwH;
  private RectF JwI;
  private Info JwJ;
  private long JwK;
  private Runnable JwL;
  private View.OnLongClickListener JwM;
  private i JwN;
  private e JwO;
  private ScaleGestureDetector.OnScaleGestureListener JwP;
  private Runnable JwQ;
  private GestureDetector.OnGestureListener JwR;
  private Rect JwS;
  private int Jwa;
  private int Jwb;
  private float Jwc;
  private int Jwd;
  private int Jwe;
  private int Jwf;
  private int Jwg;
  private Matrix Jwh;
  private Matrix Jwi;
  private f Jwj;
  private ScaleGestureDetector Jwk;
  private ImageView.ScaleType Jwl;
  private boolean Jwm;
  private boolean Jwn;
  private boolean Jwo;
  private boolean Jwp;
  private boolean Jwq;
  private boolean Jwr;
  private boolean Jws;
  private boolean Jwt;
  private boolean Jwu;
  private float Jwv;
  private float Jww;
  private int Jwx;
  private int Jwy;
  private float Jwz;
  private GestureDetector NL;
  private boolean cBX;
  private RectF cEK;
  private float cEY;
  private boolean cqf;
  private View.OnClickListener gst;
  private RectF sUm;
  private Matrix vt;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.Jwd = 0;
    this.Jwe = 0;
    this.Jwf = 0;
    this.Jwg = 500;
    this.HBo = new Matrix();
    this.Jwh = new Matrix();
    this.Jwi = new Matrix();
    this.vt = new Matrix();
    this.cBX = false;
    this.Jwq = false;
    this.cEY = 1.0F;
    this.sUm = new RectF();
    this.JwB = new RectF();
    this.JwC = new RectF();
    this.cEK = new RectF();
    this.JwD = new RectF();
    this.JwE = new PointF();
    this.JwF = new PointF();
    this.JwG = new PointF();
    this.JwH = new h();
    this.JwO = new e()
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
    this.JwP = new PhotoView.2(this);
    this.JwQ = new Runnable()
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
    this.JwR = new GestureDetector.SimpleOnGestureListener()
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
          PhotoView.o(PhotoView.this).ao(f2, f1);
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
                PhotoView.o(PhotoView.this).kg((int)PhotoView.c(PhotoView.this), (int)f1);
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
              localh.asz = i;
              if (f2 <= 0.0F) {
                break label691;
              }
              f1 = Math.abs(PhotoView.p(localh.JwT).left);
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
              localh.asA = i;
              if (f3 <= 0.0F) {
                break label745;
              }
              f1 = Math.abs(PhotoView.p(localh.JwT).top);
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
              localOverScroller = localh.sUk;
              i2 = localh.asz;
              i3 = localh.asA;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.JwT) * 2) {
                break label789;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.JwT) * 2) {
                break label802;
              }
            }
            label773:
            label779:
            label786:
            label789:
            label802:
            for (int i = 0;; i = PhotoView.G(localh.JwT))
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
              f1 = PhotoView.p(localh.JwT).right - PhotoView.q(localh.JwT).right;
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
              f1 = PhotoView.p(localh.JwT).bottom - PhotoView.q(localh.JwT).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.JwT);
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
        if (PhotoView.this.cb(paramAnonymousFloat1))
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
          if (PhotoView.this.cc(paramAnonymousFloat2)) {
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
    this.JwS = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.Jwd = 0;
    this.Jwe = 0;
    this.Jwf = 0;
    this.Jwg = 500;
    this.HBo = new Matrix();
    this.Jwh = new Matrix();
    this.Jwi = new Matrix();
    this.vt = new Matrix();
    this.cBX = false;
    this.Jwq = false;
    this.cEY = 1.0F;
    this.sUm = new RectF();
    this.JwB = new RectF();
    this.JwC = new RectF();
    this.cEK = new RectF();
    this.JwD = new RectF();
    this.JwE = new PointF();
    this.JwF = new PointF();
    this.JwG = new PointF();
    this.JwH = new h();
    this.JwO = new e()
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
    this.JwP = new PhotoView.2(this);
    this.JwQ = new Runnable()
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
    this.JwR = new GestureDetector.SimpleOnGestureListener()
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
          PhotoView.o(PhotoView.this).ao(f2, f1);
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
                PhotoView.o(PhotoView.this).kg((int)PhotoView.c(PhotoView.this), (int)f1);
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
              localh.asz = i;
              if (f2 <= 0.0F) {
                break label691;
              }
              f1 = Math.abs(PhotoView.p(localh.JwT).left);
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
              localh.asA = i;
              if (f3 <= 0.0F) {
                break label745;
              }
              f1 = Math.abs(PhotoView.p(localh.JwT).top);
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
              localOverScroller = localh.sUk;
              i2 = localh.asz;
              i3 = localh.asA;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.G(localh.JwT) * 2) {
                break label789;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.G(localh.JwT) * 2) {
                break label802;
              }
            }
            label773:
            label779:
            label786:
            label789:
            label802:
            for (int i = 0;; i = PhotoView.G(localh.JwT))
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
              f1 = PhotoView.p(localh.JwT).right - PhotoView.q(localh.JwT).right;
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
              f1 = PhotoView.p(localh.JwT).bottom - PhotoView.q(localh.JwT).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.G(localh.JwT);
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
        if (PhotoView.this.cb(paramAnonymousFloat1))
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
          if (PhotoView.this.cc(paramAnonymousFloat2)) {
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
    this.JwS = new Rect();
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
    if (this.cqf)
    {
      reset();
      this.JwS.set(paramInfo.JwS);
      Info localInfo = getInfo();
      float f1 = paramInfo.JwC.width() / localInfo.JwC.width();
      float f2 = paramInfo.JwC.height() / localInfo.JwC.height();
      if (f1 < f2)
      {
        f2 = paramInfo.mgi.left + paramInfo.mgi.width() / 2.0F;
        float f3 = paramInfo.mgi.top + paramInfo.mgi.height() / 2.0F;
        float f4 = localInfo.mgi.left + localInfo.mgi.width() / 2.0F;
        float f5 = localInfo.mgi.top;
        f5 = localInfo.mgi.height() / 2.0F + f5;
        this.Jwh.reset();
        this.Jwh.postTranslate(f2 - f4, f3 - f5);
        this.Jwh.postScale(f1, f1, f2, f3);
        this.Jwh.postRotate(paramInfo.Jww, f2, f3);
        fyN();
        this.JwF.set(f2, f3);
        this.JwG.set(f2, f3);
        this.JwH.kf((int)-(f2 - f4), (int)-(f3 - f5));
        this.JwH.ao(f1, 1.0F);
        this.JwH.kg((int)paramInfo.Jww, 0);
        if ((paramInfo.sUm.width() < paramInfo.JwC.width()) || (paramInfo.sUm.height() < paramInfo.JwC.height()))
        {
          f2 = paramInfo.sUm.width() / paramInfo.JwC.width();
          f3 = paramInfo.sUm.height() / paramInfo.JwC.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.Jwl != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.JwH.a(f1, f2, 1.0F - f1, 1.0F - f2, this.Jwb / 3, paramInfo);
        this.vt.setScale(f1, f2, (this.JwC.left + this.JwC.right) / 2.0F, paramInfo.fyO());
        this.vt.mapRect(this.JwH.Jxe, this.JwC);
        this.JwI = this.JwH.Jxe;
        this.JwH.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.Jwl == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.JwJ = paramInfo;
    this.JwK = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(164302);
    this.Jwi = parami.Jxi;
    this.Jwh = parami.Jxh;
    this.HBo = parami.Jxj;
    this.vt = parami.pP;
    this.Jwz = (parami.Jxk.width() / 2.0F);
    this.JwA = (parami.Jxk.height() / 2.0F);
    if (!this.sUm.isEmpty())
    {
      parami.wzl.set(this.sUm);
      parami.Jxo = this.JwE;
    }
    this.sUm = parami.wzl;
    this.JwB = parami.Jxk;
    this.JwC = parami.Jxl;
    this.cEK = parami.Jxm;
    this.JwD = parami.Jxn;
    this.JwE = parami.Jxo;
    this.JwF = parami.Jxp;
    this.JwG = parami.Jxq;
    AppMethodBeat.o(164302);
  }
  
  private void fyE()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.Jwn)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.Jwo)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.JwI != null) {
      this.JwI.setEmpty();
    }
    this.HBo.reset();
    this.Jwh.reset();
    this.Jwi.reset();
    this.vt.reset();
    this.Jwr = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = H(localDrawable);
    int m = I(localDrawable);
    this.JwB.set(0.0F, 0.0F, k, m);
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
        this.HBo.reset();
        this.HBo.postTranslate(n, i1);
        this.HBo.postScale(f1, f1, this.JwE.x, this.JwE.y);
        this.HBo.mapRect(this.JwB);
        this.Jwz = (this.JwB.width() / 2.0F);
        this.JwA = (this.JwB.height() / 2.0F);
        this.JwF.set(this.JwE);
        this.JwG.set(this.JwF);
        fyN();
        switch (PhotoView.5.yw[this.Jwl.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.cqf = true;
        if ((this.JwJ != null) && (System.currentTimeMillis() - this.JwK < this.Jwg)) {
          a(this.JwJ);
        }
        this.JwJ = null;
        if (this.JwN != null)
        {
          a(this.JwN);
          setImageMatrix(this.Jwi);
          this.JwN = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        fyF();
        continue;
        fyG();
        continue;
        fyH();
        continue;
        fyI();
        continue;
        fyJ();
        continue;
        fyK();
        continue;
        fyL();
      }
    }
  }
  
  private void fyF()
  {
    AppMethodBeat.i(164293);
    if (!this.Jwn)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.Jwo)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = H(localDrawable);
    int j = I(localDrawable);
    float f1;
    float f2;
    if ((i > this.sUm.width()) || (j > this.sUm.height()))
    {
      f1 = i / this.JwC.width();
      f2 = j / this.JwC.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.cEY = f1;
      this.Jwh.postScale(this.cEY, this.cEY, this.JwE.x, this.JwE.y);
      fyN();
      fyM();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void fyG()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.JwC.width() < this.sUm.width()) || (this.JwC.height() < this.sUm.height()))
    {
      f1 = this.sUm.width() / this.JwC.width();
      f2 = this.sUm.height() / this.JwC.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cEY = f1;
      this.Jwh.postScale(this.cEY, this.cEY, this.JwE.x, this.JwE.y);
      fyN();
      fyM();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fyH()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.JwC.width() > this.sUm.width()) || (this.JwC.height() > this.sUm.height()))
    {
      f1 = this.sUm.width() / this.JwC.width();
      f2 = this.sUm.height() / this.JwC.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.cEY = f1;
      this.Jwh.postScale(this.cEY, this.cEY, this.JwE.x, this.JwE.y);
      fyN();
      fyM();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void fyI()
  {
    AppMethodBeat.i(164296);
    if (this.JwC.width() < this.sUm.width())
    {
      this.cEY = (this.sUm.width() / this.JwC.width());
      this.Jwh.postScale(this.cEY, this.cEY, this.JwE.x, this.JwE.y);
      fyN();
      fyM();
    }
    AppMethodBeat.o(164296);
  }
  
  private void fyJ()
  {
    AppMethodBeat.i(164297);
    fyI();
    float f = -this.JwC.top;
    this.Jwh.postTranslate(0.0F, f);
    fyN();
    fyM();
    this.Jwy = ((int)(f + this.Jwy));
    AppMethodBeat.o(164297);
  }
  
  private void fyK()
  {
    AppMethodBeat.i(164298);
    fyI();
    float f = this.sUm.bottom - this.JwC.bottom;
    this.Jwy = ((int)(this.Jwy + f));
    this.Jwh.postTranslate(0.0F, f);
    fyN();
    fyM();
    AppMethodBeat.o(164298);
  }
  
  private void fyL()
  {
    AppMethodBeat.i(164299);
    float f1 = this.sUm.width() / this.JwC.width();
    float f2 = this.sUm.height() / this.JwC.height();
    this.Jwh.postScale(f1, f2, this.JwE.x, this.JwE.y);
    fyN();
    fyM();
    AppMethodBeat.o(164299);
  }
  
  private void fyM()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = H(localDrawable);
    int j = I(localDrawable);
    this.JwB.set(0.0F, 0.0F, i, j);
    this.HBo.set(this.Jwi);
    this.HBo.mapRect(this.JwB);
    this.Jwz = (this.JwB.width() / 2.0F);
    this.JwA = (this.JwB.height() / 2.0F);
    this.cEY = 1.0F;
    this.Jwx = 0;
    this.Jwy = 0;
    this.Jwh.reset();
    AppMethodBeat.o(164300);
  }
  
  private void fyN()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.Jwi.set(this.HBo);
    this.Jwi.postConcat(this.Jwh);
    setImageMatrix(this.Jwi);
    this.Jwh.mapRect(this.JwC, this.JwB);
    if (this.JwC.width() > this.sUm.width())
    {
      bool1 = true;
      this.Jwt = bool1;
      if (this.JwC.height() <= this.sUm.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Jwu = bool1;
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
    if (this.Jwl == null) {
      this.Jwl = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.Jwj = new f(this.JwO);
    this.NL = new GestureDetector(getContext(), this.JwR);
    this.Jwk = new ScaleGestureDetector(getContext(), this.JwP);
    float f = getResources().getDisplayMetrics().density;
    this.Jwd = ((int)(f * 30.0F));
    this.Jwe = ((int)(f * 30.0F));
    this.Jwf = ((int)(f * 140.0F));
    this.Jwa = 35;
    this.Jwb = 200;
    this.Jwc = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void j(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.sUm.width())
    {
      if (l(paramRectF)) {
        break label275;
      }
      i = -(int)((this.sUm.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.sUm.height()) {
        if (!k(paramRectF)) {
          j = -(int)((this.sUm.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.JwH.sUk.isFinished()) {
            this.JwH.sUk.abortAnimation();
          }
          this.JwH.kf(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.sUm.left)
        {
          i = (int)(paramRectF.left - this.sUm.left);
          break;
        }
        if (paramRectF.right >= this.sUm.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.sUm.right);
        break;
        if (paramRectF.top > this.sUm.top) {
          j = (int)(paramRectF.top - this.sUm.top);
        } else if (paramRectF.bottom < this.sUm.bottom) {
          j = (int)(paramRectF.bottom - this.sUm.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean k(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.sUm.height() - paramRectF.height()) / 2.0F) < 1.0F)
    {
      AppMethodBeat.o(164309);
      return true;
    }
    AppMethodBeat.o(164309);
    return false;
  }
  
  private boolean l(RectF paramRectF)
  {
    AppMethodBeat.i(164310);
    if (Math.abs(Math.round(paramRectF.left) - (this.sUm.width() - paramRectF.width()) / 2.0F) < 1.0F)
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
    this.Jwh.reset();
    fyN();
    this.cEY = 1.0F;
    this.Jwx = 0;
    this.Jwy = 0;
    AppMethodBeat.o(164317);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(164313);
    if (this.Jwm)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = cb(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.Jwm)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = cc(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public final boolean cb(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.JwC.width() <= this.sUm.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.JwC.left) - paramFloat >= this.sUm.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.JwC.right) - paramFloat <= this.sUm.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean cc(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.JwC.height() <= this.sUm.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.JwC.top) - paramFloat >= this.sUm.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.JwC.bottom) - paramFloat <= this.sUm.bottom))
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
    if (this.JwI != null) {
      paramCanvas.clipRect(this.JwI);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public int getAnimaDuring()
  {
    return this.Jwb;
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
    Rect localRect1 = this.JwS;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.JwC.left, arrayOfInt[1] + (int)this.JwC.top, arrayOfInt[0] + (int)this.JwC.right, arrayOfInt[1] + (int)this.JwC.bottom);
    localObject = new Info((Rect)localObject, this.JwC, this.sUm, this.JwB, this.JwE, this.cEY, this.Jww, this.Jwl, this.JwS);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.Jwc;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.Jwn)
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
      if (this.Jbz)
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
    ac.i("PhotoView", "[onSizeChanged] w:%s, h:%s, oldw:%s, oldh:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.sUm.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.JwE.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.Jwo)
    {
      this.Jwo = true;
      fyE();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.cBX)
    {
      this.JwI = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.Jwm = true;
      }
      this.NL.onTouchEvent(paramMotionEvent);
      f localf;
      if (this.Jwq) {
        localf = this.Jwj;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.Jwk.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.JwH.isRunning))
        {
          if ((this.Jws) || (this.Jww % 90.0F != 0.0F))
          {
            f2 = (int)(this.Jww / 90.0F) * 90;
            f3 = this.Jww % 90.0F;
            if (f3 <= 45.0F) {
              break label563;
            }
            f1 = f2 + 90.0F;
            label189:
            this.JwH.kg((int)this.Jww, (int)f1);
            this.Jww = f1;
          }
          f1 = this.cEY;
          if (this.cEY >= 1.0F) {
            break label587;
          }
          this.JwH.ao(this.cEY, 1.0F);
          f1 = 1.0F;
        }
        break;
      }
      for (;;)
      {
        f2 = this.JwC.left + this.JwC.width() / 2.0F;
        f3 = this.JwC.top + this.JwC.height() / 2.0F;
        this.JwF.set(f2, f3);
        this.JwG.set(f2, f3);
        this.Jwx = 0;
        this.Jwy = 0;
        this.vt.reset();
        this.vt.postTranslate(-this.JwB.left, -this.JwB.top);
        this.vt.postTranslate(f2 - this.Jwz, f3 - this.JwA);
        this.vt.postScale(f1, f1, f2, f3);
        this.vt.postRotate(this.Jww, f2, f3);
        this.vt.mapRect(this.cEK, this.JwB);
        j(this.cEK);
        this.JwH.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        localf.JwW = localf.al(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        localf.JwX = localf.al(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(localf.JwX)) - Math.toDegrees(Math.atan(localf.JwW));
        if (Math.abs(d) <= 120.0D) {
          localf.JwV.q((float)d, (localf.x2 + localf.x1) / 2.0F, (localf.y2 + localf.y1) / 2.0F);
        }
        localf.JwW = localf.JwX;
        break;
        label563:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label189;
        }
        f1 = f2 - 90.0F;
        break label189;
        label587:
        if (this.cEY > this.Jwc)
        {
          f1 = this.Jwc;
          this.JwH.ao(this.cEY, this.Jwc);
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
    this.Jbz = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.Jwb = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.JwS);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.Jwn = false;
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
    if (!this.Jwn) {
      this.Jwn = true;
    }
    fyE();
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
    this.JwH.Jxf.JwU = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.Jwg = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.Jwc = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.gst = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.JwM = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.Jwl)
    {
      this.Jwl = paramScaleType;
      if (this.cqf) {
        fyE();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    RectF JwB;
    RectF JwC;
    PointF JwE;
    Rect JwS;
    ImageView.ScaleType Jwl;
    float Jww;
    float cEY;
    public RectF mgi;
    RectF sUm;
    
    static
    {
      AppMethodBeat.i(164266);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(164266);
    }
    
    public Info(Rect paramRect1, RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, PointF paramPointF, float paramFloat1, float paramFloat2, ImageView.ScaleType paramScaleType, Rect paramRect2)
    {
      AppMethodBeat.i(164262);
      this.mgi = new RectF();
      this.JwC = new RectF();
      this.sUm = new RectF();
      this.JwB = new RectF();
      this.JwE = new PointF();
      this.JwS = new Rect();
      this.mgi.set(paramRect1);
      this.JwC.set(paramRectF1);
      this.sUm.set(paramRectF2);
      this.cEY = paramFloat1;
      this.Jwl = paramScaleType;
      this.Jww = paramFloat2;
      this.JwB.set(paramRectF3);
      this.JwE.set(paramPointF);
      this.JwS.set(paramRect2);
      AppMethodBeat.o(164262);
    }
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(164265);
      this.mgi = new RectF();
      this.JwC = new RectF();
      this.sUm = new RectF();
      this.JwB = new RectF();
      this.JwE = new PointF();
      this.JwS = new Rect();
      this.mgi = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.JwC = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.sUm = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.JwB = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
      this.JwE = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
      this.JwS = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
      this.cEY = paramParcel.readFloat();
      this.Jww = paramParcel.readFloat();
      int i = paramParcel.readInt();
      if (i == -1) {}
      for (paramParcel = null;; paramParcel = ImageView.ScaleType.values()[i])
      {
        this.Jwl = paramParcel;
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
      String str = "Info{mRect=" + this.mgi + ", mImgRect=" + this.JwC + ", mWidgetRect=" + this.sUm + ", mBaseRect=" + this.JwB + ", mScale=" + this.cEY + '}';
      AppMethodBeat.o(164263);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(164264);
      paramParcel.writeParcelable(this.mgi, paramInt);
      paramParcel.writeParcelable(this.JwC, paramInt);
      paramParcel.writeParcelable(this.sUm, paramInt);
      paramParcel.writeParcelable(this.JwB, paramInt);
      paramParcel.writeParcelable(this.JwE, paramInt);
      paramParcel.writeParcelable(this.JwS, paramInt);
      paramParcel.writeFloat(this.cEY);
      paramParcel.writeFloat(this.Jww);
      if (this.Jwl == null) {}
      for (paramInt = -1;; paramInt = this.Jwl.ordinal())
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(164264);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract float fyO();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float fyO()
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
    
    public final float fyO()
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
    PhotoView.e JwV;
    float JwW;
    float JwX;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.JwV = parame;
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
    
    public final float fyO()
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
    OverScroller JwY;
    Scroller JwZ;
    Scroller Jxa;
    PhotoView.a Jxb;
    int Jxc;
    int Jxd;
    RectF Jxe;
    PhotoView.c Jxf;
    int asA;
    int asz;
    boolean isRunning;
    OverScroller sUk;
    Scroller zlU;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.Jxe = new RectF();
      this.Jxf = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.JwY = new OverScroller(PhotoView.this, this.Jxf);
      this.zlU = new Scroller(PhotoView.this, this.Jxf);
      this.sUk = new OverScroller(PhotoView.this, this.Jxf);
      this.JwZ = new Scroller(PhotoView.this, this.Jxf);
      this.Jxa = new Scroller(PhotoView.this, this.Jxf);
      AppMethodBeat.o(164273);
    }
    
    private void fyP()
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
    
    private void fyQ()
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
      this.JwZ.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.Jxb = parama;
      AppMethodBeat.o(164276);
    }
    
    final void ao(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.zlU.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void kf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.Jxc = 0;
      this.Jxd = 0;
      this.JwY.startScroll(0, 0, paramInt1, paramInt2, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void kg(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.Jxa.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.F(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.zlU.computeScrollOffset()) {
        PhotoView.c(PhotoView.this, this.zlU.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.JwY.computeScrollOffset())
        {
          i = this.JwY.getCurrX();
          m = this.Jxc;
          n = this.JwY.getCurrY();
          i1 = this.Jxd;
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          this.Jxc = this.JwY.getCurrX();
          this.Jxd = this.JwY.getCurrY();
          i = 0;
        }
        if (this.sUk.computeScrollOffset())
        {
          i = this.sUk.getCurrX();
          m = this.asz;
          n = this.sUk.getCurrY();
          i1 = this.asA;
          this.asz = this.sUk.getCurrX();
          this.asA = this.sUk.getCurrY();
          PhotoView.a(PhotoView.this, i - m + PhotoView.r(PhotoView.this));
          PhotoView.b(PhotoView.this, n - i1 + PhotoView.v(PhotoView.this));
          i = 0;
        }
        if (this.Jxa.computeScrollOffset())
        {
          PhotoView.b(PhotoView.this, this.Jxa.getCurrX());
          i = 0;
        }
        if ((this.JwZ.computeScrollOffset()) || (PhotoView.H(PhotoView.this) != null))
        {
          float f1 = this.JwZ.getCurrX() / 10000.0F;
          float f2 = this.JwZ.getCurrY() / 10000.0F;
          PhotoView.A(PhotoView.this).setScale(f1, f2, (PhotoView.p(PhotoView.this).left + PhotoView.p(PhotoView.this).right) / 2.0F, this.Jxb.fyO());
          PhotoView.A(PhotoView.this).mapRect(this.Jxe, PhotoView.p(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.Jxe.left = PhotoView.q(PhotoView.this).left;
            this.Jxe.right = PhotoView.q(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.Jxe.top = PhotoView.q(PhotoView.this).top;
            this.Jxe.bottom = PhotoView.q(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.Jxe);
        }
        if (i == 0)
        {
          fyP();
          fyQ();
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
            fyP();
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
      fyQ();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.JwY.abortAnimation();
      this.zlU.abortAnimation();
      this.sUk.abortAnimation();
      this.Jxa.abortAnimation();
      this.isRunning = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i
  {
    Matrix Jxh;
    public Matrix Jxi;
    Matrix Jxj;
    RectF Jxk;
    public RectF Jxl;
    RectF Jxm;
    RectF Jxn;
    PointF Jxo;
    PointF Jxp;
    PointF Jxq;
    Matrix pP;
    public RectF wzl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */