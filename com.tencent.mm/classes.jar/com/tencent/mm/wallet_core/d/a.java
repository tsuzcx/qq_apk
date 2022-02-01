package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.g;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.an.i
{
  private n YVS;
  private g YVT;
  int YVU = 0;
  private com.tencent.mm.an.i YVV;
  
  public a(com.tencent.mm.an.i parami)
  {
    this.YVV = parami;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, g paramg)
  {
    AppMethodBeat.i(72832);
    Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.YVS != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.YVS.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.YVV.onSceneEnd(paramInt1, paramInt2, paramString, this.YVS);
      if (this.YVU == 1) {
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.YVU = 0;
      AppMethodBeat.o(72832);
      return;
      if (this.YVU == 2)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 5L, 1L);
      }
      else if (this.YVU == 3)
      {
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 6L, 1L);
        continue;
        if (this.YVV != null)
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.YVV.onSceneEnd(paramInt1, paramInt2, paramString, this.YVS);
          if (this.YVU == 1) {
            com.tencent.mm.plugin.report.service.h.IzE.p(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.YVU != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.h.IzE.p(965L, 15L, 1L);
            break;
            if (this.YVU == 2) {
              com.tencent.mm.plugin.report.service.h.IzE.p(965L, 8L, 1L);
            } else if (this.YVU == 3) {
              com.tencent.mm.plugin.report.service.h.IzE.p(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.YVU == 2) {
            com.tencent.mm.plugin.report.service.h.IzE.p(965L, 16L, 1L);
          } else if (this.YVU == 3) {
            com.tencent.mm.plugin.report.service.h.IzE.p(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(72829);
    this.YVS = paramn;
    this.YVS.setHasRetried(true);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(385, this);
    int i = u.gJo().gKt();
    this.YVU += 1;
    this.YVT = cs(this.YVS.ijn());
    this.YVT.YWk = true;
    int j = u.gJo().mRetryCount;
    paramn = this.YVT;
    if (this.YVU >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.au(bool, this.YVU);
      Log.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(this.YVT, i);
      AppMethodBeat.o(72829);
      return;
    }
  }
  
  private static g cs(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72830);
    String str = (String)paramMap.get("req_key");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramMap = new g(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    Log.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { str });
    Log.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
    if (str.startsWith("sns_aa_"))
    {
      paramMap = new b(paramMap);
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
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.c(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    paramMap = new g(paramMap);
    AppMethodBeat.o(72830);
    return paramMap;
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(72828);
    Log.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.YVU = 0;
    b(paramn);
    AppMethodBeat.o(72828);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72831);
    this.YVV = null;
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
    AppMethodBeat.o(72831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72833);
    Log.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if (((paramq instanceof g)) && (this.YVT.equals(paramq)))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
      paramq = (g)paramq;
      Log.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq, Integer.valueOf(paramq.YWj) });
      if (paramq.YWj == 1)
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramq.ijm(), paramq);
        AppMethodBeat.o(72833);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramq.YWj == 2)
        {
          a(this.YVS.YWp, this.YVS.YWq, this.YVS.YWr, this.YVS.YWs, paramq);
          AppMethodBeat.o(72833);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramq.ijm(), paramq);
        AppMethodBeat.o(72833);
        return;
      }
      if ((!paramq.checkRecSrvResp()) && (this.YVU < u.gJo().mRetryCount))
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { u.gJo().OUj });
        com.tencent.mm.plugin.report.service.h.IzE.p(965L, 0L, 1L);
        b(this.YVS);
        AppMethodBeat.o(72833);
        return;
      }
      n localn = this.YVS;
      int i = u.gJo().mRetryCount;
      Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.ijo()), Integer.valueOf(this.YVU) });
      if (this.YVU < i) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.YVS);
        AppMethodBeat.o(72833);
        return;
      }
      Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramq.YWj) });
      if (paramq.YWj == 1)
      {
        a(paramInt1, paramInt2, paramString, paramq.ijm(), paramq);
        AppMethodBeat.o(72833);
        return;
      }
      if (paramq.YWj == 2)
      {
        a(this.YVS.YWp, this.YVS.YWq, this.YVS.YWr, this.YVS.YWs, paramq);
        AppMethodBeat.o(72833);
        return;
      }
      paramString = u.gJo().OUj;
      if (!Util.isNullOrNil(this.YVS.YWr)) {
        paramString = this.YVS.YWr;
      }
      Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.YVS.YWp, this.YVS.YWq, paramString, this.YVS.YWs, paramq);
      AppMethodBeat.o(72833);
      return;
    }
    if (((paramq instanceof n)) && (this.YVS.equals(paramq)))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.b(385, this);
      if (((n)paramq).ishasCGiRetried())
      {
        if (this.YVS.checkPaySuccess())
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramq).YWs, this.YVT);
          AppMethodBeat.o(72833);
          return;
        }
        if (this.YVS.ijo())
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.YVS);
          AppMethodBeat.o(72833);
          return;
        }
        paramString = u.gJo().OUj;
        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((n)paramq).YWs, this.YVT);
      }
    }
    AppMethodBeat.o(72833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */