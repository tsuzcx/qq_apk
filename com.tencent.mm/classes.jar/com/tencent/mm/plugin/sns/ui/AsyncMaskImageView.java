package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public class AsyncMaskImageView
  extends ImageView
{
  private int a = 90;
  private int b = 0;
  private boolean bIU = true;
  private int g = 0;
  ah oNg = new ah();
  Runnable oNh = new AsyncMaskImageView.1(this);
  private int r = 0;
  
  public AsyncMaskImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (!AsyncMaskImageView.a(AsyncMaskImageView.this)) {}
        for (;;)
        {
          return false;
          AsyncMaskImageView localAsyncMaskImageView = AsyncMaskImageView.this;
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          while ((!localAsyncMaskImageView.isClickable()) && (!localAsyncMaskImageView.isLongClickable()))
          {
            return true;
            paramAnonymousView.setPressed(true);
            paramAnonymousView.invalidate();
            localAsyncMaskImageView.oNg.removeCallbacks(localAsyncMaskImageView.oNh);
            continue;
            localAsyncMaskImageView.oNg.post(localAsyncMaskImageView.oNh);
          }
        }
      }
    });
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    y.d("MicroMsg.MaskImageView", "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
  }
  
  @Deprecated
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    Assert.assertTrue(false);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.bIU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AsyncMaskImageView
 * JD-Core Version:    0.7.0.1
 */