package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.protocal.protobuf.fmw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static arc a(arc paramarc1, arc paramarc2)
  {
    AppMethodBeat.i(95453);
    arc localarc = new arc();
    if (bl(paramarc1.Zyt, paramarc2.Zyt) > 0L)
    {
      localarc.Zyt = paramarc1.Zyt;
      if (bl(paramarc1.Zyu, paramarc2.Zyu) >= 0L) {
        break label132;
      }
      localarc.Zyu = paramarc1.Zyu;
      label64:
      paramarc1 = paramarc1.Zyv;
      paramarc2 = paramarc2.Zyv.iterator();
    }
    for (;;)
    {
      if (!paramarc2.hasNext()) {
        break label639;
      }
      fmw localfmw1 = (fmw)paramarc2.next();
      if (paramarc1.isEmpty())
      {
        Log.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramarc1.addFirst(localfmw1);
        continue;
        localarc.Zyt = paramarc2.Zyt;
        break;
        label132:
        localarc.Zyu = paramarc2.Zyu;
        break label64;
      }
      long l1 = localfmw1.abMZ;
      int i = paramarc1.size() - 1;
      label158:
      label183:
      int j;
      if (i >= 0) {
        if (bl(l1, ((fmw)paramarc1.get(i)).abMY) <= 0L)
        {
          l1 = localfmw1.abMY;
          j = 0;
          label192:
          if (j >= paramarc1.size()) {
            break label254;
          }
          if (bl(l1, ((fmw)paramarc1.get(j)).abMZ) < 0L) {
            break label247;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label262;
        }
        paramarc1.addFirst(localfmw1);
        break;
        i -= 1;
        break label158;
        i = -1;
        break label183;
        label247:
        j += 1;
        break label192;
        label254:
        j = paramarc1.size();
      }
      label262:
      if (j == paramarc1.size())
      {
        paramarc1.addLast(localfmw1);
      }
      else
      {
        fmw localfmw2 = (fmw)paramarc1.get(j);
        int k = i;
        int m = j;
        fmw localfmw3;
        if (bl(localfmw1.abMY, localfmw2.abMY) < 0L)
        {
          localfmw3 = new fmw();
          localfmw3.abMY = localfmw2.abMY;
          l1 = localfmw1.abMY;
          if (l1 != 9223372036854775807L) {
            break label493;
          }
        }
        label493:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localfmw3.abMZ = l1;
          localfmw3.abNa = localfmw2.abNa;
          paramarc1.add(j, localfmw3);
          k = i + 1;
          m = j + 1;
          localfmw2 = (fmw)paramarc1.get(k);
          i = k;
          if (bl(localfmw1.abMZ, localfmw2.abMZ) > 0L)
          {
            localfmw3 = new fmw();
            localfmw3.abMZ = localfmw2.abMZ;
            localfmw3.abMY = uE(localfmw1.abMZ);
            localfmw3.abNa = localfmw2.abNa;
            paramarc1.add(k + 1, localfmw3);
            i = k;
          }
          while (i >= m)
          {
            paramarc1.remove(i);
            i -= 1;
          }
        }
        paramarc1.add(m, localfmw1);
        if (paramarc1.size() > 100)
        {
          long l2 = ((fmw)paramarc1.getLast()).abMZ;
          l1 = ((fmw)paramarc1.getLast()).abMY;
          for (i = ((fmw)paramarc1.getLast()).abNa; paramarc1.size() >= 100; i = j)
          {
            localfmw1 = (fmw)paramarc1.removeLast();
            l1 = localfmw1.abMY;
            j = i;
            if (localfmw1.abNa < i) {
              j = localfmw1.abNa;
            }
          }
          localfmw1 = new fmw();
          localfmw1.abMY = l1;
          localfmw1.abMZ = l2;
          localfmw1.abNa = i;
          paramarc1.addLast(localfmw1);
        }
      }
    }
    label639:
    localarc.Zyv = paramarc1;
    AppMethodBeat.o(95453);
    return localarc;
  }
  
  public static int b(long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(95454);
    if (paramLong1 == 0L)
    {
      Log.e("MicroMsg.FaultLogic", "minId == 0.");
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = al.hgF().aZU(paramString);
    Object localObject = paramString.aajy;
    Log.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.aajy.size()) });
    if (((LinkedList)localObject).isEmpty())
    {
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = (arc)((LinkedList)localObject).getFirst();
    if (bl(paramString.Zyu, paramLong1) > 0L)
    {
      Log.e("MicroMsg.FaultLogic", "has a fault，minId:" + paramLong2 + " fault.min:" + paramString.Zyu);
      AppMethodBeat.o(95454);
      return 0;
    }
    if ((paramLong2 != 0L) && (bl(paramString.Zyt, paramLong2) < 0L))
    {
      Log.e("MicroMsg.FaultLogic", "has part of a fault, maxId:" + paramLong2 + " fault.max:" + paramString.Zyt);
      AppMethodBeat.o(95454);
      return 0;
    }
    paramString = paramString.Zyv;
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
      localObject = (fmw)paramString.next();
      if ((paramLong2 == 0L) || (bl(paramLong2, ((fmw)localObject).abMZ) >= 0L))
      {
        int j = i;
        if (((fmw)localObject).abNa < i) {
          j = ((fmw)localObject).abNa;
        }
        i = j;
        if (bl(paramLong1, ((fmw)localObject).abMZ) >= 0L)
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
  
  private static long bl(long paramLong1, long paramLong2)
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
    Object localObject1 = al.hgF().aZU(paramString);
    if (localObject1 == null) {
      localObject1 = new can();
    }
    for (;;)
    {
      long l = paramLong1;
      if (paramLong1 == 0L)
      {
        if (((can)localObject1).aajy.isEmpty())
        {
          AppMethodBeat.o(95452);
          return;
        }
        l = ((arc)((can)localObject1).aajy.getFirst()).Zyt;
      }
      Object localObject2 = new arc();
      ((arc)localObject2).Zyt = l;
      ((arc)localObject2).Zyu = paramLong2;
      Object localObject3 = new fmw();
      ((fmw)localObject3).abMY = l;
      ((fmw)localObject3).abMZ = paramLong2;
      ((fmw)localObject3).abNa = paramInt;
      ((arc)localObject2).Zyv.add(localObject3);
      for (;;)
      {
        if (!((can)localObject1).aajy.isEmpty())
        {
          localObject3 = (arc)((can)localObject1).aajy.getFirst();
          if (bl(((arc)localObject2).Zyu, ((arc)localObject3).Zyt) > 0L) {
            Log.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((arc)localObject2).Zyu + " fault.Max" + ((arc)localObject3).Zyt);
          }
        }
        else
        {
          ((can)localObject1).aajy.addFirst(localObject2);
          while (((can)localObject1).aajy.size() > 100) {
            ((can)localObject1).aajy.removeLast();
          }
        }
        ((can)localObject1).aajy.removeFirst();
        localObject2 = a((arc)localObject3, (arc)localObject2);
      }
      if (((can)localObject1).aajy.size() > 0) {
        Log.d("MicroMsg.FaultLogic", "min " + ((arc)((can)localObject1).aajy.get(0)).Zyu + " max " + ((arc)((can)localObject1).aajy.get(0)).Zyt);
      }
      localObject2 = al.hgF().aZW(paramString);
      try
      {
        ((u)localObject2).field_userName = paramString;
        ((u)localObject2).field_faultS = ((can)localObject1).toByteArray();
        al.hgF().c((u)localObject2);
        label383:
        if (((can)localObject1).aajy.size() > 1)
        {
          Log.d("MicroMsg.FaultLogic", "fault size : " + ((can)localObject1).aajy.size());
          paramString = ((can)localObject1).aajy.iterator();
          while (paramString.hasNext())
          {
            localObject1 = (arc)paramString.next();
            Log.d("MicroMsg.FaultLogic", "min - max " + ((arc)localObject1).Zyu + " " + ((arc)localObject1).Zyt);
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
  
  public static long uE(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d
 * JD-Core Version:    0.7.0.1
 */