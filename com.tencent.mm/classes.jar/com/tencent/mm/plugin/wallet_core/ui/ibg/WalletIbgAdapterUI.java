package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.a.b;
import com.tencent.mm.pluginsdk.model.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@com.tencent.mm.ui.base.a(7)
public class WalletIbgAdapterUI
  extends WalletBaseUI
{
  private void auz(String paramString)
  {
    AppMethodBeat.i(71442);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    com.tencent.mm.wallet_core.ui.e.X(this, localIntent);
    AppMethodBeat.o(71442);
  }
  
  private void eeY()
  {
    AppMethodBeat.i(71443);
    g.afC();
    g.afB().afk().set(ae.a.FkD, Boolean.TRUE);
    h.a(this, false, getString(2131766143), "", getString(2131766138), getString(2131766137), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(71436);
        w.a.evx();
        Toast.makeText(WalletIbgAdapterUI.this, WalletIbgAdapterUI.this.getString(2131766139), 1).show();
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71440);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof b)))
    {
      paramInt1 = ((b)paramn).zXb;
      paramString = ((b)paramn).jumpUrl;
      ad.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[] { paramString, Integer.valueOf(paramInt1) });
      if (paramInt1 == 1)
      {
        paramInt1 = w.a.evw();
        ad.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[] { Integer.valueOf(paramInt1) });
        switch (paramInt1)
        {
        default: 
          eeY();
        case 1: 
        case 4: 
          for (paramInt1 = 0; paramInt1 != 0; paramInt1 = 1)
          {
            auz(paramString);
            finish();
            AppMethodBeat.o(71440);
            return false;
          }
        }
        g.afC();
        if (((Boolean)g.afB().afk().get(ae.a.FkD, Boolean.FALSE)).booleanValue())
        {
          Toast.makeText(this, getString(2131766140), 1).show();
          w.a.evx();
          finish();
        }
        for (;;)
        {
          paramInt1 = 0;
          break;
          eeY();
        }
      }
      auz(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgAdapterUI
 * JD-Core Version:    0.7.0.1
 */