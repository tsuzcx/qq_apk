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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int LAm = 2131231971;
  private static final int LAn = 2131231972;
  private int Cma;
  private int LAo;
  private int LAp;
  private int LAq;
  private int LAr;
  private a LAs;
  private View.OnFocusChangeListener jsD;
  public TenpaySecureEditText mEditText;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(73117);
    this.mEditText = null;
    this.LAo = 6;
    this.Cma = 1;
    this.LAp = LAm;
    this.LAq = 1;
    this.LAs = null;
    this.jsD = null;
    aM(paramContext);
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
    this.LAo = 6;
    this.Cma = 1;
    this.LAp = LAm;
    this.LAq = 1;
    this.LAs = null;
    this.jsD = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PwdAttr, paramInt, 0);
    this.Cma = paramAttributeSet.getInteger(2, 1);
    this.LAp = paramAttributeSet.getResourceId(0, LAm);
    this.LAq = paramAttributeSet.getInteger(1, 1);
    this.LAr = paramAttributeSet.getInteger(3, 1);
    paramAttributeSet.recycle();
    aM(paramContext);
    TenpaySecureEditText.setSalt(e.fSb());
    AppMethodBeat.o(73116);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(73119);
    this.mEditText = ((TenpaySecureEditText)z.jO(paramContext).inflate(2131494436, this, true).findViewById(2131306718));
    if ((this.LAp == LAm) && (al.isDarkMode())) {
      this.LAp = LAn;
    }
    if (this.LAr == 1) {
      this.LAp = 2131101053;
    }
    paramContext = this.mEditText;
    int i = this.Cma;
    if (this.LAr == 1) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramContext, i, bool);
      this.LAo = getNumberSize();
      if (this.mEditText == null) {
        break;
      }
      this.mEditText.setBackgroundResource(this.LAp);
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
  
  private boolean aVa()
  {
    AppMethodBeat.i(73120);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.LAo))
    {
      AppMethodBeat.o(73120);
      return true;
    }
    AppMethodBeat.o(73120);
    return false;
  }
  
  private int getNumberSize()
  {
    AppMethodBeat.i(73121);
    switch (this.Cma)
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
  
  public final void agt(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(199371);
    this.LAr = paramInt;
    TenpaySecureEditText localTenpaySecureEditText;
    if (this.LAr == 1)
    {
      this.LAp = 2131101053;
      this.mEditText.setBackgroundResource(this.LAp);
      localTenpaySecureEditText = this.mEditText;
      paramInt = this.Cma;
      if (this.LAr != 1) {
        break label93;
      }
    }
    for (;;)
    {
      b.a(localTenpaySecureEditText, paramInt, bool);
      AppMethodBeat.o(199371);
      return;
      if (al.isDarkMode())
      {
        this.LAp = LAn;
        break;
      }
      this.LAp = LAm;
      break;
      label93:
      bool = false;
    }
  }
  
  public final void dEe()
  {
    AppMethodBeat.i(73126);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(73126);
  }
  
  public final void fSe()
  {
    AppMethodBeat.i(73122);
    this.mEditText.requestFocus();
    AppMethodBeat.o(73122);
  }
  
  public final int getEncrType()
  {
    return this.LAq;
  }
  
  public final int getFormat()
  {
    return this.Cma;
  }
  
  public final String getMd5Value()
  {
    AppMethodBeat.i(73118);
    if (this.mEditText != null)
    {
      String str = ai.ee(this.mEditText.getText().toString());
      AppMethodBeat.o(73118);
      return str;
    }
    ad.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    AppMethodBeat.o(73118);
    return "";
  }
  
  public final a getOnEditInputValidListener()
  {
    return this.LAs;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.jsD;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73125);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.LAq, this.mEditText);
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
    if (this.jsD != null) {
      this.jsD.onFocusChange(this, paramBoolean);
    }
    if (this.LAs != null) {
      this.LAs.onInputValidChange(aVa());
    }
    AppMethodBeat.o(73128);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73127);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.g(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.g(getContext(), 720.0F), paramInt2));
    int j;
    int i;
    if (this.LAr == 0)
    {
      j = getMeasuredWidth();
      if (this.LAo == 0)
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
      paramInt1 = j / this.LAo;
      break;
      i = getMeasuredWidth();
      j = (i - a.fromDPToPix(getContext(), 8) * (this.LAo - 1)) / this.LAo;
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
    this.LAq = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.jsD = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.LAs = parama;
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