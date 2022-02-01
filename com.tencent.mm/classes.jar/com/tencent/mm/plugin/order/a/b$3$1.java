package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString, e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(66637);
    Object localObject1 = b.dBr();
    Object localObject2 = this.jLx;
    Object localObject3 = this.hHu.gte.xri;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.avn((String)localObject2);
      if (localj == null)
      {
        ae.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.wTi)) || (!TextUtils.isEmpty(localj.wTz)) || (!TextUtils.isEmpty(localj.wTy)) || (!TextUtils.isEmpty(localj.dEU)) || (!TextUtils.isEmpty(localj.wTu)) || (!TextUtils.isEmpty(localj.wTv)) || (!TextUtils.isEmpty(localj.wTt)) || (!TextUtils.isEmpty(localj.wTx)) || (!TextUtils.isEmpty(localj.wTw)) || (!TextUtils.isEmpty(localj.wTs))) {
        if ((localj.wTs != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.wTs)))
        {
          int i = bu.getInt(localj.wTs, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.wTu)) {
            break label446;
          }
          localj.msgId = ((String)localObject3);
          ae.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.msgId);
          ae.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.wTs);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).avp(localj.msgId)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).oEg.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).dBv();
          localObject1 = b.dBo();
          if (localj != null)
          {
            localObject2 = new cki();
            if ((TextUtils.isEmpty(localj.wTu)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.wTu))) {
              break label549;
            }
            ((cki)localObject2).CreateTime = bu.getInt(localj.wTu, 0);
          }
        }
      }
    }
    for (((cki)localObject2).wTd = bu.getInt(localj.wTu, 0);; ((cki)localObject2).wTd = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((cki)localObject2).wTg = 100000;
      ((cki)localObject2).wTi = localj.wTi;
      ((cki)localObject2).wSZ = localj.msgId;
      ((cki)localObject2).wTc = localj.wTw;
      ((cki)localObject2).HwR = -1;
      ((cki)localObject2).wTj = localj.wTt;
      ((cki)localObject2).wTk = localj.wTw;
      ((cki)localObject2).wTl = localj.dEU;
      ((b)localObject1).dBp();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.msgId = ((String)localObject3 + localj.wTu);
      break;
      label475:
      ae.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.msgId + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).avr(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).avo(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).oEg.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((cki)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */