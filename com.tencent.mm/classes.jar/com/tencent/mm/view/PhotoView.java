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
  private RectF HRw;
  private Matrix adVp;
  private boolean afUH;
  private float agHA;
  private int agHB;
  private int agHC;
  private int agHD;
  private int agHE;
  private Matrix agHF;
  private Matrix agHG;
  private f agHH;
  private ScaleGestureDetector agHI;
  private ImageView.ScaleType agHJ;
  private boolean agHK;
  private boolean agHL;
  private boolean agHM;
  private boolean agHN;
  private boolean agHO;
  private boolean agHP;
  private boolean agHQ;
  private boolean agHR;
  private boolean agHS;
  private float agHT;
  private float agHU;
  private int agHV;
  private int agHW;
  private float agHX;
  private float agHY;
  private RectF agHZ;
  private int agHy;
  private int agHz;
  private RectF agIa;
  private RectF agIb;
  private PointF agIc;
  private PointF agId;
  private PointF agIe;
  private h agIf;
  private RectF agIg;
  private PhotoView.Info agIh;
  private long agIi;
  private Runnable agIj;
  private View.OnLongClickListener agIk;
  private i agIl;
  private e agIm;
  private ScaleGestureDetector.OnScaleGestureListener agIn;
  private Runnable agIo;
  private GestureDetector.OnGestureListener agIp;
  private Rect agIq;
  private GestureDetector bth;
  private Matrix ciC;
  private boolean egk;
  private RectF hca;
  private float hco;
  private boolean isInit;
  private View.OnClickListener mWW;
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164283);
    this.agHB = 0;
    this.agHC = 0;
    this.agHD = 0;
    this.agHE = 500;
    this.adVp = new Matrix();
    this.agHF = new Matrix();
    this.agHG = new Matrix();
    this.ciC = new Matrix();
    this.egk = false;
    this.agHO = false;
    this.hco = 1.0F;
    this.HRw = new RectF();
    this.agHZ = new RectF();
    this.agIa = new RectF();
    this.hca = new RectF();
    this.agIb = new RectF();
    this.agIc = new PointF();
    this.agId = new PointF();
    this.agIe = new PointF();
    this.agIf = new h();
    this.agIm = new e()
    {
      public final void B(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(164250);
        PhotoView.a(PhotoView.this, paramAnonymousFloat1);
        if (PhotoView.a(PhotoView.this))
        {
          PhotoView.b(PhotoView.this, paramAnonymousFloat1);
          PhotoView.b(PhotoView.this).postRotate(paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousFloat3);
          AppMethodBeat.o(164250);
          return;
        }
        if (Math.abs(PhotoView.c(PhotoView.this)) >= PhotoView.d(PhotoView.this))
        {
          PhotoView.a(PhotoView.this, true);
          PhotoView.e(PhotoView.this);
        }
        AppMethodBeat.o(164250);
      }
    };
    this.agIn = new PhotoView.2(this);
    this.agIo = new PhotoView.3(this);
    this.agIp = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235096);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(235096);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        PhotoView.n(PhotoView.this).stop();
        float f1 = PhotoView.o(PhotoView.this).left + PhotoView.o(PhotoView.this).width() / 2.0F;
        float f2 = PhotoView.o(PhotoView.this).top + PhotoView.o(PhotoView.this).height() / 2.0F;
        PhotoView.u(PhotoView.this).set(f1, f2);
        PhotoView.v(PhotoView.this).set(f1, f2);
        PhotoView.w(PhotoView.this);
        PhotoView.x(PhotoView.this);
        if (PhotoView.y(PhotoView.this))
        {
          f2 = PhotoView.z(PhotoView.this);
          f1 = 1.0F;
          PhotoView.B(PhotoView.this).reset();
          PhotoView.B(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this).left, -PhotoView.C(PhotoView.this).top);
          PhotoView.B(PhotoView.this).postTranslate(PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
          PhotoView.B(PhotoView.this).postTranslate(-PhotoView.D(PhotoView.this), -PhotoView.E(PhotoView.this));
          PhotoView.B(PhotoView.this).postRotate(PhotoView.q(PhotoView.this), PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
          PhotoView.B(PhotoView.this).postScale(f1, f1, PhotoView.u(PhotoView.this).x, PhotoView.u(PhotoView.this).y);
          PhotoView.B(PhotoView.this).postTranslate(PhotoView.F(PhotoView.this), PhotoView.G(PhotoView.this));
          PhotoView.B(PhotoView.this).mapRect(PhotoView.H(PhotoView.this), PhotoView.C(PhotoView.this));
          PhotoView.a(PhotoView.this, PhotoView.H(PhotoView.this));
          paramAnonymousMotionEvent = PhotoView.this;
          if (PhotoView.y(PhotoView.this)) {
            break label497;
          }
        }
        label497:
        for (boolean bool = true;; bool = false)
        {
          PhotoView.c(paramAnonymousMotionEvent, bool);
          PhotoView.n(PhotoView.this).bp(f2, f1);
          PhotoView.n(PhotoView.this).start();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(164258);
          return false;
          f2 = PhotoView.z(PhotoView.this);
          f1 = PhotoView.A(PhotoView.this);
          PhotoView.u(PhotoView.this).set(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
          break;
        }
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164254);
        PhotoView.b(PhotoView.this, false);
        PhotoView.i(PhotoView.this);
        PhotoView.a(PhotoView.this, false);
        PhotoView.this.removeCallbacks(PhotoView.j(PhotoView.this));
        AppMethodBeat.o(164254);
        return false;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164255);
        if (PhotoView.k(PhotoView.this))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((!PhotoView.l(PhotoView.this)) && (!PhotoView.m(PhotoView.this)))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if (PhotoView.n(PhotoView.this).Uz)
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((Math.round(PhotoView.o(PhotoView.this).left) >= PhotoView.p(PhotoView.this).left) || (Math.round(PhotoView.o(PhotoView.this).right) <= PhotoView.p(PhotoView.this).right)) {}
        for (float f2 = 0.0F;; f2 = paramAnonymousFloat1)
        {
          if ((Math.round(PhotoView.o(PhotoView.this).top) >= PhotoView.p(PhotoView.this).top) || (Math.round(PhotoView.o(PhotoView.this).bottom) <= PhotoView.p(PhotoView.this).bottom)) {}
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
            if ((PhotoView.a(PhotoView.this)) || (PhotoView.q(PhotoView.this) % 90.0F != 0.0F))
            {
              f4 = (int)(PhotoView.q(PhotoView.this) / 90.0F) * 90;
              f5 = PhotoView.q(PhotoView.this) % 90.0F;
              if (f5 > 45.0F)
              {
                f1 = f4 + 90.0F;
                PhotoView.n(PhotoView.this).po((int)PhotoView.q(PhotoView.this), (int)f1);
                PhotoView.d(PhotoView.this, f1);
              }
            }
            else
            {
              PhotoView.a(PhotoView.this, PhotoView.o(PhotoView.this));
              localh = PhotoView.n(PhotoView.this);
              if (f2 >= 0.0F) {
                break label686;
              }
              i = 2147483647;
              localh.caG = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.o(localh.agIr).left);
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
              localh.caH = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.o(localh.agIr).top);
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
              localOverScroller = localh.HRu;
              i2 = localh.caG;
              i3 = localh.caH;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.J(localh.agIr) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.J(localh.agIr) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.J(localh.agIr))
            {
              localOverScroller.fling(i2, i3, i4, i5, j, k, m, n, i1, i);
              PhotoView.n(PhotoView.this).start();
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
              f1 = PhotoView.o(localh.agIr).right - PhotoView.p(localh.agIr).right;
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
              f1 = PhotoView.o(localh.agIr).bottom - PhotoView.p(localh.agIr).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.J(localh.agIr);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        if (PhotoView.h(PhotoView.this) != null) {
          PhotoView.h(PhotoView.this).onLongClick(PhotoView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(164253);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164256);
        if (PhotoView.n(PhotoView.this).Uz) {
          PhotoView.n(PhotoView.this).stop();
        }
        if (PhotoView.this.eu(paramAnonymousFloat1))
        {
          if ((paramAnonymousFloat1 >= 0.0F) || (PhotoView.o(PhotoView.this).left - paramAnonymousFloat1 <= PhotoView.p(PhotoView.this).left)) {
            break label791;
          }
          paramAnonymousFloat1 = PhotoView.o(PhotoView.this).left;
        }
        label785:
        label791:
        for (;;)
        {
          float f1 = paramAnonymousFloat1;
          if (paramAnonymousFloat1 > 0.0F)
          {
            f1 = paramAnonymousFloat1;
            if (PhotoView.o(PhotoView.this).right - paramAnonymousFloat1 < PhotoView.p(PhotoView.this).right) {
              f1 = PhotoView.o(PhotoView.this).right - PhotoView.p(PhotoView.this).right;
            }
          }
          PhotoView.b(PhotoView.this).postTranslate(-f1, 0.0F);
          PhotoView.e(PhotoView.this, f1);
          if (PhotoView.this.ev(paramAnonymousFloat2)) {
            if ((paramAnonymousFloat2 >= 0.0F) || (PhotoView.o(PhotoView.this).top - paramAnonymousFloat2 <= PhotoView.p(PhotoView.this).top)) {
              break label785;
            }
          }
          for (paramAnonymousFloat1 = PhotoView.o(PhotoView.this).top;; paramAnonymousFloat1 = paramAnonymousFloat2)
          {
            paramAnonymousFloat2 = paramAnonymousFloat1;
            if (paramAnonymousFloat1 > 0.0F)
            {
              paramAnonymousFloat2 = paramAnonymousFloat1;
              if (PhotoView.o(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.p(PhotoView.this).bottom) {
                paramAnonymousFloat2 = PhotoView.o(PhotoView.this).bottom - PhotoView.p(PhotoView.this).bottom;
              }
            }
            PhotoView.b(PhotoView.this).postTranslate(0.0F, -paramAnonymousFloat2);
            PhotoView.f(PhotoView.this, paramAnonymousFloat2);
            for (;;)
            {
              PhotoView.f(PhotoView.this);
              AppMethodBeat.o(164256);
              return true;
              if ((!PhotoView.l(PhotoView.this)) && (!PhotoView.k(PhotoView.this)) && (!PhotoView.r(PhotoView.this))) {
                break;
              }
              PhotoView.s(PhotoView.this);
              float f2 = paramAnonymousFloat1;
              if (!PhotoView.k(PhotoView.this))
              {
                f1 = paramAnonymousFloat1;
                if (paramAnonymousFloat1 < 0.0F)
                {
                  f1 = paramAnonymousFloat1;
                  if (PhotoView.o(PhotoView.this).left - paramAnonymousFloat1 > PhotoView.t(PhotoView.this).left) {
                    f1 = PhotoView.a(PhotoView.this, PhotoView.o(PhotoView.this).left - PhotoView.t(PhotoView.this).left, paramAnonymousFloat1);
                  }
                }
                f2 = f1;
                if (f1 > 0.0F)
                {
                  f2 = f1;
                  if (PhotoView.o(PhotoView.this).right - f1 < PhotoView.t(PhotoView.this).right) {
                    f2 = PhotoView.a(PhotoView.this, PhotoView.o(PhotoView.this).right - PhotoView.t(PhotoView.this).right, f1);
                  }
                }
              }
              PhotoView.e(PhotoView.this, f2);
              PhotoView.b(PhotoView.this).postTranslate(-f2, 0.0F);
              PhotoView.b(PhotoView.this, true);
              break;
              if ((PhotoView.m(PhotoView.this)) || (PhotoView.r(PhotoView.this)) || (PhotoView.k(PhotoView.this)))
              {
                PhotoView.s(PhotoView.this);
                f1 = paramAnonymousFloat2;
                if (!PhotoView.k(PhotoView.this))
                {
                  paramAnonymousFloat1 = paramAnonymousFloat2;
                  if (paramAnonymousFloat2 < 0.0F)
                  {
                    paramAnonymousFloat1 = paramAnonymousFloat2;
                    if (PhotoView.o(PhotoView.this).top - paramAnonymousFloat2 > PhotoView.t(PhotoView.this).top) {
                      paramAnonymousFloat1 = PhotoView.b(PhotoView.this, PhotoView.o(PhotoView.this).top - PhotoView.t(PhotoView.this).top, paramAnonymousFloat2);
                    }
                  }
                  f1 = paramAnonymousFloat1;
                  if (paramAnonymousFloat1 > 0.0F)
                  {
                    f1 = paramAnonymousFloat1;
                    if (PhotoView.o(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.t(PhotoView.this).bottom) {
                      f1 = PhotoView.b(PhotoView.this, PhotoView.o(PhotoView.this).bottom - PhotoView.t(PhotoView.this).bottom, paramAnonymousFloat1);
                    }
                  }
                }
                PhotoView.b(PhotoView.this).postTranslate(0.0F, -f1);
                PhotoView.f(PhotoView.this, f1);
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
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        PhotoView.this.postDelayed(PhotoView.j(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.agIq = new Rect();
    init();
    AppMethodBeat.o(164283);
  }
  
  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164284);
    this.agHB = 0;
    this.agHC = 0;
    this.agHD = 0;
    this.agHE = 500;
    this.adVp = new Matrix();
    this.agHF = new Matrix();
    this.agHG = new Matrix();
    this.ciC = new Matrix();
    this.egk = false;
    this.agHO = false;
    this.hco = 1.0F;
    this.HRw = new RectF();
    this.agHZ = new RectF();
    this.agIa = new RectF();
    this.hca = new RectF();
    this.agIb = new RectF();
    this.agIc = new PointF();
    this.agId = new PointF();
    this.agIe = new PointF();
    this.agIf = new h();
    this.agIm = new e()
    {
      public final void B(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3)
      {
        AppMethodBeat.i(164250);
        PhotoView.a(PhotoView.this, paramAnonymousFloat1);
        if (PhotoView.a(PhotoView.this))
        {
          PhotoView.b(PhotoView.this, paramAnonymousFloat1);
          PhotoView.b(PhotoView.this).postRotate(paramAnonymousFloat1, paramAnonymousFloat2, paramAnonymousFloat3);
          AppMethodBeat.o(164250);
          return;
        }
        if (Math.abs(PhotoView.c(PhotoView.this)) >= PhotoView.d(PhotoView.this))
        {
          PhotoView.a(PhotoView.this, true);
          PhotoView.e(PhotoView.this);
        }
        AppMethodBeat.o(164250);
      }
    };
    this.agIn = new PhotoView.2(this);
    this.agIo = new PhotoView.3(this);
    this.agIp = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235096);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(235096);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164258);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        PhotoView.n(PhotoView.this).stop();
        float f1 = PhotoView.o(PhotoView.this).left + PhotoView.o(PhotoView.this).width() / 2.0F;
        float f2 = PhotoView.o(PhotoView.this).top + PhotoView.o(PhotoView.this).height() / 2.0F;
        PhotoView.u(PhotoView.this).set(f1, f2);
        PhotoView.v(PhotoView.this).set(f1, f2);
        PhotoView.w(PhotoView.this);
        PhotoView.x(PhotoView.this);
        if (PhotoView.y(PhotoView.this))
        {
          f2 = PhotoView.z(PhotoView.this);
          f1 = 1.0F;
          PhotoView.B(PhotoView.this).reset();
          PhotoView.B(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this).left, -PhotoView.C(PhotoView.this).top);
          PhotoView.B(PhotoView.this).postTranslate(PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
          PhotoView.B(PhotoView.this).postTranslate(-PhotoView.D(PhotoView.this), -PhotoView.E(PhotoView.this));
          PhotoView.B(PhotoView.this).postRotate(PhotoView.q(PhotoView.this), PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
          PhotoView.B(PhotoView.this).postScale(f1, f1, PhotoView.u(PhotoView.this).x, PhotoView.u(PhotoView.this).y);
          PhotoView.B(PhotoView.this).postTranslate(PhotoView.F(PhotoView.this), PhotoView.G(PhotoView.this));
          PhotoView.B(PhotoView.this).mapRect(PhotoView.H(PhotoView.this), PhotoView.C(PhotoView.this));
          PhotoView.a(PhotoView.this, PhotoView.H(PhotoView.this));
          paramAnonymousMotionEvent = PhotoView.this;
          if (PhotoView.y(PhotoView.this)) {
            break label497;
          }
        }
        label497:
        for (boolean bool = true;; bool = false)
        {
          PhotoView.c(paramAnonymousMotionEvent, bool);
          PhotoView.n(PhotoView.this).bp(f2, f1);
          PhotoView.n(PhotoView.this).start();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(164258);
          return false;
          f2 = PhotoView.z(PhotoView.this);
          f1 = PhotoView.A(PhotoView.this);
          PhotoView.u(PhotoView.this).set(paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
          break;
        }
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164254);
        PhotoView.b(PhotoView.this, false);
        PhotoView.i(PhotoView.this);
        PhotoView.a(PhotoView.this, false);
        PhotoView.this.removeCallbacks(PhotoView.j(PhotoView.this));
        AppMethodBeat.o(164254);
        return false;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164255);
        if (PhotoView.k(PhotoView.this))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((!PhotoView.l(PhotoView.this)) && (!PhotoView.m(PhotoView.this)))
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if (PhotoView.n(PhotoView.this).Uz)
        {
          AppMethodBeat.o(164255);
          return false;
        }
        if ((Math.round(PhotoView.o(PhotoView.this).left) >= PhotoView.p(PhotoView.this).left) || (Math.round(PhotoView.o(PhotoView.this).right) <= PhotoView.p(PhotoView.this).right)) {}
        for (float f2 = 0.0F;; f2 = paramAnonymousFloat1)
        {
          if ((Math.round(PhotoView.o(PhotoView.this).top) >= PhotoView.p(PhotoView.this).top) || (Math.round(PhotoView.o(PhotoView.this).bottom) <= PhotoView.p(PhotoView.this).bottom)) {}
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
            if ((PhotoView.a(PhotoView.this)) || (PhotoView.q(PhotoView.this) % 90.0F != 0.0F))
            {
              f4 = (int)(PhotoView.q(PhotoView.this) / 90.0F) * 90;
              f5 = PhotoView.q(PhotoView.this) % 90.0F;
              if (f5 > 45.0F)
              {
                f1 = f4 + 90.0F;
                PhotoView.n(PhotoView.this).po((int)PhotoView.q(PhotoView.this), (int)f1);
                PhotoView.d(PhotoView.this, f1);
              }
            }
            else
            {
              PhotoView.a(PhotoView.this, PhotoView.o(PhotoView.this));
              localh = PhotoView.n(PhotoView.this);
              if (f2 >= 0.0F) {
                break label686;
              }
              i = 2147483647;
              localh.caG = i;
              if (f2 <= 0.0F) {
                break label692;
              }
              f1 = Math.abs(PhotoView.o(localh.agIr).left);
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
              localh.caH = i;
              if (f3 <= 0.0F) {
                break label746;
              }
              f1 = Math.abs(PhotoView.o(localh.agIr).top);
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
              localOverScroller = localh.HRu;
              i2 = localh.caG;
              i3 = localh.caH;
              i4 = (int)f2;
              i5 = (int)f3;
              if (Math.abs(i1) >= PhotoView.J(localh.agIr) * 2) {
                break label790;
              }
              i1 = 0;
              label588:
              if (Math.abs(i) >= PhotoView.J(localh.agIr) * 2) {
                break label803;
              }
            }
            label774:
            label780:
            label787:
            label790:
            label803:
            for (int i = 0;; i = PhotoView.J(localh.agIr))
            {
              localOverScroller.fling(i2, i3, i4, i5, j, k, m, n, i1, i);
              PhotoView.n(PhotoView.this).start();
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
              f1 = PhotoView.o(localh.agIr).right - PhotoView.p(localh.agIr).right;
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
              f1 = PhotoView.o(localh.agIr).bottom - PhotoView.p(localh.agIr).bottom;
              break label451;
              m = 0;
              break label485;
              n = i;
              break label496;
              break label510;
              i1 = PhotoView.J(localh.agIr);
              break label588;
            }
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(164253);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        if (PhotoView.h(PhotoView.this) != null) {
          PhotoView.h(PhotoView.this).onLongClick(PhotoView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(164253);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(164256);
        if (PhotoView.n(PhotoView.this).Uz) {
          PhotoView.n(PhotoView.this).stop();
        }
        if (PhotoView.this.eu(paramAnonymousFloat1))
        {
          if ((paramAnonymousFloat1 >= 0.0F) || (PhotoView.o(PhotoView.this).left - paramAnonymousFloat1 <= PhotoView.p(PhotoView.this).left)) {
            break label791;
          }
          paramAnonymousFloat1 = PhotoView.o(PhotoView.this).left;
        }
        label785:
        label791:
        for (;;)
        {
          float f1 = paramAnonymousFloat1;
          if (paramAnonymousFloat1 > 0.0F)
          {
            f1 = paramAnonymousFloat1;
            if (PhotoView.o(PhotoView.this).right - paramAnonymousFloat1 < PhotoView.p(PhotoView.this).right) {
              f1 = PhotoView.o(PhotoView.this).right - PhotoView.p(PhotoView.this).right;
            }
          }
          PhotoView.b(PhotoView.this).postTranslate(-f1, 0.0F);
          PhotoView.e(PhotoView.this, f1);
          if (PhotoView.this.ev(paramAnonymousFloat2)) {
            if ((paramAnonymousFloat2 >= 0.0F) || (PhotoView.o(PhotoView.this).top - paramAnonymousFloat2 <= PhotoView.p(PhotoView.this).top)) {
              break label785;
            }
          }
          for (paramAnonymousFloat1 = PhotoView.o(PhotoView.this).top;; paramAnonymousFloat1 = paramAnonymousFloat2)
          {
            paramAnonymousFloat2 = paramAnonymousFloat1;
            if (paramAnonymousFloat1 > 0.0F)
            {
              paramAnonymousFloat2 = paramAnonymousFloat1;
              if (PhotoView.o(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.p(PhotoView.this).bottom) {
                paramAnonymousFloat2 = PhotoView.o(PhotoView.this).bottom - PhotoView.p(PhotoView.this).bottom;
              }
            }
            PhotoView.b(PhotoView.this).postTranslate(0.0F, -paramAnonymousFloat2);
            PhotoView.f(PhotoView.this, paramAnonymousFloat2);
            for (;;)
            {
              PhotoView.f(PhotoView.this);
              AppMethodBeat.o(164256);
              return true;
              if ((!PhotoView.l(PhotoView.this)) && (!PhotoView.k(PhotoView.this)) && (!PhotoView.r(PhotoView.this))) {
                break;
              }
              PhotoView.s(PhotoView.this);
              float f2 = paramAnonymousFloat1;
              if (!PhotoView.k(PhotoView.this))
              {
                f1 = paramAnonymousFloat1;
                if (paramAnonymousFloat1 < 0.0F)
                {
                  f1 = paramAnonymousFloat1;
                  if (PhotoView.o(PhotoView.this).left - paramAnonymousFloat1 > PhotoView.t(PhotoView.this).left) {
                    f1 = PhotoView.a(PhotoView.this, PhotoView.o(PhotoView.this).left - PhotoView.t(PhotoView.this).left, paramAnonymousFloat1);
                  }
                }
                f2 = f1;
                if (f1 > 0.0F)
                {
                  f2 = f1;
                  if (PhotoView.o(PhotoView.this).right - f1 < PhotoView.t(PhotoView.this).right) {
                    f2 = PhotoView.a(PhotoView.this, PhotoView.o(PhotoView.this).right - PhotoView.t(PhotoView.this).right, f1);
                  }
                }
              }
              PhotoView.e(PhotoView.this, f2);
              PhotoView.b(PhotoView.this).postTranslate(-f2, 0.0F);
              PhotoView.b(PhotoView.this, true);
              break;
              if ((PhotoView.m(PhotoView.this)) || (PhotoView.r(PhotoView.this)) || (PhotoView.k(PhotoView.this)))
              {
                PhotoView.s(PhotoView.this);
                f1 = paramAnonymousFloat2;
                if (!PhotoView.k(PhotoView.this))
                {
                  paramAnonymousFloat1 = paramAnonymousFloat2;
                  if (paramAnonymousFloat2 < 0.0F)
                  {
                    paramAnonymousFloat1 = paramAnonymousFloat2;
                    if (PhotoView.o(PhotoView.this).top - paramAnonymousFloat2 > PhotoView.t(PhotoView.this).top) {
                      paramAnonymousFloat1 = PhotoView.b(PhotoView.this, PhotoView.o(PhotoView.this).top - PhotoView.t(PhotoView.this).top, paramAnonymousFloat2);
                    }
                  }
                  f1 = paramAnonymousFloat1;
                  if (paramAnonymousFloat1 > 0.0F)
                  {
                    f1 = paramAnonymousFloat1;
                    if (PhotoView.o(PhotoView.this).bottom - paramAnonymousFloat1 < PhotoView.t(PhotoView.this).bottom) {
                      f1 = PhotoView.b(PhotoView.this, PhotoView.o(PhotoView.this).bottom - PhotoView.t(PhotoView.this).bottom, paramAnonymousFloat1);
                    }
                  }
                }
                PhotoView.b(PhotoView.this).postTranslate(0.0F, -f1);
                PhotoView.f(PhotoView.this, f1);
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
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        PhotoView.this.postDelayed(PhotoView.j(PhotoView.this), 250L);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/view/PhotoView$4", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(164257);
        return false;
      }
    };
    this.agIq = new Rect();
    init();
    AppMethodBeat.o(164284);
  }
  
  private static int X(Drawable paramDrawable)
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
  
  private static int Y(Drawable paramDrawable)
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
      this.agIq.set(paramInfo.agIq);
      PhotoView.Info localInfo = getInfo();
      float f1 = paramInfo.agIa.width() / localInfo.agIa.width();
      float f2 = paramInfo.agIa.height() / localInfo.agIa.height();
      if (f1 < f2)
      {
        f2 = paramInfo.ugw.left + paramInfo.ugw.width() / 2.0F;
        float f3 = paramInfo.ugw.top + paramInfo.ugw.height() / 2.0F;
        float f4 = localInfo.ugw.left + localInfo.ugw.width() / 2.0F;
        float f5 = localInfo.ugw.top;
        f5 = localInfo.ugw.height() / 2.0F + f5;
        this.agHF.reset();
        this.agHF.postTranslate(f2 - f4, f3 - f5);
        this.agHF.postScale(f1, f1, f2, f3);
        this.agHF.postRotate(paramInfo.agHU, f2, f3);
        jMA();
        this.agId.set(f2, f3);
        this.agIe.set(f2, f3);
        this.agIf.pn((int)-(f2 - f4), (int)-(f3 - f5));
        this.agIf.bp(f1, 1.0F);
        this.agIf.po((int)paramInfo.agHU, 0);
        if ((paramInfo.HRw.width() < paramInfo.agIa.width()) || (paramInfo.HRw.height() < paramInfo.agIa.height()))
        {
          f2 = paramInfo.HRw.width() / paramInfo.agIa.width();
          f3 = paramInfo.HRw.height() / paramInfo.agIa.height();
          f1 = f2;
          if (f2 > 1.0F) {
            f1 = 1.0F;
          }
          f2 = f3;
          if (f3 > 1.0F) {
            f2 = 1.0F;
          }
          if (paramInfo.agHJ != ImageView.ScaleType.FIT_START) {
            break label488;
          }
          paramInfo = new g();
        }
      }
      for (;;)
      {
        this.agIf.a(f1, f2, 1.0F - f1, 1.0F - f2, this.agHz / 3, paramInfo);
        this.ciC.setScale(f1, f2, (this.agIa.left + this.agIa.right) / 2.0F, paramInfo.jMB());
        this.ciC.mapRect(this.agIf.agID, this.agIa);
        this.agIg = this.agIf.agID;
        this.agIf.start();
        AppMethodBeat.o(164318);
        return;
        f1 = f2;
        break;
        label488:
        if (paramInfo.agHJ == ImageView.ScaleType.FIT_END) {
          paramInfo = new b();
        } else {
          paramInfo = new d();
        }
      }
    }
    this.agIh = paramInfo;
    this.agIi = System.currentTimeMillis();
    AppMethodBeat.o(164318);
  }
  
  private void init()
  {
    AppMethodBeat.i(164285);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.agHJ == null) {
      this.agHJ = ImageView.ScaleType.CENTER_INSIDE;
    }
    this.agHH = new f(this.agIm);
    this.bth = new GestureDetector(getContext(), this.agIp);
    this.agHI = new ScaleGestureDetector(getContext(), this.agIn);
    float f = getResources().getDisplayMetrics().density;
    this.agHB = ((int)(f * 30.0F));
    this.agHC = ((int)(f * 30.0F));
    this.agHD = ((int)(f * 140.0F));
    this.agHy = 35;
    this.agHz = 200;
    this.agHA = 3.0F;
    AppMethodBeat.o(164285);
  }
  
  private void jMA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(164301);
    this.agHG.set(this.adVp);
    this.agHG.postConcat(this.agHF);
    setImageMatrix(this.agHG);
    this.agHF.mapRect(this.agIa, this.agHZ);
    if (this.agIa.width() > this.HRw.width())
    {
      bool1 = true;
      this.agHR = bool1;
      if (this.agIa.height() <= this.HRw.height()) {
        break label117;
      }
    }
    label117:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.agHS = bool1;
      AppMethodBeat.o(164301);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void jMr()
  {
    float f2 = 1.0F;
    AppMethodBeat.i(164292);
    if (!this.agHL)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (!this.agHM)
    {
      AppMethodBeat.o(164292);
      return;
    }
    if (this.agIg != null) {
      this.agIg.setEmpty();
    }
    this.adVp.reset();
    this.agHF.reset();
    this.agHG.reset();
    this.ciC.reset();
    this.agHP = false;
    Drawable localDrawable = getDrawable();
    int i = getWidth();
    int j = getHeight();
    int k = X(localDrawable);
    int m = Y(localDrawable);
    this.agHZ.set(0.0F, 0.0F, k, m);
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
        this.adVp.reset();
        this.adVp.postTranslate(n, i1);
        this.adVp.postScale(f1, f1, this.agIc.x, this.agIc.y);
        this.adVp.mapRect(this.agHZ);
        this.agHX = (this.agHZ.width() / 2.0F);
        this.agHY = (this.agHZ.height() / 2.0F);
        this.agId.set(this.agIc);
        this.agIe.set(this.agId);
        jMA();
        switch (PhotoView.5.ceG[this.agHJ.ordinal()])
        {
        }
      }
      for (;;)
      {
        this.isInit = true;
        if ((this.agIh != null) && (System.currentTimeMillis() - this.agIi < this.agHE)) {
          a(this.agIh);
        }
        this.agIh = null;
        if (this.agIl != null)
        {
          setImageMatrix(this.agHG);
          this.agIl = null;
        }
        AppMethodBeat.o(164292);
        return;
        f1 = f2;
        break;
        jMs();
        continue;
        jMt();
        continue;
        jMu();
        continue;
        jMv();
        continue;
        jMw();
        continue;
        jMx();
        continue;
        jMy();
      }
    }
  }
  
  private void jMs()
  {
    AppMethodBeat.i(164293);
    if (!this.agHL)
    {
      AppMethodBeat.o(164293);
      return;
    }
    if (!this.agHM)
    {
      AppMethodBeat.o(164293);
      return;
    }
    Drawable localDrawable = getDrawable();
    int i = X(localDrawable);
    int j = Y(localDrawable);
    float f1;
    float f2;
    if ((i > this.HRw.width()) || (j > this.HRw.height()))
    {
      f1 = i / this.agIa.width();
      f2 = j / this.agIa.height();
      if (f1 <= f2) {
        break label159;
      }
    }
    for (;;)
    {
      this.hco = f1;
      this.agHF.postScale(this.hco, this.hco, this.agIc.x, this.agIc.y);
      jMA();
      jMz();
      AppMethodBeat.o(164293);
      return;
      label159:
      f1 = f2;
    }
  }
  
  private void jMt()
  {
    AppMethodBeat.i(164294);
    float f1;
    float f2;
    if ((this.agIa.width() < this.HRw.width()) || (this.agIa.height() < this.HRw.height()))
    {
      f1 = this.HRw.width() / this.agIa.width();
      f2 = this.HRw.height() / this.agIa.height();
      if (f1 <= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.hco = f1;
      this.agHF.postScale(this.hco, this.hco, this.agIc.x, this.agIc.y);
      jMA();
      jMz();
      AppMethodBeat.o(164294);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void jMu()
  {
    AppMethodBeat.i(164295);
    float f1;
    float f2;
    if ((this.agIa.width() > this.HRw.width()) || (this.agIa.height() > this.HRw.height()))
    {
      f1 = this.HRw.width() / this.agIa.width();
      f2 = this.HRw.height() / this.agIa.height();
      if (f1 >= f2) {
        break label130;
      }
    }
    for (;;)
    {
      this.hco = f1;
      this.agHF.postScale(this.hco, this.hco, this.agIc.x, this.agIc.y);
      jMA();
      jMz();
      AppMethodBeat.o(164295);
      return;
      label130:
      f1 = f2;
    }
  }
  
  private void jMv()
  {
    AppMethodBeat.i(164296);
    if (this.agIa.width() < this.HRw.width())
    {
      this.hco = (this.HRw.width() / this.agIa.width());
      this.agHF.postScale(this.hco, this.hco, this.agIc.x, this.agIc.y);
      jMA();
      jMz();
    }
    AppMethodBeat.o(164296);
  }
  
  private void jMw()
  {
    AppMethodBeat.i(164297);
    jMv();
    float f = -this.agIa.top;
    this.agHF.postTranslate(0.0F, f);
    jMA();
    jMz();
    this.agHW = ((int)(f + this.agHW));
    AppMethodBeat.o(164297);
  }
  
  private void jMx()
  {
    AppMethodBeat.i(164298);
    jMv();
    float f = this.HRw.bottom - this.agIa.bottom;
    this.agHW = ((int)(this.agHW + f));
    this.agHF.postTranslate(0.0F, f);
    jMA();
    jMz();
    AppMethodBeat.o(164298);
  }
  
  private void jMy()
  {
    AppMethodBeat.i(164299);
    float f1 = this.HRw.width() / this.agIa.width();
    float f2 = this.HRw.height() / this.agIa.height();
    this.agHF.postScale(f1, f2, this.agIc.x, this.agIc.y);
    jMA();
    jMz();
    AppMethodBeat.o(164299);
  }
  
  private void jMz()
  {
    AppMethodBeat.i(164300);
    Drawable localDrawable = getDrawable();
    int i = X(localDrawable);
    int j = Y(localDrawable);
    this.agHZ.set(0.0F, 0.0F, i, j);
    this.adVp.set(this.agHG);
    this.adVp.mapRect(this.agHZ);
    this.agHX = (this.agHZ.width() / 2.0F);
    this.agHY = (this.agHZ.height() / 2.0F);
    this.hco = 1.0F;
    this.agHV = 0;
    this.agHW = 0;
    this.agHF.reset();
    AppMethodBeat.o(164300);
  }
  
  private void n(RectF paramRectF)
  {
    int j = 0;
    AppMethodBeat.i(164308);
    int i;
    if (paramRectF.width() <= this.HRw.width())
    {
      if (p(paramRectF)) {
        break label275;
      }
      i = -(int)((this.HRw.width() - paramRectF.width()) / 2.0F - paramRectF.left);
    }
    for (;;)
    {
      if (paramRectF.height() <= this.HRw.height()) {
        if (!o(paramRectF)) {
          j = -(int)((this.HRw.height() - paramRectF.height()) / 2.0F - paramRectF.top);
        }
      }
      for (;;)
      {
        if ((i != 0) || (j != 0))
        {
          if (!this.agIf.HRu.isFinished()) {
            this.agIf.HRu.abortAnimation();
          }
          this.agIf.pn(-i, -j);
        }
        AppMethodBeat.o(164308);
        return;
        if (paramRectF.left > this.HRw.left)
        {
          i = (int)(paramRectF.left - this.HRw.left);
          break;
        }
        if (paramRectF.right >= this.HRw.right) {
          break label275;
        }
        i = (int)(paramRectF.right - this.HRw.right);
        break;
        if (paramRectF.top > this.HRw.top) {
          j = (int)(paramRectF.top - this.HRw.top);
        } else if (paramRectF.bottom < this.HRw.bottom) {
          j = (int)(paramRectF.bottom - this.HRw.bottom);
        }
      }
      label275:
      i = 0;
    }
  }
  
  private boolean o(RectF paramRectF)
  {
    AppMethodBeat.i(164309);
    if (Math.abs(Math.round(paramRectF.top) - (this.HRw.height() - paramRectF.height()) / 2.0F) < 1.0F)
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
    if (Math.abs(Math.round(paramRectF.left) - (this.HRw.width() - paramRectF.width()) / 2.0F) < 1.0F)
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
    this.agHF.reset();
    jMA();
    this.hco = 1.0F;
    this.agHV = 0;
    this.agHW = 0;
    AppMethodBeat.o(164317);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(164313);
    if (this.agHK)
    {
      AppMethodBeat.o(164313);
      return true;
    }
    boolean bool = eu(paramInt);
    AppMethodBeat.o(164313);
    return bool;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    AppMethodBeat.i(164314);
    if (this.agHK)
    {
      AppMethodBeat.o(164314);
      return true;
    }
    boolean bool = ev(paramInt);
    AppMethodBeat.o(164314);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164306);
    paramCanvas.save();
    if (this.agIg != null) {
      paramCanvas.clipRect(this.agIg);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(164306);
  }
  
  public final boolean eu(float paramFloat)
  {
    AppMethodBeat.i(164311);
    if (this.agIa.width() <= this.HRw.width())
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.agIa.left) - paramFloat >= this.HRw.left))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.agIa.right) - paramFloat <= this.HRw.right))
    {
      AppMethodBeat.o(164311);
      return false;
    }
    AppMethodBeat.o(164311);
    return true;
  }
  
  public final boolean ev(float paramFloat)
  {
    AppMethodBeat.i(164312);
    if (this.agIa.height() <= this.HRw.height())
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat < 0.0F) && (Math.round(this.agIa.top) - paramFloat >= this.HRw.top))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    if ((paramFloat > 0.0F) && (Math.round(this.agIa.bottom) - paramFloat <= this.HRw.bottom))
    {
      AppMethodBeat.o(164312);
      return false;
    }
    AppMethodBeat.o(164312);
    return true;
  }
  
  public int getAnimaDuring()
  {
    return this.agHz;
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
    Rect localRect1 = this.agIq;
    Rect localRect2 = new Rect();
    getGlobalVisibleRect(localRect2);
    if ((!localRect1.isEmpty()) && (localRect2.bottom - getHeight() < localRect1.top)) {
      localRect2.top = (localRect2.bottom - getHeight());
    }
    arrayOfInt[0] = localRect2.left;
    arrayOfInt[1] = localRect2.top;
    arrayOfInt[0] = ((int)(arrayOfInt[0] + 0.5F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + 0.5F));
    ((Rect)localObject).set(arrayOfInt[0] + (int)this.agIa.left, arrayOfInt[1] + (int)this.agIa.top, arrayOfInt[0] + (int)this.agIa.right, arrayOfInt[1] + (int)this.agIa.bottom);
    localObject = new PhotoView.Info((Rect)localObject, this.agIa, this.HRw, this.agHZ, this.agIc, this.hco, this.agHU, this.agHJ, this.agIq);
    AppMethodBeat.o(164315);
    return localObject;
  }
  
  public float getMaxScale()
  {
    return this.agHA;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(164303);
    if (!this.agHL)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(164303);
      return;
    }
    Object localObject = getDrawable();
    int j = X((Drawable)localObject);
    int i = Y((Drawable)localObject);
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
      if (this.afUH)
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
    this.HRw.set(0.0F, 0.0F, paramInt1, paramInt2);
    this.agIc.set(paramInt1 / 2, paramInt2 / 2);
    if (!this.agHM)
    {
      this.agHM = true;
      jMr();
    }
    AppMethodBeat.o(164305);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164307);
    if (this.egk)
    {
      this.agIg = null;
      int i = paramMotionEvent.getActionMasked();
      if (paramMotionEvent.getPointerCount() >= 2) {
        this.agHK = true;
      }
      Object localObject = this.bth;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/view/PhotoView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.agHO) {
        localObject = this.agHH;
      }
      float f2;
      float f3;
      float f1;
      switch (paramMotionEvent.getActionMasked())
      {
      case 3: 
      case 4: 
      default: 
        this.agHI.onTouchEvent(paramMotionEvent);
        if (((i == 1) || (i == 3)) && (!this.agIf.Uz))
        {
          if ((this.agHQ) || (this.agHU % 90.0F != 0.0F))
          {
            f2 = (int)(this.agHU / 90.0F) * 90;
            f3 = this.agHU % 90.0F;
            if (f3 <= 45.0F) {
              break label639;
            }
            f1 = f2 + 90.0F;
            label265:
            this.agIf.po((int)this.agHU, (int)f1);
            this.agHU = f1;
          }
          f1 = this.hco;
          if (this.hco >= 1.0F) {
            break label663;
          }
          f1 = 1.0F;
          this.agIf.bp(this.hco, 1.0F);
        }
        break;
      }
      for (;;)
      {
        f2 = this.agIa.left + this.agIa.width() / 2.0F;
        f3 = this.agIa.top + this.agIa.height() / 2.0F;
        this.agId.set(f2, f3);
        this.agIe.set(f2, f3);
        this.agHV = 0;
        this.agHW = 0;
        this.ciC.reset();
        this.ciC.postTranslate(-this.agHZ.left, -this.agHZ.top);
        this.ciC.postTranslate(f2 - this.agHX, f3 - this.agHY);
        this.ciC.postScale(f1, f1, f2, f3);
        this.ciC.postRotate(this.agHU, f2, f3);
        this.ciC.mapRect(this.hca, this.agHZ);
        n(this.hca);
        this.agIf.start();
        AppMethodBeat.o(164307);
        return true;
        if (paramMotionEvent.getPointerCount() != 2) {
          break;
        }
        ((f)localObject).agIu = ((f)localObject).aK(paramMotionEvent);
        break;
        if (paramMotionEvent.getPointerCount() <= 1) {
          break;
        }
        ((f)localObject).agIv = ((f)localObject).aK(paramMotionEvent);
        double d = Math.toDegrees(Math.atan(((f)localObject).agIv)) - Math.toDegrees(Math.atan(((f)localObject).agIu));
        if (Math.abs(d) <= 120.0D) {
          ((f)localObject).agIt.B((float)d, (((f)localObject).x2 + ((f)localObject).x1) / 2.0F, (((f)localObject).y2 + ((f)localObject).y1) / 2.0F);
        }
        ((f)localObject).agIu = ((f)localObject).agIv;
        break;
        label639:
        f1 = f2;
        if (f3 >= -45.0F) {
          break label265;
        }
        f1 = f2 - 90.0F;
        break label265;
        label663:
        if (this.hco > this.agHA)
        {
          f1 = this.agHA;
          this.agIf.bp(this.hco, this.agHA);
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
    this.afUH = paramBoolean;
    AppMethodBeat.o(164304);
  }
  
  public void setAnimaDuring(int paramInt)
  {
    this.agHz = paramInt;
  }
  
  public void setGlobalVisibleView(View paramView)
  {
    AppMethodBeat.i(164316);
    paramView.getGlobalVisibleRect(this.agIq);
    AppMethodBeat.o(164316);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    int j = 0;
    AppMethodBeat.i(164289);
    super.setImageDrawable(paramDrawable);
    if (paramDrawable == null)
    {
      this.agHL = false;
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
    if (!this.agHL) {
      this.agHL = true;
    }
    jMr();
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
    this.agIf.agIE.agIs = paramInterpolator;
  }
  
  public void setMaxAnimFromWaiteTime(int paramInt)
  {
    this.agHE = paramInt;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.agHA = paramFloat;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(164286);
    super.setOnClickListener(paramOnClickListener);
    this.mWW = paramOnClickListener;
    AppMethodBeat.o(164286);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.agIk = paramOnLongClickListener;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(164287);
    if (paramScaleType == ImageView.ScaleType.MATRIX)
    {
      AppMethodBeat.o(164287);
      return;
    }
    if (paramScaleType != this.agHJ)
    {
      this.agHJ = paramScaleType;
      if (this.isInit) {
        jMr();
      }
    }
    AppMethodBeat.o(164287);
  }
  
  public static abstract interface a
  {
    public abstract float jMB();
  }
  
  public final class b
    implements PhotoView.a
  {
    public b() {}
    
    public final float jMB()
    {
      AppMethodBeat.i(164260);
      float f = PhotoView.o(PhotoView.this).bottom;
      AppMethodBeat.o(164260);
      return f;
    }
  }
  
  public final class d
    implements PhotoView.a
  {
    public d() {}
    
    public final float jMB()
    {
      AppMethodBeat.i(164269);
      float f = (PhotoView.o(PhotoView.this).top + PhotoView.o(PhotoView.this).bottom) / 2.0F;
      AppMethodBeat.o(164269);
      return f;
    }
  }
  
  static abstract interface e
  {
    public abstract void B(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public final class f
  {
    PhotoView.e agIt;
    float agIu;
    float agIv;
    float x1;
    float x2;
    float y1;
    float y2;
    
    public f(PhotoView.e parame)
    {
      this.agIt = parame;
    }
    
    final float aK(MotionEvent paramMotionEvent)
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
    
    public final float jMB()
    {
      AppMethodBeat.i(164271);
      float f = PhotoView.o(PhotoView.this).top;
      AppMethodBeat.o(164271);
      return f;
    }
  }
  
  final class h
    implements Runnable
  {
    OverScroller HRu;
    boolean Uz;
    PhotoView.a agIA;
    int agIB;
    int agIC;
    RectF agID;
    PhotoView.c agIE;
    OverScroller agIw;
    Scroller agIx;
    Scroller agIy;
    Scroller agIz;
    int caG;
    int caH;
    
    h()
    {
      AppMethodBeat.i(164273);
      this.agID = new RectF();
      this.agIE = new PhotoView.c(PhotoView.this, (byte)0);
      this$1 = PhotoView.this.getContext();
      this.agIw = new OverScroller(PhotoView.this, this.agIE);
      this.agIx = new Scroller(PhotoView.this, this.agIE);
      this.HRu = new OverScroller(PhotoView.this, this.agIE);
      this.agIy = new Scroller(PhotoView.this, this.agIE);
      this.agIz = new Scroller(PhotoView.this, this.agIE);
      AppMethodBeat.o(164273);
    }
    
    private void jMC()
    {
      AppMethodBeat.i(164281);
      PhotoView.b(PhotoView.this).reset();
      PhotoView.b(PhotoView.this).postTranslate(-PhotoView.C(PhotoView.this).left, -PhotoView.C(PhotoView.this).top);
      PhotoView.b(PhotoView.this).postTranslate(PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
      PhotoView.b(PhotoView.this).postTranslate(-PhotoView.D(PhotoView.this), -PhotoView.E(PhotoView.this));
      PhotoView.b(PhotoView.this).postRotate(PhotoView.q(PhotoView.this), PhotoView.v(PhotoView.this).x, PhotoView.v(PhotoView.this).y);
      PhotoView.b(PhotoView.this).postScale(PhotoView.z(PhotoView.this), PhotoView.z(PhotoView.this), PhotoView.u(PhotoView.this).x, PhotoView.u(PhotoView.this).y);
      PhotoView.b(PhotoView.this).postTranslate(PhotoView.F(PhotoView.this), PhotoView.G(PhotoView.this));
      PhotoView.f(PhotoView.this);
      AppMethodBeat.o(164281);
    }
    
    private void jMD()
    {
      AppMethodBeat.i(164282);
      if (this.Uz) {
        PhotoView.this.post(this);
      }
      AppMethodBeat.o(164282);
    }
    
    final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, PhotoView.a parama)
    {
      AppMethodBeat.i(164276);
      this.agIy.startScroll((int)(paramFloat1 * 10000.0F), (int)(paramFloat2 * 10000.0F), (int)(paramFloat3 * 10000.0F), (int)(10000.0F * paramFloat4), paramInt);
      this.agIA = parama;
      AppMethodBeat.o(164276);
    }
    
    final void bp(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164275);
      this.agIx.startScroll((int)(paramFloat1 * 10000.0F), 0, (int)((paramFloat2 - paramFloat1) * 10000.0F), 0, PhotoView.I(PhotoView.this));
      AppMethodBeat.o(164275);
    }
    
    final void pn(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164274);
      this.agIB = 0;
      this.agIC = 0;
      this.agIw.startScroll(0, 0, paramInt1, paramInt2, PhotoView.I(PhotoView.this));
      AppMethodBeat.o(164274);
    }
    
    final void po(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(164277);
      this.agIz.startScroll(paramInt1, 0, paramInt2 - paramInt1, 0, PhotoView.I(PhotoView.this));
      AppMethodBeat.o(164277);
    }
    
    public final void run()
    {
      int j = 1;
      int k = 0;
      AppMethodBeat.i(164280);
      if (this.agIx.computeScrollOffset()) {
        PhotoView.g(PhotoView.this, this.agIx.getCurrX() / 10000.0F);
      }
      for (int i = 0;; i = 1)
      {
        int m;
        int n;
        int i1;
        if (this.agIw.computeScrollOffset())
        {
          i = this.agIw.getCurrX();
          m = this.agIB;
          n = this.agIw.getCurrY();
          i1 = this.agIC;
          PhotoView.a(PhotoView.this, i - m);
          PhotoView.b(PhotoView.this, n - i1);
          this.agIB = this.agIw.getCurrX();
          this.agIC = this.agIw.getCurrY();
          i = 0;
        }
        if (this.HRu.computeScrollOffset())
        {
          i = this.HRu.getCurrX();
          m = this.caG;
          n = this.HRu.getCurrY();
          i1 = this.caH;
          this.caG = this.HRu.getCurrX();
          this.caH = this.HRu.getCurrY();
          PhotoView.a(PhotoView.this, i - m);
          PhotoView.b(PhotoView.this, n - i1);
          i = 0;
        }
        if (this.agIz.computeScrollOffset())
        {
          PhotoView.d(PhotoView.this, this.agIz.getCurrX());
          i = 0;
        }
        if ((this.agIy.computeScrollOffset()) || (PhotoView.K(PhotoView.this) != null))
        {
          float f1 = this.agIy.getCurrX() / 10000.0F;
          float f2 = this.agIy.getCurrY() / 10000.0F;
          PhotoView.B(PhotoView.this).setScale(f1, f2, (PhotoView.o(PhotoView.this).left + PhotoView.o(PhotoView.this).right) / 2.0F, this.agIA.jMB());
          PhotoView.B(PhotoView.this).mapRect(this.agID, PhotoView.o(PhotoView.this));
          if (f1 == 1.0F)
          {
            this.agID.left = PhotoView.p(PhotoView.this).left;
            this.agID.right = PhotoView.p(PhotoView.this).right;
          }
          if (f2 == 1.0F)
          {
            this.agID.top = PhotoView.p(PhotoView.this).top;
            this.agID.bottom = PhotoView.p(PhotoView.this).bottom;
          }
          PhotoView.b(PhotoView.this, this.agID);
        }
        if (i == 0)
        {
          jMC();
          jMD();
          AppMethodBeat.o(164280);
          return;
        }
        this.Uz = false;
        i = k;
        if (PhotoView.l(PhotoView.this))
        {
          if (PhotoView.o(PhotoView.this).left > 0.0F)
          {
            PhotoView.e(PhotoView.this, PhotoView.o(PhotoView.this).left);
            i = 1;
          }
        }
        else
        {
          if (!PhotoView.m(PhotoView.this)) {
            break label732;
          }
          if (PhotoView.o(PhotoView.this).top <= 0.0F) {
            break label669;
          }
          PhotoView.f(PhotoView.this, PhotoView.o(PhotoView.this).top);
          i = j;
        }
        label669:
        label732:
        for (;;)
        {
          if (i != 0) {
            jMC();
          }
          PhotoView.this.invalidate();
          if (PhotoView.L(PhotoView.this) != null) {
            PhotoView.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(164272);
                PhotoView.L(PhotoView.this).run();
                PhotoView.M(PhotoView.this);
                PhotoView.this.invalidate();
                AppMethodBeat.o(164272);
              }
            });
          }
          AppMethodBeat.o(164280);
          return;
          if (PhotoView.o(PhotoView.this).right >= PhotoView.p(PhotoView.this).width()) {
            break;
          }
          PhotoView.c(PhotoView.this, (int)(PhotoView.p(PhotoView.this).width() - PhotoView.o(PhotoView.this).right));
          break;
          i = j;
          if (PhotoView.o(PhotoView.this).bottom < PhotoView.p(PhotoView.this).height())
          {
            PhotoView.d(PhotoView.this, (int)(PhotoView.p(PhotoView.this).height() - PhotoView.o(PhotoView.this).bottom));
            i = j;
          }
        }
      }
    }
    
    final void start()
    {
      AppMethodBeat.i(164278);
      this.Uz = true;
      jMD();
      AppMethodBeat.o(164278);
    }
    
    final void stop()
    {
      AppMethodBeat.i(164279);
      PhotoView.this.removeCallbacks(this);
      this.agIw.abortAnimation();
      this.agIx.abortAnimation();
      this.HRu.abortAnimation();
      this.agIz.abortAnimation();
      this.Uz = false;
      AppMethodBeat.o(164279);
    }
  }
  
  public static final class i {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.view.PhotoView
 * JD-Core Version:    0.7.0.1
 */