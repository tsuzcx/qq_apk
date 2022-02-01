package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  implements com.tencent.mm.ak.g
{
  private com.tencent.mm.wallet_core.tenpay.model.n JFL;
  private com.tencent.mm.wallet_core.tenpay.model.g JFM;
  int JFN = 0;
  private com.tencent.mm.ak.g JFO;
  
  public a(com.tencent.mm.ak.g paramg)
  {
    this.JFO = paramg;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, com.tencent.mm.wallet_core.tenpay.model.g paramg)
  {
    AppMethodBeat.i(72832);
    ac.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.JFL != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.JFL.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.JFO.onSceneEnd(paramInt1, paramInt2, paramString, this.JFL);
      if (this.JFN == 1) {
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.JFN = 0;
      AppMethodBeat.o(72832);
      return;
      if (this.JFN == 2)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 5L, 1L);
      }
      else if (this.JFN == 3)
      {
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 6L, 1L);
        continue;
        if (this.JFO != null)
        {
          ac.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.JFO.onSceneEnd(paramInt1, paramInt2, paramString, this.JFL);
          if (this.JFN == 1) {
            com.tencent.mm.plugin.report.service.h.wUl.n(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.JFN != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(965L, 15L, 1L);
            break;
            if (this.JFN == 2) {
              com.tencent.mm.plugin.report.service.h.wUl.n(965L, 8L, 1L);
            } else if (this.JFN == 3) {
              com.tencent.mm.plugin.report.service.h.wUl.n(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.JFN == 2) {
            com.tencent.mm.plugin.report.service.h.wUl.n(965L, 16L, 1L);
          } else if (this.JFN == 3) {
            com.tencent.mm.plugin.report.service.h.wUl.n(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private void b(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72829);
    this.JFL = paramn;
    this.JFL.setHasRetried(true);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    int i = s.ery().esC();
    this.JFN += 1;
    this.JFM = bT(this.JFL.fAI());
    this.JFM.JGd = true;
    int j = s.ery().mRetryCount;
    paramn = this.JFM;
    if (this.JFN >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.Z(bool, this.JFN);
      ac.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(this.JFM, i);
      AppMethodBeat.o(72829);
      return;
    }
  }
  
  private static com.tencent.mm.wallet_core.tenpay.model.g bT(Map<String, String> paramMap)
  {
    AppMethodBeat.i(72830);
    String str = (String)paramMap.get("req_key");
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
      AppMethodBeat.o(72830);
      return paramMap;
    }
    ac.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { str });
    ac.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
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
    ac.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.JFN = 0;
    b(paramn);
    AppMethodBeat.o(72828);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72831);
    this.JFO = null;
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
    AppMethodBeat.o(72831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72833);
    ac.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if (((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.g)) && (this.JFM.equals(paramn)))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      paramn = (com.tencent.mm.wallet_core.tenpay.model.g)paramn;
      ac.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn, Integer.valueOf(paramn.JGc) });
      if (paramn.JGc == 1)
      {
        ac.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramn.fAH(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramn.JGc == 2)
        {
          a(this.JFL.JGi, this.JFL.JGj, this.JFL.JGk, this.JFL.JGl, paramn);
          AppMethodBeat.o(72833);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramn.fAH(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if ((!paramn.checkRecSrvResp()) && (this.JFN < s.ery().mRetryCount))
      {
        ac.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        ac.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { s.ery().BAP });
        com.tencent.mm.plugin.report.service.h.wUl.n(965L, 0L, 1L);
        b(this.JFL);
        AppMethodBeat.o(72833);
        return;
      }
      com.tencent.mm.wallet_core.tenpay.model.n localn = this.JFL;
      int i = s.ery().mRetryCount;
      ac.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.fAJ()), Integer.valueOf(this.JFN) });
      if (this.JFN < i) {}
      for (i = 1; i != 0; i = 0)
      {
        ac.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.JFL);
        AppMethodBeat.o(72833);
        return;
      }
      ac.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramn.JGc) });
      if (paramn.JGc == 1)
      {
        a(paramInt1, paramInt2, paramString, paramn.fAH(), paramn);
        AppMethodBeat.o(72833);
        return;
      }
      if (paramn.JGc == 2)
      {
        a(this.JFL.JGi, this.JFL.JGj, this.JFL.JGk, this.JFL.JGl, paramn);
        AppMethodBeat.o(72833);
        return;
      }
      paramString = s.ery().BAP;
      if (!bs.isNullOrNil(this.JFL.JGk)) {
        paramString = this.JFL.JGk;
      }
      ac.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.JFL.JGi, this.JFL.JGj, paramString, this.JFL.JGl, paramn);
      AppMethodBeat.o(72833);
      return;
    }
    if (((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n)) && (this.JFL.equals(paramn)))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.JFL.checkPaySuccess())
        {
          ac.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).JGl, this.JFM);
          AppMethodBeat.o(72833);
          return;
        }
        if (this.JFL.fAJ())
        {
          ac.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.JFL);
          AppMethodBeat.o(72833);
          return;
        }
        paramString = s.ery().BAP;
        ac.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).JGl, this.JFM);
      }
    }
    AppMethodBeat.o(72833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */