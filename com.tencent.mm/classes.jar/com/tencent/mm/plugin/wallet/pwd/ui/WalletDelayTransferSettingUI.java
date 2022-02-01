package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private Preference CLG;
  private Preference CLH;
  private Preference CLI;
  private Preference CLJ;
  private String CLK;
  private int CLL = 0;
  private String mTitle;
  private long pek;
  private com.tencent.mm.ui.base.preference.f screen;
  private String yaH;
  
  private boolean MT(int paramInt)
  {
    return (this.pek & paramInt) != 0L;
  }
  
  private void eEf()
  {
    AppMethodBeat.i(69621);
    if ((this.CLL == 1) && (!bt.isNullOrNil(this.yaH)))
    {
      addIconOptionMenu(0, 2131234701, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(69618);
          com.tencent.mm.wallet_core.ui.e.o(WalletDelayTransferSettingUI.this.getContext(), WalletDelayTransferSettingUI.a(WalletDelayTransferSettingUI.this), false);
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
  
  private void eEg()
  {
    AppMethodBeat.i(69626);
    if (MT(16))
    {
      eEi();
      AppMethodBeat.o(69626);
      return;
    }
    if (MT(32))
    {
      eEj();
      AppMethodBeat.o(69626);
      return;
    }
    eEh();
    AppMethodBeat.o(69626);
  }
  
  private void eEh()
  {
    AppMethodBeat.i(69627);
    this.CLG.setWidgetLayoutResource(2131494878);
    this.CLH.setWidgetLayoutResource(2131494879);
    this.CLI.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69627);
  }
  
  private void eEi()
  {
    AppMethodBeat.i(69628);
    this.CLG.setWidgetLayoutResource(2131494879);
    this.CLH.setWidgetLayoutResource(2131494878);
    this.CLI.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69628);
  }
  
  private void eEj()
  {
    AppMethodBeat.i(69629);
    this.CLG.setWidgetLayoutResource(2131494879);
    this.CLH.setWidgetLayoutResource(2131494879);
    this.CLI.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69629);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69622);
    this.CLG = this.screen.aVD("wallet_transfer_realtime");
    this.CLH = this.screen.aVD("wallet_transfer_2h");
    this.CLI = this.screen.aVD("wallet_transfer_24h");
    this.CLJ = this.screen.aVD("wallet_transfer_title_tips");
    this.CLG.acw(8);
    this.CLH.acw(8);
    this.CLI.acw(8);
    eEg();
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
    g.ajD();
    this.pek = ((Long)g.ajC().ajl().get(147457, Long.valueOf(0L))).longValue();
    initView();
    g.ajD();
    g.ajB().gAO.a(385, this);
    g.ajD();
    this.CLK = ((String)g.ajC().ajl().get(al.a.Ixo, ""));
    g.ajD();
    this.mTitle = ((String)g.ajC().ajl().get(al.a.Ixn, ""));
    g.ajD();
    this.yaH = ((String)g.ajC().ajl().get(al.a.Ixq, ""));
    g.ajD();
    this.CLL = ((Integer)g.ajC().ajl().get(al.a.Ixr, Integer.valueOf(0))).intValue();
    if ((bt.isNullOrNil(this.CLK)) || (bt.isNullOrNil(this.mTitle)) || (bt.isNullOrNil(this.yaH))) {}
    for (boolean bool = aj.a(true, null);; bool = aj.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.e.fRZ();
      if (!bool)
      {
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        g.ajD();
        g.ajB().gAO.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.CLJ.setTitle(this.CLK);
      setMMTitle(this.mTitle);
      eEf();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    ad.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.pek) });
    if (MT(16)) {}
    for (;;)
    {
      cah localcah = new cah();
      localcah.yho = i;
      ((l)g.ab(l.class)).azo().c(new k.a(205, localcah));
      g.ajD();
      g.ajB().gAO.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (MT(32)) {
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
      this.pek &= 0xFFFFFFEF;
      this.pek &= 0xFFFFFFDF;
    }
    for (;;)
    {
      eEg();
      g.ajD();
      g.ajC().ajl().set(147457, Long.valueOf(this.pek));
      finish();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.pek &= 0xFFFFFFDF;
        this.pek |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.pek &= 0xFFFFFFEF;
        this.pek |= 0x20;
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
        this.CLK = ((aj)paramn).CPz;
        this.mTitle = ((aj)paramn).CPy;
        this.yaH = ((aj)paramn).CPB;
        this.CLL = ((aj)paramn).CPC;
        if (!bt.isNullOrNil(this.CLK))
        {
          this.CLJ.setTitle(this.CLK);
          if (bt.isNullOrNil(this.mTitle)) {
            break label150;
          }
          setMMTitle(this.mTitle);
          label109:
          eEf();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.CLJ.setTitle(2131765235);
        break;
        label150:
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(2131765603);
        break label109;
        ad.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.CLJ.setTitle(2131765235);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */