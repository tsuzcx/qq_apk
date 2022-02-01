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
import com.tencent.mm.ck.a.a;
import com.tencent.mm.ui.ap;

public class MMFormInputView
  extends LinearLayout
{
  private TextView iYj;
  private int layout;
  private Context mContext;
  private EditText mqR;
  private int mqT;
  private int mqU;
  private int[] mqY;
  private View.OnFocusChangeListener mqZ;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159168);
    this.mContext = null;
    this.mqT = -1;
    this.mqU = -1;
    this.layout = -1;
    this.mqZ = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.mqU = paramAttributeSet.getResourceId(1, -1);
    this.mqT = paramAttributeSet.getResourceId(3, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.mqR != null))
    {
      this.mqR.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    ap.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.mqR });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.mqR;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.mqR != null)
    {
      Editable localEditable = this.mqR.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.iYj;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.iYj = ((TextView)findViewById(2131305902));
    this.mqR = ((EditText)findViewById(2131299306));
    if ((this.iYj == null) || (this.mqR == null)) {
      ap.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.iYj, this.mqR });
    }
    for (;;)
    {
      if (this.mqR != null)
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
        this.mqR.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.mqT != -1) {
        this.iYj.setText(this.mqT);
      }
      if (this.mqU != -1) {
        this.mqR.setHint(this.mqU);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mqZ = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.mqR != null)
    {
      this.mqR.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.mqR != null)
    {
      this.mqR.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.mqR != null)
    {
      this.mqR.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.mqR != null)
    {
      this.mqR.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.mqR != null)
    {
      this.mqR.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.iYj != null)
    {
      this.iYj.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.iYj != null)
    {
      this.iYj.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    ap.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */