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
  a OPB;
  
  public MMAutoSwitchEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141864);
    this.OPB = new a(this);
    addTextChangedListener(this.OPB);
    setOnKeyListener(this.OPB);
    AppMethodBeat.o(141864);
  }
  
  public static final class a
    implements TextWatcher, View.OnKeyListener
  {
    MMAutoSwitchEditText.c OPC;
    MMAutoSwitchEditText.b OPD;
    MMAutoSwitchEditText.d OPE;
    int OPF = 4;
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
      if (this.OPE != null) {
        this.OPE.cCU();
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
        if (i > this.OPF) {
          break;
        }
        paramEditable = paramEditable + this.mText.charAt(j);
        j += 1;
      }
      if (k > this.OPF)
      {
        this.mEditText.setText(paramEditable);
        this.mEditText.setSelection(paramEditable.length());
      }
      if ((k >= this.OPF) && (this.OPC != null)) {
        this.OPC.alw(this.mIndex);
      }
      AppMethodBeat.o(141862);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(141863);
      b localb = new b();
      localb.bm(paramView);
      localb.pH(paramInt);
      localb.bm(paramKeyEvent);
      a.b("com/tencent/mm/ui/base/MMAutoSwitchEditText$AutoSwitchEditTextWatcher", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
      if ((paramInt == 67) && (this.mEditText.getText().toString().trim().length() == 0) && (this.OPD != null)) {
        this.OPD.alv(this.mIndex);
      }
      a.a(false, this, "com/tencent/mm/ui/base/MMAutoSwitchEditText$AutoSwitchEditTextWatcher", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
      AppMethodBeat.o(141863);
      return false;
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static abstract interface b
  {
    public abstract void alv(int paramInt);
  }
  
  public static abstract interface c
  {
    public abstract void alw(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void cCU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoSwitchEditText
 * JD-Core Version:    0.7.0.1
 */