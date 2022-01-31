package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.a.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> ooe = new ThreadLocal();
  
  public static boolean Nj(String paramString)
  {
    paramString = af.bDF().OB(paramString);
    return a(paramString, aj.q(paramString));
  }
  
  public static boolean a(n paramn, bto parambto)
  {
    if (paramn == null) {
      return true;
    }
    awe localawe = paramn.bGw();
    if (paramn.field_type != 21) {
      return true;
    }
    if (localawe.cec == 1) {
      return true;
    }
    if (q.Gj().equals(paramn.field_userName)) {
      return true;
    }
    if (parambto.tKm != null)
    {
      parambto = parambto.tKm.tKP;
      if ((parambto == null) || (parambto.size() == 0)) {
        return false;
      }
      paramn = q.Gj();
      parambto = parambto.iterator();
      while (parambto.hasNext()) {
        if (paramn.equals(((btk)parambto.next()).sxM)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static long b(n paramn, bto parambto)
  {
    long l = 0L;
    if (paramn == null) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return 0L;
          localObject1 = parambto;
          if (parambto == null) {
            localObject1 = aj.q(paramn);
          }
        } while (localObject1 == null);
        parambto = ((bto)localObject1).tKm;
      } while (parambto == null);
      localObject2 = parambto.tKP;
    } while (localObject2 == null);
    parambto = paramn.oLj;
    if (bk.bl(parambto)) {}
    for (paramn = g.o(paramn.field_content) + g.o(paramn.field_attrBuf);; paramn = parambto)
    {
      localObject1 = (HashMap)ooe.get();
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramn))) {
        return ((Long)((HashMap)localObject1).get(paramn)).longValue();
      }
      parambto = ((List)localObject2).iterator();
      for (;;)
      {
        if (parambto.hasNext())
        {
          btk localbtk = (btk)parambto.next();
          localObject2 = new aoz();
          try
          {
            ((aoz)localObject2).aH(aa.a(localbtk.tJy));
            l += ((aoz)localObject2).ceq;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              y.e("MicrMsg.SnsLuckyUtil", localException.getMessage() + "hbBuffer is error");
            }
          }
        }
      }
      parambto = (bto)localObject1;
      if (localObject1 == null) {
        parambto = new HashMap();
      }
      parambto.put(paramn, Long.valueOf(l));
      ooe.set(parambto);
      return l;
    }
  }
  
  public static boolean k(n paramn)
  {
    return a(paramn, aj.q(paramn));
  }
  
  public static int l(n paramn)
  {
    if (paramn == null) {}
    do
    {
      do
      {
        return 0;
        paramn = aj.q(paramn);
      } while (paramn == null);
      paramn = paramn.tKm;
    } while ((paramn == null) || (paramn.tKP.size() == 0));
    return paramn.tKP.size();
  }
  
  public static long m(n paramn)
  {
    return b(paramn, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.m
 * JD-Core Version:    0.7.0.1
 */