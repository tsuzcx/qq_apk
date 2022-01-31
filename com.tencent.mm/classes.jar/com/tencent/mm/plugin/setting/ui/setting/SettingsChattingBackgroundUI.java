package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

public class SettingsChattingBackgroundUI
  extends MMPreference
{
  private f dnn;
  private boolean nUd;
  private String username;
  
  private void awX()
  {
    if (!l.c(this, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(a.i.selectcameraapp_none), 1).show();
    }
  }
  
  private String iE(boolean paramBoolean)
  {
    r.PK();
    if (this.nUd) {
      return n.H("default", paramBoolean);
    }
    return n.H(this.username, paramBoolean);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.SettingsChattingBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_chatting_bg_select_bg"))
    {
      paramf = new Intent();
      paramf.setClass(this, SettingsSelectBgUI.class);
      paramf.putExtra("isApplyToAll", this.nUd);
      paramf.putExtra("username", this.username);
      startActivityForResult(paramf, 3);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_select_from_album"))
    {
      l.a(this, 1, null);
      return true;
    }
    if (paramf.equals("settings_chatting_bg_take_photo"))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this.mController.uMN, "android.permission.CAMERA", 16, "", "");
      y.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.mController.uMN });
      if (!bool) {
        return false;
      }
      awX();
      return true;
    }
    if (paramf.equals("settings_chatting_bg_apply_to_all"))
    {
      com.tencent.mm.ui.base.h.a(this.mController.uMN, getString(a.i.settings_chatting_bg_apply_to_all), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, null);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_chatting_bg);
    this.dnn = this.vdd;
    this.nUd = getIntent().getBooleanExtra("isApplyToAll", true);
    if (!this.nUd)
    {
      Preference localPreference = this.dnn.add("settings_chatting_bg_apply_to_all");
      if (localPreference != null) {
        this.dnn.c(localPreference);
      }
    }
    this.username = getIntent().getStringExtra("username");
    setBackBtn(new SettingsChattingBackgroundUI.1(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        if (!this.nUd)
        {
          setResult(-1);
          finish();
        }
        do
        {
          do
          {
            return;
          } while (paramIntent == null);
          localObject = new Intent();
          ((Intent)localObject).putExtra("CropImageMode", 2);
          ((Intent)localObject).putExtra("CropImage_bg_vertical", iE(true));
          ((Intent)localObject).putExtra("CropImage_bg_horizontal", iE(false));
          com.tencent.mm.plugin.setting.b.eUR.a(this, paramIntent, (Intent)localObject, c.FG(), 4, null);
          return;
          paramIntent = l.f(getApplicationContext(), paramIntent, c.FG());
        } while (paramIntent == null);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 2);
        ((Intent)localObject).putExtra("CropImage_ImgPath", paramIntent);
        ((Intent)localObject).putExtra("CropImage_bg_vertical", iE(true));
        ((Intent)localObject).putExtra("CropImage_bg_horizontal", iE(false));
        com.tencent.mm.plugin.setting.b.eUR.a(this, (Intent)localObject, 4);
        return;
        if (paramInt2 == -1)
        {
          g.DP().Dz().o(66820, Integer.valueOf(-1));
          com.tencent.mm.plugin.report.service.h.nFQ.f(10198, new Object[] { Integer.valueOf(-1) });
          y.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[] { Integer.valueOf(-1) });
          if (this.nUd)
          {
            g.DP().Dz().o(12311, Integer.valueOf(-1));
            r.PK().iY(1);
          }
          else
          {
            paramIntent = r.PL();
            localObject = paramIntent.mI(this.username);
            if (localObject == null)
            {
              localObject = new com.tencent.mm.az.a();
              ((com.tencent.mm.az.a)localObject).username = this.username;
              ((com.tencent.mm.az.a)localObject).ewu = -1;
              paramIntent.a((com.tencent.mm.az.a)localObject);
            }
            else
            {
              ((com.tencent.mm.az.a)localObject).ewu = -1;
              paramIntent.b((com.tencent.mm.az.a)localObject);
            }
          }
        }
      }
    } while (paramInt2 == -1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.SettingsChattingBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      awX();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(a.i.permission_camera_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new SettingsChattingBackgroundUI.2(this), null);
  }
  
  public final int xj()
  {
    return a.k.settings_chatting_background;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI
 * JD-Core Version:    0.7.0.1
 */