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
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private TextView iCg;
  private Button iRs;
  private EditText lMg;
  private TextView lMh;
  private int lMi;
  private int lMj;
  private int lMk;
  private int lMl;
  private int lMm;
  private int[] lMn;
  private View.OnFocusChangeListener lMo;
  private View.OnClickListener lMp;
  private int layout;
  private Context mContext;
  private au timerHandler;
  
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
    this.lMi = -1;
    this.lMj = -1;
    this.lMk = -1;
    this.layout = -1;
    this.lMl = 60;
    this.lMm = this.lMl;
    this.lMo = null;
    this.lMp = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.lMj = paramAttributeSet.getResourceId(1, -1);
    this.lMi = paramAttributeSet.getResourceId(3, -1);
    this.lMk = paramAttributeSet.getResourceId(0, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141938);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(141951);
    if (this.lMg != null)
    {
      this.lMg.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(141951);
      return;
    }
    ac.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.lMg });
    AppMethodBeat.o(141951);
  }
  
  public final void bso()
  {
    AppMethodBeat.i(141948);
    this.iRs.setVisibility(8);
    this.lMh.setVisibility(0);
    this.lMh.setText(getContext().getString(2131761267, new Object[] { Integer.valueOf(this.lMl) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.au(1000L, 1000L);
      AppMethodBeat.o(141948);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new au(getContext().getMainLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(141937);
          MMFormVerifyCodeInputView.f(MMFormVerifyCodeInputView.this);
          MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(2131761267, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this)) }));
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
      this.timerHandler.au(1000L, 1000L);
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
    return this.lMg;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(141952);
    if (this.lMg != null)
    {
      Editable localEditable = this.lMg.getText();
      AppMethodBeat.o(141952);
      return localEditable;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141952);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.iCg;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141939);
    super.onFinishInflate();
    this.iCg = ((TextView)findViewById(2131305902));
    this.lMg = ((EditText)findViewById(2131299306));
    this.lMh = ((TextView)findViewById(2131305845));
    this.iRs = ((Button)findViewById(2131304586));
    if ((this.iCg == null) || (this.lMg == null) || (this.lMh == null) || (this.iRs == null)) {
      ac.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.iCg, this.lMg, this.lMh, this.iRs });
    }
    for (;;)
    {
      if (this.lMg != null)
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
                break label73;
              }
              MMFormVerifyCodeInputView.this.setBackgroundResource(2131232723);
            }
            for (;;)
            {
              MMFormVerifyCodeInputView.c(MMFormVerifyCodeInputView.this);
              if (MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this) != null) {
                MMFormVerifyCodeInputView.d(MMFormVerifyCodeInputView.this).onFocusChange(paramAnonymousView, paramAnonymousBoolean);
              }
              AppMethodBeat.o(141935);
              return;
              label73:
              MMFormVerifyCodeInputView.this.setBackgroundResource(2131232724);
            }
          }
        };
        this.lMg.setOnFocusChangeListener(local1);
      }
      if (this.iRs != null) {
        this.iRs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(141936);
            if (MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this) != null) {
              MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this).onClick(paramAnonymousView);
            }
            AppMethodBeat.o(141936);
          }
        });
      }
      AppMethodBeat.o(141939);
      return;
      if (this.lMi != -1) {
        this.iCg.setText(this.lMi);
      }
      if (this.lMj != -1) {
        this.lMg.setHint(this.lMj);
      }
      if (this.lMk != -1) {
        this.iRs.setText(this.lMk);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(141949);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.lMg.setText("");
    this.lMh.setVisibility(8);
    this.lMm = this.lMl;
    this.iRs.setVisibility(0);
    AppMethodBeat.o(141949);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.lMo = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141943);
    if (this.lMg != null)
    {
      this.lMg.setHint(paramInt);
      AppMethodBeat.o(141943);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141943);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141941);
    if (this.lMg != null)
    {
      this.lMg.setHint(paramString);
      AppMethodBeat.o(141941);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141941);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(141945);
    if (this.lMg != null)
    {
      this.lMg.setImeOptions(paramInt);
      AppMethodBeat.o(141945);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141945);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(141950);
    if (this.lMg != null)
    {
      this.lMg.setInputType(paramInt);
      AppMethodBeat.o(141950);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141950);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lMp = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(141946);
    if (this.iRs != null)
    {
      this.iRs.setText(paramInt);
      AppMethodBeat.o(141946);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141946);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(141947);
    if (this.iRs != null)
    {
      this.iRs.setText(paramString);
      AppMethodBeat.o(141947);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141947);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141944);
    if (this.lMg != null)
    {
      this.lMg.setText(paramString);
      AppMethodBeat.o(141944);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141944);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141942);
    if (this.iCg != null)
    {
      this.iCg.setText(paramInt);
      AppMethodBeat.o(141942);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141942);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141940);
    if (this.iCg != null)
    {
      this.iCg.setText(paramString);
      AppMethodBeat.o(141940);
      return;
    }
    ac.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */