package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.g;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.k;
import com.tencent.mm.wallet_core.tenpay.model.l;
import com.tencent.mm.wallet_core.tenpay.model.n;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.am.h
{
  private n agTM;
  private g agTN;
  int agTO = 0;
  private com.tencent.mm.am.h agTP;
  
  public a(com.tencent.mm.am.h paramh)
  {
    this.agTP = paramh;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject, g paramg)
  {
    AppMethodBeat.i(72832);
    Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.agTM != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.agTM.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.agTP.onSceneEnd(paramInt1, paramInt2, paramString, this.agTM);
      if (this.agTO == 1) {
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 4L, 1L);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.agTO = 0;
      AppMethodBeat.o(72832);
      return;
      if (this.agTO == 2)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 5L, 1L);
      }
      else if (this.agTO == 3)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 6L, 1L);
        continue;
        if (this.agTP != null)
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
          this.agTP.onSceneEnd(paramInt1, paramInt2, paramString, this.agTM);
          if (this.agTO == 1) {
            com.tencent.mm.plugin.report.service.h.OAn.p(965L, 7L, 1L);
          }
          for (;;)
          {
            if (paramg.checkRecSrvResp()) {
              break label305;
            }
            if (this.agTO != 1) {
              break label307;
            }
            com.tencent.mm.plugin.report.service.h.OAn.p(965L, 15L, 1L);
            break;
            if (this.agTO == 2) {
              com.tencent.mm.plugin.report.service.h.OAn.p(965L, 8L, 1L);
            } else if (this.agTO == 3) {
              com.tencent.mm.plugin.report.service.h.OAn.p(965L, 9L, 1L);
            }
          }
          label305:
          continue;
          label307:
          if (this.agTO == 2) {
            com.tencent.mm.plugin.report.service.h.OAn.p(965L, 16L, 1L);
          } else if (this.agTO == 3) {
            com.tencent.mm.plugin.report.service.h.OAn.p(965L, 17L, 1L);
          }
        }
      }
    }
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(72829);
    this.agTM = paramn;
    this.agTM.setHasRetried(true);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    int i = u.iiC().ijL();
    this.agTO += 1;
    this.agTN = cW(this.agTM.jPi());
    this.agTN.agUe = true;
    int j = u.iiC().mRetryCount;
    paramn = this.agTN;
    if (this.agTO >= j) {}
    for (boolean bool = true;; bool = false)
    {
      paramn.ax(bool, this.agTO);
      Log.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(this.agTN, i);
      AppMethodBeat.o(72829);
      return;
    }
  }
  
  private static g cW(Map<String, String> paramMap)
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
    this.agTO = 0;
    b(paramn);
    AppMethodBeat.o(72828);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72831);
    this.agTP = null;
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    AppMethodBeat.o(72831);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72833);
    Log.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if (((paramp instanceof g)) && (this.agTN.equals(paramp)))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      paramp = (g)paramp;
      Log.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp, Integer.valueOf(paramp.agUd) });
      if (paramp.agUd == 1)
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramp.jPh(), paramp);
        AppMethodBeat.o(72833);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
        if (paramp.agUd == 2)
        {
          a(this.agTM.agUj, this.agTM.agUk, this.agTM.agUl, this.agTM.agUm, paramp);
          AppMethodBeat.o(72833);
          return;
        }
        a(paramInt1, paramInt2, paramString, paramp.jPh(), paramp);
        AppMethodBeat.o(72833);
        return;
      }
      if ((!paramp.checkRecSrvResp()) && (this.agTO < u.iiC().mRetryCount))
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { u.iiC().VKp });
        com.tencent.mm.plugin.report.service.h.OAn.p(965L, 0L, 1L);
        b(this.agTM);
        AppMethodBeat.o(72833);
        return;
      }
      n localn = this.agTM;
      int i = u.iiC().mRetryCount;
      Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(localn.jPj()), Integer.valueOf(this.agTO) });
      if (this.agTO < i) {}
      for (i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
        b(this.agTM);
        AppMethodBeat.o(72833);
        return;
      }
      Log.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail, retmsg_type: %s", new Object[] { Integer.valueOf(paramp.agUd) });
      if (paramp.agUd == 1)
      {
        a(paramInt1, paramInt2, paramString, paramp.jPh(), paramp);
        AppMethodBeat.o(72833);
        return;
      }
      if (paramp.agUd == 2)
      {
        a(this.agTM.agUj, this.agTM.agUk, this.agTM.agUl, this.agTM.agUm, paramp);
        AppMethodBeat.o(72833);
        return;
      }
      paramString = u.iiC().VKp;
      if (!Util.isNullOrNil(this.agTM.agUl)) {
        paramString = this.agTM.agUl;
      }
      Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
      a(this.agTM.agUj, this.agTM.agUk, paramString, this.agTM.agUm, paramp);
      AppMethodBeat.o(72833);
      return;
    }
    if (((paramp instanceof n)) && (this.agTM.equals(paramp)))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      if (((n)paramp).ishasCGiRetried())
      {
        if (this.agTM.checkPaySuccess())
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramp).agUm, this.agTN);
          AppMethodBeat.o(72833);
          return;
        }
        if (this.agTM.jPj())
        {
          Log.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
          b(this.agTM);
          AppMethodBeat.o(72833);
          return;
        }
        paramString = u.iiC().VKp;
        Log.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
        a(paramInt1, paramInt2, paramString, ((n)paramp).agUm, this.agTN);
      }
    }
    AppMethodBeat.o(72833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.a
 * JD-Core Version:    0.7.0.1
 */