package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MMGestureGallery
  extends Gallery
{
  private boolean EHq;
  private boolean EHr;
  private boolean EHs;
  private boolean OTW;
  private boolean OTX;
  private boolean OTY;
  private boolean OTZ;
  private boolean OUa;
  private final int OUq;
  private final int OUr;
  private l QuB;
  private l QuC;
  private l QuD;
  private a QuE;
  private f QuF;
  private MMGestureGallery.c QuG;
  private e QuH;
  private boolean QuI;
  private b QuJ;
  private float aZg;
  private float aZh;
  private int auo;
  private int aup;
  private int count;
  private float dhm;
  private MMHandler handler;
  private MultiTouchImageView lTJ;
  private int mEX;
  private int mEY;
  private VelocityTracker mVelocityTracker;
  private long xsI;
  private long xsJ;
  private float xsK;
  private float xsL;
  private long xsM;
  private boolean xsN;
  private OverScroller xsO;
  private GestureDetector xsP;
  private RectF xsQ;
  private float xsS;
  private boolean xsT;
  private boolean xsU;
  private boolean xsV;
  private boolean xsW;
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143139);
    this.xsN = false;
    this.OTX = false;
    this.OTY = false;
    this.OTZ = false;
    this.OUa = false;
    this.xsT = false;
    this.xsU = false;
    this.xsV = false;
    this.xsW = false;
    this.count = 0;
    this.xsI = 0L;
    this.xsJ = 0L;
    this.xsK = 0.0F;
    this.xsL = 0.0F;
    this.xsM = 0L;
    this.xsQ = new RectF();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.QuI = true;
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.OTW = false;
    this.OUq = 60;
    this.OUr = 500;
    setStaticTransformationsEnabled(true);
    this.xsP = new GestureDetector(paramContext, new MMGestureGallery.d(this, (byte)0));
    this.QuB = new l(new WeakReference(this));
    this.QuC = new l(new WeakReference(this));
    this.QuD = new l(new WeakReference(this));
    this.xsO = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    float f = getResources().getDisplayMetrics().density;
    setOnTouchListener(new View.OnTouchListener()
    {
      private void CI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143116);
        MMGestureGallery.k(MMGestureGallery.this).S(350L, paramAnonymousBoolean);
        AppMethodBeat.o(143116);
      }
      
      private void gXG()
      {
        AppMethodBeat.i(143113);
        gXH();
        MMGestureGallery.e(MMGestureGallery.this).m(2, 500L, 0L);
        AppMethodBeat.o(143113);
      }
      
      private void gXH()
      {
        AppMethodBeat.i(143114);
        MMGestureGallery.e(MMGestureGallery.this).removeMessages(2);
        AppMethodBeat.o(143114);
      }
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143115);
        if (MMGestureGallery.f(MMGestureGallery.this) == null) {
          MMGestureGallery.a(MMGestureGallery.this, VelocityTracker.obtain());
        }
        MMGestureGallery.f(MMGestureGallery.this).addMovement(paramAnonymousMotionEvent);
        View localView = MMGestureGallery.this.getSelectedView();
        float f1;
        float f2;
        if (localView != null)
        {
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            MMGestureGallery.a(MMGestureGallery.this, paramAnonymousMotionEvent.getX());
            MMGestureGallery.b(MMGestureGallery.this, paramAnonymousMotionEvent.getY());
          }
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            if (MMGestureGallery.g(MMGestureGallery.this))
            {
              if (MMGestureGallery.h(MMGestureGallery.this) != null) {
                MMGestureGallery.h(MMGestureGallery.this).S(0.0F, 0.0F);
              }
              MMGestureGallery.a(MMGestureGallery.this, false);
            }
            if ((MMGestureGallery.i(MMGestureGallery.this)) && (!MMGestureGallery.j(MMGestureGallery.this)))
            {
              MMGestureGallery.k(MMGestureGallery.this).S(0L, true);
              MMGestureGallery.a(MMGestureGallery.this, false);
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 2) && (f.ai(paramAnonymousMotionEvent) < 2))
          {
            paramAnonymousView = MMGestureGallery.f(MMGestureGallery.this);
            paramAnonymousView.computeCurrentVelocity(1000);
            int i = (int)paramAnonymousView.getXVelocity();
            int j = (int)paramAnonymousView.getYVelocity();
            f1 = paramAnonymousMotionEvent.getX() - MMGestureGallery.l(MMGestureGallery.this);
            f2 = paramAnonymousMotionEvent.getY() - MMGestureGallery.m(MMGestureGallery.this);
            if ((MMGestureGallery.h(MMGestureGallery.this) != null) && (!MMGestureGallery.j(MMGestureGallery.this)) && (!MMGestureGallery.n(MMGestureGallery.this)))
            {
              MMGestureGallery.h(MMGestureGallery.this).T(f1, f2);
              if (((Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (j <= 0) || (MMGestureGallery.o(MMGestureGallery.this))) && (!MMGestureGallery.i(MMGestureGallery.this))) {
                break label744;
              }
              MMGestureGallery.h(MMGestureGallery.this).S(f1, f2);
              MMGestureGallery.a(MMGestureGallery.this, true);
              if (f2 <= 200.0F) {
                break label756;
              }
              MMGestureGallery.b(MMGestureGallery.this, false);
            }
          }
        }
        for (;;)
        {
          if (MMGestureGallery.f(MMGestureGallery.this) != null)
          {
            MMGestureGallery.f(MMGestureGallery.this).recycle();
            MMGestureGallery.a(MMGestureGallery.this, null);
          }
          paramAnonymousView = localView;
          if (!(localView instanceof ViewGroup)) {
            break label768;
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            MMGestureGallery.c(MMGestureGallery.this, f.j(paramAnonymousMotionEvent, 0));
            MMGestureGallery.d(MMGestureGallery.this, f.k(paramAnonymousMotionEvent, 0));
          }
          paramAnonymousView = localView.findViewById(2131302526);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0) && (!(paramAnonymousView instanceof MultiTouchImageView)))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              gXG();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              gXH();
            }
          }
          paramAnonymousView = localView.findViewById(2131309773);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0) && (!(paramAnonymousView instanceof MultiTouchImageView)))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              gXG();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              gXH();
            }
          }
          paramAnonymousView = localView.findViewById(2131309841);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              gXG();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              gXH();
            }
          }
          paramAnonymousView = localView.findViewById(2131302563);
          if (((paramAnonymousView == null) || (paramAnonymousView.getVisibility() == 8)) && (MMGestureGallery.p(MMGestureGallery.this)) && (MMGestureGallery.q(MMGestureGallery.this) != null) && (paramAnonymousMotionEvent.getAction() == 1) && (Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) < 10.0F) && (!MMGestureGallery.o(MMGestureGallery.this))) {
            CI(true);
          }
          if (paramAnonymousMotionEvent.getAction() == 1) {
            MMGestureGallery.t(MMGestureGallery.this);
          }
          if (paramAnonymousView != null)
          {
            localView = paramAnonymousView.findViewById(2131302526);
            paramAnonymousView = localView;
            if (localView != null) {
              break label768;
            }
          }
          AppMethodBeat.o(143115);
          return false;
          label744:
          MMGestureGallery.a(MMGestureGallery.this, false);
          break;
          label756:
          MMGestureGallery.b(MMGestureGallery.this, true);
        }
        label768:
        float f3;
        if ((paramAnonymousView instanceof MultiTouchImageView))
        {
          MMGestureGallery.a(MMGestureGallery.this, (MultiTouchImageView)paramAnonymousView);
          Log.d("dktest", "MMGestureGallery onTouch event.getAction():" + paramAnonymousMotionEvent.getAction());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            gXG();
            MMGestureGallery.a(MMGestureGallery.this).gKA();
            MMGestureGallery.e(MMGestureGallery.this, 0.0F);
            MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
            Log.d("dktest", "originalScale :" + MMGestureGallery.u(MMGestureGallery.this));
            MMGestureGallery.c(MMGestureGallery.this, false);
            MMGestureGallery.v(MMGestureGallery.this);
            if (MMGestureGallery.w(MMGestureGallery.this) == 1)
            {
              MMGestureGallery.a(MMGestureGallery.this, System.currentTimeMillis());
              MMGestureGallery.c(MMGestureGallery.this, f.j(paramAnonymousMotionEvent, 0));
              MMGestureGallery.d(MMGestureGallery.this, f.k(paramAnonymousMotionEvent, 0));
            }
          }
          else
          {
            if ((paramAnonymousMotionEvent.getAction() == 6) || (paramAnonymousMotionEvent.getAction() == 262))
            {
              gXH();
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              MMGestureGallery.c(MMGestureGallery.this, true);
              Log.i("MicroMsg.MMGestureGallery", "originalScale:%f, scale:%f", new Object[] { Float.valueOf(MMGestureGallery.u(MMGestureGallery.this)), Float.valueOf(MMGestureGallery.a(MMGestureGallery.this).getScaleRate()) });
              if (MMGestureGallery.u(MMGestureGallery.this) < MMGestureGallery.a(MMGestureGallery.this).getScaleRate())
              {
                f1 = f.j(paramAnonymousMotionEvent, 0) - f.j(paramAnonymousMotionEvent, 1);
                f2 = f.k(paramAnonymousMotionEvent, 0) - f.k(paramAnonymousMotionEvent, 1);
                f3 = MMGestureGallery.a(MMGestureGallery.this).getOriginScale();
                if (f3 <= 0.0F) {
                  break label2022;
                }
                if (MMGestureGallery.u(MMGestureGallery.this) <= f3 + 0.05D) {
                  MMGestureGallery.a(MMGestureGallery.this).aw(f1 + f.j(paramAnonymousMotionEvent, 1), f2 + f.k(paramAnonymousMotionEvent, 1));
                }
              }
              label1162:
              if (MMGestureGallery.u(MMGestureGallery.this) > MMGestureGallery.a(MMGestureGallery.this).getDoubleTabScale() * 2.0F)
              {
                f1 = f.j(paramAnonymousMotionEvent, 0);
                f2 = f.j(paramAnonymousMotionEvent, 1);
                f3 = f.k(paramAnonymousMotionEvent, 0);
                float f4 = f.k(paramAnonymousMotionEvent, 1);
                MMGestureGallery.a(MMGestureGallery.this).setMaxZoomLimit(MMGestureGallery.a(MMGestureGallery.this).getDoubleTabScale() * 2.0F);
                MMGestureGallery.a(MMGestureGallery.this).r(MMGestureGallery.a(MMGestureGallery.this).getDoubleTabScale() * 2.0F, f1 - f2 + f.j(paramAnonymousMotionEvent, 1), f3 - f4 + f.k(paramAnonymousMotionEvent, 1));
                MMGestureGallery.a(MMGestureGallery.this).gKz();
              }
            }
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              gXH();
              MMGestureGallery.z(MMGestureGallery.this);
              MMGestureGallery.A(MMGestureGallery.this);
              MMGestureGallery.t(MMGestureGallery.this);
              if (((!MMGestureGallery.B(MMGestureGallery.this)) && (!MMGestureGallery.C(MMGestureGallery.this)) && (!MMGestureGallery.D(MMGestureGallery.this)) && (!MMGestureGallery.E(MMGestureGallery.this))) || ((!MMGestureGallery.F(MMGestureGallery.this)) && (!MMGestureGallery.G(MMGestureGallery.this)))) {
                break label2050;
              }
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.h(MMGestureGallery.this));
              MMGestureGallery.H(MMGestureGallery.this);
              MMGestureGallery.I(MMGestureGallery.this);
              MMGestureGallery.J(MMGestureGallery.this);
              MMGestureGallery.K(MMGestureGallery.this);
              MMGestureGallery.L(MMGestureGallery.this);
              MMGestureGallery.M(MMGestureGallery.this);
              MMGestureGallery.N(MMGestureGallery.this);
              label1457:
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              if (MMGestureGallery.w(MMGestureGallery.this) == 1)
              {
                MMGestureGallery.c(MMGestureGallery.this, System.currentTimeMillis());
                if (MMGestureGallery.y(MMGestureGallery.this) - MMGestureGallery.O(MMGestureGallery.this) >= 350L) {
                  break label2265;
                }
                if ((Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) < 10.0F)) {
                  CI(false);
                }
              }
            }
          }
          for (;;)
          {
            if ((paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261))
            {
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              MMGestureGallery.c(MMGestureGallery.this, true);
            }
            if (paramAnonymousMotionEvent.getAction() != 2) {
              break label2367;
            }
            if (f.ai(paramAnonymousMotionEvent) != 2) {
              break label2444;
            }
            gXH();
            if ((!MMGestureGallery.P(MMGestureGallery.this)) && (!MMGestureGallery.D(MMGestureGallery.this)) && (!MMGestureGallery.E(MMGestureGallery.this))) {
              break label2286;
            }
            AppMethodBeat.o(143115);
            return true;
            if (MMGestureGallery.w(MMGestureGallery.this) != 2) {
              break;
            }
            MMGestureGallery.b(MMGestureGallery.this, System.currentTimeMillis());
            if (MMGestureGallery.x(MMGestureGallery.this) - MMGestureGallery.y(MMGestureGallery.this) < 350L)
            {
              if ((Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 35.0F) && (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) < 35.0F))
              {
                MMGestureGallery.a(MMGestureGallery.this, 0);
                Log.d("MicroMsg.MMGestureGallery", "double click!");
                f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
                Log.i("MicroMsg.MMGestureGallery", "currentScale:%f, scale:%f", new Object[] { Float.valueOf(f1), Float.valueOf(MMGestureGallery.a(MMGestureGallery.this).getScaleRate()) });
                if (f1 <= MMGestureGallery.a(MMGestureGallery.this).getScaleRate())
                {
                  MMGestureGallery.a(MMGestureGallery.this).y(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                  break;
                }
                if (MMGestureGallery.a(MMGestureGallery.this).getOriginScale() > 0.0F)
                {
                  if (f1 <= MMGestureGallery.a(MMGestureGallery.this).getOriginScale() + 0.05D)
                  {
                    MMGestureGallery.a(MMGestureGallery.this).y(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                    break;
                  }
                  MMGestureGallery.a(MMGestureGallery.this).av(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                  break;
                }
                MMGestureGallery.a(MMGestureGallery.this).at(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                MMGestureGallery.a(MMGestureGallery.this).gKz();
                break;
              }
              MMGestureGallery.a(MMGestureGallery.this, 1);
              break;
            }
            MMGestureGallery.a(MMGestureGallery.this, 1);
            break;
            label2022:
            MMGestureGallery.a(MMGestureGallery.this).at(f1 + f.j(paramAnonymousMotionEvent, 1), f2 + f.k(paramAnonymousMotionEvent, 1));
            break label1162;
            label2050:
            if ((MMGestureGallery.D(MMGestureGallery.this)) || (MMGestureGallery.B(MMGestureGallery.this)))
            {
              MMGestureGallery.K(MMGestureGallery.this);
              MMGestureGallery.I(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.i(MMGestureGallery.this));
              MMGestureGallery.H(MMGestureGallery.this);
            }
            if ((MMGestureGallery.E(MMGestureGallery.this)) || (MMGestureGallery.C(MMGestureGallery.this)))
            {
              MMGestureGallery.L(MMGestureGallery.this);
              MMGestureGallery.J(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.j(MMGestureGallery.this));
              MMGestureGallery.H(MMGestureGallery.this);
            }
            if (MMGestureGallery.F(MMGestureGallery.this))
            {
              MMGestureGallery.M(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.k(MMGestureGallery.this));
              MMGestureGallery.H(MMGestureGallery.this);
            }
            if (!MMGestureGallery.G(MMGestureGallery.this)) {
              break label1457;
            }
            MMGestureGallery.N(MMGestureGallery.this);
            MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.g(MMGestureGallery.this));
            MMGestureGallery.H(MMGestureGallery.this);
            break label1457;
            label2265:
            MMGestureGallery.a(MMGestureGallery.this, 0);
            Log.d("MicroMsg.MMGestureGallery", "single long click over!");
          }
          label2286:
          MMGestureGallery.c(MMGestureGallery.this, true);
          MMGestureGallery.a(MMGestureGallery.this, 0);
          f1 = f.j(paramAnonymousMotionEvent, 0) - f.j(paramAnonymousMotionEvent, 1);
          f2 = f.k(paramAnonymousMotionEvent, 0) - f.k(paramAnonymousMotionEvent, 1);
          f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
          if (MMGestureGallery.Q(MMGestureGallery.this) != 0.0F) {
            break label2374;
          }
          MMGestureGallery.e(MMGestureGallery.this, f3);
        }
        for (;;)
        {
          label2367:
          AppMethodBeat.o(143115);
          return false;
          label2374:
          f3 /= MMGestureGallery.Q(MMGestureGallery.this);
          if (MMGestureGallery.n(MMGestureGallery.this))
          {
            MMGestureGallery.a(MMGestureGallery.this).r(f3 * MMGestureGallery.u(MMGestureGallery.this), f1 + f.j(paramAnonymousMotionEvent, 1), f.k(paramAnonymousMotionEvent, 1) + f2);
            MMGestureGallery.a(MMGestureGallery.this).gKz();
            continue;
            label2444:
            if ((Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) > 35.0F) || (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) > 35.0F))
            {
              gXH();
              MMGestureGallery.a(MMGestureGallery.this, 0);
            }
          }
        }
      }
    });
    AppMethodBeat.o(143139);
  }
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143137);
    this.xsN = false;
    this.OTX = false;
    this.OTY = false;
    this.OTZ = false;
    this.OUa = false;
    this.xsT = false;
    this.xsU = false;
    this.xsV = false;
    this.xsW = false;
    this.count = 0;
    this.xsI = 0L;
    this.xsJ = 0L;
    this.xsK = 0.0F;
    this.xsL = 0.0F;
    this.xsM = 0L;
    this.xsQ = new RectF();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.QuI = true;
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.OTW = false;
    this.OUq = 60;
    this.OUr = 500;
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(143137);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat)
  {
    AppMethodBeat.i(143148);
    float f3 = paramMotionEvent1.getX();
    float f4 = paramMotionEvent2.getX();
    float f1 = paramMotionEvent1.getY();
    float f2 = paramMotionEvent2.getY();
    boolean bool = b(paramMotionEvent1, paramMotionEvent2);
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    if (Math.abs(paramFloat) <= 500.0F)
    {
      AppMethodBeat.o(143148);
      return;
    }
    if (f3 < 60.0F)
    {
      AppMethodBeat.o(143148);
      return;
    }
    if (f3 < f1)
    {
      AppMethodBeat.o(143148);
      return;
    }
    if (bool)
    {
      onKeyDown(21, null);
      AppMethodBeat.o(143148);
      return;
    }
    onKeyDown(22, null);
    AppMethodBeat.o(143148);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    AppMethodBeat.i(143142);
    int i;
    if ((this.OTY) || (this.OTX)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(143142);
      return true;
      if (getPositionForView(paramView) == getAdapter().getCount() - 1)
      {
        if (this.OUa)
        {
          if (paramFloat3 > 0.0F)
          {
            if (paramFloat2 >= this.mEX) {
              this.lTJ.au(-paramFloat3, 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if ((paramFloat2 > this.mEX * 0.7F) && (paramFloat2 < this.mEY)) {
                this.lTJ.au(-(paramFloat3 * 0.3F), 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 > 0.0F)
        {
          if (paramFloat2 < this.mEX) {
            this.OUa = true;
          }
          if (paramFloat2 >= this.mEX) {
            this.lTJ.au(-paramFloat3, 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((paramFloat2 > this.mEX * 0.7F) && (paramFloat2 < this.mEY)) {
              this.lTJ.au(-(paramFloat3 * 0.3F), 0.0F);
            }
          }
        }
      }
      this.OUa = false;
      i = 0;
    }
    if ((this.OTY) || (this.OTX)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(143142);
      return true;
      if (getPositionForView(paramView) == 0)
      {
        if (this.OTZ)
        {
          if (paramFloat3 < 0.0F)
          {
            if ((paramFloat1 > 0.0F) && (paramFloat1 < this.mEX * 0.3F)) {
              this.lTJ.au(-(paramFloat3 * 0.3F), 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if (paramFloat1 <= 0.0F) {
                this.lTJ.au(-paramFloat3, 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 < 0.0F)
        {
          if (paramFloat1 > 0.0F) {
            this.OTZ = true;
          }
          if ((paramFloat1 > 0.0F) && (paramFloat1 < this.mEX * 0.3F)) {
            this.lTJ.au(-(paramFloat3 * 0.3F), 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if (paramFloat1 <= 0.0F) {
              this.lTJ.au(-paramFloat3, 0.0F);
            }
          }
        }
      }
      this.OTZ = false;
      i = 0;
    }
    AppMethodBeat.o(143142);
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143141);
    if (this.OTX)
    {
      AppMethodBeat.o(143141);
      return true;
    }
    this.OTY = true;
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    AppMethodBeat.o(143141);
    return bool;
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(143147);
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() < 0.0F)
    {
      AppMethodBeat.o(143147);
      return true;
    }
    AppMethodBeat.o(143147);
    return false;
  }
  
  private void dSC()
  {
    AppMethodBeat.i(143138);
    this.QuB.removeMessages(1);
    AppMethodBeat.o(143138);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143152);
    Log.d("MicroMsg.MMGestureGallery", "computeScrollOffset: %s.", new Object[] { Boolean.valueOf(this.xsO.computeScrollOffset()) });
    if (this.lTJ == null)
    {
      AppMethodBeat.o(143152);
      return;
    }
    int i;
    float f4;
    float f1;
    float f5;
    int j;
    int k;
    if (this.xsO.computeScrollOffset())
    {
      Log.d("MicroMsg.MMGestureGallery", "mFlingScroller.getCurrX(): %s, mFlingScroller.getCurrY(): %s.", new Object[] { Integer.valueOf(this.xsO.getCurrX()), Integer.valueOf(this.xsO.getCurrY()) });
      i = this.xsO.getCurrX() - this.auo;
      int m = this.xsO.getCurrY() - this.aup;
      Log.d("MicroMsg.MMGestureGallery", " scrollX: %s, scrollY: %s, mLastFlingX: %s, mLastFlingY: %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(this.auo), Integer.valueOf(this.aup) });
      this.auo = this.xsO.getCurrX();
      this.aup = this.xsO.getCurrY();
      float f3 = this.lTJ.getScale();
      f4 = this.lTJ.getImageWidth();
      f1 = this.lTJ.getScale() * this.lTJ.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.lTJ.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      Log.d("MicroMsg.MMGestureGallery", "left: %s, right: %s, top: %s, bottom: %s.", new Object[] { Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5) });
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.xsQ.right - Math.round(f3)) {
          j = (int)(this.xsQ.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.xsQ.left - Math.round(f2)) {
          i = (int)(this.xsQ.left - Math.round(f2));
        }
      }
      k = m;
      if (m < 0)
      {
        k = m;
        if (m < this.xsQ.bottom - Math.round(f5)) {
          k = (int)(this.xsQ.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.xsQ.top - Math.round(f4)) {
          j = (int)(this.xsQ.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.xsQ.left) && (Math.round(f3) > this.xsQ.right)) {
        break label586;
      }
      k = 0;
    }
    for (;;)
    {
      if (f1 < this.mEY) {
        j = 0;
      }
      this.lTJ.au(k, j);
      postInvalidate();
      AppMethodBeat.o(143152);
      return;
      label586:
      if (Math.round(f4) < this.xsQ.top)
      {
        k = i;
        if (Math.round(f5) > this.xsQ.bottom) {}
      }
      else
      {
        j = 0;
        k = i;
      }
    }
  }
  
  public int getScreenWidth()
  {
    return this.mEX;
  }
  
  public int getXDown()
  {
    return (int)this.aZg;
  }
  
  public int getYDown()
  {
    return (int)this.aZh;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143144);
    if (this.xsO != null) {
      this.xsO.forceFinished(true);
    }
    boolean bool = super.onDown(paramMotionEvent);
    AppMethodBeat.o(143144);
    return bool;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143145);
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(2131302563);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        AppMethodBeat.o(143145);
        return false;
      }
      localObject2 = ((View)localObject1).findViewById(2131302526);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        AppMethodBeat.o(143145);
        return false;
      }
    }
    float f2;
    float f3;
    float f4;
    float f5;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      localObject1 = (MultiTouchImageView)localObject1;
      f2 = ((MultiTouchImageView)localObject1).getScale() * ((MultiTouchImageView)localObject1).getImageWidth();
      f3 = ((MultiTouchImageView)localObject1).getScale() * ((MultiTouchImageView)localObject1).getImageHeight();
      Log.d("MicroMsg.MMGestureGallery", "width: %f, height: %f.", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
      if ((((MultiTouchImageView)localObject1).aXq) || (((MultiTouchImageView)localObject1).aXp) || ((int)f2 > this.mEX) || ((int)f3 > this.mEY))
      {
        localObject2 = new float[9];
        ((MultiTouchImageView)localObject1).getImageMatrix().getValues((float[])localObject2);
        f1 = localObject2[2];
        float f6 = f1 + f2;
        f4 = localObject2[5];
        f5 = f4 + f3;
        Log.d("MicroMsg.MMGestureGallery", "left: %f, right: %f, top: %f, bottom: %f, velocityX: %f, velocityY: %f.", new Object[] { Float.valueOf(f1), Float.valueOf(f6), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f1) < this.xsQ.left) && (Math.round(f6) > this.xsQ.right)) {
          break label614;
        }
      }
    }
    label614:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f4) >= this.xsQ.top) || (Math.round(f5) <= this.xsQ.bottom)) {
        paramFloat2 = 0.0F;
      }
      if (Math.round(f4) < this.xsQ.top) {}
      for (this.OTW = true;; this.OTW = false)
      {
        int i = (int)(this.xsQ.right - f2);
        int j = (int)(this.xsQ.right + f2);
        int k = (int)(this.xsQ.bottom - f3);
        int m = (int)(this.xsQ.bottom + f3);
        Log.d("MicroMsg.MMGestureGallery", "minX: %d, maxX: %d, minY: %d, maxY: %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        Log.d("MicroMsg.MMGestureGallery", "vx: %f, vy: %f.", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat2) });
        this.xsO.forceFinished(true);
        this.xsO.fling(this.xsO.getCurrX(), this.xsO.getCurrY(), (int)f1, (int)paramFloat2, i, j, k, m, 0, 0);
        if (!this.xsN) {
          break;
        }
        AppMethodBeat.o(143145);
        return true;
      }
      a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
      AppMethodBeat.o(143145);
      return true;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(143150);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    AppMethodBeat.o(143150);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143146);
    this.EHs = true;
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(143146);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143140);
    super.onMeasure(paramInt1, paramInt2);
    this.mEX = View.MeasureSpec.getSize(paramInt1);
    this.mEY = View.MeasureSpec.getSize(paramInt2);
    this.xsQ.set(0.0F, 0.0F, this.mEX, this.mEY);
    Log.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.mEX + " height:" + this.mEY);
    AppMethodBeat.o(143140);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143143);
    if ((this.xsN) || (this.EHq))
    {
      AppMethodBeat.o(143143);
      return true;
    }
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    boolean bool;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(2131302563);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        AppMethodBeat.o(143143);
        return bool;
      }
      localObject2 = ((View)localObject1).findViewById(2131302526);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        AppMethodBeat.o(143143);
        return bool;
      }
    }
    float f1;
    float f5;
    float f4;
    float f6;
    float f7;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      this.lTJ = ((MultiTouchImageView)localObject1);
      localObject2 = new float[9];
      this.lTJ.getImageMatrix().getValues((float[])localObject2);
      f1 = this.lTJ.getScale() * this.lTJ.getImageWidth();
      float f2 = this.lTJ.getScale() * this.lTJ.getImageHeight();
      f5 = localObject2[2];
      f4 = f5 + f1;
      f6 = localObject2[5];
      f7 = f6 + f2;
      localObject2 = new Rect();
      this.lTJ.getGlobalVisibleRect((Rect)localObject2);
      if (((int)f1 <= this.mEX) && ((int)f2 <= this.mEY))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.mEX)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            AppMethodBeat.o(143143);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          AppMethodBeat.o(143143);
          return bool;
        }
        if (!this.OTY) {
          this.lTJ.au(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (((int)f1 <= this.mEX) && ((int)f2 > this.mEY))
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          if ((this.OTY) || (this.OTZ) || (this.OUa))
          {
            AppMethodBeat.o(143143);
            return true;
          }
          this.OTX = true;
          f2 = 0.0F;
          float f3 = 0.0F;
          if (paramFloat2 < 0.0F)
          {
            if (f6 > this.xsQ.top) {
              this.xsT = true;
            }
            if ((f6 <= this.xsQ.top) || (f7 < this.mEY))
            {
              f1 = -paramFloat2;
              if ((paramFloat1 >= 0.0F) || (f5 <= this.xsQ.left)) {
                break label691;
              }
              this.xsV = true;
              paramFloat2 = -(0.3F * paramFloat1);
            }
          }
          for (;;)
          {
            this.lTJ.au(paramFloat2, f1);
            AppMethodBeat.o(143143);
            return true;
            f1 = f3;
            if (f6 <= this.xsQ.top) {
              break;
            }
            f1 = f3;
            if (f6 >= this.mEY * 0.3F) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            if (f7 < this.xsQ.bottom) {
              this.xsU = true;
            }
            if ((f6 > 0.0F) || (f7 >= this.mEY))
            {
              f1 = -paramFloat2;
              break;
            }
            f1 = f3;
            if (f7 <= this.mEY * 0.7F) {
              break;
            }
            f1 = f3;
            if (f7 >= this.mEY) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            label691:
            paramFloat2 = f2;
            if (paramFloat1 > 0.0F)
            {
              paramFloat2 = f2;
              if (f4 < this.xsQ.right)
              {
                this.xsW = true;
                paramFloat2 = -(0.3F * paramFloat1);
              }
            }
          }
        }
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.mEX)
          {
            if (f4 > this.mEX * 0.7F)
            {
              bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
              AppMethodBeat.o(143143);
              return bool;
            }
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
            AppMethodBeat.o(143143);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          if (f5 < this.mEX * 0.3F)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
            AppMethodBeat.o(143143);
            return bool;
          }
          bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
          AppMethodBeat.o(143143);
          return bool;
        }
        if (!this.OTY) {
          this.lTJ.au(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (((int)f1 > this.mEX) && ((int)f2 <= this.mEY))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.mEX)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
            AppMethodBeat.o(143143);
            return bool;
          }
        }
        else if (f5 >= 0.0F)
        {
          bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
          AppMethodBeat.o(143143);
          return bool;
        }
        if (!this.OTY) {
          this.lTJ.au(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        if (paramFloat1 == 0.0F) {
          break label1581;
        }
        this.OTY = true;
        if (paramFloat1 < 0.0F)
        {
          if (f5 > this.xsQ.left) {
            this.xsV = true;
          }
          f1 = paramFloat1;
          if (f5 > this.xsQ.left)
          {
            if (f4 >= this.mEX) {
              break label1213;
            }
            f1 = paramFloat1;
          }
        }
      }
    }
    for (;;)
    {
      if (paramFloat2 != 0.0F)
      {
        this.OTX = true;
        if (paramFloat2 < 0.0F)
        {
          if (f6 > this.xsQ.top) {
            this.xsT = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > this.xsQ.top)
          {
            if (f7 >= this.mEY) {
              break label1329;
            }
            paramFloat1 = paramFloat2;
          }
        }
      }
      for (;;)
      {
        this.lTJ.au(-f1, -paramFloat1);
        AppMethodBeat.o(143143);
        return true;
        label1213:
        if ((f5 <= this.xsQ.left) || (f5 >= this.mEX * 0.3F)) {
          break label1581;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        if (f4 < this.xsQ.right) {
          this.xsW = true;
        }
        f1 = paramFloat1;
        if (f5 > 0.0F) {
          break;
        }
        f1 = paramFloat1;
        if (f4 >= this.mEX) {
          break;
        }
        if ((f4 <= this.mEX * 0.7F) || (f4 >= this.mEX)) {
          break label1581;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        label1329:
        if ((f6 > this.xsQ.top) && (f6 < this.mEY * 0.3F))
        {
          paramFloat1 = paramFloat2 * 0.3F;
          continue;
          if (f7 < this.xsQ.bottom) {
            this.xsU = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > 0.0F) {
            continue;
          }
          paramFloat1 = paramFloat2;
          if (f7 >= this.mEY) {
            continue;
          }
          if ((f7 > this.mEY * 0.7F) && (f7 < this.mEY))
          {
            paramFloat1 = paramFloat2 * 0.3F;
            continue;
            if (a(f5, f4, (View)localObject1, paramFloat1))
            {
              AppMethodBeat.o(143143);
              return true;
            }
            if (paramFloat1 > 0.0F)
            {
              if (f4 <= this.mEX)
              {
                bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
                AppMethodBeat.o(143143);
                return bool;
              }
            }
            else if (f5 >= 0.0F)
            {
              bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, 0.0F);
              AppMethodBeat.o(143143);
              return bool;
            }
            if (!this.OTY) {
              this.lTJ.au(-paramFloat1, -paramFloat2);
            }
            AppMethodBeat.o(143143);
            return true;
            bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
            AppMethodBeat.o(143143);
            return bool;
          }
        }
        paramFloat1 = 0.0F;
      }
      label1581:
      f1 = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143149);
    Object localObject = this.xsP;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    Log.d("dktest", "onTouchEvent event.getAction()" + paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      computeScroll();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143149);
      return bool;
      localObject = getSelectedView();
      if ((localObject instanceof MultiTouchImageView))
      {
        this.lTJ = ((MultiTouchImageView)localObject);
        float f2 = this.lTJ.getScale() * this.lTJ.getImageWidth();
        float f1 = this.lTJ.getScale() * this.lTJ.getImageHeight();
        if (((int)f2 <= this.mEX) && ((int)f1 <= this.mEY))
        {
          Log.i("dktest", "onTouchEvent width:" + f2 + "height:" + f1);
        }
        else
        {
          localObject = new float[9];
          this.lTJ.getImageMatrix().getValues((float[])localObject);
          f2 = localObject[5];
          Log.d("dktest", "onTouchEvent top:" + f2 + " height:" + f1 + " bottom:" + (f2 + f1));
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(143151);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(143151);
  }
  
  public void setGalleryScaleListener(b paramb)
  {
    this.QuJ = paramb;
  }
  
  public void setLoadQuit(boolean paramBoolean)
  {
    this.QuI = paramBoolean;
  }
  
  public void setLongClickOverListener(MMGestureGallery.c paramc)
  {
    this.QuG = paramc;
  }
  
  public void setScrollLeftRightListener(e parame)
  {
    this.QuH = parame;
  }
  
  public void setSingleClickOverListener(f paramf)
  {
    this.QuF = paramf;
  }
  
  abstract class a
  {
    protected boolean dgZ = false;
    
    public a() {}
    
    public final boolean deQ()
    {
      return this.dgZ;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b
  {
    public abstract void S(float paramFloat1, float paramFloat2);
    
    public abstract void T(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface e {}
  
  public static abstract interface f
  {
    public abstract void bmt();
  }
  
  final class g
    extends MMGestureGallery.a
  {
    float[] xtd;
    
    public g()
    {
      super();
      AppMethodBeat.i(143118);
      this.xtd = new float[9];
      AppMethodBeat.o(143118);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143119);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143117);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.g.this.xtd);
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.a(MMGestureGallery.this).getImageHeight() * f1;
          float f3 = MMGestureGallery.g.this.xtd[5];
          f1 = MMGestureGallery.d(MMGestureGallery.this);
          if (f2 < MMGestureGallery.d(MMGestureGallery.this)) {
            f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.g.this.dgZ = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.this).au(0.0F, f1);
            AppMethodBeat.o(143117);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.g.this.dgZ = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(143119);
    }
  }
  
  final class h
    extends MMGestureGallery.a
  {
    float[] xtd;
    
    public h()
    {
      super();
      AppMethodBeat.i(143121);
      this.xtd = new float[9];
      AppMethodBeat.o(143121);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143122);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143120);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.h.this.xtd);
          float f5 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).getImageWidth();
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f8 = MMGestureGallery.a(MMGestureGallery.this).getImageHeight() * f1;
          float f7 = MMGestureGallery.h.this.xtd[2];
          float f10 = MMGestureGallery.h.this.xtd[5];
          float f6 = MMGestureGallery.h.this.xtd[2];
          float f9 = MMGestureGallery.h.this.xtd[5];
          float f2 = 0.0F;
          f1 = MMGestureGallery.d(MMGestureGallery.this);
          float f3 = 0.0F;
          float f4 = MMGestureGallery.b(MMGestureGallery.this);
          if (f8 < MMGestureGallery.d(MMGestureGallery.this))
          {
            f2 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F - f8 / 2.0F;
            f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F + f8 / 2.0F;
          }
          for (;;)
          {
            f2 -= f10;
            f1 -= f9 + f8;
            if (f2 < 0.0F) {
              f1 = f2;
            }
            for (;;)
            {
              if (f5 < MMGestureGallery.b(MMGestureGallery.this))
              {
                f3 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F;
                f4 = f5 / 2.0F;
                f2 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F + f5 / 2.0F;
                f3 -= f4;
              }
              for (;;)
              {
                f3 -= f7;
                f2 -= f6 + f5;
                if (f3 < 0.0F) {
                  f2 = f3;
                }
                for (;;)
                {
                  label321:
                  if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
                    MMGestureGallery.h.this.dgZ = true;
                  }
                  for (;;)
                  {
                    MMGestureGallery.a(MMGestureGallery.this).au(f2, f1);
                    AppMethodBeat.o(143120);
                    return;
                    if (f1 <= 0.0F) {
                      break label526;
                    }
                    break;
                    if (f2 <= 0.0F) {
                      break label515;
                    }
                    break label321;
                    if (f2 >= 0.0F) {}
                    for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
                    {
                      if (f1 < 0.0F) {
                        break label485;
                      }
                      f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                      break;
                    }
                    label485:
                    f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                  }
                  label515:
                  f2 = 0.0F;
                }
                f2 = f4;
              }
              label526:
              f1 = 0.0F;
            }
          }
        }
      });
      AppMethodBeat.o(143122);
    }
  }
  
  final class i
    extends MMGestureGallery.a
  {
    float[] xtd;
    
    public i()
    {
      super();
      AppMethodBeat.i(143124);
      this.xtd = new float[9];
      AppMethodBeat.o(143124);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143125);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143123);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.i.this.xtd);
          float f2 = MMGestureGallery.i.this.xtd[2];
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).getImageWidth();
          if (f1 < MMGestureGallery.b(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.i.this.dgZ = true;
            }
            for (;;)
            {
              MMGestureGallery.a(MMGestureGallery.this).au(f1, 0.0F);
              AppMethodBeat.o(143123);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.i.this.dgZ = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(143125);
    }
  }
  
  final class j
    extends MMGestureGallery.a
  {
    float[] xtd;
    
    public j()
    {
      super();
      AppMethodBeat.i(143127);
      this.xtd = new float[9];
      AppMethodBeat.o(143127);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143128);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143126);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.j.this.xtd);
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.a(MMGestureGallery.this).getImageWidth() * f1;
          float f3 = MMGestureGallery.j.this.xtd[2];
          f1 = MMGestureGallery.b(MMGestureGallery.this);
          if (f2 < MMGestureGallery.b(MMGestureGallery.this)) {
            f1 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.j.this.dgZ = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.this).au(f1, 0.0F);
            AppMethodBeat.o(143126);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.j.this.dgZ = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(143128);
    }
  }
  
  final class k
    extends MMGestureGallery.a
  {
    float[] xtd;
    
    public k()
    {
      super();
      AppMethodBeat.i(143130);
      this.xtd = new float[9];
      AppMethodBeat.o(143130);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143131);
      MMGestureGallery.c(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143129);
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.k.this.xtd);
          float f2 = MMGestureGallery.k.this.xtd[5];
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).getImageHeight();
          if (f1 < MMGestureGallery.d(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.k.this.dgZ = true;
            }
            for (;;)
            {
              MMGestureGallery.a(MMGestureGallery.this).au(0.0F, f1);
              AppMethodBeat.o(143129);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.k.this.dgZ = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(143131);
    }
  }
  
  public static final class l
    extends MMHandler
  {
    private boolean edG;
    WeakReference<MMGestureGallery> xoV;
    private long xtj;
    
    public l(WeakReference<MMGestureGallery> paramWeakReference)
    {
      this.xoV = paramWeakReference;
    }
    
    public final void S(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(143136);
      this.edG = paramBoolean;
      m(0, paramLong, 0L);
      AppMethodBeat.o(143136);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(143134);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.xoV != null)
      {
        final MMGestureGallery localMMGestureGallery = (MMGestureGallery)this.xoV.get();
        if (localMMGestureGallery != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MMGestureGallery.w(localMMGestureGallery) == 1) || (this.edG))
            {
              Log.d("MicroMsg.MMGestureGallery", "single click over!");
              if (MMGestureGallery.q(localMMGestureGallery) != null) {
                MMGestureGallery.c(localMMGestureGallery).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143132);
                    MMGestureGallery.q(localMMGestureGallery).bmt();
                    AppMethodBeat.o(143132);
                  }
                });
              }
            }
            MMGestureGallery.a(localMMGestureGallery, 0);
            AppMethodBeat.o(143134);
            return;
          }
          if (paramMessage.what == 1)
          {
            if ((MMGestureGallery.R(localMMGestureGallery) != null) && (!MMGestureGallery.R(localMMGestureGallery).deQ()))
            {
              MMGestureGallery.R(localMMGestureGallery).play();
              sendEmptyMessageDelayed(paramMessage.what, this.xtj);
              AppMethodBeat.o(143134);
              return;
            }
            MMGestureGallery.S(localMMGestureGallery);
            AppMethodBeat.o(143134);
            return;
          }
          removeMessages(2);
          if (MMGestureGallery.T(localMMGestureGallery) != null) {
            MMGestureGallery.c(localMMGestureGallery).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(143133);
                MMGestureGallery.T(localMMGestureGallery).bmu();
                AppMethodBeat.o(143133);
              }
            });
          }
        }
      }
      AppMethodBeat.o(143134);
    }
    
    public final void m(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(143135);
      this.xtj = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(143135);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery
 * JD-Core Version:    0.7.0.1
 */