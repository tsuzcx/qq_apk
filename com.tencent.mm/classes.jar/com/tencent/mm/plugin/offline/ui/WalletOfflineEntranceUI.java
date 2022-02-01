package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.jf;
import com.tencent.mm.f.b.a.no;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(7)
public class WalletOfflineEntranceUI
  extends WalletBaseUI
{
  boolean GGj;
  private boolean GGk;
  private IListener<jf> GGl;
  private int mEntryScene;
  private int mScene;
  
  public WalletOfflineEntranceUI()
  {
    AppMethodBeat.i(66540);
    this.GGj = true;
    this.mEntryScene = -1;
    this.GGk = false;
    this.GGl = new IListener() {};
    AppMethodBeat.o(66540);
  }
  
  private void flK()
  {
    AppMethodBeat.i(66542);
    Log.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
    k.amw(1);
    g.azK(30);
    flM();
    this.mScene = getIntent().getIntExtra("key_from_scene", 0);
    if ((!getIntent().getBooleanExtra("is_offline_create", false)) && ((this.mScene == 6) || (this.mScene == 7)))
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", new Object[] { Integer.valueOf(this.mScene) });
      Object localObject = getIntent();
      String str1 = ((Intent)localObject).getStringExtra("appId");
      String str2 = ((Intent)localObject).getStringExtra("timeStamp");
      String str3 = ((Intent)localObject).getStringExtra("nonceStr");
      String str4 = ((Intent)localObject).getStringExtra("packageExt");
      String str5 = ((Intent)localObject).getStringExtra("signtype");
      String str6 = ((Intent)localObject).getStringExtra("paySignature");
      int i = ((Intent)localObject).getIntExtra("pay_channel", 0);
      if (this.mScene == 6) {}
      for (localObject = new d(str1, str2, str3, str4, str5, str6, ((Intent)localObject).getStringExtra("url"), 16, "openOfflinePayView", i);; localObject = new d(str1, str2, str3, str4, str5, str6, 16, ((Intent)localObject).getStringExtra("wxapp_username"), ((Intent)localObject).getStringExtra("wxapp_path"), "openOfflinePayView", i))
      {
        addSceneEndListener(580);
        doSceneProgress((q)localObject, true);
        this.GGj = false;
        AppMethodBeat.o(66542);
        return;
      }
    }
    init();
    this.GGj = false;
    AppMethodBeat.o(66542);
  }
  
  private int flL()
  {
    int i = 3;
    AppMethodBeat.i(66544);
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_from_scene")))
    {
      int j = localIntent.getIntExtra("key_from_scene", 0);
      if (j == 1)
      {
        this.mEntryScene = 1;
        i = 2;
      }
      for (;;)
      {
        h.IzE.a(14021, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
        AppMethodBeat.o(66544);
        return i;
        if (j == 2)
        {
          this.mEntryScene = 2;
          i = 1;
        }
        else if (j == 3)
        {
          this.mEntryScene = 3;
        }
        else if (j == 4)
        {
          this.mEntryScene = 4;
          i = 6;
        }
        else if (j == 5)
        {
          this.mEntryScene = 8;
          i = 4;
        }
        else if (j == 6)
        {
          this.mEntryScene = 10;
          i = 7;
        }
        else if (j == 7)
        {
          this.mEntryScene = 11;
          i = 8;
        }
        else if (j == 8)
        {
          this.mEntryScene = 12;
          i = 9;
        }
        else
        {
          this.mEntryScene = 0;
          Log.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[] { Integer.valueOf(j) });
          i = 1;
        }
      }
    }
    AppMethodBeat.o(66544);
    return 0;
  }
  
  private void flM()
  {
    AppMethodBeat.i(66550);
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_from_scene", 0);
      Log.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(i)));
      if (i == 3)
      {
        com.tencent.mm.plugin.offline.c.a.GGt = i;
        i = getIntent().getIntExtra("key_expire_time", 0);
        long l = getIntent().getLongExtra("key_begin_time", 0L);
        boolean bool = getIntent().getBooleanExtra("key_is_mark", false);
        Log.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + i + " beginTime:" + l + " isMark:" + bool);
        com.tencent.mm.plugin.offline.c.a.GGu = i;
        com.tencent.mm.plugin.offline.c.a.GGv = l;
        com.tencent.mm.plugin.offline.c.a.GGw = bool;
        com.tencent.mm.plugin.offline.c.a.tmG = getIntent().getStringExtra("key_card_id");
        com.tencent.mm.plugin.offline.c.a.GGx = getIntent().getStringExtra("key_user_card_id");
        com.tencent.mm.plugin.offline.c.a.GGy = getIntent().getStringExtra("key_card_code");
        AppMethodBeat.o(66550);
        return;
      }
      if ((i == 1) || (i == 2) || (i == 4))
      {
        com.tencent.mm.plugin.offline.c.a.GGt = i;
        com.tencent.mm.plugin.offline.c.a.GGu = 0;
        com.tencent.mm.plugin.offline.c.a.GGv = 0L;
        com.tencent.mm.plugin.offline.c.a.GGw = false;
        com.tencent.mm.plugin.offline.c.a.tmG = "";
        com.tencent.mm.plugin.offline.c.a.GGx = "";
        com.tencent.mm.plugin.offline.c.a.GGy = "";
      }
    }
    AppMethodBeat.o(66550);
  }
  
  private void init()
  {
    AppMethodBeat.i(66545);
    flL();
    if ((u.gJo().gJV()) || (u.gJo().OnP == null))
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
      doSceneProgress(new ae(null, 8), true);
      this.GGj = false;
      AppMethodBeat.o(66545);
      return;
    }
    if (this.mKindaEnable) {
      com.tencent.mm.wallet_core.b.iie();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_entry_scene", this.mEntryScene);
    localIntent.putExtra("key_from_scene", this.mScene);
    String str = getIntent().getStringExtra("key_business_attach");
    if (!Util.isNullOrNil(str)) {
      localIntent.putExtra("key_business_attach", str);
    }
    localIntent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
    localIntent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
    com.tencent.mm.by.c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", localIntent, 1);
    AppMethodBeat.o(66545);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66547);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(66547);
      return;
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66541);
    super.onCreate(paramBundle);
    if (26 != Build.VERSION.SDK_INT) {
      setRequestedOrientation(1);
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.clearFlags(67108864);
      paramBundle.getDecorView().setSystemUiVisibility(1280);
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(0);
    }
    for (;;)
    {
      com.tencent.mm.wallet_core.c.b.iiL().init(getApplicationContext());
      this.GGl.alive();
      flK();
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.JbV;
      paramBundle = (cpy)a.a.b(this, 3, cpy.class);
      if ((paramBundle != null) && ("launch_type_offline_wallet".equals(paramBundle.Txg)))
      {
        paramBundle = new no();
        paramBundle.ggN = 1L;
        paramBundle.gZO = 1L;
        paramBundle.bpa();
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a(paramBundle);
      }
      AppMethodBeat.o(66541);
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        getWindow().addFlags(67108864);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66543);
    super.onDestroy();
    this.GGl.dead();
    AppMethodBeat.o(66543);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(66549);
    if (paramInt == 4) {
      finish();
    }
    AppMethodBeat.o(66549);
    return true;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(66551);
    Log.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
    if ((paramIntent != null) && (paramIntent.hasExtra("is_offline_create")))
    {
      this.GGj = true;
      this.GGk = true;
      setIntent(paramIntent);
      flK();
      AppMethodBeat.o(66551);
      return;
    }
    this.GGj = false;
    this.GGk = true;
    setIntent(paramIntent);
    flK();
    AppMethodBeat.o(66551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66546);
    super.onResume();
    Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
    if (this.GGj)
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
      if (com.tencent.mm.plugin.offline.c.a.flN())
      {
        Log.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_entry_scene", this.mEntryScene);
        localIntent.putExtra("key_from_scene", 0);
        AppMethodBeat.o(66546);
        return;
      }
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
      AppMethodBeat.o(66546);
      return;
    }
    Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
    this.GGj = true;
    AppMethodBeat.o(66546);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(66548);
    if ((paramq instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
        e.bsi(((d)paramq).gIv());
        init();
        if ((this.mScene == 6) || (this.mScene == 7))
        {
          paramString = new Intent();
          if (!this.GGk) {
            break label103;
          }
          paramString.putExtra("key_callback", "return");
        }
        for (;;)
        {
          setResult(-1, paramString);
          AppMethodBeat.o(66548);
          return true;
          label103:
          paramString.putExtra("key_callback", "ok");
        }
      }
      Log.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((this.mScene == 6) || (this.mScene == 7))
      {
        paramString = new Intent();
        paramString.putExtra("key_callback", "fail");
        setResult(0, paramString);
      }
      finish();
      AppMethodBeat.o(66548);
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
      init();
      AppMethodBeat.o(66548);
      return true;
    }
    Log.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    init();
    Log.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
    finish();
    AppMethodBeat.o(66548);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI
 * JD-Core Version:    0.7.0.1
 */