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
import com.tencent.mm.cc.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/widget/RoundCornerAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "heightStep", "isRunningShow", "", "mRandom", "", "mRectCount", "mRectHeight", "mRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "mWidth", "spacing", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "setWaveCount", "count", "plugin-vlog_release"})
public final class RoundCornerAudioWaveView
  extends View
{
  private int BUZ;
  private final String TAG;
  private int mWidth;
  private int pwf;
  private final int spacing;
  private int xJm;
  private Paint xJn;
  private int xJo;
  private double xJp;
  private boolean xJq;
  
  public RoundCornerAudioWaveView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(196910);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.g(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(196910);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(196911);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.g(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(196911);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196912);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.g(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(196912);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(196906);
    this.xJo = 20;
    this.xJn = new Paint();
    Paint localPaint = this.xJn;
    if (localPaint == null) {
      p.gfZ();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.xJn;
    if (localPaint == null) {
      p.gfZ();
    }
    localPaint.setColor(-3355444);
    localPaint = this.xJn;
    if (localPaint == null) {
      p.gfZ();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(196906);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(196909);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(this.spacing, getHeight() / 2);
    int i = 0;
    int j = this.xJo;
    while (i < j)
    {
      this.xJp = Math.random();
      double d2 = (this.xJo / 2 - Math.abs(i - this.xJo / 2) + 1) * this.BUZ * this.xJp;
      int k = this.pwf * i + this.spacing * i;
      double d1 = d2 / 2.0D;
      int m = this.pwf;
      d2 = -d2 / 2.0D;
      paramCanvas.drawRoundRect(new RectF(k, (float)d1, m + k, (float)d2), this.pwf / 2, this.pwf / 2, this.xJn);
      i += 1;
    }
    paramCanvas.restore();
    if (this.xJq) {
      postInvalidateDelayed(100L);
    }
    AppMethodBeat.o(196909);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(196908);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.xJm = (getHeight() / 2);
    this.pwf = (this.mWidth / this.xJo);
    this.pwf -= this.spacing;
    this.BUZ = (this.xJm / (this.xJo / 2));
    AppMethodBeat.o(196908);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(196907);
    Paint localPaint = this.xJn;
    if (localPaint == null) {
      p.gfZ();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(196907);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.xJq = paramBoolean;
  }
  
  public final void setWaveCount(int paramInt)
  {
    this.xJo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.RoundCornerAudioWaveView
 * JD-Core Version:    0.7.0.1
 */