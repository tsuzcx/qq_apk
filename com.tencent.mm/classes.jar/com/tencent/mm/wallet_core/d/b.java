package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import org.json.JSONObject;

public final class b
  implements f
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private com.tencent.mm.wallet_core.tenpay.model.n LVE;
  private int LVG = 0;
  private f LVH;
  
  public b(f paramf)
  {
    this.LVH = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.LVE != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.LVE.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.LVH.onSceneEnd(paramInt1, paramInt2, paramString, this.LVE);
    }
    for (;;)
    {
      ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.LVG = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.LVH != null)
      {
        ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.LVH.onSceneEnd(paramInt1, paramInt2, paramString, this.LVE);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = fWi();
    if (this.LVG >= i)
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
    a(paramInt1, paramInt2, retryPayInfo.LVS, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).LWe);
    AppMethodBeat.o(72840);
  }
  
  private static int fWi()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.dxN()))
    {
      int i = retryPayInfo.HHr;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(com.tencent.mm.wallet_core.tenpay.model.n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.dxN())) {}
    int k;
    for (int i = retryPayInfo.LVR;; i = 0)
    {
      k = fWi();
      this.LVG += 1;
      if (this.LVG <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.LVE = paramn;
    this.LVE.setHasRetried(true);
    g.ajS();
    g.ajQ().gDv.a(385, this);
    this.LVE.resetForRetry();
    int m = this.LVG;
    if (this.LVG >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      g.ajS();
      g.ajQ().gDv.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.LVH = null;
    g.ajS();
    g.ajQ().gDv.b(385, this);
    AppMethodBeat.o(72837);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(72839);
    ae.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramn });
    if ((paramn instanceof com.tencent.mm.wallet_core.tenpay.model.n))
    {
      if ((paramn instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramn).getRetryPayInfo();
        if (localRetryPayInfo.dxN()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      g.ajS();
      g.ajQ().gDv.b(385, this);
      if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).ishasCGiRetried())
      {
        if (this.LVE.checkPaySuccess())
        {
          ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).LWe);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.LVE.canPayRetry()) && (canRetry()))
        {
          ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.LVE.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.LVE))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else if (((com.tencent.mm.wallet_core.tenpay.model.n)paramn).checkRecSrvResp())
        {
          ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.LVE))
          {
            d(paramInt1, paramInt2, paramn);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.LVS;
          ae.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((com.tencent.mm.wallet_core.tenpay.model.n)paramn).LWe);
        }
      }
    }
    AppMethodBeat.o(72839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */