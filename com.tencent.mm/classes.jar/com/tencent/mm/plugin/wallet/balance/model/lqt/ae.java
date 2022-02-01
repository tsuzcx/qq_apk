package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ae
{
  public static int Huu = 123;
  public static int Huv = 456;
  public static String Huw = "key_bind_serial";
  public String HuA;
  int HuB;
  public int HuC;
  public String HuD;
  public Bankcard HuE;
  public int HuF;
  public Map<String, String> HuG;
  private ac Hux;
  public ad Huy;
  public WalletBaseUI Huz;
  public int accountType;
  public String dDM;
  public b jSi;
  public int mode;
  
  public ae()
  {
    AppMethodBeat.i(68535);
    this.Hux = null;
    this.Huy = null;
    this.Huz = null;
    this.HuG = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public ae(ac paramac, ad paramad, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.Hux = null;
    this.Huy = null;
    this.Huz = null;
    this.HuG = new HashMap();
    this.Hux = paramac;
    this.Huy = paramad;
    this.Huz = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void aI(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68537);
    Log.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.jSi = com.tencent.mm.vending.g.g.hdx();
    this.jSi.hdw();
    if (paramInt1 == 1)
    {
      new i(paramInt2, paramInt3).aYI().b(new a()
      {
        private Void a(c.a<cuv> paramAnonymousa)
        {
          AppMethodBeat.i(213856);
          Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
          if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
          {
            ag.aUH(((cuv)paramAnonymousa.iLC).HuS);
            u.HtN.a(((cuv)paramAnonymousa.iLC).MAb, true, false);
            u.HtN.a((cuv)paramAnonymousa.iLC);
          }
          if (ae.d(ae.this) != null) {
            ae.d(ae.this).resume();
          }
          paramAnonymousa = QZL;
          AppMethodBeat.o(213856);
          return paramAnonymousa;
        }
      });
      AppMethodBeat.o(68537);
      return;
    }
    new j(paramInt2).aYI().b(new a()
    {
      private Void a(c.a<cux> paramAnonymousa)
      {
        AppMethodBeat.i(213858);
        Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ag.aUH(((cux)paramAnonymousa.iLC).HuS);
          x.fMZ().a((cux)paramAnonymousa.iLC);
          u.HtN.a(((cux)paramAnonymousa.iLC).MAb, false, false);
        }
        if (ae.d(ae.this) != null) {
          ae.d(ae.this).resume();
        }
        paramAnonymousa = QZL;
        AppMethodBeat.o(213858);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(68537);
  }
  
  public final void aUG(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfP, paramString);
      paramString = u.HtN;
      if (this.mode != 1) {
        break label147;
      }
      bool1 = true;
      label47:
      paramString.xI(bool1);
      if (!bool1) {
        break label152;
      }
    }
    label147:
    label152:
    for (paramString = paramString.Htx;; paramString = paramString.Hty)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        Log.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.MpK) });
        bool1 = paramString.MpK;
      }
      if (bool1)
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        aI(this.mode, this.accountType, 1);
      }
      AppMethodBeat.o(68538);
      return;
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OfQ, paramString);
      break;
      bool1 = false;
      break label47;
    }
  }
  
  public final void fW(final String paramString, int paramInt)
  {
    AppMethodBeat.i(213863);
    Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
    this.Huz.showLoading(false);
    String str = this.Huz.getIntent().getStringExtra("operate_id");
    this.Huy.Huq.a(this.HuA, this.dDM, this.HuB, this.accountType, str, this.HuF, paramInt).f(new a() {}).a(new d.a()
    {
      public final void cn(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68531);
        Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", new Object[] { paramAnonymousObject });
        ae.a(ae.this).hideLoading();
        if ((ae.a(ae.this) instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)ae.a(ae.this)).xQ(false);
          MMHandlerThread.postToMainThreadDelayed(((WalletLqtSaveFetchUI)ae.a(ae.this)).jVx, 300L);
        }
        if (ae.d(ae.this) != null) {
          ae.d(ae.this).ej(paramAnonymousObject);
        }
        AppMethodBeat.o(68531);
      }
    });
    AppMethodBeat.o(213863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ae
 * JD-Core Version:    0.7.0.1
 */