package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

public class SettingsAboutSystemUI
  extends MMPreference
{
  private boolean DaE = false;
  private int DaF = -1;
  private int DaG = -1;
  private boolean DaH = false;
  private ProgressDialog Dav = null;
  private boolean isDeleteCancel = false;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74064);
    TextView localTextView = (TextView)View.inflate(getContext(), 2131496016, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691380, 0, 0, 0);
    }
    AppMethodBeat.o(74064);
  }
  
  private void eSU()
  {
    int j = 0;
    AppMethodBeat.i(74059);
    IconPreference localIconPreference = (IconPreference)this.screen.bmg("settings_plugins");
    if (Util.nullAs((Boolean)g.aAh().azQ().get(-2046825377, null), false))
    {
      localIconPreference.alD(0);
      localIconPreference.gY(getString(2131755915), 2131234232);
      if (!com.tencent.mm.y.c.axV().cP(262158, 266266)) {
        break label132;
      }
      i = 0;
      label76:
      localIconPreference.alF(i);
      com.tencent.mm.plugin.newtips.a.exo();
      if (!com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
        break label138;
      }
    }
    label132:
    label138:
    for (int i = j;; i = 8)
    {
      localIconPreference.alF(i);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74059);
      return;
      localIconPreference.alD(8);
      localIconPreference.gY("", -1);
      break;
      i = 8;
      break label76;
    }
  }
  
  private boolean eSV()
  {
    AppMethodBeat.i(74060);
    Object localObject = new Intent(this, SettingsFontUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74060);
    return true;
  }
  
  private void eSW()
  {
    int j = 1;
    AppMethodBeat.i(74063);
    if (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SilentDownloadApkAtWiFi")) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((ChannelUtil.updateMode & 0x1) != 0)
      {
        Log.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.screen.jdMethod_do("settings_silence_update_mode", true);
      AppMethodBeat.o(74063);
      return;
    }
    this.screen.jdMethod_do("settings_silence_update_mode", false);
    Preference localPreference;
    if ((((Integer)g.aAh().azQ().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = j;
      localPreference = this.screen.bmg("settings_silence_update_mode");
      if (i == 0) {
        break label166;
      }
    }
    label166:
    for (i = 2131765594;; i = 2131765593)
    {
      localPreference.setSummary(getString(i));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74063);
      return;
      i = 0;
      break;
    }
  }
  
  private void eSX()
  {
    AppMethodBeat.i(74065);
    int i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTAutoLoadNetwork"), 1);
    int j = Util.nullAs((Integer)g.aAh().azQ().get(327686, null), i);
    Log.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (this.DaF == -1) {
      this.DaF = j;
    }
    this.DaG = j;
    if (3 == j) {
      i = 2131765607;
    }
    for (;;)
    {
      Preference localPreference = this.screen.bmg("settings_sns_sight_auto_download");
      if (localPreference != null) {
        localPreference.setSummary(getString(i));
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74065);
      return;
      if (2 == j) {
        i = 2131765609;
      } else {
        i = 2131765606;
      }
    }
  }
  
  public static boolean eSY()
  {
    AppMethodBeat.i(256509);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smt, false);
    AppMethodBeat.o(256509);
    return bool;
  }
  
  private void st(boolean paramBoolean)
  {
    AppMethodBeat.i(74061);
    if (paramBoolean)
    {
      getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      g.aAh().azQ().set(ar.a.NUQ, Integer.valueOf(1));
      AppMethodBeat.o(74061);
      return;
    }
    getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    g.aAh().azQ().set(ar.a.NUQ, Integer.valueOf(2));
    AppMethodBeat.o(74061);
  }
  
  private void ur(boolean paramBoolean)
  {
    AppMethodBeat.i(74062);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.bmg("settings_nfc_switch");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("settings_nfc_switch", paramBoolean).commit();
    localCheckBoxPreference.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74062);
  }
  
  public int getResourceId()
  {
    return 2132017282;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74055);
    setMMTitle(2131765328);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74039);
        SettingsAboutSystemUI.this.hideVKB();
        SettingsAboutSystemUI.this.finish();
        AppMethodBeat.o(74039);
        return true;
      }
    });
    com.tencent.mm.ui.base.preference.f localf = this.screen;
    boolean bool;
    if (!com.tencent.mm.compatible.util.d.oD(19))
    {
      bool = true;
      localf.jdMethod_do("settings_swipeback_mode", bool);
      if (!com.tencent.mm.br.c.aZU("backup")) {
        this.screen.jdMethod_do("settings_bak_chat", true);
      }
      eSU();
      this.screen.jdMethod_do("settings_traffic_statistic", com.tencent.mm.br.c.gsX());
      if (!eSY()) {
        break label225;
      }
      if (this.screen.bmg("settings_take_photo") != null) {
        this.screen.bmg("settings_take_photo").setTitle(2131765529);
      }
    }
    for (;;)
    {
      if (ac.jPB) {
        this.screen.jdMethod_do("settings_take_photo", true);
      }
      if ((com.tencent.mm.cc.c.gvD()) || ((!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE) && (!com.tencent.mm.ui.ao.awO())))
      {
        this.screen.jdMethod_do("settings_dark", true);
        this.screen.jdMethod_do("small_divider", true);
      }
      AppMethodBeat.o(74055);
      return;
      bool = false;
      break;
      label225:
      if (this.screen.bmg("settings_take_photo") != null) {
        this.screen.bmg("settings_take_photo").setTitle(2131765528);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74054);
    super.onCreate(paramBundle);
    this.DaE = false;
    initView();
    AppMethodBeat.o(74054);
  }
  
  public void onDestroy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74057);
    super.onDestroy();
    int i;
    com.tencent.mm.plugin.report.service.h localh;
    if (this.DaH)
    {
      i = this.DaG;
      if (this.DaF != this.DaG) {
        break label127;
      }
      bool1 = true;
      Log.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      i = this.DaG;
      if (this.DaF != this.DaG) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localh.a(11437, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Boolean.valueOf(bool1) });
      AppMethodBeat.o(74057);
      return;
      label127:
      bool1 = false;
      break;
    }
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(74058);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_landscape_mode"))
    {
      Log.i("MicroMsg.SettingsAboutSystemUI", "set ScreenOrientation，now is ： %s", new Object[] { Boolean.valueOf(getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)) });
      if (getDefaultSharedPreferences().getBoolean("settings_landscape_mode", false)) {
        setRequestedOrientation(-1);
      }
      for (;;)
      {
        AppMethodBeat.o(74058);
        return true;
        setRequestedOrientation(1);
      }
    }
    final boolean bool1;
    if (paramf.equals("settings_voicerecorder_mode"))
    {
      if (ae.gKu.gDI == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (!getDefaultSharedPreferences().getBoolean("settings_voicerecorder_mode", bool1)) {
          com.tencent.mm.ui.base.h.a(getContext(), 2131765689, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74051);
              SettingsAboutSystemUI.this.getDefaultSharedPreferences().edit().putBoolean("settings_voicerecorder_mode", true).commit();
              ((CheckBoxPreference)SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).bmg("settings_voicerecorder_mode")).setChecked(true);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).notifyDataSetChanged();
              AppMethodBeat.o(74051);
            }
          });
        }
        AppMethodBeat.o(74058);
        return true;
      }
    }
    int i;
    if (paramf.equals("settings_nfc_switch"))
    {
      paramf = NfcAdapter.getDefaultAdapter(this);
      if (paramf == null) {
        Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
      }
      for (;;)
      {
        AppMethodBeat.o(74058);
        return true;
        i = ((Integer)g.aAh().azQ().get(ar.a.NUQ, Integer.valueOf(0))).intValue();
        int j = ((Integer)g.aAh().azQ().get(ar.a.NUR, Integer.valueOf(0))).intValue();
        if (((i == 2) || ((i == 0) && (j != 1))) && (!paramf.isEnabled()) && (getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false)))
        {
          ur(false);
          com.tencent.mm.ui.base.h.c(getContext(), getString(2131763564), "", getString(2131763565), getString(2131755761), new SettingsAboutSystemUI.6(this), new SettingsAboutSystemUI.7(this));
        }
        else
        {
          st(getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false));
        }
      }
    }
    if (paramf.equals("settings_voice_play_mode"))
    {
      boolean bool3 = ((Boolean)g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue();
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        paramf = g.aAh().azQ();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
        paramf.set(26, Boolean.valueOf(bool1));
        AppMethodBeat.o(74058);
        return true;
      }
    }
    if (paramf.equals("settings_enter_button_send"))
    {
      paramf = (CheckBoxPreference)this.screen.bmg("settings_enter_button_send");
      if (paramf != null)
      {
        bool1 = paramf.isChecked();
        Log.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
        g.aAh().azQ().set(66832, Boolean.valueOf(bool1));
      }
      AppMethodBeat.o(74058);
      return true;
    }
    View localView;
    Object localObject;
    if (paramf.equals("settings_sns_sight_auto_download"))
    {
      paramPreference = new d.a(getContext());
      paramPreference.aoW(2131755761);
      paramPreference.aoO(2131765608);
      localView = View.inflate(getContext(), 2131495503, null);
      paramf = (LinearLayout)localView.findViewById(2131308813);
      i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTAutoLoadNetwork"), 1);
      i = Util.nullAs((Integer)g.aAh().azQ().get(327686, null), i);
      localObject = new SettingsAboutSystemUI.2(this, paramf, i);
      if (1 == i)
      {
        bool1 = true;
        a(paramf, 2131765606, 1, bool1, (View.OnClickListener)localObject);
        if (2 != i) {
          break label786;
        }
        bool1 = true;
        label707:
        a(paramf, 2131765609, 2, bool1, (View.OnClickListener)localObject);
        if (3 != i) {
          break label792;
        }
      }
      label786:
      label792:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, 2131765607, 3, bool1, (View.OnClickListener)localObject);
        paramPreference.hs(localView);
        paramPreference = paramPreference.hbn();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        this.DaH = true;
        AppMethodBeat.o(74058);
        return true;
        bool1 = false;
        break;
        bool1 = false;
        break label707;
      }
    }
    if (paramf.equals("settings_silence_update_mode"))
    {
      paramPreference = new d.a(getContext());
      paramPreference.aoW(2131755761);
      paramPreference.aoO(2131765592);
      localView = View.inflate(getContext(), 2131495503, null);
      paramf = (LinearLayout)localView.findViewById(2131308813);
      localObject = new SettingsAboutSystemUI.10(this, paramf);
      if ((((Integer)g.aAh().azQ().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        bool1 = true;
        a(paramf, 2131765594, 0, bool1, (View.OnClickListener)localObject);
        if (bool1) {
          break label977;
        }
      }
      label977:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, 2131765593, 1, bool1, (View.OnClickListener)localObject);
        paramPreference.hs(localView);
        paramPreference = paramPreference.hbn();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        AppMethodBeat.o(74058);
        return true;
        bool1 = false;
        break;
      }
    }
    if (paramf.equals("settings_language"))
    {
      paramf = new Intent(getContext(), SettingsLanguageUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = eSV();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_chatting_bg"))
    {
      paramPreference = new Intent();
      paramPreference.setClass(this, SettingsChattingBackgroundUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bl(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_manage_findmoreui"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsManageFindMoreUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_plugins"))
    {
      g.aAh().azQ().set(-2046825377, Boolean.FALSE);
      paramf = new Intent();
      paramf.setClass(this, SettingsPluginsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.y.c.axV().cQ(262158, 266266);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_reset"))
    {
      com.tencent.mm.ui.base.h.c(getContext(), getResources().getString(2131765566), "", getString(2131755764), getString(2131755761), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousInt = 0;
          AppMethodBeat.i(74048);
          SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, false);
          paramAnonymousDialogInterface = SettingsAboutSystemUI.this;
          Object localObject = SettingsAboutSystemUI.this;
          SettingsAboutSystemUI.this.getString(2131755998);
          SettingsAboutSystemUI.a(paramAnonymousDialogInterface, com.tencent.mm.ui.base.h.a((Context)localObject, SettingsAboutSystemUI.this.getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74045);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, true);
              AppMethodBeat.o(74045);
            }
          }));
          paramAnonymousDialogInterface = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().gCw();
          if (paramAnonymousDialogInterface.size() > 0)
          {
            localObject = com.tencent.mm.model.u.am(paramAnonymousDialogInterface);
            if (localObject != null) {
              while (paramAnonymousInt < ((List)localObject).size())
              {
                if (((Boolean)((List)localObject).get(paramAnonymousInt)).booleanValue()) {
                  com.tencent.mm.plugin.setting.c.jRu.gr((String)paramAnonymousDialogInterface.get(paramAnonymousInt));
                }
                paramAnonymousInt += 1;
              }
            }
          }
          bp.a(new bp.a()
          {
            public final boolean amG()
            {
              AppMethodBeat.i(74046);
              boolean bool = SettingsAboutSystemUI.b(SettingsAboutSystemUI.this);
              AppMethodBeat.o(74046);
              return bool;
            }
            
            public final void amH()
            {
              AppMethodBeat.i(74047);
              if (SettingsAboutSystemUI.c(SettingsAboutSystemUI.this) != null)
              {
                SettingsAboutSystemUI.c(SettingsAboutSystemUI.this).dismiss();
                SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, null);
              }
              AppMethodBeat.o(74047);
            }
          });
          AppMethodBeat.o(74048);
        }
      }, null);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_emoji_manager"))
    {
      paramf = new Intent();
      paramf.putExtra("10931", 2);
      com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settngs_clean"))
    {
      if (!g.aAh().isSDCardAvailable())
      {
        com.tencent.mm.ui.base.u.g(getContext(), null);
        AppMethodBeat.o(74058);
        return true;
      }
      com.tencent.mm.br.c.b(getContext(), "clean", ".ui.CleanUI", new Intent());
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_traffic_statistic"))
    {
      paramf = new Intent(this, SettingsNetStatUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = eSV();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_swipeback_mode"))
    {
      paramf = (CheckBoxPreference)paramPreference;
      bool1 = com.tencent.mm.compatible.h.b.apl();
      if (!bool1) {}
      for (i = 2131765620;; i = 2131765619)
      {
        com.tencent.mm.ui.base.h.a(getContext(), getString(i), null, new SettingsAboutSystemUI.3(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(74044);
            paramf.setChecked(bool1);
            SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).notifyDataSetChanged();
            AppMethodBeat.o(74044);
          }
        });
        AppMethodBeat.o(74058);
        return true;
      }
    }
    if (paramf.equals("settings_take_photo"))
    {
      paramf = new Intent(this, SettingsAboutCamera.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(74058);
      return false;
      if (paramf.equalsIgnoreCase("settngs_matrix_trace"))
      {
        if (!com.tencent.matrix.b.isInstalled())
        {
          Toast.makeText(this, "Matrix is never installed", 0).show();
          AppMethodBeat.o(74058);
          return false;
        }
        paramf = new Intent();
        paramf.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("settings_dark"))
      {
        MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
        paramf = new Intent(this, SettingDarkMode.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74056);
    super.onResume();
    Object localObject1 = (CheckBoxPreference)this.screen.bmg("settings_voice_play_mode");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(((Boolean)g.aAh().azQ().get(26, Boolean.FALSE)).booleanValue());
      ((Preference)localObject1).OZw = false;
    }
    localObject1 = (CheckBoxPreference)this.screen.bmg("settings_enter_button_send");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(((Boolean)g.aAh().azQ().get(66832, Boolean.FALSE)).booleanValue());
      ((Preference)localObject1).OZw = false;
    }
    localObject1 = (CheckBoxPreference)this.screen.bmg("settings_swipeback_mode");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(com.tencent.mm.compatible.h.b.apl());
      ((Preference)localObject1).OZw = false;
    }
    localObject1 = this.screen.bmg("settings_language");
    if (localObject1 != null) {
      ((Preference)localObject1).setSummary(LocaleUtil.getLanguageName(getContext(), 2130903056, 2131755881));
    }
    eSU();
    eSX();
    eSX();
    eSW();
    localObject1 = NfcAdapter.getDefaultAdapter(this);
    Object localObject2 = (CheckBoxPreference)this.screen.bmg("settings_nfc_switch");
    if (localObject1 == null)
    {
      this.screen.jdMethod_do("settings_nfc_switch", true);
      localObject2 = (IconPreference)this.screen.bmg("settings_dark");
      if (com.tencent.mm.ui.ao.awN())
      {
        if (!com.tencent.mm.ui.ao.awS()) {
          break label474;
        }
        localObject1 = getString(2131755881);
      }
    }
    for (;;)
    {
      ((IconPreference)localObject2).setSummary((CharSequence)localObject1);
      com.tencent.mm.cc.c.gvE();
      ((IconPreference)localObject2).alF(8);
      this.screen.jdMethod_do("settngs_matrix_trace", true);
      AppMethodBeat.o(74056);
      return;
      this.screen.jdMethod_do("settings_nfc_switch", false);
      ((CheckBoxPreference)localObject2).setSummary(Util.nullAsNil((String)g.aAh().azQ().get(ar.a.NUU, null)));
      if (this.DaE)
      {
        Log.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
        if (((NfcAdapter)localObject1).isEnabled())
        {
          st(true);
          ur(true);
          break;
        }
      }
      int i = ((Integer)g.aAh().azQ().get(ar.a.NUQ, Integer.valueOf(0))).intValue();
      if (i == 0) {
        if (((Integer)g.aAh().azQ().get(ar.a.NUR, Integer.valueOf(0))).intValue() == 1) {
          ur(true);
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        break;
        ur(false);
        continue;
        if (i == 1) {
          ur(true);
        } else {
          ur(false);
        }
      }
      label474:
      if (com.tencent.mm.ui.ao.isDarkMode()) {
        localObject1 = getString(2131765278);
      } else {
        localObject1 = getString(2131765262);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI
 * JD-Core Version:    0.7.0.1
 */