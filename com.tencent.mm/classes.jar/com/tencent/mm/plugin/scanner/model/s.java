package com.tencent.mm.plugin.scanner.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.az.a;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rx.a;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.sdk.event.EventCenter;
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
import com.tencent.scanlib.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class s
{
  public IListener IKY;
  public IListener IKZ;
  Map<Long, String> ILa;
  e.b ILb;
  
  public s()
  {
    AppMethodBeat.i(51645);
    this.IKY = new IListener() {};
    this.IKZ = new IListener() {};
    this.ILa = new HashMap();
    this.ILb = new e.b()
    {
      public final void a(final long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        final List localList3 = null;
        AppMethodBeat.i(223510);
        final List localList1;
        if (paramAnonymousd != null)
        {
          localList1 = paramAnonymousd.IMj;
          if (paramAnonymousd == null) {
            break label69;
          }
        }
        label69:
        for (final List localList2 = paramAnonymousd.KjT;; localList2 = null)
        {
          if (paramAnonymousd != null) {
            localList3 = paramAnonymousd.ZmS;
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
                if (s.this.ILa.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  localObject1 = new ry();
                  ((ry)localObject1).fRk.filePath = ((String)s.this.ILa.get(Long.valueOf(paramAnonymousLong)));
                  EventCenter.instance.publish((IEvent)localObject1);
                  s.this.ILa.remove(Long.valueOf(paramAnonymousLong));
                  AppMethodBeat.o(51643);
                }
              }
              else
              {
                Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(localList1.size()) });
                localObject1 = new rz();
                if (s.this.ILa.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  ((rz)localObject1).fRl.filePath = ((String)s.this.ILa.get(Long.valueOf(paramAnonymousLong)));
                  if (localList3.ZmT != null)
                  {
                    ((rz)localObject1).fRl.fRr = localList3.ZmT.x;
                    ((rz)localObject1).fRl.fRs = localList3.ZmT.y;
                  }
                  ((rz)localObject1).fRl.fRj = localList3.fRj;
                  ((rz)localObject1).fRl.fRm = new ArrayList();
                  ((rz)localObject1).fRl.fRo = new ArrayList();
                  ((rz)localObject1).fRl.fRq = new ArrayList();
                  ((rz)localObject1).fRl.fRn = new ArrayList();
                  ((rz)localObject1).fRl.fRp = new ArrayList();
                  ((rz)localObject1).fRl.fRt = new ArrayList();
                  ((rz)localObject1).fRl.fRu = new ArrayList();
                  Iterator localIterator = localList1.iterator();
                  Object localObject2;
                  while (localIterator.hasNext())
                  {
                    localObject2 = (a.a)localIterator.next();
                    ((rz)localObject1).fRl.fRm.add(((a.a)localObject2).data);
                    ((rz)localObject1).fRl.fRo.add(((a.a)localObject2).typeName);
                    ((rz)localObject1).fRl.fRq.add(Integer.valueOf(((a.a)localObject2).priorityLevel));
                    ((rz)localObject1).fRl.fRn.add(Integer.valueOf(com.tencent.mm.pluginsdk.e.d.boV(((a.a)localObject2).typeName)));
                  }
                  if ((localList2 != null) && (!localList2.isEmpty()))
                  {
                    localIterator = localList2.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)localIterator.next();
                      ((rz)localObject1).fRl.fRp.add(Integer.valueOf(((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion));
                    }
                  }
                  if ((this.ILg != null) && (!this.ILg.isEmpty()))
                  {
                    localIterator = this.ILg.iterator();
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
                        ((rz)localObject1).fRl.fRt.add(Float.valueOf(f1));
                        ((rz)localObject1).fRl.fRu.add(Float.valueOf(f2));
                      }
                    }
                  }
                  Log.i("MicroMsg.RecogQBarOfImageFileListener", "mFileScanCallback result:%d codeName:%d codeType:%d codeVersion:$d codePointCenterX:%d codePointCenterY:%d", new Object[] { Integer.valueOf(((rz)localObject1).fRl.fRm.size()), Integer.valueOf(((rz)localObject1).fRl.fRo.size()), Integer.valueOf(((rz)localObject1).fRl.fRn.size()), Integer.valueOf(((rz)localObject1).fRl.fRp.size()), Integer.valueOf(((rz)localObject1).fRl.fRt.size()), Integer.valueOf(((rz)localObject1).fRl.fRu.size()) });
                  EventCenter.instance.publish((IEvent)localObject1);
                  s.this.ILa.remove(Long.valueOf(paramAnonymousLong));
                }
              }
              AppMethodBeat.o(51643);
            }
          });
          AppMethodBeat.o(223510);
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
    if ((??? instanceof rx))
    {
      c.Zmn.reset();
      c.Zmn.aAj(c.Zmi);
      ??? = (rx)???;
      this.ILa.put(Long.valueOf(???.fRg.fwK), ???.fRg.filePath);
      localObject1 = new e.c();
      ((e.c)localObject1).fRi = ???.fRg.fRi;
      ((e.c)localObject1).fRj = ???.fRg.fRj;
      e.inE().a(MMApplicationContext.getContext(), ???.fRg.fwK, ???.fRg.filePath, ???.fRg.bitmap, this.ILb, new int[] { 0 }, (e.c)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof az)) {
        continue;
      }
      c.Zmn.cig();
      localObject1 = (az)???;
      b localb = b.ioB();
      long l = ((az)localObject1).fwJ.fwK;
      synchronized (localb.Brg)
      {
        if (localb.ZmK.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.ZmK.get(Long.valueOf(l));
          if (localb.ZmM.containsKey(str))
          {
            ((List)localb.ZmM.get(str)).remove(Long.valueOf(l));
            if (((List)localb.ZmM.get(str)).isEmpty()) {
              localb.ZmM.remove(str);
            }
          }
          localb.ZmK.remove(Long.valueOf(l));
          localb.ZmL.remove(Long.valueOf(l));
        }
        this.ILa.remove(Long.valueOf(((az)localObject1).fwJ.fwK));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s
 * JD-Core Version:    0.7.0.1
 */