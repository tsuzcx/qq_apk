package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
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
  private ElementQuery HRy;
  private WalletFormView Idp;
  private WalletFormView IeY;
  private WalletFormView JQf;
  private Button gxv;
  private boolean isFirst;
  
  public WalletBindDepositUI()
  {
    AppMethodBeat.i(72318);
    this.isFirst = true;
    this.HRy = new ElementQuery();
    AppMethodBeat.o(72318);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(72321);
    if (Util.isNullOrNil(this.HRy.ynT))
    {
      this.IeY.setText("");
      AppMethodBeat.o(72321);
      return;
    }
    if (2 == this.HRy.HXl)
    {
      this.IeY.setText(this.HRy.ynT + " " + getString(2131767664));
      AppMethodBeat.o(72321);
      return;
    }
    this.IeY.setText(this.HRy.ynT + " " + getString(2131767684));
    AppMethodBeat.o(72321);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496870;
  }
  
  public void initView()
  {
    AppMethodBeat.i(72320);
    setMMTitle(2131767511);
    this.Idp = ((WalletFormView)findViewById(2131310161));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Idp);
    this.IeY = ((WalletFormView)findViewById(2131310178));
    this.JQf = ((WalletFormView)findViewById(2131304743));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.JQf);
    this.gxv = ((Button)findViewById(2131305423));
    setEditFocusListener(this.Idp, 0, false);
    setEditFocusListener(this.JQf, 0, false);
    this.IeY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72316);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
          paramAnonymousView.putString("key_bank_type", WalletBindDepositUI.d(WalletBindDepositUI.this).dDj);
          paramAnonymousView.putInt("key_bankcard_type", 1);
          com.tencent.mm.wallet_core.a.by(WalletBindDepositUI.this).a(WalletBindDepositUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        }
      }
    });
    this.gxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72317);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wxcredit/ui/WalletBindDepositUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WalletBindDepositUI.e(WalletBindDepositUI.this)) {
          WalletBindDepositUI.this.getNetController().r(new Object[] { WalletBindDepositUI.a(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).dDj, WalletBindDepositUI.f(WalletBindDepositUI.this).getText(), WalletBindDepositUI.d(WalletBindDepositUI.this).HXo, Boolean.FALSE });
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
      if (paramIntent.fQr())
      {
        this.HRy = paramIntent;
        updateView();
        AppMethodBeat.o(72322);
        return;
      }
      h.n(this, 2131767509, 2131755998);
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof y)))
    {
      paramString = (y)paramq;
      if (paramString.HQf != null)
      {
        if (!paramString.HQf.fQr())
        {
          h.n(this, 2131767509, 2131755998);
          AppMethodBeat.o(72323);
          return true;
        }
        this.HRy = paramString.HQf;
        updateView();
        if ((this.HRy.HXj) && (this.HRy.isError()))
        {
          h.n(this, 2131767479, 2131755998);
          AppMethodBeat.o(72323);
          return true;
        }
        paramString = com.tencent.mm.wallet_core.a.by(this);
        if (paramString != null)
        {
          paramInt1 = this.HRy.HQg;
          if (paramString == null)
          {
            if (bool) {
              break label238;
            }
            if (!paramString.fTp()) {
              break label217;
            }
            Log.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
            h.n(this, 2131767409, 2131755998);
          }
          for (;;)
          {
            this.Idp.eIj();
            AppMethodBeat.o(72323);
            return true;
            if (!paramString.dQL.containsKey("key_support_bankcard"))
            {
              bool = true;
              break;
            }
            paramInt2 = paramString.hgI();
            if (paramInt2 == 0)
            {
              bool = true;
              break;
            }
            bool = Bankcard.jT(paramInt2, paramInt1);
            break;
            label217:
            Log.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
            h.n(this, 2131767408, 2131755998);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI
 * JD-Core Version:    0.7.0.1
 */