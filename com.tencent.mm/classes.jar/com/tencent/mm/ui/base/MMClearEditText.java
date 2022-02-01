package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.g.c.b;

public class MMClearEditText
  extends EditText
{
  private View.OnFocusChangeListener BFz;
  private View.OnTouchListener HeV;
  public boolean Kcn;
  Drawable Kco;
  private boolean OPN;
  public String oxJ;
  int qRC;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159155);
    this.oxJ = "";
    this.Kcn = false;
    this.Kco = at.aN(getContext(), 2130969010);
    this.qRC = 0;
    this.BFz = null;
    this.HeV = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(159154);
        paramAnonymousView = MMClearEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMClearEditText.this.Kco.getIntrinsicWidth())
        {
          paramAnonymousView.setText("");
          MMClearEditText.c(MMClearEditText.this);
        }
        AppMethodBeat.o(159154);
        return false;
      }
    };
    this.OPN = false;
    cMn();
    AppMethodBeat.o(159155);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159156);
    this.oxJ = "";
    this.Kcn = false;
    this.Kco = at.aN(getContext(), 2130969010);
    this.qRC = 0;
    this.BFz = null;
    this.HeV = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(159154);
        paramAnonymousView = MMClearEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMClearEditText.this.Kco.getIntrinsicWidth())
        {
          paramAnonymousView.setText("");
          MMClearEditText.c(MMClearEditText.this);
        }
        AppMethodBeat.o(159154);
        return false;
      }
    };
    this.OPN = false;
    cMn();
    AppMethodBeat.o(159156);
  }
  
  private void beu(String paramString)
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
  
  private void cMn()
  {
    AppMethodBeat.i(159157);
    if (this.Kco == null) {
      this.Kco = at.aN(getContext(), 2130969010);
    }
    this.Kco.setBounds(0, 0, this.Kco.getIntrinsicWidth(), this.Kco.getIntrinsicHeight());
    as.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.Kco.getIntrinsicWidth()), Integer.valueOf(this.Kco.getIntrinsicHeight()) });
    goL();
    setHeight(this.Kco.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165537) * 5);
    setOnTouchListener(this.HeV);
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
  
  private void goL()
  {
    AppMethodBeat.i(159160);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      goN();
      AppMethodBeat.o(159160);
      return;
    }
    goM();
    AppMethodBeat.o(159160);
  }
  
  private void goM()
  {
    AppMethodBeat.i(159161);
    if (!this.OPN) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Kco, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(159161);
  }
  
  private void goN()
  {
    AppMethodBeat.i(159162);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(159162);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.HeV;
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
    if (!this.Kcn) {
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
      this.qRC = 0;
      str = getText().toString();
    }
    try
    {
      beu(str);
      AppMethodBeat.o(159158);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        as.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.qRC) });
        if (this.qRC < 3)
        {
          this.qRC += 1;
          beu(" ".concat(String.valueOf(str)));
        }
        else
        {
          as.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
        }
      }
    }
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.BFz = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */