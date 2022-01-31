package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private TextView eXO;
  private am eyl;
  private Button fqN;
  private View.OnFocusChangeListener kEz = null;
  private int layout = -1;
  private Context mContext = null;
  private EditText nge;
  private int rSP = -1;
  private int uUR = -1;
  private int[] uUS;
  private TextView uVb;
  private int uVc = -1;
  private int uVd = 60;
  private int uVe = this.uVd;
  private View.OnClickListener uVf = null;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FormItemView, paramInt, 0);
    this.uUR = paramAttributeSet.getResourceId(a.m.FormItemView_form_hint, -1);
    this.rSP = paramAttributeSet.getResourceId(a.m.FormItemView_form_title, -1);
    this.uVc = paramAttributeSet.getResourceId(a.m.FormItemView_form_btn_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.m.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    if (this.nge != null)
    {
      this.nge.addTextChangedListener(paramTextWatcher);
      return;
    }
    y.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.nge });
  }
  
  public final void cAG()
  {
    this.fqN.setVisibility(8);
    this.uVb.setVisibility(0);
    this.uVb.setText(getContext().getString(a.k.mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(this.uVd) }));
    if (this.eyl != null)
    {
      this.eyl.stopTimer();
      this.eyl.S(1000L, 1000L);
    }
    do
    {
      return;
      if (getContext() != null)
      {
        this.eyl = new am(getContext().getMainLooper(), new MMFormVerifyCodeInputView.3(this), true);
        this.eyl.S(1000L, 1000L);
        return;
      }
    } while (this.eyl == null);
    this.eyl.stopTimer();
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
    y.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.eXO;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.eXO = ((TextView)findViewById(a.g.title));
    this.nge = ((EditText)findViewById(a.g.edittext));
    this.uVb = ((TextView)findViewById(a.g.timer));
    this.fqN = ((Button)findViewById(a.g.send_verify_code_btn));
    if ((this.eXO == null) || (this.nge == null) || (this.uVb == null) || (this.fqN == null)) {
      y.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.eXO, this.nge, this.uVb, this.fqN });
    }
    for (;;)
    {
      if (this.nge != null)
      {
        MMFormVerifyCodeInputView.1 local1 = new MMFormVerifyCodeInputView.1(this);
        this.nge.setOnFocusChangeListener(local1);
      }
      if (this.fqN != null) {
        this.fqN.setOnClickListener(new MMFormVerifyCodeInputView.2(this));
      }
      return;
      if (this.rSP != -1) {
        this.eXO.setText(this.rSP);
      }
      if (this.uUR != -1) {
        this.nge.setHint(this.uUR);
      }
      if (this.uVc != -1) {
        this.fqN.setText(this.uVc);
      }
    }
  }
  
  public final void reset()
  {
    if (this.eyl != null) {
      this.eyl.stopTimer();
    }
    this.nge.setText("");
    this.uVb.setVisibility(8);
    this.uVe = this.uVd;
    this.fqN.setVisibility(0);
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
    y.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setHint(String paramString)
  {
    if (this.nge != null)
    {
      this.nge.setHint(paramString);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setImeOption(int paramInt)
  {
    if (this.nge != null)
    {
      this.nge.setImeOptions(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setInputType(int paramInt)
  {
    if (this.nge != null)
    {
      this.nge.setInputType(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.uVf = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    if (this.fqN != null)
    {
      this.fqN.setText(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
  }
  
  public void setSmsBtnText(String paramString)
  {
    if (this.fqN != null)
    {
      this.fqN.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
  }
  
  public void setText(String paramString)
  {
    if (this.nge != null)
    {
      this.nge.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
  }
  
  public void setTitle(int paramInt)
  {
    if (this.eXO != null)
    {
      this.eXO.setText(paramInt);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
  }
  
  public void setTitle(String paramString)
  {
    if (this.eXO != null)
    {
      this.eXO.setText(paramString);
      return;
    }
    y.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */