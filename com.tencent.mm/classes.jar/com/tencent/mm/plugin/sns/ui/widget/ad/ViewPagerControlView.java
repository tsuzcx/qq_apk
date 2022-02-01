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
import com.tencent.mm.cb.a;

public class ViewPagerControlView
  extends LinearLayout
{
  protected int Fgm;
  private float Fgn;
  private float Fgo;
  private Paint Fgp;
  private Paint Fgq;
  private Paint Fgr;
  private Paint Fgs;
  private int Fgt;
  private float Fgu;
  private int Fgv;
  private float Fgw;
  private float Fgx;
  private boolean autoCarousel;
  protected Context context;
  protected int count;
  private float height;
  private float left;
  private Paint lun;
  private int mEX;
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
    AppMethodBeat.i(204030);
    this.autoCarousel = false;
    this.context = paramContext;
    this.mEX = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.ha(this.context)[0];
    this.width = a.fromDPToPix(this.context, 28);
    this.height = a.fromDPToPix(this.context, 7);
    this.radius = (this.height / 2.0F);
    this.Fgo = (this.width - this.height);
    this.Fgp = new Paint();
    this.Fgp.setFlags(1);
    this.Fgp.setColor(this.context.getResources().getColor(2131101101));
    this.Fgq = new Paint();
    this.Fgq.setStyle(Paint.Style.STROKE);
    this.Fgq.setStrokeWidth(0.5F);
    this.Fgq.setFlags(1);
    this.Fgq.setColor(this.context.getResources().getColor(2131101100));
    this.Fgr = new Paint();
    this.Fgr.setFlags(1);
    this.Fgr.setColor(this.context.getResources().getColor(2131101101));
    this.Fgs = new Paint();
    this.Fgs.setFlags(1);
    this.Fgs.setColor(-1);
    this.Fgs.setAlpha(0);
    this.lun = new Paint();
    this.lun.setFlags(1);
    this.lun.setColor(-1);
    this.lun.setAlpha(0);
    this.lun.setStyle(Paint.Style.STROKE);
    this.lun.setStrokeWidth(this.height);
    this.lun.setStrokeCap(Paint.Cap.ROUND);
    setWillNotDraw(false);
    AppMethodBeat.o(204030);
  }
  
  private void e(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(204034);
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
      f3 = this.Fgu;
      f4 = this.Fgo;
      if (this.Fgu <= 0.3F)
      {
        f1 = 1.0F - this.Fgu * 10.0F / 3.0F;
        f2 -= f3 * f4;
        i = (int)(f1 * 255.0F);
        f1 = this.left + f2;
        localRectF = new RectF(this.left, 0.0F, f1, this.height);
        paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.Fgp);
        if (!paramBoolean) {
          break label288;
        }
        this.lun.setAlpha(i);
        f3 = this.Fgw;
        f4 = this.radius;
        f5 = this.Fgw;
        paramCanvas.drawLine(f3, f4, (f2 - this.radius * 2.0F) * this.progress + f5, this.radius, this.lun);
      }
    }
    for (;;)
    {
      paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.Fgq);
      this.left = (this.height + f1);
      this.Fgw = (this.left + this.radius);
      AppMethodBeat.o(204034);
      return;
      f1 = 0.0F;
      break;
      f2 = this.Fgu;
      f3 = this.Fgo;
      f4 = this.height;
      if (this.Fgu >= 0.7F) {}
      for (f1 = (this.Fgu - 0.7F) * 10.0F / 3.0F;; f1 = 0.0F)
      {
        f2 = f4 + f2 * f3;
        break;
      }
      label288:
      if (!this.autoCarousel)
      {
        this.lun.setAlpha(i);
        f3 = this.Fgw;
        f4 = this.radius;
        f5 = this.Fgw;
        paramCanvas.drawLine(f3, f4, (f2 - this.radius * 2.0F) * this.progress + f5, this.radius, this.lun);
      }
      else
      {
        this.Fgs.setAlpha(i);
        paramCanvas.drawCircle(this.Fgw, this.Fgx, this.radius, this.Fgs);
      }
    }
  }
  
  private void v(Canvas paramCanvas)
  {
    AppMethodBeat.i(204033);
    paramCanvas.drawCircle(this.Fgw, this.Fgx, this.radius, this.Fgr);
    paramCanvas.drawCircle(this.Fgw, this.Fgx, this.radius, this.Fgq);
    this.left += 2.0F * this.height;
    this.Fgw = (this.left + this.radius);
    AppMethodBeat.o(204033);
  }
  
  public final void aX(int paramInt, boolean paramBoolean)
  {
    this.count = paramInt;
    this.Fgm = (paramInt - 2);
    this.Fgn = ((this.mEX - (this.Fgm - 1) * 2 * this.height - this.width) / 2.0F);
    this.autoCarousel = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 2;
    AppMethodBeat.i(204032);
    super.onDraw(paramCanvas);
    this.left = this.Fgn;
    this.Fgw = (this.left + this.radius);
    this.Fgx = this.radius;
    if ((this.Fgv == 1) || (this.Fgv == 2))
    {
      e(paramCanvas, false);
      while (i <= this.Fgm - 1)
      {
        v(paramCanvas);
        i += 1;
      }
      e(paramCanvas, true);
      AppMethodBeat.o(204032);
      return;
    }
    i = 1;
    while (i < this.Fgt)
    {
      v(paramCanvas);
      i += 1;
    }
    e(paramCanvas, true);
    e(paramCanvas, false);
    i = this.Fgt + 2;
    while (i <= this.Fgm)
    {
      v(paramCanvas);
      i += 1;
    }
    AppMethodBeat.o(204032);
  }
  
  public final void v(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(204031);
    if (paramInt > this.Fgm)
    {
      AppMethodBeat.o(204031);
      return;
    }
    if (paramInt <= 0) {
      this.Fgv = 1;
    }
    for (;;)
    {
      this.Fgt = paramInt;
      this.Fgu = paramFloat;
      invalidate();
      AppMethodBeat.o(204031);
      return;
      if (paramInt == this.Fgm) {
        this.Fgv = 2;
      } else {
        this.Fgv = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ViewPagerControlView
 * JD-Core Version:    0.7.0.1
 */