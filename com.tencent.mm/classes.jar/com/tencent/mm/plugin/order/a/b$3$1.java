package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString, f.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(66637);
    Object localObject1 = b.dab();
    Object localObject2 = this.iOr;
    Object localObject3 = this.gLP.fTo.uKX;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.aka((String)localObject2);
      if (localj == null)
      {
        ad.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.uph)) || (!TextUtils.isEmpty(localj.upy)) || (!TextUtils.isEmpty(localj.upx)) || (!TextUtils.isEmpty(localj.duk)) || (!TextUtils.isEmpty(localj.upt)) || (!TextUtils.isEmpty(localj.upu)) || (!TextUtils.isEmpty(localj.ups)) || (!TextUtils.isEmpty(localj.upw)) || (!TextUtils.isEmpty(localj.upv)) || (!TextUtils.isEmpty(localj.upr))) {
        if ((localj.upr != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.upr)))
        {
          int i = bt.getInt(localj.upr, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.upt)) {
            break label446;
          }
          localj.dvT = ((String)localObject3);
          ad.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.dvT);
          ad.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.upr);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).akc(localj.dvT)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).nrj.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).daf();
          localObject1 = b.cZY();
          if (localj != null)
          {
            localObject2 = new bzr();
            if ((TextUtils.isEmpty(localj.upt)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.upt))) {
              break label549;
            }
            ((bzr)localObject2).CreateTime = bt.getInt(localj.upt, 0);
          }
        }
      }
    }
    for (((bzr)localObject2).upc = bt.getInt(localj.upt, 0);; ((bzr)localObject2).upc = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((bzr)localObject2).upf = 100000;
      ((bzr)localObject2).uph = localj.uph;
      ((bzr)localObject2).uoY = localj.dvT;
      ((bzr)localObject2).upb = localj.upv;
      ((bzr)localObject2).DWt = -1;
      ((bzr)localObject2).upi = localj.ups;
      ((bzr)localObject2).upj = localj.upv;
      ((bzr)localObject2).upk = localj.duk;
      ((b)localObject1).cZZ();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.dvT = ((String)localObject3 + localj.upt);
      break;
      label475:
      ad.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.dvT + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).ake(localj.dvT);
      ((com.tencent.mm.plugin.order.model.c)localObject1).akb(localj.dvT);
      ((com.tencent.mm.plugin.order.model.c)localObject1).nrj.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((bzr)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */