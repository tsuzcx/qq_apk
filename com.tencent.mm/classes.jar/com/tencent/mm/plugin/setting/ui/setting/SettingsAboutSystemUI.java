package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.b;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c.a;

public class SettingsAboutSystemUI
  extends MMPreference
{
  private f dnn;
  private boolean isDeleteCancel = false;
  private ProgressDialog nTd = null;
  private boolean nTl = false;
  private int nTm = -1;
  private int nTn = -1;
  private boolean nTo = false;
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = (TextView)View.inflate(this.mController.uMN, a.g.radio_btn_item, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(a.h.radio_on, 0, 0, 0);
    }
  }
  
  private void byR()
  {
    int j = 0;
    IconPreference localIconPreference = (IconPreference)this.dnn.add("settings_plugins");
    if (bk.a((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(-2046825377, null), false))
    {
      localIconPreference.Gt(0);
      localIconPreference.dD(getString(a.i.app_new), a.e.new_tips_bg);
      if (!com.tencent.mm.y.c.BS().bc(262158, 266266)) {
        break label124;
      }
      i = 0;
      label73:
      localIconPreference.Gv(i);
      com.tencent.mm.plugin.y.a.bov();
      if (!com.tencent.mm.aw.c.iW(com.tencent.mm.aw.b.evf)) {
        break label130;
      }
    }
    label130:
    for (int i = j;; i = 8)
    {
      localIconPreference.Gv(i);
      this.dnn.notifyDataSetChanged();
      return;
      localIconPreference.Gt(8);
      localIconPreference.dD("", -1);
      break;
      label124:
      i = 8;
      break label73;
    }
  }
  
  private boolean byS()
  {
    startActivity(new Intent(this, SettingsFontUI.class));
    return true;
  }
  
  private void byT()
  {
    int j = 1;
    if (bk.ZR(com.tencent.mm.m.g.AA().getValue("SilentDownloadApkAtWiFi")) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((com.tencent.mm.sdk.platformtools.e.bvl & 0x1) != 0)
      {
        y.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.dnn.bJ("settings_silence_update_mode", true);
      return;
    }
    this.dnn.bJ("settings_silence_update_mode", false);
    Preference localPreference;
    if ((((Integer)com.tencent.mm.kernel.g.DP().Dz().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = j;
      localPreference = this.dnn.add("settings_silence_update_mode");
      if (i == 0) {
        break label143;
      }
    }
    label143:
    for (i = a.i.settings_silence_update_mode_wifi;; i = a.i.settings_silence_update_mode_none)
    {
      localPreference.setSummary(getString(i));
      this.dnn.notifyDataSetChanged();
      return;
      i = 0;
      break;
    }
  }
  
  private void byU()
  {
    int i = bk.getInt(com.tencent.mm.m.g.AA().getValue("SIGHTAutoLoadNetwork"), 1);
    int j = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(327686, null), i);
    y.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (this.nTm == -1) {
      this.nTm = j;
    }
    this.nTn = j;
    if (3 == j) {
      i = a.i.settings_sns_sight_auto_download_never;
    }
    for (;;)
    {
      Preference localPreference = this.dnn.add("settings_sns_sight_auto_download");
      if ((localPreference != null) && (i != 0)) {
        localPreference.setSummary(getString(i));
      }
      this.dnn.notifyDataSetChanged();
      return;
      if (2 == j) {
        i = a.i.settings_sns_sight_auto_download_wifi;
      } else {
        i = a.i.settings_sns_sight_auto_download_always;
      }
    }
  }
  
  private void hW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getPackageManager().setComponentEnabledSetting(new ComponentName(com.tencent.mm.sdk.platformtools.ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upP, Integer.valueOf(1));
      return;
    }
    getPackageManager().setComponentEnabledSetting(new ComponentName(com.tencent.mm.sdk.platformtools.ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.upP, Integer.valueOf(2));
  }
  
  private void iD(boolean paramBoolean)
  {
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("settings_nfc_switch");
    com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ae.cqR(), 0).edit().putBoolean("settings_nfc_switch", paramBoolean).commit();
    localCheckBoxPreference.rHo = paramBoolean;
    this.dnn.notifyDataSetChanged();
  }
  
  public final boolean a(final f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_landscape_mode")) {
      if (this.dnD.getBoolean("settings_landscape_mode", false)) {
        setRequestedOrientation(-1);
      }
    }
    int i;
    int j;
    do
    {
      for (;;)
      {
        return true;
        setRequestedOrientation(1);
        return true;
        if (!paramf.equals("settings_voicerecorder_mode")) {
          break;
        }
        if (q.dye.duV == 1) {}
        for (bool1 = false; !this.dnD.getBoolean("settings_voicerecorder_mode", bool1); bool1 = true)
        {
          com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.settings_voicerecorder_mode_change_to_amr, a.i.app_tip, new SettingsAboutSystemUI.8(this), new SettingsAboutSystemUI.9(this));
          return true;
        }
      }
      if (paramf.equals("settings_nfc_switch"))
      {
        paramf = NfcAdapter.getDefaultAdapter(this);
        if (paramf == null)
        {
          y.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
          return true;
        }
        i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upP, Integer.valueOf(0))).intValue();
        j = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upQ, Integer.valueOf(0))).intValue();
        if (((i == 2) || ((i == 0) && (j != 1))) && (!paramf.isEnabled()) && (this.dnD.getBoolean("settings_nfc_switch", false)))
        {
          iD(false);
          com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.nfc_off_tips), "", getString(a.i.nfc_open_title), getString(a.i.app_cancel), new SettingsAboutSystemUI.6(this), new SettingsAboutSystemUI.7(this));
          return true;
        }
        hW(this.dnD.getBoolean("settings_nfc_switch", false));
        return true;
      }
      if (paramf.equals("settings_voice_play_mode"))
      {
        boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(26, Boolean.valueOf(false))).booleanValue();
        if (!bool3) {}
        for (bool1 = true;; bool1 = false)
        {
          y.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
          paramf = com.tencent.mm.kernel.g.DP().Dz();
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
          paramf.o(26, Boolean.valueOf(bool1));
          return true;
        }
      }
      if (!paramf.equals("settings_enter_button_send")) {
        break;
      }
      paramf = (CheckBoxPreference)this.dnn.add("settings_enter_button_send");
    } while (paramf == null);
    boolean bool1 = paramf.isChecked();
    y.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
    com.tencent.mm.kernel.g.DP().Dz().o(66832, Boolean.valueOf(bool1));
    return true;
    View localView;
    Object localObject;
    if (paramf.equals("settings_sns_sight_auto_download"))
    {
      paramPreference = new c.a(this.mController.uMN);
      paramPreference.It(a.i.app_cancel);
      paramPreference.Ip(a.i.settings_sns_sight_auto_download_tips);
      localView = View.inflate(this.mController.uMN, a.g.mm_alert_switch, null);
      paramf = (LinearLayout)localView.findViewById(a.f.switcher_container);
      i = bk.getInt(com.tencent.mm.m.g.AA().getValue("SIGHTAutoLoadNetwork"), 1);
      i = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(327686, null), i);
      localObject = new SettingsAboutSystemUI.2(this, paramf, i);
      j = a.i.settings_sns_sight_auto_download_always;
      if (1 == i)
      {
        bool1 = true;
        a(paramf, j, 1, bool1, (View.OnClickListener)localObject);
        j = a.i.settings_sns_sight_auto_download_wifi;
        if (2 != i) {
          break label731;
        }
        bool1 = true;
        label655:
        a(paramf, j, 2, bool1, (View.OnClickListener)localObject);
        j = a.i.settings_sns_sight_auto_download_never;
        if (3 != i) {
          break label737;
        }
      }
      label731:
      label737:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, j, 3, bool1, (View.OnClickListener)localObject);
        paramPreference.ei(localView);
        paramPreference = paramPreference.aoP();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        this.nTo = true;
        return true;
        bool1 = false;
        break;
        bool1 = false;
        break label655;
      }
    }
    if (paramf.equals("settings_silence_update_mode"))
    {
      paramPreference = new c.a(this.mController.uMN);
      paramPreference.It(a.i.app_cancel);
      paramPreference.Ip(a.i.settings_silence_update_mode);
      localView = View.inflate(this.mController.uMN, a.g.mm_alert_switch, null);
      paramf = (LinearLayout)localView.findViewById(a.f.switcher_container);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int k = 0;
          int i = 0;
          Object localObject;
          while (i < paramf.getChildCount())
          {
            localObject = (TextView)paramf.getChildAt(i);
            if (a.f.tips_tv != ((TextView)localObject).getId()) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(a.h.radio_off, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(a.h.radio_on, 0, 0, 0);
          int m = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(7, Integer.valueOf(0))).intValue();
          int n = ((Integer)paramAnonymousView.getTag()).intValue();
          y.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(n) });
          if (n == 0)
          {
            i = 1;
            if ((m & 0x1000000) != 0) {
              break label153;
            }
          }
          label153:
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              break label158;
            }
            return;
            i = 0;
            break;
          }
          label158:
          i = k;
          if (n == 0) {
            i = 1;
          }
          if (i != 0)
          {
            j = 0xFEFFFFFF & m;
            if (i != 0) {
              break label281;
            }
          }
          label281:
          for (i = 1;; i = 2)
          {
            com.tencent.mm.kernel.g.DP().Dz().o(7, Integer.valueOf(j));
            localObject = new zr();
            ((zr)localObject).sYS = 35;
            ((zr)localObject).nfn = i;
            ((j)com.tencent.mm.kernel.g.r(j.class)).Fv().b(new i.a(23, (com.tencent.mm.bv.a)localObject));
            com.tencent.mm.plugin.setting.b.eUS.tk();
            paramAnonymousView.post(new SettingsAboutSystemUI.10.1(this));
            return;
            j = m | 0x1000000;
            break;
          }
        }
      };
      if ((((Integer)com.tencent.mm.kernel.g.DP().Dz().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        bool1 = true;
        a(paramf, a.i.settings_silence_update_mode_wifi, 0, bool1, (View.OnClickListener)localObject);
        i = a.i.settings_silence_update_mode_none;
        if (bool1) {
          break label923;
        }
      }
      label923:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, i, 1, bool1, (View.OnClickListener)localObject);
        paramPreference.ei(localView);
        paramPreference = paramPreference.aoP();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        return true;
        bool1 = false;
        break;
      }
    }
    if (paramf.equals("settings_language"))
    {
      startActivity(new Intent(this.mController.uMN, SettingsLanguageUI.class));
      return true;
    }
    if (paramf.equals("settings_text_size")) {
      return byS();
    }
    if (paramf.equals("settings_chatting_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsChattingBackgroundUI.class);
      this.mController.uMN.startActivity(paramf);
      return true;
    }
    if (paramf.equals("settings_manage_findmoreui"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsManageFindMoreUI.class);
      startActivity(paramf);
      return true;
    }
    if (paramf.equals("settings_plugins"))
    {
      com.tencent.mm.kernel.g.DP().Dz().o(-2046825377, Boolean.valueOf(false));
      paramf = new Intent();
      paramf.setClass(this, SettingsPluginsUI.class);
      startActivity(paramf);
      com.tencent.mm.y.c.BS().bd(262158, 266266);
      return true;
    }
    if (paramf.equals("settings_reset"))
    {
      com.tencent.mm.ui.base.h.a(this.mController.uMN, getResources().getString(a.i.settings_reset_warning), "", getString(a.i.app_clear), getString(a.i.app_cancel), new SettingsAboutSystemUI.5(this), null);
      return true;
    }
    if (paramf.equals("settings_emoji_manager"))
    {
      paramf = new Intent();
      paramf.putExtra("10931", 2);
      com.tencent.mm.br.d.b(this.mController.uMN, "emoji", ".ui.EmojiMineUI", paramf);
      return true;
    }
    if (paramf.equals("settngs_clean"))
    {
      if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.gM(this.mController.uMN);
        return true;
      }
      com.tencent.mm.br.d.b(this.mController.uMN, "clean", ".ui.CleanUI", new Intent());
      return true;
    }
    if (paramf.equals("settings_traffic_statistic"))
    {
      startActivity(new Intent(this, SettingsNetStatUI.class));
      return true;
    }
    if (paramf.equals("settings_text_size")) {
      return byS();
    }
    if (paramf.equals("settings_swipeback_mode"))
    {
      paramf = (CheckBoxPreference)paramPreference;
      bool1 = com.tencent.mm.compatible.i.a.zD();
      if (!bool1) {}
      for (i = a.i.settings_swipeback_mode_open_tips;; i = a.i.settings_swipeback_mode_close_tips)
      {
        com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(i), null, new SettingsAboutSystemUI.3(this), new SettingsAboutSystemUI.4(this, paramf, bool1));
        return true;
      }
    }
    if (paramf.equals("settings_take_photo")) {
      startActivity(new Intent(this, SettingsAboutCamera.class));
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_about_system);
    this.dnn = this.vdd;
    setBackBtn(new SettingsAboutSystemUI.1(this));
    f localf = this.dnn;
    if (!com.tencent.mm.compatible.util.d.gF(19)) {}
    for (boolean bool = true;; bool = false)
    {
      localf.bJ("settings_swipeback_mode", bool);
      if (!com.tencent.mm.br.d.SP("backup")) {
        this.dnn.bJ("settings_bak_chat", true);
      }
      byR();
      this.dnn.bJ("settings_traffic_statistic", com.tencent.mm.br.d.coz());
      if (com.tencent.mm.platformtools.ae.eTJ) {
        this.dnn.bJ("settings_take_photo", true);
      }
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nTl = false;
    initView();
  }
  
  protected void onDestroy()
  {
    boolean bool2 = true;
    super.onDestroy();
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    if (this.nTo)
    {
      i = this.nTn;
      if (this.nTm != this.nTn) {
        break label114;
      }
      bool1 = true;
      y.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.nFQ;
      i = this.nTn;
      if (this.nTm != this.nTn) {
        break label119;
      }
    }
    label114:
    label119:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localh.f(11437, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Boolean.valueOf(bool1) });
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = (CheckBoxPreference)this.dnn.add("settings_voice_play_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).rHo = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(26, Boolean.valueOf(false))).booleanValue();
      ((Preference)localObject).vdK = false;
    }
    localObject = (CheckBoxPreference)this.dnn.add("settings_enter_button_send");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).rHo = ((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(66832, Boolean.valueOf(false))).booleanValue();
      ((Preference)localObject).vdK = false;
    }
    localObject = (CheckBoxPreference)this.dnn.add("settings_swipeback_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).rHo = com.tencent.mm.compatible.i.a.zD();
      ((Preference)localObject).vdK = false;
    }
    localObject = this.dnn.add("settings_language");
    if (localObject != null) {
      ((Preference)localObject).setSummary(x.g(this.mController.uMN, a.b.language_setting, a.i.app_lang_sys));
    }
    byR();
    byU();
    byU();
    byT();
    localObject = NfcAdapter.getDefaultAdapter(this);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.dnn.add("settings_nfc_switch");
    if (localObject == null)
    {
      this.dnn.bJ("settings_nfc_switch", true);
      return;
    }
    this.dnn.bJ("settings_nfc_switch", false);
    localCheckBoxPreference.setSummary(bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upT, null)));
    if (this.nTl)
    {
      y.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
      if (((NfcAdapter)localObject).isEnabled())
      {
        hW(true);
        iD(true);
        return;
      }
    }
    int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upP, Integer.valueOf(0))).intValue();
    if (i == 0) {
      if (((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.upQ, Integer.valueOf(0))).intValue() == 1) {
        iD(true);
      }
    }
    for (;;)
    {
      this.dnn.notifyDataSetChanged();
      return;
      iD(false);
      continue;
      if (i == 1) {
        iD(true);
      } else {
        iD(false);
      }
    }
  }
  
  public final int xj()
  {
    return a.k.settings_pref_system;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI
 * JD-Core Version:    0.7.0.1
 */