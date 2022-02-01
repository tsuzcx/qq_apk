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
import com.tencent.mm.af.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private TextView ica;
  private Button irm;
  private int layout;
  private EditText lmq;
  private TextView lmr;
  private int lms;
  private int lmt;
  private int lmu;
  private int lmv;
  private int lmw;
  private int[] lmx;
  private View.OnFocusChangeListener lmy;
  private View.OnClickListener lmz;
  private Context mContext;
  private av timerHandler;
  
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
    this.lms = -1;
    this.lmt = -1;
    this.lmu = -1;
    this.layout = -1;
    this.lmv = 60;
    this.lmw = this.lmv;
    this.lmy = null;
    this.lmz = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.lmt = paramAttributeSet.getResourceId(1, -1);
    this.lms = paramAttributeSet.getResourceId(3, -1);
    this.lmu = paramAttributeSet.getResourceId(0, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141938);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(141951);
    if (this.lmq != null)
    {
      this.lmq.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(141951);
      return;
    }
    ad.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.lmq });
    AppMethodBeat.o(141951);
  }
  
  public final void blz()
  {
    AppMethodBeat.i(141948);
    this.irm.setVisibility(8);
    this.lmr.setVisibility(0);
    this.lmr.setText(getContext().getString(2131761267, new Object[] { Integer.valueOf(this.lmv) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.av(1000L, 1000L);
      AppMethodBeat.o(141948);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new av(getContext().getMainLooper(), new av.a()
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
      this.timerHandler.av(1000L, 1000L);
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
    return this.lmq;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(141952);
    if (this.lmq != null)
    {
      Editable localEditable = this.lmq.getText();
      AppMethodBeat.o(141952);
      return localEditable;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141952);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.ica;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141939);
    super.onFinishInflate();
    this.ica = ((TextView)findViewById(2131305902));
    this.lmq = ((EditText)findViewById(2131299306));
    this.lmr = ((TextView)findViewById(2131305845));
    this.irm = ((Button)findViewById(2131304586));
    if ((this.ica == null) || (this.lmq == null) || (this.lmr == null) || (this.irm == null)) {
      ad.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.ica, this.lmq, this.lmr, this.irm });
    }
    for (;;)
    {
      if (this.lmq != null)
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
        this.lmq.setOnFocusChangeListener(local1);
      }
      if (this.irm != null) {
        this.irm.setOnClickListener(new View.OnClickListener()
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
      if (this.lms != -1) {
        this.ica.setText(this.lms);
      }
      if (this.lmt != -1) {
        this.lmq.setHint(this.lmt);
      }
      if (this.lmu != -1) {
        this.irm.setText(this.lmu);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(141949);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.lmq.setText("");
    this.lmr.setVisibility(8);
    this.lmw = this.lmv;
    this.irm.setVisibility(0);
    AppMethodBeat.o(141949);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.lmy = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141943);
    if (this.lmq != null)
    {
      this.lmq.setHint(paramInt);
      AppMethodBeat.o(141943);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141943);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141941);
    if (this.lmq != null)
    {
      this.lmq.setHint(paramString);
      AppMethodBeat.o(141941);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141941);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(141945);
    if (this.lmq != null)
    {
      this.lmq.setImeOptions(paramInt);
      AppMethodBeat.o(141945);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141945);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(141950);
    if (this.lmq != null)
    {
      this.lmq.setInputType(paramInt);
      AppMethodBeat.o(141950);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141950);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.lmz = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(141946);
    if (this.irm != null)
    {
      this.irm.setText(paramInt);
      AppMethodBeat.o(141946);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141946);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(141947);
    if (this.irm != null)
    {
      this.irm.setText(paramString);
      AppMethodBeat.o(141947);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141947);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141944);
    if (this.lmq != null)
    {
      this.lmq.setText(paramString);
      AppMethodBeat.o(141944);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141944);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141942);
    if (this.ica != null)
    {
      this.ica.setText(paramInt);
      AppMethodBeat.o(141942);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141942);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141940);
    if (this.ica != null)
    {
      this.ica.setText(paramString);
      AppMethodBeat.o(141940);
      return;
    }
    ad.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */