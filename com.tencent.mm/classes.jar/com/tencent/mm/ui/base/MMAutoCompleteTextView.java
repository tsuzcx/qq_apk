package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bt;

public class MMAutoCompleteTextView
  extends AutoCompleteTextView
{
  final Drawable ETa;
  private a JjQ;
  
  public MMAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141840);
    this.ETa = getResources().getDrawable(2131232862);
    this.ETa.setBounds(0, 0, this.ETa.getIntrinsicWidth(), this.ETa.getIntrinsicHeight());
    fbO();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141836);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/base/MMAutoCompleteTextView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        paramAnonymousView = MMAutoCompleteTextView.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMAutoCompleteTextView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(141836);
          return false;
        }
        if (paramAnonymousMotionEvent.getAction() != 1)
        {
          a.a(false, this, "com/tencent/mm/ui/base/MMAutoCompleteTextView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(141836);
          return false;
        }
        if (paramAnonymousMotionEvent.getX() > paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMAutoCompleteTextView.this.ETa.getIntrinsicWidth())
        {
          paramAnonymousView.setText("");
          MMAutoCompleteTextView.a(MMAutoCompleteTextView.this);
        }
        a.a(false, this, "com/tencent/mm/ui/base/MMAutoCompleteTextView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(141836);
        return false;
      }
    });
    addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(141837);
        MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
        AppMethodBeat.o(141837);
      }
    });
    setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(141838);
        MMAutoCompleteTextView.b(MMAutoCompleteTextView.this);
        AppMethodBeat.o(141838);
      }
    });
    AppMethodBeat.o(141840);
  }
  
  private void fbO()
  {
    AppMethodBeat.i(141841);
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      fbQ();
      AppMethodBeat.o(141841);
      return;
    }
    fbP();
    AppMethodBeat.o(141841);
  }
  
  private void fbP()
  {
    AppMethodBeat.i(141842);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.ETa, getCompoundDrawables()[3]);
    AppMethodBeat.o(141842);
  }
  
  private void fbQ()
  {
    AppMethodBeat.i(141843);
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    AppMethodBeat.o(141843);
  }
  
  public void setSpilter(String paramString)
  {
    AppMethodBeat.i(141844);
    if (!bt.isNullOrNil(paramString))
    {
      this.JjQ = new a(paramString);
      addTextChangedListener(this.JjQ);
    }
    AppMethodBeat.o(141844);
  }
  
  final class a
    implements TextWatcher
  {
    private String JjS;
    
    public a(String paramString)
    {
      this.JjS = paramString;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(141839);
      if (paramEditable.toString().endsWith(this.JjS)) {
        MMAutoCompleteTextView.this.showDropDown();
      }
      AppMethodBeat.o(141839);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */