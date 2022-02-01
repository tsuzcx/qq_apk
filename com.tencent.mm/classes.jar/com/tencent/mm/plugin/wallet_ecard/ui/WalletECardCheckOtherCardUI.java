package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
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
  private WalletFormView Cjy;
  private WalletFormView HSp;
  private Button krs;
  private String mTrueName;
  
  public int getLayoutId()
  {
    return 2131493866;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71769);
    this.Cjy = ((WalletFormView)findViewById(2131298616));
    this.HSp = ((WalletFormView)findViewById(2131298617));
    this.krs = ((Button)findViewById(2131298618));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Cjy);
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.HSp);
    if (!Util.isNullOrNil(this.mTrueName)) {
      this.Cjy.setHint(getString(2131758438, new Object[] { this.mTrueName }));
    }
    for (;;)
    {
      this.HSp.setHint(getString(2131758440));
      this.Cjy.setOnInputValidChangeListener(this);
      this.HSp.setOnInputValidChangeListener(this);
      setEditFocusListener(this.Cjy, 0, false);
      setEditFocusListener(this.HSp, 0, false);
      this.krs.setEnabled(false);
      this.krs.setClickable(false);
      this.krs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71767);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardCheckOtherCardUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          Log.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
          if ((WalletECardCheckOtherCardUI.a(WalletECardCheckOtherCardUI.this).bql()) && (WalletECardCheckOtherCardUI.b(WalletECardCheckOtherCardUI.this).bql()))
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
      this.Cjy.setHint(getString(2131758439));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71768);
    super.onCreate(paramBundle);
    this.mTrueName = getInput().getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpH, "");
    setMMTitle(getString(2131758441));
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
    if ((this.Cjy.bql()) && (this.HSp.bql()))
    {
      this.krs.setEnabled(true);
      this.krs.setClickable(true);
      AppMethodBeat.o(71771);
      return;
    }
    this.krs.setEnabled(false);
    this.krs.setClickable(false);
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