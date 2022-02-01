package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.kg;
import com.tencent.mm.autogen.mmdata.rpt.rg;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(7)
public class WalletOfflineEntranceUI
  extends WalletBaseUI
{
  boolean MCV;
  private boolean MCW;
  private IListener<kg> MCX;
  private int mEntryScene;
  private int mScene;
  
  public WalletOfflineEntranceUI()
  {
    AppMethodBeat.i(66540);
    this.MCV = true;
    this.mEntryScene = -1;
    this.MCW = false;
    this.MCX = new IListener(f.hfK) {};
    AppMethodBeat.o(66540);
  }
  
  private void gws()
  {
    AppMethodBeat.i(66542);
    Log.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
    k.asj(1);
    i.aGA(30);
    gwu();
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
      for (localObject = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, ((Intent)localObject).getStringExtra("url"), 16, "openOfflinePayView", i);; localObject = new com.tencent.mm.plugin.wallet_core.c.d(str1, str2, str3, str4, str5, str6, 16, ((Intent)localObject).getStringExtra("wxapp_username"), ((Intent)localObject).getStringExtra("wxapp_path"), "openOfflinePayView", i))
      {
        addSceneEndListener(580);
        doSceneProgress((p)localObject, true);
        this.MCV = false;
        AppMethodBeat.o(66542);
        return;
      }
    }
    init();
    this.MCV = false;
    AppMethodBeat.o(66542);
  }
  
  private void gwt()
  {
    int i = 3;
    AppMethodBeat.i(269203);
    Intent localIntent = getIntent();
    int j;
    if ((localIntent != null) && (localIntent.hasExtra("key_from_scene")))
    {
      j = localIntent.getIntExtra("key_from_scene", 0);
      if (j != 1) {
        break label78;
      }
      this.mEntryScene = 1;
      i = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(14021, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(269203);
      return;
      label78:
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
  
  private void gwu()
  {
    AppMethodBeat.i(66550);
    if (getIntent() != null)
    {
      int i = getIntent().getIntExtra("key_from_scene", 0);
      Log.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is ".concat(String.valueOf(i)));
      if (i == 3)
      {
        com.tencent.mm.plugin.offline.c.d.MDk = i;
        i = getIntent().getIntExtra("key_expire_time", 0);
        long l = getIntent().getLongExtra("key_begin_time", 0L);
        boolean bool = getIntent().getBooleanExtra("key_is_mark", false);
        Log.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + i + " beginTime:" + l + " isMark:" + bool);
        com.tencent.mm.plugin.offline.c.d.MDl = i;
        com.tencent.mm.plugin.offline.c.d.MDm = l;
        com.tencent.mm.plugin.offline.c.d.MDn = bool;
        com.tencent.mm.plugin.offline.c.d.wrg = getIntent().getStringExtra("key_card_id");
        com.tencent.mm.plugin.offline.c.d.MDo = getIntent().getStringExtra("key_user_card_id");
        com.tencent.mm.plugin.offline.c.d.MDp = getIntent().getStringExtra("key_card_code");
        AppMethodBeat.o(66550);
        return;
      }
      if ((i == 1) || (i == 2) || (i == 4))
      {
        com.tencent.mm.plugin.offline.c.d.MDk = i;
        com.tencent.mm.plugin.offline.c.d.MDl = 0;
        com.tencent.mm.plugin.offline.c.d.MDm = 0L;
        com.tencent.mm.plugin.offline.c.d.MDn = false;
        com.tencent.mm.plugin.offline.c.d.wrg = "";
        com.tencent.mm.plugin.offline.c.d.MDo = "";
        com.tencent.mm.plugin.offline.c.d.MDp = "";
      }
    }
    AppMethodBeat.o(66550);
  }
  
  private void init()
  {
    Object localObject1 = null;
    AppMethodBeat.i(66545);
    gwt();
    if ((u.iiC().ijl()) || (u.iiC().VcF == null))
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
      doSceneProgress(new ae(null, 8), true);
      this.MCV = false;
      AppMethodBeat.o(66545);
      return;
    }
    if (this.mKindaEnable)
    {
      com.tencent.mm.wallet_core.b.jNX();
      if ((com.tencent.mm.wallet_core.b.jOb()) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).isOfflineReady()))
      {
        if (com.tencent.mm.plugin.offline.c.d.MDk == 3)
        {
          localObject2 = new HashMap();
          if (com.tencent.mm.plugin.offline.c.d.wrg == null) {
            break label216;
          }
          localObject1 = com.tencent.mm.plugin.offline.c.d.wrg;
          ((HashMap)localObject2).put("card_id", localObject1);
          if (com.tencent.mm.plugin.offline.c.d.MDo == null) {
            break label222;
          }
          localObject1 = com.tencent.mm.plugin.offline.c.d.MDo;
          label141:
          ((HashMap)localObject2).put("user_card_id", localObject1);
          if (com.tencent.mm.plugin.offline.c.d.MDp == null) {
            break label228;
          }
        }
        label216:
        label222:
        label228:
        for (localObject1 = com.tencent.mm.plugin.offline.c.d.MDp;; localObject1 = "")
        {
          ((HashMap)localObject2).put("card_code", localObject1);
          localObject1 = localObject2;
          int i = getIntent().getIntExtra("pay_channel", 0);
          ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startOfflinePrePay(getContext(), this.mEntryScene, i, this.mScene, (Map)localObject1);
          AppMethodBeat.o(66545);
          return;
          localObject1 = "";
          break;
          localObject1 = "";
          break label141;
        }
      }
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("key_entry_scene", this.mEntryScene);
    ((Intent)localObject1).putExtra("key_from_scene", this.mScene);
    Object localObject2 = getIntent().getStringExtra("key_business_attach");
    if (!Util.isNullOrNil((String)localObject2)) {
      ((Intent)localObject1).putExtra("key_business_attach", (String)localObject2);
    }
    ((Intent)localObject1).putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
    ((Intent)localObject1).putExtra("key_appid", getIntent().getStringExtra("key_appid"));
    com.tencent.mm.br.c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", (Intent)localObject1, 1);
    AppMethodBeat.o(66545);
  }
  
  public void finish()
  {
    AppMethodBeat.i(269218);
    Log.d("MicroMsg.WalletOfflineEntranceUI", "finish");
    super.finish();
    AppMethodBeat.o(269218);
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
      com.tencent.mm.wallet_core.model.b.jOG().init(getApplicationContext());
      this.MCX.alive();
      gws();
      paramBundle = com.tencent.mm.plugin.secdata.ui.a.PlI;
      paramBundle = (dgs)a.a.b(this, 3, dgs.class);
      if ((paramBundle != null) && ("launch_type_offline_wallet".equals(paramBundle.aaLL)))
      {
        paramBundle = new rg();
        paramBundle.iUz = 1L;
        paramBundle.jvA = 1L;
        paramBundle.bMH();
        com.tencent.mm.util.c localc = com.tencent.mm.util.c.agsX;
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
    this.MCX.dead();
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
      this.MCV = true;
      this.MCW = true;
      setIntent(paramIntent);
      gws();
      AppMethodBeat.o(66551);
      return;
    }
    this.MCV = false;
    this.MCW = true;
    setIntent(paramIntent);
    gws();
    AppMethodBeat.o(66551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66546);
    super.onResume();
    Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
    if (this.MCV)
    {
      Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
      if (com.tencent.mm.plugin.offline.c.d.gwA())
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
    this.MCV = true;
    AppMethodBeat.o(66546);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(66548);
    if ((paramp instanceof com.tencent.mm.plugin.wallet_core.c.d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
        e.brZ(((com.tencent.mm.plugin.wallet_core.c.d)paramp).ihJ());
        init();
        if ((this.mScene == 6) || (this.mScene == 7))
        {
          paramString = new Intent();
          if (!this.MCW) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI
 * JD-Core Version:    0.7.0.1
 */