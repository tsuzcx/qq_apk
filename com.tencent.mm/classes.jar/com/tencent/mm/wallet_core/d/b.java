package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.k;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  implements f
{
  static ITenpaySave.RetryPayInfo qfp;
  private k wAY;
  private int wBa = 0;
  f wBb;
  
  public b(f paramf)
  {
    this.wBb = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.wAY != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
      this.wAY.a(paramInt2, paramString, paramJSONObject);
      this.wBb.onSceneEnd(paramInt1, paramInt2, paramString, this.wAY);
    }
    for (;;)
    {
      y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
      this.wBa = 0;
      return;
      if (this.wBb != null)
      {
        y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
        this.wBb.onSceneEnd(paramInt1, paramInt2, paramString, this.wAY);
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, com.tencent.mm.ah.m paramm)
  {
    a(paramInt1, paramInt2, qfp.wBn, ((k)paramm).wBB);
  }
  
  private boolean cMP()
  {
    int i = cMQ();
    return this.wBa < i;
  }
  
  private static int cMQ()
  {
    if ((qfp != null) && (qfp.cMW())) {
      return qfp.wBm;
    }
    return 0;
  }
  
  public final boolean d(k paramk)
  {
    if ((qfp != null) && (qfp.cMW())) {}
    int k;
    for (int i = qfp.wBl;; i = 0)
    {
      k = cMQ();
      this.wBa += 1;
      if (this.wBa <= k) {
        break;
      }
      return false;
    }
    this.wAY = paramk;
    this.wAY.nyn = true;
    g.DQ();
    g.DO().dJT.a(385, this);
    this.wAY.cNb();
    int m = this.wBa;
    if (this.wBa >= k) {}
    for (int j = 1;; j = 0)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("retry_count", String.valueOf(m));
      localHashMap.put("is_last_retry", String.valueOf(j));
      paramk.aB(localHashMap);
      y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      g.DQ();
      g.DO().dJT.a(paramk, i * 1000);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if ((paramm instanceof k))
    {
      if ((paramm instanceof ITenpaySave))
      {
        ITenpaySave.RetryPayInfo localRetryPayInfo = ((ITenpaySave)paramm).bTh();
        if (localRetryPayInfo.cMW()) {
          qfp = localRetryPayInfo;
        }
      }
      g.DQ();
      g.DO().dJT.b(385, this);
      if (((k)paramm).wBF)
      {
        if (!this.wAY.qno) {
          break label136;
        }
        y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
        a(paramInt1, paramInt2, paramString, ((k)paramm).wBB);
      }
    }
    label136:
    do
    {
      do
      {
        return;
        if ((!this.wAY.wBG) || (!cMP())) {
          break;
        }
        y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[] { Boolean.valueOf(this.wAY.wBG), Boolean.valueOf(cMP()) });
      } while (d(this.wAY));
      c(paramInt1, paramInt2, paramm);
      return;
      if (!((k)paramm).wAF) {
        break;
      }
      y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
    } while (d(this.wAY));
    c(paramInt1, paramInt2, paramm);
    return;
    paramString = qfp.wBn;
    y.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[] { paramString });
    a(paramInt1, paramInt2, paramString, ((k)paramm).wBB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.b
 * JD-Core Version:    0.7.0.1
 */