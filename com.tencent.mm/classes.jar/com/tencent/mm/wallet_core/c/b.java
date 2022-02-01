package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.n;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.am.h
{
  static ITenpaySave.RetryPayInfo retryPayInfo;
  private n agTM;
  private int agTO = 0;
  private com.tencent.mm.am.h agTP;
  
  public b(com.tencent.mm.am.h paramh)
  {
    this.agTP = paramh;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72838);
    Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.agTM != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.agTM.onGYNetEnd(paramInt2, paramString, paramJSONObject);
      this.agTP.onSceneEnd(paramInt1, paramInt2, paramString, this.agTM);
    }
    for (;;)
    {
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.agTO = 0;
      AppMethodBeat.o(72838);
      return;
      if (this.agTP != null)
      {
        Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.agTP.onSceneEnd(paramInt1, paramInt2, paramString, this.agTM);
      }
    }
  }
  
  private boolean canRetry()
  {
    AppMethodBeat.i(72834);
    int i = jPc();
    if (this.agTO >= i)
    {
      AppMethodBeat.o(72834);
      return false;
    }
    AppMethodBeat.o(72834);
    return true;
  }
  
  private void f(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(72840);
    a(paramInt1, paramInt2, retryPayInfo.agUa, ((n)paramp).agUm);
    AppMethodBeat.o(72840);
  }
  
  private static int jPc()
  {
    AppMethodBeat.i(72835);
    if ((retryPayInfo != null) && (retryPayInfo.gtp()))
    {
      int i = retryPayInfo.abvX;
      AppMethodBeat.o(72835);
      return i;
    }
    AppMethodBeat.o(72835);
    return 0;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(72836);
    if ((retryPayInfo != null) && (retryPayInfo.gtp())) {}
    int k;
    for (int i = retryPayInfo.agTZ;; i = 0)
    {
      k = jPc();
      this.agTO += 1;
      if (this.agTO <= k) {
        break;
      }
      AppMethodBeat.o(72836);
      return false;
    }
    this.agTM = paramn;
    this.agTM.setHasRetried(true);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(385, this);
    this.agTM.resetForRetry();
    int m = this.agTO;
    if (this.agTO >= k) {}
    for (int j = 1;; j = 0)
    {
      paramn.updateConfig(m, j);
      Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramn, i * 1000);
      AppMethodBeat.o(72836);
      return true;
    }
  }
  
  public final void destory()
  {
    AppMethodBeat.i(72837);
    this.agTP = null;
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(385, this);
    AppMethodBeat.o(72837);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72839);
    Log.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    if ((paramp instanceof n))
    {
      if ((paramp instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramp).getRetryPayInfo();
        if (localRetryPayInfo.gtp()) {
          retryPayInfo = localRetryPayInfo;
        }
      }
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.b(385, this);
      if (((n)paramp).ishasCGiRetried())
      {
        if (this.agTM.checkPaySuccess())
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
          a(paramInt1, paramInt2, paramString, ((n)paramp).agUm);
          AppMethodBeat.o(72839);
          return;
        }
        if ((this.agTM.canPayRetry()) && (canRetry()))
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.agTM.canPayRetry()), Boolean.valueOf(canRetry()) });
          if (!c(this.agTM))
          {
            f(paramInt1, paramInt2, paramp);
            AppMethodBeat.o(72839);
          }
        }
        else if (((n)paramp).checkRecSrvResp())
        {
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
          if (!c(this.agTM))
          {
            f(paramInt1, paramInt2, paramp);
            AppMethodBeat.o(72839);
          }
        }
        else
        {
          paramString = retryPayInfo.agUa;
          Log.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
          a(paramInt1, paramInt2, paramString, ((n)paramp).agUm);
        }
      }
    }
    AppMethodBeat.o(72839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.b
 * JD-Core Version:    0.7.0.1
 */