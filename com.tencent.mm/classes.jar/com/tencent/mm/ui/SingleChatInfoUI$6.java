package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;

final class SingleChatInfoUI$6
  implements p.b
{
  SingleChatInfoUI$6(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void dK(List<aqi> paramList)
  {
    AppMethodBeat.i(187038);
    ae.i("MicroMsg.SingleChatInfoUI", "sessionInfos size :" + paramList.size());
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramList = (aqi)((Iterator)localObject).next();
      } while (!paramList.sessionId.equals(SingleChatInfoUI.a(this.JAw)));
    }
    for (;;)
    {
      if (paramList != null)
      {
        ae.i("MicroMsg.SingleChatInfoUI", "sessionId: " + paramList.sessionId + ", sessionReject: " + paramList.GHf);
        localObject = this.JAw;
        if (paramList.GHf != 1) {
          break label161;
        }
      }
      label161:
      for (boolean bool = true;; bool = false)
      {
        SingleChatInfoUI.a((SingleChatInfoUI)localObject, bool);
        SingleChatInfoUI.b(this.JAw);
        AppMethodBeat.o(187038);
        return;
      }
      paramList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.6
 * JD-Core Version:    0.7.0.1
 */