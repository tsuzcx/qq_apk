package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.u.a.b;
import com.tencent.mm.plugin.u.a.c;
import com.tencent.mm.plugin.u.a.g;

public final class o
  extends View
{
  private int borderWidth;
  private Paint hzj;
  private View.OnTouchListener kFq = new o.2(this);
  Drawable mmA = new o.b(this, a.g(getContext(), a.g.video_clip_slider_selected), a.g(getContext(), a.g.video_clip_slider_normal));
  private int mmB = a.fromDPToPix(getContext(), 8);
  private float mmC = this.mmB * 0.5F;
  private int mmD = a.fromDPToPix(getContext(), 1);
  float mmE = -1.0F;
  private int mmF = a.aa(getContext(), a.c.video_segment_seekbar_recycler_view_height);
  private Paint mmG = new Paint();
  private float mmH;
  private Paint mmI;
  private Paint mmJ;
  private int mmK;
  private float mmL;
  private float mmM = -1.0F;
  private float mmN = -1.0F;
  private int mmO = a.fromDPToPix(getContext(), 8);
  Rect mmP;
  Rect mmQ;
  private o.a mmu;
  private boolean mmv = false;
  boolean mmw = false;
  private int mmx;
  private int mmy;
  Drawable mmz = new o.b(this, a.g(getContext(), a.g.video_clip_slider_selected), a.g(getContext(), a.g.video_clip_slider_normal));
  private int padding = 0;
  
  public o(Context paramContext)
  {
    super(paramContext);
    this.mmG.setColor(a.i(getContext(), a.b.white));
    this.mmG.setAlpha(102);
    this.mmI = new Paint();
    this.mmI.setColor(a.i(getContext(), a.b.black));
    this.mmI.setAlpha(102);
    this.hzj = new Paint();
    this.hzj.setColor(a.i(getContext(), a.b.white));
    this.hzj.setStyle(Paint.Style.STROKE);
    this.borderWidth = dN(getContext());
    this.hzj.setStrokeWidth(this.borderWidth);
    this.mmH = (this.borderWidth * 0.5F);
    this.mmJ = new Paint();
    this.mmJ.setColor(a.i(getContext(), a.b.white));
    this.mmJ.setStyle(Paint.Style.STROKE);
    this.mmK = dN(getContext());
    this.mmL = (this.mmK * 0.5F);
    this.mmJ.setStrokeWidth(this.mmK);
    this.mmJ.setAlpha(178);
    setOnTouchListener(this.kFq);
  }
  
  private static int dN(Context paramContext)
  {
    return Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
  }
  
  private boolean hy(boolean paramBoolean)
  {
    if (paramBoolean) {
      return o.b.a((o.b)this.mmz);
    }
    return o.b.a((o.b)this.mmA);
  }
  
  public final int getLeftSliderBound()
  {
    return this.mmz.getBounds().left;
  }
  
  public final int getRightSliderBound()
  {
    return this.mmA.getBounds().right;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    if (this.mmE > 0.0F)
    {
      float f = getWidth() * this.mmE;
      paramCanvas.drawRect(f - this.mmD * 0.5F, 0.0F, this.mmD * 0.5F + f, this.mmF, this.mmG);
    }
    if (!this.mmv) {
      return;
    }
    int i = this.mmz.getBounds().centerX();
    int j = this.mmA.getBounds().centerX();
    if ((hy(true)) || (hy(false))) {
      paramCanvas.drawRect(this.padding + this.mmL, this.mmL, getWidth() - this.padding - this.mmL, getBottom() - this.mmL, this.mmJ);
    }
    if (this.mmz.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.mmI);
    }
    if (this.mmA.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.mmI);
    }
    paramCanvas.drawLine(i, this.mmH, j, this.mmH, this.hzj);
    paramCanvas.drawLine(i, getHeight() - this.mmH, j, getHeight() - this.mmH, this.hzj);
    this.mmz.draw(paramCanvas);
    this.mmA.draw(paramCanvas);
  }
  
  public final void setCursorPos(float paramFloat)
  {
    if (!this.mmv) {
      return;
    }
    this.mmE = paramFloat;
    invalidate();
  }
  
  public final void setOnSliderTouchListener(o.a parama)
  {
    this.mmu = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.o
 * JD-Core Version:    0.7.0.1
 */