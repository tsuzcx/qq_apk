package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private String mTitle;
  private long nXu;
  private f screen;
  private String vCU;
  private Preference zSY;
  private Preference zSZ;
  private Preference zTa;
  private Preference zTb;
  private String zTc;
  private int zTd = 0;
  
  private boolean Js(int paramInt)
  {
    return (this.nXu & paramInt) != 0L;
  }
  
  private void eaJ()
  {
    AppMethodBeat.i(69621);
    if ((this.zTd == 1) && (!bt.isNullOrNil(this.vCU)))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69618);
          com.tencent.mm.wallet_core.ui.e.p(WalletDelayTransferSettingUI.this.getContext(), WalletDelayTransferSettingUI.a(WalletDelayTransferSettingUI.this), false);
          AppMethodBeat.o(69618);
          return false;
        }
      });
      AppMethodBeat.o(69621);
      return;
    }
    removeAllOptionMenu();
    AppMethodBeat.o(69621);
  }
  
  private void eaK()
  {
    AppMethodBeat.i(69626);
    if (Js(16))
    {
      eaM();
      AppMethodBeat.o(69626);
      return;
    }
    if (Js(32))
    {
      eaN();
      AppMethodBeat.o(69626);
      return;
    }
    eaL();
    AppMethodBeat.o(69626);
  }
  
  private void eaL()
  {
    AppMethodBeat.i(69627);
    this.zSY.setWidgetLayoutResource(2131494878);
    this.zSZ.setWidgetLayoutResource(2131494879);
    this.zTa.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69627);
  }
  
  private void eaM()
  {
    AppMethodBeat.i(69628);
    this.zSY.setWidgetLayoutResource(2131494879);
    this.zSZ.setWidgetLayoutResource(2131494878);
    this.zTa.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69628);
  }
  
  private void eaN()
  {
    AppMethodBeat.i(69629);
    this.zSY.setWidgetLayoutResource(2131494879);
    this.zSZ.setWidgetLayoutResource(2131494879);
    this.zTa.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69629);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69622);
    this.zSY = this.screen.aKk("wallet_transfer_realtime");
    this.zSZ = this.screen.aKk("wallet_transfer_2h");
    this.zTa = this.screen.aKk("wallet_transfer_24h");
    this.zTb = this.screen.aKk("wallet_transfer_title_tips");
    this.zSY.Yb(8);
    this.zSZ.Yb(8);
    this.zTa.Yb(8);
    eaK();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69619);
        WalletDelayTransferSettingUI.this.finish();
        AppMethodBeat.o(69619);
        return false;
      }
    });
    AppMethodBeat.o(69622);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69620);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    this.screen = getPreferenceScreen();
    this.screen.addPreferencesFromResource(2131951757);
    com.tencent.mm.kernel.g.afC();
    this.nXu = ((Long)com.tencent.mm.kernel.g.afB().afk().get(147457, Long.valueOf(0L))).longValue();
    initView();
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(385, this);
    com.tencent.mm.kernel.g.afC();
    this.zTc = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnh, ""));
    com.tencent.mm.kernel.g.afC();
    this.mTitle = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fng, ""));
    com.tencent.mm.kernel.g.afC();
    this.vCU = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnj, ""));
    com.tencent.mm.kernel.g.afC();
    this.zTd = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fnk, Integer.valueOf(0))).intValue();
    if ((bt.isNullOrNil(this.zTc)) || (bt.isNullOrNil(this.mTitle)) || (bt.isNullOrNil(this.vCU))) {}
    for (boolean bool = aj.a(true, null);; bool = aj.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.e.fkz();
      if (!bool)
      {
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.zTb.setTitle(this.zTc);
      setMMTitle(this.mTitle);
      eaJ();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    ad.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.nXu) });
    if (Js(16)) {}
    for (;;)
    {
      bra localbra = new bra();
      localbra.vJA = i;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).apL().c(new j.a(205, localbra));
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (Js(32)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69624);
    paramf = paramPreference.mKey;
    if ("wallet_transfer_realtime".equals(paramf))
    {
      this.nXu &= 0xFFFFFFEF;
      this.nXu &= 0xFFFFFFDF;
    }
    for (;;)
    {
      eaK();
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(147457, Long.valueOf(this.nXu));
      finish();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.nXu &= 0xFFFFFFDF;
        this.nXu |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.nXu &= 0xFFFFFFEF;
        this.nXu |= 0x20;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69625);
    if ((paramn instanceof aj))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.zTc = ((aj)paramn).zWP;
        this.mTitle = ((aj)paramn).zWO;
        this.vCU = ((aj)paramn).zWR;
        this.zTd = ((aj)paramn).zWS;
        if (!bt.isNullOrNil(this.zTc))
        {
          this.zTb.setTitle(this.zTc);
          if (bt.isNullOrNil(this.mTitle)) {
            break label150;
          }
          setMMTitle(this.mTitle);
          label109:
          eaJ();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.zTb.setTitle(2131765235);
        break;
        label150:
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(2131765603);
        break label109;
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.zTb.setTitle(2131765235);
        setMMTitle(2131765603);
      }
    }
    ad.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    AppMethodBeat.o(69625);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */