package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMAutoSwitchEditText
  extends EditText
{
  a Hwf;
  
  public MMAutoSwitchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141864);
    this.Hwf = new a(this);
    addTextChangedListener(this.Hwf);
    setOnKeyListener(this.Hwf);
    AppMethodBeat.o(141864);
  }
  
  public static final class a
    implements TextWatcher, View.OnKeyListener
  {
    MMAutoSwitchEditText.c Hwg;
    MMAutoSwitchEditText.b Hwh;
    MMAutoSwitchEditText.d Hwi;
    int Hwj = 4;
    private EditText mEditText;
    int mIndex = 0;
    private String mText;
    
    public a(EditText paramEditText)
    {
      this.mEditText = paramEditText;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(141862);
      this.mText = paramEditable.toString();
      paramEditable = "";
      if (this.Hwi != null) {
        this.Hwi.bZl();
      }
      int j = 0;
      int i = 0;
      int k;
      for (;;)
      {
        k = i;
        if (j >= this.mText.length()) {
          break;
        }
        i += 1;
        k = i;
        if (i > this.Hwj) {
          break;
        }
        paramEditable = paramEditable + this.mText.charAt(j);
        j += 1;
      }
      if (k > this.Hwj)
      {
        this.mEditText.setText(paramEditable);
        this.mEditText.setSelection(paramEditable.length());
      }
      if ((k >= this.Hwj) && (this.Hwg != null)) {
        this.Hwg.ZV(this.mIndex);
      }
      AppMethodBeat.o(141862);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(141863);
      if ((paramInt == 67) && (this.mEditText.getText().toString().trim().length() == 0) && (this.Hwh != null)) {
        this.Hwh.ZU(this.mIndex);
      }
      AppMethodBeat.o(141863);
      return false;
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static abstract interface b
  {
    public abstract void ZU(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void ZV(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bZl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText
 * JD-Core Version:    0.7.0.1
 */