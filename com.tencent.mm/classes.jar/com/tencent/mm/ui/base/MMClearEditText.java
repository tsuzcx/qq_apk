package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.f.c.b;

public class MMClearEditText
  extends EditText
{
  private View.OnTouchListener AKw;
  public boolean DnT;
  Drawable DnU;
  private boolean Hwr;
  public String mIy;
  int oRW;
  private View.OnFocusChangeListener whV;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159155);
    this.mIy = "";
    this.DnT = false;
    this.DnU = ao.aI(getContext(), 2130968981);
    this.oRW = 0;
    this.whV = null;
    this.AKw = new MMClearEditText.3(this);
    this.Hwr = false;
    cih();
    AppMethodBeat.o(159155);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159156);
    this.mIy = "";
    this.DnT = false;
    this.DnU = ao.aI(getContext(), 2130968981);
    this.oRW = 0;
    this.whV = null;
    this.AKw = new MMClearEditText.3(this);
    this.Hwr = false;
    cih();
    AppMethodBeat.o(159156);
  }
  
  private void aGT(String paramString)
  {
    AppMethodBeat.i(159159);
    int i = getSelectionStart();
    setText(b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(159159);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(159159);
  }
  
  private void cih()
  {
    AppMethodBeat.i(159157);
    if (this.DnU == null) {
      this.DnU = ao.aI(getContext(), 2130968981);
    }
    this.DnU.setBounds(0, 0, this.DnU.getIntrinsicWidth(), this.DnU.getIntrinsicHeight());
    an.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.DnU.getIntrinsicWidth()), Integer.valueOf(this.DnU.getIntrinsicHeight()) });
    eMP();
    setHeight(this.DnU.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    setOnTouchListener(this.AKw);
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(159152);
        MMClearEditText.a(MMClearEditText.this);
        AppMethodBeat.o(159152);
      }
    });
    super.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(159153);
        if (MMClearEditText.b(MMClearEditText.this) != null) {
          MMClearEditText.b(MMClearEditText.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        MMClearEditText.a(MMClearEditText.this);
        AppMethodBeat.o(159153);
      }
    });
    AppMethodBeat.o(159157);
  }
  
  private void eMP()
  {
    AppMethodBeat.i(159160);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      eMR();
      AppMethodBeat.o(159160);
      return;
    }
    eMQ();
    AppMethodBeat.o(159160);
  }
  
  private void eMQ()
  {
    AppMethodBeat.i(159161);
    if (!this.Hwr) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.DnU, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(159161);
  }
  
  private void eMR()
  {
    AppMethodBeat.i(159162);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(159162);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.AKw;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(159163);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(159163);
      return;
    }
    if (!this.DnT) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(159163);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(159158);
    boolean bool = super.onTextContextMenuItem(paramInt);
    String str;
    if (paramInt == 16908322)
    {
      this.oRW = 0;
      str = getText().toString();
    }
    try
    {
      aGT(str);
      AppMethodBeat.o(159158);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        an.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.oRW) });
        if (this.oRW < 3)
        {
          this.oRW += 1;
          aGT(" ".concat(String.valueOf(str)));
        }
        else
        {
          an.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
        }
      }
    }
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.whV = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */