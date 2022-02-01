package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.Window;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.aab;
import com.tencent.mm.g.a.zp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.e;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements i
{
  private boolean IrJ;
  private b IrK;
  private WalletJsapiData IrL;
  private final int IrM;
  public String IrN;
  private int IrO;
  public boolean IrP;
  private IListener IrQ;
  private IListener IrR;
  private int efQ;
  private q gNg;
  public VoidBoolStringI32StringCallback hgw;
  public VoidCallback hgx;
  private Dialog tipDialog;
  
  public WalletBrandUI()
  {
    AppMethodBeat.i(71901);
    this.IrJ = false;
    this.tipDialog = null;
    this.gNg = null;
    this.IrM = (hashCode() & 0xFFFF);
    this.IrN = "";
    this.hgw = null;
    this.hgx = null;
    this.IrP = false;
    this.IrQ = new IListener() {};
    this.IrR = new IListener() {};
    AppMethodBeat.o(71901);
  }
  
  private static String aVZ(String paramString)
  {
    AppMethodBeat.i(71911);
    int i = paramString.indexOf("prepay_id=");
    if (i == -1)
    {
      AppMethodBeat.o(71911);
      return null;
    }
    paramString = paramString.substring(i + 10);
    if (paramString == null)
    {
      AppMethodBeat.o(71911);
      return null;
    }
    i = paramString.indexOf("&");
    if (i == -1)
    {
      AppMethodBeat.o(71911);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(71911);
    return paramString;
  }
  
  private static boolean aWa(String paramString)
  {
    AppMethodBeat.i(182531);
    Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda: %s", new Object[] { paramString });
    if (paramString.startsWith("tax_"))
    {
      Log.i("MicroMsg.WalletBrandUI", "prepay_id starts With tax_");
      com.tencent.mm.wallet_core.b.hgC();
      if (com.tencent.mm.wallet_core.b.b(b.a.rZX, false))
      {
        Log.i("MicroMsg.WalletBrandUI", "open KindaTaxPaySwitch");
        AppMethodBeat.o(182531);
        return false;
      }
      AppMethodBeat.o(182531);
      return true;
    }
    AppMethodBeat.o(182531);
    return false;
  }
  
  private boolean fUu()
  {
    AppMethodBeat.i(71910);
    com.tencent.mm.wallet_core.b.hgC();
    if ((com.tencent.mm.wallet_core.b.b(b.a.rWd, true)) && (this.IrL.packageExt != null))
    {
      String str = aVZ(this.IrL.packageExt);
      if (str == null)
      {
        AppMethodBeat.o(71910);
        return true;
      }
      boolean bool = aWa(str);
      Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda :%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(71910);
        return false;
      }
      if ((this.IrL.dVv == 3) || (this.IrL.dVv == 46))
      {
        AppMethodBeat.o(71910);
        return true;
      }
      AppMethodBeat.o(71910);
      return false;
    }
    AppMethodBeat.o(71910);
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public final void n(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(174530);
    Log.i("MicroMsg.WalletBrandUI", "sendMiniAppPayResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    aab localaab = new aab();
    localaab.egN.intent = paramIntent;
    localaab.egN.egM = 1;
    localaab.egN.dDL = "key_from_scene_appbrandgame";
    localaab.egN.result = paramInt;
    localaab.egN.requestCode = this.IrO;
    EventCenter.instance.publish(localaab);
    AppMethodBeat.o(174530);
  }
  
  public final void o(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182530);
    Log.i("MicroMsg.WalletBrandUI", "sendPaySuccessAheadCallbackResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.IrL != null) && (this.IrL.KxQ != null))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (localIntent.getExtras() == null) {
        localIntent.putExtras(new Bundle());
      }
      this.IrL.KxQ.send(paramInt, localIntent.getExtras());
    }
    AppMethodBeat.o(182530);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71909);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + paramInt2 + " requestCode: " + paramInt1);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((this.IrP) && (paramInt1 == 4) && (paramIntent != null))
    {
      Log.i("MicroMsg.WalletBrandUI", "onActivityResult For Face Action,resultCode : ".concat(String.valueOf(paramInt2)));
      int i = paramIntent.getIntExtra("err_code", 0);
      paramInt1 = paramIntent.getIntExtra("scene", 0);
      int j = paramIntent.getIntExtra("countFace", 0);
      long l = paramIntent.getLongExtra("totalTime", 0L);
      int k = paramIntent.getIntExtra("err_type", 6);
      Log.i("MicroMsg.WalletBrandUI", "errCode： ".concat(String.valueOf(i)));
      Log.i("MicroMsg.WalletBrandUI", "scene： ".concat(String.valueOf(paramInt1)));
      Log.i("MicroMsg.WalletBrandUI", "countFace： ".concat(String.valueOf(j)));
      Log.i("MicroMsg.WalletBrandUI", "totalTime： ".concat(String.valueOf(l)));
      Log.i("MicroMsg.WalletBrandUI", "errorType： ".concat(String.valueOf(k)));
      if (paramInt2 == -1)
      {
        if ((this.hgw != null) && (paramIntent.getExtras() != null))
        {
          paramIntent = paramIntent.getExtras().getString("token");
          this.hgw.call(false, paramIntent, i, "");
          this.hgw = null;
          AppMethodBeat.o(71909);
          return;
          Log.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
        }
      }
      else if ((this.hgw != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((Util.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label447;
        }
      }
      label447:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        Log.i("MicroMsg.WalletBrandUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.WalletBrandUI", "check face failed, click other verify");
          this.hgw.call(true, "", i, "");
          this.hgw = null;
        }
        if (paramInt2 == 0)
        {
          Log.i("MicroMsg.WalletBrandUI", "resultCode：RESULT_CANCELED");
          if (this.hgx != null)
          {
            this.hgx.call();
            this.hgx = null;
          }
          finish();
        }
        AppMethodBeat.o(71909);
        return;
      }
    }
    finish();
    AppMethodBeat.o(71909);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71902);
    super.onCreate(paramBundle);
    this.IrL = ((WalletJsapiData)getIntent().getParcelableExtra("WalletJsapiData"));
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    if (this.IrL == null)
    {
      Log.w("MicroMsg.WalletBrandUI", "no jsapi data");
      finish();
      AppMethodBeat.o(71902);
      return;
    }
    ((com.tencent.mm.plugin.wxpay.a.a)g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.hlD();
    if (this.IrL.KxM != null) {
      this.IrN = this.IrL.KxM;
    }
    this.efQ = this.IrL.dVv;
    if (this.IrN.equalsIgnoreCase("key_from_scene_appbrandgame"))
    {
      this.IrO = this.IrL.dVw;
      this.IrL.dVw = 0;
    }
    ab.hht();
    int i = this.IrL.KxH;
    Log.i("MicroMsg.WalletBrandUI", "onCreate appbrandScene:%s,payScene:%d,requestCode:%d", new Object[] { this.IrN, Integer.valueOf(this.efQ), Integer.valueOf(this.IrO) });
    if (z.aUo())
    {
      Log.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.IrK = new e();
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.IrQ);
      EventCenter.instance.addListener(this.IrR);
      if (!(this.IrK instanceof c)) {
        break;
      }
      Log.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
      AppMethodBeat.o(71902);
      return;
      if (i == 2)
      {
        Log.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.IrK = new a();
      }
      else if (i == 3)
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.IrK = new g();
      }
      else if (i == 4)
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with component");
        this.IrK = new d();
      }
      else if (fUu())
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with kinda");
        this.IrK = new c();
      }
      else
      {
        Log.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.IrK = new f();
      }
    }
    g.aAi();
    g.aAg().hqi.a(this.IrK.fUv(), this);
    AppMethodBeat.o(71902);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71903);
    Log.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    if ((this.IrK instanceof c)) {
      Log.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
    }
    for (;;)
    {
      EventCenter.instance.removeListener(this.IrQ);
      EventCenter.instance.removeListener(this.IrR);
      AppMethodBeat.o(71903);
      return;
      g.aAi();
      g.aAg().hqi.b(this.IrK.fUv(), this);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(71906);
    if (paramInt == 4)
    {
      finish();
      AppMethodBeat.o(71906);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(71906);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71904);
    Log.i("MicroMsg.WalletBrandUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71904);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71905);
    Log.i("MicroMsg.WalletBrandUI", "onResume");
    super.onResume();
    Log.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.IrJ), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.IrJ)
    {
      this.IrJ = true;
      this.gNg = this.IrK.fUw();
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((!fUu()) && (this.IrL.KxH != 4)) {
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.b(this, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(71882);
            g.aAi();
            g.aAg().hqi.a(WalletBrandUI.a(WalletBrandUI.this));
            WalletBrandUI.this.finish();
            AppMethodBeat.o(71882);
          }
        });
      }
    }
    AppMethodBeat.o(71905);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71908);
    Log.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq, this.gNg });
    if ((paramq.getType() != this.IrK.fUv()) || (paramq != this.gNg))
    {
      AppMethodBeat.o(71908);
      return;
    }
    this.IrK.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(71908);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(71907);
    super.onStop();
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(71907);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    implements WalletBrandUI.b
  {
    private int IrT = 0;
    private String mReqKey = "";
    
    public a() {}
    
    public final int fUv()
    {
      return 1563;
    }
    
    public final q fUw()
    {
      AppMethodBeat.i(71887);
      this.IrT = WalletBrandUI.f(WalletBrandUI.this).KxJ;
      int i = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      com.tencent.mm.plugin.wallet_index.c.a.a locala = new com.tencent.mm.plugin.wallet_index.c.a.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dVt, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dVu, i);
      g.aAi();
      g.aAg().hqi.a(locala, 0);
      AppMethodBeat.o(71887);
      return locala;
    }
    
    public final String fUx()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71888);
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.wallet_index.c.a.a)))
      {
        paramString = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramq).jumpUrl;
        Log.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[] { paramString });
        this.mReqKey = paramString;
        paramq = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramq).Irb;
        Intent localIntent;
        if (this.IrT == 1)
        {
          localIntent = new Intent();
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("jsInjectCode", paramq);
          WalletBrandUI.this.setResult(-1, localIntent);
        }
        for (;;)
        {
          WalletBrandUI.this.finish();
          AppMethodBeat.o(71888);
          return;
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramString);
          localIntent.putExtra("showShare", true);
          if (!Util.isNullOrNil(paramq))
          {
            localIntent.putExtra("shouldForceViewPort", true);
            localIntent.putExtra("view_port_code", paramq);
          }
          com.tencent.mm.wallet_core.ui.f.aA(WalletBrandUI.this.getContext(), localIntent);
          WalletBrandUI.this.setResult(-1);
        }
      }
      Log.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.ui.base.h.a(WalletBrandUI.this, paramString, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71885);
          WalletBrandUI.this.setResult(0);
          WalletBrandUI.this.finish();
          AppMethodBeat.o(71885);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(71886);
          WalletBrandUI.this.setResult(0);
          WalletBrandUI.this.finish();
          AppMethodBeat.o(71886);
        }
      });
      AppMethodBeat.o(71888);
    }
  }
  
  static abstract interface b
  {
    public abstract int fUv();
    
    public abstract q fUw();
    
    public abstract String fUx();
    
    public abstract void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  }
  
  class c
    implements WalletBrandUI.b
  {
    c() {}
    
    public final int fUv()
    {
      return 0;
    }
    
    public q fUw()
    {
      AppMethodBeat.i(71890);
      MMActivity.a local1 = new MMActivity.a()
      {
        private Intent IrV;
        
        private void p(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174529);
          Log.i("MicroMsg.WalletBrandUI", "KindaBrand.kindaEndWithResult resultCode: %d, data: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousIntent.toString() });
          WalletBrandUI.this.setResult(paramAnonymousInt, paramAnonymousIntent);
          AppMethodBeat.o(174529);
        }
        
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(71889);
          if (paramAnonymousInt1 != WalletBrandUI.g(WalletBrandUI.this))
          {
            AppMethodBeat.o(71889);
            return;
          }
          if (paramAnonymousIntent == null)
          {
            Log.e("MicroMsg.WalletBrandUI", Util.stackTraceToString(new Throwable("KindaBrand Intent data null!")));
            AppMethodBeat.o(71889);
            return;
          }
          if (paramAnonymousInt2 == -1)
          {
            if (paramAnonymousIntent.hasExtra("key_jsapi_close_page_after_pay"))
            {
              Log.i("MicroMsg.WalletBrandUI", "KindaBrand.mmOnActivityResult ClosePage data: %s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousIntent.toString() });
              paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_close_page_after_pay", 0);
              this.IrV.putExtra("key_jsapi_close_page_after_pay", paramAnonymousInt1);
              WalletBrandUI.this.setResult(paramAnonymousInt2, this.IrV);
              AppMethodBeat.o(71889);
              return;
            }
            this.IrV.putExtras(paramAnonymousIntent);
            p(paramAnonymousInt2, this.IrV);
            AppMethodBeat.o(71889);
            return;
          }
          p(paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(71889);
        }
      };
      ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayJsApiPay(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), local1, WalletBrandUI.g(WalletBrandUI.this));
      AppMethodBeat.o(71890);
      return null;
    }
    
    public final String fUx()
    {
      return "";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  }
  
  final class d
    extends WalletBrandUI.c
  {
    d()
    {
      super();
    }
    
    public final q fUw()
    {
      AppMethodBeat.i(71892);
      ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startJsApiComponentUseCase(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), new MMActivity.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(71891);
          if (paramAnonymousInt1 == WalletBrandUI.g(WalletBrandUI.this))
          {
            WalletBrandUI.this.setResult(paramAnonymousInt2, paramAnonymousIntent);
            WalletBrandUI.this.finish();
          }
          AppMethodBeat.o(71891);
        }
      }, WalletBrandUI.g(WalletBrandUI.this));
      AppMethodBeat.o(71892);
      return null;
    }
  }
  
  final class e
    implements WalletBrandUI.b
  {
    private String mReqKey = "";
    
    e() {}
    
    public final int fUv()
    {
      return 1521;
    }
    
    public final q fUw()
    {
      AppMethodBeat.i(71893);
      com.tencent.mm.plugin.wallet_index.c.b.a locala = new com.tencent.mm.plugin.wallet_index.c.b.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dVt, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dVu, WalletBrandUI.f(WalletBrandUI.this).payChannel);
      g.aAi();
      g.aAg().hqi.a(locala, 0);
      AppMethodBeat.o(71893);
      return locala;
    }
    
    public final String fUx()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71894);
      paramq = (com.tencent.mm.plugin.wallet_index.c.b.a)paramq;
      String str = paramq.IqL;
      Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
      this.mReqKey = str;
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.dDL = str;
      localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
      localPayInfo.IqM = paramq.IqM;
      localPayInfo.dVv = WalletBrandUI.f(WalletBrandUI.this).dVv;
      localPayInfo.errMsg = paramString;
      localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, localPayInfo, 1);
      AppMethodBeat.o(71894);
    }
  }
  
  final class f
    implements WalletBrandUI.b
  {
    private String mReqKey = "";
    
    f() {}
    
    public final int fUv()
    {
      AppMethodBeat.i(71898);
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand getGenPrepayFuncId packageExt:%s", new Object[] { WalletBrandUI.f(WalletBrandUI.this).packageExt });
      if (com.tencent.mm.plugin.wallet_index.c.a.lw(WalletBrandUI.f(WalletBrandUI.this).packageExt, "up_"))
      {
        AppMethodBeat.o(71898);
        return 2519;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.lw(WalletBrandUI.f(WalletBrandUI.this).packageExt, "tax_"))
      {
        AppMethodBeat.o(71898);
        return 2923;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.lw(WalletBrandUI.f(WalletBrandUI.this).packageExt, "dc_"))
      {
        AppMethodBeat.o(71898);
        return 2798;
      }
      AppMethodBeat.o(71898);
      return 398;
    }
    
    public final q fUw()
    {
      AppMethodBeat.i(71896);
      Object localObject = WalletBrandUI.f(WalletBrandUI.this).appId;
      String str1 = WalletBrandUI.f(WalletBrandUI.this).signType;
      String str2 = WalletBrandUI.f(WalletBrandUI.this).nonceStr;
      String str3 = WalletBrandUI.f(WalletBrandUI.this).packageExt;
      String str4 = WalletBrandUI.f(WalletBrandUI.this).dVt;
      String str5 = WalletBrandUI.f(WalletBrandUI.this).timeStamp;
      String str6 = WalletBrandUI.f(WalletBrandUI.this).url;
      String str7 = WalletBrandUI.f(WalletBrandUI.this).dVu;
      int i = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      int j = WalletBrandUI.f(WalletBrandUI.this).dVv;
      int k = WalletBrandUI.f(WalletBrandUI.this).KxG;
      String str8 = WalletBrandUI.f(WalletBrandUI.this).iDk;
      if (com.tencent.mm.plugin.wallet_index.c.a.lw(str3, "up_")) {
        localObject = new l((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.wallet_index.c.f)localObject).setProcessSessionId(System.currentTimeMillis());
        ((com.tencent.mm.plugin.wallet_index.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet_index.c.f)localObject).setScene(WalletBrandUI.f(WalletBrandUI.this).dVv);
        g.aAi();
        g.aAg().hqi.a((q)localObject, 0);
        AppMethodBeat.o(71896);
        return localObject;
        if (com.tencent.mm.plugin.wallet_index.c.a.lw(str3, "tax_")) {
          localObject = new k((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else if (com.tencent.mm.plugin.wallet_index.c.a.lw(str3, "dc_")) {
          localObject = new com.tencent.mm.plugin.wallet_index.c.d((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else {
          localObject = new com.tencent.mm.plugin.wallet_index.c.f((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        }
      }
    }
    
    public final String fUx()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71897);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.wallet_index.c.f localf = (com.tencent.mm.plugin.wallet_index.c.f)paramq;
        localObject1 = localf.IqL;
        Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(localObject1)));
        this.mReqKey = ((String)localObject1);
        EventCenter.instance.publish(new zp());
        Object localObject2 = ((com.tencent.mm.plugin.wallet_index.c.f)paramq).IqN;
        if ((localObject2 != null) && (!Util.isNullOrNil(((exi)localObject2).NuI)))
        {
          Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand start WalletMixOrderInfoUI");
          paramString = new Intent();
          paramString.putExtra("prepayId", (String)localObject1);
          paramString.putExtra("is_jsapi_offline_pay", false);
          paramString.putExtra("pay_gate_url", ((exi)localObject2).NuI);
          paramString.putExtra("need_dialog", ((exi)localObject2).NuK);
          paramString.putExtra("dialog_text", ((exi)localObject2).NuL);
          paramString.putExtra("max_count", ((exi)localObject2).NuJ.LbT);
          paramString.putExtra("inteval_time", ((exi)localObject2).NuJ.LbS);
          paramString.putExtra("default_wording", ((exi)localObject2).NuJ.LbU);
          c.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
          AppMethodBeat.o(71897);
          return;
        }
        Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand startPay");
        localObject2 = new PayInfo();
        ((PayInfo)localObject2).dDL = ((String)localObject1);
        ((PayInfo)localObject2).appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        ((PayInfo)localObject2).IqM = localf.IqM;
        ((PayInfo)localObject2).dVv = WalletBrandUI.f(WalletBrandUI.this).dVv;
        ((PayInfo)localObject2).errMsg = paramString;
        ((PayInfo)localObject2).channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
        ((PayInfo)localObject2).Kxv = localf.sessionId;
        if (((PayInfo)localObject2).iqp == null) {
          ((PayInfo)localObject2).iqp = new Bundle();
        }
        ((PayInfo)localObject2).iqp.putString("extinfo_key_20", ((com.tencent.mm.plugin.wallet_index.c.f)paramq).IqO);
        ((PayInfo)localObject2).iqp.putString("extinfo_key_21", WalletBrandUI.f(WalletBrandUI.this).KxK);
        ((PayInfo)localObject2).iqp.putString("extinfo_key_22", WalletBrandUI.f(WalletBrandUI.this).KxL);
        af.z(((PayInfo)localObject2).dVv, (String)localObject1, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, (PayInfo)localObject2, 1);
        AppMethodBeat.o(71897);
        return;
      }
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand dialog");
      af.z(WalletBrandUI.f(WalletBrandUI.this).dVv, "", paramInt2);
      if (WalletBrandUI.f(WalletBrandUI.this).dVv == 3)
      {
        paramq = WalletBrandUI.this;
        if (Util.isNullOrNil(paramString)) {
          paramString = WalletBrandUI.this.getString(2131767969);
        }
        for (;;)
        {
          paramString = com.tencent.mm.ui.base.h.a(paramq, paramString, "", WalletBrandUI.this.getString(2131767686), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(71895);
              WalletBrandUI.this.finish();
              AppMethodBeat.o(71895);
            }
          });
          if (paramString != null) {
            paramString.setCancelable(false);
          }
          if (WalletBrandUI.d(WalletBrandUI.this) != null)
          {
            WalletBrandUI.d(WalletBrandUI.this).dismiss();
            WalletBrandUI.e(WalletBrandUI.this);
          }
          AppMethodBeat.o(71897);
          return;
        }
      }
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand setResult ResultPayFailed");
      Object localObject1 = new Intent();
      if (paramInt1 != 0) {
        paramInt2 = -1;
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_onActivityResult", "jsapi_pay_onActivityResult");
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_code", paramInt2);
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = WalletBrandUI.this.getString(2131767969);
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_msg", paramq);
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_dialog_confirm", WalletBrandUI.this.getString(2131767686));
      WalletBrandUI.this.setResult(5, (Intent)localObject1);
      WalletBrandUI.this.finish();
      AppMethodBeat.o(71897);
    }
  }
  
  final class g
    implements WalletBrandUI.b
  {
    private String mReqKey = "";
    
    g() {}
    
    public final int fUv()
    {
      return 2755;
    }
    
    public final q fUw()
    {
      AppMethodBeat.i(71899);
      e locale = new e(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dVt, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dVu, WalletBrandUI.f(WalletBrandUI.this).payChannel, WalletBrandUI.f(WalletBrandUI.this).dVv, WalletBrandUI.f(WalletBrandUI.this).extInfo);
      locale.setProcessSessionId(System.currentTimeMillis());
      locale.setProcessName("PayProcess");
      locale.setScene(WalletBrandUI.f(WalletBrandUI.this).dVv);
      g.aAi();
      g.aAg().hqi.a(locale, 0);
      AppMethodBeat.o(71899);
      return locale;
    }
    
    public final String fUx()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71900);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (e)paramq;
        String str = paramq.IqL;
        this.mReqKey = str;
        Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
        PayInfo localPayInfo = new PayInfo();
        localPayInfo.dDL = str;
        localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        localPayInfo.IqM = paramq.IqM;
        localPayInfo.dVv = WalletBrandUI.f(WalletBrandUI.this).dVv;
        localPayInfo.errMsg = paramString;
        localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
        localPayInfo.Kxv = paramq.sessionId;
        af.z(localPayInfo.dVv, str, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, localPayInfo, 1);
        AppMethodBeat.o(71900);
        return;
      }
      WalletBrandUI.this.finish();
      AppMethodBeat.o(71900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI
 * JD-Core Version:    0.7.0.1
 */