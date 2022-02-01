package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ac
{
  public static int CxY = 123;
  public static int CxZ = 456;
  public static String Cya = "key_bind_serial";
  private aa Cyb;
  public ab Cyc;
  public WalletBaseUI Cyd;
  public String Cye;
  public int Cyf;
  public int Cyg;
  public String Cyh;
  public Bankcard Cyi;
  public int Cyj;
  public Map<String, String> Cyk;
  public int accountType;
  public String dlv;
  public b iSv;
  public int mode;
  
  public ac()
  {
    AppMethodBeat.i(68535);
    this.Cyb = null;
    this.Cyc = null;
    this.Cyd = null;
    this.Cyk = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public ac(aa paramaa, ab paramab, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.Cyb = null;
    this.Cyc = null;
    this.Cyd = null;
    this.Cyk = new HashMap();
    this.Cyb = paramaa;
    this.Cyc = paramab;
    this.Cyd = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void aDP(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICT, paramString);
      paramString = s.Cxr;
      if (this.mode != 1) {
        break label142;
      }
      bool1 = true;
      label46:
      paramString.tS(bool1);
      if (!bool1) {
        break label147;
      }
    }
    label142:
    label147:
    for (paramString = paramString.Cxb;; paramString = paramString.Cxc)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        ad.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.GQd) });
        bool1 = paramString.GQd;
      }
      if (bool1)
      {
        ad.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        az(this.mode, this.accountType, 1);
      }
      AppMethodBeat.o(68538);
      return;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICU, paramString);
      break;
      bool1 = false;
      break label46;
    }
  }
  
  public final void az(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68537);
    ad.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iSv = com.tencent.mm.vending.g.g.fOa();
    this.iSv.fNZ();
    if (paramInt1 == 1)
    {
      new i(paramInt2, paramInt3).aED().b(new a()
      {
        private Void a(a.a<cdu> paramAnonymousa)
        {
          AppMethodBeat.i(182504);
          ad.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
          if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
          {
            ae.aDQ(((cdu)paramAnonymousa.hNC).Cyu);
            s.Cxr.a(((cdu)paramAnonymousa.hNC).GXL, true);
            s.Cxr.a((cdu)paramAnonymousa.hNC);
          }
          if (ac.d(ac.this) != null) {
            ac.d(ac.this).resume();
          }
          paramAnonymousa = LhQ;
          AppMethodBeat.o(182504);
          return paramAnonymousa;
        }
      });
      AppMethodBeat.o(68537);
      return;
    }
    new j(paramInt2).aED().b(new a()
    {
      private Void a(a.a<cdw> paramAnonymousa)
      {
        AppMethodBeat.i(182503);
        ad.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ae.aDQ(((cdw)paramAnonymousa.hNC).Cyu);
          v.eCj().a((cdw)paramAnonymousa.hNC);
          s.Cxr.a(((cdw)paramAnonymousa.hNC).GXL, false);
        }
        if (ac.d(ac.this) != null) {
          ac.d(ac.this).resume();
        }
        paramAnonymousa = LhQ;
        AppMethodBeat.o(182503);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(68537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac
 * JD-Core Version:    0.7.0.1
 */