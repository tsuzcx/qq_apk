package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.bvr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private Preference Bls;
  private Preference Blt;
  private Preference Blu;
  private Preference Blv;
  private String Blw;
  private int Blx = 0;
  private String mTitle;
  private long oAP;
  private f screen;
  private String wMZ;
  
  private boolean Lr(int paramInt)
  {
    return (this.oAP & paramInt) != 0L;
  }
  
  private void eqf()
  {
    AppMethodBeat.i(69621);
    if ((this.Blx == 1) && (!bs.isNullOrNil(this.wMZ)))
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
  
  private void eqg()
  {
    AppMethodBeat.i(69626);
    if (Lr(16))
    {
      eqi();
      AppMethodBeat.o(69626);
      return;
    }
    if (Lr(32))
    {
      eqj();
      AppMethodBeat.o(69626);
      return;
    }
    eqh();
    AppMethodBeat.o(69626);
  }
  
  private void eqh()
  {
    AppMethodBeat.i(69627);
    this.Bls.setWidgetLayoutResource(2131494878);
    this.Blt.setWidgetLayoutResource(2131494879);
    this.Blu.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69627);
  }
  
  private void eqi()
  {
    AppMethodBeat.i(69628);
    this.Bls.setWidgetLayoutResource(2131494879);
    this.Blt.setWidgetLayoutResource(2131494878);
    this.Blu.setWidgetLayoutResource(2131494879);
    AppMethodBeat.o(69628);
  }
  
  private void eqj()
  {
    AppMethodBeat.i(69629);
    this.Bls.setWidgetLayoutResource(2131494879);
    this.Blt.setWidgetLayoutResource(2131494879);
    this.Blu.setWidgetLayoutResource(2131494878);
    AppMethodBeat.o(69629);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69622);
    this.Bls = this.screen.aPN("wallet_transfer_realtime");
    this.Blt = this.screen.aPN("wallet_transfer_2h");
    this.Blu = this.screen.aPN("wallet_transfer_24h");
    this.Blv = this.screen.aPN("wallet_transfer_title_tips");
    this.Bls.aam(8);
    this.Blt.aam(8);
    this.Blu.aam(8);
    eqg();
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
    com.tencent.mm.kernel.g.agS();
    this.oAP = ((Long)com.tencent.mm.kernel.g.agR().agA().get(147457, Long.valueOf(0L))).longValue();
    initView();
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    com.tencent.mm.kernel.g.agS();
    this.Blw = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKW, ""));
    com.tencent.mm.kernel.g.agS();
    this.mTitle = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKV, ""));
    com.tencent.mm.kernel.g.agS();
    this.wMZ = ((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKY, ""));
    com.tencent.mm.kernel.g.agS();
    this.Blx = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GKZ, Integer.valueOf(0))).intValue();
    if ((bs.isNullOrNil(this.Blw)) || (bs.isNullOrNil(this.mTitle)) || (bs.isNullOrNil(this.wMZ))) {}
    for (boolean bool = aj.a(true, null);; bool = aj.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.e.fAP();
      if (!bool)
      {
        ac.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      }
      AppMethodBeat.o(69620);
      return;
      this.Blv.setTitle(this.Blw);
      setMMTitle(this.mTitle);
      eqf();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(69623);
    super.onDestroy();
    ac.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.oAP) });
    if (Lr(16)) {}
    for (;;)
    {
      bvr localbvr = new bvr();
      localbvr.wTE = i;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new j.a(205, localbvr));
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      AppMethodBeat.o(69623);
      return;
      if (Lr(32)) {
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
      this.oAP &= 0xFFFFFFEF;
      this.oAP &= 0xFFFFFFDF;
    }
    for (;;)
    {
      eqg();
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(147457, Long.valueOf(this.oAP));
      finish();
      AppMethodBeat.o(69624);
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.oAP &= 0xFFFFFFDF;
        this.oAP |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.oAP &= 0xFFFFFFEF;
        this.oAP |= 0x20;
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
        this.Blw = ((aj)paramn).Bpj;
        this.mTitle = ((aj)paramn).Bpi;
        this.wMZ = ((aj)paramn).Bpl;
        this.Blx = ((aj)paramn).Bpm;
        if (!bs.isNullOrNil(this.Blw))
        {
          this.Blv.setTitle(this.Blw);
          if (bs.isNullOrNil(this.mTitle)) {
            break label150;
          }
          setMMTitle(this.mTitle);
          label109:
          eqf();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69625);
        return;
        ac.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.Blv.setTitle(2131765235);
        break;
        label150:
        ac.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(2131765603);
        break label109;
        ac.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.Blv.setTitle(2131765235);
        setMMTitle(2131765603);
      }
    }
    ac.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
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