package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class MMAutoCompleteTextView
  extends AutoCompleteTextView
{
  final Drawable vQV;
  private a ziI;
  
  public MMAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106476);
    this.vQV = getResources().getDrawable(2130839272);
    this.vQV.setBounds(0, 0, this.vQV.getIntrinsicWidth(), this.vQV.getIntrinsicHeight());
    dnb();
    setOnTouchListener(new MMAutoCompleteTextView.1(this));
    addTextChangedListener(new MMAutoCompleteTextView.2(this));
    setOnFocusChangeListener(new MMAutoCompleteTextView.3(this));
    AppMethodBeat.o(106476);
  }
  
  private void dnb()
  {
    AppMethodBeat.i(106477);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      dnd();
      AppMethodBeat.o(106477);
      return;
    }
    dnc();
    AppMethodBeat.o(106477);
  }
  
  private void dnc()
  {
    AppMethodBeat.i(106478);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vQV, getCompoundDrawables()[3]);
    AppMethodBeat.o(106478);
  }
  
  private void dnd()
  {
    AppMethodBeat.i(106479);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(106479);
  }
  
  public void setSpilter(String paramString)
  {
    AppMethodBeat.i(106480);
    if (!bo.isNullOrNil(paramString))
    {
      this.ziI = new a(paramString);
      addTextChangedListener(this.ziI);
    }
    AppMethodBeat.o(106480);
  }
  
  final class a
    implements TextWatcher
  {
    private String ziK;
    
    public a(String paramString)
    {
      this.ziK = paramString;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(106475);
      if (paramEditable.toString().endsWith(this.ziK)) {
        MMAutoCompleteTextView.this.showDropDown();
      }
      AppMethodBeat.o(106475);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */