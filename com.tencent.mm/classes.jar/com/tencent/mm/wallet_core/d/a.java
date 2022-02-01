package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.al.g
{
  private com.tencent.mm.wallet_core.tenpay.model.n Iej;
  private com.tencent.mm.wallet_core.tenpay.model.g Iek;
  int Iel = 0;
  private com.tencent.mm.al.g Iem;
  
  public a(com.tencent.mm.al.g paramg)
  {
    this.Iem = paramg;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, com.tencent.mm.wallet_core.tenpay.model.g paramg)
  {
    AppMethodBeat.i(72832);
    ad.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.Iej != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.Iej.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.Iem.onSceneEnd(paramInt1, paramInt2, paramString, this.Iej);
      if (this.Iel == 1) {
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.Iel = 0;
      AppMethodBeat.o(72832);
      return;
      if (this.Iel == 2)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 5L, 1L);
      }
      else if (this.Iel == 3)
      {
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 6L, 1L);
        continue;
        if (this.Iem != null)
        {
          ad.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.Iem.onSceneEnd(paramInt1, paramInt2, paramString, this.Iej);
          if (this.Iel == 1) {
            com.tencent.mm.plugin.report.service.h.vKh.m(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.Iel != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.h.vKh.m(965L, 15L, 1L);
            break;
            if (this.Iel == 2) {
              com.tencent.mm.plugin.report.service.h.vKh.m(965L, 8L, 1L);
            } else if (this.Iel == 3) {
              com.tencent.mm.plugin.report.service.h.vKh.m(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.Iel == 2) {
            com.tencent.mm.plugin.report.service.h.vKh.m(965L, 16L, 1L);
          } else if (this.Iel == 3) {
            com.tencent.mm.plugin.report.service.h.vKh.m(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private void b(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72829);
    this.Iej = paramn;
    this.Iej.setHasRetried(true);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(385, this);
    int i = s.ecc().edh();
    this.Iel += 1;
    this.Iek = bO(this.Iej.fks());
    this.Iek.IeB = true;
    int j = s.ecc().mRetryCount;
    paramn = this.Iek;
    if (this.Iel >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.W(bool, this.Iel);
      ad.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(this.Iek, i);
      AppMethodBeat.o(72829);
      return;
    }
  }
  
  private static com.tencent.mm.wallet_core.tenpay.model.g bO(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72830);
    String str = (String)paramMap.get("req_key");
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    ad.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { str });
    ad.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
    if (str.startsWith("sns_aa_"))
    {
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.b(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("sns_tf_"))
    {
      paramMap = new k(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("sns_ff_"))
    {
      paramMap = new d(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("ts_"))
    {
      paramMap = new e(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("sns_"))
    {
      paramMap = new i(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("offline_"))
    {
      paramMap = new f(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("up_"))
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("seb_ff_"))
    {
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.h(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("tax_"))
    {
      paramMap = new j(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    if (str.startsWith("dc_"))
    {
      paramMap = new c(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
    AppMethodBeat.o(72830);
    return paramMap;
  }
  
  public final void a(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72828);
    ad.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.Iel = 0;
    b(paramn);
    AppMethodBeat.o(72828);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72831);
    this.Iem = null;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, this);
    AppMethodBeat.o(72831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(72833);
    ad.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if (((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.g)) && (this.Iek.equals(paramn)))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      paramn = (com.tencent.mm.wallet_core.tenpay.model.g)paramn;
      ad.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn, Integer.valueOf(paramn.IeA) });
      if (paramn.IeA == 1)
      {
        ad.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramn.fkr(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramn.IeA == 2)
        {
          a(this.Iej.IeG, this.Iej.IeH, this.Iej.IeI, this.Iej.IeJ, paramn);
          AppMethodBeat.o(72833);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramn.fkr(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if ((!paramn.checkRecSrvResp()) && (this.Iel < s.ecc().mRetryCount))
      {
        ad.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        ad.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { s.ecc().Aiu });
        com.tencent.mm.plugin.report.service.h.vKh.m(965L, 0L, 1L);
        b(this.Iej);
        AppMethodBeat.o(72833);
        return;
      }
      com.tencent.mm.wallet_core.tenpay.model.n localn = this.Iej;
      int i = s.ecc().mRetryCount;
      ad.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.fkt()), Integer.valueOf(this.Iel) });
      if (this.Iel < i) {}
      for (i = 1; i != 0; i = 0)
      {
        ad.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.Iej);
        AppMethodBeat.o(72833);
        return;
      }
      ad.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramn.IeA) });
      if (paramn.IeA == 1)
      {
        a(paramInt1, paramInt2, paramString, paramn.fkr(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if (paramn.IeA == 2)
      {
        a(this.Iej.IeG, this.Iej.IeH, this.Iej.IeI, this.Iej.IeJ, paramn);
        AppMethodBeat.o(72833);
        return;
      }
      paramString = s.ecc().Aiu;
      if (!bt.isNullOrNil(this.Iej.IeI)) {
        paramString = this.Iej.IeI;
      }
      ad.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.Iej.IeG, this.Iej.IeH, paramString, this.Iej.IeJ, paramn);
      AppMethodBeat.o(72833);
      return;
    }
    if (((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n)) && (this.Iej.equals(paramn)))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.Iej.checkPaySuccess())
        {
          ad.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).IeJ, this.Iek);
          AppMethodBeat.o(72833);
          return;
        }
        if (this.Iej.fkt())
        {
          ad.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.Iej);
          AppMethodBeat.o(72833);
          return;
        }
        paramString = s.ecc().Aiu;
        ad.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).IeJ, this.Iek);
      }
    }
    AppMethodBeat.o(72833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */