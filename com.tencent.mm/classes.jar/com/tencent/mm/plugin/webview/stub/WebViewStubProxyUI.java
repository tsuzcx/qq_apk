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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.uu;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yv.a;
import com.tencent.mm.g.a.yv.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.webview.model.e;
import com.tencent.mm.plugin.webview.model.e.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.i.c;
import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.d.b;

@com.tencent.mm.ui.base.a(7)
@d.b
public class WebViewStubProxyUI
  extends MMActivity
{
  private int IRl;
  private f ISw;
  public boolean Jdc;
  private boolean Jdd;
  private final f Jde;
  private MTimerHandler Jdf;
  private DialogInterface.OnDismissListener ebe;
  private boolean iMQ;
  private String nlH;
  private MTimerHandler timer;
  private int tnt;
  
  public WebViewStubProxyUI()
  {
    AppMethodBeat.i(79287);
    this.Jdc = false;
    this.ISw = null;
    this.Jdd = false;
    this.nlH = "";
    this.iMQ = false;
    this.Jde = new f()
    {
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
        Log.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        WebViewStubProxyUI.b(WebViewStubProxyUI.this);
        WebViewStubProxyUI.this.Jdc = WebViewStubProxyUI.aZO(paramAnonymousString2);
        WebViewStubProxyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79262);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(WebViewStubProxyUI.c(WebViewStubProxyUI.this)).a(null, null, null);
            WebViewStubProxyUI.this.finish();
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).a(paramAnonymousString1, paramAnonymousString2, paramAnonymousBundle, paramAnonymousBoolean);
              AppMethodBeat.o(79262);
              return;
            }
            catch (Exception localException)
            {
              Log.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + localException.getMessage());
              AppMethodBeat.o(79262);
            }
          }
        });
        AppMethodBeat.o(79266);
        return false;
      }
      
      public final void aL(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79280);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aL(paramAnonymousBundle);
        AppMethodBeat.o(79280);
      }
      
      public final void aM(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79275);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aM(paramAnonymousBundle);
        AppMethodBeat.o(79275);
      }
      
      public final void aWP(String paramAnonymousString)
      {
        AppMethodBeat.i(79276);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aWP(paramAnonymousString);
        AppMethodBeat.o(79276);
      }
      
      public final boolean afl(int paramAnonymousInt)
      {
        AppMethodBeat.i(79263);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).afl(paramAnonymousInt);
        AppMethodBeat.o(79263);
        return false;
      }
      
      public final IBinder asBinder()
      {
        return null;
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final String ePp()
      {
        AppMethodBeat.i(211035);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ePp();
        AppMethodBeat.o(211035);
        return str;
      }
      
      public final boolean f(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79264);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).f(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79264);
        return false;
      }
      
      public final void fWV()
      {
        AppMethodBeat.i(79274);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).fWV();
        AppMethodBeat.o(79274);
      }
      
      public final String fWW()
      {
        AppMethodBeat.i(79267);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).fWW();
        AppMethodBeat.o(79267);
        return str;
      }
      
      public final String fWX()
      {
        AppMethodBeat.i(79269);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).fWX();
        AppMethodBeat.o(79269);
        return str;
      }
      
      public final int fWY()
      {
        AppMethodBeat.i(79270);
        int i = WebViewStubProxyUI.a(WebViewStubProxyUI.this).fWY();
        AppMethodBeat.o(79270);
        return i;
      }
      
      public final void fWZ()
      {
        AppMethodBeat.i(79277);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          AppMethodBeat.o(79277);
          return;
        }
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).fWZ();
        AppMethodBeat.o(79277);
      }
      
      public final Bundle fl(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79283);
        paramAnonymousString1 = WebViewStubProxyUI.a(WebViewStubProxyUI.this).fl(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79283);
        return paramAnonymousString1;
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
          Log.w("MicroMsg.callbackerWrapper", "invokeAsResult callbacker is null");
          paramAnonymousBundle = new Bundle();
          AppMethodBeat.o(79279);
          return paramAnonymousBundle;
        }
        paramAnonymousBundle = WebViewStubProxyUI.a(WebViewStubProxyUI.this).j(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79279);
        return paramAnonymousBundle;
      }
      
      public final void lA(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79282);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).lA(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79282);
      }
      
      public final void lz(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79278);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).lz(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79278);
      }
      
      public final void t(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79273);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).t(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79273);
      }
      
      public final void yL(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79271);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).yL(paramAnonymousBoolean);
        AppMethodBeat.o(79271);
      }
      
      public final void yM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79272);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).yM(paramAnonymousBoolean);
        AppMethodBeat.o(79272);
      }
      
      public final void yN(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79281);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).yN(paramAnonymousBoolean);
        AppMethodBeat.o(79281);
      }
    };
    this.ebe = new DialogInterface.OnDismissListener()
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
    this.tnt = 0;
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
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
          Log.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
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
    this.Jdf = new MTimerHandler(new MTimerHandler.CallBack()
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
    if (com.tencent.mm.compatible.util.d.oD(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.ISw = paramBundle.JhP;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.IRl = paramBundle.getIntExtra("webview_binder_id", 0);
    this.nlH = paramBundle.getStringExtra("proxyui_function_key");
    Log.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d, functionName=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.IRl), this.nlH });
    if ("startMonitoringBeacons".equals(this.nlH)) {
      this.Jdc = true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79288);
      return;
      if (!this.Jdd) {
        this.timer.startTimer(100L);
      }
      if (this.Jdc)
      {
        this.Jdf.startTimer(5000L);
        AppMethodBeat.o(79288);
        return;
        Object localObject1 = new yv();
        ((yv)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79257);
            if (!this.Jdg.efc.efd)
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
              c.a locala = c.JYn;
              if (locala != null) {
                locala.bV(WebViewStubProxyUI.this);
              }
              AppMethodBeat.o(79257);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                Log.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + localRemoteException.getMessage());
              }
            }
          }
        };
        ((yv)localObject1).efb.context = this;
        ((yv)localObject1).efb.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((yv)localObject1).efb.type <= 0)
        {
          Log.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((yv)localObject1).efb.type);
          finish();
          AppMethodBeat.o(79288);
          return;
        }
        EventCenter.instance.asyncPublish((IEvent)localObject1, Looper.myLooper());
        AppMethodBeat.o(79288);
        return;
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
        if (!z.aUM()) {
          paramBundle = h.a(this, 2131757956, 2131755998, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79258);
              com.tencent.mm.plugin.webview.a.a.jRt.g(new Intent(), WebViewStubProxyUI.this);
              AppMethodBeat.o(79258);
            }
          }, null);
        }
        while (paramBundle == null)
        {
          finish();
          AppMethodBeat.o(79288);
          return;
          if ((paramBundle == null) || (Util.isNullOrNil(paramBundle.name)))
          {
            paramBundle = h.n(this, 2131765655, 2131755998);
          }
          else
          {
            paramBundle = Util.nullAsNil(getIntent().getStringExtra("shortUrl"));
            paramBundle = new y(getIntent().getIntExtra("type", 0), paramBundle);
            com.tencent.mm.kernel.g.azz().a(paramBundle, 0);
            try
            {
              this.ISw.afl(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              Log.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.ebe);
        AppMethodBeat.o(79288);
        return;
        this.timer.startTimer(100L);
        AppMethodBeat.o(79288);
        return;
        ((p)com.tencent.mm.kernel.g.af(p.class)).a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.ebe);
        AppMethodBeat.o(79288);
        return;
        i = getIntent().getIntExtra("proxyui_expired_errtype", 0);
        int j = getIntent().getIntExtra("proxyui_expired_errcode", 0);
        if ((i == 0) && (j == 0))
        {
          Log.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
          AppMethodBeat.o(79288);
          return;
          paramBundle = getIntent().getStringExtra("proxyui_phone");
          if (Util.isNullOrNil(paramBundle))
          {
            Log.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
            finish();
            AppMethodBeat.o(79288);
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 3);
          Object localObject2 = new uu();
          ((uu)localObject2).ebc.context = this;
          ((uu)localObject2).ebc.ebd = paramBundle;
          ((uu)localObject2).ebc.ebe = this.ebe;
          ((uu)localObject2).ebc.ebf = ((Bundle)localObject1);
          EventCenter.instance.publish((IEvent)localObject2);
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
          if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil((String)localObject1)))
          {
            getString(2131755998);
            localObject2 = h.a(this, getString(2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(79259);
                Log.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(79259);
              }
            });
            ((q)localObject2).show();
            e.a(MMApplicationContext.getContext(), (String)localObject1, paramBundle, new e.a()
            {
              public final void pI(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(79261);
                if (this.rHR != null) {
                  this.rHR.dismiss();
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
                    h.a(WebViewStubProxyUI.this, 2131768755, 2131755998, false, new DialogInterface.OnClickListener()
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
                      Log.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException1.getMessage());
                    }
                  }
                }
                Toast.makeText(WebViewStubProxyUI.this.getContext(), WebViewStubProxyUI.this.getContext().getString(2131768754), 0).show();
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
                    Log.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException2.getMessage());
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
    if (!this.Jdc) {
      this.ISw = null;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(this.IRl).cLD();
    if ((!this.iMQ) && (Util.isEqual(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(this.IRl).JsO, this.nlH)))
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(this.IRl).K(false, this.nlH);
      Log.w("MicroMsg.WebViewStubProxyUI", "onDestroy setIsBusy false");
    }
    Log.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(this.IRl).d(paramInt, -1, null);
        AppMethodBeat.o(79291);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ahd(this.IRl).d(paramInt, 0, null);
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