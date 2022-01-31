package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e
{
  private static boolean DEBUG = false;
  private static boolean ajS = false;
  
  static void ab(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(80544);
    ab.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!g.RJ().QU())
    {
      ab.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(80544);
      return;
    }
    if ((!DEBUG) && (!paramBoolean1) && (!paramBoolean2))
    {
      localObject = (Long)g.RL().Ru().get(ac.a.yGA, null);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 != 0L) {
          break label169;
        }
        i = new Random().nextInt(86400);
        kL(i);
        abQ();
        abS();
        ab.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label307;
        }
        ab.v("MicroMsg.WelabUpdater", "No need to update");
        AppMethodBeat.o(80544);
        return;
        l1 = ((Long)localObject).longValue();
        break;
        label169:
        localObject = (Integer)g.RL().Ru().get(ac.a.yGB, null);
        label203:
        long l2;
        long l3;
        if ((localObject == null) || (((Integer)localObject).intValue() == 0))
        {
          i = 86400;
          l2 = i;
          l3 = System.currentTimeMillis() / 1000L;
          if (l3 <= l1 + l2) {
            break label297;
          }
        }
        label297:
        for (boolean bool = true;; bool = false)
        {
          ab.i("MicroMsg.WelabUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
          if (l3 <= l1 + l2) {
            break label302;
          }
          i = 1;
          break;
          i = ((Integer)localObject).intValue();
          break label203;
        }
        label302:
        i = 0;
      }
    }
    label307:
    if (ajS)
    {
      ab.i("MicroMsg.WelabUpdater", "Updating");
      AppMethodBeat.o(80544);
      return;
    }
    ajS = true;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afh();
    ((b.a)localObject).fsY = new afi();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getlabsinfo";
    ((b.a)localObject).funcId = 1816;
    localObject = ((b.a)localObject).ado();
    afh localafh = (afh)((b)localObject).fsV.fta;
    Integer localInteger = (Integer)g.RL().Ru().get(ac.a.yGC, null);
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localafh.wYB = i;
      localafh.wYC = dhn();
      localafh.wYD = ((int)bo.aox());
      if (paramBoolean1) {
        localafh.bsY |= 0x1;
      }
      if (paramBoolean2) {
        localafh.bsY |= 0x2;
      }
      ab.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[] { c(localafh.wYC) });
      w.a((b)localObject, new e.1());
      AppMethodBeat.o(80544);
      return;
    }
  }
  
  private static void abQ()
  {
    AppMethodBeat.i(80547);
    long l = System.currentTimeMillis() / 1000L;
    g.RL().Ru().set(ac.a.yGA, Long.valueOf(l));
    AppMethodBeat.o(80547);
  }
  
  private static void abS()
  {
    AppMethodBeat.i(80549);
    g.RL().Ru().dww();
    AppMethodBeat.o(80549);
  }
  
  private static String c(LinkedList<aaj> paramLinkedList)
  {
    AppMethodBeat.i(80545);
    Iterator localIterator = paramLinkedList.iterator();
    aaj localaaj;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localaaj.wPe + ":" + localaaj.priority + "|") {
      localaaj = (aaj)localIterator.next();
    }
    AppMethodBeat.o(80545);
    return paramLinkedList;
  }
  
  private static LinkedList<aaj> dhn()
  {
    AppMethodBeat.i(80546);
    localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = a.dhl().vuT.dht().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if (!locala.dhx())
        {
          aaj localaaj = new aaj();
          localaaj.wPe = bo.getInt(locala.field_expId, 0);
          localaaj.priority = locala.field_prioritylevel;
          localLinkedList.add(localaaj);
        }
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WelabUpdater", localException, "", new Object[0]);
      AppMethodBeat.o(80546);
    }
  }
  
  private static void kL(int paramInt)
  {
    AppMethodBeat.i(80548);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.RL().Ru().set(ac.a.yGB, Integer.valueOf(i));
        AppMethodBeat.o(80548);
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e
 * JD-Core Version:    0.7.0.1
 */