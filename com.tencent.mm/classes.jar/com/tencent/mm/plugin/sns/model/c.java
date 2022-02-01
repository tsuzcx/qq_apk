package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    paramString = af.dty().apN(paramString);
    Object localObject = paramString.DnX;
    ad.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.DnX.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (afv)((LinkedList)localObject).getFirst();
    if ((paramLong1 == 0L) || (al(paramString.DfN, paramLong1) > 0L))
    {
      ad.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.DfN);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (al(paramString.DfM, paramLong2) < 0L))
    {
      ad.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.DfM);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.DfO;
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (dbt)paramString.next();
      if ((paramLong2 == 0L) || (al(paramLong2, ((dbt)localObject).Etv) >= 0L))
      {
        int j = i;
        if (((dbt)localObject).Etw < i) {
          j = ((dbt)localObject).Etw;
        }
        i = j;
        if (al(paramLong1, ((dbt)localObject).Etv) >= 0L)
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
  
  private static afv a(afv paramafv1, afv paramafv2)
  {
    AppMethodBeat.i(95453);
    afv localafv = new afv();
    if (al(paramafv1.DfM, paramafv2.DfM) > 0L)
    {
      localafv.DfM = paramafv1.DfM;
      if (al(paramafv1.DfN, paramafv2.DfN) >= 0L) {
        break label132;
      }
      localafv.DfN = paramafv1.DfN;
      label64:
      paramafv1 = paramafv1.DfO;
      paramafv2 = paramafv2.DfO.iterator();
    }
    for (;;)
    {
      if (!paramafv2.hasNext()) {
        break label639;
      }
      dbt localdbt1 = (dbt)paramafv2.next();
      if (paramafv1.isEmpty())
      {
        ad.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramafv1.addFirst(localdbt1);
        continue;
        localafv.DfM = paramafv2.DfM;
        break;
        label132:
        localafv.DfN = paramafv2.DfN;
        break label64;
      }
      long l1 = localdbt1.Etv;
      int i = paramafv1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (al(l1, ((dbt)paramafv1.get(i)).Etu) <= 0L)
        {
          l1 = localdbt1.Etu;
          j = 0;
          label192:
          if (j >= paramafv1.size()) {
            break label254;
          }
          if (al(l1, ((dbt)paramafv1.get(j)).Etv) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramafv1.addFirst(localdbt1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramafv1.size();
      }
      label262:
      if (j == paramafv1.size())
      {
        paramafv1.addLast(localdbt1);
      }
      else
      {
        dbt localdbt2 = (dbt)paramafv1.get(j);
        int k = i;
        int m = j;
        dbt localdbt3;
        if (al(localdbt1.Etu, localdbt2.Etu) < 0L)
        {
          localdbt3 = new dbt();
          localdbt3.Etu = localdbt2.Etu;
          l1 = localdbt1.Etu;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localdbt3.Etv = l1;
          localdbt3.Etw = localdbt2.Etw;
          paramafv1.add(j, localdbt3);
          k = i + 1;
          m = j + 1;
          localdbt2 = (dbt)paramafv1.get(k);
          i = k;
          if (al(localdbt1.Etv, localdbt2.Etv) > 0L)
          {
            localdbt3 = new dbt();
            localdbt3.Etv = localdbt2.Etv;
            localdbt3.Etu = sz(localdbt1.Etv);
            localdbt3.Etw = localdbt2.Etw;
            paramafv1.add(k + 1, localdbt3);
            i = k;
          }
          while (i >= m)
          {
            paramafv1.remove(i);
            i -= 1;
          }
        }
        paramafv1.add(m, localdbt1);
        if (paramafv1.size() > 100)
        {
          long l2 = ((dbt)paramafv1.getLast()).Etv;
          l1 = ((dbt)paramafv1.getLast()).Etu;
          for (i = ((dbt)paramafv1.getLast()).Etw; paramafv1.size() >= 100; i = j)
          {
            localdbt1 = (dbt)paramafv1.removeLast();
            l1 = localdbt1.Etu;
            j = i;
            if (localdbt1.Etw < i) {
              j = localdbt1.Etw;
            }
          }
          localdbt1 = new dbt();
          localdbt1.Etu = l1;
          localdbt1.Etv = l2;
          localdbt1.Etw = i;
          paramafv1.addLast(localdbt1);
        }
      }
    }
    label639:
    localafv.DfO = paramafv1;
    AppMethodBeat.o(95453);
    return localafv;
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
  
  public static void e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(95452);
    if (paramLong2 == 0L)
    {
      AppMethodBeat.o(95452);
      return;
    }
    Object localObject1 = af.dty().apN(paramString);
    if (localObject1 == null) {
      localObject1 = new amw();
    }
    for (;;)
    {
      if ((paramLong1 == 0L) && (((amw)localObject1).DnX.isEmpty()))
      {
        AppMethodBeat.o(95452);
        return;
      }
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = ((afv)((amw)localObject1).DnX.getFirst()).DfM;
      }
      Object localObject2 = new afv();
      ((afv)localObject2).DfM = l;
      ((afv)localObject2).DfN = paramLong2;
      Object localObject3 = new dbt();
      ((dbt)localObject3).Etu = l;
      ((dbt)localObject3).Etv = paramLong2;
      ((dbt)localObject3).Etw = paramInt;
      ((afv)localObject2).DfO.add(localObject3);
      for (;;)
      {
        if (!((amw)localObject1).DnX.isEmpty())
        {
          localObject3 = (afv)((amw)localObject1).DnX.getFirst();
          if (al(((afv)localObject2).DfN, ((afv)localObject3).DfM) > 0L) {
            ad.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((afv)localObject2).DfN + " fault.Max" + ((afv)localObject3).DfM);
          }
        }
        else
        {
          ((amw)localObject1).DnX.addFirst(localObject2);
          while (((amw)localObject1).DnX.size() > 100) {
            ((amw)localObject1).DnX.removeLast();
          }
        }
        ((amw)localObject1).DnX.removeFirst();
        localObject2 = a((afv)localObject3, (afv)localObject2);
      }
      if (((amw)localObject1).DnX.size() > 0) {
        ad.d("MicroMsg.FaultLogic", "min " + ((afv)((amw)localObject1).DnX.get(0)).DfN + " max " + ((afv)((amw)localObject1).DnX.get(0)).DfM);
      }
      localObject2 = af.dty().apP(paramString);
      try
      {
        ((n)localObject2).field_userName = paramString;
        ((n)localObject2).field_faultS = ((amw)localObject1).toByteArray();
        af.dty().c((n)localObject2);
        label389:
        if (((amw)localObject1).DnX.size() > 1)
        {
          ad.d("MicroMsg.FaultLogic", "fault size : " + ((amw)localObject1).DnX.size());
          paramString = ((amw)localObject1).DnX.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (afv)paramString.next();
            ad.d("MicroMsg.FaultLogic", "min - max " + ((afv)localObject1).DfN + " " + ((afv)localObject1).DfM);
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
  
  public static long sz(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */