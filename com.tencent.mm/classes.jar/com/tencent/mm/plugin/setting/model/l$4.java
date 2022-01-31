package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

final class l$4
  implements com.tencent.mm.plugin.fts.a.l
{
  final int limit = this.nRe;
  
  l$4(l paraml, int paramInt, List paramList, LinkedList paramLinkedList, long paramLong) {}
  
  public final void b(j arg1)
  {
    ??? = ???.kxh;
    HashMap localHashMap;
    if ((??? != null) && (???.size() > 0))
    {
      ??? = (com.tencent.mm.plugin.fts.a.a.l)???.get(0);
      if ((???.userData != null) && ((???.userData instanceof HashMap))) {
        localHashMap = (HashMap)???.userData;
      }
    }
    label412:
    for (;;)
    {
      Object localObject3;
      String str;
      synchronized (this.nRa.mLock)
      {
        localObject3 = this.gFL.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label200;
        }
        str = (String)((Iterator)localObject3).next();
        if (!localHashMap.containsKey(str)) {
          this.nRa.nQV.add(str);
        }
      }
      Iterator localIterator = ((List)localObject1.get(str)).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).kxk >= 100L);
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label412;
        }
        this.nRa.nQV.add(str);
        break;
        label200:
        if (this.limit >= this.nRf.size())
        {
          y.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(this.nRf.size()), Long.valueOf(System.currentTimeMillis() - this.dhV) });
          this.nRa.nQS.countDown();
          return;
          localObject3 = "[getSameChatInfoTask] is null?%s is instanceof List";
          Object localObject2 = new Object[2];
          boolean bool;
          if (???.userData == null)
          {
            bool = true;
            localObject2[0] = Boolean.valueOf(bool);
            bool = ???.userData instanceof HashMap;
            i = 1;
            ??? = (j)localObject2;
          }
          for (;;)
          {
            ???[i] = Boolean.valueOf(bool);
            y.e("MicroMsg.UnfamiliarContactEngine", (String)localObject3, (Object[])localObject2);
            break;
            bool = false;
            break label284;
            str = "[getSameChatInfoTask] list is null? %s ";
            ??? = new Object[1];
            if (this.gFL == null)
            {
              bool = true;
              i = 0;
              localObject2 = ???;
              localObject3 = ???;
              ??? = (j)localObject2;
              localObject2 = localObject3;
              localObject3 = str;
            }
            else
            {
              bool = false;
              i = 0;
              localObject2 = ???;
              localObject3 = ???;
              ??? = (j)localObject2;
              localObject2 = localObject3;
              localObject3 = str;
            }
          }
        }
        label284:
        this.nRa.g(this.nRf, this.limit);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.4
 * JD-Core Version:    0.7.0.1
 */