package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletBindDepositUI
  extends WalletBaseUI
{
  private ElementQuery OJG;
  private WalletFormView OVG;
  private WalletFormView OXn;
  private WalletFormView QOw;
  private boolean isFirst;
  private Button jbJ;
  
  public WalletBindDepositUI()
  {
    AppMethodBeat.i(72318);
    this.isFirst = true;
    this.OJG = new ElementQuery();
    AppMethodBeat.o(72318);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(72321);
    if (Util.isNullOrNil(this.OJG.DNV))
    {
      this.OXn.setText("");
      AppMethodBeat.o(72321);
      return;
    }
    if (2 == this.OJG.OPl)
    {
      this.OXn.setText(this.OJG.DNV + " " + getString(a.i.wallet_credit_card));
      AppMethodBeat.o(72321);
      return;
    }
    this.OXn.setText(this.OJG.DNV + " " + getString(a.i.wallet_deposit_card));
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
    this.OVG = ((WalletFormView)findViewById(a.f.wallet_card_bankcard_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OVG);
    this.OXn = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.QOw = ((WalletFormView)findViewById(a.f.mobile_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.QOw);
    this.jbJ = ((Button)findViewById(a.f.next_btn));
    setEditFocusListener(this.OVG, 0, false);
    setEditFocusListener(this.QOw, 0, false);
    this.OXn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72316);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = WalletBindDepositUI.a(WalletBindDepositUI.this).getText();
        if (Util.isNullOrNil(paramAnonymousView))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72316);
          return;
        }
        if (WalletBindDepositUI.b(WalletBindDepositUI.this))
        {
          WalletBindDepositUI.this.getNetController().B(new Object[] { paramAnonymousView });
          WalletBindDepositUI.c(WalletBindDepositUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72316);
          return;
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("key_support_bankcard", 1);
          paramAnonymousView.putString("key_bank_type", WalletBindDepositUI.d(WalletBindDepositUI.this).fvP);
          paramAnonymousView.putInt("key_bankcard_type", 1);
          com.tencent.mm.wallet_core.a.bF(WalletBindDepositUI.this).a(WalletBindDepositUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
      }
    });
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72317);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WalletBindDepositUI.e(WalletBindDepositUI.this)) {
          WalletBindDepositUI.this.getNetController().r(new Object[] { WalletBindDepositUI.a(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).fvP, WalletBindDepositUI.f(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).OPo, Boolean.FALSE });
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
      if (paramIntent.gIX())
      {
        this.OJG = paramIntent;
        updateView();
        AppMethodBeat.o(72322);
        return;
      }
      h.p(this, a.i.wallet_bind_deposit_bank_type_err, a.i.app_tip);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72319);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(72319);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(72323);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof z)))
    {
      paramString = (z)paramq;
      if (paramString.OIo != null)
      {
        if (!paramString.OIo.gIX())
        {
          h.p(this, a.i.wallet_bind_deposit_bank_type_err, a.i.app_tip);
          AppMethodBeat.o(72323);
          return true;
        }
        this.OJG = paramString.OIo;
        updateView();
        if ((this.OJG.OPj) && (this.OJG.isError()))
        {
          h.p(this, a.i.wallet_bank_broken, a.i.app_tip);
          AppMethodBeat.o(72323);
          return true;
        }
        paramString = com.tencent.mm.wallet_core.a.bF(this);
        if (paramString != null)
        {
          paramInt1 = this.OJG.OIp;
          if (paramString == null)
          {
            if (bool) {
              break label247;
            }
            if (!paramString.gLV()) {
              break label225;
            }
            Log.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
            h.p(this, a.i.wallet_allow_international_bankcard, a.i.app_tip);
          }
          for (;;)
          {
            this.OVG.fuo();
            AppMethodBeat.o(72323);
            return true;
            if (!paramString.fKb.containsKey("key_support_bankcard"))
            {
              bool = true;
              break;
            }
            paramInt2 = paramString.iik();
            if (paramInt2 == 0)
            {
              bool = true;
              break;
            }
            bool = Bankcard.lj(paramInt2, paramInt1);
            break;
            label225:
            Log.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
            h.p(this, a.i.wallet_allow_domestic_bankcard, a.i.app_tip);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI
 * JD-Core Version:    0.7.0.1
 */