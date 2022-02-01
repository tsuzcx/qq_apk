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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ap;

public class MaskImageButton
  extends ImageView
{
  private RectF KJS;
  private int KJT;
  private int KJU;
  private int a;
  private int b;
  private int g;
  public Object hgD;
  private Paint paint;
  private int r;
  private ap zOG;
  private Runnable zOH;
  
  public MaskImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143201);
    this.KJS = new RectF();
    this.paint = null;
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.KJT = 0;
    this.KJU = 0;
    this.paint = new Paint();
    this.paint.setColor(Color.argb(this.a, this.r, this.g, this.b));
    this.zOG = new ap(Looper.getMainLooper());
    this.zOH = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143199);
        MaskImageButton.this.setPressed(false);
        MaskImageButton.this.invalidate();
        AppMethodBeat.o(143199);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143200);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/tools/MaskImageButton$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        case 2: 
        default: 
          if ((MaskImageButton.this.isClickable()) || (MaskImageButton.this.isLongClickable())) {
            break;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          a.a(bool, this, "com/tencent/mm/ui/tools/MaskImageButton$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143200);
          return bool;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          MaskImageButton.b(MaskImageButton.this).removeCallbacks(MaskImageButton.a(MaskImageButton.this));
          break;
          MaskImageButton.b(MaskImageButton.this).post(MaskImageButton.a(MaskImageButton.this));
          break;
        }
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
      this.KJS.set(getPaddingLeft() + 0, getPaddingTop() + 0, this.KJT - getPaddingRight(), this.KJU - getPaddingBottom());
      paramCanvas.drawRoundRect(this.KJS, getMeasuredHeight() / 10, getMeasuredHeight() / 10, this.paint);
    }
    AppMethodBeat.o(143202);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143203);
    super.onMeasure(paramInt1, paramInt2);
    this.KJT = getMeasuredWidth();
    this.KJU = getMeasuredHeight();
    AppMethodBeat.o(143203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MaskImageButton
 * JD-Core Version:    0.7.0.1
 */