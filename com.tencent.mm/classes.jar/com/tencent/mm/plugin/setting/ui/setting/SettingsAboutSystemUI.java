package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.Dialog;
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
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.List;

public class SettingsAboutSystemUI
  extends MMPreference
{
  private boolean isDeleteCancel = false;
  private f screen;
  private ProgressDialog yVG = null;
  private boolean yVQ = false;
  private int yVR = -1;
  private int yVS = -1;
  private boolean yVT = false;
  
  private void a(LinearLayout paramLinearLayout, int paramInt1, int paramInt2, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(74064);
    TextView localTextView = (TextView)View.inflate(getContext(), 2131495173, null);
    localTextView.setText(paramInt1);
    localTextView.setTag(Integer.valueOf(paramInt2));
    paramLinearLayout.addView(localTextView);
    localTextView.setOnClickListener(paramOnClickListener);
    if (paramBoolean) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
    }
    AppMethodBeat.o(74064);
  }
  
  private void dQT()
  {
    int j = 0;
    AppMethodBeat.i(74059);
    IconPreference localIconPreference = (IconPreference)this.screen.aXe("settings_plugins");
    if (bu.a((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(-2046825377, null), false))
    {
      localIconPreference.acS(0);
      localIconPreference.gF(getString(2131755829), 2131233430);
      if (!com.tencent.mm.y.c.ahI().cJ(262158, 266266)) {
        break label132;
      }
      i = 0;
      label76:
      localIconPreference.acU(i);
      com.tencent.mm.plugin.newtips.a.dxG();
      if (!com.tencent.mm.plugin.newtips.a.e.Mr(com.tencent.mm.plugin.newtips.a.d.wHR)) {
        break label138;
      }
    }
    label132:
    label138:
    for (int i = j;; i = 8)
    {
      localIconPreference.acU(i);
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74059);
      return;
      localIconPreference.acS(8);
      localIconPreference.gF("", -1);
      break;
      i = 8;
      break label76;
    }
  }
  
  private boolean dQU()
  {
    AppMethodBeat.i(74060);
    Object localObject = new Intent(this, SettingsFontUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetTextSize", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(74060);
    return true;
  }
  
  private void dQV()
  {
    int j = 1;
    AppMethodBeat.i(74063);
    if (bu.aSB(com.tencent.mm.n.g.acL().getValue("SilentDownloadApkAtWiFi")) != 0) {}
    for (int i = 1;; i = 0)
    {
      if ((k.cSO & 0x1) != 0)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
        i = 1;
      }
      if (i == 0) {
        break;
      }
      this.screen.cT("settings_silence_update_mode", true);
      AppMethodBeat.o(74063);
      return;
    }
    this.screen.cT("settings_silence_update_mode", false);
    Preference localPreference;
    if ((((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = j;
      localPreference = this.screen.aXe("settings_silence_update_mode");
      if (i == 0) {
        break label166;
      }
    }
    label166:
    for (i = 2131763412;; i = 2131763411)
    {
      localPreference.setSummary(getString(i));
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74063);
      return;
      i = 0;
      break;
    }
  }
  
  private void dQW()
  {
    AppMethodBeat.i(74065);
    int i = bu.getInt(com.tencent.mm.n.g.acL().getValue("SIGHTAutoLoadNetwork"), 1);
    int j = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(327686, null), i);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (this.yVR == -1) {
      this.yVR = j;
    }
    this.yVS = j;
    if (3 == j) {
      i = 2131763425;
    }
    for (;;)
    {
      Preference localPreference = this.screen.aXe("settings_sns_sight_auto_download");
      if (localPreference != null) {
        localPreference.setSummary(getString(i));
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(74065);
      return;
      if (2 == j) {
        i = 2131763427;
      } else {
        i = 2131763424;
      }
    }
  }
  
  public static boolean dQX()
  {
    AppMethodBeat.i(190341);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPk, false);
    AppMethodBeat.o(190341);
    return bool;
  }
  
  private void po(boolean paramBoolean)
  {
    AppMethodBeat.i(74061);
    if (paramBoolean)
    {
      getPackageManager().setComponentEnabledSetting(new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMN, Integer.valueOf(1));
      AppMethodBeat.o(74061);
      return;
    }
    getPackageManager().setComponentEnabledSetting(new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IMN, Integer.valueOf(2));
    AppMethodBeat.o(74061);
  }
  
  private void qW(boolean paramBoolean)
  {
    AppMethodBeat.i(74062);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.screen.aXe("settings_nfc_switch");
    ak.getContext().getSharedPreferences(ak.fow(), 0).edit().putBoolean("settings_nfc_switch", paramBoolean).commit();
    localCheckBoxPreference.setChecked(paramBoolean);
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74062);
  }
  
  public int getResourceId()
  {
    return 2131951737;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74055);
    setMMTitle(2131763160);
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
    f localf = this.screen;
    boolean bool;
    if (!com.tencent.mm.compatible.util.d.lA(19))
    {
      bool = true;
      localf.cT("settings_swipeback_mode", bool);
      if (!com.tencent.mm.br.d.aJN("backup")) {
        this.screen.cT("settings_bak_chat", true);
      }
      dQT();
      this.screen.cT("settings_traffic_statistic", com.tencent.mm.br.d.fjx());
      if (!dQX()) {
        break label225;
      }
      if (this.screen.aXe("settings_take_photo") != null) {
        this.screen.aXe("settings_take_photo").setTitle(2131766805);
      }
    }
    for (;;)
    {
      if (ac.iSG) {
        this.screen.cT("settings_take_photo", true);
      }
      if ((com.tencent.mm.cc.c.flR()) || ((!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) && (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) && (!al.fBW())))
      {
        this.screen.cT("settings_dark", true);
        this.screen.cT("small_divider", true);
      }
      AppMethodBeat.o(74055);
      return;
      bool = false;
      break;
      label225:
      if (this.screen.aXe("settings_take_photo") != null) {
        this.screen.aXe("settings_take_photo").setTitle(2131763347);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74054);
    super.onCreate(paramBundle);
    this.yVQ = false;
    initView();
    AppMethodBeat.o(74054);
  }
  
  public void onDestroy()
  {
    boolean bool2 = true;
    AppMethodBeat.i(74057);
    super.onDestroy();
    int i;
    com.tencent.mm.plugin.report.service.g localg;
    if (this.yVT)
    {
      i = this.yVS;
      if (this.yVR != this.yVS) {
        break label127;
      }
      bool1 = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutSystemUI", "kvstat, autodownload sight change: %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      i = this.yVS;
      if (this.yVR != this.yVS) {
        break label132;
      }
    }
    label132:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localg.f(11437, new Object[] { Integer.valueOf(1), Integer.valueOf(i), Boolean.valueOf(bool1) });
      AppMethodBeat.o(74057);
      return;
      label127:
      bool1 = false;
      break;
    }
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    boolean bool2 = false;
    AppMethodBeat.i(74058);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_landscape_mode"))
    {
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
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYv == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        if (!getDefaultSharedPreferences().getBoolean("settings_voicerecorder_mode", bool1)) {
          h.a(getContext(), 2131763504, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(74051);
              SettingsAboutSystemUI.this.getDefaultSharedPreferences().edit().putBoolean("settings_voicerecorder_mode", true).commit();
              ((CheckBoxPreference)SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).aXe("settings_voicerecorder_mode")).setChecked(true);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this).notifyDataSetChanged();
              AppMethodBeat.o(74051);
            }
          });
        }
        AppMethodBeat.o(74058);
        return true;
      }
    }
    final int i;
    if (paramf.equals("settings_nfc_switch"))
    {
      paramf = NfcAdapter.getDefaultAdapter(this);
      if (paramf == null) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
      }
      for (;;)
      {
        AppMethodBeat.o(74058);
        return true;
        i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMN, Integer.valueOf(0))).intValue();
        int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMO, Integer.valueOf(0))).intValue();
        if (((i == 2) || ((i == 0) && (j != 1))) && (!paramf.isEnabled()) && (getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false)))
        {
          qW(false);
          h.e(getContext(), getString(2131761596), "", getString(2131761597), getString(2131755691), new SettingsAboutSystemUI.6(this), new SettingsAboutSystemUI.7(this));
        }
        else
        {
          po(getDefaultSharedPreferences().getBoolean("settings_nfc_switch", false));
        }
      }
    }
    if (paramf.equals("settings_voice_play_mode"))
    {
      boolean bool3 = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(26, Boolean.FALSE)).booleanValue();
      if (!bool3) {}
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutSystemUI", "set voice mode from %B to %B", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        paramf = com.tencent.mm.kernel.g.ajR().ajA();
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
      paramf = (CheckBoxPreference)this.screen.aXe("settings_enter_button_send");
      if (paramf != null)
      {
        bool1 = paramf.isChecked();
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", new Object[] { Boolean.valueOf(bool1) });
        com.tencent.mm.kernel.g.ajR().ajA().set(66832, Boolean.valueOf(bool1));
      }
      AppMethodBeat.o(74058);
      return true;
    }
    View localView;
    Object localObject;
    if (paramf.equals("settings_sns_sight_auto_download"))
    {
      paramPreference = new d.a(getContext());
      paramPreference.afV(2131755691);
      paramPreference.afN(2131763426);
      localView = View.inflate(getContext(), 2131494769, null);
      paramf = (LinearLayout)localView.findViewById(2131305591);
      i = bu.getInt(com.tencent.mm.n.g.acL().getValue("SIGHTAutoLoadNetwork"), 1);
      i = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(327686, null), i);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74041);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          final int i = 0;
          while (i < paramf.getChildCount())
          {
            localObject = (TextView)paramf.getChildAt(i);
            if (2131305896 != ((TextView)localObject).getId()) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
          i = ((Integer)paramAnonymousView.getTag()).intValue();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          if (i == i)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74041);
            return;
          }
          paramAnonymousView.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(74040);
              ((Dialog)SettingsAboutSystemUI.2.this.yVV.getTag()).dismiss();
              com.tencent.mm.kernel.g.ajR().ajA().set(327686, Integer.valueOf(i));
              com.tencent.mm.kernel.g.ajR().ajA().fuc();
              SettingsAboutSystemUI.f(SettingsAboutSystemUI.this);
              AppMethodBeat.o(74040);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74041);
        }
      };
      if (1 == i)
      {
        bool1 = true;
        a(paramf, 2131763424, 1, bool1, (View.OnClickListener)localObject);
        if (2 != i) {
          break label754;
        }
        bool1 = true;
        label675:
        a(paramf, 2131763427, 2, bool1, (View.OnClickListener)localObject);
        if (3 != i) {
          break label760;
        }
      }
      label754:
      label760:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, 2131763425, 3, bool1, (View.OnClickListener)localObject);
        paramPreference.hd(localView);
        paramPreference = paramPreference.fQv();
        paramf.setTag(paramPreference);
        paramPreference.show();
        addDialog(paramPreference);
        this.yVT = true;
        AppMethodBeat.o(74058);
        return true;
        bool1 = false;
        break;
        bool1 = false;
        break label675;
      }
    }
    if (paramf.equals("settings_silence_update_mode"))
    {
      paramPreference = new d.a(getContext());
      paramPreference.afV(2131755691);
      paramPreference.afN(2131763410);
      localView = View.inflate(getContext(), 2131494769, null);
      paramf = (LinearLayout)localView.findViewById(2131305591);
      localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int k = 0;
          AppMethodBeat.i(74053);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          int i = 0;
          while (i < paramf.getChildCount())
          {
            localObject = (TextView)paramf.getChildAt(i);
            if (2131305896 != ((TextView)localObject).getId()) {
              ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131691077, 0, 0, 0);
            }
            i += 1;
          }
          ((TextView)paramAnonymousView).setCompoundDrawablesWithIntrinsicBounds(2131691078, 0, 0, 0);
          int m = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(7, Integer.valueOf(0))).intValue();
          int n = ((Integer)paramAnonymousView.getTag()).intValue();
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(n) });
          if (n == 0)
          {
            i = 1;
            if ((m & 0x1000000) != 0) {
              break label204;
            }
          }
          label204:
          for (int j = 1;; j = 0)
          {
            if (i != j) {
              break label209;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74053);
            return;
            i = 0;
            break;
          }
          label209:
          i = k;
          if (n == 0) {
            i = 1;
          }
          if (i != 0)
          {
            j = 0xFEFFFFFF & m;
            if (i != 0) {
              break label349;
            }
          }
          label349:
          for (i = 1;; i = 2)
          {
            com.tencent.mm.kernel.g.ajR().ajA().set(7, Integer.valueOf(j));
            localObject = new auo();
            ((auo)localObject).GLx = 35;
            ((auo)localObject).xsz = i;
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(23, (com.tencent.mm.bw.a)localObject));
            com.tencent.mm.plugin.setting.c.iUA.MM();
            paramAnonymousView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(74052);
                ((Dialog)SettingsAboutSystemUI.10.this.yVV.getTag()).dismiss();
                SettingsAboutSystemUI.e(SettingsAboutSystemUI.this);
                AppMethodBeat.o(74052);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74053);
            return;
            j = m | 0x1000000;
            break;
          }
        }
      };
      if ((((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        bool1 = true;
        a(paramf, 2131763412, 0, bool1, (View.OnClickListener)localObject);
        if (bool1) {
          break label945;
        }
      }
      label945:
      for (bool1 = true;; bool1 = false)
      {
        a(paramf, 2131763411, 1, bool1, (View.OnClickListener)localObject);
        paramPreference.hd(localView);
        paramPreference = paramPreference.fQv();
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetLanguage", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = dQU();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_chatting_bg"))
    {
      paramPreference = new Intent();
      paramPreference.setClass(this, SettingsChattingBackgroundUI.class);
      paramf = getContext();
      paramPreference = new com.tencent.mm.hellhoundlib.b.a().bc(paramPreference);
      com.tencent.mm.hellhoundlib.a.a.a(paramf, paramPreference.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramf.startActivity((Intent)paramPreference.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramf, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetChattingBackground", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_manage_findmoreui"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsManageFindMoreUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToManageFindMoreUI", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_plugins"))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(-2046825377, Boolean.FALSE);
      paramf = new Intent();
      paramf.setClass(this, SettingsPluginsUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetPlugins", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.y.c.ahI().cK(262158, 266266);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_reset"))
    {
      h.e(getContext(), getResources().getString(2131763384), "", getString(2131755694), getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousInt = 0;
          AppMethodBeat.i(74048);
          SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, false);
          paramAnonymousDialogInterface = SettingsAboutSystemUI.this;
          Object localObject = SettingsAboutSystemUI.this;
          SettingsAboutSystemUI.this.getString(2131755906);
          SettingsAboutSystemUI.a(paramAnonymousDialogInterface, h.b((Context)localObject, SettingsAboutSystemUI.this.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(74045);
              SettingsAboutSystemUI.a(SettingsAboutSystemUI.this, true);
              AppMethodBeat.o(74045);
            }
          }));
          paramAnonymousDialogInterface = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().fuP();
          if (paramAnonymousDialogInterface.size() > 0)
          {
            localObject = q.ad(paramAnonymousDialogInterface);
            if (localObject != null) {
              while (paramAnonymousInt < ((List)localObject).size())
              {
                if (((Boolean)((List)localObject).get(paramAnonymousInt)).booleanValue()) {
                  com.tencent.mm.plugin.setting.c.iUA.fF((String)paramAnonymousDialogInterface.get(paramAnonymousInt));
                }
                paramAnonymousInt += 1;
              }
            }
          }
          bl.a(new bl.a()
          {
            public final boolean YT()
            {
              AppMethodBeat.i(74046);
              boolean bool = SettingsAboutSystemUI.b(SettingsAboutSystemUI.this);
              AppMethodBeat.o(74046);
              return bool;
            }
            
            public final void YU()
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
      com.tencent.mm.br.d.b(getContext(), "emoji", ".ui.EmojiMineUI", paramf);
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settngs_clean"))
    {
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        t.g(getContext(), null);
        AppMethodBeat.o(74058);
        return true;
      }
      com.tencent.mm.br.d.b(getContext(), "clean", ".ui.CleanUI", new Intent());
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_traffic_statistic"))
    {
      paramf = new Intent(this, SettingsNetStatUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goToSetTrafficStatistic", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74058);
      return true;
    }
    if (paramf.equals("settings_text_size"))
    {
      bool1 = dQU();
      AppMethodBeat.o(74058);
      return bool1;
    }
    if (paramf.equals("settings_swipeback_mode"))
    {
      paramf = (CheckBoxPreference)paramPreference;
      bool1 = com.tencent.mm.compatible.g.b.abm();
      if (!bool1) {}
      for (i = 2131763438;; i = 2131763437)
      {
        h.a(getContext(), getString(i), null, new SettingsAboutSystemUI.3(this), new DialogInterface.OnClickListener()
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
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(74058);
      return false;
      if (paramf.equalsIgnoreCase("settngs_matrix_trace"))
      {
        if (!com.tencent.matrix.b.HS())
        {
          Toast.makeText(this, "Matrix is never installed", 0).show();
          AppMethodBeat.o(74058);
          return false;
        }
        paramf = new Intent();
        paramf.setClassName(ak.getContext(), "com.tencent.mm.ui.matrix.MatrixSettingUI");
        paramf.addFlags(67108864);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramf.equals("settings_dark"))
      {
        ay.aRW(ak.fow()).putBoolean("dark_mode_red_dot", false);
        paramf = new Intent(this, SettingDarkMode.class);
        paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramf.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAboutSystemUI", "goTosetDarkMode", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74056);
    super.onResume();
    Object localObject1 = (CheckBoxPreference)this.screen.aXe("settings_voice_play_mode");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(26, Boolean.FALSE)).booleanValue());
      ((Preference)localObject1).JOq = false;
    }
    localObject1 = (CheckBoxPreference)this.screen.aXe("settings_enter_button_send");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(66832, Boolean.FALSE)).booleanValue());
      ((Preference)localObject1).JOq = false;
    }
    localObject1 = (CheckBoxPreference)this.screen.aXe("settings_swipeback_mode");
    if (localObject1 != null)
    {
      ((CheckBoxPreference)localObject1).setChecked(com.tencent.mm.compatible.g.b.abm());
      ((Preference)localObject1).JOq = false;
    }
    localObject1 = this.screen.aXe("settings_language");
    if (localObject1 != null) {
      ((Preference)localObject1).setSummary(ad.iS(getContext()));
    }
    dQT();
    dQW();
    dQW();
    dQV();
    localObject1 = NfcAdapter.getDefaultAdapter(this);
    Object localObject2 = (CheckBoxPreference)this.screen.aXe("settings_nfc_switch");
    if (localObject1 == null)
    {
      this.screen.cT("settings_nfc_switch", true);
      localObject2 = (IconPreference)this.screen.aXe("settings_dark");
      if (al.fBV())
      {
        if (!al.fCb()) {
          break label468;
        }
        localObject1 = getString(2131755800);
      }
    }
    for (;;)
    {
      ((IconPreference)localObject2).setSummary((CharSequence)localObject1);
      com.tencent.mm.cc.c.flS();
      ((IconPreference)localObject2).acU(8);
      this.screen.cT("settngs_matrix_trace", true);
      AppMethodBeat.o(74056);
      return;
      this.screen.cT("settings_nfc_switch", false);
      ((CheckBoxPreference)localObject2).setSummary(bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMR, null)));
      if (this.yVQ)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
        if (((NfcAdapter)localObject1).isEnabled())
        {
          po(true);
          qW(true);
          break;
        }
      }
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMN, Integer.valueOf(0))).intValue();
      if (i == 0) {
        if (((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IMO, Integer.valueOf(0))).intValue() == 1) {
          qW(true);
        }
      }
      for (;;)
      {
        this.screen.notifyDataSetChanged();
        break;
        qW(false);
        continue;
        if (i == 1) {
          qW(true);
        } else {
          qW(false);
        }
      }
      label468:
      if (al.isDarkMode()) {
        localObject1 = getString(2131763116);
      } else {
        localObject1 = getString(2131763100);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI
 * JD-Core Version:    0.7.0.1
 */