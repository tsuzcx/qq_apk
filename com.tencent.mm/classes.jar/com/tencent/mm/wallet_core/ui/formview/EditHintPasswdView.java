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
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.w;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int AYU = 2130838582;
  private int AYV;
  private int AYW;
  private int AYX;
  private EditHintPasswdView.a AYY;
  private View.OnFocusChangeListener gLH;
  public TenpaySecureEditText mEditText;
  private int tFy;
  
  public EditHintPasswdView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142678);
    this.mEditText = null;
    this.AYV = 6;
    this.tFy = 1;
    this.AYW = AYU;
    this.AYX = 1;
    this.AYY = null;
    this.gLH = null;
    aA(paramContext);
    AppMethodBeat.o(142678);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49390);
    this.mEditText = null;
    this.AYV = 6;
    this.tFy = 1;
    this.AYW = AYU;
    this.AYX = 1;
    this.AYY = null;
    this.gLH = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.PwdAttr, paramInt, 0);
    this.tFy = paramAttributeSet.getInteger(0, 1);
    this.AYW = paramAttributeSet.getResourceId(1, AYU);
    this.AYX = paramAttributeSet.getInteger(2, 1);
    paramAttributeSet.recycle();
    aA(paramContext);
    TenpaySecureEditText.setSalt(Long.toString(cb.abp() / 1000L));
    AppMethodBeat.o(49390);
  }
  
  private void aA(Context paramContext)
  {
    AppMethodBeat.i(142679);
    this.mEditText = ((TenpaySecureEditText)w.hM(paramContext).inflate(2130969859, this, true).findViewById(2131820689));
    b.a(this.mEditText, this.tFy);
    this.AYV = getNumberSize();
    if (this.mEditText != null)
    {
      this.mEditText.setBackgroundResource(this.AYW);
      this.mEditText.setImeOptions(6);
      this.mEditText.setInputType(128);
      this.mEditText.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(49389);
          if (EditHintPasswdView.b(EditHintPasswdView.this) != null) {
            EditHintPasswdView.b(EditHintPasswdView.this).onInputValidChange(EditHintPasswdView.c(EditHintPasswdView.this));
          }
          AppMethodBeat.o(49389);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.mEditText.setOnFocusChangeListener(this);
      this.mEditText.setClickable(false);
      this.mEditText.setLongClickable(false);
      super.setEnabled(true);
      super.setClickable(true);
      AppMethodBeat.o(142679);
      return;
    }
    ab.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    AppMethodBeat.o(142679);
  }
  
  private boolean asv()
  {
    AppMethodBeat.i(49392);
    if ((this.mEditText != null) && (this.mEditText.getInputLength() == this.AYV))
    {
      AppMethodBeat.o(49392);
      return true;
    }
    AppMethodBeat.o(49392);
    return false;
  }
  
  private int getNumberSize()
  {
    AppMethodBeat.i(49393);
    switch (this.tFy)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      ab.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
      AppMethodBeat.o(49393);
      return 6;
    case 1: 
      AppMethodBeat.o(49393);
      return 6;
    case 3: 
      AppMethodBeat.o(49393);
      return 3;
    case 4: 
      AppMethodBeat.o(49393);
      return 4;
    }
    AppMethodBeat.o(49393);
    return 4;
  }
  
  public final void cfK()
  {
    AppMethodBeat.i(49397);
    if (this.mEditText != null) {
      this.mEditText.ClearInput();
    }
    AppMethodBeat.o(49397);
  }
  
  public final int getEncrType()
  {
    return this.AYX;
  }
  
  public final int getFormat()
  {
    return this.tFy;
  }
  
  public final String getMd5Value()
  {
    AppMethodBeat.i(49391);
    if (this.mEditText != null)
    {
      String str = ag.cE(this.mEditText.getText().toString());
      AppMethodBeat.o(49391);
      return str;
    }
    ab.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    AppMethodBeat.o(49391);
    return "";
  }
  
  public final EditHintPasswdView.a getOnEditInputValidListener()
  {
    return this.AYY;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.gLH;
  }
  
  public final String getText()
  {
    AppMethodBeat.i(49396);
    if (this.mEditText != null)
    {
      String str = c.a.a(this.AYX, this.mEditText);
      AppMethodBeat.o(49396);
      return str;
    }
    ab.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
    AppMethodBeat.o(49396);
    return "";
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49399);
    if (this.gLH != null) {
      this.gLH.onFocusChange(this, paramBoolean);
    }
    if (this.AYY != null) {
      this.AYY.onInputValidChange(asv());
    }
    AppMethodBeat.o(49399);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49398);
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.b(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.b(getContext(), 720.0F), paramInt2));
    paramInt2 = getMeasuredWidth();
    if (this.AYV == 0) {}
    for (paramInt1 = paramInt2 / 6;; paramInt1 = paramInt2 / this.AYV)
    {
      int i = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      int j = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      setMeasuredDimension(getDefaultSize(paramInt2, i), getDefaultSize(paramInt1, j));
      super.onMeasure(i, j);
      AppMethodBeat.o(49398);
      return;
    }
  }
  
  public final void setEditTextMaxLength(int paramInt)
  {
    AppMethodBeat.i(49395);
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
    AppMethodBeat.o(49395);
  }
  
  public final void setEditTextSize(float paramFloat)
  {
    AppMethodBeat.i(49394);
    if (this.mEditText != null) {
      this.mEditText.setTextSize(paramFloat);
    }
    AppMethodBeat.o(49394);
  }
  
  public final void setEncrType(int paramInt)
  {
    this.AYX = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.gLH = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(EditHintPasswdView.a parama)
  {
    this.AYY = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */