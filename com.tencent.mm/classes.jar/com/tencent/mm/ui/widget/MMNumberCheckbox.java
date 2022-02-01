package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMNumberCheckbox
  extends AppCompatCheckBox
{
  private int bow;
  
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
    return this.bow;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(143377);
    super.setChecked(paramBoolean);
    if ((paramBoolean) && (this.bow > 0) && (!String.valueOf(this.bow).contentEquals(getText()))) {
      setText(String.valueOf(this.bow));
    }
    if (!paramBoolean)
    {
      this.bow = 0;
      setText("");
    }
    AppMethodBeat.o(143377);
  }
  
  public void setCheckedNumber(int paramInt)
  {
    AppMethodBeat.i(143378);
    if ((paramInt > 0) && (paramInt != this.bow))
    {
      this.bow = paramInt;
      setText(String.valueOf(paramInt));
      setChecked(true);
    }
    AppMethodBeat.o(143378);
  }
  
  public void setNumber(int paramInt)
  {
    if (this.bow > 0) {
      this.bow = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMNumberCheckbox
 * JD-Core Version:    0.7.0.1
 */