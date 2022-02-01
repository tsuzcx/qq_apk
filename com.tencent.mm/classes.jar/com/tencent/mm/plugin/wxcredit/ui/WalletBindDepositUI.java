package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.z;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletBindDepositUI
  extends WalletBaseUI
{
  private WalletFormView VLV;
  private WalletFormView VNB;
  private ElementQuery Vzs;
  private WalletFormView XHU;
  private boolean isFirst;
  private Button lDJ;
  
  public WalletBindDepositUI()
  {
    AppMethodBeat.i(72318);
    this.isFirst = true;
    this.Vzs = new ElementQuery();
    AppMethodBeat.o(72318);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(72321);
    if (Util.isNullOrNil(this.Vzs.JFk))
    {
      this.VNB.setText("");
      AppMethodBeat.o(72321);
      return;
    }
    if (2 == this.Vzs.VFf)
    {
      this.VNB.setText(this.Vzs.JFk + " " + getString(a.i.wallet_credit_card));
      AppMethodBeat.o(72321);
      return;
    }
    this.VNB.setText(this.Vzs.JFk + " " + getString(a.i.wallet_deposit_card));
    AppMethodBeat.o(72321);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.walle_wxcredit_bind_deposit_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72320);
    setMMTitle(a.i.wallet_bind_deposit_title);
    this.VLV = ((WalletFormView)findViewById(a.f.wallet_card_bankcard_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.VLV);
    this.VNB = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.XHU = ((WalletFormView)findViewById(a.f.mobile_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.XHU);
    this.lDJ = ((Button)findViewById(a.f.next_btn));
    setEditFocusListener(this.VLV, 0, false);
    setEditFocusListener(this.XHU, 0, false);
    this.VNB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72316);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = WalletBindDepositUI.a(WalletBindDepositUI.this).getText();
        if (Util.isNullOrNil(paramAnonymousView))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72316);
          return;
        }
        if (WalletBindDepositUI.b(WalletBindDepositUI.this))
        {
          WalletBindDepositUI.this.getNetController().E(new Object[] { paramAnonymousView });
          WalletBindDepositUI.c(WalletBindDepositUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72316);
          return;
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("key_support_bankcard", 1);
          paramAnonymousView.putString("key_bank_type", WalletBindDepositUI.d(WalletBindDepositUI.this).hAk);
          paramAnonymousView.putInt("key_bankcard_type", 1);
          com.tencent.mm.wallet_core.a.cm(WalletBindDepositUI.this).a(WalletBindDepositUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
      }
    });
    this.lDJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72317);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (WalletBindDepositUI.e(WalletBindDepositUI.this)) {
          WalletBindDepositUI.this.getNetController().t(new Object[] { WalletBindDepositUI.a(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).hAk, WalletBindDepositUI.f(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).VFi, Boolean.FALSE });
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72317);
      }
    });
    AppMethodBeat.o(72320);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(72322);
    Log.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(72322);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(72322);
      return;
      paramIntent = (ElementQuery)paramIntent.getParcelableExtra("elemt_query");
      if (paramIntent.iil())
      {
        this.Vzs = paramIntent;
        updateView();
        AppMethodBeat.o(72322);
        return;
      }
      k.s(this, a.i.wallet_bind_deposit_bank_type_err, a.i.app_tip);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72319);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(72319);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = false;
    AppMethodBeat.i(72323);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof z)))
    {
      paramString = (z)paramp;
      if (paramString.Vya != null)
      {
        if (!paramString.Vya.iil())
        {
          k.s(this, a.i.wallet_bind_deposit_bank_type_err, a.i.app_tip);
          AppMethodBeat.o(72323);
          return true;
        }
        this.Vzs = paramString.Vya;
        updateView();
        if ((this.Vzs.VFd) && (this.Vzs.isError()))
        {
          k.s(this, a.i.wallet_bank_broken, a.i.app_tip);
          AppMethodBeat.o(72323);
          return true;
        }
        paramString = com.tencent.mm.wallet_core.a.cm(this);
        if (paramString != null)
        {
          paramInt1 = this.Vzs.Vyb;
          if (paramString == null)
          {
            if (bool) {
              break label247;
            }
            if (!paramString.ill()) {
              break label225;
            }
            Log.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
            k.s(this, a.i.wallet_allow_international_bankcard, a.i.app_tip);
          }
          for (;;)
          {
            this.VLV.gGd();
            AppMethodBeat.o(72323);
            return true;
            if (!paramString.hPH.containsKey("key_support_bankcard"))
            {
              bool = true;
              break;
            }
            paramInt2 = paramString.jOf();
            if (paramInt2 == 0)
            {
              bool = true;
              break;
            }
            bool = Bankcard.mU(paramInt2, paramInt1);
            break;
            label225:
            Log.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
            k.s(this, a.i.wallet_allow_domestic_bankcard, a.i.app_tip);
          }
        }
        label247:
        updateView();
        AppMethodBeat.o(72323);
        return true;
      }
    }
    AppMethodBeat.o(72323);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI
 * JD-Core Version:    0.7.0.1
 */