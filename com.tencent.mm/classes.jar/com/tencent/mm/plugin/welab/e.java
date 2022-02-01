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
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.arq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e
{
  private static boolean DEBUG = false;
  private static boolean eg = false;
  
  private static void aAj()
  {
    AppMethodBeat.i(146220);
    long l = System.currentTimeMillis() / 1000L;
    g.agR().agA().set(ah.a.GMZ, Long.valueOf(l));
    AppMethodBeat.o(146220);
  }
  
  private static void aAl()
  {
    AppMethodBeat.i(146222);
    g.agR().agA().faa();
    AppMethodBeat.o(146222);
  }
  
  static void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146217);
    ac.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!g.agP().afY())
    {
      ac.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(146217);
      return;
    }
    if ((!DEBUG) && (!paramBoolean1) && (!paramBoolean2))
    {
      localObject = (Long)g.agR().agA().get(ah.a.GMZ, null);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 != 0L) {
          break label169;
        }
        i = new Random().nextInt(86400);
        oh(i);
        aAj();
        aAl();
        ac.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label306;
        }
        ac.v("MicroMsg.WelabUpdater", "No need to update");
        AppMethodBeat.o(146217);
        return;
        l1 = ((Long)localObject).longValue();
        break;
        label169:
        localObject = (Integer)g.agR().agA().get(ah.a.GNa, null);
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
          ac.i("MicroMsg.WelabUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
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
    if (eg)
    {
      ac.i("MicroMsg.WelabUpdater", "Updating");
      AppMethodBeat.o(146217);
      return;
    }
    eg = true;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new arp();
    ((b.a)localObject).hvu = new arq();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getlabsinfo";
    ((b.a)localObject).funcId = 1816;
    localObject = ((b.a)localObject).aAz();
    arp localarp = (arp)((b)localObject).hvr.hvw;
    Integer localInteger = (Integer)g.agR().agA().get(ah.a.GNb, null);
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localarp.ELo = i;
      localarp.ELp = eHx();
      localarp.ELq = ((int)bs.aNx());
      if (paramBoolean1) {
        localarp.drx |= 0x1;
      }
      if (paramBoolean2) {
        localarp.drx |= 0x2;
      }
      ac.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[] { c(localarp.ELp) });
      x.a((b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(146216);
          e.adZ();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ac.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
            e.access$100();
            e.oi(86400);
            e.access$300();
            AppMethodBeat.o(146216);
            return 0;
          }
          paramAnonymousString = (arq)paramAnonymousb.hvs.hvw;
          e.access$100();
          e.oj(paramAnonymousString.Timestamp);
          e.oi(paramAnonymousString.ELs);
          e.aj(paramAnonymousString.ELt);
          e.ak(paramAnonymousString.ELr);
          e.access$300();
          ac.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.ELs) });
          AppMethodBeat.o(146216);
          return 0;
        }
      });
      AppMethodBeat.o(146217);
      return;
    }
  }
  
  private static String c(LinkedList<aex> paramLinkedList)
  {
    AppMethodBeat.i(146218);
    Iterator localIterator = paramLinkedList.iterator();
    aex localaex;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localaex.EuO + ":" + localaex.priority + "|") {
      localaex = (aex)localIterator.next();
    }
    AppMethodBeat.o(146218);
    return paramLinkedList;
  }
  
  private static LinkedList<aex> eHx()
  {
    AppMethodBeat.i(146219);
    localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = a.eHv().CTI.eHD().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if (!locala.eHF())
        {
          aex localaex = new aex();
          localaex.EuO = bs.getInt(locala.field_expId, 0);
          localaex.priority = locala.field_prioritylevel;
          localLinkedList.add(localaex);
        }
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WelabUpdater", localException, "", new Object[0]);
      AppMethodBeat.o(146219);
    }
  }
  
  private static void oh(int paramInt)
  {
    AppMethodBeat.i(146221);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.agR().agA().set(ah.a.GNa, Integer.valueOf(i));
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