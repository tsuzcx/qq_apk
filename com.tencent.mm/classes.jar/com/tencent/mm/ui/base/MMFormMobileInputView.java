package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MMFormMobileInputView
  extends LinearLayout
{
  private Context mContext = null;
  private int uUR = -1;
  private int[] uUS;
  private EditText uUU;
  private EditText uUV;
  private String uUW = "";
  private String uUX = "";
  private final int uUY = 13;
  private MMFormMobileInputView.a uUZ = null;
  
  public MMFormMobileInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormMobileInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.FormItemView, paramInt, 0);
    this.uUR = paramAttributeSet.getResourceId(a.m.FormItemView_form_hint, -1);
    paramAttributeSet.recycle();
    com.tencent.mm.ui.y.gt(paramContext).inflate(a.h.mm_form_mobile_input_view, this);
    this.mContext = paramContext;
  }
  
  private void dD(View paramView)
  {
    this.uUS = new int[] { paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() };
  }
  
  private void dE(View paramView)
  {
    if (this.uUS != null) {
      paramView.setPadding(this.uUS[0], this.uUS[1], this.uUS[2], this.uUS[3]);
    }
  }
  
  public String getCountryCode()
  {
    if (this.uUU != null) {
      return this.uUU.getText().toString().trim();
    }
    return "";
  }
  
  public EditText getCountryCodeEditText()
  {
    return this.uUU;
  }
  
  public String getMobileNumber()
  {
    if (this.uUV != null) {
      return ar.Zt(this.uUV.getText().toString());
    }
    return "";
  }
  
  public EditText getMobileNumberEditText()
  {
    return this.uUV;
  }
  
  public final void mZ(boolean paramBoolean)
  {
    dD(this.uUU);
    if (paramBoolean)
    {
      this.uUU.setBackgroundResource(a.f.input_bar_bg_active);
      dE(this.uUU);
      dD(this.uUV);
      if (!paramBoolean) {
        break label74;
      }
      this.uUV.setBackgroundResource(a.f.input_bar_bg_active);
    }
    for (;;)
    {
      dE(this.uUV);
      return;
      this.uUU.setBackgroundResource(a.f.input_bar_bg_normal);
      break;
      label74:
      this.uUV.setBackgroundResource(a.f.input_bar_bg_normal);
    }
  }
  
  public void onFinishInflate()
  {
    this.uUU = ((EditText)findViewById(a.g.country_code));
    this.uUV = ((EditText)findViewById(a.g.mobile_number));
    if ((this.uUU == null) || (this.uUV == null))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[] { this.uUU, this.uUV });
      if ((this.uUU != null) && (this.uUV != null))
      {
        if ((!this.uUU.hasFocus()) && (!this.uUV.hasFocus())) {
          break label205;
        }
        mZ(true);
      }
    }
    for (;;)
    {
      MMFormMobileInputView.1 local1 = new MMFormMobileInputView.1(this);
      this.uUU.setOnFocusChangeListener(local1);
      this.uUV.setOnFocusChangeListener(local1);
      this.uUV.addTextChangedListener(new MMEditText.c(this.uUV, null, 20));
      this.uUV.addTextChangedListener(new MMFormMobileInputView.2(this));
      this.uUU.addTextChangedListener(new MMFormMobileInputView.3(this));
      return;
      if (this.uUR == -1) {
        break;
      }
      this.uUV.setHint(this.uUR);
      break;
      label205:
      mZ(false);
    }
  }
  
  public void setCountryCode(String paramString)
  {
    if (this.uUU != null)
    {
      this.uUU.setText(paramString);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
  }
  
  public void setHint(String paramString)
  {
    if (this.uUV != null)
    {
      this.uUV.setHint(paramString);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
  }
  
  public void setMobileNumber(String paramString)
  {
    if (this.uUV != null)
    {
      this.uUV.setText(paramString);
      return;
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
  }
  
  public void setOnCountryCodeChangedListener(MMFormMobileInputView.a parama)
  {
    this.uUZ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView
 * JD-Core Version:    0.7.0.1
 */