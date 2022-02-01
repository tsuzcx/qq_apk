package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.c.a.a.a;
import com.tencent.matrix.e;
import com.tencent.matrix.g.c;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingUI
  extends MMPreference
  implements MatrixSettingHeaderPreference.a
{
  private static Object QmU = null;
  private static boolean QmV = false;
  private MultiProcessMMKV cPL;
  
  public MatrixSettingUI()
  {
    AppMethodBeat.i(38889);
    this.cPL = MultiProcessMMKV.getMMKV("MatrixDelegate");
    AppMethodBeat.o(38889);
  }
  
  private boolean RN()
  {
    AppMethodBeat.i(38896);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = Settings.canDrawOverlays(this);
      AppMethodBeat.o(38896);
      return bool;
    }
    AppMethodBeat.o(38896);
    return true;
  }
  
  private static boolean dCM()
  {
    return (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG);
  }
  
  private static void dt(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38894);
    Intent localIntent = new Intent();
    localIntent.setAction(paramString);
    localIntent.putExtra(paramString, paramBoolean);
    MMApplicationContext.getContext();
    e.j(localIntent);
    MMApplicationContext.getContext().sendBroadcast(localIntent, MatrixStrategyNotifyBroadcast.dag);
    AppMethodBeat.o(38894);
  }
  
  public final void gWW()
  {
    AppMethodBeat.i(38892);
    Log.i("Matrix.SettingUI", "onOpenDev...");
    QmV = true;
    getPreferenceScreen().jdMethod_do("matrix_dev_wording", false);
    getPreferenceScreen().jdMethod_do("make_leak_preference", false);
    getPreferenceScreen().jdMethod_do("methodBeat_preference", false);
    getPreferenceScreen().jdMethod_do("trace_dev_log_preference", false);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)getPreferenceScreen().bmg("methodBeat_preference");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)getPreferenceScreen().bmg("trace_dev_log_preference");
    com.tencent.matrix.trace.a locala = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
    localCheckBoxPreference1.setChecked(com.tencent.matrix.trace.a.Ts().isAlive());
    localCheckBoxPreference2.setChecked(locala.daC.daO);
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(38892);
  }
  
  public int getResourceId()
  {
    return 2132017236;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38895);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    c.i("Matrix.SettingUI", "requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramIntent = (CheckBoxPreference)getPreferenceScreen().bmg("fps_decorator_preference");
      if (RN()) {
        break label101;
      }
      Toast.makeText(this, getResources().getString(2131762981), 1).show();
      paramIntent.setChecked(false);
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(38895);
      return;
      label101:
      paramIntent.setChecked(true);
      dt("ENABLE_FPS_FLOAT", paramIntent.isChecked());
      ((CheckBoxPreference)getPreferenceScreen().bmg("fps_preference")).setChecked(true);
      dt("ENABLE_FPS", true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38890);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(2131762996));
    setBackBtn(new MatrixSettingUI.1(this));
    if (!com.tencent.matrix.b.isInstalled())
    {
      Log.e("Matrix.SettingUI", "Matrix is not installed!");
      AppMethodBeat.o(38890);
      return;
    }
    MatrixSettingHeaderPreference localMatrixSettingHeaderPreference = (MatrixSettingHeaderPreference)getPreferenceScreen().bmg("matrix_header_pref");
    if ((QmV) || (!dCM())) {}
    for (paramBundle = null;; paramBundle = this)
    {
      localMatrixSettingHeaderPreference.QmP = paramBundle;
      paramBundle = (MatrixSettingSeekBarPreference)getPreferenceScreen().bmg("matrix_jank_seek_bar");
      paramBundle.KVM = this.cPL.getInt(a.a.RzN.name(), 700);
      paramBundle.QmR = new MatrixSettingUI.2(this);
      AppMethodBeat.o(38890);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(38893);
    if (!com.tencent.matrix.b.isInstalled())
    {
      AppMethodBeat.o(38893);
      return false;
    }
    paramf = paramPreference.mKey;
    if (paramf.equalsIgnoreCase("startup_preference")) {
      dt("ENABLE_START_UP", ((CheckBoxPreference)paramPreference).isChecked());
    }
    for (;;)
    {
      AppMethodBeat.o(38893);
      return true;
      if (paramf.equalsIgnoreCase("jank_preference"))
      {
        dt("ENABLE_EVIL_METHOD", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("anr_preference"))
      {
        dt("ENABLE_ANR", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("fps_preference"))
      {
        dt("ENABLE_FPS", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("methodBeat_preference"))
      {
        dt("ENABLE_METHOD_BEAT", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("make_leak_preference"))
      {
        if (((CheckBoxPreference)paramPreference).isChecked()) {
          QmU = this;
        } else {
          QmU = null;
        }
      }
      else if (paramf.equalsIgnoreCase("fps_decorator_preference"))
      {
        paramf = (CheckBoxPreference)paramPreference;
        if (!RN())
        {
          startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2);
        }
        else
        {
          paramPreference = (CheckBoxPreference)getPreferenceScreen().bmg("fps_preference");
          if (paramf.isChecked())
          {
            paramPreference.setChecked(true);
            dt("ENABLE_FPS", true);
          }
          dt("ENABLE_FPS_FLOAT", paramf.isChecked());
        }
      }
      else if (paramf.equalsIgnoreCase("trace_dev_log_preference"))
      {
        dt("ENABLE_DEV_LOG", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("battery_preference"))
      {
        dt("ENABLE_BATTERY", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("thread_preference"))
      {
        dt("ENABLE_THREAD", ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
  }
  
  public void onStart()
  {
    boolean bool2 = true;
    AppMethodBeat.i(38891);
    super.onStart();
    if (dCM()) {
      addIconOptionMenu(0, 2131230866, new MatrixSettingUI.3(this));
    }
    getPreferenceScreen().jdMethod_do("thread_preference", true);
    Object localObject1 = getPreferenceScreen();
    boolean bool1;
    label84:
    label107:
    Object localObject2;
    label130:
    Object localObject3;
    CheckBoxPreference localCheckBoxPreference;
    if (!QmV)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("methodBeat_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (QmV) {
        break label595;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("make_leak_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (QmV) {
        break label600;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("matrix_dev_wording", bool1);
      localObject1 = getPreferenceScreen();
      if (QmV) {
        break label605;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).jdMethod_do("trace_dev_log_preference", bool1);
      localObject1 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
      localObject2 = (com.tencent.matrix.f.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.f.a.class);
      localObject3 = (com.tencent.matrix.a.b)com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("anr_preference");
      if ((!QmV) || (localObject1 == null)) {
        break label610;
      }
      bool1 = true;
      label209:
      localCheckBoxPreference.setEnabled(bool1);
      localCheckBoxPreference.setChecked(true);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("startup_preference");
      if ((!dCM()) || (localObject1 == null)) {
        break label615;
      }
      bool1 = true;
      label250:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label620;
      }
      label260:
      bool1 = false;
      label262:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("trace_dev_log_preference");
      if ((!dCM()) || (localObject1 == null)) {
        break label644;
      }
      bool1 = true;
      label296:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label649;
      }
      localCheckBoxPreference.setChecked(false);
      label312:
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("fps_preference");
      localCheckBoxPreference.setEnabled(true);
      if (localObject1 != null) {
        break label660;
      }
      bool1 = false;
      label340:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("fps_decorator_preference");
      if (localObject1 == null) {
        break label723;
      }
      bool1 = true;
      label368:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label728;
      }
      localCheckBoxPreference.setChecked(false);
      label384:
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("jank_preference");
      if (localObject1 == null) {
        break label870;
      }
      bool1 = true;
      label407:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label875;
      }
      label417:
      bool1 = false;
      label419:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bmg("battery_preference");
      if ((!dCM()) || (localObject3 == null)) {
        break label899;
      }
      bool1 = true;
      label455:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject3 != null) {
        break label904;
      }
      localCheckBoxPreference.setChecked(false);
      label472:
      localObject3 = (CheckBoxPreference)getPreferenceScreen().bmg("thread_preference");
      if ((!dCM()) || (localObject2 == null)) {
        break label917;
      }
      bool1 = bool2;
      label502:
      ((CheckBoxPreference)localObject3).setEnabled(bool1);
      if (localObject2 != null) {
        break label922;
      }
      ((CheckBoxPreference)localObject3).setChecked(false);
    }
    for (;;)
    {
      localObject2 = (CheckBoxPreference)getPreferenceScreen().bmg("methodBeat_preference");
      if (localObject1 != null)
      {
        ((CheckBoxPreference)localObject2).setChecked(com.tencent.matrix.trace.a.Ts().isAlive());
        ((CheckBoxPreference)getPreferenceScreen().bmg("trace_dev_log_preference")).setChecked(((com.tencent.matrix.trace.a)localObject1).daC.daO);
      }
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(38891);
      return;
      bool1 = false;
      break;
      label595:
      bool1 = false;
      break label84;
      label600:
      bool1 = false;
      break label107;
      label605:
      bool1 = false;
      break label130;
      label610:
      bool1 = false;
      break label209;
      label615:
      bool1 = false;
      break label250;
      label620:
      Object localObject4 = ((com.tencent.matrix.trace.a)localObject1).daE;
      if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).dbi)) {
        break label260;
      }
      bool1 = true;
      break label262;
      label644:
      bool1 = false;
      break label296;
      label649:
      localCheckBoxPreference.setChecked(AppMethodBeat.isDev);
      break label312;
      label660:
      localObject4 = ((com.tencent.matrix.trace.a)localObject1).daF;
      if ((localObject4 != null) && (((com.tencent.matrix.trace.f.f)localObject4).dbi)) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("Matrix.SettingUI", "[fps_preference] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
        if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).dbi)) {
          break;
        }
        bool1 = true;
        break label340;
      }
      label723:
      bool1 = false;
      break label368;
      label728:
      localObject4 = com.tencent.matrix.trace.view.a.bi(MMApplicationContext.getContext());
      ((com.tencent.matrix.trace.view.a)localObject4).eQ(MMApplicationContext.getProcessName());
      if (this.cPL.getInt("ENABLE_FPS_FLOAT", 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.matrix.trace.view.a)localObject4).ded = bool1;
        Log.i("Matrix.SettingUI", "decorator is enable=" + ((com.tencent.matrix.trace.view.a)localObject4).ded);
        localCheckBoxPreference.setChecked(((com.tencent.matrix.trace.view.a)localObject4).ded);
        if ((!((com.tencent.matrix.trace.view.a)localObject4).ded) || (((com.tencent.matrix.trace.view.a)localObject4).ddZ)) {
          break;
        }
        if (!RN()) {
          break label853;
        }
        Log.w("Matrix.SettingUI", "fallback to show float!");
        dt("ENABLE_FPS", true);
        dt("ENABLE_FPS_FLOAT", true);
        break;
      }
      label853:
      Log.w("Matrix.SettingUI", "has no permission! fallback to dismiss float!");
      dt("ENABLE_FPS_FLOAT", false);
      break label384;
      label870:
      bool1 = false;
      break label407;
      label875:
      localObject4 = ((com.tencent.matrix.trace.a)localObject1).daD;
      if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).dbi)) {
        break label417;
      }
      bool1 = true;
      break label419;
      label899:
      bool1 = false;
      break label455;
      label904:
      localCheckBoxPreference.setChecked(((com.tencent.matrix.a.b)localObject3).isPluginStarted());
      break label472;
      label917:
      bool1 = false;
      break label502;
      label922:
      ((CheckBoxPreference)localObject3).setChecked(((com.tencent.matrix.f.a)localObject2).isPluginStarted());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingUI
 * JD-Core Version:    0.7.0.1
 */