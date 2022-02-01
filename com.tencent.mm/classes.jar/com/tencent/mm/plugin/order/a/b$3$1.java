package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString, h.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(66637);
    Object localObject1 = b.fmK();
    Object localObject2 = this.nHw;
    Object localObject3 = this.lrj.jQG.HlE;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.aTW((String)localObject2);
      if (localj == null)
      {
        Log.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.GIq)) || (!TextUtils.isEmpty(localj.GIH)) || (!TextUtils.isEmpty(localj.GIG)) || (!TextUtils.isEmpty(localj.fQs)) || (!TextUtils.isEmpty(localj.GIC)) || (!TextUtils.isEmpty(localj.GID)) || (!TextUtils.isEmpty(localj.GIB)) || (!TextUtils.isEmpty(localj.GIF)) || (!TextUtils.isEmpty(localj.GIE)) || (!TextUtils.isEmpty(localj.GIA))) {
        if ((localj.GIA != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.GIA)))
        {
          int i = Util.getInt(localj.GIA, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.GIC)) {
            break label446;
          }
          localj.msgId = ((String)localObject3);
          Log.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.msgId);
          Log.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.GIA);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).aTY(localj.msgId)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).tnP.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).fmN();
          localObject1 = b.fmH();
          if (localj != null)
          {
            localObject2 = new dke();
            if ((TextUtils.isEmpty(localj.GIC)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.GIC))) {
              break label549;
            }
            ((dke)localObject2).CreateTime = Util.getInt(localj.GIC, 0);
          }
        }
      }
    }
    for (((dke)localObject2).GIl = Util.getInt(localj.GIC, 0);; ((dke)localObject2).GIl = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((dke)localObject2).GIo = 100000;
      ((dke)localObject2).GIq = localj.GIq;
      ((dke)localObject2).GIh = localj.msgId;
      ((dke)localObject2).GIk = localj.GIE;
      ((dke)localObject2).TRD = -1;
      ((dke)localObject2).GIr = localj.GIB;
      ((dke)localObject2).GIs = localj.GIE;
      ((dke)localObject2).GIt = localj.fQs;
      ((b)localObject1).fmI();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.msgId = ((String)localObject3 + localj.GIC);
      break;
      label475:
      Log.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.msgId + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).aUa(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).aTX(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).tnP.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((dke)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */