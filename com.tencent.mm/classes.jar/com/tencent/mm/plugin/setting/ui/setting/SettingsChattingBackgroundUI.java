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
import com.tencent.mm.bc.a;
import com.tencent.mm.bc.p;
import com.tencent.mm.bc.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingBackgroundUI
  extends MMPreference
{
  private f screen;
  private String username;
  private boolean yGA;
  
  private void cVW()
  {
    AppMethodBeat.i(74135);
    if (!q.d(this, com.tencent.mm.loader.j.b.asg(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131763022), 1).show();
    }
    AppMethodBeat.o(74135);
  }
  
  private String qR(boolean paramBoolean)
  {
    AppMethodBeat.i(74137);
    t.aJZ();
    if (this.yGA)
    {
      str = p.T("default", paramBoolean);
      AppMethodBeat.o(74137);
      return str;
    }
    String str = p.T(this.username, paramBoolean);
    AppMethodBeat.o(74137);
    return str;
  }
  
  public int getResourceId()
  {
    return 2131951718;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74133);
    setMMTitle(2131763196);
    this.screen = getPreferenceScreen();
    this.yGA = getIntent().getBooleanExtra("isApplyToAll", true);
    if (!this.yGA)
    {
      Preference localPreference = this.screen.aVD("settings_chatting_bg_apply_to_all");
      if (localPreference != null) {
        this.screen.d(localPreference);
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
        if (!this.yGA)
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
        ((Intent)localObject).putExtra("CropImage_bg_vertical", qR(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", qR(false));
        com.tencent.mm.plugin.setting.b.iRG.a(this, paramIntent, (Intent)localObject, d.azA(), 4, null);
        AppMethodBeat.o(74132);
        return;
        paramIntent = q.i(getApplicationContext(), paramIntent, d.azA());
        if (paramIntent == null)
        {
          AppMethodBeat.o(74132);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", qR(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", qR(false));
        com.tencent.mm.plugin.setting.b.iRG.a(this, (Intent)localObject, 4);
        AppMethodBeat.o(74132);
        return;
        if (paramInt2 == -1)
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(66820, Integer.valueOf(-1));
          com.tencent.mm.plugin.report.service.g.yhR.f(10198, new Object[] { Integer.valueOf(-1) });
          ad.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[] { Integer.valueOf(-1) });
          if (this.yGA)
          {
            com.tencent.mm.kernel.g.ajC().ajl().set(12311, Integer.valueOf(-1));
            t.aJZ().pP(1);
          }
          else
          {
            paramIntent = t.aKa();
            localObject = paramIntent.Gb(this.username);
            if (localObject == null)
            {
              localObject = new a();
              ((a)localObject).username = this.username;
              ((a)localObject).iiM = -1;
              paramIntent.a((a)localObject);
            }
            else
            {
              ((a)localObject).iiM = -1;
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
    ad.i("MicroMsg.SettingsChattingBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_chatting_bg_select_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSelectBgUI.class);
      paramf.putExtra("isApplyToAll", this.yGA);
      paramf.putExtra("username", this.username);
      startActivityForResult(paramf, 3);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_select_from_album"))
    {
      q.c(this, 1, null);
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_take_photo"))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
      ad.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bt.flS(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(74134);
        return false;
      }
      cVW();
      AppMethodBeat.o(74134);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_apply_to_all"))
    {
      h.a(getContext(), getString(2131763197), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(74129);
          SettingsChattingBackgroundUI.dNG();
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
      ad.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(74136);
      return;
    }
    ad.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74136);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cVW();
        AppMethodBeat.o(74136);
        return;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new SettingsChattingBackgroundUI.2(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI
 * JD-Core Version:    0.7.0.1
 */