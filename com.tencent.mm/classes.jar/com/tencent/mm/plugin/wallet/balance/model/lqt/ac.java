package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ac
{
  public static int zFC = 123;
  public static int zFD = 456;
  public static String zFE = "key_bind_serial";
  public int accountType;
  public String dcF;
  public b hZi;
  public int mode;
  private aa zFF;
  public ab zFG;
  public WalletBaseUI zFH;
  public String zFI;
  public int zFJ;
  public int zFK;
  public String zFL;
  public Bankcard zFM;
  public int zFN;
  public Map<String, String> zFO;
  
  public ac()
  {
    AppMethodBeat.i(68535);
    this.zFF = null;
    this.zFG = null;
    this.zFH = null;
    this.zFO = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public ac(aa paramaa, ab paramab, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.zFF = null;
    this.zFG = null;
    this.zFH = null;
    this.zFO = new HashMap();
    this.zFF = paramaa;
    this.zFG = paramab;
    this.zFH = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void atp(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsE, paramString);
      paramString = s.zEV;
      if (this.mode != 1) {
        break label142;
      }
      bool1 = true;
      label46:
      paramString.sh(bool1);
      if (!bool1) {
        break label147;
      }
    }
    label142:
    label147:
    for (paramString = paramString.zEF;; paramString = paramString.zEG)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        ad.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.DKm) });
        bool1 = paramString.DKm;
      }
      if (bool1)
      {
        ad.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        aw(this.mode, this.accountType, 1);
      }
      AppMethodBeat.o(68538);
      return;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsF, paramString);
      break;
      bool1 = false;
      break label46;
    }
  }
  
  public final void aw(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68537);
    ad.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.hZi = com.tencent.mm.vending.g.g.fhl();
    this.hZi.fhk();
    if (paramInt1 == 1)
    {
      new i(paramInt2, paramInt3).auK().b(new ac.10(this));
      AppMethodBeat.o(68537);
      return;
    }
    new j(paramInt2).auK().b(new ac.2(this));
    AppMethodBeat.o(68537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac
 * JD-Core Version:    0.7.0.1
 */