package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView.SavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.g;
import com.tencent.mm.sdk.platformtools.ab;

public class MMPhoneNumberEditText
  extends EditText
{
  public String jqH;
  private View.OnFocusChangeListener pXn;
  public boolean vQU;
  public Drawable vQV;
  private MMPhoneNumberEditText.a vQW;
  public boolean vQX;
  private boolean vQY;
  int vzq;
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27495);
    this.jqH = "";
    this.vQU = false;
    this.vQY = false;
    this.vzq = 0;
    this.pXn = null;
    init();
    AppMethodBeat.o(27495);
  }
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27496);
    this.jqH = "";
    this.vQU = false;
    this.vQY = false;
    this.vzq = 0;
    this.pXn = null;
    init();
    AppMethodBeat.o(27496);
  }
  
  private void alZ(String paramString)
  {
    AppMethodBeat.i(27500);
    int i = getSelectionStart();
    g localg = g.dvk();
    getContext();
    setText(localg.b(paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      AppMethodBeat.o(27500);
      return;
    }
    setSelection(i);
    AppMethodBeat.o(27500);
  }
  
  private void dnb()
  {
    AppMethodBeat.i(27501);
    if (getText().toString().equals(""))
    {
      dnd();
      AppMethodBeat.o(27501);
      return;
    }
    dnc();
    AppMethodBeat.o(27501);
  }
  
  private void dnc()
  {
    AppMethodBeat.i(27502);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.vQV, getCompoundDrawables()[3]);
    AppMethodBeat.o(27502);
  }
  
  private void dnd()
  {
    AppMethodBeat.i(27503);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(27503);
  }
  
  private void init()
  {
    AppMethodBeat.i(27498);
    this.vQV = getResources().getDrawable(2130840216);
    this.vQV.setBounds(0, 0, this.vQV.getIntrinsicWidth(), this.vQV.getIntrinsicHeight());
    ab.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.vQV.getIntrinsicWidth()), Integer.valueOf(this.vQV.getIntrinsicHeight()) });
    dnb();
    setHeight(this.vQV.getIntrinsicHeight() + getResources().getDimensionPixelSize(2131427811) * 5);
    clearFocus();
    setOnTouchListener(new MMPhoneNumberEditText.1(this));
    addTextChangedListener(new MMPhoneNumberEditText.2(this));
    super.setOnFocusChangeListener(new MMPhoneNumberEditText.3(this));
    AppMethodBeat.o(27498);
  }
  
  public final void dna()
  {
    AppMethodBeat.i(27497);
    this.vQX = true;
    this.vQV = getResources().getDrawable(2131231553);
    this.vQV.setBounds(0, 0, this.vQV.getIntrinsicWidth(), this.vQV.getIntrinsicHeight());
    setFocusable(false);
    dnc();
    AppMethodBeat.o(27497);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(27504);
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(27504);
      return;
    }
    if (!this.vQU) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
    AppMethodBeat.o(27504);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(27499);
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
      AppMethodBeat.o(27499);
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
  
  public void setCallback(MMPhoneNumberEditText.a parama)
  {
    this.vQW = parama;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.pXn = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText
 * JD-Core Version:    0.7.0.1
 */