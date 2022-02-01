package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Intent;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dre;
import com.tencent.mm.protocal.protobuf.dvn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

public final class af
{
  public static int Omg = 123;
  public static int Omh = 456;
  public static String Omi = "key_bind_serial";
  private ad Omj;
  public ae Omk;
  public WalletBaseUI Oml;
  public String Omm;
  int Omn;
  public int Omo;
  public String Omp;
  public int Omq;
  public Bankcard Omr;
  public int Oms;
  public Map<String, String> Omt;
  public String fww;
  public b mJv;
  public int mode;
  
  public af()
  {
    AppMethodBeat.i(68535);
    this.Omj = null;
    this.Omk = null;
    this.Oml = null;
    this.Omt = new HashMap();
    AppMethodBeat.o(68535);
  }
  
  public af(ad paramad, ae paramae, WalletBaseUI paramWalletBaseUI)
  {
    AppMethodBeat.i(68536);
    this.Omj = null;
    this.Omk = null;
    this.Oml = null;
    this.Omt = new HashMap();
    this.Omj = paramad;
    this.Omk = paramae;
    this.Oml = paramWalletBaseUI;
    this.mode = 1;
    AppMethodBeat.o(68536);
  }
  
  public final void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(68537);
    Log.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mJv = g.ieE();
    this.mJv.ieD();
    if (paramInt1 == 1)
    {
      new i(paramInt2, paramInt3).bhW().b(new a()
      {
        private Void a(c.a<ded> paramAnonymousa)
        {
          AppMethodBeat.i(273805);
          Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
          if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
          {
            ah.bgp(((ded)paramAnonymousa.lBJ).OmF);
            v.Oly.a(((ded)paramAnonymousa.lBJ).TLK, true, false);
            v.Oly.a((ded)paramAnonymousa.lBJ);
          }
          if (af.d(af.this) != null) {
            af.d(af.this).resume();
          }
          paramAnonymousa = YAb;
          AppMethodBeat.o(273805);
          return paramAnonymousa;
        }
      });
      AppMethodBeat.o(68537);
      return;
    }
    new j(paramInt2).bhW().b(new a()
    {
      private Void a(c.a<deh> paramAnonymousa)
      {
        AppMethodBeat.i(206345);
        Log.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode) });
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ah.bgp(((deh)paramAnonymousa.lBJ).OmF);
          y.gFD().a((deh)paramAnonymousa.lBJ);
          v.Oly.a(((deh)paramAnonymousa.lBJ).TLK, false, false);
        }
        if (af.d(af.this) != null) {
          af.d(af.this).resume();
        }
        paramAnonymousa = YAb;
        AppMethodBeat.o(206345);
        return paramAnonymousa;
      }
    });
    AppMethodBeat.o(68537);
  }
  
  public final void bgo(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(68538);
    boolean bool1;
    if (this.mode == 1)
    {
      h.aHH();
      h.aHG().aHp().set(ar.a.Vuf, paramString);
      paramString = v.Oly;
      if (this.mode != 1) {
        break label147;
      }
      bool1 = true;
      label47:
      paramString.BC(bool1);
      if (!bool1) {
        break label152;
      }
    }
    label147:
    label152:
    for (paramString = paramString.Oli;; paramString = paramString.Olj)
    {
      bool1 = bool2;
      if (paramString != null)
      {
        Log.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(paramString.TAN) });
        bool1 = paramString.TAN;
      }
      if (bool1)
      {
        Log.i("MicroMsg.LqtSaveFetchLogic", "saveOrfetchDone, req again after deal");
        aM(this.mode, this.Omq, 1);
      }
      AppMethodBeat.o(68538);
      return;
      h.aHH();
      h.aHG().aHp().set(ar.a.Vug, paramString);
      break;
      bool1 = false;
      break label47;
    }
  }
  
  public final void gF(final String paramString, int paramInt)
  {
    AppMethodBeat.i(191875);
    Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
    this.Oml.showLoading(false);
    String str = this.Oml.getIntent().getStringExtra("operate_id");
    this.Omk.Omc.a(this.Omm, this.fww, this.Omn, this.Omq, str, this.Oms, paramInt).f(new a() {}).a(new d.a()
    {
      public final void cm(Object paramAnonymousObject)
      {
        AppMethodBeat.i(68531);
        Log.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", new Object[] { paramAnonymousObject });
        af.a(af.this).hideLoading();
        if ((af.a(af.this) instanceof WalletLqtSaveFetchUI))
        {
          ((WalletLqtSaveFetchUI)af.a(af.this)).BK(false);
          MMHandlerThread.postToMainThreadDelayed(((WalletLqtSaveFetchUI)af.a(af.this)).mMK, 300L);
        }
        if (af.d(af.this) != null) {
          af.d(af.this).eo(paramAnonymousObject);
        }
        AppMethodBeat.o(68531);
      }
    });
    AppMethodBeat.o(191875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.af
 * JD-Core Version:    0.7.0.1
 */