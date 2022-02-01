package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cjq;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ac
{
  public static int AXP = 123;
  public static int AXQ = 456;
  public static String AXR = "key_bind_serial";
  private aa AXS;
  public ab AXT;
  public WalletBaseUI AXU;
  public String AXV;
  public int AXW;
  public int AXX;
  public String AXY;
  public Bankcard AXZ;
  public int AYa;
  public Map<String, String> AYb;
  public int accountType;
  public String dad;
  public b izm;
  public int mode;
  
  public ac()
  {
    AppMethodBeat.i(68535);
    this.AXS = null;
    this.AXT = null;
    this.AXU = null;
    this.AYb = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public ac(aa paramaa, ab paramab, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.AXS = null;
    this.AXT = null;
    this.AXU = null;
    this.AYb = new HashMap();
    this.AXS = paramaa;
    this.AXT = paramab;
    this.AXU = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void ax(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68537);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.izm = com.tencent.mm.vending.g.g.fxn();
    this.izm.fxm();
    if (paramInt1 == 1)
    {
      new i(paramInt2, paramInt3).aBB().b(new a()
      {
        private Void a(c.a<bzd> paramAnonymousa)
        {
          AppMethodBeat.i(182504);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
          if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
          {
            ae.ayI(((bzd)paramAnonymousa.hvj).AYl);
            s.AXi.a(((bzd)paramAnonymousa.hvj).FnZ, true);
            s.AXi.a((bzd)paramAnonymousa.hvj);
          }
          if (ac.d(ac.this) != null) {
            ac.d(ac.this).resume();
          }
          paramAnonymousa = Jql;
          AppMethodBeat.o(182504);
          return paramAnonymousa;
        }
      });
      AppMethodBeat.o(68537);
      return;
    }
    new j(paramInt2).aBB().b(new a()
    {
      private Void a(c.a<bzf> paramAnonymousa)
      {
        AppMethodBeat.i(182503);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ae.ayI(((bzf)paramAnonymousa.hvj).AYl);
          v.eok().a((bzf)paramAnonymousa.hvj);
          s.AXi.a(((bzf)paramAnonymousa.hvj).FnZ, false);
        }
        if (ac.d(ac.this) != null) {
          ac.d(ac.this).resume();
        }
        paramAnonymousa = Jql;
        AppMethodBeat.o(182503);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(68537);
  }
  
  public final void ayH(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQw, paramString);
      paramString = s.AXi;
      if (this.mode != 1) {
        break label142;
      }
      bool1 = true;
      label46:
      paramString.ti(bool1);
      if (!bool1) {
        break label147;
      }
    }
    label142:
    label147:
    for (paramString = paramString.AWS;; paramString = paramString.AWT)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.FgB) });
        bool1 = paramString.FgB;
      }
      if (bool1)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        ax(this.mode, this.accountType, 1);
      }
      AppMethodBeat.o(68538);
      return;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQx, paramString);
      break;
      bool1 = false;
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac
 * JD-Core Version:    0.7.0.1
 */