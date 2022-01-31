package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView
  extends RelativeLayout
  implements View.OnFocusChangeListener
{
  private static final int wCI = a.e.edit_passwd_bg_selector;
  private View.OnFocusChangeListener fuf = null;
  private int pZW = 1;
  private TenpaySecureEditText wCJ = null;
  private int wCK = 6;
  private int wCL = wCI;
  private int wCM = 1;
  private a wCN = null;
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public EditHintPasswdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.PwdAttr, paramInt, 0);
    this.pZW = paramAttributeSet.getInteger(a.k.PwdAttr_format, 1);
    this.wCL = paramAttributeSet.getResourceId(a.k.PwdAttr_EditTextBg, wCI);
    this.wCM = paramAttributeSet.getInteger(a.k.PwdAttr_PwdEncryptType, 1);
    paramAttributeSet.recycle();
    this.wCJ = ((TenpaySecureEditText)com.tencent.mm.ui.y.gt(paramContext).inflate(a.g.hint_view_passwd, this, true).findViewById(a.f.wallet_content));
    b.a(this.wCJ, this.pZW);
    this.wCK = getNumberSize();
    if (this.wCJ != null)
    {
      this.wCJ.setBackgroundResource(this.wCL);
      this.wCJ.setImeOptions(6);
      this.wCJ.setInputType(128);
      this.wCJ.addTextChangedListener(new EditHintPasswdView.1(this));
      this.wCJ.setOnFocusChangeListener(this);
      super.setEnabled(true);
      super.setClickable(true);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
  }
  
  private boolean YL()
  {
    return (this.wCJ != null) && (this.wCJ.getInputLength() == this.wCK);
  }
  
  private int getNumberSize()
  {
    switch (this.pZW)
    {
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
    case 1: 
      return 6;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 4;
  }
  
  public final void bvr()
  {
    if (this.wCJ != null) {
      this.wCJ.ClearInput();
    }
  }
  
  public final int getEncrType()
  {
    return this.wCM;
  }
  
  public final int getFormat()
  {
    return this.pZW;
  }
  
  public final String getMd5Value()
  {
    if (this.wCJ != null) {
      return ad.bB(this.wCJ.getText().toString());
    }
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
    return "";
  }
  
  public final a getOnEditInputValidListener()
  {
    return this.wCN;
  }
  
  public final View.OnFocusChangeListener getOnFocusChangeListener()
  {
    return this.fuf;
  }
  
  public final String getText()
  {
    if (this.wCJ != null) {
      return c.a.a(this.wCM, this.wCJ);
    }
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
    return "";
  }
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.fuf != null) {
      this.fuf.onFocusChange(this, paramBoolean);
    }
    if (this.wCN != null) {
      this.wCN.gG(YL());
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(BackwardSupportUtil.b.b(getContext(), 960.0F), paramInt1), getDefaultSize(BackwardSupportUtil.b.b(getContext(), 720.0F), paramInt2));
    paramInt2 = getMeasuredWidth();
    if (this.wCK == 0) {}
    for (paramInt1 = paramInt2 / 6;; paramInt1 = paramInt2 / this.wCK)
    {
      int i = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      int j = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      setMeasuredDimension(getDefaultSize(paramInt2, i), getDefaultSize(paramInt1, j));
      super.onMeasure(i, j);
      return;
    }
  }
  
  public final void setEditTextMaxLength(int paramInt)
  {
    if (this.wCJ != null)
    {
      InputFilter[] arrayOfInputFilter1 = this.wCJ.getFilters();
      InputFilter[] arrayOfInputFilter2 = new InputFilter[arrayOfInputFilter1.length + 1];
      int i = 0;
      while (i < arrayOfInputFilter1.length)
      {
        arrayOfInputFilter2[i] = arrayOfInputFilter1[i];
        i += 1;
      }
      arrayOfInputFilter2[(arrayOfInputFilter2.length - 1)] = new InputFilter.LengthFilter(paramInt);
      this.wCJ.setFilters(arrayOfInputFilter2);
    }
  }
  
  public final void setEditTextSize(float paramFloat)
  {
    if (this.wCJ != null) {
      this.wCJ.setTextSize(paramFloat);
    }
  }
  
  public final void setEncrType(int paramInt)
  {
    this.wCM = paramInt;
  }
  
  public final void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.fuf = paramOnFocusChangeListener;
  }
  
  public final void setOnInputValidListener(a parama)
  {
    this.wCN = parama;
  }
  
  public static abstract interface a
  {
    public abstract void gG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView
 * JD-Core Version:    0.7.0.1
 */