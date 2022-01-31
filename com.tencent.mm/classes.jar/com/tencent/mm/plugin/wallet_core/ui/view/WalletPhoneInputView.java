package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.at.b;
import com.tencent.mm.at.b.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletPhoneInputView
  extends LinearLayout
{
  private int mMode = 0;
  private WalletFormView qIi;
  private WalletFormView qIj;
  private TenpaySecureEditText qIk;
  private Map<String, b.a> qIl;
  private String qIm = "";
  private String qIn = "";
  private boolean qIo = true;
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    a(paramContext, paramAttributeSet, -1);
  }
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletPhoneInputViewAttrs, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletPhoneInputViewAttrs_phoneHint, 0);
    if (paramInt != 0)
    {
      String str = paramContext.getString(paramInt);
      this.qIj.setHint(str);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.WalletPhoneInputViewAttrs_phoneTitle, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getString(paramInt);
      this.qIj.setTitleText(paramContext);
    }
  }
  
  private void bXg()
  {
    this.qIi.setText(this.qIm);
    this.qIk.setText(this.qIn);
  }
  
  private void bXh()
  {
    b.a locala = (b.a)this.qIl.get("86");
    this.qIn = locala.esf;
    this.qIm = locala.esg;
    bXg();
  }
  
  private void init(Context paramContext)
  {
    inflate(paramContext, a.g.wallet_phone_input_view_layout, this);
    this.qIi = ((WalletFormView)findViewById(a.f.phone_area_code_et));
    this.qIj = ((WalletFormView)findViewById(a.f.phone_number_et));
    this.qIi.setOnClickListener(new WalletPhoneInputView.1(this));
    this.qIk = ((TenpaySecureEditText)this.qIj.findViewById(a.f.prefix_input_et));
    this.qIk.setFixedHeaderText("+");
    if ((getContext() instanceof MMActivity))
    {
      this.qIj.setOnInfoIvClickListener(new WalletPhoneInputView.2(this));
      this.qIj.setLogicDelegate(new WalletPhoneInputView.3(this));
    }
    paramContext = b.C(getContext(), getContext().getString(a.i.country_code));
    this.qIl = new HashMap();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      b.a locala = (b.a)paramContext.next();
      this.qIl.put(locala.esf, locala);
    }
  }
  
  public final boolean bXi()
  {
    return this.mMode == 0;
  }
  
  public final void bXj()
  {
    this.mMode = 0;
    bXh();
    this.qIi.setVisibility(8);
    this.qIk.setVisibility(8);
  }
  
  public final void bXk()
  {
    this.mMode = 1;
    bXh();
    this.qIi.setVisibility(0);
    this.qIk.setVisibility(0);
    this.qIk.addTextChangedListener(new WalletPhoneInputView.4(this));
    this.qIk.setOnFocusChangeListener(new WalletPhoneInputView.5(this));
  }
  
  public final boolean e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 65521)
    {
      String str;
      if (paramInt2 == 100)
      {
        str = paramIntent.getStringExtra("country_name");
        paramIntent = paramIntent.getStringExtra("couttry_code");
        y.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[] { this.qIm, this.qIn });
        if ((bk.bl(str)) || (bk.bl(paramIntent))) {
          y.i("MicroMsg.WalletPhoneInputView", "cancel pick");
        }
      }
      else
      {
        return true;
      }
      this.qIm = str;
      this.qIn = paramIntent;
      this.qIo = false;
      bXg();
      this.qIk.clearFocus();
      return true;
    }
    return false;
  }
  
  public String getCountryCode()
  {
    if (bXi()) {
      return "86";
    }
    return this.qIk.getText().toString();
  }
  
  public WalletFormView getPhoneNumberEt()
  {
    return this.qIj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView
 * JD-Core Version:    0.7.0.1
 */