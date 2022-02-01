package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mBgColor", "", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radius", "", "rectF", "Landroid/graphics/RectF;", "drawBg", "", "canvas", "Landroid/graphics/Canvas;", "onDraw", "setTextBackground", "color", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PhotoTextView
  extends AppCompatTextView
{
  private final RectF avO;
  private int mBgColor;
  private final Paint paint;
  private final Path path;
  private final float radius;
  
  public PhotoTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(279904);
    this.path = new Path();
    this.paint = new Paint();
    this.avO = new RectF();
    this.radius = a.fromDPToPix(paramContext, 12);
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setAntiAlias(true);
    AppMethodBeat.o(279904);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(279923);
    s.u(paramCanvas, "canvas");
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
        this.path.reset();
        if (getLineCount() != 0)
        {
          f1 = getLayout().getLineBottom(getLineCount() - 1) + getPaddingTop() + getPaddingBottom();
          if (getLineCount() != 1) {
            break label212;
          }
          f2 = getLayout().getLineWidth(0);
          f3 = getPaddingLeft();
          f4 = getPaddingRight();
          this.avO.set(0.0F, 0.0F, f2 + f3 + f4, f1);
          this.path.addRoundRect(this.avO, this.radius, this.radius, Path.Direction.CW);
        }
      }
    }
    for (;;)
    {
      this.path.close();
      paramCanvas.drawPath(this.path, this.paint);
      super.onDraw(paramCanvas);
      AppMethodBeat.o(279923);
      return;
      label206:
      i = 0;
      break;
      label212:
      f3 = getMeasuredWidth();
      float f5 = getLayout().getLineWidth(getLineCount() - 1);
      if (f5 >= f3 - f2 - getPaddingLeft() - getPaddingRight())
      {
        this.avO.set(0.0F, 0.0F, f3, f1);
        this.path.addRoundRect(this.avO, this.radius, this.radius, Path.Direction.CW);
      }
      else
      {
        f4 = getLayout().getLineTop(getLineCount() - 1) + getPaddingTop() + getPaddingBottom();
        f5 = f5 + getPaddingRight() + getPaddingLeft();
        this.path.moveTo(0.0F, this.radius);
        this.avO.set(0.0F, 0.0F, f2, f2);
        this.path.arcTo(this.avO, 180.0F, 90.0F);
        this.path.lineTo(f3 - f2, 0.0F);
        this.avO.set(f3 - f2, 0.0F, f3, f2);
        this.path.arcTo(this.avO, 270.0F, 90.0F);
        this.path.lineTo(f3, f4 - this.radius);
        this.avO.set(f3 - f2, f4 - f2, f3, f4);
        this.path.arcTo(this.avO, 0.0F, 90.0F);
        this.path.lineTo(this.radius + f5, f4);
        this.avO.set(f5, f4, f5 + f2, f4 + f2);
        this.path.arcTo(this.avO, 270.0F, -90.0F);
        this.path.lineTo(f5, f1 - this.radius);
        this.avO.set(f5 - f2, f1 - f2, f5, f1);
        this.path.arcTo(this.avO, 0.0F, 90.0F);
        this.path.lineTo(this.radius, f1);
        this.avO.set(0.0F, f1 - f2, f2, f1);
        this.path.arcTo(this.avO, 90.0F, 90.0F);
        this.path.lineTo(0.0F, this.radius);
      }
    }
  }
  
  public final void setTextBackground(int paramInt)
  {
    AppMethodBeat.i(279910);
    this.mBgColor = paramInt;
    invalidate();
    AppMethodBeat.o(279910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.PhotoTextView
 * JD-Core Version:    0.7.0.1
 */