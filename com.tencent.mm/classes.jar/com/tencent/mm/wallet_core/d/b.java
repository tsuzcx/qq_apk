package com.tencent.mm.wallet_core.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import org.json.JSONObject;

public final class b
  implements i
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private n YVS;
  private int YVU = 0;
  private i YVV;
  
  public b(i parami)
  {
    this.YVV = parami;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.YVS != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.YVS.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.YVV.onSceneEnd(paramInt1, paramInt2, paramString, this.YVS);
    }
    for (;;)
    {
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.YVU = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.YVV != null)
      {
        Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.YVV.onSceneEnd(paramInt1, paramInt2, paramString, this.YVS);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = ijh();
    if (this.YVU >= i)
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
    a(paramInt1, paramInt2, retryPayInfo.YWg, ((n)paramq).YWs);
    AppMethodBeat.o(72840);
  }
  
  private static int ijh()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.fiY()))
    {
      int i = retryPayInfo.UeK;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.fiY())) {}
    int k;
    for (int i = retryPayInfo.YWf;; i = 0)
    {
      k = ijh();
      this.YVU += 1;
      if (this.YVU <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.YVS = paramn;
    this.YVS.setHasRetried(true);
    h.aHH();
    h.aHF().kcd.a(385, this);
    this.YVS.resetForRetry();
    int m = this.YVU;
    if (this.YVU >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      h.aHH();
      h.aHF().kcd.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.YVV = null;
    h.aHH();
    h.aHF().kcd.b(385, this);
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
        if (localRetryPayInfo.fiY()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      h.aHH();
      h.aHF().kcd.b(385, this);
      if (((n)paramq).ishasCGiRetried())
      {
        if (this.YVS.checkPaySuccess())
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramq).YWs);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.YVS.canPayRetry()) && (canRetry()))
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.YVS.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.YVS))
          {
            d(paramInt1, paramInt2, paramq);
            AppMethodBeat.o(72839);
          }
        }
        else if (((n)paramq).checkRecSrvResp())
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.YVS))
          {
            d(paramInt1, paramInt2, paramq);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.YWg;
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((n)paramq).YWs);
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