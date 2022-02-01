package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.a.a;
import java.util.LinkedList;
import java.util.List;

public class SettingSnsBackgroundUI
  extends MMPreference
{
  protected String filePath;
  private f screen;
  private SharedPreferences sp;
  
  private void dRW()
  {
    AppMethodBeat.i(98255);
    if (!com.tencent.mm.pluginsdk.ui.tools.s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131765171), 1).show();
    }
    AppMethodBeat.o(98255);
  }
  
  private void l(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(98251);
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      Log.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
      AppMethodBeat.o(98251);
      return;
    case 2: 
      Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.s.h(getApplicationContext(), paramIntent, aj.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      localObject1 = com.tencent.mm.b.g.getMessageDigest((this.filePath + System.currentTimeMillis()).getBytes());
      paramIntent.putExtra("CropImage_OutputPath", aj.getAccSnsTmpPath() + (String)localObject1);
      com.tencent.mm.plugin.sns.c.a.jRt.a(this, paramIntent, 6);
      AppMethodBeat.o(98251);
      return;
    case 5: 
      Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      this.filePath = com.tencent.mm.pluginsdk.ui.tools.s.h(getApplicationContext(), paramIntent, aj.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 1);
      ((Intent)localObject1).putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.sns.c.a.jRt.a(this, paramIntent, (Intent)localObject1, aj.getAccSnsTmpPath(), 6, new a.a()
      {
        public final String aQX(String paramAnonymousString)
        {
          AppMethodBeat.i(98241);
          paramAnonymousString = com.tencent.mm.b.g.getMessageDigest((SettingSnsBackgroundUI.this.filePath + System.currentTimeMillis()).getBytes());
          paramAnonymousString = aj.getAccSnsTmpPath() + paramAnonymousString;
          AppMethodBeat.o(98241);
          return paramAnonymousString;
        }
      });
      AppMethodBeat.o(98251);
      return;
    }
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98242);
        com.tencent.mm.plugin.sns.c.a.jRu.Xb();
        AppMethodBeat.o(98242);
      }
    });
    if (paramIntent == null)
    {
      AppMethodBeat.o(98251);
      return;
    }
    this.filePath = paramIntent.getStringExtra("CropImage_OutputPath");
    if (this.filePath == null)
    {
      AppMethodBeat.o(98251);
      return;
    }
    Log.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
    Object localObject1 = aj.faK();
    paramIntent = this.filePath;
    new LinkedList().add(new q(paramIntent, 2));
    if ((((be)localObject1).fau() != null) && (!((be)localObject1).fau().equals("")))
    {
      Object localObject2 = ar.ki(aj.getAccSnsPath(), ((be)localObject1).fau());
      com.tencent.mm.vfs.s.boN((String)localObject2);
      com.tencent.mm.vfs.s.deleteFile((String)localObject2 + ((be)localObject1).fau() + "bg_");
      com.tencent.mm.vfs.s.nw(paramIntent, (String)localObject2 + ((be)localObject1).fau() + "bg_");
      localObject2 = aj.faS();
      com.tencent.mm.plugin.sns.storage.l locall = ((com.tencent.mm.plugin.sns.storage.m)localObject2).aQr(((be)localObject1).fau());
      locall.field_bgId = "";
      ((com.tencent.mm.plugin.sns.storage.m)localObject2).c(locall);
    }
    ((be)localObject1).fbT();
    ((be)localObject1).fau();
    localObject1 = new bf(7);
    ((bf)localObject1).kn(paramIntent, "");
    ((bf)localObject1).YH(1);
    ((bf)localObject1).commit();
    setResult(-1);
    finish();
    AppMethodBeat.o(98251);
  }
  
  public int getResourceId()
  {
    return 2132017283;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98253);
    setMMTitle(2131765601);
    SnsArtistPreference localSnsArtistPreference = (SnsArtistPreference)this.screen.bmg("settings_sns_bg_select_bg");
    if (localSnsArtistPreference != null)
    {
      String str = this.sp.getString("artist_name", "");
      Log.d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(str)));
      localSnsArtistPreference.EAb = str;
      localSnsArtistPreference.fhz();
      this.screen.notifyDataSetChanged();
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(98245);
        SettingSnsBackgroundUI.this.finish();
        AppMethodBeat.o(98245);
        return true;
      }
    });
    AppMethodBeat.o(98253);
  }
  
  public void onActivityResult(final int paramInt1, final int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(98252);
    Log.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + paramInt1 + " " + paramInt2);
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 5) || (paramInt1 == 6)) {
        new MMHandler(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98243);
            com.tencent.mm.plugin.sns.c.a.jRu.Xb();
            AppMethodBeat.o(98243);
          }
        });
      }
      AppMethodBeat.o(98252);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("result ok ");
    com.tencent.mm.kernel.g.aAi();
    Log.d("MicroMsg.SettingSnsBackgroundUI", com.tencent.mm.kernel.g.aAf().azp());
    if (aj.isInValid())
    {
      new MMHandler(Looper.myLooper()).postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98244);
          SettingSnsBackgroundUI.a(SettingSnsBackgroundUI.this, paramInt1, paramIntent);
          AppMethodBeat.o(98244);
        }
      }, 2000L);
      AppMethodBeat.o(98252);
      return;
    }
    Log.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
    l(paramInt1, paramIntent);
    AppMethodBeat.o(98252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98247);
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.sp = getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    initView();
    AppMethodBeat.o(98247);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98249);
    super.onDestroy();
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    AppMethodBeat.o(98249);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(98248);
    Log.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    setResult(-1);
    finish();
    AppMethodBeat.o(98248);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(98254);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.SettingSnsBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_sns_bg_select_from_album"))
    {
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        u.g(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      com.tencent.mm.pluginsdk.ui.tools.s.c(this, 5, null);
      AppMethodBeat.o(98254);
      return true;
    }
    if (paramf.equals("settings_sns_bg_take_photo"))
    {
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
      {
        u.g(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
      Log.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(98254);
        return false;
      }
      dRW();
      AppMethodBeat.o(98254);
      return true;
    }
    if (paramf.equals("settings_sns_bg_select_bg"))
    {
      paramf = new Intent(this, ArtistUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(98254);
      return true;
    }
    AppMethodBeat.o(98254);
    return false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(98256);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(98256);
      return;
    }
    Log.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98256);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dRW();
        AppMethodBeat.o(98256);
        return;
      }
      h.a(this, getString(2131763864), getString(2131763890), getString(2131762043), getString(2131755761), false, new SettingSnsBackgroundUI.6(this), null);
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98250);
    super.onResume();
    if (this.screen != null) {
      this.screen.notifyDataSetChanged();
    }
    AppMethodBeat.o(98250);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI
 * JD-Core Version:    0.7.0.1
 */