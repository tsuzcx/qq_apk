package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.f.c.b;

public class MMClearEditText
  extends EditText
{
  public String jqH;
  private View.OnTouchListener kjL;
  private View.OnFocusChangeListener pXn;
  public boolean vQU;
  final Drawable vQV;
  int vzq;
  private boolean ziZ;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106507);
    this.jqH = "";
    this.vQU = false;
    this.vQV = getResources().getDrawable(2130840216);
    this.vzq = 0;
    this.pXn = null;
    this.kjL = new MMClearEditText.3(this);
    this.ziZ = false;
    dDP();
    AppMethodBeat.o(106507);
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106508);
    this.jqH = "";
    this.vQU = false;
    this.vQV = getResources().getDrawable(2130840216);
    this.vzq = 0;
    this.pXn = null;
    this.kjL = new MMClearEditText.3(this);
    this.ziZ = false;
    dDP();
    AppMethodBeat.o(106508);
  }
  
  private void alZ(String paramString)
  {
    AppMethodBeat.i(106511);
    int i = getSelectionStart();
    setText(b.c(getContext(), paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(106511);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(106511);
  }
  
  private void dDP()
  {
    AppMethodBeat.i(106509);
    this.vQV.setBounds(0, 0, this.vQV.getIntrinsicWidth(), this.vQV.getIntrinsicHeight());
    ab.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.vQV.getIntrinsicWidth()), Integer.valueOf(this.vQV.getIntrinsicHeight()) });
    dnb();
    setHeight(this.vQV.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131427811) * 5);
    setOnTouchListener(this.kjL);
    addTextChangedListener(new MMClearEditText.1(this));
    super.setOnFocusChangeListener(new MMClearEditText.2(this));
    AppMethodBeat.o(106509);
  }
  
  private void dnb()
  {
    AppMethodBeat.i(106512);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      dnd();
      AppMethodBeat.o(106512);
      return;
    }
    dnc();
    AppMethodBeat.o(106512);
  }
  
  private void dnc()
  {
    AppMethodBeat.i(106513);
    if (!this.ziZ) {
      setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vQV, getCompoundDrawables()[3]);
    }
    AppMethodBeat.o(106513);
  }
  
  private void dnd()
  {
    AppMethodBeat.i(106514);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(106514);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.kjL;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(106515);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(106515);
      return;
    }
    if (!this.vQU) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(106515);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(106510);
    boolean bool = super.onTextContextMenuItem(paramInt);
    String str;
    if (paramInt == 16908322)
    {
      this.vzq = 0;
      str = getText().toString();
    }
    try
    {
      alZ(str);
      AppMethodBeat.o(106510);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.vzq) });
        if (this.vzq < 3)
        {
          this.vzq += 1;
          alZ(" ".concat(String.valueOf(str)));
        }
        else
        {
          ab.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
        }
      }
    }
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.pXn = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */