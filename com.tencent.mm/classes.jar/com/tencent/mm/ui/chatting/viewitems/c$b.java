package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ai.h;
import com.tencent.mm.ai.h.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.protocal.c.cln;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import java.util.LinkedList;

final class c$b
  implements h.a
{
  a byx;
  private String rAL;
  
  protected c$b(a parama, String paramString)
  {
    this.rAL = paramString;
    this.byx = parama;
  }
  
  public final String Mq()
  {
    return this.rAL;
  }
  
  public final void e(LinkedList<cln> paramLinkedList)
  {
    int k = 0;
    z.Mz().b(this);
    y.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
    int i;
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      y.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.rAL });
      if (this.byx != null)
      {
        i = k;
        if (paramLinkedList != null)
        {
          if (paramLinkedList.size() != 0) {
            break label96;
          }
          i = k;
        }
        if (i != 0) {
          ai.d(new c.b.1(this));
        }
      }
    }
    return;
    label96:
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= paramLinkedList.size()) {
        break;
      }
      cln localcln = (cln)paramLinkedList.get(j);
      if ((localcln != null) && (!bk.bl(localcln.tYK)) && (localcln.tYK.equals(this.rAL)))
      {
        y.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
        if (!bk.bl(localcln.tqh))
        {
          y.i("MicroMsg.ChattingItem", "needCallback: true");
          i = 1;
          break;
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.b
 * JD-Core Version:    0.7.0.1
 */