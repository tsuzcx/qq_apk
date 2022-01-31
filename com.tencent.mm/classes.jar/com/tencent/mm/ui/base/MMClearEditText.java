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
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.c.b;

public class MMClearEditText
  extends EditText
{
  public String hyx = "";
  private View.OnFocusChangeListener nrZ = null;
  private View.OnTouchListener pXl = new MMClearEditText.3(this);
  int rIK = 0;
  public boolean sae = false;
  final Drawable saf = getResources().getDrawable(a.f.list_clear);
  private boolean uUy = false;
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cAE();
  }
  
  public MMClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cAE();
  }
  
  private void Wu(String paramString)
  {
    int i = getSelectionStart();
    setText(b.d(getContext(), paramString, getTextSize()));
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
  
  private void cAE()
  {
    this.saf.setBounds(0, 0, this.saf.getIntrinsicWidth(), this.saf.getIntrinsicHeight());
    y.d("MicroMsg.MMClearEditText", "imgX width %d height %d", new Object[] { Integer.valueOf(this.saf.getIntrinsicWidth()), Integer.valueOf(this.saf.getIntrinsicHeight()) });
    cml();
    setHeight(this.saf.getIntrinsicHeight() + getResources().getDimensionPixelSize(a.e.OneDPPadding) * 5);
    setOnTouchListener(this.pXl);
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        MMClearEditText.a(MMClearEditText.this);
      }
    });
    super.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (MMClearEditText.b(MMClearEditText.this) != null) {
          MMClearEditText.b(MMClearEditText.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
        }
        MMClearEditText.a(MMClearEditText.this);
      }
    });
  }
  
  private void cml()
  {
    if ((getText().toString().equals("")) || (!isFocused())) {
      cmn();
    }
    while (this.uUy) {
      return;
    }
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.saf, getCompoundDrawables()[3]);
  }
  
  private void cmn()
  {
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
  }
  
  public View.OnTouchListener getDefaultOnTouchListener()
  {
    return this.pXl;
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
  
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.nrZ = paramOnFocusChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText
 * JD-Core Version:    0.7.0.1
 */