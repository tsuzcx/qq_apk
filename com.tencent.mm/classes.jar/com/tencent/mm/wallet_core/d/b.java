package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public final class b
  implements f
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private com.tencent.mm.wallet_core.tenpay.model.n LyP;
  private int LyR = 0;
  private f LyS;
  
  public b(f paramf)
  {
    this.LyS = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.LyP != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.LyP.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.LyS.onSceneEnd(paramInt1, paramInt2, paramString, this.LyP);
    }
    for (;;)
    {
      ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.LyR = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.LyS != null)
      {
        ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.LyS.onSceneEnd(paramInt1, paramInt2, paramString, this.LyP);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = fRM();
    if (this.LyR >= i)
    {
      AppMethodBeat.o(72834);
      return false;
    }
    AppMethodBeat.o(72834);
    return true;
  }
  
  private void d(int paramInt1, int paramInt2, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(72840);
    a(paramInt1, paramInt2, retryPayInfo.Lzd, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).Lzp);
    AppMethodBeat.o(72840);
  }
  
  private static int fRM()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.dux()))
    {
      int i = retryPayInfo.HnR;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.dux())) {}
    int k;
    for (int i = retryPayInfo.Lzc;; i = 0)
    {
      k = fRM();
      this.LyR += 1;
      if (this.LyR <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.LyP = paramn;
    this.LyP.setHasRetried(true);
    g.ajD();
    g.ajB().gAO.a(385, this);
    this.LyP.resetForRetry();
    int m = this.LyR;
    if (this.LyR >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      g.ajD();
      g.ajB().gAO.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.LyS = null;
    g.ajD();
    g.ajB().gAO.b(385, this);
    AppMethodBeat.o(72837);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(72839);
    ad.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n))
    {
      if ((paramn instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramn).getRetryPayInfo();
        if (localRetryPayInfo.dux()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      g.ajD();
      g.ajB().gAO.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.LyP.checkPaySuccess())
        {
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).Lzp);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.LyP.canPayRetry()) && (canRetry()))
        {
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.LyP.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.LyP))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).checkRecSrvResp())
        {
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.LyP))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.Lzd;
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).Lzp);
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