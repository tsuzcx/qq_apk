package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.atu;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    paramString = ag.dUi().aAd(paramString);
    Object localObject = paramString.GrO;
    ad.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.GrO.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (ajk)((LinkedList)localObject).getFirst();
    if ((paramLong1 == 0L) || (al(paramString.GgF, paramLong1) > 0L))
    {
      ad.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.GgF);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (al(paramString.GgE, paramLong2) < 0L))
    {
      ad.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.GgE);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.GgG;
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (dmu)paramString.next();
      if ((paramLong2 == 0L) || (al(paramLong2, ((dmu)localObject).HBc) >= 0L))
      {
        int j = i;
        if (((dmu)localObject).HBd < i) {
          j = ((dmu)localObject).HBd;
        }
        i = j;
        if (al(paramLong1, ((dmu)localObject).HBc) >= 0L)
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
    ad.i("MicroMsg.FaultLogic", "should not to hear  minId:".concat(String.valueOf(paramLong1)));
    AppMethodBeat.o(95454);
    return 0;
  }
  
  private static ajk a(ajk paramajk1, ajk paramajk2)
  {
    AppMethodBeat.i(95453);
    ajk localajk = new ajk();
    if (al(paramajk1.GgE, paramajk2.GgE) > 0L)
    {
      localajk.GgE = paramajk1.GgE;
      if (al(paramajk1.GgF, paramajk2.GgF) >= 0L) {
        break label132;
      }
      localajk.GgF = paramajk1.GgF;
      label64:
      paramajk1 = paramajk1.GgG;
      paramajk2 = paramajk2.GgG.iterator();
    }
    for (;;)
    {
      if (!paramajk2.hasNext()) {
        break label639;
      }
      dmu localdmu1 = (dmu)paramajk2.next();
      if (paramajk1.isEmpty())
      {
        ad.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramajk1.addFirst(localdmu1);
        continue;
        localajk.GgE = paramajk2.GgE;
        break;
        label132:
        localajk.GgF = paramajk2.GgF;
        break label64;
      }
      long l1 = localdmu1.HBc;
      int i = paramajk1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (al(l1, ((dmu)paramajk1.get(i)).HBb) <= 0L)
        {
          l1 = localdmu1.HBb;
          j = 0;
          label192:
          if (j >= paramajk1.size()) {
            break label254;
          }
          if (al(l1, ((dmu)paramajk1.get(j)).HBc) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramajk1.addFirst(localdmu1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramajk1.size();
      }
      label262:
      if (j == paramajk1.size())
      {
        paramajk1.addLast(localdmu1);
      }
      else
      {
        dmu localdmu2 = (dmu)paramajk1.get(j);
        int k = i;
        int m = j;
        dmu localdmu3;
        if (al(localdmu1.HBb, localdmu2.HBb) < 0L)
        {
          localdmu3 = new dmu();
          localdmu3.HBb = localdmu2.HBb;
          l1 = localdmu1.HBb;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localdmu3.HBc = l1;
          localdmu3.HBd = localdmu2.HBd;
          paramajk1.add(j, localdmu3);
          k = i + 1;
          m = j + 1;
          localdmu2 = (dmu)paramajk1.get(k);
          i = k;
          if (al(localdmu1.HBc, localdmu2.HBc) > 0L)
          {
            localdmu3 = new dmu();
            localdmu3.HBc = localdmu2.HBc;
            localdmu3.HBb = zB(localdmu1.HBc);
            localdmu3.HBd = localdmu2.HBd;
            paramajk1.add(k + 1, localdmu3);
            i = k;
          }
          while (i >= m)
          {
            paramajk1.remove(i);
            i -= 1;
          }
        }
        paramajk1.add(m, localdmu1);
        if (paramajk1.size() > 100)
        {
          long l2 = ((dmu)paramajk1.getLast()).HBc;
          l1 = ((dmu)paramajk1.getLast()).HBb;
          for (i = ((dmu)paramajk1.getLast()).HBd; paramajk1.size() >= 100; i = j)
          {
            localdmu1 = (dmu)paramajk1.removeLast();
            l1 = localdmu1.HBb;
            j = i;
            if (localdmu1.HBd < i) {
              j = localdmu1.HBd;
            }
          }
          localdmu1 = new dmu();
          localdmu1.HBb = l1;
          localdmu1.HBc = l2;
          localdmu1.HBd = i;
          paramajk1.addLast(localdmu1);
        }
      }
    }
    label639:
    localajk.GgG = paramajk1;
    AppMethodBeat.o(95453);
    return localajk;
  }
  
  private static long al(long paramLong1, long paramLong2)
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
    Object localObject1 = ag.dUi().aAd(paramString);
    if (localObject1 == null) {
      localObject1 = new atu();
    }
    for (;;)
    {
      if ((paramLong1 == 0L) && (((atu)localObject1).GrO.isEmpty()))
      {
        AppMethodBeat.o(95452);
        return;
      }
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = ((ajk)((atu)localObject1).GrO.getFirst()).GgE;
      }
      Object localObject2 = new ajk();
      ((ajk)localObject2).GgE = l;
      ((ajk)localObject2).GgF = paramLong2;
      Object localObject3 = new dmu();
      ((dmu)localObject3).HBb = l;
      ((dmu)localObject3).HBc = paramLong2;
      ((dmu)localObject3).HBd = paramInt;
      ((ajk)localObject2).GgG.add(localObject3);
      for (;;)
      {
        if (!((atu)localObject1).GrO.isEmpty())
        {
          localObject3 = (ajk)((atu)localObject1).GrO.getFirst();
          if (al(((ajk)localObject2).GgF, ((ajk)localObject3).GgE) > 0L) {
            ad.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((ajk)localObject2).GgF + " fault.Max" + ((ajk)localObject3).GgE);
          }
        }
        else
        {
          ((atu)localObject1).GrO.addFirst(localObject2);
          while (((atu)localObject1).GrO.size() > 100) {
            ((atu)localObject1).GrO.removeLast();
          }
        }
        ((atu)localObject1).GrO.removeFirst();
        localObject2 = a((ajk)localObject3, (ajk)localObject2);
      }
      if (((atu)localObject1).GrO.size() > 0) {
        ad.d("MicroMsg.FaultLogic", "min " + ((ajk)((atu)localObject1).GrO.get(0)).GgF + " max " + ((ajk)((atu)localObject1).GrO.get(0)).GgE);
      }
      localObject2 = ag.dUi().aAf(paramString);
      try
      {
        ((n)localObject2).field_userName = paramString;
        ((n)localObject2).field_faultS = ((atu)localObject1).toByteArray();
        ag.dUi().c((n)localObject2);
        label389:
        if (((atu)localObject1).GrO.size() > 1)
        {
          ad.d("MicroMsg.FaultLogic", "fault size : " + ((atu)localObject1).GrO.size());
          paramString = ((atu)localObject1).GrO.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (ajk)paramString.next();
            ad.d("MicroMsg.FaultLogic", "min - max " + ((ajk)localObject1).GgF + " " + ((ajk)localObject1).GgE);
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
  
  public static long zB(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */