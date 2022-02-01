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
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.a.a;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;
import java.util.List;

public class SettingSnsBackgroundUI
  extends MMPreference
{
  protected String filePath;
  private f screen;
  private SharedPreferences sp;
  
  private void cNE()
  {
    AppMethodBeat.i(98255);
    if (!q.d(this, com.tencent.mm.loader.j.b.aps(), "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
      Toast.makeText(this, getString(2131763022), 1).show();
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
      ac.e("MicroMsg.SettingSnsBackgroundUI", "onActivityResult: not found this requestCode");
      AppMethodBeat.o(98251);
      return;
    case 2: 
      ac.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_TAKE_PICTURE");
      this.filePath = q.h(getApplicationContext(), paramIntent, af.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      paramIntent = new Intent();
      paramIntent.putExtra("CropImageMode", 1);
      paramIntent.putExtra("CropImage_ImgPath", this.filePath);
      localObject1 = com.tencent.mm.b.g.getMessageDigest((this.filePath + System.currentTimeMillis()).getBytes());
      paramIntent.putExtra("CropImage_OutputPath", af.getAccSnsTmpPath() + (String)localObject1);
      com.tencent.mm.plugin.sns.c.a.iyx.a(this, paramIntent, 6);
      AppMethodBeat.o(98251);
      return;
    case 5: 
      ac.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
      if (paramIntent == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      this.filePath = q.h(getApplicationContext(), paramIntent, af.getAccSnsTmpPath());
      if (this.filePath == null)
      {
        AppMethodBeat.o(98251);
        return;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("CropImageMode", 1);
      ((Intent)localObject1).putExtra("CropImage_ImgPath", this.filePath);
      com.tencent.mm.plugin.sns.c.a.iyx.a(this, paramIntent, (Intent)localObject1, af.getAccSnsTmpPath(), 6, new a.a()
      {
        public final String avE(String paramAnonymousString)
        {
          AppMethodBeat.i(98241);
          paramAnonymousString = com.tencent.mm.b.g.getMessageDigest((SettingSnsBackgroundUI.this.filePath + System.currentTimeMillis()).getBytes());
          paramAnonymousString = af.getAccSnsTmpPath() + paramAnonymousString;
          AppMethodBeat.o(98241);
          return paramAnonymousString;
        }
      });
      AppMethodBeat.o(98251);
      return;
    }
    ac.d("MicroMsg.SettingSnsBackgroundUI", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98242);
        com.tencent.mm.plugin.sns.c.a.iyy.Ll();
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
    ac.d("MicroMsg.SettingSnsBackgroundUI", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM   " + this.filePath);
    Object localObject1 = af.dHN();
    paramIntent = this.filePath;
    new LinkedList().add(new p(paramIntent, 2));
    if ((((ba)localObject1).dHx() != null) && (!((ba)localObject1).dHx().equals("")))
    {
      Object localObject2 = an.jc(af.getAccSnsPath(), ((ba)localObject1).dHx());
      i.aSh((String)localObject2);
      i.deleteFile((String)localObject2 + ((ba)localObject1).dHx() + "bg_");
      i.lZ(paramIntent, (String)localObject2 + ((ba)localObject1).dHx() + "bg_");
      localObject2 = af.dHV();
      n localn = ((o)localObject2).auY(((ba)localObject1).dHx());
      localn.field_bgId = "";
      ((o)localObject2).c(localn);
    }
    ((ba)localObject1).dIR();
    ((ba)localObject1).dHx();
    localObject1 = new bb(7);
    ((bb)localObject1).jh(paramIntent, "");
    ((bb)localObject1).Ov(1);
    ((bb)localObject1).commit();
    setResult(-1);
    finish();
    AppMethodBeat.o(98251);
  }
  
  public int getResourceId()
  {
    return 2131951738;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98253);
    setMMTitle(2131763419);
    SnsArtistPreference localSnsArtistPreference = (SnsArtistPreference)this.screen.aPN("settings_sns_bg_select_bg");
    if (localSnsArtistPreference != null)
    {
      String str = this.sp.getString("artist_name", "");
      ac.d("MicroMsg.SettingSnsBackgroundUI", "artistName".concat(String.valueOf(str)));
      localSnsArtistPreference.yIv = str;
      localSnsArtistPreference.dPh();
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
    ac.i("MicroMsg.SettingSnsBackgroundUI", "onAcvityResult requestCode:" + paramInt1 + " " + paramInt2);
    if (paramInt2 != -1)
    {
      if ((paramInt1 == 2) || (paramInt1 == 5) || (paramInt1 == 6)) {
        new ao(Looper.getMainLooper()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98243);
            com.tencent.mm.plugin.sns.c.a.iyy.Ll();
            AppMethodBeat.o(98243);
          }
        });
      }
      AppMethodBeat.o(98252);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("result ok ");
    com.tencent.mm.kernel.g.agS();
    ac.d("MicroMsg.SettingSnsBackgroundUI", com.tencent.mm.kernel.g.agP().afY());
    if (af.dHA())
    {
      new ao(Looper.myLooper()).postDelayed(new Runnable()
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
    ac.d("MicroMsg.SettingSnsBackgroundUI", "isInValid ok");
    l(paramInt1, paramIntent);
    AppMethodBeat.o(98252);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98247);
    ac.d("MicroMsg.SettingSnsBackgroundUI", "onCreate");
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    this.sp = getSharedPreferences(ai.eUX(), 0);
    initView();
    AppMethodBeat.o(98247);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98249);
    super.onDestroy();
    ac.d("MicroMsg.SettingSnsBackgroundUI", "onDestroy");
    AppMethodBeat.o(98249);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(98248);
    ac.d("MicroMsg.SettingSnsBackgroundUI", "onNewIntent");
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
    ac.i("MicroMsg.SettingSnsBackgroundUI", paramf + " item has been clicked!");
    if (paramf.equals("settings_sns_bg_select_from_album"))
    {
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        t.g(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      q.c(this, 5, null);
      AppMethodBeat.o(98254);
      return true;
    }
    if (paramf.equals("settings_sns_bg_take_photo"))
    {
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
      {
        t.g(this, null);
        AppMethodBeat.o(98254);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(getContext(), "android.permission.CAMERA", 16, "", "");
      ac.i("MicroMsg.SettingSnsBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), getContext() });
      if (!bool)
      {
        AppMethodBeat.o(98254);
        return false;
      }
      cNE();
      AppMethodBeat.o(98254);
      return true;
    }
    if (paramf.equals("settings_sns_bg_select_bg"))
    {
      paramf = new Intent(this, ArtistUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.aeD(), "com/tencent/mm/plugin/sns/ui/SettingSnsBackgroundUI", "setSelectBg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lR(0));
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
      ac.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(98256);
      return;
    }
    ac.i("MicroMsg.SettingSnsBackgroundUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98256);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        cNE();
        AppMethodBeat.o(98256);
        return;
      }
      h.a(this, getString(2131761860), getString(2131761885), getString(2131760598), getString(2131755691), false, new SettingSnsBackgroundUI.6(this), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SettingSnsBackgroundUI
 * JD-Core Version:    0.7.0.1
 */