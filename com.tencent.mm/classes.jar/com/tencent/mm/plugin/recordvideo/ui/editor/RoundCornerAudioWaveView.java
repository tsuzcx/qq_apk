package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aw;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/RoundCornerAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DP_1", "TAG", "", "WAVE_DECREMENT", "WAVE_INCREMENT", "", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "isRunningShow", "", "mWaveCount", "mWavePaint", "Landroid/graphics/Paint;", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "initView", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "setWaveCount", "count", "plugin-recordvideo_release"})
public final class RoundCornerAudioWaveView
  extends View
{
  private Paint HWV;
  private boolean HWZ;
  private final int IaA;
  private final float IaB;
  private float IaC;
  private int IaD;
  private RectF[] IaE;
  private float[] IaF;
  private final float Iax;
  private final int Iay;
  private final float Iaz;
  private final String TAG;
  private final int tBj;
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(218477);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.tBj = aw.fromDPToPix(getContext(), 1);
    this.Iax = (this.tBj * 1.5F);
    this.Iay = this.tBj;
    this.Iaz = (this.tBj * 2.0F);
    this.IaA = this.tBj;
    this.IaB = (this.tBj * 1.5F);
    this.IaC = (this.tBj * 9.0F);
    int j = this.IaD;
    paramContext = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramContext[i] = new RectF();
      i += 1;
    }
    this.IaE = paramContext;
    this.IaF = new float[this.IaD];
    initView();
    AppMethodBeat.o(218477);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(218478);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.tBj = aw.fromDPToPix(getContext(), 1);
    this.Iax = (this.tBj * 1.5F);
    this.Iay = this.tBj;
    this.Iaz = (this.tBj * 2.0F);
    this.IaA = this.tBj;
    this.IaB = (this.tBj * 1.5F);
    this.IaC = (this.tBj * 9.0F);
    int i = this.IaD;
    paramContext = new RectF[i];
    paramInt = 0;
    while (paramInt < i)
    {
      paramContext[paramInt] = new RectF();
      paramInt += 1;
    }
    this.IaE = paramContext;
    this.IaF = new float[this.IaD];
    initView();
    AppMethodBeat.o(218478);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(218470);
    setWaveCount(20);
    this.HWV = new Paint();
    Paint localPaint = this.HWV;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.HWV;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setColor(-3355444);
    localPaint = this.HWV;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(218470);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(218476);
    p.k(paramCanvas, "canvas");
    RectF[] arrayOfRectF = this.IaE;
    int i = 0;
    int k = arrayOfRectF.length;
    int j = 0;
    float f1 = 0.0F;
    if (j < k)
    {
      RectF localRectF = arrayOfRectF[j];
      float f2 = localRectF.height();
      if (f2 <= this.Iay)
      {
        this.IaF[i] = ((float)(this.IaC * Math.random()));
        label77:
        if (f2 > this.IaF[i]) {
          break label257;
        }
      }
      label257:
      for (f2 = Math.min(f2 + this.Iaz, this.IaC);; f2 = Math.max(f2 - this.IaA, this.Iay))
      {
        float f3 = this.IaB;
        float f4 = this.IaC / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.IaB;
        float f7 = this.Iax;
        float f8 = this.IaC / 2.0F;
        localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localRectF.right;
        f2 = this.Iax / 2.0F;
        f3 = this.Iax / 2.0F;
        Paint localPaint = this.HWV;
        if (localPaint == null) {
          p.iCn();
        }
        paramCanvas.drawRoundRect(localRectF, f2, f3, localPaint);
        j += 1;
        i += 1;
        break;
        if (f2 < this.IaF[i]) {
          break label77;
        }
        this.IaF[i] = this.Iay;
        break label77;
      }
    }
    if (this.HWZ) {
      postInvalidateDelayed(33L);
    }
    AppMethodBeat.o(218476);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(218475);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.IaC = paramInt2;
    AppMethodBeat.o(218475);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(218472);
    Paint localPaint = this.HWV;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(218472);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.HWZ = paramBoolean;
  }
  
  public final void setWaveCount(int paramInt)
  {
    AppMethodBeat.i(218473);
    this.IaD = paramInt;
    int i = this.IaD;
    RectF[] arrayOfRectF = new RectF[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfRectF[paramInt] = new RectF();
      paramInt += 1;
    }
    this.IaE = arrayOfRectF;
    this.IaF = new float[this.IaD];
    AppMethodBeat.o(218473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.RoundCornerAudioWaveView
 * JD-Core Version:    0.7.0.1
 */