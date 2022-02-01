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
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  private int FsK;
  private int Kqp;
  private SimpleDateFormat Scq;
  private SimpleDateFormat Scr;
  private boolean Scs;
  private SportChartView.a Sct;
  private int Scu;
  private List<e> Scv;
  private b[] Scw;
  private int Scx;
  private boolean Scy;
  private GestureDetector.OnGestureListener Scz;
  private int mbM;
  private int mbN;
  private GestureDetector nwZ;
  Paint paint;
  private int xRatio;
  private final float yDA;
  private final int yDB;
  private final float yDC;
  private final int yDD;
  private final float yDE;
  private final int yDF;
  private final float yDG;
  private final int yDH;
  private final float yDI;
  private final int yDJ;
  private final float yDK;
  private final int yDL;
  private final float yDM;
  private final float yDN;
  private final float yDO;
  private final float yDP;
  private final int yDQ;
  private final int yDR;
  private final int yDS;
  private final int yDT;
  private final float yDU;
  private final int yDV;
  private final float yDW;
  private final int yDX;
  private final float yDY;
  private final int yDZ;
  private final int yDa;
  private final int yDb;
  private final int yDc;
  private final float yDd;
  private final float yDe;
  private final float yDf;
  private final float yDg;
  private final float yDh;
  private final int yDi;
  private final int yDj;
  private final int yDk;
  private final int yDl;
  private final float yDo;
  private final int yDp;
  private final float yDq;
  private final int yDr;
  private final float yDs;
  private final int yDt;
  private final float yDu;
  private final int yDv;
  private final float yDw;
  private final int yDx;
  private final float yDy;
  private final int yDz;
  private int yEA;
  private boolean yEB;
  private final float yEa;
  private final int yEb;
  private final float yEc;
  private final int yEd;
  private final int yEe;
  private final int yEf;
  private final int yEg;
  private final int yEh;
  private final int yEi;
  private final int yEj;
  private final int yEk;
  private final int yEl;
  private int yEm;
  private final Typeface yEn;
  private final Typeface yEo;
  Path yEu;
  Path yEv;
  private int yEz;
  private int yRatio;
  private int yag;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.Scq = new SimpleDateFormat(getResources().getString(a.b.Scl));
    this.Scr = new SimpleDateFormat("d");
    this.yDa = -1;
    this.yDb = -1;
    this.yDc = getResources().getColor(a.a.Sci);
    this.yDd = 12.0F;
    this.yDe = 24.0F;
    this.yDf = 28.0F;
    this.yDg = 12.0F;
    this.yDh = 12.0F;
    this.yDi = getResources().getColor(a.a.Scj);
    this.yDj = -1;
    this.yDk = getResources().getColor(a.a.Scj);
    this.yDl = -1;
    this.Kqp = 2147483647;
    this.mbM = 0;
    this.mbN = 0;
    this.yDo = 2.5F;
    this.yDp = ((int)u(1, 2.5F));
    this.yDq = 4.0F;
    this.yDr = ((int)u(1, 4.0F));
    this.yDs = 1.8F;
    this.yDt = ((int)u(1, 1.8F));
    this.yDu = 1.0F;
    this.yDv = ((int)u(1, 1.0F));
    this.yDw = 8.0F;
    this.yDx = ((int)u(1, 8.0F));
    this.yDy = 22.0F;
    this.yDz = ((int)u(1, 22.0F));
    this.yDA = 67.0F;
    this.yDB = ((int)u(1, 67.0F));
    this.yDC = 40.0F;
    this.yDD = ((int)u(1, 40.0F));
    this.yDE = 22.0F;
    this.yDF = ((int)u(1, 22.0F));
    this.yDG = 55.0F;
    this.yDH = ((int)u(1, 55.0F));
    this.yDI = 35.0F;
    this.yDJ = ((int)u(1, 35.0F));
    this.yDK = 45.0F;
    this.yDL = ((int)u(1, 45.0F));
    this.yDM = 8.0F;
    this.yDN = ((int)u(1, 8.0F));
    this.yDO = 8.0F;
    this.yDP = ((int)u(1, 8.0F));
    this.yDQ = 2;
    this.yDR = ((int)u(1, 2.0F));
    this.yDS = 15;
    this.yDT = ((int)u(1, 15.0F));
    this.yDU = 33.0F;
    this.yDV = ((int)u(1, 33.0F));
    this.yDW = 8.0F;
    this.yDX = ((int)u(1, 8.0F));
    this.yDY = 35.0F;
    this.yDZ = ((int)u(1, 35.0F));
    this.yEa = 10.0F;
    this.yEb = ((int)u(1, 10.0F));
    this.yEc = 58.0F;
    this.yEd = ((int)u(1, 58.0F));
    this.yEe = ((int)u(1, 1.0F));
    this.yEf = 102;
    this.yEg = 102;
    this.yEh = 153;
    this.yEi = 102;
    this.yEj = 102;
    this.yEk = 102;
    this.yEl = 204;
    this.yEm = 0;
    this.yEn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.yEo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.xRatio = 0;
    this.yRatio = 0;
    this.yag = -1;
    this.FsK = -1;
    this.Sct = SportChartView.a.ScC;
    this.Scu = 7;
    this.Scw = new b[this.Scu];
    this.Scz = new GestureDetector.SimpleOnGestureListener()
    {
      private long ScA;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(263952);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(263952);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(263951);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(263951);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(263948);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(263948);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.ScA < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.ScA = System.currentTimeMillis();
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
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        Log.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103524);
        return true;
      }
    };
    dHl();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.Scq = new SimpleDateFormat(getResources().getString(a.b.Scl));
    this.Scr = new SimpleDateFormat("d");
    this.yDa = -1;
    this.yDb = -1;
    this.yDc = getResources().getColor(a.a.Sci);
    this.yDd = 12.0F;
    this.yDe = 24.0F;
    this.yDf = 28.0F;
    this.yDg = 12.0F;
    this.yDh = 12.0F;
    this.yDi = getResources().getColor(a.a.Scj);
    this.yDj = -1;
    this.yDk = getResources().getColor(a.a.Scj);
    this.yDl = -1;
    this.Kqp = 2147483647;
    this.mbM = 0;
    this.mbN = 0;
    this.yDo = 2.5F;
    this.yDp = ((int)u(1, 2.5F));
    this.yDq = 4.0F;
    this.yDr = ((int)u(1, 4.0F));
    this.yDs = 1.8F;
    this.yDt = ((int)u(1, 1.8F));
    this.yDu = 1.0F;
    this.yDv = ((int)u(1, 1.0F));
    this.yDw = 8.0F;
    this.yDx = ((int)u(1, 8.0F));
    this.yDy = 22.0F;
    this.yDz = ((int)u(1, 22.0F));
    this.yDA = 67.0F;
    this.yDB = ((int)u(1, 67.0F));
    this.yDC = 40.0F;
    this.yDD = ((int)u(1, 40.0F));
    this.yDE = 22.0F;
    this.yDF = ((int)u(1, 22.0F));
    this.yDG = 55.0F;
    this.yDH = ((int)u(1, 55.0F));
    this.yDI = 35.0F;
    this.yDJ = ((int)u(1, 35.0F));
    this.yDK = 45.0F;
    this.yDL = ((int)u(1, 45.0F));
    this.yDM = 8.0F;
    this.yDN = ((int)u(1, 8.0F));
    this.yDO = 8.0F;
    this.yDP = ((int)u(1, 8.0F));
    this.yDQ = 2;
    this.yDR = ((int)u(1, 2.0F));
    this.yDS = 15;
    this.yDT = ((int)u(1, 15.0F));
    this.yDU = 33.0F;
    this.yDV = ((int)u(1, 33.0F));
    this.yDW = 8.0F;
    this.yDX = ((int)u(1, 8.0F));
    this.yDY = 35.0F;
    this.yDZ = ((int)u(1, 35.0F));
    this.yEa = 10.0F;
    this.yEb = ((int)u(1, 10.0F));
    this.yEc = 58.0F;
    this.yEd = ((int)u(1, 58.0F));
    this.yEe = ((int)u(1, 1.0F));
    this.yEf = 102;
    this.yEg = 102;
    this.yEh = 153;
    this.yEi = 102;
    this.yEj = 102;
    this.yEk = 102;
    this.yEl = 204;
    this.yEm = 0;
    this.yEn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.yEo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.xRatio = 0;
    this.yRatio = 0;
    this.yag = -1;
    this.FsK = -1;
    this.Sct = SportChartView.a.ScC;
    this.Scu = 7;
    this.Scw = new b[this.Scu];
    this.Scz = new GestureDetector.SimpleOnGestureListener()
    {
      private long ScA;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(263952);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(263952);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(263951);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(263951);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(263948);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(263948);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.ScA < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.ScA = System.currentTimeMillis();
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
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        Log.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(103524);
        return true;
      }
    };
    dHl();
    AppMethodBeat.o(103532);
  }
  
  private void d(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.yEv.reset();
      this.yEv.moveTo(this.Scw[0].x, this.Scw[0].y);
      i = 0;
      while (i < this.Scw.length)
      {
        this.yEv.lineTo(this.Scw[i].x, this.Scw[i].y);
        i += 1;
      }
      this.yEv.lineTo(this.Scw[(this.Scw.length - 1)].x, this.mbN - this.yDJ - 1);
      this.yEv.lineTo(this.yDx, this.mbN - this.yDJ - 1);
      this.yEv.lineTo(this.yDx, this.Scw[0].y);
      paramCanvas.drawPath(this.yEv, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.yEv.reset();
    this.yEv.moveTo(this.Scw[0].x, this.Scw[0].y);
    if (i < this.Scw.length)
    {
      if (i > 0) {
        if (this.Scw[(i - 1)].y == this.mbN - this.yDD)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.yDt);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.yEv.lineTo(this.Scw[i].x, this.Scw[i].y);
        paramCanvas.drawPath(this.yEv, this.paint);
        this.yEv.reset();
        this.yEv.moveTo(this.Scw[i].x, this.Scw[i].y);
        i += 1;
        break;
        dHn();
        continue;
        dHn();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void dHl()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.yEu = new Path();
    this.yEv = new Path();
    this.Scw = new b[this.Scu];
    huy();
    huz();
    this.nwZ = new GestureDetector(getContext(), this.Scz);
    AppMethodBeat.o(103538);
  }
  
  private void dHn()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.yDt);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void huy()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.Scw.length)
    {
      this.Scw[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void huz()
  {
    int i = 0;
    if (i < this.Scu)
    {
      if (i == this.Scu - 1) {}
      for (this.Scw[i].ScF = true;; this.Scw[i].ScF = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private float u(int paramInt, float paramFloat)
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
  
  private void u(Canvas paramCanvas)
  {
    AppMethodBeat.i(103534);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-1);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.Scw.length)
    {
      if (i == this.Scw.length - 1) {
        paramCanvas.drawCircle(this.Scw[i].x, this.Scw[i].y, this.yDr, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.Scw[i].x, this.Scw[i].y, this.yDp, this.paint);
      }
    }
    AppMethodBeat.o(103534);
  }
  
  private void v(Canvas paramCanvas)
  {
    AppMethodBeat.i(103537);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setTextSize(u(2, 12.0F));
    this.paint.setAlpha(153);
    int i = 0;
    if (i < this.Scw.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.Scw[i].ScF) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.Scw[i].NjO, this.Scw[i].x, this.mbN - this.yDT, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.yDi);
      }
    }
    AppMethodBeat.o(103537);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.mbM = getWidth();
    this.mbN = getHeight();
    this.xRatio = ((this.mbM - this.yDx - this.yDz) / (this.Scu - 1));
    this.yRatio = ((this.mbN - this.yDB - this.yDD) / 2);
    int i = 0;
    while (i < this.Scw.length)
    {
      this.Scw[i].x = (this.yDx + this.xRatio * i);
      i += 1;
    }
    i = this.Scw.length;
    int k = i;
    if (i > this.Scu) {
      k = this.Scu;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.Scw[i].rBp > 100000) {
        this.Scw[i].rBp = 100000;
      }
      if (this.Scw[i].rBp < 0) {
        this.Scw[i].rBp = 0;
      }
      int m = j;
      if (this.Scw[i].rBp > j) {
        m = this.Scw[i].rBp;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.yEm = ((this.mbN - this.yDB - this.yDD) * 10000 / i);
      this.yEm = (this.mbN - this.yDD - this.yEm);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.Scw[j].y = (this.mbN - this.yDD - this.Scw[j].rBp / i * (this.mbN - this.yDB - this.yDD));
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
          this.Scw[i].NjO = this.Scq.format(new Date(this.Scw[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.Sct == SportChartView.a.ScD)
          {
            if (i % 6 == 5) {
              this.Scw[i].NjO = this.Scr.format(new Date(this.Scw[i].timestamp));
            } else {
              this.Scw[i].NjO = "";
            }
          }
          else {
            this.Scw[i].NjO = this.Scr.format(new Date(this.Scw[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.Scs)
      {
        u(paramCanvas);
        if (this.Kqp != 2147483647)
        {
          i = this.Kqp;
          if ((i >= 0) && (i <= this.Scu - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.yDi);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(u(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.Scu - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.yEB)
            {
              this.yEz = ((int)this.Scw[i].y - this.yEd);
              this.yEA = this.yEz;
              this.yEB = true;
            }
            if (this.yEB)
            {
              f = (float)(this.yEA / 8.0D);
              if (this.yEz > 0) {
                this.paint.setAlpha((this.yEA - this.yEz) * 255 / this.yEA);
              }
              paramCanvas.drawText(this.Scw[i].rBp, this.Scw[i].x, this.yEz + this.yEd, this.paint);
              if (this.Sct == SportChartView.a.ScD)
              {
                this.paint.reset();
                this.yEu.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.yDc);
                this.paint.setStrokeWidth(this.yDv);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.yEu.moveTo(this.Scw[i].x, this.mbN - this.yDJ);
                this.yEu.lineTo(this.Scw[i].x, this.yEz + this.yEd + this.yDr);
                paramCanvas.drawPath(this.yEu, this.paint);
              }
              if (this.yEz <= 0) {
                break label1844;
              }
              if (this.yEz / this.yEA > 1.0F / f) {
                break label1817;
              }
              this.yEz -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.Kqp;
          if ((i >= 0) && (i <= this.Scu - 1)) {
            this.Scw[i].ScF = true;
          }
        }
      }
      this.paint.reset();
      this.yEu.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.yDc);
      this.paint.setStrokeWidth(this.yDv);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.yEm != 0) && (!this.Scs))
      {
        this.yEu.moveTo(this.yDx, this.yEm);
        this.yEu.lineTo(this.mbM - this.yDF, this.yEm);
        paramCanvas.drawPath(this.yEu, this.paint);
      }
      this.paint.reset();
      this.yEu.reset();
      this.paint.setColor(this.yDc);
      this.paint.setStrokeWidth(this.yDv);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.yEu.reset();
      this.yEu.moveTo(this.yDN, this.mbN - this.yDJ);
      this.yEu.lineTo(this.mbM - this.yDP, this.mbN - this.yDJ);
      this.yEu.moveTo(this.yDN, this.yDL);
      this.yEu.lineTo(this.mbM - this.yDP, this.yDL);
      paramCanvas.drawPath(this.yEu, this.paint);
      if (!this.Scs)
      {
        this.paint.reset();
        this.paint.setColor(this.yDk);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(u(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(a.b.Sck), this.mbM - this.yDR, (float)(this.yEm + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.Scy)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.yEn);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(u(2, 28.0F));
        localObject = String.valueOf(this.Scx);
        paramCanvas.drawText((String)localObject, this.mbM - this.yEb, this.yDZ, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(u(2, 24.0F));
        paramCanvas.drawText(getResources().getString(a.b.Scn), this.mbM - this.yEb - f, this.yDV, this.paint);
      }
      for (;;)
      {
        if (this.Scw.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.mbN - this.yDJ, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          d(paramCanvas, true);
          dHn();
          if (!this.Scs) {
            d(paramCanvas, false);
          }
        }
        v(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.yEz = ((int)(this.yEz - f * (this.yEz / this.yEA)));
        break;
        label1844:
        this.yEB = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.yEn);
        this.paint.setTextSize(u(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(a.b.Scm), this.yDX, this.yDV, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(u(2, 28.0F));
        paramCanvas.drawText(this.Scx, this.mbM - this.yEb, this.yDZ, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    GestureDetector localGestureDetector = this.nwZ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.Scy = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.Scx = paramInt;
  }
  
  final class b
  {
    String NjO = "";
    boolean ScF;
    int rBp;
    long timestamp;
    float x;
    float y;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */