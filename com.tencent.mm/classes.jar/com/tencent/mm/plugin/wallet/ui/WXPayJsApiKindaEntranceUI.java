package com.tencent.mm.plugin.wallet.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

@a(7)
public class WXPayJsApiKindaEntranceUI
  extends WalletBaseUI
{
  protected boolean Olz = false;
  private boolean isFront = false;
  
  private void ihh()
  {
    AppMethodBeat.i(315460);
    f local2 = new f() {};
    j.a(MainProcessIPCService.PROCESS_NAME, getIntent().getExtras(), IPCInvoke_KindaJSInvoke.class, local2);
    AppMethodBeat.o(315460);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(315489);
    if (!this.Olz)
    {
      Log.d("MicroMsg.WXPayJsApiKindaEntranceUI", "back press not lock");
      finish();
      AppMethodBeat.o(315489);
      return;
    }
    Log.d("MicroMsg.WXPayJsApiKindaEntranceUI", "back press but lock");
    AppMethodBeat.o(315489);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(315468);
    super.onCreate(paramBundle);
    setContentViewVisibility(8);
    if (getIntent() == null)
    {
      Log.d("MicroMsg.WXPayJsApiKindaEntranceUI", "func[doCheckPayNetscene] intent null");
      setResult(0);
      finish();
      AppMethodBeat.o(315468);
      return;
    }
    paramBundle = getIntent().getStringExtra("jsapiName");
    if (paramBundle.equals("phoneBindCardEntry"))
    {
      paramBundle = new f() {};
      j.a(MainProcessIPCService.PROCESS_NAME, getIntent().getExtras(), IPCInvoke_KindaJSInvoke.class, paramBundle);
      AppMethodBeat.o(315468);
      return;
    }
    if (paramBundle.equals("requestKidsPayRechargePayment"))
    {
      ihh();
      AppMethodBeat.o(315468);
      return;
    }
    if (paramBundle.equals("requestSnsPayment"))
    {
      ihh();
      AppMethodBeat.o(315468);
      return;
    }
    finish();
    AppMethodBeat.o(315468);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(315480);
    super.onDestroy();
    AppMethodBeat.o(315480);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(315478);
    super.onPause();
    this.isFront = false;
    h.ahAA.bFQ("WXPayJsApiKindaEntranceUIObserver");
    AppMethodBeat.o(315478);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(315474);
    super.onResume();
    this.isFront = true;
    h.ahAA.a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(315479);
        h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(315475);
            Log.i("MicroMsg.WXPayJsApiKindaEntranceUI", "execute finish logic if in font page：%s", new Object[] { Boolean.valueOf(WXPayJsApiKindaEntranceUI.a(WXPayJsApiKindaEntranceUI.this)) });
            if ((WXPayJsApiKindaEntranceUI.a(WXPayJsApiKindaEntranceUI.this)) && (!WXPayJsApiKindaEntranceUI.this.isFinishing()) && (!WXPayJsApiKindaEntranceUI.this.isDestroyed()))
            {
              WXPayJsApiKindaEntranceUI.this.setResult(0);
              WXPayJsApiKindaEntranceUI.this.finish();
            }
            AppMethodBeat.o(315475);
          }
        });
        AppMethodBeat.o(315479);
      }
    }, 6000L, "WXPayJsApiKindaEntranceUIObserver");
    AppMethodBeat.o(315474);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.WXPayJsApiKindaEntranceUI
 * JD-Core Version:    0.7.0.1
 */