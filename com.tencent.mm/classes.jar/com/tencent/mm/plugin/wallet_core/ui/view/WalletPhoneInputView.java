package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletPhoneInputView
  extends LinearLayout
{
  private boolean VWA;
  public String VWB;
  private WalletFormView VWt;
  public WalletFormView VWu;
  private TenpaySecureEditText VWv;
  private TextView VWw;
  private Map<String, b.a> VWx;
  private String VWy;
  private String VWz;
  private int mMode;
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71521);
    this.mMode = 0;
    this.VWy = "";
    this.VWz = "";
    this.VWA = true;
    init(paramContext);
    c(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(71521);
  }
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71522);
    this.mMode = 0;
    this.VWy = "";
    this.VWz = "";
    this.VWA = true;
    init(paramContext);
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(71522);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(71524);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletPhoneInputViewAttrs, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.k.WalletPhoneInputViewAttrs_phoneHint, 0);
    if (paramInt != 0)
    {
      String str = paramContext.getString(paramInt);
      this.VWu.setHint(str);
    }
    paramInt = paramAttributeSet.getResourceId(a.k.WalletPhoneInputViewAttrs_phoneTitle, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getString(paramInt);
      this.VWu.setTitleText(paramContext);
    }
    AppMethodBeat.o(71524);
  }
  
  private void ilL()
  {
    AppMethodBeat.i(71527);
    this.VWt.setText(this.VWy);
    this.VWv.setText(this.VWz);
    AppMethodBeat.o(71527);
  }
  
  private void ilM()
  {
    AppMethodBeat.i(71528);
    b.a locala = (b.a)this.VWx.get("86");
    this.VWz = locala.oLk;
    this.VWy = locala.oLl;
    ilL();
    AppMethodBeat.o(71528);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71523);
    inflate(paramContext, a.g.wallet_phone_input_view_layout, this);
    this.VWt = ((WalletFormView)findViewById(a.f.phone_area_code_et));
    this.VWu = ((WalletFormView)findViewById(a.f.phone_number_et));
    this.VWw = ((TextView)findViewById(a.f.plus_prefix_tv));
    this.VWt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.d("MicroMsg.WalletPhoneInputView", "click area");
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        ((MMActivity)WalletPhoneInputView.this.getContext()).startActivityForResult(paramAnonymousView, 65521);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71515);
      }
    });
    this.VWv = ((TenpaySecureEditText)this.VWu.findViewById(a.f.prefix_input_et));
    if ((getContext() instanceof MMActivity))
    {
      this.VWu.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          WalletPhoneInputView.a(WalletPhoneInputView.this, WalletPhoneInputView.a(WalletPhoneInputView.this));
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71516);
        }
      });
      this.VWu.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
      {
        public final boolean a(WalletFormView paramAnonymousWalletFormView)
        {
          AppMethodBeat.i(71517);
          if (WalletPhoneInputView.this.ilN())
          {
            boolean bool = paramAnonymousWalletFormView.isPhoneNum();
            AppMethodBeat.o(71517);
            return bool;
          }
          if ((!Util.isNullOrNil(WalletPhoneInputView.b(WalletPhoneInputView.this))) && (!Util.isNullOrNil(WalletPhoneInputView.c(WalletPhoneInputView.this))) && (!Util.isNullOrNil(WalletPhoneInputView.d(WalletPhoneInputView.this).getText())))
          {
            AppMethodBeat.o(71517);
            return true;
          }
          AppMethodBeat.o(71517);
          return false;
        }
        
        public final boolean a(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
        {
          return false;
        }
        
        public final boolean b(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
        {
          return false;
        }
        
        public final String c(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
        {
          return null;
        }
        
        public final boolean gGa()
        {
          return false;
        }
      });
    }
    getContext();
    paramContext = com.tencent.mm.au.b.OB(getContext().getString(a.i.country_code));
    this.VWx = new HashMap();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      b.a locala = (b.a)paramContext.next();
      this.VWx.put(locala.oLk, locala);
    }
    AppMethodBeat.o(71523);
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(71525);
    if (ilN())
    {
      AppMethodBeat.o(71525);
      return "86";
    }
    String str = this.VWv.getText().toString();
    AppMethodBeat.o(71525);
    return str;
  }
  
  public WalletFormView getPhoneNumberEt()
  {
    return this.VWu;
  }
  
  public final boolean ilN()
  {
    return this.mMode == 0;
  }
  
  public final void ilO()
  {
    AppMethodBeat.i(71529);
    this.mMode = 0;
    ilM();
    this.VWt.setVisibility(8);
    this.VWv.setVisibility(8);
    this.VWw.setVisibility(8);
    AppMethodBeat.o(71529);
  }
  
  public final void ilP()
  {
    AppMethodBeat.i(71530);
    this.mMode = 1;
    ilM();
    this.VWt.setVisibility(0);
    this.VWv.setVisibility(0);
    this.VWw.setVisibility(0);
    this.VWv.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(71519);
        if (Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText("");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(a.c.normal_text_color);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(a.c.normal_text_color));
          AppMethodBeat.o(71519);
          return;
        }
        if (!WalletPhoneInputView.g(WalletPhoneInputView.this))
        {
          Log.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(a.c.normal_text_color);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(a.c.normal_text_color));
          WalletPhoneInputView.h(WalletPhoneInputView.this);
          AppMethodBeat.o(71519);
          return;
        }
        b.a locala = (b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(paramAnonymousEditable.toString());
        Log.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[] { locala, paramAnonymousEditable.toString() });
        if (locala != null)
        {
          WalletPhoneInputView.b(WalletPhoneInputView.this, locala.oLk);
          WalletPhoneInputView.c(WalletPhoneInputView.this, locala.oLl);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(locala.oLl);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(a.c.normal_text_color);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(a.c.normal_text_color));
        }
        for (;;)
        {
          WalletPhoneInputView.d(WalletPhoneInputView.this).getInputValidChangeListener().onInputValidChange(WalletPhoneInputView.d(WalletPhoneInputView.this).bZp());
          AppMethodBeat.o(71519);
          return;
          WalletPhoneInputView.b(WalletPhoneInputView.this, "");
          WalletPhoneInputView.c(WalletPhoneInputView.this, "");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(WalletPhoneInputView.this.getContext().getString(a.i.wallet_phone_invalid_country_code));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.VWv.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71520);
        if (!paramAnonymousBoolean)
        {
          if ((b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(WalletPhoneInputView.f(WalletPhoneInputView.this).getText().toString()) == null)
          {
            WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(a.c.red_text_color);
            WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(a.c.red_text_color));
            AppMethodBeat.o(71520);
            return;
          }
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(a.c.normal_text_color);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(a.c.normal_text_color));
        }
        AppMethodBeat.o(71520);
      }
    });
    AppMethodBeat.o(71530);
  }
  
  public final boolean j(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71526);
    if (paramInt1 == 65521)
    {
      if (paramInt2 == 100)
      {
        String str = paramIntent.getStringExtra("country_name");
        paramIntent = paramIntent.getStringExtra("couttry_code");
        Log.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[] { this.VWy, this.VWz });
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramIntent)))
        {
          Log.i("MicroMsg.WalletPhoneInputView", "cancel pick");
          AppMethodBeat.o(71526);
          return true;
        }
        this.VWy = str;
        this.VWz = paramIntent;
        this.VWA = false;
        ilL();
        this.VWv.clearFocus();
      }
      AppMethodBeat.o(71526);
      return true;
    }
    AppMethodBeat.o(71526);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView
 * JD-Core Version:    0.7.0.1
 */