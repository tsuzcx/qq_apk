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
import com.tencent.mm.sdk.platformtools.ac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  private int fMt;
  private int fMu;
  private GestureDetector irA;
  private final int pJI;
  private final int pJJ;
  private final int pJK;
  private final float pJL;
  private final float pJM;
  private final float pJN;
  private final float pJO;
  private final float pJP;
  private final int pJQ;
  private final int pJR;
  private final int pJS;
  private final int pJT;
  private final float pJW;
  private final int pJX;
  private final float pJY;
  private final int pJZ;
  private final int pKA;
  private final int pKB;
  private final float pKC;
  private final int pKD;
  private final float pKE;
  private final int pKF;
  private final float pKG;
  private final int pKH;
  private final float pKI;
  private final int pKJ;
  private final float pKK;
  private final int pKL;
  private final int pKM;
  private final int pKN;
  private final int pKO;
  private final int pKP;
  private final int pKQ;
  private final int pKR;
  private final int pKS;
  private final int pKT;
  private int pKU;
  private final Typeface pKV;
  private final Typeface pKW;
  private int pKX;
  private int pKY;
  private final float pKa;
  private final int pKb;
  private final float pKc;
  private final int pKd;
  private final float pKe;
  private final int pKf;
  private final float pKg;
  private final int pKh;
  private final float pKi;
  private final int pKj;
  private final float pKk;
  private final int pKl;
  private final float pKm;
  private final int pKn;
  private final float pKo;
  private final int pKp;
  private final float pKq;
  private final int pKr;
  private final float pKs;
  private final int pKt;
  private final float pKu;
  private final float pKv;
  private final float pKw;
  private final float pKx;
  private final int pKy;
  private final int pKz;
  Path pLe;
  Path pLf;
  private int pLj;
  private boolean pLk;
  Paint paint;
  private int rxK;
  private int startY;
  private int ukJ;
  private SportChartView.a zpA;
  private int zpB;
  private List<d> zpC;
  private b[] zpD;
  private int zpE;
  private boolean zpF;
  private GestureDetector.OnGestureListener zpG;
  private SimpleDateFormat zpw;
  private SimpleDateFormat zpx;
  private boolean zpy;
  private int zpz;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103531);
    this.zpw = new SimpleDateFormat(getResources().getString(2131764119));
    this.zpx = new SimpleDateFormat("d");
    this.pJI = -1;
    this.pJJ = -1;
    this.pJK = getResources().getColor(2131100945);
    this.pJL = 12.0F;
    this.pJM = 24.0F;
    this.pJN = 28.0F;
    this.pJO = 12.0F;
    this.pJP = 12.0F;
    this.pJQ = getResources().getColor(2131100946);
    this.pJR = -1;
    this.pJS = getResources().getColor(2131100946);
    this.pJT = -1;
    this.ukJ = 2147483647;
    this.fMt = 0;
    this.fMu = 0;
    this.pJW = 2.5F;
    this.pJX = ((int)o(1, 2.5F));
    this.pJY = 4.0F;
    this.pJZ = ((int)o(1, 4.0F));
    this.pKa = 1.8F;
    this.pKb = ((int)o(1, 1.8F));
    this.pKc = 1.0F;
    this.pKd = ((int)o(1, 1.0F));
    this.pKe = 8.0F;
    this.pKf = ((int)o(1, 8.0F));
    this.pKg = 22.0F;
    this.pKh = ((int)o(1, 22.0F));
    this.pKi = 67.0F;
    this.pKj = ((int)o(1, 67.0F));
    this.pKk = 40.0F;
    this.pKl = ((int)o(1, 40.0F));
    this.pKm = 22.0F;
    this.pKn = ((int)o(1, 22.0F));
    this.pKo = 55.0F;
    this.pKp = ((int)o(1, 55.0F));
    this.pKq = 35.0F;
    this.pKr = ((int)o(1, 35.0F));
    this.pKs = 45.0F;
    this.pKt = ((int)o(1, 45.0F));
    this.pKu = 8.0F;
    this.pKv = ((int)o(1, 8.0F));
    this.pKw = 8.0F;
    this.pKx = ((int)o(1, 8.0F));
    this.pKy = 2;
    this.pKz = ((int)o(1, 2.0F));
    this.pKA = 15;
    this.pKB = ((int)o(1, 15.0F));
    this.pKC = 33.0F;
    this.pKD = ((int)o(1, 33.0F));
    this.pKE = 8.0F;
    this.pKF = ((int)o(1, 8.0F));
    this.pKG = 35.0F;
    this.pKH = ((int)o(1, 35.0F));
    this.pKI = 10.0F;
    this.pKJ = ((int)o(1, 10.0F));
    this.pKK = 58.0F;
    this.pKL = ((int)o(1, 58.0F));
    this.pKM = ((int)o(1, 1.0F));
    this.pKN = 102;
    this.pKO = 102;
    this.pKP = 153;
    this.pKQ = 102;
    this.pKR = 102;
    this.pKS = 102;
    this.pKT = 204;
    this.pKU = 0;
    this.pKV = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.pKW = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.pKX = 0;
    this.pKY = 0;
    this.zpz = -1;
    this.rxK = -1;
    this.zpA = SportChartView.a.zpJ;
    this.zpB = 7;
    this.zpD = new b[this.zpB];
    this.zpG = new GestureDetector.SimpleOnGestureListener()
    {
      private long zpH;
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ac.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.zpH < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.zpH = System.currentTimeMillis();
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
        ac.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        AppMethodBeat.o(103524);
        return true;
      }
    };
    chY();
    AppMethodBeat.o(103531);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103532);
    this.zpw = new SimpleDateFormat(getResources().getString(2131764119));
    this.zpx = new SimpleDateFormat("d");
    this.pJI = -1;
    this.pJJ = -1;
    this.pJK = getResources().getColor(2131100945);
    this.pJL = 12.0F;
    this.pJM = 24.0F;
    this.pJN = 28.0F;
    this.pJO = 12.0F;
    this.pJP = 12.0F;
    this.pJQ = getResources().getColor(2131100946);
    this.pJR = -1;
    this.pJS = getResources().getColor(2131100946);
    this.pJT = -1;
    this.ukJ = 2147483647;
    this.fMt = 0;
    this.fMu = 0;
    this.pJW = 2.5F;
    this.pJX = ((int)o(1, 2.5F));
    this.pJY = 4.0F;
    this.pJZ = ((int)o(1, 4.0F));
    this.pKa = 1.8F;
    this.pKb = ((int)o(1, 1.8F));
    this.pKc = 1.0F;
    this.pKd = ((int)o(1, 1.0F));
    this.pKe = 8.0F;
    this.pKf = ((int)o(1, 8.0F));
    this.pKg = 22.0F;
    this.pKh = ((int)o(1, 22.0F));
    this.pKi = 67.0F;
    this.pKj = ((int)o(1, 67.0F));
    this.pKk = 40.0F;
    this.pKl = ((int)o(1, 40.0F));
    this.pKm = 22.0F;
    this.pKn = ((int)o(1, 22.0F));
    this.pKo = 55.0F;
    this.pKp = ((int)o(1, 55.0F));
    this.pKq = 35.0F;
    this.pKr = ((int)o(1, 35.0F));
    this.pKs = 45.0F;
    this.pKt = ((int)o(1, 45.0F));
    this.pKu = 8.0F;
    this.pKv = ((int)o(1, 8.0F));
    this.pKw = 8.0F;
    this.pKx = ((int)o(1, 8.0F));
    this.pKy = 2;
    this.pKz = ((int)o(1, 2.0F));
    this.pKA = 15;
    this.pKB = ((int)o(1, 15.0F));
    this.pKC = 33.0F;
    this.pKD = ((int)o(1, 33.0F));
    this.pKE = 8.0F;
    this.pKF = ((int)o(1, 8.0F));
    this.pKG = 35.0F;
    this.pKH = ((int)o(1, 35.0F));
    this.pKI = 10.0F;
    this.pKJ = ((int)o(1, 10.0F));
    this.pKK = 58.0F;
    this.pKL = ((int)o(1, 58.0F));
    this.pKM = ((int)o(1, 1.0F));
    this.pKN = 102;
    this.pKO = 102;
    this.pKP = 153;
    this.pKQ = 102;
    this.pKR = 102;
    this.pKS = 102;
    this.pKT = 204;
    this.pKU = 0;
    this.pKV = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.pKW = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.pKX = 0;
    this.pKY = 0;
    this.zpz = -1;
    this.rxK = -1;
    this.zpA = SportChartView.a.zpJ;
    this.zpB = 7;
    this.zpD = new b[this.zpB];
    this.zpG = new GestureDetector.SimpleOnGestureListener()
    {
      private long zpH;
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(103525);
        ac.i("MicroMsg.Sport.SportChartView", "onScroll %.2f", new Object[] { Float.valueOf(paramAnonymousFloat1) });
        if ((System.currentTimeMillis() - this.zpH < 500L) || (!SportChartView.d(SportChartView.this)))
        {
          AppMethodBeat.o(103525);
          return false;
        }
        this.zpH = System.currentTimeMillis();
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
        ac.i("MicroMsg.Sport.SportChartView", "onSingleTapUp %s %s %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(SportChartView.c(SportChartView.this)) });
        SportChartView.this.invalidate();
        AppMethodBeat.o(103524);
        return true;
      }
    };
    chY();
    AppMethodBeat.o(103532);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(103533);
    if (paramBoolean)
    {
      this.pLf.reset();
      this.pLf.moveTo(this.zpD[0].x, this.zpD[0].y);
      i = 0;
      while (i < this.zpD.length)
      {
        this.pLf.lineTo(this.zpD[i].x, this.zpD[i].y);
        i += 1;
      }
      this.pLf.lineTo(this.zpD[(this.zpD.length - 1)].x, this.fMu - this.pKr - 1);
      this.pLf.lineTo(this.pKf, this.fMu - this.pKr - 1);
      this.pLf.lineTo(this.pKf, this.zpD[0].y);
      paramCanvas.drawPath(this.pLf, this.paint);
      AppMethodBeat.o(103533);
      return;
    }
    this.pLf.reset();
    this.pLf.moveTo(this.zpD[0].x, this.zpD[0].y);
    if (i < this.zpD.length)
    {
      if (i > 0) {
        if (this.zpD[(i - 1)].y == this.fMu - this.pKl)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.pKb);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.pLf.lineTo(this.zpD[i].x, this.zpD[i].y);
        paramCanvas.drawPath(this.pLf, this.paint);
        this.pLf.reset();
        this.pLf.moveTo(this.zpD[i].x, this.zpD[i].y);
        i += 1;
        break;
        cia();
        continue;
        cia();
      }
    }
    AppMethodBeat.o(103533);
  }
  
  private void chY()
  {
    AppMethodBeat.i(103538);
    this.paint = new Paint();
    this.pLe = new Path();
    this.pLf = new Path();
    this.zpD = new b[this.zpB];
    dUq();
    dUr();
    this.irA = new GestureDetector(getContext(), this.zpG);
    AppMethodBeat.o(103538);
  }
  
  private void cia()
  {
    AppMethodBeat.i(103539);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.pKb);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(103539);
  }
  
  private void dUq()
  {
    AppMethodBeat.i(103530);
    int i = 0;
    while (i < this.zpD.length)
    {
      this.zpD[i] = new b(0);
      i += 1;
    }
    AppMethodBeat.o(103530);
  }
  
  private void dUr()
  {
    int i = 0;
    if (i < this.zpB)
    {
      if (i == this.zpB - 1) {}
      for (this.zpD[i].zpM = true;; this.zpD[i].zpM = false)
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
    if (i < this.zpD.length)
    {
      if (i == this.zpD.length - 1) {
        paramCanvas.drawCircle(this.zpD[i].x, this.zpD[i].y, this.pJZ, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.zpD[i].x, this.zpD[i].y, this.pJX, this.paint);
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
    if (i < this.zpD.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.zpD[i].zpM) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.zpD[i].xpb, this.zpD[i].x, this.fMu - this.pKB, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.pJQ);
      }
    }
    AppMethodBeat.o(103537);
  }
  
  private void rz(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(103541);
    this.ukJ = 2147483647;
    Object localObject1 = Calendar.getInstance();
    this.zpD = new b[this.zpB];
    dUq();
    int i;
    if ((this.zpC == null) || (this.zpC.size() <= 0))
    {
      this.zpy = true;
      ((Calendar)localObject1).add(5, -this.zpB);
      i = 0;
      while (i < this.zpD.length)
      {
        ((Calendar)localObject1).add(5, 1);
        this.zpD[i].timestamp = ((Calendar)localObject1).getTimeInMillis();
        this.zpD[i].kar = 0;
        i += 1;
      }
      AppMethodBeat.o(103541);
      return;
    }
    this.zpy = false;
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.zpC);
    Collections.sort((List)localObject2);
    int m = ((List)localObject2).size();
    if ((paramBoolean) || (this.rxK == -1))
    {
      i = m / this.zpB;
      if (m % this.zpB == 0) {
        break label413;
      }
    }
    int j;
    label413:
    for (this.rxK = (i + 1);; this.rxK = i)
    {
      if (this.rxK > 4) {
        this.rxK = 4;
      }
      this.zpz = this.rxK;
      j = m - this.zpB * (this.rxK - this.zpz + 1);
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = m - this.zpB * (this.rxK - this.zpz);
      ac.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject2 = ((List)localObject2).subList(i, j);
      m = ((List)localObject2).size();
      j = k;
      if (m >= this.zpB) {
        break;
      }
      ((Calendar)localObject1).setTimeInMillis(((d)((List)localObject2).get(0)).field_timestamp);
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.zpB - m) {
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
    while (j < this.zpB)
    {
      localObject1 = (d)((List)localObject2).get(j);
      this.zpD[j].kar = ((d)localObject1).field_step;
      this.zpD[j].timestamp = ((d)localObject1).field_timestamp;
      j += 1;
    }
    AppMethodBeat.o(103541);
  }
  
  public final void a(SportChartView.a parama)
  {
    AppMethodBeat.i(103529);
    this.zpA = parama;
    if (parama == SportChartView.a.zpJ) {}
    for (this.zpB = 7;; this.zpB = 30)
    {
      this.zpD = new b[this.zpB];
      dUq();
      AppMethodBeat.o(103529);
      return;
    }
  }
  
  public final void fY(List<d> paramList)
  {
    AppMethodBeat.i(103535);
    this.zpC = paramList;
    rz(true);
    invalidate();
    AppMethodBeat.o(103535);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(103540);
    this.fMt = getWidth();
    this.fMu = getHeight();
    this.pKX = ((this.fMt - this.pKf - this.pKh) / (this.zpB - 1));
    this.pKY = ((this.fMu - this.pKj - this.pKl) / 2);
    int i = 0;
    while (i < this.zpD.length)
    {
      this.zpD[i].x = (this.pKf + this.pKX * i);
      i += 1;
    }
    i = this.zpD.length;
    int k = i;
    if (i > this.zpB) {
      k = this.zpB;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.zpD[i].kar > 100000) {
        this.zpD[i].kar = 100000;
      }
      if (this.zpD[i].kar < 0) {
        this.zpD[i].kar = 0;
      }
      int m = j;
      if (this.zpD[i].kar > j) {
        m = this.zpD[i].kar;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.pKU = ((this.fMu - this.pKj - this.pKl) * 10000 / i);
      this.pKU = (this.fMu - this.pKl - this.pKU);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.zpD[j].y = (this.fMu - this.pKl - this.zpD[j].kar / i * (this.fMu - this.pKj - this.pKl));
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
          this.zpD[i].xpb = this.zpw.format(new Date(this.zpD[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.zpA == SportChartView.a.zpK)
          {
            if (i % 6 == 5) {
              this.zpD[i].xpb = this.zpx.format(new Date(this.zpD[i].timestamp));
            } else {
              this.zpD[i].xpb = "";
            }
          }
          else {
            this.zpD[i].xpb = this.zpx.format(new Date(this.zpD[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.zpy)
      {
        n(paramCanvas);
        if (this.ukJ != 2147483647)
        {
          i = this.ukJ;
          if ((i >= 0) && (i <= this.zpB - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.pJQ);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(o(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.zpB - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.pLk)
            {
              this.pLj = ((int)this.zpD[i].y - this.pKL);
              this.startY = this.pLj;
              this.pLk = true;
            }
            if (this.pLk)
            {
              f = (float)(this.startY / 8.0D);
              if (this.pLj > 0) {
                this.paint.setAlpha((this.startY - this.pLj) * 255 / this.startY);
              }
              paramCanvas.drawText(this.zpD[i].kar, this.zpD[i].x, this.pLj + this.pKL, this.paint);
              if (this.zpA == SportChartView.a.zpK)
              {
                this.paint.reset();
                this.pLe.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.pJK);
                this.paint.setStrokeWidth(this.pKd);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.pLe.moveTo(this.zpD[i].x, this.fMu - this.pKr);
                this.pLe.lineTo(this.zpD[i].x, this.pLj + this.pKL + this.pJZ);
                paramCanvas.drawPath(this.pLe, this.paint);
              }
              if (this.pLj <= 0) {
                break label1844;
              }
              if (this.pLj / this.startY > 1.0F / f) {
                break label1817;
              }
              this.pLj -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.ukJ;
          if ((i >= 0) && (i <= this.zpB - 1)) {
            this.zpD[i].zpM = true;
          }
        }
      }
      this.paint.reset();
      this.pLe.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.pJK);
      this.paint.setStrokeWidth(this.pKd);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.pKU != 0) && (!this.zpy))
      {
        this.pLe.moveTo(this.pKf, this.pKU);
        this.pLe.lineTo(this.fMt - this.pKn, this.pKU);
        paramCanvas.drawPath(this.pLe, this.paint);
      }
      this.paint.reset();
      this.pLe.reset();
      this.paint.setColor(this.pJK);
      this.paint.setStrokeWidth(this.pKd);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.pLe.reset();
      this.pLe.moveTo(this.pKv, this.fMu - this.pKr);
      this.pLe.lineTo(this.fMt - this.pKx, this.fMu - this.pKr);
      this.pLe.moveTo(this.pKv, this.pKt);
      this.pLe.lineTo(this.fMt - this.pKx, this.pKt);
      paramCanvas.drawPath(this.pLe, this.paint);
      if (!this.zpy)
      {
        this.paint.reset();
        this.paint.setColor(this.pJS);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(o(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131764118), this.fMt - this.pKz, (float)(this.pKU + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.zpF)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.pKV);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(o(2, 28.0F));
        localObject = String.valueOf(this.zpE);
        paramCanvas.drawText((String)localObject, this.fMt - this.pKJ, this.pKH, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(o(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131764121), this.fMt - this.pKJ - f, this.pKD, this.paint);
      }
      for (;;)
      {
        if (this.zpD.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.fMu - this.pKr, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          cia();
          if (!this.zpy) {
            c(paramCanvas, false);
          }
        }
        o(paramCanvas);
        AppMethodBeat.o(103540);
        return;
        label1817:
        this.pLj = ((int)(this.pLj - f * (this.pLj / this.startY)));
        break;
        label1844:
        this.pLk = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.pKV);
        this.paint.setTextSize(o(2, 24.0F));
        this.paint.setTextAlign(Paint.Align.LEFT);
        paramCanvas.drawText(getResources().getString(2131764120), this.pKF, this.pKD, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(o(2, 28.0F));
        paramCanvas.drawText(this.zpE, this.fMt - this.pKJ, this.pKH, this.paint);
      }
      label2014:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(103542);
    this.irA.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(103542);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.zpF = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.zpE = paramInt;
  }
  
  final class b
  {
    int kar;
    long timestamp;
    float x;
    String xpb = "";
    float y;
    boolean zpM;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */