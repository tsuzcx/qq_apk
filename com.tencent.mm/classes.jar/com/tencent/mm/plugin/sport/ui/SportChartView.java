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
import com.tencent.mm.sdk.platformtools.ae;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  private SimpleDateFormat AYT;
  private SimpleDateFormat AYU;
  private boolean AYV;
  private int AYW;
  private SportChartView.a AYX;
  private int AYY;
  private List<d> AYZ;
  private b[] AZa;
  private int AZb;
  private boolean AZc;
  private GestureDetector.OnGestureListener AZd;
  private int gil;
  private int gim;
  private GestureDetector iNw;
  Paint paint;
  private final int qtS;
  private final int qtT;
  private final int qtU;
  private final float qtV;
  private final float qtW;
  private final float qtX;
  private final float qtY;
  private final float qtZ;
  private final int quA;
  private final float quB;
  private final int quC;
  private final float quD;
  private final int quE;
  private final float quF;
  private final float quG;
  private final float quH;
  private final float quI;
  private final int quJ;
  private final int quK;
  private final int quL;
  private final int quM;
  private final float quN;
  private final int quO;
  private final float quP;
  private final int quQ;
  private final float quR;
  private final int quS;
  private final float quT;
  private final int quU;
  private final float quV;
  private final int quW;
  private final int quX;
  private final int quY;
  private final int quZ;
  private final int qub;
  private final int quc;
  private final int qud;
  private final int que;
  private final float quh;
  private final int qui;
  private final float quj;
  private final int quk;
  private final float qul;
  private final int qum;
  private final float qun;
  private final int quo;
  private final float qup;
  private final int quq;
  private final float qur;
  private final int qus;
  private final float qut;
  private final int quu;
  private final float quv;
  private final int quw;
  private final float qux;
  private final int quy;
  private final float quz;
  private final int qva;
  private final int qvb;
  private final int qvc;
  private final int qvd;
  private final int qve;
  private int qvf;
  private final Typeface qvg;
  private final Typeface qvh;
  private int qvi;
  private int qvj;
  Path qvp;
  Path qvq;
  private int qvu;
  private boolean qvv;
  private int startY;
  private int szq;
  private int vzu;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.AYT = new SimpleDateFormat(getResources().getString(2131764119));
    this.AYU = new SimpleDateFormat("d");
    this.qtS = -1;
    this.qtT = -1;
    this.qtU = getResources().getColor(2131100945);
    this.qtV = 12.0F;
    this.qtW = 24.0F;
    this.qtX = 28.0F;
    this.qtY = 12.0F;
    this.qtZ = 12.0F;
    this.qub = getResources().getColor(2131100946);
    this.quc = -1;
    this.qud = getResources().getColor(2131100946);
    this.que = -1;
    this.vzu = 2147483647;
    this.gil = 0;
    this.gim = 0;
    this.quh = 2.5F;
    this.qui = ((int)p(1, 2.5F));
    this.quj = 4.0F;
    this.quk = ((int)p(1, 4.0F));
    this.qul = 1.8F;
    this.qum = ((int)p(1, 1.8F));
    this.qun = 1.0F;
    this.quo = ((int)p(1, 1.0F));
    this.qup = 8.0F;
    this.quq = ((int)p(1, 8.0F));
    this.qur = 22.0F;
    this.qus = ((int)p(1, 22.0F));
    this.qut = 67.0F;
    this.quu = ((int)p(1, 67.0F));
    this.quv = 40.0F;
    this.quw = ((int)p(1, 40.0F));
    this.qux = 22.0F;
    this.quy = ((int)p(1, 22.0F));
    this.quz = 55.0F;
    this.quA = ((int)p(1, 55.0F));
    this.quB = 35.0F;
    this.quC = ((int)p(1, 35.0F));
    this.quD = 45.0F;
    this.quE = ((int)p(1, 45.0F));
    this.quF = 8.0F;
    this.quG = ((int)p(1, 8.0F));
    this.quH = 8.0F;
    this.quI = ((int)p(1, 8.0F));
    this.quJ = 2;
    this.quK = ((int)p(1, 2.0F));
    this.quL = 15;
    this.quM = ((int)p(1, 15.0F));
    this.quN = 33.0F;
    this.quO = ((int)p(1, 33.0F));
    this.quP = 8.0F;
    this.quQ = ((int)p(1, 8.0F));
    this.quR = 35.0F;
    this.quS = ((int)p(1, 35.0F));
    this.quT = 10.0F;
    this.quU = ((int)p(1, 10.0F));
    this.quV = 58.0F;
    this.quW = ((int)p(1, 58.0F));
    this.quX = ((int)p(1, 1.0F));
    this.quY = 102;
    this.quZ = 102;
    this.qva = 153;
    this.qvb = 102;
    this.qvc = 102;
    this.qvd = 102;
    this.qve = 204;
    this.qvf = 0;
    this.qvg = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qvh = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qvi = 0;
    this.qvj = 0;
    this.AYW = -1;
    this.szq = -1;
    this.AYX = SportChartView.a.AZg;
    this.AYY = 7;
    this.AZa = new b[this.AYY];
    this.AZd = new GestureDetector.SimpleOnGestureListener()
    {
      private long AZe;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210888);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210888);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210887);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210887);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210886);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(210886);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ae.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.AZe < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.AZe = System.currentTimeMillis();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        ae.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103524);
        return true;
      }
    };
    cnS();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.AYT = new SimpleDateFormat(getResources().getString(2131764119));
    this.AYU = new SimpleDateFormat("d");
    this.qtS = -1;
    this.qtT = -1;
    this.qtU = getResources().getColor(2131100945);
    this.qtV = 12.0F;
    this.qtW = 24.0F;
    this.qtX = 28.0F;
    this.qtY = 12.0F;
    this.qtZ = 12.0F;
    this.qub = getResources().getColor(2131100946);
    this.quc = -1;
    this.qud = getResources().getColor(2131100946);
    this.que = -1;
    this.vzu = 2147483647;
    this.gil = 0;
    this.gim = 0;
    this.quh = 2.5F;
    this.qui = ((int)p(1, 2.5F));
    this.quj = 4.0F;
    this.quk = ((int)p(1, 4.0F));
    this.qul = 1.8F;
    this.qum = ((int)p(1, 1.8F));
    this.qun = 1.0F;
    this.quo = ((int)p(1, 1.0F));
    this.qup = 8.0F;
    this.quq = ((int)p(1, 8.0F));
    this.qur = 22.0F;
    this.qus = ((int)p(1, 22.0F));
    this.qut = 67.0F;
    this.quu = ((int)p(1, 67.0F));
    this.quv = 40.0F;
    this.quw = ((int)p(1, 40.0F));
    this.qux = 22.0F;
    this.quy = ((int)p(1, 22.0F));
    this.quz = 55.0F;
    this.quA = ((int)p(1, 55.0F));
    this.quB = 35.0F;
    this.quC = ((int)p(1, 35.0F));
    this.quD = 45.0F;
    this.quE = ((int)p(1, 45.0F));
    this.quF = 8.0F;
    this.quG = ((int)p(1, 8.0F));
    this.quH = 8.0F;
    this.quI = ((int)p(1, 8.0F));
    this.quJ = 2;
    this.quK = ((int)p(1, 2.0F));
    this.quL = 15;
    this.quM = ((int)p(1, 15.0F));
    this.quN = 33.0F;
    this.quO = ((int)p(1, 33.0F));
    this.quP = 8.0F;
    this.quQ = ((int)p(1, 8.0F));
    this.quR = 35.0F;
    this.quS = ((int)p(1, 35.0F));
    this.quT = 10.0F;
    this.quU = ((int)p(1, 10.0F));
    this.quV = 58.0F;
    this.quW = ((int)p(1, 58.0F));
    this.quX = ((int)p(1, 1.0F));
    this.quY = 102;
    this.quZ = 102;
    this.qva = 153;
    this.qvb = 102;
    this.qvc = 102;
    this.qvd = 102;
    this.qve = 204;
    this.qvf = 0;
    this.qvg = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.qvh = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.qvi = 0;
    this.qvj = 0;
    this.AYW = -1;
    this.szq = -1;
    this.AYX = SportChartView.a.AZg;
    this.AYY = 7;
    this.AZa = new b[this.AYY];
    this.AZd = new GestureDetector.SimpleOnGestureListener()
    {
      private long AZe;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210888);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210888);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210887);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(210887);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(210886);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(210886);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ae.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.AZe < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.AZe = System.currentTimeMillis();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        ae.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103524);
        return true;
      }
    };
    cnS();
    AppMethodBeat.o(103532);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.qvq.reset();
      this.qvq.moveTo(this.AZa[0].x, this.AZa[0].y);
      i = 0;
      while (i < this.AZa.length)
      {
        this.qvq.lineTo(this.AZa[i].x, this.AZa[i].y);
        i += 1;
      }
      this.qvq.lineTo(this.AZa[(this.AZa.length - 1)].x, this.gim - this.quC - 1);
      this.qvq.lineTo(this.quq, this.gim - this.quC - 1);
      this.qvq.lineTo(this.quq, this.AZa[0].y);
      paramCanvas.drawPath(this.qvq, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.qvq.reset();
    this.qvq.moveTo(this.AZa[0].x, this.AZa[0].y);
    if (i < this.AZa.length)
    {
      if (i > 0) {
        if (this.AZa[(i - 1)].y == this.gim - this.quw)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.qum);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.qvq.lineTo(this.AZa[i].x, this.AZa[i].y);
        paramCanvas.drawPath(this.qvq, this.paint);
        this.qvq.reset();
        this.qvq.moveTo(this.AZa[i].x, this.AZa[i].y);
        i += 1;
        break;
        cnU();
        continue;
        cnU();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void cnS()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.qvp = new Path();
    this.qvq = new Path();
    this.AZa = new b[this.AYY];
    ekm();
    ekn();
    this.iNw = new GestureDetector(getContext(), this.AZd);
    AppMethodBeat.o(103538);
  }
  
  private void cnU()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.qum);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void ekm()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.AZa.length)
    {
      this.AZa[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void ekn()
  {
    int i = 0;
    if (i < this.AYY)
    {
      if (i == this.AYY - 1) {}
      for (this.AZa[i].AZj = true;; this.AZa[i].AZj = false)
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
    if (i < this.AZa.length)
    {
      if (i == this.AZa.length - 1) {
        paramCanvas.drawCircle(this.AZa[i].x, this.AZa[i].y, this.quk, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.AZa[i].x, this.AZa[i].y, this.qui, this.paint);
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
    if (i < this.AZa.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.AZa[i].AZj) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.AZa[i].xrF, this.AZa[i].x, this.gim - this.quM, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.qub);
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
  
  private void sm(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(103541);
    this.vzu = 2147483647;
    Object localObject1 = Calendar.getInstance();
    this.AZa = new b[this.AYY];
    ekm();
    int i;
    if ((this.AYZ == null) || (this.AYZ.size() <= 0))
    {
      this.AYV = true;
      ((Calendar)localObject1).add(5, -this.AYY);
      i = 0;
      while (i < this.AZa.length)
      {
        ((Calendar)localObject1).add(5, 1);
        this.AZa[i].timestamp = ((Calendar)localObject1).getTimeInMillis();
        this.AZa[i].kyd = 0;
        i += 1;
      }
      AppMethodBeat.o(103541);
      return;
    }
    this.AYV = false;
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.AYZ);
    Collections.sort((List)localObject2);
    int m = ((List)localObject2).size();
    if ((paramBoolean) || (this.szq == -1))
    {
      i = m / this.AYY;
      if (m % this.AYY == 0) {
        break label413;
      }
    }
    int j;
    label413:
    for (this.szq = (i + 1);; this.szq = i)
    {
      if (this.szq > 4) {
        this.szq = 4;
      }
      this.AYW = this.szq;
      j = m - this.AYY * (this.szq - this.AYW + 1);
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = m - this.AYY * (this.szq - this.AYW);
      ae.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject2 = ((List)localObject2).subList(i, j);
      m = ((List)localObject2).size();
      j = k;
      if (m >= this.AYY) {
        break;
      }
      ((Calendar)localObject1).setTimeInMillis(((d)((List)localObject2).get(0)).field_timestamp);
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.AYY - m) {
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
    while (j < this.AYY)
    {
      localObject1 = (d)((List)localObject2).get(j);
      this.AZa[j].kyd = ((d)localObject1).field_step;
      this.AZa[j].timestamp = ((d)localObject1).field_timestamp;
      j += 1;
    }
    AppMethodBeat.o(103541);
  }
  
  public final void a(SportChartView.a parama)
  {
    AppMethodBeat.i(103529);
    this.AYX = parama;
    if (parama == SportChartView.a.AZg) {}
    for (this.AYY = 7;; this.AYY = 30)
    {
      this.AZa = new b[this.AYY];
      ekm();
      AppMethodBeat.o(103529);
      return;
    }
  }
  
  public final void gs(List<d> paramList)
  {
    AppMethodBeat.i(103535);
    this.AYZ = paramList;
    sm(true);
    invalidate();
    AppMethodBeat.o(103535);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.gil = getWidth();
    this.gim = getHeight();
    this.qvi = ((this.gil - this.quq - this.qus) / (this.AYY - 1));
    this.qvj = ((this.gim - this.quu - this.quw) / 2);
    int i = 0;
    while (i < this.AZa.length)
    {
      this.AZa[i].x = (this.quq + this.qvi * i);
      i += 1;
    }
    i = this.AZa.length;
    int k = i;
    if (i > this.AYY) {
      k = this.AYY;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.AZa[i].kyd > 100000) {
        this.AZa[i].kyd = 100000;
      }
      if (this.AZa[i].kyd < 0) {
        this.AZa[i].kyd = 0;
      }
      int m = j;
      if (this.AZa[i].kyd > j) {
        m = this.AZa[i].kyd;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.qvf = ((this.gim - this.quu - this.quw) * 10000 / i);
      this.qvf = (this.gim - this.quw - this.qvf);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.AZa[j].y = (this.gim - this.quw - this.AZa[j].kyd / i * (this.gim - this.quu - this.quw));
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
          this.AZa[i].xrF = this.AYT.format(new Date(this.AZa[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.AYX == SportChartView.a.AZh)
          {
            if (i % 6 == 5) {
              this.AZa[i].xrF = this.AYU.format(new Date(this.AZa[i].timestamp));
            } else {
              this.AZa[i].xrF = "";
            }
          }
          else {
            this.AZa[i].xrF = this.AYU.format(new Date(this.AZa[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.AYV)
      {
        m(paramCanvas);
        if (this.vzu != 2147483647)
        {
          i = this.vzu;
          if ((i >= 0) && (i <= this.AYY - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.qub);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(p(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.AYY - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.qvv)
            {
              this.qvu = ((int)this.AZa[i].y - this.quW);
              this.startY = this.qvu;
              this.qvv = true;
            }
            if (this.qvv)
            {
              f = (float)(this.startY / 8.0D);
              if (this.qvu > 0) {
                this.paint.setAlpha((this.startY - this.qvu) * 255 / this.startY);
              }
              paramCanvas.drawText(this.AZa[i].kyd, this.AZa[i].x, this.qvu + this.quW, this.paint);
              if (this.AYX == SportChartView.a.AZh)
              {
                this.paint.reset();
                this.qvp.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.qtU);
                this.paint.setStrokeWidth(this.quo);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.qvp.moveTo(this.AZa[i].x, this.gim - this.quC);
                this.qvp.lineTo(this.AZa[i].x, this.qvu + this.quW + this.quk);
                paramCanvas.drawPath(this.qvp, this.paint);
              }
              if (this.qvu <= 0) {
                break label1844;
              }
              if (this.qvu / this.startY > 1.0F / f) {
                break label1817;
              }
              this.qvu -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.vzu;
          if ((i >= 0) && (i <= this.AYY - 1)) {
            this.AZa[i].AZj = true;
          }
        }
      }
      this.paint.reset();
      this.qvp.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.qtU);
      this.paint.setStrokeWidth(this.quo);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.qvf != 0) && (!this.AYV))
      {
        this.qvp.moveTo(this.quq, this.qvf);
        this.qvp.lineTo(this.gil - this.quy, this.qvf);
        paramCanvas.drawPath(this.qvp, this.paint);
      }
      this.paint.reset();
      this.qvp.reset();
      this.paint.setColor(this.qtU);
      this.paint.setStrokeWidth(this.quo);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.qvp.reset();
      this.qvp.moveTo(this.quG, this.gim - this.quC);
      this.qvp.lineTo(this.gil - this.quI, this.gim - this.quC);
      this.qvp.moveTo(this.quG, this.quE);
      this.qvp.lineTo(this.gil - this.quI, this.quE);
      paramCanvas.drawPath(this.qvp, this.paint);
      if (!this.AYV)
      {
        this.paint.reset();
        this.paint.setColor(this.qud);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(p(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131764118), this.gil - this.quK, (float)(this.qvf + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.AZc)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.qvg);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(p(2, 28.0F));
        localObject = String.valueOf(this.AZb);
        paramCanvas.drawText((String)localObject, this.gil - this.quU, this.quS, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(p(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131764121), this.gil - this.quU - f, this.quO, this.paint);
      }
      for (;;)
      {
        if (this.AZa.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.gim - this.quC, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          cnU();
          if (!this.AYV) {
            c(paramCanvas, false);
          }
        }
        n(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.qvu = ((int)(this.qvu - f * (this.qvu / this.startY)));
        break;
        label1844:
        this.qvv = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.qvg);
        this.paint.setTextSize(p(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(2131764120), this.quQ, this.quO, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(p(2, 28.0F));
        paramCanvas.drawText(this.AZb, this.gil - this.quU, this.quS, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    GestureDetector localGestureDetector = this.iNw;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahE(), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.AZc = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.AZb = paramInt;
  }
  
  final class b
  {
    boolean AZj;
    int kyd;
    long timestamp;
    float x;
    String xrF = "";
    float y;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */