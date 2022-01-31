package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MMFormMobileInputView
  extends LinearLayout
{
  private Context mContext;
  private int zjm;
  private int[] zjn;
  private EditText zjp;
  private EditText zjq;
  private String zjr;
  private String zjs;
  private final int zjt;
  private MMFormMobileInputView.a zju;
  
  public MMFormMobileInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormMobileInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106574);
    this.mContext = null;
    this.zjm = -1;
    this.zjr = "";
    this.zjs = "";
    this.zjt = 13;
    this.zju = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.zjm = paramAttributeSet.getResourceId(2, -1);
    paramAttributeSet.recycle();
    w.hM(paramContext).inflate(2130970170, this);
    this.mContext = paramContext;
    AppMethodBeat.o(106574);
  }
  
  private void eM(View paramView)
  {
    AppMethodBeat.i(106577);
    this.zjn = new int[] { paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() };
    AppMethodBeat.o(106577);
  }
  
  private void eN(View paramView)
  {
    AppMethodBeat.i(106578);
    if (this.zjn != null) {
      paramView.setPadding(this.zjn[0], this.zjn[1], this.zjn[2], this.zjn[3]);
    }
    AppMethodBeat.o(106578);
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(106583);
    if (this.zjp != null)
    {
      String str = this.zjp.getText().toString().trim();
      AppMethodBeat.o(106583);
      return str;
    }
    AppMethodBeat.o(106583);
    return "";
  }
  
  public EditText getCountryCodeEditText()
  {
    return this.zjp;
  }
  
  public String getMobileNumber()
  {
    AppMethodBeat.i(106582);
    if (this.zjq != null)
    {
      String str = av.apy(this.zjq.getText().toString());
      AppMethodBeat.o(106582);
      return str;
    }
    AppMethodBeat.o(106582);
    return "";
  }
  
  public EditText getMobileNumberEditText()
  {
    return this.zjq;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(106575);
    this.zjp = ((EditText)findViewById(2131821766));
    this.zjq = ((EditText)findViewById(2131826179));
    if ((this.zjp == null) || (this.zjq == null))
    {
      ab.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[] { this.zjp, this.zjq });
      if ((this.zjp != null) && (this.zjq != null))
      {
        if ((!this.zjp.hasFocus()) && (!this.zjq.hasFocus())) {
          break label213;
        }
        qC(true);
      }
    }
    for (;;)
    {
      MMFormMobileInputView.1 local1 = new MMFormMobileInputView.1(this);
      this.zjp.setOnFocusChangeListener(local1);
      this.zjq.setOnFocusChangeListener(local1);
      this.zjq.addTextChangedListener(new MMEditText.c(this.zjq, null, 20));
      this.zjq.addTextChangedListener(new MMFormMobileInputView.2(this));
      this.zjp.addTextChangedListener(new MMFormMobileInputView.3(this));
      AppMethodBeat.o(106575);
      return;
      if (this.zjm == -1) {
        break;
      }
      this.zjq.setHint(this.zjm);
      break;
      label213:
      qC(false);
    }
  }
  
  public final void qC(boolean paramBoolean)
  {
    AppMethodBeat.i(106576);
    eM(this.zjp);
    if (paramBoolean)
    {
      this.zjp.setBackgroundResource(2130839162);
      eN(this.zjp);
      eM(this.zjq);
      if (!paramBoolean) {
        break label81;
      }
      this.zjq.setBackgroundResource(2130839162);
    }
    for (;;)
    {
      eN(this.zjq);
      AppMethodBeat.o(106576);
      return;
      this.zjp.setBackgroundResource(2130839163);
      break;
      label81:
      this.zjq.setBackgroundResource(2130839163);
    }
  }
  
  public void setCountryCode(String paramString)
  {
    AppMethodBeat.i(106579);
    if (this.zjp != null)
    {
      this.zjp.setText(paramString);
      AppMethodBeat.o(106579);
      return;
    }
    ab.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
    AppMethodBeat.o(106579);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(106580);
    if (this.zjq != null)
    {
      this.zjq.setHint(paramString);
      AppMethodBeat.o(106580);
      return;
    }
    ab.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(106580);
  }
  
  public void setMobileNumber(String paramString)
  {
    AppMethodBeat.i(106581);
    if (this.zjq != null)
    {
      this.zjq.setText(paramString);
      AppMethodBeat.o(106581);
      return;
    }
    ab.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(106581);
  }
  
  public void setOnCountryCodeChangedListener(MMFormMobileInputView.a parama)
  {
    this.zju = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView
 * JD-Core Version:    0.7.0.1
 */