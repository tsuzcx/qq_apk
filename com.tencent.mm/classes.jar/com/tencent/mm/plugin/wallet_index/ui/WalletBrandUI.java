package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.Window;
import androidx.lifecycle.q;
import com.tencent.kinda.gen.VoidBoolStringI32StringCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.act;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.autogen.a.adf;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wallet_index.model.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.protocal.protobuf.geh;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.model.ac;
import com.tencent.mm.wallet_core.model.ag;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(7)
public class WalletBrandUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private int WbA;
  public boolean WbB;
  private IListener WbC;
  private IListener WbD;
  private boolean Wbv;
  private b Wbw;
  private WalletJsapiData Wbx;
  private final int Wby;
  public String Wbz;
  private int igp;
  private p maU;
  public VoidBoolStringI32StringCallback msH;
  public VoidCallback msI;
  private Dialog tipDialog;
  
  public WalletBrandUI()
  {
    AppMethodBeat.i(71901);
    this.Wbv = false;
    this.tipDialog = null;
    this.maU = null;
    this.Wby = (hashCode() & 0xFFFF);
    this.Wbz = "";
    this.msH = null;
    this.msI = null;
    this.WbB = false;
    this.WbC = new IListener(com.tencent.mm.app.f.hfK) {};
    this.WbD = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(71901);
  }
  
  private static String bhr(String paramString)
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
  
  private static boolean bhs(String paramString)
  {
    AppMethodBeat.i(182531);
    Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda: %s", new Object[] { paramString });
    if (paramString.startsWith("tax_"))
    {
      Log.i("MicroMsg.WalletBrandUI", "prepay_id starts With tax_");
      b.jNX();
      if (b.b(c.a.yWT, true))
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
  
  private boolean isKindaEnabled()
  {
    AppMethodBeat.i(71910);
    b.jNX();
    if ((b.b(c.a.yRc, true)) && (this.Wbx.packageExt != null))
    {
      String str = bhr(this.Wbx.packageExt);
      if (str == null)
      {
        AppMethodBeat.o(71910);
        return true;
      }
      boolean bool = bhs(str);
      Log.i("MicroMsg.WalletBrandUI", "isPrefixDisableKinda :%s", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        AppMethodBeat.o(71910);
        return false;
      }
      if ((this.Wbx.hUR == 3) || (this.Wbx.hUR == 46))
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
    while ((this.WbB) && (paramInt1 == 4) && (paramIntent != null))
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
        if ((this.msH != null) && (paramIntent.getExtras() != null))
        {
          paramIntent = paramIntent.getExtras().getString("token");
          this.msH.call(false, paramIntent, i, "");
          this.msH = null;
          AppMethodBeat.o(71909);
          return;
          Log.i("MicroMsg.WalletBrandUI", "get result to callback? " + paramIntent.getStringExtra("test"));
        }
      }
      else if ((this.msH != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("click_other_verify_btn");
        if ((Util.isNullOrNil(paramIntent)) || (!paramIntent.equalsIgnoreCase("yes"))) {
          break label444;
        }
      }
      label444:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        Log.i("MicroMsg.WalletBrandUI", "isClickOtherVerify: %s", new Object[] { paramIntent });
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.WalletBrandUI", "check face failed, click other verify");
          this.msH.call(true, "", i, "");
          this.msH = null;
        }
        if (paramInt2 == 0)
        {
          Log.i("MicroMsg.WalletBrandUI", "resultCode：RESULT_CANCELED");
          if (this.msI != null)
          {
            this.msI.call();
            this.msI = null;
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
    this.Wbx = ((WalletJsapiData)getIntent().getParcelableExtra("WalletJsapiData"));
    if ((Build.VERSION.SDK_INT >= 21) && (getWindow() != null))
    {
      getWindow().addFlags(-2147483648);
      getWindow().setStatusBarColor(0);
    }
    if (this.Wbx == null)
    {
      Log.w("MicroMsg.WalletBrandUI", "no jsapi data");
      finish();
      AppMethodBeat.o(71902);
      return;
    }
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
    com.tencent.soter.a.a.jYq();
    if (this.Wbx.YvZ != null) {
      this.Wbz = this.Wbx.YvZ;
    }
    this.igp = this.Wbx.hUR;
    if (this.Wbz.equalsIgnoreCase("key_from_scene_appbrandgame"))
    {
      this.WbA = this.Wbx.hUS;
      this.Wbx.hUS = 0;
    }
    ac.jOR();
    int i = this.Wbx.YvU;
    Log.i("MicroMsg.WalletBrandUI", "onCreate appbrandScene:%s,payScene:%d,requestCode:%d", new Object[] { this.Wbz, Integer.valueOf(this.igp), Integer.valueOf(this.WbA) });
    if (z.bBi())
    {
      Log.i("MicroMsg.WalletBrandUI", "hy: do pay with payu");
      this.Wbw = new e();
    }
    for (;;)
    {
      this.WbC.alive();
      this.WbD.alive();
      if (!(this.Wbw instanceof c)) {
        break;
      }
      Log.i("MicroMsg.WalletBrandUI", "onCreate: do pay with kinda");
      AppMethodBeat.o(71902);
      return;
      if (i == 2)
      {
        Log.i("MicroMsg.WalletBrandUI", "hy: do pay with h5");
        this.Wbw = new a();
      }
      else if (i == 3)
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with mall");
        this.Wbw = new g();
      }
      else if (i == 4)
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with component");
        this.Wbw = new d();
      }
      else if (isKindaEnabled())
      {
        Log.i("MicroMsg.WalletBrandUI", "do pay with kinda");
        this.Wbw = new c();
      }
      else
      {
        Log.i("MicroMsg.WalletBrandUI", "hy: do pay with tenpay");
        this.Wbw = new f();
      }
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.Wbw.imp(), this);
    AppMethodBeat.o(71902);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71903);
    Log.i("MicroMsg.WalletBrandUI", "onDestroy");
    super.onDestroy();
    if ((this.Wbw instanceof c)) {
      Log.i("MicroMsg.WalletBrandUI", "onDestroy: do pay with kinda");
    }
    for (;;)
    {
      this.WbC.dead();
      this.WbD.dead();
      AppMethodBeat.o(71903);
      return;
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(this.Wbw.imp(), this);
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
    Log.i("MicroMsg.WalletBrandUI", "Handler jump intercept = %b,taskid = %d,parentName = %s", new Object[] { Boolean.valueOf(this.Wbv), Integer.valueOf(getTaskId()), getCallingActivity() });
    if (!this.Wbv)
    {
      this.Wbv = true;
      this.maU = this.Wbw.imq();
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((!isKindaEnabled()) && (this.Wbx.YvU != 4)) {
        this.tipDialog = com.tencent.mm.wallet_core.ui.l.b(this, true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(71882);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(WalletBrandUI.a(WalletBrandUI.this));
            WalletBrandUI.this.finish();
            AppMethodBeat.o(71882);
          }
        });
      }
    }
    AppMethodBeat.o(71905);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(71908);
    Log.i("MicroMsg.WalletBrandUI", "hy: brandui on scene end. errType: %d, errCode: %d, errMsg:%s scene %s _scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp, this.maU });
    if ((paramp.getType() != this.Wbw.imp()) || (paramp != this.maU))
    {
      AppMethodBeat.o(71908);
      return;
    }
    this.Wbw.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
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
  
  public final void q(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(174530);
    Log.i("MicroMsg.WalletBrandUI", "sendMiniAppPayResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    adf localadf = new adf();
    localadf.ihn.intent = paramIntent;
    localadf.ihn.ihm = 1;
    localadf.ihn.hAT = "key_from_scene_appbrandgame";
    localadf.ihn.result = paramInt;
    localadf.ihn.hPm = this.WbA;
    localadf.publish();
    AppMethodBeat.o(174530);
  }
  
  public final void r(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(182530);
    Log.i("MicroMsg.WalletBrandUI", "sendPaySuccessAheadCallbackResult result:%d", new Object[] { Integer.valueOf(paramInt) });
    if ((this.Wbx != null) && (this.Wbx.Ywd != null))
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      if (localIntent.getExtras() == null) {
        localIntent.putExtras(new Bundle());
      }
      this.Wbx.Ywd.c(paramInt, localIntent.getExtras());
    }
    AppMethodBeat.o(182530);
  }
  
  public final class a
    implements WalletBrandUI.b
  {
    private int WbF = 0;
    private String mReqKey = "";
    
    public a() {}
    
    public final int imp()
    {
      return 1563;
    }
    
    public final p imq()
    {
      AppMethodBeat.i(71887);
      this.WbF = WalletBrandUI.f(WalletBrandUI.this).YvW;
      int i = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      com.tencent.mm.plugin.wallet_index.model.a.a locala = new com.tencent.mm.plugin.wallet_index.model.a.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).hUP, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).hUQ, i);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(locala, 0);
      AppMethodBeat.o(71887);
      return locala;
    }
    
    public final String imr()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71888);
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.wallet_index.model.a.a)))
      {
        paramString = ((com.tencent.mm.plugin.wallet_index.model.a.a)paramp).jumpUrl;
        Log.i("MicroMsg.WalletBrandUI", "hy: gen prepay success! url is: %s", new Object[] { paramString });
        this.mReqKey = paramString;
        paramp = ((com.tencent.mm.plugin.wallet_index.model.a.a)paramp).WaN;
        Intent localIntent;
        if (this.WbF == 1)
        {
          localIntent = new Intent();
          localIntent.putExtra("url", paramString);
          localIntent.putExtra("jsInjectCode", paramp);
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
          if (!Util.isNullOrNil(paramp))
          {
            localIntent.putExtra("shouldForceViewPort", true);
            localIntent.putExtra("view_port_code", paramp);
          }
          i.aS(WalletBrandUI.this.getContext(), localIntent);
          WalletBrandUI.this.setResult(-1);
        }
      }
      Log.i("MicroMsg.WalletBrandUI", "hy: gen prepay failed! errType: %d, errCode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      com.tencent.mm.ui.base.k.a(WalletBrandUI.this, paramString, "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    public abstract int imp();
    
    public abstract p imq();
    
    public abstract String imr();
    
    public abstract void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp);
  }
  
  class c
    implements WalletBrandUI.b
  {
    c() {}
    
    public final int imp()
    {
      return 0;
    }
    
    public p imq()
    {
      AppMethodBeat.i(71890);
      MMActivity.a local1 = new MMActivity.a()
      {
        private Intent WbH;
        
        private void s(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(174529);
          Log.i("MicroMsg.WalletBrandUI", "KindaBrand.kindaEndWithResult resultCode: %d, data: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousIntent.toString() });
          WalletBrandUI.this.setResult(paramAnonymousInt, paramAnonymousIntent);
          AppMethodBeat.o(174529);
        }
        
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
              this.WbH.putExtra("key_jsapi_close_page_after_pay", paramAnonymousInt1);
              WalletBrandUI.this.setResult(paramAnonymousInt2, this.WbH);
              AppMethodBeat.o(71889);
              return;
            }
            this.WbH.putExtras(paramAnonymousIntent);
            s(paramAnonymousInt2, this.WbH);
            AppMethodBeat.o(71889);
            return;
          }
          s(paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(71889);
        }
      };
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startWxpayJsApiPay(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), local1, WalletBrandUI.g(WalletBrandUI.this));
      AppMethodBeat.o(71890);
      return null;
    }
    
    public final String imr()
    {
      return "";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  }
  
  final class d
    extends WalletBrandUI.c
  {
    d()
    {
      super();
    }
    
    public final p imq()
    {
      AppMethodBeat.i(71892);
      ((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startJsApiComponentUseCase(WalletBrandUI.this.getContext(), WalletBrandUI.f(WalletBrandUI.this), new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
    
    public final int imp()
    {
      return 1521;
    }
    
    public final p imq()
    {
      AppMethodBeat.i(71893);
      com.tencent.mm.plugin.wallet_index.model.b.a locala = new com.tencent.mm.plugin.wallet_index.model.b.a(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).hUP, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).hUQ, WalletBrandUI.f(WalletBrandUI.this).payChannel);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(locala, 0);
      AppMethodBeat.o(71893);
      return locala;
    }
    
    public final String imr()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71894);
      paramp = (com.tencent.mm.plugin.wallet_index.model.b.a)paramp;
      String str = paramp.Wam;
      Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
      this.mReqKey = str;
      PayInfo localPayInfo = new PayInfo();
      localPayInfo.hAT = str;
      localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
      localPayInfo.Wan = paramp.Wan;
      localPayInfo.hUR = WalletBrandUI.f(WalletBrandUI.this).hUR;
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
    
    public final int imp()
    {
      AppMethodBeat.i(71898);
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand getGenPrepayFuncId packageExt:%s", new Object[] { WalletBrandUI.f(WalletBrandUI.this).packageExt });
      if (com.tencent.mm.plugin.wallet_index.model.a.nF(WalletBrandUI.f(WalletBrandUI.this).packageExt, "up_"))
      {
        AppMethodBeat.o(71898);
        return 2519;
      }
      if (com.tencent.mm.plugin.wallet_index.model.a.nF(WalletBrandUI.f(WalletBrandUI.this).packageExt, "tax_"))
      {
        AppMethodBeat.o(71898);
        return 2923;
      }
      if (com.tencent.mm.plugin.wallet_index.model.a.nF(WalletBrandUI.f(WalletBrandUI.this).packageExt, "dc_"))
      {
        AppMethodBeat.o(71898);
        return 2798;
      }
      AppMethodBeat.o(71898);
      return 398;
    }
    
    public final p imq()
    {
      AppMethodBeat.i(71896);
      Object localObject = WalletBrandUI.f(WalletBrandUI.this).appId;
      String str1 = WalletBrandUI.f(WalletBrandUI.this).signType;
      String str2 = WalletBrandUI.f(WalletBrandUI.this).nonceStr;
      String str3 = WalletBrandUI.f(WalletBrandUI.this).packageExt;
      String str4 = WalletBrandUI.f(WalletBrandUI.this).hUP;
      String str5 = WalletBrandUI.f(WalletBrandUI.this).timeStamp;
      String str6 = WalletBrandUI.f(WalletBrandUI.this).url;
      String str7 = WalletBrandUI.f(WalletBrandUI.this).hUQ;
      int i = WalletBrandUI.f(WalletBrandUI.this).payChannel;
      int j = WalletBrandUI.f(WalletBrandUI.this).hUR;
      int k = WalletBrandUI.f(WalletBrandUI.this).YvS;
      String str8 = WalletBrandUI.f(WalletBrandUI.this).okK;
      if (com.tencent.mm.plugin.wallet_index.model.a.nF(str3, "up_")) {
        localObject = new com.tencent.mm.plugin.wallet_index.model.l((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.wallet_index.model.f)localObject).setProcessSessionId(System.currentTimeMillis());
        ((com.tencent.mm.plugin.wallet_index.model.f)localObject).setProcessName("PayProcess");
        ((com.tencent.mm.plugin.wallet_index.model.f)localObject).setScene(WalletBrandUI.f(WalletBrandUI.this).hUR);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
        AppMethodBeat.o(71896);
        return localObject;
        if (com.tencent.mm.plugin.wallet_index.model.a.nF(str3, "tax_")) {
          localObject = new com.tencent.mm.plugin.wallet_index.model.k((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else if (com.tencent.mm.plugin.wallet_index.model.a.nF(str3, "dc_")) {
          localObject = new d((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        } else {
          localObject = new com.tencent.mm.plugin.wallet_index.model.f((String)localObject, str1, str2, str3, str4, str5, str6, str7, i, j, k, str8);
        }
      }
    }
    
    public final String imr()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71897);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.wallet_index.model.f localf = (com.tencent.mm.plugin.wallet_index.model.f)paramp;
        localObject1 = localf.Wam;
        Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(localObject1)));
        this.mReqKey = ((String)localObject1);
        new act().publish();
        Object localObject2 = ((com.tencent.mm.plugin.wallet_index.model.f)paramp).Wao;
        if ((localObject2 != null) && (!Util.isNullOrNil(((geh)localObject2).acbS)))
        {
          Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand start WalletMixOrderInfoUI");
          paramString = new Intent();
          paramString.putExtra("prepayId", (String)localObject1);
          paramString.putExtra("is_jsapi_offline_pay", false);
          paramString.putExtra("pay_gate_url", ((geh)localObject2).acbS);
          paramString.putExtra("need_dialog", ((geh)localObject2).acbU);
          paramString.putExtra("dialog_text", ((geh)localObject2).acbV);
          paramString.putExtra("max_count", ((geh)localObject2).acbT.ZaY);
          paramString.putExtra("inteval_time", ((geh)localObject2).acbT.ZaX);
          paramString.putExtra("default_wording", ((geh)localObject2).acbT.ZaZ);
          com.tencent.mm.br.c.c(WalletBrandUI.this, "wallet_core", ".ui.WalletMixOrderInfoUI", paramString);
          AppMethodBeat.o(71897);
          return;
        }
        Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand startPay");
        localObject2 = new PayInfo();
        ((PayInfo)localObject2).hAT = ((String)localObject1);
        ((PayInfo)localObject2).appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        ((PayInfo)localObject2).Wan = localf.Wan;
        ((PayInfo)localObject2).hUR = WalletBrandUI.f(WalletBrandUI.this).hUR;
        ((PayInfo)localObject2).errMsg = paramString;
        ((PayInfo)localObject2).channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
        ((PayInfo)localObject2).YvH = localf.sessionId;
        if (((PayInfo)localObject2).nKf == null) {
          ((PayInfo)localObject2).nKf = new Bundle();
        }
        ((PayInfo)localObject2).nKf.putString("extinfo_key_20", ((com.tencent.mm.plugin.wallet_index.model.f)paramp).Wap);
        ((PayInfo)localObject2).nKf.putString("extinfo_key_21", WalletBrandUI.f(WalletBrandUI.this).YvX);
        ((PayInfo)localObject2).nKf.putString("extinfo_key_22", WalletBrandUI.f(WalletBrandUI.this).YvY);
        ag.G(((PayInfo)localObject2).hUR, (String)localObject1, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, (PayInfo)localObject2, 1);
        AppMethodBeat.o(71897);
        return;
      }
      Log.i("MicroMsg.WalletBrandUI", "TenpayWalletBrand dialog");
      ag.G(WalletBrandUI.f(WalletBrandUI.this).hUR, "", paramInt2);
      if (WalletBrandUI.f(WalletBrandUI.this).hUR == 3)
      {
        paramp = WalletBrandUI.this;
        if (Util.isNullOrNil(paramString)) {
          paramString = WalletBrandUI.this.getString(a.i.wallet_net_err);
        }
        for (;;)
        {
          paramString = com.tencent.mm.ui.base.k.a(paramp, paramString, "", WalletBrandUI.this.getString(a.i.wallet_dialog_confirm), false, new DialogInterface.OnClickListener()
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
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = WalletBrandUI.this.getString(a.i.wallet_net_err);
      }
      ((Intent)localObject1).putExtra("key_jsapi_pay_err_msg", paramp);
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
    
    public final int imp()
    {
      return 2755;
    }
    
    public final p imq()
    {
      AppMethodBeat.i(71899);
      com.tencent.mm.plugin.wallet_index.model.e locale = new com.tencent.mm.plugin.wallet_index.model.e(WalletBrandUI.f(WalletBrandUI.this).appId, WalletBrandUI.f(WalletBrandUI.this).signType, WalletBrandUI.f(WalletBrandUI.this).nonceStr, WalletBrandUI.f(WalletBrandUI.this).packageExt, WalletBrandUI.f(WalletBrandUI.this).hUP, WalletBrandUI.f(WalletBrandUI.this).timeStamp, WalletBrandUI.f(WalletBrandUI.this).url, WalletBrandUI.f(WalletBrandUI.this).hUQ, WalletBrandUI.f(WalletBrandUI.this).payChannel, WalletBrandUI.f(WalletBrandUI.this).hUR, WalletBrandUI.f(WalletBrandUI.this).extInfo);
      locale.setProcessSessionId(System.currentTimeMillis());
      locale.setProcessName("PayProcess");
      locale.setScene(WalletBrandUI.f(WalletBrandUI.this).hUR);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(locale, 0);
      AppMethodBeat.o(71899);
      return locale;
    }
    
    public final String imr()
    {
      return this.mReqKey;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(71900);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramp = (com.tencent.mm.plugin.wallet_index.model.e)paramp;
        String str = paramp.Wam;
        this.mReqKey = str;
        Log.d("MicroMsg.WalletBrandUI", "req_key = ".concat(String.valueOf(str)));
        PayInfo localPayInfo = new PayInfo();
        localPayInfo.hAT = str;
        localPayInfo.appId = WalletBrandUI.f(WalletBrandUI.this).appId;
        localPayInfo.Wan = paramp.Wan;
        localPayInfo.hUR = WalletBrandUI.f(WalletBrandUI.this).hUR;
        localPayInfo.errMsg = paramString;
        localPayInfo.channel = WalletBrandUI.f(WalletBrandUI.this).payChannel;
        localPayInfo.YvH = paramp.sessionId;
        ag.G(localPayInfo.hUR, str, paramInt2);
        com.tencent.mm.pluginsdk.wallet.f.a(WalletBrandUI.this, localPayInfo, 1);
        AppMethodBeat.o(71900);
        return;
      }
      WalletBrandUI.this.finish();
      AppMethodBeat.o(71900);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI
 * JD-Core Version:    0.7.0.1
 */