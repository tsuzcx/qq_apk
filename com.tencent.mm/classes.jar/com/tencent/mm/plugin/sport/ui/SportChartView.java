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
  private int ExF;
  private int FBx;
  private SimpleDateFormat LyB;
  private SimpleDateFormat LyC;
  private boolean LyD;
  private SportChartView.a LyE;
  private int LyF;
  private List<e> LyG;
  private b[] LyH;
  private int LyI;
  private boolean LyJ;
  private GestureDetector.OnGestureListener LyK;
  private int jBZ;
  private int jCa;
  private GestureDetector mBn;
  Paint paint;
  private final int vqJ;
  private final int vqK;
  private final int vqL;
  private final float vqM;
  private final float vqN;
  private final float vqO;
  private final float vqP;
  private final float vqQ;
  private final int vqR;
  private final int vqS;
  private final int vqT;
  private final int vqU;
  private final float vqX;
  private final int vqY;
  private final float vqZ;
  private final int vrA;
  private final int vrB;
  private final int vrC;
  private final float vrD;
  private final int vrE;
  private final float vrF;
  private final int vrG;
  private final float vrH;
  private final int vrI;
  private final float vrJ;
  private final int vrK;
  private final float vrL;
  private final int vrM;
  private final int vrN;
  private final int vrO;
  private final int vrP;
  private final int vrQ;
  private final int vrR;
  private final int vrS;
  private final int vrT;
  private final int vrU;
  private int vrV;
  private final Typeface vrW;
  private final Typeface vrX;
  private int vrY;
  private int vrZ;
  private final int vra;
  private final float vrb;
  private final int vrc;
  private final float vrd;
  private final int vre;
  private final float vrf;
  private final int vrg;
  private final float vrh;
  private final int vri;
  private final float vrj;
  private final int vrk;
  private final float vrl;
  private final int vrm;
  private final float vrn;
  private final int vro;
  private final float vrp;
  private final int vrq;
  private final float vrr;
  private final int vrs;
  private final float vrt;
  private final int vru;
  private final float vrv;
  private final float vrw;
  private final float vrx;
  private final float vry;
  private final int vrz;
  Path vsf;
  Path vsg;
  private int vsk;
  private int vsl;
  private boolean vsm;
  private int zXe;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.LyB = new SimpleDateFormat(getResources().getString(a.b.Lyv));
    this.LyC = new SimpleDateFormat("d");
    this.vqJ = -1;
    this.vqK = -1;
    this.vqL = getResources().getColor(a.a.Lys);
    this.vqM = 12.0F;
    this.vqN = 24.0F;
    this.vqO = 28.0F;
    this.vqP = 12.0F;
    this.vqQ = 12.0F;
    this.vqR = getResources().getColor(a.a.Lyt);
    this.vqS = -1;
    this.vqT = getResources().getColor(a.a.Lyt);
    this.vqU = -1;
    this.ExF = 2147483647;
    this.jBZ = 0;
    this.jCa = 0;
    this.vqX = 2.5F;
    this.vqY = ((int)r(1, 2.5F));
    this.vqZ = 4.0F;
    this.vra = ((int)r(1, 4.0F));
    this.vrb = 1.8F;
    this.vrc = ((int)r(1, 1.8F));
    this.vrd = 1.0F;
    this.vre = ((int)r(1, 1.0F));
    this.vrf = 8.0F;
    this.vrg = ((int)r(1, 8.0F));
    this.vrh = 22.0F;
    this.vri = ((int)r(1, 22.0F));
    this.vrj = 67.0F;
    this.vrk = ((int)r(1, 67.0F));
    this.vrl = 40.0F;
    this.vrm = ((int)r(1, 40.0F));
    this.vrn = 22.0F;
    this.vro = ((int)r(1, 22.0F));
    this.vrp = 55.0F;
    this.vrq = ((int)r(1, 55.0F));
    this.vrr = 35.0F;
    this.vrs = ((int)r(1, 35.0F));
    this.vrt = 45.0F;
    this.vru = ((int)r(1, 45.0F));
    this.vrv = 8.0F;
    this.vrw = ((int)r(1, 8.0F));
    this.vrx = 8.0F;
    this.vry = ((int)r(1, 8.0F));
    this.vrz = 2;
    this.vrA = ((int)r(1, 2.0F));
    this.vrB = 15;
    this.vrC = ((int)r(1, 15.0F));
    this.vrD = 33.0F;
    this.vrE = ((int)r(1, 33.0F));
    this.vrF = 8.0F;
    this.vrG = ((int)r(1, 8.0F));
    this.vrH = 35.0F;
    this.vrI = ((int)r(1, 35.0F));
    this.vrJ = 10.0F;
    this.vrK = ((int)r(1, 10.0F));
    this.vrL = 58.0F;
    this.vrM = ((int)r(1, 58.0F));
    this.vrN = ((int)r(1, 1.0F));
    this.vrO = 102;
    this.vrP = 102;
    this.vrQ = 153;
    this.vrR = 102;
    this.vrS = 102;
    this.vrT = 102;
    this.vrU = 204;
    this.vrV = 0;
    this.vrW = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.vrX = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.vrY = 0;
    this.vrZ = 0;
    this.FBx = -1;
    this.zXe = -1;
    this.LyE = SportChartView.a.LyN;
    this.LyF = 7;
    this.LyH = new b[this.LyF];
    this.LyK = new GestureDetector.SimpleOnGestureListener()
    {
      private long LyL;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250074);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250074);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250072);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250072);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250071);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(250071);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.LyL < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.LyL = System.currentTimeMillis();
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
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
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
    daR();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.LyB = new SimpleDateFormat(getResources().getString(a.b.Lyv));
    this.LyC = new SimpleDateFormat("d");
    this.vqJ = -1;
    this.vqK = -1;
    this.vqL = getResources().getColor(a.a.Lys);
    this.vqM = 12.0F;
    this.vqN = 24.0F;
    this.vqO = 28.0F;
    this.vqP = 12.0F;
    this.vqQ = 12.0F;
    this.vqR = getResources().getColor(a.a.Lyt);
    this.vqS = -1;
    this.vqT = getResources().getColor(a.a.Lyt);
    this.vqU = -1;
    this.ExF = 2147483647;
    this.jBZ = 0;
    this.jCa = 0;
    this.vqX = 2.5F;
    this.vqY = ((int)r(1, 2.5F));
    this.vqZ = 4.0F;
    this.vra = ((int)r(1, 4.0F));
    this.vrb = 1.8F;
    this.vrc = ((int)r(1, 1.8F));
    this.vrd = 1.0F;
    this.vre = ((int)r(1, 1.0F));
    this.vrf = 8.0F;
    this.vrg = ((int)r(1, 8.0F));
    this.vrh = 22.0F;
    this.vri = ((int)r(1, 22.0F));
    this.vrj = 67.0F;
    this.vrk = ((int)r(1, 67.0F));
    this.vrl = 40.0F;
    this.vrm = ((int)r(1, 40.0F));
    this.vrn = 22.0F;
    this.vro = ((int)r(1, 22.0F));
    this.vrp = 55.0F;
    this.vrq = ((int)r(1, 55.0F));
    this.vrr = 35.0F;
    this.vrs = ((int)r(1, 35.0F));
    this.vrt = 45.0F;
    this.vru = ((int)r(1, 45.0F));
    this.vrv = 8.0F;
    this.vrw = ((int)r(1, 8.0F));
    this.vrx = 8.0F;
    this.vry = ((int)r(1, 8.0F));
    this.vrz = 2;
    this.vrA = ((int)r(1, 2.0F));
    this.vrB = 15;
    this.vrC = ((int)r(1, 15.0F));
    this.vrD = 33.0F;
    this.vrE = ((int)r(1, 33.0F));
    this.vrF = 8.0F;
    this.vrG = ((int)r(1, 8.0F));
    this.vrH = 35.0F;
    this.vrI = ((int)r(1, 35.0F));
    this.vrJ = 10.0F;
    this.vrK = ((int)r(1, 10.0F));
    this.vrL = 58.0F;
    this.vrM = ((int)r(1, 58.0F));
    this.vrN = ((int)r(1, 1.0F));
    this.vrO = 102;
    this.vrP = 102;
    this.vrQ = 153;
    this.vrR = 102;
    this.vrS = 102;
    this.vrT = 102;
    this.vrU = 204;
    this.vrV = 0;
    this.vrW = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.vrX = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.vrY = 0;
    this.vrZ = 0;
    this.FBx = -1;
    this.zXe = -1;
    this.LyE = SportChartView.a.LyN;
    this.LyF = 7;
    this.LyH = new b[this.LyF];
    this.LyK = new GestureDetector.SimpleOnGestureListener()
    {
      private long LyL;
      
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250074);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250074);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250072);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250072);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250071);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(250071);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        Log.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.LyL < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.LyL = System.currentTimeMillis();
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
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sport/ui/SportChartView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
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
    daR();
    AppMethodBeat.o(103532);
  }
  
  private void A(Canvas paramCanvas)
  {
    AppMethodBeat.i(103537);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setTextSize(r(2, 12.0F));
    this.paint.setAlpha(153);
    int i = 0;
    if (i < this.LyH.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.LyH[i].LyQ) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.LyH[i].Hma, this.LyH[i].x, this.jCa - this.vrC, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.vqR);
      }
    }
    AppMethodBeat.o(103537);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.vsg.reset();
      this.vsg.moveTo(this.LyH[0].x, this.LyH[0].y);
      i = 0;
      while (i < this.LyH.length)
      {
        this.vsg.lineTo(this.LyH[i].x, this.LyH[i].y);
        i += 1;
      }
      this.vsg.lineTo(this.LyH[(this.LyH.length - 1)].x, this.jCa - this.vrs - 1);
      this.vsg.lineTo(this.vrg, this.jCa - this.vrs - 1);
      this.vsg.lineTo(this.vrg, this.LyH[0].y);
      paramCanvas.drawPath(this.vsg, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.vsg.reset();
    this.vsg.moveTo(this.LyH[0].x, this.LyH[0].y);
    if (i < this.LyH.length)
    {
      if (i > 0) {
        if (this.LyH[(i - 1)].y == this.jCa - this.vrm)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.vrc);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.vsg.lineTo(this.LyH[i].x, this.LyH[i].y);
        paramCanvas.drawPath(this.vsg, this.paint);
        this.vsg.reset();
        this.vsg.moveTo(this.LyH[i].x, this.LyH[i].y);
        i += 1;
        break;
        daT();
        continue;
        daT();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void daR()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.vsf = new Path();
    this.vsg = new Path();
    this.LyH = new b[this.LyF];
    gbf();
    gbg();
    this.mBn = new GestureDetector(getContext(), this.LyK);
    AppMethodBeat.o(103538);
  }
  
  private void daT()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.vrc);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void gbf()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.LyH.length)
    {
      this.LyH[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void gbg()
  {
    int i = 0;
    if (i < this.LyF)
    {
      if (i == this.LyF - 1) {}
      for (this.LyH[i].LyQ = true;; this.LyH[i].LyQ = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private float r(int paramInt, float paramFloat)
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
  
  private void z(Canvas paramCanvas)
  {
    AppMethodBeat.i(103534);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-1);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.LyH.length)
    {
      if (i == this.LyH.length - 1) {
        paramCanvas.drawCircle(this.LyH[i].x, this.LyH[i].y, this.vra, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.LyH[i].x, this.LyH[i].y, this.vqY, this.paint);
      }
    }
    AppMethodBeat.o(103534);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.jBZ = getWidth();
    this.jCa = getHeight();
    this.vrY = ((this.jBZ - this.vrg - this.vri) / (this.LyF - 1));
    this.vrZ = ((this.jCa - this.vrk - this.vrm) / 2);
    int i = 0;
    while (i < this.LyH.length)
    {
      this.LyH[i].x = (this.vrg + this.vrY * i);
      i += 1;
    }
    i = this.LyH.length;
    int k = i;
    if (i > this.LyF) {
      k = this.LyF;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.LyH[i].oxQ > 100000) {
        this.LyH[i].oxQ = 100000;
      }
      if (this.LyH[i].oxQ < 0) {
        this.LyH[i].oxQ = 0;
      }
      int m = j;
      if (this.LyH[i].oxQ > j) {
        m = this.LyH[i].oxQ;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.vrV = ((this.jCa - this.vrk - this.vrm) * 10000 / i);
      this.vrV = (this.jCa - this.vrm - this.vrV);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.LyH[j].y = (this.jCa - this.vrm - this.LyH[j].oxQ / i * (this.jCa - this.vrk - this.vrm));
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
          this.LyH[i].Hma = this.LyB.format(new Date(this.LyH[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.LyE == SportChartView.a.LyO)
          {
            if (i % 6 == 5) {
              this.LyH[i].Hma = this.LyC.format(new Date(this.LyH[i].timestamp));
            } else {
              this.LyH[i].Hma = "";
            }
          }
          else {
            this.LyH[i].Hma = this.LyC.format(new Date(this.LyH[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.LyD)
      {
        z(paramCanvas);
        if (this.ExF != 2147483647)
        {
          i = this.ExF;
          if ((i >= 0) && (i <= this.LyF - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.vqR);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(r(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.LyF - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.vsm)
            {
              this.vsk = ((int)this.LyH[i].y - this.vrM);
              this.vsl = this.vsk;
              this.vsm = true;
            }
            if (this.vsm)
            {
              f = (float)(this.vsl / 8.0D);
              if (this.vsk > 0) {
                this.paint.setAlpha((this.vsl - this.vsk) * 255 / this.vsl);
              }
              paramCanvas.drawText(this.LyH[i].oxQ, this.LyH[i].x, this.vsk + this.vrM, this.paint);
              if (this.LyE == SportChartView.a.LyO)
              {
                this.paint.reset();
                this.vsf.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.vqL);
                this.paint.setStrokeWidth(this.vre);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.vsf.moveTo(this.LyH[i].x, this.jCa - this.vrs);
                this.vsf.lineTo(this.LyH[i].x, this.vsk + this.vrM + this.vra);
                paramCanvas.drawPath(this.vsf, this.paint);
              }
              if (this.vsk <= 0) {
                break label1844;
              }
              if (this.vsk / this.vsl > 1.0F / f) {
                break label1817;
              }
              this.vsk -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.ExF;
          if ((i >= 0) && (i <= this.LyF - 1)) {
            this.LyH[i].LyQ = true;
          }
        }
      }
      this.paint.reset();
      this.vsf.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.vqL);
      this.paint.setStrokeWidth(this.vre);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.vrV != 0) && (!this.LyD))
      {
        this.vsf.moveTo(this.vrg, this.vrV);
        this.vsf.lineTo(this.jBZ - this.vro, this.vrV);
        paramCanvas.drawPath(this.vsf, this.paint);
      }
      this.paint.reset();
      this.vsf.reset();
      this.paint.setColor(this.vqL);
      this.paint.setStrokeWidth(this.vre);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.vsf.reset();
      this.vsf.moveTo(this.vrw, this.jCa - this.vrs);
      this.vsf.lineTo(this.jBZ - this.vry, this.jCa - this.vrs);
      this.vsf.moveTo(this.vrw, this.vru);
      this.vsf.lineTo(this.jBZ - this.vry, this.vru);
      paramCanvas.drawPath(this.vsf, this.paint);
      if (!this.LyD)
      {
        this.paint.reset();
        this.paint.setColor(this.vqT);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(r(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(a.b.Lyu), this.jBZ - this.vrA, (float)(this.vrV + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.LyJ)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.vrW);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(r(2, 28.0F));
        localObject = String.valueOf(this.LyI);
        paramCanvas.drawText((String)localObject, this.jBZ - this.vrK, this.vrI, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(r(2, 24.0F));
        paramCanvas.drawText(getResources().getString(a.b.Lyx), this.jBZ - this.vrK - f, this.vrE, this.paint);
      }
      for (;;)
      {
        if (this.LyH.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.jCa - this.vrs, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          daT();
          if (!this.LyD) {
            c(paramCanvas, false);
          }
        }
        A(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.vsk = ((int)(this.vsk - f * (this.vsk / this.vsl)));
        break;
        label1844:
        this.vsm = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.vrW);
        this.paint.setTextSize(r(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(a.b.Lyw), this.vrG, this.vrE, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(r(2, 28.0F));
        paramCanvas.drawText(this.LyI, this.jBZ - this.vrK, this.vrI, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    GestureDetector localGestureDetector = this.mBn;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aFh(), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/sport/ui/SportChartView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.LyJ = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.LyI = paramInt;
  }
  
  final class b
  {
    String Hma = "";
    boolean LyQ;
    int oxQ;
    long timestamp;
    float x;
    float y;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */