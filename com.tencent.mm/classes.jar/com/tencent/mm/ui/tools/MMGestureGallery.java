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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MMGestureGallery
  extends Gallery
{
  private long Cfh;
  private long Cfi;
  private float Cfj;
  private float Cfk;
  private long Cfl;
  private boolean Cfm;
  private OverScroller Cfn;
  private GestureDetector Cfo;
  private RectF Cfp;
  private float Cfr;
  private boolean Cfs;
  private boolean Cft;
  private boolean Cfu;
  private boolean Cfv;
  private boolean KVq;
  private boolean KVr;
  private boolean KVs;
  private final int WnD;
  private final int WnE;
  private boolean Wnj;
  private boolean Wnk;
  private boolean Wnl;
  private boolean Wnm;
  private boolean Wnn;
  private l XSD;
  private l XSE;
  private l XSF;
  private a XSG;
  private f XSH;
  private MMGestureGallery.c XSI;
  private e XSJ;
  private boolean XSK;
  private b XSL;
  private float aIC;
  private float aID;
  private int amg;
  private int amh;
  private int count;
  private float eYT;
  private MMHandler handler;
  private VelocityTracker mVelocityTracker;
  private MultiTouchImageView oQr;
  private int pEj;
  private int pEk;
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143139);
    this.Cfm = false;
    this.Wnk = false;
    this.Wnl = false;
    this.Wnm = false;
    this.Wnn = false;
    this.Cfs = false;
    this.Cft = false;
    this.Cfu = false;
    this.Cfv = false;
    this.count = 0;
    this.Cfh = 0L;
    this.Cfi = 0L;
    this.Cfj = 0.0F;
    this.Cfk = 0.0F;
    this.Cfl = 0L;
    this.Cfp = new RectF();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.XSK = true;
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.Wnj = false;
    this.WnD = 60;
    this.WnE = 500;
    setStaticTransformationsEnabled(true);
    this.Cfo = new GestureDetector(paramContext, new MMGestureGallery.d(this, (byte)0));
    this.XSD = new l(new WeakReference(this));
    this.XSE = new l(new WeakReference(this));
    this.XSF = new l(new WeakReference(this));
    this.Cfn = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    float f = getResources().getDisplayMetrics().density;
    setOnTouchListener(new View.OnTouchListener()
    {
      private void Hc(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143116);
        MMGestureGallery.k(MMGestureGallery.this).S(350L, paramAnonymousBoolean);
        AppMethodBeat.o(143116);
      }
      
      private void hYs()
      {
        AppMethodBeat.i(143113);
        hYt();
        MMGestureGallery.e(MMGestureGallery.this).p(2, 500L, 0L);
        AppMethodBeat.o(143113);
      }
      
      private void hYt()
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
                MMGestureGallery.h(MMGestureGallery.this).U(0.0F, 0.0F);
              }
              MMGestureGallery.a(MMGestureGallery.this, false);
            }
            if ((MMGestureGallery.i(MMGestureGallery.this)) && (!MMGestureGallery.j(MMGestureGallery.this)))
            {
              MMGestureGallery.k(MMGestureGallery.this).S(0L, true);
              MMGestureGallery.a(MMGestureGallery.this, false);
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 2) && (f.ar(paramAnonymousMotionEvent) < 2))
          {
            paramAnonymousView = MMGestureGallery.f(MMGestureGallery.this);
            paramAnonymousView.computeCurrentVelocity(1000);
            int i = (int)paramAnonymousView.getXVelocity();
            int j = (int)paramAnonymousView.getYVelocity();
            f1 = paramAnonymousMotionEvent.getX() - MMGestureGallery.l(MMGestureGallery.this);
            f2 = paramAnonymousMotionEvent.getY() - MMGestureGallery.m(MMGestureGallery.this);
            if ((MMGestureGallery.h(MMGestureGallery.this) != null) && (!MMGestureGallery.j(MMGestureGallery.this)) && (!MMGestureGallery.n(MMGestureGallery.this)))
            {
              MMGestureGallery.h(MMGestureGallery.this).V(f1, f2);
              if (((Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (j <= 0) || (MMGestureGallery.o(MMGestureGallery.this))) && (!MMGestureGallery.i(MMGestureGallery.this))) {
                break label749;
              }
              MMGestureGallery.h(MMGestureGallery.this).U(f1, f2);
              MMGestureGallery.a(MMGestureGallery.this, true);
              if (f2 <= 200.0F) {
                break label761;
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
            break label773;
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            MMGestureGallery.c(MMGestureGallery.this, f.j(paramAnonymousMotionEvent, 0));
            MMGestureGallery.d(MMGestureGallery.this, f.k(paramAnonymousMotionEvent, 0));
          }
          paramAnonymousView = localView.findViewById(a.g.image);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0) && (!(paramAnonymousView instanceof MultiTouchImageView)))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              hYs();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              hYt();
            }
          }
          paramAnonymousView = localView.findViewById(a.g.video_image);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0) && (!(paramAnonymousView instanceof MultiTouchImageView)))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              hYs();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              hYt();
            }
          }
          paramAnonymousView = localView.findViewById(a.g.video_view);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              hYs();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              hYt();
            }
          }
          paramAnonymousView = localView.findViewById(a.g.image_gallery_download_success);
          if (((paramAnonymousView == null) || (paramAnonymousView.getVisibility() == 8)) && (MMGestureGallery.p(MMGestureGallery.this)) && (MMGestureGallery.q(MMGestureGallery.this) != null) && (paramAnonymousMotionEvent.getAction() == 1) && (Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) < 10.0F) && (!MMGestureGallery.o(MMGestureGallery.this))) {
            Hc(true);
          }
          if (paramAnonymousMotionEvent.getAction() == 1) {
            MMGestureGallery.t(MMGestureGallery.this);
          }
          if (paramAnonymousView != null)
          {
            localView = paramAnonymousView.findViewById(a.g.image);
            paramAnonymousView = localView;
            if (localView != null) {
              break label773;
            }
          }
          AppMethodBeat.o(143115);
          return false;
          label749:
          MMGestureGallery.a(MMGestureGallery.this, false);
          break;
          label761:
          MMGestureGallery.b(MMGestureGallery.this, true);
        }
        label773:
        float f3;
        if ((paramAnonymousView instanceof MultiTouchImageView))
        {
          MMGestureGallery.a(MMGestureGallery.this, (MultiTouchImageView)paramAnonymousView);
          Log.d("dktest", "MMGestureGallery onTouch event.getAction():" + paramAnonymousMotionEvent.getAction());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            hYs();
            MMGestureGallery.a(MMGestureGallery.this).hJz();
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
              hYt();
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
                  break label2027;
                }
                if (MMGestureGallery.u(MMGestureGallery.this) <= f3 + 0.05D) {
                  MMGestureGallery.a(MMGestureGallery.this).aB(f1 + f.j(paramAnonymousMotionEvent, 1), f2 + f.k(paramAnonymousMotionEvent, 1));
                }
              }
              label1167:
              if (MMGestureGallery.u(MMGestureGallery.this) > MMGestureGallery.a(MMGestureGallery.this).getDoubleTabScale() * 2.0F)
              {
                f1 = f.j(paramAnonymousMotionEvent, 0);
                f2 = f.j(paramAnonymousMotionEvent, 1);
                f3 = f.k(paramAnonymousMotionEvent, 0);
                float f4 = f.k(paramAnonymousMotionEvent, 1);
                MMGestureGallery.a(MMGestureGallery.this).setMaxZoomLimit(MMGestureGallery.a(MMGestureGallery.this).getDoubleTabScale() * 2.0F);
                MMGestureGallery.a(MMGestureGallery.this).s(MMGestureGallery.a(MMGestureGallery.this).getDoubleTabScale() * 2.0F, f1 - f2 + f.j(paramAnonymousMotionEvent, 1), f3 - f4 + f.k(paramAnonymousMotionEvent, 1));
                MMGestureGallery.a(MMGestureGallery.this).hJy();
              }
            }
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              hYt();
              MMGestureGallery.z(MMGestureGallery.this);
              MMGestureGallery.A(MMGestureGallery.this);
              MMGestureGallery.t(MMGestureGallery.this);
              if (((!MMGestureGallery.B(MMGestureGallery.this)) && (!MMGestureGallery.C(MMGestureGallery.this)) && (!MMGestureGallery.D(MMGestureGallery.this)) && (!MMGestureGallery.E(MMGestureGallery.this))) || ((!MMGestureGallery.F(MMGestureGallery.this)) && (!MMGestureGallery.G(MMGestureGallery.this)))) {
                break label2055;
              }
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.h(MMGestureGallery.this));
              MMGestureGallery.H(MMGestureGallery.this);
              MMGestureGallery.I(MMGestureGallery.this);
              MMGestureGallery.J(MMGestureGallery.this);
              MMGestureGallery.K(MMGestureGallery.this);
              MMGestureGallery.L(MMGestureGallery.this);
              MMGestureGallery.M(MMGestureGallery.this);
              MMGestureGallery.N(MMGestureGallery.this);
              label1462:
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.a(MMGestureGallery.this).getScale());
              if (MMGestureGallery.w(MMGestureGallery.this) == 1)
              {
                MMGestureGallery.c(MMGestureGallery.this, System.currentTimeMillis());
                if (MMGestureGallery.y(MMGestureGallery.this) - MMGestureGallery.O(MMGestureGallery.this) >= 350L) {
                  break label2270;
                }
                if ((Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) < 10.0F)) {
                  Hc(false);
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
              break label2372;
            }
            if (f.ar(paramAnonymousMotionEvent) != 2) {
              break label2449;
            }
            hYt();
            if ((!MMGestureGallery.P(MMGestureGallery.this)) && (!MMGestureGallery.D(MMGestureGallery.this)) && (!MMGestureGallery.E(MMGestureGallery.this))) {
              break label2291;
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
                  MMGestureGallery.a(MMGestureGallery.this).A(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                  break;
                }
                if (MMGestureGallery.a(MMGestureGallery.this).getOriginScale() > 0.0F)
                {
                  if (f1 <= MMGestureGallery.a(MMGestureGallery.this).getOriginScale() + 0.05D)
                  {
                    MMGestureGallery.a(MMGestureGallery.this).A(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                    break;
                  }
                  MMGestureGallery.a(MMGestureGallery.this).aA(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                  break;
                }
                MMGestureGallery.a(MMGestureGallery.this).ay(f.j(paramAnonymousMotionEvent, 0), f.k(paramAnonymousMotionEvent, 0));
                MMGestureGallery.a(MMGestureGallery.this).hJy();
                break;
              }
              MMGestureGallery.a(MMGestureGallery.this, 1);
              break;
            }
            MMGestureGallery.a(MMGestureGallery.this, 1);
            break;
            label2027:
            MMGestureGallery.a(MMGestureGallery.this).ay(f1 + f.j(paramAnonymousMotionEvent, 1), f2 + f.k(paramAnonymousMotionEvent, 1));
            break label1167;
            label2055:
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
              break label1462;
            }
            MMGestureGallery.N(MMGestureGallery.this);
            MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.g(MMGestureGallery.this));
            MMGestureGallery.H(MMGestureGallery.this);
            break label1462;
            label2270:
            MMGestureGallery.a(MMGestureGallery.this, 0);
            Log.d("MicroMsg.MMGestureGallery", "single long click over!");
          }
          label2291:
          MMGestureGallery.c(MMGestureGallery.this, true);
          MMGestureGallery.a(MMGestureGallery.this, 0);
          f1 = f.j(paramAnonymousMotionEvent, 0) - f.j(paramAnonymousMotionEvent, 1);
          f2 = f.k(paramAnonymousMotionEvent, 0) - f.k(paramAnonymousMotionEvent, 1);
          f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
          if (MMGestureGallery.Q(MMGestureGallery.this) != 0.0F) {
            break label2379;
          }
          MMGestureGallery.e(MMGestureGallery.this, f3);
        }
        for (;;)
        {
          label2372:
          AppMethodBeat.o(143115);
          return false;
          label2379:
          f3 /= MMGestureGallery.Q(MMGestureGallery.this);
          if (MMGestureGallery.n(MMGestureGallery.this))
          {
            MMGestureGallery.a(MMGestureGallery.this).s(f3 * MMGestureGallery.u(MMGestureGallery.this), f1 + f.j(paramAnonymousMotionEvent, 1), f.k(paramAnonymousMotionEvent, 1) + f2);
            MMGestureGallery.a(MMGestureGallery.this).hJy();
            continue;
            label2449:
            if ((Math.abs(MMGestureGallery.r(MMGestureGallery.this) - f.j(paramAnonymousMotionEvent, 0)) > 35.0F) || (Math.abs(MMGestureGallery.s(MMGestureGallery.this) - f.k(paramAnonymousMotionEvent, 0)) > 35.0F))
            {
              hYt();
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
    this.Cfm = false;
    this.Wnk = false;
    this.Wnl = false;
    this.Wnm = false;
    this.Wnn = false;
    this.Cfs = false;
    this.Cft = false;
    this.Cfu = false;
    this.Cfv = false;
    this.count = 0;
    this.Cfh = 0L;
    this.Cfi = 0L;
    this.Cfj = 0.0F;
    this.Cfk = 0.0F;
    this.Cfl = 0L;
    this.Cfp = new RectF();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.XSK = true;
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.Wnj = false;
    this.WnD = 60;
    this.WnE = 500;
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
    if ((this.Wnl) || (this.Wnk)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(143142);
      return true;
      if (getPositionForView(paramView) == getAdapter().getCount() - 1)
      {
        if (this.Wnn)
        {
          if (paramFloat3 > 0.0F)
          {
            if (paramFloat2 >= this.pEj) {
              this.oQr.az(-paramFloat3, 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if ((paramFloat2 > this.pEj * 0.7F) && (paramFloat2 < this.pEk)) {
                this.oQr.az(-(paramFloat3 * 0.3F), 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 > 0.0F)
        {
          if (paramFloat2 < this.pEj) {
            this.Wnn = true;
          }
          if (paramFloat2 >= this.pEj) {
            this.oQr.az(-paramFloat3, 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((paramFloat2 > this.pEj * 0.7F) && (paramFloat2 < this.pEk)) {
              this.oQr.az(-(paramFloat3 * 0.3F), 0.0F);
            }
          }
        }
      }
      this.Wnn = false;
      i = 0;
    }
    if ((this.Wnl) || (this.Wnk)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(143142);
      return true;
      if (getPositionForView(paramView) == 0)
      {
        if (this.Wnm)
        {
          if (paramFloat3 < 0.0F)
          {
            if ((paramFloat1 > 0.0F) && (paramFloat1 < this.pEj * 0.3F)) {
              this.oQr.az(-(paramFloat3 * 0.3F), 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if (paramFloat1 <= 0.0F) {
                this.oQr.az(-paramFloat3, 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 < 0.0F)
        {
          if (paramFloat1 > 0.0F) {
            this.Wnm = true;
          }
          if ((paramFloat1 > 0.0F) && (paramFloat1 < this.pEj * 0.3F)) {
            this.oQr.az(-(paramFloat3 * 0.3F), 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if (paramFloat1 <= 0.0F) {
              this.oQr.az(-paramFloat3, 0.0F);
            }
          }
        }
      }
      this.Wnm = false;
      i = 0;
    }
    AppMethodBeat.o(143142);
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143141);
    if (this.Wnk)
    {
      AppMethodBeat.o(143141);
      return true;
    }
    this.Wnl = true;
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
  
  private void eve()
  {
    AppMethodBeat.i(143138);
    this.XSD.removeMessages(1);
    AppMethodBeat.o(143138);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143152);
    Log.d("MicroMsg.MMGestureGallery", "computeScrollOffset: %s.", new Object[] { Boolean.valueOf(this.Cfn.computeScrollOffset()) });
    if (this.oQr == null)
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
    if (this.Cfn.computeScrollOffset())
    {
      Log.d("MicroMsg.MMGestureGallery", "mFlingScroller.getCurrX(): %s, mFlingScroller.getCurrY(): %s.", new Object[] { Integer.valueOf(this.Cfn.getCurrX()), Integer.valueOf(this.Cfn.getCurrY()) });
      i = this.Cfn.getCurrX() - this.amg;
      int m = this.Cfn.getCurrY() - this.amh;
      Log.d("MicroMsg.MMGestureGallery", " scrollX: %s, scrollY: %s, mLastFlingX: %s, mLastFlingY: %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(this.amg), Integer.valueOf(this.amh) });
      this.amg = this.Cfn.getCurrX();
      this.amh = this.Cfn.getCurrY();
      float f3 = this.oQr.getScale();
      f4 = this.oQr.getImageWidth();
      f1 = this.oQr.getScale() * this.oQr.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.oQr.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      Log.d("MicroMsg.MMGestureGallery", "left: %s, right: %s, top: %s, bottom: %s.", new Object[] { Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5) });
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.Cfp.right - Math.round(f3)) {
          j = (int)(this.Cfp.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.Cfp.left - Math.round(f2)) {
          i = (int)(this.Cfp.left - Math.round(f2));
        }
      }
      k = m;
      if (m < 0)
      {
        k = m;
        if (m < this.Cfp.bottom - Math.round(f5)) {
          k = (int)(this.Cfp.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.Cfp.top - Math.round(f4)) {
          j = (int)(this.Cfp.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.Cfp.left) && (Math.round(f3) > this.Cfp.right)) {
        break label586;
      }
      k = 0;
    }
    for (;;)
    {
      if (f1 < this.pEk) {
        j = 0;
      }
      this.oQr.az(k, j);
      postInvalidate();
      AppMethodBeat.o(143152);
      return;
      label586:
      if (Math.round(f4) < this.Cfp.top)
      {
        k = i;
        if (Math.round(f5) > this.Cfp.bottom) {}
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
    return this.pEj;
  }
  
  public int getXDown()
  {
    return (int)this.aIC;
  }
  
  public int getYDown()
  {
    return (int)this.aID;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143144);
    if (this.Cfn != null) {
      this.Cfn.forceFinished(true);
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
      localObject1 = ((View)localObject2).findViewById(a.g.image_gallery_download_success);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        a(paramMotionEvent1, paramMotionEvent2, paramFloat1);
        AppMethodBeat.o(143145);
        return false;
      }
      localObject2 = ((View)localObject1).findViewById(a.g.image);
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
      if ((((MultiTouchImageView)localObject1).aGK) || (((MultiTouchImageView)localObject1).aGJ) || ((int)f2 > this.pEj) || ((int)f3 > this.pEk))
      {
        localObject2 = new float[9];
        ((MultiTouchImageView)localObject1).getImageMatrix().getValues((float[])localObject2);
        f1 = localObject2[2];
        float f6 = f1 + f2;
        f4 = localObject2[5];
        f5 = f4 + f3;
        Log.d("MicroMsg.MMGestureGallery", "left: %f, right: %f, top: %f, bottom: %f, velocityX: %f, velocityY: %f.", new Object[] { Float.valueOf(f1), Float.valueOf(f6), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f1) < this.Cfp.left) && (Math.round(f6) > this.Cfp.right)) {
          break label614;
        }
      }
    }
    label614:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f4) >= this.Cfp.top) || (Math.round(f5) <= this.Cfp.bottom)) {
        paramFloat2 = 0.0F;
      }
      if (Math.round(f4) < this.Cfp.top) {}
      for (this.Wnj = true;; this.Wnj = false)
      {
        int i = (int)(this.Cfp.right - f2);
        int j = (int)(this.Cfp.right + f2);
        int k = (int)(this.Cfp.bottom - f3);
        int m = (int)(this.Cfp.bottom + f3);
        Log.d("MicroMsg.MMGestureGallery", "minX: %d, maxX: %d, minY: %d, maxY: %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        Log.d("MicroMsg.MMGestureGallery", "vx: %f, vy: %f.", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat2) });
        this.Cfn.forceFinished(true);
        this.Cfn.fling(this.Cfn.getCurrX(), this.Cfn.getCurrY(), (int)f1, (int)paramFloat2, i, j, k, m, 0, 0);
        if (!this.Cfm) {
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
    this.KVs = true;
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(143146);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143140);
    super.onMeasure(paramInt1, paramInt2);
    this.pEj = View.MeasureSpec.getSize(paramInt1);
    this.pEk = View.MeasureSpec.getSize(paramInt2);
    this.Cfp.set(0.0F, 0.0F, this.pEj, this.pEk);
    Log.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.pEj + " height:" + this.pEk);
    AppMethodBeat.o(143140);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143143);
    if ((this.Cfm) || (this.KVq))
    {
      AppMethodBeat.o(143143);
      return true;
    }
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    boolean bool;
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = ((View)localObject2).findViewById(a.g.image_gallery_download_success);
      if ((localObject1 == null) || (((View)localObject1).getVisibility() == 8))
      {
        bool = a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        AppMethodBeat.o(143143);
        return bool;
      }
      localObject2 = ((View)localObject1).findViewById(a.g.image);
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
      this.oQr = ((MultiTouchImageView)localObject1);
      localObject2 = new float[9];
      this.oQr.getImageMatrix().getValues((float[])localObject2);
      f1 = this.oQr.getScale() * this.oQr.getImageWidth();
      float f2 = this.oQr.getScale() * this.oQr.getImageHeight();
      f5 = localObject2[2];
      f4 = f5 + f1;
      f6 = localObject2[5];
      f7 = f6 + f2;
      localObject2 = new Rect();
      this.oQr.getGlobalVisibleRect((Rect)localObject2);
      if (((int)f1 <= this.pEj) && ((int)f2 <= this.pEk))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.pEj)
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
        if (!this.Wnl) {
          this.oQr.az(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (((int)f1 <= this.pEj) && ((int)f2 > this.pEk))
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          if ((this.Wnl) || (this.Wnm) || (this.Wnn))
          {
            AppMethodBeat.o(143143);
            return true;
          }
          this.Wnk = true;
          f2 = 0.0F;
          float f3 = 0.0F;
          if (paramFloat2 < 0.0F)
          {
            if (f6 > this.Cfp.top) {
              this.Cfs = true;
            }
            if ((f6 <= this.Cfp.top) || (f7 < this.pEk))
            {
              f1 = -paramFloat2;
              if ((paramFloat1 >= 0.0F) || (f5 <= this.Cfp.left)) {
                break label691;
              }
              this.Cfu = true;
              paramFloat2 = -(0.3F * paramFloat1);
            }
          }
          for (;;)
          {
            this.oQr.az(paramFloat2, f1);
            AppMethodBeat.o(143143);
            return true;
            f1 = f3;
            if (f6 <= this.Cfp.top) {
              break;
            }
            f1 = f3;
            if (f6 >= this.pEk * 0.3F) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            if (f7 < this.Cfp.bottom) {
              this.Cft = true;
            }
            if ((f6 > 0.0F) || (f7 >= this.pEk))
            {
              f1 = -paramFloat2;
              break;
            }
            f1 = f3;
            if (f7 <= this.pEk * 0.7F) {
              break;
            }
            f1 = f3;
            if (f7 >= this.pEk) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            label691:
            paramFloat2 = f2;
            if (paramFloat1 > 0.0F)
            {
              paramFloat2 = f2;
              if (f4 < this.Cfp.right)
              {
                this.Cfv = true;
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
          if (f4 <= this.pEj)
          {
            if (f4 > this.pEj * 0.7F)
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
          if (f5 < this.pEj * 0.3F)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
            AppMethodBeat.o(143143);
            return bool;
          }
          bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
          AppMethodBeat.o(143143);
          return bool;
        }
        if (!this.Wnl) {
          this.oQr.az(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (((int)f1 > this.pEj) && ((int)f2 <= this.pEk))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.pEj)
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
        if (!this.Wnl) {
          this.oQr.az(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        if (paramFloat1 == 0.0F) {
          break label1581;
        }
        this.Wnl = true;
        if (paramFloat1 < 0.0F)
        {
          if (f5 > this.Cfp.left) {
            this.Cfu = true;
          }
          f1 = paramFloat1;
          if (f5 > this.Cfp.left)
          {
            if (f4 >= this.pEj) {
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
        this.Wnk = true;
        if (paramFloat2 < 0.0F)
        {
          if (f6 > this.Cfp.top) {
            this.Cfs = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > this.Cfp.top)
          {
            if (f7 >= this.pEk) {
              break label1329;
            }
            paramFloat1 = paramFloat2;
          }
        }
      }
      for (;;)
      {
        this.oQr.az(-f1, -paramFloat1);
        AppMethodBeat.o(143143);
        return true;
        label1213:
        if ((f5 <= this.Cfp.left) || (f5 >= this.pEj * 0.3F)) {
          break label1581;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        if (f4 < this.Cfp.right) {
          this.Cfv = true;
        }
        f1 = paramFloat1;
        if (f5 > 0.0F) {
          break;
        }
        f1 = paramFloat1;
        if (f4 >= this.pEj) {
          break;
        }
        if ((f4 <= this.pEj * 0.7F) || (f4 >= this.pEj)) {
          break label1581;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        label1329:
        if ((f6 > this.Cfp.top) && (f6 < this.pEk * 0.3F))
        {
          paramFloat1 = paramFloat2 * 0.3F;
          continue;
          if (f7 < this.Cfp.bottom) {
            this.Cft = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > 0.0F) {
            continue;
          }
          paramFloat1 = paramFloat2;
          if (f7 >= this.pEk) {
            continue;
          }
          if ((f7 > this.pEk * 0.7F) && (f7 < this.pEk))
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
              if (f4 <= this.pEj)
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
            if (!this.Wnl) {
              this.oQr.az(-paramFloat1, -paramFloat2);
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
    Object localObject = this.Cfo;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
        this.oQr = ((MultiTouchImageView)localObject);
        float f2 = this.oQr.getScale() * this.oQr.getImageWidth();
        float f1 = this.oQr.getScale() * this.oQr.getImageHeight();
        if (((int)f2 <= this.pEj) && ((int)f1 <= this.pEk))
        {
          Log.i("dktest", "onTouchEvent width:" + f2 + "height:" + f1);
        }
        else
        {
          localObject = new float[9];
          this.oQr.getImageMatrix().getValues((float[])localObject);
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
    this.XSL = paramb;
  }
  
  public void setLoadQuit(boolean paramBoolean)
  {
    this.XSK = paramBoolean;
  }
  
  public void setLongClickOverListener(MMGestureGallery.c paramc)
  {
    this.XSI = paramc;
  }
  
  public void setScrollLeftRightListener(e parame)
  {
    this.XSJ = parame;
  }
  
  public void setSingleClickOverListener(f paramf)
  {
    this.XSH = paramf;
  }
  
  abstract class a
  {
    protected boolean eYG = false;
    
    public a() {}
    
    public final boolean evg()
    {
      return this.eYG;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b
  {
    public abstract void U(float paramFloat1, float paramFloat2);
    
    public abstract void V(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface e {}
  
  public static abstract interface f
  {
    public abstract void bwB();
  }
  
  final class g
    extends MMGestureGallery.a
  {
    float[] CfC;
    
    public g()
    {
      super();
      AppMethodBeat.i(143118);
      this.CfC = new float[9];
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
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.g.this.CfC);
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.a(MMGestureGallery.this).getImageHeight() * f1;
          float f3 = MMGestureGallery.g.this.CfC[5];
          f1 = MMGestureGallery.d(MMGestureGallery.this);
          if (f2 < MMGestureGallery.d(MMGestureGallery.this)) {
            f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.g.this.eYG = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.this).az(0.0F, f1);
            AppMethodBeat.o(143117);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.g.this.eYG = true;
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
    float[] CfC;
    
    public h()
    {
      super();
      AppMethodBeat.i(143121);
      this.CfC = new float[9];
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
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.h.this.CfC);
          float f5 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).getImageWidth();
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f8 = MMGestureGallery.a(MMGestureGallery.this).getImageHeight() * f1;
          float f7 = MMGestureGallery.h.this.CfC[2];
          float f10 = MMGestureGallery.h.this.CfC[5];
          float f6 = MMGestureGallery.h.this.CfC[2];
          float f9 = MMGestureGallery.h.this.CfC[5];
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
                    MMGestureGallery.h.this.eYG = true;
                  }
                  for (;;)
                  {
                    MMGestureGallery.a(MMGestureGallery.this).az(f2, f1);
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
    float[] CfC;
    
    public i()
    {
      super();
      AppMethodBeat.i(143124);
      this.CfC = new float[9];
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
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.i.this.CfC);
          float f2 = MMGestureGallery.i.this.CfC[2];
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).getImageWidth();
          if (f1 < MMGestureGallery.b(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.i.this.eYG = true;
            }
            for (;;)
            {
              MMGestureGallery.a(MMGestureGallery.this).az(f1, 0.0F);
              AppMethodBeat.o(143123);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.i.this.eYG = true;
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
    float[] CfC;
    
    public j()
    {
      super();
      AppMethodBeat.i(143127);
      this.CfC = new float[9];
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
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.j.this.CfC);
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.a(MMGestureGallery.this).getImageWidth() * f1;
          float f3 = MMGestureGallery.j.this.CfC[2];
          f1 = MMGestureGallery.b(MMGestureGallery.this);
          if (f2 < MMGestureGallery.b(MMGestureGallery.this)) {
            f1 = MMGestureGallery.b(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.j.this.eYG = true;
          }
          for (;;)
          {
            MMGestureGallery.a(MMGestureGallery.this).az(f1, 0.0F);
            AppMethodBeat.o(143126);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.j.this.eYG = true;
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
    float[] CfC;
    
    public k()
    {
      super();
      AppMethodBeat.i(143130);
      this.CfC = new float[9];
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
          MMGestureGallery.a(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.k.this.CfC);
          float f2 = MMGestureGallery.k.this.CfC[5];
          float f1 = MMGestureGallery.a(MMGestureGallery.this).getScale() * MMGestureGallery.a(MMGestureGallery.this).getImageHeight();
          if (f1 < MMGestureGallery.d(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.k.this.eYG = true;
            }
            for (;;)
            {
              MMGestureGallery.a(MMGestureGallery.this).az(0.0F, f1);
              AppMethodBeat.o(143129);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.k.this.eYG = true;
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
    WeakReference<MMGestureGallery> Cbq;
    private long CfI;
    private boolean fXP;
    
    public l(WeakReference<MMGestureGallery> paramWeakReference)
    {
      this.Cbq = paramWeakReference;
    }
    
    public final void S(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(143136);
      this.fXP = paramBoolean;
      p(0, paramLong, 0L);
      AppMethodBeat.o(143136);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(143134);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.Cbq != null)
      {
        final MMGestureGallery localMMGestureGallery = (MMGestureGallery)this.Cbq.get();
        if (localMMGestureGallery != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MMGestureGallery.w(localMMGestureGallery) == 1) || (this.fXP))
            {
              Log.d("MicroMsg.MMGestureGallery", "single click over!");
              if (MMGestureGallery.q(localMMGestureGallery) != null) {
                MMGestureGallery.c(localMMGestureGallery).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143132);
                    MMGestureGallery.q(localMMGestureGallery).bwB();
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
            if ((MMGestureGallery.R(localMMGestureGallery) != null) && (!MMGestureGallery.R(localMMGestureGallery).evg()))
            {
              MMGestureGallery.R(localMMGestureGallery).play();
              sendEmptyMessageDelayed(paramMessage.what, this.CfI);
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
                MMGestureGallery.T(localMMGestureGallery).bwC();
                AppMethodBeat.o(143133);
              }
            });
          }
        }
      }
      AppMethodBeat.o(143134);
    }
    
    public final void p(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(143135);
      this.CfI = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(143135);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery
 * JD-Core Version:    0.7.0.1
 */