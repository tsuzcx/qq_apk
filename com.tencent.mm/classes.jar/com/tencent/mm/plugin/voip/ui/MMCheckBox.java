package com.tencent.mm.plugin.voip.ui;

import android.annotation.TargetApi;
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
  private Drawable tBU;
  private int tBV;
  
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
    AppMethodBeat.i(4776);
    super.drawableStateChanged();
    if (this.tBU != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.tBU.setState(arrayOfInt);
      invalidate();
    }
    AppMethodBeat.o(4776);
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(4778);
    super.jumpDrawablesToCurrentState();
    if ((Build.VERSION.SDK_INT >= 11) && (this.tBU != null)) {
      this.tBU.jumpToCurrentState();
    }
    AppMethodBeat.o(4778);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(4779);
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.tBU;
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
      AppMethodBeat.o(4779);
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
    AppMethodBeat.i(4775);
    if ((paramInt != 0) && (paramInt == this.tBV))
    {
      AppMethodBeat.o(4775);
      return;
    }
    this.tBV = paramInt;
    Drawable localDrawable = null;
    if (this.tBV != 0) {
      localDrawable = getResources().getDrawable(this.tBV);
    }
    setButtonDrawable(localDrawable);
    AppMethodBeat.o(4775);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    this.tBU = paramDrawable;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(4777);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.tBU))
    {
      AppMethodBeat.o(4777);
      return true;
    }
    AppMethodBeat.o(4777);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMCheckBox
 * JD-Core Version:    0.7.0.1
 */