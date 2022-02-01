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
import com.tencent.mm.cl.a.a;
import com.tencent.mm.ui.ap;

public class MMFormInputView
  extends LinearLayout
{
  private TextView iVq;
  private int layout;
  private Context mContext;
  private EditText mlU;
  private int mlW;
  private int mlX;
  private int[] mmb;
  private View.OnFocusChangeListener mmc;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159168);
    this.mContext = null;
    this.mlW = -1;
    this.mlX = -1;
    this.layout = -1;
    this.mmc = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.mlX = paramAttributeSet.getResourceId(1, -1);
    this.mlW = paramAttributeSet.getResourceId(3, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.mlU != null))
    {
      this.mlU.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    ap.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.mlU });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.mlU;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.mlU != null)
    {
      Editable localEditable = this.mlU.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.iVq;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.iVq = ((TextView)findViewById(2131305902));
    this.mlU = ((EditText)findViewById(2131299306));
    if ((this.iVq == null) || (this.mlU == null)) {
      ap.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.iVq, this.mlU });
    }
    for (;;)
    {
      if (this.mlU != null)
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
        this.mlU.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.mlW != -1) {
        this.iVq.setText(this.mlW);
      }
      if (this.mlX != -1) {
        this.mlU.setHint(this.mlX);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mmc = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.mlU != null)
    {
      this.mlU.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.mlU != null)
    {
      this.mlU.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.mlU != null)
    {
      this.mlU.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.mlU != null)
    {
      this.mlU.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.mlU != null)
    {
      this.mlU.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.iVq != null)
    {
      this.iVq.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.iVq != null)
    {
      this.iVq.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */