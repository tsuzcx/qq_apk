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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.aaw;
import com.tencent.mm.f.a.abh;
import com.tencent.mm.f.a.abi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.e;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.plugin.wallet_index.c.l;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.fhv;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;
import com.tencent.mm.wallet_core.ui.g;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private IListener PkA;
  private boolean Pks;
  private b Pkt;
  private WalletJsapiData Pku;
  private final int Pkv;
  public String Pkw;
  private int Pkx;
  public boolean Pky;
  private IListener Pkz;
  private int gag;
  public VoidBoolStringI32StringCallback jSq;
  public VoidCallback jSr;
  private q jxA;
  private Dialog tipDialog;
  
  public WalletBrandUI()
  {
    AppMethodBeat.i(71901);
    this.Pks = false;
    this.tipDialog = null;
    this.jxA = null;
    this.Pkv = (hashCode() & 0xFFFF);
    this.Pkw = "";
    this.jSq = null;
    this.jSr = null;
    this.Pky = false;
    this.Pkz = new IListener() {};
    this.PkA = new IListener() {};
    AppMethodBeat.o(71901);
  }
  
  private static String bhI(String paramString)
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
  
  private static boolean bhJ(String paramString)
  {
    AppMethodBeat.i(182531);
    Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda: %s", new Object[] { paramString });
    if (paramString.startsWith("tax_"))
    {
      Log.i("MicroMsg.WalletBrandUI", "prepay_id starts With tax_");
      b.iie();
      if (b.b(b.a.vGZ, false))
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
  
  private boolean gNa()
  {
    AppMethodBeat.i(71910);
    b.iie();
    if ((b.b(b.a.vCG, true)) && (this.Pku.packageExt != null))
    {
      String str = bhI(this.Pku.packageExt);
      if (str == null)
      {
        AppMethodBeat.o(71910);
        return true;
      }
      boolean bool = bhJ(str);
      Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda :%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(71910);
        return false;
      }
      if ((this.Pku.fOY == 3) || (this.Pku.fOY == 46))
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
    abi localabi = new abi();
    localabi.gbd.intent = paramIntent;
    localabi.gbd.gbc = 1;
    localabi.gbd.fwv = "key_from_scene_appbrandgame";
    localabi.gbd.result = paramInt;
    localabi.gbd.requestCode = this.Pkx;
    EventCenter.instance.publish(localabi);
    AppMethodBeat.o(174530);
  }
  
  public final void o(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182530);
    Log.i("MicroMsg.WalletBrandUI", "sendPaySuccessAheadCallbackResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.Pku != null) && (this.Pku.RzE != null))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (localIntent.getExtras() == null) {
        localIntent.putExtras(new Bundle());
      }
      this.Pku.RzE.send(paramInt, localIntent.getExtras());
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
    while ((this.Pky) && (paramInt1 == 4) && (paramIntent != null))
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
        if ((this.jSq != null) && (paramIntent.getExtras() != null))
        {
          paramIntent = paramIntent.getExtras().getString("token");
          this.jSq.call(false, paramIntent, i, "");
          this.jSq = null;
          AppMethodBeat.o(71909);
          return;
          Log.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
        }
      }
      else if ((this.jSq != null) && (paramIntent.getExtras() != null))
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
          this.jSq.call(true, "", i, "");
          this.jSq = null;
        }
        if (paramInt2 == 0)
        {
          Log.i("MicroMsg.WalletBrandUI", "resultCode：RESULT_CANCELED");
          if (this.jSr != null)
          {
            this.jSr.call();
            this.jSr = null;
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
    this.Pku = ((WalletJsapiData)getIntent().getParcelableExtra("WalletJsapiData"));
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    if (this.Pku == null)
    {
      Log.w("MicroMsg.WalletBrandUI", "no jsapi data");
      finish();
      AppMethodBeat.o(71902);
      return;
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.ipc();
    if (this.Pku.RzA != null) {
      this.Pkw = this.Pku.RzA;
    }
    this.gag = this.Pku.fOY;
    if (this.Pkw.equalsIgnoreCase("key_from_scene_appbrandgame"))
    {
      this.Pkx = this.Pku.fOZ;
      this.Pku.fOZ = 0;
    }
    ab.iiV();
    int i = this.Pku.Rzv;
    Log.i("MicroMsg.WalletBrandUI", "onCreate appbrandScene:%s,payScene:%d,requestCode:%d", new Object[] { this.Pkw, Integer.valueOf(this.gag), Integer.valueOf(this.Pkx) });
    if (z.bdq())
    {
      Log.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.Pkt = new e();
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.Pkz);
      EventCenter.instance.addListener(this.PkA);
      if (!(this.Pkt instanceof c)) {
        break;
      }
      Log.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
      AppMethodBeat.o(71902);
      return;
      if (i == 2)
      {
        Log.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.Pkt = new a();
      }
      else if (i == 3)
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.Pkt = new g();
      }
      else if (i == 4)
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with component");
        this.Pkt = new d();
      }
      else if (gNa())
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with kinda");
        this.Pkt = new c();
      }
      else
      {
        Log.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.Pkt = new f();
      }
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(this.Pkt.gNb(), this);
    AppMethodBeat.o(71902);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71903);
    Log.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    if ((this.Pkt instanceof c)) {
      Log.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
    }
    for (;;)
    {
      EventCenter.instance.removeListener(this.Pkz);
      EventCenter.instance.removeListener(this.PkA);
      AppMethodBeat.o(71903);
      return;
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(this.Pkt.gNb(), this);
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
    Log.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.Pks), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.Pks)
    {
      this.Pks = true;
      this.jxA = this.Pkt.gNc();
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((!gNa()) && (this.Pku.Rzv != 4)) {
        this.tipDialog = com.tencent.mm.wallet_core.ui.i.b(this, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(71882);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(WalletBrandUI.a(WalletBrandUI.this));
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
    Log.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq, this.jxA });
    if ((paramq.getType() != this.Pkt.gNb()) || (paramq != this.jxA))
    {
      AppMethodBeat.o(71908);
      return;
    }
    this.Pkt.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
    private int PkC = 0;
    private String mReqKey = "";
    
    public a() {}
    
    public final int gNb()
    {
      return 1563;
    }
    
    public final q gNc()
    {
      AppMethodBeat.i(71887);
      this.PkC = WalletBrandUI.f(WalletBrandUI.this).Rzx;
      int i = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      com.tencent.mm.plugin.wallet_index.c.a.a locala = new com.tencent.mm.plugin.wallet_index.c.a.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).fOW, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).fOX, i);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(locala, 0);
      AppMethodBeat.o(71887);
      return locala;
    }
    
    public final String gNd()
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
        paramq = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramq).PjK;
        Intent localIntent;
        if (this.PkC == 1)
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
          g.aJ(WalletBrandUI.this.getContext(), localIntent);
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
    public abstract int gNb();
    
    public abstract q gNc();
    
    public abstract String gNd();
    
    public abstract void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  }
  
  class c
    implements WalletBrandUI.b
  {
    c() {}
    
    public final int gNb()
    {
      return 0;
    }
    
    public q gNc()
    {
      AppMethodBeat.i(71890);
      MMActivity.a local1 = new MMActivity.a()
      {
        private Intent PkE;
        
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
              this.PkE.putExtra("key_jsapi_close_page_after_pay", paramAnonymousInt1);
              WalletBrandUI.this.setResult(paramAnonymousInt2, this.PkE);
              AppMethodBeat.o(71889);
              return;
            }
            this.PkE.putExtras(paramAnonymousIntent);
            p(paramAnonymousInt2, this.PkE);
            AppMethodBeat.o(71889);
            return;
          }
          p(paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(71889);
        }
      };
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayJsApiPay(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), local1, WalletBrandUI.g(WalletBrandUI.this));
      AppMethodBeat.o(71890);
      return null;
    }
    
    public final String gNd()
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
    
    public final q gNc()
    {
      AppMethodBeat.i(71892);
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startJsApiComponentUseCase(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), new MMActivity.a()
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
    
    public final int gNb()
    {
      return 1521;
    }
    
    public final q gNc()
    {
      AppMethodBeat.i(71893);
      com.tencent.mm.plugin.wallet_index.c.b.a locala = new com.tencent.mm.plugin.wallet_index.c.b.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).fOW, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).fOX, WalletBrandUI.f(WalletBrandUI.this).payChannel);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(locala, 0);
      AppMethodBeat.o(71893);
      return locala;
    }
    
    public final String gNd()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71894);
      paramq = (com.tencent.mm.plugin.wallet_index.c.b.a)paramq;
      String str = paramq.Pju;
      Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
      this.mReqKey = str;
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.fwv = str;
      localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
      localPayInfo.Pjv = paramq.Pjv;
      localPayInfo.fOY = WalletBrandUI.f(WalletBrandUI.this).fOY;
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
    
    public final int gNb()
    {
      AppMethodBeat.i(71898);
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand getGenPrepayFuncId packageExt:%s", new Object[] { WalletBrandUI.f(WalletBrandUI.this).packageExt });
      if (com.tencent.mm.plugin.wallet_index.c.a.lT(WalletBrandUI.f(WalletBrandUI.this).packageExt, "up_"))
      {
        AppMethodBeat.o(71898);
        return 2519;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.lT(WalletBrandUI.f(WalletBrandUI.this).packageExt, "tax_"))
      {
        AppMethodBeat.o(71898);
        return 2923;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.lT(WalletBrandUI.f(WalletBrandUI.this).packageExt, "dc_"))
      {
        AppMethodBeat.o(71898);
        return 2798;
      }
      AppMethodBeat.o(71898);
      return 398;
    }
    
    public final q gNc()
    {
      AppMethodBeat.i(71896);
      Object localObject = WalletBrandUI.f(WalletBrandUI.this).appId;
      String str1 = WalletBrandUI.f(WalletBrandUI.this).signType;
      String str2 = WalletBrandUI.f(WalletBrandUI.this).nonceStr;
      String str3 = WalletBrandUI.f(WalletBrandUI.this).packageExt;
      String str4 = WalletBrandUI.f(WalletBrandUI.this).fOW;
      String str5 = WalletBrandUI.f(WalletBrandUI.this).timeStamp;
      String str6 = WalletBrandUI.f(WalletBrandUI.this).url;
      String str7 = WalletBrandUI.f(WalletBrandUI.this).fOX;
      int i = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      int j = WalletBrandUI.f(WalletBrandUI.this).fOY;
      int k = WalletBrandUI.f(WalletBrandUI.this).Rzu;
      String str8 = WalletBrandUI.f(WalletBrandUI.this).ltk;
      if (com.tencent.mm.plugin.wallet_index.c.a.lT(str3, "up_")) {
        localObject = new l((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.wallet_index.c.f)localObject).setProcessSessionId(System.currentTimeMillis());
        ((com.tencent.mm.plugin.wallet_index.c.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet_index.c.f)localObject).setScene(WalletBrandUI.f(WalletBrandUI.this).fOY);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
        AppMethodBeat.o(71896);
        return localObject;
        if (com.tencent.mm.plugin.wallet_index.c.a.lT(str3, "tax_")) {
          localObject = new k((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else if (com.tencent.mm.plugin.wallet_index.c.a.lT(str3, "dc_")) {
          localObject = new com.tencent.mm.plugin.wallet_index.c.d((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else {
          localObject = new com.tencent.mm.plugin.wallet_index.c.f((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        }
      }
    }
    
    public final String gNd()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71897);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.wallet_index.c.f localf = (com.tencent.mm.plugin.wallet_index.c.f)paramq;
        localObject1 = localf.Pju;
        Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(localObject1)));
        this.mReqKey = ((String)localObject1);
        EventCenter.instance.publish(new aaw());
        Object localObject2 = ((com.tencent.mm.plugin.wallet_index.c.f)paramq).Pjw;
        if ((localObject2 != null) && (!Util.isNullOrNil(((fhv)localObject2).UHJ)))
        {
          Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand start WalletMixOrderInfoUI");
          paramString = new Intent();
          paramString.putExtra("prepayId", (String)localObject1);
          paramString.putExtra("is_jsapi_offline_pay", false);
          paramString.putExtra("pay_gate_url", ((fhv)localObject2).UHJ);
          paramString.putExtra("need_dialog", ((fhv)localObject2).UHL);
          paramString.putExtra("dialog_text", ((fhv)localObject2).UHM);
          paramString.putExtra("max_count", ((fhv)localObject2).UHK.Sdg);
          paramString.putExtra("inteval_time", ((fhv)localObject2).UHK.Sdf);
          paramString.putExtra("default_wording", ((fhv)localObject2).UHK.Sdh);
          com.tencent.mm.by.c.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
          AppMethodBeat.o(71897);
          return;
        }
        Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand startPay");
        localObject2 = new PayInfo();
        ((PayInfo)localObject2).fwv = ((String)localObject1);
        ((PayInfo)localObject2).appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        ((PayInfo)localObject2).Pjv = localf.Pjv;
        ((PayInfo)localObject2).fOY = WalletBrandUI.f(WalletBrandUI.this).fOY;
        ((PayInfo)localObject2).errMsg = paramString;
        ((PayInfo)localObject2).channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
        ((PayInfo)localObject2).Rzj = localf.sessionId;
        if (((PayInfo)localObject2).lfu == null) {
          ((PayInfo)localObject2).lfu = new Bundle();
        }
        ((PayInfo)localObject2).lfu.putString("extinfo_key_20", ((com.tencent.mm.plugin.wallet_index.c.f)paramq).Pjx);
        ((PayInfo)localObject2).lfu.putString("extinfo_key_21", WalletBrandUI.f(WalletBrandUI.this).Rzy);
        ((PayInfo)localObject2).lfu.putString("extinfo_key_22", WalletBrandUI.f(WalletBrandUI.this).Rzz);
        af.B(((PayInfo)localObject2).fOY, (String)localObject1, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, (PayInfo)localObject2, 1);
        AppMethodBeat.o(71897);
        return;
      }
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand dialog");
      af.B(WalletBrandUI.f(WalletBrandUI.this).fOY, "", paramInt2);
      if (WalletBrandUI.f(WalletBrandUI.this).fOY == 3)
      {
        paramq = WalletBrandUI.this;
        if (Util.isNullOrNil(paramString)) {
          paramString = WalletBrandUI.this.getString(a.i.wallet_net_err);
        }
        for (;;)
        {
          paramString = com.tencent.mm.ui.base.h.a(paramq, paramString, "", WalletBrandUI.this.getString(a.i.wallet_dialog_confirm), false, new DialogInterface.OnClickListener()
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
        paramq = WalletBrandUI.this.getString(a.i.wallet_net_err);
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_msg", paramq);
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_dialog_confirm", WalletBrandUI.this.getString(a.i.wallet_dialog_confirm));
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
    
    public final int gNb()
    {
      return 2755;
    }
    
    public final q gNc()
    {
      AppMethodBeat.i(71899);
      e locale = new e(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).fOW, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).fOX, WalletBrandUI.f(WalletBrandUI.this).payChannel, WalletBrandUI.f(WalletBrandUI.this).fOY, WalletBrandUI.f(WalletBrandUI.this).extInfo);
      locale.setProcessSessionId(System.currentTimeMillis());
      locale.setProcessName("PayProcess");
      locale.setScene(WalletBrandUI.f(WalletBrandUI.this).fOY);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(locale, 0);
      AppMethodBeat.o(71899);
      return locale;
    }
    
    public final String gNd()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(71900);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = (e)paramq;
        String str = paramq.Pju;
        this.mReqKey = str;
        Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
        PayInfo localPayInfo = new PayInfo();
        localPayInfo.fwv = str;
        localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        localPayInfo.Pjv = paramq.Pjv;
        localPayInfo.fOY = WalletBrandUI.f(WalletBrandUI.this).fOY;
        localPayInfo.errMsg = paramString;
        localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
        localPayInfo.Rzj = paramq.sessionId;
        af.B(localPayInfo.fOY, str, paramInt2);
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