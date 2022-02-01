package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private Preference Ddp;
  private Preference Ddq;
  private Preference Ddr;
  private Preference Dds;
  private String Ddt;
  private int Ddu = 0;
  private String mTitle;
  private long pkQ;
  private com.tencent.mm.ui.base.preference.f screen;
  private String yqy;
  
  private boolean Nz(int paramInt)
  {
    return (this.pkQ & paramInt) != 0L;
  }
  
  private void eHM()
  {
    AppMethodBeat.i(69621);
    if ((this.Ddu == 1) && (!bu.isNullOrNil(this.yqy)))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69618);
          com.tencent.mm.wallet_core.ui.f.p(WalletDelayTransferSettingUI.this.getContext(), WalletDelayTransferSettingUI.a(WalletDelayTransferSettingUI.this), false);
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
  
  private void eHN()
  {
    AppMethodBeat.i(69626);
    if (Nz(16))
    {
      eHP();
      AppMethodBeat.o(69626);
      return;
    }
    if (Nz(32))
    {
      eHQ();
      AppMethodBeat.o(69626);
      return;
    }
    eHO();
    AppMethodBeat.o(69626);
  }
  
  private void eHO()
  {
    AppMethodBeat.i(69627);
    this.Ddp.setWidgetLayoutResource(2131494878);
    this.Ddq.setWidgetLayoutResource(2131494879);
    this.Ddr.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69627);
  }
  
  private void eHP()
  {
    AppMethodBeat.i(69628);
    this.Ddp.setWidgetLayoutResource(2131494879);
    this.Ddq.setWidgetLayoutResource(2131494878);
    this.Ddr.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69628);
  }
  
  private void eHQ()
  {
    AppMethodBeat.i(69629);
    this.Ddp.setWidgetLayoutResource(2131494879);
    this.Ddq.setWidgetLayoutResource(2131494879);
    this.Ddr.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69629);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69622);
    this.Ddp = this.screen.aXe("wallet_transfer_realtime");
    this.Ddq = this.screen.aXe("wallet_transfer_2h");
    this.Ddr = this.screen.aXe("wallet_transfer_24h");
    this.Dds = this.screen.aXe("wallet_transfer_title_tips");
    this.Ddp.ade(8);
    this.Ddq.ade(8);
    this.Ddr.ade(8);
    eHN();
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
    g.ajS();
    this.pkQ = ((Long)g.ajR().ajA().get(147457, Long.valueOf(0L))).longValue();
    initView();
    g.ajS();
    g.ajQ().gDv.a(385, this);
    g.ajS();
    this.Ddt = ((String)g.ajR().ajA().get(am.a.IRM, ""));
    g.ajS();
    this.mTitle = ((String)g.ajR().ajA().get(am.a.IRL, ""));
    g.ajS();
    this.yqy = ((String)g.ajR().ajA().get(am.a.IRO, ""));
    g.ajS();
    this.Ddu = ((Integer)g.ajR().ajA().get(am.a.IRP, Integer.valueOf(0))).intValue();
    if ((bu.isNullOrNil(this.Ddt)) || (bu.isNullOrNil(this.mTitle)) || (bu.isNullOrNil(this.yqy))) {}
    for (boolean bool = com.tencent.mm.plugin.wallet_core.c.aj.a(true, null);; bool = com.tencent.mm.plugin.wallet_core.c.aj.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.f.fWv();
      if (!bool)
      {
        ae.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        g.ajS();
        g.ajQ().gDv.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.Dds.setTitle(this.Ddt);
      setMMTitle(this.mTitle);
      eHM();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    ae.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.pkQ) });
    if (Nz(16)) {}
    for (;;)
    {
      cbb localcbb = new cbb();
      localcbb.yxf = i;
      ((l)g.ab(l.class)).azE().d(new k.a(205, localcbb));
      g.ajS();
      g.ajQ().gDv.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (Nz(32)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(69624);
    paramf = paramPreference.mKey;
    if ("wallet_transfer_realtime".equals(paramf))
    {
      this.pkQ &= 0xFFFFFFEF;
      this.pkQ &= 0xFFFFFFDF;
    }
    for (;;)
    {
      eHN();
      g.ajS();
      g.ajR().ajA().set(147457, Long.valueOf(this.pkQ));
      finish();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.pkQ &= 0xFFFFFFDF;
        this.pkQ |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.pkQ &= 0xFFFFFFEF;
        this.pkQ |= 0x20;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(69625);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.aj))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Ddt = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhd;
        this.mTitle = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhc;
        this.yqy = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhf;
        this.Ddu = ((com.tencent.mm.plugin.wallet_core.c.aj)paramn).Dhg;
        if (!bu.isNullOrNil(this.Ddt))
        {
          this.Dds.setTitle(this.Ddt);
          if (bu.isNullOrNil(this.mTitle)) {
            break label150;
          }
          setMMTitle(this.mTitle);
          label109:
          eHM();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        ae.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.Dds.setTitle(2131765235);
        break;
        label150:
        ae.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(2131765603);
        break label109;
        ae.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.Dds.setTitle(2131765235);
        setMMTitle(2131765603);
      }
    }
    ae.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    AppMethodBeat.o(69625);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */