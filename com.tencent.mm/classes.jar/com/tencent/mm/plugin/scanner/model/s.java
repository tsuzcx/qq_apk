package com.tencent.mm.plugin.scanner.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.a;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qd.a;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class s
{
  public com.tencent.mm.sdk.b.c yCX;
  public com.tencent.mm.sdk.b.c yCY;
  Map<Long, String> yCZ;
  e.b yDa;
  
  public s()
  {
    AppMethodBeat.i(51645);
    this.yCX = new com.tencent.mm.sdk.b.c() {};
    this.yCY = new com.tencent.mm.sdk.b.c() {};
    this.yCZ = new HashMap();
    this.yDa = new e.b()
    {
      public final void a(final long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        final List localList3 = null;
        AppMethodBeat.i(189446);
        final List localList1;
        if (paramAnonymousd != null)
        {
          localList1 = paramAnonymousd.yEe;
          if (paramAnonymousd == null) {
            break label69;
          }
        }
        label69:
        for (final List localList2 = paramAnonymousd.MhI;; localList2 = null)
        {
          if (paramAnonymousd != null) {
            localList3 = paramAnonymousd.MhJ;
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51643);
              Object localObject;
              if ((localList1 == null) || (localList1.isEmpty()))
              {
                ae.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", new Object[] { Long.valueOf(paramAnonymousLong) });
                if (s.this.yCZ.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  localObject = new qe();
                  ((qe)localObject).dFL.filePath = ((String)s.this.yCZ.get(Long.valueOf(paramAnonymousLong)));
                  a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                  s.this.yCZ.remove(Long.valueOf(paramAnonymousLong));
                  AppMethodBeat.o(51643);
                }
              }
              else
              {
                ae.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(localList1.size()) });
                localObject = new qf();
                if (s.this.yCZ.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  ((qf)localObject).dFM.filePath = ((String)s.this.yCZ.get(Long.valueOf(paramAnonymousLong)));
                  ((qf)localObject).dFM.result = ((a.a)localList1.get(0)).data;
                  ((qf)localObject).dFM.dEy = ((a.a)localList1.get(0)).typeName;
                  ((qf)localObject).dFM.dov = com.tencent.mm.pluginsdk.e.d.aMC(((a.a)localList1.get(0)).typeName);
                  ((qf)localObject).dFM.dFK = localList2.dFK;
                  if ((localList3 != null) && (localList3.size() > 0))
                  {
                    QbarNative.QBarPoint localQBarPoint = (QbarNative.QBarPoint)localList3.get(0);
                    if (localQBarPoint != null)
                    {
                      ((qf)localObject).dFM.dFP = ((localQBarPoint.x0 + localQBarPoint.x1 + localQBarPoint.x2 + localQBarPoint.x3) / 4.0F);
                      qf.a locala = ((qf)localObject).dFM;
                      float f1 = localQBarPoint.y0;
                      float f2 = localQBarPoint.y1;
                      float f3 = localQBarPoint.y2;
                      locala.dFQ = ((localQBarPoint.y3 + (f1 + f2 + f3)) / 4.0F);
                      ((qf)localObject).dFM.dFP = Math.max(0.0F, ((qf)localObject).dFM.dFP);
                      ((qf)localObject).dFM.dFQ = Math.max(0.0F, ((qf)localObject).dFM.dFQ);
                    }
                  }
                  if (localList2.MhK != null)
                  {
                    ((qf)localObject).dFM.dFN = localList2.MhK.x;
                    ((qf)localObject).dFM.dFO = localList2.MhK.y;
                  }
                  if ((this.yDf != null) && (!this.yDf.isEmpty())) {
                    ((qf)localObject).dFM.dow = ((WxQbarNative.QBarReportMsg)this.yDf.get(0)).qrcodeVersion;
                  }
                  a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                  s.this.yCZ.remove(Long.valueOf(paramAnonymousLong));
                }
              }
              AppMethodBeat.o(51643);
            }
          });
          AppMethodBeat.o(189446);
          return;
          localList1 = null;
          break;
        }
      }
    };
    AppMethodBeat.o(51645);
  }
  
  public final boolean g(com.tencent.mm.sdk.b.b arg1)
  {
    AppMethodBeat.i(51646);
    if (??? == null)
    {
      AppMethodBeat.o(51646);
      return false;
    }
    Object localObject1;
    if ((??? instanceof qd))
    {
      com.tencent.qbar.c.Mhe.reset();
      com.tencent.qbar.c.Mhe.ahi(com.tencent.qbar.c.MgZ);
      ??? = (qd)???;
      this.yCZ.put(Long.valueOf(???.dFH.dmK), ???.dFH.filePath);
      localObject1 = new e.c();
      ((e.c)localObject1).dFJ = ???.dFH.dFJ;
      ((e.c)localObject1).dFK = ???.dFH.dFK;
      e.fXW().a(ak.getContext(), ???.dFH.dmK, ???.dFH.filePath, ???.dFH.bitmap, this.yDa, new int[] { 0 }, (e.c)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof av)) {
        continue;
      }
      com.tencent.qbar.c.Mhe.byD();
      localObject1 = (av)???;
      com.tencent.scanlib.b.b localb = com.tencent.scanlib.b.b.fYR();
      long l = ((av)localObject1).dmJ.dmK;
      synchronized (localb.yBn)
      {
        if (localb.MhB.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.MhB.get(Long.valueOf(l));
          if (localb.MhD.containsKey(str))
          {
            ((List)localb.MhD.get(str)).remove(Long.valueOf(l));
            if (((List)localb.MhD.get(str)).isEmpty()) {
              localb.MhD.remove(str);
            }
          }
          localb.MhB.remove(Long.valueOf(l));
          localb.MhC.remove(Long.valueOf(l));
        }
        this.yCZ.remove(Long.valueOf(((av)localObject1).dmJ.dmK));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s
 * JD-Core Version:    0.7.0.1
 */