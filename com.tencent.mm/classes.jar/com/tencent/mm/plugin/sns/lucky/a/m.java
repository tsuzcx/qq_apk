package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> zfa;
  
  static
  {
    AppMethodBeat.i(95195);
    zfa = new ThreadLocal();
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
    byo localbyo = paramp.dYD();
    if (paramp.field_type != 21)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (localbyo.dNN == 1)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (u.aAm().equals(paramp.field_userName))
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.HuR;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(95191);
        return false;
      }
      paramp = u.aAm();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramp.equals(((dfw)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(95191);
          return true;
        }
      }
    }
    AppMethodBeat.o(95191);
    return false;
  }
  
  public static boolean ayt(String paramString)
  {
    AppMethodBeat.i(95189);
    paramString = ag.dUe().aAa(paramString);
    boolean bool = a(paramString, ak.v(paramString));
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
      localObject1 = ak.v(paramp);
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
    Object localObject2 = paramSnsObject.HuR;
    if (localObject2 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = paramp.zMB;
    if (bt.isNullOrNil(paramSnsObject)) {}
    for (paramp = g.getMessageDigest(paramp.field_content) + g.getMessageDigest(paramp.field_attrBuf);; paramp = paramSnsObject)
    {
      localObject1 = (HashMap)zfa.get();
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
          dfw localdfw = (dfw)paramSnsObject.next();
          localObject2 = new bnt();
          try
          {
            ((bnt)localObject2).parseFrom(z.a(localdfw.HtK));
            l += ((bnt)localObject2).dOa;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.e("MicrMsg.SnsLuckyUtil", localException.getMessage() + "hbBuffer is error");
            }
          }
        }
      }
      paramSnsObject = (SnsObject)localObject1;
      if (localObject1 == null) {
        paramSnsObject = new HashMap();
      }
      paramSnsObject.put(paramp, Long.valueOf(l));
      zfa.set(paramSnsObject);
      AppMethodBeat.o(95194);
      return l;
    }
  }
  
  public static boolean p(p paramp)
  {
    AppMethodBeat.i(95190);
    boolean bool = a(paramp, ak.v(paramp));
    AppMethodBeat.o(95190);
    return bool;
  }
  
  public static int q(p paramp)
  {
    AppMethodBeat.i(95192);
    if (paramp == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramp = ak.v(paramp);
    if (paramp == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramp = paramp.SnsRedEnvelops;
    if ((paramp == null) || (paramp.HuR.size() == 0))
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    int i = paramp.HuR.size();
    AppMethodBeat.o(95192);
    return i;
  }
  
  public static long r(p paramp)
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