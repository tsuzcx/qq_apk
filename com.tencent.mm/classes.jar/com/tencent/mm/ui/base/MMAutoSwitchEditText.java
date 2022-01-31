package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMAutoSwitchEditText
  extends EditText
{
  MMAutoSwitchEditText.a ziN;
  
  public MMAutoSwitchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106497);
    this.ziN = new MMAutoSwitchEditText.a(this);
    addTextChangedListener(this.ziN);
    setOnKeyListener(this.ziN);
    AppMethodBeat.o(106497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText
 * JD-Core Version:    0.7.0.1
 */