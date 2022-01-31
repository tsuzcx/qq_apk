package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.sdk.platformtools.bk;

public class MMAutoCompleteTextView
  extends AutoCompleteTextView
{
  final Drawable saf = getResources().getDrawable(a.f.list_clear);
  private a uUh;
  
  public MMAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.saf.setBounds(0, 0, this.saf.getIntrinsicWidth(), this.saf.getIntrinsicHeight());
    cml();
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramAnonymousView = MMAutoCompleteTextView.this;
        if (paramAnonymousView.getCompoundDrawables()[2] == null) {}
        while ((paramAnonymousMotionEvent.getAction() != 1) || (paramAnonymousMotionEvent.getX() <= paramAnonymousView.getWidth() - paramAnonymousView.getPaddingRight() - MMAutoCompleteTextView.this.saf.getIntrinsicWidth())) {
          return false;
        }
        paramAnonymousView.setText("");
        MMAutoCompleteTextView.a(MMAutoCompleteTextView.this);
        return false;
      }
    });
    addTextChangedListener(new MMAutoCompleteTextView.2(this));
    setOnFocusChangeListener(new MMAutoCompleteTextView.3(this));
  }
  
  private void cml()
  {
    if ((getText().toString().equals("")) || (!isFocused()))
    {
      cmn();
      return;
    }
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.saf, getCompoundDrawables()[3]);
  }
  
  private void cmn()
  {
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
  }
  
  public void setSpilter(String paramString)
  {
    if (!bk.bl(paramString))
    {
      this.uUh = new a(paramString);
      addTextChangedListener(this.uUh);
    }
  }
  
  private final class a
    implements TextWatcher
  {
    private String uUj;
    
    public a(String paramString)
    {
      this.uUj = paramString;
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().endsWith(this.uUj)) {
        MMAutoCompleteTextView.this.showDropDown();
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */