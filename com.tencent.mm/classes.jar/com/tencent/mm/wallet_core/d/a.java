package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ak.f
{
  private com.tencent.mm.wallet_core.tenpay.model.n LVE;
  private com.tencent.mm.wallet_core.tenpay.model.g LVF;
  int LVG = 0;
  private com.tencent.mm.ak.f LVH;
  
  public a(com.tencent.mm.ak.f paramf)
  {
    this.LVH = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, com.tencent.mm.wallet_core.tenpay.model.g paramg)
  {
    AppMethodBeat.i(72832);
    ae.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.LVE != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.LVE.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.LVH.onSceneEnd(paramInt1, paramInt2, paramString, this.LVE);
      if (this.LVG == 1) {
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.LVG = 0;
      AppMethodBeat.o(72832);
      return;
      if (this.LVG == 2)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 5L, 1L);
      }
      else if (this.LVG == 3)
      {
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 6L, 1L);
        continue;
        if (this.LVH != null)
        {
          ae.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.LVH.onSceneEnd(paramInt1, paramInt2, paramString, this.LVE);
          if (this.LVG == 1) {
            com.tencent.mm.plugin.report.service.g.yxI.n(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.LVG != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.g.yxI.n(965L, 15L, 1L);
            break;
            if (this.LVG == 2) {
              com.tencent.mm.plugin.report.service.g.yxI.n(965L, 8L, 1L);
            } else if (this.LVG == 3) {
              com.tencent.mm.plugin.report.service.g.yxI.n(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.LVG == 2) {
            com.tencent.mm.plugin.report.service.g.yxI.n(965L, 16L, 1L);
          } else if (this.LVG == 3) {
            com.tencent.mm.plugin.report.service.g.yxI.n(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private void b(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72829);
    this.LVE = paramn;
    this.LVE.setHasRetried(true);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(385, this);
    int i = t.eJf().eKj();
    this.LVG += 1;
    this.LVF = ce(this.LVE.fWo());
    this.LVF.LVW = true;
    int j = t.eJf().mRetryCount;
    paramn = this.LVF;
    if (this.LVG >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.ae(bool, this.LVG);
      ae.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.LVF, i);
      AppMethodBeat.o(72829);
      return;
    }
  }
  
  private static com.tencent.mm.wallet_core.tenpay.model.g ce(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72830);
    String str = (String)paramMap.get("req_key");
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    ae.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { str });
    ae.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
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
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.f(paramMap);
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
      paramMap = new h(paramMap);
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
    ae.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.LVG = 0;
    b(paramn);
    AppMethodBeat.o(72828);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72831);
    this.LVH = null;
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(385, this);
    AppMethodBeat.o(72831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72833);
    ae.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if (((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.g)) && (this.LVF.equals(paramn)))
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(385, this);
      paramn = (com.tencent.mm.wallet_core.tenpay.model.g)paramn;
      ae.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn, Integer.valueOf(paramn.LVV) });
      if (paramn.LVV == 1)
      {
        ae.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramn.fWn(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramn.LVV == 2)
        {
          a(this.LVE.LWb, this.LVE.LWc, this.LVE.LWd, this.LVE.LWe, paramn);
          AppMethodBeat.o(72833);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramn.fWn(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if ((!paramn.checkRecSrvResp()) && (this.LVG < t.eJf().mRetryCount))
      {
        ae.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        ae.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { t.eJf().DsL });
        com.tencent.mm.plugin.report.service.g.yxI.n(965L, 0L, 1L);
        b(this.LVE);
        AppMethodBeat.o(72833);
        return;
      }
      com.tencent.mm.wallet_core.tenpay.model.n localn = this.LVE;
      int i = t.eJf().mRetryCount;
      ae.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.fWp()), Integer.valueOf(this.LVG) });
      if (this.LVG < i) {}
      for (i = 1; i != 0; i = 0)
      {
        ae.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.LVE);
        AppMethodBeat.o(72833);
        return;
      }
      ae.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramn.LVV) });
      if (paramn.LVV == 1)
      {
        a(paramInt1, paramInt2, paramString, paramn.fWn(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if (paramn.LVV == 2)
      {
        a(this.LVE.LWb, this.LVE.LWc, this.LVE.LWd, this.LVE.LWe, paramn);
        AppMethodBeat.o(72833);
        return;
      }
      paramString = t.eJf().DsL;
      if (!bu.isNullOrNil(this.LVE.LWd)) {
        paramString = this.LVE.LWd;
      }
      ae.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.LVE.LWb, this.LVE.LWc, paramString, this.LVE.LWe, paramn);
      AppMethodBeat.o(72833);
      return;
    }
    if (((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n)) && (this.LVE.equals(paramn)))
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.LVE.checkPaySuccess())
        {
          ae.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).LWe, this.LVF);
          AppMethodBeat.o(72833);
          return;
        }
        if (this.LVE.fWp())
        {
          ae.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.LVE);
          AppMethodBeat.o(72833);
          return;
        }
        paramString = t.eJf().DsL;
        ae.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).LWe, this.LVF);
      }
    }
    AppMethodBeat.o(72833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */