package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMFormInputView
  extends LinearLayout
{
  private TextView gpL;
  private int layout;
  private Context mContext;
  private View.OnFocusChangeListener naX;
  private EditText pLt;
  private int vJN;
  private int zjm;
  private int[] zjn;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106557);
    this.mContext = null;
    this.vJN = -1;
    this.zjm = -1;
    this.layout = -1;
    this.naX = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.zjm = paramAttributeSet.getResourceId(2, -1);
    this.vJN = paramAttributeSet.getResourceId(1, -1);
    this.layout = paramAttributeSet.getResourceId(0, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(106557);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(106566);
    if ((paramTextWatcher != null) && (this.pLt != null))
    {
      this.pLt.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(106566);
      return;
    }
    ab.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.pLt });
    AppMethodBeat.o(106566);
  }
  
  public EditText getContentEditText()
  {
    return this.pLt;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(106567);
    if (this.pLt != null)
    {
      Editable localEditable = this.pLt.getText();
      AppMethodBeat.o(106567);
      return localEditable;
    }
    ab.e("MicroMsg.MMFormInputView", "contentET is null!");
    AppMethodBeat.o(106567);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.gpL;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(106558);
    this.gpL = ((TextView)findViewById(2131820680));
    this.pLt = ((EditText)findViewById(2131820995));
    if ((this.gpL == null) || (this.pLt == null)) {
      ab.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.gpL, this.pLt });
    }
    for (;;)
    {
      if (this.pLt != null)
      {
        MMFormInputView.1 local1 = new MMFormInputView.1(this);
        this.pLt.setOnFocusChangeListener(local1);
      }
      AppMethodBeat.o(106558);
      return;
      if (this.vJN != -1) {
        this.gpL.setText(this.vJN);
      }
      if (this.zjm != -1) {
        this.pLt.setHint(this.zjm);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.naX = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(106562);
    if (this.pLt != null)
    {
      this.pLt.setHint(paramInt);
      AppMethodBeat.o(106562);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "contentET is null!");
    AppMethodBeat.o(106562);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(106560);
    if (this.pLt != null)
    {
      this.pLt.setHint(paramString);
      AppMethodBeat.o(106560);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "contentET is null!");
    AppMethodBeat.o(106560);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(106564);
    if (this.pLt != null)
    {
      this.pLt.setImeOptions(paramInt);
      AppMethodBeat.o(106564);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "contentET is null!");
    AppMethodBeat.o(106564);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(106565);
    if (this.pLt != null)
    {
      this.pLt.setInputType(paramInt);
      AppMethodBeat.o(106565);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "contentET is null!");
    AppMethodBeat.o(106565);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(106563);
    if (this.pLt != null)
    {
      this.pLt.setText(paramString);
      AppMethodBeat.o(106563);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "contentET is null!");
    AppMethodBeat.o(106563);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(106561);
    if (this.gpL != null)
    {
      this.gpL.setText(paramInt);
      AppMethodBeat.o(106561);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "titleTV is null!");
    AppMethodBeat.o(106561);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(106559);
    if (this.gpL != null)
    {
      this.gpL.setText(paramString);
      AppMethodBeat.o(106559);
      return;
    }
    ab.e("MicroMsg.MMFormInputView", "titleTV is null!");
    AppMethodBeat.o(106559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */