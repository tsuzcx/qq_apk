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
import com.tencent.mm.cr.a.b;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.h.c.b;

public class MMClearEditText
  extends EditText
{
  private View.OnFocusChangeListener HBD;
  public boolean RcS;
  Drawable RcT;
  private boolean WiU;
  public MMClearEditText.a ZuS;
  private View.OnTouchListener nan;
  public String rAi;
  int utI;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159155);
    this.rAi = "";
    this.RcS = false;
    this.ZuS = null;
    this.RcT = aw.bf(getContext(), a.b.et_clear_selector);
    this.utI = 0;
    this.HBD = null;
    this.nan = new MMClearEditText.3(this);
    this.WiU = false;
    dbb();
    AppMethodBeat.o(159155);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159156);
    this.rAi = "";
    this.RcS = false;
    this.ZuS = null;
    this.RcT = aw.bf(getContext(), a.b.et_clear_selector);
    this.utI = 0;
    this.HBD = null;
    this.nan = new MMClearEditText.3(this);
    this.WiU = false;
    dbb();
    AppMethodBeat.o(159156);
  }
  
  private void bqQ(String paramString)
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
  
  private void dbb()
  {
    AppMethodBeat.i(159157);
    if (this.RcT == null) {
      this.RcT = aw.bf(getContext(), a.b.et_clear_selector);
    }
    this.RcT.setBounds(0, 0, this.RcT.getIntrinsicWidth(), this.RcT.getIntrinsicHeight());
    av.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.RcT.getIntrinsicWidth()), Integer.valueOf(this.RcT.getIntrinsicHeight()) });
    hjx();
    setHeight(this.RcT.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.d.OneDPPadding) * 5);
    setOnTouchListener(this.nan);
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
  
  private void hjx()
  {
    AppMethodBeat.i(159160);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      hjz();
      AppMethodBeat.o(159160);
      return;
    }
    hjy();
    AppMethodBeat.o(159160);
  }
  
  private void hjy()
  {
    AppMethodBeat.i(159161);
    if (!this.WiU) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.RcT, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(159161);
  }
  
  private void hjz()
  {
    AppMethodBeat.i(159162);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(159162);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.nan;
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
    if (!this.RcS) {
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
      this.utI = 0;
      str = getText().toString();
    }
    try
    {
      bqQ(str);
      AppMethodBeat.o(159158);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        av.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.utI) });
        if (this.utI < 3)
        {
          this.utI += 1;
          bqQ(" ".concat(String.valueOf(str)));
        }
        else
        {
          av.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
        }
      }
    }
  }
  
  public void setClearBtnListener(MMClearEditText.a parama)
  {
    this.ZuS = parama;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.HBD = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */