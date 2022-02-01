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

public final class z$a
  extends Drawable
{
  private static int XNk;
  private Paint EFQ;
  private RectF Qik;
  private float XNl;
  private float XNm;
  private float XVw;
  private float XVx;
  private Paint jZS;
  private String mText;
  
  public z$a(Context paramContext, String paramString, Paint paramPaint)
  {
    AppMethodBeat.i(143284);
    this.jZS = new Paint(1);
    this.jZS.setColor(-7829368);
    this.EFQ = paramPaint;
    XNk = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 2.0F);
    this.XVw = XNk;
    this.XVx = XNk;
    this.mText = paramString;
    this.XNl = this.EFQ.measureText(this.mText);
    paramContext = this.EFQ.getFontMetrics();
    this.XNm = ((float)Math.ceil(paramContext.bottom - paramContext.top));
    setBounds(0, 0, (int)(this.XNl + XNk * 2 + XNk * 2), (int)this.XNm);
    Log.i("MicroMsg.TextDrawable", "setText(%s).", new Object[] { paramString });
    AppMethodBeat.o(143284);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143285);
    paramCanvas.drawRoundRect(this.Qik, this.XVw, this.XVx, this.jZS);
    Rect localRect = getBounds();
    int i = (int)((localRect.right - localRect.left - (this.Qik.right - this.Qik.left) + XNk * 2) / 2.0F);
    Paint.FontMetricsInt localFontMetricsInt = this.EFQ.getFontMetricsInt();
    int j = localRect.top;
    int k = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
    int m = localFontMetricsInt.top;
    paramCanvas.drawText(this.mText, i, k + j - m, this.EFQ);
    AppMethodBeat.o(143285);
  }
  
  public final int getOpacity()
  {
    AppMethodBeat.i(143288);
    if (this.jZS.getAlpha() < 255)
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
    if (paramInt != this.jZS.getAlpha())
    {
      this.jZS.setAlpha(paramInt);
      invalidateSelf();
    }
    AppMethodBeat.o(143286);
  }
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143289);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Paint.FontMetrics localFontMetrics = this.EFQ.getFontMetrics();
    float f1 = XNk + paramInt1;
    float f2 = paramInt2;
    this.Qik = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - XNk, paramInt4);
    invalidateSelf();
    AppMethodBeat.o(143289);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(143287);
    this.jZS.setColorFilter(paramColorFilter);
    invalidateSelf();
    AppMethodBeat.o(143287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.z.a
 * JD-Core Version:    0.7.0.1
 */