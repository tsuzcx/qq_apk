package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.b.c.a;

public class SettingsAboutSystemUI
  extends MMPreference
{
  private boolean isDeleteCancel = false;
  private ProgressDialog qHd = null;
  private boolean qHl = false;
  private int qHm = -1;
  private int qHn = -1;
  private boolean qHo = false;
  private f screen;
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(127132);
    TextView localTextView = (TextView)View.inflate(getContext(), 2130970500, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
    }
    AppMethodBeat.o(127132);
  }
  
  private void ckb()
  {
    int j = 0;
    AppMethodBeat.i(127127);
    IconPreference localIconPreference = (IconPreference)this.screen.atx("settings_plugins");
    if (bo.a((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(-2046825377, null), false))
    {
      localIconPreference.OL(0);
      localIconPreference.eN(getString(2131297012), 2130839787);
      if (!com.tencent.mm.x.c.PJ().cd(262158, 266266)) {
        break label132;
      }
      i = 0;
      label76:
      localIconPreference.ON(i);
      com.tencent.mm.plugin.r.a.bWU();
      if (!com.tencent.mm.ax.c.lO(com.tencent.mm.ax.b.fKS)) {
        break label138;
      }
    }
    label132:
    label138:
    for (int i = j;; i = 8)
    {
      localIconPreference.ON(i);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127127);
      return;
      localIconPreference.OL(8);
      localIconPreference.eN("", -1);
      break;
      i = 8;
      break label76;
    }
  }
  
  private boolean ckc()
  {
    AppMethodBeat.i(127128);
    startActivity(new Intent(this, SettingsFontUI.class));
    AppMethodBeat.o(127128);
    return true;
  }
  
  private void ckd()
  {
    int j = 1;
    AppMethodBeat.i(127131);
    if (bo.apV(com.tencent.mm.m.g.Nq().getValue("SilentDownloadApkAtWiFi")) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x1) != 0)
      {
        ab.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.screen.cl("settings_silence_update_mode", true);
      AppMethodBeat.o(127131);
      return;
    }
    this.screen.cl("settings_silence_update_mode", false);
    Preference localPreference;
    if ((((Integer)com.tencent.mm.kernel.g.RL().Ru().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = j;
      localPreference = this.screen.atx("settings_silence_update_mode");
      if (i == 0) {
        break label156;
      }
    }
    label156:
    for (i = 2131303430;; i = 2131303429)
    {
      localPreference.setSummary(getString(i));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127131);
      return;
      i = 0;
      break;
    }
  }
  
  private void cke()
  {
    AppMethodBeat.i(127133);
    int i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SIGHTAutoLoadNetwork"), 1);
    int j = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(327686, null), i);
    ab.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (this.qHm == -1) {
      this.qHm = j;
    }
    this.qHn = j;
    if (3 == j) {
      i = 2131303443;
    }
    for (;;)
    {
      Preference localPreference = this.screen.atx("settings_sns_sight_auto_download");
      if (localPreference != null) {
        localPreference.setSummary(getString(i));
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(127133);
      return;
      if (2 == j) {
        i = 2131303445;
      } else {
        i = 2131303442;
      }
    }
  }
  
  private void jS(boolean paramBoolean)
  {
    AppMethodBeat.i(127129);
    if (paramBoolean)
    {
      getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzP, Integer.valueOf(1));
      AppMethodBeat.o(127129);
      return;
    }
    getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yzP, Integer.valueOf(2));
    AppMethodBeat.o(127129);
  }
  
  private void kH(boolean paramBoolean)
  {
    AppMethodBeat.i(127130);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("settings_nfc_switch");
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putBoolean("settings_nfc_switch", paramBoolean).commit();
    localCheckBoxPreference.vxW = paramBoolean;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(127130);
  }
  
  public int getResourceId()
  {
    return 2131165293;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127123);
    setMMTitle(2131303193);
    this.screen = getPreferenceScreen();
    setBackBtn(new SettingsAboutSystemUI.1(this));
    f localf = this.screen;
    if (!com.tencent.mm.compatible.util.d.fv(19)) {}
    for (boolean bool = true;; bool = false)
    {
      localf.cl("settings_swipeback_mode", bool);
      if (!com.tencent.mm.bq.d.ahR("backup")) {
        this.screen.cl("settings_bak_chat", true);
      }
      ckb();
      this.screen.cl("settings_traffic_statistic", com.tencent.mm.bq.d.dpU());
      if (ae.glE) {
        this.screen.cl("settings_take_photo", true);
      }
      AppMethodBeat.o(127123);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127122);
    super.onCreate(paramBundle);
    this.qHl = false;
    initView();
    AppMethodBeat.o(127122);
  }
  
  public void onDestroy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(127125);
    super.onDestroy();
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    if (this.qHo)
    {
      i = this.qHn;
      if (this.qHm != this.qHn) {
        break label126;
      }
      bool1 = true;
      ab.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.qsU;
      i = this.qHn;
      if (this.qHm != this.qHn) {
        break label131;
      }
    }
    label131:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localh.e(11437, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Boolean.valueOf(bool1) });
      AppMethodBeat.o(127125);
      return;
      label126:
      bool1 = false;
      break;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(127126);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_landscape_mode"))
    {
      if (getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)) {
        setRequestedOrientation(-1);
      }
      for (;;)
      {
        AppMethodBeat.o(127126);
        return true;
        setRequestedOrientation(1);
      }
    }
    boolean bool1;
    if (paramf.equals("settings_voicerecorder_mode"))
    {
      if (ac.erv.emL == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (!getDefaultSharedPreferences().getBoolean("settings_voicerecorder_mode", bool1)) {
          com.tencent.mm.ui.base.h.a(getContext(), 2131303522, 2131297087, new SettingsAboutSystemUI.8(this), new SettingsAboutSystemUI.9(this));
        }
        AppMethodBeat.o(127126);
        return true;
      }
    }
    int i;
    if (paramf.equals("settings_nfc_switch"))
    {
      paramf = NfcAdapter.getDefaultAdapter(this);
      if (paramf == null) {
        ab.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
      }
      for (;;)
      {
        AppMethodBeat.o(127126);
        return true;
        i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzP, Integer.valueOf(0))).intValue();
        int j = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzQ, Integer.valueOf(0))).intValue();
        if (((i == 2) || ((i == 0) && (j != 1))) && (!paramf.isEnabled()) && (getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false)))
        {
          kH(false);
          com.tencent.mm.ui.base.h.d(getContext(), getString(2131301836), "", getString(2131301837), getString(2131296888), new SettingsAboutSystemUI.6(this), new SettingsAboutSystemUI.7(this));
        }
        else
        {
          jS(getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false));
        }
      }
    }
    if (paramf.equals("settings_voice_play_mode"))
    {
      boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(26, Boolean.FALSE)).booleanValue();
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        ab.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        paramf = com.tencent.mm.kernel.g.RL().Ru();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        paramf.set(26, Boolean.valueOf(bool1));
        AppMethodBeat.o(127126);
        return true;
      }
    }
    if (paramf.equals("settings_enter_button_send"))
    {
      paramf = (CheckBoxPreference)this.screen.atx("settings_enter_button_send");
      if (paramf != null)
      {
        bool1 = paramf.isChecked();
        ab.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
        com.tencent.mm.kernel.g.RL().Ru().set(66832, Boolean.valueOf(bool1));
      }
      AppMethodBeat.o(127126);
      return true;
    }
    View localView;
    Object localObject;
    if (paramf.equals("settings_sns_sight_auto_download"))
    {
      paramPreference = new c.a(getContext());
      paramPreference.Rj(2131296888);
      paramPreference.Rb(2131303444);
      localView = View.inflate(getContext(), 2130970146, null);
      paramf = (LinearLayout)localView.findViewById(2131826156);
      i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("SIGHTAutoLoadNetwork"), 1);
      i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(327686, null), i);
      localObject = new SettingsAboutSystemUI.2(this, paramf, i);
      if (1 == i)
      {
        bool1 = true;
        a(paramf, 2131303442, 1, bool1, (View.OnClickListener)localObject);
        if (2 != i) {
          break label751;
        }
        bool1 = true;
        label672:
        a(paramf, 2131303445, 2, bool1, (View.OnClickListener)localObject);
        if (3 != i) {
          break label757;
        }
      }
      label751:
      label757:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, 2131303443, 3, bool1, (View.OnClickListener)localObject);
        paramPreference.fu(localView);
        paramPreference = paramPreference.aLZ();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        this.qHo = true;
        AppMethodBeat.o(127126);
        return true;
        bool1 = false;
        break;
        bool1 = false;
        break label672;
      }
    }
    if (paramf.equals("settings_silence_update_mode"))
    {
      paramPreference = new c.a(getContext());
      paramPreference.Rj(2131296888);
      paramPreference.Rb(2131303428);
      localView = View.inflate(getContext(), 2130970146, null);
      paramf = (LinearLayout)localView.findViewById(2131826156);
      localObject = new SettingsAboutSystemUI.10(this, paramf);
      if ((((Integer)com.tencent.mm.kernel.g.RL().Ru().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        bool1 = true;
        a(paramf, 2131303430, 0, bool1, (View.OnClickListener)localObject);
        if (bool1) {
          break label938;
        }
      }
      label938:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, 2131303429, 1, bool1, (View.OnClickListener)localObject);
        paramPreference.fu(localView);
        paramPreference = paramPreference.aLZ();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        AppMethodBeat.o(127126);
        return true;
        bool1 = false;
        break;
      }
    }
    if (paramf.equals("settings_language"))
    {
      startActivity(new Intent(getContext(), SettingsLanguageUI.class));
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = ckc();
      AppMethodBeat.o(127126);
      return bool1;
    }
    if (paramf.equals("settings_chatting_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsChattingBackgroundUI.class);
      getContext().startActivity(paramf);
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_manage_findmoreui"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsManageFindMoreUI.class);
      startActivity(paramf);
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_plugins"))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(-2046825377, Boolean.FALSE);
      paramf = new Intent();
      paramf.setClass(this, SettingsPluginsUI.class);
      startActivity(paramf);
      com.tencent.mm.x.c.PJ().ce(262158, 266266);
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_reset"))
    {
      com.tencent.mm.ui.base.h.d(getContext(), getResources().getString(2131303402), "", getString(2131296891), getString(2131296888), new SettingsAboutSystemUI.5(this), null);
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_emoji_manager"))
    {
      paramf = new Intent();
      paramf.putExtra("10931", 2);
      com.tencent.mm.bq.d.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settngs_clean"))
    {
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        t.ii(getContext());
        AppMethodBeat.o(127126);
        return true;
      }
      com.tencent.mm.bq.d.b(getContext(), "clean", ".ui.CleanUI", new Intent());
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_traffic_statistic"))
    {
      startActivity(new Intent(this, SettingsNetStatUI.class));
      AppMethodBeat.o(127126);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = ckc();
      AppMethodBeat.o(127126);
      return bool1;
    }
    if (paramf.equals("settings_swipeback_mode"))
    {
      paramf = (CheckBoxPreference)paramPreference;
      bool1 = com.tencent.mm.compatible.i.b.Mg();
      if (!bool1) {}
      for (i = 2131303456;; i = 2131303455)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(i), null, new SettingsAboutSystemUI.3(this), new SettingsAboutSystemUI.4(this, paramf, bool1));
        AppMethodBeat.o(127126);
        return true;
      }
    }
    if (paramf.equals("settings_take_photo")) {
      startActivity(new Intent(this, SettingsAboutCamera.class));
    }
    for (;;)
    {
      AppMethodBeat.o(127126);
      return false;
      if (paramf.equalsIgnoreCase("settngs_matrix_trace"))
      {
        if (!com.tencent.matrix.b.isInstalled())
        {
          Toast.makeText(this, "Matrix is never installed", 0).show();
          AppMethodBeat.o(127126);
          return false;
        }
        paramf = new Intent();
        paramf.setClassName(ah.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        startActivity(paramf);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127124);
    super.onResume();
    Object localObject = (CheckBoxPreference)this.screen.atx("settings_voice_play_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).vxW = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(26, Boolean.FALSE)).booleanValue();
      ((Preference)localObject).zsk = false;
    }
    localObject = (CheckBoxPreference)this.screen.atx("settings_enter_button_send");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).vxW = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(66832, Boolean.FALSE)).booleanValue();
      ((Preference)localObject).zsk = false;
    }
    localObject = (CheckBoxPreference)this.screen.atx("settings_swipeback_mode");
    if (localObject != null)
    {
      ((CheckBoxPreference)localObject).vxW = com.tencent.mm.compatible.i.b.Mg();
      ((Preference)localObject).zsk = false;
    }
    localObject = this.screen.atx("settings_language");
    if (localObject != null) {
      ((Preference)localObject).setSummary(aa.gQ(getContext()));
    }
    ckb();
    cke();
    cke();
    ckd();
    localObject = NfcAdapter.getDefaultAdapter(this);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.atx("settings_nfc_switch");
    if (localObject == null)
    {
      this.screen.cl("settings_nfc_switch", true);
      localObject = this.screen;
      if ((com.tencent.mm.protocal.d.whL) || (bp.dud())) {
        break label431;
      }
    }
    label431:
    for (boolean bool = true;; bool = false)
    {
      ((f)localObject).cl("settngs_matrix_trace", bool);
      AppMethodBeat.o(127124);
      return;
      this.screen.cl("settings_nfc_switch", false);
      localCheckBoxPreference.setSummary(bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzT, null)));
      if (this.qHl)
      {
        ab.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
        if (((NfcAdapter)localObject).isEnabled())
        {
          jS(true);
          kH(true);
          break;
        }
      }
      int i = ((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzP, Integer.valueOf(0))).intValue();
      if (i == 0) {
        if (((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yzQ, Integer.valueOf(0))).intValue() == 1) {
          kH(true);
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        break;
        kH(false);
        continue;
        if (i == 1) {
          kH(true);
        } else {
          kH(false);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI
 * JD-Core Version:    0.7.0.1
 */