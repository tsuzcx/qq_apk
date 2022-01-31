package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gr;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(7)
public class WalletOfflineEntranceUI
  extends WalletBaseUI
{
  private int gyl;
  private int mScene;
  boolean pnX;
  private boolean pnY;
  private c<gr> pnZ;
  
  public WalletOfflineEntranceUI()
  {
    AppMethodBeat.i(43634);
    this.pnX = true;
    this.gyl = -1;
    this.pnY = false;
    this.pnZ = new WalletOfflineEntranceUI.1(this);
    AppMethodBeat.o(43634);
  }
  
  private void bZt()
  {
    AppMethodBeat.i(43636);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
    com.tencent.mm.plugin.wallet_core.model.m.Iy(1);
    e.RX(30);
    bZv();
    this.mScene = getIntent().getIntExtra("key_from_scene", 0);
    if ((!getIntent().getBooleanExtra("is_offline_create", false)) && ((this.mScene == 6) || (this.mScene == 7)))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", new Object[] { Integer.valueOf(this.mScene) });
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
        doSceneProgress((com.tencent.mm.ai.m)localObject, true);
        this.pnX = false;
        AppMethodBeat.o(43636);
        return;
      }
    }
    init();
    this.pnX = false;
    AppMethodBeat.o(43636);
  }
  
  private void bZu()
  {
    int i = 3;
    AppMethodBeat.i(43638);
    Intent localIntent = getIntent();
    int j;
    if ((localIntent != null) && (localIntent.hasExtra("key_from_scene")))
    {
      j = localIntent.getIntExtra("key_from_scene", 0);
      if (j != 1) {
        break label78;
      }
      this.gyl = 1;
      i = 2;
    }
    for (;;)
    {
      h.qsU.e(14021, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(43638);
      return;
      label78:
      if (j == 2)
      {
        this.gyl = 2;
        i = 1;
      }
      else if (j == 3)
      {
        this.gyl = 3;
      }
      else if (j == 4)
      {
        this.gyl = 4;
        i = 6;
      }
      else if (j == 5)
      {
        this.gyl = 8;
        i = 4;
      }
      else if (j == 6)
      {
        this.gyl = 10;
        i = 7;
      }
      else if (j == 7)
      {
        this.gyl = 11;
        i = 8;
      }
      else if (j == 8)
      {
        this.gyl = 12;
        i = 9;
      }
      else
      {
        this.gyl = 0;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[] { Integer.valueOf(j) });
        i = 1;
      }
    }
  }
  
  private void bZv()
  {
    AppMethodBeat.i(43644);
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_from_scene", 0);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(i)));
      if (i == 3)
      {
        com.tencent.mm.plugin.offline.c.a.poh = i;
        i = getIntent().getIntExtra("key_expire_time", 0);
        long l = getIntent().getLongExtra("key_begin_time", 0L);
        boolean bool = getIntent().getBooleanExtra("key_is_mark", false);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + i + " beginTime:" + l + " isMark:" + bool);
        com.tencent.mm.plugin.offline.c.a.poi = i;
        com.tencent.mm.plugin.offline.c.a.poj = l;
        com.tencent.mm.plugin.offline.c.a.pok = bool;
        com.tencent.mm.plugin.offline.c.a.kkW = getIntent().getStringExtra("key_card_id");
        com.tencent.mm.plugin.offline.c.a.pol = getIntent().getStringExtra("key_user_card_id");
        com.tencent.mm.plugin.offline.c.a.pom = getIntent().getStringExtra("key_card_code");
        AppMethodBeat.o(43644);
        return;
      }
      if ((i == 1) || (i == 2) || (i == 4))
      {
        com.tencent.mm.plugin.offline.c.a.poh = i;
        com.tencent.mm.plugin.offline.c.a.poi = 0;
        com.tencent.mm.plugin.offline.c.a.poj = 0L;
        com.tencent.mm.plugin.offline.c.a.pok = false;
        com.tencent.mm.plugin.offline.c.a.kkW = "";
        com.tencent.mm.plugin.offline.c.a.pol = "";
        com.tencent.mm.plugin.offline.c.a.pom = "";
      }
    }
    AppMethodBeat.o(43644);
  }
  
  private void init()
  {
    AppMethodBeat.i(43639);
    bZu();
    if (t.cTN().cUq())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
      doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ab(null, 8), true);
      this.pnX = false;
      AppMethodBeat.o(43639);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_entry_scene", this.gyl);
    localIntent.putExtra("key_from_scene", this.mScene);
    String str = getIntent().getStringExtra("key_business_attach");
    if (!bo.isNullOrNil(str)) {
      localIntent.putExtra("key_business_attach", str);
    }
    localIntent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
    localIntent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
    com.tencent.mm.bq.d.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", localIntent, 1);
    AppMethodBeat.o(43639);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(43641);
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(43641);
      return;
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43635);
    super.onCreate(paramBundle);
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
      b.dSi().init(getApplicationContext());
      this.pnZ.alive();
      bZt();
      AppMethodBeat.o(43635);
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        getWindow().addFlags(67108864);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43637);
    super.onDestroy();
    this.pnZ.dead();
    AppMethodBeat.o(43637);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(43643);
    if (paramInt == 4) {
      finish();
    }
    AppMethodBeat.o(43643);
    return true;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(43645);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
    if ((paramIntent != null) && (paramIntent.hasExtra("is_offline_create")))
    {
      this.pnX = true;
      this.pnY = true;
      setIntent(paramIntent);
      bZt();
      AppMethodBeat.o(43645);
      return;
    }
    this.pnX = false;
    this.pnY = true;
    setIntent(paramIntent);
    bZt();
    AppMethodBeat.o(43645);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(43640);
    super.onResume();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
    if (this.pnX)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
      if (com.tencent.mm.plugin.offline.c.a.bZw())
      {
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_entry_scene", this.gyl);
        localIntent.putExtra("key_from_scene", 0);
        AppMethodBeat.o(43640);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
      AppMethodBeat.o(43640);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
    this.pnX = true;
    AppMethodBeat.o(43640);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(43642);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
        g.ana(((com.tencent.mm.plugin.wallet_core.c.d)paramm).cSW());
        init();
        if ((this.mScene == 6) || (this.mScene == 7))
        {
          paramString = new Intent();
          if (!this.pnY) {
            break label103;
          }
          paramString.putExtra("key_callback", "return");
        }
        for (;;)
        {
          setResult(-1, paramString);
          AppMethodBeat.o(43642);
          return true;
          label103:
          paramString.putExtra("key_callback", "ok");
        }
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((this.mScene == 6) || (this.mScene == 7))
      {
        paramString = new Intent();
        paramString.putExtra("key_callback", "fail");
        setResult(0, paramString);
      }
      finish();
      AppMethodBeat.o(43642);
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
      init();
      AppMethodBeat.o(43642);
      return true;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    init();
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
    finish();
    AppMethodBeat.o(43642);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI
 * JD-Core Version:    0.7.0.1
 */