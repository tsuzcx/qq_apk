package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletIbgAdapterUI
  extends WalletBaseUI
{
  private void afP(String paramString)
  {
    AppMethodBeat.i(47842);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    d.b(this, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(47842);
  }
  
  private void cWE()
  {
    AppMethodBeat.i(47843);
    g.RM();
    g.RL().Ru().set(ac.a.yCh, Boolean.TRUE);
    h.a(this, false, getString(2131305906), "", getString(2131305901), getString(2131305900), new WalletIbgAdapterUI.1(this), new WalletIbgAdapterUI.2(this));
    AppMethodBeat.o(47843);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47838);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.mNetSceneMgr.addSceneEndListener(1564);
    doSceneForceProgress(new b());
    AppMethodBeat.o(47838);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47841);
    this.mNetSceneMgr.removeSceneEndListener(1564);
    super.onDestroy();
    AppMethodBeat.o(47841);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(47839);
    super.onResume();
    AppMethodBeat.o(47839);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47840);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof b)))
    {
      paramInt1 = ((b)paramm).ucm;
      paramString = ((b)paramm).jumpUrl;
      ab.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[] { paramString, Integer.valueOf(paramInt1) });
      if (paramInt1 == 1)
      {
        paramInt1 = u.a.dlp();
        ab.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          cWE();
        case 1: 
        case 4: 
          for (paramInt1 = 0; paramInt1 != 0; paramInt1 = 1)
          {
            afP(paramString);
            finish();
            AppMethodBeat.o(47840);
            return false;
          }
        }
        g.RM();
        if (((Boolean)g.RL().Ru().get(ac.a.yCh, Boolean.FALSE)).booleanValue())
        {
          Toast.makeText(this, getString(2131305903), 1).show();
          u.a.dlq();
          finish();
        }
        for (;;)
        {
          paramInt1 = 0;
          break;
          cWE();
        }
      }
      afP(paramString);
      finish();
      AppMethodBeat.o(47840);
      return false;
    }
    com.tencent.mm.wallet_core.a.b(this, null, 0);
    AppMethodBeat.o(47840);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI
 * JD-Core Version:    0.7.0.1
 */