package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public class PressImageView
  extends ImageView
{
  private MMHandler Eok;
  private Runnable Eol;
  private int a;
  private int b;
  private int g;
  private int r;
  
  public PressImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143213);
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.Eok = new MMHandler();
    this.Eol = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143211);
        PressImageView.this.setPressed(false);
        PressImageView.this.invalidate();
        AppMethodBeat.o(143211);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143212);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!PressImageView.this.isClickable()) && (!PressImageView.this.isLongClickable()))
        {
          AppMethodBeat.o(143212);
          return true;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          PressImageView.b(PressImageView.this).removeCallbacks(PressImageView.a(PressImageView.this));
          continue;
          PressImageView.b(PressImageView.this).post(PressImageView.a(PressImageView.this));
        }
        AppMethodBeat.o(143212);
        return false;
      }
    });
    AppMethodBeat.o(143213);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143214);
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
    AppMethodBeat.o(143214);
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(143215);
    Assert.assertTrue(false);
    AppMethodBeat.o(143215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.PressImageView
 * JD-Core Version:    0.7.0.1
 */