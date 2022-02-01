package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ne;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsAboutCamera
  extends MMPreference
{
  private final String Pqn = "settings_auto_mul_terminal_sync_tip";
  private final String Pqo = "settings_auto_mul_terminal_sync";
  private final String Pqp = "settings_take_photo_auto_save_tip";
  private final String Pqq = "settings_take_photo_auto_save_photo";
  private final String Pqr = "settings_take_photo_auto_save_video";
  private final String Pqs = "settings_sns_auto_play_switch";
  private final String Pqt = "settings_sns_auto_play_tip";
  private final String Pqu = "settings_voip_audio_switch_mobile_net";
  private final String Pqv = "settings_voip_audio_switch_mobile_net_tip";
  private int Pqw = 0;
  private com.tencent.mm.ui.base.preference.f screen;
  private long xct;
  
  public int getResourceId()
  {
    return b.k.settings_pref_camera;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74014);
    this.screen = getPreferenceScreen();
    Object localObject;
    if (!SettingsAboutSystemUI.gVw())
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
      bool = ((Boolean)h.baE().ban().get(at.a.acPp, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bAi("settings_auto_mul_terminal_sync");
      ((Preference)localObject).adZV = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)h.baE().ban().get(at.a.acPr, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bAi("settings_take_photo_auto_save_photo");
      ((Preference)localObject).adZV = false;
      ((CheckBoxPreference)localObject).setChecked(bool);
      bool = ((Boolean)h.baE().ban().get(at.a.acPs, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bAi("settings_take_photo_auto_save_video");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).adZV = false;
      bool = ((Boolean)h.baE().ban().get(at.a.acPt, Boolean.TRUE)).booleanValue();
      localObject = (CheckBoxPreference)this.screen.bAi("settings_sns_auto_play_switch");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).adZV = false;
      if (SettingsAboutSystemUI.gVw())
      {
        if ((this.xct & 0x0) == 0L) {
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
      localObject = (CheckBoxPreference)this.screen.bAi("settings_voip_audio_switch_mobile_net");
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((Preference)localObject).adZV = false;
      this.screen.notifyDataSetChanged();
      if (this.Pqw != 1) {
        break label427;
      }
      this.screen.eh("settings_sns_auto_play_switch", true);
      this.screen.eh("settings_sns_auto_play_tip", true);
      this.screen.eh("settings_take_photo_auto_save_photo", true);
      this.screen.eh("settings_take_photo_auto_save_video", true);
      this.screen.eh("settings_auto_mul_terminal_sync", true);
      this.screen.eh("settings_auto_mul_terminal_sync_tip", true);
      this.screen.eh("settings_take_photo_auto_save_tip", true);
      AppMethodBeat.o(74014);
      return;
      setMMTitle(b.i.settings_photo_video_new);
      break;
      i = 0;
      break label259;
    }
    label427:
    if (((c)h.ax(c.class)).a(c.a.yIY, 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      localObject = q.aPo().toLowerCase();
      String str = ((c)h.ax(c.class)).a(c.a.yIZ, "");
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
        this.screen.eh("settings_sns_auto_play_switch", true);
        this.screen.eh("settings_sns_auto_play_tip", true);
      }
      if (!SettingsAboutSystemUI.gVw())
      {
        this.screen.eh("settings_voip_audio_switch_mobile_net", true);
        this.screen.eh("settings_voip_audio_switch_mobile_net_tip", true);
      }
      AppMethodBeat.o(74014);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74012);
    super.onCreate(paramBundle);
    this.xct = z.bAR();
    this.Pqw = getIntent().getIntExtra("activity_caller_params", 0);
    initView();
    AppMethodBeat.o(74012);
  }
  
  public void onDestroy()
  {
    int j = 1;
    AppMethodBeat.i(74015);
    super.onDestroy();
    ne localne = new ne();
    localne.jdF = 2;
    if (((Boolean)h.baE().ban().get(at.a.acPp, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      localne.jdG = i;
      if (!((Boolean)h.baE().ban().get(at.a.acPr, Boolean.TRUE)).booleanValue()) {
        break label166;
      }
      i = 1;
      label82:
      localne.jdH = i;
      if (!((Boolean)h.baE().ban().get(at.a.acPs, Boolean.TRUE)).booleanValue()) {
        break label171;
      }
      i = 1;
      label113:
      localne.jdI = i;
      if (!((Boolean)h.baE().ban().get(at.a.acPt, Boolean.TRUE)).booleanValue()) {
        break label176;
      }
    }
    label166:
    label171:
    label176:
    for (int i = j;; i = 2)
    {
      localne.jdJ = i;
      localne.bMH();
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
    aq localaq;
    at.a locala;
    if (paramf.equals("settings_auto_mul_terminal_sync"))
    {
      bool = ((Boolean)h.baE().ban().get(at.a.acPp, Boolean.TRUE)).booleanValue();
      localaq = h.baE().ban();
      locala = at.a.acPp;
      if (!bool)
      {
        bool = true;
        localaq.set(locala, Boolean.valueOf(bool));
      }
    }
    else
    {
      if (paramf.equals("settings_take_photo_auto_save_photo"))
      {
        bool = ((Boolean)h.baE().ban().get(at.a.acPr, Boolean.TRUE)).booleanValue();
        localaq = h.baE().ban();
        locala = at.a.acPr;
        if (bool) {
          break label494;
        }
        bool = true;
        label141:
        localaq.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_take_photo_auto_save_video"))
      {
        bool = ((Boolean)h.baE().ban().get(at.a.acPs, Boolean.TRUE)).booleanValue();
        localaq = h.baE().ban();
        locala = at.a.acPs;
        if (bool) {
          break label500;
        }
        bool = true;
        label206:
        localaq.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_sns_auto_play_switch"))
      {
        bool = ((Boolean)h.baE().ban().get(at.a.acPt, Boolean.TRUE)).booleanValue();
        localaq = h.baE().ban();
        locala = at.a.acPt;
        if (bool) {
          break label506;
        }
        bool = true;
        label271:
        localaq.set(locala, Boolean.valueOf(bool));
      }
      if (paramf.equals("settings_voip_audio_switch_mobile_net"))
      {
        bool = ((CheckBoxPreference)paramPreference).isChecked();
        Log.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + bool + " item value = 137438953472 functionId = 58");
        if (!bool) {
          break label512;
        }
        this.xct &= 0xFFFFFFFF;
        label347:
        if (!bool) {
          break label527;
        }
        i = 1;
        label354:
        paramPreference = new cas();
        paramPreference.aajJ = 58;
        paramPreference.NkL = i;
        ((n)h.ax(n.class)).bzz().d(new k.a(23, paramPreference));
        h.baE().ban().B(147457, Long.valueOf(this.xct));
      }
      paramPreference = new ne();
      paramPreference.jdF = 3;
      if (!Util.isEqual(paramf, "settings_auto_mul_terminal_sync")) {
        break label537;
      }
      if (!((Boolean)h.baE().ban().get(at.a.acPp, Boolean.TRUE)).booleanValue()) {
        break label532;
      }
      i = j;
      label470:
      paramPreference.jdG = i;
    }
    label494:
    label500:
    label506:
    do
    {
      paramPreference.bMH();
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
      this.xct |= 0x0;
      break label347;
      i = 2;
      break label354;
      i = 2;
      break label470;
      if (Util.isEqual(paramf, "settings_take_photo_auto_save_photo"))
      {
        if (((Boolean)h.baE().ban().get(at.a.acPr, Boolean.TRUE)).booleanValue()) {}
        for (i = k;; i = 2)
        {
          paramPreference.jdH = i;
          break;
        }
      }
      if (Util.isEqual(paramf, "settings_take_photo_auto_save_video"))
      {
        if (((Boolean)h.baE().ban().get(at.a.acPs, Boolean.TRUE)).booleanValue()) {}
        for (i = m;; i = 2)
        {
          paramPreference.jdI = i;
          break;
        }
      }
    } while (!Util.isEqual(paramf, "settings_sns_auto_play_switch"));
    label512:
    label527:
    label532:
    label537:
    if (((Boolean)h.baE().ban().get(at.a.acPt, Boolean.TRUE)).booleanValue()) {}
    for (int i = n;; i = 2)
    {
      paramPreference.jdJ = i;
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(298962);
    super.onResume();
    if (this.Pqw == 1)
    {
      ((b)h.ax(b.class)).mq(true);
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(298962);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera
 * JD-Core Version:    0.7.0.1
 */