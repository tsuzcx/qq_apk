package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

public class MaskImageButton
  extends ImageView
{
  private RectF Awn;
  private int Awo;
  private int Awp;
  private int a;
  private int b;
  public Object eQq;
  private int g;
  private Paint paint;
  private int r;
  private ak rER;
  private Runnable rES;
  
  public MaskImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107743);
    this.Awn = new RectF();
    this.paint = null;
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.Awo = 0;
    this.Awp = 0;
    this.paint = new Paint();
    this.paint.setColor(Color.argb(this.a, this.r, this.g, this.b));
    this.rER = new ak(Looper.getMainLooper());
    this.rES = new MaskImageButton.1(this);
    super.setOnTouchListener(new MaskImageButton.2(this));
    AppMethodBeat.o(107743);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107744);
    super.onDraw(paramCanvas);
    if (isPressed())
    {
      this.Awn.set(getPaddingLeft() + 0, getPaddingTop() + 0, this.Awo - getPaddingRight(), this.Awp - getPaddingBottom());
      paramCanvas.drawRoundRect(this.Awn, getMeasuredHeight() / 10, getMeasuredHeight() / 10, this.paint);
    }
    AppMethodBeat.o(107744);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107745);
    super.onMeasure(paramInt1, paramInt2);
    this.Awo = getMeasuredWidth();
    this.Awp = getMeasuredHeight();
    AppMethodBeat.o(107745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MaskImageButton
 * JD-Core Version:    0.7.0.1
 */