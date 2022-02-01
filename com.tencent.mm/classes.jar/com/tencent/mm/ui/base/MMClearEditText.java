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
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.i.c.b;

public class MMClearEditText
  extends EditText
{
  private View.OnFocusChangeListener Nzg;
  public boolean XYY;
  Drawable XYZ;
  public b adPV;
  private a adPW;
  private boolean adPX;
  public String defaultValue;
  private View.OnTouchListener pWX;
  int xAf;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159155);
    this.defaultValue = "";
    this.XYY = false;
    this.adPV = null;
    this.XYZ = bb.m(getContext(), a.e.icons_filled_close2, getResources().getColor(a.c.BW_0_Alpha_0_5));
    this.xAf = 0;
    this.Nzg = null;
    this.pWX = new View.OnTouchListener()
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
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMClearEditText.this.XYZ.getIntrinsicWidth()) {
          MMClearEditText.this.jmg();
        }
        AppMethodBeat.o(159154);
        return false;
      }
    };
    this.adPX = false;
    dHA();
    AppMethodBeat.o(159155);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(159156);
    this.defaultValue = "";
    this.XYY = false;
    this.adPV = null;
    this.XYZ = bb.m(getContext(), a.e.icons_filled_close2, getResources().getColor(a.c.BW_0_Alpha_0_5));
    this.xAf = 0;
    this.Nzg = null;
    this.pWX = new View.OnTouchListener()
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
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMClearEditText.this.XYZ.getIntrinsicWidth()) {
          MMClearEditText.this.jmg();
        }
        AppMethodBeat.o(159154);
        return false;
      }
    };
    this.adPX = false;
    dHA();
    AppMethodBeat.o(159156);
  }
  
  private void bqF(String paramString)
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
  
  private void dHA()
  {
    AppMethodBeat.i(159157);
    if (this.XYZ == null) {
      this.XYZ = bb.m(getContext(), a.e.icons_filled_close2, getResources().getColor(a.c.BW_0_Alpha_0_5));
    }
    this.XYZ.setBounds(0, 0, this.XYZ.getIntrinsicWidth(), this.XYZ.getIntrinsicHeight());
    bc.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.XYZ.getIntrinsicWidth()), Integer.valueOf(this.XYZ.getIntrinsicHeight()) });
    iKp();
    setHeight(this.XYZ.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.d.OneDPPadding) * 5);
    setOnTouchListener(this.pWX);
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
  
  private void iKp()
  {
    AppMethodBeat.i(159160);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      iKr();
      AppMethodBeat.o(159160);
      return;
    }
    iKq();
    AppMethodBeat.o(159160);
  }
  
  private void iKq()
  {
    AppMethodBeat.i(159161);
    if (!this.adPX)
    {
      if (this.adPW != null) {
        this.adPW.showClearBtn(true);
      }
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.XYZ, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(159161);
  }
  
  private void iKr()
  {
    AppMethodBeat.i(159162);
    if (this.adPW != null) {
      this.adPW.showClearBtn(false);
    }
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(159162);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.pWX;
  }
  
  public final void jmg()
  {
    AppMethodBeat.i(251477);
    setText("");
    iKr();
    if (this.adPV != null) {
      this.adPV.jmh();
    }
    AppMethodBeat.o(251477);
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
    if (!this.XYY) {
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
      this.xAf = 0;
      str = getText().toString();
    }
    try
    {
      bqF(str);
      AppMethodBeat.o(159158);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        bc.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.xAf) });
        if (this.xAf < 3)
        {
          this.xAf += 1;
          bqF(" ".concat(String.valueOf(str)));
        }
        else
        {
          bc.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix", new Object[0]);
        }
      }
    }
  }
  
  public void setClearBtnCallBcakListener(a parama)
  {
    this.adPW = parama;
  }
  
  public void setClearBtnListener(b paramb)
  {
    this.adPV = paramb;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.Nzg = paramOnFocusChangeListener;
  }
  
  public static abstract interface a
  {
    public abstract void showClearBtn(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void jmh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */