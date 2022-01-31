package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class b$1
  implements Runnable
{
  public b$1(b paramb, String paramString, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(6568);
    Object localObject4 = br.F(this.uVi, "DNSAdvanceRelateDomain");
    Object localObject3 = new LinkedList();
    int i;
    Object localObject5;
    Object localObject1;
    if ((localObject4 != null) && (((Map)localObject4).size() > 0))
    {
      i = 0;
      if (i < ((Map)localObject4).size())
      {
        localObject5 = new StringBuilder(".DNSAdvanceRelateDomain.RelateDomain");
        if (i != 0) {
          break label651;
        }
        localObject1 = "";
        label73:
        localObject1 = (String)((Map)localObject4).get(localObject1 + ".$domain");
        if (!bo.isNullOrNil((String)localObject1)) {
          break label660;
        }
        ab.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", new Object[] { Integer.valueOf(i) });
      }
      i = 0;
    }
    label147:
    long l2;
    long l1;
    for (;;)
    {
      localObject5 = new StringBuilder(".DNSAdvanceRelateDomain.RelateDomain");
      Object localObject6;
      if (i == 0)
      {
        localObject1 = "";
        localObject5 = (String)((Map)localObject4).get(localObject1 + ".Relate");
        localObject6 = new StringBuilder(".DNSAdvanceRelateDomain.RelateDomain.Relate");
        if (i != 0) {
          break label694;
        }
      }
      label651:
      label660:
      label694:
      for (localObject1 = "";; localObject2 = Integer.valueOf(i))
      {
        localObject1 = (String)((Map)localObject4).get(localObject1);
        if ((!bo.isNullOrNil((String)localObject5)) || (!bo.isNullOrNil((String)localObject1))) {
          break label703;
        }
        ab.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", new Object[] { Integer.valueOf(i) });
        localObject4 = this.uVk.uVh.dcg();
        for (;;)
        {
          try
          {
            localObject5 = ((LinkedList)localObject3).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break label819;
            }
            localObject6 = (String)((Iterator)localObject5).next();
            l2 = System.currentTimeMillis();
            localObject1 = null;
          }
          catch (Exception localException1)
          {
            ab.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", new Object[] { localException1.getMessage() });
          }
          try
          {
            localObject3 = InetAddress.getByName((String)localObject6);
            localObject1 = localObject3;
            l1 = System.currentTimeMillis() - l2;
            localObject1 = localObject3;
            ab.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", new Object[] { localObject6, Long.valueOf(l1) });
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            ab.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", new Object[] { localException2.getMessage() });
            l1 = System.currentTimeMillis() - l2;
            continue;
            ((as.o)localObject4).csk = false;
            continue;
            Object localObject2 = ((as.o)localObject4).url.replace(",", "!");
            continue;
          }
          ((as.o)localObject4).iHc = l1;
          ((as.o)localObject4).url = ((String)localObject6);
          if (localObject1 == null) {
            break;
          }
          ((as.o)localObject4).csk = true;
          localObject3 = this.uVj;
          if (localObject3 != null)
          {
            ab.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", new Object[] { Integer.valueOf(as.aDS()), Long.valueOf(((as.o)localObject4).iHc), ((as.o)localObject4).url, Boolean.valueOf(((as.o)localObject4).csk) });
            localObject6 = ((as.o)localObject4).uWU;
            l1 = ((as.o)localObject4).iHc;
            i = at.getNetType(ah.getContext());
            if (((as.o)localObject4).url != null) {
              break label802;
            }
            localObject1 = ((as.o)localObject4).url;
            as.b((d)localObject3, (String)localObject6, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(as.access$000()), Integer.valueOf(as.access$100()), Integer.valueOf(((as.o)localObject4).cNH), ((as.o)localObject4).uWU });
            if (!((as.o)localObject4).csk) {
              h.qsU.idkeyStat(32L, 12L, 1L, true);
            }
            h.qsU.idkeyStat(32L, 1L, 1L, true);
            h.qsU.idkeyStat(32L, 5L, ((as.o)localObject4).iHc, true);
          }
        }
        AppMethodBeat.o(6568);
        return;
        localObject2 = Integer.valueOf(i);
        break label73;
        if (!((LinkedList)localObject3).contains(localObject2)) {
          ((LinkedList)localObject3).add(localObject2);
        }
        i += 1;
        break;
        localObject2 = Integer.valueOf(i);
        break label147;
      }
      label703:
      if ((!bo.isNullOrNil((String)localObject5)) && (!((LinkedList)localObject3).contains(localObject5))) {
        ((LinkedList)localObject3).add(localObject5);
      }
      if ((!bo.isNullOrNil((String)localObject2)) && (!((LinkedList)localObject3).contains(localObject2))) {
        ((LinkedList)localObject3).add(localObject2);
      }
      i += 1;
    }
    label802:
    label819:
    AppMethodBeat.o(6568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.b.1
 * JD-Core Version:    0.7.0.1
 */