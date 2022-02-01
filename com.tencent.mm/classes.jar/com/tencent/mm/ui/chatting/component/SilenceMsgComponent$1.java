package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xs;
import com.tencent.mm.autogen.a.xs.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.d.a;

class SilenceMsgComponent$1
  extends IListener<xs>
{
  private boolean a(xs paramxs)
  {
    AppMethodBeat.i(256310);
    Object localObject = paramxs.ibg.data;
    if (localObject != null) {
      paramxs = new dm();
    }
    for (;;)
    {
      try
      {
        paramxs.parseFrom((byte[])localObject);
        localObject = w.a(paramxs.YFM);
        Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr SilenceNotifyEvent callback chatRoomId[%s], current talker[%s]", new Object[] { localObject, this.aexd.hlc.Uxa.field_username });
        if ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).equals(this.aexd.hlc.Uxa.field_username)))
        {
          final int i = paramxs.YFL;
          final int j = paramxs.YFN;
          bh.baH().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255802);
              Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr SilenceNotifyEvent in chatting lastSeq[%d], undeliverCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
              long l5 = i;
              long l2 = i;
              long l1 = j;
              long l4 = ((n)h.ax(n.class)).gaZ().aMa(this.aexg);
              if ((l4 > 0L) && (l4 < l2))
              {
                l1 = -1L;
                l2 = l4;
              }
              for (;;)
              {
                long l3 = l1;
                if (l1 <= 0L) {
                  l3 = 1L;
                }
                Log.i("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr SilenceNotifyEvent in chatting down [%d, %d, %d, %d]", new Object[] { Long.valueOf(l5), Long.valueOf(l2), Long.valueOf(l4), Long.valueOf(l3) });
                AppMethodBeat.o(255802);
                throw null;
              }
            }
          });
        }
        AppMethodBeat.o(256310);
        return false;
      }
      catch (Exception paramxs)
      {
        Log.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgComponent", paramxs, "summerbadcr SilenceNotifyEvent callback parse:", new Object[0]);
        AppMethodBeat.o(256310);
        return false;
      }
      Log.e("MicroMsg.ChattingUI.SilenceMsgComponent", "summerbadcr silenceNotifyListener callback event data is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.SilenceMsgComponent.1
 * JD-Core Version:    0.7.0.1
 */