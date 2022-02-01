package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
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
  private Button iwY;
  private String mTrueName;
  private WalletFormView vuS;
  private WalletFormView zYJ;
  
  public int getLayoutId()
  {
    return 2131493731;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71769);
    this.vuS = ((WalletFormView)findViewById(2131298232));
    this.zYJ = ((WalletFormView)findViewById(2131298233));
    this.iwY = ((Button)findViewById(2131298234));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.vuS);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.zYJ);
    if (!bt.isNullOrNil(this.mTrueName)) {
      this.vuS.setHint(getString(2131758165, new Object[] { this.mTrueName }));
    }
    for (;;)
    {
      this.zYJ.setHint(getString(2131758167));
      this.vuS.setOnInputValidChangeListener(this);
      this.zYJ.setOnInputValidChangeListener(this);
      setEditFocusListener(this.vuS, 0, false);
      setEditFocusListener(this.zYJ, 0, false);
      this.iwY.setEnabled(false);
      this.iwY.setClickable(false);
      this.iwY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71767);
          ad.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
          if ((WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).aKX()) && (WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).aKX()))
          {
            paramAnonymousView = WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).getText();
            String str = WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).getText();
            WalletECardCheckOtherCardUI.this.getNetController().q(new Object[] { paramAnonymousView, str });
            AppMethodBeat.o(71767);
            return;
          }
          ad.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
          AppMethodBeat.o(71767);
        }
      });
      AppMethodBeat.o(71769);
      return;
      this.vuS.setHint(getString(2131758166));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71768);
    super.onCreate(paramBundle);
    this.mTrueName = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.Awd, "");
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
    if ((this.vuS.aKX()) && (this.zYJ.aKX()))
    {
      this.iwY.setEnabled(true);
      this.iwY.setClickable(true);
      AppMethodBeat.o(71771);
      return;
    }
    this.iwY.setEnabled(false);
    this.iwY.setClickable(false);
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