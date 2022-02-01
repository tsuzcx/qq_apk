package com.tencent.mm.plugin.sport.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  private GestureDetector.OnGestureListener AHA;
  private SimpleDateFormat AHq;
  private SimpleDateFormat AHr;
  private boolean AHs;
  private int AHt;
  private SportChartView.a AHu;
  private int AHv;
  private List<d> AHw;
  private b[] AHx;
  private int AHy;
  private boolean AHz;
  private int gfT;
  private int gfU;
  private GestureDetector iKD;
  Paint paint;
  private final float qnB;
  private final int qnC;
  private final float qnD;
  private final int qnE;
  private final float qnF;
  private final int qnG;
  private final float qnH;
  private final int qnI;
  private final float qnJ;
  private final int qnK;
  private final float qnL;
  private final int qnM;
  private final float qnN;
  private final int qnO;
  private final float qnP;
  private final int qnQ;
  private final float qnR;
  private final int qnS;
  private final float qnT;
  private final int qnU;
  private final float qnV;
  private final int qnW;
  private final float qnX;
  private final int qnY;
  private final float qnZ;
  private final int qnn;
  private final int qno;
  private final int qnp;
  private final float qnq;
  private final float qnr;
  private final float qns;
  private final float qnt;
  private final float qnu;
  private final int qnv;
  private final int qnw;
  private final int qnx;
  private final int qny;
  private final Typeface qoA;
  private final Typeface qoB;
  private int qoC;
  private int qoD;
  Path qoJ;
  Path qoK;
  private int qoO;
  private boolean qoP;
  private final float qoa;
  private final float qob;
  private final float qoc;
  private final int qod;
  private final int qoe;
  private final int qof;
  private final int qog;
  private final float qoh;
  private final int qoi;
  private final float qoj;
  private final int qok;
  private final float qol;
  private final int qom;
  private final float qon;
  private final int qoo;
  private final float qop;
  private final int qoq;
  private final int qor;
  private final int qos;
  private final int qot;
  private final int qou;
  private final int qov;
  private final int qow;
  private final int qox;
  private final int qoy;
  private int qoz;
  private int spf;
  private int startY;
  private int vnp;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.AHq = new SimpleDateFormat(getResources().getString(2131764119));
    this.AHr = new SimpleDateFormat("d");
    this.qnn = -1;
    this.qno = -1;
    this.qnp = getResources().getColor(2131100945);
    this.qnq = 12.0F;
    this.qnr = 24.0F;
    this.qns = 28.0F;
    this.qnt = 12.0F;
    this.qnu = 12.0F;
    this.qnv = getResources().getColor(2131100946);
    this.qnw = -1;
    this.qnx = getResources().getColor(2131100946);
    this.qny = -1;
    this.vnp = 2147483647;
    this.gfT = 0;
    this.gfU = 0;
    this.qnB = 2.5F;
    this.qnC = ((int)p(1, 2.5F));
    this.qnD = 4.0F;
    this.qnE = ((int)p(1, 4.0F));
    this.qnF = 1.8F;
    this.qnG = ((int)p(1, 1.8F));
    this.qnH = 1.0F;
    this.qnI = ((int)p(1, 1.0F));
    this.qnJ = 8.0F;
    this.qnK = ((int)p(1, 8.0F));
    this.qnL = 22.0F;
    this.qnM = ((int)p(1, 22.0F));
    this.qnN = 67.0F;
    this.qnO = ((int)p(1, 67.0F));
    this.qnP = 40.0F;
    this.qnQ = ((int)p(1, 40.0F));
    this.qnR = 22.0F;
    this.qnS = ((int)p(1, 22.0F));
    this.qnT = 55.0F;
    this.qnU = ((int)p(1, 55.0F));
    this.qnV = 35.0F;
    this.qnW = ((int)p(1, 35.0F));
    this.qnX = 45.0F;
    this.qnY = ((int)p(1, 45.0F));
    this.qnZ = 8.0F;
    this.qoa = ((int)p(1, 8.0F));
    this.qob = 8.0F;
    this.qoc = ((int)p(1, 8.0F));
    this.qod = 2;
    this.qoe = ((int)p(1, 2.0F));
    this.qof = 15;
    this.qog = ((int)p(1, 15.0F));
    this.qoh = 33.0F;
    this.qoi = ((int)p(1, 33.0F));
    this.qoj = 8.0F;
    this.qok = ((int)p(1, 8.0F));
    this.qol = 35.0F;
    this.qom = ((int)p(1, 35.0F));
    this.qon = 10.0F;
    this.qoo = ((int)p(1, 10.0F));
    this.qop = 58.0F;
    this.qoq = ((int)p(1, 58.0F));
    this.qor = ((int)p(1, 1.0F));
    this.qos = 102;
    this.qot = 102;
    this.qou = 153;
    this.qov = 102;
    this.qow = 102;
    this.qox = 102;
    this.qoy = 204;
    this.qoz = 0;
    this.qoA = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qoB = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qoC = 0;
    this.qoD = 0;
    this.AHt = -1;
    this.spf = -1;
    this.AHu = SportChartView.a.AHD;
    this.AHv = 7;
    this.AHx = new b[this.AHv];
    this.AHA = new GestureDetector.SimpleOnGestureListener()
    {
      private long AHB;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211011);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211011);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211010);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211010);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211009);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(211009);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ad.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.AHB < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.AHB = System.currentTimeMillis();
        if (paramAnonymousFloat1 > 0.0F)
        {
          SportChartView.e(SportChartView.this);
          if (SportChartView.f(SportChartView.this) > SportChartView.g(SportChartView.this)) {
            SportChartView.b(SportChartView.this, SportChartView.g(SportChartView.this));
          }
          SportChartView.h(SportChartView.this);
          SportChartView.this.invalidate();
          AppMethodBeat.o(103525);
          return true;
        }
        if (paramAnonymousFloat1 < 0.0F)
        {
          SportChartView.i(SportChartView.this);
          if (SportChartView.f(SportChartView.this) <= 0) {
            SportChartView.b(SportChartView.this, 1);
          }
          SportChartView.h(SportChartView.this);
          SportChartView.this.invalidate();
          AppMethodBeat.o(103525);
          return true;
        }
        AppMethodBeat.o(103525);
        return false;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(103524);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        ad.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103524);
        return true;
      }
    };
    cmC();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.AHq = new SimpleDateFormat(getResources().getString(2131764119));
    this.AHr = new SimpleDateFormat("d");
    this.qnn = -1;
    this.qno = -1;
    this.qnp = getResources().getColor(2131100945);
    this.qnq = 12.0F;
    this.qnr = 24.0F;
    this.qns = 28.0F;
    this.qnt = 12.0F;
    this.qnu = 12.0F;
    this.qnv = getResources().getColor(2131100946);
    this.qnw = -1;
    this.qnx = getResources().getColor(2131100946);
    this.qny = -1;
    this.vnp = 2147483647;
    this.gfT = 0;
    this.gfU = 0;
    this.qnB = 2.5F;
    this.qnC = ((int)p(1, 2.5F));
    this.qnD = 4.0F;
    this.qnE = ((int)p(1, 4.0F));
    this.qnF = 1.8F;
    this.qnG = ((int)p(1, 1.8F));
    this.qnH = 1.0F;
    this.qnI = ((int)p(1, 1.0F));
    this.qnJ = 8.0F;
    this.qnK = ((int)p(1, 8.0F));
    this.qnL = 22.0F;
    this.qnM = ((int)p(1, 22.0F));
    this.qnN = 67.0F;
    this.qnO = ((int)p(1, 67.0F));
    this.qnP = 40.0F;
    this.qnQ = ((int)p(1, 40.0F));
    this.qnR = 22.0F;
    this.qnS = ((int)p(1, 22.0F));
    this.qnT = 55.0F;
    this.qnU = ((int)p(1, 55.0F));
    this.qnV = 35.0F;
    this.qnW = ((int)p(1, 35.0F));
    this.qnX = 45.0F;
    this.qnY = ((int)p(1, 45.0F));
    this.qnZ = 8.0F;
    this.qoa = ((int)p(1, 8.0F));
    this.qob = 8.0F;
    this.qoc = ((int)p(1, 8.0F));
    this.qod = 2;
    this.qoe = ((int)p(1, 2.0F));
    this.qof = 15;
    this.qog = ((int)p(1, 15.0F));
    this.qoh = 33.0F;
    this.qoi = ((int)p(1, 33.0F));
    this.qoj = 8.0F;
    this.qok = ((int)p(1, 8.0F));
    this.qol = 35.0F;
    this.qom = ((int)p(1, 35.0F));
    this.qon = 10.0F;
    this.qoo = ((int)p(1, 10.0F));
    this.qop = 58.0F;
    this.qoq = ((int)p(1, 58.0F));
    this.qor = ((int)p(1, 1.0F));
    this.qos = 102;
    this.qot = 102;
    this.qou = 153;
    this.qov = 102;
    this.qow = 102;
    this.qox = 102;
    this.qoy = 204;
    this.qoz = 0;
    this.qoA = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qoB = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qoC = 0;
    this.qoD = 0;
    this.AHt = -1;
    this.spf = -1;
    this.AHu = SportChartView.a.AHD;
    this.AHv = 7;
    this.AHx = new b[this.AHv];
    this.AHA = new GestureDetector.SimpleOnGestureListener()
    {
      private long AHB;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211011);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211011);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211010);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211010);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211009);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(211009);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ad.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.AHB < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.AHB = System.currentTimeMillis();
        if (paramAnonymousFloat1 > 0.0F)
        {
          SportChartView.e(SportChartView.this);
          if (SportChartView.f(SportChartView.this) > SportChartView.g(SportChartView.this)) {
            SportChartView.b(SportChartView.this, SportChartView.g(SportChartView.this));
          }
          SportChartView.h(SportChartView.this);
          SportChartView.this.invalidate();
          AppMethodBeat.o(103525);
          return true;
        }
        if (paramAnonymousFloat1 < 0.0F)
        {
          SportChartView.i(SportChartView.this);
          if (SportChartView.f(SportChartView.this) <= 0) {
            SportChartView.b(SportChartView.this, 1);
          }
          SportChartView.h(SportChartView.this);
          SportChartView.this.invalidate();
          AppMethodBeat.o(103525);
          return true;
        }
        AppMethodBeat.o(103525);
        return false;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(103524);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        ad.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103524);
        return true;
      }
    };
    cmC();
    AppMethodBeat.o(103532);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.qoK.reset();
      this.qoK.moveTo(this.AHx[0].x, this.AHx[0].y);
      i = 0;
      while (i < this.AHx.length)
      {
        this.qoK.lineTo(this.AHx[i].x, this.AHx[i].y);
        i += 1;
      }
      this.qoK.lineTo(this.AHx[(this.AHx.length - 1)].x, this.gfU - this.qnW - 1);
      this.qoK.lineTo(this.qnK, this.gfU - this.qnW - 1);
      this.qoK.lineTo(this.qnK, this.AHx[0].y);
      paramCanvas.drawPath(this.qoK, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.qoK.reset();
    this.qoK.moveTo(this.AHx[0].x, this.AHx[0].y);
    if (i < this.AHx.length)
    {
      if (i > 0) {
        if (this.AHx[(i - 1)].y == this.gfU - this.qnQ)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.qnG);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.qoK.lineTo(this.AHx[i].x, this.AHx[i].y);
        paramCanvas.drawPath(this.qoK, this.paint);
        this.qoK.reset();
        this.qoK.moveTo(this.AHx[i].x, this.AHx[i].y);
        i += 1;
        break;
        cmE();
        continue;
        cmE();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void cmC()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.qoJ = new Path();
    this.qoK = new Path();
    this.AHx = new b[this.AHv];
    egE();
    egF();
    this.iKD = new GestureDetector(getContext(), this.AHA);
    AppMethodBeat.o(103538);
  }
  
  private void cmE()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.qnG);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void egE()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.AHx.length)
    {
      this.AHx[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void egF()
  {
    int i = 0;
    if (i < this.AHv)
    {
      if (i == this.AHv - 1) {}
      for (this.AHx[i].AHG = true;; this.AHx[i].AHG = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private void m(Canvas paramCanvas)
  {
    AppMethodBeat.i(103534);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-1);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.AHx.length)
    {
      if (i == this.AHx.length - 1) {
        paramCanvas.drawCircle(this.AHx[i].x, this.AHx[i].y, this.qnE, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.AHx[i].x, this.AHx[i].y, this.qnC, this.paint);
      }
    }
    AppMethodBeat.o(103534);
  }
  
  private void n(Canvas paramCanvas)
  {
    AppMethodBeat.i(103537);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setTextSize(p(2, 12.0F));
    this.paint.setAlpha(153);
    int i = 0;
    if (i < this.AHx.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.AHx[i].AHG) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.AHx[i].xbO, this.AHx[i].x, this.gfU - this.qog, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.qnv);
      }
    }
    AppMethodBeat.o(103537);
  }
  
  private float p(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(103536);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      AppMethodBeat.o(103536);
      return paramFloat;
    }
  }
  
  private void sf(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(103541);
    this.vnp = 2147483647;
    Object localObject1 = Calendar.getInstance();
    this.AHx = new b[this.AHv];
    egE();
    int i;
    if ((this.AHw == null) || (this.AHw.size() <= 0))
    {
      this.AHs = true;
      ((Calendar)localObject1).add(5, -this.AHv);
      i = 0;
      while (i < this.AHx.length)
      {
        ((Calendar)localObject1).add(5, 1);
        this.AHx[i].timestamp = ((Calendar)localObject1).getTimeInMillis();
        this.AHx[i].kuN = 0;
        i += 1;
      }
      AppMethodBeat.o(103541);
      return;
    }
    this.AHs = false;
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.AHw);
    Collections.sort((List)localObject2);
    int m = ((List)localObject2).size();
    if ((paramBoolean) || (this.spf == -1))
    {
      i = m / this.AHv;
      if (m % this.AHv == 0) {
        break label413;
      }
    }
    int j;
    label413:
    for (this.spf = (i + 1);; this.spf = i)
    {
      if (this.spf > 4) {
        this.spf = 4;
      }
      this.AHt = this.spf;
      j = m - this.AHv * (this.spf - this.AHt + 1);
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = m - this.AHv * (this.spf - this.AHt);
      ad.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject2 = ((List)localObject2).subList(i, j);
      m = ((List)localObject2).size();
      j = k;
      if (m >= this.AHv) {
        break;
      }
      ((Calendar)localObject1).setTimeInMillis(((d)((List)localObject2).get(0)).field_timestamp);
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.AHv - m) {
          break;
        }
        ((Calendar)localObject1).add(5, -1);
        d locald = new d();
        locald.field_timestamp = ((Calendar)localObject1).getTimeInMillis();
        locald.field_step = 0;
        ((List)localObject2).add(0, locald);
        i += 1;
      }
    }
    while (j < this.AHv)
    {
      localObject1 = (d)((List)localObject2).get(j);
      this.AHx[j].kuN = ((d)localObject1).field_step;
      this.AHx[j].timestamp = ((d)localObject1).field_timestamp;
      j += 1;
    }
    AppMethodBeat.o(103541);
  }
  
  public final void a(SportChartView.a parama)
  {
    AppMethodBeat.i(103529);
    this.AHu = parama;
    if (parama == SportChartView.a.AHD) {}
    for (this.AHv = 7;; this.AHv = 30)
    {
      this.AHx = new b[this.AHv];
      egE();
      AppMethodBeat.o(103529);
      return;
    }
  }
  
  public final void gj(List<d> paramList)
  {
    AppMethodBeat.i(103535);
    this.AHw = paramList;
    sf(true);
    invalidate();
    AppMethodBeat.o(103535);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.gfT = getWidth();
    this.gfU = getHeight();
    this.qoC = ((this.gfT - this.qnK - this.qnM) / (this.AHv - 1));
    this.qoD = ((this.gfU - this.qnO - this.qnQ) / 2);
    int i = 0;
    while (i < this.AHx.length)
    {
      this.AHx[i].x = (this.qnK + this.qoC * i);
      i += 1;
    }
    i = this.AHx.length;
    int k = i;
    if (i > this.AHv) {
      k = this.AHv;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.AHx[i].kuN > 100000) {
        this.AHx[i].kuN = 100000;
      }
      if (this.AHx[i].kuN < 0) {
        this.AHx[i].kuN = 0;
      }
      int m = j;
      if (this.AHx[i].kuN > j) {
        m = this.AHx[i].kuN;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.qoz = ((this.gfU - this.qnO - this.qnQ) * 10000 / i);
      this.qoz = (this.gfU - this.qnQ - this.qoz);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.AHx[j].y = (this.gfU - this.qnQ - this.AHx[j].kuN / i * (this.gfU - this.qnO - this.qnQ));
          j += 1;
          continue;
          if ((j <= 15000) || (j > 100000)) {
            break label2014;
          }
          i = j;
          if (j / 5000.0D <= j / 5000.0F) {
            break;
          }
          i = (j / 5000 + 1) * 5000;
          break;
        }
      }
      i = 0;
      if (i < k)
      {
        if (i == 0) {
          this.AHx[i].xbO = this.AHq.format(new Date(this.AHx[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.AHu == SportChartView.a.AHE)
          {
            if (i % 6 == 5) {
              this.AHx[i].xbO = this.AHr.format(new Date(this.AHx[i].timestamp));
            } else {
              this.AHx[i].xbO = "";
            }
          }
          else {
            this.AHx[i].xbO = this.AHr.format(new Date(this.AHx[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.AHs)
      {
        m(paramCanvas);
        if (this.vnp != 2147483647)
        {
          i = this.vnp;
          if ((i >= 0) && (i <= this.AHv - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.qnv);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(p(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.AHv - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.qoP)
            {
              this.qoO = ((int)this.AHx[i].y - this.qoq);
              this.startY = this.qoO;
              this.qoP = true;
            }
            if (this.qoP)
            {
              f = (float)(this.startY / 8.0D);
              if (this.qoO > 0) {
                this.paint.setAlpha((this.startY - this.qoO) * 255 / this.startY);
              }
              paramCanvas.drawText(this.AHx[i].kuN, this.AHx[i].x, this.qoO + this.qoq, this.paint);
              if (this.AHu == SportChartView.a.AHE)
              {
                this.paint.reset();
                this.qoJ.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.qnp);
                this.paint.setStrokeWidth(this.qnI);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.qoJ.moveTo(this.AHx[i].x, this.gfU - this.qnW);
                this.qoJ.lineTo(this.AHx[i].x, this.qoO + this.qoq + this.qnE);
                paramCanvas.drawPath(this.qoJ, this.paint);
              }
              if (this.qoO <= 0) {
                break label1844;
              }
              if (this.qoO / this.startY > 1.0F / f) {
                break label1817;
              }
              this.qoO -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.vnp;
          if ((i >= 0) && (i <= this.AHv - 1)) {
            this.AHx[i].AHG = true;
          }
        }
      }
      this.paint.reset();
      this.qoJ.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.qnp);
      this.paint.setStrokeWidth(this.qnI);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.qoz != 0) && (!this.AHs))
      {
        this.qoJ.moveTo(this.qnK, this.qoz);
        this.qoJ.lineTo(this.gfT - this.qnS, this.qoz);
        paramCanvas.drawPath(this.qoJ, this.paint);
      }
      this.paint.reset();
      this.qoJ.reset();
      this.paint.setColor(this.qnp);
      this.paint.setStrokeWidth(this.qnI);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.qoJ.reset();
      this.qoJ.moveTo(this.qoa, this.gfU - this.qnW);
      this.qoJ.lineTo(this.gfT - this.qoc, this.gfU - this.qnW);
      this.qoJ.moveTo(this.qoa, this.qnY);
      this.qoJ.lineTo(this.gfT - this.qoc, this.qnY);
      paramCanvas.drawPath(this.qoJ, this.paint);
      if (!this.AHs)
      {
        this.paint.reset();
        this.paint.setColor(this.qnx);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(p(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131764118), this.gfT - this.qoe, (float)(this.qoz + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.AHz)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.qoA);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(p(2, 28.0F));
        localObject = String.valueOf(this.AHy);
        paramCanvas.drawText((String)localObject, this.gfT - this.qoo, this.qom, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(p(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131764121), this.gfT - this.qoo - f, this.qoi, this.paint);
      }
      for (;;)
      {
        if (this.AHx.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.gfU - this.qnW, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          cmE();
          if (!this.AHs) {
            c(paramCanvas, false);
          }
        }
        n(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.qoO = ((int)(this.qoO - f * (this.qoO / this.startY)));
        break;
        label1844:
        this.qoP = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.qoA);
        this.paint.setTextSize(p(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(2131764120), this.qok, this.qoi, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(p(2, 28.0F));
        paramCanvas.drawText(this.AHy, this.gfT - this.qoo, this.qom, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    GestureDetector localGestureDetector = this.iKD;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahp(), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.AHz = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.AHy = paramInt;
  }
  
  final class b
  {
    boolean AHG;
    int kuN;
    long timestamp;
    float x;
    String xbO = "";
    float y;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */