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
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  private SimpleDateFormat FjQ;
  private SimpleDateFormat FjR;
  private boolean FjS;
  private SportChartView.a FjT;
  private int FjU;
  private List<d> FjV;
  private b[] FjW;
  private int FjX;
  private boolean FjY;
  private GestureDetector.OnGestureListener FjZ;
  private int gRD;
  private int gRE;
  private GestureDetector jKk;
  Paint paint;
  private final float rLA;
  private final int rLB;
  private final float rLC;
  private final int rLD;
  private final float rLE;
  private final int rLF;
  private final float rLG;
  private final int rLH;
  private final float rLI;
  private final int rLJ;
  private final float rLK;
  private final int rLL;
  private final float rLM;
  private final float rLN;
  private final float rLO;
  private final float rLP;
  private final int rLQ;
  private final int rLR;
  private final int rLS;
  private final int rLT;
  private final float rLU;
  private final int rLV;
  private final float rLW;
  private final int rLX;
  private final float rLY;
  private final int rLZ;
  private final int rLa;
  private final int rLb;
  private final int rLc;
  private final float rLd;
  private final float rLe;
  private final float rLf;
  private final float rLg;
  private final float rLh;
  private final int rLi;
  private final int rLj;
  private final int rLk;
  private final int rLl;
  private final float rLo;
  private final int rLp;
  private final float rLq;
  private final int rLr;
  private final float rLs;
  private final int rLt;
  private final float rLu;
  private final int rLv;
  private final float rLw;
  private final int rLx;
  private final float rLy;
  private final int rLz;
  private int rMB;
  private boolean rMC;
  private final float rMa;
  private final int rMb;
  private final float rMc;
  private final int rMd;
  private final int rMe;
  private final int rMf;
  private final int rMg;
  private final int rMh;
  private final int rMi;
  private final int rMj;
  private final int rMk;
  private final int rMl;
  private int rMm;
  private final Typeface rMn;
  private final Typeface rMo;
  private int rMp;
  private int rMq;
  Path rMw;
  Path rMx;
  private int startY;
  private int vfW;
  private int yTI;
  private int zVN;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.FjQ = new SimpleDateFormat(getResources().getString(2131766368));
    this.FjR = new SimpleDateFormat("d");
    this.rLa = -1;
    this.rLb = -1;
    this.rLc = getResources().getColor(2131101163);
    this.rLd = 12.0F;
    this.rLe = 24.0F;
    this.rLf = 28.0F;
    this.rLg = 12.0F;
    this.rLh = 12.0F;
    this.rLi = getResources().getColor(2131101164);
    this.rLj = -1;
    this.rLk = getResources().getColor(2131101164);
    this.rLl = -1;
    this.yTI = 2147483647;
    this.gRD = 0;
    this.gRE = 0;
    this.rLo = 2.5F;
    this.rLp = ((int)q(1, 2.5F));
    this.rLq = 4.0F;
    this.rLr = ((int)q(1, 4.0F));
    this.rLs = 1.8F;
    this.rLt = ((int)q(1, 1.8F));
    this.rLu = 1.0F;
    this.rLv = ((int)q(1, 1.0F));
    this.rLw = 8.0F;
    this.rLx = ((int)q(1, 8.0F));
    this.rLy = 22.0F;
    this.rLz = ((int)q(1, 22.0F));
    this.rLA = 67.0F;
    this.rLB = ((int)q(1, 67.0F));
    this.rLC = 40.0F;
    this.rLD = ((int)q(1, 40.0F));
    this.rLE = 22.0F;
    this.rLF = ((int)q(1, 22.0F));
    this.rLG = 55.0F;
    this.rLH = ((int)q(1, 55.0F));
    this.rLI = 35.0F;
    this.rLJ = ((int)q(1, 35.0F));
    this.rLK = 45.0F;
    this.rLL = ((int)q(1, 45.0F));
    this.rLM = 8.0F;
    this.rLN = ((int)q(1, 8.0F));
    this.rLO = 8.0F;
    this.rLP = ((int)q(1, 8.0F));
    this.rLQ = 2;
    this.rLR = ((int)q(1, 2.0F));
    this.rLS = 15;
    this.rLT = ((int)q(1, 15.0F));
    this.rLU = 33.0F;
    this.rLV = ((int)q(1, 33.0F));
    this.rLW = 8.0F;
    this.rLX = ((int)q(1, 8.0F));
    this.rLY = 35.0F;
    this.rLZ = ((int)q(1, 35.0F));
    this.rMa = 10.0F;
    this.rMb = ((int)q(1, 10.0F));
    this.rMc = 58.0F;
    this.rMd = ((int)q(1, 58.0F));
    this.rMe = ((int)q(1, 1.0F));
    this.rMf = 102;
    this.rMg = 102;
    this.rMh = 153;
    this.rMi = 102;
    this.rMj = 102;
    this.rMk = 102;
    this.rMl = 204;
    this.rMm = 0;
    this.rMn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.rMo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.rMp = 0;
    this.rMq = 0;
    this.zVN = -1;
    this.vfW = -1;
    this.FjT = SportChartView.a.Fkc;
    this.FjU = 7;
    this.FjW = new b[this.FjU];
    this.FjZ = new GestureDetector.SimpleOnGestureListener()
    {
      private long Fka;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(224208);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(224208);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(224207);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(224207);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(224206);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(224206);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.Fka < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.Fka = System.currentTimeMillis();
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
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
    cMe();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.FjQ = new SimpleDateFormat(getResources().getString(2131766368));
    this.FjR = new SimpleDateFormat("d");
    this.rLa = -1;
    this.rLb = -1;
    this.rLc = getResources().getColor(2131101163);
    this.rLd = 12.0F;
    this.rLe = 24.0F;
    this.rLf = 28.0F;
    this.rLg = 12.0F;
    this.rLh = 12.0F;
    this.rLi = getResources().getColor(2131101164);
    this.rLj = -1;
    this.rLk = getResources().getColor(2131101164);
    this.rLl = -1;
    this.yTI = 2147483647;
    this.gRD = 0;
    this.gRE = 0;
    this.rLo = 2.5F;
    this.rLp = ((int)q(1, 2.5F));
    this.rLq = 4.0F;
    this.rLr = ((int)q(1, 4.0F));
    this.rLs = 1.8F;
    this.rLt = ((int)q(1, 1.8F));
    this.rLu = 1.0F;
    this.rLv = ((int)q(1, 1.0F));
    this.rLw = 8.0F;
    this.rLx = ((int)q(1, 8.0F));
    this.rLy = 22.0F;
    this.rLz = ((int)q(1, 22.0F));
    this.rLA = 67.0F;
    this.rLB = ((int)q(1, 67.0F));
    this.rLC = 40.0F;
    this.rLD = ((int)q(1, 40.0F));
    this.rLE = 22.0F;
    this.rLF = ((int)q(1, 22.0F));
    this.rLG = 55.0F;
    this.rLH = ((int)q(1, 55.0F));
    this.rLI = 35.0F;
    this.rLJ = ((int)q(1, 35.0F));
    this.rLK = 45.0F;
    this.rLL = ((int)q(1, 45.0F));
    this.rLM = 8.0F;
    this.rLN = ((int)q(1, 8.0F));
    this.rLO = 8.0F;
    this.rLP = ((int)q(1, 8.0F));
    this.rLQ = 2;
    this.rLR = ((int)q(1, 2.0F));
    this.rLS = 15;
    this.rLT = ((int)q(1, 15.0F));
    this.rLU = 33.0F;
    this.rLV = ((int)q(1, 33.0F));
    this.rLW = 8.0F;
    this.rLX = ((int)q(1, 8.0F));
    this.rLY = 35.0F;
    this.rLZ = ((int)q(1, 35.0F));
    this.rMa = 10.0F;
    this.rMb = ((int)q(1, 10.0F));
    this.rMc = 58.0F;
    this.rMd = ((int)q(1, 58.0F));
    this.rMe = ((int)q(1, 1.0F));
    this.rMf = 102;
    this.rMg = 102;
    this.rMh = 153;
    this.rMi = 102;
    this.rMj = 102;
    this.rMk = 102;
    this.rMl = 204;
    this.rMm = 0;
    this.rMn = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.rMo = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.rMp = 0;
    this.rMq = 0;
    this.zVN = -1;
    this.vfW = -1;
    this.FjT = SportChartView.a.Fkc;
    this.FjU = 7;
    this.FjW = new b[this.FjU];
    this.FjZ = new GestureDetector.SimpleOnGestureListener()
    {
      private long Fka;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(224208);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(224208);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(224207);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(224207);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(224206);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(224206);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.Fka < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.Fka = System.currentTimeMillis();
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
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
    cMe();
    AppMethodBeat.o(103532);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.rMx.reset();
      this.rMx.moveTo(this.FjW[0].x, this.FjW[0].y);
      i = 0;
      while (i < this.FjW.length)
      {
        this.rMx.lineTo(this.FjW[i].x, this.FjW[i].y);
        i += 1;
      }
      this.rMx.lineTo(this.FjW[(this.FjW.length - 1)].x, this.gRE - this.rLJ - 1);
      this.rMx.lineTo(this.rLx, this.gRE - this.rLJ - 1);
      this.rMx.lineTo(this.rLx, this.FjW[0].y);
      paramCanvas.drawPath(this.rMx, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.rMx.reset();
    this.rMx.moveTo(this.FjW[0].x, this.FjW[0].y);
    if (i < this.FjW.length)
    {
      if (i > 0) {
        if (this.FjW[(i - 1)].y == this.gRE - this.rLD)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.rLt);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.rMx.lineTo(this.FjW[i].x, this.FjW[i].y);
        paramCanvas.drawPath(this.rMx, this.paint);
        this.rMx.reset();
        this.rMx.moveTo(this.FjW[i].x, this.FjW[i].y);
        i += 1;
        break;
        cMg();
        continue;
        cMg();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void cMe()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.rMw = new Path();
    this.rMx = new Path();
    this.FjW = new b[this.FjU];
    fmM();
    fmN();
    this.jKk = new GestureDetector(getContext(), this.FjZ);
    AppMethodBeat.o(103538);
  }
  
  private void cMg()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.rLt);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void fmM()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.FjW.length)
    {
      this.FjW[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void fmN()
  {
    int i = 0;
    if (i < this.FjU)
    {
      if (i == this.FjU - 1) {}
      for (this.FjW[i].Fkf = true;; this.FjW[i].Fkf = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private float q(int paramInt, float paramFloat)
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
  
  private void w(Canvas paramCanvas)
  {
    AppMethodBeat.i(103534);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-1);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.FjW.length)
    {
      if (i == this.FjW.length - 1) {
        paramCanvas.drawCircle(this.FjW[i].x, this.FjW[i].y, this.rLr, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.FjW[i].x, this.FjW[i].y, this.rLp, this.paint);
      }
    }
    AppMethodBeat.o(103534);
  }
  
  private void x(Canvas paramCanvas)
  {
    AppMethodBeat.i(103537);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setTextSize(q(2, 12.0F));
    this.paint.setAlpha(153);
    int i = 0;
    if (i < this.FjW.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.FjW[i].Fkf) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.FjW[i].BrH, this.FjW[i].x, this.gRE - this.rLT, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.rLi);
      }
    }
    AppMethodBeat.o(103537);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.gRD = getWidth();
    this.gRE = getHeight();
    this.rMp = ((this.gRD - this.rLx - this.rLz) / (this.FjU - 1));
    this.rMq = ((this.gRE - this.rLB - this.rLD) / 2);
    int i = 0;
    while (i < this.FjW.length)
    {
      this.FjW[i].x = (this.rLx + this.rMp * i);
      i += 1;
    }
    i = this.FjW.length;
    int k = i;
    if (i > this.FjU) {
      k = this.FjU;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.FjW[i].lCq > 100000) {
        this.FjW[i].lCq = 100000;
      }
      if (this.FjW[i].lCq < 0) {
        this.FjW[i].lCq = 0;
      }
      int m = j;
      if (this.FjW[i].lCq > j) {
        m = this.FjW[i].lCq;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.rMm = ((this.gRE - this.rLB - this.rLD) * 10000 / i);
      this.rMm = (this.gRE - this.rLD - this.rMm);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.FjW[j].y = (this.gRE - this.rLD - this.FjW[j].lCq / i * (this.gRE - this.rLB - this.rLD));
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
          this.FjW[i].BrH = this.FjQ.format(new Date(this.FjW[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.FjT == SportChartView.a.Fkd)
          {
            if (i % 6 == 5) {
              this.FjW[i].BrH = this.FjR.format(new Date(this.FjW[i].timestamp));
            } else {
              this.FjW[i].BrH = "";
            }
          }
          else {
            this.FjW[i].BrH = this.FjR.format(new Date(this.FjW[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.FjS)
      {
        w(paramCanvas);
        if (this.yTI != 2147483647)
        {
          i = this.yTI;
          if ((i >= 0) && (i <= this.FjU - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.rLi);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(q(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.FjU - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.rMC)
            {
              this.rMB = ((int)this.FjW[i].y - this.rMd);
              this.startY = this.rMB;
              this.rMC = true;
            }
            if (this.rMC)
            {
              f = (float)(this.startY / 8.0D);
              if (this.rMB > 0) {
                this.paint.setAlpha((this.startY - this.rMB) * 255 / this.startY);
              }
              paramCanvas.drawText(this.FjW[i].lCq, this.FjW[i].x, this.rMB + this.rMd, this.paint);
              if (this.FjT == SportChartView.a.Fkd)
              {
                this.paint.reset();
                this.rMw.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.rLc);
                this.paint.setStrokeWidth(this.rLv);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.rMw.moveTo(this.FjW[i].x, this.gRE - this.rLJ);
                this.rMw.lineTo(this.FjW[i].x, this.rMB + this.rMd + this.rLr);
                paramCanvas.drawPath(this.rMw, this.paint);
              }
              if (this.rMB <= 0) {
                break label1844;
              }
              if (this.rMB / this.startY > 1.0F / f) {
                break label1817;
              }
              this.rMB -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.yTI;
          if ((i >= 0) && (i <= this.FjU - 1)) {
            this.FjW[i].Fkf = true;
          }
        }
      }
      this.paint.reset();
      this.rMw.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.rLc);
      this.paint.setStrokeWidth(this.rLv);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.rMm != 0) && (!this.FjS))
      {
        this.rMw.moveTo(this.rLx, this.rMm);
        this.rMw.lineTo(this.gRD - this.rLF, this.rMm);
        paramCanvas.drawPath(this.rMw, this.paint);
      }
      this.paint.reset();
      this.rMw.reset();
      this.paint.setColor(this.rLc);
      this.paint.setStrokeWidth(this.rLv);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.rMw.reset();
      this.rMw.moveTo(this.rLN, this.gRE - this.rLJ);
      this.rMw.lineTo(this.gRD - this.rLP, this.gRE - this.rLJ);
      this.rMw.moveTo(this.rLN, this.rLL);
      this.rMw.lineTo(this.gRD - this.rLP, this.rLL);
      paramCanvas.drawPath(this.rMw, this.paint);
      if (!this.FjS)
      {
        this.paint.reset();
        this.paint.setColor(this.rLk);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(q(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131766367), this.gRD - this.rLR, (float)(this.rMm + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.FjY)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.rMn);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(q(2, 28.0F));
        localObject = String.valueOf(this.FjX);
        paramCanvas.drawText((String)localObject, this.gRD - this.rMb, this.rLZ, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(q(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131766370), this.gRD - this.rMb - f, this.rLV, this.paint);
      }
      for (;;)
      {
        if (this.FjW.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.gRE - this.rLJ, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          cMg();
          if (!this.FjS) {
            c(paramCanvas, false);
          }
        }
        x(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.rMB = ((int)(this.rMB - f * (this.rMB / this.startY)));
        break;
        label1844:
        this.rMC = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.rMn);
        this.paint.setTextSize(q(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(2131766369), this.rLX, this.rLV, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(q(2, 28.0F));
        paramCanvas.drawText(this.FjX, this.gRD - this.rMb, this.rLZ, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    GestureDetector localGestureDetector = this.jKk;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.axQ(), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.FjY = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.FjX = paramInt;
  }
  
  final class b
  {
    String BrH = "";
    boolean Fkf;
    int lCq;
    long timestamp;
    float x;
    float y;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */