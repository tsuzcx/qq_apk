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
  private int fIN;
  private int fIO;
  private GestureDetector hRv;
  private int maxPageIndex;
  Paint paint;
  private final int pgA;
  private final float pgB;
  private final float pgC;
  private final float pgD;
  private final float pgE;
  private final float pgF;
  private final int pgG;
  private final int pgH;
  private final int pgI;
  private final int pgJ;
  private final float pgM;
  private final int pgN;
  private final float pgO;
  private final int pgP;
  private final float pgQ;
  private final int pgR;
  private final float pgS;
  private final int pgT;
  private final float pgU;
  private final int pgV;
  private final float pgW;
  private final int pgX;
  private final float pgY;
  private final int pgZ;
  private final int pgy;
  private final int pgz;
  private final float phA;
  private final int phB;
  private final int phC;
  private final int phD;
  private final int phE;
  private final int phF;
  private final int phG;
  private final int phH;
  private final int phI;
  private final int phJ;
  private int phK;
  private final Typeface phL;
  private final Typeface phM;
  private int phN;
  private int phO;
  Path phU;
  Path phV;
  private int phZ;
  private final float pha;
  private final int phb;
  private final float phc;
  private final int phd;
  private final float phe;
  private final int phf;
  private final float phg;
  private final int phh;
  private final float phi;
  private final int phj;
  private final float phk;
  private final float phl;
  private final float phm;
  private final float phn;
  private final int pho;
  private final int php;
  private final int phq;
  private final int phr;
  private final float phs;
  private final int pht;
  private final float phu;
  private final int phv;
  private final float phw;
  private final int phx;
  private final float phy;
  private final int phz;
  private boolean pia;
  private int startY;
  private int tcu;
  private SportChartView.a ycA;
  private int ycB;
  private List<d> ycC;
  private b[] ycD;
  private int ycE;
  private boolean ycF;
  private GestureDetector.OnGestureListener ycG;
  private SimpleDateFormat ycw;
  private SimpleDateFormat ycx;
  private boolean ycy;
  private int ycz;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.ycw = new SimpleDateFormat(getResources().getString(2131764119));
    this.ycx = new SimpleDateFormat("d");
    this.pgy = -1;
    this.pgz = -1;
    this.pgA = getResources().getColor(2131100945);
    this.pgB = 12.0F;
    this.pgC = 24.0F;
    this.pgD = 28.0F;
    this.pgE = 12.0F;
    this.pgF = 12.0F;
    this.pgG = getResources().getColor(2131100946);
    this.pgH = -1;
    this.pgI = getResources().getColor(2131100946);
    this.pgJ = -1;
    this.tcu = 2147483647;
    this.fIN = 0;
    this.fIO = 0;
    this.pgM = 2.5F;
    this.pgN = ((int)o(1, 2.5F));
    this.pgO = 4.0F;
    this.pgP = ((int)o(1, 4.0F));
    this.pgQ = 1.8F;
    this.pgR = ((int)o(1, 1.8F));
    this.pgS = 1.0F;
    this.pgT = ((int)o(1, 1.0F));
    this.pgU = 8.0F;
    this.pgV = ((int)o(1, 8.0F));
    this.pgW = 22.0F;
    this.pgX = ((int)o(1, 22.0F));
    this.pgY = 67.0F;
    this.pgZ = ((int)o(1, 67.0F));
    this.pha = 40.0F;
    this.phb = ((int)o(1, 40.0F));
    this.phc = 22.0F;
    this.phd = ((int)o(1, 22.0F));
    this.phe = 55.0F;
    this.phf = ((int)o(1, 55.0F));
    this.phg = 35.0F;
    this.phh = ((int)o(1, 35.0F));
    this.phi = 45.0F;
    this.phj = ((int)o(1, 45.0F));
    this.phk = 8.0F;
    this.phl = ((int)o(1, 8.0F));
    this.phm = 8.0F;
    this.phn = ((int)o(1, 8.0F));
    this.pho = 2;
    this.php = ((int)o(1, 2.0F));
    this.phq = 15;
    this.phr = ((int)o(1, 15.0F));
    this.phs = 33.0F;
    this.pht = ((int)o(1, 33.0F));
    this.phu = 8.0F;
    this.phv = ((int)o(1, 8.0F));
    this.phw = 35.0F;
    this.phx = ((int)o(1, 35.0F));
    this.phy = 10.0F;
    this.phz = ((int)o(1, 10.0F));
    this.phA = 58.0F;
    this.phB = ((int)o(1, 58.0F));
    this.phC = ((int)o(1, 1.0F));
    this.phD = 102;
    this.phE = 102;
    this.phF = 153;
    this.phG = 102;
    this.phH = 102;
    this.phI = 102;
    this.phJ = 204;
    this.phK = 0;
    this.phL = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.phM = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.phN = 0;
    this.phO = 0;
    this.ycz = -1;
    this.maxPageIndex = -1;
    this.ycA = SportChartView.a.ycJ;
    this.ycB = 7;
    this.ycD = new b[this.ycB];
    this.ycG = new GestureDetector.SimpleOnGestureListener()
    {
      private long ycH;
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ad.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.ycH < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.ycH = System.currentTimeMillis();
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
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        ad.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        AppMethodBeat.o(103524);
        return true;
      }
    };
    caP();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.ycw = new SimpleDateFormat(getResources().getString(2131764119));
    this.ycx = new SimpleDateFormat("d");
    this.pgy = -1;
    this.pgz = -1;
    this.pgA = getResources().getColor(2131100945);
    this.pgB = 12.0F;
    this.pgC = 24.0F;
    this.pgD = 28.0F;
    this.pgE = 12.0F;
    this.pgF = 12.0F;
    this.pgG = getResources().getColor(2131100946);
    this.pgH = -1;
    this.pgI = getResources().getColor(2131100946);
    this.pgJ = -1;
    this.tcu = 2147483647;
    this.fIN = 0;
    this.fIO = 0;
    this.pgM = 2.5F;
    this.pgN = ((int)o(1, 2.5F));
    this.pgO = 4.0F;
    this.pgP = ((int)o(1, 4.0F));
    this.pgQ = 1.8F;
    this.pgR = ((int)o(1, 1.8F));
    this.pgS = 1.0F;
    this.pgT = ((int)o(1, 1.0F));
    this.pgU = 8.0F;
    this.pgV = ((int)o(1, 8.0F));
    this.pgW = 22.0F;
    this.pgX = ((int)o(1, 22.0F));
    this.pgY = 67.0F;
    this.pgZ = ((int)o(1, 67.0F));
    this.pha = 40.0F;
    this.phb = ((int)o(1, 40.0F));
    this.phc = 22.0F;
    this.phd = ((int)o(1, 22.0F));
    this.phe = 55.0F;
    this.phf = ((int)o(1, 55.0F));
    this.phg = 35.0F;
    this.phh = ((int)o(1, 35.0F));
    this.phi = 45.0F;
    this.phj = ((int)o(1, 45.0F));
    this.phk = 8.0F;
    this.phl = ((int)o(1, 8.0F));
    this.phm = 8.0F;
    this.phn = ((int)o(1, 8.0F));
    this.pho = 2;
    this.php = ((int)o(1, 2.0F));
    this.phq = 15;
    this.phr = ((int)o(1, 15.0F));
    this.phs = 33.0F;
    this.pht = ((int)o(1, 33.0F));
    this.phu = 8.0F;
    this.phv = ((int)o(1, 8.0F));
    this.phw = 35.0F;
    this.phx = ((int)o(1, 35.0F));
    this.phy = 10.0F;
    this.phz = ((int)o(1, 10.0F));
    this.phA = 58.0F;
    this.phB = ((int)o(1, 58.0F));
    this.phC = ((int)o(1, 1.0F));
    this.phD = 102;
    this.phE = 102;
    this.phF = 153;
    this.phG = 102;
    this.phH = 102;
    this.phI = 102;
    this.phJ = 204;
    this.phK = 0;
    this.phL = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.phM = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.phN = 0;
    this.phO = 0;
    this.ycz = -1;
    this.maxPageIndex = -1;
    this.ycA = SportChartView.a.ycJ;
    this.ycB = 7;
    this.ycD = new b[this.ycB];
    this.ycG = new GestureDetector.SimpleOnGestureListener()
    {
      private long ycH;
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ad.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.ycH < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.ycH = System.currentTimeMillis();
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
        float f1 = paramAnonymousMotionEvent.getX();
        float f2 = paramAnonymousMotionEvent.getY();
        SportChartView.a(SportChartView.this, SportChartView.a(SportChartView.this, f1));
        SportChartView.a(SportChartView.this);
        SportChartView.b(SportChartView.this);
        ad.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        AppMethodBeat.o(103524);
        return true;
      }
    };
    caP();
    AppMethodBeat.o(103532);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.phV.reset();
      this.phV.moveTo(this.ycD[0].x, this.ycD[0].y);
      i = 0;
      while (i < this.ycD.length)
      {
        this.phV.lineTo(this.ycD[i].x, this.ycD[i].y);
        i += 1;
      }
      this.phV.lineTo(this.ycD[(this.ycD.length - 1)].x, this.fIO - this.phh - 1);
      this.phV.lineTo(this.pgV, this.fIO - this.phh - 1);
      this.phV.lineTo(this.pgV, this.ycD[0].y);
      paramCanvas.drawPath(this.phV, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.phV.reset();
    this.phV.moveTo(this.ycD[0].x, this.ycD[0].y);
    if (i < this.ycD.length)
    {
      if (i > 0) {
        if (this.ycD[(i - 1)].y == this.fIO - this.phb)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.pgR);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.phV.lineTo(this.ycD[i].x, this.ycD[i].y);
        paramCanvas.drawPath(this.phV, this.paint);
        this.phV.reset();
        this.phV.moveTo(this.ycD[i].x, this.ycD[i].y);
        i += 1;
        break;
        caR();
        continue;
        caR();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void caP()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.phU = new Path();
    this.phV = new Path();
    this.ycD = new b[this.ycB];
    dFP();
    dFQ();
    this.hRv = new GestureDetector(getContext(), this.ycG);
    AppMethodBeat.o(103538);
  }
  
  private void caR()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.pgR);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void dFP()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.ycD.length)
    {
      this.ycD[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void dFQ()
  {
    int i = 0;
    if (i < this.ycB)
    {
      if (i == this.ycB - 1) {}
      for (this.ycD[i].ycM = true;; this.ycD[i].ycM = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private void n(Canvas paramCanvas)
  {
    AppMethodBeat.i(103534);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-1);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.ycD.length)
    {
      if (i == this.ycD.length - 1) {
        paramCanvas.drawCircle(this.ycD[i].x, this.ycD[i].y, this.pgP, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.ycD[i].x, this.ycD[i].y, this.pgN, this.paint);
      }
    }
    AppMethodBeat.o(103534);
  }
  
  private float o(int paramInt, float paramFloat)
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
  
  private void o(Canvas paramCanvas)
  {
    AppMethodBeat.i(103537);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setTextSize(o(2, 12.0F));
    this.paint.setAlpha(153);
    int i = 0;
    if (i < this.ycD.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.ycD[i].ycM) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.ycD[i].wdN, this.ycD[i].x, this.fIO - this.phr, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.pgG);
      }
    }
    AppMethodBeat.o(103537);
  }
  
  private void qB(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(103541);
    this.tcu = 2147483647;
    Object localObject1 = Calendar.getInstance();
    this.ycD = new b[this.ycB];
    dFP();
    int i;
    if ((this.ycC == null) || (this.ycC.size() <= 0))
    {
      this.ycy = true;
      ((Calendar)localObject1).add(5, -this.ycB);
      i = 0;
      while (i < this.ycD.length)
      {
        ((Calendar)localObject1).add(5, 1);
        this.ycD[i].timestamp = ((Calendar)localObject1).getTimeInMillis();
        this.ycD[i].jzV = 0;
        i += 1;
      }
      AppMethodBeat.o(103541);
      return;
    }
    this.ycy = false;
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.ycC);
    Collections.sort((List)localObject2);
    int m = ((List)localObject2).size();
    if ((paramBoolean) || (this.maxPageIndex == -1))
    {
      i = m / this.ycB;
      if (m % this.ycB == 0) {
        break label413;
      }
    }
    int j;
    label413:
    for (this.maxPageIndex = (i + 1);; this.maxPageIndex = i)
    {
      if (this.maxPageIndex > 4) {
        this.maxPageIndex = 4;
      }
      this.ycz = this.maxPageIndex;
      j = m - this.ycB * (this.maxPageIndex - this.ycz + 1);
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = m - this.ycB * (this.maxPageIndex - this.ycz);
      ad.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject2 = ((List)localObject2).subList(i, j);
      m = ((List)localObject2).size();
      j = k;
      if (m >= this.ycB) {
        break;
      }
      ((Calendar)localObject1).setTimeInMillis(((d)((List)localObject2).get(0)).field_timestamp);
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.ycB - m) {
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
    while (j < this.ycB)
    {
      localObject1 = (d)((List)localObject2).get(j);
      this.ycD[j].jzV = ((d)localObject1).field_step;
      this.ycD[j].timestamp = ((d)localObject1).field_timestamp;
      j += 1;
    }
    AppMethodBeat.o(103541);
  }
  
  public final void a(SportChartView.a parama)
  {
    AppMethodBeat.i(103529);
    this.ycA = parama;
    if (parama == SportChartView.a.ycJ) {}
    for (this.ycB = 7;; this.ycB = 30)
    {
      this.ycD = new b[this.ycB];
      dFP();
      AppMethodBeat.o(103529);
      return;
    }
  }
  
  public final void fQ(List<d> paramList)
  {
    AppMethodBeat.i(103535);
    this.ycC = paramList;
    qB(true);
    invalidate();
    AppMethodBeat.o(103535);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.fIN = getWidth();
    this.fIO = getHeight();
    this.phN = ((this.fIN - this.pgV - this.pgX) / (this.ycB - 1));
    this.phO = ((this.fIO - this.pgZ - this.phb) / 2);
    int i = 0;
    while (i < this.ycD.length)
    {
      this.ycD[i].x = (this.pgV + this.phN * i);
      i += 1;
    }
    i = this.ycD.length;
    int k = i;
    if (i > this.ycB) {
      k = this.ycB;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.ycD[i].jzV > 100000) {
        this.ycD[i].jzV = 100000;
      }
      if (this.ycD[i].jzV < 0) {
        this.ycD[i].jzV = 0;
      }
      int m = j;
      if (this.ycD[i].jzV > j) {
        m = this.ycD[i].jzV;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.phK = ((this.fIO - this.pgZ - this.phb) * 10000 / i);
      this.phK = (this.fIO - this.phb - this.phK);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.ycD[j].y = (this.fIO - this.phb - this.ycD[j].jzV / i * (this.fIO - this.pgZ - this.phb));
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
          this.ycD[i].wdN = this.ycw.format(new Date(this.ycD[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.ycA == SportChartView.a.ycK)
          {
            if (i % 6 == 5) {
              this.ycD[i].wdN = this.ycx.format(new Date(this.ycD[i].timestamp));
            } else {
              this.ycD[i].wdN = "";
            }
          }
          else {
            this.ycD[i].wdN = this.ycx.format(new Date(this.ycD[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.ycy)
      {
        n(paramCanvas);
        if (this.tcu != 2147483647)
        {
          i = this.tcu;
          if ((i >= 0) && (i <= this.ycB - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.pgG);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(o(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.ycB - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.pia)
            {
              this.phZ = ((int)this.ycD[i].y - this.phB);
              this.startY = this.phZ;
              this.pia = true;
            }
            if (this.pia)
            {
              f = (float)(this.startY / 8.0D);
              if (this.phZ > 0) {
                this.paint.setAlpha((this.startY - this.phZ) * 255 / this.startY);
              }
              paramCanvas.drawText(this.ycD[i].jzV, this.ycD[i].x, this.phZ + this.phB, this.paint);
              if (this.ycA == SportChartView.a.ycK)
              {
                this.paint.reset();
                this.phU.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.pgA);
                this.paint.setStrokeWidth(this.pgT);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.phU.moveTo(this.ycD[i].x, this.fIO - this.phh);
                this.phU.lineTo(this.ycD[i].x, this.phZ + this.phB + this.pgP);
                paramCanvas.drawPath(this.phU, this.paint);
              }
              if (this.phZ <= 0) {
                break label1844;
              }
              if (this.phZ / this.startY > 1.0F / f) {
                break label1817;
              }
              this.phZ -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.tcu;
          if ((i >= 0) && (i <= this.ycB - 1)) {
            this.ycD[i].ycM = true;
          }
        }
      }
      this.paint.reset();
      this.phU.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.pgA);
      this.paint.setStrokeWidth(this.pgT);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.phK != 0) && (!this.ycy))
      {
        this.phU.moveTo(this.pgV, this.phK);
        this.phU.lineTo(this.fIN - this.phd, this.phK);
        paramCanvas.drawPath(this.phU, this.paint);
      }
      this.paint.reset();
      this.phU.reset();
      this.paint.setColor(this.pgA);
      this.paint.setStrokeWidth(this.pgT);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.phU.reset();
      this.phU.moveTo(this.phl, this.fIO - this.phh);
      this.phU.lineTo(this.fIN - this.phn, this.fIO - this.phh);
      this.phU.moveTo(this.phl, this.phj);
      this.phU.lineTo(this.fIN - this.phn, this.phj);
      paramCanvas.drawPath(this.phU, this.paint);
      if (!this.ycy)
      {
        this.paint.reset();
        this.paint.setColor(this.pgI);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(o(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131764118), this.fIN - this.php, (float)(this.phK + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.ycF)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.phL);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(o(2, 28.0F));
        localObject = String.valueOf(this.ycE);
        paramCanvas.drawText((String)localObject, this.fIN - this.phz, this.phx, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(o(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131764121), this.fIN - this.phz - f, this.pht, this.paint);
      }
      for (;;)
      {
        if (this.ycD.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.fIO - this.phh, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          caR();
          if (!this.ycy) {
            c(paramCanvas, false);
          }
        }
        o(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.phZ = ((int)(this.phZ - f * (this.phZ / this.startY)));
        break;
        label1844:
        this.pia = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.phL);
        this.paint.setTextSize(o(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(2131764120), this.phv, this.pht, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(o(2, 28.0F));
        paramCanvas.drawText(this.ycE, this.fIN - this.phz, this.phx, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    this.hRv.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.ycF = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.ycE = paramInt;
  }
  
  final class b
  {
    int jzV;
    long timestamp;
    String wdN = "";
    float x;
    float y;
    boolean ycM;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */