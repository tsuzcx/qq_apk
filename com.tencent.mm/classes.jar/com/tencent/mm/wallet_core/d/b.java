package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.ak.g
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private com.tencent.mm.wallet_core.tenpay.model.n JFL;
  private int JFN = 0;
  private com.tencent.mm.ak.g JFO;
  
  public b(com.tencent.mm.ak.g paramg)
  {
    this.JFO = paramg;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.JFL != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.JFL.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.JFO.onSceneEnd(paramInt1, paramInt2, paramString, this.JFL);
    }
    for (;;)
    {
      ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.JFN = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.JFO != null)
      {
        ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.JFO.onSceneEnd(paramInt1, paramInt2, paramString, this.JFL);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = fAC();
    if (this.JFN >= i)
    {
      AppMethodBeat.o(72834);
      return false;
    }
    AppMethodBeat.o(72834);
    return true;
  }
  
  private void d(int paramInt1, int paramInt2, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72840);
    a(paramInt1, paramInt2, retryPayInfo.JFZ, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).JGl);
    AppMethodBeat.o(72840);
  }
  
  private static int fAC()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.dkl()))
    {
      int i = retryPayInfo.FDE;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.dkl())) {}
    int k;
    for (int i = retryPayInfo.JFY;; i = 0)
    {
      k = fAC();
      this.JFN += 1;
      if (this.JFN <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.JFL = paramn;
    this.JFL.setHasRetried(true);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(385, this);
    this.JFL.resetForRetry();
    int m = this.JFN;
    if (this.JFN >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.JFO = null;
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
    AppMethodBeat.o(72837);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72839);
    ac.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n))
    {
      if ((paramn instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramn).getRetryPayInfo();
        if (localRetryPayInfo.dkl()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.JFL.checkPaySuccess())
        {
          ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).JGl);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.JFL.canPayRetry()) && (canRetry()))
        {
          ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.JFL.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.JFL))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).checkRecSrvResp())
        {
          ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.JFL))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.JFZ;
          ac.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).JGl);
        }
      }
    }
    AppMethodBeat.o(72839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */