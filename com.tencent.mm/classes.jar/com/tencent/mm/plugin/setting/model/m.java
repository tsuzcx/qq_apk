package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wk.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.br;
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
  public final ap nKw;
  public boolean wdf;
  public boolean wdg;
  public boolean wdh;
  final CountDownLatch wdi;
  HashSet<String> wdj;
  HashSet<String> wdk;
  HashSet<String> wdl;
  HashSet<String> wdm;
  public a wdn;
  public UnfamiliarContactDetailUI.h wdo;
  public long wdp;
  public com.tencent.e.i.b wdq;
  
  public m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(73799);
    this.mLock = new Object();
    this.wdj = new HashSet();
    this.wdk = new HashSet();
    this.wdl = new HashSet();
    this.wdm = new HashSet();
    this.wdf = paramBoolean1;
    this.wdg = paramBoolean2;
    this.wdh = paramBoolean3;
    int i;
    int j;
    if (this.wdg)
    {
      i = 1;
      if (!this.wdf) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.wdh) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      ad.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.wdg), Boolean.valueOf(this.wdf), Boolean.valueOf(this.wdh) });
      this.wdi = new CountDownLatch(i);
      this.nKw = new ap("UnfamiliarContactEngine");
      this.wdo = paramh;
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
      localj.iWB = 8;
      localj.query = bt.n(localList, ",");
      localj.rpO = new l()
      {
        final int limit;
        
        public final void b(com.tencent.mm.plugin.fts.a.a.k arg1)
        {
          AppMethodBeat.i(73793);
          ??? = ???.rpQ;
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
                m.this.wdl.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((com.tencent.mm.plugin.fts.a.a.m)localIterator.next()).rpT >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              m.this.wdl.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                ad.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                m.this.wdi.countDown();
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
                  ad.e("MicroMsg.UnfamiliarContactEngine", (String)localObject3, (Object[])localObject2);
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
      localj.handler = this.nKw;
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      AppMethodBeat.o(73800);
      return;
    }
  }
  
  final class a
    implements com.tencent.e.i.h, com.tencent.mm.al.g
  {
    CountDownLatch oYW;
    long start;
    UnfamiliarContactDetailUI.h wdw;
    com.tencent.mm.al.n wdx;
    
    a(UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
    {
      this.wdw = paramh;
      this.oYW = paramCountDownLatch;
    }
    
    static void dnz()
    {
      AppMethodBeat.i(73798);
      iz localiz = new iz();
      localiz.dmX.djq = 3;
      a.ESL.l(localiz);
      AppMethodBeat.o(73798);
    }
    
    public final String getKey()
    {
      return "load_unfamiliar_contact";
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(73796);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.oYW.countDown();
        AppMethodBeat.o(73796);
        return;
      }
      if (paramn.getType() == 292)
      {
        this.wdx = paramn;
        com.tencent.e.h.Iye.aP(this);
      }
      AppMethodBeat.o(73796);
    }
    
    public final void run()
    {
      AppMethodBeat.i(73797);
      Object localObject = new wk();
      ((wk)localObject).dBQ.dBS = this.wdx;
      a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      int j = ((wk)localObject).dBR.state;
      localObject = ((wk)localObject).dBR.dBT;
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
        ad.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
        if (j == 1) {
          break label177;
        }
        if (localObject != null) {
          m.this.wdm.addAll((Collection)localObject);
        }
        ad.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
        this.oYW.countDown();
        AppMethodBeat.o(73797);
        return;
        bool = false;
        break;
      }
      label177:
      if (this.wdw != null) {
        m.this.nKw.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73794);
            m.a.this.wdw.a(UnfamiliarContactDetailUI.e.wkx);
            AppMethodBeat.o(73794);
          }
        });
      }
      m.this.nKw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73795);
          m.a.dnz();
          AppMethodBeat.o(73795);
        }
      }, 30000L);
      AppMethodBeat.o(73797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.m
 * JD-Core Version:    0.7.0.1
 */