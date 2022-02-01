package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.at.a;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.ps.a;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e;
import com.tencent.qbar.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p
{
  public com.tencent.mm.sdk.b.c wZf;
  public com.tencent.mm.sdk.b.c wZg;
  Map<Long, String> wZh;
  e.b wZi;
  
  public p()
  {
    AppMethodBeat.i(51645);
    this.wZf = new com.tencent.mm.sdk.b.c() {};
    this.wZg = new com.tencent.mm.sdk.b.c() {};
    this.wZh = new HashMap();
    this.wZi = new e.b()
    {
      public final void a(final long paramAnonymousLong, final List<a.a> paramAnonymousList, List<WxQbarNative.QBarReportMsg> paramAnonymousList1)
      {
        AppMethodBeat.i(51644);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(51643);
            Object localObject;
            if ((paramAnonymousList == null) || (paramAnonymousList.isEmpty()))
            {
              ac.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", new Object[] { Long.valueOf(paramAnonymousLong) });
              if (p.this.wZh.containsKey(Long.valueOf(paramAnonymousLong)))
              {
                localObject = new pt();
                ((pt)localObject).dsL.filePath = ((String)p.this.wZh.get(Long.valueOf(paramAnonymousLong)));
                a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                p.this.wZh.remove(Long.valueOf(paramAnonymousLong));
                AppMethodBeat.o(51643);
              }
            }
            else
            {
              ac.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousList.size()) });
              localObject = new pu();
              if (p.this.wZh.containsKey(Long.valueOf(paramAnonymousLong)))
              {
                ((pu)localObject).dsM.filePath = ((String)p.this.wZh.get(Long.valueOf(paramAnonymousLong)));
                ((pu)localObject).dsM.result = ((a.a)paramAnonymousList.get(0)).data;
                ((pu)localObject).dsM.drB = ((a.a)paramAnonymousList.get(0)).typeName;
                ((pu)localObject).dsM.dbX = d.d.aFG(((a.a)paramAnonymousList.get(0)).typeName);
                if ((this.wZl != null) && (!this.wZl.isEmpty())) {
                  ((pu)localObject).dsM.dbY = ((WxQbarNative.QBarReportMsg)this.wZl.get(0)).qrcodeVersion;
                }
                a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                p.this.wZh.remove(Long.valueOf(paramAnonymousLong));
              }
            }
            AppMethodBeat.o(51643);
          }
        });
        AppMethodBeat.o(51644);
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
    if ((??? instanceof ps))
    {
      com.tencent.qbar.c.JQs.reset();
      com.tencent.qbar.c.JQs.adZ(com.tencent.qbar.c.JQn);
      ??? = (ps)???;
      this.wZh.put(Long.valueOf(???.dsJ.dao), ???.dsJ.filePath);
      e.fCh().a(ai.getContext(), ???.dsJ.dao, ???.dsJ.filePath, this.wZi, new int[] { 0 });
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof at)) {
        continue;
      }
      com.tencent.qbar.c.JQs.btF();
      at localat = (at)???;
      com.tencent.scanlib.b.b localb = com.tencent.scanlib.b.b.fDa();
      long l = localat.dan.dao;
      synchronized (localb.wXD)
      {
        if (localb.JQP.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.JQP.get(Long.valueOf(l));
          if (localb.JQR.containsKey(str))
          {
            ((List)localb.JQR.get(str)).remove(Long.valueOf(l));
            if (((List)localb.JQR.get(str)).isEmpty()) {
              localb.JQR.remove(str);
            }
          }
          localb.JQP.remove(Long.valueOf(l));
          localb.JQQ.remove(Long.valueOf(l));
        }
        this.wZh.remove(Long.valueOf(localat.dan.dao));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p
 * JD-Core Version:    0.7.0.1
 */