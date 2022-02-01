package com.tencent.mm.plugin.scanner.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.ax.a;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qx.a;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.a;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class u
{
  public IListener CFM;
  public IListener CFN;
  Map<Long, String> CFO;
  e.b CFP;
  
  public u()
  {
    AppMethodBeat.i(51645);
    this.CFM = new IListener() {};
    this.CFN = new IListener() {};
    this.CFO = new HashMap();
    this.CFP = new e.b()
    {
      public final void a(final long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        final List localList3 = null;
        AppMethodBeat.i(240716);
        final List localList1;
        if (paramAnonymousd != null)
        {
          localList1 = paramAnonymousd.CGY;
          if (paramAnonymousd == null) {
            break label69;
          }
        }
        label69:
        for (final List localList2 = paramAnonymousd.RKj;; localList2 = null)
        {
          if (paramAnonymousd != null) {
            localList3 = paramAnonymousd.RKk;
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51643);
              Object localObject;
              if ((localList1 == null) || (localList1.isEmpty()))
              {
                Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", new Object[] { Long.valueOf(paramAnonymousLong) });
                if (u.this.CFO.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  localObject = new qy();
                  ((qy)localObject).dXy.filePath = ((String)u.this.CFO.get(Long.valueOf(paramAnonymousLong)));
                  EventCenter.instance.publish((IEvent)localObject);
                  u.this.CFO.remove(Long.valueOf(paramAnonymousLong));
                  AppMethodBeat.o(51643);
                }
              }
              else
              {
                Log.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(localList1.size()) });
                localObject = new qz();
                if (u.this.CFO.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  ((qz)localObject).dXz.filePath = ((String)u.this.CFO.get(Long.valueOf(paramAnonymousLong)));
                  ((qz)localObject).dXz.result = ((a.a)localList1.get(0)).data;
                  ((qz)localObject).dXz.dWl = ((a.a)localList1.get(0)).typeName;
                  ((qz)localObject).dXz.dFL = com.tencent.mm.pluginsdk.e.d.bcV(((a.a)localList1.get(0)).typeName);
                  ((qz)localObject).dXz.dXx = localList2.dXx;
                  if ((localList3 != null) && (localList3.size() > 0))
                  {
                    QbarNative.QBarPoint localQBarPoint = (QbarNative.QBarPoint)localList3.get(0);
                    if (localQBarPoint != null)
                    {
                      ((qz)localObject).dXz.dXC = ((localQBarPoint.x0 + localQBarPoint.x1 + localQBarPoint.x2 + localQBarPoint.x3) / 4.0F);
                      qz.a locala = ((qz)localObject).dXz;
                      float f1 = localQBarPoint.y0;
                      float f2 = localQBarPoint.y1;
                      float f3 = localQBarPoint.y2;
                      locala.dXD = ((localQBarPoint.y3 + (f1 + f2 + f3)) / 4.0F);
                      ((qz)localObject).dXz.dXC = Math.max(0.0F, ((qz)localObject).dXz.dXC);
                      ((qz)localObject).dXz.dXD = Math.max(0.0F, ((qz)localObject).dXz.dXD);
                    }
                  }
                  if (localList2.RKl != null)
                  {
                    ((qz)localObject).dXz.dXA = localList2.RKl.x;
                    ((qz)localObject).dXz.dXB = localList2.RKl.y;
                  }
                  if ((this.CFU != null) && (!this.CFU.isEmpty())) {
                    ((qz)localObject).dXz.dFM = ((WxQbarNative.QBarReportMsg)this.CFU.get(0)).qrcodeVersion;
                  }
                  EventCenter.instance.publish((IEvent)localObject);
                  u.this.CFO.remove(Long.valueOf(paramAnonymousLong));
                }
              }
              AppMethodBeat.o(51643);
            }
          });
          AppMethodBeat.o(240716);
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
    if ((??? instanceof qx))
    {
      c.RJF.reset();
      c.RJF.aqw(c.RJA);
      ??? = (qx)???;
      this.CFO.put(Long.valueOf(???.dXu.dDZ), ???.dXu.filePath);
      localObject1 = new e.c();
      ((e.c)localObject1).dXw = ???.dXu.dXw;
      ((e.c)localObject1).dXx = ???.dXu.dXx;
      e.hki().a(MMApplicationContext.getContext(), ???.dXu.dDZ, ???.dXu.filePath, ???.dXu.bitmap, this.CFP, new int[] { 0 }, (e.c)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof ax)) {
        continue;
      }
      c.RJF.bUV();
      localObject1 = (ax)???;
      b localb = b.hlc();
      long l = ((ax)localObject1).dDY.dDZ;
      synchronized (localb.CCt)
      {
        if (localb.RKc.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.RKc.get(Long.valueOf(l));
          if (localb.RKe.containsKey(str))
          {
            ((List)localb.RKe.get(str)).remove(Long.valueOf(l));
            if (((List)localb.RKe.get(str)).isEmpty()) {
              localb.RKe.remove(str);
            }
          }
          localb.RKc.remove(Long.valueOf(l));
          localb.RKd.remove(Long.valueOf(l));
        }
        this.CFO.remove(Long.valueOf(((ax)localObject1).dDY.dDZ));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u
 * JD-Core Version:    0.7.0.1
 */