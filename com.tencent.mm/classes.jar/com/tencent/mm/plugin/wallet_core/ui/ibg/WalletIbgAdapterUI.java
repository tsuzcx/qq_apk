package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class WalletIbgAdapterUI
  extends WalletBaseUI
{
  private void aVV(String paramString)
  {
    AppMethodBeat.i(71442);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    f.aA(this, localIntent);
    AppMethodBeat.o(71442);
  }
  
  private void fTO()
  {
    AppMethodBeat.i(71443);
    g.aAi();
    g.aAh().azQ().set(ar.a.NXj, Boolean.TRUE);
    h.a(this, false, getString(2131768616), "", getString(2131768611), getString(2131768610), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71436);
        x.a.gmK();
        Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(2131768612), 1).show();
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
      paramInt1 = ((b)paramq).HQH;
      paramString = ((b)paramq).jumpUrl;
      Log.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[] { paramString, Integer.valueOf(paramInt1) });
      if (paramInt1 == 1)
      {
        paramInt1 = x.a.gmJ();
        Log.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          fTO();
        case 1: 
        case 4: 
          for (paramInt1 = 0; paramInt1 != 0; paramInt1 = 1)
          {
            aVV(paramString);
            finish();
            AppMethodBeat.o(71440);
            return false;
          }
        }
        g.aAi();
        if (((Boolean)g.aAh().azQ().get(ar.a.NXj, Boolean.FALSE)).booleanValue())
        {
          Toast.makeText(this, getString(2131768613), 1).show();
          x.a.gmK();
          finish();
        }
        for (;;)
        {
          paramInt1 = 0;
          break;
          fTO();
        }
      }
      aVV(paramString);
      finish();
      AppMethodBeat.o(71440);
      return false;
    }
    com.tencent.mm.wallet_core.a.c(this, null, 0);
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