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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingUI
  extends MMPreference
  implements MatrixSettingHeaderPreference.a
{
  private static Object KBG = null;
  private static boolean KBH = false;
  private ax cBg;
  
  public MatrixSettingUI()
  {
    AppMethodBeat.i(38889);
    this.cBg = ax.aQz("MatrixDelegate");
    AppMethodBeat.o(38889);
  }
  
  private boolean HS()
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
  
  private static void cU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38894);
    Intent localIntent = new Intent();
    localIntent.setAction(paramString);
    localIntent.putExtra(paramString, paramBoolean);
    aj.getContext();
    e.j(localIntent);
    aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.matrix.strategynotify");
    AppMethodBeat.o(38894);
  }
  
  private static boolean fJN()
  {
    return (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE) || (i.DEBUG);
  }
  
  public final void fJM()
  {
    AppMethodBeat.i(38892);
    ad.i("Matrix.SettingUI", "onOpenDev...");
    KBH = true;
    getPreferenceScreen().cP("matrix_dev_wording", false);
    getPreferenceScreen().cP("make_leak_preference", false);
    getPreferenceScreen().cP("methodBeat_preference", false);
    getPreferenceScreen().cP("trace_dev_log_preference", false);
    CheckBoxPreference localCheckBoxPreference1 = (CheckBoxPreference)getPreferenceScreen().aVD("methodBeat_preference");
    CheckBoxPreference localCheckBoxPreference2 = (CheckBoxPreference)getPreferenceScreen().aVD("trace_dev_log_preference");
    com.tencent.matrix.trace.a locala = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class);
    localCheckBoxPreference1.oB = com.tencent.matrix.trace.a.IW().isAlive();
    localCheckBoxPreference2.oB = locala.cJv.cJH;
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
      paramIntent = (CheckBoxPreference)getPreferenceScreen().aVD("fps_decorator_preference");
      if (HS()) {
        break label101;
      }
      Toast.makeText(this, getResources().getString(2131761194), 1).show();
      paramIntent.oB = false;
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(38895);
      return;
      label101:
      paramIntent.oB = true;
      cU("ENABLE_FPS_FLOAT", paramIntent.isChecked());
      ((CheckBoxPreference)getPreferenceScreen().aVD("fps_preference")).oB = true;
      cU("ENABLE_FPS", true);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38890);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(2131761209));
    setBackBtn(new MatrixSettingUI.1(this));
    if (!com.tencent.matrix.b.HK())
    {
      ad.e("Matrix.SettingUI", "Matrix is not installed!");
      AppMethodBeat.o(38890);
      return;
    }
    MatrixSettingHeaderPreference localMatrixSettingHeaderPreference = (MatrixSettingHeaderPreference)getPreferenceScreen().aVD("matrix_header_pref");
    if ((KBH) || (!fJN())) {}
    for (paramBundle = null;; paramBundle = this)
    {
      localMatrixSettingHeaderPreference.KBB = paramBundle;
      paramBundle = (MatrixSettingSeekBarPreference)getPreferenceScreen().aVD("matrix_jank_seek_bar");
      paramBundle.FJm = this.cBg.getInt(a.a.LCr.name(), 700);
      paramBundle.KBD = new MatrixSettingUI.2(this);
      AppMethodBeat.o(38890);
      return;
    }
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(38893);
    if (!com.tencent.matrix.b.HK())
    {
      AppMethodBeat.o(38893);
      return false;
    }
    paramf = paramPreference.mKey;
    if (paramf.equalsIgnoreCase("startup_preference")) {
      cU("ENABLE_START_UP", ((CheckBoxPreference)paramPreference).isChecked());
    }
    for (;;)
    {
      AppMethodBeat.o(38893);
      return true;
      if (paramf.equalsIgnoreCase("jank_preference"))
      {
        cU("ENABLE_EVIL_METHOD", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("anr_preference"))
      {
        cU("ENABLE_ANR", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("fps_preference"))
      {
        cU("ENABLE_FPS", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("methodBeat_preference"))
      {
        cU("ENABLE_METHOD_BEAT", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("make_leak_preference"))
      {
        if (((CheckBoxPreference)paramPreference).isChecked()) {
          KBG = this;
        } else {
          KBG = null;
        }
      }
      else if (paramf.equalsIgnoreCase("fps_decorator_preference"))
      {
        paramf = (CheckBoxPreference)paramPreference;
        if (!HS())
        {
          startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2);
        }
        else
        {
          paramPreference = (CheckBoxPreference)getPreferenceScreen().aVD("fps_preference");
          if (paramf.isChecked())
          {
            paramPreference.oB = true;
            cU("ENABLE_FPS", true);
          }
          cU("ENABLE_FPS_FLOAT", paramf.isChecked());
        }
      }
      else if (paramf.equalsIgnoreCase("trace_dev_log_preference"))
      {
        cU("ENABLE_DEV_LOG", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("battery_preference"))
      {
        cU("ENABLE_BATTERY", ((CheckBoxPreference)paramPreference).isChecked());
      }
      else if (paramf.equalsIgnoreCase("thread_preference"))
      {
        cU("ENABLE_THREAD", ((CheckBoxPreference)paramPreference).isChecked());
      }
    }
  }
  
  public void onStart()
  {
    boolean bool2 = true;
    AppMethodBeat.i(38891);
    super.onStart();
    if (fJN()) {
      addIconOptionMenu(0, 2131230853, new MatrixSettingUI.3(this));
    }
    getPreferenceScreen().cP("thread_preference", true);
    Object localObject1 = getPreferenceScreen();
    boolean bool1;
    label84:
    label107:
    Object localObject2;
    label130:
    Object localObject3;
    CheckBoxPreference localCheckBoxPreference;
    if (!KBH)
    {
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cP("methodBeat_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (KBH) {
        break label595;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cP("make_leak_preference", bool1);
      localObject1 = getPreferenceScreen();
      if (KBH) {
        break label600;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cP("matrix_dev_wording", bool1);
      localObject1 = getPreferenceScreen();
      if (KBH) {
        break label605;
      }
      bool1 = true;
      ((com.tencent.mm.ui.base.preference.f)localObject1).cP("trace_dev_log_preference", bool1);
      localObject1 = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class);
      localObject2 = (com.tencent.matrix.f.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.f.a.class);
      localObject3 = (com.tencent.matrix.a.c.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.a.c.a.class);
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("anr_preference");
      if ((!KBH) || (localObject1 == null)) {
        break label610;
      }
      bool1 = true;
      label209:
      localCheckBoxPreference.setEnabled(bool1);
      localCheckBoxPreference.oB = true;
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("startup_preference");
      if ((!fJN()) || (localObject1 == null)) {
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
      localCheckBoxPreference.oB = bool1;
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("trace_dev_log_preference");
      if ((!fJN()) || (localObject1 == null)) {
        break label644;
      }
      bool1 = true;
      label296:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label649;
      }
      localCheckBoxPreference.oB = false;
      label312:
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("fps_preference");
      localCheckBoxPreference.setEnabled(true);
      if (localObject1 != null) {
        break label660;
      }
      bool1 = false;
      label340:
      localCheckBoxPreference.oB = bool1;
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("fps_decorator_preference");
      if (localObject1 == null) {
        break label723;
      }
      bool1 = true;
      label368:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject1 != null) {
        break label728;
      }
      localCheckBoxPreference.oB = false;
      label384:
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("jank_preference");
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
      localCheckBoxPreference.oB = bool1;
      localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().aVD("battery_preference");
      if ((!fJN()) || (localObject3 == null)) {
        break label899;
      }
      bool1 = true;
      label455:
      localCheckBoxPreference.setEnabled(bool1);
      if (localObject3 != null) {
        break label904;
      }
      localCheckBoxPreference.oB = false;
      label472:
      localObject3 = (CheckBoxPreference)getPreferenceScreen().aVD("thread_preference");
      if ((!fJN()) || (localObject2 == null)) {
        break label917;
      }
      bool1 = bool2;
      label502:
      ((CheckBoxPreference)localObject3).setEnabled(bool1);
      if (localObject2 != null) {
        break label922;
      }
    }
    label644:
    label649:
    label660:
    label917:
    label922:
    for (((CheckBoxPreference)localObject3).oB = false;; ((CheckBoxPreference)localObject3).oB = ((com.tencent.matrix.f.a)localObject2).isPluginStarted())
    {
      localObject2 = (CheckBoxPreference)getPreferenceScreen().aVD("methodBeat_preference");
      if (localObject1 != null)
      {
        ((CheckBoxPreference)localObject2).oB = com.tencent.matrix.trace.a.IW().isAlive();
        ((CheckBoxPreference)getPreferenceScreen().aVD("trace_dev_log_preference")).oB = ((com.tencent.matrix.trace.a)localObject1).cJv.cJH;
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
      Object localObject4 = ((com.tencent.matrix.trace.a)localObject1).cJx;
      if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).cKc)) {
        break label260;
      }
      bool1 = true;
      break label262;
      bool1 = false;
      break label296;
      localCheckBoxPreference.oB = AppMethodBeat.isDev;
      break label312;
      localObject4 = ((com.tencent.matrix.trace.a)localObject1).cJy;
      if ((localObject4 != null) && (((com.tencent.matrix.trace.f.f)localObject4).cKc)) {}
      for (bool1 = true;; bool1 = false)
      {
        ad.i("Matrix.SettingUI", "[fps_preference] isEnable=%s", new Object[] { Boolean.valueOf(bool1) });
        if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).cKc)) {
          break;
        }
        bool1 = true;
        break label340;
      }
      label723:
      bool1 = false;
      break label368;
      label728:
      localObject4 = com.tencent.matrix.trace.view.a.aN(aj.getContext());
      ((com.tencent.matrix.trace.view.a)localObject4).eb(aj.getProcessName());
      if (this.cBg.getInt("ENABLE_FPS_FLOAT", 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.matrix.trace.view.a)localObject4).cMW = bool1;
        ad.i("Matrix.SettingUI", "decorator is enable=" + ((com.tencent.matrix.trace.view.a)localObject4).cMW);
        localCheckBoxPreference.oB = ((com.tencent.matrix.trace.view.a)localObject4).cMW;
        if ((!((com.tencent.matrix.trace.view.a)localObject4).cMW) || (((com.tencent.matrix.trace.view.a)localObject4).cMS)) {
          break;
        }
        if (!HS()) {
          break label853;
        }
        ad.w("Matrix.SettingUI", "fallback to show float!");
        cU("ENABLE_FPS", true);
        cU("ENABLE_FPS_FLOAT", true);
        break;
      }
      label853:
      ad.w("Matrix.SettingUI", "has no permission! fallback to dismiss float!");
      cU("ENABLE_FPS_FLOAT", false);
      break label384;
      label870:
      bool1 = false;
      break label407;
      label875:
      localObject4 = ((com.tencent.matrix.trace.a)localObject1).cJw;
      if ((localObject4 == null) || (!((com.tencent.matrix.trace.f.f)localObject4).cKc)) {
        break label417;
      }
      bool1 = true;
      break label419;
      bool1 = false;
      break label455;
      localCheckBoxPreference.oB = ((com.tencent.matrix.a.c.a)localObject3).isPluginStarted();
      break label472;
      bool1 = false;
      break label502;
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