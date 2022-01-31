package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.bs;
import com.tencent.mm.h.a.th;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.l;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;
import java.util.Map;

public class WalletPasswordSettingUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private boolean dGb;
  private com.tencent.mm.ui.base.preference.f dnn;
  private Dialog ftk;
  private ah handler = new ah(new WalletPasswordSettingUI.1(this));
  com.tencent.mm.sdk.b.c qkv = new com.tencent.mm.sdk.b.c() {};
  private boolean qpA = false;
  private int qpB = 0;
  private int qpC = 0;
  CheckBoxPreference qpt;
  private IconPreference qpu;
  private Preference qpv;
  private String qpw;
  private String qpx;
  private String qpy;
  private com.tencent.mm.plugin.wallet_core.model.z qpz;
  
  private void bUz()
  {
    com.tencent.mm.kernel.g.DQ();
    String str1 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxV, "");
    com.tencent.mm.kernel.g.DQ();
    String str2 = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxW, "");
    y.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", new Object[] { str1, str2 });
    if ((!bk.bl(str1)) && (!bk.bl(str2)))
    {
      this.dnn.bJ("wallet_password_setting_un_reg", false);
      return;
    }
    this.dnn.bJ("wallet_password_setting_un_reg", true);
  }
  
  private void fi(String paramString1, String paramString2)
  {
    this.qpu.setTitle(paramString1);
    if (!bk.bl(paramString2))
    {
      this.dnn.bJ("wallet_open_auto_pay", false);
      return;
    }
    this.dnn.bJ("wallet_open_auto_pay", true);
    y.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null");
  }
  
  private void ky(boolean paramBoolean)
  {
    this.dnD.edit().putBoolean("wallet_fingerprint_switch", paramBoolean).commit();
    this.qpt.rHo = paramBoolean;
    this.dnn.notifyDataSetChanged();
  }
  
  private void kz(boolean paramBoolean)
  {
    com.tencent.mm.plugin.wallet.pwd.a.d locald = new com.tencent.mm.plugin.wallet.pwd.a.d();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(locald, 0);
    this.qpA = true;
    if (paramBoolean) {
      this.ftk = com.tencent.mm.wallet_core.ui.g.a(this, false, new WalletPasswordSettingUI.4(this));
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool = false;
    if ("wallet_modify_password".equals(paramPreference.mKey))
    {
      bUB();
      com.tencent.mm.wallet_core.ui.e.Jc(24);
      bool = true;
    }
    label503:
    do
    {
      return bool;
      if ("wallet_forget_password".equals(paramPreference.mKey))
      {
        com.tencent.mm.kernel.g.DQ();
        paramf = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usA, "");
        if (!bk.bl(paramf))
        {
          y.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", new Object[] { paramf });
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("showShare", false);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
          paramf = new com.tencent.mm.h.b.a.z();
          paramf.ckp = 2L;
          paramf.ckq = 2L;
          paramf.QX();
          return true;
        }
        paramf = o.bVs().bVW();
        if (!bk.bl(paramf))
        {
          y.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", new Object[] { paramf });
          com.tencent.mm.wallet_core.ui.e.l(this, paramf, false);
          return true;
        }
        bUC();
        paramf = new com.tencent.mm.h.b.a.z();
        paramf.ckp = 2L;
        paramf.ckq = 1L;
        paramf.QX();
        com.tencent.mm.wallet_core.ui.e.Jc(25);
        return true;
      }
      if ("wallet_realname_verify".equals(paramPreference.mKey))
      {
        if (o.bVs().bVN()) {
          if (!bk.bl(this.qpx))
          {
            y.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
            paramf = new Intent();
            paramf.putExtra("rawUrl", this.qpx);
            paramf.putExtra("showShare", false);
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
          }
        }
        for (;;)
        {
          return true;
          y.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
          continue;
          y.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
          paramf = new Bundle();
          paramf.putInt("real_name_verify_mode", 0);
          paramf.putString("realname_verify_process_jump_plugin", "wallet");
          paramf.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
          com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, paramf, new WalletPasswordSettingUI.7(this));
        }
      }
      if ("wallet_fingerprint_switch".equals(paramPreference.mKey))
      {
        if (this.qpC == 1)
        {
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upx, Boolean.valueOf(true));
          if (this.qpt.isChecked()) {
            if (this.dGb)
            {
              com.tencent.mm.plugin.soter.d.a.zi(2);
              paramf = (k)com.tencent.mm.kernel.g.r(k.class);
              if ((paramf == null) || (!paramf.aSG())) {
                break label503;
              }
              paramf = new Bundle();
              paramf.putInt("open_scene", 1);
              paramf.putInt("key_open_bio_auth_type", 0);
              com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", paramf);
            }
          }
        }
        for (;;)
        {
          return true;
          com.tencent.mm.plugin.soter.d.a.zi(1);
          break;
          this.handler.obtainMessage(2).sendToTarget();
          continue;
          this.handler.obtainMessage(1).sendToTarget();
          continue;
          if (this.qpC == 2)
          {
            if (this.qpt.isChecked())
            {
              paramf = (k)com.tencent.mm.kernel.g.r(k.class);
              if (paramf == null)
              {
                y.w("MicroMsg.WalletPasswordSettingUI", "finger mgr is null");
                return true;
              }
              if (paramf.aST())
              {
                paramf = new Bundle();
                paramf.putInt("open_scene", 1);
                paramf.putInt("key_open_bio_auth_type", 1);
                com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", paramf);
              }
              else
              {
                this.handler.obtainMessage(3).sendToTarget();
              }
            }
            else
            {
              com.tencent.mm.ui.base.h.a(this, false, getString(a.i.faceid_close), "", getResources().getString(a.i.app_ok), getResources().getString(a.i.app_cancel), new WalletPasswordSettingUI.8(this), new WalletPasswordSettingUI.9(this));
            }
          }
          else {
            y.w("MicroMsg.WalletPasswordSettingUI", "error mode: %s", new Object[] { Integer.valueOf(this.qpC) });
          }
        }
      }
      if ("wallet_open_auto_pay".equals(paramPreference.mKey))
      {
        if (!bk.bl(this.qpw))
        {
          y.i("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is not null,jump!");
          paramf = new Intent();
          paramf.putExtra("rawUrl", this.qpw);
          paramf.putExtra("showShare", false);
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramf);
          this.qpu.Gu(8);
          return true;
        }
        y.e("MicroMsg.WalletPasswordSettingUI", "mDeductUrl is null");
      }
      if ("wallet_digitalcert".equals(paramPreference.mKey))
      {
        if (!this.qpA)
        {
          paramf = new com.tencent.mm.plugin.wallet.pwd.a.d();
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DO().dJT.a(paramf, 0);
        }
        com.tencent.mm.br.d.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
        return true;
      }
      if ("wallet_delay_transfer_date".equals(paramPreference.mKey))
      {
        startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
        return true;
      }
    } while (!"wallet_password_setting_un_reg".equals(paramPreference.mKey));
    com.tencent.mm.kernel.g.DQ();
    paramf = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxW, "");
    paramPreference = new Intent();
    paramPreference.putExtra("rawUrl", paramf);
    paramPreference.putExtra("showShare", false);
    com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
    return false;
  }
  
  public int bUA()
  {
    return a.l.wallet_password_setting_pref;
  }
  
  public void bUB()
  {
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
  }
  
  public void bUC()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_paymanager", true);
    localBundle.putInt("key_forgot_scene", 2);
    com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, localBundle, null);
  }
  
  public void bUD()
  {
    Object localObject;
    boolean bool;
    if ((o.bVs().bVK()) || (o.bVs().bVO()))
    {
      this.dnn.bJ("wallet_modify_password", true);
      this.dnn.bJ("wallet_forget_password", true);
      this.dnn.bJ("wallet_fingerprint_switch", true);
      this.dnn.bJ("wallet_realname_verify", false);
      this.dnn.add("wallet_realname_verify").setSummary(a.i.wallet_password_setting_ui_go_realname_verify_now);
      this.dnn.bJ("wallet_digitalcert", true);
      if (!com.tencent.mm.br.d.SP("fingerprint")) {
        break label741;
      }
      localObject = com.tencent.mm.model.c.c.IX().fJ("100428");
      if (((com.tencent.mm.storage.c)localObject).isValid()) {
        break label544;
      }
      y.i("MicroMsg.WalletPasswordSettingUI", "invalid abtest item");
      bool = false;
    }
    for (;;)
    {
      label139:
      y.i("MicroMsg.WalletPasswordSettingUI", "abtest open faceid: %s", new Object[] { Boolean.valueOf(bool) });
      if (com.tencent.mm.plugin.wallet.b.a.bUE())
      {
        this.qpC = 1;
        y.i("MicroMsg.WalletPasswordSettingUI", "isSupportFingeprintForPay is true");
        com.tencent.mm.plugin.wallet.a.p.bTK();
        if ((com.tencent.mm.plugin.wallet.a.p.bTL() != null) && (((k)com.tencent.mm.kernel.g.r(k.class)).aSw()))
        {
          this.qpt.rHo = true;
          this.qpt.vdK = false;
          label219:
          this.qpt.setTitle(a.i.wallet_password_setting_ui_fingerprint_title);
          this.qpt.setSummary(a.i.wallet_password_setting_ui_fingerprint_off_summary);
          this.dnn.bJ("wallet_fingerprint_switch", false);
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upv, Boolean.TRUE);
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upw, Boolean.TRUE);
          com.tencent.mm.kernel.g.DQ();
          localObject = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upx, Boolean.FALSE);
          if (localObject == null) {
            break label782;
          }
        }
      }
      label782:
      for (bool = ((Boolean)localObject).booleanValue();; bool = false)
      {
        label354:
        label380:
        long l;
        int i;
        if (!bool)
        {
          this.qpt.cF(getString(a.i.app_new), a.e.unread_count_shape);
          this.qpt.AL(0);
          if (com.tencent.mm.plugin.wallet.b.a.bUF()) {
            com.tencent.mm.plugin.report.service.h.nFQ.f(15817, new Object[] { Integer.valueOf(0) });
          }
          com.tencent.mm.kernel.g.DQ();
          l = ((Long)com.tencent.mm.kernel.g.DP().Dz().get(147457, Long.valueOf(0L))).longValue();
          i = a.i.wallet_delay_transfer_setting_realtime_text;
          if ((0x10 & l) == 0L) {
            break label765;
          }
          i = a.i.wallet_delay_transfer_setting_2h_text;
        }
        for (;;)
        {
          this.dnn.add("wallet_delay_transfer_date").setSummary(i);
          this.dnn.notifyDataSetChanged();
          return;
          if (o.bVs().bVN())
          {
            this.dnn.bJ("wallet_modify_password", false);
            this.dnn.bJ("wallet_forget_password", false);
            this.dnn.bJ("wallet_fingerprint_switch", false);
            this.dnn.bJ("wallet_realname_verify", false);
            this.dnn.add("wallet_realname_verify").setSummary(a.i.wallet_password_setting_ui_realname_verify_done);
            break;
          }
          y.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
          break;
          label544:
          if (bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("openFaceIdPay"), 0) != 1) {
            break label787;
          }
          bool = true;
          break label139;
          this.qpt.rHo = false;
          this.qpt.vdK = false;
          break label219;
          this.qpt.AL(8);
          break label354;
          if (com.tencent.mm.plugin.wallet.b.a.bUF())
          {
            y.i("MicroMsg.WalletPasswordSettingUI", "show face id pay switch");
            this.qpC = 2;
            com.tencent.mm.plugin.wallet.a.p.bTK();
            if ((com.tencent.mm.plugin.wallet.a.p.bTL() != null) && (((k)com.tencent.mm.kernel.g.r(k.class)).aSz())) {
              this.qpt.rHo = true;
            }
            for (this.qpt.vdK = false;; this.qpt.vdK = false)
            {
              this.qpt.setTitle(a.i.wallet_password_setting_ui_faceid_title);
              this.qpt.setSummary(a.i.wallet_password_setting_ui_faceid_off_summary);
              this.dnn.bJ("wallet_fingerprint_switch", false);
              break;
              this.qpt.rHo = false;
            }
          }
          this.qpC = 0;
          this.dnn.bJ("wallet_fingerprint_switch", true);
          break label354;
          label741:
          y.e("MicroMsg.WalletPasswordSettingUI", "plugin fingerprinthad not been installed");
          this.dnn.bJ("wallet_fingerprint_switch", true);
          break label380;
          label765:
          if ((l & 0x20) != 0L) {
            i = a.i.wallet_delay_transfer_setting_24h_text;
          }
        }
      }
      label787:
      bool = false;
    }
  }
  
  protected final void initView()
  {
    if (q.Gw()) {}
    for (String str = getString(a.i.wallet_password_setting_ui_title_payu);; str = getString(a.i.wallet_password_setting_ui_title))
    {
      setMMTitle(str);
      com.tencent.mm.wallet_core.ui.e.cNo();
      this.dnn = this.vdd;
      this.dnn.addPreferencesFromResource(bUA());
      this.qpu = ((IconPreference)this.dnn.add("wallet_open_auto_pay"));
      this.qpv = this.dnn.add("wallet_delay_transfer_date");
      com.tencent.mm.kernel.g.DQ();
      if (!((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usi, Boolean.valueOf(false))).booleanValue())
      {
        this.qpu.dE("new", a.e.unread_count_shape);
        this.qpu.Gu(0);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DP().Dz().c(ac.a.usi, Boolean.valueOf(true));
      }
      this.qpt = ((CheckBoxPreference)this.dnn.add("wallet_fingerprint_switch"));
      bUD();
      this.dnn.bJ("nfc_idpay", true);
      this.dnn.bJ("wallet_open_auto_pay", true);
      bUz();
      setBackBtn(new WalletPasswordSettingUI.6(this));
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.uMp = true;
    super.onCreate(paramBundle);
    ta(this.mController.czv());
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(385, this);
    com.tencent.mm.sdk.b.a.udP.c(this.qkv);
    this.dGb = getIntent().getBooleanExtra("key_is_from_system", false);
    if (this.dGb)
    {
      y.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
      ((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.walletlock.a.b.class)).a(this, null);
    }
    initView();
    label181:
    Cursor localCursor;
    if (com.tencent.mm.plugin.wallet.pwd.a.d.bLD())
    {
      kz(false);
      com.tencent.mm.kernel.g.DQ();
      this.qpB = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uuC, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.DQ();
      this.qpy = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uux, ""));
      if (bk.bl(this.qpy))
      {
        ae.a(true, null);
        if (this.qpB == 0) {
          this.dnn.bJ("wallet_delay_transfer_date", true);
        }
      }
    }
    else
    {
      com.tencent.mm.kernel.g.DQ();
      this.qpx = ((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.usr, ""));
      paramBundle = o.bVr();
      if (!bk.bl("wallet_open_auto_pay"))
      {
        localCursor = paramBundle.dXw.a("select * from WalletPrefInfo where pref_key=?", new String[] { "wallet_open_auto_pay" }, 2);
        if (localCursor != null)
        {
          if (!localCursor.moveToFirst()) {
            break label463;
          }
          paramBundle = new com.tencent.mm.plugin.wallet_core.model.z();
          paramBundle.d(localCursor);
        }
      }
    }
    for (;;)
    {
      localCursor.close();
      for (;;)
      {
        this.qpz = paramBundle;
        if ((this.qpz == null) || (this.qpz.field_is_show != 1) || (bk.bl(this.qpz.field_pref_url))) {
          break label375;
        }
        y.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
        this.qpw = this.qpz.field_pref_url;
        fi(this.qpz.field_pref_title, this.qpz.field_pref_url);
        break;
        paramBundle = null;
      }
      label375:
      if (this.qpz == null)
      {
        y.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
        break;
      }
      y.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.qpz.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + bk.bl(this.qpz.field_pref_url));
      break;
      this.qpv.setTitle(this.qpy);
      ae.a(false, null);
      break label181;
      label463:
      paramBundle = null;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.b.a.udP.d(this.qkv);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(385, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (((com.tencent.mm.plugin.walletlock.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.walletlock.a.b.class)).bXN())
    {
      finish();
      return;
    }
    bUD();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.pwd.a.d))
      {
        bUD();
        paramString = (com.tencent.mm.plugin.wallet.pwd.a.d)paramm;
        y.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + paramString.qoj);
        this.qpx = paramString.qon;
        if (paramString.qoj == 1)
        {
          this.qpw = paramString.qok;
          fi(bk.aM(paramString.qom, getString(a.i.wallet_pay_deduct_checkbox_label)), paramString.qok);
          bUz();
          if (this.ftk != null) {
            this.ftk.dismiss();
          }
        }
      }
    }
    while (!(paramm instanceof ae))
    {
      do
      {
        for (;;)
        {
          return;
          this.dnn.bJ("wallet_open_auto_pay", true);
        }
      } while (!(paramm instanceof ae));
      this.qpy = ((ae)paramm).qri;
      this.qpB = ((ae)paramm).qrn;
      if (this.qpB == 0)
      {
        this.dnn.bJ("wallet_delay_transfer_date", true);
        return;
      }
      if (!bk.bl(this.qpy)) {
        this.qpv.setTitle(this.qpy);
      }
      for (;;)
      {
        this.dnn.bJ("wallet_delay_transfer_date", false);
        return;
        y.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
      }
    }
    y.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI
 * JD-Core Version:    0.7.0.1
 */