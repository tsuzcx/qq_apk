package com.tencent.mm.ui.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMNumberCheckbox
  extends AppCompatCheckBox
{
  private int EB;
  
  public MMNumberCheckbox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMNumberCheckbox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getNumber()
  {
    return this.EB;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(143377);
    super.setChecked(paramBoolean);
    if ((paramBoolean) && (this.EB > 0) && (!String.valueOf(this.EB).contentEquals(getText()))) {
      setText(String.valueOf(this.EB));
    }
    if (!paramBoolean)
    {
      this.EB = 0;
      setText("");
    }
    AppMethodBeat.o(143377);
  }
  
  public void setCheckedNumber(int paramInt)
  {
    AppMethodBeat.i(143378);
    if ((paramInt > 0) && (paramInt != this.EB))
    {
      this.EB = paramInt;
      setText(String.valueOf(paramInt));
      setChecked(true);
    }
    AppMethodBeat.o(143378);
  }
  
  public void setNumber(int paramInt)
  {
    if (this.EB > 0) {
      this.EB = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNumberCheckbox
 * JD-Core Version:    0.7.0.1
 */