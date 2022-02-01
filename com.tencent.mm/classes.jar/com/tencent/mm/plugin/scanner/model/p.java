package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.as.a;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pj.a;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.a.a;
import com.tencent.qbar.e;
import com.tencent.qbar.e.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class p
{
  public com.tencent.mm.sdk.b.c vOJ;
  public com.tencent.mm.sdk.b.c vOK;
  Map<Long, String> vOL;
  e.b vOM;
  
  public p()
  {
    AppMethodBeat.i(51645);
    this.vOJ = new com.tencent.mm.sdk.b.c() {};
    this.vOK = new com.tencent.mm.sdk.b.c() {};
    this.vOL = new HashMap();
    this.vOM = new e.b()
    {
      public final void a(final long paramAnonymousLong, final List<a.a> paramAnonymousList, List<WxQbarNative.QBarReportMsg> paramAnonymousList1)
      {
        AppMethodBeat.i(51644);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(51643);
            Object localObject;
            if ((paramAnonymousList == null) || (paramAnonymousList.isEmpty()))
            {
              ad.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file no result", new Object[] { Long.valueOf(paramAnonymousLong) });
              if (p.this.vOL.containsKey(Long.valueOf(paramAnonymousLong)))
              {
                localObject = new pk();
                ((pk)localObject).duZ.filePath = ((String)p.this.vOL.get(Long.valueOf(paramAnonymousLong)));
                a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                p.this.vOL.remove(Long.valueOf(paramAnonymousLong));
                AppMethodBeat.o(51643);
              }
            }
            else
            {
              ad.i("MicroMsg.RecogQBarOfImageFileListener", "%d scan file get %d results ", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousList.size()) });
              localObject = new pl();
              if (p.this.vOL.containsKey(Long.valueOf(paramAnonymousLong)))
              {
                ((pl)localObject).dva.filePath = ((String)p.this.vOL.get(Long.valueOf(paramAnonymousLong)));
                ((pl)localObject).dva.result = ((a.a)paramAnonymousList.get(0)).data;
                ((pl)localObject).dva.dtQ = ((a.a)paramAnonymousList.get(0)).typeName;
                ((pl)localObject).dva.deB = d.d.aAo(((a.a)paramAnonymousList.get(0)).typeName);
                if ((this.vOP != null) && (!this.vOP.isEmpty())) {
                  ((pl)localObject).dva.deC = ((WxQbarNative.QBarReportMsg)this.vOP.get(0)).qrcodeVersion;
                }
                a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                p.this.vOL.remove(Long.valueOf(paramAnonymousLong));
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
    if ((??? instanceof pj))
    {
      com.tencent.qbar.c.IoH.reset();
      com.tencent.qbar.c.IoH.abG(com.tencent.qbar.c.IoC);
      ??? = (pj)???;
      this.vOL.put(Long.valueOf(???.duX.dcQ), ???.duX.filePath);
      e.flQ().a(aj.getContext(), ???.duX.dcQ, ???.duX.filePath, this.vOM, new int[] { 0 });
    }
    for (;;)
    {
      AppMethodBeat.o(51646);
      return false;
      if (!(??? instanceof as)) {
        continue;
      }
      com.tencent.qbar.c.IoH.bmJ();
      as localas = (as)???;
      com.tencent.scanlib.b.b localb = com.tencent.scanlib.b.b.fmK();
      long l = localas.dcP.dcQ;
      synchronized (localb.vNi)
      {
        if (localb.Ipf.containsKey(Long.valueOf(l)))
        {
          String str = (String)localb.Ipf.get(Long.valueOf(l));
          if (localb.Iph.containsKey(str))
          {
            ((List)localb.Iph.get(str)).remove(Long.valueOf(l));
            if (((List)localb.Iph.get(str)).isEmpty()) {
              localb.Iph.remove(str);
            }
          }
          localb.Ipf.remove(Long.valueOf(l));
          localb.Ipg.remove(Long.valueOf(l));
        }
        this.vOL.remove(Long.valueOf(localas.dcP.dcQ));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.p
 * JD-Core Version:    0.7.0.1
 */