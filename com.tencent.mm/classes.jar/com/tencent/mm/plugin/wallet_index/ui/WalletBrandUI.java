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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  public boolean BQA;
  private com.tencent.mm.sdk.b.c BQB;
  private com.tencent.mm.sdk.b.c BQC;
  private boolean BQt;
  private b BQu;
  private n BQv;
  private WalletJsapiData BQw;
  private final int BQx;
  public String BQy;
  private int BQz;
  private int dAs;
  public VoidBoolStringI32StringCallback fXP;
  public VoidCallback fXQ;
  private Dialog tipDialog;
  
  public WalletBrandUI()
  {
    AppMethodBeat.i(71901);
    this.BQt = false;
    this.tipDialog = null;
    this.BQv = null;
    this.BQx = (hashCode() & 0xFFFF);
    this.BQy = "";
    this.fXP = null;
    this.fXQ = null;
    this.BQA = false;
    this.BQB = new com.tencent.mm.sdk.b.c() {};
    this.BQC = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71901);
  }
  
  private static String azT(String paramString)
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
  
  private static boolean azU(String paramString)
  {
    AppMethodBeat.i(182531);
    ac.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda: %s", new Object[] { paramString });
    if (paramString.startsWith("sns_"))
    {
      ac.i("MicroMsg.WalletBrandUI", "prepay_id starts With sns_");
      AppMethodBeat.o(182531);
      return true;
    }
    if (paramString.startsWith("tax_"))
    {
      ac.i("MicroMsg.WalletBrandUI", "prepay_id starts With tax_");
      com.tencent.mm.wallet_core.b.fzz();
      if (com.tencent.mm.wallet_core.b.b(b.a.pUU, false))
      {
        ac.i("MicroMsg.WalletBrandUI", "open KindaTaxPaySwitch");
        AppMethodBeat.o(182531);
        return false;
      }
      AppMethodBeat.o(182531);
      return true;
    }
    AppMethodBeat.o(182531);
    return false;
  }
  
  private boolean euX()
  {
    AppMethodBeat.i(71910);
    com.tencent.mm.wallet_core.b.fzz();
    if ((com.tencent.mm.wallet_core.b.b(b.a.pRO, true)) && (this.BQw.packageExt != null))
    {
      String str = azT(this.BQw.packageExt);
      if (str == null)
      {
        bool = ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_EMPTY_PREPAY_ID_PAY_SWTICH_KEY");
        AppMethodBeat.o(71910);
        return bool;
      }
      boolean bool = azU(str);
      ac.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda :%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(71910);
        return false;
      }
      if (((this.BQw.dqL == 3) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_JSAPI_PAY_SWTICH_KEY"))) || ((this.BQw.dqL == 46) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TINYAPP_PAY_SWTICH_KEY"))))
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
    ac.i("MicroMsg.WalletBrandUI", "sendMiniAppPayResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    xw localxw = new xw();
    localxw.dBo.intent = paramIntent;
    localxw.dBo.dBn = 1;
    localxw.dBo.dac = "key_from_scene_appbrandgame";
    localxw.dBo.result = paramInt;
    localxw.dBo.requestCode = this.BQz;
    com.tencent.mm.sdk.b.a.GpY.l(localxw);
    AppMethodBeat.o(174530);
  }
  
  public final void o(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182530);
    ac.i("MicroMsg.WalletBrandUI", "sendPaySuccessAheadCallbackResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.BQw != null) && (this.BQw.DHg != null))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (localIntent.getExtras() == null) {
        localIntent.putExtras(new Bundle());
      }
      this.BQw.DHg.send(paramInt, localIntent.getExtras());
    }
    AppMethodBeat.o(182530);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71909);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + paramInt2 + " requestCode: " + paramInt1);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((this.BQA) && (paramInt1 == 4) && (paramIntent != null))
    {
      ac.i("MicroMsg.WalletBrandUI", "onActivityResult For Face Action,resultCode : ".concat(String.valueOf(paramInt2)));
      int i = paramIntent.getIntExtra("err_code", 0);
      paramInt1 = paramIntent.getIntExtra("scene", 0);
      int j = paramIntent.getIntExtra("countFace", 0);
      long l = paramIntent.getLongExtra("totalTime", 0L);
      int k = paramIntent.getIntExtra("err_type", 6);
      ac.i("MicroMsg.WalletBrandUI", "errCode： ".concat(String.valueOf(i)));
      ac.i("MicroMsg.WalletBrandUI", "scene： ".concat(String.valueOf(paramInt1)));
      ac.i("MicroMsg.WalletBrandUI", "countFace： ".concat(String.valueOf(j)));
      ac.i("MicroMsg.WalletBrandUI", "totalTime： ".concat(String.valueOf(l)));
      ac.i("MicroMsg.WalletBrandUI", "errorType： ".concat(String.valueOf(k)));
      if (paramInt2 == -1)
      {
        if ((this.fXP != null) && (paramIntent.getExtras() != null))
        {
          paramIntent = paramIntent.getExtras().getString("token");
          this.fXP.call(false, paramIntent, i, "");
          this.fXP = null;
          AppMethodBeat.o(71909);
          return;
          ac.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
        }
      }
      else if ((this.fXP != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((bs.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label447;
        }
      }
      label447:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        ac.i("MicroMsg.WalletBrandUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
        if (paramInt1 != 0)
        {
          ac.i("MicroMsg.WalletBrandUI", "check face failed, click other verify");
          this.fXP.call(true, "", i, "");
          this.fXP = null;
        }
        if (paramInt2 == 0)
        {
          ac.i("MicroMsg.WalletBrandUI", "resultCode：RESULT_CANCELED");
          if (this.fXQ != null)
          {
            this.fXQ.call();
            this.fXQ = null;
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
    this.BQw = ((WalletJsapiData)getIntent().getParcelableExtra("WalletJsapiData"));
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    if (this.BQw == null)
    {
      ac.w("MicroMsg.WalletBrandUI", "no jsapi data");
      finish();
      AppMethodBeat.o(71902);
      return;
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.fDB();
    if (this.BQw.DHc != null) {
      this.BQy = this.BQw.DHc;
    }
    this.dAs = this.BQw.dqL;
    if (this.BQy.equalsIgnoreCase("key_from_scene_appbrandgame"))
    {
      this.BQz = this.BQw.dqM;
      this.BQw.dqM = 0;
    }
    ab.fAq();
    int i = this.BQw.DGX;
    ac.i("MicroMsg.WalletBrandUI", "onCreate appbrandScene:%s,payScene:%d,requestCode:%d", new Object[] { this.BQy, Integer.valueOf(this.dAs), Integer.valueOf(this.BQz) });
    if (u.axL())
    {
      ac.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.BQu = new e();
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.c(this.BQB);
      com.tencent.mm.sdk.b.a.GpY.c(this.BQC);
      if (!(this.BQu instanceof c)) {
        break;
      }
      ac.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
      AppMethodBeat.o(71902);
      return;
      if (i == 2)
      {
        ac.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.BQu = new a();
      }
      else if (i == 3)
      {
        ac.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.BQu = new g();
      }
      else if (i == 4)
      {
        ac.i("MicroMsg.WalletBrandUI", "do pay with component");
        this.BQu = new d();
      }
      else if (euX())
      {
        ac.i("MicroMsg.WalletBrandUI", "do pay with kinda");
        this.BQu = new c();
      }
      else
      {
        ac.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.BQu = new f();
      }
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.BQu.euY(), this);
    AppMethodBeat.o(71902);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71903);
    ac.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    if ((this.BQu instanceof c)) {
      ac.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.GpY.d(this.BQB);
      com.tencent.mm.sdk.b.a.GpY.d(this.BQC);
      AppMethodBeat.o(71903);
      return;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(this.BQu.euY(), this);
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
    ac.i("MicroMsg.WalletBrandUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71904);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71905);
    ac.i("MicroMsg.WalletBrandUI", "onResume");
    super.onResume();
    ac.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.BQt), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.BQt)
    {
      this.BQt = true;
      this.BQv = this.BQu.euZ();
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((!euX()) && (this.BQw.DGX != 4)) {
        this.tipDialog = com.tencent.mm.wallet_core.ui.g.b(this, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(71882);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(WalletBrandUI.a(WalletBrandUI.this));
            WalletBrandUI.this.finish();
            AppMethodBeat.o(71882);
          }
        });
      }
    }
    AppMethodBeat.o(71905);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71908);
    ac.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn, this.BQv });
    if ((paramn.getType() != this.BQu.euY()) || (paramn != this.BQv))
    {
      AppMethodBeat.o(71908);
      return;
    }
    this.BQu.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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
    private int BQE = 0;
    private String mReqKey = "";
    
    public a() {}
    
    public final int euY()
    {
      return 1563;
    }
    
    public final n euZ()
    {
      AppMethodBeat.i(71887);
      this.BQE = WalletBrandUI.f(WalletBrandUI.this).DGZ;
      int i = WalletBrandUI.f(WalletBrandUI.this).dcB;
      com.tencent.mm.plugin.wallet_index.c.a.a locala = new com.tencent.mm.plugin.wallet_index.c.a.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dqJ, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dqK, i);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(locala, 0);
      AppMethodBeat.o(71887);
      return locala;
    }
    
    public final String eva()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71888);
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.a.a)))
      {
        paramString = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramn).jumpUrl;
        ac.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[] { paramString });
        this.mReqKey = paramString;
        paramn = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramn).BPN;
        Intent localIntent;
        if (this.BQE == 1)
        {
          localIntent = new Intent();
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("jsInjectCode", paramn);
          WalletBrandUI.this.setResult(-1, localIntent);
        }
        for (;;)
        {
          WalletBrandUI.this.finish();
          AppMethodBeat.o(71888);
          return;
          localIntent = new Intent();
          localIntent.putExtra("rawUrl", paramString);
          localIntent.putExtra("showShare", false);
          if (!bs.isNullOrNil(paramn))
          {
            localIntent.putExtra("shouldForceViewPort", true);
            localIntent.putExtra("view_port_code", paramn);
          }
          com.tencent.mm.wallet_core.ui.e.al(WalletBrandUI.this.getContext(), localIntent);
          WalletBrandUI.this.setResult(-1);
        }
      }
      ac.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.a(WalletBrandUI.this, paramString, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    public abstract int euY();
    
    public abstract n euZ();
    
    public abstract String eva();
    
    public abstract void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  }
  
  class c
    implements WalletBrandUI.b
  {
    c() {}
    
    public final int euY()
    {
      return 0;
    }
    
    public n euZ()
    {
      AppMethodBeat.i(71890);
      MMActivity.a local1 = new MMActivity.a()
      {
        private Intent BQG;
        
        private void p(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174529);
          ac.i("MicroMsg.WalletBrandUI", "KindaBrand.kindaEndWithResult resultCode: %d, data: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousIntent.toString() });
          WalletBrandUI.this.setResult(paramAnonymousInt, paramAnonymousIntent);
          AppMethodBeat.o(174529);
        }
        
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(71889);
          if (paramAnonymousInt1 != WalletBrandUI.g(WalletBrandUI.this))
          {
            AppMethodBeat.o(71889);
            return;
          }
          if (paramAnonymousIntent == null)
          {
            ac.e("MicroMsg.WalletBrandUI", bs.m(new Throwable("KindaBrand Intent data null!")));
            AppMethodBeat.o(71889);
            return;
          }
          if (paramAnonymousInt2 == -1)
          {
            if (paramAnonymousIntent.hasExtra("key_jsapi_close_page_after_pay"))
            {
              ac.i("MicroMsg.WalletBrandUI", "KindaBrand.mmOnActivityResult ClosePage data: %s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousIntent.toString() });
              paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_close_page_after_pay", 0);
              this.BQG.putExtra("key_jsapi_close_page_after_pay", paramAnonymousInt1);
              WalletBrandUI.this.setResult(paramAnonymousInt2, this.BQG);
              AppMethodBeat.o(71889);
              return;
            }
            this.BQG.putExtras(paramAnonymousIntent);
            p(paramAnonymousInt2, this.BQG);
            AppMethodBeat.o(71889);
            return;
          }
          p(paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(71889);
        }
      };
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayJsApiPay(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), local1, WalletBrandUI.g(WalletBrandUI.this));
      AppMethodBeat.o(71890);
      return null;
    }
    
    public final String eva()
    {
      return "";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn) {}
  }
  
  final class d
    extends WalletBrandUI.c
  {
    d()
    {
      super();
    }
    
    public final n euZ()
    {
      AppMethodBeat.i(71892);
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startJsApiComponentUseCase(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
    
    public final int euY()
    {
      return 1521;
    }
    
    public final n euZ()
    {
      AppMethodBeat.i(71893);
      com.tencent.mm.plugin.wallet_index.c.b.a locala = new com.tencent.mm.plugin.wallet_index.c.b.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dqJ, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dqK, WalletBrandUI.f(WalletBrandUI.this).dcB);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(locala, 0);
      AppMethodBeat.o(71893);
      return locala;
    }
    
    public final String eva()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71894);
      paramn = (com.tencent.mm.plugin.wallet_index.c.b.a)paramn;
      String str = paramn.BPz;
      ac.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
      this.mReqKey = str;
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.dac = str;
      localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
      localPayInfo.BPA = paramn.BPA;
      localPayInfo.dqL = WalletBrandUI.f(WalletBrandUI.this).dqL;
      localPayInfo.errMsg = paramString;
      localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).dcB;
      f.a(WalletBrandUI.this, localPayInfo, 1);
      AppMethodBeat.o(71894);
    }
  }
  
  final class f
    implements WalletBrandUI.b
  {
    private String mReqKey = "";
    
    f() {}
    
    public final int euY()
    {
      AppMethodBeat.i(71898);
      ac.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand getGenPrepayFuncId packageExt:%s", new Object[] { WalletBrandUI.f(WalletBrandUI.this).packageExt });
      if (com.tencent.mm.plugin.wallet_index.c.a.kc(WalletBrandUI.f(WalletBrandUI.this).packageExt, "up_"))
      {
        AppMethodBeat.o(71898);
        return 2519;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.kc(WalletBrandUI.f(WalletBrandUI.this).packageExt, "tax_"))
      {
        AppMethodBeat.o(71898);
        return 2923;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.kc(WalletBrandUI.f(WalletBrandUI.this).packageExt, "dc_"))
      {
        AppMethodBeat.o(71898);
        return 2798;
      }
      AppMethodBeat.o(71898);
      return 398;
    }
    
    public final n euZ()
    {
      AppMethodBeat.i(71896);
      Object localObject = WalletBrandUI.f(WalletBrandUI.this).appId;
      String str1 = WalletBrandUI.f(WalletBrandUI.this).signType;
      String str2 = WalletBrandUI.f(WalletBrandUI.this).nonceStr;
      String str3 = WalletBrandUI.f(WalletBrandUI.this).packageExt;
      String str4 = WalletBrandUI.f(WalletBrandUI.this).dqJ;
      String str5 = WalletBrandUI.f(WalletBrandUI.this).timeStamp;
      String str6 = WalletBrandUI.f(WalletBrandUI.this).url;
      String str7 = WalletBrandUI.f(WalletBrandUI.this).dqK;
      int i = WalletBrandUI.f(WalletBrandUI.this).dcB;
      int j = WalletBrandUI.f(WalletBrandUI.this).dqL;
      int k = WalletBrandUI.f(WalletBrandUI.this).DGW;
      String str8 = WalletBrandUI.f(WalletBrandUI.this).hnq;
      if (com.tencent.mm.plugin.wallet_index.c.a.kc(str3, "up_")) {
        localObject = new k((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.wallet_index.c.e)localObject).setProcessSessionId(System.currentTimeMillis());
        ((com.tencent.mm.plugin.wallet_index.c.e)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet_index.c.e)localObject).setScene(WalletBrandUI.f(WalletBrandUI.this).dqL);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
        AppMethodBeat.o(71896);
        return localObject;
        if (com.tencent.mm.plugin.wallet_index.c.a.kc(str3, "tax_")) {
          localObject = new j((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else if (com.tencent.mm.plugin.wallet_index.c.a.kc(str3, "dc_")) {
          localObject = new com.tencent.mm.plugin.wallet_index.c.c((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else {
          localObject = new com.tencent.mm.plugin.wallet_index.c.e((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        }
      }
    }
    
    public final String eva()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71897);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.wallet_index.c.e locale = (com.tencent.mm.plugin.wallet_index.c.e)paramn;
        localObject1 = locale.BPz;
        ac.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(localObject1)));
        this.mReqKey = ((String)localObject1);
        com.tencent.mm.sdk.b.a.GpY.l(new xk());
        Object localObject2 = ((com.tencent.mm.plugin.wallet_index.c.e)paramn).BPB;
        if ((localObject2 != null) && (!bs.isNullOrNil(((dvk)localObject2).GcR)))
        {
          ac.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand start WalletMixOrderInfoUI");
          paramString = new Intent();
          paramString.putExtra("prepayId", (String)localObject1);
          paramString.putExtra("is_jsapi_offline_pay", false);
          paramString.putExtra("pay_gate_url", ((dvk)localObject2).GcR);
          paramString.putExtra("need_dialog", ((dvk)localObject2).GcT);
          paramString.putExtra("dialog_text", ((dvk)localObject2).GcU);
          paramString.putExtra("max_count", ((dvk)localObject2).GcS.EhK);
          paramString.putExtra("inteval_time", ((dvk)localObject2).GcS.EhJ);
          paramString.putExtra("default_wording", ((dvk)localObject2).GcS.EhL);
          com.tencent.mm.br.d.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
          AppMethodBeat.o(71897);
          return;
        }
        ac.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand startPay");
        localObject2 = new PayInfo();
        ((PayInfo)localObject2).dac = ((String)localObject1);
        ((PayInfo)localObject2).appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        ((PayInfo)localObject2).BPA = locale.BPA;
        ((PayInfo)localObject2).dqL = WalletBrandUI.f(WalletBrandUI.this).dqL;
        ((PayInfo)localObject2).errMsg = paramString;
        ((PayInfo)localObject2).channel = WalletBrandUI.f(WalletBrandUI.this).dcB;
        ((PayInfo)localObject2).DGM = locale.sessionId;
        if (((PayInfo)localObject2).hbR == null) {
          ((PayInfo)localObject2).hbR = new Bundle();
        }
        ((PayInfo)localObject2).hbR.putString("extinfo_key_20", ((com.tencent.mm.plugin.wallet_index.c.e)paramn).BPC);
        ((PayInfo)localObject2).hbR.putString("extinfo_key_21", WalletBrandUI.f(WalletBrandUI.this).DHa);
        ((PayInfo)localObject2).hbR.putString("extinfo_key_22", WalletBrandUI.f(WalletBrandUI.this).DHb);
        af.x(((PayInfo)localObject2).dqL, (String)localObject1, paramInt2);
        f.a(WalletBrandUI.this, (PayInfo)localObject2, 1);
        AppMethodBeat.o(71897);
        return;
      }
      ac.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand dialog");
      af.x(WalletBrandUI.f(WalletBrandUI.this).dqL, "", paramInt2);
      if (WalletBrandUI.f(WalletBrandUI.this).dqL == 3)
      {
        paramn = WalletBrandUI.this;
        if (bs.isNullOrNil(paramString)) {
          paramString = WalletBrandUI.this.getString(2131765520);
        }
        for (;;)
        {
          paramString = h.a(paramn, paramString, "", WalletBrandUI.this.getString(2131765243), false, new DialogInterface.OnClickListener()
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
      ac.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand setResult ResultPayFailed");
      Object localObject1 = new Intent();
      if (paramInt1 != 0) {
        paramInt2 = -1;
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_onActivityResult", "jsapi_pay_onActivityResult");
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_code", paramInt2);
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = WalletBrandUI.this.getString(2131765520);
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_msg", paramn);
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_dialog_confirm", WalletBrandUI.this.getString(2131765243));
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
    
    public final int euY()
    {
      return 2755;
    }
    
    public final n euZ()
    {
      AppMethodBeat.i(71899);
      com.tencent.mm.plugin.wallet_index.c.d locald = new com.tencent.mm.plugin.wallet_index.c.d(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dqJ, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dqK, WalletBrandUI.f(WalletBrandUI.this).dcB, WalletBrandUI.f(WalletBrandUI.this).dqL, WalletBrandUI.f(WalletBrandUI.this).extInfo);
      locald.setProcessSessionId(System.currentTimeMillis());
      locald.setProcessName("PayProcess");
      locald.setScene(WalletBrandUI.f(WalletBrandUI.this).dqL);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(locald, 0);
      AppMethodBeat.o(71899);
      return locald;
    }
    
    public final String eva()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71900);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.wallet_index.c.d)paramn;
        String str = paramn.BPz;
        this.mReqKey = str;
        ac.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
        PayInfo localPayInfo = new PayInfo();
        localPayInfo.dac = str;
        localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        localPayInfo.BPA = paramn.BPA;
        localPayInfo.dqL = WalletBrandUI.f(WalletBrandUI.this).dqL;
        localPayInfo.errMsg = paramString;
        localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).dcB;
        localPayInfo.DGM = paramn.sessionId;
        af.x(localPayInfo.dqL, str, paramInt2);
        f.a(WalletBrandUI.this, localPayInfo, 1);
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