package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsVoicePrintUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private VoiceHeaderPreference NIb;
  private ProgressDialog iXX = null;
  private View oFW;
  private f screen;
  private boolean wAk = false;
  
  private void gxc()
  {
    AppMethodBeat.i(29837);
    com.tencent.mm.plugin.report.service.h.IzE.a(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.wAk = false;
    AppMethodBeat.o(29837);
  }
  
  public int getResourceId()
  {
    return R.o.eXP;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29834);
    bh.beI();
    int i = Util.nullAsInt(c.aHp().b(40, Integer.valueOf(0)), 0);
    Log.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.screen = getPreferenceScreen();
    this.NIb = ((VoiceHeaderPreference)this.screen.byG("settings_voiceprint_header"));
    ((CheckBoxPreference)this.screen.byG("settings_voiceprint_title")).BT(true);
    this.screen.notifyDataSetChanged();
    if ((this.iXX != null) && (this.iXX.isShowing())) {
      this.iXX.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    bh.aGY().a(new com.tencent.mm.plugin.voiceprint.model.i(0), 0);
    this.screen.dz("settings_voiceprint_unlock", true);
    this.screen.dz("settings_voiceprint_reset", true);
    this.screen.dz("settings_voiceprint_create", true);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29827);
        SettingsVoicePrintUI.this.finish();
        AppMethodBeat.o(29827);
        return true;
      }
    });
    AppMethodBeat.o(29834);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(29838);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramIntent != null)) {
      this.wAk = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
    AppMethodBeat.o(29838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29831);
    super.onCreate(paramBundle);
    setMMTitle(R.l.settings_voiceprint);
    bh.aGY().a(615, this);
    this.oFW = findViewById(R.h.mm_preference_list_content);
    initView();
    this.oFW.setBackgroundResource(R.e.white);
    bh.beI();
    c.aHp().set(ar.a.Vhp, Boolean.FALSE);
    bh.beI();
    c.aHp().set(ar.a.Vhq, Boolean.FALSE);
    bh.beI();
    c.aHp().set(ar.a.Vhr, Boolean.FALSE);
    bh.beI();
    c.aHp().set(ar.a.Vhs, Boolean.FALSE);
    Log.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    AppMethodBeat.o(29831);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29833);
    super.onDestroy();
    bh.aGY().b(615, this);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    AppMethodBeat.o(29833);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29835);
    paramPreference = paramPreference.mKey;
    Intent localIntent = new Intent();
    if (paramPreference.equals("settings_voiceprint_title"))
    {
      paramf = (CheckBoxPreference)paramf.byG("settings_voiceprint_title");
      Log.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.iXX != null) && (this.iXX.isShowing())) {
        this.iXX.dismiss();
      }
      paramPreference = getContext();
      getString(R.l.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(paramPreference, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        bh.aGY().a(new com.tencent.mm.plugin.voiceprint.model.i(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(29835);
        return true;
        bh.aGY().a(new com.tencent.mm.plugin.voiceprint.model.i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(29835);
      return true;
    }
    if (paramPreference.equals("settings_voiceprint_reset"))
    {
      localIntent.setClass(this, VoiceCreateUI.class);
      localIntent.putExtra("KvoicePrintReset", true);
      localIntent.putExtra("kscene_type", 73);
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(29835);
      return true;
    }
    AppMethodBeat.o(29835);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29839);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(29839);
      return;
    }
    Log.i("MicroMsg.VoiceSettingsUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29839);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        gxc();
        AppMethodBeat.o(29839);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29829);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = SettingsVoicePrintUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousDialogInterface, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(29829);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29830);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(29830);
        }
      });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29832);
    super.onResume();
    if (this.wAk)
    {
      this.wAk = false;
      if ((this.iXX != null) && (this.iXX.isShowing())) {
        this.iXX.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(R.l.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      Log.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      bh.aGY().a(new com.tencent.mm.plugin.voiceprint.model.i(1), 0);
    }
    AppMethodBeat.o(29832);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29836);
    Log.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.dz("settings_voiceprint_unlock", true);
      this.screen.dz("settings_voiceprint_reset", true);
      this.screen.dz("settings_voiceprint_create", true);
      ((CheckBoxPreference)this.screen.byG("settings_voiceprint_title")).BT(false);
      this.NIb.gR(getString(R.l.eVp), "");
      this.screen.notifyDataSetChanged();
      if (this.iXX != null) {
        this.iXX.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
    }
    if (paramq.getType() == 615)
    {
      paramString = (com.tencent.mm.plugin.voiceprint.model.i)paramq;
      if (paramString.mStatus != 1) {
        break label499;
      }
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
      this.screen.dz("settings_voiceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = z.bdf();
      paramq = (CheckBoxPreference)this.screen.byG("settings_voiceprint_title");
      Log.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.NHk) });
      if (paramString.NHk <= 0) {
        break label433;
      }
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
      paramq.BT(true);
      this.screen.dz("settings_voiceprint_reset", false);
      this.screen.dz("settings_voiceprint_unlock", false);
      paramInt1 = 0x20000 | paramInt1;
      this.NIb.gR(getString(R.l.eVq), "");
      Log.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bg.ltv.aS("last_login_use_voice", String.valueOf(paramInt1));
      bh.beI();
      c.aHp().i(40, Integer.valueOf(paramInt1));
      this.screen.dz("settings_voiceprint_create", true);
      this.screen.dz("settings_voiceprint_title", false);
      this.NIb.c(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.iXX != null) {
        this.iXX.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
      label433:
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
      paramq.BT(false);
      this.screen.dz("settings_voiceprint_reset", true);
      this.screen.dz("settings_voiceprint_unlock", true);
      paramInt1 = 0xFFFDFFFF & paramInt1;
      this.NIb.gR(getString(R.l.eVp), "");
      break;
      label499:
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
      com.tencent.mm.plugin.report.service.h.IzE.a(11390, new Object[] { Integer.valueOf(2) });
      this.screen.dz("settings_voiceprint_unlock", true);
      this.screen.dz("settings_voiceprint_reset", true);
      this.screen.dz("settings_voiceprint_create", true);
      this.screen.dz("settings_voiceprint_title", true);
      this.NIb.gR(getString(R.l.eVs), getString(R.l.eVr));
      this.NIb.c(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29828);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, "", "");
          Log.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), SettingsVoicePrintUI.this });
          if (!bool)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(29828);
            return;
          }
          SettingsVoicePrintUI.a(SettingsVoicePrintUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29828);
        }
      });
      this.screen.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */