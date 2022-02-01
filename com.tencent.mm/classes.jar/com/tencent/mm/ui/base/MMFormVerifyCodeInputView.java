package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private View.OnFocusChangeListener jQt;
  private int layout;
  private Context mContext;
  private TextView mNb;
  private Button nds;
  private EditText qDO;
  private TextView qDP;
  private int qDQ;
  private int qDR;
  private int qDS;
  private int qDT;
  private int qDU;
  private int[] qDV;
  private View.OnClickListener qDW;
  private MTimerHandler timerHandler;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141938);
    this.mContext = null;
    this.qDQ = -1;
    this.qDR = -1;
    this.qDS = -1;
    this.layout = -1;
    this.qDT = 60;
    this.qDU = this.qDT;
    this.jQt = null;
    this.qDW = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FormItemView, paramInt, 0);
    this.qDR = paramAttributeSet.getResourceId(a.m.FormItemView_form_hint, -1);
    this.qDQ = paramAttributeSet.getResourceId(a.m.FormItemView_form_title, -1);
    this.qDS = paramAttributeSet.getResourceId(a.m.FormItemView_form_btn_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.m.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141938);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(141951);
    if (this.qDO != null)
    {
      this.qDO.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(141951);
      return;
    }
    Log.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.qDO });
    AppMethodBeat.o(141951);
  }
  
  public final void cgz()
  {
    AppMethodBeat.i(141948);
    this.nds.setVisibility(8);
    this.qDP.setVisibility(0);
    this.qDP.setText(getContext().getString(a.k.mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(this.qDT) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.startTimer(1000L);
      AppMethodBeat.o(141948);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new MTimerHandler(getContext().getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(141937);
          MMFormVerifyCodeInputView.f(MMFormVerifyCodeInputView.this);
          MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(a.k.mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this)) }));
          if (MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this) == 0)
          {
            MMFormVerifyCodeInputView.i(MMFormVerifyCodeInputView.this).stopTimer();
            MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this, MMFormVerifyCodeInputView.j(MMFormVerifyCodeInputView.this));
            MMFormVerifyCodeInputView.k(MMFormVerifyCodeInputView.this).setVisibility(0);
            MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setVisibility(8);
          }
          AppMethodBeat.o(141937);
          return true;
        }
      }, true);
      this.timerHandler.startTimer(1000L);
      AppMethodBeat.o(141948);
      return;
    }
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    AppMethodBeat.o(141948);
  }
  
  public EditText getContentEditText()
  {
    return this.qDO;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(141952);
    if (this.qDO != null)
    {
      Editable localEditable = this.qDO.getText();
      AppMethodBeat.o(141952);
      return localEditable;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141952);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.mNb;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141939);
    super.onFinishInflate();
    this.mNb = ((TextView)findViewById(a.g.title));
    this.qDO = ((EditText)findViewById(a.g.edittext));
    this.qDP = ((TextView)findViewById(a.g.timer));
    this.nds = ((Button)findViewById(a.g.send_verify_code_btn));
    if ((this.mNb == null) || (this.qDO == null) || (this.qDP == null) || (this.nds == null)) {
      Log.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.mNb, this.qDO, this.qDP, this.nds });
    }
    for (;;)
    {
      if (this.qDO != null)
      {
        View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(141935);
            if (paramAnonymousView == MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this))
            {
              MMFormVerifyCodeInputView.b(MMFormVerifyCodeInputView.this);
              if (!paramAnonymousBoolean) {
                break label74;
              }
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.f.input_bar_bg_active);
            }
            for (;;)
            {
              MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
              if (MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this) != null) {
                MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              AppMethodBeat.o(141935);
              return;
              label74:
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.f.input_bar_bg_normal);
            }
          }
        };
        this.qDO.setOnFocusChangeListener(local1);
      }
      if (this.nds != null) {
        this.nds.setOnClickListener(new MMFormVerifyCodeInputView.2(this));
      }
      AppMethodBeat.o(141939);
      return;
      if (this.qDQ != -1) {
        this.mNb.setText(this.qDQ);
      }
      if (this.qDR != -1) {
        this.qDO.setHint(this.qDR);
      }
      if (this.qDS != -1) {
        this.nds.setText(this.qDS);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(141949);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.qDO.setText("");
    this.qDP.setVisibility(8);
    this.qDU = this.qDT;
    this.nds.setVisibility(0);
    AppMethodBeat.o(141949);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.jQt = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141943);
    if (this.qDO != null)
    {
      this.qDO.setHint(paramInt);
      AppMethodBeat.o(141943);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141943);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141941);
    if (this.qDO != null)
    {
      this.qDO.setHint(paramString);
      AppMethodBeat.o(141941);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141941);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(141945);
    if (this.qDO != null)
    {
      this.qDO.setImeOptions(paramInt);
      AppMethodBeat.o(141945);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141945);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(141950);
    if (this.qDO != null)
    {
      this.qDO.setInputType(paramInt);
      AppMethodBeat.o(141950);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141950);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.qDW = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(141946);
    if (this.nds != null)
    {
      this.nds.setText(paramInt);
      AppMethodBeat.o(141946);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141946);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(141947);
    if (this.nds != null)
    {
      this.nds.setText(paramString);
      AppMethodBeat.o(141947);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141947);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141944);
    if (this.qDO != null)
    {
      this.qDO.setText(paramString);
      AppMethodBeat.o(141944);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141944);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141942);
    if (this.mNb != null)
    {
      this.mNb.setText(paramInt);
      AppMethodBeat.o(141942);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141942);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141940);
    if (this.mNb != null)
    {
      this.mNb.setText(paramString);
      AppMethodBeat.o(141940);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */