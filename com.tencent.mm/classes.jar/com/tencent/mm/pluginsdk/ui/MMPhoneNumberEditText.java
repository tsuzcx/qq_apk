package com.tencent.mm.pluginsdk.ui;

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
import com.tencent.mm.cf.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;

public class MMPhoneNumberEditText
  extends EditText
{
  public boolean DnT;
  public Drawable DnU;
  private a DnV;
  public boolean DnW;
  private boolean DnX;
  public String mIy;
  int oRW;
  private View.OnFocusChangeListener whV;
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31197);
    this.mIy = "";
    this.DnT = false;
    this.DnX = false;
    this.oRW = 0;
    this.whV = null;
    init();
    AppMethodBeat.o(31197);
  }
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31198);
    this.mIy = "";
    this.DnT = false;
    this.DnX = false;
    this.oRW = 0;
    this.whV = null;
    init();
    AppMethodBeat.o(31198);
  }
  
  private void aGT(String paramString)
  {
    AppMethodBeat.i(31202);
    int i = getSelectionStart();
    g localg = g.eXw();
    getContext();
    setText(localg.b(paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(31202);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(31202);
  }
  
  private void eMP()
  {
    AppMethodBeat.i(31203);
    if (getText().toString().equals(""))
    {
      eMR();
      AppMethodBeat.o(31203);
      return;
    }
    eMQ();
    AppMethodBeat.o(31203);
  }
  
  private void eMQ()
  {
    AppMethodBeat.i(31204);
    setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], this.DnU, getCompoundDrawables()[3]);
    AppMethodBeat.o(31204);
  }
  
  private void eMR()
  {
    AppMethodBeat.i(31205);
    setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(31205);
  }
  
  private void init()
  {
    AppMethodBeat.i(31200);
    this.DnU = ao.aI(getContext(), 2130968981);
    this.DnU.setBounds(0, 0, this.DnU.getIntrinsicWidth(), this.DnU.getIntrinsicHeight());
    ac.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.DnU.getIntrinsicWidth()), Integer.valueOf(this.DnU.getIntrinsicHeight()) });
    eMP();
    setHeight(this.DnU.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    clearFocus();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(31193);
        paramAnonymousView = MMPhoneNumberEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          AppMethodBeat.o(31193);
          return false;
        }
        if ((paramAnonymousMotionEvent.getAction() == 1) && (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMPhoneNumberEditText.this.DnU.getIntrinsicWidth()))
        {
          if (!paramAnonymousView.isFocused()) {
            break label90;
          }
          paramAnonymousView.setText("");
          MMPhoneNumberEditText.a(paramAnonymousView);
        }
        for (;;)
        {
          AppMethodBeat.o(31193);
          return false;
          label90:
          if (MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).f(paramAnonymousView);
          }
        }
      }
    });
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31195);
        if (bs.isNullOrNil(paramAnonymousCharSequence.toString()))
        {
          MMPhoneNumberEditText.a(MMPhoneNumberEditText.this, true);
          AppMethodBeat.o(31195);
          return;
        }
        MMPhoneNumberEditText.a(MMPhoneNumberEditText.this, false);
        AppMethodBeat.o(31195);
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(31194);
        MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
        if ((paramAnonymousCharSequence.toString().equals("")) && (!MMPhoneNumberEditText.d(MMPhoneNumberEditText.this)))
        {
          if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused()))
          {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).g(MMPhoneNumberEditText.this);
            AppMethodBeat.o(31194);
          }
        }
        else if ((!paramAnonymousCharSequence.toString().equals("")) && (MMPhoneNumberEditText.d(MMPhoneNumberEditText.this)))
        {
          if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused()))
          {
            MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).eMS();
            AppMethodBeat.o(31194);
          }
        }
        else if ((MMPhoneNumberEditText.b(MMPhoneNumberEditText.this) != null) && (MMPhoneNumberEditText.this.isFocused())) {
          MMPhoneNumberEditText.b(MMPhoneNumberEditText.this).eMT();
        }
        AppMethodBeat.o(31194);
      }
    });
    super.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31196);
        if (MMPhoneNumberEditText.e(MMPhoneNumberEditText.this) != null) {
          MMPhoneNumberEditText.e(MMPhoneNumberEditText.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        MMPhoneNumberEditText.c(MMPhoneNumberEditText.this);
        AppMethodBeat.o(31196);
      }
    });
    AppMethodBeat.o(31200);
  }
  
  public final void eMO()
  {
    AppMethodBeat.i(31199);
    this.DnW = true;
    this.DnU = getResources().getDrawable(2131690693);
    this.DnU.setBounds(0, 0, this.DnU.getIntrinsicWidth(), this.DnU.getIntrinsicHeight());
    setFocusable(false);
    eMQ();
    AppMethodBeat.o(31199);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(31206);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(31206);
      return;
    }
    if (!this.DnT) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(31206);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(31201);
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
      AppMethodBeat.o(31201);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        ac.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.oRW) });
        if (this.oRW < 3)
        {
          this.oRW += 1;
          aGT(" ".concat(String.valueOf(str)));
        }
        else
        {
          ac.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
        }
      }
    }
  }
  
  public void setCallback(a parama)
  {
    this.DnV = parama;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.whV = paramOnFocusChangeListener;
  }
  
  public static abstract interface a
  {
    public abstract void eMS();
    
    public abstract void eMT();
    
    public abstract void f(MMPhoneNumberEditText paramMMPhoneNumberEditText);
    
    public abstract void g(MMPhoneNumberEditText paramMMPhoneNumberEditText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText
 * JD-Core Version:    0.7.0.1
 */