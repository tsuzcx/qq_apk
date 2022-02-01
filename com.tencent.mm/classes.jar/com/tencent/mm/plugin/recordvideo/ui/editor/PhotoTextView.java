package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "Landroid/support/v7/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBgColor", "", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radius", "", "rectF", "Landroid/graphics/RectF;", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "setTextBackground", "color", "plugin-recordvideo_release"})
public final class PhotoTextView
  extends AppCompatTextView
{
  private final RectF hM;
  private final Path lP;
  private int mBgColor;
  private final Paint paint;
  private final float radius;
  
  public PhotoTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(206904);
    this.lP = new Path();
    this.paint = new Paint();
    this.hM = new RectF();
    this.radius = a.fromDPToPix(paramContext, 12);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(206904);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206903);
    p.h(paramCanvas, "canvas");
    int i;
    float f2;
    float f1;
    float f3;
    float f4;
    if (this.mBgColor != 0)
    {
      CharSequence localCharSequence = getText();
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label206;
      }
      i = 1;
      if (i == 0)
      {
        this.paint.setColor(this.mBgColor);
        f2 = this.radius * 2.0F;
        this.lP.reset();
        if (getLineCount() != 0)
        {
          f1 = getLayout().getLineBottom(getLineCount() - 1) + getPaddingTop() + getPaddingBottom();
          if (getLineCount() != 1) {
            break label212;
          }
          f2 = getLayout().getLineWidth(0);
          f3 = getPaddingLeft();
          f4 = getPaddingRight();
          this.hM.set(0.0F, 0.0F, f2 + f3 + f4, f1);
          this.lP.addRoundRect(this.hM, this.radius, this.radius, Path.Direction.CW);
        }
      }
    }
    for (;;)
    {
      this.lP.close();
      paramCanvas.drawPath(this.lP, this.paint);
      super.onDraw(paramCanvas);
      AppMethodBeat.o(206903);
      return;
      label206:
      i = 0;
      break;
      label212:
      f3 = getMeasuredWidth();
      float f5 = getLayout().getLineWidth(getLineCount() - 1);
      if (f5 >= f3 - f2 - getPaddingLeft() - getPaddingRight())
      {
        this.hM.set(0.0F, 0.0F, f3, f1);
        this.lP.addRoundRect(this.hM, this.radius, this.radius, Path.Direction.CW);
      }
      else
      {
        f4 = getLayout().getLineTop(getLineCount() - 1) + getPaddingTop() + getPaddingBottom();
        f5 = f5 + getPaddingRight() + getPaddingLeft();
        this.lP.moveTo(0.0F, this.radius);
        this.hM.set(0.0F, 0.0F, f2, f2);
        this.lP.arcTo(this.hM, 180.0F, 90.0F);
        this.lP.lineTo(f3 - f2, 0.0F);
        this.hM.set(f3 - f2, 0.0F, f3, f2);
        this.lP.arcTo(this.hM, 270.0F, 90.0F);
        this.lP.lineTo(f3, f4 - this.radius);
        this.hM.set(f3 - f2, f4 - f2, f3, f4);
        this.lP.arcTo(this.hM, 0.0F, 90.0F);
        this.lP.lineTo(this.radius + f5, f4);
        this.hM.set(f5, f4, f5 + f2, f4 + f2);
        this.lP.arcTo(this.hM, 270.0F, -90.0F);
        this.lP.lineTo(f5, f1 - this.radius);
        this.hM.set(f5 - f2, f1 - f2, f5, f1);
        this.lP.arcTo(this.hM, 0.0F, 90.0F);
        this.lP.lineTo(this.radius, f1);
        this.hM.set(0.0F, f1 - f2, f2, f1);
        this.lP.arcTo(this.hM, 90.0F, 90.0F);
        this.lP.lineTo(0.0F, this.radius);
      }
    }
  }
  
  public final void setTextBackground(int paramInt)
  {
    AppMethodBeat.i(206902);
    this.mBgColor = paramInt;
    invalidate();
    AppMethodBeat.o(206902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.PhotoTextView
 * JD-Core Version:    0.7.0.1
 */