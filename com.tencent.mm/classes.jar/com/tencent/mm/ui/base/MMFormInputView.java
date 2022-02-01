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
import com.tencent.mm.ui.as;

public class MMFormInputView
  extends LinearLayout
{
  private View.OnFocusChangeListener heD;
  private TextView jVO;
  private int layout;
  private Context mContext;
  private EditText nBD;
  private int nBF;
  private int nBG;
  private int[] nBK;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159168);
    this.mContext = null;
    this.nBF = -1;
    this.nBG = -1;
    this.layout = -1;
    this.heD = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.nBG = paramAttributeSet.getResourceId(1, -1);
    this.nBF = paramAttributeSet.getResourceId(3, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(159168);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(159177);
    if ((paramTextWatcher != null) && (this.nBD != null))
    {
      this.nBD.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(159177);
      return;
    }
    as.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.nBD });
    AppMethodBeat.o(159177);
  }
  
  public EditText getContentEditText()
  {
    return this.nBD;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(159178);
    if (this.nBD != null)
    {
      Editable localEditable = this.nBD.getText();
      AppMethodBeat.o(159178);
      return localEditable;
    }
    as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159178);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.jVO;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(159169);
    this.jVO = ((TextView)findViewById(2131309195));
    this.nBD = ((EditText)findViewById(2131299910));
    if ((this.jVO == null) || (this.nBD == null)) {
      as.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.jVO, this.nBD });
    }
    for (;;)
    {
      if (this.nBD != null)
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
              MMFormInputView.this.setBackgroundResource(2131233162);
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
              MMFormInputView.this.setBackgroundResource(2131233163);
            }
          }
        };
        this.nBD.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(159169);
      return;
      if (this.nBF != -1) {
        this.jVO.setText(this.nBF);
      }
      if (this.nBG != -1) {
        this.nBD.setHint(this.nBG);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.heD = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(159173);
    if (this.nBD != null)
    {
      this.nBD.setHint(paramInt);
      AppMethodBeat.o(159173);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159173);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(159171);
    if (this.nBD != null)
    {
      this.nBD.setHint(paramString);
      AppMethodBeat.o(159171);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159171);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(159175);
    if (this.nBD != null)
    {
      this.nBD.setImeOptions(paramInt);
      AppMethodBeat.o(159175);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159175);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(159176);
    if (this.nBD != null)
    {
      this.nBD.setInputType(paramInt);
      AppMethodBeat.o(159176);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159176);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(159174);
    if (this.nBD != null)
    {
      this.nBD.setText(paramString);
      AppMethodBeat.o(159174);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "contentET is null!", new Object[0]);
    AppMethodBeat.o(159174);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(159172);
    if (this.jVO != null)
    {
      this.jVO.setText(paramInt);
      AppMethodBeat.o(159172);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159172);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(159170);
    if (this.jVO != null)
    {
      this.jVO.setText(paramString);
      AppMethodBeat.o(159170);
      return;
    }
    as.e("MicroMsg.MMFormInputView", "titleTV is null!", new Object[0]);
    AppMethodBeat.o(159170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */