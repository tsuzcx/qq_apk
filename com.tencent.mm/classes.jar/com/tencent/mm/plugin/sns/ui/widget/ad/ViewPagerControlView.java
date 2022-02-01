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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.i.c;

public class ViewPagerControlView
  extends LinearLayout
{
  protected int LuR;
  private float LuS;
  private float LuT;
  private Paint LuU;
  private Paint LuV;
  private Paint LuW;
  private Paint LuX;
  private int LuY;
  private float LuZ;
  private int Lva;
  private float Lvb;
  private float Lvc;
  private boolean autoCarousel;
  protected Context context;
  protected int count;
  private float height;
  private float left;
  private Paint opm;
  private int pEj;
  float progress;
  private float radius;
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
    AppMethodBeat.i(263901);
    this.autoCarousel = false;
    this.context = paramContext;
    this.pEj = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao.ib(this.context)[0];
    this.width = a.fromDPToPix(this.context, 28);
    this.height = a.fromDPToPix(this.context, 7);
    this.radius = (this.height / 2.0F);
    this.LuT = (this.width - this.height);
    this.LuU = new Paint();
    this.LuU.setFlags(1);
    this.LuU.setColor(this.context.getResources().getColor(i.c.sns_ad_gallery_control_view_point_color));
    this.LuV = new Paint();
    this.LuV.setStyle(Paint.Style.STROKE);
    this.LuV.setStrokeWidth(0.5F);
    this.LuV.setFlags(1);
    this.LuV.setColor(this.context.getResources().getColor(i.c.sns_ad_gallery_control_view_border_color));
    this.LuW = new Paint();
    this.LuW.setFlags(1);
    this.LuW.setColor(this.context.getResources().getColor(i.c.sns_ad_gallery_control_view_point_color));
    this.LuX = new Paint();
    this.LuX.setFlags(1);
    this.LuX.setColor(-1);
    this.LuX.setAlpha(0);
    this.opm = new Paint();
    this.opm.setFlags(1);
    this.opm.setColor(-1);
    this.opm.setAlpha(0);
    this.opm.setStyle(Paint.Style.STROKE);
    this.opm.setStrokeWidth(this.height);
    this.opm.setStrokeCap(Paint.Cap.ROUND);
    setWillNotDraw(false);
    AppMethodBeat.o(263901);
  }
  
  private void e(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(263909);
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
      f3 = this.LuZ;
      f4 = this.LuT;
      if (this.LuZ <= 0.3F)
      {
        f1 = 1.0F - this.LuZ * 10.0F / 3.0F;
        f2 -= f3 * f4;
        i = (int)(f1 * 255.0F);
        f1 = this.left + f2;
        localRectF = new RectF(this.left, 0.0F, f1, this.height);
        paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.LuU);
        if (!paramBoolean) {
          break label288;
        }
        this.opm.setAlpha(i);
        f3 = this.Lvb;
        f4 = this.radius;
        f5 = this.Lvb;
        paramCanvas.drawLine(f3, f4, (f2 - this.radius * 2.0F) * this.progress + f5, this.radius, this.opm);
      }
    }
    for (;;)
    {
      paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.LuV);
      this.left = (this.height + f1);
      this.Lvb = (this.left + this.radius);
      AppMethodBeat.o(263909);
      return;
      f1 = 0.0F;
      break;
      f2 = this.LuZ;
      f3 = this.LuT;
      f4 = this.height;
      if (this.LuZ >= 0.7F) {}
      for (f1 = (this.LuZ - 0.7F) * 10.0F / 3.0F;; f1 = 0.0F)
      {
        f2 = f4 + f2 * f3;
        break;
      }
      label288:
      if (!this.autoCarousel)
      {
        this.opm.setAlpha(i);
        f3 = this.Lvb;
        f4 = this.radius;
        f5 = this.Lvb;
        paramCanvas.drawLine(f3, f4, (f2 - this.radius * 2.0F) * this.progress + f5, this.radius, this.opm);
      }
      else
      {
        this.LuX.setAlpha(i);
        paramCanvas.drawCircle(this.Lvb, this.Lvc, this.radius, this.LuX);
      }
    }
  }
  
  private void y(Canvas paramCanvas)
  {
    AppMethodBeat.i(263908);
    paramCanvas.drawCircle(this.Lvb, this.Lvc, this.radius, this.LuW);
    paramCanvas.drawCircle(this.Lvb, this.Lvc, this.radius, this.LuV);
    this.left += 2.0F * this.height;
    this.Lvb = (this.left + this.radius);
    AppMethodBeat.o(263908);
  }
  
  public final void bi(int paramInt, boolean paramBoolean)
  {
    this.count = paramInt;
    this.LuR = (paramInt - 2);
    this.LuS = ((this.pEj - (this.LuR - 1) * 2 * this.height - this.width) / 2.0F);
    this.autoCarousel = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 2;
    AppMethodBeat.i(263907);
    super.onDraw(paramCanvas);
    this.left = this.LuS;
    this.Lvb = (this.left + this.radius);
    this.Lvc = this.radius;
    if ((this.Lva == 1) || (this.Lva == 2))
    {
      e(paramCanvas, false);
      while (i <= this.LuR - 1)
      {
        y(paramCanvas);
        i += 1;
      }
      e(paramCanvas, true);
      AppMethodBeat.o(263907);
      return;
    }
    i = 1;
    while (i < this.LuY)
    {
      y(paramCanvas);
      i += 1;
    }
    e(paramCanvas, true);
    e(paramCanvas, false);
    i = this.LuY + 2;
    while (i <= this.LuR)
    {
      y(paramCanvas);
      i += 1;
    }
    AppMethodBeat.o(263907);
  }
  
  public final void w(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(263905);
    if (paramInt > this.LuR)
    {
      AppMethodBeat.o(263905);
      return;
    }
    if (paramInt <= 0) {
      this.Lva = 1;
    }
    for (;;)
    {
      this.LuY = paramInt;
      this.LuZ = paramFloat;
      invalidate();
      AppMethodBeat.o(263905);
      return;
      if (paramInt == this.LuR) {
        this.Lva = 2;
      } else {
        this.Lva = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ViewPagerControlView
 * JD-Core Version:    0.7.0.1
 */