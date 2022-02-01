package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletBindDepositUI
  extends WalletBaseUI
{
  private ElementQuery Dif;
  private WalletFormView Dud;
  private WalletFormView DvN;
  private WalletFormView EZn;
  private Button fSn;
  private boolean isFirst;
  
  public WalletBindDepositUI()
  {
    AppMethodBeat.i(72318);
    this.isFirst = true;
    this.Dif = new ElementQuery();
    AppMethodBeat.o(72318);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(72321);
    if (bu.isNullOrNil(this.Dif.uVs))
    {
      this.DvN.setText("");
      AppMethodBeat.o(72321);
      return;
    }
    if (2 == this.Dif.DnT)
    {
      this.DvN.setText(this.Dif.uVs + " " + getString(2131765221));
      AppMethodBeat.o(72321);
      return;
    }
    this.DvN.setText(this.Dif.uVs + " " + getString(2131765241));
    AppMethodBeat.o(72321);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495890;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72320);
    setMMTitle(2131765068);
    this.Dud = ((WalletFormView)findViewById(2131306700));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Dud);
    this.DvN = ((WalletFormView)findViewById(2131306717));
    this.EZn = ((WalletFormView)findViewById(2131302346));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.EZn);
    this.fSn = ((Button)findViewById(2131302852));
    setEditFocusListener(this.Dud, 0, false);
    setEditFocusListener(this.EZn, 0, false);
    this.DvN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72316);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = WalletBindDepositUI.a(WalletBindDepositUI.this).getText();
        if (bu.isNullOrNil(paramAnonymousView))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72316);
          return;
        }
        if (WalletBindDepositUI.b(WalletBindDepositUI.this))
        {
          WalletBindDepositUI.this.getNetController().A(new Object[] { paramAnonymousView });
          WalletBindDepositUI.c(WalletBindDepositUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72316);
          return;
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("key_support_bankcard", 1);
          paramAnonymousView.putString("key_bank_type", WalletBindDepositUI.d(WalletBindDepositUI.this).dlT);
          paramAnonymousView.putInt("key_bankcard_type", 1);
          com.tencent.mm.wallet_core.a.bs(WalletBindDepositUI.this).a(WalletBindDepositUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
      }
    });
    this.fSn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72317);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WalletBindDepositUI.e(WalletBindDepositUI.this)) {
          WalletBindDepositUI.this.getNetController().r(new Object[] { WalletBindDepositUI.a(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).dlT, WalletBindDepositUI.f(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).DnW, Boolean.FALSE });
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
    ae.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      if (paramIntent.eIO())
      {
        this.Dif = paramIntent;
        updateView();
        AppMethodBeat.o(72322);
        return;
      }
      h.l(this, 2131765066, 2131755906);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72319);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(72319);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(72323);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof y)))
    {
      paramString = (y)paramn;
      if (paramString.DgM != null)
      {
        if (!paramString.DgM.eIO())
        {
          h.l(this, 2131765066, 2131755906);
          AppMethodBeat.o(72323);
          return true;
        }
        this.Dif = paramString.DgM;
        updateView();
        if ((this.Dif.DnR) && (this.Dif.isError()))
        {
          h.l(this, 2131765036, 2131755906);
          AppMethodBeat.o(72323);
          return true;
        }
        paramString = com.tencent.mm.wallet_core.a.bs(this);
        if (paramString != null)
        {
          paramInt1 = this.Dif.DgN;
          if (paramString == null)
          {
            if (bool) {
              break label238;
            }
            if (!paramString.eLI()) {
              break label217;
            }
            ae.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
            h.l(this, 2131764966, 2131755906);
          }
          for (;;)
          {
            this.Dud.dHv();
            AppMethodBeat.o(72323);
            return true;
            if (!paramString.dyY.containsKey("key_support_bankcard"))
            {
              bool = true;
              break;
            }
            paramInt2 = paramString.fVl();
            if (paramInt2 == 0)
            {
              bool = true;
              break;
            }
            bool = Bankcard.iN(paramInt2, paramInt1);
            break;
            label217:
            ae.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
            h.l(this, 2131764965, 2131755906);
          }
        }
        label238:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI
 * JD-Core Version:    0.7.0.1
 */