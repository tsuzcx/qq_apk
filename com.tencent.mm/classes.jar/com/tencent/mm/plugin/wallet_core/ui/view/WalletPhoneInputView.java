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
import com.tencent.mm.aw.b.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private WalletFormView DEb;
  public WalletFormView DEc;
  private TenpaySecureEditText DEd;
  private TextView DEe;
  private Map<String, b.a> DEf;
  private String DEg;
  private String DEh;
  private boolean DEi;
  public String DEj;
  private int mMode;
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71521);
    this.mMode = 0;
    this.DEg = "";
    this.DEh = "";
    this.DEi = true;
    init(paramContext);
    d(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(71521);
  }
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71522);
    this.mMode = 0;
    this.DEg = "";
    this.DEh = "";
    this.DEi = true;
    init(paramContext);
    d(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(71522);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(71524);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletPhoneInputViewAttrs, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, 0);
    if (paramInt != 0)
    {
      String str = paramContext.getString(paramInt);
      this.DEc.setHint(str);
    }
    paramInt = paramAttributeSet.getResourceId(1, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getString(paramInt);
      this.DEc.setTitleText(paramContext);
    }
    AppMethodBeat.o(71524);
  }
  
  private void eMk()
  {
    AppMethodBeat.i(71527);
    this.DEb.setText(this.DEg);
    this.DEd.setText(this.DEh);
    AppMethodBeat.o(71527);
  }
  
  private void eMl()
  {
    AppMethodBeat.i(71528);
    b.a locala = (b.a)this.DEf.get("86");
    this.DEh = locala.ihd;
    this.DEg = locala.ihe;
    eMk();
    AppMethodBeat.o(71528);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71523);
    inflate(paramContext, 2131496012, this);
    this.DEb = ((WalletFormView)findViewById(2131303207));
    this.DEc = ((WalletFormView)findViewById(2131303219));
    this.DEe = ((TextView)findViewById(2131303326));
    this.DEb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.WalletPhoneInputView", "click area");
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        ((MMActivity)WalletPhoneInputView.this.getContext()).startActivityForResult(paramAnonymousView, 65521);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71515);
      }
    });
    this.DEd = ((TenpaySecureEditText)this.DEc.findViewById(2131303383));
    if ((getContext() instanceof MMActivity))
    {
      this.DEc.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          WalletPhoneInputView.a(WalletPhoneInputView.this, WalletPhoneInputView.a(WalletPhoneInputView.this));
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71516);
        }
      });
      this.DEc.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
      {
        public final boolean a(WalletFormView paramAnonymousWalletFormView)
        {
          AppMethodBeat.i(71517);
          if (WalletPhoneInputView.this.eMm())
          {
            boolean bool = paramAnonymousWalletFormView.isPhoneNum();
            AppMethodBeat.o(71517);
            return bool;
          }
          if ((!bu.isNullOrNil(WalletPhoneInputView.b(WalletPhoneInputView.this))) && (!bu.isNullOrNil(WalletPhoneInputView.c(WalletPhoneInputView.this))) && (!bu.isNullOrNil(WalletPhoneInputView.d(WalletPhoneInputView.this).getText())))
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
        
        public final boolean dHs()
        {
          return false;
        }
      });
    }
    getContext();
    paramContext = com.tencent.mm.aw.b.Gt(getContext().getString(2131757950));
    this.DEf = new HashMap();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      b.a locala = (b.a)paramContext.next();
      this.DEf.put(locala.ihd, locala);
    }
    AppMethodBeat.o(71523);
  }
  
  public final boolean eMm()
  {
    return this.mMode == 0;
  }
  
  public final void eMn()
  {
    AppMethodBeat.i(71529);
    this.mMode = 0;
    eMl();
    this.DEb.setVisibility(8);
    this.DEd.setVisibility(8);
    this.DEe.setVisibility(8);
    AppMethodBeat.o(71529);
  }
  
  public final void eMo()
  {
    AppMethodBeat.i(71530);
    this.mMode = 1;
    eMl();
    this.DEb.setVisibility(0);
    this.DEd.setVisibility(0);
    this.DEe.setVisibility(0);
    this.DEd.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(71519);
        if (bu.isNullOrNil(paramAnonymousEditable.toString()))
        {
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText("");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
          AppMethodBeat.o(71519);
          return;
        }
        if (!WalletPhoneInputView.g(WalletPhoneInputView.this))
        {
          ae.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
          WalletPhoneInputView.h(WalletPhoneInputView.this);
          AppMethodBeat.o(71519);
          return;
        }
        b.a locala = (b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(paramAnonymousEditable.toString());
        ae.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[] { locala, paramAnonymousEditable.toString() });
        if (locala != null)
        {
          WalletPhoneInputView.b(WalletPhoneInputView.this, locala.ihd);
          WalletPhoneInputView.c(WalletPhoneInputView.this, locala.ihe);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(locala.ihe);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
        }
        for (;;)
        {
          WalletPhoneInputView.d(WalletPhoneInputView.this).getInputValidChangeListener().onInputValidChange(WalletPhoneInputView.d(WalletPhoneInputView.this).aVz());
          AppMethodBeat.o(71519);
          return;
          WalletPhoneInputView.b(WalletPhoneInputView.this, "");
          WalletPhoneInputView.c(WalletPhoneInputView.this, "");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(WalletPhoneInputView.this.getContext().getString(2131765736));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.DEd.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71520);
        if (!paramAnonymousBoolean)
        {
          if ((b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(WalletPhoneInputView.f(WalletPhoneInputView.this).getText().toString()) == null)
          {
            WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100800);
            WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100800));
            AppMethodBeat.o(71520);
            return;
          }
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
        }
        AppMethodBeat.o(71520);
      }
    });
    AppMethodBeat.o(71530);
  }
  
  public final boolean g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71526);
    if (paramInt1 == 65521)
    {
      if (paramInt2 == 100)
      {
        String str = paramIntent.getStringExtra("country_name");
        paramIntent = paramIntent.getStringExtra("couttry_code");
        ae.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[] { this.DEg, this.DEh });
        if ((bu.isNullOrNil(str)) || (bu.isNullOrNil(paramIntent)))
        {
          ae.i("MicroMsg.WalletPhoneInputView", "cancel pick");
          AppMethodBeat.o(71526);
          return true;
        }
        this.DEg = str;
        this.DEh = paramIntent;
        this.DEi = false;
        eMk();
        this.DEd.clearFocus();
      }
      AppMethodBeat.o(71526);
      return true;
    }
    AppMethodBeat.o(71526);
    return false;
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(71525);
    if (eMm())
    {
      AppMethodBeat.o(71525);
      return "86";
    }
    String str = this.DEd.getText().toString();
    AppMethodBeat.o(71525);
    return str;
  }
  
  public WalletFormView getPhoneNumberEt()
  {
    return this.DEc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView
 * JD-Core Version:    0.7.0.1
 */