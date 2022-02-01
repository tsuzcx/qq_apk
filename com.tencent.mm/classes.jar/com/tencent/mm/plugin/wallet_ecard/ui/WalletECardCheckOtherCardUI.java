package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI
  extends WalletECardBaseUI
  implements WalletFormView.a
{
  private WalletFormView Igr;
  private WalletFormView OKw;
  private String mTrueName;
  private Button njb;
  
  public int getLayoutId()
  {
    return a.g.ecard_check_other_card_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71769);
    this.Igr = ((WalletFormView)findViewById(a.f.check_other_card_input_et));
    this.OKw = ((WalletFormView)findViewById(a.f.check_other_card_mobile_input_et));
    this.njb = ((Button)findViewById(a.f.check_other_card_next_btn));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Igr);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.OKw);
    if (!Util.isNullOrNil(this.mTrueName)) {
      this.Igr.setHint(getString(a.i.ecard_check_other_card_hint_text, new Object[] { this.mTrueName }));
    }
    for (;;)
    {
      this.OKw.setHint(getString(a.i.ecard_check_other_card_phone_hint_text));
      this.Igr.setOnInputValidChangeListener(this);
      this.OKw.setOnInputValidChangeListener(this);
      setEditFocusListener(this.Igr, 0, false);
      setEditFocusListener(this.OKw, 0, false);
      this.njb.setEnabled(false);
      this.njb.setClickable(false);
      this.njb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71767);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          Log.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
          if ((WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).bAz()) && (WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).bAz()))
          {
            paramAnonymousView = WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).getText();
            localObject = WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).getText();
            WalletECardCheckOtherCardUI.this.getNetController().r(new Object[] { paramAnonymousView, localObject });
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
      this.Igr.setHint(getString(a.i.ecard_check_other_card_hint_without_name_text));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71768);
    super.onCreate(paramBundle);
    this.mTrueName = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.Pip, "");
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
    if ((this.Igr.bAz()) && (this.OKw.bAz()))
    {
      this.njb.setEnabled(true);
      this.njb.setClickable(true);
      AppMethodBeat.o(71771);
      return;
    }
    this.njb.setEnabled(false);
    this.njb.setClickable(false);
    AppMethodBeat.o(71771);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI
 * JD-Core Version:    0.7.0.1
 */