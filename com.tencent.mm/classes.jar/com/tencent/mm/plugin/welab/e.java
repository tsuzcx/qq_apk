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
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class e
{
  private static boolean DEBUG = false;
  private static boolean arf = false;
  
  static void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(146217);
    ad.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (!g.afz().aeI())
    {
      ad.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
      AppMethodBeat.o(146217);
      return;
    }
    if ((!DEBUG) && (!paramBoolean1) && (!paramBoolean2))
    {
      localObject = (Long)g.afB().afk().get(ae.a.Fpj, null);
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        if (l1 != 0L) {
          break label169;
        }
        i = new Random().nextInt(86400);
        nt(i);
        ats();
        atu();
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
        localObject = (Integer)g.afB().afk().get(ae.a.Fpk, null);
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
    if (arf)
    {
      ad.i("MicroMsg.WelabUpdater", "Updating");
      AppMethodBeat.o(146217);
      return;
    }
    arf = true;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aol();
    ((b.a)localObject).gUV = new aom();
    ((b.a)localObject).uri = "/cgi-bin/mmux-bin/getlabsinfo";
    ((b.a)localObject).funcId = 1816;
    localObject = ((b.a)localObject).atI();
    aol localaol = (aol)((b)localObject).gUS.gUX;
    Integer localInteger = (Integer)g.afB().afk().get(ae.a.Fpl, null);
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      localaol.Dqm = i;
      localaol.Dqn = esd();
      localaol.Dqo = ((int)bt.aGK());
      if (paramBoolean1) {
        localaol.dtM |= 0x1;
      }
      if (paramBoolean2) {
        localaol.dtM |= 0x2;
      }
      ad.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[] { c(localaol.Dqn) });
      x.a((b)localObject, new x.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, n paramAnonymousn)
        {
          AppMethodBeat.i(146216);
          e.acT();
          if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
          {
            ad.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(86400) });
            e.access$100();
            e.nu(86400);
            e.access$300();
            AppMethodBeat.o(146216);
            return 0;
          }
          paramAnonymousString = (aom)paramAnonymousb.gUT.gUX;
          e.access$100();
          e.nv(paramAnonymousString.Timestamp);
          e.nu(paramAnonymousString.Dqq);
          e.am(paramAnonymousString.Dqr);
          e.an(paramAnonymousString.Dqp);
          e.access$300();
          ad.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramAnonymousString.Dqq) });
          AppMethodBeat.o(146216);
          return 0;
        }
      });
      AppMethodBeat.o(146217);
      return;
    }
  }
  
  private static void ats()
  {
    AppMethodBeat.i(146220);
    long l = System.currentTimeMillis() / 1000L;
    g.afB().afk().set(ae.a.Fpj, Long.valueOf(l));
    AppMethodBeat.o(146220);
  }
  
  private static void atu()
  {
    AppMethodBeat.i(146222);
    g.afB().afk().eKy();
    AppMethodBeat.o(146222);
  }
  
  private static String c(LinkedList<ady> paramLinkedList)
  {
    AppMethodBeat.i(146218);
    Iterator localIterator = paramLinkedList.iterator();
    ady localady;
    for (paramLinkedList = ""; localIterator.hasNext(); paramLinkedList = paramLinkedList + localady.DbI + ":" + localady.priority + "|") {
      localady = (ady)localIterator.next();
    }
    AppMethodBeat.o(146218);
    return paramLinkedList;
  }
  
  private static LinkedList<ady> esd()
  {
    AppMethodBeat.i(146219);
    localLinkedList = new LinkedList();
    try
    {
      Iterator localIterator = a.esb().BBC.esj().iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.welab.d.a.a locala = (com.tencent.mm.plugin.welab.d.a.a)localIterator.next();
        if (!locala.esm())
        {
          ady localady = new ady();
          localady.DbI = bt.getInt(locala.field_expId, 0);
          localady.priority = locala.field_prioritylevel;
          localLinkedList.add(localady);
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
  
  private static void nt(int paramInt)
  {
    AppMethodBeat.i(146221);
    int i = 0;
    if (paramInt == 0) {}
    for (i = 86400;; i = new Random().nextInt(126000) + 3600) {
      do
      {
        g.afB().afk().set(ae.a.Fpk, Integer.valueOf(i));
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