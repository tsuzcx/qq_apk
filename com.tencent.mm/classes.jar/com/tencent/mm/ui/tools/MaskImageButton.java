package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MaskImageButton
  extends ImageView
{
  private MMHandler Rba;
  private Runnable Rbb;
  private int a;
  private RectF afJB;
  private int afJC;
  private int afJD;
  private int b;
  private int g;
  public Object nsy;
  private Paint paint;
  private int r;
  
  public MaskImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143201);
    this.afJB = new RectF();
    this.paint = null;
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.afJC = 0;
    this.afJD = 0;
    this.paint = new Paint();
    this.paint.setColor(Color.argb(this.a, this.r, this.g, this.b));
    this.Rba = new MMHandler(Looper.getMainLooper());
    this.Rbb = new MaskImageButton.1(this);
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143200);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!MaskImageButton.this.isClickable()) && (!MaskImageButton.this.isLongClickable()))
        {
          AppMethodBeat.o(143200);
          return true;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          MaskImageButton.b(MaskImageButton.this).removeCallbacks(MaskImageButton.a(MaskImageButton.this));
          continue;
          MaskImageButton.b(MaskImageButton.this).post(MaskImageButton.a(MaskImageButton.this));
        }
        AppMethodBeat.o(143200);
        return false;
      }
    });
    AppMethodBeat.o(143201);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143202);
    super.onDraw(paramCanvas);
    if (isPressed())
    {
      this.afJB.set(getPaddingLeft() + 0, getPaddingTop() + 0, this.afJC - getPaddingRight(), this.afJD - getPaddingBottom());
      paramCanvas.drawRoundRect(this.afJB, getMeasuredHeight() / 10, getMeasuredHeight() / 10, this.paint);
    }
    AppMethodBeat.o(143202);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143203);
    super.onMeasure(paramInt1, paramInt2);
    this.afJC = getMeasuredWidth();
    this.afJD = getMeasuredHeight();
    AppMethodBeat.o(143203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MaskImageButton
 * JD-Core Version:    0.7.0.1
 */