package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import org.json.JSONObject;

public final class b
  implements f
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private n AXw;
  private int AXy = 0;
  private f AXz;
  
  public b(f paramf)
  {
    this.AXz = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49122);
    ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.AXw != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.AXw.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.AXz.onSceneEnd(paramInt1, paramInt2, paramString, this.AXw);
    }
    for (;;)
    {
      ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.AXy = 0;
      AppMethodBeat.o(49122);
      return;
      if (this.AXz != null)
      {
        ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.AXz.onSceneEnd(paramInt1, paramInt2, paramString, this.AXw);
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(49124);
    a(paramInt1, paramInt2, retryPayInfo.AXK, ((n)paramm).AXW);
    AppMethodBeat.o(49124);
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(49118);
    int i = dSE();
    if (this.AXy >= i)
    {
      AppMethodBeat.o(49118);
      return false;
    }
    AppMethodBeat.o(49118);
    return true;
  }
  
  private static int dSE()
  {
    AppMethodBeat.i(49119);
    if ((retryPayInfo != null) && (retryPayInfo.bWX()))
    {
      int i = retryPayInfo.xJf;
      AppMethodBeat.o(49119);
      return i;
    }
    AppMethodBeat.o(49119);
    return 0;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(49120);
    if ((retryPayInfo != null) && (retryPayInfo.bWX())) {}
    int k;
    for (int i = retryPayInfo.AXJ;; i = 0)
    {
      k = dSE();
      this.AXy += 1;
      if (this.AXy <= k) {
        break;
      }
      AppMethodBeat.o(49120);
      return false;
    }
    this.AXw = paramn;
    this.AXw.setHasRetried(true);
    g.RM();
    g.RK().eHt.a(385, this);
    this.AXw.resetForRetry();
    int m = this.AXy;
    if (this.AXy >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      g.RM();
      g.RK().eHt.a(paramn, i * 1000);
      AppMethodBeat.o(49120);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(49121);
    this.AXz = null;
    g.RM();
    g.RK().eHt.b(385, this);
    AppMethodBeat.o(49121);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(49123);
    ab.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof n))
    {
      if ((paramm instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramm).getRetryPayInfo();
        if (localRetryPayInfo.bWX()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      g.RM();
      g.RK().eHt.b(385, this);
      if (((n)paramm).ishasCGiRetried())
      {
        if (this.AXw.checkPaySuccess())
        {
          ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramm).AXW);
          AppMethodBeat.o(49123);
          return;
        }
        if ((this.AXw.canPayRetry()) && (canRetry()))
        {
          ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.AXw.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.AXw))
          {
            c(paramInt1, paramInt2, paramm);
            AppMethodBeat.o(49123);
          }
        }
        else if (((n)paramm).checkRecSrvResp())
        {
          ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.AXw))
          {
            c(paramInt1, paramInt2, paramm);
            AppMethodBeat.o(49123);
          }
        }
        else
        {
          paramString = retryPayInfo.AXK;
          ab.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((n)paramm).AXW);
        }
      }
    }
    AppMethodBeat.o(49123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */