package com.tencent.mm.plugin.welab;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class f
{
  private static boolean DEBUG = false;
  private static boolean ahC = false;
  
  private static void IT()
  {
    long l = System.currentTimeMillis() / 1000L;
    g.DP().Dz().c(ac.a.uws, Long.valueOf(l));
  }
  
  private static void IU()
  {
    g.DP().Dz().mC(true);
  }
  
  static void R(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!g.DN().Dc())
    {
      y.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
      return;
    }
    if ((!DEBUG) && (!paramBoolean1) && (!paramBoolean2))
    {
      localObject = (Long)g.DP().Dz().get(ac.a.uws, null);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 != 0L) {
          break label156;
        }
        i = new Random().nextInt(86400);
        hY(i);
        IT();
        IU();
        y.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[] { Integer.valueOf(i) });
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          break label294;
        }
        y.v("MicroMsg.WelabUpdater", "No need to update");
        return;
        l1 = ((Long)localObject).longValue();
        break;
        label156:
        localObject = (Integer)g.DP().Dz().get(ac.a.uwt, null);
        label190:
        long l2;
        long l3;
        if ((localObject == null) || (((Integer)localObject).intValue() == 0))
        {
          i = 86400;
          l2 = i;
          l3 = System.currentTimeMillis() / 1000L;
          if (l3 <= l1 + l2) {
            break label284;
          }
        }
        label284:
        for (boolean bool = true;; bool = false)
        {
          y.i("MicroMsg.WelabUpdater", "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
          if (l3 <= l1 + l2) {
            break label289;
          }
          i = 1;
          break;
          i = ((Integer)localObject).intValue();
          break label190;
        }
        label289:
        i = 0;
      }
    }
    label294:
    if (ahC)
    {
      y.i("MicroMsg.WelabUpdater", "Updating");
      return;
    }
    ahC = true;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aap();
    ((b.a)localObject).ecI = new aaq();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getlabsinfo";
    ((b.a)localObject).ecG = 1816;
    localObject = ((b.a)localObject).Kt();
    aap localaap = (aap)((com.tencent.mm.ah.b)localObject).ecE.ecN;
    Integer localInteger = (Integer)g.DP().Dz().get(ac.a.uwu, null);
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localaap.tak = i;
      localaap.tal = che();
      localaap.tam = ((int)bk.UX());
      if (paramBoolean1) {
        localaap.bcw |= 0x1;
      }
      if (paramBoolean2) {
        localaap.bcw |= 0x2;
      }
      y.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[] { aw(localaap.tal) });
      w.a((com.tencent.mm.ah.b)localObject, new f.1());
      return;
    }
  }
  
  private static String aw(LinkedList<we> paramLinkedList)
  {
    Iterator localIterator = paramLinkedList.iterator();
    we localwe;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localwe.sQD + ":" + localwe.priority + "|") {
      localwe = (we)localIterator.next();
    }
    return paramLinkedList;
  }
  
  private static LinkedList<we> che()
  {
    localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = b.chc().rEr.chl().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.c.a.a locala = (com.tencent.mm.plugin.welab.c.a.a)localIterator.next();
        we localwe = new we();
        localwe.sQD = bk.getInt(locala.field_expId, 0);
        localwe.priority = locala.field_prioritylevel;
        localLinkedList.add(localwe);
      }
      return localLinkedList;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WelabUpdater", localException, "", new Object[0]);
    }
  }
  
  private static void hY(int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.DP().Dz().c(ac.a.uwt, Integer.valueOf(i));
        return;
      } while ((paramInt >= 3600) && (paramInt <= 129600));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.f
 * JD-Core Version:    0.7.0.1
 */