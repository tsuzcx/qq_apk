package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.ejz;
import com.tencent.mm.protocal.protobuf.eoj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class ag
{
  public static int VaM = 123;
  public static int VaN = 456;
  public static String VaO = "key_bind_serial";
  private ae VaP;
  public af VaQ;
  public WalletBaseUI VaR;
  public String VaS;
  int VaT;
  public int VaU;
  public String VaV;
  public int VaW;
  public Bankcard VaX;
  public int VaY;
  public Map<String, String> VaZ;
  public String hAU;
  public int mode;
  public b pGe;
  
  public ag()
  {
    AppMethodBeat.i(68535);
    this.VaP = null;
    this.VaQ = null;
    this.VaR = null;
    this.VaZ = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public ag(ae paramae, af paramaf, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.VaP = null;
    this.VaQ = null;
    this.VaR = null;
    this.VaZ = new HashMap();
    this.VaP = paramae;
    this.VaQ = paramaf;
    this.VaR = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void bfT(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      h.baF();
      h.baE().ban().set(at.a.acVO, paramString);
      paramString = w.Vad;
      if (this.mode != 1) {
        break label145;
      }
      bool1 = true;
      label46:
      paramString.Hi(bool1);
      if (!bool1) {
        break label150;
      }
    }
    label145:
    label150:
    for (paramString = paramString.UZL;; paramString = paramString.UZM)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        Log.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.aaQc) });
        bool1 = paramString.aaQc;
      }
      if (bool1)
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        bo(this.mode, this.VaW, 1);
      }
      AppMethodBeat.o(68538);
      return;
      h.baF();
      h.baE().ban().set(at.a.acVP, paramString);
      break;
      bool1 = false;
      break label46;
    }
  }
  
  public final void bo(int paramInt1, int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(68537);
    Log.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.pGe = g.jJL();
    this.pGe.jJK();
    if (paramInt1 == 1)
    {
      new j(paramInt2, paramInt3).bFJ().b(new a()
      {
        private Void a(b.a<dwc> paramAnonymousa)
        {
          AppMethodBeat.i(316252);
          Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
          if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
          {
            ai.bfU(((dwc)paramAnonymousa.ott).Vbl);
            w.Vad.a(((dwc)paramAnonymousa.ott).abbO, true, false, "");
            w.Vad.a((dwc)paramAnonymousa.ott, paramInt3);
          }
          if (ag.d(ag.this) != null) {
            ag.d(ag.this).resume();
          }
          paramAnonymousa = aguz;
          AppMethodBeat.o(316252);
          return paramAnonymousa;
        }
      });
      AppMethodBeat.o(68537);
      return;
    }
    new k(paramInt2).bFJ().b(new a()
    {
      private Void a(b.a<dwg> paramAnonymousa)
      {
        AppMethodBeat.i(316251);
        Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ai.bfU(((dwg)paramAnonymousa.ott).Vbl);
          z.ieB().a((dwg)paramAnonymousa.ott);
          w.Vad.a(((dwg)paramAnonymousa.ott).abbO, false, false, "");
        }
        if (ag.d(ag.this) != null) {
          ag.d(ag.this).resume();
        }
        paramAnonymousa = aguz;
        AppMethodBeat.o(316251);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(68537);
  }
  
  public final void hC(final String paramString, int paramInt)
  {
    AppMethodBeat.i(316248);
    Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
    this.VaR.showLoading(false);
    String str = this.VaR.getIntent().getStringExtra("operate_id");
    this.VaQ.VaI.a(this.VaS, this.hAU, this.VaT, this.VaW, str, this.VaY, paramInt).f(new a() {}).a(new d.a()
    {
      public final void onInterrupt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68531);
        Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", new Object[] { paramAnonymousObject });
        ag.a(ag.this).hideLoading();
        if ((ag.a(ag.this) instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)ag.a(ag.this)).Hp(false);
          MMHandlerThread.postToMainThreadDelayed(((WalletLqtSaveFetchUI)ag.a(ag.this)).pJs, 300L);
        }
        if (ag.d(ag.this) != null) {
          ag.d(ag.this).gM(paramAnonymousObject);
        }
        AppMethodBeat.o(68531);
      }
    });
    AppMethodBeat.o(316248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ag
 * JD-Core Version:    0.7.0.1
 */