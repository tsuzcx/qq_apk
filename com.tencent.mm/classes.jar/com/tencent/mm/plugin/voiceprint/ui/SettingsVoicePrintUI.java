package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
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
  implements com.tencent.mm.ak.i
{
  private VoiceHeaderPreference GRQ;
  private ProgressDialog gtM = null;
  private View lJI;
  private boolean sUn = false;
  private f screen;
  
  private void fEP()
  {
    AppMethodBeat.i(29837);
    com.tencent.mm.plugin.report.service.h.CyF.a(11390, new Object[] { Integer.valueOf(3) });
    Intent localIntent = new Intent();
    localIntent.setClass(this, VoiceCreateUI.class);
    localIntent.putExtra("kscene_type", 71);
    localIntent.putExtra("createVoicePrint", true);
    startActivityForResult(localIntent, 1);
    this.sUn = false;
    AppMethodBeat.o(29837);
  }
  
  public int getResourceId()
  {
    return 2132017285;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29834);
    bg.aVF();
    int i = Util.nullAsInt(c.azQ().get(40, Integer.valueOf(0)), 0);
    Log.i("MicroMsg.VoiceSettingsUI", "plugSwitch " + i + " " + (i & 0x20000));
    this.screen = getPreferenceScreen();
    this.GRQ = ((VoiceHeaderPreference)this.screen.bmg("settings_voiceprint_header"));
    ((CheckBoxPreference)this.screen.bmg("settings_voiceprint_title")).xZ(true);
    this.screen.notifyDataSetChanged();
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131755998);
    this.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(0), 0);
    this.screen.jdMethod_do("settings_voiceprint_unlock", true);
    this.screen.jdMethod_do("settings_voiceprint_reset", true);
    this.screen.jdMethod_do("settings_voiceprint_create", true);
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
      this.sUn = paramIntent.getBooleanExtra("KIsCreateSuccess", false);
    }
    AppMethodBeat.o(29838);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29831);
    super.onCreate(paramBundle);
    setMMTitle(2131765680);
    bg.azz().a(615, this);
    this.lJI = findViewById(2131304719);
    initView();
    this.lJI.setBackgroundResource(2131101424);
    bg.aVF();
    c.azQ().set(ar.a.NTp, Boolean.FALSE);
    bg.aVF();
    c.azQ().set(ar.a.NTq, Boolean.FALSE);
    bg.aVF();
    c.azQ().set(ar.a.NTr, Boolean.FALSE);
    bg.aVF();
    c.azQ().set(ar.a.NTs, Boolean.FALSE);
    Log.i("MicroMsg.VoiceSettingsUI", "unset all voiceprint config");
    AppMethodBeat.o(29831);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29833);
    super.onDestroy();
    bg.azz().b(615, this);
    if (this.gtM != null) {
      this.gtM.dismiss();
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
      paramf = (CheckBoxPreference)paramf.bmg("settings_voiceprint_title");
      Log.d("MicroMsg.VoiceSettingsUI", "checkPref.isChecked() " + paramf.isChecked());
      if ((this.gtM != null) && (this.gtM.isShowing())) {
        this.gtM.dismiss();
      }
      paramPreference = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(paramPreference, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      if (paramf.isChecked()) {
        bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(1), 0);
      }
      for (;;)
      {
        AppMethodBeat.o(29835);
        return true;
        bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(2), 0);
      }
    }
    if (paramPreference.equals("settings_voiceprint_unlock"))
    {
      localIntent.setClass(this, VoiceUnLockUI.class);
      localIntent.putExtra("kscene_type", 73);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        fEP();
        AppMethodBeat.o(29839);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763876), getString(2131763890), getString(2131762043), getString(2131756929), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(29829);
          paramAnonymousDialogInterface.dismiss();
          paramAnonymousDialogInterface = SettingsVoicePrintUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$6", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    if (this.sUn)
    {
      this.sUn = false;
      if ((this.gtM != null) && (this.gtM.isShowing())) {
        this.gtM.dismiss();
      }
      AppCompatActivity localAppCompatActivity = getContext();
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(localAppCompatActivity, getString(2131756029), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      Log.d("MicroMsg.VoiceSettingsUI", "resume after create voiceprint, get switch status");
      bg.azz().a(new com.tencent.mm.plugin.voiceprint.model.i(1), 0);
    }
    AppMethodBeat.o(29832);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29836);
    Log.d("MicroMsg.VoiceSettingsUI", "onSceneEnd, errType:%d, errCode:%d, sceneType:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramq.getType()) });
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.screen.jdMethod_do("settings_voiceprint_unlock", true);
      this.screen.jdMethod_do("settings_voiceprint_reset", true);
      this.screen.jdMethod_do("settings_voiceprint_create", true);
      ((CheckBoxPreference)this.screen.bmg("settings_voiceprint_title")).xZ(false);
      this.GRQ.gD(getString(2131767205), "");
      this.screen.notifyDataSetChanged();
      if (this.gtM != null) {
        this.gtM.dismiss();
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
      this.screen.jdMethod_do("settings_voiceprint_unlock", false);
      this.screen.notifyDataSetChanged();
      paramInt1 = z.aUe();
      paramq = (CheckBoxPreference)this.screen.bmg("settings_voiceprint_title");
      Log.d("MicroMsg.VoiceSettingsUI", "opScene.getSwitch:%d", new Object[] { Integer.valueOf(paramString.GQZ) });
      if (paramString.GQZ <= 0) {
        break label433;
      }
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint open");
      paramq.xZ(true);
      this.screen.jdMethod_do("settings_voiceprint_reset", false);
      this.screen.jdMethod_do("settings_voiceprint_unlock", false);
      paramInt1 = 0x20000 | paramInt1;
      this.GRQ.gD(getString(2131767207), "");
      Log.i("MicroMsg.VoiceSettingsUI", "scene end plugSwitch %d", new Object[] { Integer.valueOf(paramInt1) });
      bf.iDu.aO("last_login_use_voice", String.valueOf(paramInt1));
      bg.aVF();
      c.azQ().set(40, Integer.valueOf(paramInt1));
      this.screen.jdMethod_do("settings_voiceprint_create", true);
      this.screen.jdMethod_do("settings_voiceprint_title", false);
      this.GRQ.b(null);
      this.screen.notifyDataSetChanged();
    }
    for (;;)
    {
      if (this.gtM != null) {
        this.gtM.dismiss();
      }
      AppMethodBeat.o(29836);
      return;
      label433:
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint close");
      paramq.xZ(false);
      this.screen.jdMethod_do("settings_voiceprint_reset", true);
      this.screen.jdMethod_do("settings_voiceprint_unlock", true);
      paramInt1 = 0xFFFDFFFF & paramInt1;
      this.GRQ.gD(getString(2131767205), "");
      break;
      label499:
      Log.d("MicroMsg.VoiceSettingsUI", "voiceprint not exist");
      com.tencent.mm.plugin.report.service.h.CyF.a(11390, new Object[] { Integer.valueOf(2) });
      this.screen.jdMethod_do("settings_voiceprint_unlock", true);
      this.screen.jdMethod_do("settings_voiceprint_reset", true);
      this.screen.jdMethod_do("settings_voiceprint_create", true);
      this.screen.jdMethod_do("settings_voiceprint_title", true);
      this.GRQ.gD(getString(2131767209), getString(2131767208));
      this.GRQ.b(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(29828);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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