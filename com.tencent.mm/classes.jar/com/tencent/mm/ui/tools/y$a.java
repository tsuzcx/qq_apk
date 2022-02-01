package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;

public final class y$a
  extends Drawable
{
  private static int afDy;
  private Paint KyZ;
  private RectF Xao;
  private float afDA;
  private float afDz;
  private float afLL;
  private float afLM;
  private String mText;
  private Paint mzW;
  
  public y$a(Context paramContext, String paramString, Paint paramPaint)
  {
    AppMethodBeat.i(143284);
    this.mzW = new Paint(1);
    this.mzW.setColor(-7829368);
    this.KyZ = paramPaint;
    afDy = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 2.0F);
    this.afLL = afDy;
    this.afLM = afDy;
    this.mText = paramString;
    this.afDz = this.KyZ.measureText(this.mText);
    paramContext = this.KyZ.getFontMetrics();
    this.afDA = ((float)Math.ceil(paramContext.bottom - paramContext.top));
    setBounds(0, 0, (int)(this.afDz + afDy * 2 + afDy * 2), (int)this.afDA);
    Log.i("MicroMsg.TextDrawable", "setText(%s).", new Object[] { paramString });
    AppMethodBeat.o(143284);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143285);
    paramCanvas.drawRoundRect(this.Xao, this.afLL, this.afLM, this.mzW);
    Rect localRect = getBounds();
    int i = (int)((localRect.right - localRect.left - (this.Xao.right - this.Xao.left) + afDy * 2) / 2.0F);
    Paint.FontMetricsInt localFontMetricsInt = this.KyZ.getFontMetricsInt();
    int j = localRect.top;
    int k = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
    int m = localFontMetricsInt.top;
    paramCanvas.drawText(this.mText, i, k + j - m, this.KyZ);
    AppMethodBeat.o(143285);
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(143288);
    if (this.mzW.getAlpha() < 255)
    {
      AppMethodBeat.o(143288);
      return -3;
    }
    AppMethodBeat.o(143288);
    return -1;
  }
  
  public final void setAlpha(int paramInt)
  {
    AppMethodBeat.i(143286);
    if (paramInt != this.mzW.getAlpha())
    {
      this.mzW.setAlpha(paramInt);
      invalidateSelf();
    }
    AppMethodBeat.o(143286);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143289);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Paint.FontMetrics localFontMetrics = this.KyZ.getFontMetrics();
    float f1 = afDy + paramInt1;
    float f2 = paramInt2;
    this.Xao = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - afDy, paramInt4);
    invalidateSelf();
    AppMethodBeat.o(143289);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(143287);
    this.mzW.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(143287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.y.a
 * JD-Core Version:    0.7.0.1
 */