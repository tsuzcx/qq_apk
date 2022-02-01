package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements i
{
  private String Crp;
  private Preference HJd;
  private Preference HJe;
  private Preference HJf;
  private Preference HJg;
  private String HJh;
  private int HJi = 0;
  private String mTitle;
  private long qAb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private boolean UM(int paramInt)
  {
    return (this.qAb & paramInt) != 0L;
  }
  
  private void fOY()
  {
    AppMethodBeat.i(69621);
    if ((this.HJi == 1) && (!Util.isNullOrNil(this.Crp)))
    {
      addIconOptionMenu(0, 2131235663, new MenuItem.OnMenuItemClickListener()
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
  
  private void fOZ()
  {
    AppMethodBeat.i(69626);
    if (UM(16))
    {
      fPb();
      AppMethodBeat.o(69626);
      return;
    }
    if (UM(32))
    {
      fPc();
      AppMethodBeat.o(69626);
      return;
    }
    fPa();
    AppMethodBeat.o(69626);
  }
  
  private void fPa()
  {
    AppMethodBeat.i(69627);
    this.HJd.setWidgetLayoutResource(2131495615);
    this.HJe.setWidgetLayoutResource(2131495616);
    this.HJf.setWidgetLayoutResource(2131495616);
    AppMethodBeat.o(69627);
  }
  
  private void fPb()
  {
    AppMethodBeat.i(69628);
    this.HJd.setWidgetLayoutResource(2131495616);
    this.HJe.setWidgetLayoutResource(2131495615);
    this.HJf.setWidgetLayoutResource(2131495616);
    AppMethodBeat.o(69628);
  }
  
  private void fPc()
  {
    AppMethodBeat.i(69629);
    this.HJd.setWidgetLayoutResource(2131495616);
    this.HJe.setWidgetLayoutResource(2131495616);
    this.HJf.setWidgetLayoutResource(2131495615);
    AppMethodBeat.o(69629);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69622);
    this.HJd = this.screen.bmg("wallet_transfer_realtime");
    this.HJe = this.screen.bmg("wallet_transfer_2h");
    this.HJf = this.screen.bmg("wallet_transfer_24h");
    this.HJg = this.screen.bmg("wallet_transfer_title_tips");
    this.HJd.alO(8);
    this.HJe.alO(8);
    this.HJf.alO(8);
    fOZ();
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
    this.screen.addPreferencesFromResource(2132017302);
    g.aAi();
    this.qAb = ((Long)g.aAh().azQ().get(147457, Long.valueOf(0L))).longValue();
    initView();
    g.aAi();
    g.aAg().hqi.a(385, this);
    g.aAi();
    this.HJh = ((String)g.aAh().azQ().get(ar.a.NZO, ""));
    g.aAi();
    this.mTitle = ((String)g.aAh().azQ().get(ar.a.NZN, ""));
    g.aAi();
    this.Crp = ((String)g.aAh().azQ().get(ar.a.NZQ, ""));
    g.aAi();
    this.HJi = ((Integer)g.aAh().azQ().get(ar.a.NZR, Integer.valueOf(0))).intValue();
    if ((Util.isNullOrNil(this.HJh)) || (Util.isNullOrNil(this.mTitle)) || (Util.isNullOrNil(this.Crp))) {}
    for (boolean bool = aj.a(true, null);; bool = aj.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.f.hhT();
      if (!bool)
      {
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        g.aAi();
        g.aAg().hqi.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.HJg.setTitle(this.HJh);
      setMMTitle(this.mTitle);
      fOY();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    Log.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.qAb) });
    if (UM(16)) {}
    for (;;)
    {
      cqd localcqd = new cqd();
      localcqd.Cyb = i;
      ((l)g.af(l.class)).aSM().d(new k.a(205, localcqd));
      g.aAi();
      g.aAg().hqi.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (UM(32)) {
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
      this.qAb &= 0xFFFFFFEF;
      this.qAb &= 0xFFFFFFDF;
    }
    for (;;)
    {
      fOZ();
      g.aAi();
      g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
      finish();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.qAb &= 0xFFFFFFDF;
        this.qAb |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.qAb &= 0xFFFFFFEF;
        this.qAb |= 0x20;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(69625);
    if ((paramq instanceof aj))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.HJh = ((aj)paramq).HQw;
        this.mTitle = ((aj)paramq).HQv;
        this.Crp = ((aj)paramq).HQy;
        this.HJi = ((aj)paramq).HQz;
        if (!Util.isNullOrNil(this.HJh))
        {
          this.HJg.setTitle(this.HJh);
          if (Util.isNullOrNil(this.mTitle)) {
            break label150;
          }
          setMMTitle(this.mTitle);
          label109:
          fOY();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.HJg.setTitle(2131767678);
        break;
        label150:
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(2131768052);
        break label109;
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.HJg.setTitle(2131767678);
        setMMTitle(2131768052);
      }
    }
    Log.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    AppMethodBeat.o(69625);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */