package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMSightCircularProgressBar
  extends View
{
  int duration;
  boolean isStart;
  private Context mContext;
  private RectF oNA;
  c oNB;
  MMSightCircularProgressBar.a oNC;
  private int oND;
  float oNx;
  int oNy;
  int oNz;
  private float offset;
  private Paint paint;
  private float strokeWidth;
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55082);
    this.oNx = 0.0F;
    this.oNy = 0;
    this.oNz = 0;
    this.duration = 0;
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.isStart = false;
    this.oND = Color.parseColor("#1AAD19");
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55082);
  }
  
  public MMSightCircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55083);
    this.oNx = 0.0F;
    this.oNy = 0;
    this.oNz = 0;
    this.duration = 0;
    this.strokeWidth = 0.0F;
    this.offset = 0.0F;
    this.isStart = false;
    this.oND = Color.parseColor("#1AAD19");
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(55083);
  }
  
  private void init()
  {
    AppMethodBeat.i(55084);
    float f = this.mContext.getResources().getDimensionPixelSize(2131428580);
    this.strokeWidth = this.mContext.getResources().getDimensionPixelSize(2131428582);
    this.offset = (this.strokeWidth / 2.0F);
    this.oNA = new RectF(this.offset, this.offset, f - this.offset, f - this.offset);
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(this.strokeWidth);
    this.paint.setColor(this.oND);
    this.paint.setAlpha(153);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(55084);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55089);
    paramCanvas.save();
    paramCanvas.translate(this.offset, this.offset);
    paramCanvas.rotate(180.0F, this.oNA.right / 2.0F, this.oNA.bottom / 2.0F);
    paramCanvas.drawArc(this.oNA, 90.0F, 360.0F * (this.oNx / this.oNz), false, this.paint);
    paramCanvas.restore();
    AppMethodBeat.o(55089);
  }
  
  public void setCircularColor(int paramInt)
  {
    AppMethodBeat.i(55088);
    if ((this.paint != null) && (paramInt != 0)) {
      this.paint.setColor(paramInt);
    }
    AppMethodBeat.o(55088);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(55086);
    ab.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", new Object[] { Integer.valueOf(paramInt) });
    this.duration = paramInt;
    AppMethodBeat.o(55086);
  }
  
  public void setInitProgress(int paramInt)
  {
    AppMethodBeat.i(55087);
    ab.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    if (!this.isStart) {
      this.oNy = paramInt;
    }
    AppMethodBeat.o(55087);
  }
  
  public void setMaxProgress(int paramInt)
  {
    AppMethodBeat.i(55085);
    ab.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", new Object[] { Integer.valueOf(paramInt) });
    this.oNz = paramInt;
    AppMethodBeat.o(55085);
  }
  
  public void setProgressCallback(MMSightCircularProgressBar.a parama)
  {
    this.oNC = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar
 * JD-Core Version:    0.7.0.1
 */