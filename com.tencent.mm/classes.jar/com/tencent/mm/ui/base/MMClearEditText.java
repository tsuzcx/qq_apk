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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.aq;

public class MMClearEditText
  extends EditText
{
  private View.OnTouchListener CBc;
  public boolean Flu;
  Drawable Flv;
  private boolean JEV;
  public String nod;
  int pCk;
  private View.OnFocusChangeListener xFB;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159155);
    this.nod = "";
    this.Flu = false;
    this.Flv = aq.aM(getContext(), 2130968981);
    this.pCk = 0;
    this.xFB = null;
    this.CBc = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(159154);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousView = MMClearEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMClearEditText.this.Flv.getIntrinsicWidth())
        {
          paramAnonymousView.setText("");
          MMClearEditText.c(MMClearEditText.this);
        }
        a.a(false, this, "com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(159154);
        return false;
      }
    };
    this.JEV = false;
    cob();
    AppMethodBeat.o(159155);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159156);
    this.nod = "";
    this.Flu = false;
    this.Flv = aq.aM(getContext(), 2130968981);
    this.pCk = 0;
    this.xFB = null;
    this.CBc = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(159154);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        paramAnonymousView = MMClearEditText.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(159154);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMClearEditText.this.Flv.getIntrinsicWidth())
        {
          paramAnonymousView.setText("");
          MMClearEditText.c(MMClearEditText.this);
        }
        a.a(false, this, "com/tencent/mm/ui/base/MMClearEditText$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(159154);
        return false;
      }
    };
    this.JEV = false;
    cob();
    AppMethodBeat.o(159156);
  }
  
  private void aNS(String paramString)
  {
    AppMethodBeat.i(159159);
    int i = getSelectionStart();
    setText(com.tencent.mm.ui.f.c.b.c(getContext(), paramString, getTextSize()));
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
  
  private void cob()
  {
    AppMethodBeat.i(159157);
    if (this.Flv == null) {
      this.Flv = aq.aM(getContext(), 2130968981);
    }
    this.Flv.setBounds(0, 0, this.Flv.getIntrinsicWidth(), this.Flv.getIntrinsicHeight());
    ap.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.Flv.getIntrinsicWidth()), Integer.valueOf(this.Flv.getIntrinsicHeight()) });
    ffC();
    setHeight(this.Flv.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131165519) * 5);
    setOnTouchListener(this.CBc);
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
  
  private void ffC()
  {
    AppMethodBeat.i(159160);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      ffE();
      AppMethodBeat.o(159160);
      return;
    }
    ffD();
    AppMethodBeat.o(159160);
  }
  
  private void ffD()
  {
    AppMethodBeat.i(159161);
    if (!this.JEV) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.Flv, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(159161);
  }
  
  private void ffE()
  {
    AppMethodBeat.i(159162);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(159162);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.CBc;
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
    if (!this.Flu) {
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
      this.pCk = 0;
      str = getText().toString();
    }
    try
    {
      aNS(str);
      AppMethodBeat.o(159158);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        ap.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.pCk) });
        if (this.pCk < 3)
        {
          this.pCk += 1;
          aNS(" ".concat(String.valueOf(str)));
        }
        else
        {
          ap.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
        }
      }
    }
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.xFB = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */