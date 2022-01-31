package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsChattingBackgroundUI
  extends MMPreference
{
  private boolean qId;
  private f screen;
  private String username;
  
  private void bEq()
  {
    AppMethodBeat.i(127205);
    if (!com.tencent.mm.pluginsdk.ui.tools.n.c(this, com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131303074), 1).show();
    }
    AppMethodBeat.o(127205);
  }
  
  private String kI(boolean paramBoolean)
  {
    AppMethodBeat.i(127207);
    r.aiP();
    if (this.qId)
    {
      str = com.tencent.mm.ba.n.L("default", paramBoolean);
      AppMethodBeat.o(127207);
      return str;
    }
    String str = com.tencent.mm.ba.n.L(this.username, paramBoolean);
    AppMethodBeat.o(127207);
    return str;
  }
  
  public int getResourceId()
  {
    return 2131165274;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127203);
    setMMTitle(2131303228);
    this.screen = getPreferenceScreen();
    this.qId = getIntent().getBooleanExtra("isApplyToAll", true);
    if (!this.qId)
    {
      Preference localPreference = this.screen.atx("settings_chatting_bg_apply_to_all");
      if (localPreference != null) {
        this.screen.d(localPreference);
      }
    }
    this.username = getIntent().getStringExtra("username");
    setBackBtn(new SettingsChattingBackgroundUI.1(this));
    AppMethodBeat.o(127203);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127202);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        if (!this.qId)
        {
          setResult(-1);
          finish();
        }
        AppMethodBeat.o(127202);
        return;
        if (paramIntent == null)
        {
          AppMethodBeat.o(127202);
          return;
        }
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", kI(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", kI(false));
        com.tencent.mm.plugin.setting.b.gmO.a(this, paramIntent, (Intent)localObject, c.YK(), 4, null);
        AppMethodBeat.o(127202);
        return;
        paramIntent = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, c.YK());
        if (paramIntent == null)
        {
          AppMethodBeat.o(127202);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", kI(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", kI(false));
        com.tencent.mm.plugin.setting.b.gmO.a(this, (Intent)localObject, 4);
        AppMethodBeat.o(127202);
        return;
        if (paramInt2 == -1)
        {
          g.RL().Ru().set(66820, Integer.valueOf(-1));
          com.tencent.mm.plugin.report.service.h.qsU.e(10198, new Object[] { Integer.valueOf(-1) });
          ab.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[] { Integer.valueOf(-1) });
          if (this.qId)
          {
            g.RL().Ru().set(12311, Integer.valueOf(-1));
            r.aiP().lQ(1);
          }
          else
          {
            paramIntent = r.aiQ();
            localObject = paramIntent.tS(this.username);
            if (localObject == null)
            {
              localObject = new a();
              ((a)localObject).username = this.username;
              ((a)localObject).fMk = -1;
              paramIntent.a((a)localObject);
            }
            else
            {
              ((a)localObject).fMk = -1;
              paramIntent.b((a)localObject);
            }
          }
        }
      }
    } while (paramInt2 == -1);
    AppMethodBeat.o(127202);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127200);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127200);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127201);
    super.onDestroy();
    AppMethodBeat.o(127201);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127204);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.SettingsChattingBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_chatting_bg_select_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSelectBgUI.class);
      paramf.putExtra("isApplyToAll", this.qId);
      paramf.putExtra("username", this.username);
      startActivityForResult(paramf, 3);
      AppMethodBeat.o(127204);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_select_from_album"))
    {
      com.tencent.mm.pluginsdk.ui.tools.n.a(this, 1, null);
      AppMethodBeat.o(127204);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_take_photo"))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
      ab.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(127204);
        return false;
      }
      bEq();
      AppMethodBeat.o(127204);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_apply_to_all"))
    {
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131303229), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127199);
          SettingsChattingBackgroundUI.ckj();
          AppMethodBeat.o(127199);
        }
      }, null);
      AppMethodBeat.o(127204);
      return true;
    }
    AppMethodBeat.o(127204);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(127206);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(127206);
      return;
    }
    ab.i("MicroMsg.SettingsChattingBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(127206);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bEq();
        AppMethodBeat.o(127206);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new SettingsChattingBackgroundUI.2(this), null);
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