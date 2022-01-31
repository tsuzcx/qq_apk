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
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SportChartView
  extends View
{
  Paint gaZ;
  private GestureDetector jEK;
  private final float jGC = 2.5F;
  private final int jGD = (int)j(1, 2.5F);
  private final float jGE = 4.0F;
  private final int jGF = (int)j(1, 4.0F);
  private final float jGG = 1.8F;
  private final int jGH = (int)j(1, 1.8F);
  private final float jGI = 1.0F;
  private final int jGJ = (int)j(1, 1.0F);
  private final float jGK = 8.0F;
  private final int jGL = (int)j(1, 8.0F);
  private final float jGM = 22.0F;
  private final int jGN = (int)j(1, 22.0F);
  private final float jGO = 67.0F;
  private final int jGP = (int)j(1, 67.0F);
  private final float jGQ = 40.0F;
  private final int jGR = (int)j(1, 40.0F);
  private final float jGS = 22.0F;
  private final int jGT = (int)j(1, 22.0F);
  private final float jGU = 55.0F;
  private final int jGV = (int)j(1, 55.0F);
  private final float jGW = 35.0F;
  private final int jGX = (int)j(1, 35.0F);
  private final float jGY = 45.0F;
  private final int jGZ = (int)j(1, 45.0F);
  private final int jGo = -1;
  private final int jGp = -1;
  private final int jGq = getResources().getColor(a.a.sport_step_chart_background_line_color);
  private final float jGr = 12.0F;
  private final float jGs = 24.0F;
  private final float jGt = 28.0F;
  private final float jGu = 12.0F;
  private final float jGv = 12.0F;
  private final int jGw = getResources().getColor(a.a.sport_step_chart_date_text_color);
  private final int jGx = -1;
  private final int jGy = getResources().getColor(a.a.sport_step_chart_date_text_color);
  private final int jGz = -1;
  private int jHA = 0;
  private final Typeface jHB = Typeface.create(Typeface.DEFAULT_BOLD, 0);
  private final Typeface jHC = Typeface.create(Typeface.DEFAULT_BOLD, 1);
  private int jHD = 0;
  private int jHE = 0;
  Path jHK;
  Path jHL;
  private int jHP;
  private boolean jHQ;
  private final float jHa = 8.0F;
  private final float jHb = (int)j(1, 8.0F);
  private final float jHc = 8.0F;
  private final float jHd = (int)j(1, 8.0F);
  private final int jHe = 2;
  private final int jHf = (int)j(1, 2.0F);
  private final int jHg = 15;
  private final int jHh = (int)j(1, 15.0F);
  private final float jHi = 33.0F;
  private final int jHj = (int)j(1, 33.0F);
  private final float jHk = 8.0F;
  private final int jHl = (int)j(1, 8.0F);
  private final float jHm = 35.0F;
  private final int jHn = (int)j(1, 35.0F);
  private final float jHo = 10.0F;
  private final int jHp = (int)j(1, 10.0F);
  private final float jHq = 58.0F;
  private final int jHr = (int)j(1, 58.0F);
  private final int jHs = (int)j(1, 1.0F);
  private final int jHt = 102;
  private final int jHu = 102;
  private final int jHv = 153;
  private final int jHw = 102;
  private final int jHx = 102;
  private final int jHy = 102;
  private final int jHz = 204;
  private int jsq = 0;
  private int jsr = 0;
  private int lPj = 2147483647;
  private SimpleDateFormat ptS = new SimpleDateFormat(getResources().getString(a.b.sport_step_chart_fmt_date));
  private SimpleDateFormat ptT = new SimpleDateFormat("d");
  private boolean ptU;
  private int ptV = -1;
  private int ptW = -1;
  private SportChartView.a ptX = SportChartView.a.pug;
  private int ptY = 7;
  private List<e> ptZ;
  private SportChartView.b[] pua = new SportChartView.b[this.ptY];
  private int pub;
  private boolean puc;
  private GestureDetector.OnGestureListener pud = new SportChartView.1(this);
  private int startY;
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    aMS();
  }
  
  public SportChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    aMS();
  }
  
  private void aMS()
  {
    this.gaZ = new Paint();
    this.jHK = new Path();
    this.jHL = new Path();
    this.pua = new SportChartView.b[this.ptY];
    bLy();
    bLz();
    this.jEK = new GestureDetector(getContext(), this.pud);
  }
  
  private void aMU()
  {
    this.gaZ.reset();
    this.gaZ.setAntiAlias(true);
    this.gaZ.setStrokeWidth(this.jGH);
    this.gaZ.setStyle(Paint.Style.STROKE);
    this.gaZ.setColor(-1);
  }
  
  private void bLy()
  {
    int i = 0;
    while (i < this.pua.length)
    {
      this.pua[i] = new SportChartView.b(this, 0);
      i += 1;
    }
  }
  
  private void bLz()
  {
    int i = 0;
    if (i < this.ptY)
    {
      if (i == this.ptY - 1) {}
      for (this.pua[i].puj = true;; this.pua[i].puj = false)
      {
        i += 1;
        break;
      }
    }
  }
  
  private void c(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jHL.reset();
      this.jHL.moveTo(this.pua[0].x, this.pua[0].y);
      i = 0;
      while (i < this.pua.length)
      {
        this.jHL.lineTo(this.pua[i].x, this.pua[i].y);
        i += 1;
      }
      this.jHL.lineTo(this.pua[(this.pua.length - 1)].x, this.jsr - this.jGX - 1);
      this.jHL.lineTo(this.jGL, this.jsr - this.jGX - 1);
      this.jHL.lineTo(this.jGL, this.pua[0].y);
      paramCanvas.drawPath(this.jHL, this.gaZ);
      return;
    }
    this.jHL.reset();
    this.jHL.moveTo(this.pua[0].x, this.pua[0].y);
    label205:
    if (i < this.pua.length)
    {
      if (i <= 0) {
        break label406;
      }
      if (this.pua[(i - 1)].y != this.jsr - this.jGR) {
        break label399;
      }
      this.gaZ.reset();
      DashPathEffect localDashPathEffect = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.gaZ.setPathEffect(localDashPathEffect);
      this.gaZ.setAntiAlias(true);
      this.gaZ.setStrokeWidth(this.jGH);
      this.gaZ.setStyle(Paint.Style.STROKE);
      this.gaZ.setColor(-1);
    }
    for (;;)
    {
      this.jHL.lineTo(this.pua[i].x, this.pua[i].y);
      paramCanvas.drawPath(this.jHL, this.gaZ);
      this.jHL.reset();
      this.jHL.moveTo(this.pua[i].x, this.pua[i].y);
      i += 1;
      break label205;
      break;
      label399:
      aMU();
      continue;
      label406:
      aMU();
    }
  }
  
  private float j(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources()) {
      return TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
    }
  }
  
  private void jC(boolean paramBoolean)
  {
    int k = 0;
    this.lPj = 2147483647;
    Object localObject1 = Calendar.getInstance();
    this.pua = new SportChartView.b[this.ptY];
    bLy();
    int i;
    if ((this.ptZ == null) || (this.ptZ.size() <= 0))
    {
      this.ptU = true;
      ((Calendar)localObject1).add(5, -this.ptY);
      i = 0;
    }
    while (i < this.pua.length)
    {
      ((Calendar)localObject1).add(5, 1);
      this.pua[i].timestamp = ((Calendar)localObject1).getTimeInMillis();
      this.pua[i].ghE = 0;
      i += 1;
      continue;
      this.ptU = false;
      Object localObject2 = new ArrayList();
      ((List)localObject2).addAll(this.ptZ);
      Collections.sort((List)localObject2);
      int m = ((List)localObject2).size();
      if ((paramBoolean) || (this.ptW == -1))
      {
        i = m / this.ptY;
        if (m % this.ptY == 0) {
          break label400;
        }
      }
      int j;
      label400:
      for (this.ptW = (i + 1);; this.ptW = i)
      {
        if (this.ptW > 4) {
          this.ptW = 4;
        }
        this.ptV = this.ptW;
        j = m - this.ptY * (this.ptW - this.ptV + 1);
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = m - this.ptY * (this.ptW - this.ptV);
        y.i("MicroMsg.Sport.SportChartView", "updateViewItems beginIndex:%d endIndex:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        localObject2 = ((List)localObject2).subList(i, j);
        m = ((List)localObject2).size();
        j = k;
        if (m >= this.ptY) {
          break;
        }
        ((Calendar)localObject1).setTimeInMillis(((e)((List)localObject2).get(0)).field_timestamp);
        i = 0;
        for (;;)
        {
          j = k;
          if (i >= this.ptY - m) {
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
      while (j < this.ptY)
      {
        localObject1 = (e)((List)localObject2).get(j);
        this.pua[j].ghE = ((e)localObject1).field_step;
        this.pua[j].timestamp = ((e)localObject1).field_timestamp;
        j += 1;
      }
    }
  }
  
  private void k(Canvas paramCanvas)
  {
    this.gaZ.reset();
    this.gaZ.setAntiAlias(true);
    this.gaZ.setColor(-1);
    this.gaZ.setStrokeWidth(0.0F);
    this.gaZ.setStyle(Paint.Style.FILL);
    int i = 0;
    if (i < this.pua.length)
    {
      if (i == this.pua.length - 1) {
        paramCanvas.drawCircle(this.pua[i].x, this.pua[i].y, this.jGF, this.gaZ);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle(this.pua[i].x, this.pua[i].y, this.jGD, this.gaZ);
      }
    }
  }
  
  private void l(Canvas paramCanvas)
  {
    this.gaZ.reset();
    this.gaZ.setAntiAlias(true);
    this.gaZ.setStrokeWidth(0.0F);
    this.gaZ.setTextSize(j(2, 12.0F));
    this.gaZ.setAlpha(153);
    int i = 0;
    if (i < this.pua.length)
    {
      if (i == 0)
      {
        this.gaZ.setTextAlign(Paint.Align.LEFT);
        label72:
        if (!this.pua[i].puj) {
          break label148;
        }
        this.gaZ.setColor(-1);
      }
      for (;;)
      {
        paramCanvas.drawText(this.pua[i].nRs, this.pua[i].x, this.jsr - this.jHh, this.gaZ);
        i += 1;
        break;
        this.gaZ.setTextAlign(Paint.Align.CENTER);
        break label72;
        label148:
        this.gaZ.setColor(this.jGw);
      }
    }
  }
  
  public final void a(SportChartView.a parama)
  {
    this.ptX = parama;
    if (parama == SportChartView.a.pug) {}
    for (this.ptY = 7;; this.ptY = 30)
    {
      this.pua = new SportChartView.b[this.ptY];
      bLy();
      return;
    }
  }
  
  public final void cN(List<e> paramList)
  {
    this.ptZ = paramList;
    jC(true);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jsq = getWidth();
    this.jsr = getHeight();
    this.jHD = ((this.jsq - this.jGL - this.jGN) / (this.ptY - 1));
    this.jHE = ((this.jsr - this.jGP - this.jGR) / 2);
    int i = 0;
    while (i < this.pua.length)
    {
      this.pua[i].x = (this.jGL + this.jHD * i);
      i += 1;
    }
    i = this.pua.length;
    int k = i;
    if (i > this.ptY) {
      k = this.ptY;
    }
    int j = 0;
    i = 0;
    while (i < k)
    {
      if (this.pua[i].ghE > 100000) {
        this.pua[i].ghE = 100000;
      }
      if (this.pua[i].ghE < 0) {
        this.pua[i].ghE = 0;
      }
      int m = j;
      if (this.pua[i].ghE > j) {
        m = this.pua[i].ghE;
      }
      i += 1;
      j = m;
    }
    if ((j <= 15000) && (j >= 0)) {
      i = 15000;
    }
    for (;;)
    {
      this.jHA = ((this.jsr - this.jGP - this.jGR) * 10000 / i);
      this.jHA = (this.jsr - this.jGR - this.jHA);
      j = 0;
      for (;;)
      {
        if (j < k)
        {
          this.pua[j].y = (this.jsr - this.jGR - this.pua[j].ghE / i * (this.jsr - this.jGP - this.jGR));
          j += 1;
          continue;
          if ((j <= 15000) || (j > 100000)) {
            break label1992;
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
          this.pua[i].nRs = this.ptS.format(new Date(this.pua[i].timestamp));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.ptX == SportChartView.a.puh)
          {
            if (i % 6 == 5) {
              this.pua[i].nRs = this.ptT.format(new Date(this.pua[i].timestamp));
            } else {
              this.pua[i].nRs = "";
            }
          }
          else {
            this.pua[i].nRs = this.ptT.format(new Date(this.pua[i].timestamp));
          }
        }
      }
      super.onDraw(paramCanvas);
      float f;
      if (!this.ptU)
      {
        k(paramCanvas);
        if (this.lPj != 2147483647)
        {
          i = this.lPj;
          if ((i >= 0) && (i <= this.ptY - 1))
          {
            this.gaZ.reset();
            this.gaZ.setColor(this.jGw);
            this.gaZ.setAntiAlias(true);
            this.gaZ.setStrokeWidth(0.0F);
            this.gaZ.setTextSize(j(2, 12.0F));
            this.gaZ.setTextAlign(Paint.Align.CENTER);
            if (i == 0) {
              this.gaZ.setTextAlign(Paint.Align.LEFT);
            }
            if (i == this.ptY - 1) {
              this.gaZ.setTextAlign(Paint.Align.RIGHT);
            }
            if (!this.jHQ)
            {
              this.jHP = ((int)this.pua[i].y - this.jHr);
              this.startY = this.jHP;
              this.jHQ = true;
            }
            if (this.jHQ)
            {
              f = (float)(this.startY / 8.0D);
              if (this.jHP > 0) {
                this.gaZ.setAlpha((this.startY - this.jHP) * 255 / this.startY);
              }
              paramCanvas.drawText(this.pua[i].ghE, this.pua[i].x, this.jHP + this.jHr, this.gaZ);
              if (this.ptX == SportChartView.a.puh)
              {
                this.gaZ.reset();
                this.jHK.reset();
                localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
                this.gaZ.setPathEffect((PathEffect)localObject);
                this.gaZ.setColor(this.jGq);
                this.gaZ.setStrokeWidth(this.jGJ);
                this.gaZ.setStyle(Paint.Style.STROKE);
                this.gaZ.setAlpha(102);
                this.jHK.moveTo(this.pua[i].x, this.jsr - this.jGX);
                this.jHK.lineTo(this.pua[i].x, this.jHP + this.jHr + this.jGF);
                paramCanvas.drawPath(this.jHK, this.gaZ);
              }
              if (this.jHP <= 0) {
                break label1832;
              }
              if (this.jHP / this.startY > 1.0F / f) {
                break label1805;
              }
              this.jHP -= 1;
              invalidate();
            }
          }
          label1044:
          i = this.lPj;
          if ((i >= 0) && (i <= this.ptY - 1)) {
            this.pua[i].puj = true;
          }
        }
      }
      this.gaZ.reset();
      this.jHK.reset();
      Object localObject = new DashPathEffect(new float[] { 5.0F, 5.0F }, 0.0F);
      this.gaZ.setPathEffect((PathEffect)localObject);
      this.gaZ.setColor(this.jGq);
      this.gaZ.setStrokeWidth(this.jGJ);
      this.gaZ.setAlpha(102);
      this.gaZ.setStyle(Paint.Style.STROKE);
      if ((this.jHA != 0) && (!this.ptU))
      {
        this.jHK.moveTo(this.jGL, this.jHA);
        this.jHK.lineTo(this.jsq - this.jGT, this.jHA);
        paramCanvas.drawPath(this.jHK, this.gaZ);
      }
      this.gaZ.reset();
      this.jHK.reset();
      this.gaZ.setColor(this.jGq);
      this.gaZ.setStrokeWidth(this.jGJ);
      this.gaZ.setStyle(Paint.Style.STROKE);
      this.gaZ.setAlpha(102);
      this.jHK.reset();
      this.jHK.moveTo(this.jHb, this.jsr - this.jGX);
      this.jHK.lineTo(this.jsq - this.jHd, this.jsr - this.jGX);
      this.jHK.moveTo(this.jHb, this.jGZ);
      this.jHK.lineTo(this.jsq - this.jHd, this.jGZ);
      paramCanvas.drawPath(this.jHK, this.gaZ);
      if (!this.ptU)
      {
        this.gaZ.reset();
        this.gaZ.setColor(this.jGy);
        this.gaZ.setAntiAlias(true);
        this.gaZ.setAlpha(102);
        this.gaZ.setStrokeWidth(0.0F);
        this.gaZ.setTextSize(j(2, 12.0F));
        this.gaZ.setTextAlign(Paint.Align.RIGHT);
        paramCanvas.drawText(getResources().getString(a.b.sport_step_chart_1w_tips), this.jsq - this.jHf, (float)(this.jHA + this.gaZ.getTextSize() * 0.34D), this.gaZ);
      }
      if (this.puc)
      {
        this.gaZ.reset();
        this.gaZ.setColor(-1);
        this.gaZ.setAntiAlias(true);
        this.gaZ.setStrokeWidth(0.0F);
        this.gaZ.setTypeface(this.jHB);
        this.gaZ.setTextAlign(Paint.Align.RIGHT);
        this.gaZ.setTextSize(j(2, 28.0F));
        localObject = String.valueOf(this.pub);
        paramCanvas.drawText((String)localObject, this.jsq - this.jHp, this.jHn, this.gaZ);
        f = this.gaZ.measureText((String)localObject);
        this.gaZ.setTextSize(j(2, 24.0F));
        paramCanvas.drawText(getResources().getString(a.b.sport_step_chart_switch_step_tips), this.jsq - this.jHp - f, this.jHj, this.gaZ);
      }
      for (;;)
      {
        if (this.pua.length > 2)
        {
          this.gaZ.reset();
          this.gaZ.setAntiAlias(true);
          this.gaZ.setStrokeWidth(0.0F);
          this.gaZ.setAlpha(102);
          this.gaZ.setStyle(Paint.Style.FILL_AND_STROKE);
          localObject = new LinearGradient(0.0F, 0.0F, 0.0F, this.jsr - this.jGX, -1, 16777215, Shader.TileMode.REPEAT);
          this.gaZ.setShader((Shader)localObject);
          this.gaZ.setColor(-1);
          c(paramCanvas, true);
          aMU();
          if (!this.ptU) {
            c(paramCanvas, false);
          }
        }
        l(paramCanvas);
        return;
        label1805:
        this.jHP = ((int)(this.jHP - f * (this.jHP / this.startY)));
        break;
        label1832:
        this.jHQ = false;
        break label1044;
        this.gaZ.reset();
        this.gaZ.setColor(-1);
        this.gaZ.setAntiAlias(true);
        this.gaZ.setStrokeWidth(0.0F);
        this.gaZ.setTypeface(this.jHB);
        this.gaZ.setTextSize(j(2, 24.0F));
        paramCanvas.drawText(getResources().getString(a.b.sport_step_chart_step_tips), this.jHl, this.jHj, this.gaZ);
        this.gaZ.setTextAlign(Paint.Align.RIGHT);
        this.gaZ.setTextSize(j(2, 28.0F));
        paramCanvas.drawText(this.pub, this.jsq - this.jHp, this.jHn, this.gaZ);
      }
      label1992:
      i = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jEK.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setHasSwitchBtn(boolean paramBoolean)
  {
    this.puc = paramBoolean;
  }
  
  public void setTodayStep(int paramInt)
  {
    this.pub = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.ui.SportChartView
 * JD-Core Version:    0.7.0.1
 */