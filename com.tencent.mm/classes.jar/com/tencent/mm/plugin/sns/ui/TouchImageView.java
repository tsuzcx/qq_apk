package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class TouchImageView
  extends ImageView
{
  private RectF RGh;
  MMHandler Rba;
  Runnable Rbb;
  private int a;
  private int b;
  private boolean enable;
  private int g;
  private int r;
  private Paint yxf;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(99770);
    this.RGh = new RectF();
    this.yxf = new Paint();
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    init();
    AppMethodBeat.o(99770);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99771);
    this.RGh = new RectF();
    this.yxf = new Paint();
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    init();
    AppMethodBeat.o(99771);
  }
  
  private void init()
  {
    AppMethodBeat.i(99772);
    this.Rba = new MMHandler();
    this.Rbb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99768);
        TouchImageView.this.setPressed(false);
        TouchImageView.this.invalidate();
        AppMethodBeat.o(99768);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(99769);
        if (!TouchImageView.a(TouchImageView.this))
        {
          AppMethodBeat.o(99769);
          return false;
        }
        TouchImageView localTouchImageView = TouchImageView.this;
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!localTouchImageView.isClickable()) && (!localTouchImageView.isLongClickable()))
        {
          AppMethodBeat.o(99769);
          return true;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          localTouchImageView.Rba.removeCallbacks(localTouchImageView.Rbb);
          continue;
          localTouchImageView.Rba.post(localTouchImageView.Rbb);
        }
        AppMethodBeat.o(99769);
        return false;
      }
    });
    AppMethodBeat.o(99772);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(99775);
    super.onAttachedToWindow();
    Log.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    AppMethodBeat.o(99775);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(99776);
    super.onDetachedFromWindow();
    Log.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    AppMethodBeat.o(99776);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(99773);
    super.onDraw(paramCanvas);
    if (isPressed())
    {
      this.RGh.left = getPaddingLeft();
      this.RGh.top = getPaddingTop();
      this.RGh.right = (getWidth() - getPaddingRight());
      this.RGh.bottom = (getHeight() - getPaddingBottom());
      this.yxf.setARGB(this.a, this.r, this.g, this.b);
      paramCanvas.drawRoundRect(this.RGh, getWidth() / 10, getHeight() / 10, this.yxf);
    }
    AppMethodBeat.o(99773);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(99774);
    AppMethodBeat.o(99774);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TouchImageView
 * JD-Core Version:    0.7.0.1
 */