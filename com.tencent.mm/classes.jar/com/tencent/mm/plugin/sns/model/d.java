package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.protobuf.anj;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.ero;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static long Qy(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
  
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    if (paramLong1 == 0L)
    {
      Log.e("MicroMsg.FaultLogic", "minId == 0.");
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = aj.fOM().bbp(paramString);
    Object localObject = paramString.SXE;
    Log.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.SXE.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (anj)((LinkedList)localObject).getFirst();
    if (aB(paramString.SxC, paramLong1) > 0L)
    {
      Log.e("MicroMsg.FaultLogic", "has a fault，minId:" + paramLong2 + " fault.min:" + paramString.SxC);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (aB(paramString.SxB, paramLong2) < 0L))
    {
      Log.e("MicroMsg.FaultLogic", "has part of a fault, maxId:" + paramLong2 + " fault.max:" + paramString.SxB);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.SxD;
    Log.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId segmentList %s", new Object[] { Integer.valueOf(paramString.size()) });
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (ero)paramString.next();
      if ((paramLong2 == 0L) || (aB(paramLong2, ((ero)localObject).UtE) >= 0L))
      {
        int j = i;
        if (((ero)localObject).UtF < i) {
          j = ((ero)localObject).UtF;
        }
        i = j;
        if (aB(paramLong1, ((ero)localObject).UtE) >= 0L)
        {
          Log.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId result %s", new Object[] { Integer.valueOf(j) });
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
    Log.i("MicroMsg.FaultLogic", "should not to hear minId:".concat(String.valueOf(paramLong1)));
    AppMethodBeat.o(95454);
    return 0;
  }
  
  private static anj a(anj paramanj1, anj paramanj2)
  {
    AppMethodBeat.i(95453);
    anj localanj = new anj();
    if (aB(paramanj1.SxB, paramanj2.SxB) > 0L)
    {
      localanj.SxB = paramanj1.SxB;
      if (aB(paramanj1.SxC, paramanj2.SxC) >= 0L) {
        break label132;
      }
      localanj.SxC = paramanj1.SxC;
      label64:
      paramanj1 = paramanj1.SxD;
      paramanj2 = paramanj2.SxD.iterator();
    }
    for (;;)
    {
      if (!paramanj2.hasNext()) {
        break label639;
      }
      ero localero1 = (ero)paramanj2.next();
      if (paramanj1.isEmpty())
      {
        Log.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramanj1.addFirst(localero1);
        continue;
        localanj.SxB = paramanj2.SxB;
        break;
        label132:
        localanj.SxC = paramanj2.SxC;
        break label64;
      }
      long l1 = localero1.UtE;
      int i = paramanj1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (aB(l1, ((ero)paramanj1.get(i)).UtD) <= 0L)
        {
          l1 = localero1.UtD;
          j = 0;
          label192:
          if (j >= paramanj1.size()) {
            break label254;
          }
          if (aB(l1, ((ero)paramanj1.get(j)).UtE) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramanj1.addFirst(localero1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramanj1.size();
      }
      label262:
      if (j == paramanj1.size())
      {
        paramanj1.addLast(localero1);
      }
      else
      {
        ero localero2 = (ero)paramanj1.get(j);
        int k = i;
        int m = j;
        ero localero3;
        if (aB(localero1.UtD, localero2.UtD) < 0L)
        {
          localero3 = new ero();
          localero3.UtD = localero2.UtD;
          l1 = localero1.UtD;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localero3.UtE = l1;
          localero3.UtF = localero2.UtF;
          paramanj1.add(j, localero3);
          k = i + 1;
          m = j + 1;
          localero2 = (ero)paramanj1.get(k);
          i = k;
          if (aB(localero1.UtE, localero2.UtE) > 0L)
          {
            localero3 = new ero();
            localero3.UtE = localero2.UtE;
            localero3.UtD = Qy(localero1.UtE);
            localero3.UtF = localero2.UtF;
            paramanj1.add(k + 1, localero3);
            i = k;
          }
          while (i >= m)
          {
            paramanj1.remove(i);
            i -= 1;
          }
        }
        paramanj1.add(m, localero1);
        if (paramanj1.size() > 100)
        {
          long l2 = ((ero)paramanj1.getLast()).UtE;
          l1 = ((ero)paramanj1.getLast()).UtD;
          for (i = ((ero)paramanj1.getLast()).UtF; paramanj1.size() >= 100; i = j)
          {
            localero1 = (ero)paramanj1.removeLast();
            l1 = localero1.UtD;
            j = i;
            if (localero1.UtF < i) {
              j = localero1.UtF;
            }
          }
          localero1 = new ero();
          localero1.UtD = l1;
          localero1.UtE = l2;
          localero1.UtF = i;
          paramanj1.addLast(localero1);
        }
      }
    }
    label639:
    localanj.SxD = paramanj1;
    AppMethodBeat.o(95453);
    return localanj;
  }
  
  private static long aB(long paramLong1, long paramLong2)
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
    Object localObject1 = aj.fOM().bbp(paramString);
    if (localObject1 == null) {
      localObject1 = new bmt();
    }
    for (;;)
    {
      long l = paramLong1;
      if (paramLong1 == 0L)
      {
        if (((bmt)localObject1).SXE.isEmpty())
        {
          AppMethodBeat.o(95452);
          return;
        }
        l = ((anj)((bmt)localObject1).SXE.getFirst()).SxB;
      }
      Object localObject2 = new anj();
      ((anj)localObject2).SxB = l;
      ((anj)localObject2).SxC = paramLong2;
      Object localObject3 = new ero();
      ((ero)localObject3).UtD = l;
      ((ero)localObject3).UtE = paramLong2;
      ((ero)localObject3).UtF = paramInt;
      ((anj)localObject2).SxD.add(localObject3);
      for (;;)
      {
        if (!((bmt)localObject1).SXE.isEmpty())
        {
          localObject3 = (anj)((bmt)localObject1).SXE.getFirst();
          if (aB(((anj)localObject2).SxC, ((anj)localObject3).SxB) > 0L) {
            Log.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((anj)localObject2).SxC + " fault.Max" + ((anj)localObject3).SxB);
          }
        }
        else
        {
          ((bmt)localObject1).SXE.addFirst(localObject2);
          while (((bmt)localObject1).SXE.size() > 100) {
            ((bmt)localObject1).SXE.removeLast();
          }
        }
        ((bmt)localObject1).SXE.removeFirst();
        localObject2 = a((anj)localObject3, (anj)localObject2);
      }
      if (((bmt)localObject1).SXE.size() > 0) {
        Log.d("MicroMsg.FaultLogic", "min " + ((anj)((bmt)localObject1).SXE.get(0)).SxC + " max " + ((anj)((bmt)localObject1).SXE.get(0)).SxB);
      }
      localObject2 = aj.fOM().bbr(paramString);
      try
      {
        ((l)localObject2).field_userName = paramString;
        ((l)localObject2).field_faultS = ((bmt)localObject1).toByteArray();
        aj.fOM().c((l)localObject2);
        label383:
        if (((bmt)localObject1).SXE.size() > 1)
        {
          Log.d("MicroMsg.FaultLogic", "fault size : " + ((bmt)localObject1).SXE.size());
          paramString = ((bmt)localObject1).SXE.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (anj)paramString.next();
            Log.d("MicroMsg.FaultLogic", "min - max " + ((anj)localObject1).SxC + " " + ((anj)localObject1).SxB);
          }
        }
        AppMethodBeat.o(95452);
        return;
      }
      catch (Exception paramString)
      {
        break label383;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d
 * JD-Core Version:    0.7.0.1
 */