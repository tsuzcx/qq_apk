package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ab.b;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

final class SingleChatInfoUI$7
  implements ab.b
{
  SingleChatInfoUI$7(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void eK(List<bff> paramList)
  {
    AppMethodBeat.i(281772);
    Log.i("MicroMsg.SingleChatInfoUI", "sessionInfos size :" + paramList.size());
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramList = (bff)((Iterator)localObject).next();
      } while (!paramList.sessionId.equals(SingleChatInfoUI.a(this.WeA)));
    }
    for (;;)
    {
      if (paramList != null)
      {
        Log.i("MicroMsg.SingleChatInfoUI", "sessionId: " + paramList.sessionId + ", sessionReject: " + paramList.SPR);
        localObject = this.WeA;
        if (paramList.SPR != 1) {
          break label161;
        }
      }
      label161:
      for (boolean bool = true;; bool = false)
      {
        SingleChatInfoUI.a((SingleChatInfoUI)localObject, bool);
        SingleChatInfoUI.b(this.WeA);
        AppMethodBeat.o(281772);
        return;
      }
      paramList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.SingleChatInfoUI.7
 * JD-Core Version:    0.7.0.1
 */