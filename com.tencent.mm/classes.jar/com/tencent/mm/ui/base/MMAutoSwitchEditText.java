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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

class MMAutoSwitchEditText
  extends EditText
{
  a JEJ;
  
  public MMAutoSwitchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141864);
    this.JEJ = new a(this);
    addTextChangedListener(this.JEJ);
    setOnKeyListener(this.JEJ);
    AppMethodBeat.o(141864);
  }
  
  public static final class a
    implements TextWatcher, View.OnKeyListener
  {
    MMAutoSwitchEditText.c JEK;
    MMAutoSwitchEditText.b JEL;
    MMAutoSwitchEditText.d JEM;
    int JEN = 4;
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
      if (this.JEM != null) {
        this.JEM.cfe();
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
        if (i > this.JEN) {
          break;
        }
        paramEditable = paramEditable + this.mText.charAt(j);
        j += 1;
      }
      if (k > this.JEN)
      {
        this.mEditText.setText(paramEditable);
        this.mEditText.setSelection(paramEditable.length());
      }
      if ((k >= this.JEN) && (this.JEK != null)) {
        this.JEK.acM(this.mIndex);
      }
      AppMethodBeat.o(141862);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(141863);
      b localb = new b();
      localb.bd(paramView);
      localb.mu(paramInt);
      localb.bd(paramKeyEvent);
      a.b("com/tencent/mm/ui/base/MMAutoSwitchEditText$AutoSwitchEditTextWatcher", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
      if ((paramInt == 67) && (this.mEditText.getText().toString().trim().length() == 0) && (this.JEL != null)) {
        this.JEL.acL(this.mIndex);
      }
      a.a(false, this, "com/tencent/mm/ui/base/MMAutoSwitchEditText$AutoSwitchEditTextWatcher", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(141863);
      return false;
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static abstract interface b
  {
    public abstract void acL(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void acM(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void cfe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText
 * JD-Core Version:    0.7.0.1
 */