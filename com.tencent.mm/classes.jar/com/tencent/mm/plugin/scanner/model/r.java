package com.tencent.mm.plugin.scanner.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.a;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qc.a;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e;
import com.tencent.qbar.e.b;
import com.tencent.qbar.e.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r
{
  public com.tencent.mm.sdk.b.c ymY;
  public com.tencent.mm.sdk.b.c ymZ;
  Map<Long, String> yna;
  e.b ynb;
  
  public r()
  {
    AppMethodBeat.i(51645);
    this.ymY = new com.tencent.mm.sdk.b.c() {};
    this.ymZ = new com.tencent.mm.sdk.b.c() {};
    this.yna = new HashMap();
    this.ynb = new e.b()
    {
      public final void a(final long paramAnonymousLong, com.tencent.qbar.e.d paramAnonymousd)
      {
        final List localList3 = null;
        AppMethodBeat.i(186164);
        final List localList1;
        if (paramAnonymousd != null)
        {
          localList1 = paramAnonymousd.yof;
          if (paramAnonymousd == null) {
            break label69;
          }
        }
        label69:
        for (final List localList2 = paramAnonymousd.LKJ;; localList2 = null)
        {
          if (paramAnonymousd != null) {
            localList3 = paramAnonymousd.LKK;
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(51643);
              Object localObject;
              if ((localList1 == null) || (localList1.isEmpty()))
              {
                ad.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", new Object[] { Long.valueOf(paramAnonymousLong) });
                if (r.this.yna.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  localObject = new qd();
                  ((qd)localObject).dEG.filePath = ((String)r.this.yna.get(Long.valueOf(paramAnonymousLong)));
                  a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                  r.this.yna.remove(Long.valueOf(paramAnonymousLong));
                  AppMethodBeat.o(51643);
                }
              }
              else
              {
                ad.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(localList1.size()) });
                localObject = new qe();
                if (r.this.yna.containsKey(Long.valueOf(paramAnonymousLong)))
                {
                  ((qe)localObject).dEH.filePath = ((String)r.this.yna.get(Long.valueOf(paramAnonymousLong)));
                  ((qe)localObject).dEH.result = ((a.a)localList1.get(0)).data;
                  ((qe)localObject).dEH.dDt = ((a.a)localList1.get(0)).typeName;
                  ((qe)localObject).dEH.dnt = com.tencent.mm.pluginsdk.e.d.aLg(((a.a)localList1.get(0)).typeName);
                  ((qe)localObject).dEH.dEF = localList2.dEF;
                  if ((localList3 != null) && (localList3.size() > 0))
                  {
                    QbarNative.QBarPoint localQBarPoint = (QbarNative.QBarPoint)localList3.get(0);
                    if (localQBarPoint != null)
                    {
                      ((qe)localObject).dEH.dEK = ((localQBarPoint.x0 + localQBarPoint.x1 + localQBarPoint.x2 + localQBarPoint.x3) / 4.0F);
                      qe.a locala = ((qe)localObject).dEH;
                      float f1 = localQBarPoint.y0;
                      float f2 = localQBarPoint.y1;
                      float f3 = localQBarPoint.y2;
                      locala.dEL = ((localQBarPoint.y3 + (f1 + f2 + f3)) / 4.0F);
                      ((qe)localObject).dEH.dEK = Math.max(0.0F, ((qe)localObject).dEH.dEK);
                      ((qe)localObject).dEH.dEL = Math.max(0.0F, ((qe)localObject).dEH.dEL);
                    }
                  }
                  if (localList2.LKL != null)
                  {
                    ((qe)localObject).dEH.dEI = localList2.LKL.x;
                    ((qe)localObject).dEH.dEJ = localList2.LKL.y;
                  }
                  if ((this.yng != null) && (!this.yng.isEmpty())) {
                    ((qe)localObject).dEH.dnu = ((WxQbarNative.QBarReportMsg)this.yng.get(0)).qrcodeVersion;
                  }
                  a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                  r.this.yna.remove(Long.valueOf(paramAnonymousLong));
                }
              }
              AppMethodBeat.o(51643);
            }
          });
          AppMethodBeat.o(186164);
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
    if ((??? instanceof qc))
    {
      com.tencent.qbar.c.LKf.reset();
      com.tencent.qbar.c.LKf.agz(com.tencent.qbar.c.LKa);
      ??? = (qc)???;
      this.yna.put(Long.valueOf(???.dEC.dlI), ???.dEC.filePath);
      localObject1 = new e.c();
      ((e.c)localObject1).dEE = ???.dEC.dEE;
      ((e.c)localObject1).dEF = ???.dEC.dEF;
      e.fTw().a(aj.getContext(), ???.dEC.dlI, ???.dEC.filePath, ???.dEC.bitmap, this.ynb, new int[] { 0 }, (e.c)localObject1);
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof av)) {
        continue;
      }
      com.tencent.qbar.c.LKf.bxK();
      localObject1 = (av)???;
      com.tencent.scanlib.b.b localb = com.tencent.scanlib.b.b.fUs();
      long l = ((av)localObject1).dlH.dlI;
      synchronized (localb.ylo)
      {
        if (localb.LKC.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.LKC.get(Long.valueOf(l));
          if (localb.LKE.containsKey(str))
          {
            ((List)localb.LKE.get(str)).remove(Long.valueOf(l));
            if (((List)localb.LKE.get(str)).isEmpty()) {
              localb.LKE.remove(str);
            }
          }
          localb.LKC.remove(Long.valueOf(l));
          localb.LKD.remove(Long.valueOf(l));
        }
        this.yna.remove(Long.valueOf(((av)localObject1).dlH.dlI));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.r
 * JD-Core Version:    0.7.0.1
 */