package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;
import com.tencent.matrix.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.view.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingUI
  extends MMPreference
{
  static a Apt;
  
  static
  {
    AppMethodBeat.i(156167);
    Apt = a.aB(ah.getContext());
    AppMethodBeat.o(156167);
  }
  
  private boolean dNp()
  {
    AppMethodBeat.i(156166);
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool = Settings.canDrawOverlays(this);
      AppMethodBeat.o(156166);
      return bool;
    }
    AppMethodBeat.o(156166);
    return true;
  }
  
  public int getResourceId()
  {
    return 2131165250;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(156165);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    c.i("MicroMsg.mmui.MMPreference", "requestCode:%s resultCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 2) && (!dNp())) {
      Toast.makeText(this, getResources().getString(2131306188), 1).show();
    }
    AppMethodBeat.o(156165);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(156163);
    super.onCreate(paramBundle);
    setMMTitle("Matrix");
    setBackBtn(new MatrixSettingUI.1(this));
    addIconOptionMenu(0, 2130837627, new MatrixSettingUI.2(this));
    getPreferenceScreen().cl("methodBeat_preference", true);
    paramBundle = (CheckBoxPreference)getPreferenceScreen().atx("anr_preference");
    if (paramBundle != null)
    {
      paramBundle.setEnabled(false);
      paramBundle.vxW = true;
    }
    ((CheckBoxPreference)getPreferenceScreen().atx("trace_dev_preference")).vxW = false;
    AppMethodBeat.o(156163);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(156164);
    if (!com.tencent.matrix.b.isInstalled())
    {
      AppMethodBeat.o(156164);
      return false;
    }
    com.tencent.matrix.trace.b localb = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
    if (localb == null)
    {
      AppMethodBeat.o(156164);
      return false;
    }
    String str = paramPreference.mKey;
    paramf = (CheckBoxPreference)paramPreference;
    if (str.equalsIgnoreCase("startup_preference"))
    {
      paramPreference = localb.bQP;
      if (paramf.isChecked()) {
        paramPreference.zA();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156164);
      return true;
      paramPreference.zB();
      continue;
      if (str.equalsIgnoreCase("jank_preference"))
      {
        paramPreference = localb.bQO;
        if (paramf.isChecked()) {
          paramPreference.zA();
        } else {
          paramPreference.zB();
        }
      }
      else if (!str.equalsIgnoreCase("anr_preference"))
      {
        if (str.equalsIgnoreCase("fps_preference"))
        {
          paramPreference = localb.bQQ;
          if (paramf.isChecked())
          {
            paramPreference.zA();
            paramf = (CheckBoxPreference)getPreferenceScreen().atx("fps_decorator_preference");
            paramf.setEnabled(true);
            Apt.bTy = true;
            if (paramf.isChecked())
            {
              Apt.show();
            }
            else
            {
              Apt.dismiss();
              Apt.bTy = false;
            }
          }
          else
          {
            paramPreference.zB();
            Apt.dismiss();
            Apt.bTy = false;
            ((CheckBoxPreference)getPreferenceScreen().atx("fps_decorator_preference")).setEnabled(false);
          }
        }
        else if (str.equalsIgnoreCase("methodBeat_preference"))
        {
          paramPreference = com.tencent.matrix.trace.b.zr();
          if (paramf.isChecked()) {
            paramPreference.onStart();
          } else {
            paramPreference.onStop();
          }
        }
        else if (str.equalsIgnoreCase("fps_decorator_preference"))
        {
          if (!dNp())
          {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 2);
          }
          else
          {
            Apt.bTy = true;
            if (paramf.isChecked())
            {
              Apt.show();
            }
            else
            {
              Apt.dismiss();
              Apt.bTy = false;
            }
          }
        }
        else if (str.equalsIgnoreCase("trace_dev_preference"))
        {
          localb.bQN.bQX = paramf.isChecked();
        }
      }
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