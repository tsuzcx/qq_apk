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
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.cd.g;
import com.tencent.mm.sdk.platformtools.y;

public class MMPhoneNumberEditText
  extends EditText
{
  public String hyx = "";
  private View.OnFocusChangeListener nrZ = null;
  int rIK = 0;
  public boolean sae = false;
  public Drawable saf;
  private MMPhoneNumberEditText.a sag;
  public boolean sah;
  private boolean sai = false;
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMPhoneNumberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void Wu(String paramString)
  {
    int i = getSelectionStart();
    g localg = g.csM();
    getContext();
    setText(localg.a(paramString, getTextSize()));
    int j = getText().length() - paramString.length();
    if (j > 0)
    {
      i += j;
      if (i <= getText().length()) {
        setSelection(i);
      }
      return;
    }
    setSelection(i);
  }
  
  private void cml()
  {
    if (getText().toString().equals(""))
    {
      cmn();
      return;
    }
    cmm();
  }
  
  private void cmn()
  {
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
  }
  
  private void init()
  {
    this.saf = getResources().getDrawable(R.g.list_clear);
    this.saf.setBounds(0, 0, this.saf.getIntrinsicWidth(), this.saf.getIntrinsicHeight());
    y.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.saf.getIntrinsicWidth()), Integer.valueOf(this.saf.getIntrinsicHeight()) });
    cml();
    setHeight(this.saf.getIntrinsicHeight() + getResources().getDimensionPixelSize(R.f.OneDPPadding) * 5);
    clearFocus();
    setOnTouchListener(new MMPhoneNumberEditText.1(this));
    addTextChangedListener(new MMPhoneNumberEditText.2(this));
    super.setOnFocusChangeListener(new MMPhoneNumberEditText.3(this));
  }
  
  final void cmm()
  {
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.saf, getCompoundDrawables()[3]);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TextView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    if (!this.sae) {
      paramParcelable = View.BaseSavedState.EMPTY_STATE;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    boolean bool = super.onTextContextMenuItem(paramInt);
    String str;
    if (paramInt == 16908322)
    {
      this.rIK = 0;
      str = getText().toString();
    }
    try
    {
      Wu(str);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      y.e("MicroMsg.MMClearEditText", "!!MMClearEditText Exception %d", new Object[] { Integer.valueOf(this.rIK) });
      if (this.rIK < 3)
      {
        this.rIK += 1;
        Wu(" " + str);
        return bool;
      }
      y.e("MicroMsg.MMClearEditText", "!!MMClearEditText, IndexOutOfBoundsException cannot fix");
    }
    return bool;
  }
  
  public void setCallback(MMPhoneNumberEditText.a parama)
  {
    this.sag = parama;
  }
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.nrZ = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MMPhoneNumberEditText
 * JD-Core Version:    0.7.0.1
 */