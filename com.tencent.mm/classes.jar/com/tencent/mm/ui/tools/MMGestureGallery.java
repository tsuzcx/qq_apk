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
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.g;
import java.lang.ref.WeakReference;

public class MMGestureGallery
  extends Gallery
{
  private boolean HRA;
  private boolean HRB;
  private boolean HRC;
  private long HRo;
  private long HRp;
  private float HRq;
  private float HRr;
  private long HRs;
  private boolean HRt;
  private OverScroller HRu;
  private GestureDetector HRv;
  private RectF HRw;
  private float HRy;
  private boolean HRz;
  private boolean Rvo;
  private boolean Rvp;
  private boolean Rvq;
  public boolean SHb;
  private boolean adUA;
  private boolean adUB;
  private boolean adUC;
  private final int adUS;
  private final int adUT;
  private boolean adUy;
  private boolean adUz;
  private n afIO;
  private n afIP;
  private n afIQ;
  private boolean afIR;
  private boolean afIS;
  private a afIT;
  private MMGestureGallery.f afIU;
  private c afIV;
  private e afIW;
  private boolean afIX;
  private b afIY;
  private int caG;
  private int caH;
  private int count;
  private MMHandler handler;
  private float hct;
  private VelocityTracker mVelocityTracker;
  private int pvg;
  private MultiTouchImageView rUf;
  private int sJv;
  private float x_down;
  private float y_down;
  
  public MMGestureGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143139);
    this.HRt = false;
    this.SHb = false;
    this.adUz = false;
    this.adUA = false;
    this.adUB = false;
    this.afIR = false;
    this.adUC = false;
    this.afIS = false;
    this.HRz = false;
    this.HRA = false;
    this.HRB = false;
    this.HRC = false;
    this.count = 0;
    this.HRo = 0L;
    this.HRp = 0L;
    this.HRq = 0.0F;
    this.HRr = 0.0F;
    this.HRs = 0L;
    this.HRw = new RectF();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.afIX = true;
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.adUy = false;
    this.adUS = 60;
    this.adUT = 500;
    setStaticTransformationsEnabled(true);
    this.HRv = new GestureDetector(paramContext, new MMGestureGallery.d(this, (byte)0));
    this.afIO = new n(new WeakReference(this));
    this.afIP = new n(new WeakReference(this));
    this.afIQ = new n(new WeakReference(this));
    this.HRu = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    float f = getResources().getDisplayMetrics().density;
    setOnTouchListener(new View.OnTouchListener()
    {
      boolean aemc = true;
      
      private void MX(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(143116);
        MMGestureGallery.p(MMGestureGallery.this).ad(350L, paramAnonymousBoolean);
        AppMethodBeat.o(143116);
      }
      
      private void jDb()
      {
        AppMethodBeat.i(143113);
        jDc();
        MMGestureGallery.e(MMGestureGallery.this).o(2, 500L, 0L);
        AppMethodBeat.o(143113);
      }
      
      private void jDc()
      {
        AppMethodBeat.i(143114);
        MMGestureGallery.e(MMGestureGallery.this).removeMessages(2);
        AppMethodBeat.o(143114);
      }
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143115);
        if (this.aemc)
        {
          paramAnonymousMotionEvent.setAction(0);
          this.aemc = false;
        }
        if (paramAnonymousMotionEvent.getActionMasked() == 1)
        {
          this.aemc = true;
          if (MMGestureGallery.f(MMGestureGallery.this))
          {
            MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.j(MMGestureGallery.this));
            MMGestureGallery.g(MMGestureGallery.this);
            MMGestureGallery.h(MMGestureGallery.this);
          }
          if (MMGestureGallery.i(MMGestureGallery.this))
          {
            MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.l(MMGestureGallery.this));
            MMGestureGallery.g(MMGestureGallery.this);
            MMGestureGallery.j(MMGestureGallery.this);
          }
        }
        if (MMGestureGallery.k(MMGestureGallery.this) == null) {
          MMGestureGallery.a(MMGestureGallery.this, VelocityTracker.obtain());
        }
        MMGestureGallery.k(MMGestureGallery.this).addMovement(paramAnonymousMotionEvent);
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
            if (MMGestureGallery.l(MMGestureGallery.this))
            {
              if (MMGestureGallery.m(MMGestureGallery.this) != null) {
                MMGestureGallery.m(MMGestureGallery.this).onGalleryScale(0.0F, 0.0F);
              }
              MMGestureGallery.a(MMGestureGallery.this, false);
            }
            if ((MMGestureGallery.n(MMGestureGallery.this)) && (!MMGestureGallery.o(MMGestureGallery.this)))
            {
              MMGestureGallery.p(MMGestureGallery.this).ad(0L, true);
              MMGestureGallery.a(MMGestureGallery.this, false);
            }
          }
          if ((paramAnonymousMotionEvent.getAction() == 2) && (g.au(paramAnonymousMotionEvent) < 2))
          {
            paramAnonymousView = MMGestureGallery.k(MMGestureGallery.this);
            paramAnonymousView.computeCurrentVelocity(1000);
            int i = (int)paramAnonymousView.getXVelocity();
            int j = (int)paramAnonymousView.getYVelocity();
            f1 = paramAnonymousMotionEvent.getX() - MMGestureGallery.q(MMGestureGallery.this);
            f2 = paramAnonymousMotionEvent.getY() - MMGestureGallery.r(MMGestureGallery.this);
            if ((MMGestureGallery.m(MMGestureGallery.this) != null) && (!MMGestureGallery.o(MMGestureGallery.this)) && (!MMGestureGallery.s(MMGestureGallery.this)))
            {
              MMGestureGallery.m(MMGestureGallery.this).aC(f1, f2);
              if (((Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (j <= 0) || (MMGestureGallery.t(MMGestureGallery.this))) && (!MMGestureGallery.n(MMGestureGallery.this))) {
                break label890;
              }
              MMGestureGallery.m(MMGestureGallery.this).onGalleryScale(f1, f2);
              MMGestureGallery.a(MMGestureGallery.this, true);
              if ((MMGestureGallery.this.SHb) || (f2 <= 200.0F)) {
                break label902;
              }
              MMGestureGallery.b(MMGestureGallery.this, false);
            }
          }
        }
        for (;;)
        {
          if (MMGestureGallery.k(MMGestureGallery.this) != null)
          {
            MMGestureGallery.k(MMGestureGallery.this).recycle();
            MMGestureGallery.a(MMGestureGallery.this, null);
          }
          paramAnonymousView = localView;
          if (!(localView instanceof ViewGroup)) {
            break label914;
          }
          paramAnonymousView = localView;
          if ((localView instanceof WxImageView)) {
            break label914;
          }
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            MMGestureGallery.c(MMGestureGallery.this, g.k(paramAnonymousMotionEvent, 0));
            MMGestureGallery.d(MMGestureGallery.this, g.l(paramAnonymousMotionEvent, 0));
          }
          paramAnonymousView = localView.findViewById(a.g.image);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0) && (!(paramAnonymousView instanceof MultiTouchImageView)))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              jDb();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              jDc();
            }
          }
          paramAnonymousView = localView.findViewById(a.g.video_image);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0) && (!(paramAnonymousView instanceof MultiTouchImageView)))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              jDb();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              jDc();
            }
          }
          paramAnonymousView = localView.findViewById(a.g.video_view);
          if ((paramAnonymousView != null) && (paramAnonymousView.getVisibility() == 0))
          {
            if (paramAnonymousMotionEvent.getAction() == 0) {
              jDb();
            }
            if (paramAnonymousMotionEvent.getAction() == 1) {
              jDc();
            }
          }
          paramAnonymousView = localView.findViewById(a.g.image_gallery_download_success);
          if (((paramAnonymousView == null) || (paramAnonymousView.getVisibility() == 8)) && (MMGestureGallery.u(MMGestureGallery.this)) && (MMGestureGallery.v(MMGestureGallery.this) != null) && (paramAnonymousMotionEvent.getAction() == 1) && (Math.abs(MMGestureGallery.w(MMGestureGallery.this) - g.k(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.x(MMGestureGallery.this) - g.l(paramAnonymousMotionEvent, 0)) < 10.0F) && (!MMGestureGallery.t(MMGestureGallery.this))) {
            MX(true);
          }
          if (paramAnonymousMotionEvent.getAction() == 1) {
            MMGestureGallery.y(MMGestureGallery.this);
          }
          if (paramAnonymousView != null)
          {
            localView = paramAnonymousView.findViewById(a.g.image);
            paramAnonymousView = localView;
            if (localView != null) {
              break label914;
            }
          }
          AppMethodBeat.o(143115);
          return false;
          label890:
          MMGestureGallery.a(MMGestureGallery.this, false);
          break;
          label902:
          MMGestureGallery.b(MMGestureGallery.this, true);
        }
        label914:
        float f3;
        if ((paramAnonymousView instanceof MultiTouchImageView))
        {
          MMGestureGallery.a(MMGestureGallery.this, (MultiTouchImageView)paramAnonymousView);
          Log.d("dktest", "MMGestureGallery onTouch event.getAction():" + paramAnonymousMotionEvent.getAction());
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            jDb();
            MMGestureGallery.b(MMGestureGallery.this).jmc();
            MMGestureGallery.e(MMGestureGallery.this, 0.0F);
            MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.b(MMGestureGallery.this).getScale());
            Log.d("dktest", "originalScale :" + MMGestureGallery.z(MMGestureGallery.this));
            MMGestureGallery.c(MMGestureGallery.this, false);
            MMGestureGallery.A(MMGestureGallery.this);
            if (MMGestureGallery.B(MMGestureGallery.this) == 1)
            {
              MMGestureGallery.a(MMGestureGallery.this, System.currentTimeMillis());
              MMGestureGallery.c(MMGestureGallery.this, g.k(paramAnonymousMotionEvent, 0));
              MMGestureGallery.d(MMGestureGallery.this, g.l(paramAnonymousMotionEvent, 0));
            }
          }
          else
          {
            if ((paramAnonymousMotionEvent.getAction() == 6) || (paramAnonymousMotionEvent.getAction() == 262))
            {
              jDc();
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.b(MMGestureGallery.this).getScale());
              MMGestureGallery.c(MMGestureGallery.this, true);
              Log.i("MicroMsg.MMGestureGallery", "originalScale:%f, scale:%f", new Object[] { Float.valueOf(MMGestureGallery.z(MMGestureGallery.this)), Float.valueOf(MMGestureGallery.b(MMGestureGallery.this).getScaleRate()) });
              if (MMGestureGallery.z(MMGestureGallery.this) < MMGestureGallery.b(MMGestureGallery.this).getScaleRate())
              {
                f1 = g.k(paramAnonymousMotionEvent, 0) - g.k(paramAnonymousMotionEvent, 1);
                f2 = g.l(paramAnonymousMotionEvent, 0) - g.l(paramAnonymousMotionEvent, 1);
                f3 = MMGestureGallery.b(MMGestureGallery.this).getOriginScale();
                if (f3 <= 0.0F) {
                  break label2173;
                }
                if (MMGestureGallery.z(MMGestureGallery.this) <= f3 + 0.05D) {
                  MMGestureGallery.b(MMGestureGallery.this).bg(f1 + g.k(paramAnonymousMotionEvent, 1), f2 + g.l(paramAnonymousMotionEvent, 1));
                }
              }
              label1311:
              if (MMGestureGallery.z(MMGestureGallery.this) > MMGestureGallery.b(MMGestureGallery.this).getDoubleTabScale() * 2.0F)
              {
                f1 = g.k(paramAnonymousMotionEvent, 0);
                f2 = g.k(paramAnonymousMotionEvent, 1);
                f3 = g.l(paramAnonymousMotionEvent, 0);
                float f4 = g.l(paramAnonymousMotionEvent, 1);
                MMGestureGallery.b(MMGestureGallery.this).setMaxZoomLimit(MMGestureGallery.b(MMGestureGallery.this).getDoubleTabScale() * 2.0F);
                MMGestureGallery.b(MMGestureGallery.this).x(MMGestureGallery.b(MMGestureGallery.this).getDoubleTabScale() * 2.0F, f1 - f2 + g.k(paramAnonymousMotionEvent, 1), f3 - f4 + g.l(paramAnonymousMotionEvent, 1));
                MMGestureGallery.b(MMGestureGallery.this).jmb();
              }
            }
            if (paramAnonymousMotionEvent.getAction() == 1)
            {
              jDc();
              MMGestureGallery.E(MMGestureGallery.this);
              MMGestureGallery.F(MMGestureGallery.this);
              MMGestureGallery.y(MMGestureGallery.this);
              if (((!MMGestureGallery.G(MMGestureGallery.this)) && (!MMGestureGallery.H(MMGestureGallery.this)) && (!MMGestureGallery.I(MMGestureGallery.this)) && (!MMGestureGallery.J(MMGestureGallery.this))) || ((!MMGestureGallery.K(MMGestureGallery.this)) && (!MMGestureGallery.L(MMGestureGallery.this)))) {
                break label2201;
              }
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.h(MMGestureGallery.this));
              MMGestureGallery.g(MMGestureGallery.this);
              MMGestureGallery.M(MMGestureGallery.this);
              MMGestureGallery.N(MMGestureGallery.this);
              MMGestureGallery.O(MMGestureGallery.this);
              MMGestureGallery.P(MMGestureGallery.this);
              MMGestureGallery.Q(MMGestureGallery.this);
              MMGestureGallery.R(MMGestureGallery.this);
              label1606:
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.b(MMGestureGallery.this).getScale());
              if (MMGestureGallery.B(MMGestureGallery.this) == 1)
              {
                MMGestureGallery.c(MMGestureGallery.this, System.currentTimeMillis());
                if (MMGestureGallery.D(MMGestureGallery.this) - MMGestureGallery.S(MMGestureGallery.this) >= 350L) {
                  break label2416;
                }
                if ((Math.abs(MMGestureGallery.w(MMGestureGallery.this) - g.k(paramAnonymousMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.x(MMGestureGallery.this) - g.l(paramAnonymousMotionEvent, 0)) < 10.0F)) {
                  MX(false);
                }
              }
            }
          }
          for (;;)
          {
            if ((paramAnonymousMotionEvent.getAction() == 5) || (paramAnonymousMotionEvent.getAction() == 261))
            {
              MMGestureGallery.e(MMGestureGallery.this, 0.0F);
              MMGestureGallery.f(MMGestureGallery.this, MMGestureGallery.b(MMGestureGallery.this).getScale());
              MMGestureGallery.c(MMGestureGallery.this, true);
            }
            if (paramAnonymousMotionEvent.getAction() != 2) {
              break label2518;
            }
            if (g.au(paramAnonymousMotionEvent) != 2) {
              break label2595;
            }
            jDc();
            if ((!MMGestureGallery.T(MMGestureGallery.this)) && (!MMGestureGallery.I(MMGestureGallery.this)) && (!MMGestureGallery.J(MMGestureGallery.this))) {
              break label2437;
            }
            AppMethodBeat.o(143115);
            return true;
            if (MMGestureGallery.B(MMGestureGallery.this) != 2) {
              break;
            }
            MMGestureGallery.b(MMGestureGallery.this, System.currentTimeMillis());
            if (MMGestureGallery.C(MMGestureGallery.this) - MMGestureGallery.D(MMGestureGallery.this) < 350L)
            {
              if ((Math.abs(MMGestureGallery.w(MMGestureGallery.this) - g.k(paramAnonymousMotionEvent, 0)) < 35.0F) && (Math.abs(MMGestureGallery.x(MMGestureGallery.this) - g.l(paramAnonymousMotionEvent, 0)) < 35.0F))
              {
                MMGestureGallery.a(MMGestureGallery.this, 0);
                Log.d("MicroMsg.MMGestureGallery", "double click!");
                f1 = MMGestureGallery.b(MMGestureGallery.this).getScale();
                Log.i("MicroMsg.MMGestureGallery", "currentScale:%f, scale:%f", new Object[] { Float.valueOf(f1), Float.valueOf(MMGestureGallery.b(MMGestureGallery.this).getScaleRate()) });
                if (f1 <= MMGestureGallery.b(MMGestureGallery.this).getScaleRate())
                {
                  MMGestureGallery.b(MMGestureGallery.this).ag(g.k(paramAnonymousMotionEvent, 0), g.l(paramAnonymousMotionEvent, 0));
                  break;
                }
                if (MMGestureGallery.b(MMGestureGallery.this).getOriginScale() > 0.0F)
                {
                  if (f1 <= MMGestureGallery.b(MMGestureGallery.this).getOriginScale() + 0.05D)
                  {
                    MMGestureGallery.b(MMGestureGallery.this).ag(g.k(paramAnonymousMotionEvent, 0), g.l(paramAnonymousMotionEvent, 0));
                    break;
                  }
                  MMGestureGallery.b(MMGestureGallery.this).bf(g.k(paramAnonymousMotionEvent, 0), g.l(paramAnonymousMotionEvent, 0));
                  break;
                }
                MMGestureGallery.b(MMGestureGallery.this).bd(g.k(paramAnonymousMotionEvent, 0), g.l(paramAnonymousMotionEvent, 0));
                MMGestureGallery.b(MMGestureGallery.this).jmb();
                break;
              }
              MMGestureGallery.a(MMGestureGallery.this, 1);
              break;
            }
            MMGestureGallery.a(MMGestureGallery.this, 1);
            break;
            label2173:
            MMGestureGallery.b(MMGestureGallery.this).bd(f1 + g.k(paramAnonymousMotionEvent, 1), f2 + g.l(paramAnonymousMotionEvent, 1));
            break label1311;
            label2201:
            if ((MMGestureGallery.I(MMGestureGallery.this)) || (MMGestureGallery.G(MMGestureGallery.this)))
            {
              MMGestureGallery.O(MMGestureGallery.this);
              MMGestureGallery.M(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.i(MMGestureGallery.this));
              MMGestureGallery.g(MMGestureGallery.this);
            }
            if ((MMGestureGallery.J(MMGestureGallery.this)) || (MMGestureGallery.H(MMGestureGallery.this)))
            {
              MMGestureGallery.P(MMGestureGallery.this);
              MMGestureGallery.N(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.k(MMGestureGallery.this));
              MMGestureGallery.g(MMGestureGallery.this);
            }
            if (MMGestureGallery.K(MMGestureGallery.this))
            {
              MMGestureGallery.Q(MMGestureGallery.this);
              MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.m(MMGestureGallery.this));
              MMGestureGallery.g(MMGestureGallery.this);
            }
            if (!MMGestureGallery.L(MMGestureGallery.this)) {
              break label1606;
            }
            MMGestureGallery.R(MMGestureGallery.this);
            MMGestureGallery.a(MMGestureGallery.this, new MMGestureGallery.g(MMGestureGallery.this));
            MMGestureGallery.g(MMGestureGallery.this);
            break label1606;
            label2416:
            MMGestureGallery.a(MMGestureGallery.this, 0);
            Log.d("MicroMsg.MMGestureGallery", "single long click over!");
          }
          label2437:
          MMGestureGallery.c(MMGestureGallery.this, true);
          MMGestureGallery.a(MMGestureGallery.this, 0);
          f1 = g.k(paramAnonymousMotionEvent, 0) - g.k(paramAnonymousMotionEvent, 1);
          f2 = g.l(paramAnonymousMotionEvent, 0) - g.l(paramAnonymousMotionEvent, 1);
          f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
          if (MMGestureGallery.U(MMGestureGallery.this) != 0.0F) {
            break label2525;
          }
          MMGestureGallery.e(MMGestureGallery.this, f3);
        }
        for (;;)
        {
          label2518:
          AppMethodBeat.o(143115);
          return false;
          label2525:
          f3 /= MMGestureGallery.U(MMGestureGallery.this);
          if (MMGestureGallery.s(MMGestureGallery.this))
          {
            MMGestureGallery.b(MMGestureGallery.this).x(f3 * MMGestureGallery.z(MMGestureGallery.this), f1 + g.k(paramAnonymousMotionEvent, 1), g.l(paramAnonymousMotionEvent, 1) + f2);
            MMGestureGallery.b(MMGestureGallery.this).jmb();
            continue;
            label2595:
            if ((Math.abs(MMGestureGallery.w(MMGestureGallery.this) - g.k(paramAnonymousMotionEvent, 0)) > 35.0F) || (Math.abs(MMGestureGallery.x(MMGestureGallery.this) - g.l(paramAnonymousMotionEvent, 0)) > 35.0F))
            {
              jDc();
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
    this.HRt = false;
    this.SHb = false;
    this.adUz = false;
    this.adUA = false;
    this.adUB = false;
    this.afIR = false;
    this.adUC = false;
    this.afIS = false;
    this.HRz = false;
    this.HRA = false;
    this.HRB = false;
    this.HRC = false;
    this.count = 0;
    this.HRo = 0L;
    this.HRp = 0L;
    this.HRq = 0.0F;
    this.HRr = 0.0F;
    this.HRs = 0L;
    this.HRw = new RectF();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.afIX = true;
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.adUy = false;
    this.adUS = 60;
    this.adUT = 500;
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(143137);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat)
  {
    AppMethodBeat.i(143148);
    try
    {
      float f3 = paramMotionEvent1.getX();
      float f4 = paramMotionEvent2.getX();
      float f1 = paramMotionEvent1.getY();
      float f2 = paramMotionEvent2.getY();
      boolean bool = b(paramMotionEvent1, paramMotionEvent2);
      f3 = Math.abs(f3 - f4);
      f1 = Math.abs(f1 - f2);
      paramFloat = Math.abs(paramFloat);
      if (paramFloat <= 500.0F)
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
    }
    catch (Exception paramMotionEvent1)
    {
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
    if ((this.adUA) || (this.adUz)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(143142);
      return true;
      if (getPositionForView(paramView) == getAdapter().getCount() - 1)
      {
        if (this.adUC)
        {
          if (paramFloat3 > 0.0F)
          {
            if (paramFloat2 >= this.sJv) {
              this.rUf.be(-paramFloat3, 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if ((paramFloat2 > this.sJv * 0.7F) && (paramFloat2 < this.pvg)) {
                this.rUf.be(-(paramFloat3 * 0.3F), 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 > 0.0F)
        {
          if (paramFloat2 < this.sJv) {
            this.adUC = true;
          }
          if (paramFloat2 >= this.sJv) {
            this.rUf.be(-paramFloat3, 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if ((paramFloat2 > this.sJv * 0.7F) && (paramFloat2 < this.pvg)) {
              this.rUf.be(-(paramFloat3 * 0.3F), 0.0F);
            }
          }
        }
      }
      this.adUC = false;
      i = 0;
    }
    if ((this.adUA) || (this.adUz)) {
      i = 0;
    }
    while (i != 0)
    {
      AppMethodBeat.o(143142);
      return true;
      if (getPositionForView(paramView) == 0)
      {
        if (this.adUB)
        {
          if (paramFloat3 < 0.0F)
          {
            if ((paramFloat1 > 0.0F) && (paramFloat1 < this.sJv * 0.3F)) {
              this.rUf.be(-(paramFloat3 * 0.3F), 0.0F);
            }
            for (;;)
            {
              i = 1;
              break;
              if (paramFloat1 <= 0.0F) {
                this.rUf.be(-paramFloat3, 0.0F);
              }
            }
          }
          i = 0;
          continue;
        }
        if (paramFloat3 < 0.0F)
        {
          if (paramFloat1 > 0.0F) {
            this.adUB = true;
          }
          if ((paramFloat1 > 0.0F) && (paramFloat1 < this.sJv * 0.3F)) {
            this.rUf.be(-(paramFloat3 * 0.3F), 0.0F);
          }
          for (;;)
          {
            i = 1;
            break;
            if (paramFloat1 <= 0.0F) {
              this.rUf.be(-paramFloat3, 0.0F);
            }
          }
        }
      }
      this.adUB = false;
      i = 0;
    }
    AppMethodBeat.o(143142);
    return false;
  }
  
  private boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143141);
    if ((this.adUz) || (this.SHb))
    {
      AppMethodBeat.o(143141);
      return true;
    }
    this.adUA = true;
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
  
  private void fBX()
  {
    AppMethodBeat.i(143138);
    this.afIO.removeMessages(1);
    AppMethodBeat.o(143138);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143152);
    Log.d("MicroMsg.MMGestureGallery", "computeScrollOffset: %s.", new Object[] { Boolean.valueOf(this.HRu.computeScrollOffset()) });
    if (this.rUf == null)
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
    if (this.HRu.computeScrollOffset())
    {
      Log.d("MicroMsg.MMGestureGallery", "mFlingScroller.getCurrX(): %s, mFlingScroller.getCurrY(): %s.", new Object[] { Integer.valueOf(this.HRu.getCurrX()), Integer.valueOf(this.HRu.getCurrY()) });
      i = this.HRu.getCurrX() - this.caG;
      int m = this.HRu.getCurrY() - this.caH;
      Log.d("MicroMsg.MMGestureGallery", " scrollX: %s, scrollY: %s, mLastFlingX: %s, mLastFlingY: %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(this.caG), Integer.valueOf(this.caH) });
      this.caG = this.HRu.getCurrX();
      this.caH = this.HRu.getCurrY();
      float f3 = this.rUf.getScale();
      f4 = this.rUf.getImageWidth();
      f1 = this.rUf.getScale() * this.rUf.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.rUf.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      Log.d("MicroMsg.MMGestureGallery", "left: %s, right: %s, top: %s, bottom: %s.", new Object[] { Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5) });
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.HRw.right - Math.round(f3)) {
          j = (int)(this.HRw.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.HRw.left - Math.round(f2)) {
          i = (int)(this.HRw.left - Math.round(f2));
        }
      }
      k = m;
      if (m < 0)
      {
        k = m;
        if (m < this.HRw.bottom - Math.round(f5)) {
          k = (int)(this.HRw.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.HRw.top - Math.round(f4)) {
          j = (int)(this.HRw.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.HRw.left) && (Math.round(f3) > this.HRw.right)) {
        break label586;
      }
      k = 0;
    }
    for (;;)
    {
      if (f1 < this.pvg) {
        j = 0;
      }
      this.rUf.be(k, j);
      postInvalidate();
      AppMethodBeat.o(143152);
      return;
      label586:
      if (Math.round(f4) < this.HRw.top)
      {
        k = i;
        if (Math.round(f5) > this.HRw.bottom) {}
      }
      else
      {
        j = 0;
        k = i;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251155);
    Log.i("MicroMsg.MMGestureGallery", "MMGallery dispatchTouchEvent " + String.valueOf(paramMotionEvent.getActionMasked()));
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(251155);
    return bool;
  }
  
  public int getScreenWidth()
  {
    return this.sJv;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(251151);
    View localView1 = super.getSelectedView();
    if (localView1 != null)
    {
      View localView2 = localView1.findViewById(a.g.multi_image);
      View localView3 = localView1.findViewById(a.g.wx_image);
      if ((localView2 != null) && (localView2.getVisibility() == 0))
      {
        AppMethodBeat.o(251151);
        return localView2;
      }
      if ((localView3 != null) && (localView3.getVisibility() == 0))
      {
        AppMethodBeat.o(251151);
        return localView3;
      }
      AppMethodBeat.o(251151);
      return localView1;
    }
    AppMethodBeat.o(251151);
    return null;
  }
  
  public MMGestureGallery.f getSingleClickOverListener()
  {
    return this.afIU;
  }
  
  public int getXDown()
  {
    return (int)this.x_down;
  }
  
  public int getYDown()
  {
    return (int)this.y_down;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143144);
    if (this.HRu != null) {
      this.HRu.forceFinished(true);
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
      if ((((MultiTouchImageView)localObject1).horizontalLong) || (((MultiTouchImageView)localObject1).verticalLong) || ((int)f2 > this.sJv) || ((int)f3 > this.pvg))
      {
        localObject2 = new float[9];
        ((MultiTouchImageView)localObject1).getImageMatrix().getValues((float[])localObject2);
        f1 = localObject2[2];
        float f6 = f1 + f2;
        f4 = localObject2[5];
        f5 = f4 + f3;
        Log.d("MicroMsg.MMGestureGallery", "left: %f, right: %f, top: %f, bottom: %f, velocityX: %f, velocityY: %f.", new Object[] { Float.valueOf(f1), Float.valueOf(f6), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
        if ((Math.round(f1) < this.HRw.left) && (Math.round(f6) > this.HRw.right)) {
          break label614;
        }
      }
    }
    label614:
    for (float f1 = 0.0F;; f1 = paramFloat1)
    {
      if ((Math.round(f4) >= this.HRw.top) || (Math.round(f5) <= this.HRw.bottom)) {
        paramFloat2 = 0.0F;
      }
      if (Math.round(f4) < this.HRw.top) {}
      for (this.adUy = true;; this.adUy = false)
      {
        int i = (int)(this.HRw.right - f2);
        int j = (int)(this.HRw.right + f2);
        int k = (int)(this.HRw.bottom - f3);
        int m = (int)(this.HRw.bottom + f3);
        Log.d("MicroMsg.MMGestureGallery", "minX: %d, maxX: %d, minY: %d, maxY: %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
        Log.d("MicroMsg.MMGestureGallery", "vx: %f, vy: %f.", new Object[] { Float.valueOf(f1), Float.valueOf(paramFloat2) });
        this.HRu.forceFinished(true);
        this.HRu.fling(this.HRu.getCurrX(), this.HRu.getCurrY(), (int)f1, (int)paramFloat2, i, j, k, m, 0, 0);
        if (!this.HRt) {
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
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251157);
    paramMotionEvent = getSelectedView();
    if (((paramMotionEvent instanceof WxImageView)) && (!((WxImageView)paramMotionEvent).getInternalTouchEventConsumed()))
    {
      AppMethodBeat.o(251157);
      return true;
    }
    AppMethodBeat.o(251157);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143146);
    this.Rvq = true;
    super.onLongPress(paramMotionEvent);
    AppMethodBeat.o(143146);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143140);
    super.onMeasure(paramInt1, paramInt2);
    this.sJv = View.MeasureSpec.getSize(paramInt1);
    this.pvg = View.MeasureSpec.getSize(paramInt2);
    this.HRw.set(0.0F, 0.0F, this.sJv, this.pvg);
    Log.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.sJv + " height:" + this.pvg);
    AppMethodBeat.o(143140);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(143143);
    if ((this.HRt) || (this.Rvo))
    {
      AppMethodBeat.o(143143);
      return true;
    }
    Object localObject2 = getSelectedView();
    Object localObject1 = localObject2;
    float f1;
    float f2;
    boolean bool;
    if ((localObject2 instanceof ViewGroup))
    {
      if ((localObject2 instanceof WxImageView))
      {
        int i;
        if (getPositionForView((View)localObject2) == 0)
        {
          f1 = ((WxImageView)localObject2).getTranslationX();
          f2 = 0.3F * paramFloat1;
          if ((f2 < 0.0F) && (f1 - f2 > 0.0F)) {
            this.afIR = true;
          }
          if (this.afIR)
          {
            ((WxImageView)localObject2).A(-f2, 0.0F);
            i = 1;
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(143143);
          return true;
          i = 0;
          continue;
          i = 0;
        }
        if (getPositionForView((View)localObject2) == getAdapter().getCount() - 1)
        {
          f1 = ((WxImageView)localObject2).getTranslationX();
          f2 = 0.3F * paramFloat1;
          if ((f2 > 0.0F) && (f1 - f2 < 0.0F)) {
            this.afIS = true;
          }
          if (this.afIS)
          {
            ((WxImageView)localObject2).A(-f2, 0.0F);
            i = 1;
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(143143);
          return true;
          i = 0;
          continue;
          i = 0;
        }
      }
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
    float f5;
    float f4;
    float f6;
    float f7;
    if ((localObject1 instanceof MultiTouchImageView))
    {
      this.rUf = ((MultiTouchImageView)localObject1);
      localObject2 = new float[9];
      this.rUf.getImageMatrix().getValues((float[])localObject2);
      f1 = this.rUf.getScale() * this.rUf.getImageWidth();
      f2 = this.rUf.getScale() * this.rUf.getImageHeight();
      f5 = localObject2[2];
      f4 = f5 + f1;
      f6 = localObject2[5];
      f7 = f6 + f2;
      localObject2 = new Rect();
      this.rUf.getGlobalVisibleRect((Rect)localObject2);
      if (((int)f1 <= this.sJv) && ((int)f2 <= this.pvg))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.sJv)
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
        if (!this.adUA) {
          this.rUf.be(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (((int)f1 <= this.sJv) && ((int)f2 > this.pvg))
      {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
        {
          if ((this.adUA) || (this.adUB) || (this.adUC))
          {
            AppMethodBeat.o(143143);
            return true;
          }
          this.adUz = true;
          f2 = 0.0F;
          float f3 = 0.0F;
          if (paramFloat2 < 0.0F)
          {
            if (f6 > this.HRw.top) {
              this.HRz = true;
            }
            if ((f6 <= this.HRw.top) || (f7 < this.pvg))
            {
              f1 = -paramFloat2;
              if ((paramFloat1 >= 0.0F) || (f5 <= this.HRw.left)) {
                break label900;
              }
              this.HRB = true;
              paramFloat2 = -(0.3F * paramFloat1);
            }
          }
          for (;;)
          {
            this.rUf.be(paramFloat2, f1);
            AppMethodBeat.o(143143);
            return true;
            f1 = f3;
            if (f6 <= this.HRw.top) {
              break;
            }
            f1 = f3;
            if (f6 >= this.pvg * 0.3F) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            if (f7 < this.HRw.bottom) {
              this.HRA = true;
            }
            if ((f6 > 0.0F) || (f7 >= this.pvg))
            {
              f1 = -paramFloat2;
              break;
            }
            f1 = f3;
            if (f7 <= this.pvg * 0.7F) {
              break;
            }
            f1 = f3;
            if (f7 >= this.pvg) {
              break;
            }
            f1 = -(0.3F * paramFloat2);
            break;
            label900:
            paramFloat2 = f2;
            if (paramFloat1 > 0.0F)
            {
              paramFloat2 = f2;
              if (f4 < this.HRw.right)
              {
                this.HRC = true;
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
          if (f4 <= this.sJv)
          {
            if (f4 > this.sJv * 0.7F)
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
          if (f5 < this.sJv * 0.3F)
          {
            bool = a(paramMotionEvent1, paramMotionEvent2, 0.3F * paramFloat1, 0.0F);
            AppMethodBeat.o(143143);
            return bool;
          }
          bool = a(paramMotionEvent1, paramMotionEvent2, 0.0F, 0.0F);
          AppMethodBeat.o(143143);
          return bool;
        }
        if (!this.adUA) {
          this.rUf.be(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (((int)f1 > this.sJv) && ((int)f2 <= this.pvg))
      {
        if (a(f5, f4, (View)localObject1, paramFloat1))
        {
          AppMethodBeat.o(143143);
          return true;
        }
        if (paramFloat1 > 0.0F)
        {
          if (f4 <= this.sJv)
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
        if (!this.adUA) {
          this.rUf.be(-paramFloat1, 0.0F);
        }
        AppMethodBeat.o(143143);
        return true;
      }
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        if (paramFloat1 == 0.0F) {
          break label1790;
        }
        this.adUA = true;
        if (paramFloat1 < 0.0F)
        {
          if (f5 > this.HRw.left) {
            this.HRB = true;
          }
          f1 = paramFloat1;
          if (f5 > this.HRw.left)
          {
            if (f4 >= this.sJv) {
              break label1422;
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
        this.adUz = true;
        if (paramFloat2 < 0.0F)
        {
          if (f6 > this.HRw.top) {
            this.HRz = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > this.HRw.top)
          {
            if (f7 >= this.pvg) {
              break label1538;
            }
            paramFloat1 = paramFloat2;
          }
        }
      }
      for (;;)
      {
        this.rUf.be(-f1, -paramFloat1);
        AppMethodBeat.o(143143);
        return true;
        label1422:
        if ((f5 <= this.HRw.left) || (f5 >= this.sJv * 0.3F)) {
          break label1790;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        if (f4 < this.HRw.right) {
          this.HRC = true;
        }
        f1 = paramFloat1;
        if (f5 > 0.0F) {
          break;
        }
        f1 = paramFloat1;
        if (f4 >= this.sJv) {
          break;
        }
        if ((f4 <= this.sJv * 0.7F) || (f4 >= this.sJv)) {
          break label1790;
        }
        f1 = paramFloat1 * 0.3F;
        break;
        label1538:
        if ((f6 > this.HRw.top) && (f6 < this.pvg * 0.3F))
        {
          paramFloat1 = paramFloat2 * 0.3F;
          continue;
          if (f7 < this.HRw.bottom) {
            this.HRA = true;
          }
          paramFloat1 = paramFloat2;
          if (f6 > 0.0F) {
            continue;
          }
          paramFloat1 = paramFloat2;
          if (f7 >= this.pvg) {
            continue;
          }
          if ((f7 > this.pvg * 0.7F) && (f7 < this.pvg))
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
              if (f4 <= this.sJv)
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
            if (!this.adUA) {
              this.rUf.be(-paramFloat1, -paramFloat2);
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
      label1790:
      f1 = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143149);
    Object localObject = this.HRv;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/tools/MMGestureGallery", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
        this.rUf = ((MultiTouchImageView)localObject);
        float f2 = this.rUf.getScale() * this.rUf.getImageWidth();
        float f1 = this.rUf.getScale() * this.rUf.getImageHeight();
        if (((int)f2 <= this.sJv) && ((int)f1 <= this.pvg))
        {
          Log.i("dktest", "onTouchEvent width:" + f2 + "height:" + f1);
        }
        else
        {
          localObject = new float[9];
          this.rUf.getImageMatrix().getValues((float[])localObject);
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
    this.afIY = paramb;
  }
  
  public void setLoadQuit(boolean paramBoolean)
  {
    this.afIX = paramBoolean;
  }
  
  public void setLongClickOverListener(c paramc)
  {
    this.afIV = paramc;
  }
  
  public void setScrollLeftRightListener(e parame)
  {
    this.afIW = parame;
  }
  
  public void setSingleClickOverListener(MMGestureGallery.f paramf)
  {
    this.afIU = paramf;
  }
  
  abstract class a
  {
    protected boolean hcg = false;
    
    public a() {}
    
    public final boolean efT()
    {
      return this.hcg;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b
  {
    public abstract void aC(float paramFloat1, float paramFloat2);
    
    public abstract void onGalleryScale(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c
  {
    public abstract void longClickOver();
  }
  
  public static abstract interface e {}
  
  final class g
    extends MMGestureGallery.a
  {
    float[] HRJ;
    
    public g()
    {
      super();
      AppMethodBeat.i(143118);
      this.HRJ = new float[9];
      AppMethodBeat.o(143118);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143119);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143117);
          MMGestureGallery.b(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.g.this.HRJ);
          float f1 = MMGestureGallery.b(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.b(MMGestureGallery.this).getImageHeight() * f1;
          float f3 = MMGestureGallery.g.this.HRJ[5];
          f1 = MMGestureGallery.d(MMGestureGallery.this);
          if (f2 < MMGestureGallery.d(MMGestureGallery.this)) {
            f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.g.this.hcg = true;
          }
          for (;;)
          {
            MMGestureGallery.b(MMGestureGallery.this).be(0.0F, f1);
            AppMethodBeat.o(143117);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.g.this.hcg = true;
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
    float[] HRJ;
    
    public h()
    {
      super();
      AppMethodBeat.i(143121);
      this.HRJ = new float[9];
      AppMethodBeat.o(143121);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143122);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143120);
          MMGestureGallery.b(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.h.this.HRJ);
          float f5 = MMGestureGallery.b(MMGestureGallery.this).getScale() * MMGestureGallery.b(MMGestureGallery.this).getImageWidth();
          float f1 = MMGestureGallery.b(MMGestureGallery.this).getScale();
          float f8 = MMGestureGallery.b(MMGestureGallery.this).getImageHeight() * f1;
          float f7 = MMGestureGallery.h.this.HRJ[2];
          float f10 = MMGestureGallery.h.this.HRJ[5];
          float f6 = MMGestureGallery.h.this.HRJ[2];
          float f9 = MMGestureGallery.h.this.HRJ[5];
          float f2 = 0.0F;
          f1 = MMGestureGallery.d(MMGestureGallery.this);
          float f3 = 0.0F;
          float f4 = MMGestureGallery.c(MMGestureGallery.this);
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
              if (f5 < MMGestureGallery.c(MMGestureGallery.this))
              {
                f3 = MMGestureGallery.c(MMGestureGallery.this) / 2.0F;
                f4 = f5 / 2.0F;
                f2 = MMGestureGallery.c(MMGestureGallery.this) / 2.0F + f5 / 2.0F;
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
                    MMGestureGallery.h.this.hcg = true;
                  }
                  for (;;)
                  {
                    MMGestureGallery.b(MMGestureGallery.this).be(f2, f1);
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
    float[] HRJ;
    
    public i()
    {
      super();
      AppMethodBeat.i(143124);
      this.HRJ = new float[9];
      AppMethodBeat.o(143124);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143125);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143123);
          MMGestureGallery.b(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.i.this.HRJ);
          float f2 = MMGestureGallery.i.this.HRJ[2];
          float f1 = MMGestureGallery.b(MMGestureGallery.this).getScale() * MMGestureGallery.b(MMGestureGallery.this).getImageWidth();
          if (f1 < MMGestureGallery.c(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.c(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.i.this.hcg = true;
            }
            for (;;)
            {
              MMGestureGallery.b(MMGestureGallery.this).be(f1, 0.0F);
              AppMethodBeat.o(143123);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.i.this.hcg = true;
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
    public j()
    {
      super();
    }
    
    public final void play()
    {
      AppMethodBeat.i(251124);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(251090);
          Object localObject = MMGestureGallery.this.getSelectedView();
          float f;
          if ((localObject instanceof WxImageView))
          {
            localObject = (WxImageView)localObject;
            f = -((WxImageView)localObject).getTranslationX();
            if (f < 0.0F) {
              break label60;
            }
            MMGestureGallery.j.this.hcg = true;
          }
          for (;;)
          {
            ((WxImageView)localObject).A(f, 0.0F);
            AppMethodBeat.o(251090);
            return;
            label60:
            if (Math.abs(f) <= 5.0F) {
              MMGestureGallery.j.this.hcg = true;
            } else {
              f = -(float)(Math.abs(f) - Math.pow(Math.sqrt(Math.abs(f)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(251124);
    }
  }
  
  final class k
    extends MMGestureGallery.a
  {
    float[] HRJ;
    
    public k()
    {
      super();
      AppMethodBeat.i(143127);
      this.HRJ = new float[9];
      AppMethodBeat.o(143127);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143128);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143126);
          MMGestureGallery.b(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.k.this.HRJ);
          float f1 = MMGestureGallery.b(MMGestureGallery.this).getScale();
          float f2 = MMGestureGallery.b(MMGestureGallery.this).getImageWidth() * f1;
          float f3 = MMGestureGallery.k.this.HRJ[2];
          f1 = MMGestureGallery.c(MMGestureGallery.this);
          if (f2 < MMGestureGallery.c(MMGestureGallery.this)) {
            f1 = MMGestureGallery.c(MMGestureGallery.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MMGestureGallery.k.this.hcg = true;
          }
          for (;;)
          {
            MMGestureGallery.b(MMGestureGallery.this).be(f1, 0.0F);
            AppMethodBeat.o(143126);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMGestureGallery.k.this.hcg = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(143128);
    }
  }
  
  final class l
    extends MMGestureGallery.a
  {
    public l()
    {
      super();
    }
    
    public final void play()
    {
      AppMethodBeat.i(251126);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(251119);
          Object localObject = MMGestureGallery.this.getSelectedView();
          float f;
          if ((localObject instanceof WxImageView))
          {
            localObject = (WxImageView)localObject;
            f = -((WxImageView)localObject).getTranslationX();
            if (f < 0.0F) {
              break label60;
            }
            MMGestureGallery.l.this.hcg = true;
          }
          for (;;)
          {
            ((WxImageView)localObject).A(f, 0.0F);
            AppMethodBeat.o(251119);
            return;
            label60:
            if (Math.abs(f) <= 5.0F) {
              MMGestureGallery.l.this.hcg = true;
            } else {
              f = (float)(Math.abs(f) - Math.pow(Math.sqrt(Math.abs(f)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(251126);
    }
  }
  
  final class m
    extends MMGestureGallery.a
  {
    float[] HRJ;
    
    public m()
    {
      super();
      AppMethodBeat.i(143130);
      this.HRJ = new float[9];
      AppMethodBeat.o(143130);
    }
    
    public final void play()
    {
      AppMethodBeat.i(143131);
      MMGestureGallery.a(MMGestureGallery.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143129);
          MMGestureGallery.b(MMGestureGallery.this).getImageMatrix().getValues(MMGestureGallery.m.this.HRJ);
          float f2 = MMGestureGallery.m.this.HRJ[5];
          float f1 = MMGestureGallery.b(MMGestureGallery.this).getScale() * MMGestureGallery.b(MMGestureGallery.this).getImageHeight();
          if (f1 < MMGestureGallery.d(MMGestureGallery.this)) {}
          for (f1 = MMGestureGallery.d(MMGestureGallery.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MMGestureGallery.m.this.hcg = true;
            }
            for (;;)
            {
              MMGestureGallery.b(MMGestureGallery.this).be(0.0F, f1);
              AppMethodBeat.o(143129);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMGestureGallery.m.this.hcg = true;
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
  
  public static final class n
    extends MMHandler
  {
    WeakReference<MMGestureGallery> HNs;
    private long HRP;
    private boolean idP;
    
    public n(WeakReference<MMGestureGallery> paramWeakReference)
    {
      this.HNs = paramWeakReference;
    }
    
    public final void ad(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(143136);
      this.idP = paramBoolean;
      o(0, paramLong, 0L);
      AppMethodBeat.o(143136);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(143134);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.HNs != null)
      {
        final MMGestureGallery localMMGestureGallery = (MMGestureGallery)this.HNs.get();
        if (localMMGestureGallery != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MMGestureGallery.B(localMMGestureGallery) == 1) || (this.idP))
            {
              Log.d("MicroMsg.MMGestureGallery", "single click over!");
              if (MMGestureGallery.v(localMMGestureGallery) != null) {
                MMGestureGallery.a(localMMGestureGallery).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143132);
                    MMGestureGallery.v(localMMGestureGallery).singleClickOver();
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
            if ((MMGestureGallery.V(localMMGestureGallery) != null) && (!MMGestureGallery.V(localMMGestureGallery).efT()))
            {
              MMGestureGallery.V(localMMGestureGallery).play();
              sendEmptyMessageDelayed(paramMessage.what, this.HRP);
              AppMethodBeat.o(143134);
              return;
            }
            MMGestureGallery.W(localMMGestureGallery);
            AppMethodBeat.o(143134);
            return;
          }
          removeMessages(2);
          if (MMGestureGallery.X(localMMGestureGallery) != null) {
            MMGestureGallery.a(localMMGestureGallery).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(143133);
                MMGestureGallery.X(localMMGestureGallery).longClickOver();
                AppMethodBeat.o(143133);
              }
            });
          }
        }
      }
      AppMethodBeat.o(143134);
    }
    
    public final void o(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(143135);
      this.HRP = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(143135);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery
 * JD-Core Version:    0.7.0.1
 */