package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import junit.framework.Assert;

public class AsyncMaskImageView
  extends ImageView
{
  private int a;
  private int b;
  private boolean enable;
  private int g;
  private int r;
  ak rER;
  Runnable rES;
  
  public AsyncMaskImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38131);
    this.a = 90;
    this.r = 0;
    this.g = 0;
    this.b = 0;
    this.enable = true;
    this.rER = new ak();
    this.rES = new AsyncMaskImageView.1(this);
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(38130);
        if (!AsyncMaskImageView.a(AsyncMaskImageView.this))
        {
          AppMethodBeat.o(38130);
          return false;
        }
        AsyncMaskImageView localAsyncMaskImageView = AsyncMaskImageView.this;
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        while ((!localAsyncMaskImageView.isClickable()) && (!localAsyncMaskImageView.isLongClickable()))
        {
          AppMethodBeat.o(38130);
          return true;
          paramAnonymousView.setPressed(true);
          paramAnonymousView.invalidate();
          localAsyncMaskImageView.rER.removeCallbacks(localAsyncMaskImageView.rES);
          continue;
          localAsyncMaskImageView.rER.post(localAsyncMaskImageView.rES);
        }
        AppMethodBeat.o(38130);
        return false;
      }
    });
    AppMethodBeat.o(38131);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38134);
    super.onAttachedToWindow();
    ab.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    AppMethodBeat.o(38134);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38135);
    super.onDetachedFromWindow();
    ab.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    AppMethodBeat.o(38135);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38132);
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
    AppMethodBeat.o(38132);
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(38133);
    Assert.assertTrue(false);
    AppMethodBeat.o(38133);
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