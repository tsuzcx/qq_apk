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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;
import com.tencent.mm.wallet_core.ui.f;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int LXc = 2131231971;
  private static final int LXd = 2131231972;
  private int CDE;
  private int LXe;
  private int LXf;
  private int LXg;
  private int LXh;
  private a LXi;
  private View.OnFocusChangeListener jvw;
  public TenpaySecureEditText mEditText;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(73117);
    this.mEditText = null;
    this.LXe = 6;
    this.CDE = 1;
    this.LXf = LXc;
    this.LXg = 1;
    this.LXi = null;
    this.jvw = null;
    aN(paramContext);
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
    this.LXe = 6;
    this.CDE = 1;
    this.LXf = LXc;
    this.LXg = 1;
    this.LXi = null;
    this.jvw = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PwdAttr, paramInt, 0);
    this.CDE = paramAttributeSet.getInteger(2, 1);
    this.LXf = paramAttributeSet.getResourceId(0, LXc);
    this.LXg = paramAttributeSet.getInteger(1, 1);
    this.LXh = paramAttributeSet.getInteger(3, 1);
    paramAttributeSet.recycle();
    aN(paramContext);
    TenpaySecureEditText.setSalt(f.fWx());
    AppMethodBeat.o(73116);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(73119);
    this.mEditText = ((TenpaySecureEditText)z.jV(paramContext).inflate(2131494436, this, true).findViewById(2131306718));
    if ((this.LXf == LXc) && (al.isDarkMode())) {
      this.LXf = LXd;
    }
    if (this.LXh == 1) {
      this.LXf = 2131101053;
    }
    paramContext = this.mEditText;
    int i = this.CDE;
    if (this.LXh == 1) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramContext, i, bool);
      this.LXe = getNumberSize();
      if (this.mEditText == null) {
        break;
      }
      this.mEditText.setBackgroundResource(this.LXf);
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
    ae.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    AppMethodBeat.o(73119);
  }
  
  private boolean aVz()
  {
    AppMethodBeat.i(73120);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.LXe))
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
    switch (this.CDE)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      ae.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
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
  
  public final void ahc(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(190258);
    this.LXh = paramInt;
    TenpaySecureEditText localTenpaySecureEditText;
    if (this.LXh == 1)
    {
      this.LXf = 2131101053;
      this.mEditText.setBackgroundResource(this.LXf);
      localTenpaySecureEditText = this.mEditText;
      paramInt = this.CDE;
      if (this.LXh != 1) {
        break label93;
      }
    }
    for (;;)
    {
      b.a(localTenpaySecureEditText, paramInt, bool);
      AppMethodBeat.o(190258);
      return;
      if (al.isDarkMode())
      {
        this.LXf = LXd;
        break;
      }
      this.LXf = LXc;
      break;
      label93:
      bool = false;
    }
  }
  
  public final void dHv()
  {
    AppMethodBeat.i(73126);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(73126);
  }
  
  public final void fWA()
  {
    AppMethodBeat.i(73122);
    this.mEditText.requestFocus();
    AppMethodBeat.o(73122);
  }
  
  public final int getEncrType()
  {
    return this.LXg;
  }
  
  public final int getFormat()
  {
    return this.CDE;
  }
  
  public final String getMd5Value()
  {
    AppMethodBeat.i(73118);
    if (this.mEditText != null)
    {
      String str = aj.ej(this.mEditText.getText().toString());
      AppMethodBeat.o(73118);
      return str;
    }
    ae.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    AppMethodBeat.o(73118);
    return "";
  }
  
  public final a getOnEditInputValidListener()
  {
    return this.LXi;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.jvw;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(73125);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.LXg, this.mEditText);
      AppMethodBeat.o(73125);
      return str;
    }
    ae.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
    AppMethodBeat.o(73125);
    return "";
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(73128);
    if (this.jvw != null) {
      this.jvw.onFocusChange(this, paramBoolean);
    }
    if (this.LXi != null) {
      this.LXi.onInputValidChange(aVz());
    }
    AppMethodBeat.o(73128);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(73127);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.h(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.h(getContext(), 720.0F), paramInt2));
    int j;
    int i;
    if (this.LXh == 0)
    {
      j = getMeasuredWidth();
      if (this.LXe == 0)
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
      paramInt1 = j / this.LXe;
      break;
      i = getMeasuredWidth();
      j = (i - a.fromDPToPix(getContext(), 8) * (this.LXe - 1)) / this.LXe;
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
    this.LXg = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.jvw = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.LXi = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onInputValidChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */