package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public class SettingSnsBackgroundUI
  extends MMPreference
{
  private SharedPreferences dnD;
  private f dnn;
  protected String filePath;
  
  private void awX()
  {
    if (!com.tencent.mm.pluginsdk.ui.tools.l.c(this, com.tencent.mm.compatible.util.e.dzD, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(i.j.selectcameraapp_none), 1).show();
    }
  }
  
  private void e(int paramInt, Intent paramIntent)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      y.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              y.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
              this.filePath = com.tencent.mm.pluginsdk.ui.tools.l.f(getApplicationContext(), paramIntent, af.getAccSnsTmpPath());
            } while (this.filePath == null);
            paramIntent = new Intent();
            paramIntent.putExtra("CropImageMode", 1);
            paramIntent.putExtra("CropImage_ImgPath", this.filePath);
            localObject1 = com.tencent.mm.a.g.o((this.filePath + System.currentTimeMillis()).getBytes());
            paramIntent.putExtra("CropImage_OutputPath", af.getAccSnsTmpPath() + (String)localObject1);
            com.tencent.mm.plugin.sns.c.a.eUR.a(this, paramIntent, 6);
            return;
            y.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
          } while (paramIntent == null);
          this.filePath = com.tencent.mm.pluginsdk.ui.tools.l.f(getApplicationContext(), paramIntent, af.getAccSnsTmpPath());
        } while (this.filePath == null);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("CropImageMode", 1);
        ((Intent)localObject1).putExtra("CropImage_ImgPath", this.filePath);
        com.tencent.mm.plugin.sns.c.a.eUR.a(this, paramIntent, (Intent)localObject1, af.getAccSnsTmpPath(), 6, new SettingSnsBackgroundUI.1(this));
        return;
        y.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
        new ah(Looper.getMainLooper()).post(new SettingSnsBackgroundUI.2(this));
      } while (paramIntent == null);
      this.filePath = paramIntent.getStringExtra("CropImage_OutputPath");
    } while (this.filePath == null);
    y.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
    Object localObject1 = af.bDB();
    paramIntent = this.filePath;
    new LinkedList().add(new com.tencent.mm.plugin.sns.data.h(paramIntent, 2));
    if ((((aw)localObject1).bDl() != null) && (!((aw)localObject1).bDl().equals("")))
    {
      Object localObject2 = an.eJ(af.getAccSnsPath(), ((aw)localObject1).bDl());
      com.tencent.mm.vfs.e.nb((String)localObject2);
      com.tencent.mm.vfs.e.deleteFile((String)localObject2 + ((aw)localObject1).bDl() + "bg_");
      com.tencent.mm.vfs.e.r(paramIntent, (String)localObject2 + ((aw)localObject1).bDl() + "bg_");
      localObject2 = af.bDJ();
      com.tencent.mm.plugin.sns.storage.l locall = ((com.tencent.mm.plugin.sns.storage.m)localObject2).OF(((aw)localObject1).bDl());
      locall.field_bgId = "";
      ((com.tencent.mm.plugin.sns.storage.m)localObject2).c(locall);
    }
    ((aw)localObject1).bEo();
    ((aw)localObject1).bDl();
    localObject1 = new ax(7);
    ((ax)localObject1).eO(paramIntent, "");
    ((ax)localObject1).xT(1);
    ((ax)localObject1).commit();
    setResult(-1);
    finish();
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.SettingSnsBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_sns_bg_select_from_album"))
    {
      com.tencent.mm.kernel.g.DQ();
      if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable()) {
        com.tencent.mm.ui.base.s.gM(this);
      }
    }
    do
    {
      boolean bool;
      do
      {
        return false;
        com.tencent.mm.pluginsdk.ui.tools.l.a(this, 5, null);
        return true;
        if (!paramf.equals("settings_sns_bg_take_photo")) {
          break;
        }
        com.tencent.mm.kernel.g.DQ();
        if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.gM(this);
          return false;
        }
        bool = com.tencent.mm.pluginsdk.permission.a.a(this.mController.uMN, "android.permission.CAMERA", 16, "", "");
        y.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.mController.uMN });
      } while (!bool);
      awX();
      return true;
    } while (!paramf.equals("settings_sns_bg_select_bg"));
    startActivity(new Intent(this, ArtistUI.class));
    return true;
  }
  
  protected final void initView()
  {
    setMMTitle(i.j.settings_sns_bg_title);
    SnsArtistPreference localSnsArtistPreference = (SnsArtistPreference)this.dnn.add("settings_sns_bg_select_bg");
    if (localSnsArtistPreference != null)
    {
      String str = this.dnD.getString("artist_name", "");
      y.d("MicroMsg.SettingSnsBackgroundUI", "artistName" + str);
      localSnsArtistPreference.oVr = str;
      localSnsArtistPreference.bIs();
      this.dnn.notifyDataSetChanged();
    }
    setBackBtn(new SettingSnsBackgroundUI.5(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + paramInt1 + " " + paramInt2);
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 5) || (paramInt1 == 6)) {
        new ah(Looper.getMainLooper()).post(new SettingSnsBackgroundUI.3(this));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("result ok ");
    com.tencent.mm.kernel.g.DQ();
    y.d("MicroMsg.SettingSnsBackgroundUI", com.tencent.mm.kernel.g.DN().Dc());
    if (af.bDo())
    {
      new ah(Looper.myLooper()).postDelayed(new SettingSnsBackgroundUI.4(this, paramInt1, paramInt2, paramIntent), 2000L);
      return;
    }
    y.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
    e(paramInt1, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    y.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    this.dnD = getSharedPreferences(ae.cqR(), 0);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    setResult(-1);
    finish();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      y.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult grantResults[%s] invalid", new Object[] { paramArrayOfInt });
      return;
    }
    y.i("MicroMsg.SettingSnsBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
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
    com.tencent.mm.ui.base.h.a(this, getString(i.j.permission_camera_request_again_msg), getString(i.j.permission_tips_title), getString(i.j.jump_to_settings), getString(i.j.app_cancel), false, new SettingSnsBackgroundUI.6(this), null);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.dnn != null) {
      this.dnn.notifyDataSetChanged();
    }
  }
  
  public final int xj()
  {
    return i.m.settings_sns_background;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI
 * JD-Core Version:    0.7.0.1
 */