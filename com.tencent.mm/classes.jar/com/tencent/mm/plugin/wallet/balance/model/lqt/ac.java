package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ac
{
  public static int CPD = 123;
  public static int CPE = 456;
  public static String CPF = "key_bind_serial";
  private aa CPG;
  public ab CPH;
  public WalletBaseUI CPI;
  public String CPJ;
  public int CPK;
  public int CPL;
  public String CPM;
  public Bankcard CPN;
  public int CPO;
  public Map<String, String> CPP;
  public int accountType;
  public String dmx;
  public b iVo;
  public int mode;
  
  public ac()
  {
    AppMethodBeat.i(68535);
    this.CPG = null;
    this.CPH = null;
    this.CPI = null;
    this.CPP = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public ac(aa paramaa, ab paramab, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.CPG = null;
    this.CPH = null;
    this.CPI = null;
    this.CPP = new HashMap();
    this.CPG = paramaa;
    this.CPH = paramab;
    this.CPI = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void aA(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68537);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.iVo = com.tencent.mm.vending.g.g.fSv();
    this.iVo.fSu();
    if (paramInt1 == 1)
    {
      new i(paramInt2, paramInt3).aET().b(new a()
      {
        private Void a(a.a<ceo> paramAnonymousa)
        {
          AppMethodBeat.i(182504);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
          if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
          {
            ae.aFj(((ceo)paramAnonymousa.hQv).CPZ);
            s.COW.a(((ceo)paramAnonymousa.hQv).Hrl, true);
            s.COW.a((ceo)paramAnonymousa.hQv);
          }
          if (ac.d(ac.this) != null) {
            ac.d(ac.this).resume();
          }
          paramAnonymousa = LEs;
          AppMethodBeat.o(182504);
          return paramAnonymousa;
        }
      });
      AppMethodBeat.o(68537);
      return;
    }
    new j(paramInt2).aET().b(new a()
    {
      private Void a(a.a<ceq> paramAnonymousa)
      {
        AppMethodBeat.i(182503);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ae.aFj(((ceq)paramAnonymousa.hQv).CPZ);
          v.eFR().a((ceq)paramAnonymousa.hQv);
          s.COW.a(((ceq)paramAnonymousa.hQv).Hrl, false);
        }
        if (ac.d(ac.this) != null) {
          ac.d(ac.this).resume();
        }
        paramAnonymousa = LEs;
        AppMethodBeat.o(182503);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(68537);
  }
  
  public final void aFi(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXt, paramString);
      paramString = s.COW;
      if (this.mode != 1) {
        break label142;
      }
      bool1 = true;
      label46:
      paramString.tZ(bool1);
      if (!bool1) {
        break label147;
      }
    }
    label142:
    label147:
    for (paramString = paramString.COG;; paramString = paramString.COH)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.HjE) });
        bool1 = paramString.HjE;
      }
      if (bool1)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        aA(this.mode, this.accountType, 1);
      }
      AppMethodBeat.o(68538);
      return;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXu, paramString);
      break;
      bool1 = false;
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac
 * JD-Core Version:    0.7.0.1
 */