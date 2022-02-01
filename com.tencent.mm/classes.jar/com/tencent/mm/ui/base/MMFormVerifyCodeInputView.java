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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private TextView iYj;
  private Button jnu;
  private int layout;
  private Context mContext;
  private EditText mqR;
  private TextView mqS;
  private int mqT;
  private int mqU;
  private int mqV;
  private int mqW;
  private int mqX;
  private int[] mqY;
  private View.OnFocusChangeListener mqZ;
  private View.OnClickListener mra;
  private aw timerHandler;
  
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
    this.mqT = -1;
    this.mqU = -1;
    this.mqV = -1;
    this.layout = -1;
    this.mqW = 60;
    this.mqX = this.mqW;
    this.mqZ = null;
    this.mra = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.mqU = paramAttributeSet.getResourceId(1, -1);
    this.mqT = paramAttributeSet.getResourceId(3, -1);
    this.mqV = paramAttributeSet.getResourceId(0, -1);
    this.layout = paramAttributeSet.getResourceId(2, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141938);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(141951);
    if (this.mqR != null)
    {
      this.mqR.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(141951);
      return;
    }
    ae.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.mqR });
    AppMethodBeat.o(141951);
  }
  
  public final void bxk()
  {
    AppMethodBeat.i(141948);
    this.jnu.setVisibility(8);
    this.mqS.setVisibility(0);
    this.mqS.setText(getContext().getString(2131761267, new Object[] { Integer.valueOf(this.mqW) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.ay(1000L, 1000L);
      AppMethodBeat.o(141948);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new aw(getContext().getMainLooper(), new aw.a()
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
      this.timerHandler.ay(1000L, 1000L);
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
    return this.mqR;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(141952);
    if (this.mqR != null)
    {
      Editable localEditable = this.mqR.getText();
      AppMethodBeat.o(141952);
      return localEditable;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141952);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.iYj;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141939);
    super.onFinishInflate();
    this.iYj = ((TextView)findViewById(2131305902));
    this.mqR = ((EditText)findViewById(2131299306));
    this.mqS = ((TextView)findViewById(2131305845));
    this.jnu = ((Button)findViewById(2131304586));
    if ((this.iYj == null) || (this.mqR == null) || (this.mqS == null) || (this.jnu == null)) {
      ae.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.iYj, this.mqR, this.mqS, this.jnu });
    }
    for (;;)
    {
      if (this.mqR != null)
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
        this.mqR.setOnFocusChangeListener(local1);
      }
      if (this.jnu != null) {
        this.jnu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(141936);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/ui/base/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this) != null) {
              MMFormVerifyCodeInputView.e(MMFormVerifyCodeInputView.this).onClick(paramAnonymousView);
            }
            a.a(this, "com/tencent/mm/ui/base/MMFormVerifyCodeInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(141936);
          }
        });
      }
      AppMethodBeat.o(141939);
      return;
      if (this.mqT != -1) {
        this.iYj.setText(this.mqT);
      }
      if (this.mqU != -1) {
        this.mqR.setHint(this.mqU);
      }
      if (this.mqV != -1) {
        this.jnu.setText(this.mqV);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(141949);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.mqR.setText("");
    this.mqS.setVisibility(8);
    this.mqX = this.mqW;
    this.jnu.setVisibility(0);
    AppMethodBeat.o(141949);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mqZ = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(141943);
    if (this.mqR != null)
    {
      this.mqR.setHint(paramInt);
      AppMethodBeat.o(141943);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141943);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141941);
    if (this.mqR != null)
    {
      this.mqR.setHint(paramString);
      AppMethodBeat.o(141941);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141941);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(141945);
    if (this.mqR != null)
    {
      this.mqR.setImeOptions(paramInt);
      AppMethodBeat.o(141945);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141945);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(141950);
    if (this.mqR != null)
    {
      this.mqR.setInputType(paramInt);
      AppMethodBeat.o(141950);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141950);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mra = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(141946);
    if (this.jnu != null)
    {
      this.jnu.setText(paramInt);
      AppMethodBeat.o(141946);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141946);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(141947);
    if (this.jnu != null)
    {
      this.jnu.setText(paramString);
      AppMethodBeat.o(141947);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(141947);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(141944);
    if (this.mqR != null)
    {
      this.mqR.setText(paramString);
      AppMethodBeat.o(141944);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(141944);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(141942);
    if (this.iYj != null)
    {
      this.iYj.setText(paramInt);
      AppMethodBeat.o(141942);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141942);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(141940);
    if (this.iYj != null)
    {
      this.iYj.setText(paramString);
      AppMethodBeat.o(141940);
      return;
    }
    ae.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(141940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */