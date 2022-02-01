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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(3)
public class WalletPayUStartOpenUI
  extends WalletBaseUI
{
  private WalletPayUOpenIntroView Itn;
  private MMFormMobileInputView Ito;
  private EditText Itp;
  private EditText Itq;
  private Button Itr;
  private TextView Its;
  private TextView Itt;
  private String Itu;
  private String knP;
  
  private String fOi()
  {
    AppMethodBeat.i(72040);
    if (this.Ito.getCountryCode().startsWith("+"))
    {
      str = this.Ito.getCountryCode().substring(1);
      AppMethodBeat.o(72040);
      return str;
    }
    String str = this.Ito.getCountryCode();
    AppMethodBeat.o(72040);
    return str;
  }
  
  private boolean fUA()
  {
    AppMethodBeat.i(72041);
    if ((!Util.isNullOrNil(fOi())) && (!Util.isNullOrNil(this.Itq.getText().toString())))
    {
      AppMethodBeat.o(72041);
      return true;
    }
    AppMethodBeat.o(72041);
    return false;
  }
  
  private void fUB()
  {
    AppMethodBeat.i(72042);
    if (this.Ito.getVisibility() == 0)
    {
      if (fUA())
      {
        this.Itu = fOi();
        this.knP = this.Ito.getMobileNumber();
        this.Itr.setEnabled(true);
        AppMethodBeat.o(72042);
        return;
      }
      this.Itr.setEnabled(false);
    }
    AppMethodBeat.o(72042);
  }
  
  public int getLayoutId()
  {
    return 2131495913;
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72038);
    super.onCreate(paramBundle);
    this.knP = getInput().getString("key_mobile");
    this.Itu = getInput().getString("dial_code");
    if (Util.isNullOrNil(this.Itu)) {
      this.Itu = "27";
    }
    this.Itn = ((WalletPayUOpenIntroView)findViewById(2131302697));
    this.Itn.setPagerData(new d[] { new d(2131234383, 2131768184, 2131768178), new d(2131234384, 2131768185, 2131768179), new d(2131234385, 2131768186, 2131768180) });
    this.Ito = ((MMFormMobileInputView)findViewById(2131308368));
    this.Itr = ((Button)findViewById(2131308361));
    this.Itp = this.Ito.getCountryCodeEditText();
    this.Itq = this.Ito.getMobileNumberEditText();
    if (!Util.isNullOrNil(this.knP)) {
      this.Itq.setText(this.knP);
    }
    if (!Util.isNullOrNil(this.Itu)) {
      this.Itp.setText(this.Itu);
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
    this.Itq.addTextChangedListener(paramBundle);
    this.Itp.addTextChangedListener(paramBundle);
    this.Itr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72037);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletPayUStartOpenUI.b(WalletPayUStartOpenUI.this).getVisibility() == 0)
        {
          WalletPayUStartOpenUI.this.getInput().putString("key_mobile", WalletPayUStartOpenUI.c(WalletPayUStartOpenUI.this));
          WalletPayUStartOpenUI.this.getInput().putString("dial_code", WalletPayUStartOpenUI.d(WalletPayUStartOpenUI.this));
        }
        WalletPayUStartOpenUI.this.getNetController().r(new Object[0]);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_payu/create/ui/WalletPayUStartOpenUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72037);
      }
    });
    this.Its = ((TextView)findViewById(2131308366));
    c.a(this, this.Its);
    this.Itt = ((TextView)findViewById(2131308370));
    this.Itt.setText(ah.hhy());
    AppMethodBeat.o(72038);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(72039);
    super.onResume();
    fUB();
    AppMethodBeat.o(72039);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI
 * JD-Core Version:    0.7.0.1
 */