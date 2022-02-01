package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import junit.framework.Assert;

public class AsyncMaskImageView
  extends ImageView
{
  private int a;
  private int b;
  private boolean enable;
  private int g;
  private int r;
  ap xkC;
  Runnable xkD;
  
  public AsyncMaskImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97755);
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    this.xkC = new ap();
    this.xkD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(97753);
        AsyncMaskImageView.this.setPressed(false);
        AsyncMaskImageView.this.invalidate();
        AppMethodBeat.o(97753);
      }
    };
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(97754);
        if (!AsyncMaskImageView.a(AsyncMaskImageView.this))
        {
          AppMethodBeat.o(97754);
          return false;
        }
        AsyncMaskImageView localAsyncMaskImageView = AsyncMaskImageView.this;
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!localAsyncMaskImageView.isClickable()) && (!localAsyncMaskImageView.isLongClickable()))
        {
          AppMethodBeat.o(97754);
          return true;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          localAsyncMaskImageView.xkC.removeCallbacks(localAsyncMaskImageView.xkD);
          continue;
          localAsyncMaskImageView.xkC.post(localAsyncMaskImageView.xkD);
        }
        AppMethodBeat.o(97754);
        return false;
      }
    });
    AppMethodBeat.o(97755);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(97758);
    super.onAttachedToWindow();
    ad.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    AppMethodBeat.o(97758);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97759);
    super.onDetachedFromWindow();
    ad.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    AppMethodBeat.o(97759);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(97756);
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
    AppMethodBeat.o(97756);
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(97757);
    Assert.assertTrue(false);
    AppMethodBeat.o(97757);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncMaskImageView
 * JD-Core Version:    0.7.0.1
 */