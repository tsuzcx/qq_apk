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
  private Drawable zpA;
  private int zpB;
  
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
    AppMethodBeat.i(115298);
    super.drawableStateChanged();
    if (this.zpA != null)
    {
      int[] arrayOfInt = getDrawableState();
      this.zpA.setState(arrayOfInt);
      invalidate();
    }
    AppMethodBeat.o(115298);
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(115300);
    super.jumpDrawablesToCurrentState();
    if ((Build.VERSION.SDK_INT >= 11) && (this.zpA != null)) {
      this.zpA.jumpToCurrentState();
    }
    AppMethodBeat.o(115300);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    AppMethodBeat.i(115301);
    super.onDraw(paramCanvas);
    Drawable localDrawable = this.zpA;
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
      AppMethodBeat.o(115301);
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
    AppMethodBeat.i(115297);
    if ((paramInt != 0) && (paramInt == this.zpB))
    {
      AppMethodBeat.o(115297);
      return;
    }
    this.zpB = paramInt;
    Drawable localDrawable = null;
    if (this.zpB != 0) {
      localDrawable = getResources().getDrawable(this.zpB);
    }
    setButtonDrawable(localDrawable);
    AppMethodBeat.o(115297);
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    this.zpA = paramDrawable;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(115299);
    if ((super.verifyDrawable(paramDrawable)) || (paramDrawable == this.zpA))
    {
      AppMethodBeat.o(115299);
      return true;
    }
    AppMethodBeat.o(115299);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMCheckBox
 * JD-Core Version:    0.7.0.1
 */