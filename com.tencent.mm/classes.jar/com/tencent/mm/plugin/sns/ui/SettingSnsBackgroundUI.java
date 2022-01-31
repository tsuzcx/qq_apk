package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;
import java.util.List;

public class SettingSnsBackgroundUI
  extends MMPreference
{
  protected String filePath;
  private f screen;
  private SharedPreferences sp;
  
  private void bEq()
  {
    AppMethodBeat.i(38567);
    if (!com.tencent.mm.pluginsdk.ui.tools.n.c(this, com.tencent.mm.compatible.util.e.esr, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131303074), 1).show();
    }
    AppMethodBeat.o(38567);
  }
  
  private void k(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(38563);
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      ab.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
      AppMethodBeat.o(38563);
      return;
    case 2: 
      ab.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, ag.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(38563);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      localObject1 = com.tencent.mm.a.g.w((this.filePath + System.currentTimeMillis()).getBytes());
      paramIntent.putExtra("CropImage_OutputPath", ag.getAccSnsTmpPath() + (String)localObject1);
      com.tencent.mm.plugin.sns.c.a.gmO.a(this, paramIntent, 6);
      AppMethodBeat.o(38563);
      return;
    case 5: 
      ab.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(38563);
        return;
      }
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.n.h(getApplicationContext(), paramIntent, ag.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(38563);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 1);
      ((Intent)localObject1).putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.sns.c.a.gmO.a(this, paramIntent, (Intent)localObject1, ag.getAccSnsTmpPath(), 6, new SettingSnsBackgroundUI.1(this));
      AppMethodBeat.o(38563);
      return;
    }
    ab.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
    new ak(Looper.getMainLooper()).post(new SettingSnsBackgroundUI.2(this));
    if (paramIntent == null)
    {
      AppMethodBeat.o(38563);
      return;
    }
    this.filePath = paramIntent.getStringExtra("CropImage_OutputPath");
    if (this.filePath == null)
    {
      AppMethodBeat.o(38563);
      return;
    }
    ab.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
    Object localObject1 = ag.cpb();
    paramIntent = this.filePath;
    new LinkedList().add(new com.tencent.mm.plugin.sns.data.h(paramIntent, 2));
    if ((((ax)localObject1).coK() != null) && (!((ax)localObject1).coK().equals("")))
    {
      Object localObject2 = ao.gl(ag.getAccSnsPath(), ((ax)localObject1).coK());
      com.tencent.mm.vfs.e.um((String)localObject2);
      com.tencent.mm.vfs.e.deleteFile((String)localObject2 + ((ax)localObject1).coK() + "bg_");
      com.tencent.mm.vfs.e.C(paramIntent, (String)localObject2 + ((ax)localObject1).coK() + "bg_");
      localObject2 = ag.cpj();
      l locall = ((m)localObject2).abz(((ax)localObject1).coK());
      locall.field_bgId = "";
      ((m)localObject2).c(locall);
    }
    ((ax)localObject1).cpN();
    ((ax)localObject1).coK();
    localObject1 = new ay(7);
    ((ay)localObject1).gq(paramIntent, "");
    ((ay)localObject1).DT(1);
    ((ay)localObject1).commit();
    setResult(-1);
    finish();
    AppMethodBeat.o(38563);
  }
  
  public int getResourceId()
  {
    return 2131165294;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38565);
    setMMTitle(2131303437);
    SnsArtistPreference localSnsArtistPreference = (SnsArtistPreference)this.screen.atx("settings_sns_bg_select_bg");
    if (localSnsArtistPreference != null)
    {
      String str = this.sp.getString("artist_name", "");
      ab.d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(str)));
      localSnsArtistPreference.rNM = str;
      localSnsArtistPreference.cuM();
      this.screen.notifyDataSetChanged();
    }
    setBackBtn(new SettingSnsBackgroundUI.5(this));
    AppMethodBeat.o(38565);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38564);
    ab.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + paramInt1 + " " + paramInt2);
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 5) || (paramInt1 == 6)) {
        new ak(Looper.getMainLooper()).post(new SettingSnsBackgroundUI.3(this));
      }
      AppMethodBeat.o(38564);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("result ok ");
    com.tencent.mm.kernel.g.RM();
    ab.d("MicroMsg.SettingSnsBackgroundUI", com.tencent.mm.kernel.g.RJ().QU());
    if (ag.coN())
    {
      new ak(Looper.myLooper()).postDelayed(new SettingSnsBackgroundUI.4(this, paramInt1, paramInt2, paramIntent), 2000L);
      AppMethodBeat.o(38564);
      return;
    }
    ab.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
    k(paramInt1, paramIntent);
    AppMethodBeat.o(38564);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38559);
    ab.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.sp = getSharedPreferences(ah.dsP(), 0);
    initView();
    AppMethodBeat.o(38559);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38561);
    super.onDestroy();
    ab.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    AppMethodBeat.o(38561);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(38560);
    ab.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    setResult(-1);
    finish();
    AppMethodBeat.o(38560);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(38566);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.SettingSnsBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_sns_bg_select_from_album"))
    {
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        t.ii(this);
        AppMethodBeat.o(38566);
        return false;
      }
      com.tencent.mm.pluginsdk.ui.tools.n.a(this, 5, null);
      AppMethodBeat.o(38566);
      return true;
    }
    if (paramf.equals("settings_sns_bg_take_photo"))
    {
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        t.ii(this);
        AppMethodBeat.o(38566);
        return false;
      }
      boolean bool = b.a(getContext(), "android.permission.CAMERA", 16, "", "");
      ab.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(38566);
        return false;
      }
      bEq();
      AppMethodBeat.o(38566);
      return true;
    }
    if (paramf.equals("settings_sns_bg_select_bg"))
    {
      startActivity(new Intent(this, ArtistUI.class));
      AppMethodBeat.o(38566);
      return true;
    }
    AppMethodBeat.o(38566);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38568);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(38568);
      return;
    }
    ab.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38568);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        bEq();
        AppMethodBeat.o(38568);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new SettingSnsBackgroundUI.6(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38562);
    super.onResume();
    if (this.screen != null) {
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(38562);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI
 * JD-Core Version:    0.7.0.1
 */