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
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.y;

public class MMFormInputView
  extends LinearLayout
{
  private TextView eXO;
  private View.OnFocusChangeListener kEz = null;
  private int layout = -1;
  private Context mContext = null;
  private EditText nge;
  private int rSP = -1;
  private int uUR = -1;
  private int[] uUS;
  
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FormItemView, paramInt, 0);
    this.uUR = paramAttributeSet.getResourceId(a.m.FormItemView_form_hint, -1);
    this.rSP = paramAttributeSet.getResourceId(a.m.FormItemView_form_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.m.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    if ((paramTextWatcher != null) && (this.nge != null))
    {
      this.nge.addTextChangedListener(paramTextWatcher);
      return;
    }
    y.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.nge });
  }
  
  public EditText getContentEditText()
  {
    return this.nge;
  }
  
  public Editable getText()
  {
    if (this.nge != null) {
      return this.nge.getText();
    }
    y.e("MicroMsg.MMFormInputView", "contentET is null!");
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.eXO;
  }
  
  public void onFinishInflate()
  {
    this.eXO = ((TextView)findViewById(a.g.title));
    this.nge = ((EditText)findViewById(a.g.edittext));
    if ((this.eXO == null) || (this.nge == null)) {
      y.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", new Object[] { this.eXO, this.nge });
    }
    for (;;)
    {
      if (this.nge != null)
      {
        MMFormInputView.1 local1 = new MMFormInputView.1(this);
        this.nge.setOnFocusChangeListener(local1);
      }
      return;
      if (this.rSP != -1) {
        this.eXO.setText(this.rSP);
      }
      if (this.uUR != -1) {
        this.nge.setHint(this.uUR);
      }
    }
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.kEz = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    if (this.nge != null)
    {
      this.nge.setHint(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "contentET is null!");
  }
  
  public void setHint(String paramString)
  {
    if (this.nge != null)
    {
      this.nge.setHint(paramString);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "contentET is null!");
  }
  
  public void setImeOption(int paramInt)
  {
    if (this.nge != null)
    {
      this.nge.setImeOptions(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "contentET is null!");
  }
  
  public void setInputType(int paramInt)
  {
    if (this.nge != null)
    {
      this.nge.setInputType(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "contentET is null!");
  }
  
  public void setText(String paramString)
  {
    if (this.nge != null)
    {
      this.nge.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "contentET is null!");
  }
  
  public void setTitle(int paramInt)
  {
    if (this.eXO != null)
    {
      this.eXO.setText(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "titleTV is null!");
  }
  
  public void setTitle(String paramString)
  {
    if (this.eXO != null)
    {
      this.eXO.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormInputView", "titleTV is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormInputView
 * JD-Core Version:    0.7.0.1
 */