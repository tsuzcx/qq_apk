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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class MMFormVerifyCodeInputView
  extends LinearLayout
{
  private Button gIq;
  private TextView gpL;
  private int layout;
  private Context mContext;
  private View.OnFocusChangeListener naX;
  private EditText pLt;
  private ap timerHandler;
  private int vJN;
  private View.OnClickListener zjA;
  private int zjm;
  private int[] zjn;
  private TextView zjw;
  private int zjx;
  private int zjy;
  private int zjz;
  
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormVerifyCodeInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106595);
    this.mContext = null;
    this.vJN = -1;
    this.zjm = -1;
    this.zjx = -1;
    this.layout = -1;
    this.zjy = 60;
    this.zjz = this.zjy;
    this.naX = null;
    this.zjA = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.zjm = paramAttributeSet.getResourceId(2, -1);
    this.vJN = paramAttributeSet.getResourceId(1, -1);
    this.zjx = paramAttributeSet.getResourceId(3, -1);
    this.layout = paramAttributeSet.getResourceId(0, this.layout);
    paramAttributeSet.recycle();
    inflate(paramContext, this.layout, this);
    this.mContext = paramContext;
    AppMethodBeat.o(106595);
  }
  
  public final void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    AppMethodBeat.i(106608);
    if (this.pLt != null)
    {
      this.pLt.addTextChangedListener(paramTextWatcher);
      AppMethodBeat.o(106608);
      return;
    }
    ab.w("MicroMsg.MMFormVerifyCodeInputView", "watcher : %s, contentET : %s", new Object[] { paramTextWatcher, this.pLt });
    AppMethodBeat.o(106608);
  }
  
  public final void dDR()
  {
    AppMethodBeat.i(106605);
    this.gIq.setVisibility(8);
    this.zjw.setVisibility(0);
    this.zjw.setText(getContext().getString(2131301595, new Object[] { Integer.valueOf(this.zjy) }));
    if (this.timerHandler != null)
    {
      this.timerHandler.stopTimer();
      this.timerHandler.ag(1000L, 1000L);
      AppMethodBeat.o(106605);
      return;
    }
    if (getContext() != null)
    {
      this.timerHandler = new ap(getContext().getMainLooper(), new MMFormVerifyCodeInputView.3(this), true);
      this.timerHandler.ag(1000L, 1000L);
      AppMethodBeat.o(106605);
      return;
    }
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    AppMethodBeat.o(106605);
  }
  
  public EditText getContentEditText()
  {
    return this.pLt;
  }
  
  public Editable getText()
  {
    AppMethodBeat.i(106609);
    if (this.pLt != null)
    {
      Editable localEditable = this.pLt.getText();
      AppMethodBeat.o(106609);
      return localEditable;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(106609);
    return null;
  }
  
  public TextView getTitleTextView()
  {
    return this.gpL;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(106596);
    super.onFinishInflate();
    this.gpL = ((TextView)findViewById(2131820680));
    this.pLt = ((EditText)findViewById(2131820995));
    this.zjw = ((TextView)findViewById(2131826178));
    this.gIq = ((Button)findViewById(2131826177));
    if ((this.gpL == null) || (this.pLt == null) || (this.zjw == null) || (this.gIq == null)) {
      ab.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", new Object[] { this.gpL, this.pLt, this.zjw, this.gIq });
    }
    for (;;)
    {
      if (this.pLt != null)
      {
        MMFormVerifyCodeInputView.1 local1 = new MMFormVerifyCodeInputView.1(this);
        this.pLt.setOnFocusChangeListener(local1);
      }
      if (this.gIq != null) {
        this.gIq.setOnClickListener(new MMFormVerifyCodeInputView.2(this));
      }
      AppMethodBeat.o(106596);
      return;
      if (this.vJN != -1) {
        this.gpL.setText(this.vJN);
      }
      if (this.zjm != -1) {
        this.pLt.setHint(this.zjm);
      }
      if (this.zjx != -1) {
        this.gIq.setText(this.zjx);
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(106606);
    if (this.timerHandler != null) {
      this.timerHandler.stopTimer();
    }
    this.pLt.setText("");
    this.zjw.setVisibility(8);
    this.zjz = this.zjy;
    this.gIq.setVisibility(0);
    AppMethodBeat.o(106606);
  }
  
  public void setFocusListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.naX = paramOnFocusChangeListener;
  }
  
  public void setHint(int paramInt)
  {
    AppMethodBeat.i(106600);
    if (this.pLt != null)
    {
      this.pLt.setHint(paramInt);
      AppMethodBeat.o(106600);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(106600);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(106598);
    if (this.pLt != null)
    {
      this.pLt.setHint(paramString);
      AppMethodBeat.o(106598);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(106598);
  }
  
  public void setImeOption(int paramInt)
  {
    AppMethodBeat.i(106602);
    if (this.pLt != null)
    {
      this.pLt.setImeOptions(paramInt);
      AppMethodBeat.o(106602);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(106602);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(106607);
    if (this.pLt != null)
    {
      this.pLt.setInputType(paramInt);
      AppMethodBeat.o(106607);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(106607);
  }
  
  public void setSendSmsBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zjA = paramOnClickListener;
  }
  
  public void setSmsBtnText(int paramInt)
  {
    AppMethodBeat.i(106603);
    if (this.gIq != null)
    {
      this.gIq.setText(paramInt);
      AppMethodBeat.o(106603);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(106603);
  }
  
  public void setSmsBtnText(String paramString)
  {
    AppMethodBeat.i(106604);
    if (this.gIq != null)
    {
      this.gIq.setText(paramString);
      AppMethodBeat.o(106604);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "sendSmsBtn is null!");
    AppMethodBeat.o(106604);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(106601);
    if (this.pLt != null)
    {
      this.pLt.setText(paramString);
      AppMethodBeat.o(106601);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
    AppMethodBeat.o(106601);
  }
  
  public void setTitle(int paramInt)
  {
    AppMethodBeat.i(106599);
    if (this.gpL != null)
    {
      this.gpL.setText(paramInt);
      AppMethodBeat.o(106599);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(106599);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(106597);
    if (this.gpL != null)
    {
      this.gpL.setText(paramString);
      AppMethodBeat.o(106597);
      return;
    }
    ab.e("MicroMsg.MMFormVerifyCodeInputView", "titleTV is null!");
    AppMethodBeat.o(106597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormVerifyCodeInputView
 * JD-Core Version:    0.7.0.1
 */