package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.ah;

public class MaskImageView
  extends TagImageView
{
  private int a = 90;
  private int b = 0;
  private boolean bIU = true;
  private int g = 0;
  private ah oNg = new ah(Looper.getMainLooper());
  private Runnable oNh = new MaskImageView.1(this);
  private int r = 0;
  
  public MaskImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnTouchListener(new MaskImageView.2(this));
    super.setContentDescription(getContext().getResources().getString(i.j.sns_img));
  }
  
  public final boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while ((!isClickable()) && (!isLongClickable()))
    {
      return true;
      paramView.setPressed(true);
      paramView.invalidate();
      this.oNg.removeCallbacks(this.oNh);
      continue;
      this.oNg.post(this.oNh);
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.bIU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.MaskImageView
 * JD-Core Version:    0.7.0.1
 */