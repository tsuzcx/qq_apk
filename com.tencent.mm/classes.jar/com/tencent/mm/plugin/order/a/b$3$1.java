package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.de;
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
    Object localObject1 = b.eBd();
    Object localObject2 = this.kNw;
    Object localObject3 = this.iBE.heO.Brl;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.aJA((String)localObject2);
      if (localj == null)
      {
        Log.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.APc)) || (!TextUtils.isEmpty(localj.APt)) || (!TextUtils.isEmpty(localj.APs)) || (!TextUtils.isEmpty(localj.dWG)) || (!TextUtils.isEmpty(localj.APo)) || (!TextUtils.isEmpty(localj.APp)) || (!TextUtils.isEmpty(localj.APn)) || (!TextUtils.isEmpty(localj.APr)) || (!TextUtils.isEmpty(localj.APq)) || (!TextUtils.isEmpty(localj.APm))) {
        if ((localj.APm != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.APm)))
        {
          int i = Util.getInt(localj.APm, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.APo)) {
            break label446;
          }
          localj.msgId = ((String)localObject3);
          Log.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.msgId);
          Log.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.APm);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).aJC(localj.msgId)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).pRP.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).eBg();
          localObject1 = b.eBa();
          if (localj != null)
          {
            localObject2 = new daq();
            if ((TextUtils.isEmpty(localj.APo)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.APo))) {
              break label549;
            }
            ((daq)localObject2).CreateTime = Util.getInt(localj.APo, 0);
          }
        }
      }
    }
    for (((daq)localObject2).AOX = Util.getInt(localj.APo, 0);; ((daq)localObject2).AOX = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((daq)localObject2).APa = 100000;
      ((daq)localObject2).APc = localj.APc;
      ((daq)localObject2).AOT = localj.msgId;
      ((daq)localObject2).AOW = localj.APq;
      ((daq)localObject2).MFR = -1;
      ((daq)localObject2).APd = localj.APn;
      ((daq)localObject2).APe = localj.APq;
      ((daq)localObject2).APf = localj.dWG;
      ((b)localObject1).eBb();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.msgId = ((String)localObject3 + localj.APo);
      break;
      label475:
      Log.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.msgId + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).aJE(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).aJB(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).pRP.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((daq)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */