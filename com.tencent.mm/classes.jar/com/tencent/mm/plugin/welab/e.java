package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ahg;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e
{
  private static boolean DEBUG = false;
  private static boolean ga = false;
  
  private static void aDm()
  {
    AppMethodBeat.i(146220);
    long l = System.currentTimeMillis() / 1000L;
    g.ajC().ajl().set(al.a.Izq, Long.valueOf(l));
    AppMethodBeat.o(146220);
  }
  
  private static void aDo()
  {
    AppMethodBeat.i(146222);
    g.ajC().ajl().fqc();
    AppMethodBeat.o(146222);
  }
  
  static void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146217);
    ad.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!g.ajA().aiK())
    {
      ad.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(146217);
      return;
    }
    if ((!DEBUG) && (!paramBoolean1) && (!paramBoolean2))
    {
      localObject = (Long)g.ajC().ajl().get(al.a.Izq, null);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 != 0L) {
          break label169;
        }
        i = new Random().nextInt(86400);
        oH(i);
        aDm();
        aDo();
        ad.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label306;
        }
        ad.v("MicroMsg.WelabUpdater", "No need to update");
        AppMethodBeat.o(146217);
        return;
        l1 = ((Long)localObject).longValue();
        break;
        label169:
        localObject = (Integer)g.ajC().ajl().get(al.a.Izr, null);
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
          ad.i("MicroMsg.WelabUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
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
      ad.i("MicroMsg.WelabUpdater", "Updating");
      AppMethodBeat.o(146217);
      return;
    }
    ga = true;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new avl();
    ((b.a)localObject).hNN = new avm();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getlabsinfo";
    ((b.a)localObject).funcId = 1816;
    localObject = ((b.a)localObject).aDC();
    avl localavl = (avl)((b)localObject).hNK.hNQ;
    Integer localInteger = (Integer)g.ajC().ajl().get(al.a.Izs, null);
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localavl.Gur = i;
      localavl.Gus = eWq();
      localavl.Gut = ((int)bt.aQJ());
      if (paramBoolean1) {
        localavl.dDp |= 0x1;
      }
      if (paramBoolean2) {
        localavl.dDp |= 0x2;
      }
      ad.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[] { c(localavl.Gus) });
      x.a((b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(146216);
          e.Jy();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
            e.access$100();
            e.oI(86400);
            e.access$300();
            AppMethodBeat.o(146216);
            return 0;
          }
          paramAnonymousString = (avm)paramAnonymousb.hNL.hNQ;
          e.access$100();
          e.oJ(paramAnonymousString.Timestamp);
          e.oI(paramAnonymousString.Guv);
          e.ak(paramAnonymousString.Guw);
          e.al(paramAnonymousString.Guu);
          e.access$300();
          ad.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.Guv) });
          AppMethodBeat.o(146216);
          return 0;
        }
      });
      AppMethodBeat.o(146217);
      return;
    }
  }
  
  private static String c(LinkedList<ahg> paramLinkedList)
  {
    AppMethodBeat.i(146218);
    Iterator localIterator = paramLinkedList.iterator();
    ahg localahg;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localahg.Gci + ":" + localahg.priority + "|") {
      localahg = (ahg)localIterator.next();
    }
    AppMethodBeat.o(146218);
    return paramLinkedList;
  }
  
  private static LinkedList<ahg> eWq()
  {
    AppMethodBeat.i(146219);
    localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = a.eWo().ExI.eWw().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if (!locala.eWy())
        {
          ahg localahg = new ahg();
          localahg.Gci = bt.getInt(locala.field_expId, 0);
          localahg.priority = locala.field_prioritylevel;
          localLinkedList.add(localahg);
        }
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WelabUpdater", localException, "", new Object[0]);
      AppMethodBeat.o(146219);
    }
  }
  
  private static void oH(int paramInt)
  {
    AppMethodBeat.i(146221);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.ajC().ajl().set(al.a.Izr, Integer.valueOf(i));
        AppMethodBeat.o(146221);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e
 * JD-Core Version:    0.7.0.1
 */