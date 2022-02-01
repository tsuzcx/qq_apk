package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera
  extends MMPreference
{
  private long oAP;
  private f screen;
  private final String xqC = "settings_auto_mul_terminal_sync";
  private final String xqD = "settings_take_photo_auto_save_photo";
  private final String xqE = "settings_take_photo_auto_save_video";
  private final String xqF = "settings_sns_auto_play_switch";
  private final String xqG = "settings_sns_auto_play_tip";
  private final String xqH = "settings_voip_audio_switch_mobile_net";
  private final String xqI = "settings_voip_audio_switch_mobile_net_tip";
  
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
    boolean bool = ((Boolean)g.agR().agA().get(ah.a.GLb, Boolean.TRUE)).booleanValue();
    Object localObject = (CheckBoxPreference)this.screen.aPN("settings_auto_mul_terminal_sync");
    ((Preference)localObject).HFK = false;
    ((CheckBoxPreference)localObject).mF = bool;
    bool = ((Boolean)g.agR().agA().get(ah.a.GLd, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.aPN("settings_take_photo_auto_save_photo");
    ((Preference)localObject).HFK = false;
    ((CheckBoxPreference)localObject).mF = bool;
    bool = ((Boolean)g.agR().agA().get(ah.a.GLe, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.aPN("settings_take_photo_auto_save_video");
    ((CheckBoxPreference)localObject).mF = bool;
    ((Preference)localObject).HFK = false;
    bool = ((Boolean)g.agR().agA().get(ah.a.GLf, Boolean.TRUE)).booleanValue();
    localObject = (CheckBoxPreference)this.screen.aPN("settings_sns_auto_play_switch");
    ((CheckBoxPreference)localObject).mF = bool;
    ((Preference)localObject).HFK = false;
    if (SettingsAboutSystemUI.dBX())
    {
      if ((this.oAP & 0x0) != 0L)
      {
        i = 1;
        if (i != 0) {
          break label464;
        }
        bool = true;
        label258:
        localObject = (CheckBoxPreference)this.screen.aPN("settings_voip_audio_switch_mobile_net");
        ((CheckBoxPreference)localObject).mF = bool;
        ((Preference)localObject).HFK = false;
      }
    }
    else
    {
      this.screen.notifyDataSetChanged();
      if (((b)g.ab(b.class)).a(b.a.pNf, 0) != 1) {
        break label469;
      }
    }
    label464:
    label469:
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((b)g.ab(b.class)).a(b.a.pNg, "");
      int j = i;
      if (!bs.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          ac.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.cK("settings_sns_auto_play_switch", true);
        this.screen.cK("settings_sns_auto_play_tip", true);
      }
      if (!SettingsAboutSystemUI.dBX())
      {
        this.screen.cK("settings_voip_audio_switch_mobile_net", true);
        this.screen.cK("settings_voip_audio_switch_mobile_net_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
      i = 0;
      break;
      bool = false;
      break label258;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    this.oAP = u.axB();
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    dw localdw = new dw();
    localdw.dSL = 2;
    if (((Boolean)g.agR().agA().get(ah.a.GLb, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localdw.dSM = i;
      if (!((Boolean)g.agR().agA().get(ah.a.GLd, Boolean.TRUE)).booleanValue()) {
        break label164;
      }
      i = 1;
      label81:
      localdw.dSN = i;
      if (!((Boolean)g.agR().agA().get(ah.a.GLe, Boolean.TRUE)).booleanValue()) {
        break label169;
      }
      i = 1;
      label112:
      localdw.dSO = i;
      if (!((Boolean)g.agR().agA().get(ah.a.GLf, Boolean.TRUE)).booleanValue()) {
        break label174;
      }
    }
    label164:
    label169:
    label174:
    for (int i = j;; i = 2)
    {
      localdw.dSP = i;
      localdw.aHZ();
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
    int k = 1;
    int m = 1;
    int n = 1;
    int j = 1;
    AppMethodBeat.i(74013);
    paramf = paramPreference.mKey;
    boolean bool;
    ae localae;
    ah.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)g.agR().agA().get(ah.a.GLb, Boolean.TRUE)).booleanValue();
      localae = g.agR().agA();
      locala = ah.a.GLb;
      if (!bool)
      {
        bool = true;
        localae.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)g.agR().agA().get(ah.a.GLd, Boolean.TRUE)).booleanValue();
        localae = g.agR().agA();
        locala = ah.a.GLd;
        if (bool) {
          break label494;
        }
        bool = true;
        label141:
        localae.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)g.agR().agA().get(ah.a.GLe, Boolean.TRUE)).booleanValue();
        localae = g.agR().agA();
        locala = ah.a.GLe;
        if (bool) {
          break label500;
        }
        bool = true;
        label206:
        localae.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)g.agR().agA().get(ah.a.GLf, Boolean.TRUE)).booleanValue();
        localae = g.agR().agA();
        locala = ah.a.GLf;
        if (bool) {
          break label506;
        }
        bool = true;
        label271:
        localae.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_voip_audio_switch_mobile_net"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        ac.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + bool + " item value = 137438953472 functionId = 58");
        if (!bool) {
          break label512;
        }
        this.oAP &= 0xFFFFFFFF;
        label347:
        if (!bool) {
          break label527;
        }
        i = 1;
        label354:
        paramPreference = new aqc();
        paramPreference.EIY = 58;
        paramPreference.vVH = i;
        ((k)g.ab(k.class)).awA().c(new j.a(23, paramPreference));
        g.agR().agA().set(147457, Long.valueOf(this.oAP));
      }
      paramPreference = new dw();
      paramPreference.dSL = 3;
      if (!bs.lr(paramf, "settings_auto_mul_terminal_sync")) {
        break label537;
      }
      if (!((Boolean)g.agR().agA().get(ah.a.GLb, Boolean.TRUE)).booleanValue()) {
        break label532;
      }
      i = j;
      label470:
      paramPreference.dSM = i;
    }
    label494:
    label500:
    label506:
    do
    {
      paramPreference.aHZ();
      AppMethodBeat.o(74013);
      return false;
      bool = false;
      break;
      bool = false;
      break label141;
      bool = false;
      break label206;
      bool = false;
      break label271;
      this.oAP |= 0x0;
      break label347;
      i = 2;
      break label354;
      i = 2;
      break label470;
      if (bs.lr(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)g.agR().agA().get(ah.a.GLd, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.dSN = i;
          break;
        }
      }
      if (bs.lr(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)g.agR().agA().get(ah.a.GLe, Boolean.TRUE)).booleanValue()) {}
        for (i = m;; i = 2)
        {
          paramPreference.dSO = i;
          break;
        }
      }
    } while (!bs.lr(paramf, "settings_sns_auto_play_switch"));
    label512:
    label527:
    label532:
    label537:
    if (((Boolean)g.agR().agA().get(ah.a.GLf, Boolean.TRUE)).booleanValue()) {}
    for (int i = n;; i = 2)
    {
      paramPreference.dSP = i;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */