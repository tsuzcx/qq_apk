package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutCamera
  extends MMPreference
{
  private final String JfA = "settings_auto_mul_terminal_sync_tip";
  private final String JfB = "settings_auto_mul_terminal_sync";
  private final String JfC = "settings_take_photo_auto_save_tip";
  private final String JfD = "settings_take_photo_auto_save_photo";
  private final String JfE = "settings_take_photo_auto_save_video";
  private final String JfF = "settings_sns_auto_play_switch";
  private final String JfG = "settings_sns_auto_play_tip";
  private final String JfH = "settings_voip_audio_switch_mobile_net";
  private final String JfI = "settings_voip_audio_switch_mobile_net_tip";
  private int JfJ = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  private long tZb;
  
  public int getResourceId()
  {
    return b.k.settings_pref_camera;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74014);
    this.screen = getPreferenceScreen();
    Object localObject;
    if (!SettingsAboutSystemUI.fGc())
    {
      setMMTitle(b.i.settings_photo_video);
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
      bool = ((Boolean)h.aHG().aHp().get(ar.a.VnU, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.byG("settings_auto_mul_terminal_sync");
      ((Preference)localObject).WsF = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)h.aHG().aHp().get(ar.a.VnW, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.byG("settings_take_photo_auto_save_photo");
      ((Preference)localObject).WsF = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)h.aHG().aHp().get(ar.a.VnX, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.byG("settings_take_photo_auto_save_video");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).WsF = false;
      bool = ((Boolean)h.aHG().aHp().get(ar.a.VnY, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.byG("settings_sns_auto_play_switch");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).WsF = false;
      if (SettingsAboutSystemUI.fGc())
      {
        if ((this.tZb & 0x0) == 0L) {
          break label417;
        }
        i = 1;
        label259:
        if (i != 0) {
          break label422;
        }
      }
    }
    label417:
    label422:
    for (boolean bool = true;; bool = false)
    {
      localObject = (CheckBoxPreference)this.screen.byG("settings_voip_audio_switch_mobile_net");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).WsF = false;
      this.screen.notifyDataSetChanged();
      if (this.JfJ != 1) {
        break label427;
      }
      this.screen.dz("settings_sns_auto_play_switch", true);
      this.screen.dz("settings_sns_auto_play_tip", true);
      this.screen.dz("settings_take_photo_auto_save_photo", true);
      this.screen.dz("settings_take_photo_auto_save_video", true);
      this.screen.dz("settings_auto_mul_terminal_sync", true);
      this.screen.dz("settings_auto_mul_terminal_sync_tip", true);
      this.screen.dz("settings_take_photo_auto_save_tip", true);
      AppMethodBeat.o(74014);
      return;
      setMMTitle(b.i.settings_photo_video_new);
      break;
      i = 0;
      break label259;
    }
    label427:
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvX, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = Build.MODEL.toLowerCase();
      String str = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvY, "");
      int j = i;
      if (!Util.isNullOrNil(str))
      {
        j = i;
        if (str.contains((CharSequence)localObject))
        {
          Log.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", new Object[] { localObject, str });
          j = 0;
        }
      }
      if (j == 0)
      {
        this.screen.dz("settings_sns_auto_play_switch", true);
        this.screen.dz("settings_sns_auto_play_tip", true);
      }
      if (!SettingsAboutSystemUI.fGc())
      {
        this.screen.dz("settings_voip_audio_switch_mobile_net", true);
        this.screen.dz("settings_voip_audio_switch_mobile_net_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    this.tZb = z.bde();
    this.JfJ = getIntent().getIntExtra("activity_caller_params", 0);
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    kl localkl = new kl();
    localkl.gNx = 2;
    if (((Boolean)h.aHG().aHp().get(ar.a.VnU, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localkl.gNy = i;
      if (!((Boolean)h.aHG().aHp().get(ar.a.VnW, Boolean.TRUE)).booleanValue()) {
        break label166;
      }
      i = 1;
      label82:
      localkl.gNz = i;
      if (!((Boolean)h.aHG().aHp().get(ar.a.VnX, Boolean.TRUE)).booleanValue()) {
        break label171;
      }
      i = 1;
      label113:
      localkl.gNA = i;
      if (!((Boolean)h.aHG().aHp().get(ar.a.VnY, Boolean.TRUE)).booleanValue()) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int i = j;; i = 2)
    {
      localkl.gNB = i;
      localkl.bpa();
      AppMethodBeat.o(74015);
      return;
      i = 2;
      break;
      i = 2;
      break label82;
      i = 2;
      break label113;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    int k = 1;
    int m = 1;
    int n = 1;
    int j = 1;
    AppMethodBeat.i(74013);
    paramf = paramPreference.mKey;
    boolean bool;
    ao localao;
    ar.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)h.aHG().aHp().get(ar.a.VnU, Boolean.TRUE)).booleanValue();
      localao = h.aHG().aHp();
      locala = ar.a.VnU;
      if (!bool)
      {
        bool = true;
        localao.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)h.aHG().aHp().get(ar.a.VnW, Boolean.TRUE)).booleanValue();
        localao = h.aHG().aHp();
        locala = ar.a.VnW;
        if (bool) {
          break label494;
        }
        bool = true;
        label141:
        localao.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)h.aHG().aHp().get(ar.a.VnX, Boolean.TRUE)).booleanValue();
        localao = h.aHG().aHp();
        locala = ar.a.VnX;
        if (bool) {
          break label500;
        }
        bool = true;
        label206:
        localao.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)h.aHG().aHp().get(ar.a.VnY, Boolean.TRUE)).booleanValue();
        localao = h.aHG().aHp();
        locala = ar.a.VnY;
        if (bool) {
          break label506;
        }
        bool = true;
        label271:
        localao.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_voip_audio_switch_mobile_net"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + bool + " item value = 137438953472 functionId = 58");
        if (!bool) {
          break label512;
        }
        this.tZb &= 0xFFFFFFFF;
        label347:
        if (!bool) {
          break label527;
        }
        i = 1;
        label354:
        paramPreference = new bmy();
        paramPreference.SXP = 58;
        paramPreference.HmX = i;
        ((n)h.ae(n.class)).bbK().d(new k.a(23, paramPreference));
        h.aHG().aHp().i(147457, Long.valueOf(this.tZb));
      }
      paramPreference = new kl();
      paramPreference.gNx = 3;
      if (!Util.isEqual(paramf, "settings_auto_mul_terminal_sync")) {
        break label537;
      }
      if (!((Boolean)h.aHG().aHp().get(ar.a.VnU, Boolean.TRUE)).booleanValue()) {
        break label532;
      }
      i = j;
      label470:
      paramPreference.gNy = i;
    }
    label494:
    label500:
    label506:
    do
    {
      paramPreference.bpa();
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
      this.tZb |= 0x0;
      break label347;
      i = 2;
      break label354;
      i = 2;
      break label470;
      if (Util.isEqual(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)h.aHG().aHp().get(ar.a.VnW, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.gNz = i;
          break;
        }
      }
      if (Util.isEqual(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)h.aHG().aHp().get(ar.a.VnX, Boolean.TRUE)).booleanValue()) {}
        for (i = m;; i = 2)
        {
          paramPreference.gNA = i;
          break;
        }
      }
    } while (!Util.isEqual(paramf, "settings_sns_auto_play_switch"));
    label512:
    label527:
    label532:
    label537:
    if (((Boolean)h.aHG().aHp().get(ar.a.VnY, Boolean.TRUE)).booleanValue()) {}
    for (int i = n;; i = 2)
    {
      paramPreference.gNB = i;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(263526);
    super.onResume();
    if (this.JfJ == 1)
    {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(true);
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(263526);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */