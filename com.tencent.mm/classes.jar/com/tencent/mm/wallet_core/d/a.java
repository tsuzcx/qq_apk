package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ak.i
{
  private n Ruu;
  private com.tencent.mm.wallet_core.tenpay.model.g Ruv;
  int Ruw = 0;
  private com.tencent.mm.ak.i Rux;
  
  public a(com.tencent.mm.ak.i parami)
  {
    this.Rux = parami;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, com.tencent.mm.wallet_core.tenpay.model.g paramg)
  {
    AppMethodBeat.i(72832);
    Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.Ruu != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.Ruu.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.Rux.onSceneEnd(paramInt1, paramInt2, paramString, this.Ruu);
      if (this.Ruw == 1) {
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.Ruw = 0;
      AppMethodBeat.o(72832);
      return;
      if (this.Ruw == 2)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 5L, 1L);
      }
      else if (this.Ruw == 3)
      {
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 6L, 1L);
        continue;
        if (this.Rux != null)
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.Rux.onSceneEnd(paramInt1, paramInt2, paramString, this.Ruu);
          if (this.Ruw == 1) {
            com.tencent.mm.plugin.report.service.h.CyF.n(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.Ruw != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.h.CyF.n(965L, 15L, 1L);
            break;
            if (this.Ruw == 2) {
              com.tencent.mm.plugin.report.service.h.CyF.n(965L, 8L, 1L);
            } else if (this.Ruw == 3) {
              com.tencent.mm.plugin.report.service.h.CyF.n(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.Ruw == 2) {
            com.tencent.mm.plugin.report.service.h.CyF.n(965L, 16L, 1L);
          } else if (this.Ruw == 3) {
            com.tencent.mm.plugin.report.service.h.CyF.n(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(72829);
    this.Ruu = paramn;
    this.Ruu.setHasRetried(true);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(385, this);
    int i = com.tencent.mm.plugin.wallet_core.model.t.fQI().fRO();
    this.Ruw += 1;
    this.Ruv = cm(this.Ruu.hhM());
    this.Ruv.RuM = true;
    int j = com.tencent.mm.plugin.wallet_core.model.t.fQI().mRetryCount;
    paramn = this.Ruv;
    if (this.Ruw >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.ag(bool, this.Ruw);
      Log.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(this.Ruv, i);
      AppMethodBeat.o(72829);
      return;
    }
  }
  
  private static com.tencent.mm.wallet_core.tenpay.model.g cm(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72830);
    String str = (String)paramMap.get("req_key");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    Log.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { str });
    Log.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
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
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.i(paramMap);
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
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(72828);
    Log.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.Ruw = 0;
    b(paramn);
    AppMethodBeat.o(72828);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72831);
    this.Rux = null;
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
    AppMethodBeat.o(72831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72833);
    Log.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if (((paramq instanceof com.tencent.mm.wallet_core.tenpay.model.g)) && (this.Ruv.equals(paramq)))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
      paramq = (com.tencent.mm.wallet_core.tenpay.model.g)paramq;
      Log.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq, Integer.valueOf(paramq.RuL) });
      if (paramq.RuL == 1)
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramq.hhL(), paramq);
        AppMethodBeat.o(72833);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramq.RuL == 2)
        {
          a(this.Ruu.RuR, this.Ruu.RuS, this.Ruu.RuT, this.Ruu.RuU, paramq);
          AppMethodBeat.o(72833);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramq.hhL(), paramq);
        AppMethodBeat.o(72833);
        return;
      }
      if ((!paramq.checkRecSrvResp()) && (this.Ruw < com.tencent.mm.plugin.wallet_core.model.t.fQI().mRetryCount))
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { com.tencent.mm.plugin.wallet_core.model.t.fQI().IbX });
        com.tencent.mm.plugin.report.service.h.CyF.n(965L, 0L, 1L);
        b(this.Ruu);
        AppMethodBeat.o(72833);
        return;
      }
      n localn = this.Ruu;
      int i = com.tencent.mm.plugin.wallet_core.model.t.fQI().mRetryCount;
      Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.hhN()), Integer.valueOf(this.Ruw) });
      if (this.Ruw < i) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.Ruu);
        AppMethodBeat.o(72833);
        return;
      }
      Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramq.RuL) });
      if (paramq.RuL == 1)
      {
        a(paramInt1, paramInt2, paramString, paramq.hhL(), paramq);
        AppMethodBeat.o(72833);
        return;
      }
      if (paramq.RuL == 2)
      {
        a(this.Ruu.RuR, this.Ruu.RuS, this.Ruu.RuT, this.Ruu.RuU, paramq);
        AppMethodBeat.o(72833);
        return;
      }
      paramString = com.tencent.mm.plugin.wallet_core.model.t.fQI().IbX;
      if (!Util.isNullOrNil(this.Ruu.RuT)) {
        paramString = this.Ruu.RuT;
      }
      Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.Ruu.RuR, this.Ruu.RuS, paramString, this.Ruu.RuU, paramq);
      AppMethodBeat.o(72833);
      return;
    }
    if (((paramq instanceof n)) && (this.Ruu.equals(paramq)))
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
      if (((n)paramq).ishasCGiRetried())
      {
        if (this.Ruu.checkPaySuccess())
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramq).RuU, this.Ruv);
          AppMethodBeat.o(72833);
          return;
        }
        if (this.Ruu.hhN())
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.Ruu);
          AppMethodBeat.o(72833);
          return;
        }
        paramString = com.tencent.mm.plugin.wallet_core.model.t.fQI().IbX;
        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((n)paramq).RuU, this.Ruv);
      }
    }
    AppMethodBeat.o(72833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */