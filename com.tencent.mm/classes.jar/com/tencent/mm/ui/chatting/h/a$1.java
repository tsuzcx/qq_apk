package com.tencent.mm.ui.chatting.h;

import com.tencent.mm.plugin.appbrand.u.c.a;
import com.tencent.mm.plugin.appbrand.u.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.d.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void y(LinkedList<e> paramLinkedList)
  {
    if (!bk.dk(paramLinkedList))
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        Object localObject = (e)paramLinkedList.next();
        localObject = new a.a(this.vyA, ((e)localObject).timestamp, ((e)localObject).type, ((e)localObject).title, ((e)localObject).bIt, ((e)localObject).username, ((e)localObject).nickname, ((e)localObject).aVs, ((e)localObject).hkV, ((e)localObject).dSZ, ((e)localObject).bWy, ((e)localObject).bXr, ((e)localObject).desc, ((e)localObject).imagePath);
        this.vyA.hka.add(localObject);
      }
    }
    this.vyA.vyF = this.vyA.hka;
    if (this.vyA.vyD != null) {
      this.vyA.vyD.k(this.kik, this.vyA.hka.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a.1
 * JD-Core Version:    0.7.0.1
 */