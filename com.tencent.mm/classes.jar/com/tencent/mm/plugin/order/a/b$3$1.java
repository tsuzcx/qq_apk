package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString, e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(66637);
    Object localObject1 = b.dyb();
    Object localObject2 = this.jIw;
    Object localObject3 = this.hEC.gqE.xbr;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.atY((String)localObject2);
      if (localj == null)
      {
        ad.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.wDx)) || (!TextUtils.isEmpty(localj.wDO)) || (!TextUtils.isEmpty(localj.wDN)) || (!TextUtils.isEmpty(localj.dDP)) || (!TextUtils.isEmpty(localj.wDJ)) || (!TextUtils.isEmpty(localj.wDK)) || (!TextUtils.isEmpty(localj.wDI)) || (!TextUtils.isEmpty(localj.wDM)) || (!TextUtils.isEmpty(localj.wDL)) || (!TextUtils.isEmpty(localj.wDH))) {
        if ((localj.wDH != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.wDH)))
        {
          int i = bt.getInt(localj.wDH, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.wDJ)) {
            break label446;
          }
          localj.msgId = ((String)localObject3);
          ad.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.msgId);
          ad.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.wDH);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).aua(localj.msgId)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).oxE.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).dyf();
          localObject1 = b.dxY();
          if (localj != null)
          {
            localObject2 = new cjo();
            if ((TextUtils.isEmpty(localj.wDJ)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.wDJ))) {
              break label549;
            }
            ((cjo)localObject2).CreateTime = bt.getInt(localj.wDJ, 0);
          }
        }
      }
    }
    for (((cjo)localObject2).wDs = bt.getInt(localj.wDJ, 0);; ((cjo)localObject2).wDs = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((cjo)localObject2).wDv = 100000;
      ((cjo)localObject2).wDx = localj.wDx;
      ((cjo)localObject2).wDo = localj.msgId;
      ((cjo)localObject2).wDr = localj.wDL;
      ((cjo)localObject2).Hdr = -1;
      ((cjo)localObject2).wDy = localj.wDI;
      ((cjo)localObject2).wDz = localj.wDL;
      ((cjo)localObject2).wDA = localj.dDP;
      ((b)localObject1).dxZ();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.msgId = ((String)localObject3 + localj.wDJ);
      break;
      label475:
      ad.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.msgId + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).auc(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).atZ(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).oxE.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((cjo)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */