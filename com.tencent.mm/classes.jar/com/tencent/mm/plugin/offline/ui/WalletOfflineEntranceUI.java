package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@com.tencent.mm.ui.base.a(7)
public class WalletOfflineEntranceUI
  extends WalletBaseUI
{
  private int mEntryScene;
  private int mScene;
  boolean wRa;
  private boolean wRb;
  private c<ia> wRc;
  
  public WalletOfflineEntranceUI()
  {
    AppMethodBeat.i(66540);
    this.wRa = true;
    this.mEntryScene = -1;
    this.wRb = false;
    this.wRc = new c() {};
    AppMethodBeat.o(66540);
  }
  
  private void dAv()
  {
    AppMethodBeat.i(66542);
    ae.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
    k.Wf(1);
    f.aha(30);
    dAx();
    this.mScene = getIntent().getIntExtra("key_from_scene", 0);
    if ((!getIntent().getBooleanExtra("is_offline_create", false)) && ((this.mScene == 6) || (this.mScene == 7)))
    {
      ae.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", new Object[] { Integer.valueOf(this.mScene) });
      Object localObject = getIntent();
      String str1 = ((Intent)localObject).getStringExtra("appId");
      String str2 = ((Intent)localObject).getStringExtra("timeStamp");
      String str3 = ((Intent)localObject).getStringExtra("nonceStr");
      String str4 = ((Intent)localObject).getStringExtra("packageExt");
      String str5 = ((Intent)localObject).getStringExtra("signtype");
      String str6 = ((Intent)localObject).getStringExtra("paySignature");
      int i = ((Intent)localObject).getIntExtra("pay_channel", 0);
      if (this.mScene == 6) {}
      for (localObject = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, ((Intent)localObject).getStringExtra("url"), 16, "openOfflinePayView", i);; localObject = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, 16, ((Intent)localObject).getStringExtra("wxapp_username"), ((Intent)localObject).getStringExtra("wxapp_path"), "openOfflinePayView", i))
      {
        addSceneEndListener(580);
        doSceneProgress((n)localObject, true);
        this.wRa = false;
        AppMethodBeat.o(66542);
        return;
      }
    }
    init();
    this.wRa = false;
    AppMethodBeat.o(66542);
  }
  
  private int dAw()
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
        g.yxI.f(14021, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
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
          ae.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[] { Integer.valueOf(j) });
          i = 1;
        }
      }
    }
    AppMethodBeat.o(66544);
    return 0;
  }
  
  private void dAx()
  {
    AppMethodBeat.i(66550);
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_from_scene", 0);
      ae.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(i)));
      if (i == 3)
      {
        com.tencent.mm.plugin.offline.c.a.wRk = i;
        i = getIntent().getIntExtra("key_expire_time", 0);
        long l = getIntent().getLongExtra("key_begin_time", 0L);
        boolean bool = getIntent().getBooleanExtra("key_is_mark", false);
        ae.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + i + " beginTime:" + l + " isMark:" + bool);
        com.tencent.mm.plugin.offline.c.a.wRl = i;
        com.tencent.mm.plugin.offline.c.a.wRm = l;
        com.tencent.mm.plugin.offline.c.a.wRn = bool;
        com.tencent.mm.plugin.offline.c.a.oCY = getIntent().getStringExtra("key_card_id");
        com.tencent.mm.plugin.offline.c.a.wRo = getIntent().getStringExtra("key_user_card_id");
        com.tencent.mm.plugin.offline.c.a.wRp = getIntent().getStringExtra("key_card_code");
        AppMethodBeat.o(66550);
        return;
      }
      if ((i == 1) || (i == 2) || (i == 4))
      {
        com.tencent.mm.plugin.offline.c.a.wRk = i;
        com.tencent.mm.plugin.offline.c.a.wRl = 0;
        com.tencent.mm.plugin.offline.c.a.wRm = 0L;
        com.tencent.mm.plugin.offline.c.a.wRn = false;
        com.tencent.mm.plugin.offline.c.a.oCY = "";
        com.tencent.mm.plugin.offline.c.a.wRo = "";
        com.tencent.mm.plugin.offline.c.a.wRp = "";
      }
    }
    AppMethodBeat.o(66550);
  }
  
  private void init()
  {
    AppMethodBeat.i(66545);
    dAw();
    if (t.eJf().eJM())
    {
      ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
      doSceneProgress(new ad(null, 8), true);
      this.wRa = false;
      AppMethodBeat.o(66545);
      return;
    }
    if (this.mKindaEnable) {
      com.tencent.mm.wallet_core.b.fVf();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_entry_scene", this.mEntryScene);
    localIntent.putExtra("key_from_scene", this.mScene);
    String str = getIntent().getStringExtra("key_business_attach");
    if (!bu.isNullOrNil(str)) {
      localIntent.putExtra("key_business_attach", str);
    }
    localIntent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
    localIntent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
    com.tencent.mm.br.d.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", localIntent, 1);
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
      ae.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
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
      com.tencent.mm.wallet_core.c.b.fVM().init(getApplicationContext());
      this.wRc.alive();
      dAv();
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
    this.wRc.dead();
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
    ae.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
    if ((paramIntent != null) && (paramIntent.hasExtra("is_offline_create")))
    {
      this.wRa = true;
      this.wRb = true;
      setIntent(paramIntent);
      dAv();
      AppMethodBeat.o(66551);
      return;
    }
    this.wRa = false;
    this.wRb = true;
    setIntent(paramIntent);
    dAv();
    AppMethodBeat.o(66551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66546);
    super.onResume();
    ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
    if (this.wRa)
    {
      ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
      if (com.tencent.mm.plugin.offline.c.a.dAy())
      {
        ae.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_entry_scene", this.mEntryScene);
        localIntent.putExtra("key_from_scene", 0);
        AppMethodBeat.o(66546);
        return;
      }
      ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
      AppMethodBeat.o(66546);
      return;
    }
    ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
    this.wRa = true;
    AppMethodBeat.o(66546);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(66548);
    if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
        e.aPm(((com.tencent.mm.plugin.wallet_core.c.d)paramn).eIm());
        init();
        if ((this.mScene == 6) || (this.mScene == 7))
        {
          paramString = new Intent();
          if (!this.wRb) {
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
      ae.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      ae.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
      init();
      AppMethodBeat.o(66548);
      return true;
    }
    ae.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    init();
    ae.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI
 * JD-Core Version:    0.7.0.1
 */