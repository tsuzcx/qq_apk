package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.protobuf.abx;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.cjz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static long W(long paramLong1, long paramLong2)
  {
    if (((paramLong1 > 0L) && (paramLong2 > 0L)) || ((paramLong1 < 0L) && (paramLong2 < 0L))) {
      return paramLong1 - paramLong2;
    }
    if (paramLong1 < 0L) {
      return 1L;
    }
    return -1L;
  }
  
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(36134);
    paramString = ag.cpj().abx(paramString);
    Object localObject = paramString.wXm;
    ab.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.wXm.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(36134);
      return 0;
    }
    paramString = (abx)((LinkedList)localObject).getFirst();
    if ((paramLong1 == 0L) || (W(paramString.wSq, paramLong1) > 0L))
    {
      ab.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.wSq);
      AppMethodBeat.o(36134);
      return 0;
    }
    if ((paramLong2 != 0L) && (W(paramString.wSp, paramLong2) < 0L))
    {
      ab.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.wSp);
      AppMethodBeat.o(36134);
      return 0;
    }
    paramString = paramString.wSr;
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(36134);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (cjz)paramString.next();
      if ((paramLong2 == 0L) || (W(paramLong2, ((cjz)localObject).xUb) >= 0L))
      {
        int j = i;
        if (((cjz)localObject).xUc < i) {
          j = ((cjz)localObject).xUc;
        }
        i = j;
        if (W(paramLong1, ((cjz)localObject).xUb) >= 0L)
        {
          if (j == 2147483647)
          {
            AppMethodBeat.o(36134);
            return 0;
          }
          AppMethodBeat.o(36134);
          return j;
        }
      }
    }
    ab.i("MicroMsg.FaultLogic", "should not to hear  minId:".concat(String.valueOf(paramLong1)));
    AppMethodBeat.o(36134);
    return 0;
  }
  
  private static abx a(abx paramabx1, abx paramabx2)
  {
    AppMethodBeat.i(36133);
    abx localabx = new abx();
    if (W(paramabx1.wSp, paramabx2.wSp) > 0L)
    {
      localabx.wSp = paramabx1.wSp;
      if (W(paramabx1.wSq, paramabx2.wSq) >= 0L) {
        break label132;
      }
      localabx.wSq = paramabx1.wSq;
      label64:
      paramabx1 = paramabx1.wSr;
      paramabx2 = paramabx2.wSr.iterator();
    }
    for (;;)
    {
      if (!paramabx2.hasNext()) {
        break label639;
      }
      cjz localcjz1 = (cjz)paramabx2.next();
      if (paramabx1.isEmpty())
      {
        ab.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramabx1.addFirst(localcjz1);
        continue;
        localabx.wSp = paramabx2.wSp;
        break;
        label132:
        localabx.wSq = paramabx2.wSq;
        break label64;
      }
      long l1 = localcjz1.xUb;
      int i = paramabx1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (W(l1, ((cjz)paramabx1.get(i)).xUa) <= 0L)
        {
          l1 = localcjz1.xUa;
          j = 0;
          label192:
          if (j >= paramabx1.size()) {
            break label254;
          }
          if (W(l1, ((cjz)paramabx1.get(j)).xUb) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramabx1.addFirst(localcjz1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramabx1.size();
      }
      label262:
      if (j == paramabx1.size())
      {
        paramabx1.addLast(localcjz1);
      }
      else
      {
        cjz localcjz2 = (cjz)paramabx1.get(j);
        int k = i;
        int m = j;
        cjz localcjz3;
        if (W(localcjz1.xUa, localcjz2.xUa) < 0L)
        {
          localcjz3 = new cjz();
          localcjz3.xUa = localcjz2.xUa;
          l1 = localcjz1.xUa;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localcjz3.xUb = l1;
          localcjz3.xUc = localcjz2.xUc;
          paramabx1.add(j, localcjz3);
          k = i + 1;
          m = j + 1;
          localcjz2 = (cjz)paramabx1.get(k);
          i = k;
          if (W(localcjz1.xUb, localcjz2.xUb) > 0L)
          {
            localcjz3 = new cjz();
            localcjz3.xUb = localcjz2.xUb;
            localcjz3.xUa = lw(localcjz1.xUb);
            localcjz3.xUc = localcjz2.xUc;
            paramabx1.add(k + 1, localcjz3);
            i = k;
          }
          while (i >= m)
          {
            paramabx1.remove(i);
            i -= 1;
          }
        }
        paramabx1.add(m, localcjz1);
        if (paramabx1.size() > 100)
        {
          long l2 = ((cjz)paramabx1.getLast()).xUb;
          l1 = ((cjz)paramabx1.getLast()).xUa;
          for (i = ((cjz)paramabx1.getLast()).xUc; paramabx1.size() >= 100; i = j)
          {
            localcjz1 = (cjz)paramabx1.removeLast();
            l1 = localcjz1.xUa;
            j = i;
            if (localcjz1.xUc < i) {
              j = localcjz1.xUc;
            }
          }
          localcjz1 = new cjz();
          localcjz1.xUa = l1;
          localcjz1.xUb = l2;
          localcjz1.xUc = i;
          paramabx1.addLast(localcjz1);
        }
      }
    }
    label639:
    localabx.wSr = paramabx1;
    AppMethodBeat.o(36133);
    return localabx;
  }
  
  public static void f(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(36132);
    if (paramLong2 == 0L)
    {
      AppMethodBeat.o(36132);
      return;
    }
    Object localObject1 = ag.cpj().abx(paramString);
    if (localObject1 == null) {
      localObject1 = new aei();
    }
    for (;;)
    {
      if ((paramLong1 == 0L) && (((aei)localObject1).wXm.isEmpty()))
      {
        AppMethodBeat.o(36132);
        return;
      }
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = ((abx)((aei)localObject1).wXm.getFirst()).wSp;
      }
      Object localObject2 = new abx();
      ((abx)localObject2).wSp = l;
      ((abx)localObject2).wSq = paramLong2;
      Object localObject3 = new cjz();
      ((cjz)localObject3).xUa = l;
      ((cjz)localObject3).xUb = paramLong2;
      ((cjz)localObject3).xUc = paramInt;
      ((abx)localObject2).wSr.add(localObject3);
      for (;;)
      {
        if (!((aei)localObject1).wXm.isEmpty())
        {
          localObject3 = (abx)((aei)localObject1).wXm.getFirst();
          if (W(((abx)localObject2).wSq, ((abx)localObject3).wSp) > 0L) {
            ab.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((abx)localObject2).wSq + " fault.Max" + ((abx)localObject3).wSp);
          }
        }
        else
        {
          ((aei)localObject1).wXm.addFirst(localObject2);
          while (((aei)localObject1).wXm.size() > 100) {
            ((aei)localObject1).wXm.removeLast();
          }
        }
        ((aei)localObject1).wXm.removeFirst();
        localObject2 = a((abx)localObject3, (abx)localObject2);
      }
      if (((aei)localObject1).wXm.size() > 0) {
        ab.d("MicroMsg.FaultLogic", "min " + ((abx)((aei)localObject1).wXm.get(0)).wSq + " max " + ((abx)((aei)localObject1).wXm.get(0)).wSp);
      }
      localObject2 = ag.cpj().abz(paramString);
      try
      {
        ((l)localObject2).field_userName = paramString;
        ((l)localObject2).field_faultS = ((aei)localObject1).toByteArray();
        ag.cpj().c((l)localObject2);
        label389:
        if (((aei)localObject1).wXm.size() > 1)
        {
          ab.d("MicroMsg.FaultLogic", "fault size : " + ((aei)localObject1).wXm.size());
          paramString = ((aei)localObject1).wXm.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (abx)paramString.next();
            ab.d("MicroMsg.FaultLogic", "min - max " + ((abx)localObject1).wSq + " " + ((abx)localObject1).wSp);
          }
        }
        AppMethodBeat.o(36132);
        return;
      }
      catch (Exception paramString)
      {
        break label389;
      }
    }
  }
  
  public static long lw(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */