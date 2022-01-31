package com.tencent.mm.plugin.voip.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class MMCheckBox
  extends CheckBox
{
  private Drawable pWr;
  private int pWs;
  
  public MMCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.pWr != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.pWr.setState(arrayOfInt);
      invalidate();
    }
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if ((Build.VERSION.SDK_INT >= 11) && (this.pWr != null)) {
      this.pWr.jumpToCurrentState();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.pWr;
    int i;
    int k;
    int m;
    if (localDrawable != null)
    {
      i = getGravity();
      int n = getGravity();
      k = localDrawable.getIntrinsicHeight();
      m = localDrawable.getIntrinsicWidth();
      switch (i & 0x70)
      {
      default: 
        i = 0;
        switch (n & 0x7)
        {
        }
        break;
      }
    }
    for (;;)
    {
      localDrawable.setBounds(j, i, j + m, k + i);
      localDrawable.draw(paramCanvas);
      return;
      i = getHeight() - k;
      break;
      i = (getHeight() - k) / 2;
      break;
      j = getWidth() - m;
      continue;
      j = (getWidth() - m) / 2;
    }
  }
  
  public void setButtonDrawable(int paramInt)
  {
    if ((paramInt != 0) && (paramInt == this.pWs)) {
      return;
    }
    this.pWs = paramInt;
    Drawable localDrawable = null;
    if (this.pWs != 0) {
      localDrawable = getResources().getDrawable(this.pWs);
    }
    setButtonDrawable(localDrawable);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    this.pWr = paramDrawable;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.pWr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMCheckBox
 * JD-Core Version:    0.7.0.1
 */