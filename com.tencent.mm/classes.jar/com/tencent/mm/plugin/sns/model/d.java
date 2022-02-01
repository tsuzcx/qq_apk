package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.ehm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  public static long Jf(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
  
  public static int a(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    paramString = aj.faS().aQp(paramString);
    Object localObject = paramString.LPq;
    Log.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.LPq.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (ami)((LinkedList)localObject).getFirst();
    if ((paramLong1 == 0L) || (aq(paramString.Lvc, paramLong1) > 0L))
    {
      Log.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.Lvc);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (aq(paramString.Lvb, paramLong2) < 0L))
    {
      Log.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.Lvb);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.Lvd;
    if (paramString.isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.iterator();
    int i = 2147483647;
    while (paramString.hasNext())
    {
      localObject = (ehm)paramString.next();
      if ((paramLong2 == 0L) || (aq(paramLong2, ((ehm)localObject).NgZ) >= 0L))
      {
        int j = i;
        if (((ehm)localObject).Nha < i) {
          j = ((ehm)localObject).Nha;
        }
        i = j;
        if (aq(paramLong1, ((ehm)localObject).NgZ) >= 0L)
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
    Log.i("MicroMsg.FaultLogic", "should not to hear  minId:".concat(String.valueOf(paramLong1)));
    AppMethodBeat.o(95454);
    return 0;
  }
  
  private static ami a(ami paramami1, ami paramami2)
  {
    AppMethodBeat.i(95453);
    ami localami = new ami();
    if (aq(paramami1.Lvb, paramami2.Lvb) > 0L)
    {
      localami.Lvb = paramami1.Lvb;
      if (aq(paramami1.Lvc, paramami2.Lvc) >= 0L) {
        break label132;
      }
      localami.Lvc = paramami1.Lvc;
      label64:
      paramami1 = paramami1.Lvd;
      paramami2 = paramami2.Lvd.iterator();
    }
    for (;;)
    {
      if (!paramami2.hasNext()) {
        break label639;
      }
      ehm localehm1 = (ehm)paramami2.next();
      if (paramami1.isEmpty())
      {
        Log.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramami1.addFirst(localehm1);
        continue;
        localami.Lvb = paramami2.Lvb;
        break;
        label132:
        localami.Lvc = paramami2.Lvc;
        break label64;
      }
      long l1 = localehm1.NgZ;
      int i = paramami1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (aq(l1, ((ehm)paramami1.get(i)).NgY) <= 0L)
        {
          l1 = localehm1.NgY;
          j = 0;
          label192:
          if (j >= paramami1.size()) {
            break label254;
          }
          if (aq(l1, ((ehm)paramami1.get(j)).NgZ) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramami1.addFirst(localehm1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramami1.size();
      }
      label262:
      if (j == paramami1.size())
      {
        paramami1.addLast(localehm1);
      }
      else
      {
        ehm localehm2 = (ehm)paramami1.get(j);
        int k = i;
        int m = j;
        ehm localehm3;
        if (aq(localehm1.NgY, localehm2.NgY) < 0L)
        {
          localehm3 = new ehm();
          localehm3.NgY = localehm2.NgY;
          l1 = localehm1.NgY;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localehm3.NgZ = l1;
          localehm3.Nha = localehm2.Nha;
          paramami1.add(j, localehm3);
          k = i + 1;
          m = j + 1;
          localehm2 = (ehm)paramami1.get(k);
          i = k;
          if (aq(localehm1.NgZ, localehm2.NgZ) > 0L)
          {
            localehm3 = new ehm();
            localehm3.NgZ = localehm2.NgZ;
            localehm3.NgY = Jf(localehm1.NgZ);
            localehm3.Nha = localehm2.Nha;
            paramami1.add(k + 1, localehm3);
            i = k;
          }
          while (i >= m)
          {
            paramami1.remove(i);
            i -= 1;
          }
        }
        paramami1.add(m, localehm1);
        if (paramami1.size() > 100)
        {
          long l2 = ((ehm)paramami1.getLast()).NgZ;
          l1 = ((ehm)paramami1.getLast()).NgY;
          for (i = ((ehm)paramami1.getLast()).Nha; paramami1.size() >= 100; i = j)
          {
            localehm1 = (ehm)paramami1.removeLast();
            l1 = localehm1.NgY;
            j = i;
            if (localehm1.Nha < i) {
              j = localehm1.Nha;
            }
          }
          localehm1 = new ehm();
          localehm1.NgY = l1;
          localehm1.NgZ = l2;
          localehm1.Nha = i;
          paramami1.addLast(localehm1);
        }
      }
    }
    label639:
    localami.Lvd = paramami1;
    AppMethodBeat.o(95453);
    return localami;
  }
  
  private static long aq(long paramLong1, long paramLong2)
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
    Object localObject1 = aj.faS().aQp(paramString);
    if (localObject1 == null) {
      localObject1 = new bft();
    }
    for (;;)
    {
      if ((paramLong1 == 0L) && (((bft)localObject1).LPq.isEmpty()))
      {
        AppMethodBeat.o(95452);
        return;
      }
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = ((ami)((bft)localObject1).LPq.getFirst()).Lvb;
      }
      Object localObject2 = new ami();
      ((ami)localObject2).Lvb = l;
      ((ami)localObject2).Lvc = paramLong2;
      Object localObject3 = new ehm();
      ((ehm)localObject3).NgY = l;
      ((ehm)localObject3).NgZ = paramLong2;
      ((ehm)localObject3).Nha = paramInt;
      ((ami)localObject2).Lvd.add(localObject3);
      for (;;)
      {
        if (!((bft)localObject1).LPq.isEmpty())
        {
          localObject3 = (ami)((bft)localObject1).LPq.getFirst();
          if (aq(((ami)localObject2).Lvc, ((ami)localObject3).Lvb) > 0L) {
            Log.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((ami)localObject2).Lvc + " fault.Max" + ((ami)localObject3).Lvb);
          }
        }
        else
        {
          ((bft)localObject1).LPq.addFirst(localObject2);
          while (((bft)localObject1).LPq.size() > 100) {
            ((bft)localObject1).LPq.removeLast();
          }
        }
        ((bft)localObject1).LPq.removeFirst();
        localObject2 = a((ami)localObject3, (ami)localObject2);
      }
      if (((bft)localObject1).LPq.size() > 0) {
        Log.d("MicroMsg.FaultLogic", "min " + ((ami)((bft)localObject1).LPq.get(0)).Lvc + " max " + ((ami)((bft)localObject1).LPq.get(0)).Lvb);
      }
      localObject2 = aj.faS().aQr(paramString);
      try
      {
        ((l)localObject2).field_userName = paramString;
        ((l)localObject2).field_faultS = ((bft)localObject1).toByteArray();
        aj.faS().c((l)localObject2);
        label389:
        if (((bft)localObject1).LPq.size() > 1)
        {
          Log.d("MicroMsg.FaultLogic", "fault size : " + ((bft)localObject1).LPq.size());
          paramString = ((bft)localObject1).LPq.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (ami)paramString.next();
            Log.d("MicroMsg.FaultLogic", "min - max " + ((ami)localObject1).Lvc + " " + ((ami)localObject1).Lvb);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d
 * JD-Core Version:    0.7.0.1
 */