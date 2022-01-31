package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI
  extends WalletECardBaseUI
  implements WalletFormView.a
{
  private Button gJr;
  private String mTrueName;
  private WalletFormView qgz;
  private WalletFormView uzI;
  
  public int getLayoutId()
  {
    return 2130969342;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48135);
    this.qgz = ((WalletFormView)findViewById(2131823474));
    this.uzI = ((WalletFormView)findViewById(2131823475));
    this.gJr = ((Button)findViewById(2131823476));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qgz);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.uzI);
    if (!bo.isNullOrNil(this.mTrueName)) {
      this.qgz.setHint(getString(2131299060, new Object[] { this.mTrueName }));
    }
    for (;;)
    {
      this.uzI.setHint(getString(2131299062));
      this.qgz.setOnInputValidChangeListener(this);
      this.uzI.setOnInputValidChangeListener(this);
      setEditFocusListener(this.qgz, 0, false);
      setEditFocusListener(this.uzI, 0, false);
      this.gJr.setEnabled(false);
      this.gJr.setClickable(false);
      this.gJr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48133);
          ab.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
          if ((WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).asv()) && (WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).asv()))
          {
            paramAnonymousView = WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).getText();
            String str = WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).getText();
            WalletECardCheckOtherCardUI.this.getNetController().p(new Object[] { paramAnonymousView, str });
            AppMethodBeat.o(48133);
            return;
          }
          ab.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
          AppMethodBeat.o(48133);
        }
      });
      AppMethodBeat.o(48135);
      return;
      this.qgz.setHint(getString(2131299061));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48134);
    super.onCreate(paramBundle);
    this.mTrueName = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.uza, "");
    setMMTitle(getString(2131299063));
    this.mNetSceneMgr.addSceneEndListener(385);
    initView();
    AppMethodBeat.o(48134);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48136);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(385);
    AppMethodBeat.o(48136);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(48137);
    ab.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((this.qgz.asv()) && (this.uzI.asv()))
    {
      this.gJr.setEnabled(true);
      this.gJr.setClickable(true);
      AppMethodBeat.o(48137);
      return;
    }
    this.gJr.setEnabled(false);
    this.gJr.setClickable(false);
    AppMethodBeat.o(48137);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI
 * JD-Core Version:    0.7.0.1
 */