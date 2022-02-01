package com.tencent.mm.ui.matrix;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.b.a.a.a;
import com.tencent.matrix.strategy.MatrixStrategyNotifyBroadcast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.tracer.g;
import com.tencent.matrix.trace.view.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
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
  private static Object afxI = null;
  private static boolean afxJ = false;
  private MultiProcessMMKV eLH;
  
  public MatrixSettingUI()
  {
    AppMethodBeat.i(38889);
    this.eLH = MultiProcessMMKV.getMMKV("MatrixDelegate");
    AppMethodBeat.o(38889);
  }
  
  private boolean awl()
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
  
  private static boolean bgV()
  {
    return (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG);
  }
  
  private static void er(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38894);
    Intent localIntent = new Intent();
    localIntent.setAction(paramString);
    localIntent.putExtra(paramString, paramBoolean);
    MMApplicationContext.getContext();
    com.tencent.matrix.f.l(localIntent);
    MMApplicationContext.getContext().sendBroadcast(localIntent, MatrixStrategyNotifyBroadcast.fdj);
    AppMethodBeat.o(38894);
  }
  
  public int getResourceId()
  {
    return R.o.hbh;
  }
  
  public final void jBJ()
  {
    AppMethodBeat.i(38892);
    Log.i("Matrix.SettingUI", "onOpenDev...");
    afxJ = true;
    getPreferenceScreen().eh("matrix_dev_wording", false);
    getPreferenceScreen().eh("make_leak_preference", false);
    getPreferenceScreen().eh("methodBeat_preference", false);
    getPreferenceScreen().eh("trace_dev_log_preference", false);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)getPreferenceScreen().bAi("methodBeat_preference");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)getPreferenceScreen().bAi("trace_dev_log_preference");
    com.tencent.matrix.trace.b localb = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
    localCheckBoxPreference1.setChecked(com.tencent.matrix.trace.b.azC().isAlive());
    localCheckBoxPreference2.setChecked(localb.fdo.fdK);
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(38892);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38895);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.matrix.e.c.i("Matrix.SettingUI", "requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramIntent = (CheckBoxPreference)getPreferenceScreen().bAi("fps_decorator_preference");
      if (awl()) {
        break label102;
      }
      Toast.makeText(this, getResources().getString(R.l.gNG), 1).show();
      paramIntent.setChecked(false);
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(38895);
      return;
      label102:
      paramIntent.setChecked(true);
      er("ENABLE_FPS_FLOAT", paramIntent.isChecked());
      ((CheckBoxPreference)getPreferenceScreen().bAi("fps_preference")).setChecked(true);
      er("ENABLE_FPS", true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38890);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(R.l.gNI));
    setBackBtn(new MatrixSettingUI.1(this));
    if (!com.tencent.matrix.c.isInstalled())
    {
      Log.e("Matrix.SettingUI", "Matrix is not installed!");
      AppMethodBeat.o(38890);
      return;
    }
    MatrixSettingHeaderPreference localMatrixSettingHeaderPreference = (MatrixSettingHeaderPreference)getPreferenceScreen().bAi("matrix_header_pref");
    if ((afxJ) || (!bgV())) {}
    for (paramBundle = null;; paramBundle = this)
    {
      localMatrixSettingHeaderPreference.afxD = paramBundle;
      paramBundle = (MatrixSettingSeekBarPreference)getPreferenceScreen().bAi("matrix_jank_seek_bar");
      paramBundle.Jfu = this.eLH.getInt(a.a.ahaa.name(), 700);
      paramBundle.afxF = new MatrixSettingUI.2(this);
      AppMethodBeat.o(38890);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(38893);
    if (!com.tencent.matrix.c.isInstalled())
    {
      AppMethodBeat.o(38893);
      return false;
    }
    paramf = paramPreference.mKey;
    if (paramf.equalsIgnoreCase("startup_preference")) {
      er("ENABLE_START_UP", ((CheckBoxPreference)paramPreference).isChecked());
    }
    for (;;)
    {
      AppMethodBeat.o(38893);
      return true;
      if (paramf.equalsIgnoreCase("jank_preference"))
      {
        er("ENABLE_EVIL_METHOD", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("anr_preference"))
      {
        er("ENABLE_ANR", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("fps_preference"))
      {
        er("ENABLE_FPS", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("methodBeat_preference"))
      {
        er("ENABLE_METHOD_BEAT", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("make_leak_preference"))
      {
        if (((CheckBoxPreference)paramPreference).isChecked()) {
          afxI = this;
        } else {
          afxI = null;
        }
      }
      else if (paramf.equalsIgnoreCase("fps_decorator_preference"))
      {
        paramf = (CheckBoxPreference)paramPreference;
        if (!awl())
        {
          startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2);
        }
        else
        {
          paramPreference = (CheckBoxPreference)getPreferenceScreen().bAi("fps_preference");
          if (paramf.isChecked())
          {
            paramPreference.setChecked(true);
            er("ENABLE_FPS", true);
          }
          er("ENABLE_FPS_FLOAT", paramf.isChecked());
        }
      }
      else if (paramf.equalsIgnoreCase("trace_dev_log_preference"))
      {
        er("ENABLE_DEV_LOG", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("battery_preference"))
      {
        er("ENABLE_BATTERY", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("thread_preference"))
      {
        er("ENABLE_THREAD", ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
  }
  
  public void onStart()
  {
    boolean bool2 = true;
    AppMethodBeat.i(38891);
    super.onStart();
    if (bgV()) {
      addIconOptionMenu(0, R.g.actionbar_icon_light_more, new MatrixSettingUI.3(this));
    }
    getPreferenceScreen().eh("thread_preference", true);
    Object localObject1 = getPreferenceScreen();
    boolean bool1;
    label84:
    label107:
    Object localObject2;
    label130:
    CheckBoxPreference localCheckBoxPreference;
    if (!afxJ)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("methodBeat_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (afxJ) {
        break label534;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("make_leak_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (afxJ) {
        break label539;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("matrix_dev_wording", bool1);
      localObject1 = getPreferenceScreen();
      if (afxJ) {
        break label544;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("trace_dev_log_preference", bool1);
      localObject1 = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
      localObject2 = (com.tencent.matrix.a.c)com.tencent.matrix.c.avW().ai(com.tencent.matrix.a.c.class);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("anr_preference");
      if ((!afxJ) || (localObject1 == null)) {
        break label549;
      }
      bool1 = true;
      label195:
      localCheckBoxPreference.setEnabled(bool1);
      localCheckBoxPreference.setChecked(true);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("startup_preference");
      if ((!bgV()) || (localObject1 == null)) {
        break label554;
      }
      bool1 = true;
      label236:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label559;
      }
      label246:
      bool1 = false;
      label248:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("trace_dev_log_preference");
      if ((!bgV()) || (localObject1 == null)) {
        break label583;
      }
      bool1 = true;
      label282:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label588;
      }
      localCheckBoxPreference.setChecked(false);
      label298:
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("fps_preference");
      localCheckBoxPreference.setEnabled(true);
      if (localObject1 != null) {
        break label599;
      }
      bool1 = false;
      label326:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("fps_decorator_preference");
      if (localObject1 == null) {
        break label662;
      }
      bool1 = true;
      label354:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label667;
      }
      localCheckBoxPreference.setChecked(false);
      label370:
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("jank_preference");
      if (localObject1 == null) {
        break label809;
      }
      bool1 = true;
      label393:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label814;
      }
      label403:
      bool1 = false;
      label405:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("battery_preference");
      if ((!bgV()) || (localObject2 == null)) {
        break label838;
      }
      bool1 = bool2;
      label441:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject2 != null) {
        break label843;
      }
      localCheckBoxPreference.setChecked(false);
    }
    for (;;)
    {
      localObject2 = (CheckBoxPreference)getPreferenceScreen().bAi("methodBeat_preference");
      if (localObject1 != null)
      {
        ((CheckBoxPreference)localObject2).setChecked(com.tencent.matrix.trace.b.azC().isAlive());
        ((CheckBoxPreference)getPreferenceScreen().bAi("trace_dev_log_preference")).setChecked(((com.tencent.matrix.trace.b)localObject1).fdo.fdK);
      }
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(38891);
      return;
      bool1 = false;
      break;
      label534:
      bool1 = false;
      break label84;
      label539:
      bool1 = false;
      break label107;
      label544:
      bool1 = false;
      break label130;
      label549:
      bool1 = false;
      break label195;
      label554:
      bool1 = false;
      break label236;
      label559:
      Object localObject3 = ((com.tencent.matrix.trace.b)localObject1).fdq;
      if ((localObject3 == null) || (!((g)localObject3).fez)) {
        break label246;
      }
      bool1 = true;
      break label248;
      label583:
      bool1 = false;
      break label282;
      label588:
      localCheckBoxPreference.setChecked(AppMethodBeat.isDev);
      break label298;
      label599:
      localObject3 = ((com.tencent.matrix.trace.b)localObject1).fdr;
      if ((localObject3 != null) && (((g)localObject3).fez)) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.i("Matrix.SettingUI", "[fps_preference] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
        if ((localObject3 == null) || (!((g)localObject3).fez)) {
          break;
        }
        bool1 = true;
        break label326;
      }
      label662:
      bool1 = false;
      break label354;
      label667:
      localObject3 = a.cj(MMApplicationContext.getContext());
      ((a)localObject3).hn(MMApplicationContext.getProcessName());
      if (this.eLH.getInt("ENABLE_FPS_FLOAT", 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        ((a)localObject3).egk = bool1;
        Log.i("Matrix.SettingUI", "decorator is enable=" + ((a)localObject3).egk);
        localCheckBoxPreference.setChecked(((a)localObject3).egk);
        if ((!((a)localObject3).egk) || (((a)localObject3).fhR)) {
          break;
        }
        if (!awl()) {
          break label792;
        }
        Log.w("Matrix.SettingUI", "fallback to show float!");
        er("ENABLE_FPS", true);
        er("ENABLE_FPS_FLOAT", true);
        break;
      }
      label792:
      Log.w("Matrix.SettingUI", "has no permission! fallback to dismiss float!");
      er("ENABLE_FPS_FLOAT", false);
      break label370;
      label809:
      bool1 = false;
      break label393;
      label814:
      localObject3 = ((com.tencent.matrix.trace.b)localObject1).fdp;
      if ((localObject3 == null) || (!((g)localObject3).fez)) {
        break label403;
      }
      bool1 = true;
      break label405;
      label838:
      bool1 = false;
      break label441;
      label843:
      localCheckBoxPreference.setChecked(((com.tencent.matrix.a.c)localObject2).isPluginStarted());
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingUI
 * JD-Core Version:    0.7.0.1
 */