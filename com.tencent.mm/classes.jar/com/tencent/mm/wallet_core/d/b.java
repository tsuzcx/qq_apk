package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import org.json.JSONObject;

public final class b
  implements i
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private n Ruu;
  private int Ruw = 0;
  private i Rux;
  
  public b(i parami)
  {
    this.Rux = parami;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.Ruu != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.Ruu.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.Rux.onSceneEnd(paramInt1, paramInt2, paramString, this.Ruu);
    }
    for (;;)
    {
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.Ruw = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.Rux != null)
      {
        Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.Rux.onSceneEnd(paramInt1, paramInt2, paramString, this.Ruu);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = hhG();
    if (this.Ruw >= i)
    {
      AppMethodBeat.o(72834);
      return false;
    }
    AppMethodBeat.o(72834);
    return true;
  }
  
  private void d(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(72840);
    a(paramInt1, paramInt2, retryPayInfo.RuI, ((n)paramq).RuU);
    AppMethodBeat.o(72840);
  }
  
  private static int hhG()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.exv()))
    {
      int i = retryPayInfo.MSD;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.exv())) {}
    int k;
    for (int i = retryPayInfo.RuH;; i = 0)
    {
      k = hhG();
      this.Ruw += 1;
      if (this.Ruw <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.Ruu = paramn;
    this.Ruu.setHasRetried(true);
    g.aAi();
    g.aAg().hqi.a(385, this);
    this.Ruu.resetForRetry();
    int m = this.Ruw;
    if (this.Ruw >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      g.aAi();
      g.aAg().hqi.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.Rux = null;
    g.aAi();
    g.aAg().hqi.b(385, this);
    AppMethodBeat.o(72837);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72839);
    Log.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    if ((paramq instanceof n))
    {
      if ((paramq instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramq).getRetryPayInfo();
        if (localRetryPayInfo.exv()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      g.aAi();
      g.aAg().hqi.b(385, this);
      if (((n)paramq).ishasCGiRetried())
      {
        if (this.Ruu.checkPaySuccess())
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramq).RuU);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.Ruu.canPayRetry()) && (canRetry()))
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.Ruu.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.Ruu))
          {
            d(paramInt1, paramInt2, paramq);
            AppMethodBeat.o(72839);
          }
        }
        else if (((n)paramq).checkRecSrvResp())
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.Ruu))
          {
            d(paramInt1, paramInt2, paramq);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.RuI;
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((n)paramq).RuU);
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