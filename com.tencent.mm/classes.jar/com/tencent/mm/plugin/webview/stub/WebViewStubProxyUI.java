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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.xt;
import com.tencent.mm.g.a.xt.a;
import com.tencent.mm.g.a.xt.b;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.webview.model.e;
import com.tencent.mm.plugin.webview.model.e.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.cb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.d.b;

@com.tencent.mm.ui.base.a(7)
@d.b
public class WebViewStubProxyUI
  extends MMActivity
{
  private int EeE;
  private f EfN;
  public boolean EpV;
  private boolean EpW;
  private final f EpX;
  private aw EpY;
  private aw cYd;
  private DialogInterface.OnDismissListener dJr;
  private boolean hRI;
  private String mxL;
  private int rNI;
  
  public WebViewStubProxyUI()
  {
    AppMethodBeat.i(79287);
    this.EpV = false;
    this.EfN = null;
    this.EpW = false;
    this.mxL = "";
    this.hRI = false;
    this.EpX = new f()
    {
      public final boolean WE(int paramAnonymousInt)
      {
        AppMethodBeat.i(79263);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).WE(paramAnonymousInt);
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
        ae.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        WebViewStubProxyUI.b(WebViewStubProxyUI.this);
        WebViewStubProxyUI.this.EpV = WebViewStubProxyUI.aJH(paramAnonymousString2);
        WebViewStubProxyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79262);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(WebViewStubProxyUI.c(WebViewStubProxyUI.this)).a(null, null, null);
            WebViewStubProxyUI.this.finish();
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).a(paramAnonymousString1, paramAnonymousString2, paramAnonymousBundle, paramAnonymousBoolean);
              AppMethodBeat.o(79262);
              return;
            }
            catch (Exception localException)
            {
              ae.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + localException.getMessage());
              AppMethodBeat.o(79262);
            }
          }
        });
        AppMethodBeat.o(79266);
        return false;
      }
      
      public final void aA(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79275);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aA(paramAnonymousBundle);
        AppMethodBeat.o(79275);
      }
      
      public final void aHa(String paramAnonymousString)
      {
        AppMethodBeat.i(79276);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aHa(paramAnonymousString);
        AppMethodBeat.o(79276);
      }
      
      public final IBinder asBinder()
      {
        return null;
      }
      
      public final void az(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79280);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).az(paramAnonymousBundle);
        AppMethodBeat.o(79280);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void ePd()
      {
        AppMethodBeat.i(79274);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ePd();
        AppMethodBeat.o(79274);
      }
      
      public final String ePe()
      {
        AppMethodBeat.i(79267);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ePe();
        AppMethodBeat.o(79267);
        return str;
      }
      
      public final String ePf()
      {
        AppMethodBeat.i(79269);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ePf();
        AppMethodBeat.o(79269);
        return str;
      }
      
      public final int ePg()
      {
        AppMethodBeat.i(79270);
        int i = WebViewStubProxyUI.a(WebViewStubProxyUI.this).ePg();
        AppMethodBeat.o(79270);
        return i;
      }
      
      public final void ePh()
      {
        AppMethodBeat.i(79277);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          AppMethodBeat.o(79277);
          return;
        }
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ePh();
        AppMethodBeat.o(79277);
      }
      
      public final Bundle eU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79283);
        paramAnonymousString1 = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eU(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79283);
        return paramAnonymousString1;
      }
      
      public final String eaf()
      {
        AppMethodBeat.i(198174);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eaf();
        AppMethodBeat.o(198174);
        return str;
      }
      
      public final boolean g(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79264);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).g(paramAnonymousInt, paramAnonymousBundle);
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
      
      public final Bundle k(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79279);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          ae.w("MicroMsg.callbackerWrapper", "invokeAsResult callbacker is null");
          paramAnonymousBundle = new Bundle();
          AppMethodBeat.o(79279);
          return paramAnonymousBundle;
        }
        paramAnonymousBundle = WebViewStubProxyUI.a(WebViewStubProxyUI.this).k(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79279);
        return paramAnonymousBundle;
      }
      
      public final void kG(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79278);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).kG(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79278);
      }
      
      public final void kH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79282);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).kH(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79282);
      }
      
      public final void u(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79273);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).u(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79273);
      }
      
      public final void uW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79271);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).uW(paramAnonymousBoolean);
        AppMethodBeat.o(79271);
      }
      
      public final void uX(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79272);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).uX(paramAnonymousBoolean);
        AppMethodBeat.o(79272);
      }
      
      public final void uY(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79281);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).uY(paramAnonymousBoolean);
        AppMethodBeat.o(79281);
      }
    };
    this.dJr = new DialogInterface.OnDismissListener()
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
    this.rNI = 0;
    this.cYd = new aw(new aw.a()
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
          ae.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
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
    this.EpY = new aw(new aw.a()
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
    if (com.tencent.mm.compatible.util.d.lA(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.EfN = paramBundle.Euw;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.EeE = paramBundle.getIntExtra("webview_binder_id", 0);
    this.mxL = paramBundle.getStringExtra("proxyui_function_key");
    ae.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d, functionName=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.EeE), this.mxL });
    if ("startMonitoringBeacons".equals(this.mxL)) {
      this.EpV = true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79288);
      return;
      if (!this.EpW) {
        this.cYd.ay(100L, 100L);
      }
      if (this.EpV)
      {
        this.EpY.ay(5000L, 5000L);
        AppMethodBeat.o(79288);
        return;
        Object localObject1 = new xt();
        ((xt)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79257);
            if (!this.EpZ.dNk.dNl)
            {
              WebViewStubProxyUI.this.finish();
              AppMethodBeat.o(79257);
              return;
            }
            if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null) {}
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).g(1001, null);
              WebViewStubProxyUI.this.finish();
              f.a locala = com.tencent.mm.pluginsdk.i.f.Fhu;
              if (locala != null) {
                locala.bA(WebViewStubProxyUI.this);
              }
              AppMethodBeat.o(79257);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                ae.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + localRemoteException.getMessage());
              }
            }
          }
        };
        ((xt)localObject1).dNj.context = this;
        ((xt)localObject1).dNj.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((xt)localObject1).dNj.type <= 0)
        {
          ae.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((xt)localObject1).dNj.type);
          finish();
          AppMethodBeat.o(79288);
          return;
        }
        com.tencent.mm.sdk.b.a.IvT.a((b)localObject1, Looper.myLooper());
        AppMethodBeat.o(79288);
        return;
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
        if (!v.aBp()) {
          paramBundle = h.a(this, 2131757725, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79258);
              com.tencent.mm.plugin.webview.a.a.iUz.g(new Intent(), WebViewStubProxyUI.this);
              AppMethodBeat.o(79258);
            }
          }, null);
        }
        while (paramBundle == null)
        {
          finish();
          AppMethodBeat.o(79288);
          return;
          if ((paramBundle == null) || (bu.isNullOrNil(paramBundle.name)))
          {
            paramBundle = h.l(this, 2131763472, 2131755906);
          }
          else
          {
            paramBundle = bu.nullAsNil(getIntent().getStringExtra("shortUrl"));
            paramBundle = new y(getIntent().getIntExtra("type", 0), paramBundle);
            com.tencent.mm.kernel.g.ajj().a(paramBundle, 0);
            try
            {
              this.EfN.WE(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              ae.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.dJr);
        AppMethodBeat.o(79288);
        return;
        this.cYd.ay(100L, 100L);
        AppMethodBeat.o(79288);
        return;
        ((com.tencent.mm.pluginsdk.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.p.class)).a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.dJr);
        AppMethodBeat.o(79288);
        return;
        i = getIntent().getIntExtra("proxyui_expired_errtype", 0);
        int j = getIntent().getIntExtra("proxyui_expired_errcode", 0);
        if ((i == 0) && (j == 0))
        {
          ae.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
          AppMethodBeat.o(79288);
          return;
          paramBundle = getIntent().getStringExtra("proxyui_phone");
          if (bu.isNullOrNil(paramBundle))
          {
            ae.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
            finish();
            AppMethodBeat.o(79288);
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 3);
          Object localObject2 = new tw();
          ((tw)localObject2).dJp.context = this;
          ((tw)localObject2).dJp.dJq = paramBundle;
          ((tw)localObject2).dJp.dJr = this.dJr;
          ((tw)localObject2).dJp.dJs = ((Bundle)localObject1);
          com.tencent.mm.sdk.b.a.IvT.l((b)localObject2);
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
          if ((!bu.isNullOrNil(paramBundle)) && (!bu.isNullOrNil((String)localObject1)))
          {
            getString(2131755906);
            localObject2 = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(79259);
                ae.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(79259);
              }
            });
            ((com.tencent.mm.ui.base.p)localObject2).show();
            e.a(ak.getContext(), (String)localObject1, paramBundle, new e.a()
            {
              public final void nc(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(79261);
                if (this.qqK != null) {
                  this.qqK.dismiss();
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
                    WebViewStubProxyUI.a(WebViewStubProxyUI.this).k(54, localBundle1);
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
                      ae.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException1.getMessage());
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
                  WebViewStubProxyUI.a(WebViewStubProxyUI.this).k(54, localBundle2);
                  WebViewStubProxyUI.this.finish();
                  AppMethodBeat.o(79261);
                  return;
                }
                catch (Exception localException2)
                {
                  for (;;)
                  {
                    ae.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException2.getMessage());
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
    if (!this.EpV) {
      this.EfN = null;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(this.EeE).cnq();
    if ((!this.hRI) && (bu.lX(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(this.EeE).EDn, this.mxL)))
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(this.EeE).J(false, this.mxL);
      ae.w("MicroMsg.WebViewStubProxyUI", "onDestroy setIsBusy false");
    }
    ae.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(this.EeE).c(paramInt, -1, null);
        AppMethodBeat.o(79291);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.Yt(this.EeE).c(paramInt, 0, null);
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