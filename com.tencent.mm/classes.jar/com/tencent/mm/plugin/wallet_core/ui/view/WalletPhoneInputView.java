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
import com.tencent.mm.ax.b.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private TextView DmA;
  private Map<String, b.a> DmB;
  private String DmC;
  private String DmD;
  private boolean DmE;
  public String DmF;
  private WalletFormView Dmx;
  public WalletFormView Dmy;
  private TenpaySecureEditText Dmz;
  private int mMode;
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71521);
    this.mMode = 0;
    this.DmC = "";
    this.DmD = "";
    this.DmE = true;
    init(paramContext);
    d(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(71521);
  }
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71522);
    this.mMode = 0;
    this.DmC = "";
    this.DmD = "";
    this.DmE = true;
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
      this.Dmy.setHint(str);
    }
    paramInt = paramAttributeSet.getResourceId(1, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getString(paramInt);
      this.Dmy.setTitleText(paramContext);
    }
    AppMethodBeat.o(71524);
  }
  
  private void eIC()
  {
    AppMethodBeat.i(71527);
    this.Dmx.setText(this.DmC);
    this.Dmz.setText(this.DmD);
    AppMethodBeat.o(71527);
  }
  
  private void eID()
  {
    AppMethodBeat.i(71528);
    b.a locala = (b.a)this.DmB.get("86");
    this.DmD = locala.iel;
    this.DmC = locala.iem;
    eIC();
    AppMethodBeat.o(71528);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71523);
    inflate(paramContext, 2131496012, this);
    this.Dmx = ((WalletFormView)findViewById(2131303207));
    this.Dmy = ((WalletFormView)findViewById(2131303219));
    this.DmA = ((TextView)findViewById(2131303326));
    this.Dmx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.WalletPhoneInputView", "click area");
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        ((MMActivity)WalletPhoneInputView.this.getContext()).startActivityForResult(paramAnonymousView, 65521);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71515);
      }
    });
    this.Dmz = ((TenpaySecureEditText)this.Dmy.findViewById(2131303383));
    if ((getContext() instanceof MMActivity))
    {
      this.Dmy.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          WalletPhoneInputView.a(WalletPhoneInputView.this, WalletPhoneInputView.a(WalletPhoneInputView.this));
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71516);
        }
      });
      this.Dmy.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
      {
        public final boolean a(WalletFormView paramAnonymousWalletFormView)
        {
          AppMethodBeat.i(71517);
          if (WalletPhoneInputView.this.eIE())
          {
            boolean bool = paramAnonymousWalletFormView.isPhoneNum();
            AppMethodBeat.o(71517);
            return bool;
          }
          if ((!bt.isNullOrNil(WalletPhoneInputView.b(WalletPhoneInputView.this))) && (!bt.isNullOrNil(WalletPhoneInputView.c(WalletPhoneInputView.this))) && (!bt.isNullOrNil(WalletPhoneInputView.d(WalletPhoneInputView.this).getText())))
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
        
        public final boolean dEb()
        {
          return false;
        }
      });
    }
    getContext();
    paramContext = com.tencent.mm.ax.b.FR(getContext().getString(2131757950));
    this.DmB = new HashMap();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      b.a locala = (b.a)paramContext.next();
      this.DmB.put(locala.iel, locala);
    }
    AppMethodBeat.o(71523);
  }
  
  public final boolean eIE()
  {
    return this.mMode == 0;
  }
  
  public final void eIF()
  {
    AppMethodBeat.i(71529);
    this.mMode = 0;
    eID();
    this.Dmx.setVisibility(8);
    this.Dmz.setVisibility(8);
    this.DmA.setVisibility(8);
    AppMethodBeat.o(71529);
  }
  
  public final void eIG()
  {
    AppMethodBeat.i(71530);
    this.mMode = 1;
    eID();
    this.Dmx.setVisibility(0);
    this.Dmz.setVisibility(0);
    this.DmA.setVisibility(0);
    this.Dmz.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(71519);
        if (bt.isNullOrNil(paramAnonymousEditable.toString()))
        {
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText("");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
          AppMethodBeat.o(71519);
          return;
        }
        if (!WalletPhoneInputView.g(WalletPhoneInputView.this))
        {
          ad.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
          WalletPhoneInputView.h(WalletPhoneInputView.this);
          AppMethodBeat.o(71519);
          return;
        }
        b.a locala = (b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(paramAnonymousEditable.toString());
        ad.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[] { locala, paramAnonymousEditable.toString() });
        if (locala != null)
        {
          WalletPhoneInputView.b(WalletPhoneInputView.this, locala.iel);
          WalletPhoneInputView.c(WalletPhoneInputView.this, locala.iem);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(locala.iem);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100711);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100711));
        }
        for (;;)
        {
          WalletPhoneInputView.d(WalletPhoneInputView.this).getInputValidChangeListener().onInputValidChange(WalletPhoneInputView.d(WalletPhoneInputView.this).aVa());
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
    this.Dmz.setOnFocusChangeListener(new View.OnFocusChangeListener()
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
  
  public final boolean f(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71526);
    if (paramInt1 == 65521)
    {
      if (paramInt2 == 100)
      {
        String str = paramIntent.getStringExtra("country_name");
        paramIntent = paramIntent.getStringExtra("couttry_code");
        ad.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[] { this.DmC, this.DmD });
        if ((bt.isNullOrNil(str)) || (bt.isNullOrNil(paramIntent)))
        {
          ad.i("MicroMsg.WalletPhoneInputView", "cancel pick");
          AppMethodBeat.o(71526);
          return true;
        }
        this.DmC = str;
        this.DmD = paramIntent;
        this.DmE = false;
        eIC();
        this.Dmz.clearFocus();
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
    if (eIE())
    {
      AppMethodBeat.o(71525);
      return "86";
    }
    String str = this.Dmz.getText().toString();
    AppMethodBeat.o(71525);
    return str;
  }
  
  public WalletFormView getPhoneNumberEt()
  {
    return this.Dmy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView
 * JD-Core Version:    0.7.0.1
 */