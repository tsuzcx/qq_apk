package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.auk;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    paramString = ah.dXI().aBu(paramString);
    Object localObject = paramString.GLm;
    ae.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.GLm.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (aju)((LinkedList)localObject).getFirst();
    if ((paramLong1 == 0L) || (ak(paramString.Gzo, paramLong1) > 0L))
    {
      ae.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.Gzo);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (ak(paramString.Gzn, paramLong2) < 0L))
    {
      ae.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.Gzn);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.Gzp;
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (dnr)paramString.next();
      if ((paramLong2 == 0L) || (ak(paramLong2, ((dnr)localObject).HUP) >= 0L))
      {
        int j = i;
        if (((dnr)localObject).HUQ < i) {
          j = ((dnr)localObject).HUQ;
        }
        i = j;
        if (ak(paramLong1, ((dnr)localObject).HUP) >= 0L)
        {
          if (j == 2147483647)
          {
            AppMethodBeat.o(95454);
            return 0;
          }
          AppMethodBeat.o(95454);
          return j;
        }
      }
    }
    ae.i("MicroMsg.FaultLogic", "should not to hear  minId:".concat(String.valueOf(paramLong1)));
    AppMethodBeat.o(95454);
    return 0;
  }
  
  private static aju a(aju paramaju1, aju paramaju2)
  {
    AppMethodBeat.i(95453);
    aju localaju = new aju();
    if (ak(paramaju1.Gzn, paramaju2.Gzn) > 0L)
    {
      localaju.Gzn = paramaju1.Gzn;
      if (ak(paramaju1.Gzo, paramaju2.Gzo) >= 0L) {
        break label132;
      }
      localaju.Gzo = paramaju1.Gzo;
      label64:
      paramaju1 = paramaju1.Gzp;
      paramaju2 = paramaju2.Gzp.iterator();
    }
    for (;;)
    {
      if (!paramaju2.hasNext()) {
        break label639;
      }
      dnr localdnr1 = (dnr)paramaju2.next();
      if (paramaju1.isEmpty())
      {
        ae.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramaju1.addFirst(localdnr1);
        continue;
        localaju.Gzn = paramaju2.Gzn;
        break;
        label132:
        localaju.Gzo = paramaju2.Gzo;
        break label64;
      }
      long l1 = localdnr1.HUP;
      int i = paramaju1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (ak(l1, ((dnr)paramaju1.get(i)).HUO) <= 0L)
        {
          l1 = localdnr1.HUO;
          j = 0;
          label192:
          if (j >= paramaju1.size()) {
            break label254;
          }
          if (ak(l1, ((dnr)paramaju1.get(j)).HUP) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramaju1.addFirst(localdnr1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramaju1.size();
      }
      label262:
      if (j == paramaju1.size())
      {
        paramaju1.addLast(localdnr1);
      }
      else
      {
        dnr localdnr2 = (dnr)paramaju1.get(j);
        int k = i;
        int m = j;
        dnr localdnr3;
        if (ak(localdnr1.HUO, localdnr2.HUO) < 0L)
        {
          localdnr3 = new dnr();
          localdnr3.HUO = localdnr2.HUO;
          l1 = localdnr1.HUO;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localdnr3.HUP = l1;
          localdnr3.HUQ = localdnr2.HUQ;
          paramaju1.add(j, localdnr3);
          k = i + 1;
          m = j + 1;
          localdnr2 = (dnr)paramaju1.get(k);
          i = k;
          if (ak(localdnr1.HUP, localdnr2.HUP) > 0L)
          {
            localdnr3 = new dnr();
            localdnr3.HUP = localdnr2.HUP;
            localdnr3.HUO = zZ(localdnr1.HUP);
            localdnr3.HUQ = localdnr2.HUQ;
            paramaju1.add(k + 1, localdnr3);
            i = k;
          }
          while (i >= m)
          {
            paramaju1.remove(i);
            i -= 1;
          }
        }
        paramaju1.add(m, localdnr1);
        if (paramaju1.size() > 100)
        {
          long l2 = ((dnr)paramaju1.getLast()).HUP;
          l1 = ((dnr)paramaju1.getLast()).HUO;
          for (i = ((dnr)paramaju1.getLast()).HUQ; paramaju1.size() >= 100; i = j)
          {
            localdnr1 = (dnr)paramaju1.removeLast();
            l1 = localdnr1.HUO;
            j = i;
            if (localdnr1.HUQ < i) {
              j = localdnr1.HUQ;
            }
          }
          localdnr1 = new dnr();
          localdnr1.HUO = l1;
          localdnr1.HUP = l2;
          localdnr1.HUQ = i;
          paramaju1.addLast(localdnr1);
        }
      }
    }
    label639:
    localaju.Gzp = paramaju1;
    AppMethodBeat.o(95453);
    return localaju;
  }
  
  private static long ak(long paramLong1, long paramLong2)
  {
    if (((paramLong1 > 0L) && (paramLong2 > 0L)) || ((paramLong1 < 0L) && (paramLong2 < 0L))) {
      return paramLong1 - paramLong2;
    }
    if (paramLong1 < 0L) {
      return 1L;
    }
    return -1L;
  }
  
  public static void f(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(95452);
    if (paramLong2 == 0L)
    {
      AppMethodBeat.o(95452);
      return;
    }
    Object localObject1 = ah.dXI().aBu(paramString);
    if (localObject1 == null) {
      localObject1 = new auk();
    }
    for (;;)
    {
      if ((paramLong1 == 0L) && (((auk)localObject1).GLm.isEmpty()))
      {
        AppMethodBeat.o(95452);
        return;
      }
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = ((aju)((auk)localObject1).GLm.getFirst()).Gzn;
      }
      Object localObject2 = new aju();
      ((aju)localObject2).Gzn = l;
      ((aju)localObject2).Gzo = paramLong2;
      Object localObject3 = new dnr();
      ((dnr)localObject3).HUO = l;
      ((dnr)localObject3).HUP = paramLong2;
      ((dnr)localObject3).HUQ = paramInt;
      ((aju)localObject2).Gzp.add(localObject3);
      for (;;)
      {
        if (!((auk)localObject1).GLm.isEmpty())
        {
          localObject3 = (aju)((auk)localObject1).GLm.getFirst();
          if (ak(((aju)localObject2).Gzo, ((aju)localObject3).Gzn) > 0L) {
            ae.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((aju)localObject2).Gzo + " fault.Max" + ((aju)localObject3).Gzn);
          }
        }
        else
        {
          ((auk)localObject1).GLm.addFirst(localObject2);
          while (((auk)localObject1).GLm.size() > 100) {
            ((auk)localObject1).GLm.removeLast();
          }
        }
        ((auk)localObject1).GLm.removeFirst();
        localObject2 = a((aju)localObject3, (aju)localObject2);
      }
      if (((auk)localObject1).GLm.size() > 0) {
        ae.d("MicroMsg.FaultLogic", "min " + ((aju)((auk)localObject1).GLm.get(0)).Gzo + " max " + ((aju)((auk)localObject1).GLm.get(0)).Gzn);
      }
      localObject2 = ah.dXI().aBw(paramString);
      try
      {
        ((n)localObject2).field_userName = paramString;
        ((n)localObject2).field_faultS = ((auk)localObject1).toByteArray();
        ah.dXI().c((n)localObject2);
        label389:
        if (((auk)localObject1).GLm.size() > 1)
        {
          ae.d("MicroMsg.FaultLogic", "fault size : " + ((auk)localObject1).GLm.size());
          paramString = ((auk)localObject1).GLm.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (aju)paramString.next();
            ae.d("MicroMsg.FaultLogic", "min - max " + ((aju)localObject1).Gzo + " " + ((aju)localObject1).Gzn);
          }
        }
        AppMethodBeat.o(95452);
        return;
      }
      catch (Exception paramString)
      {
        break label389;
      }
    }
  }
  
  public static long zZ(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d
 * JD-Core Version:    0.7.0.1
 */