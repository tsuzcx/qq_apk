package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class m
{
  Object mLock;
  public final ao onw;
  HashSet<String> xoA;
  public a xoB;
  public UnfamiliarContactDetailUI.h xoC;
  public long xoD;
  public com.tencent.e.i.b xoE;
  public boolean xot;
  public boolean xou;
  public boolean xov;
  final CountDownLatch xow;
  HashSet<String> xox;
  HashSet<String> xoy;
  HashSet<String> xoz;
  
  public m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(73799);
    this.mLock = new Object();
    this.xox = new HashSet();
    this.xoy = new HashSet();
    this.xoz = new HashSet();
    this.xoA = new HashSet();
    this.xot = paramBoolean1;
    this.xou = paramBoolean2;
    this.xov = paramBoolean3;
    int i;
    int j;
    if (this.xou)
    {
      i = 1;
      if (!this.xot) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.xov) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      ac.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.xou), Boolean.valueOf(this.xot), Boolean.valueOf(this.xov) });
      this.xow = new CountDownLatch(i);
      this.onw = new ao("UnfamiliarContactEngine");
      this.xoC = paramh;
      AppMethodBeat.o(73799);
      return;
      i = 0;
      break;
      j = 0;
      break label99;
    }
  }
  
  final void i(final LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(73800);
    final long l = System.currentTimeMillis();
    if (paramInt + 10 < paramLinkedList.size()) {}
    for (final int i = paramInt + 10;; i = paramLinkedList.size())
    {
      final List localList = paramLinkedList.subList(paramInt, i);
      j localj = new j();
      localj.jwR = 8;
      localj.query = bs.n(localList, ",");
      localj.syI = new l()
      {
        final int limit;
        
        public final void b(com.tencent.mm.plugin.fts.a.a.k arg1)
        {
          AppMethodBeat.i(73793);
          ??? = ???.syK;
          HashMap localHashMap;
          if ((??? != null) && (???.size() > 0))
          {
            ??? = (com.tencent.mm.plugin.fts.a.a.m)???.get(0);
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
            synchronized (m.this.mLock)
            {
              localObject3 = localList.iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label210;
              }
              str = (String)((Iterator)localObject3).next();
              if (!localHashMap.containsKey(str)) {
                m.this.xoz.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).syN >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              m.this.xoz.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                ac.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                m.this.xow.countDown();
                AppMethodBeat.o(73793);
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
                  ??? = (com.tencent.mm.plugin.fts.a.a.k)localObject2;
                }
                for (;;)
                {
                  ???[i] = Boolean.valueOf(bool);
                  ac.e("MicroMsg.UnfamiliarContactEngine", (String)localObject3, (Object[])localObject2);
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
                    ??? = (com.tencent.mm.plugin.fts.a.a.k)localObject2;
                    localObject2 = localObject3;
                    localObject3 = str;
                  }
                  else
                  {
                    bool = false;
                    i = 0;
                    localObject2 = ???;
                    localObject3 = ???;
                    ??? = (com.tencent.mm.plugin.fts.a.a.k)localObject2;
                    localObject2 = localObject3;
                    localObject3 = str;
                  }
                }
              }
              m.this.i(paramLinkedList, this.limit);
              AppMethodBeat.o(73793);
              return;
            }
          }
        }
      };
      localj.handler = this.onw;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      AppMethodBeat.o(73800);
      return;
    }
  }
  
  final class a
    implements com.tencent.e.i.h, com.tencent.mm.ak.g
  {
    CountDownLatch pCh;
    long start;
    UnfamiliarContactDetailUI.h xoK;
    com.tencent.mm.ak.n xoL;
    
    a(UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
    {
      this.xoK = paramh;
      this.pCh = paramCountDownLatch;
    }
    
    static void dBH()
    {
      AppMethodBeat.i(73798);
      jg localjg = new jg();
      localjg.dkF.dgL = 3;
      a.GpY.l(localjg);
      AppMethodBeat.o(73798);
    }
    
    public final String getKey()
    {
      return "load_unfamiliar_contact";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(73796);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.pCh.countDown();
        AppMethodBeat.o(73796);
        return;
      }
      if (paramn.getType() == 292)
      {
        this.xoL = paramn;
        com.tencent.e.h.JZN.aS(this);
      }
      AppMethodBeat.o(73796);
    }
    
    public final void run()
    {
      AppMethodBeat.i(73797);
      Object localObject = new wv();
      ((wv)localObject).dzE.dzG = this.xoL;
      a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      int j = ((wv)localObject).dzF.state;
      localObject = ((wv)localObject).dzF.dzH;
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
        ac.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
        if (j == 1) {
          break label177;
        }
        if (localObject != null) {
          m.this.xoA.addAll((Collection)localObject);
        }
        ac.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
        this.pCh.countDown();
        AppMethodBeat.o(73797);
        return;
        bool = false;
        break;
      }
      label177:
      if (this.xoK != null) {
        m.this.onw.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73794);
            m.a.this.xoK.a(UnfamiliarContactDetailUI.e.xvN);
            AppMethodBeat.o(73794);
          }
        });
      }
      m.this.onw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73795);
          m.a.dBH();
          AppMethodBeat.o(73795);
        }
      }, 30000L);
      AppMethodBeat.o(73797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.m
 * JD-Core Version:    0.7.0.1
 */