package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI
  extends WalletECardBaseUI
  implements WalletFormView.a
{
  private WalletFormView OcQ;
  private WalletFormView VAi;
  private String mTrueName;
  private Button qgp;
  
  public int getLayoutId()
  {
    return a.g.ecard_check_other_card_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71769);
    this.OcQ = ((WalletFormView)findViewById(a.f.check_other_card_input_et));
    this.VAi = ((WalletFormView)findViewById(a.f.check_other_card_mobile_input_et));
    this.qgp = ((Button)findViewById(a.f.check_other_card_next_btn));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OcQ);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.VAi);
    if (!Util.isNullOrNil(this.mTrueName)) {
      this.OcQ.setHint(getString(a.i.ecard_check_other_card_hint_text, new Object[] { this.mTrueName }));
    }
    for (;;)
    {
      this.VAi.setHint(getString(a.i.ecard_check_other_card_phone_hint_text));
      this.OcQ.setOnInputValidChangeListener(this);
      this.VAi.setOnInputValidChangeListener(this);
      setEditFocusListener(this.OcQ, 0, false);
      setEditFocusListener(this.VAi, 0, false);
      this.qgp.setEnabled(false);
      this.qgp.setClickable(false);
      this.qgp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71767);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          Log.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
          if ((WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).bZp()) && (WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).bZp()))
          {
            paramAnonymousView = WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).getText();
            localObject = WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).getText();
            WalletECardCheckOtherCardUI.this.getNetController().t(new Object[] { paramAnonymousView, localObject });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71767);
            return;
            Log.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
          }
        }
      });
      AppMethodBeat.o(71769);
      return;
      this.OcQ.setHint(getString(a.i.ecard_check_other_card_hint_without_name_text));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71768);
    super.onCreate(paramBundle);
    this.mTrueName = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.VZd, "");
    setMMTitle(getString(a.i.ecard_check_other_card_title));
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
    Log.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.OcQ.bZp()) && (this.VAi.bZp()))
    {
      this.qgp.setEnabled(true);
      this.qgp.setClickable(true);
      AppMethodBeat.o(71771);
      return;
    }
    this.qgp.setEnabled(false);
    this.qgp.setClickable(false);
    AppMethodBeat.o(71771);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI
 * JD-Core Version:    0.7.0.1
 */