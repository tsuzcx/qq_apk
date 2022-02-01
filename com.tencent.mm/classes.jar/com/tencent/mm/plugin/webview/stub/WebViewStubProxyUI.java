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
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.a;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bu;
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
  private int CjB;
  private f CkJ;
  public boolean Cum;
  private boolean Cun;
  private final f Cuo;
  private au Cup;
  private au cLS;
  private DialogInterface.OnDismissListener dwd;
  private boolean hwA;
  private String lSY;
  private int qVj;
  
  public WebViewStubProxyUI()
  {
    AppMethodBeat.i(79287);
    this.Cum = false;
    this.CkJ = null;
    this.Cun = false;
    this.lSY = "";
    this.hwA = false;
    this.Cuo = new f()
    {
      public final boolean Vr(int paramAnonymousInt)
      {
        AppMethodBeat.i(79263);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).Vr(paramAnonymousInt);
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
        ac.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        WebViewStubProxyUI.b(WebViewStubProxyUI.this);
        WebViewStubProxyUI.this.Cum = WebViewStubProxyUI.aCN(paramAnonymousString2);
        WebViewStubProxyUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79262);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(WebViewStubProxyUI.c(WebViewStubProxyUI.this)).a(null, null, null);
            WebViewStubProxyUI.this.finish();
            try
            {
              WebViewStubProxyUI.a(WebViewStubProxyUI.this).a(paramAnonymousString1, paramAnonymousString2, paramAnonymousBundle, paramAnonymousBoolean);
              AppMethodBeat.o(79262);
              return;
            }
            catch (Exception localException)
            {
              ac.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + localException.getMessage());
              AppMethodBeat.o(79262);
            }
          }
        });
        AppMethodBeat.o(79266);
        return false;
      }
      
      public final void aCM(String paramAnonymousString)
      {
        AppMethodBeat.i(79276);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aCM(paramAnonymousString);
        AppMethodBeat.o(79276);
      }
      
      public final void aD(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79275);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aD(paramAnonymousBundle);
        AppMethodBeat.o(79275);
      }
      
      public final void aE(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79280);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).aE(paramAnonymousBundle);
        AppMethodBeat.o(79280);
      }
      
      public final IBinder asBinder()
      {
        return null;
      }
      
      public final String dKq()
      {
        AppMethodBeat.i(188368);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).dKq();
        AppMethodBeat.o(188368);
        return str;
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final String eCA()
      {
        AppMethodBeat.i(79269);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eCA();
        AppMethodBeat.o(79269);
        return str;
      }
      
      public final String eCy()
      {
        AppMethodBeat.i(79267);
        String str = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eCy();
        AppMethodBeat.o(79267);
        return str;
      }
      
      public final int eCz()
      {
        AppMethodBeat.i(79270);
        int i = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eCz();
        AppMethodBeat.o(79270);
        return i;
      }
      
      public final Bundle eH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79283);
        paramAnonymousString1 = WebViewStubProxyUI.a(WebViewStubProxyUI.this).eH(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79283);
        return paramAnonymousString1;
      }
      
      public final void ezP()
      {
        AppMethodBeat.i(79277);
        if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) == null)
        {
          AppMethodBeat.o(79277);
          return;
        }
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ezP();
        AppMethodBeat.o(79277);
      }
      
      public final void ezQ()
      {
        AppMethodBeat.i(79274);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ezQ();
        AppMethodBeat.o(79274);
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
          ac.w("MicroMsg.callbackerWrapper", "invokeAsResult callbacker is null");
          paramAnonymousBundle = new Bundle();
          AppMethodBeat.o(79279);
          return paramAnonymousBundle;
        }
        paramAnonymousBundle = WebViewStubProxyUI.a(WebViewStubProxyUI.this).k(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79279);
        return paramAnonymousBundle;
      }
      
      public final void kA(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79282);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).kA(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79282);
      }
      
      public final void kz(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(79278);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).kz(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(79278);
      }
      
      public final void u(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(79273);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).u(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(79273);
      }
      
      public final void uq(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79271);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).uq(paramAnonymousBoolean);
        AppMethodBeat.o(79271);
      }
      
      public final void ur(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79272);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).ur(paramAnonymousBoolean);
        AppMethodBeat.o(79272);
      }
      
      public final void us(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(79281);
        WebViewStubProxyUI.a(WebViewStubProxyUI.this).us(paramAnonymousBoolean);
        AppMethodBeat.o(79281);
      }
    };
    this.dwd = new DialogInterface.OnDismissListener()
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
    this.qVj = 0;
    this.cLS = new au(new au.a()
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
          ac.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
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
    this.Cup = new au(new au.a()
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
    if (com.tencent.mm.compatible.util.d.kZ(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.CkJ = paramBundle.CyL;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.CjB = paramBundle.getIntExtra("webview_binder_id", 0);
    this.lSY = paramBundle.getStringExtra("proxyui_function_key");
    ac.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d, functionName=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.CjB), this.lSY });
    if ("startMonitoringBeacons".equals(this.lSY)) {
      this.Cum = true;
    }
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(79288);
      return;
      if (!this.Cun) {
        this.cLS.au(100L, 100L);
      }
      if (this.Cum)
      {
        this.Cup.au(5000L, 5000L);
        AppMethodBeat.o(79288);
        return;
        Object localObject1 = new ww();
        ((ww)localObject1).callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(79257);
            if (!this.Cuq.dzJ.dzK)
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
              com.tencent.mm.pluginsdk.g.e.a locala = com.tencent.mm.pluginsdk.g.e.DjW;
              if (locala != null) {
                locala.bz(WebViewStubProxyUI.this);
              }
              AppMethodBeat.o(79257);
              return;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                ac.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + localRemoteException.getMessage());
              }
            }
          }
        };
        ((ww)localObject1).dzI.context = this;
        ((ww)localObject1).dzI.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((ww)localObject1).dzI.type <= 0)
        {
          ac.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((ww)localObject1).dzI.type);
          finish();
          AppMethodBeat.o(79288);
          return;
        }
        com.tencent.mm.sdk.b.a.GpY.a((b)localObject1, Looper.myLooper());
        AppMethodBeat.o(79288);
        return;
        paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ("@t.qq.com");
        if (!u.ayd()) {
          paramBundle = h.a(this, 2131757725, 2131755906, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(79258);
              com.tencent.mm.plugin.webview.a.a.iyx.g(new Intent(), WebViewStubProxyUI.this);
              AppMethodBeat.o(79258);
            }
          }, null);
        }
        while (paramBundle == null)
        {
          finish();
          AppMethodBeat.o(79288);
          return;
          if ((paramBundle == null) || (bs.isNullOrNil(paramBundle.name)))
          {
            paramBundle = h.l(this, 2131763472, 2131755906);
          }
          else
          {
            paramBundle = bs.nullAsNil(getIntent().getStringExtra("shortUrl"));
            paramBundle = new x(getIntent().getIntExtra("type", 0), paramBundle);
            com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
            try
            {
              this.CkJ.Vr(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              ac.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.dwd);
        AppMethodBeat.o(79288);
        return;
        this.cLS.au(100L, 100L);
        AppMethodBeat.o(79288);
        return;
        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.dwd);
        AppMethodBeat.o(79288);
        return;
        i = getIntent().getIntExtra("proxyui_expired_errtype", 0);
        int j = getIntent().getIntExtra("proxyui_expired_errcode", 0);
        if ((i == 0) && (j == 0))
        {
          ac.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
          AppMethodBeat.o(79288);
          return;
          paramBundle = getIntent().getStringExtra("proxyui_phone");
          if (bs.isNullOrNil(paramBundle))
          {
            ac.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
            finish();
            AppMethodBeat.o(79288);
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 3);
          Object localObject2 = new td();
          ((td)localObject2).dwb.context = this;
          ((td)localObject2).dwb.dwc = paramBundle;
          ((td)localObject2).dwb.dwd = this.dwd;
          ((td)localObject2).dwb.dwe = ((Bundle)localObject1);
          com.tencent.mm.sdk.b.a.GpY.l((b)localObject2);
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
          if ((!bs.isNullOrNil(paramBundle)) && (!bs.isNullOrNil((String)localObject1)))
          {
            getString(2131755906);
            localObject2 = h.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(79259);
                ac.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                WebViewStubProxyUI.this.finish();
                AppMethodBeat.o(79259);
              }
            });
            ((p)localObject2).show();
            com.tencent.mm.plugin.webview.model.e.a(ai.getContext(), (String)localObject1, paramBundle, new com.tencent.mm.plugin.webview.model.e.a()
            {
              public final void mF(boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(79261);
                if (this.pGA != null) {
                  this.pGA.dismiss();
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
                      ac.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException1.getMessage());
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
                    ac.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + localException2.getMessage());
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
    if (!this.Cum) {
      this.CkJ = null;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(this.CjB).chw();
    if ((!this.hwA) && (bs.lr(com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(this.CjB).CHx, this.lSY)))
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(this.CjB).C(false, this.lSY);
      ac.w("MicroMsg.WebViewStubProxyUI", "onDestroy setIsBusy false");
    }
    ac.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
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
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(this.CjB).c(paramInt, -1, null);
        AppMethodBeat.o(79291);
        return;
      }
      com.tencent.mm.plugin.webview.ui.tools.jsapi.g.VW(this.CjB).c(paramInt, 0, null);
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