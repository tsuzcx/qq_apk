package com.tencent.mm.ui.base;

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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private MMClearEditText adQt;
  private int layout;
  private Context mContext;
  private View.OnFocusChangeListener mpk;
  private TextView pJJ;
  private View pXc;
  private Button qaJ;
  private TextView tIE;
  private int tIF;
  private int tIG;
  private int tIH;
  private int tII;
  private int tIJ;
  private int[] tIK;
  private View.OnClickListener tIL;
  private MTimerHandler timerHandler;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141938);
    this.mContext = null;
    this.tIF = -1;
    this.tIG = -1;
    this.tIH = -1;
    this.layout = -1;
    this.tII = 60;
    this.tIJ = this.tII;
    this.mpk = null;
    this.tIL = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FormItemView, paramInt, 0);
    this.tIG = paramAttributeSet.getResourceId(a.m.FormItemView_form_hint, -1);
    this.tIF = paramAttributeSet.getResourceId(a.m.FormItemView_form_title, -1);
    this.tIH = paramAttributeSet.getResourceId(a.m.FormItemView_form_btn_title, -1);
    this.layout = paramAttributeSet.getResourceId(a.m.FormItemView_form_layout, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141938);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(141951);
    if (this.adQt != null)
    {
      this.adQt.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(141951);
      return;
    }
    Log.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.adQt });
    AppMethodBeat.o(141951);
  }
  
  public final void cHv()
  {
    AppMethodBeat.i(141948);
    this.qaJ.setVisibility(8);
    this.tIE.setVisibility(0);
    this.tIE.setText(getContext().getString(a.k.mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(this.tII) }));
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
          AppMethodBeat.i(251443);
          MMFormVerifyCodeInputView.g(MMFormVerifyCodeInputView.this);
          MMFormVerifyCodeInputView.i(MMFormVerifyCodeInputView.this).setText(MMFormVerifyCodeInputView.this.getContext().getString(a.k.mobile_input_send_sms_timer_title, new Object[] { Integer.valueOf(MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this)) }));
          if (MMFormVerifyCodeInputView.h(MMFormVerifyCodeInputView.this) == 0)
          {
            MMFormVerifyCodeInputView.j(MMFormVerifyCodeInputView.this).stopTimer();
            MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this, MMFormVerifyCodeInputView.k(MMFormVerifyCodeInputView.this));
            MMFormVerifyCodeInputView.l(MMFormVerifyCodeInputView.this).setVisibility(0);
            MMFormVerifyCodeInputView.i(MMFormVerifyCodeInputView.this).setVisibility(8);
          }
          AppMethodBeat.o(251443);
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
    return this.adQt;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(141952);
    if (this.adQt != null)
    {
      Editable localEditable = this.adQt.getText();
      AppMethodBeat.o(141952);
      return localEditable;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141952);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.pJJ;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141939);
    super.onFinishInflate();
    this.pJJ = ((TextView)findViewById(a.g.title));
    this.adQt = ((MMClearEditText)findViewById(a.g.edittext));
    this.pXc = findViewById(a.g.clear_mask);
    this.pXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251433);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMFormVerifyCodeInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        MMFormVerifyCodeInputView.a(MMFormVerifyCodeInputView.this).jmg();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMFormVerifyCodeInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251433);
      }
    });
    if (com.tencent.mm.cd.a.mp(getContext()))
    {
      findViewById(a.g.timer).setVisibility(8);
      findViewById(a.g.send_verify_code_btn).setVisibility(8);
      findViewById(a.g.large_text_layout).setVisibility(0);
      this.tIE = ((TextView)findViewById(a.g.large_text_timer));
      this.qaJ = ((Button)findViewById(a.g.large_text_send_verify_code_btn));
      this.qaJ.setVisibility(0);
      if ((this.pJJ != null) && (this.adQt != null) && (this.tIE != null) && (this.qaJ != null)) {
        break label310;
      }
      Log.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.pJJ, this.adQt, this.tIE, this.qaJ });
    }
    for (;;)
    {
      if (this.adQt != null)
      {
        View.OnFocusChangeListener local2 = new View.OnFocusChangeListener()
        {
          public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(251436);
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
              AppMethodBeat.o(251436);
              return;
              label74:
              MMFormVerifyCodeInputView.this.setBackgroundResource(a.f.input_bar_bg_normal);
            }
          }
        };
        this.adQt.setOnFocusChangeListener(local2);
        this.adQt.setClearBtnCallBcakListener(new MMClearEditText.a()
        {
          public final void showClearBtn(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(251437);
            View localView = MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this);
            if (paramAnonymousBoolean) {}
            for (int i = 0;; i = 8)
            {
              localView.setVisibility(i);
              AppMethodBeat.o(251437);
              return;
            }
          }
        });
      }
      if (this.qaJ != null) {
        this.qaJ.setOnClickListener(new MMFormVerifyCodeInputView.4(this));
      }
      AppMethodBeat.o(141939);
      return;
      this.tIE = ((TextView)findViewById(a.g.timer));
      this.qaJ = ((Button)findViewById(a.g.send_verify_code_btn));
      break;
      label310:
      if (this.tIF != -1) {
        this.pJJ.setText(this.tIF);
      }
      if (this.tIG != -1) {
        this.adQt.setHint(this.tIG);
      }
      if (this.tIH != -1) {
        this.qaJ.setText(this.tIH);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(141949);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.adQt.setText("");
    this.tIE.setVisibility(8);
    this.tIJ = this.tII;
    this.qaJ.setVisibility(0);
    AppMethodBeat.o(141949);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mpk = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141943);
    if (this.adQt != null)
    {
      this.adQt.setHint(paramInt);
      AppMethodBeat.o(141943);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141943);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141941);
    if (this.adQt != null)
    {
      this.adQt.setHint(paramString);
      AppMethodBeat.o(141941);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141941);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(141945);
    if (this.adQt != null)
    {
      this.adQt.setImeOptions(paramInt);
      AppMethodBeat.o(141945);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141945);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(141950);
    if (this.adQt != null)
    {
      this.adQt.setInputType(paramInt);
      AppMethodBeat.o(141950);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141950);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.tIL = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(141946);
    if (this.qaJ != null)
    {
      this.qaJ.setText(paramInt);
      AppMethodBeat.o(141946);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141946);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(141947);
    if (this.qaJ != null)
    {
      this.qaJ.setText(paramString);
      AppMethodBeat.o(141947);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141947);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141944);
    if (this.adQt != null)
    {
      this.adQt.setText(paramString);
      AppMethodBeat.o(141944);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141944);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141942);
    if (this.pJJ != null)
    {
      this.pJJ.setText(paramInt);
      AppMethodBeat.o(141942);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141942);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141940);
    if (this.pJJ != null)
    {
      this.pJJ.setText(paramString);
      AppMethodBeat.o(141940);
      return;
    }
    Log.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */