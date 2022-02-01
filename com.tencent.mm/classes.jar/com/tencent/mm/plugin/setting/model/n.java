package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.g.a.xs;
import com.tencent.mm.g.a.xs.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.e;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class n
{
  Object mLock;
  public final aq oXt;
  public boolean yTd;
  public boolean yTe;
  public boolean yTf;
  final CountDownLatch yTg;
  HashSet<String> yTh;
  HashSet<String> yTi;
  HashSet<String> yTj;
  HashSet<String> yTk;
  public a yTl;
  public UnfamiliarContactDetailUI.h yTm;
  public long yTn;
  public com.tencent.e.i.b yTo;
  
  public n(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(73799);
    this.mLock = new Object();
    this.yTh = new HashSet();
    this.yTi = new HashSet();
    this.yTj = new HashSet();
    this.yTk = new HashSet();
    this.yTd = paramBoolean1;
    this.yTe = paramBoolean2;
    this.yTf = paramBoolean3;
    int i;
    int j;
    if (this.yTe)
    {
      i = 1;
      if (!this.yTd) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.yTf) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      ae.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.yTe), Boolean.valueOf(this.yTd), Boolean.valueOf(this.yTf) });
      this.yTg = new CountDownLatch(i);
      this.oXt = new aq("UnfamiliarContactEngine");
      this.yTm = paramh;
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
      localj.jUf = 8;
      localj.query = bu.m(localList, ",");
      localj.tGa = new com.tencent.mm.plugin.fts.a.l()
      {
        final int limit;
        
        public final void b(k arg1)
        {
          AppMethodBeat.i(73793);
          ??? = ???.tGc;
          HashMap localHashMap;
          if ((??? != null) && (???.size() > 0))
          {
            ??? = (m)???.get(0);
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
            synchronized (n.this.mLock)
            {
              localObject3 = localList.iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label210;
              }
              str = (String)((Iterator)localObject3).next();
              if (!localHashMap.containsKey(str)) {
                n.this.yTj.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((m)localIterator.next()).tGf >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              n.this.yTj.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                ae.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                n.this.yTg.countDown();
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
                  ??? = (k)localObject2;
                }
                for (;;)
                {
                  ???[i] = Boolean.valueOf(bool);
                  ae.e("MicroMsg.UnfamiliarContactEngine", (String)localObject3, (Object[])localObject2);
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
              n.this.j(paramLinkedList, this.limit);
              AppMethodBeat.o(73793);
              return;
            }
          }
        }
      };
      localj.handler = this.oXt;
      ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
      AppMethodBeat.o(73800);
      return;
    }
  }
  
  final class a
    implements com.tencent.e.i.h, f
  {
    CountDownLatch qmr;
    long start;
    UnfamiliarContactDetailUI.h yTu;
    com.tencent.mm.ak.n yTv;
    
    a(UnfamiliarContactDetailUI.h paramh, CountDownLatch paramCountDownLatch)
    {
      this.yTu = paramh;
      this.qmr = paramCountDownLatch;
    }
    
    static void dQG()
    {
      AppMethodBeat.i(73798);
      jp localjp = new jp();
      localjp.dxx.dto = 3;
      a.IvT.l(localjp);
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
        ae.e("MicroMsg.UnfamiliarContactEngine", "[onSceneEnd] errType:%s errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        this.qmr.countDown();
        AppMethodBeat.o(73796);
        return;
      }
      if (paramn.getType() == 292)
      {
        this.yTv = paramn;
        com.tencent.e.h.MqF.aO(this);
      }
      AppMethodBeat.o(73796);
    }
    
    public final void run()
    {
      AppMethodBeat.i(73797);
      Object localObject = new xs();
      ((xs)localObject).dNf.dNh = this.yTv;
      a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      int j = ((xs)localObject).dNg.state;
      localObject = ((xs)localObject).dNg.dNi;
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
        ae.i("MicroMsg.UnfamiliarContactEngine", "[callback] state:%s,tagList is null?%s,tagList size:%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool), Integer.valueOf(i) });
        if (j == 1) {
          break label177;
        }
        if (localObject != null) {
          n.this.yTk.addAll((Collection)localObject);
        }
        ae.i("MicroMsg.UnfamiliarContactEngine", "[AsyncGetSnsTagInfo] %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.start) });
        this.qmr.countDown();
        AppMethodBeat.o(73797);
        return;
        bool = false;
        break;
      }
      label177:
      if (this.yTu != null) {
        n.this.oXt.postUI(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(73794);
            n.a.this.yTu.a(UnfamiliarContactDetailUI.e.zaI);
            AppMethodBeat.o(73794);
          }
        });
      }
      n.this.oXt.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(73795);
          n.a.dQG();
          AppMethodBeat.o(73795);
        }
      }, 30000L);
      AppMethodBeat.o(73797);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.n
 * JD-Core Version:    0.7.0.1
 */