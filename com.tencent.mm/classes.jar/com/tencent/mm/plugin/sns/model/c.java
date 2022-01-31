package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bxl;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.protocal.c.zq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private static long H(long paramLong1, long paramLong2)
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
    paramString = af.bDJ().OD(paramString);
    Object localObject = paramString.sYR;
    y.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[] { Integer.valueOf(paramString.sYR.size()) });
    int j;
    if (((LinkedList)localObject).isEmpty()) {
      j = 0;
    }
    int i;
    do
    {
      return j;
      paramString = (xs)((LinkedList)localObject).getFirst();
      if ((paramLong1 == 0L) || (H(paramString.sUt, paramLong1) > 0L))
      {
        y.e("MicroMsg.FaultLogic", "has a fault  minId:" + paramLong2 + " fault.min:" + paramString.sUt);
        return 0;
      }
      if ((paramLong2 != 0L) && (H(paramString.sUs, paramLong2) < 0L))
      {
        y.e("MicroMsg.FaultLogic", ":" + paramLong2 + " fault.max:" + paramString.sUs);
        return 0;
      }
      paramString = paramString.sUu;
      if (paramString.isEmpty()) {
        return 0;
      }
      paramString = paramString.iterator();
      j = 2147483647;
      do
      {
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          localObject = (bxl)paramString.next();
        } while ((paramLong2 != 0L) && (H(paramLong2, ((bxl)localObject).tNA) < 0L));
        i = j;
        if (((bxl)localObject).tNB < j) {
          i = ((bxl)localObject).tNB;
        }
        j = i;
      } while (H(paramLong1, ((bxl)localObject).tNA) < 0L);
      j = i;
    } while (i != 2147483647);
    return 0;
    y.i("MicroMsg.FaultLogic", "should not to hear  minId:" + paramLong1);
    return 0;
  }
  
  private static xs a(xs paramxs1, xs paramxs2)
  {
    xs localxs = new xs();
    if (H(paramxs1.sUs, paramxs2.sUs) > 0L)
    {
      localxs.sUs = paramxs1.sUs;
      if (H(paramxs1.sUt, paramxs2.sUt) >= 0L) {
        break label127;
      }
      localxs.sUt = paramxs1.sUt;
      label59:
      paramxs1 = paramxs1.sUu;
      paramxs2 = paramxs2.sUu.iterator();
    }
    for (;;)
    {
      if (!paramxs2.hasNext()) {
        break label634;
      }
      bxl localbxl1 = (bxl)paramxs2.next();
      if (paramxs1.isEmpty())
      {
        y.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
        paramxs1.addFirst(localbxl1);
        continue;
        localxs.sUs = paramxs2.sUs;
        break;
        label127:
        localxs.sUt = paramxs2.sUt;
        break label59;
      }
      long l1 = localbxl1.tNA;
      int i = paramxs1.size() - 1;
      label153:
      label178:
      int j;
      if (i >= 0) {
        if (H(l1, ((bxl)paramxs1.get(i)).tNz) <= 0L)
        {
          l1 = localbxl1.tNz;
          j = 0;
          label187:
          if (j >= paramxs1.size()) {
            break label249;
          }
          if (H(l1, ((bxl)paramxs1.get(j)).tNA) < 0L) {
            break label242;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label257;
        }
        paramxs1.addFirst(localbxl1);
        break;
        i -= 1;
        break label153;
        i = -1;
        break label178;
        label242:
        j += 1;
        break label187;
        label249:
        j = paramxs1.size();
      }
      label257:
      if (j == paramxs1.size())
      {
        paramxs1.addLast(localbxl1);
      }
      else
      {
        bxl localbxl2 = (bxl)paramxs1.get(j);
        int k = i;
        int m = j;
        bxl localbxl3;
        if (H(localbxl1.tNz, localbxl2.tNz) < 0L)
        {
          localbxl3 = new bxl();
          localbxl3.tNz = localbxl2.tNz;
          l1 = localbxl1.tNz;
          if (l1 != 9223372036854775807L) {
            break label488;
          }
        }
        label488:
        for (l1 = -9223372036854775808L;; l1 += 1L)
        {
          localbxl3.tNA = l1;
          localbxl3.tNB = localbxl2.tNB;
          paramxs1.add(j, localbxl3);
          k = i + 1;
          m = j + 1;
          localbxl2 = (bxl)paramxs1.get(k);
          i = k;
          if (H(localbxl1.tNA, localbxl2.tNA) > 0L)
          {
            localbxl3 = new bxl();
            localbxl3.tNA = localbxl2.tNA;
            localbxl3.tNz = fR(localbxl1.tNA);
            localbxl3.tNB = localbxl2.tNB;
            paramxs1.add(k + 1, localbxl3);
            i = k;
          }
          while (i >= m)
          {
            paramxs1.remove(i);
            i -= 1;
          }
        }
        paramxs1.add(m, localbxl1);
        if (paramxs1.size() > 100)
        {
          long l2 = ((bxl)paramxs1.getLast()).tNA;
          l1 = ((bxl)paramxs1.getLast()).tNz;
          for (i = ((bxl)paramxs1.getLast()).tNB; paramxs1.size() >= 100; i = j)
          {
            localbxl1 = (bxl)paramxs1.removeLast();
            l1 = localbxl1.tNz;
            j = i;
            if (localbxl1.tNB < i) {
              j = localbxl1.tNB;
            }
          }
          localbxl1 = new bxl();
          localbxl1.tNz = l1;
          localbxl1.tNA = l2;
          localbxl1.tNB = i;
          paramxs1.addLast(localbxl1);
        }
      }
    }
    label634:
    localxs.sUu = paramxs1;
    return localxs;
  }
  
  public static void f(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramLong2 == 0L) {}
    label488:
    for (;;)
    {
      return;
      Object localObject1 = af.bDJ().OD(paramString);
      if (localObject1 == null) {
        localObject1 = new zq();
      }
      for (;;)
      {
        for (;;)
        {
          if ((paramLong1 == 0L) && (((zq)localObject1).sYR.isEmpty())) {
            break label488;
          }
          long l = paramLong1;
          if (paramLong1 == 0L) {
            l = ((xs)((zq)localObject1).sYR.getFirst()).sUs;
          }
          Object localObject2 = new xs();
          ((xs)localObject2).sUs = l;
          ((xs)localObject2).sUt = paramLong2;
          Object localObject3 = new bxl();
          ((bxl)localObject3).tNz = l;
          ((bxl)localObject3).tNA = paramLong2;
          ((bxl)localObject3).tNB = paramInt;
          ((xs)localObject2).sUu.add(localObject3);
          for (;;)
          {
            if (!((zq)localObject1).sYR.isEmpty())
            {
              localObject3 = (xs)((zq)localObject1).sYR.getFirst();
              if (H(((xs)localObject2).sUt, ((xs)localObject3).sUs) > 0L) {
                y.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + ((xs)localObject2).sUt + " fault.Max" + ((xs)localObject3).sUs);
              }
            }
            else
            {
              ((zq)localObject1).sYR.addFirst(localObject2);
              while (((zq)localObject1).sYR.size() > 100) {
                ((zq)localObject1).sYR.removeLast();
              }
            }
            ((zq)localObject1).sYR.removeFirst();
            localObject2 = a((xs)localObject3, (xs)localObject2);
          }
          if (((zq)localObject1).sYR.size() > 0) {
            y.d("MicroMsg.FaultLogic", "min " + ((xs)((zq)localObject1).sYR.get(0)).sUt + " max " + ((xs)((zq)localObject1).sYR.get(0)).sUs);
          }
          localObject2 = af.bDJ().OF(paramString);
          try
          {
            ((l)localObject2).field_userName = paramString;
            ((l)localObject2).field_faultS = ((zq)localObject1).toByteArray();
            af.bDJ().c((l)localObject2);
            label373:
            if (((zq)localObject1).sYR.size() <= 1) {
              break;
            }
            y.d("MicroMsg.FaultLogic", "fault size : " + ((zq)localObject1).sYR.size());
            paramString = ((zq)localObject1).sYR.iterator();
            while (paramString.hasNext())
            {
              localObject1 = (xs)paramString.next();
              y.d("MicroMsg.FaultLogic", "min - max " + ((xs)localObject1).sUt + " " + ((xs)localObject1).sUs);
            }
          }
          catch (Exception paramString)
          {
            break label373;
          }
        }
      }
    }
  }
  
  public static long fR(long paramLong)
  {
    if (paramLong == -9223372036854775808L) {
      return 9223372036854775807L;
    }
    return paramLong - 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c
 * JD-Core Version:    0.7.0.1
 */