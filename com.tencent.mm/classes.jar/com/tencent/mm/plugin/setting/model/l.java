package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class l
{
  public final al eIo;
  Object mLock;
  public Runnable mRunnable;
  public boolean qEM;
  public boolean qEN;
  public boolean qEO;
  final CountDownLatch qEP;
  HashSet<String> qEQ;
  HashSet<String> qER;
  HashSet<String> qES;
  HashSet<String> qET;
  public l.a qEU;
  public UnfamiliarContactDetailUI.h qEV;
  public long qEW;
  
  public l(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(126877);
    this.mLock = new Object();
    this.qEQ = new HashSet();
    this.qER = new HashSet();
    this.qES = new HashSet();
    this.qET = new HashSet();
    this.qEM = paramBoolean1;
    this.qEN = paramBoolean2;
    this.qEO = paramBoolean3;
    int i;
    int j;
    if (this.qEN)
    {
      i = 1;
      if (!this.qEM) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.qEO) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      ab.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.qEN), Boolean.valueOf(this.qEM), Boolean.valueOf(this.qEO) });
      this.qEP = new CountDownLatch(i);
      this.eIo = new al("UnfamiliarContactEngine");
      this.qEV = paramh;
      AppMethodBeat.o(126877);
      return;
      i = 0;
      break;
      j = 0;
      break label99;
    }
  }
  
  final void g(final LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(126878);
    final long l = System.currentTimeMillis();
    if (paramInt + 10 < paramLinkedList.size()) {}
    for (final int i = paramInt + 10;; i = paramLinkedList.size())
    {
      final List localList = paramLinkedList.subList(paramInt, i);
      i locali = new i();
      locali.hdl = 8;
      locali.query = bo.d(localList, ",");
      locali.mSU = new com.tencent.mm.plugin.fts.a.l()
      {
        final int limit;
        
        public final void b(j arg1)
        {
          AppMethodBeat.i(126871);
          ??? = ???.mSW;
          HashMap localHashMap;
          if ((??? != null) && (???.size() > 0))
          {
            ??? = (com.tencent.mm.plugin.fts.a.a.l)???.get(0);
            if ((???.userData != null) && ((???.userData instanceof HashMap))) {
              localHashMap = (HashMap)???.userData;
            }
          }
          label299:
          label432:
          for (;;)
          {
            Object localObject3;
            String str;
            synchronized (l.this.mLock)
            {
              localObject3 = localList.iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label210;
              }
              str = (String)((Iterator)localObject3).next();
              if (!localHashMap.containsKey(str)) {
                l.this.qES.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).mSZ >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              l.this.qES.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                ab.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                l.this.qEP.countDown();
                AppMethodBeat.o(126871);
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
                  ab.e("MicroMsg.UnfamiliarContactEngine", (String)localObject3, (Object[])localObject2);
                  break;
                  bool = false;
                  break label299;
                  str = "[getSameChatInfoTask] list is null? %s ";
                  ??? = new Object[1];
                  if (localList == null)
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
              l.this.g(paramLinkedList, this.limit);
              AppMethodBeat.o(126871);
              return;
            }
          }
        }
      };
      locali.handler = this.eIo.caB();
      ((n)g.G(n.class)).search(2, locali);
      AppMethodBeat.o(126878);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l
 * JD-Core Version:    0.7.0.1
 */