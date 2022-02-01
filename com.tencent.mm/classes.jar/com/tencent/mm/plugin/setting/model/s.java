package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abx;
import com.tencent.mm.autogen.a.abx.b;
import com.tencent.mm.autogen.a.ly;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cm;
import com.tencent.threadpool.i.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class s
{
  public boolean PnU;
  public boolean PnV;
  public boolean PnW;
  final CountDownLatch PnX;
  HashSet<String> PnY;
  HashSet<String> PnZ;
  HashSet<String> Poa;
  HashSet<String> Pob;
  public a Poc;
  public UnfamiliarContactDetailUI.h Pod;
  public long Poe;
  public b Pof;
  Object mLock;
  public final MMHandler wOw;
  
  public s(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(73799);
    this.mLock = new Object();
    this.PnY = new HashSet();
    this.PnZ = new HashSet();
    this.Poa = new HashSet();
    this.Pob = new HashSet();
    this.PnU = paramBoolean1;
    this.PnV = paramBoolean2;
    this.PnW = paramBoolean3;
    int i;
    int j;
    if (this.PnV)
    {
      i = 1;
      if (!this.PnU) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.PnW) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      Log.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.PnV), Boolean.valueOf(this.PnU), Boolean.valueOf(this.PnW) });
      this.PnX = new CountDownLatch(i);
      this.wOw = new MMHandler("UnfamiliarContactEngine");
      this.Pod = paramh;
      AppMethodBeat.o(73799);
      return;
      i = 0;
      break;
      j = 0;
      break label99;
    }
  }
  
  final void l(final LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(73800);
    final long l = System.currentTimeMillis();
    if (paramInt + 10 < paramLinkedList.size()) {}
    for (final int i = paramInt + 10;; i = paramLinkedList.size())
    {
      final List localList = paramLinkedList.subList(paramInt, i);
      com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
      locall.qRb = 8;
      locall.query = Util.listToString(localList, ",");
      locall.HtC = new com.tencent.mm.plugin.fts.a.l()
      {
        final int limit;
        
        public final void b(m arg1)
        {
          AppMethodBeat.i(73793);
          ??? = ???.HtF;
          HashMap localHashMap;
          if ((??? != null) && (???.size() > 0))
          {
            ??? = (o)???.get(0);
            if ((???.HtQ != null) && ((???.HtQ instanceof HashMap))) {
              localHashMap = (HashMap)???.HtQ;
            }
          }
          label299:
          label432:
          for (;;)
          {
            Object localObject3;
            String str;
            synchronized (s.this.mLock)
            {
              localObject3 = localList.iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label210;
              }
              str = (String)((Iterator)localObject3).next();
              if (!localHashMap.containsKey(str)) {
                s.this.Poa.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((o)localIterator.next()).HtI >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              s.this.Poa.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                Log.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                s.this.PnX.countDown();
                AppMethodBeat.o(73793);
                return;
                localObject3 = "[getSameChatInfoTask] is null?%s is instanceof List";
                Object localObject2 = new Object[2];
                boolean bool;
                if (???.HtQ == null)
                {
                  bool = true;
                  localObject2[0] = Boolean.valueOf(bool);
                  bool = ???.HtQ instanceof HashMap;
                  i = 1;
                  ??? = (m)localObject2;
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
                    ??? = (m)localObject2;
                    localObject2 = localObject3;
                    localObject3 = str;
                  }
                  else
                  {
                    bool = false;
                    i = 0;
                    localObject2 = ???;
                    localObject3 = ???;
                    ??? = (m)localObject2;
                    localObject2 = localObject3;
                    localObject3 = str;
                  }
                }
              }
              s.this.l(paramLinkedList, this.limit);
              AppMethodBeat.o(73793);
              return;
            }
          }
        }
      };
      locall.handler = this.wOw;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
      AppMethodBeat.o(73800);
      return;
    }
  }
  
  final class a
    implements com.tencent.mm.am.h, com.tencent.threadpool.i.h
  {
    UnfamiliarContactDetailUI.h Pol;
    p Pom;
    long start;
    CountDownLatch yuW;
    
    a(UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
    {
      this.Pol = paramh;
      this.yuW = paramCountDownLatch;
    }
    
    static void gUY()
    {
      AppMethodBeat.i(73798);
      ly locally = new ly();
      locally.hNP.hId = 3;
      locally.publish();
      AppMethodBeat.o(73798);
    }
    
    public final String getKey()
    {
      return "load_unfamiliar_contact";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(73796);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.yuW.countDown();
        AppMethodBeat.o(73796);
        return;
      }
      if (paramp.getType() == 292)
      {
        this.Pom = paramp;
        com.tencent.threadpool.h.ahAA.bm(this);
      }
      AppMethodBeat.o(73796);
    }
    
    public final void run()
    {
      AppMethodBeat.i(73797);
      Object localObject = new abx();
      ((abx)localObject).ifr.ift = this.Pom;
      ((abx)localObject).publish();
      int j = ((abx)localObject).ifs.state;
      localObject = ((abx)localObject).ifs.ifu;
      boolean bool;
      if (localObject == null)
      {
        bool = true;
        if (localObject != null) {
          break label163;
        }
      }
      label163:
      for (int i = 0;; i = ((List)localObject).size())
      {
        Log.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
        if (j == 1) {
          break label174;
        }
        if (localObject != null) {
          s.this.Pob.addAll((Collection)localObject);
        }
        Log.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
        this.yuW.countDown();
        AppMethodBeat.o(73797);
        return;
        bool = false;
        break;
      }
      label174:
      if (this.Pol != null) {
        s.this.wOw.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73794);
            s.a.this.Pol.a(UnfamiliarContactDetailUI.e.PxF);
            AppMethodBeat.o(73794);
          }
        });
      }
      s.this.wOw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73795);
          s.a.gUZ();
          AppMethodBeat.o(73795);
        }
      }, 30000L);
      AppMethodBeat.o(73797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.s
 * JD-Core Version:    0.7.0.1
 */