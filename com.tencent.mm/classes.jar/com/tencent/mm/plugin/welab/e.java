package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e
{
  private static boolean DEBUG = false;
  private static boolean ga = false;
  
  private static void aDC()
  {
    AppMethodBeat.i(146220);
    long l = System.currentTimeMillis() / 1000L;
    g.ajR().ajA().set(am.a.ITP, Long.valueOf(l));
    AppMethodBeat.o(146220);
  }
  
  private static void aDE()
  {
    AppMethodBeat.i(146222);
    g.ajR().ajA().fuc();
    AppMethodBeat.o(146222);
  }
  
  static void aK(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146217);
    ae.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!g.ajP().aiZ())
    {
      ae.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(146217);
      return;
    }
    if ((!DEBUG) && (!paramBoolean1) && (!paramBoolean2))
    {
      localObject = (Long)g.ajR().ajA().get(am.a.ITP, null);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 != 0L) {
          break label169;
        }
        i = new Random().nextInt(86400);
        oK(i);
        aDC();
        aDE();
        ae.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label306;
        }
        ae.v("MicroMsg.WelabUpdater", "No need to update");
        AppMethodBeat.o(146217);
        return;
        l1 = ((Long)localObject).longValue();
        break;
        label169:
        localObject = (Integer)g.ajR().ajA().get(am.a.ITQ, null);
        label203:
        long l2;
        long l3;
        if ((localObject == null) || (((Integer)localObject).intValue() == 0))
        {
          i = 86400;
          l2 = i;
          l3 = System.currentTimeMillis() / 1000L;
          if (l3 <= l1 + l2) {
            break label296;
          }
        }
        label296:
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.WelabUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
          if (l3 <= l1 + l2) {
            break label301;
          }
          i = 1;
          break;
          i = ((Integer)localObject).intValue();
          break label203;
        }
        label301:
        i = 0;
      }
    }
    label306:
    if (ga)
    {
      ae.i("MicroMsg.WelabUpdater", "Updating");
      AppMethodBeat.o(146217);
      return;
    }
    ga = true;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awb();
    ((b.a)localObject).hQG = new awc();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getlabsinfo";
    ((b.a)localObject).funcId = 1816;
    localObject = ((b.a)localObject).aDS();
    awb localawb = (awb)((b)localObject).hQD.hQJ;
    Integer localInteger = (Integer)g.ajR().ajA().get(am.a.ITR, null);
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localawb.GNQ = i;
      localawb.GNR = fac();
      localawb.GNS = ((int)bu.aRi());
      if (paramBoolean1) {
        localawb.dEu |= 0x1;
      }
      if (paramBoolean2) {
        localawb.dEu |= 0x2;
      }
      ae.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[] { c(localawb.GNR) });
      x.a((b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(146216);
          e.JG();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ae.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
            e.access$100();
            e.oL(86400);
            e.access$300();
            AppMethodBeat.o(146216);
            return 0;
          }
          paramAnonymousString = (awc)paramAnonymousb.hQE.hQJ;
          e.access$100();
          e.oM(paramAnonymousString.Timestamp);
          e.oL(paramAnonymousString.GNU);
          e.ak(paramAnonymousString.GNV);
          e.al(paramAnonymousString.GNT);
          e.access$300();
          ae.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.GNU) });
          AppMethodBeat.o(146216);
          return 0;
        }
      });
      AppMethodBeat.o(146217);
      return;
    }
  }
  
  private static String c(LinkedList<ahq> paramLinkedList)
  {
    AppMethodBeat.i(146218);
    Iterator localIterator = paramLinkedList.iterator();
    ahq localahq;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localahq.GuP + ":" + localahq.priority + "|") {
      localahq = (ahq)localIterator.next();
    }
    AppMethodBeat.o(146218);
    return paramLinkedList;
  }
  
  private static LinkedList<ahq> fac()
  {
    AppMethodBeat.i(146219);
    localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = a.faa().EQe.fai().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if (!locala.fak())
        {
          ahq localahq = new ahq();
          localahq.GuP = bu.getInt(locala.field_expId, 0);
          localahq.priority = locala.field_prioritylevel;
          localLinkedList.add(localahq);
        }
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WelabUpdater", localException, "", new Object[0]);
      AppMethodBeat.o(146219);
    }
  }
  
  private static void oK(int paramInt)
  {
    AppMethodBeat.i(146221);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.ajR().ajA().set(am.a.ITQ, Integer.valueOf(i));
        AppMethodBeat.o(146221);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e
 * JD-Core Version:    0.7.0.1
 */