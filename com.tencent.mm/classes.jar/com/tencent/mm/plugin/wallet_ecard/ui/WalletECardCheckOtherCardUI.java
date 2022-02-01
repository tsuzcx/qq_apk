package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI
  extends WalletECardBaseUI
  implements WalletFormView.a
{
  private WalletFormView CRs;
  private Button jqk;
  private String mTrueName;
  private WalletFormView xSE;
  
  public int getLayoutId()
  {
    return 2131493731;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71769);
    this.xSE = ((WalletFormView)findViewById(2131298232));
    this.CRs = ((WalletFormView)findViewById(2131298233));
    this.jqk = ((Button)findViewById(2131298234));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.xSE);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.CRs);
    if (!bt.isNullOrNil(this.mTrueName)) {
      this.xSE.setHint(getString(2131758165, new Object[] { this.mTrueName }));
    }
    for (;;)
    {
      this.CRs.setHint(getString(2131758167));
      this.xSE.setOnInputValidChangeListener(this);
      this.CRs.setOnInputValidChangeListener(this);
      setEditFocusListener(this.xSE, 0, false);
      setEditFocusListener(this.CRs, 0, false);
      this.jqk.setEnabled(false);
      this.jqk.setClickable(false);
      this.jqk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71767);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          ad.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
          if ((WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).aVa()) && (WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).aVa()))
          {
            paramAnonymousView = WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).getText();
            localObject = WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).getText();
            WalletECardCheckOtherCardUI.this.getNetController().s(new Object[] { paramAnonymousView, localObject });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71767);
            return;
            ad.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
          }
        }
      });
      AppMethodBeat.o(71769);
      return;
      this.xSE.setHint(getString(2131758166));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71768);
    super.onCreate(paramBundle);
    this.mTrueName = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.DoP, "");
    setMMTitle(getString(2131758168));
    this.mNetSceneMgr.addSceneEndListener(385);
    initView();
    AppMethodBeat.o(71768);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71770);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(385);
    AppMethodBeat.o(71770);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(71771);
    ad.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.xSE.aVa()) && (this.CRs.aVa()))
    {
      this.jqk.setEnabled(true);
      this.jqk.setClickable(true);
      AppMethodBeat.o(71771);
      return;
    }
    this.jqk.setEnabled(false);
    this.jqk.setClickable(false);
    AppMethodBeat.o(71771);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI
 * JD-Core Version:    0.7.0.1
 */