package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
    localObject4 = bn.s(this.rfh, "DNSAdvanceRelateDomain");
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
          break label639;
        }
        localObject1 = "";
        label67:
        localObject1 = (String)((Map)localObject4).get(localObject1 + ".$domain");
        if (!bk.bl((String)localObject1)) {
          break label648;
        }
        y.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", new Object[] { Integer.valueOf(i) });
      }
      i = 0;
    }
    for (;;)
    {
      localObject5 = new StringBuilder(".DNSAdvanceRelateDomain.RelateDomain");
      label141:
      Object localObject6;
      if (i == 0)
      {
        localObject1 = "";
        localObject5 = (String)((Map)localObject4).get(localObject1 + ".Relate");
        localObject6 = new StringBuilder(".DNSAdvanceRelateDomain.RelateDomain.Relate");
        if (i != 0) {
          break label682;
        }
      }
      label648:
      label682:
      for (localObject1 = "";; localObject2 = Integer.valueOf(i))
      {
        localObject1 = (String)((Map)localObject4).get(localObject1);
        if ((!bk.bl((String)localObject5)) || (!bk.bl((String)localObject1))) {
          break label691;
        }
        y.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", new Object[] { Integer.valueOf(i) });
        localObject4 = this.rfj.rfg.ccd();
        for (;;)
        {
          try
          {
            localObject5 = ((LinkedList)localObject3).iterator();
            if (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              l2 = System.currentTimeMillis();
              localObject1 = null;
            }
          }
          catch (Exception localException1)
          {
            y.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", new Object[] { localException1.getMessage() });
          }
          try
          {
            localObject3 = InetAddress.getByName((String)localObject6);
            localObject1 = localObject3;
            l1 = System.currentTimeMillis() - l2;
            localObject1 = localObject3;
            y.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", new Object[] { localObject6, Long.valueOf(l1) });
            localObject1 = localObject3;
          }
          catch (Exception localException2)
          {
            y.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", new Object[] { localException2.getMessage() });
            l1 = System.currentTimeMillis() - l2;
            continue;
            ((an.n)localObject4).bKQ = false;
            continue;
            Object localObject2 = ((an.n)localObject4).url.replace(",", "!");
            continue;
          }
          ((an.n)localObject4).gYL = l1;
          ((an.n)localObject4).url = ((String)localObject6);
          if (localObject1 == null) {
            break label781;
          }
          ((an.n)localObject4).bKQ = true;
          localObject3 = this.rfi;
          if (localObject3 != null)
          {
            y.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", new Object[] { Integer.valueOf(an.ccb()), Long.valueOf(((an.n)localObject4).gYL), ((an.n)localObject4).url, Boolean.valueOf(((an.n)localObject4).bKQ) });
            localObject6 = ((an.n)localObject4).rgH;
            l1 = ((an.n)localObject4).gYL;
            i = aq.getNetType(ae.getContext());
            if (((an.n)localObject4).url != null) {
              break label790;
            }
            localObject1 = ((an.n)localObject4).url;
            an.a((d)localObject3, (String)localObject6, new Object[] { Integer.valueOf(1), Long.valueOf(l1), Integer.valueOf(i), localObject1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(((an.n)localObject4).cfb), ((an.n)localObject4).rgH });
            if (!((an.n)localObject4).bKQ) {
              h.nFQ.a(32L, 12L, 1L, true);
            }
            h.nFQ.a(32L, 1L, 1L, true);
            h.nFQ.a(32L, 5L, ((an.n)localObject4).gYL, true);
          }
        }
        return;
        label639:
        localObject2 = Integer.valueOf(i);
        break label67;
        if (!((LinkedList)localObject3).contains(localObject2)) {
          ((LinkedList)localObject3).add(localObject2);
        }
        i += 1;
        break;
        localObject2 = Integer.valueOf(i);
        break label141;
      }
      label691:
      if ((!bk.bl((String)localObject5)) && (!((LinkedList)localObject3).contains(localObject5))) {
        ((LinkedList)localObject3).add(localObject5);
      }
      if ((!bk.bl((String)localObject2)) && (!((LinkedList)localObject3).contains(localObject2))) {
        ((LinkedList)localObject3).add(localObject2);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.b.1
 * JD-Core Version:    0.7.0.1
 */