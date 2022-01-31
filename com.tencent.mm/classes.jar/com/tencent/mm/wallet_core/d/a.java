package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.e;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.tenpay.model.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ah.f
{
  private k wAY;
  private com.tencent.mm.wallet_core.tenpay.model.f wAZ;
  private int wBa = 0;
  com.tencent.mm.ah.f wBb;
  
  public a(com.tencent.mm.ah.f paramf)
  {
    this.wBb = paramf;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, JSONObject paramJSONObject)
  {
    y.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + paramInt2 + "errType = " + paramInt1);
    if ((this.wAY != null) && (paramJSONObject != null) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
      this.wAY.a(paramInt2, paramString, paramJSONObject);
      this.wBb.onSceneEnd(paramInt1, paramInt2, paramString, this.wAY);
    }
    for (;;)
    {
      y.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
      this.wBa = 0;
      return;
      if (this.wBb != null)
      {
        y.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
        this.wBb.onSceneEnd(paramInt1, paramInt2, paramString, this.wAY);
      }
    }
  }
  
  private void c(k paramk)
  {
    this.wAY = paramk;
    this.wAY.nyn = true;
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(385, this);
    paramk = com.tencent.mm.plugin.wallet_core.model.o.bVs();
    int i;
    Object localObject;
    label101:
    int k;
    label138:
    int m;
    StringBuilder localStringBuilder;
    if (paramk.qzo > 0)
    {
      i = paramk.qzo;
      this.wBa += 1;
      paramk = this.wAY.cMZ();
      localObject = (String)paramk.get("req_key");
      if (!bk.bl((String)localObject)) {
        break label257;
      }
      y.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
      paramk = new com.tencent.mm.wallet_core.tenpay.model.f(paramk);
      this.wAZ = paramk;
      this.wAZ.wBr = true;
      k = com.tencent.mm.plugin.wallet_core.model.o.bVs().mRetryCount;
      paramk = this.wAZ;
      if (this.wBa < k) {
        break label446;
      }
      j = 1;
      m = this.wBa;
      localObject = new HashMap();
      localStringBuilder = new StringBuilder();
      if (j == 0) {
        break label451;
      }
    }
    label257:
    label446:
    label451:
    for (int j = 1;; j = 0)
    {
      ((HashMap)localObject).put("is_last_query", j);
      ((HashMap)localObject).put("curr_query_count", String.valueOf(m));
      paramk.aB((Map)localObject);
      y.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.a(this.wAZ, i);
      return;
      i = 10000;
      break;
      y.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[] { localObject });
      y.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
      if (((String)localObject).startsWith("sns_aa_"))
      {
        paramk = new com.tencent.mm.wallet_core.tenpay.model.b(paramk);
        break label101;
      }
      if (((String)localObject).startsWith("sns_tf_"))
      {
        paramk = new h(paramk);
        break label101;
      }
      if (((String)localObject).startsWith("sns_ff_"))
      {
        paramk = new c(paramk);
        break label101;
      }
      if (((String)localObject).startsWith("ts_"))
      {
        paramk = new d(paramk);
        break label101;
      }
      if (((String)localObject).startsWith("sns_"))
      {
        paramk = new com.tencent.mm.wallet_core.tenpay.model.g(paramk);
        break label101;
      }
      if (((String)localObject).startsWith("offline_"))
      {
        paramk = new e(paramk);
        break label101;
      }
      if (((String)localObject).startsWith("up_"))
      {
        paramk = new i(paramk);
        break label101;
      }
      paramk = new com.tencent.mm.wallet_core.tenpay.model.f(paramk);
      break label101;
      j = 0;
      break label138;
    }
  }
  
  public final boolean a(k paramk)
  {
    int i = com.tencent.mm.plugin.wallet_core.model.o.bVs().mRetryCount;
    y.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[] { Boolean.valueOf(paramk.cNa()), Integer.valueOf(this.wBa) });
    return (paramk.cNa()) && (this.wBa < i);
  }
  
  public final void b(k paramk)
  {
    y.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
    this.wBa = 0;
    c(paramk);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm });
    if (((paramm instanceof com.tencent.mm.wallet_core.tenpay.model.f)) && (this.wAZ.equals(paramm)))
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(385, this);
      paramm = (com.tencent.mm.wallet_core.tenpay.model.f)paramm;
      y.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramm, Integer.valueOf(paramm.wBq) });
      if (paramm.wBq == 1)
      {
        y.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
        a(paramInt1, paramInt2, paramString, paramm.cMX());
      }
    }
    label260:
    do
    {
      do
      {
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          y.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
          if (paramm.wBq != 2) {
            a(paramInt1, paramInt2, paramString, paramm.cMX());
          }
        }
        else
        {
          if (paramm.wAF) {
            break label260;
          }
          y.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
          y.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { com.tencent.mm.plugin.wallet_core.model.o.bVs().qzp });
        }
        do
        {
          a(this.wAY.wBy, this.wAY.wBz, this.wAY.wBA, this.wAY.wBB);
          return;
          if (a(this.wAY))
          {
            y.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
            c(this.wAY);
            return;
          }
          y.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail");
        } while (paramm.wBq != 1);
        a(paramInt1, paramInt2, paramString, paramm.cMX());
        return;
      } while ((!(paramm instanceof k)) || (!this.wAY.equals(paramm)));
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DO().dJT.b(385, this);
    } while (!((k)paramm).wBF);
    if (this.wAY.qno)
    {
      y.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
      a(paramInt1, paramInt2, paramString, ((k)paramm).wBB);
      return;
    }
    if (this.wAY.cNa())
    {
      y.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
      c(this.wAY);
      return;
    }
    paramString = com.tencent.mm.plugin.wallet_core.model.o.bVs().qzp;
    y.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[] { paramString });
    a(paramInt1, paramInt2, paramString, ((k)paramm).wBB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.a
 * JD-Core Version:    0.7.0.1
 */