package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.p.b;
import com.tencent.mm.protocal.protobuf.apv;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;

final class SingleChatInfoUI$6
  implements p.b
{
  SingleChatInfoUI$6(SingleChatInfoUI paramSingleChatInfoUI) {}
  
  public final void dH(List<apv> paramList)
  {
    AppMethodBeat.i(193747);
    ad.i("MicroMsg.SingleChatInfoUI", "sessionInfos size :" + paramList.size());
    Object localObject;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramList = (apv)((Iterator)localObject).next();
      } while (!paramList.sessionId.equals(SingleChatInfoUI.a(this.JfL)));
    }
    for (;;)
    {
      if (paramList != null)
      {
        ad.i("MicroMsg.SingleChatInfoUI", "sessionId: " + paramList.sessionId + ", sessionReject: " + paramList.GnZ);
        localObject = this.JfL;
        if (paramList.GnZ != 1) {
          break label161;
        }
      }
      label161:
      for (boolean bool = true;; bool = false)
      {
        SingleChatInfoUI.a((SingleChatInfoUI)localObject, bool);
        SingleChatInfoUI.b(this.JfL);
        AppMethodBeat.o(193747);
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