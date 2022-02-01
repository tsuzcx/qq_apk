package com.tencent.mm.ui.tools;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ActionBarSearchView$d
  extends Drawable
{
  private Paint EFQ;
  private RectF Qik;
  private int XNk;
  private float XNl;
  private float XNm;
  private String mText;
  
  ActionBarSearchView$d(ActionBarSearchView paramActionBarSearchView, EditText paramEditText, String paramString)
  {
    AppMethodBeat.i(142997);
    this.XNk = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 2.0F);
    this.EFQ = new Paint(paramEditText.getPaint());
    this.mText = paramString;
    this.EFQ.setColor(MMApplicationContext.getResources().getColor(a.d.brand_text_color));
    this.XNl = this.EFQ.measureText(this.mText);
    paramActionBarSearchView = this.EFQ.getFontMetrics();
    this.XNm = ((float)Math.ceil(paramActionBarSearchView.bottom - paramActionBarSearchView.top));
    float f = this.XNm;
    setBounds(0, 0, (int)(this.XNl + this.XNk * 2 + this.XNk * 2 + 2.0F), (int)f);
    AppMethodBeat.o(142997);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142998);
    Paint.FontMetricsInt localFontMetricsInt = this.EFQ.getFontMetricsInt();
    Rect localRect = getBounds();
    int i = localRect.right;
    i = localRect.left;
    float f = this.Qik.right;
    f = this.Qik.left;
    i = localRect.top;
    int j = (localRect.bottom - localRect.top - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2;
    int k = localFontMetricsInt.top;
    paramCanvas.drawText(this.mText, localRect.left + 2, i + j - k, this.EFQ);
    AppMethodBeat.o(142998);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142999);
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    Paint.FontMetrics localFontMetrics = this.EFQ.getFontMetrics();
    float f1 = this.XNk + paramInt1;
    float f2 = paramInt2;
    this.Qik = new RectF(f1, localFontMetrics.ascent - localFontMetrics.top + f2, paramInt3 - this.XNk, paramInt4);
    invalidateSelf();
    AppMethodBeat.o(142999);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ActionBarSearchView.d
 * JD-Core Version:    0.7.0.1
 */