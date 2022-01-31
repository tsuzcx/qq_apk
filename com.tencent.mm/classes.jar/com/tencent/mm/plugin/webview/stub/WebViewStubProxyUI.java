package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.Window;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.st;
import com.tencent.mm.h.a.st.a;
import com.tencent.mm.h.a.st.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.b;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.d.b;

@com.tencent.mm.ui.base.a(7)
@d.b
public class WebViewStubProxyUI
  extends MMActivity
{
  private am byQ = new am(new WebViewStubProxyUI.7(this), true);
  private int kkh = 0;
  private e rgh = null;
  public boolean rjL = false;
  private boolean rjM = false;
  private int rjN;
  private final e rjO = new WebViewStubProxyUI.5(this);
  private DialogInterface.OnDismissListener rjP = new WebViewStubProxyUI.6(this);
  private am rjQ = new am(new am.a()
  {
    public final boolean tC()
    {
      if (!WebViewStubProxyUI.this.isFinishing()) {
        WebViewStubProxyUI.this.finish();
      }
      return false;
    }
  }, true);
  
  protected final int getForceOrientation()
  {
    return getIntent().getIntExtra("screen_orientation", -1);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  @TargetApi(21)
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.gF(21)) {
      getWindow().setStatusBarColor(0);
    }
    paramBundle = (WebViewStubCallbackWrapper)getIntent().getParcelableExtra("webview_stub_callbacker_key");
    if (paramBundle != null) {
      this.rgh = paramBundle.rno;
    }
    paramBundle = getIntent();
    int i = paramBundle.getIntExtra("proxyui_action_code_key", 0);
    this.rjN = paramBundle.getIntExtra("webview_binder_id", 0);
    y.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.rjN) });
    if ("startMonitoringBeacons".equals(paramBundle.getStringExtra("proxyui_function_key"))) {
      this.rjL = true;
    }
    switch (i)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!this.rjM) {
            this.byQ.S(100L, 100L);
          }
        } while (!this.rjL);
        this.rjQ.S(5000L, 5000L);
        return;
        localObject = new st();
        ((st)localObject).bFJ = new Runnable()
        {
          public final void run()
          {
            if (!this.rjR.cco.ccp) {
              WebViewStubProxyUI.this.finish();
            }
            for (;;)
            {
              return;
              if (WebViewStubProxyUI.a(WebViewStubProxyUI.this) != null) {}
              try
              {
                WebViewStubProxyUI.a(WebViewStubProxyUI.this).b(1001, null);
                WebViewStubProxyUI.this.finish();
                e.a locala = com.tencent.mm.pluginsdk.f.e.rVK;
                if (locala == null) {
                  continue;
                }
                locala.aK(WebViewStubProxyUI.this);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                for (;;)
                {
                  y.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + localRemoteException.getMessage());
                }
              }
            }
          }
        };
        ((st)localObject).ccn.context = this;
        ((st)localObject).ccn.type = paramBundle.getIntExtra("update_type_key", 0);
        if (((st)localObject).ccn.type <= 0)
        {
          y.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + ((st)localObject).ccn.type);
          finish();
          return;
        }
        com.tencent.mm.sdk.b.a.udP.a((b)localObject, Looper.myLooper());
        return;
        au.Hx();
        paramBundle = com.tencent.mm.model.c.FE().Ic("@t.qq.com");
        if (!q.GR()) {
          paramBundle = com.tencent.mm.ui.base.h.a(this, R.l.contact_info_medianote_sync_to_qqmail_alert_tip, R.l.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              com.tencent.mm.plugin.webview.a.a.eUR.h(new Intent(), WebViewStubProxyUI.this);
            }
          }, null);
        }
        while (paramBundle == null)
        {
          finish();
          return;
          if ((paramBundle == null) || (bk.bl(paramBundle.name)))
          {
            paramBundle = com.tencent.mm.ui.base.h.h(this, R.l.settings_tweibo_notfind, R.l.app_tip);
          }
          else
          {
            paramBundle = bk.pm(getIntent().getStringExtra("shortUrl"));
            paramBundle = new w(getIntent().getIntExtra("type", 0), paramBundle);
            au.Dk().a(paramBundle, 0);
            try
            {
              this.rgh.Cl(0);
              paramBundle = null;
            }
            catch (Exception paramBundle)
            {
              y.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + paramBundle.getMessage());
              paramBundle = null;
            }
          }
        }
        paramBundle.setOnDismissListener(this.rjP);
        return;
        this.byQ.S(100L, 100L);
        return;
      } while (o.a.rSF == null);
      o.a.rSF.a(this, paramBundle.getStringExtra("proxyui_handle_event_url"), this.rjP);
      return;
      i = getIntent().getIntExtra("proxyui_expired_errtype", 0);
      int j = getIntent().getIntExtra("proxyui_expired_errcode", 0);
      if ((i == 0) && (j == 0))
      {
        y.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
        return;
      }
      paramBundle = new com.tencent.mm.h.a.c();
      paramBundle.bEQ.bER = this;
      paramBundle.bEQ.errType = i;
      paramBundle.bEQ.errCode = j;
      com.tencent.mm.sdk.b.a.udP.m(paramBundle);
      return;
      paramBundle = getIntent().getStringExtra("proxyui_phone");
      if (bk.bl(paramBundle))
      {
        y.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
        finish();
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("fromScene", 3);
      l.a(this, paramBundle, this.rjP, (Bundle)localObject);
      return;
      paramBundle = (Intent)getIntent().getExtras().getParcelable("proxyui_next_intent_key");
      paramBundle.setFlags(603979776);
      localObject = new Intent();
      ((Intent)localObject).setClass(this, SimpleLoginUI.class);
      MMWizardActivity.b(this, (Intent)localObject, paramBundle);
      finish();
      return;
      paramBundle = getIntent().getStringExtra("KAppId");
      localObject = getIntent().getStringExtra("shortcut_user_name");
    } while ((bk.bl(paramBundle)) || (bk.bl((String)localObject)));
    getString(R.l.app_tip);
    com.tencent.mm.ui.base.p localp = com.tencent.mm.ui.base.h.b(this, getString(R.l.app_waiting), true, new WebViewStubProxyUI.3(this));
    localp.show();
    com.tencent.mm.plugin.base.model.d.a(ae.getContext(), (String)localObject, paramBundle, new WebViewStubProxyUI.4(this, localp));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.rjL) {
      this.rgh = null;
    }
    y.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(this.rjN).c(paramInt, -1, null);
      return;
    }
    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Db(this.rjN).c(paramInt, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI
 * JD-Core Version:    0.7.0.1
 */