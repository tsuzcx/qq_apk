package com.tencent.mm.plugin.vlog.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/widget/RoundCornerAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "heightStep", "isRunningShow", "", "mRandom", "", "mRectCount", "mRectHeight", "mRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "mWidth", "spacing", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "setWaveCount", "count", "plugin-vlog_release"})
public final class RoundCornerAudioWaveView
  extends View
{
  private int CmA;
  private final String TAG;
  private int mWidth;
  private int pCJ;
  private final int spacing;
  private int xZh;
  private Paint xZi;
  private int xZj;
  private double xZk;
  private boolean xZl;
  
  public RoundCornerAudioWaveView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192373);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.h(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(192373);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192374);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.h(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(192374);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192375);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.h(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(192375);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(192369);
    this.xZj = 20;
    this.xZi = new Paint();
    Paint localPaint = this.xZi;
    if (localPaint == null) {
      p.gkB();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.xZi;
    if (localPaint == null) {
      p.gkB();
    }
    localPaint.setColor(-3355444);
    localPaint = this.xZi;
    if (localPaint == null) {
      p.gkB();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(192369);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192372);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(this.spacing, getHeight() / 2);
    int i = 0;
    int j = this.xZj;
    while (i < j)
    {
      this.xZk = Math.random();
      double d2 = (this.xZj / 2 - Math.abs(i - this.xZj / 2) + 1) * this.CmA * this.xZk;
      int k = this.pCJ * i + this.spacing * i;
      double d1 = d2 / 2.0D;
      int m = this.pCJ;
      d2 = -d2 / 2.0D;
      paramCanvas.drawRoundRect(new RectF(k, (float)d1, m + k, (float)d2), this.pCJ / 2, this.pCJ / 2, this.xZi);
      i += 1;
    }
    paramCanvas.restore();
    if (this.xZl) {
      postInvalidateDelayed(100L);
    }
    AppMethodBeat.o(192372);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192371);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.xZh = (getHeight() / 2);
    this.pCJ = (this.mWidth / this.xZj);
    this.pCJ -= this.spacing;
    this.CmA = (this.xZh / (this.xZj / 2));
    AppMethodBeat.o(192371);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(192370);
    Paint localPaint = this.xZi;
    if (localPaint == null) {
      p.gkB();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(192370);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.xZl = paramBoolean;
  }
  
  public final void setWaveCount(int paramInt)
  {
    this.xZj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.RoundCornerAudioWaveView
 * JD-Core Version:    0.7.0.1
 */