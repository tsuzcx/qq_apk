package com.tencent.mm.plugin.sns.ad.timeline.a;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static Map<String, Long> zrM;
  
  static
  {
    AppMethodBeat.i(219127);
    zrM = new ConcurrentHashMap();
    AppMethodBeat.o(219127);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(219126);
    if ((parama == null) || (bu.isNullOrNil(paramString)))
    {
      ae.e("DynamicDataReqHelper", "adInfo or snsId is null, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219126);
      return;
    }
    if (parama.zMg != 1)
    {
      ae.i("DynamicDataReqHelper", "adChainType is not 1, snsId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(219126);
      return;
    }
    int i;
    long l2;
    Long localLong;
    if (parama.zMh == 0)
    {
      i = 60000;
      l2 = System.currentTimeMillis();
      localLong = (Long)zrM.get(paramString);
      if (localLong != null) {
        break label128;
      }
    }
    label128:
    for (long l1 = 0L;; l1 = localLong.longValue())
    {
      if (l2 - l1 >= i) {
        break label137;
      }
      AppMethodBeat.o(219126);
      return;
      i = parama.zMh * 1000;
      break;
    }
    label137:
    parama = new com.tencent.mm.plugin.sns.ad.e.h("", parama.zMk, paramString, parama.dGD);
    com.tencent.mm.kernel.g.ajj().a(4342, new a(paramString, (byte)0));
    com.tencent.mm.kernel.g.ajQ().gDv.a(parama, 0);
    zrM.put(paramString, Long.valueOf(l2));
    AppMethodBeat.o(219126);
  }
  
  public static boolean a(a parama, String paramString)
  {
    AppMethodBeat.i(219125);
    if (((parama.zMa == a.zLN) && (!bu.isNullOrNil(parama.zMb)) && (parama.zMd.size() > 0)) || ((parama.zMa == a.zLM) && (!bu.isNullOrNil(parama.zMb))))
    {
      ae.i("DynamicDataReqHelper", "use init adChainData");
      zrM.put(paramString, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(219125);
      return true;
    }
    AppMethodBeat.o(219125);
    return false;
  }
  
  static final class a
    implements f
  {
    private int actionType = 1;
    private String dAg;
    a zrN;
    
    private a(String paramString)
    {
      this.dAg = paramString;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(219124);
      if ((paramn instanceof com.tencent.mm.plugin.sns.ad.e.h)) {
        try
        {
          Object localObject = (bjh)((com.tencent.mm.ak.b)paramn.getReqResp()).hQE.hQJ;
          StringBuilder localStringBuilder = new StringBuilder("errType = ").append(paramInt1).append(", errCode = ").append(paramInt2).append(", snsId = ").append(this.dAg).append(", rsp.sns_ad_id = ");
          if (localObject == null) {}
          for (paramString = "";; paramString = ((bjh)localObject).GWR)
          {
            ae.i("DynamicDataReqHelper", paramString);
            if ((paramInt1 == 0) && (paramInt2 == 0) && (localObject != null))
            {
              paramInt1 = ((bjh)localObject).oGc;
              paramString = ((bjh)localObject).GWR;
              localObject = ((bjh)localObject).GWS;
              if ((this.actionType == 1) && (this.actionType == paramInt1)) {
                if ((!bu.V(new String[] { this.dAg, localObject })) && (this.dAg.equals(paramString)))
                {
                  paramString = this.dAg;
                  com.tencent.e.h.MqF.aO(new c.a.2(this, paramString, (String)localObject));
                }
              }
            }
            com.tencent.mm.kernel.g.ajj().b(paramn.getType(), this);
            AppMethodBeat.o(219124);
            return;
          }
          AppMethodBeat.o(219124);
        }
        catch (Throwable paramString)
        {
          ae.e("DynamicDataReqHelper", "NetSceneDynamicAdDataUpdate onSceneEnd exp=" + paramString.toString() + ", snsId = " + this.dAg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.c
 * JD-Core Version:    0.7.0.1
 */