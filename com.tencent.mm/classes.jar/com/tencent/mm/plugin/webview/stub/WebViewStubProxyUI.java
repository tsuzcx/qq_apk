package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.wl.a;
import com.tencent.mm.g.a.wl.b;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.d.b;

@com.tencent.mm.ui.base.a(7)
@d.b
public class WebViewStubProxyUI
  extends MMActivity
{
  private int ARo;
  private f ASw;
  public boolean Bca;
  private boolean Bcb;
  private final f Bcc;
  private av Bcd;
  private av cOx;
  private DialogInterface.OnDismissListener dyr;
  private boolean gWb;
  private String lrd;
  private int qmH;
  
  public WebViewStubProxyUI()
  {
    AppMethodBeat.i(79287);
    this.Bca = false;
    this.ASw = null;
    this.Bcb = false;
    this.lrd = "";
    this.gWb = false;
    this.Bcc = new f()
    {
      public final boolean Tj(int paramAnonymousInt)
      {
        AppMethodBeat.i(79263);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).Tj(paramAnonymousInt);
        AppMethodBeat.o(79263);
        return false;
      }
      
      public final boolean a(d paramAnonymousd)
      {
        AppMethodBeat.i(79265);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).a(paramAnonymousd);
        AppMethodBeat.o(79265);
        return false;
      }
      
      public final boolean a(final String paramAnonymousString1, final String paramAnonymousString2, final Bundle paramAnonymousBundle, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79266);
        ad.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        WebViewStubProxyUI.b(WebViewStubProxyUI.this);
        WebViewStubProxyUI.this.Bca = WebViewStubProxyUI.axv(paramAnonymousString2);
        WebViewStubProxyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79262);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(WebViewStubProxyUI.c(WebViewStubProxyUI.this)).a(null, null, null);
            WebViewStubProxyUI.this.finish();
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).a(paramAnonymousString1, paramAnonymousString2, paramAnonymousBundle, paramAnonymousBoolean);
              AppMethodBeat.o(79262);
              return;
            }
            catch (Exception localException)
            {
              ad.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + localException.getMessage());
              AppMethodBeat.o(79262);
            }
          }
        });
        AppMethodBeat.o(79266);
        return false;
      }
      
      public final IBinder asBinder()
      {
        return null;
      }
      
      public final void axu(String paramAnonymousString)
      {
        AppMethodBeat.i(79276);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).axu(paramAnonymousString);
        AppMethodBeat.o(79276);
      }
      
      public final void ay(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79275);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ay(paramAnonymousBundle);
        AppMethodBeat.o(79275);
      }
      
      public final void az(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79280);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).az(paramAnonymousBundle);
        AppMethodBeat.o(79280);
      }
      
      public final String dvR()
      {
        AppMethodBeat.i(187940);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).dvR();
        AppMethodBeat.o(187940);
        return str;
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void ekt()
      {
        AppMethodBeat.i(79277);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          AppMethodBeat.o(79277);
          return;
        }
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ekt();
        AppMethodBeat.o(79277);
      }
      
      public final void eku()
      {
        AppMethodBeat.i(79274);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).eku();
        AppMethodBeat.o(79274);
      }
      
      public final String ene()
      {
        AppMethodBeat.i(79267);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ene();
        AppMethodBeat.o(79267);
        return str;
      }
      
      public final int enf()
      {
        AppMethodBeat.i(79270);
        int i = WebViewStubProxyUI.a(WebViewStubProxyUI.this).enf();
        AppMethodBeat.o(79270);
        return i;
      }
      
      public final String eng()
      {
        AppMethodBeat.i(79269);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eng();
        AppMethodBeat.o(79269);
        return str;
      }
      
      public final Bundle ev(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79283);
        paramAnonymousString1 = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ev(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79283);
        return paramAnonymousString1;
      }
      
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79264);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).f(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79264);
        return false;
      }
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(79268);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).getCurrentUrl();
        AppMethodBeat.o(79268);
        return str;
      }
      
      public final Bundle j(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79279);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          ad.w("MicroMsg.callbackerWrapper", "invokeAsResult callbacker is null");
          paramAnonymousBundle = new Bundle();
          AppMethodBeat.o(79279);
          return paramAnonymousBundle;
        }
        paramAnonymousBundle = WebViewStubProxyUI.a(WebViewStubProxyUI.this).j(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79279);
        return paramAnonymousBundle;
      }
      
      public final void kd(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79278);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).kd(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79278);
      }
      
      public final void ke(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79282);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ke(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79282);
      }
      
      public final void t(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79273);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).t(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79273);
      }
      
      public final void to(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79271);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).to(paramAnonymousBoolean);
        AppMethodBeat.o(79271);
      }
      
      public final void tp(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79272);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).tp(paramAnonymousBoolean);
        AppMethodBeat.o(79272);
      }
      
      public final void tq(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79281);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).tq(paramAnonymousBoolean);
        AppMethodBeat.o(79281);
      }
    };
    this.dyr = new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(79284);
        if (!WebViewStubProxyUI.this.isFinishing()) {
          WebViewStubProxyUI.this.finish();
        }
        AppMethodBeat.o(79284);
      }
    };
    this.qmH = 0;
    this.cOx = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(79285);
        if ((WebViewStubProxyUI.this.getWindow() == null) || (WebViewStubProxyUI.this.getWindow().getDecorView() == null) || (WebViewStubProxyUI.this.getWindow().getDecorView().getWindowToken() == null))
        {
          if (WebViewStubProxyUI.d(WebViewStubProxyUI.this) < 10)
          {
            WebViewStubProxyUI.e(WebViewStubProxyUI.this);
            AppMethodBeat.o(79285);
            return true;
          }
          ad.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
          WebViewStubProxyUI.this.finish();
          AppMethodBeat.o(79285);
          return false;
        }
        WebViewStubProxyUI.f(WebViewStubProxyUI.this);
        WebViewStubProxyUI.g(WebViewStubProxyUI.this);
        AppMethodBeat.o(79285);
        return false;
      }
    }, true);
    this.Bcd = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(79286);
        if (!WebViewStubProxyUI.this.isFinishing()) {
          WebViewStubProxyUI.this.finish();
        }
        AppMethodBeat.o(79286);
        return false;
      }
    }, true);
    AppMethodBeat.o(79287);
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(79289);
    int i = getIntent().getIntExtra("screen_orientation", -1);
    AppMethodBeat.o(79289);
    return i;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(21)
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79288);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.lf(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.ASw = paramBundle.Bgz;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.ARo = paramBundle.getIntExtra("webview_binder_id", 0);
    this.lrd = paramBundle.getStringExtra("proxyui_function_key");
    ad.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d, functionName=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.ARo), this.lrd });
    if ("startMonitoringBeacons".equals(this.lrd)) {
      this.Bca = true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79288);
      return;
      if (!this.Bcb) {
        this.cOx.av(100L, 100L);
      }
      if (this.Bca)
      {
        this.Bcd.av(5000L, 5000L);
        AppMethodBeat.o(79288);
        return;
        Object localObject1 = new wl();
        ((wl)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79257);
            if (!this.Bce.dBV.dBW)
            {
              WebViewStubProxyUI.this.finish();
              AppMethodBeat.o(79257);
              return;
            }
            if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null) {}
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).f(1001, null);
              WebViewStubProxyUI.this.finish();
              com.tencent.mm.pluginsdk.g.e.a locala = com.tencent.mm.pluginsdk.g.e.BRG;
              if (locala != null) {
                locala.bw(WebViewStubProxyUI.this);
              }
              AppMethodBeat.o(79257);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                ad.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + localRemoteException.getMessage());
              }
            }
          }
        };
        ((wl)localObject1).dBU.context = this;
        ((wl)localObject1).dBU.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((wl)localObject1).dBU.type <= 0)
        {
          ad.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((wl)localObject1).dBU.type);
          finish();
          AppMethodBeat.o(79288);
          return;
        }
        com.tencent.mm.sdk.b.a.ESL.a((b)localObject1, Looper.myLooper());
        AppMethodBeat.o(79288);
        return;
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP("@t.qq.com");
        if (!u.arn()) {
          paramBundle = h.a(this, 2131757725, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79258);
              com.tencent.mm.plugin.webview.a.a.hYt.g(new Intent(), WebViewStubProxyUI.this);
              AppMethodBeat.o(79258);
            }
          }, null);
        }
        while (paramBundle == null)
        {
          finish();
          AppMethodBeat.o(79288);
          return;
          if ((paramBundle == null) || (bt.isNullOrNil(paramBundle.name)))
          {
            paramBundle = h.j(this, 2131763472, 2131755906);
          }
          else
          {
            paramBundle = bt.nullAsNil(getIntent().getStringExtra("shortUrl"));
            paramBundle = new x(getIntent().getIntExtra("type", 0), paramBundle);
            com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
            try
            {
              this.ASw.Tj(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              ad.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.dyr);
        AppMethodBeat.o(79288);
        return;
        this.cOx.av(100L, 100L);
        AppMethodBeat.o(79288);
        return;
        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.dyr);
        AppMethodBeat.o(79288);
        return;
        i = getIntent().getIntExtra("proxyui_expired_errtype", 0);
        int j = getIntent().getIntExtra("proxyui_expired_errcode", 0);
        if ((i == 0) && (j == 0))
        {
          ad.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
          AppMethodBeat.o(79288);
          return;
          paramBundle = getIntent().getStringExtra("proxyui_phone");
          if (bt.isNullOrNil(paramBundle))
          {
            ad.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
            finish();
            AppMethodBeat.o(79288);
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 3);
          Object localObject2 = new su();
          ((su)localObject2).dyp.context = this;
          ((su)localObject2).dyp.dyq = paramBundle;
          ((su)localObject2).dyp.dyr = this.dyr;
          ((su)localObject2).dyp.dys = ((Bundle)localObject1);
          com.tencent.mm.sdk.b.a.ESL.l((b)localObject2);
          AppMethodBeat.o(79288);
          return;
          paramBundle = (Intent)getIntent().getExtras().getParcelable("proxyui_next_intent_key");
          paramBundle.setFlags(603979776);
          localObject1 = new Intent();
          ((Intent)localObject1).setClass(this, SimpleLoginUI.class);
          MMWizardActivity.b(this, (Intent)localObject1, paramBundle);
          finish();
          AppMethodBeat.o(79288);
          return;
          paramBundle = getIntent().getStringExtra("KAppId");
          localObject1 = getIntent().getStringExtra("shortcut_user_name");
          if ((!bt.isNullOrNil(paramBundle)) && (!bt.isNullOrNil((String)localObject1)))
          {
            getString(2131755906);
            localObject2 = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(79259);
                ad.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(79259);
              }
            });
            ((p)localObject2).show();
            com.tencent.mm.plugin.webview.model.e.a(aj.getContext(), (String)localObject1, paramBundle, new com.tencent.mm.plugin.webview.model.e.a()
            {
              public final void lM(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(79261);
                if (this.pdp != null) {
                  this.pdp.dismiss();
                }
                if (paramAnonymousBoolean)
                {
                  Bundle localBundle1;
                  if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null)
                  {
                    localBundle1 = new Bundle();
                    localBundle1.putBoolean("add_shortcut_status", true);
                  }
                  try
                  {
                    WebViewStubProxyUI.a(WebViewStubProxyUI.this).j(54, localBundle1);
                    h.a(WebViewStubProxyUI.this, 2131766244, 2131755906, false, new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(79260);
                        WebViewStubProxyUI.this.finish();
                        AppMethodBeat.o(79260);
                      }
                    });
                    AppMethodBeat.o(79261);
                    return;
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException1.getMessage());
                    }
                  }
                }
                Toast.makeText(WebViewStubProxyUI.this.getContext(), WebViewStubProxyUI.this.getContext().getString(2131766243), 0).show();
                Bundle localBundle2;
                if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null)
                {
                  localBundle2 = new Bundle();
                  localBundle2.putBoolean("add_shortcut_status", false);
                }
                try
                {
                  WebViewStubProxyUI.a(WebViewStubProxyUI.this).j(54, localBundle2);
                  WebViewStubProxyUI.this.finish();
                  AppMethodBeat.o(79261);
                  return;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    ad.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException2.getMessage());
                  }
                }
              }
            });
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(79290);
    super.onDestroy();
    if (!this.Bca) {
      this.ASw = null;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(this.ARo).can();
    if ((!this.gWb) && (bt.kU(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(this.ARo).Bpr, this.lrd)))
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(this.ARo).B(false, this.lrd);
      ad.w("MicroMsg.WebViewStubProxyUI", "onDestroy setIsBusy false");
    }
    ad.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    AppMethodBeat.o(79290);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79291);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79291);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(this.ARo).c(paramInt, -1, null);
        AppMethodBeat.o(79291);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.TO(this.ARo).c(paramInt, 0, null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI
 * JD-Core Version:    0.7.0.1
 */