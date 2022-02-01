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
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.k;
import com.tencent.mm.ui.av;

public class MMFormInputView
  extends LinearLayout
{
  private View.OnFocusChangeListener jQt;
  private int layout;
  private Context mContext;
  private TextView mNb;
  private EditText qDO;
  private int qDQ;
  private int qDR;
  private int[] qDV;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159168);
    this.mContext = null;
    this.qDQ = -1;
    this.qDR = -1;
    this.layout = -1;
    this.jQt = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.FormItemView, paramInt, 0);
    this.qDR = paramAttributeSet.getResourceId(a.k.FormItemView_form_hint, -1);
    this.qDQ = paramAttributeSet.getResourceId(a.k.FormItemView_form_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.k.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.qDO != null))
    {
      this.qDO.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    av.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.qDO });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.qDO;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.qDO != null)
    {
      Editable localEditable = this.qDO.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    av.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.mNb;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.mNb = ((TextView)findViewById(a.f.title));
    this.qDO = ((EditText)findViewById(a.f.edittext));
    if ((this.mNb == null) || (this.qDO == null)) {
      av.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.mNb, this.qDO });
    }
    for (;;)
    {
      if (this.qDO != null)
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
        this.qDO.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.qDQ != -1) {
        this.mNb.setText(this.qDQ);
      }
      if (this.qDR != -1) {
        this.qDO.setHint(this.qDR);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.jQt = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.qDO != null)
    {
      this.qDO.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.qDO != null)
    {
      this.qDO.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.qDO != null)
    {
      this.qDO.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.qDO != null)
    {
      this.qDO.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.qDO != null)
    {
      this.qDO.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.mNb != null)
    {
      this.mNb.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.mNb != null)
    {
      this.mNb.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    av.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */