package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int IfH = 2131231971;
  private static final int IfI = 2131231972;
  private int IfJ;
  private int IfK;
  private int IfL;
  private int IfM;
  private a IfN;
  private View.OnFocusChangeListener izr;
  public TenpaySecureEditText mEditText;
  private int ztV;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(73117);
    this.mEditText = null;
    this.IfJ = 6;
    this.ztV = 1;
    this.IfK = IfH;
    this.IfL = 1;
    this.IfN = null;
    this.izr = null;
    aL(paramContext);
    AppMethodBeat.o(73117);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(73116);
    this.mEditText = null;
    this.IfJ = 6;
    this.ztV = 1;
    this.IfK = IfH;
    this.IfL = 1;
    this.IfN = null;
    this.izr = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PwdAttr, paramInt, 0);
    this.ztV = paramAttributeSet.getInteger(2, 1);
    this.IfK = paramAttributeSet.getResourceId(0, IfH);
    this.IfL = paramAttributeSet.getInteger(1, 1);
    this.IfM = paramAttributeSet.getInteger(3, 1);
    paramAttributeSet.recycle();
    aL(paramContext);
    TenpaySecureEditText.setSalt(e.fkB());
    AppMethodBeat.o(73116);
  }
  
  private boolean aKX()
  {
    AppMethodBeat.i(73120);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.IfJ))
    {
      AppMethodBeat.o(73120);
      return true;
    }
    AppMethodBeat.o(73120);
    return false;
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(73119);
    this.mEditText = ((TenpaySecureEditText)y.js(paramContext).inflate(2131494436, this, true).findViewById(2131306718));
    if ((this.IfK == IfH) && (com.tencent.mm.ui.ai.Eq())) {
      this.IfK = IfI;
    }
    if (this.IfM == 1) {
      this.IfK = 2131101053;
    }
    paramContext = this.mEditText;
    int i = this.ztV;
    if (this.IfM == 1) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramContext, i, bool);
      this.IfJ = getNumberSize();
      if (this.mEditText == null) {
        break;
      }
      this.mEditText.setBackgroundResource(this.IfK);
      this.mEditText.setImeOptions(6);
      this.mEditText.setInputType(128);
      this.mEditText.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(73115);
          if (EditHintPasswdView.b(EditHintPasswdView.this) != null) {
            EditHintPasswdView.b(EditHintPasswdView.this).onInputValidChange(EditHintPasswdView.c(EditHintPasswdView.this));
          }
          AppMethodBeat.o(73115);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mEditText.setOnFocusChangeListener(this);
      this.mEditText.setClickable(false);
      this.mEditText.setLongClickable(false);
      super.setEnabled(true);
      super.setClickable(true);
      AppMethodBeat.o(73119);
      return;
    }
    ad.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    AppMethodBeat.o(73119);
  }
  
  private int getNumberSize()
  {
    AppMethodBeat.i(73121);
    switch (this.ztV)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      ad.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
      AppMethodBeat.o(73121);
      return 6;
    case 1: 
      AppMethodBeat.o(73121);
      return 6;
    case 3: 
      AppMethodBeat.o(73121);
      return 3;
    case 4: 
      AppMethodBeat.o(73121);
      return 4;
    }
    AppMethodBeat.o(73121);
    return 4;
  }
  
  public final void abA(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(187199);
    this.IfM = paramInt;
    TenpaySecureEditText localTenpaySecureEditText;
    if (this.IfM == 1)
    {
      this.IfK = 2131101053;
      this.mEditText.setBackgroundResource(this.IfK);
      localTenpaySecureEditText = this.mEditText;
      paramInt = this.ztV;
      if (this.IfM != 1) {
        break label93;
      }
    }
    for (;;)
    {
      b.a(localTenpaySecureEditText, paramInt, bool);
      AppMethodBeat.o(187199);
      return;
      if (com.tencent.mm.ui.ai.Eq())
      {
        this.IfK = IfI;
        break;
      }
      this.IfK = IfH;
      break;
      label93:
      bool = false;
    }
  }
  
  public final void dga()
  {
    AppMethodBeat.i(73126);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(73126);
  }
  
  public final void fkE()
  {
    AppMethodBeat.i(73122);
    this.mEditText.requestFocus();
    AppMethodBeat.o(73122);
  }
  
  public final int getEncrType()
  {
    return this.IfL;
  }
  
  public final int getFormat()
  {
    return this.ztV;
  }
  
  public final String getMd5Value()
  {
    AppMethodBeat.i(73118);
    if (this.mEditText != null)
    {
      String str = com.tencent.mm.sdk.platformtools.ai.du(this.mEditText.getText().toString());
      AppMethodBeat.o(73118);
      return str;
    }
    ad.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    AppMethodBeat.o(73118);
    return "";
  }
  
  public final a getOnEditInputValidListener()
  {
    return this.IfN;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.izr;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73125);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.IfL, this.mEditText);
      AppMethodBeat.o(73125);
      return str;
    }
    ad.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
    AppMethodBeat.o(73125);
    return "";
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73128);
    if (this.izr != null) {
      this.izr.onFocusChange(this, paramBoolean);
    }
    if (this.IfN != null) {
      this.IfN.onInputValidChange(aKX());
    }
    AppMethodBeat.o(73128);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73127);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.g(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.g(getContext(), 720.0F), paramInt2));
    int j;
    int i;
    if (this.IfM == 0)
    {
      j = getMeasuredWidth();
      if (this.IfJ == 0)
      {
        paramInt1 = j / 6;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
        i = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        setMeasuredDimension(getDefaultSize(j, paramInt2), getDefaultSize(paramInt1, i));
        paramInt1 = i;
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt2, paramInt1);
      AppMethodBeat.o(73127);
      return;
      paramInt1 = j / this.IfJ;
      break;
      i = getMeasuredWidth();
      j = (i - a.fromDPToPix(getContext(), 8) * (this.IfJ - 1)) / this.IfJ;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i + 1, 1073741824);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
      setMeasuredDimension(getDefaultSize(i, paramInt2), getDefaultSize(j, paramInt1));
    }
  }
  
  public final void setEditTextMaxLength(int paramInt)
  {
    AppMethodBeat.i(73124);
    if (this.mEditText != null)
    {
      InputFilter[] arrayOfInputFilter1 = this.mEditText.getFilters();
      InputFilter[] arrayOfInputFilter2 = new InputFilter[arrayOfInputFilter1.length + 1];
      int i = 0;
      while (i < arrayOfInputFilter1.length)
      {
        arrayOfInputFilter2[i] = arrayOfInputFilter1[i];
        i += 1;
      }
      arrayOfInputFilter2[(arrayOfInputFilter2.length - 1)] = new InputFilter.LengthFilter(paramInt);
      this.mEditText.setFilters(arrayOfInputFilter2);
    }
    AppMethodBeat.o(73124);
  }
  
  public final void setEditTextSize(float paramFloat)
  {
    AppMethodBeat.i(73123);
    if (this.mEditText != null) {
      this.mEditText.setTextSize(paramFloat);
    }
    AppMethodBeat.o(73123);
  }
  
  public final void setEncrType(int paramInt)
  {
    this.IfL = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.izr = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.IfN = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */