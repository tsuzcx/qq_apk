package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/RoundCornerAudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DP_1", "TAG", "", "WAVE_DECREMENT", "WAVE_INCREMENT", "", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "isRunningShow", "", "mWaveCount", "mWavePaint", "Landroid/graphics/Paint;", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "initView", "", "isShow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "setWaveCount", "count", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoundCornerAudioWaveView
  extends View
{
  private Paint NTF;
  private boolean NTJ;
  private final float NWY;
  private final int NWZ;
  private final float NXa;
  private final int NXb;
  private final float NXc;
  private float NXd;
  private int NXe;
  private RectF[] NXf;
  private float[] NXg;
  private final String TAG;
  private final int wFI;
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(279901);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.wFI = bd.fromDPToPix(getContext(), 1);
    this.NWY = (this.wFI * 1.5F);
    this.NWZ = this.wFI;
    this.NXa = (this.wFI * 2.0F);
    this.NXb = this.wFI;
    this.NXc = (this.wFI * 1.5F);
    this.NXd = (this.wFI * 9.0F);
    int i = 0;
    int j = this.NXe;
    paramContext = new RectF[j];
    while (i < j)
    {
      paramContext[i] = new RectF();
      i += 1;
    }
    this.NXf = paramContext;
    this.NXg = new float[this.NXe];
    initView();
    AppMethodBeat.o(279901);
  }
  
  public RoundCornerAudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279907);
    this.TAG = "MicroMsg.RoundCornerAudioWaveView";
    this.wFI = bd.fromDPToPix(getContext(), 1);
    this.NWY = (this.wFI * 1.5F);
    this.NWZ = this.wFI;
    this.NXa = (this.wFI * 2.0F);
    this.NXb = this.wFI;
    this.NXc = (this.wFI * 1.5F);
    this.NXd = (this.wFI * 9.0F);
    paramInt = 0;
    int i = this.NXe;
    paramContext = new RectF[i];
    while (paramInt < i)
    {
      paramContext[paramInt] = new RectF();
      paramInt += 1;
    }
    this.NXf = paramContext;
    this.NXg = new float[this.NXe];
    initView();
    AppMethodBeat.o(279907);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(279913);
    setWaveCount(20);
    this.NTF = new Paint();
    Paint localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setColor(-3355444);
    localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(279913);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(279939);
    s.u(paramCanvas, "canvas");
    RectF[] arrayOfRectF = this.NXf;
    int i = 0;
    int k = arrayOfRectF.length;
    int j = 0;
    float f1 = 0.0F;
    if (j < k)
    {
      RectF localRectF = arrayOfRectF[j];
      float f2 = localRectF.height();
      if (f2 <= this.NWZ)
      {
        this.NXg[i] = ((float)(this.NXd * Math.random()));
        label77:
        if (f2 > this.NXg[i]) {
          break label254;
        }
      }
      label254:
      for (f2 = Math.min(f2 + this.NXa, this.NXd);; f2 = Math.max(f2 - this.NXb, this.NWZ))
      {
        float f3 = this.NXc;
        float f4 = this.NXd / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.NXc;
        float f7 = this.NWY;
        float f8 = this.NXd / 2.0F;
        localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localRectF.right;
        f2 = this.NWY / 2.0F;
        f3 = this.NWY / 2.0F;
        Paint localPaint = this.NTF;
        s.checkNotNull(localPaint);
        paramCanvas.drawRoundRect(localRectF, f2, f3, localPaint);
        j += 1;
        i += 1;
        break;
        if (f2 < this.NXg[i]) {
          break label77;
        }
        this.NXg[i] = this.NWZ;
        break label77;
      }
    }
    if (this.NTJ) {
      postInvalidateDelayed(33L);
    }
    AppMethodBeat.o(279939);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(279932);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.NXd = paramInt2;
    AppMethodBeat.o(279932);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(279917);
    Paint localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(279917);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.NTJ = paramBoolean;
  }
  
  public final void setWaveCount(int paramInt)
  {
    AppMethodBeat.i(279926);
    this.NXe = paramInt;
    paramInt = 0;
    int i = this.NXe;
    RectF[] arrayOfRectF = new RectF[i];
    while (paramInt < i)
    {
      arrayOfRectF[paramInt] = new RectF();
      paramInt += 1;
    }
    this.NXf = arrayOfRectF;
    this.NXg = new float[this.NXe];
    AppMethodBeat.o(279926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.RoundCornerAudioWaveView
 * JD-Core Version:    0.7.0.1
 */