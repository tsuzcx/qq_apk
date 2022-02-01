package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.f.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ci;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public final class o
{
  public boolean CXV;
  public boolean CXW;
  public boolean CXX;
  final CountDownLatch CXY;
  HashSet<String> CXZ;
  HashSet<String> CYa;
  HashSet<String> CYb;
  HashSet<String> CYc;
  public o.a CYd;
  public UnfamiliarContactDetailUI.h CYe;
  public long CYf;
  public b CYg;
  Object mLock;
  public final MMHandler qmq;
  
  public o(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, UnfamiliarContactDetailUI.h paramh)
  {
    AppMethodBeat.i(73799);
    this.mLock = new Object();
    this.CXZ = new HashSet();
    this.CYa = new HashSet();
    this.CYb = new HashSet();
    this.CYc = new HashSet();
    this.CXV = paramBoolean1;
    this.CXW = paramBoolean2;
    this.CXX = paramBoolean3;
    int i;
    int j;
    if (this.CXW)
    {
      i = 1;
      if (!this.CXV) {
        break label212;
      }
      j = 1;
      label99:
      if (!this.CXX) {
        break label218;
      }
    }
    label212:
    label218:
    for (int k = 1;; k = 0)
    {
      i = k + (j + i);
      Log.i("MicroMsg.UnfamiliarContactEngine", "[UnfamiliarContactEngine] count:%s [%s:%s:%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.CXW), Boolean.valueOf(this.CXV), Boolean.valueOf(this.CXX) });
      this.CXY = new CountDownLatch(i);
      this.qmq = new MMHandler("UnfamiliarContactEngine");
      this.CYe = paramh;
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
      localj.kXb = 8;
      localj.query = Util.listToString(localList, ",");
      localj.wWZ = new com.tencent.mm.plugin.fts.a.l()
      {
        final int limit;
        
        public final void b(k arg1)
        {
          AppMethodBeat.i(73793);
          ??? = ???.wXb;
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
            synchronized (o.this.mLock)
            {
              localObject3 = localList.iterator();
              if (!((Iterator)localObject3).hasNext()) {
                break label210;
              }
              str = (String)((Iterator)localObject3).next();
              if (!localHashMap.containsKey(str)) {
                o.this.CYb.add(str);
              }
            }
            Iterator localIterator = ((List)localObject1.get(str)).iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (((m)localIterator.next()).wXe >= 100L);
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                break label432;
              }
              o.this.CYb.add(str);
              break;
              label210:
              if (this.limit >= paramLinkedList.size())
              {
                Log.i("MicroMsg.UnfamiliarContactEngine", "[getSameChatInfoTask] finish all load! userNames.size:%s cost:%sms", new Object[] { Integer.valueOf(paramLinkedList.size()), Long.valueOf(System.currentTimeMillis() - l) });
                o.this.CXY.countDown();
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
              o.this.i(paramLinkedList, this.limit);
              AppMethodBeat.o(73793);
              return;
            }
          }
        }
      };
      localj.handler = this.qmq;
      ((n)g.ah(n.class)).search(2, localj);
      AppMethodBeat.o(73800);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.o
 * JD-Core Version:    0.7.0.1
 */