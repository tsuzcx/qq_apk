package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private int mMode;
  private WalletFormView uwQ;
  private WalletFormView uwR;
  private TenpaySecureEditText uwS;
  private Map<String, b.a> uwT;
  private String uwU;
  private String uwV;
  private boolean uwW;
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47913);
    this.mMode = 0;
    this.uwU = "";
    this.uwV = "";
    this.uwW = true;
    init(paramContext);
    b(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(47913);
  }
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47914);
    this.mMode = 0;
    this.uwU = "";
    this.uwV = "";
    this.uwW = true;
    init(paramContext);
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(47914);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(47916);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletPhoneInputViewAttrs, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, 0);
    if (paramInt != 0)
    {
      String str = paramContext.getString(paramInt);
      this.uwR.setHint(str);
    }
    paramInt = paramAttributeSet.getResourceId(1, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getString(paramInt);
      this.uwR.setTitleText(paramContext);
    }
    AppMethodBeat.o(47916);
  }
  
  private void cWH()
  {
    AppMethodBeat.i(47919);
    this.uwQ.setText(this.uwU);
    this.uwS.setText(this.uwV);
    AppMethodBeat.o(47919);
  }
  
  private void cWI()
  {
    AppMethodBeat.i(47920);
    b.a locala = (b.a)this.uwT.get("86");
    this.uwV = locala.fHS;
    this.uwU = locala.fHT;
    cWH();
    AppMethodBeat.o(47920);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(47915);
    inflate(paramContext, 2130971235, this);
    this.uwQ = ((WalletFormView)findViewById(2131829353));
    this.uwR = ((WalletFormView)findViewById(2131829354));
    this.uwQ.setOnClickListener(new WalletPhoneInputView.1(this));
    this.uwS = ((TenpaySecureEditText)this.uwR.findViewById(2131829352));
    this.uwS.setFixedHeaderText("+");
    if ((getContext() instanceof MMActivity))
    {
      this.uwR.setOnInfoIvClickListener(new WalletPhoneInputView.2(this));
      this.uwR.setLogicDelegate(new WalletPhoneInputView.3(this));
    }
    paramContext = b.G(getContext(), getContext().getString(2131298871));
    this.uwT = new HashMap();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      b.a locala = (b.a)paramContext.next();
      this.uwT.put(locala.fHS, locala);
    }
    AppMethodBeat.o(47915);
  }
  
  public final boolean cWJ()
  {
    return this.mMode == 0;
  }
  
  public final void cWK()
  {
    AppMethodBeat.i(47921);
    this.mMode = 0;
    cWI();
    this.uwQ.setVisibility(8);
    this.uwS.setVisibility(8);
    AppMethodBeat.o(47921);
  }
  
  public final void cWL()
  {
    AppMethodBeat.i(47922);
    this.mMode = 1;
    cWI();
    this.uwQ.setVisibility(0);
    this.uwS.setVisibility(0);
    this.uwS.addTextChangedListener(new WalletPhoneInputView.4(this));
    this.uwS.setOnFocusChangeListener(new WalletPhoneInputView.5(this));
    AppMethodBeat.o(47922);
  }
  
  public final boolean e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47918);
    if (paramInt1 == 65521)
    {
      if (paramInt2 == 100)
      {
        String str = paramIntent.getStringExtra("country_name");
        paramIntent = paramIntent.getStringExtra("couttry_code");
        ab.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[] { this.uwU, this.uwV });
        if ((bo.isNullOrNil(str)) || (bo.isNullOrNil(paramIntent)))
        {
          ab.i("MicroMsg.WalletPhoneInputView", "cancel pick");
          AppMethodBeat.o(47918);
          return true;
        }
        this.uwU = str;
        this.uwV = paramIntent;
        this.uwW = false;
        cWH();
        this.uwS.clearFocus();
      }
      AppMethodBeat.o(47918);
      return true;
    }
    AppMethodBeat.o(47918);
    return false;
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(47917);
    if (cWJ())
    {
      AppMethodBeat.o(47917);
      return "86";
    }
    String str = this.uwS.getText().toString();
    AppMethodBeat.o(47917);
    return str;
  }
  
  public WalletFormView getPhoneNumberEt()
  {
    return this.uwR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView
 * JD-Core Version:    0.7.0.1
 */