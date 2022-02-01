package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.a;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingBackgroundUI
  extends MMPreference
{
  private boolean Dbz;
  private f screen;
  private String username;
  
  private void dRW()
  {
    AppMethodBeat.i(74135);
    if (!s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131765171), 1).show();
    }
    AppMethodBeat.o(74135);
  }
  
  private String ut(boolean paramBoolean)
  {
    AppMethodBeat.i(74137);
    v.bev();
    if (this.Dbz)
    {
      str = r.T("default", paramBoolean);
      AppMethodBeat.o(74137);
      return str;
    }
    String str = r.T(this.username, paramBoolean);
    AppMethodBeat.o(74137);
    return str;
  }
  
  public int getResourceId()
  {
    return 2132017263;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74133);
    setMMTitle(2131765364);
    this.screen = getPreferenceScreen();
    this.Dbz = getIntent().getBooleanExtra("isApplyToAll", true);
    if (!this.Dbz)
    {
      Preference localPreference = this.screen.bmg("settings_chatting_bg_apply_to_all");
      if (localPreference != null) {
        this.screen.e(localPreference);
      }
    }
    this.username = getIntent().getStringExtra("username");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74127);
        SettingsChattingBackgroundUI.this.hideVKB();
        SettingsChattingBackgroundUI.this.finish();
        AppMethodBeat.o(74127);
        return true;
      }
    });
    AppMethodBeat.o(74133);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74132);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        if (!this.Dbz)
        {
          setResult(-1);
          finish();
        }
        AppMethodBeat.o(74132);
        return;
        if (paramIntent == null)
        {
          AppMethodBeat.o(74132);
          return;
        }
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", ut(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", ut(false));
        c.jRt.a(this, paramIntent, (Intent)localObject, d.aSY(), 4, null);
        AppMethodBeat.o(74132);
        return;
        paramIntent = s.h(getApplicationContext(), paramIntent, d.aSY());
        if (paramIntent == null)
        {
          AppMethodBeat.o(74132);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", ut(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", ut(false));
        c.jRt.a(this, (Intent)localObject, 4);
        AppMethodBeat.o(74132);
        return;
        if (paramInt2 == -1)
        {
          g.aAh().azQ().set(66820, Integer.valueOf(-1));
          com.tencent.mm.plugin.report.service.h.CyF.a(10198, new Object[] { Integer.valueOf(-1) });
          Log.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[] { Integer.valueOf(-1) });
          if (this.Dbz)
          {
            g.aAh().azQ().set(12311, Integer.valueOf(-1));
            v.bev().tH(1);
          }
          else
          {
            paramIntent = v.bew();
            localObject = paramIntent.Pp(this.username);
            if (localObject == null)
            {
              localObject = new a();
              ((a)localObject).username = this.username;
              ((a)localObject).jgE = -1;
              paramIntent.a((a)localObject);
            }
            else
            {
              ((a)localObject).jgE = -1;
              paramIntent.b((a)localObject);
            }
          }
        }
      }
    } while (paramInt2 == -1);
    AppMethodBeat.o(74132);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74130);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74130);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74131);
    super.onDestroy();
    AppMethodBeat.o(74131);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74134);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsChattingBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_chatting_bg_select_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSelectBgUI.class);
      paramf.putExtra("isApplyToAll", this.Dbz);
      paramf.putExtra("username", this.username);
      startActivityForResult(paramf, 3);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_select_from_album"))
    {
      s.c(this, 1, null);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_take_photo"))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
      Log.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(74134);
        return false;
      }
      dRW();
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_apply_to_all"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131765365), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74129);
          SettingsChattingBackgroundUI.eTe();
          AppMethodBeat.o(74129);
        }
      }, null);
      AppMethodBeat.o(74134);
      return true;
    }
    AppMethodBeat.o(74134);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(74136);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(74136);
      return;
    }
    Log.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74136);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dRW();
        AppMethodBeat.o(74136);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new SettingsChattingBackgroundUI.2(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI
 * JD-Core Version:    0.7.0.1
 */