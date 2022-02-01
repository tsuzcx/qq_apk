package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(7)
public class WalletIbgAdapterUI
  extends WalletBaseUI
{
  private void bhE(String paramString)
  {
    AppMethodBeat.i(71442);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    g.aJ(this, localIntent);
    AppMethodBeat.o(71442);
  }
  
  private void gMu()
  {
    AppMethodBeat.i(71443);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vlj, Boolean.TRUE);
    com.tencent.mm.ui.base.h.a(this, false, getString(a.i.webview_tbs_need_download), "", getString(a.i.webview_tbs_download_ok), getString(a.i.webview_tbs_download_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71436);
        ab.a.hhl();
        Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(a.i.webview_tbs_download_start), 1).show();
        WalletIbgAdapterUI.this.finish();
        AppMethodBeat.o(71436);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71437);
        WalletIbgAdapterUI.this.finish();
        AppMethodBeat.o(71437);
      }
    });
    AppMethodBeat.o(71443);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71438);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.mNetSceneMgr.addSceneEndListener(1564);
    doSceneForceProgress(new b());
    AppMethodBeat.o(71438);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71441);
    this.mNetSceneMgr.removeSceneEndListener(1564);
    super.onDestroy();
    AppMethodBeat.o(71441);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71439);
    super.onResume();
    AppMethodBeat.o(71439);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71440);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof b)))
    {
      paramInt1 = ((b)paramq).OIP;
      paramString = ((b)paramq).jumpUrl;
      Log.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[] { paramString, Integer.valueOf(paramInt1) });
      if (paramInt1 == 1)
      {
        paramInt1 = ab.a.hhk();
        Log.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          gMu();
        case 1: 
        case 4: 
          for (paramInt1 = 0; paramInt1 != 0; paramInt1 = 1)
          {
            bhE(paramString);
            finish();
            AppMethodBeat.o(71440);
            return false;
          }
        }
        com.tencent.mm.kernel.h.aHH();
        if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vlj, Boolean.FALSE)).booleanValue())
        {
          Toast.makeText(this, getString(a.i.webview_tbs_downloading), 1).show();
          ab.a.hhl();
          finish();
        }
        for (;;)
        {
          paramInt1 = 0;
          break;
          gMu();
        }
      }
      bhE(paramString);
      finish();
      AppMethodBeat.o(71440);
      return false;
    }
    com.tencent.mm.wallet_core.a.b(this, null, 0);
    AppMethodBeat.o(71440);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI
 * JD-Core Version:    0.7.0.1
 */