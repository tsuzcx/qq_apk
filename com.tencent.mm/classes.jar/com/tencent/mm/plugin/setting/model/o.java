package com.tencent.mm.plugin.setting.model;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.aaa;
import com.tencent.mm.f.a.aaa.b;
import com.tencent.mm.f.a.ku;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class o
{
  public boolean JdB;
  public boolean JdC;
  public boolean JdD;
  final CountDownLatch JdE;
  HashSet<String> JdF;
  HashSet<String> JdG;
  HashSet<String> JdH;
  HashSet<String> JdI;
  public a JdJ;
  public UnfamiliarContactDetailUI.h JdK;
  public long JdL;
  public b JdM;
  Object mLock;
  public final MMHandler tLh;
  
  public o(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(73799);
    this.mLock = new Object();
    this.JdF = new HashSet();
    this.JdG = new HashSet();
    this.JdH = new HashSet();
    this.JdI = new HashSet();
    this.JdB = paramBoolean1;
    this.JdC = paramBoolean2;
    this.JdD = paramBoolean3;
    int i;
    int j;
    if (this.JdC)
    {
      i = 1;
      if (!this.JdB) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.JdD) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      Log.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.JdC), Boolean.valueOf(this.JdB), Boolean.valueOf(this.JdD) });
      this.JdE = new CountDownLatch(i);
      this.tLh = new MMHandler("UnfamiliarContactEngine");
      this.JdK = paramh;
      AppMethodBeat.o(73799);
      return;
      i = 0;
      break;
      j = 0;
      break label99;
    }
  }
  
  final void j(final LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(73800);
    final long l = System.currentTimeMillis();
    if (paramInt + 10 < paramLinkedList.size()) {}
    for (final int i = paramInt + 10;; i = paramLinkedList.size())
    {
      final List localList = paramLinkedList.subList(paramInt, i);
      j localj = new j();
      localj.nRn = 8;
      localj.query = Util.listToString(localList, ",");
      localj.BIU = new l()
      {
        final int limit;
        
        public final void b(k arg1)
        {
          AppMethodBeat.i(73793);
          ??? = ???.BIW;
          HashMap localHashMap;
          if ((??? != null) && (???.size() > 0))
          {
            ??? = (m)???.get(0);
            if ((???.BJh != null) && ((???.BJh instanceof HashMap))) {
              localHashMap = (HashMap)???.BJh;
            }
          }
          label299:
          label432:
          for (;;)
          {
            Object localObject3;
            String str;
            synchronized (o.this.mLock)
            {
              localObject3 = localList.iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label210;
              }
              str = (String)((Iterator)localObject3).next();
              if (!localHashMap.containsKey(str)) {
                o.this.JdH.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((m)localIterator.next()).BIZ >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              o.this.JdH.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                Log.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                o.this.JdE.countDown();
                AppMethodBeat.o(73793);
                return;
                localObject3 = "[getSameChatInfoTask] is null?%s is instanceof List";
                Object localObject2 = new Object[2];
                boolean bool;
                if (???.BJh == null)
                {
                  bool = true;
                  localObject2[0] = Boolean.valueOf(bool);
                  bool = ???.BJh instanceof HashMap;
                  i = 1;
                  ??? = (k)localObject2;
                }
                for (;;)
                {
                  ???[i] = Boolean.valueOf(bool);
                  Log.e("MicroMsg.UnfamiliarContactEngine", (String)localObject3, (Object[])localObject2);
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
                    ??? = (k)localObject2;
                    localObject2 = localObject3;
                    localObject3 = str;
                  }
                  else
                  {
                    bool = false;
                    i = 0;
                    localObject2 = ???;
                    localObject3 = ???;
                    ??? = (k)localObject2;
                    localObject2 = localObject3;
                    localObject3 = str;
                  }
                }
              }
              o.this.j(paramLinkedList, this.limit);
              AppMethodBeat.o(73793);
              return;
            }
          }
        }
      };
      localj.handler = this.tLh;
      ((n)com.tencent.mm.kernel.h.ag(n.class)).search(2, localj);
      AppMethodBeat.o(73800);
      return;
    }
  }
  
  final class a
    implements com.tencent.e.i.h, com.tencent.mm.an.i
  {
    UnfamiliarContactDetailUI.h JdS;
    q JdT;
    long start;
    CountDownLatch viX;
    
    a(UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
    {
      this.JdS = paramh;
      this.viX = paramCountDownLatch;
    }
    
    static void fFK()
    {
      AppMethodBeat.i(73798);
      ku localku = new ku();
      localku.fIp.fDn = 3;
      EventCenter.instance.publish(localku);
      AppMethodBeat.o(73798);
    }
    
    public final String getKey()
    {
      return "load_unfamiliar_contact";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(73796);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.viX.countDown();
        AppMethodBeat.o(73796);
        return;
      }
      if (paramq.getType() == 292)
      {
        this.JdT = paramq;
        com.tencent.e.h.ZvG.be(this);
      }
      AppMethodBeat.o(73796);
    }
    
    public final void run()
    {
      AppMethodBeat.i(73797);
      Object localObject = new aaa();
      ((aaa)localObject).fZm.fZo = this.JdT;
      EventCenter.instance.publish((IEvent)localObject);
      int j = ((aaa)localObject).fZn.state;
      localObject = ((aaa)localObject).fZn.fZp;
      boolean bool;
      if (localObject == null)
      {
        bool = true;
        if (localObject != null) {
          break label166;
        }
      }
      label166:
      for (int i = 0;; i = ((List)localObject).size())
      {
        Log.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
        if (j == 1) {
          break label177;
        }
        if (localObject != null) {
          o.this.JdI.addAll((Collection)localObject);
        }
        Log.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
        this.viX.countDown();
        AppMethodBeat.o(73797);
        return;
        bool = false;
        break;
      }
      label177:
      if (this.JdS != null) {
        o.this.tLh.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73794);
            o.a.this.JdS.a(UnfamiliarContactDetailUI.e.Jlg);
            AppMethodBeat.o(73794);
          }
        });
      }
      o.this.tLh.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73795);
          o.a.fFL();
          AppMethodBeat.o(73795);
        }
      }, 30000L);
      AppMethodBeat.o(73797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.o
 * JD-Core Version:    0.7.0.1
 */