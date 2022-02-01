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
import com.tencent.mm.cm.a.a;
import com.tencent.mm.ui.an;

public class MMFormInputView
  extends LinearLayout
{
  private TextView ica;
  private int layout;
  private EditText lmq;
  private int lms;
  private int lmt;
  private int[] lmx;
  private View.OnFocusChangeListener lmy;
  private Context mContext;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159168);
    this.mContext = null;
    this.lms = -1;
    this.lmt = -1;
    this.layout = -1;
    this.lmy = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.lmt = paramAttributeSet.getResourceId(1, -1);
    this.lms = paramAttributeSet.getResourceId(3, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.lmq != null))
    {
      this.lmq.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    an.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.lmq });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.lmq;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.lmq != null)
    {
      Editable localEditable = this.lmq.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.ica;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.ica = ((TextView)findViewById(2131305902));
    this.lmq = ((EditText)findViewById(2131299306));
    if ((this.ica == null) || (this.lmq == null)) {
      an.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.ica, this.lmq });
    }
    for (;;)
    {
      if (this.lmq != null)
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
                break label73;
              }
              MMFormInputView.this.setBackgroundResource(2131232723);
            }
            for (;;)
            {
              MMFormInputView.c(MMFormInputView.this);
              if (MMFormInputView.d(MMFormInputView.this) != null) {
                MMFormInputView.d(MMFormInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              AppMethodBeat.o(159167);
              return;
              label73:
              MMFormInputView.this.setBackgroundResource(2131232724);
            }
          }
        };
        this.lmq.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.lms != -1) {
        this.ica.setText(this.lms);
      }
      if (this.lmt != -1) {
        this.lmq.setHint(this.lmt);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.lmy = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.lmq != null)
    {
      this.lmq.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.lmq != null)
    {
      this.lmq.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.lmq != null)
    {
      this.lmq.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.lmq != null)
    {
      this.lmq.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.lmq != null)
    {
      this.lmq.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.ica != null)
    {
      this.ica.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.ica != null)
    {
      this.ica.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */