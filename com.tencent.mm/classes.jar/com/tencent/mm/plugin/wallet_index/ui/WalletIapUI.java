package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.xl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class WalletIapUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private c Axw;
  private d Axy;
  private com.tencent.mm.sdk.b.c Ayf;
  private final int Ayo;
  private final int Ayp;
  private final int Ayq;
  private final int Ayr;
  private final int Ays;
  private final int Ayt;
  private boolean Ayu;
  private int Ayv;
  private boolean Ayw;
  private String Ayx;
  private b Ayy;
  private d Ayz;
  private final int DEFAULT;
  private final int OK;
  private int currentState;
  private Dialog lIc;
  private int mRequestCode;
  private com.tencent.mm.sdk.b.c uxB;
  private final int vdC;
  
  public WalletIapUI()
  {
    AppMethodBeat.i(71919);
    this.Ayo = 4;
    this.Ayp = 0;
    this.Ayq = 1;
    this.Ayr = 2;
    this.Ays = 3;
    this.OK = 1000;
    this.Ayt = 1001;
    this.vdC = 1002;
    this.DEFAULT = 1003;
    this.Ayu = false;
    this.Ayv = 0;
    this.currentState = 1003;
    this.Ayx = "0";
    this.mRequestCode = 0;
    this.Ayf = new com.tencent.mm.sdk.b.c() {};
    this.Ayz = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71915);
        ad.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if ((WalletIapUI.b(WalletIapUI.this) instanceof a))
        {
          ad.i("MicroMsg.WalletIapUI", "Pay Purchase finished mWallet is  GoogleWallet");
          if (paramAnonymousc != null) {
            ab.d(paramAnonymousc.AwX, paramAnonymousc.oyw, paramAnonymousc.Axd, paramAnonymousb.std, paramAnonymousb.ste);
          }
        }
        else
        {
          if (!paramAnonymousb.efz()) {
            break label268;
          }
          ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramAnonymousb.std + " , errMsg: " + paramAnonymousb.ste);
          if (paramAnonymousb.std != 1) {
            break label254;
          }
          WalletIapUI.a(WalletIapUI.this, 1001);
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.std);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.ste);
          paramAnonymousc.putExtra("key_launch_ts", a.Axx);
          paramAnonymousc.putExtra("key_gw_error_code", paramAnonymousb.Axe);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
          a locala = (a)WalletIapUI.b(WalletIapUI.this);
          ab.d(locala.AxB, locala.oyw, locala.Axd, paramAnonymousb.std, paramAnonymousb.ste);
          break;
          label254:
          WalletIapUI.a(WalletIapUI.this, 1002);
        }
        label268:
        if (!paramAnonymousb.efy())
        {
          if (paramAnonymousc != null)
          {
            ad.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramAnonymousc.oyw + ",billNo:" + paramAnonymousc.Axa);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(WalletIapUI.c(WalletIapUI.this).a(paramAnonymousc, false), 0);
            WalletIapUI.b(WalletIapUI.this, 2);
            WalletIapUI.d(WalletIapUI.this);
            AppMethodBeat.o(71915);
            return;
          }
          WalletIapUI.a(WalletIapUI.this, 1002);
          paramAnonymousb = new Intent();
          paramAnonymousc = com.tencent.mm.plugin.wallet_index.c.b.cg(6, "");
          paramAnonymousb.putExtra("key_err_code", paramAnonymousc.std);
          paramAnonymousb.putExtra("key_err_msg", paramAnonymousc.ste);
          paramAnonymousb.putExtra("key_launch_ts", a.Axx);
          paramAnonymousb.putExtra("key_gw_error_code", paramAnonymousc.Axe);
          WalletIapUI.this.setResult(-1, paramAnonymousb);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71915);
          return;
        }
        WalletIapUI.b(WalletIapUI.this, 3);
        ad.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        WalletIapUI.b(WalletIapUI.this).c(WalletIapUI.this, false);
        AppMethodBeat.o(71915);
      }
    };
    this.Axy = new d()
    {
      public final void a(com.tencent.mm.plugin.wallet_index.c.b paramAnonymousb, com.tencent.mm.plugin.wallet_index.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(71916);
        ad.i("MicroMsg.WalletIapUI", "Consume finished: " + paramAnonymousb + ", purchase: " + paramAnonymousc);
        if (paramAnonymousb.efz())
        {
          WalletIapUI.a(WalletIapUI.this, 1002);
          ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
        }
        for (;;)
        {
          paramAnonymousc = new Intent();
          paramAnonymousc.putExtra("key_err_code", paramAnonymousb.std);
          paramAnonymousc.putExtra("key_err_msg", paramAnonymousb.ste);
          paramAnonymousc.putStringArrayListExtra("key_response_product_ids", WalletIapUI.c(WalletIapUI.this).AxE);
          paramAnonymousc.putStringArrayListExtra("key_response_series_ids", WalletIapUI.c(WalletIapUI.this).AxF);
          paramAnonymousc.putExtra("key_launch_ts", a.Axx);
          WalletIapUI.this.setResult(-1, paramAnonymousc);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71916);
          return;
          WalletIapUI.a(WalletIapUI.this, 1000);
          ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
        }
      }
    };
    this.uxB = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(71919);
  }
  
  private void aHU()
  {
    AppMethodBeat.i(71927);
    ad.i("MicroMsg.WalletIapUI", "showLoadingDialog!");
    this.lIc = com.tencent.mm.wallet_core.ui.g.b(this, getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(71918);
        ad.i("MicroMsg.WalletIapUI", "showLoadingDialog onCancel currentScene: %d", new Object[] { Integer.valueOf(WalletIapUI.f(WalletIapUI.this)) });
        if (WalletIapUI.f(WalletIapUI.this) == 2) {}
        for (paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cg(7, "");; paramAnonymousDialogInterface = com.tencent.mm.plugin.wallet_index.c.b.cg(1, ""))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_err_code", paramAnonymousDialogInterface.std);
          localIntent.putExtra("key_err_msg", paramAnonymousDialogInterface.ste);
          WalletIapUI.this.setResult(-1, localIntent);
          WalletIapUI.this.finish();
          AppMethodBeat.o(71918);
          return;
        }
      }
    });
    AppMethodBeat.o(71927);
  }
  
  private void aHV()
  {
    AppMethodBeat.i(71928);
    ad.i("MicroMsg.WalletIapUI", "hideLoadingDialog!");
    if ((this.lIc != null) && (this.lIc.isShowing()))
    {
      this.lIc.dismiss();
      this.lIc = null;
    }
    AppMethodBeat.o(71928);
  }
  
  public void finish()
  {
    AppMethodBeat.i(71926);
    ad.i("MicroMsg.WalletIapUI", "finish");
    aHV();
    super.finish();
    AppMethodBeat.o(71926);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71924);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.WalletIapUI", "onActivityResult resultCode : ".concat(String.valueOf(paramInt2)));
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().get("key_total_fee") != null))
    {
      this.Ayx = paramIntent.getExtras().get("key_total_fee").toString();
      ad.i("MicroMsg.WalletIapUI", "has payAmount:%s", new Object[] { this.Ayx });
    }
    while (this.Ayy != null)
    {
      this.Ayy.a(this, paramInt1, paramInt2, paramIntent);
      ad.d("MicroMsg.WalletIapUI", "onActivityResult handled by mWalletPay.");
      AppMethodBeat.o(71924);
      return;
      ad.i("MicroMsg.WalletIapUI", "no payAmount");
    }
    ad.e("MicroMsg.WalletIapUI", "havn't handle user action");
    paramIntent = new Intent();
    com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cg(6, "");
    paramIntent.putExtra("key_err_code", localb.std);
    paramIntent.putExtra("key_err_msg", localb.ste);
    paramIntent.putExtra("key_launch_ts", a.Axx);
    setResult(-1, paramIntent);
    finish();
    AppMethodBeat.o(71924);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71920);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.WalletIapUI", "onCreate");
    ai.jx(this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(422, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(414, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1130, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1306, this);
    if (getIntent().getIntExtra("key_action_type", 200001) == 200001) {
      aHU();
    }
    this.Ayw = getIntent().getBooleanExtra("key_is_mini_program", false);
    if (getIntent().getBooleanExtra("key_request_fullscreen", false)) {
      getWindow().addFlags(1024);
    }
    this.Axw = new c();
    this.Axw.AxJ = this.Ayw;
    if ((getIntent().getBooleanExtra("key_force_google", false)) || (com.tencent.mm.model.u.aqU())) {
      ad.d("MicroMsg.WalletIapUI", "Pay use Google Wallet!");
    }
    for (this.Ayy = new a(this, this.Axw, this.Axy);; this.Ayy = new f(this.Axw, this.uxB))
    {
      this.Axw.uqr = this.Ayy.efA();
      com.tencent.mm.sdk.b.a.ESL.c(this.Ayf);
      AppMethodBeat.o(71920);
      return;
      ad.d("MicroMsg.WalletIapUI", "Pay use WeiXin Wallet!");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(71923);
    ad.i("MicroMsg.WalletIapUI", "onDestroy");
    aHV();
    if (this.currentState == 1003) {
      this.currentState = 1001;
    }
    String str = "";
    if (getIntent() != null) {
      str = getIntent().getStringExtra("key_appid");
    }
    int i;
    int j;
    if ((this.Ayy instanceof f))
    {
      i = 0;
      long l = (bt.getDouble(this.Ayx, 0.0D) * 100.0D);
      ad.i("MicroMsg.WalletIapUI", "reportPaymentState report(%s), isMiniProgram : %b, appid %s, walletType %s, currentScene %s, currentState %s, payAmount %s, payamount %s", new Object[] { Integer.valueOf(15751), Boolean.valueOf(this.Ayw), str, Integer.valueOf(i), Integer.valueOf(this.Ayv), Integer.valueOf(this.currentState), this.Ayx, Long.valueOf(l) });
      h localh = h.vKh;
      if (!this.Ayw) {
        break label405;
      }
      j = 0;
      label178:
      localh.f(15751, new Object[] { Integer.valueOf(j), str, Integer.valueOf(i), Integer.valueOf(this.Ayv), Integer.valueOf(this.currentState), this.Ayx, Long.valueOf(l) });
      h.vKh.idkeyStat(1044L, this.currentState - 1000, 1L, false);
      if (this.currentState != 1001) {
        break label410;
      }
      h.vKh.idkeyStat(1044L, this.Ayv + 4, 1L, false);
    }
    for (;;)
    {
      if (this.Ayy != null) {
        this.Ayy.n(this);
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(422, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(414, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(1130, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(1306, this);
      com.tencent.mm.sdk.b.a.ESL.d(this.Ayf);
      super.onDestroy();
      AppMethodBeat.o(71923);
      return;
      i = 1;
      break;
      label405:
      j = 1;
      break label178;
      label410:
      if (this.currentState == 1002) {
        h.vKh.idkeyStat(1044L, this.Ayv + 8, 1L, false);
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(71922);
    ad.i("MicroMsg.WalletIapUI", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(71922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(71921);
    ad.i("MicroMsg.WalletIapUI", "onResume");
    super.onResume();
    ad.i("MicroMsg.WalletIapUI", "Handler jump");
    Object localObject2;
    String str1;
    String str2;
    String str3;
    String str4;
    int i;
    if (!this.Ayu)
    {
      this.Ayu = true;
      localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("key_action_type", 200001) == 200002)
      {
        ad.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
        this.Ayv = 3;
        this.Ayy.c(this, true);
        AppMethodBeat.o(71921);
        return;
      }
      ad.i("MicroMsg.WalletIapUI", "start to doScene!");
      localObject2 = this.Axw;
      str1 = ((Intent)localObject1).getStringExtra("key_product_id");
      ((c)localObject2).oyw = str1;
      ((c)localObject2).AxI.add(str1);
      ad.d("MicroMsg.IapData", "prepare pay product: ".concat(String.valueOf(str1)));
      this.Axw.Axd = ((Intent)localObject1).getStringExtra("key_price");
      this.Axw.Axc = ((Intent)localObject1).getStringExtra("key_currency_type");
      str1 = ((Intent)localObject1).getStringExtra("key_ext_info");
      this.Axw.mCount = ((Intent)localObject1).getIntExtra("key_count", 1);
      str2 = ((Intent)localObject1).getStringExtra("key_appid");
      str3 = ((Intent)localObject1).getStringExtra("key_desc");
      str4 = ((Intent)localObject1).getStringExtra("key_busiid");
      this.Axw.AxK = ((Intent)localObject1).getStringExtra("key_virtual_pay_sign");
      this.Axw.AxL = ((Intent)localObject1).getStringExtra("key_attach");
      com.tencent.mm.kernel.g.afC();
      localObject2 = com.tencent.mm.kernel.g.afA().gcy;
      localObject1 = this.Axw;
      i = this.Ayy.efA();
      if (!((c)localObject1).AxJ) {
        break label336;
      }
    }
    label336:
    for (Object localObject1 = new com.tencent.mm.plugin.wallet_index.c.f(i, str2, ((c)localObject1).Axd, str3, ((c)localObject1).mCount, ((c)localObject1).Axc, str4, ((c)localObject1).AxK, ((c)localObject1).AxL);; localObject1 = new com.tencent.mm.wallet_core.c.u(((c)localObject1).oyw, ((c)localObject1).Axd, ((c)localObject1).Axc, ((c)localObject1).mCount, i, str1))
    {
      ((q)localObject2).a((n)localObject1, 0);
      AppMethodBeat.o(71921);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(71925);
    ad.i("MicroMsg.WalletIapUI", "onSceneEnd type:" + paramn.getType() + " errCode:" + paramInt2 + ",errMsg:" + paramString);
    paramString = com.tencent.mm.plugin.wallet_index.c.b.cg(paramInt2, paramString);
    paramInt2 = paramString.std;
    paramString = paramString.ste;
    paramInt1 = paramn.getType();
    switch (paramInt1)
    {
    default: 
      ad.w("MicroMsg.WalletIapUI", "get a wrong sceneType : ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(71925);
      return;
    case 422: 
    case 1130: 
      localc = this.Axw;
      com.tencent.mm.plugin.wallet_index.c.b localb = com.tencent.mm.plugin.wallet_index.c.b.cg(paramInt2, paramString);
      paramInt1 = localb.std;
      if ((paramn instanceof com.tencent.mm.wallet_core.c.u))
      {
        paramn = (com.tencent.mm.wallet_core.c.u)paramn;
        if (paramInt1 == 0)
        {
          if (!localc.efB()) {
            break label342;
          }
          paramn = (ccb)paramn.rr.gUT.gUX;
          if (paramn == null) {
            break label328;
          }
          paramString = new bhj();
          paramString.DFo = paramn.DYv;
          paramString.DFp = paramn.DYw;
          paramString.dtb = 5;
          paramString.DFq = paramn.DYx;
          ad.d("MicroMsg.NetScenePreparePurchase", "get Sign4TenPay is " + paramn.DYx);
          localc.Axk = paramString;
        }
      }
      for (;;)
      {
        if (localb.std != 0) {
          break label580;
        }
        ad.i("MicroMsg.WalletIapUI", "Wallet.launchPay");
        this.mRequestCode = this.Ayy.a(this, this.Ayz);
        this.Ayv = 1;
        AppMethodBeat.o(71925);
        return;
        label328:
        ad.e("MicroMsg.NetScenePreparePurchase", "getIapWxPayData fail.");
        paramString = null;
        break;
        label342:
        ccb localccb = (ccb)paramn.rr.gUT.gUX;
        if (localccb != null)
        {
          paramString = new bhi();
          paramString.DqC = paramn.Axc;
          paramString.uwi = paramn.oyw;
          paramString.upC = paramn.Axd;
          paramString.DFk = localccb.DYu;
          ad.d("MicroMsg.NetScenePreparePurchase", "getIapGoogleData is " + localccb.DYu);
        }
        for (;;)
        {
          localc.Axj = paramString;
          break;
          ad.e("MicroMsg.NetScenePreparePurchase", "getIapGoogleData fail.");
          paramString = null;
        }
        if ((paramn instanceof com.tencent.mm.plugin.wallet_index.c.f))
        {
          paramString = (com.tencent.mm.plugin.wallet_index.c.f)paramn;
          if ((paramInt1 == 0) && (paramString.errCode == 0))
          {
            localc.Axk = paramString.Axk;
            localc.Axj = paramString.Axj;
            if (localc.efB())
            {
              if (localc.Axk != null) {
                localc.AxB = localc.Axk.DFk;
              } else {
                ad.e("MicroMsg.IapData", "iapWxPayData is null");
              }
            }
            else if (localc.Axj != null) {
              localc.AxB = localc.Axj.DFk;
            } else {
              ad.e("MicroMsg.IapData", "iapGoogleData is null");
            }
          }
        }
      }
      label580:
      this.currentState = 1002;
      ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: PreparePurchase fail , errCode: " + localb.std + " , errMsg: " + localb.ste);
      paramString = new Intent();
      paramString.putExtra("key_err_code", localb.std);
      paramString.putExtra("key_err_msg", localb.ste);
      paramString.putExtra("key_response_position", 1);
      setResult(-1, paramString);
      finish();
      AppMethodBeat.o(71925);
      return;
    }
    c localc = this.Axw;
    if ((paramn instanceof v))
    {
      paramn = (v)paramn;
      localc.oyw = paramn.oyw;
      localc.AxG = paramn.oyy;
      localc.AxH = paramn.AxH;
      if (paramn.errCode == 0) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      localc.AxI.remove(localc.oyw);
      if (paramInt1 != 0)
      {
        ad.i("MicroMsg.IapData", "Verify " + localc.oyw + " OK");
        localc.AxE.add(localc.oyw);
        localc.AxF.add(localc.AxG);
      }
      for (;;)
      {
        bool = false;
        for (;;)
        {
          if (!this.Axw.AxI.isEmpty()) {
            break label1238;
          }
          ad.d("MicroMsg.WalletIapUI", "Verify All End... ");
          if (this.Axw.AxE.isEmpty()) {
            break label1139;
          }
          ad.i("MicroMsg.WalletIapUI", "mResultProductIds size: " + this.Axw.AxE.size() + ", Consume ...");
          this.Ayy.a(this, this.Axw.AxE, this.Axy, bool);
          AppMethodBeat.o(71925);
          return;
          paramInt1 = 0;
          break;
          if (!(paramn instanceof m)) {
            break label1245;
          }
          paramn = (m)paramn;
          localc.oyw = paramn.dft;
          if (paramn.errCode == 0)
          {
            paramInt1 = 1;
            break;
          }
          paramInt1 = 0;
          break;
          if (!localc.oyw.startsWith("com.tencent.xin.wco")) {
            break label1103;
          }
          if (localc.AxH <= 0) {
            break label1067;
          }
          localc.AxE.add(localc.oyw);
          localc.AxF.add(localc.AxG);
          ad.i("MicroMsg.IapData", "Verify " + localc.oyw + " fail and cosume");
        }
        label1067:
        ad.i("MicroMsg.IapData", "Verify " + localc.oyw + " fail");
        continue;
        label1103:
        ad.i("MicroMsg.IapData", "Verify " + localc.oyw + " fail");
      }
      label1139:
      ad.i("MicroMsg.WalletIapUI", "back to preview UI, reason: VerifyPurchase fail , errCode: " + paramInt2 + " , errMsg: " + paramString);
      this.currentState = 1002;
      paramn = new Intent();
      paramn.putExtra("key_err_code", paramInt2);
      paramn.putExtra("key_err_msg", paramString);
      paramn.putExtra("key_response_position", 3);
      paramn.putExtra("key_launch_ts", a.Axx);
      setResult(-1, paramn);
      finish();
      label1238:
      AppMethodBeat.o(71925);
      return;
      label1245:
      paramInt1 = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI
 * JD-Core Version:    0.7.0.1
 */