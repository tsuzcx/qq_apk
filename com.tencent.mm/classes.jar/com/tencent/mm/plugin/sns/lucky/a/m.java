package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> zvP;
  
  static
  {
    AppMethodBeat.i(95195);
    zvP = new ThreadLocal();
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
    bzi localbzi = paramp.ech();
    if (paramp.field_type != 21)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (localbzi.dPd == 1)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (v.aAC().equals(paramp.field_userName))
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.HOu;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(95191);
        return false;
      }
      paramp = v.aAC();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramp.equals(((dgq)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(95191);
          return true;
        }
      }
    }
    AppMethodBeat.o(95191);
    return false;
  }
  
  public static boolean azK(String paramString)
  {
    AppMethodBeat.i(95189);
    paramString = ah.dXE().aBr(paramString);
    boolean bool = a(paramString, al.v(paramString));
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
      localObject1 = al.v(paramp);
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
    Object localObject2 = paramSnsObject.HOu;
    if (localObject2 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = paramp.AdI;
    if (bu.isNullOrNil(paramSnsObject)) {}
    for (paramp = g.getMessageDigest(paramp.field_content) + g.getMessageDigest(paramp.field_attrBuf);; paramp = paramSnsObject)
    {
      localObject1 = (HashMap)zvP.get();
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
          dgq localdgq = (dgq)paramSnsObject.next();
          localObject2 = new bol();
          try
          {
            ((bol)localObject2).parseFrom(z.a(localdgq.HNn));
            l += ((bol)localObject2).dPq;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ae.e("MicrMsg.SnsLuckyUtil", localException.getMessage() + "hbBuffer is error");
            }
          }
        }
      }
      paramSnsObject = (SnsObject)localObject1;
      if (localObject1 == null) {
        paramSnsObject = new HashMap();
      }
      paramSnsObject.put(paramp, Long.valueOf(l));
      zvP.set(paramSnsObject);
      AppMethodBeat.o(95194);
      return l;
    }
  }
  
  public static boolean p(p paramp)
  {
    AppMethodBeat.i(95190);
    boolean bool = a(paramp, al.v(paramp));
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
    paramp = al.v(paramp);
    if (paramp == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramp = paramp.SnsRedEnvelops;
    if ((paramp == null) || (paramp.HOu.size() == 0))
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    int i = paramp.HOu.size();
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