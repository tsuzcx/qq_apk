package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ai.f
{
  private n AXw;
  private com.tencent.mm.wallet_core.tenpay.model.g AXx;
  int AXy = 0;
  private com.tencent.mm.ai.f AXz;
  
  public a(com.tencent.mm.ai.f paramf)
  {
    this.AXz = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, com.tencent.mm.wallet_core.tenpay.model.g paramg)
  {
    AppMethodBeat.i(49116);
    ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.AXw != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.AXw.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.AXz.onSceneEnd(paramInt1, paramInt2, paramString, this.AXw);
      if (this.AXy == 1) {
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.AXy = 0;
      AppMethodBeat.o(49116);
      return;
      if (this.AXy == 2)
      {
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 5L, 1L);
      }
      else if (this.AXy == 3)
      {
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 6L, 1L);
        continue;
        if (this.AXz != null)
        {
          ab.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.AXz.onSceneEnd(paramInt1, paramInt2, paramString, this.AXw);
          if (this.AXy == 1) {
            com.tencent.mm.plugin.report.service.h.qsU.j(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.AXy != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.h.qsU.j(965L, 15L, 1L);
            break;
            if (this.AXy == 2) {
              com.tencent.mm.plugin.report.service.h.qsU.j(965L, 8L, 1L);
            } else if (this.AXy == 3) {
              com.tencent.mm.plugin.report.service.h.qsU.j(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.AXy == 2) {
            com.tencent.mm.plugin.report.service.h.qsU.j(965L, 16L, 1L);
          } else if (this.AXy == 3) {
            com.tencent.mm.plugin.report.service.h.qsU.j(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private static com.tencent.mm.wallet_core.tenpay.model.g aZ(Map<String, String> paramMap)
  {
    AppMethodBeat.i(49114);
    String str = (String)paramMap.get("req_key");
    if (bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    ab.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { str });
    ab.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
    if (str.startsWith("sns_aa_"))
    {
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.b(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("sns_tf_"))
    {
      paramMap = new k(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("sns_ff_"))
    {
      paramMap = new d(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("ts_"))
    {
      paramMap = new e(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("sns_"))
    {
      paramMap = new i(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("offline_"))
    {
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.f(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("up_"))
    {
      paramMap = new l(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("seb_ff_"))
    {
      paramMap = new com.tencent.mm.wallet_core.tenpay.model.h(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("tax_"))
    {
      paramMap = new j(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    if (str.startsWith("dc_"))
    {
      paramMap = new c(paramMap);
      AppMethodBeat.o(49114);
      return paramMap;
    }
    paramMap = new com.tencent.mm.wallet_core.tenpay.model.g(paramMap);
    AppMethodBeat.o(49114);
    return paramMap;
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(49113);
    this.AXw = paramn;
    this.AXw.setHasRetried(true);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(385, this);
    int i = t.cTN().cUN();
    this.AXy += 1;
    this.AXx = aZ(this.AXw.dSL());
    this.AXx.AXO = true;
    int j = t.cTN().mRetryCount;
    paramn = this.AXx;
    if (this.AXy >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.L(bool, this.AXy);
      ab.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.a(this.AXx, i);
      AppMethodBeat.o(49113);
      return;
    }
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(49112);
    ab.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.AXy = 0;
    b(paramn);
    AppMethodBeat.o(49112);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(49115);
    this.AXz = null;
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.b(385, this);
    AppMethodBeat.o(49115);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(49117);
    ab.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if (((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.g)) && (this.AXx.equals(paramm)))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(385, this);
      paramm = (com.tencent.mm.wallet_core.tenpay.model.g)paramm;
      ab.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm, Integer.valueOf(paramm.AXN) });
      if (paramm.AXN == 1)
      {
        ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramm.dSK(), paramm);
        AppMethodBeat.o(49117);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramm.AXN == 2)
        {
          a(this.AXw.AXT, this.AXw.AXU, this.AXw.AXV, this.AXw.AXW, paramm);
          AppMethodBeat.o(49117);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramm.dSK(), paramm);
        AppMethodBeat.o(49117);
        return;
      }
      if ((!paramm.checkRecSrvResp()) && (this.AXy < t.cTN().mRetryCount))
      {
        ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { t.cTN().ulZ });
        com.tencent.mm.plugin.report.service.h.qsU.j(965L, 0L, 1L);
        b(this.AXw);
        AppMethodBeat.o(49117);
        return;
      }
      n localn = this.AXw;
      int i = t.cTN().mRetryCount;
      ab.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.dSM()), Integer.valueOf(this.AXy) });
      if (this.AXy < i) {}
      for (i = 1; i != 0; i = 0)
      {
        ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.AXw);
        AppMethodBeat.o(49117);
        return;
      }
      ab.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramm.AXN) });
      if (paramm.AXN == 1)
      {
        a(paramInt1, paramInt2, paramString, paramm.dSK(), paramm);
        AppMethodBeat.o(49117);
        return;
      }
      if (paramm.AXN == 2)
      {
        a(this.AXw.AXT, this.AXw.AXU, this.AXw.AXV, this.AXw.AXW, paramm);
        AppMethodBeat.o(49117);
        return;
      }
      paramString = t.cTN().ulZ;
      if (!bo.isNullOrNil(this.AXw.AXV)) {
        paramString = this.AXw.AXV;
      }
      ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.AXw.AXT, this.AXw.AXU, paramString, this.AXw.AXW, paramm);
      AppMethodBeat.o(49117);
      return;
    }
    if (((paramm instanceof n)) && (this.AXw.equals(paramm)))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RK().eHt.b(385, this);
      if (((n)paramm).ishasCGiRetried())
      {
        if (this.AXw.checkPaySuccess())
        {
          ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramm).AXW, this.AXx);
          AppMethodBeat.o(49117);
          return;
        }
        if (this.AXw.dSM())
        {
          ab.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.AXw);
          AppMethodBeat.o(49117);
          return;
        }
        paramString = t.cTN().ulZ;
        ab.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((n)paramm).AXW, this.AXx);
      }
    }
    AppMethodBeat.o(49117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */