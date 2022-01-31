package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.c;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.um;
import com.tencent.mm.g.a.um.a;
import com.tencent.mm.g.a.um.b;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.d.b;

@com.tencent.mm.ui.base.a(7)
@d.b
public class WebViewStubProxyUI
  extends MMActivity
{
  private DialogInterface.OnDismissListener cHC;
  private ap caS;
  private int mEM;
  private e uWu;
  public boolean uZe;
  private boolean uZf;
  private int uZg;
  private final e uZh;
  private ap uZi;
  
  public WebViewStubProxyUI()
  {
    AppMethodBeat.i(7098);
    this.uZe = false;
    this.uWu = null;
    this.uZf = false;
    this.uZh = new WebViewStubProxyUI.5(this);
    this.cHC = new WebViewStubProxyUI.6(this);
    this.mEM = 0;
    this.caS = new ap(new WebViewStubProxyUI.7(this), true);
    this.uZi = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(7097);
        if (!WebViewStubProxyUI.this.isFinishing()) {
          WebViewStubProxyUI.this.finish();
        }
        AppMethodBeat.o(7097);
        return false;
      }
    }, true);
    AppMethodBeat.o(7098);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(7100);
    int i = getIntent().getIntExtra("screen_orientation", -1);
    AppMethodBeat.o(7100);
    return i;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(21)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(7099);
    super.onCreate(paramBundle);
    if (d.fv(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.uWu = paramBundle.vdZ;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.uZg = paramBundle.getIntExtra("webview_binder_id", 0);
    ab.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.uZg) });
    if ("startMonitoringBeacons".equals(paramBundle.getStringExtra("proxyui_function_key"))) {
      this.uZe = true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7099);
      return;
      if (!this.uZf) {
        this.caS.ag(100L, 100L);
      }
      if (this.uZe)
      {
        this.uZi.ag(5000L, 5000L);
        AppMethodBeat.o(7099);
        return;
        Object localObject1 = new um();
        ((um)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(7068);
            if (!this.uZj.cKY.cKZ)
            {
              WebViewStubProxyUI.this.finish();
              AppMethodBeat.o(7068);
              return;
            }
            if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null) {}
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).e(1001, null);
              WebViewStubProxyUI.this.finish();
              e.a locala = com.tencent.mm.pluginsdk.f.e.vMF;
              if (locala != null) {
                locala.bi(WebViewStubProxyUI.this);
              }
              AppMethodBeat.o(7068);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                ab.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + localRemoteException.getMessage());
              }
            }
          }
        };
        ((um)localObject1).cKX.context = this;
        ((um)localObject1).cKX.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((um)localObject1).cKX.type <= 0)
        {
          ab.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((um)localObject1).cKX.type);
          finish();
          AppMethodBeat.o(7099);
          return;
        }
        com.tencent.mm.sdk.b.a.ymk.a((b)localObject1, Looper.myLooper());
        AppMethodBeat.o(7099);
        return;
        paramBundle = ((j)com.tencent.mm.kernel.g.E(j.class)).YI().TL("@t.qq.com");
        if (!r.ZT()) {
          paramBundle = com.tencent.mm.ui.base.h.a(this, 2131298664, 2131297087, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(7069);
              com.tencent.mm.plugin.webview.a.a.gmO.g(new Intent(), WebViewStubProxyUI.this);
              AppMethodBeat.o(7069);
            }
          }, null);
        }
        while (paramBundle == null)
        {
          finish();
          AppMethodBeat.o(7099);
          return;
          if ((paramBundle == null) || (bo.isNullOrNil(paramBundle.name)))
          {
            paramBundle = com.tencent.mm.ui.base.h.h(this, 2131303490, 2131297087);
          }
          else
          {
            paramBundle = bo.nullAsNil(getIntent().getStringExtra("shortUrl"));
            paramBundle = new x(getIntent().getIntExtra("type", 0), paramBundle);
            com.tencent.mm.kernel.g.Rc().a(paramBundle, 0);
            try
            {
              this.uWu.Ke(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              ab.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.cHC);
        AppMethodBeat.o(7099);
        return;
        this.caS.ag(100L, 100L);
        AppMethodBeat.o(7099);
        return;
        ((q)com.tencent.mm.kernel.g.E(q.class)).a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.cHC);
        AppMethodBeat.o(7099);
        return;
        i = getIntent().getIntExtra("proxyui_expired_errtype", 0);
        int j = getIntent().getIntExtra("proxyui_expired_errcode", 0);
        if ((i == 0) && (j == 0))
        {
          ab.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
          AppMethodBeat.o(7099);
          return;
        }
        paramBundle = new c();
        paramBundle.cmb.cmc = this;
        paramBundle.cmb.errType = i;
        paramBundle.cmb.errCode = j;
        com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
        AppMethodBeat.o(7099);
        return;
        paramBundle = getIntent().getStringExtra("proxyui_phone");
        if (bo.isNullOrNil(paramBundle))
        {
          ab.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
          finish();
          AppMethodBeat.o(7099);
          return;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("fromScene", 3);
        Object localObject2 = new rb();
        ((rb)localObject2).cHA.context = this;
        ((rb)localObject2).cHA.cHB = paramBundle;
        ((rb)localObject2).cHA.cHC = this.cHC;
        ((rb)localObject2).cHA.cHD = ((Bundle)localObject1);
        com.tencent.mm.sdk.b.a.ymk.l((b)localObject2);
        AppMethodBeat.o(7099);
        return;
        paramBundle = (Intent)getIntent().getExtras().getParcelable("proxyui_next_intent_key");
        paramBundle.setFlags(603979776);
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(this, SimpleLoginUI.class);
        MMWizardActivity.b(this, (Intent)localObject1, paramBundle);
        finish();
        AppMethodBeat.o(7099);
        return;
        paramBundle = getIntent().getStringExtra("KAppId");
        localObject1 = getIntent().getStringExtra("shortcut_user_name");
        if ((!bo.isNullOrNil(paramBundle)) && (!bo.isNullOrNil((String)localObject1)))
        {
          getString(2131297087);
          localObject2 = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, new WebViewStubProxyUI.3(this));
          ((com.tencent.mm.ui.base.p)localObject2).show();
          av.a(ah.getContext(), (String)localObject1, paramBundle, new WebViewStubProxyUI.4(this, (com.tencent.mm.ui.base.p)localObject2));
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7101);
    super.onDestroy();
    if (!this.uZe) {
      this.uWu = null;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g localg = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(this.uZg);
    if (localg.eeN != null)
    {
      localg.eeN.dismiss();
      localg.eeN = null;
    }
    ab.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    AppMethodBeat.o(7101);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(7102);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(7102);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(this.uZg).c(paramInt, -1, null);
        AppMethodBeat.o(7102);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.h.KW(this.uZg).c(paramInt, 0, null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI
 * JD-Core Version:    0.7.0.1
 */