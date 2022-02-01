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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/widget/RoundCornerAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "heightStep", "isRunningShow", "", "mRandom", "", "mRectCount", "mRectHeight", "mRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "mWidth", "spacing", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "setWaveCount", "count", "plugin-vlog_release"})
public final class RoundCornerAudioWaveView
  extends View
{
  private int Caf;
  private Paint Cag;
  private int Cai;
  private double Caj;
  private boolean Cak;
  private int GQA;
  private final String TAG;
  private int mWidth;
  private int qSb;
  private final int spacing;
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(192220);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.fromDPToPix(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(192220);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192221);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.spacing = a.fromDPToPix(getContext(), 2.0F);
    initView();
    AppMethodBeat.o(192221);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(192216);
    this.Cai = 20;
    this.Cag = new Paint();
    Paint localPaint = this.Cag;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.Cag;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setColor(-3355444);
    localPaint = this.Cag;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(192216);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(192219);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.translate(this.spacing, getHeight() / 2);
    int i = 0;
    int j = this.Cai;
    while (i < j)
    {
      this.Caj = Math.random();
      double d2 = (this.Cai / 2 - Math.abs(i - this.Cai / 2) + 1) * this.GQA * this.Caj;
      int k = this.qSb * i + this.spacing * i;
      double d1 = d2 / 2.0D;
      int m = this.qSb;
      d2 = -d2 / 2.0D;
      RectF localRectF = new RectF(k, (float)d1, m + k, (float)d2);
      float f1 = this.qSb / 2;
      float f2 = this.qSb / 2;
      Paint localPaint = this.Cag;
      if (localPaint == null) {
        p.hyc();
      }
      paramCanvas.drawRoundRect(localRectF, f1, f2, localPaint);
      i += 1;
    }
    paramCanvas.restore();
    if (this.Cak) {
      postInvalidateDelayed(100L);
    }
    AppMethodBeat.o(192219);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(192218);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.Caf = (getHeight() / 2);
    this.qSb = (this.mWidth / this.Cai);
    this.qSb -= this.spacing;
    this.GQA = (this.Caf / (this.Cai / 2));
    AppMethodBeat.o(192218);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(192217);
    Paint localPaint = this.Cag;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(192217);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.Cak = paramBoolean;
  }
  
  public final void setWaveCount(int paramInt)
  {
    this.Cai = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.widget.RoundCornerAudioWaveView
 * JD-Core Version:    0.7.0.1
 */