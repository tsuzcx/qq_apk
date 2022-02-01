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
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yv;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wallet_index.c.e;
import com.tencent.mm.plugin.wallet_index.c.j;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.af;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.sdk.b.c DIA;
  private boolean DIs;
  private b DIt;
  private WalletJsapiData DIu;
  private final int DIv;
  public String DIw;
  private int DIx;
  public boolean DIy;
  private com.tencent.mm.sdk.b.c DIz;
  private int dNV;
  private n ghA;
  public VoidBoolStringI32StringCallback gtL;
  public VoidCallback gtM;
  private Dialog tipDialog;
  
  public WalletBrandUI()
  {
    AppMethodBeat.i(71901);
    this.DIs = false;
    this.tipDialog = null;
    this.ghA = null;
    this.DIv = (hashCode() & 0xFFFF);
    this.DIw = "";
    this.gtL = null;
    this.gtM = null;
    this.DIy = false;
    this.DIz = new com.tencent.mm.sdk.b.c() {};
    this.DIA = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71901);
  }
  
  private static String aGx(String paramString)
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
  
  private static boolean aGy(String paramString)
  {
    AppMethodBeat.i(182531);
    ae.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda: %s", new Object[] { paramString });
    if (paramString.startsWith("tax_"))
    {
      ae.i("MicroMsg.WalletBrandUI", "prepay_id starts With tax_");
      com.tencent.mm.wallet_core.b.fVf();
      if (com.tencent.mm.wallet_core.b.b(b.a.qGG, false))
      {
        ae.i("MicroMsg.WalletBrandUI", "open KindaTaxPaySwitch");
        AppMethodBeat.o(182531);
        return false;
      }
      AppMethodBeat.o(182531);
      return true;
    }
    AppMethodBeat.o(182531);
    return false;
  }
  
  private boolean eML()
  {
    AppMethodBeat.i(71910);
    com.tencent.mm.wallet_core.b.fVf();
    if ((com.tencent.mm.wallet_core.b.b(b.a.qDk, true)) && (this.DIu.packageExt != null))
    {
      String str = aGx(this.DIu.packageExt);
      if (str == null)
      {
        bool = ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_EMPTY_PREPAY_ID_PAY_SWTICH_KEY");
        AppMethodBeat.o(71910);
        return bool;
      }
      boolean bool = aGy(str);
      ae.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda :%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(71910);
        return false;
      }
      if (((this.DIu.dDH == 3) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_JSAPI_PAY_SWTICH_KEY"))) || ((this.DIu.dDH == 46) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TINYAPP_PAY_SWTICH_KEY"))))
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
    ae.i("MicroMsg.WalletBrandUI", "sendMiniAppPayResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    yw localyw = new yw();
    localyw.dOR.intent = paramIntent;
    localyw.dOR.dOQ = 1;
    localyw.dOR.dmw = "key_from_scene_appbrandgame";
    localyw.dOR.result = paramInt;
    localyw.dOR.requestCode = this.DIx;
    com.tencent.mm.sdk.b.a.IvT.l(localyw);
    AppMethodBeat.o(174530);
  }
  
  public final void o(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182530);
    ae.i("MicroMsg.WalletBrandUI", "sendPaySuccessAheadCallbackResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.DIu != null) && (this.DIu.FEL != null))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (localIntent.getExtras() == null) {
        localIntent.putExtras(new Bundle());
      }
      this.DIu.FEL.send(paramInt, localIntent.getExtras());
    }
    AppMethodBeat.o(182530);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71909);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.WalletBrandUI", "onActivityResultresultCode : " + paramInt2 + " requestCode: " + paramInt1);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    while ((this.DIy) && (paramInt1 == 4) && (paramIntent != null))
    {
      ae.i("MicroMsg.WalletBrandUI", "onActivityResult For Face Action,resultCode : ".concat(String.valueOf(paramInt2)));
      int i = paramIntent.getIntExtra("err_code", 0);
      paramInt1 = paramIntent.getIntExtra("scene", 0);
      int j = paramIntent.getIntExtra("countFace", 0);
      long l = paramIntent.getLongExtra("totalTime", 0L);
      int k = paramIntent.getIntExtra("err_type", 6);
      ae.i("MicroMsg.WalletBrandUI", "errCode： ".concat(String.valueOf(i)));
      ae.i("MicroMsg.WalletBrandUI", "scene： ".concat(String.valueOf(paramInt1)));
      ae.i("MicroMsg.WalletBrandUI", "countFace： ".concat(String.valueOf(j)));
      ae.i("MicroMsg.WalletBrandUI", "totalTime： ".concat(String.valueOf(l)));
      ae.i("MicroMsg.WalletBrandUI", "errorType： ".concat(String.valueOf(k)));
      if (paramInt2 == -1)
      {
        if ((this.gtL != null) && (paramIntent.getExtras() != null))
        {
          paramIntent = paramIntent.getExtras().getString("token");
          this.gtL.call(false, paramIntent, i, "");
          this.gtL = null;
          AppMethodBeat.o(71909);
          return;
          ae.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
        }
      }
      else if ((this.gtL != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((bu.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label447;
        }
      }
      label447:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        ae.i("MicroMsg.WalletBrandUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
        if (paramInt1 != 0)
        {
          ae.i("MicroMsg.WalletBrandUI", "check face failed, click other verify");
          this.gtL.call(true, "", i, "");
          this.gtL = null;
        }
        if (paramInt2 == 0)
        {
          ae.i("MicroMsg.WalletBrandUI", "resultCode：RESULT_CANCELED");
          if (this.gtM != null)
          {
            this.gtM.call();
            this.gtM = null;
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
    this.DIu = ((WalletJsapiData)getIntent().getParcelableExtra("WalletJsapiData"));
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    if (this.DIu == null)
    {
      ae.w("MicroMsg.WalletBrandUI", "no jsapi data");
      finish();
      AppMethodBeat.o(71902);
      return;
    }
    ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.fZs();
    if (this.DIu.FEH != null) {
      this.DIw = this.DIu.FEH;
    }
    this.dNV = this.DIu.dDH;
    if (this.DIw.equalsIgnoreCase("key_from_scene_appbrandgame"))
    {
      this.DIx = this.DIu.dDI;
      this.DIu.dDI = 0;
    }
    ab.fVW();
    int i = this.DIu.FEC;
    ae.i("MicroMsg.WalletBrandUI", "onCreate appbrandScene:%s,payScene:%d,requestCode:%d", new Object[] { this.DIw, Integer.valueOf(this.dNV), Integer.valueOf(this.DIx) });
    if (v.aAR())
    {
      ae.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.DIt = new e();
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.c(this.DIz);
      com.tencent.mm.sdk.b.a.IvT.c(this.DIA);
      if (!(this.DIt instanceof c)) {
        break;
      }
      ae.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
      AppMethodBeat.o(71902);
      return;
      if (i == 2)
      {
        ae.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.DIt = new a();
      }
      else if (i == 3)
      {
        ae.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.DIt = new g();
      }
      else if (i == 4)
      {
        ae.i("MicroMsg.WalletBrandUI", "do pay with component");
        this.DIt = new d();
      }
      else if (eML())
      {
        ae.i("MicroMsg.WalletBrandUI", "do pay with kinda");
        this.DIt = new c();
      }
      else
      {
        ae.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.DIt = new f();
      }
    }
    g.ajS();
    g.ajQ().gDv.a(this.DIt.eMM(), this);
    AppMethodBeat.o(71902);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71903);
    ae.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    if ((this.DIt instanceof c)) {
      ae.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.IvT.d(this.DIz);
      com.tencent.mm.sdk.b.a.IvT.d(this.DIA);
      AppMethodBeat.o(71903);
      return;
      g.ajS();
      g.ajQ().gDv.b(this.DIt.eMM(), this);
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
    ae.i("MicroMsg.WalletBrandUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71904);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71905);
    ae.i("MicroMsg.WalletBrandUI", "onResume");
    super.onResume();
    ae.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.DIs), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.DIs)
    {
      this.DIs = true;
      this.ghA = this.DIt.eMN();
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((!eML()) && (this.DIu.FEC != 4)) {
        this.tipDialog = com.tencent.mm.wallet_core.ui.h.b(this, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(71882);
            g.ajS();
            g.ajQ().gDv.a(WalletBrandUI.a(WalletBrandUI.this));
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
    ae.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn, this.ghA });
    if ((paramn.getType() != this.DIt.eMM()) || (paramn != this.ghA))
    {
      AppMethodBeat.o(71908);
      return;
    }
    this.DIt.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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
    private int DIC = 0;
    private String mReqKey = "";
    
    public a() {}
    
    public final int eMM()
    {
      return 1563;
    }
    
    public final n eMN()
    {
      AppMethodBeat.i(71887);
      this.DIC = WalletBrandUI.f(WalletBrandUI.this).FEE;
      int i = WalletBrandUI.f(WalletBrandUI.this).dpc;
      com.tencent.mm.plugin.wallet_index.c.a.a locala = new com.tencent.mm.plugin.wallet_index.c.a.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dDF, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dDG, i);
      g.ajS();
      g.ajQ().gDv.a(locala, 0);
      AppMethodBeat.o(71887);
      return locala;
    }
    
    public final String eMO()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71888);
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.a.a)))
      {
        paramString = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramn).jumpUrl;
        ae.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[] { paramString });
        this.mReqKey = paramString;
        paramn = ((com.tencent.mm.plugin.wallet_index.c.a.a)paramn).DHL;
        Intent localIntent;
        if (this.DIC == 1)
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
          if (!bu.isNullOrNil(paramn))
          {
            localIntent.putExtra("shouldForceViewPort", true);
            localIntent.putExtra("view_port_code", paramn);
          }
          com.tencent.mm.wallet_core.ui.f.an(WalletBrandUI.this.getContext(), localIntent);
          WalletBrandUI.this.setResult(-1);
        }
      }
      ae.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
    public abstract int eMM();
    
    public abstract n eMN();
    
    public abstract String eMO();
    
    public abstract void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  }
  
  class c
    implements WalletBrandUI.b
  {
    c() {}
    
    public final int eMM()
    {
      return 0;
    }
    
    public n eMN()
    {
      AppMethodBeat.i(71890);
      MMActivity.a local1 = new MMActivity.a()
      {
        private Intent DIE;
        
        private void p(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174529);
          ae.i("MicroMsg.WalletBrandUI", "KindaBrand.kindaEndWithResult resultCode: %d, data: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousIntent.toString() });
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
            ae.e("MicroMsg.WalletBrandUI", bu.o(new Throwable("KindaBrand Intent data null!")));
            AppMethodBeat.o(71889);
            return;
          }
          if (paramAnonymousInt2 == -1)
          {
            if (paramAnonymousIntent.hasExtra("key_jsapi_close_page_after_pay"))
            {
              ae.i("MicroMsg.WalletBrandUI", "KindaBrand.mmOnActivityResult ClosePage data: %s", new Object[] { Integer.valueOf(paramAnonymousInt2), paramAnonymousIntent.toString() });
              paramAnonymousInt1 = paramAnonymousIntent.getIntExtra("key_jsapi_close_page_after_pay", 0);
              this.DIE.putExtra("key_jsapi_close_page_after_pay", paramAnonymousInt1);
              WalletBrandUI.this.setResult(paramAnonymousInt2, this.DIE);
              AppMethodBeat.o(71889);
              return;
            }
            this.DIE.putExtras(paramAnonymousIntent);
            p(paramAnonymousInt2, this.DIE);
            AppMethodBeat.o(71889);
            return;
          }
          p(paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(71889);
        }
      };
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayJsApiPay(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), local1, WalletBrandUI.g(WalletBrandUI.this));
      AppMethodBeat.o(71890);
      return null;
    }
    
    public final String eMO()
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
    
    public final n eMN()
    {
      AppMethodBeat.i(71892);
      ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).startJsApiComponentUseCase(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), new MMActivity.a()
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
    
    public final int eMM()
    {
      return 1521;
    }
    
    public final n eMN()
    {
      AppMethodBeat.i(71893);
      com.tencent.mm.plugin.wallet_index.c.b.a locala = new com.tencent.mm.plugin.wallet_index.c.b.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dDF, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dDG, WalletBrandUI.f(WalletBrandUI.this).dpc);
      g.ajS();
      g.ajQ().gDv.a(locala, 0);
      AppMethodBeat.o(71893);
      return locala;
    }
    
    public final String eMO()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71894);
      paramn = (com.tencent.mm.plugin.wallet_index.c.b.a)paramn;
      String str = paramn.DHx;
      ae.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
      this.mReqKey = str;
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.dmw = str;
      localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
      localPayInfo.DHy = paramn.DHy;
      localPayInfo.dDH = WalletBrandUI.f(WalletBrandUI.this).dDH;
      localPayInfo.errMsg = paramString;
      localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).dpc;
      com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, localPayInfo, 1);
      AppMethodBeat.o(71894);
    }
  }
  
  final class f
    implements WalletBrandUI.b
  {
    private String mReqKey = "";
    
    f() {}
    
    public final int eMM()
    {
      AppMethodBeat.i(71898);
      ae.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand getGenPrepayFuncId packageExt:%s", new Object[] { WalletBrandUI.f(WalletBrandUI.this).packageExt });
      if (com.tencent.mm.plugin.wallet_index.c.a.kD(WalletBrandUI.f(WalletBrandUI.this).packageExt, "up_"))
      {
        AppMethodBeat.o(71898);
        return 2519;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.kD(WalletBrandUI.f(WalletBrandUI.this).packageExt, "tax_"))
      {
        AppMethodBeat.o(71898);
        return 2923;
      }
      if (com.tencent.mm.plugin.wallet_index.c.a.kD(WalletBrandUI.f(WalletBrandUI.this).packageExt, "dc_"))
      {
        AppMethodBeat.o(71898);
        return 2798;
      }
      AppMethodBeat.o(71898);
      return 398;
    }
    
    public final n eMN()
    {
      AppMethodBeat.i(71896);
      Object localObject = WalletBrandUI.f(WalletBrandUI.this).appId;
      String str1 = WalletBrandUI.f(WalletBrandUI.this).signType;
      String str2 = WalletBrandUI.f(WalletBrandUI.this).nonceStr;
      String str3 = WalletBrandUI.f(WalletBrandUI.this).packageExt;
      String str4 = WalletBrandUI.f(WalletBrandUI.this).dDF;
      String str5 = WalletBrandUI.f(WalletBrandUI.this).timeStamp;
      String str6 = WalletBrandUI.f(WalletBrandUI.this).url;
      String str7 = WalletBrandUI.f(WalletBrandUI.this).dDG;
      int i = WalletBrandUI.f(WalletBrandUI.this).dpc;
      int j = WalletBrandUI.f(WalletBrandUI.this).dDH;
      int k = WalletBrandUI.f(WalletBrandUI.this).FEB;
      String str8 = WalletBrandUI.f(WalletBrandUI.this).hIA;
      if (com.tencent.mm.plugin.wallet_index.c.a.kD(str3, "up_")) {
        localObject = new k((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      }
      for (;;)
      {
        ((e)localObject).setProcessSessionId(System.currentTimeMillis());
        ((e)localObject).setProcessName("PayProcess");
        ((e)localObject).setScene(WalletBrandUI.f(WalletBrandUI.this).dDH);
        g.ajS();
        g.ajQ().gDv.a((n)localObject, 0);
        AppMethodBeat.o(71896);
        return localObject;
        if (com.tencent.mm.plugin.wallet_index.c.a.kD(str3, "tax_")) {
          localObject = new j((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else if (com.tencent.mm.plugin.wallet_index.c.a.kD(str3, "dc_")) {
          localObject = new com.tencent.mm.plugin.wallet_index.c.c((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else {
          localObject = new e((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        }
      }
    }
    
    public final String eMO()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71897);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        e locale = (e)paramn;
        localObject1 = locale.DHx;
        ae.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(localObject1)));
        this.mReqKey = ((String)localObject1);
        com.tencent.mm.sdk.b.a.IvT.l(new yk());
        Object localObject2 = ((e)paramn).DHz;
        if ((localObject2 != null) && (!bu.isNullOrNil(((eda)localObject2).Iie)))
        {
          ae.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand start WalletMixOrderInfoUI");
          paramString = new Intent();
          paramString.putExtra("prepayId", (String)localObject1);
          paramString.putExtra("is_jsapi_offline_pay", false);
          paramString.putExtra("pay_gate_url", ((eda)localObject2).Iie);
          paramString.putExtra("need_dialog", ((eda)localObject2).Iig);
          paramString.putExtra("dialog_text", ((eda)localObject2).Iih);
          paramString.putExtra("max_count", ((eda)localObject2).Iif.Ghq);
          paramString.putExtra("inteval_time", ((eda)localObject2).Iif.Ghp);
          paramString.putExtra("default_wording", ((eda)localObject2).Iif.Ghr);
          com.tencent.mm.br.d.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
          AppMethodBeat.o(71897);
          return;
        }
        ae.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand startPay");
        localObject2 = new PayInfo();
        ((PayInfo)localObject2).dmw = ((String)localObject1);
        ((PayInfo)localObject2).appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        ((PayInfo)localObject2).DHy = locale.DHy;
        ((PayInfo)localObject2).dDH = WalletBrandUI.f(WalletBrandUI.this).dDH;
        ((PayInfo)localObject2).errMsg = paramString;
        ((PayInfo)localObject2).channel = WalletBrandUI.f(WalletBrandUI.this).dpc;
        ((PayInfo)localObject2).FEr = locale.sessionId;
        if (((PayInfo)localObject2).hwN == null) {
          ((PayInfo)localObject2).hwN = new Bundle();
        }
        ((PayInfo)localObject2).hwN.putString("extinfo_key_20", ((e)paramn).DHA);
        ((PayInfo)localObject2).hwN.putString("extinfo_key_21", WalletBrandUI.f(WalletBrandUI.this).FEF);
        ((PayInfo)localObject2).hwN.putString("extinfo_key_22", WalletBrandUI.f(WalletBrandUI.this).FEG);
        af.w(((PayInfo)localObject2).dDH, (String)localObject1, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, (PayInfo)localObject2, 1);
        AppMethodBeat.o(71897);
        return;
      }
      ae.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand dialog");
      af.w(WalletBrandUI.f(WalletBrandUI.this).dDH, "", paramInt2);
      if (WalletBrandUI.f(WalletBrandUI.this).dDH == 3)
      {
        paramn = WalletBrandUI.this;
        if (bu.isNullOrNil(paramString)) {
          paramString = WalletBrandUI.this.getString(2131765520);
        }
        for (;;)
        {
          paramString = com.tencent.mm.ui.base.h.a(paramn, paramString, "", WalletBrandUI.this.getString(2131765243), false, new DialogInterface.OnClickListener()
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
      ae.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand setResult ResultPayFailed");
      Object localObject1 = new Intent();
      if (paramInt1 != 0) {
        paramInt2 = -1;
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_onActivityResult", "jsapi_pay_onActivityResult");
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_code", paramInt2);
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
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
    
    public final int eMM()
    {
      return 2755;
    }
    
    public final n eMN()
    {
      AppMethodBeat.i(71899);
      com.tencent.mm.plugin.wallet_index.c.d locald = new com.tencent.mm.plugin.wallet_index.c.d(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).dDF, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).dDG, WalletBrandUI.f(WalletBrandUI.this).dpc, WalletBrandUI.f(WalletBrandUI.this).dDH, WalletBrandUI.f(WalletBrandUI.this).extInfo);
      locald.setProcessSessionId(System.currentTimeMillis());
      locald.setProcessName("PayProcess");
      locald.setScene(WalletBrandUI.f(WalletBrandUI.this).dDH);
      g.ajS();
      g.ajQ().gDv.a(locald, 0);
      AppMethodBeat.o(71899);
      return locald;
    }
    
    public final String eMO()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(71900);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramn = (com.tencent.mm.plugin.wallet_index.c.d)paramn;
        String str = paramn.DHx;
        this.mReqKey = str;
        ae.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
        PayInfo localPayInfo = new PayInfo();
        localPayInfo.dmw = str;
        localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        localPayInfo.DHy = paramn.DHy;
        localPayInfo.dDH = WalletBrandUI.f(WalletBrandUI.this).dDH;
        localPayInfo.errMsg = paramString;
        localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).dpc;
        localPayInfo.FEr = paramn.sessionId;
        af.w(localPayInfo.dDH, str, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, localPayInfo, 1);
        AppMethodBeat.o(71900);
        return;
      }
      WalletBrandUI.this.finish();
      AppMethodBeat.o(71900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI
 * JD-Core Version:    0.7.0.1
 */