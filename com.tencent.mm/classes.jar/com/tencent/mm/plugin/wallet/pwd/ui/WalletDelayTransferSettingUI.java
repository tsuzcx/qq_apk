package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.protocal.c.axp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;

public class WalletDelayTransferSettingUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private long iKA;
  private String mTitle;
  private String nAq;
  private Preference qou;
  private Preference qov;
  private Preference qow;
  private Preference qox;
  private String qoy;
  private int qoz = 0;
  
  private void bUt()
  {
    if ((this.qoz == 1) && (!bk.bl(this.nAq)))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new WalletDelayTransferSettingUI.1(this));
      return;
    }
    this.mController.removeAllOptionMenu();
  }
  
  private void bUu()
  {
    if (wb(16))
    {
      this.qou.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      this.qov.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      this.qow.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      return;
    }
    if (wb(32))
    {
      this.qou.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      this.qov.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
      this.qow.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
      return;
    }
    this.qou.setWidgetLayoutResource(a.g.mm_preference_radio_checked);
    this.qov.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
    this.qow.setWidgetLayoutResource(a.g.mm_preference_radio_unchecked);
  }
  
  private boolean wb(int paramInt)
  {
    return (this.iKA & paramInt) != 0L;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if ("wallet_transfer_realtime".equals(paramf))
    {
      this.iKA &= 0xFFFFFFEF;
      this.iKA &= 0xFFFFFFDF;
    }
    for (;;)
    {
      bUu();
      g.DQ();
      g.DP().Dz().o(147457, Long.valueOf(this.iKA));
      finish();
      return true;
      if ("wallet_transfer_2h".equals(paramf))
      {
        this.iKA &= 0xFFFFFFDF;
        this.iKA |= 0x10;
      }
      else if ("wallet_transfer_24h".equals(paramf))
      {
        this.iKA &= 0xFFFFFFEF;
        this.iKA |= 0x20;
      }
    }
  }
  
  protected final void initView()
  {
    this.qou = this.dnn.add("wallet_transfer_realtime");
    this.qov = this.dnn.add("wallet_transfer_2h");
    this.qow = this.dnn.add("wallet_transfer_24h");
    this.qox = this.dnn.add("wallet_transfer_title_tips");
    bUu();
    setBackBtn(new WalletDelayTransferSettingUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(this.mController.czv());
    this.dnn = this.vdd;
    this.dnn.addPreferencesFromResource(a.l.wallet_delay_transfer_setting_pref);
    g.DQ();
    this.iKA = ((Long)g.DP().Dz().get(147457, Long.valueOf(0L))).longValue();
    initView();
    g.DQ();
    g.DO().dJT.a(385, this);
    g.DQ();
    this.qoy = ((String)g.DP().Dz().get(ac.a.uuy, ""));
    g.DQ();
    this.mTitle = ((String)g.DP().Dz().get(ac.a.uux, ""));
    g.DQ();
    this.nAq = ((String)g.DP().Dz().get(ac.a.uuA, ""));
    g.DQ();
    this.qoz = ((Integer)g.DP().Dz().get(ac.a.uuB, Integer.valueOf(0))).intValue();
    if ((bk.bl(this.qoy)) || (bk.bl(this.mTitle)) || (bk.bl(this.nAq))) {}
    for (boolean bool = ae.a(true, null);; bool = ae.a(false, null))
    {
      com.tencent.mm.wallet_core.ui.e.cNo();
      if (!bool)
      {
        y.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
        g.DQ();
        g.DO().dJT.b(385, this);
      }
      return;
      this.qox.setTitle(this.qoy);
      setMMTitle(this.mTitle);
      bUt();
    }
  }
  
  protected void onDestroy()
  {
    int i = 1;
    super.onDestroy();
    y.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[] { Long.valueOf(this.iKA) });
    if (wb(16)) {}
    for (;;)
    {
      axp localaxp = new axp();
      localaxp.nFj = i;
      ((j)g.r(j.class)).Fv().b(new i.a(205, localaxp));
      g.DQ();
      g.DO().dJT.b(385, this);
      return;
      if (wb(32)) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof ae))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qoy = ((ae)paramm).qrj;
        this.mTitle = ((ae)paramm).qri;
        this.nAq = ((ae)paramm).qrl;
        this.qoz = ((ae)paramm).qrm;
        if (!bk.bl(this.qoy))
        {
          this.qox.setTitle(this.qoy);
          if (bk.bl(this.mTitle)) {
            break label139;
          }
          setMMTitle(this.mTitle);
          label103:
          bUt();
        }
      }
      for (;;)
      {
        this.dnn.notifyDataSetChanged();
        return;
        y.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
        this.qox.setTitle(a.i.wallet_delay_transfer_setting_title_hardcode_tip);
        break;
        label139:
        y.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
        setMMTitle(a.i.wallet_password_setting_delay_transfer_date);
        break label103;
        y.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
        this.qox.setTitle(a.i.wallet_delay_transfer_setting_title_hardcode_tip);
        setMMTitle(a.i.wallet_password_setting_delay_transfer_date);
      }
    }
    y.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI
 * JD-Core Version:    0.7.0.1
 */