package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.al.g
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private com.tencent.mm.wallet_core.tenpay.model.n Iej;
  private int Iel = 0;
  private com.tencent.mm.al.g Iem;
  
  public b(com.tencent.mm.al.g paramg)
  {
    this.Iem = paramg;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.Iej != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.Iej.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.Iem.onSceneEnd(paramInt1, paramInt2, paramString, this.Iej);
    }
    for (;;)
    {
      ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.Iel = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.Iem != null)
      {
        ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.Iem.onSceneEnd(paramInt1, paramInt2, paramString, this.Iej);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = fkm();
    if (this.Iel >= i)
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
    a(paramInt1, paramInt2, retryPayInfo.Iex, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).IeJ);
    AppMethodBeat.o(72840);
  }
  
  private static int fkm()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.cWD()))
    {
      int i = retryPayInfo.EgF;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.cWD())) {}
    int k;
    for (int i = retryPayInfo.Iew;; i = 0)
    {
      k = fkm();
      this.Iel += 1;
      if (this.Iel <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.Iej = paramn;
    this.Iej.setHasRetried(true);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(385, this);
    this.Iej.resetForRetry();
    int m = this.Iel;
    if (this.Iel >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.Iem = null;
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(385, this);
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
        if (localRetryPayInfo.cWD()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.Iej.checkPaySuccess())
        {
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).IeJ);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.Iej.canPayRetry()) && (canRetry()))
        {
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.Iej.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.Iej))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).checkRecSrvResp())
        {
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.Iej))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.Iex;
          ad.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).IeJ);
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