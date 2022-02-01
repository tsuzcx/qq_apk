package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private WalletPayUOpenIntroView Dss;
  private MMFormMobileInputView Dst;
  private EditText Dsu;
  private EditText Dsv;
  private Button Dsw;
  private TextView Dsx;
  private TextView Dsy;
  private String Dsz;
  private String jmL;
  
  private String eDr()
  {
    AppMethodBeat.i(72040);
    if (this.Dst.getCountryCode().startsWith("+"))
    {
      str = this.Dst.getCountryCode().substring(1);
      AppMethodBeat.o(72040);
      return str;
    }
    String str = this.Dst.getCountryCode();
    AppMethodBeat.o(72040);
    return str;
  }
  
  private boolean eJj()
  {
    AppMethodBeat.i(72041);
    if ((!bt.isNullOrNil(eDr())) && (!bt.isNullOrNil(this.Dsv.getText().toString())))
    {
      AppMethodBeat.o(72041);
      return true;
    }
    AppMethodBeat.o(72041);
    return false;
  }
  
  private void eJk()
  {
    AppMethodBeat.i(72042);
    if (this.Dst.getVisibility() == 0)
    {
      if (eJj())
      {
        this.Dsz = eDr();
        this.jmL = this.Dst.getMobileNumber();
        this.Dsw.setEnabled(true);
        AppMethodBeat.o(72042);
        return;
      }
      this.Dsw.setEnabled(false);
    }
    AppMethodBeat.o(72042);
  }
  
  public int getLayoutId()
  {
    return 2131495076;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72038);
    super.onCreate(paramBundle);
    this.jmL = getInput().getString("key_mobile");
    this.Dsz = getInput().getString("dial_code");
    if (bt.isNullOrNil(this.Dsz)) {
      this.Dsz = "27";
    }
    this.Dss = ((WalletPayUOpenIntroView)findViewById(2131301044));
    this.Dss.setPagerData(new d[] { new d(2131233575, 2131765731, 2131765725), new d(2131233576, 2131765732, 2131765726), new d(2131233577, 2131765733, 2131765727) });
    this.Dst = ((MMFormMobileInputView)findViewById(2131305178));
    this.Dsw = ((Button)findViewById(2131305174));
    this.Dsu = this.Dst.getCountryCodeEditText();
    this.Dsv = this.Dst.getMobileNumberEditText();
    if (!bt.isNullOrNil(this.jmL)) {
      this.Dsv.setText(this.jmL);
    }
    if (!bt.isNullOrNil(this.Dsz)) {
      this.Dsu.setText(this.Dsz);
    }
    paramBundle = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(72036);
        WalletPayUStartOpenUI.a(WalletPayUStartOpenUI.this);
        AppMethodBeat.o(72036);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.Dsv.addTextChangedListener(paramBundle);
    this.Dsu.addTextChangedListener(paramBundle);
    this.Dsw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72037);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (WalletPayUStartOpenUI.b(WalletPayUStartOpenUI.this).getVisibility() == 0)
        {
          WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(WalletPayUStartOpenUI.this));
          WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.d(WalletPayUStartOpenUI.this));
        }
        WalletPayUStartOpenUI.this.getNetController().s(new Object[0]);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72037);
      }
    });
    this.Dsx = ((TextView)findViewById(2131305177));
    c.a(this, this.Dsx);
    this.Dsy = ((TextView)findViewById(2131305180));
    this.Dsy.setText(ah.fRF());
    AppMethodBeat.o(72038);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72039);
    super.onResume();
    eJk();
    AppMethodBeat.o(72039);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */