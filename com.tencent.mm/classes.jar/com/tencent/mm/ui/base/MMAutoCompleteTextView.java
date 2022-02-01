package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class MMAutoCompleteTextView
  extends AutoCompleteTextView
{
  final Drawable DnU;
  private a Hwa;
  
  public MMAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141840);
    this.DnU = getResources().getDrawable(2131232862);
    this.DnU.setBounds(0, 0, this.DnU.getIntrinsicWidth(), this.DnU.getIntrinsicHeight());
    eMP();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141836);
        paramAnonymousView = MMAutoCompleteTextView.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          AppMethodBeat.o(141836);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          AppMethodBeat.o(141836);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMAutoCompleteTextView.this.DnU.getIntrinsicWidth())
        {
          paramAnonymousView.setText("");
          MMAutoCompleteTextView.a(MMAutoCompleteTextView.this);
        }
        AppMethodBeat.o(141836);
        return false;
      }
    });
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(141837);
        MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
        AppMethodBeat.o(141837);
      }
    });
    setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(141838);
        MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
        AppMethodBeat.o(141838);
      }
    });
    AppMethodBeat.o(141840);
  }
  
  private void eMP()
  {
    AppMethodBeat.i(141841);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      eMR();
      AppMethodBeat.o(141841);
      return;
    }
    eMQ();
    AppMethodBeat.o(141841);
  }
  
  private void eMQ()
  {
    AppMethodBeat.i(141842);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.DnU, getCompoundDrawables()[3]);
    AppMethodBeat.o(141842);
  }
  
  private void eMR()
  {
    AppMethodBeat.i(141843);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(141843);
  }
  
  public void setSpilter(String paramString)
  {
    AppMethodBeat.i(141844);
    if (!bs.isNullOrNil(paramString))
    {
      this.Hwa = new a(paramString);
      addTextChangedListener(this.Hwa);
    }
    AppMethodBeat.o(141844);
  }
  
  final class a
    implements TextWatcher
  {
    private String Hwc;
    
    public a(String paramString)
    {
      this.Hwc = paramString;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(141839);
      if (paramEditable.toString().endsWith(this.Hwc)) {
        MMAutoCompleteTextView.this.showDropDown();
      }
      AppMethodBeat.o(141839);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */