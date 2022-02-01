package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.a;
import com.tencent.mm.be.s;
import com.tencent.mm.be.w;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsChattingBackgroundUI
  extends MMPreference
{
  private boolean Jha;
  private com.tencent.mm.ui.base.preference.f screen;
  private String username;
  
  private void euy()
  {
    AppMethodBeat.i(74135);
    if (!u.d(this, com.tencent.mm.loader.j.b.aSX(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(b.i.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(74135);
  }
  
  private String xR(boolean paramBoolean)
  {
    AppMethodBeat.i(74137);
    w.bnU();
    if (this.Jha)
    {
      str = s.V("default", paramBoolean);
      AppMethodBeat.o(74137);
      return str;
    }
    String str = s.V(this.username, paramBoolean);
    AppMethodBeat.o(74137);
    return str;
  }
  
  public int getResourceId()
  {
    return b.k.settings_chatting_background;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74133);
    setMMTitle(b.i.settings_chatting_bg);
    this.screen = getPreferenceScreen();
    this.Jha = getIntent().getBooleanExtra("isApplyToAll", true);
    if (!this.Jha)
    {
      Preference localPreference = this.screen.byG("settings_chatting_bg_apply_to_all");
      if (localPreference != null) {
        this.screen.d(localPreference);
      }
    }
    this.username = getIntent().getStringExtra("username");
    setBackBtn(new SettingsChattingBackgroundUI.1(this));
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
        if (!this.Jha)
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
        ((Intent)localObject).putExtra("CropImage_bg_vertical", xR(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", xR(false));
        c.mIG.a(this, paramIntent, (Intent)localObject, d.bbW(), 4, null);
        AppMethodBeat.o(74132);
        return;
        paramIntent = u.g(getApplicationContext(), paramIntent, d.bbW());
        if (paramIntent == null)
        {
          AppMethodBeat.o(74132);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", xR(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", xR(false));
        c.mIG.a(this, (Intent)localObject, 4);
        AppMethodBeat.o(74132);
        return;
        if (paramInt2 == -1)
        {
          com.tencent.mm.kernel.h.aHG().aHp().i(66820, Integer.valueOf(-1));
          com.tencent.mm.plugin.report.service.h.IzE.a(10198, new Object[] { Integer.valueOf(-1) });
          Log.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[] { Integer.valueOf(-1) });
          if (this.Jha)
          {
            com.tencent.mm.kernel.h.aHG().aHp().i(12311, Integer.valueOf(-1));
            w.bnU().wH(1);
          }
          else
          {
            paramIntent = w.bnV();
            localObject = paramIntent.WM(this.username);
            if (localObject == null)
            {
              localObject = new a();
              ((a)localObject).username = this.username;
              ((a)localObject).lXh = -1;
              paramIntent.a((a)localObject);
            }
            else
            {
              ((a)localObject).lXh = -1;
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74134);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingsChattingBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_chatting_bg_select_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSelectBgUI.class);
      paramf.putExtra("isApplyToAll", this.Jha);
      paramf.putExtra("username", this.username);
      startActivityForResult(paramf, 3);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_select_from_album"))
    {
      u.d(this, 1, null);
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
      euy();
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_apply_to_all"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), getString(b.i.settings_chatting_bg_apply_to_all), "", new SettingsChattingBackgroundUI.3(this), null);
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
        euy();
        AppMethodBeat.o(74136);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(b.i.permission_camera_request_again_msg), getString(b.i.permission_tips_title), getString(b.i.jump_to_settings), getString(b.i.app_cancel), false, new SettingsChattingBackgroundUI.2(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI
 * JD-Core Version:    0.7.0.1
 */