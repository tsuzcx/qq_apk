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
import com.tencent.mm.ui.an;

public class MMFormInputView
  extends LinearLayout
{
  private TextView iCg;
  private EditText lMg;
  private int lMi;
  private int lMj;
  private int[] lMn;
  private View.OnFocusChangeListener lMo;
  private int layout;
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
    this.lMi = -1;
    this.lMj = -1;
    this.layout = -1;
    this.lMo = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.lMj = paramAttributeSet.getResourceId(1, -1);
    this.lMi = paramAttributeSet.getResourceId(3, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.lMg != null))
    {
      this.lMg.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    an.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.lMg });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.lMg;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.lMg != null)
    {
      Editable localEditable = this.lMg.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.iCg;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.iCg = ((TextView)findViewById(2131305902));
    this.lMg = ((EditText)findViewById(2131299306));
    if ((this.iCg == null) || (this.lMg == null)) {
      an.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.iCg, this.lMg });
    }
    for (;;)
    {
      if (this.lMg != null)
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
        this.lMg.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.lMi != -1) {
        this.iCg.setText(this.lMi);
      }
      if (this.lMj != -1) {
        this.lMg.setHint(this.lMj);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.lMo = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.lMg != null)
    {
      this.lMg.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.lMg != null)
    {
      this.lMg.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.lMg != null)
    {
      this.lMg.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.lMg != null)
    {
      this.lMg.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.lMg != null)
    {
      this.lMg.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.iCg != null)
    {
      this.iCg.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.iCg != null)
    {
      this.iCg.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    an.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */