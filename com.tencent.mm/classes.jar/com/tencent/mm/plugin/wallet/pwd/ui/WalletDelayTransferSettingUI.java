package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.ah;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private long kRf;
  private String mTitle;
  private String qlM;
  private com.tencent.mm.ui.base.preference.f screen;
  private Preference tYH;
  private Preference tYI;
  private Preference tYJ;
  private Preference tYK;
  private String tYL;
  private int tYM = 0;
  
  private boolean BF(int paramInt)
  {
    return (this.kRf & paramInt) != 0L;
  }
  
  private void cSA()
  {
    AppMethodBeat.i(46249);
    this.tYH.setWidgetLayoutResource(2130970250);
    this.tYI.setWidgetLayoutResource(2130970249);
    this.tYJ.setWidgetLayoutResource(2130970250);
    AppMethodBeat.o(46249);
  }
  
  private void cSB()
  {
    AppMethodBeat.i(46250);
    this.tYH.setWidgetLayoutResource(2130970250);
    this.tYI.setWidgetLayoutResource(2130970250);
    this.tYJ.setWidgetLayoutResource(2130970249);
    AppMethodBeat.o(46250);
  }
  
  private void cSx()
  {
    AppMethodBeat.i(46242);
    if ((this.tYM == 1) && (!bo.isNullOrNil(this.qlM)))
    {
      addIconOptionMenu(0, 2130840873, new WalletDelayTransferSettingUI.1(this));
      AppMethodBeat.o(46242);
      return;
    }
    removeAllOptionMenu();
    AppMethodBeat.o(46242);
  }
  
  private void cSy()
  {
    AppMethodBeat.i(46247);
    if (BF(16))
    {
      cSA();
      AppMethodBeat.o(46247);
      return;
    }
    if (BF(32))
    {
      cSB();
      AppMethodBeat.o(46247);
      return;
    }
    cSz();
    AppMethodBeat.o(46247);
  }
  
  private void cSz()
  {
    AppMethodBeat.i(46248);
    this.tYH.setWidgetLayoutResource(2130970249);
    this.tYI.setWidgetLayoutResource(2130970250);
    this.tYJ.setWidgetLayoutResource(2130970250);
    AppMethodBeat.o(46248);
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46243);
    this.tYH = this.screen.atx("wallet_transfer_realtime");
    this.tYI = this.screen.atx("wallet_transfer_2h");
    this.tYJ = this.screen.atx("wallet_transfer_24h");
    this.tYK = this.screen.atx("wallet_transfer_title_tips");
    this.tYH.OW(8);
    this.tYI.OW(8);
    this.tYJ.OW(8);
    cSy();
    setBackBtn(new WalletDelayTransferSettingUI.2(this));
    AppMethodBeat.o(46243);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46241);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getActionbarColor());
    this.screen = getPreferenceScreen();
    this.screen.addPreferencesFromResource(2131165312);
    g.RM();
    this.kRf = ((Long)g.RL().Ru().get(147457, Long.valueOf(0L))).longValue();
    initView();
    g.RM();
    g.RK().eHt.a(385, this);
    g.RM();
    this.tYL = ((String)g.RL().Ru().get(ac.a.yEB, ""));
    g.RM();
    this.mTitle = ((String)g.RL().Ru().get(ac.a.yEA, ""));
    g.RM();
    this.qlM = ((String)g.RL().Ru().get(ac.a.yED, ""));
    g.RM();
    this.tYM = ((Integer)g.RL().Ru().get(ac.a.yEE, Integer.valueOf(0))).intValue();
    if ((bo.isNullOrNil(this.tYL)) || (bo.isNullOrNil(this.mTitle)) || (bo.isNullOrNil(this.qlM))) {}
    for (boolean bool = ah.a(true, null);; bool = ah.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.e.dSS();
      if (!bool)
      {
        ab.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        g.RM();
        g.RK().eHt.b(385, this);
      }
      AppMethodBeat.o(46241);
      return;
      this.tYK.setTitle(this.tYL);
      setMMTitle(this.mTitle);
      cSx();
    }
  }
  
  public void onDestroy()
  {
    int i = 1;
    AppMethodBeat.i(46244);
    super.onDestroy();
    ab.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.kRf) });
    if (BF(16)) {}
    for (;;)
    {
      bei localbei = new bei();
      localbei.qsl = i;
      ((j)g.E(j.class)).Yz().c(new j.a(205, localbei));
      g.RM();
      g.RK().eHt.b(385, this);
      AppMethodBeat.o(46244);
      return;
      if (BF(32)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(46245);
    paramf = paramPreference.mKey;
    if ("wallet_transfer_realtime".equals(paramf))
    {
      this.kRf &= 0xFFFFFFEF;
      this.kRf &= 0xFFFFFFDF;
    }
    for (;;)
    {
      cSy();
      g.RM();
      g.RL().Ru().set(147457, Long.valueOf(this.kRf));
      finish();
      AppMethodBeat.o(46245);
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.kRf &= 0xFFFFFFDF;
        this.kRf |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.kRf &= 0xFFFFFFEF;
        this.kRf |= 0x20;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(46246);
    if ((paramm instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tYL = ((ah)paramm).uch;
        this.mTitle = ((ah)paramm).ucg;
        this.qlM = ((ah)paramm).ucj;
        this.tYM = ((ah)paramm).uck;
        if (!bo.isNullOrNil(this.tYL))
        {
          this.tYK.setTitle(this.tYL);
          if (bo.isNullOrNil(this.mTitle)) {
            break label150;
          }
          setMMTitle(this.mTitle);
          label109:
          cSx();
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(46246);
        return;
        ab.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.tYK.setTitle(2131305043);
        break;
        label150:
        ab.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(2131305389);
        break label109;
        ab.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.tYK.setTitle(2131305043);
        setMMTitle(2131305389);
      }
    }
    ab.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    AppMethodBeat.o(46246);
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