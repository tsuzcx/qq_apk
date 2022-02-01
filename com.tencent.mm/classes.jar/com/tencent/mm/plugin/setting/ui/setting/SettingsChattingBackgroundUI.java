package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.a;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsChattingBackgroundUI
  extends MMPreference
{
  private boolean PsF;
  private com.tencent.mm.ui.base.preference.f screen;
  private String username;
  
  private String CL(boolean paramBoolean)
  {
    AppMethodBeat.i(74137);
    u.bLH();
    if (this.PsF)
    {
      str = com.tencent.mm.modelpackage.t.Z("default", paramBoolean);
      AppMethodBeat.o(74137);
      return str;
    }
    String str = com.tencent.mm.modelpackage.t.Z(this.username, paramBoolean);
    AppMethodBeat.o(74137);
    return str;
  }
  
  private void fBt()
  {
    AppMethodBeat.i(74135);
    if (!com.tencent.mm.pluginsdk.ui.tools.t.d(this, com.tencent.mm.loader.i.b.bmx(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(com.tencent.mm.plugin.setting.b.i.selectcameraapp_none), 1).show();
    }
    AppMethodBeat.o(74135);
  }
  
  private boolean gVG()
  {
    AppMethodBeat.i(299166);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "");
    Log.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), getContext() });
    if (!bool)
    {
      AppMethodBeat.o(299166);
      return false;
    }
    fBt();
    AppMethodBeat.o(299166);
    return true;
  }
  
  public int getResourceId()
  {
    return b.k.settings_chatting_background;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74133);
    setMMTitle(com.tencent.mm.plugin.setting.b.i.settings_chatting_bg);
    this.screen = getPreferenceScreen();
    this.PsF = getIntent().getBooleanExtra("isApplyToAll", true);
    if (!this.PsF)
    {
      Preference localPreference = this.screen.bAi("settings_chatting_bg_apply_to_all");
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
        if (!this.PsF)
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
        ((Intent)localObject).putExtra("CropImage_bg_vertical", CL(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", CL(false));
        c.pFn.a(this, paramIntent, (Intent)localObject, d.bzL(), null);
        AppMethodBeat.o(74132);
        return;
        paramIntent = com.tencent.mm.pluginsdk.ui.tools.t.g(getApplicationContext(), paramIntent, d.bzL());
        if (paramIntent == null)
        {
          AppMethodBeat.o(74132);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", CL(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", CL(false));
        c.pFn.a(this, (Intent)localObject, 4);
        AppMethodBeat.o(74132);
        return;
        if (paramInt2 == -1)
        {
          com.tencent.mm.kernel.h.baE().ban().B(66820, Integer.valueOf(-1));
          com.tencent.mm.plugin.report.service.h.OAn.b(10198, new Object[] { Integer.valueOf(-1) });
          Log.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[] { Integer.valueOf(-1) });
          if (this.PsF)
          {
            com.tencent.mm.kernel.h.baE().ban().B(12311, Integer.valueOf(-1));
            u.bLH().wI(1);
          }
          else
          {
            paramIntent = u.bLI();
            localObject = paramIntent.OM(this.username);
            if (localObject == null)
            {
              localObject = new a();
              ((a)localObject).username = this.username;
              ((a)localObject).oQj = -1;
              paramIntent.a((a)localObject);
            }
            else
            {
              ((a)localObject).oQj = -1;
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
      paramf.putExtra("isApplyToAll", this.PsF);
      paramf.putExtra("username", this.username);
      startActivityForResult(paramf, 3);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_select_from_album"))
    {
      com.tencent.mm.pluginsdk.ui.tools.t.d(this, 1, null);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_take_photo"))
    {
      boolean bool = gVG();
      AppMethodBeat.o(74134);
      return bool;
    }
    if (paramf.equals("settings_chatting_bg_apply_to_all"))
    {
      k.a(getContext(), getString(com.tencent.mm.plugin.setting.b.i.settings_chatting_bg_apply_to_all), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(299340);
          SettingsChattingBackgroundUI.gVH();
          AppMethodBeat.o(299340);
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
        fBt();
        AppMethodBeat.o(74136);
        return;
      }
      k.a(this, getString(com.tencent.mm.plugin.setting.b.i.permission_camera_request_again_msg), getString(com.tencent.mm.plugin.setting.b.i.permission_tips_title), getString(com.tencent.mm.plugin.setting.b.i.jump_to_settings), getString(com.tencent.mm.plugin.setting.b.i.app_cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74128);
          com.tencent.mm.pluginsdk.permission.b.lx(SettingsChattingBackgroundUI.this.getContext());
          AppMethodBeat.o(74128);
        }
      }, null);
      AppMethodBeat.o(74136);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        gVG();
        AppMethodBeat.o(74136);
        return;
      }
      k.a(this, getString(com.tencent.mm.plugin.gallery.b.i.permission_gallery_request_again_msg), getString(com.tencent.mm.plugin.gallery.b.i.permission_tips_title), getString(com.tencent.mm.plugin.gallery.b.i.jump_to_settings), getString(com.tencent.mm.plugin.gallery.b.i.gallery_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74129);
          com.tencent.mm.pluginsdk.permission.b.lx(SettingsChattingBackgroundUI.this.getContext());
          AppMethodBeat.o(74129);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
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