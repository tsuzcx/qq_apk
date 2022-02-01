package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> xPg;
  
  static
  {
    AppMethodBeat.i(95195);
    xPg = new ThreadLocal();
    AppMethodBeat.o(95195);
  }
  
  public static boolean a(p paramp, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95191);
    if (paramp == null)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    bua localbua = paramp.dMn();
    if (paramp.field_type != 21)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (localbua.dBA == 1)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (u.axw().equals(paramp.field_userName))
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.FKj;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(95191);
        return false;
      }
      paramp = u.axw();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramp.equals(((daj)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(95191);
          return true;
        }
      }
    }
    AppMethodBeat.o(95191);
    return false;
  }
  
  public static boolean ato(String paramString)
  {
    AppMethodBeat.i(95189);
    paramString = af.dHR().auT(paramString);
    boolean bool = a(paramString, aj.t(paramString));
    AppMethodBeat.o(95189);
    return bool;
  }
  
  public static long b(p paramp, SnsObject paramSnsObject)
  {
    long l = 0L;
    AppMethodBeat.i(95194);
    if (paramp == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    Object localObject1 = paramSnsObject;
    if (paramSnsObject == null) {
      localObject1 = aj.t(paramp);
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = ((SnsObject)localObject1).SnsRedEnvelops;
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    Object localObject2 = paramSnsObject.FKj;
    if (localObject2 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = paramp.yvo;
    if (bs.isNullOrNil(paramSnsObject)) {}
    for (paramp = g.getMessageDigest(paramp.field_content) + g.getMessageDigest(paramp.field_attrBuf);; paramp = paramSnsObject)
    {
      localObject1 = (HashMap)xPg.get();
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramp)))
      {
        l = ((Long)((HashMap)localObject1).get(paramp)).longValue();
        AppMethodBeat.o(95194);
        return l;
      }
      paramSnsObject = ((List)localObject2).iterator();
      for (;;)
      {
        if (paramSnsObject.hasNext())
        {
          daj localdaj = (daj)paramSnsObject.next();
          localObject2 = new bjl();
          try
          {
            ((bjl)localObject2).parseFrom(z.a(localdaj.FJc));
            l += ((bjl)localObject2).dBN;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.e("MicrMsg.SnsLuckyUtil", localException.getMessage() + "hbBuffer is error");
            }
          }
        }
      }
      paramSnsObject = (SnsObject)localObject1;
      if (localObject1 == null) {
        paramSnsObject = new HashMap();
      }
      paramSnsObject.put(paramp, Long.valueOf(l));
      xPg.set(paramSnsObject);
      AppMethodBeat.o(95194);
      return l;
    }
  }
  
  public static boolean n(p paramp)
  {
    AppMethodBeat.i(95190);
    boolean bool = a(paramp, aj.t(paramp));
    AppMethodBeat.o(95190);
    return bool;
  }
  
  public static int o(p paramp)
  {
    AppMethodBeat.i(95192);
    if (paramp == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramp = aj.t(paramp);
    if (paramp == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramp = paramp.SnsRedEnvelops;
    if ((paramp == null) || (paramp.FKj.size() == 0))
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    int i = paramp.FKj.size();
    AppMethodBeat.o(95192);
    return i;
  }
  
  public static long p(p paramp)
  {
    AppMethodBeat.i(95193);
    long l = b(paramp, null);
    AppMethodBeat.o(95193);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.m
 * JD-Core Version:    0.7.0.1
 */