package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera
  extends MMPreference
{
  private f screen;
  private final String wfo = "settings_auto_mul_terminal_sync";
  private final String wfp = "settings_take_photo_auto_save_photo";
  private final String wfq = "settings_take_photo_auto_save_video";
  private final String wfr = "settings_sns_auto_play_switch";
  private final String wfs = "settings_sns_auto_play_tip";
  
  public int getResourceId()
  {
    return 2131951725;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74014);
    this.screen = getPreferenceScreen();
    setMMTitle(2131763347);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74011);
        SettingsAboutCamera.this.hideVKB();
        SettingsAboutCamera.this.finish();
        AppMethodBeat.o(74011);
        return true;
      }
    });
    boolean bool = ((Boolean)g.afB().afk().get(ae.a.Fnm, Boolean.TRUE)).booleanValue();
    Object localObject = (CheckBoxPreference)this.screen.aKk("settings_auto_mul_terminal_sync");
    ((Preference)localObject).GfV = false;
    ((CheckBoxPreference)localObject).lG = bool;
    bool = ((Boolean)g.afB().afk().get(ae.a.Fno, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.aKk("settings_take_photo_auto_save_photo");
    ((Preference)localObject).GfV = false;
    ((CheckBoxPreference)localObject).lG = bool;
    bool = ((Boolean)g.afB().afk().get(ae.a.Fnp, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.aKk("settings_take_photo_auto_save_video");
    ((CheckBoxPreference)localObject).lG = bool;
    ((Preference)localObject).GfV = false;
    bool = ((Boolean)g.afB().afk().get(ae.a.Fnq, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.aKk("settings_sns_auto_play_switch");
    ((CheckBoxPreference)localObject).lG = bool;
    ((Preference)localObject).GfV = false;
    this.screen.notifyDataSetChanged();
    if (((b)g.ab(b.class)).a(b.a.pjO, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((b)g.ab(b.class)).a(b.a.pjP, "");
      int j = i;
      if (!bt.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          ad.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.cE("settings_sns_auto_play_switch", true);
        this.screen.cE("settings_sns_auto_play_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    ci localci = new ci();
    localci.dQW = 2;
    if (((Boolean)g.afB().afk().get(ae.a.Fnm, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localci.dQX = i;
      if (!((Boolean)g.afB().afk().get(ae.a.Fno, Boolean.TRUE)).booleanValue()) {
        break label164;
      }
      i = 1;
      label81:
      localci.dQY = i;
      if (!((Boolean)g.afB().afk().get(ae.a.Fnp, Boolean.TRUE)).booleanValue()) {
        break label169;
      }
      i = 1;
      label112:
      localci.dQZ = i;
      if (!((Boolean)g.afB().afk().get(ae.a.Fnq, Boolean.TRUE)).booleanValue()) {
        break label174;
      }
    }
    label164:
    label169:
    label174:
    for (int i = j;; i = 2)
    {
      localci.dRa = i;
      localci.aBj();
      AppMethodBeat.o(74015);
      return;
      i = 2;
      break;
      i = 2;
      break label81;
      i = 2;
      break label112;
    }
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int j = 1;
    int k = 1;
    int m = 1;
    int i = 1;
    AppMethodBeat.i(74013);
    paramf = paramPreference.mKey;
    boolean bool;
    ae.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)g.afB().afk().get(ae.a.Fnm, Boolean.TRUE)).booleanValue();
      paramPreference = g.afB().afk();
      locala = ae.a.Fnm;
      if (!bool)
      {
        bool = true;
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)g.afB().afk().get(ae.a.Fno, Boolean.TRUE)).booleanValue();
        paramPreference = g.afB().afk();
        locala = ae.a.Fno;
        if (bool) {
          break label342;
        }
        bool = true;
        label136:
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)g.afB().afk().get(ae.a.Fnp, Boolean.TRUE)).booleanValue();
        paramPreference = g.afB().afk();
        locala = ae.a.Fnp;
        if (bool) {
          break label348;
        }
        bool = true;
        label199:
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)g.afB().afk().get(ae.a.Fnq, Boolean.TRUE)).booleanValue();
        paramPreference = g.afB().afk();
        locala = ae.a.Fnq;
        if (bool) {
          break label354;
        }
        bool = true;
        label262:
        paramPreference.set(locala, Boolean.valueOf(bool));
      }
      paramPreference = new ci();
      paramPreference.dQW = 3;
      if (!bt.kU(paramf, "settings_auto_mul_terminal_sync")) {
        break label365;
      }
      if (!((Boolean)g.afB().afk().get(ae.a.Fnm, Boolean.TRUE)).booleanValue()) {
        break label360;
      }
      label319:
      paramPreference.dQX = i;
    }
    label342:
    label348:
    label354:
    label360:
    label365:
    do
    {
      paramPreference.aBj();
      AppMethodBeat.o(74013);
      return false;
      bool = false;
      break;
      bool = false;
      break label136;
      bool = false;
      break label199;
      bool = false;
      break label262;
      i = 2;
      break label319;
      if (bt.kU(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)g.afB().afk().get(ae.a.Fno, Boolean.TRUE)).booleanValue()) {}
        for (i = j;; i = 2)
        {
          paramPreference.dQY = i;
          break;
        }
      }
      if (bt.kU(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)g.afB().afk().get(ae.a.Fnp, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.dQZ = i;
          break;
        }
      }
    } while (!bt.kU(paramf, "settings_sns_auto_play_switch"));
    if (((Boolean)g.afB().afk().get(ae.a.Fnq, Boolean.TRUE)).booleanValue()) {}
    for (i = m;; i = 2)
    {
      paramPreference.dRa = i;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */