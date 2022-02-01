package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.c;

public class ViewPagerControlView
  extends LinearLayout
{
  private float RYA;
  private int RYB;
  private float RYC;
  private float RYD;
  protected int RYs;
  private float RYt;
  private float RYu;
  private Paint RYv;
  private Paint RYw;
  private Paint RYx;
  private Paint RYy;
  private int RYz;
  private boolean autoCarousel;
  protected Context context;
  protected int count;
  private float height;
  private float left;
  float progress;
  private float radius;
  private Paint rsU;
  private int sJv;
  private float width;
  
  public ViewPagerControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(309270);
    this.autoCarousel = false;
    this.context = paramContext;
    this.sJv = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar.jR(this.context)[0];
    this.width = a.fromDPToPix(this.context, 28);
    this.height = a.fromDPToPix(this.context, 7);
    this.radius = (this.height / 2.0F);
    this.RYu = (this.width - this.height);
    this.RYv = new Paint();
    this.RYv.setFlags(1);
    this.RYv.setColor(this.context.getResources().getColor(b.c.sns_ad_gallery_control_view_point_color));
    this.RYw = new Paint();
    this.RYw.setStyle(Paint.Style.STROKE);
    this.RYw.setStrokeWidth(0.5F);
    this.RYw.setFlags(1);
    this.RYw.setColor(this.context.getResources().getColor(b.c.sns_ad_gallery_control_view_border_color));
    this.RYx = new Paint();
    this.RYx.setFlags(1);
    this.RYx.setColor(this.context.getResources().getColor(b.c.sns_ad_gallery_control_view_point_color));
    this.RYy = new Paint();
    this.RYy.setFlags(1);
    this.RYy.setColor(-1);
    this.RYy.setAlpha(0);
    this.rsU = new Paint();
    this.rsU.setFlags(1);
    this.rsU.setColor(-1);
    this.rsU.setAlpha(0);
    this.rsU.setStyle(Paint.Style.STROKE);
    this.rsU.setStrokeWidth(this.height);
    this.rsU.setStrokeCap(Paint.Cap.ROUND);
    setWillNotDraw(false);
    AppMethodBeat.o(309270);
  }
  
  private void f(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(309278);
    float f2;
    float f3;
    float f4;
    float f1;
    int i;
    RectF localRectF;
    float f5;
    if (paramBoolean)
    {
      f2 = this.width;
      f3 = this.RYA;
      f4 = this.RYu;
      if (this.RYA <= 0.3F)
      {
        f1 = 1.0F - this.RYA * 10.0F / 3.0F;
        f2 -= f3 * f4;
        i = (int)(f1 * 255.0F);
        f1 = this.left + f2;
        localRectF = new RectF(this.left, 0.0F, f1, this.height);
        paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.RYv);
        if (!paramBoolean) {
          break label288;
        }
        this.rsU.setAlpha(i);
        f3 = this.RYC;
        f4 = this.radius;
        f5 = this.RYC;
        paramCanvas.drawLine(f3, f4, (f2 - this.radius * 2.0F) * this.progress + f5, this.radius, this.rsU);
      }
    }
    for (;;)
    {
      paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.RYw);
      this.left = (this.height + f1);
      this.RYC = (this.left + this.radius);
      AppMethodBeat.o(309278);
      return;
      f1 = 0.0F;
      break;
      f2 = this.RYA;
      f3 = this.RYu;
      f4 = this.height;
      if (this.RYA >= 0.7F) {}
      for (f1 = (this.RYA - 0.7F) * 10.0F / 3.0F;; f1 = 0.0F)
      {
        f2 = f4 + f2 * f3;
        break;
      }
      label288:
      if (!this.autoCarousel)
      {
        this.rsU.setAlpha(i);
        f3 = this.RYC;
        f4 = this.radius;
        f5 = this.RYC;
        paramCanvas.drawLine(f3, f4, (f2 - this.radius * 2.0F) * this.progress + f5, this.radius, this.rsU);
      }
      else
      {
        this.RYy.setAlpha(i);
        paramCanvas.drawCircle(this.RYC, this.RYD, this.radius, this.RYy);
      }
    }
  }
  
  private void t(Canvas paramCanvas)
  {
    AppMethodBeat.i(309273);
    paramCanvas.drawCircle(this.RYC, this.RYD, this.radius, this.RYx);
    paramCanvas.drawCircle(this.RYC, this.RYD, this.radius, this.RYw);
    this.left += 2.0F * this.height;
    this.RYC = (this.left + this.radius);
    AppMethodBeat.o(309273);
  }
  
  public final void bQ(int paramInt, boolean paramBoolean)
  {
    this.count = paramInt;
    this.RYs = (paramInt - 2);
    this.RYt = ((this.sJv - (this.RYs - 1) * 2 * this.height - this.width) / 2.0F);
    this.autoCarousel = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 2;
    AppMethodBeat.i(309291);
    super.onDraw(paramCanvas);
    this.left = this.RYt;
    this.RYC = (this.left + this.radius);
    this.RYD = this.radius;
    if ((this.RYB == 1) || (this.RYB == 2))
    {
      f(paramCanvas, false);
      while (i <= this.RYs - 1)
      {
        t(paramCanvas);
        i += 1;
      }
      f(paramCanvas, true);
      AppMethodBeat.o(309291);
      return;
    }
    i = 1;
    while (i < this.RYz)
    {
      t(paramCanvas);
      i += 1;
    }
    f(paramCanvas, true);
    f(paramCanvas, false);
    i = this.RYz + 2;
    while (i <= this.RYs)
    {
      t(paramCanvas);
      i += 1;
    }
    AppMethodBeat.o(309291);
  }
  
  public final void z(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(309285);
    if (paramInt > this.RYs)
    {
      AppMethodBeat.o(309285);
      return;
    }
    if (paramInt <= 0) {
      this.RYB = 1;
    }
    for (;;)
    {
      this.RYz = paramInt;
      this.RYA = paramFloat;
      invalidate();
      AppMethodBeat.o(309285);
      return;
      if (paramInt == this.RYs) {
        this.RYB = 2;
      } else {
        this.RYB = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ViewPagerControlView
 * JD-Core Version:    0.7.0.1
 */