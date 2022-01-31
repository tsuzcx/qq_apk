package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.h;
import com.tencent.mm.aj.h.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;
import java.util.LinkedList;

final class c$b
  implements h.a
{
  a caz;
  private String vrN;
  
  protected c$b(a parama, String paramString)
  {
    this.vrN = paramString;
    this.caz = parama;
  }
  
  public final String aeZ()
  {
    return this.vrN;
  }
  
  public final void e(LinkedList<czd> paramLinkedList)
  {
    int k = 0;
    AppMethodBeat.i(32791);
    z.afj().b(this);
    ab.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
    int i;
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      ab.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", new Object[] { Integer.valueOf(paramLinkedList.size()), this.vrN });
      if (this.caz != null)
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
          al.d(new c.b.1(this));
        }
      }
    }
    AppMethodBeat.o(32791);
    return;
    label106:
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= paramLinkedList.size()) {
        break;
      }
      czd localczd = (czd)paramLinkedList.get(j);
      if ((localczd != null) && (!bo.isNullOrNil(localczd.ygd)) && (localczd.ygd.equals(this.vrN)))
      {
        ab.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
        if (!bo.isNullOrNil(localczd.Nickname))
        {
          ab.i("MicroMsg.ChattingItem", "needCallback: true");
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