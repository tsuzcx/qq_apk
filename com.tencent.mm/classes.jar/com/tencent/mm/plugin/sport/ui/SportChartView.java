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
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  private int jgD;
  private int jgE;
  private GestureDetector lOj;
  private final int lPM;
  private final int lPN;
  private final int lPO;
  private final float lPP;
  private final float lPQ;
  private final float lPR;
  private final float lPS;
  private final float lPT;
  private final int lPU;
  private final int lPV;
  private final int lPW;
  private final int lPX;
  private final float lQA;
  private final float lQB;
  private final int lQC;
  private final int lQD;
  private final int lQE;
  private final int lQF;
  private final float lQG;
  private final int lQH;
  private final float lQI;
  private final int lQJ;
  private final float lQK;
  private final int lQL;
  private final float lQM;
  private final int lQN;
  private final float lQO;
  private final int lQP;
  private final int lQQ;
  private final int lQR;
  private final int lQS;
  private final int lQT;
  private final int lQU;
  private final int lQV;
  private final int lQW;
  private final int lQX;
  private int lQY;
  private final Typeface lQZ;
  private final float lQa;
  private final int lQb;
  private final float lQc;
  private final int lQd;
  private final float lQe;
  private final int lQf;
  private final float lQg;
  private final int lQh;
  private final float lQi;
  private final int lQj;
  private final float lQk;
  private final int lQl;
  private final float lQm;
  private final int lQn;
  private final float lQo;
  private final int lQp;
  private final float lQq;
  private final int lQr;
  private final float lQs;
  private final int lQt;
  private final float lQu;
  private final int lQv;
  private final float lQw;
  private final int lQx;
  private final float lQy;
  private final float lQz;
  private final Typeface lRa;
  private int lRb;
  private int lRc;
  Path lRi;
  Path lRj;
  private int lRn;
  private boolean lRo;
  private int omD;
  Paint paint;
  private SimpleDateFormat sqh;
  private SimpleDateFormat sqi;
  private boolean sqj;
  private int sqk;
  private int sqm;
  private SportChartView.a sqn;
  private int sqo;
  private List<e> sqp;
  private SportChartView.b[] sqq;
  private int sqr;
  private boolean sqs;
  private GestureDetector.OnGestureListener sqt;
  private int startY;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65428);
    this.sqh = new SimpleDateFormat(getResources().getString(2131304087));
    this.sqi = new SimpleDateFormat("d");
    this.lPM = -1;
    this.lPN = -1;
    this.lPO = getResources().getColor(2131690517);
    this.lPP = 12.0F;
    this.lPQ = 24.0F;
    this.lPR = 28.0F;
    this.lPS = 12.0F;
    this.lPT = 12.0F;
    this.lPU = getResources().getColor(2131690518);
    this.lPV = -1;
    this.lPW = getResources().getColor(2131690518);
    this.lPX = -1;
    this.omD = 2147483647;
    this.jgD = 0;
    this.jgE = 0;
    this.lQa = 2.5F;
    this.lQb = ((int)l(1, 2.5F));
    this.lQc = 4.0F;
    this.lQd = ((int)l(1, 4.0F));
    this.lQe = 1.8F;
    this.lQf = ((int)l(1, 1.8F));
    this.lQg = 1.0F;
    this.lQh = ((int)l(1, 1.0F));
    this.lQi = 8.0F;
    this.lQj = ((int)l(1, 8.0F));
    this.lQk = 22.0F;
    this.lQl = ((int)l(1, 22.0F));
    this.lQm = 67.0F;
    this.lQn = ((int)l(1, 67.0F));
    this.lQo = 40.0F;
    this.lQp = ((int)l(1, 40.0F));
    this.lQq = 22.0F;
    this.lQr = ((int)l(1, 22.0F));
    this.lQs = 55.0F;
    this.lQt = ((int)l(1, 55.0F));
    this.lQu = 35.0F;
    this.lQv = ((int)l(1, 35.0F));
    this.lQw = 45.0F;
    this.lQx = ((int)l(1, 45.0F));
    this.lQy = 8.0F;
    this.lQz = ((int)l(1, 8.0F));
    this.lQA = 8.0F;
    this.lQB = ((int)l(1, 8.0F));
    this.lQC = 2;
    this.lQD = ((int)l(1, 2.0F));
    this.lQE = 15;
    this.lQF = ((int)l(1, 15.0F));
    this.lQG = 33.0F;
    this.lQH = ((int)l(1, 33.0F));
    this.lQI = 8.0F;
    this.lQJ = ((int)l(1, 8.0F));
    this.lQK = 35.0F;
    this.lQL = ((int)l(1, 35.0F));
    this.lQM = 10.0F;
    this.lQN = ((int)l(1, 10.0F));
    this.lQO = 58.0F;
    this.lQP = ((int)l(1, 58.0F));
    this.lQQ = ((int)l(1, 1.0F));
    this.lQR = 102;
    this.lQS = 102;
    this.lQT = 153;
    this.lQU = 102;
    this.lQV = 102;
    this.lQW = 102;
    this.lQX = 204;
    this.lQY = 0;
    this.lQZ = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.lRa = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.lRb = 0;
    this.lRc = 0;
    this.sqk = -1;
    this.sqm = -1;
    this.sqn = SportChartView.a.sqw;
    this.sqo = 7;
    this.sqq = new SportChartView.b[this.sqo];
    this.sqt = new SportChartView.1(this);
    brg();
    AppMethodBeat.o(65428);
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(65429);
    this.sqh = new SimpleDateFormat(getResources().getString(2131304087));
    this.sqi = new SimpleDateFormat("d");
    this.lPM = -1;
    this.lPN = -1;
    this.lPO = getResources().getColor(2131690517);
    this.lPP = 12.0F;
    this.lPQ = 24.0F;
    this.lPR = 28.0F;
    this.lPS = 12.0F;
    this.lPT = 12.0F;
    this.lPU = getResources().getColor(2131690518);
    this.lPV = -1;
    this.lPW = getResources().getColor(2131690518);
    this.lPX = -1;
    this.omD = 2147483647;
    this.jgD = 0;
    this.jgE = 0;
    this.lQa = 2.5F;
    this.lQb = ((int)l(1, 2.5F));
    this.lQc = 4.0F;
    this.lQd = ((int)l(1, 4.0F));
    this.lQe = 1.8F;
    this.lQf = ((int)l(1, 1.8F));
    this.lQg = 1.0F;
    this.lQh = ((int)l(1, 1.0F));
    this.lQi = 8.0F;
    this.lQj = ((int)l(1, 8.0F));
    this.lQk = 22.0F;
    this.lQl = ((int)l(1, 22.0F));
    this.lQm = 67.0F;
    this.lQn = ((int)l(1, 67.0F));
    this.lQo = 40.0F;
    this.lQp = ((int)l(1, 40.0F));
    this.lQq = 22.0F;
    this.lQr = ((int)l(1, 22.0F));
    this.lQs = 55.0F;
    this.lQt = ((int)l(1, 55.0F));
    this.lQu = 35.0F;
    this.lQv = ((int)l(1, 35.0F));
    this.lQw = 45.0F;
    this.lQx = ((int)l(1, 45.0F));
    this.lQy = 8.0F;
    this.lQz = ((int)l(1, 8.0F));
    this.lQA = 8.0F;
    this.lQB = ((int)l(1, 8.0F));
    this.lQC = 2;
    this.lQD = ((int)l(1, 2.0F));
    this.lQE = 15;
    this.lQF = ((int)l(1, 15.0F));
    this.lQG = 33.0F;
    this.lQH = ((int)l(1, 33.0F));
    this.lQI = 8.0F;
    this.lQJ = ((int)l(1, 8.0F));
    this.lQK = 35.0F;
    this.lQL = ((int)l(1, 35.0F));
    this.lQM = 10.0F;
    this.lQN = ((int)l(1, 10.0F));
    this.lQO = 58.0F;
    this.lQP = ((int)l(1, 58.0F));
    this.lQQ = ((int)l(1, 1.0F));
    this.lQR = 102;
    this.lQS = 102;
    this.lQT = 153;
    this.lQU = 102;
    this.lQV = 102;
    this.lQW = 102;
    this.lQX = 204;
    this.lQY = 0;
    this.lQZ = Typeface.create(Typeface.DEFAULT_BOLD, 0);
    this.lRa = Typeface.create(Typeface.DEFAULT_BOLD, 1);
    this.lRb = 0;
    this.lRc = 0;
    this.sqk = -1;
    this.sqm = -1;
    this.sqn = SportChartView.a.sqw;
    this.sqo = 7;
    this.sqq = new SportChartView.b[this.sqo];
    this.sqt = new SportChartView.1(this);
    brg();
    AppMethodBeat.o(65429);
  }
  
  private void brg()
  {
    AppMethodBeat.i(65435);
    this.paint = new Paint();
    this.lRi = new Path();
    this.lRj = new Path();
    this.sqq = new SportChartView.b[this.sqo];
    cze();
    czf();
    this.lOj = new GestureDetector(getContext(), this.sqt);
    AppMethodBeat.o(65435);
  }
  
  private void bri()
  {
    AppMethodBeat.i(65436);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(this.lQf);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setColor(-1);
    AppMethodBeat.o(65436);
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(65430);
    if (paramBoolean)
    {
      this.lRj.reset();
      this.lRj.moveTo(this.sqq[0].x, this.sqq[0].y);
      i = 0;
      while (i < this.sqq.length)
      {
        this.lRj.lineTo(this.sqq[i].x, this.sqq[i].y);
        i += 1;
      }
      this.lRj.lineTo(this.sqq[(this.sqq.length - 1)].x, this.jgE - this.lQv - 1);
      this.lRj.lineTo(this.lQj, this.jgE - this.lQv - 1);
      this.lRj.lineTo(this.lQj, this.sqq[0].y);
      paramCanvas.drawPath(this.lRj, this.paint);
      AppMethodBeat.o(65430);
      return;
    }
    this.lRj.reset();
    this.lRj.moveTo(this.sqq[0].x, this.sqq[0].y);
    if (i < this.sqq.length)
    {
      if (i > 0) {
        if (this.sqq[(i - 1)].y == this.jgE - this.lQp)
        {
          this.paint.reset();
          DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
          this.paint.setPathEffect(localDashPathEffect);
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(this.lQf);
          this.paint.setStyle(Paint.Style.STROKE);
          this.paint.setColor(-1);
        }
      }
      for (;;)
      {
        this.lRj.lineTo(this.sqq[i].x, this.sqq[i].y);
        paramCanvas.drawPath(this.lRj, this.paint);
        this.lRj.reset();
        this.lRj.moveTo(this.sqq[i].x, this.sqq[i].y);
        i += 1;
        break;
        bri();
        continue;
        bri();
      }
    }
    AppMethodBeat.o(65430);
  }
  
  private void cze()
  {
    AppMethodBeat.i(65427);
    int i = 0;
    while (i < this.sqq.length)
    {
      this.sqq[i] = new SportChartView.b(this, 0);
      i += 1;
    }
    AppMethodBeat.o(65427);
  }
  
  private void czf()
  {
    int i = 0;
    if (i < this.sqo)
    {
      if (i == this.sqo - 1) {}
      for (this.sqq[i].sqz = true;; this.sqq[i].sqz = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private void k(Canvas paramCanvas)
  {
    AppMethodBeat.i(65431);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setColor(-1);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.sqq.length)
    {
      if (i == this.sqq.length - 1) {
        paramCanvas.drawCircle(this.sqq[i].x, this.sqq[i].y, this.lQd, this.paint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.sqq[i].x, this.sqq[i].y, this.lQb, this.paint);
      }
    }
    AppMethodBeat.o(65431);
  }
  
  private float l(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(65433);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      AppMethodBeat.o(65433);
      return paramFloat;
    }
  }
  
  private void l(Canvas paramCanvas)
  {
    AppMethodBeat.i(65434);
    this.paint.reset();
    this.paint.setAntiAlias(true);
    this.paint.setStrokeWidth(0.0F);
    this.paint.setTextSize(l(2, 12.0F));
    this.paint.setAlpha(153);
    int i = 0;
    if (i < this.sqq.length)
    {
      if (i == 0)
      {
        this.paint.setTextAlign(Paint.Align.LEFT);
        label78:
        if (!this.sqq[i].sqz) {
          break label154;
        }
        this.paint.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.sqq[i].qFq, this.sqq[i].x, this.jgE - this.lQF, this.paint);
        i += 1;
        break;
        this.paint.setTextAlign(Paint.Align.CENTER);
        break label78;
        label154:
        this.paint.setColor(this.lPU);
      }
    }
    AppMethodBeat.o(65434);
  }
  
  private void lM(boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(65438);
    this.omD = 2147483647;
    Object localObject1 = Calendar.getInstance();
    this.sqq = new SportChartView.b[this.sqo];
    cze();
    int i;
    if ((this.sqp == null) || (this.sqp.size() <= 0))
    {
      this.sqj = true;
      ((Calendar)localObject1).add(5, -this.sqo);
      i = 0;
      while (i < this.sqq.length)
      {
        ((Calendar)localObject1).add(5, 1);
        this.sqq[i].timestamp = ((Calendar)localObject1).getTimeInMillis();
        this.sqq[i].hAu = 0;
        i += 1;
      }
      AppMethodBeat.o(65438);
      return;
    }
    this.sqj = false;
    Object localObject2 = new ArrayList();
    ((List)localObject2).addAll(this.sqp);
    Collections.sort((List)localObject2);
    int m = ((List)localObject2).size();
    if ((paramBoolean) || (this.sqm == -1))
    {
      i = m / this.sqo;
      if (m % this.sqo == 0) {
        break label413;
      }
    }
    int j;
    label413:
    for (this.sqm = (i + 1);; this.sqm = i)
    {
      if (this.sqm > 4) {
        this.sqm = 4;
      }
      this.sqk = this.sqm;
      j = m - this.sqo * (this.sqm - this.sqk + 1);
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = m - this.sqo * (this.sqm - this.sqk);
      ab.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject2 = ((List)localObject2).subList(i, j);
      m = ((List)localObject2).size();
      j = k;
      if (m >= this.sqo) {
        break;
      }
      ((Calendar)localObject1).setTimeInMillis(((e)((List)localObject2).get(0)).field_timestamp);
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= this.sqo - m) {
          break;
        }
        ((Calendar)localObject1).add(5, -1);
        e locale = new e();
        locale.field_timestamp = ((Calendar)localObject1).getTimeInMillis();
        locale.field_step = 0;
        ((List)localObject2).add(0, locale);
        i += 1;
      }
    }
    while (j < this.sqo)
    {
      localObject1 = (e)((List)localObject2).get(j);
      this.sqq[j].hAu = ((e)localObject1).field_step;
      this.sqq[j].timestamp = ((e)localObject1).field_timestamp;
      j += 1;
    }
    AppMethodBeat.o(65438);
  }
  
  public final void a(SportChartView.a parama)
  {
    AppMethodBeat.i(65426);
    this.sqn = parama;
    if (parama == SportChartView.a.sqw) {}
    for (this.sqo = 7;; this.sqo = 30)
    {
      this.sqq = new SportChartView.b[this.sqo];
      cze();
      AppMethodBeat.o(65426);
      return;
    }
  }
  
  public final void dz(List<e> paramList)
  {
    AppMethodBeat.i(65432);
    this.sqp = paramList;
    lM(true);
    invalidate();
    AppMethodBeat.o(65432);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(65437);
    this.jgD = getWidth();
    this.jgE = getHeight();
    this.lRb = ((this.jgD - this.lQj - this.lQl) / (this.sqo - 1));
    this.lRc = ((this.jgE - this.lQn - this.lQp) / 2);
    int i = 0;
    while (i < this.sqq.length)
    {
      this.sqq[i].x = (this.lQj + this.lRb * i);
      i += 1;
    }
    i = this.sqq.length;
    int k = i;
    if (i > this.sqo) {
      k = this.sqo;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.sqq[i].hAu > 100000) {
        this.sqq[i].hAu = 100000;
      }
      if (this.sqq[i].hAu < 0) {
        this.sqq[i].hAu = 0;
      }
      int m = j;
      if (this.sqq[i].hAu > j) {
        m = this.sqq[i].hAu;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.lQY = ((this.jgE - this.lQn - this.lQp) * 10000 / i);
      this.lQY = (this.jgE - this.lQp - this.lQY);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.sqq[j].y = (this.jgE - this.lQp - this.sqq[j].hAu / i * (this.jgE - this.lQn - this.lQp));
          j += 1;
          continue;
          if ((j <= 15000) || (j > 100000)) {
            break label2004;
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
          this.sqq[i].qFq = this.sqh.format(new Date(this.sqq[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.sqn == SportChartView.a.sqx)
          {
            if (i % 6 == 5) {
              this.sqq[i].qFq = this.sqi.format(new Date(this.sqq[i].timestamp));
            } else {
              this.sqq[i].qFq = "";
            }
          }
          else {
            this.sqq[i].qFq = this.sqi.format(new Date(this.sqq[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.sqj)
      {
        k(paramCanvas);
        if (this.omD != 2147483647)
        {
          i = this.omD;
          if ((i >= 0) && (i <= this.sqo - 1))
          {
            this.paint.reset();
            this.paint.setColor(this.lPU);
            this.paint.setAntiAlias(true);
            this.paint.setStrokeWidth(0.0F);
            this.paint.setTextSize(l(2, 12.0F));
            this.paint.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.paint.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.sqo - 1) {
              this.paint.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.lRo)
            {
              this.lRn = ((int)this.sqq[i].y - this.lQP);
              this.startY = this.lRn;
              this.lRo = true;
            }
            if (this.lRo)
            {
              f = (float)(this.startY / 8.0D);
              if (this.lRn > 0) {
                this.paint.setAlpha((this.startY - this.lRn) * 255 / this.startY);
              }
              paramCanvas.drawText(this.sqq[i].hAu, this.sqq[i].x, this.lRn + this.lQP, this.paint);
              if (this.sqn == SportChartView.a.sqx)
              {
                this.paint.reset();
                this.lRi.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.paint.setPathEffect((PathEffect)localObject);
                this.paint.setColor(this.lPO);
                this.paint.setStrokeWidth(this.lQh);
                this.paint.setStyle(Paint.Style.STROKE);
                this.paint.setAlpha(102);
                this.lRi.moveTo(this.sqq[i].x, this.jgE - this.lQv);
                this.lRi.lineTo(this.sqq[i].x, this.lRn + this.lQP + this.lQd);
                paramCanvas.drawPath(this.lRi, this.paint);
              }
              if (this.lRn <= 0) {
                break label1844;
              }
              if (this.lRn / this.startY > 1.0F / f) {
                break label1817;
              }
              this.lRn -= 1;
              invalidate();
            }
          }
          label1050:
          i = this.omD;
          if ((i >= 0) && (i <= this.sqo - 1)) {
            this.sqq[i].sqz = true;
          }
        }
      }
      this.paint.reset();
      this.lRi.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.paint.setPathEffect((PathEffect)localObject);
      this.paint.setColor(this.lPO);
      this.paint.setStrokeWidth(this.lQh);
      this.paint.setAlpha(102);
      this.paint.setStyle(Paint.Style.STROKE);
      if ((this.lQY != 0) && (!this.sqj))
      {
        this.lRi.moveTo(this.lQj, this.lQY);
        this.lRi.lineTo(this.jgD - this.lQr, this.lQY);
        paramCanvas.drawPath(this.lRi, this.paint);
      }
      this.paint.reset();
      this.lRi.reset();
      this.paint.setColor(this.lPO);
      this.paint.setStrokeWidth(this.lQh);
      this.paint.setStyle(Paint.Style.STROKE);
      this.paint.setAlpha(102);
      this.lRi.reset();
      this.lRi.moveTo(this.lQz, this.jgE - this.lQv);
      this.lRi.lineTo(this.jgD - this.lQB, this.jgE - this.lQv);
      this.lRi.moveTo(this.lQz, this.lQx);
      this.lRi.lineTo(this.jgD - this.lQB, this.lQx);
      paramCanvas.drawPath(this.lRi, this.paint);
      if (!this.sqj)
      {
        this.paint.reset();
        this.paint.setColor(this.lPW);
        this.paint.setAntiAlias(true);
        this.paint.setAlpha(102);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTextSize(l(2, 12.0F));
        this.paint.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(2131304086), this.jgD - this.lQD, (float)(this.lQY + this.paint.getTextSize() * 0.34D), this.paint);
      }
      if (this.sqs)
      {
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.lQZ);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(l(2, 28.0F));
        localObject = String.valueOf(this.sqr);
        paramCanvas.drawText((String)localObject, this.jgD - this.lQN, this.lQL, this.paint);
        f = this.paint.measureText((String)localObject);
        this.paint.setTextSize(l(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131304089), this.jgD - this.lQN - f, this.lQH, this.paint);
      }
      for (;;)
      {
        if (this.sqq.length > 2)
        {
          this.paint.reset();
          this.paint.setAntiAlias(true);
          this.paint.setStrokeWidth(0.0F);
          this.paint.setAlpha(102);
          this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.jgE - this.lQv, -1, 16777215, Shader.TileMode.REPEAT);
          this.paint.setShader((Shader)localObject);
          this.paint.setColor(-1);
          c(paramCanvas, true);
          bri();
          if (!this.sqj) {
            c(paramCanvas, false);
          }
        }
        l(paramCanvas);
        AppMethodBeat.o(65437);
        return;
        label1817:
        this.lRn = ((int)(this.lRn - f * (this.lRn / this.startY)));
        break;
        label1844:
        this.lRo = false;
        break label1050;
        this.paint.reset();
        this.paint.setColor(-1);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(0.0F);
        this.paint.setTypeface(this.lQZ);
        this.paint.setTextSize(l(2, 24.0F));
        paramCanvas.drawText(getResources().getString(2131304088), this.lQJ, this.lQH, this.paint);
        this.paint.setTextAlign(Paint.Align.RIGHT);
        this.paint.setTextSize(l(2, 28.0F));
        paramCanvas.drawText(this.sqr, this.jgD - this.lQN, this.lQL, this.paint);
      }
      label2004:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65439);
    this.lOj.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(65439);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.sqs = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.sqr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */