package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMCheckBox
  extends CheckBox
{
  private Drawable UUW;
  private int UUX;
  
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
    AppMethodBeat.i(293450);
    super.drawableStateChanged();
    if (this.UUW != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.UUW.setState(arrayOfInt);
      invalidate();
    }
    AppMethodBeat.o(293450);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(293458);
    super.jumpDrawablesToCurrentState();
    if ((Build.VERSION.SDK_INT >= 11) && (this.UUW != null)) {
      this.UUW.jumpToCurrentState();
    }
    AppMethodBeat.o(293458);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(293466);
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.UUW;
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
      AppMethodBeat.o(293466);
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
    AppMethodBeat.i(293440);
    if ((paramInt != 0) && (paramInt == this.UUX))
    {
      AppMethodBeat.o(293440);
      return;
    }
    this.UUX = paramInt;
    Drawable localDrawable = null;
    if (this.UUX != 0) {
      localDrawable = getResources().getDrawable(this.UUX);
    }
    setButtonDrawable(localDrawable);
    AppMethodBeat.o(293440);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    this.UUW = paramDrawable;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(293453);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.UUW))
    {
      AppMethodBeat.o(293453);
      return true;
    }
    AppMethodBeat.o(293453);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.MMCheckBox
 * JD-Core Version:    0.7.0.1
 */