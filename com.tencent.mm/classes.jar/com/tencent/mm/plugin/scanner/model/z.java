package com.tencent.mm.plugin.scanner.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bf;
import com.tencent.mm.autogen.a.bf.a;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.tm.a;
import com.tencent.mm.autogen.a.tn;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.to.a;
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.c;
import com.tencent.qbar.e;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.c;
import com.tencent.qbar.e.d;
import com.tencent.scanlib.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class z
{
  public IListener ORV;
  public IListener ORW;
  Map<Long, String> ORX;
  e.b ORY;
  
  public z()
  {
    AppMethodBeat.i(51645);
    this.ORV = new RecogQBarOfImageFileListener.1(this, f.hfK);
    this.ORW = new RecogQBarOfImageFileListener.2(this, f.hfK);
    this.ORX = new HashMap();
    this.ORY = new e.b()
    {
      public final void a(final long paramAnonymousLong, e.d paramAnonymousd)
      {
        final List localList3 = null;
        AppMethodBeat.i(314418);
        final List localList1;
        if (paramAnonymousd != null)
        {
          localList1 = paramAnonymousd.OTq;
          if (paramAnonymousd == null) {
            break label69;
          }
        }
        label69:
        for (final List localList2 = paramAnonymousd.QHP;; localList2 = null)
        {
          if (paramAnonymousd != null) {
            localList3 = paramAnonymousd.ahrp;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51643);
              Object localObject1;
              if ((localList1 == null) || (localList1.isEmpty()))
              {
                Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", new Object[] { Long.valueOf(paramAnonymousLong) });
                if (z.this.ORX.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  localObject1 = new tn();
                  ((tn)localObject1).hXh.filePath = ((String)z.this.ORX.get(Long.valueOf(paramAnonymousLong)));
                  ((tn)localObject1).publish();
                  z.this.ORX.remove(Long.valueOf(paramAnonymousLong));
                  AppMethodBeat.o(51643);
                }
              }
              else
              {
                Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(localList1.size()) });
                localObject1 = new to();
                if (z.this.ORX.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  ((to)localObject1).hXi.filePath = ((String)z.this.ORX.get(Long.valueOf(paramAnonymousLong)));
                  if (localList3.ahrq != null)
                  {
                    ((to)localObject1).hXi.hXo = localList3.ahrq.x;
                    ((to)localObject1).hXi.hXp = localList3.ahrq.y;
                  }
                  ((to)localObject1).hXi.hXg = localList3.hXg;
                  ((to)localObject1).hXi.hXj = new ArrayList();
                  ((to)localObject1).hXi.hXl = new ArrayList();
                  ((to)localObject1).hXi.hXn = new ArrayList();
                  ((to)localObject1).hXi.hXk = new ArrayList();
                  ((to)localObject1).hXi.hXm = new ArrayList();
                  ((to)localObject1).hXi.hXq = new ArrayList();
                  ((to)localObject1).hXi.hXr = new ArrayList();
                  Iterator localIterator = localList1.iterator();
                  Object localObject2;
                  while (localIterator.hasNext())
                  {
                    localObject2 = (a.a)localIterator.next();
                    ((to)localObject1).hXi.hXj.add(((a.a)localObject2).data);
                    ((to)localObject1).hXi.hXl.add(((a.a)localObject2).typeName);
                    ((to)localObject1).hXi.hXn.add(Integer.valueOf(((a.a)localObject2).priorityLevel));
                    ((to)localObject1).hXi.hXk.add(Integer.valueOf(e.e.boP(((a.a)localObject2).typeName)));
                  }
                  if ((localList2 != null) && (!localList2.isEmpty()))
                  {
                    localIterator = localList2.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)localIterator.next();
                      ((to)localObject1).hXi.hXm.add(Integer.valueOf(((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion));
                    }
                  }
                  if ((this.OSd != null) && (!this.OSd.isEmpty()))
                  {
                    localIterator = this.OSd.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (QbarNative.QBarPoint)localIterator.next();
                      if (localObject2 != null)
                      {
                        float f1 = Math.max(0.0F, (((QbarNative.QBarPoint)localObject2).x0 + ((QbarNative.QBarPoint)localObject2).x1 + ((QbarNative.QBarPoint)localObject2).x2 + ((QbarNative.QBarPoint)localObject2).x3) / 4.0F);
                        float f2 = ((QbarNative.QBarPoint)localObject2).y0;
                        float f3 = ((QbarNative.QBarPoint)localObject2).y1;
                        float f4 = ((QbarNative.QBarPoint)localObject2).y2;
                        f2 = Math.max(0.0F, (((QbarNative.QBarPoint)localObject2).y3 + (f2 + f3 + f4)) / 4.0F);
                        ((to)localObject1).hXi.hXq.add(Float.valueOf(f1));
                        ((to)localObject1).hXi.hXr.add(Float.valueOf(f2));
                      }
                    }
                  }
                  Log.i("MicroMsg.RecogQBarOfImageFileListener", "mFileScanCallback result:%d codeName:%d codeType:%d codeVersion:$d codePointCenterX:%d codePointCenterY:%d", new Object[] { Integer.valueOf(((to)localObject1).hXi.hXj.size()), Integer.valueOf(((to)localObject1).hXi.hXl.size()), Integer.valueOf(((to)localObject1).hXi.hXk.size()), Integer.valueOf(((to)localObject1).hXi.hXm.size()), Integer.valueOf(((to)localObject1).hXi.hXq.size()), Integer.valueOf(((to)localObject1).hXi.hXr.size()) });
                  ((to)localObject1).publish();
                  z.this.ORX.remove(Long.valueOf(paramAnonymousLong));
                }
              }
              AppMethodBeat.o(51643);
            }
          });
          AppMethodBeat.o(314418);
          return;
          localList1 = null;
          break;
        }
      }
    };
    AppMethodBeat.o(51645);
  }
  
  public final boolean h(IEvent arg1)
  {
    AppMethodBeat.i(51646);
    if (??? == null)
    {
      AppMethodBeat.o(51646);
      return false;
    }
    Object localObject1;
    if ((??? instanceof tm))
    {
      c.ahqI.reset();
      c.ahqI.aGV(c.ahqC);
      ??? = (tm)???;
      this.ORX.put(Long.valueOf(???.hXd.hBk), ???.hXd.filePath);
      localObject1 = new e.c();
      ((e.c)localObject1).hXf = ???.hXd.hXf;
      ((e.c)localObject1).hXg = ???.hXd.hXg;
      e.jWN().a(MMApplicationContext.getContext(), ???.hXd.hBk, ???.hXd.filePath, ???.hXd.bitmap, this.ORY, new int[] { 0 }, (e.c)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof bf)) {
        continue;
      }
      c.ahqI.cIX();
      localObject1 = (bf)???;
      b localb = b.jXO();
      long l = ((bf)localObject1).hBj.hBk;
      synchronized (localb.GXz)
      {
        if (localb.ahrh.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.ahrh.get(Long.valueOf(l));
          if (localb.ahrj.containsKey(str))
          {
            ((List)localb.ahrj.get(str)).remove(Long.valueOf(l));
            if (((List)localb.ahrj.get(str)).isEmpty()) {
              localb.ahrj.remove(str);
            }
          }
          localb.ahrh.remove(Long.valueOf(l));
          localb.ahri.remove(Long.valueOf(l));
        }
        this.ORX.remove(Long.valueOf(((bf)localObject1).hBj.hBk));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */