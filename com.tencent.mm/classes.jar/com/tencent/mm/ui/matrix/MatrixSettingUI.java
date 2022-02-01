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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingUI
  extends MMPreference
  implements MatrixSettingHeaderPreference.a
{
  private static Object KYa = null;
  private static boolean KYb = false;
  private ay cBN;
  
  public MatrixSettingUI()
  {
    AppMethodBeat.i(38889);
    this.cBN = ay.aRW("MatrixDelegate");
    AppMethodBeat.o(38889);
  }
  
  private boolean Ia()
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
  
  private static void cY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38894);
    Intent localIntent = new Intent();
    localIntent.setAction(paramString);
    localIntent.putExtra(paramString, paramBoolean);
    ak.getContext();
    e.j(localIntent);
    ak.getContext().sendBroadcast(localIntent, "com.tencent.mm.matrix.strategynotify");
    AppMethodBeat.o(38894);
  }
  
  private static boolean fOe()
  {
    return (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (j.DEBUG);
  }
  
  public final void fOd()
  {
    AppMethodBeat.i(38892);
    ae.i("Matrix.SettingUI", "onOpenDev...");
    KYb = true;
    getPreferenceScreen().cT("matrix_dev_wording", false);
    getPreferenceScreen().cT("make_leak_preference", false);
    getPreferenceScreen().cT("methodBeat_preference", false);
    getPreferenceScreen().cT("trace_dev_log_preference", false);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)getPreferenceScreen().aXe("methodBeat_preference");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)getPreferenceScreen().aXe("trace_dev_log_preference");
    com.tencent.matrix.trace.a locala = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
    localCheckBoxPreference1.setChecked(com.tencent.matrix.trace.a.Je().isAlive());
    localCheckBoxPreference2.setChecked(locala.cKe.cKq);
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(38892);
  }
  
  public int getResourceId()
  {
    return 2131951692;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38895);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    c.i("Matrix.SettingUI", "requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramIntent = (CheckBoxPreference)getPreferenceScreen().aXe("fps_decorator_preference");
      if (Ia()) {
        break label101;
      }
      Toast.makeText(this, getResources().getString(2131761194), 1).show();
      paramIntent.setChecked(false);
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(38895);
      return;
      label101:
      paramIntent.setChecked(true);
      cY("ENABLE_FPS_FLOAT", paramIntent.isChecked());
      ((CheckBoxPreference)getPreferenceScreen().aXe("fps_preference")).setChecked(true);
      cY("ENABLE_FPS", true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38890);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(2131761209));
    setBackBtn(new MatrixSettingUI.1(this));
    if (!com.tencent.matrix.b.HS())
    {
      ae.e("Matrix.SettingUI", "Matrix is not installed!");
      AppMethodBeat.o(38890);
      return;
    }
    MatrixSettingHeaderPreference localMatrixSettingHeaderPreference = (MatrixSettingHeaderPreference)getPreferenceScreen().aXe("matrix_header_pref");
    if ((KYb) || (!fOe())) {}
    for (paramBundle = null;; paramBundle = this)
    {
      localMatrixSettingHeaderPreference.KXV = paramBundle;
      paramBundle = (MatrixSettingSeekBarPreference)getPreferenceScreen().aXe("matrix_jank_seek_bar");
      paramBundle.GbL = this.cBN.getInt(a.a.LZv.name(), 700);
      paramBundle.KXX = new MatrixSettingUI.2(this);
      AppMethodBeat.o(38890);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(38893);
    if (!com.tencent.matrix.b.HS())
    {
      AppMethodBeat.o(38893);
      return false;
    }
    paramf = paramPreference.mKey;
    if (paramf.equalsIgnoreCase("startup_preference")) {
      cY("ENABLE_START_UP", ((CheckBoxPreference)paramPreference).isChecked());
    }
    for (;;)
    {
      AppMethodBeat.o(38893);
      return true;
      if (paramf.equalsIgnoreCase("jank_preference"))
      {
        cY("ENABLE_EVIL_METHOD", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("anr_preference"))
      {
        cY("ENABLE_ANR", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("fps_preference"))
      {
        cY("ENABLE_FPS", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("methodBeat_preference"))
      {
        cY("ENABLE_METHOD_BEAT", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("make_leak_preference"))
      {
        if (((CheckBoxPreference)paramPreference).isChecked()) {
          KYa = this;
        } else {
          KYa = null;
        }
      }
      else if (paramf.equalsIgnoreCase("fps_decorator_preference"))
      {
        paramf = (CheckBoxPreference)paramPreference;
        if (!Ia())
        {
          startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2);
        }
        else
        {
          paramPreference = (CheckBoxPreference)getPreferenceScreen().aXe("fps_preference");
          if (paramf.isChecked())
          {
            paramPreference.setChecked(true);
            cY("ENABLE_FPS", true);
          }
          cY("ENABLE_FPS_FLOAT", paramf.isChecked());
        }
      }
      else if (paramf.equalsIgnoreCase("trace_dev_log_preference"))
      {
        cY("ENABLE_DEV_LOG", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("battery_preference"))
      {
        cY("ENABLE_BATTERY", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("thread_preference"))
      {
        cY("ENABLE_THREAD", ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
  }
  
  public void onStart()
  {
    boolean bool2 = true;
    AppMethodBeat.i(38891);
    super.onStart();
    if (fOe()) {
      addIconOptionMenu(0, 2131230853, new MatrixSettingUI.3(this));
    }
    getPreferenceScreen().cT("thread_preference", true);
    Object localObject1 = getPreferenceScreen();
    boolean bool1;
    label84:
    label107:
    Object localObject2;
    label130:
    Object localObject3;
    CheckBoxPreference localCheckBoxPreference;
    if (!KYb)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cT("methodBeat_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (KYb) {
        break label595;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cT("make_leak_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (KYb) {
        break label600;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cT("matrix_dev_wording", bool1);
      localObject1 = getPreferenceScreen();
      if (KYb) {
        break label605;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cT("trace_dev_log_preference", bool1);
      localObject1 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
      localObject2 = (com.tencent.matrix.f.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.f.a.class);
      localObject3 = (com.tencent.matrix.a.c.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.a.c.a.class);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("anr_preference");
      if ((!KYb) || (localObject1 == null)) {
        break label610;
      }
      bool1 = true;
      label209:
      localCheckBoxPreference.setEnabled(bool1);
      localCheckBoxPreference.setChecked(true);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("startup_preference");
      if ((!fOe()) || (localObject1 == null)) {
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
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("trace_dev_log_preference");
      if ((!fOe()) || (localObject1 == null)) {
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
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("fps_preference");
      localCheckBoxPreference.setEnabled(true);
      if (localObject1 != null) {
        break label660;
      }
      bool1 = false;
      label340:
      localCheckBoxPreference.setChecked(bool1);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("fps_decorator_preference");
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
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("jank_preference");
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
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aXe("battery_preference");
      if ((!fOe()) || (localObject3 == null)) {
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
      localObject3 = (CheckBoxPreference)getPreferenceScreen().aXe("thread_preference");
      if ((!fOe()) || (localObject2 == null)) {
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
      localObject2 = (CheckBoxPreference)getPreferenceScreen().aXe("methodBeat_preference");
      if (localObject1 != null)
      {
        ((CheckBoxPreference)localObject2).setChecked(com.tencent.matrix.trace.a.Je().isAlive());
        ((CheckBoxPreference)getPreferenceScreen().aXe("trace_dev_log_preference")).setChecked(((com.tencent.matrix.trace.a)localObject1).cKe.cKq);
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
      Object localObject4 = ((com.tencent.matrix.trace.a)localObject1).cKg;
      if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).cKL)) {
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
      localObject4 = ((com.tencent.matrix.trace.a)localObject1).cKh;
      if ((localObject4 != null) && (((com.tencent.matrix.trace.f.f)localObject4).cKL)) {}
      for (bool1 = true;; bool1 = false)
      {
        ae.i("Matrix.SettingUI", "[fps_preference] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
        if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).cKL)) {
          break;
        }
        bool1 = true;
        break label340;
      }
      label723:
      bool1 = false;
      break label368;
      label728:
      localObject4 = com.tencent.matrix.trace.view.a.aO(ak.getContext());
      ((com.tencent.matrix.trace.view.a)localObject4).eg(ak.getProcessName());
      if (this.cBN.getInt("ENABLE_FPS_FLOAT", 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.matrix.trace.view.a)localObject4).cNF = bool1;
        ae.i("Matrix.SettingUI", "decorator is enable=" + ((com.tencent.matrix.trace.view.a)localObject4).cNF);
        localCheckBoxPreference.setChecked(((com.tencent.matrix.trace.view.a)localObject4).cNF);
        if ((!((com.tencent.matrix.trace.view.a)localObject4).cNF) || (((com.tencent.matrix.trace.view.a)localObject4).cNB)) {
          break;
        }
        if (!Ia()) {
          break label853;
        }
        ae.w("Matrix.SettingUI", "fallback to show float!");
        cY("ENABLE_FPS", true);
        cY("ENABLE_FPS_FLOAT", true);
        break;
      }
      label853:
      ae.w("Matrix.SettingUI", "has no permission! fallback to dismiss float!");
      cY("ENABLE_FPS_FLOAT", false);
      break label384;
      label870:
      bool1 = false;
      break label407;
      label875:
      localObject4 = ((com.tencent.matrix.trace.a)localObject1).cKf;
      if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).cKL)) {
        break label417;
      }
      bool1 = true;
      break label419;
      label899:
      bool1 = false;
      break label455;
      label904:
      localCheckBoxPreference.setChecked(((com.tencent.matrix.a.c.a)localObject3).isPluginStarted());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingUI
 * JD-Core Version:    0.7.0.1
 */