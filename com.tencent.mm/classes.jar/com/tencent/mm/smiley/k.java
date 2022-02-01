package com.tencent.mm.smiley;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/EmojiSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "drawable", "Landroid/graphics/drawable/Drawable;", "isWxEmoji", "", "start", "", "end", "(Landroid/graphics/drawable/Drawable;ZII)V", "alpha", "drawRect", "Landroid/graphics/RectF;", "getEnd", "()I", "isSetAlpha", "()Z", "getStart", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getDrawRect", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "setAlpha", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  public static final k.a acyi;
  private static boolean acyl;
  public final RectF NTS;
  public final boolean acyj;
  private boolean acyk;
  private int alpha;
  public final int end;
  public final int start;
  
  static
  {
    AppMethodBeat.i(242834);
    acyi = new k.a((byte)0);
    AppMethodBeat.o(242834);
  }
  
  public k(Drawable paramDrawable, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramDrawable, 0);
    AppMethodBeat.i(242833);
    this.acyj = paramBoolean;
    this.start = paramInt1;
    this.end = paramInt2;
    this.NTS = new RectF();
    this.alpha = 255;
    AppMethodBeat.o(242833);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(242842);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    paramCharSequence = getDrawable();
    paramCanvas.save();
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = localFontMetricsInt.descent;
    paramInt2 = localFontMetricsInt.ascent;
    float f = localFontMetricsInt.descent + paramInt4 - (paramInt1 - paramInt2) / 2 - (paramCharSequence.getBounds().bottom - paramCharSequence.getBounds().top) / 2.0F;
    paramCanvas.translate(paramFloat, f);
    this.NTS.set(paramFloat, f, paramCharSequence.getBounds().width() + paramFloat, paramCharSequence.getBounds().height() + f);
    paramInt2 = paramCharSequence.getAlpha();
    if (this.acyk) {}
    for (paramInt1 = this.alpha;; paramInt1 = paramPaint.getAlpha())
    {
      if ((paramInt1 == 0) && (paramInt2 != paramInt1)) {
        paramCharSequence.setAlpha(paramInt1);
      }
      paramCharSequence.draw(paramCanvas);
      paramCharSequence.setAlpha(paramInt2);
      paramCanvas.restore();
      if (acyl)
      {
        paramCanvas.save();
        paramInt1 = paramPaint.getColor();
        paramCharSequence = paramPaint.getStyle();
        paramPaint.setColor(-65536);
        paramPaint.setStyle(Paint.Style.STROKE);
        paramCanvas.drawRect(this.NTS, paramPaint);
        paramPaint.setColor(paramInt1);
        paramPaint.setStyle(paramCharSequence);
      }
      AppMethodBeat.o(242842);
      return;
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(242838);
    s.u(paramPaint, "paint");
    paramCharSequence = getDrawable();
    Rect localRect = paramCharSequence.getBounds();
    s.s(localRect, "drawable.bounds");
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt1 = localRect.width();
    if (paramPaint != null)
    {
      paramInt1 = Math.abs(paramPaint.descent - paramPaint.ascent);
      paramCharSequence.setBounds(0, 0, paramInt1, paramInt1);
      paramInt2 = paramCharSequence.getBounds().width();
      paramInt1 = paramInt2;
      if (paramFontMetricsInt != null)
      {
        paramFontMetricsInt.ascent = paramPaint.ascent;
        paramFontMetricsInt.descent = paramPaint.descent;
        paramFontMetricsInt.top = paramPaint.top;
        paramFontMetricsInt.bottom = paramPaint.bottom;
        paramInt1 = paramInt2;
      }
    }
    AppMethodBeat.o(242838);
    return paramInt1;
  }
  
  public final void setAlpha(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(242836);
    this.alpha = Math.round(255.0F * paramFloat);
    int i;
    if (paramFloat == 1.0F)
    {
      i = 1;
      if (i != 0) {
        break label46;
      }
    }
    for (;;)
    {
      this.acyk = bool;
      AppMethodBeat.o(242836);
      return;
      i = 0;
      break;
      label46:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.smiley.k
 * JD-Core Version:    0.7.0.1
 */