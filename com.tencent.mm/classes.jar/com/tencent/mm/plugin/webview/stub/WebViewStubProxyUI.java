package com.tencent.mm.plugin.webview.stub;

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
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.aby;
import com.tencent.mm.autogen.a.aby.a;
import com.tencent.mm.autogen.a.aby.b;
import com.tencent.mm.autogen.a.xp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.model.e;
import com.tencent.mm.plugin.webview.model.e.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.platformtools.c;
import com.tencent.mm.pluginsdk.platformtools.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.e.b;

@com.tencent.mm.ui.base.a(7)
@e.b
public class WebViewStubProxyUI
  extends MMActivity
{
  private int Aqu;
  private int WDK;
  private f WFb;
  public boolean WRn;
  private boolean WRo;
  private final f WRp;
  private MTimerHandler WRq;
  private DialogInterface.OnDismissListener iaY;
  private boolean ouJ;
  private MTimerHandler timer;
  private String trR;
  
  public WebViewStubProxyUI()
  {
    AppMethodBeat.i(79287);
    this.WRn = false;
    this.WFb = null;
    this.WRo = false;
    this.trR = "";
    this.ouJ = false;
    this.WRp = new f()
    {
      public final void Il(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79271);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).Il(paramAnonymousBoolean);
        AppMethodBeat.o(79271);
      }
      
      public final void Im(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79272);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).Im(paramAnonymousBoolean);
        AppMethodBeat.o(79272);
      }
      
      public final void In(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79281);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).In(paramAnonymousBoolean);
        AppMethodBeat.o(79281);
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
        Log.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        WebViewStubProxyUI.b(WebViewStubProxyUI.this);
        WebViewStubProxyUI.this.WRn = WebViewStubProxyUI.blk(paramAnonymousString2);
        WebViewStubProxyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79262);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(WebViewStubProxyUI.c(WebViewStubProxyUI.this)).a(null, null, null);
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
      
      public final void aF(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79275);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aF(paramAnonymousBundle);
        AppMethodBeat.o(79275);
      }
      
      public final IBinder asBinder()
      {
        return null;
      }
      
      public final boolean asR(int paramAnonymousInt)
      {
        AppMethodBeat.i(79263);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).asR(paramAnonymousInt);
        AppMethodBeat.o(79263);
        return false;
      }
      
      public final void bif(String paramAnonymousString)
      {
        AppMethodBeat.i(79276);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).bif(paramAnonymousString);
        AppMethodBeat.o(79276);
      }
      
      public final void bk(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79280);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).bk(paramAnonymousBundle);
        AppMethodBeat.o(79280);
      }
      
      public final String cxY()
      {
        AppMethodBeat.i(298469);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).cxY();
        AppMethodBeat.o(298469);
        return str;
      }
      
      public final void f(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final String getCurrentUrl()
      {
        AppMethodBeat.i(79268);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).getCurrentUrl();
        AppMethodBeat.o(79268);
        return str;
      }
      
      public final boolean i(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79264);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).i(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79264);
        return false;
      }
      
      public final void ioZ()
      {
        AppMethodBeat.i(79274);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ioZ();
        AppMethodBeat.o(79274);
      }
      
      public final String ipa()
      {
        AppMethodBeat.i(79267);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ipa();
        AppMethodBeat.o(79267);
        return str;
      }
      
      public final String ipb()
      {
        AppMethodBeat.i(79269);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ipb();
        AppMethodBeat.o(79269);
        return str;
      }
      
      public final int ipc()
      {
        AppMethodBeat.i(79270);
        int i = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ipc();
        AppMethodBeat.o(79270);
        return i;
      }
      
      public final void ipd()
      {
        AppMethodBeat.i(79277);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          AppMethodBeat.o(79277);
          return;
        }
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ipd();
        AppMethodBeat.o(79277);
      }
      
      public final Bundle m(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79279);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          Log.w("MicroMsg.callbackerWrapper", "invokeAsResult callbacker is null");
          paramAnonymousBundle = new Bundle();
          AppMethodBeat.o(79279);
          return paramAnonymousBundle;
        }
        paramAnonymousBundle = WebViewStubProxyUI.a(WebViewStubProxyUI.this).m(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79279);
        return paramAnonymousBundle;
      }
      
      public final Bundle nK(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79283);
        paramAnonymousString1 = WebViewStubProxyUI.a(WebViewStubProxyUI.this).nK(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79283);
        return paramAnonymousString1;
      }
      
      public final void nL(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79278);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).nL(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79278);
      }
      
      public final void nM(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79282);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).nM(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79282);
      }
      
      public final void y(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79273);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).y(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79273);
      }
    };
    this.iaY = new DialogInterface.OnDismissListener()
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
    this.Aqu = 0;
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
    this.WRq = new MTimerHandler(new MTimerHandler.CallBack()
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
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(79288);
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.rb(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.WFb = paramBundle.WWL;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.WDK = paramBundle.getIntExtra("webview_binder_id", 0);
    this.trR = paramBundle.getStringExtra("proxyui_function_key");
    Log.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d, functionName=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.WDK), this.trR });
    if ("startMonitoringBeacons".equals(this.trR)) {
      this.WRn = true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79288);
      return;
      if (!this.WRo) {
        this.timer.startTimer(100L);
      }
      if (this.WRn)
      {
        this.WRq.startTimer(5000L);
        AppMethodBeat.o(79288);
        return;
        Object localObject1 = new aby();
        ((aby)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79257);
            if (!this.WRr.ifw.ifx)
            {
              WebViewStubProxyUI.this.finish();
              AppMethodBeat.o(79257);
              return;
            }
            if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null) {}
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).i(1001, null);
              WebViewStubProxyUI.this.finish();
              c.a locala = c.XUP;
              if (locala != null) {
                locala.cF(WebViewStubProxyUI.this);
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
        ((aby)localObject1).ifv.context = this;
        ((aby)localObject1).ifv.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((aby)localObject1).ifv.type <= 0)
        {
          Log.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((aby)localObject1).ifv.type);
          finish();
          AppMethodBeat.o(79288);
          return;
        }
        ((aby)localObject1).asyncPublish(Looper.myLooper());
        AppMethodBeat.o(79288);
        return;
        paramBundle = ((n)h.ax(n.class)).bzJ().aMh("@t.qq.com");
        if (!com.tencent.mm.model.z.bBG()) {
          paramBundle = com.tencent.mm.ui.base.k.a(this, c.i.contact_info_medianote_sync_to_qqmail_alert_tip, c.i.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79258);
              com.tencent.mm.plugin.webview.a.a.pFn.g(new Intent(), WebViewStubProxyUI.this);
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
            paramBundle = com.tencent.mm.ui.base.k.s(this, c.i.settings_tweibo_notfind, c.i.app_tip);
          }
          else
          {
            paramBundle = Util.nullAsNil(getIntent().getStringExtra("shortUrl"));
            paramBundle = new com.tencent.mm.modelsimple.z(getIntent().getIntExtra("type", 0), paramBundle);
            h.aZW().a(paramBundle, 0);
            try
            {
              this.WFb.asR(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              Log.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.iaY);
        AppMethodBeat.o(79288);
        return;
        this.timer.startTimer(100L);
        AppMethodBeat.o(79288);
        return;
        ((p)h.ax(p.class)).a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.iaY);
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
          Object localObject2 = new xp();
          ((xp)localObject2).iaW.context = this;
          ((xp)localObject2).iaW.iaX = paramBundle;
          ((xp)localObject2).iaW.iaY = this.iaY;
          ((xp)localObject2).iaW.iaZ = ((Bundle)localObject1);
          ((xp)localObject2).publish();
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
            getString(c.i.app_tip);
            localObject2 = com.tencent.mm.ui.base.k.a(this, getString(c.i.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(79259);
                Log.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(79259);
              }
            });
            ((w)localObject2).show();
            e.a(MMApplicationContext.getContext(), (String)localObject1, paramBundle, new e.a()
            {
              public final void wk(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(79261);
                if (this.yAa != null) {
                  this.yAa.dismiss();
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
                    WebViewStubProxyUI.a(WebViewStubProxyUI.this).m(54, localBundle1);
                    com.tencent.mm.ui.base.k.a(WebViewStubProxyUI.this, c.i.wv_add_shortcut_success, c.i.app_tip, false, new DialogInterface.OnClickListener()
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
                Toast.makeText(WebViewStubProxyUI.this.getContext(), WebViewStubProxyUI.this.getContext().getString(c.i.wv_add_shortcut_fail), 0).show();
                Bundle localBundle2;
                if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null)
                {
                  localBundle2 = new Bundle();
                  localBundle2.putBoolean("add_shortcut_status", false);
                }
                try
                {
                  WebViewStubProxyUI.a(WebViewStubProxyUI.this).m(54, localBundle2);
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
    if (!this.ouJ) {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).a(MMApplicationContext.getContext(), this.WFb, this.WFb);
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).iBl();
    if (!this.WRn) {
      this.WFb = null;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).dGL();
    if ((!this.ouJ) && (Util.isEqual(com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).XiD, this.trR)))
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).aM(false, this.trR);
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
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).mmOnActivityResult(paramInt, -1, null);
        AppMethodBeat.o(79291);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(this.WDK).mmOnActivityResult(paramInt, 0, null);
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