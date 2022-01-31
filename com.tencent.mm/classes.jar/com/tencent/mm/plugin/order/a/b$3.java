package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class b$3
  implements bx.a
{
  b$3(b paramb) {}
  
  public final void a(final e.a parama)
  {
    final String str = aa.a(parama.dBs.svH);
    y.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:" + str);
    b.a(this.mOt).post(new Runnable()
    {
      public final void run()
      {
        Object localObject1 = b.bry();
        Object localObject2 = str;
        Object localObject3 = parama.dBs.ndm;
        j localj;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localj = com.tencent.mm.plugin.order.model.c.KF((String)localObject2);
          if (localj != null) {
            break label61;
          }
          y.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        }
        label61:
        int i;
        do
        {
          do
          {
            return;
          } while ((TextUtils.isEmpty(localj.mPS)) && (TextUtils.isEmpty(localj.mQj)) && (TextUtils.isEmpty(localj.mQi)) && (TextUtils.isEmpty(localj.bVV)) && (TextUtils.isEmpty(localj.mQe)) && (TextUtils.isEmpty(localj.mQf)) && (TextUtils.isEmpty(localj.mQd)) && (TextUtils.isEmpty(localj.mQh)) && (TextUtils.isEmpty(localj.mQg)) && (TextUtils.isEmpty(localj.mQc)));
          if ((localj.mQc == null) || (!com.tencent.mm.plugin.order.c.c.yS(localj.mQc))) {
            break;
          }
          i = Integer.valueOf(localj.mQc).intValue();
        } while ((i != 2) && (i != 1));
        if (TextUtils.isEmpty(localj.mQe))
        {
          localj.bVP = ((String)localObject3);
          y.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.bVP);
          y.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.mQc);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).KH(localj.bVP)) {
            break label466;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).ilf.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label294:
          ((com.tencent.mm.plugin.order.model.c)localObject1).brC();
          localObject1 = b.brv();
          if (localj != null)
          {
            localObject2 = new bdv();
            if ((TextUtils.isEmpty(localj.mQe)) || (!com.tencent.mm.plugin.order.c.c.yS(localj.mQe))) {
              break label540;
            }
            ((bdv)localObject2).mPL = Integer.valueOf(localj.mQe).intValue();
          }
        }
        for (((bdv)localObject2).mPN = Integer.valueOf(localj.mQe).intValue();; ((bdv)localObject2).mPN = ((int)(System.currentTimeMillis() / 1000L)))
        {
          ((bdv)localObject2).mPQ = 100000;
          ((bdv)localObject2).mPS = localj.mPS;
          ((bdv)localObject2).mPI = localj.bVP;
          ((bdv)localObject2).mPM = localj.mQg;
          ((bdv)localObject2).tze = -1;
          ((bdv)localObject2).mPT = localj.mQd;
          ((bdv)localObject2).mPU = localj.mQg;
          ((bdv)localObject2).mPV = localj.bVV;
          ((b)localObject1).brw();
          return;
          localj.bVP = ((String)localObject3 + localj.mQe);
          break;
          label466:
          y.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.bVP + " is exist!!");
          localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).KJ(localj.bVP);
          ((com.tencent.mm.plugin.order.model.c)localObject1).KG(localj.bVP);
          ((com.tencent.mm.plugin.order.model.c)localObject1).ilf.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
          break label294;
          label540:
          ((bdv)localObject2).mPL = ((int)(System.currentTimeMillis() / 1000L));
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3
 * JD-Core Version:    0.7.0.1
 */