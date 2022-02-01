package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    paramString = af.dHV().auW(paramString);
    Object localObject = paramString.EIX;
    ac.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.EIX.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (agu)((LinkedList)localObject).getFirst();
    if ((paramLong1 == 0L) || (ai(paramString.EyT, paramLong1) > 0L))
    {
      ac.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.EyT);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (ai(paramString.EyS, paramLong2) < 0L))
    {
      ac.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.EyS);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.EyU;
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (dhf)paramString.next();
      if ((paramLong2 == 0L) || (ai(paramLong2, ((dhf)localObject).FQx) >= 0L))
      {
        int j = i;
        if (((dhf)localObject).FQy < i) {
          j = ((dhf)localObject).FQy;
        }
        i = j;
        if (ai(paramLong1, ((dhf)localObject).FQx) >= 0L)
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
    ac.i("MicroMsg.FaultLogic", "should not to hear  minId:".concat(String.valueOf(paramLong1)));
    AppMethodBeat.o(95454);
    return 0;
  }
  
  private static agu a(agu paramagu1, agu paramagu2)
  {
    AppMethodBeat.i(95453);
    agu localagu = new agu();
    if (ai(paramagu1.EyS, paramagu2.EyS) > 0L)
    {
      localagu.EyS = paramagu1.EyS;
      if (ai(paramagu1.EyT, paramagu2.EyT) >= 0L) {
        break label132;
      }
      localagu.EyT = paramagu1.EyT;
      label64:
      paramagu1 = paramagu1.EyU;
      paramagu2 = paramagu2.EyU.iterator();
    }
    for (;;)
    {
      if (!paramagu2.hasNext()) {
        break label639;
      }
      dhf localdhf1 = (dhf)paramagu2.next();
      if (paramagu1.isEmpty())
      {
        ac.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramagu1.addFirst(localdhf1);
        continue;
        localagu.EyS = paramagu2.EyS;
        break;
        label132:
        localagu.EyT = paramagu2.EyT;
        break label64;
      }
      long l1 = localdhf1.FQx;
      int i = paramagu1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (ai(l1, ((dhf)paramagu1.get(i)).FQw) <= 0L)
        {
          l1 = localdhf1.FQw;
          j = 0;
          label192:
          if (j >= paramagu1.size()) {
            break label254;
          }
          if (ai(l1, ((dhf)paramagu1.get(j)).FQx) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramagu1.addFirst(localdhf1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramagu1.size();
      }
      label262:
      if (j == paramagu1.size())
      {
        paramagu1.addLast(localdhf1);
      }
      else
      {
        dhf localdhf2 = (dhf)paramagu1.get(j);
        int k = i;
        int m = j;
        dhf localdhf3;
        if (ai(localdhf1.FQw, localdhf2.FQw) < 0L)
        {
          localdhf3 = new dhf();
          localdhf3.FQw = localdhf2.FQw;
          l1 = localdhf1.FQw;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localdhf3.FQx = l1;
          localdhf3.FQy = localdhf2.FQy;
          paramagu1.add(j, localdhf3);
          k = i + 1;
          m = j + 1;
          localdhf2 = (dhf)paramagu1.get(k);
          i = k;
          if (ai(localdhf1.FQx, localdhf2.FQx) > 0L)
          {
            localdhf3 = new dhf();
            localdhf3.FQx = localdhf2.FQx;
            localdhf3.FQw = xc(localdhf1.FQx);
            localdhf3.FQy = localdhf2.FQy;
            paramagu1.add(k + 1, localdhf3);
            i = k;
          }
          while (i >= m)
          {
            paramagu1.remove(i);
            i -= 1;
          }
        }
        paramagu1.add(m, localdhf1);
        if (paramagu1.size() > 100)
        {
          long l2 = ((dhf)paramagu1.getLast()).FQx;
          l1 = ((dhf)paramagu1.getLast()).FQw;
          for (i = ((dhf)paramagu1.getLast()).FQy; paramagu1.size() >= 100; i = j)
          {
            localdhf1 = (dhf)paramagu1.removeLast();
            l1 = localdhf1.FQw;
            j = i;
            if (localdhf1.FQy < i) {
              j = localdhf1.FQy;
            }
          }
          localdhf1 = new dhf();
          localdhf1.FQw = l1;
          localdhf1.FQx = l2;
          localdhf1.FQy = i;
          paramagu1.addLast(localdhf1);
        }
      }
    }
    label639:
    localagu.EyU = paramagu1;
    AppMethodBeat.o(95453);
    return localagu;
  }
  
  private static long ai(long paramLong1, long paramLong2)
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
    Object localObject1 = af.dHV().auW(paramString);
    if (localObject1 == null) {
      localObject1 = new aqa();
    }
    for (;;)
    {
      if ((paramLong1 == 0L) && (((aqa)localObject1).EIX.isEmpty()))
      {
        AppMethodBeat.o(95452);
        return;
      }
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = ((agu)((aqa)localObject1).EIX.getFirst()).EyS;
      }
      Object localObject2 = new agu();
      ((agu)localObject2).EyS = l;
      ((agu)localObject2).EyT = paramLong2;
      Object localObject3 = new dhf();
      ((dhf)localObject3).FQw = l;
      ((dhf)localObject3).FQx = paramLong2;
      ((dhf)localObject3).FQy = paramInt;
      ((agu)localObject2).EyU.add(localObject3);
      for (;;)
      {
        if (!((aqa)localObject1).EIX.isEmpty())
        {
          localObject3 = (agu)((aqa)localObject1).EIX.getFirst();
          if (ai(((agu)localObject2).EyT, ((agu)localObject3).EyS) > 0L) {
            ac.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((agu)localObject2).EyT + " fault.Max" + ((agu)localObject3).EyS);
          }
        }
        else
        {
          ((aqa)localObject1).EIX.addFirst(localObject2);
          while (((aqa)localObject1).EIX.size() > 100) {
            ((aqa)localObject1).EIX.removeLast();
          }
        }
        ((aqa)localObject1).EIX.removeFirst();
        localObject2 = a((agu)localObject3, (agu)localObject2);
      }
      if (((aqa)localObject1).EIX.size() > 0) {
        ac.d("MicroMsg.FaultLogic", "min " + ((agu)((aqa)localObject1).EIX.get(0)).EyT + " max " + ((agu)((aqa)localObject1).EIX.get(0)).EyS);
      }
      localObject2 = af.dHV().auY(paramString);
      try
      {
        ((n)localObject2).field_userName = paramString;
        ((n)localObject2).field_faultS = ((aqa)localObject1).toByteArray();
        af.dHV().c((n)localObject2);
        label389:
        if (((aqa)localObject1).EIX.size() > 1)
        {
          ac.d("MicroMsg.FaultLogic", "fault size : " + ((aqa)localObject1).EIX.size());
          paramString = ((aqa)localObject1).EIX.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (agu)paramString.next();
            ac.d("MicroMsg.FaultLogic", "min - max " + ((agu)localObject1).EyT + " " + ((agu)localObject1).EyS);
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
  
  public static long xc(long paramLong)
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