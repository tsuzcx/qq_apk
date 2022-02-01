package com.tencent.mm.plugin.voiceprint.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voiceprint.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsVoicePrintUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private VoiceHeaderPreference Uuc;
  private ProgressDialog lzP = null;
  private View rootView;
  private f screen;
  private boolean zWv = false;
  
  private void hUZ()
  {
    AppMethodBeat.i(29837);
    com.tencent.mm.plugin.report.service.h.OAn.b(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.zWv = false;
    AppMethodBeat.o(29837);
  }
  
  public int getResourceId()
  {
    return R.o.hbq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29834);
    bh.bCz();
    int i = Util.nullAsInt(c.ban().d(40, Integer.valueOf(0)), 0);
    Log.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.screen = getPreferenceScreen();
    this.Uuc = ((VoiceHeaderPreference)this.screen.bAi("settings_voiceprint_header"));
    ((CheckBoxPreference)this.screen.bAi("settings_voiceprint_title")).Hy(true);
    this.screen.notifyDataSetChanged();
    if ((this.lzP != null) && (this.lzP.isShowing())) {
      this.lzP.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(R.l.app_tip);
    this.lzP = k.a(localAppCompatActivity, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    bh.aZW().a(new i(0), 0);
    this.screen.eh("settings_voiceprint_title", true);
    this.screen.eh("settings_voiceprint_unlock", true);
    this.screen.eh("settings_voiceprint_reset", true);
    this.screen.eh("settings_voiceprint_create", true);
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
      this.zWv = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
    AppMethodBeat.o(29838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29831);
    super.onCreate(paramBundle);
    setMMTitle(R.l.settings_voiceprint);
    bh.aZW().a(615, this);
    this.rootView = findViewById(R.h.mm_preference_list_content);
    initView();
    this.rootView.setBackgroundResource(R.e.white);
    bh.bCz();
    c.ban().set(at.a.acIJ, Boolean.FALSE);
    bh.bCz();
    c.ban().set(at.a.acIK, Boolean.FALSE);
    bh.bCz();
    c.ban().set(at.a.acIL, Boolean.FALSE);
    bh.bCz();
    c.ban().set(at.a.acIM, Boolean.FALSE);
    Log.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    AppMethodBeat.o(29831);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29833);
    super.onDestroy();
    bh.aZW().b(615, this);
    if (this.lzP != null) {
      this.lzP.dismiss();
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
      paramf = (CheckBoxPreference)paramf.bAi("settings_voiceprint_title");
      Log.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.lzP != null) && (this.lzP.isShowing())) {
        this.lzP.dismiss();
      }
      paramPreference = getContext();
      getString(R.l.app_tip);
      this.lzP = k.a(paramPreference, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        bh.aZW().a(new i(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(29835);
        return true;
        bh.aZW().a(new i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aYi(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sb(0));
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
        hUZ();
        AppMethodBeat.o(29839);
        return;
      }
      k.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29829);
          paramAnonymousDialogInterface.dismiss();
          com.tencent.mm.pluginsdk.permission.b.lx(SettingsVoicePrintUI.this.getContext());
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
    if (this.zWv)
    {
      this.zWv = false;
      if ((this.lzP != null) && (this.lzP.isShowing())) {
        this.lzP.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(R.l.app_tip);
      this.lzP = k.a(localAppCompatActivity, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      Log.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      bh.aZW().a(new i(1), 0);
    }
    AppMethodBeat.o(29832);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(29836);
    Log.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramp.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.eh("settings_voiceprint_unlock", true);
      this.screen.eh("settings_voiceprint_reset", true);
      this.screen.eh("settings_voiceprint_create", true);
      this.screen.eh("settings_voiceprint_title", false);
      ((CheckBoxPreference)this.screen.bAi("settings_voiceprint_title")).Hy(false);
      this.Uuc.hA(getString(R.l.gYt), "");
      this.screen.notifyDataSetChanged();
      if (this.lzP != null) {
        this.lzP.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
    }
    if (paramp.getType() == 615)
    {
      paramString = (i)paramp;
      if (paramString.mStatus != 1) {
        break label512;
      }
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint exist");
      this.screen.eh("settings_voiceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = z.bAU();
      paramp = (CheckBoxPreference)this.screen.bAi("settings_voiceprint_title");
      Log.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.Utk) });
      if (paramString.Utk <= 0) {
        break label446;
      }
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
      paramp.Hy(true);
      this.screen.eh("settings_voiceprint_reset", false);
      this.screen.eh("settings_voiceprint_unlock", false);
      paramInt1 = 0x20000 | paramInt1;
      this.Uuc.hA(getString(R.l.gYu), "");
      Log.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bg.okT.bc("last_login_use_voice", String.valueOf(paramInt1));
      bh.bCz();
      c.ban().B(40, Integer.valueOf(paramInt1));
      this.screen.eh("settings_voiceprint_create", true);
      this.screen.eh("settings_voiceprint_title", false);
      this.Uuc.c(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.lzP != null) {
        this.lzP.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
      label446:
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
      paramp.Hy(false);
      this.screen.eh("settings_voiceprint_reset", true);
      this.screen.eh("settings_voiceprint_unlock", true);
      paramInt1 = 0xFFFDFFFF & paramInt1;
      this.Uuc.hA(getString(R.l.gYt), "");
      break;
      label512:
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
      com.tencent.mm.plugin.report.service.h.OAn.b(11390, new Object[] { Integer.valueOf(2) });
      this.screen.eh("settings_voiceprint_unlock", true);
      this.screen.eh("settings_voiceprint_reset", true);
      this.screen.eh("settings_voiceprint_create", true);
      this.screen.eh("settings_voiceprint_title", true);
      this.Uuc.hA(getString(R.l.gYw), getString(R.l.gYv));
      this.Uuc.c(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29828);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          boolean bool = com.tencent.mm.pluginsdk.permission.b.a(SettingsVoicePrintUI.this, "android.permission.RECORD_AUDIO", 80, SettingsVoicePrintUI.this.getString(R.l.gUZ));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI
 * JD-Core Version:    0.7.0.1
 */