package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class WalletOfflineEntranceUI
  extends WalletBaseUI
{
  boolean AMV;
  private boolean AMW;
  private IListener<ip> AMX;
  private int mEntryScene;
  private int mScene;
  
  public WalletOfflineEntranceUI()
  {
    AppMethodBeat.i(66540);
    this.AMV = true;
    this.mEntryScene = -1;
    this.AMW = false;
    this.AMX = new IListener() {};
    AppMethodBeat.o(66540);
  }
  
  private void eAg()
  {
    AppMethodBeat.i(66542);
    Log.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
    k.aeJ(1);
    f.aqm(30);
    eAi();
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
        this.AMV = false;
        AppMethodBeat.o(66542);
        return;
      }
    }
    init();
    this.AMV = false;
    AppMethodBeat.o(66542);
  }
  
  private int eAh()
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
        h.CyF.a(14021, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
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
  
  private void eAi()
  {
    AppMethodBeat.i(66550);
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_from_scene", 0);
      Log.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(i)));
      if (i == 3)
      {
        com.tencent.mm.plugin.offline.c.a.ANf = i;
        i = getIntent().getIntExtra("key_expire_time", 0);
        long l = getIntent().getLongExtra("key_begin_time", 0L);
        boolean bool = getIntent().getBooleanExtra("key_is_mark", false);
        Log.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + i + " beginTime:" + l + " isMark:" + bool);
        com.tencent.mm.plugin.offline.c.a.ANg = i;
        com.tencent.mm.plugin.offline.c.a.ANh = l;
        com.tencent.mm.plugin.offline.c.a.ANi = bool;
        com.tencent.mm.plugin.offline.c.a.pQH = getIntent().getStringExtra("key_card_id");
        com.tencent.mm.plugin.offline.c.a.ANj = getIntent().getStringExtra("key_user_card_id");
        com.tencent.mm.plugin.offline.c.a.ANk = getIntent().getStringExtra("key_card_code");
        AppMethodBeat.o(66550);
        return;
      }
      if ((i == 1) || (i == 2) || (i == 4))
      {
        com.tencent.mm.plugin.offline.c.a.ANf = i;
        com.tencent.mm.plugin.offline.c.a.ANg = 0;
        com.tencent.mm.plugin.offline.c.a.ANh = 0L;
        com.tencent.mm.plugin.offline.c.a.ANi = false;
        com.tencent.mm.plugin.offline.c.a.pQH = "";
        com.tencent.mm.plugin.offline.c.a.ANj = "";
        com.tencent.mm.plugin.offline.c.a.ANk = "";
      }
    }
    AppMethodBeat.o(66550);
  }
  
  private void init()
  {
    AppMethodBeat.i(66545);
    eAh();
    if (t.fQI().fRp())
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
      doSceneProgress(new ad(null, 8), true);
      this.AMV = false;
      AppMethodBeat.o(66545);
      return;
    }
    if (this.mKindaEnable) {
      com.tencent.mm.wallet_core.b.hgC();
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
    c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", localIntent, 1);
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
      com.tencent.mm.wallet_core.c.b.hhj().init(getApplicationContext());
      this.AMX.alive();
      eAg();
      paramBundle = SecDataUIC.CWq;
      paramBundle = (chc)SecDataUIC.a.b(this, 3, chc.class);
      if ((paramBundle != null) && ("launch_type_offline_wallet".equals(paramBundle.Mmm)))
      {
        paramBundle = new ks();
        paramBundle.elF = 1L;
        paramBundle.eXj = 1L;
        paramBundle.bfK();
        com.tencent.mm.util.b localb = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(paramBundle);
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
    this.AMX.dead();
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
      this.AMV = true;
      this.AMW = true;
      setIntent(paramIntent);
      eAg();
      AppMethodBeat.o(66551);
      return;
    }
    this.AMV = false;
    this.AMW = true;
    setIntent(paramIntent);
    eAg();
    AppMethodBeat.o(66551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66546);
    super.onResume();
    Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
    if (this.AMV)
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
      if (com.tencent.mm.plugin.offline.c.a.eAj())
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
    this.AMV = true;
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
        e.bfP(((d)paramq).fPP());
        init();
        if ((this.mScene == 6) || (this.mScene == 7))
        {
          paramString = new Intent();
          if (!this.AMW) {
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