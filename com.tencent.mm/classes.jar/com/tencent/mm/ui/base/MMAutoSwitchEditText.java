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
  a FWr;
  
  public MMAutoSwitchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141864);
    this.FWr = new a(this);
    addTextChangedListener(this.FWr);
    setOnKeyListener(this.FWr);
    AppMethodBeat.o(141864);
  }
  
  public static final class a
    implements TextWatcher, View.OnKeyListener
  {
    MMAutoSwitchEditText.c FWs;
    MMAutoSwitchEditText.b FWt;
    MMAutoSwitchEditText.d FWu;
    int FWv = 4;
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
      if (this.FWu != null) {
        this.FWu.bRW();
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
        if (i > this.FWv) {
          break;
        }
        paramEditable = paramEditable + this.mText.charAt(j);
        j += 1;
      }
      if (k > this.FWv)
      {
        this.mEditText.setText(paramEditable);
        this.mEditText.setSelection(paramEditable.length());
      }
      if ((k >= this.FWv) && (this.FWs != null)) {
        this.FWs.XK(this.mIndex);
      }
      AppMethodBeat.o(141862);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(141863);
      if ((paramInt == 67) && (this.mEditText.getText().toString().trim().length() == 0) && (this.FWt != null)) {
        this.FWt.XJ(this.mIndex);
      }
      AppMethodBeat.o(141863);
      return false;
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static abstract interface b
  {
    public abstract void XJ(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void XK(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bRW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText
 * JD-Core Version:    0.7.0.1
 */