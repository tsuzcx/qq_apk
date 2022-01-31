package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.e.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(32506);
    if (!bo.es(this.eiQ))
    {
      Iterator localIterator = this.eiQ.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (e)localIterator.next();
        localObject = new a.a(this.zOX.zOW, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).cpO, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).bma, ((e)localObject).iXn, ((e)localObject).fiY, ((e)localObject).cEn, ((e)localObject).cFn, ((e)localObject).desc, ((e)localObject).imagePath, ((e)localObject).iXo);
        this.zOX.zOW.iVH.add(localObject);
      }
    }
    this.zOX.zOW.zPe = this.zOX.zOW.iVH;
    if (this.zOX.zOW.zPc != null) {
      this.zOX.zOW.zPc.s(this.zOX.kFC, this.zOX.zOW.iVH.size());
    }
    AppMethodBeat.o(32506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a.1.1
 * JD-Core Version:    0.7.0.1
 */