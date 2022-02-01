package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.k;
import com.tencent.mm.ui.bc;

public class MMFormInputView
  extends LinearLayout
{
  private int layout;
  private Context mContext;
  private View.OnFocusChangeListener mpk;
  private TextView pJJ;
  private EditText tID;
  private int tIF;
  private int tIG;
  private int[] tIK;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159168);
    this.mContext = null;
    this.tIF = -1;
    this.tIG = -1;
    this.layout = -1;
    this.mpk = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.FormItemView, paramInt, 0);
    this.tIG = paramAttributeSet.getResourceId(a.k.FormItemView_form_hint, -1);
    this.tIF = paramAttributeSet.getResourceId(a.k.FormItemView_form_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.k.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.tID != null))
    {
      this.tID.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    bc.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.tID });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.tID;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.tID != null)
    {
      Editable localEditable = this.tID.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    bc.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.pJJ;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.pJJ = ((TextView)findViewById(a.f.title));
    this.tID = ((EditText)findViewById(a.f.edittext));
    if ((this.pJJ == null) || (this.tID == null)) {
      bc.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.pJJ, this.tID });
    }
    for (;;)
    {
      if (this.tID != null)
      {
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(159167);
            if (paramAnonymousView == MMFormInputView.a(MMFormInputView.this))
            {
              MMFormInputView.b(MMFormInputView.this);
              if (!paramAnonymousBoolean) {
                break label74;
              }
              MMFormInputView.this.setBackgroundResource(a.e.input_bar_bg_active);
            }
            for (;;)
            {
              MMFormInputView.c(MMFormInputView.this);
              if (MMFormInputView.d(MMFormInputView.this) != null) {
                MMFormInputView.d(MMFormInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              AppMethodBeat.o(159167);
              return;
              label74:
              MMFormInputView.this.setBackgroundResource(a.e.input_bar_bg_normal);
            }
          }
        };
        this.tID.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.tIF != -1) {
        this.pJJ.setText(this.tIF);
      }
      if (this.tIG != -1) {
        this.tID.setHint(this.tIG);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mpk = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.tID != null)
    {
      this.tID.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.tID != null)
    {
      this.tID.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.tID != null)
    {
      this.tID.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.tID != null)
    {
      this.tID.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.tID != null)
    {
      this.tID.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.pJJ != null)
    {
      this.pJJ.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.pJJ != null)
    {
      this.pJJ.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    bc.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */