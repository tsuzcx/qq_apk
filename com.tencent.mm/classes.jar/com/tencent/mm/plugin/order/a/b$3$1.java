package com.tencent.mm.plugin.order.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

final class b$3$1
  implements Runnable
{
  b$3$1(b.3 param3, String paramString, g.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(66637);
    Object localObject1 = b.gxy();
    Object localObject2 = this.qHj;
    Object localObject3 = this.oiK.mpN.Njs;
    j localj;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localj = com.tencent.mm.plugin.order.model.c.aRc((String)localObject2);
      if (localj == null)
      {
        Log.i("MicroMsg.MallPayMsgManager", "payMsg == null");
        AppMethodBeat.o(66637);
        return;
      }
      if ((!TextUtils.isEmpty(localj.MFg)) || (!TextUtils.isEmpty(localj.MFx)) || (!TextUtils.isEmpty(localj.MFw)) || (!TextUtils.isEmpty(localj.hWn)) || (!TextUtils.isEmpty(localj.MFs)) || (!TextUtils.isEmpty(localj.MFt)) || (!TextUtils.isEmpty(localj.MFr)) || (!TextUtils.isEmpty(localj.MFv)) || (!TextUtils.isEmpty(localj.MFu)) || (!TextUtils.isEmpty(localj.MFq))) {
        if ((localj.MFq != null) && (com.tencent.mm.plugin.order.c.c.isNumeric(localj.MFq)))
        {
          int i = Util.getInt(localj.MFq, 0);
          if ((i != 2) && (i != 1)) {}
        }
        else
        {
          if (!TextUtils.isEmpty(localj.MFs)) {
            break label446;
          }
          localj.msgId = ((String)localObject3);
          Log.i("MicroMsg.MallPayMsgManager", "msgid: " + localj.msgId);
          Log.i("MicroMsg.MallPayMsgManager", "msgType: " + localj.MFq);
          if (((com.tencent.mm.plugin.order.model.c)localObject1).aRe(localj.msgId)) {
            break label475;
          }
          ((com.tencent.mm.plugin.order.model.c)localObject1).wsq.add(localj);
          ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, "0");
          label302:
          ((com.tencent.mm.plugin.order.model.c)localObject1).gxB();
          localObject1 = b.gxv();
          if (localj != null)
          {
            localObject2 = new eco();
            if ((TextUtils.isEmpty(localj.MFs)) || (!com.tencent.mm.plugin.order.c.c.isNumeric(localj.MFs))) {
              break label549;
            }
            ((eco)localObject2).CreateTime = Util.getInt(localj.MFs, 0);
          }
        }
      }
    }
    for (((eco)localObject2).MFb = Util.getInt(localj.MFs, 0);; ((eco)localObject2).MFb = ((int)(System.currentTimeMillis() / 1000L)))
    {
      ((eco)localObject2).MFe = 100000;
      ((eco)localObject2).MFg = localj.MFg;
      ((eco)localObject2).MEX = localj.msgId;
      ((eco)localObject2).MFa = localj.MFu;
      ((eco)localObject2).abic = -1;
      ((eco)localObject2).MFh = localj.MFr;
      ((eco)localObject2).MFi = localj.MFu;
      ((eco)localObject2).MFj = localj.hWn;
      ((b)localObject1).gxw();
      AppMethodBeat.o(66637);
      return;
      label446:
      localj.msgId = ((String)localObject3 + localj.MFs);
      break;
      label475:
      Log.e("MicroMsg.MallPayMsgManager", "msg for id " + localj.msgId + " is exist!!");
      localObject3 = ((com.tencent.mm.plugin.order.model.c)localObject1).aRg(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).aRd(localj.msgId);
      ((com.tencent.mm.plugin.order.model.c)localObject1).wsq.add(localj);
      ((com.tencent.mm.plugin.order.model.c)localObject1).a(localj, (String)localObject2, ((a)localObject3).field_isRead);
      break label302;
      label549:
      ((eco)localObject2).CreateTime = ((int)(System.currentTimeMillis() / 1000L));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b.3.1
 * JD-Core Version:    0.7.0.1
 */