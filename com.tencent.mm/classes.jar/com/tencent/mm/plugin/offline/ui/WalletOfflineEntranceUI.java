package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.gm;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@com.tencent.mm.ui.base.a(7)
public class WalletOfflineEntranceUI
  extends WalletBaseUI
{
  private int fgD = -1;
  private int fzn;
  boolean mNI = true;
  private boolean mNJ = false;
  private c<gm> mNK = new WalletOfflineEntranceUI.1(this);
  
  private void bqG()
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
    i.AN(1);
    e.Jc(30);
    int i;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    if (getIntent() != null)
    {
      i = getIntent().getIntExtra("key_from_scene", 0);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is " + i);
      if (i == 3)
      {
        com.tencent.mm.plugin.offline.c.a.mNS = i;
        i = getIntent().getIntExtra("key_expire_time", 0);
        long l = getIntent().getLongExtra("key_begin_time", 0L);
        boolean bool = getIntent().getBooleanExtra("key_is_mark", false);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + i + " beginTime:" + l + " isMark:" + bool);
        com.tencent.mm.plugin.offline.c.a.mNT = i;
        com.tencent.mm.plugin.offline.c.a.mNU = l;
        com.tencent.mm.plugin.offline.c.a.mNV = bool;
        com.tencent.mm.plugin.offline.c.a.ijW = getIntent().getStringExtra("key_card_id");
        com.tencent.mm.plugin.offline.c.a.mNW = getIntent().getStringExtra("key_user_card_id");
        com.tencent.mm.plugin.offline.c.a.mNX = getIntent().getStringExtra("key_card_code");
      }
    }
    else
    {
      this.fzn = getIntent().getIntExtra("key_from_scene", 0);
      if ((getIntent().getBooleanExtra("is_offline_create", false)) || ((this.fzn != 6) && (this.fzn != 7))) {
        break label475;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", new Object[] { Integer.valueOf(this.fzn) });
      localObject = getIntent();
      str1 = ((Intent)localObject).getStringExtra("appId");
      str2 = ((Intent)localObject).getStringExtra("timeStamp");
      str3 = ((Intent)localObject).getStringExtra("nonceStr");
      str4 = ((Intent)localObject).getStringExtra("packageExt");
      str5 = ((Intent)localObject).getStringExtra("signtype");
      str6 = ((Intent)localObject).getStringExtra("paySignature");
      i = ((Intent)localObject).getIntExtra("pay_channel", 0);
      if (this.fzn != 6) {
        break label434;
      }
    }
    label434:
    for (Object localObject = new com.tencent.mm.plugin.wallet_core.c.a(str1, str2, str3, str4, str5, str6, ((Intent)localObject).getStringExtra("url"), 16, "openOfflinePayView", i);; localObject = new com.tencent.mm.plugin.wallet_core.c.a(str1, str2, str3, str4, str5, str6, ((Intent)localObject).getStringExtra("wxapp_username"), ((Intent)localObject).getStringExtra("wxapp_path"), "openOfflinePayView", i))
    {
      kh(580);
      a((m)localObject, true, false);
      this.mNI = false;
      return;
      if ((i != 1) && (i != 2) && (i != 4)) {
        break;
      }
      com.tencent.mm.plugin.offline.c.a.mNS = i;
      com.tencent.mm.plugin.offline.c.a.mNT = 0;
      com.tencent.mm.plugin.offline.c.a.mNU = 0L;
      com.tencent.mm.plugin.offline.c.a.mNV = false;
      com.tencent.mm.plugin.offline.c.a.ijW = "";
      com.tencent.mm.plugin.offline.c.a.mNW = "";
      com.tencent.mm.plugin.offline.c.a.mNX = "";
      break;
    }
    label475:
    init();
    this.mNI = false;
  }
  
  private void init()
  {
    int i = 3;
    Intent localIntent = getIntent();
    int j;
    if ((localIntent != null) && (localIntent.hasExtra("key_from_scene")))
    {
      j = localIntent.getIntExtra("key_from_scene", 0);
      if (j != 1) {
        break label105;
      }
      this.fgD = 1;
      i = 2;
    }
    for (;;)
    {
      h.nFQ.f(14021, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      if (!o.bVs().bVM()) {
        break;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
      a(new com.tencent.mm.plugin.wallet_core.c.y(null, 8), true, false);
      this.mNI = false;
      return;
      label105:
      if (j == 2)
      {
        this.fgD = 2;
        i = 1;
      }
      else if (j == 3)
      {
        this.fgD = 3;
      }
      else if (j == 4)
      {
        this.fgD = 4;
        i = 6;
      }
      else if (j == 5)
      {
        this.fgD = 8;
        i = 4;
      }
      else if (j == 6)
      {
        this.fgD = 10;
        i = 7;
      }
      else if (j == 7)
      {
        this.fgD = 11;
        i = 8;
      }
      else if (j == 8)
      {
        this.fgD = 12;
        i = 9;
      }
      else
      {
        this.fgD = 0;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[] { Integer.valueOf(j) });
        i = 1;
      }
    }
    localIntent = new Intent();
    localIntent.putExtra("key_entry_scene", this.fgD);
    localIntent.putExtra("key_from_scene", this.fzn);
    String str = getIntent().getStringExtra("key_business_attach");
    if (!bk.bl(str)) {
      localIntent.putExtra("key_business_attach", str);
    }
    localIntent.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
    localIntent.putExtra("key_appid", getIntent().getStringExtra("key_appid"));
    d.b(this.mController.uMN, "offline", ".ui.WalletOfflineCoinPurseUI", localIntent, 1);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
        f.Xf(((com.tencent.mm.plugin.wallet_core.c.a)paramm).bUH());
        init();
        if ((this.fzn == 6) || (this.fzn == 7))
        {
          paramString = new Intent();
          if (!this.mNJ) {
            break label91;
          }
          paramString.putExtra("key_callback", "return");
        }
        for (;;)
        {
          setResult(-1, paramString);
          return true;
          label91:
          paramString.putExtra("key_callback", "ok");
        }
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if ((this.fzn == 6) || (this.fzn == 7))
      {
        paramString = new Intent();
        paramString.putExtra("key_callback", "fail");
        setResult(0, paramString);
      }
      finish();
      return true;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
      init();
      return true;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    init();
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
    finish();
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1)) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
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
      com.tencent.mm.wallet_core.c.a.cMr();
      com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
      this.mNK.cqo();
      bqG();
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        getWindow().addFlags(67108864);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mNK.dead();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      finish();
    }
    return true;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
    if ((paramIntent != null) && (paramIntent.hasExtra("is_offline_create")))
    {
      this.mNI = true;
      this.mNJ = true;
      setIntent(paramIntent);
      bqG();
      return;
    }
    this.mNI = false;
    this.mNJ = true;
    setIntent(paramIntent);
    bqG();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
    if (this.mNI)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
      if (com.tencent.mm.plugin.offline.c.a.bqH())
      {
        com.tencent.mm.sdk.platformtools.y.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_entry_scene", this.fgD);
        localIntent.putExtra("key_from_scene", 0);
        return;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
    this.mNI = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI
 * JD-Core Version:    0.7.0.1
 */