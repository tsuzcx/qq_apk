package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.i;
import com.tencent.mm.al.i.b;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.e.a;
import java.util.LinkedList;

final class c$b
  implements i.b
{
  private String ISe;
  a dom;
  
  protected c$b(a parama, String paramString)
  {
    this.ISe = paramString;
    this.dom = parama;
  }
  
  public final String aZT()
  {
    return this.ISe;
  }
  
  public final void e(LinkedList<fbw> paramLinkedList)
  {
    int k = 0;
    AppMethodBeat.i(36736);
    ag.bai().b(this);
    Log.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
    int i;
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Log.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.ISe });
      if (this.dom != null)
      {
        i = k;
        if (paramLinkedList != null)
        {
          if (paramLinkedList.size() != 0) {
            break label106;
          }
          i = k;
        }
        if (i != 0) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36735);
              c.b.this.dom.cmy();
              AppMethodBeat.o(36735);
            }
          });
        }
      }
    }
    AppMethodBeat.o(36736);
    return;
    label106:
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= paramLinkedList.size()) {
        break;
      }
      fbw localfbw = (fbw)paramLinkedList.get(j);
      if ((localfbw != null) && (!Util.isNullOrNil(localfbw.NxV)) && (localfbw.NxV.equals(this.ISe)))
      {
        Log.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
        if (!Util.isNullOrNil(localfbw.Nickname))
        {
          Log.i("MicroMsg.ChattingItem", "needCallback: true");
          i = 1;
          break;
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.b
 * JD-Core Version:    0.7.0.1
 */