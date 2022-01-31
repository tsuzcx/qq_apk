package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.bct;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> rcv;
  
  static
  {
    AppMethodBeat.i(35898);
    rcv = new ThreadLocal();
    AppMethodBeat.o(35898);
  }
  
  public static boolean ZV(String paramString)
  {
    AppMethodBeat.i(35892);
    paramString = ag.cpf().abv(paramString);
    boolean bool = a(paramString, ak.q(paramString));
    AppMethodBeat.o(35892);
    return bool;
  }
  
  public static boolean a(n paramn, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(35894);
    if (paramn == null)
    {
      AppMethodBeat.o(35894);
      return true;
    }
    bct localbct = paramn.csz();
    if (paramn.field_type != 21)
    {
      AppMethodBeat.o(35894);
      return true;
    }
    if (localbct.cMQ == 1)
    {
      AppMethodBeat.o(35894);
      return true;
    }
    if (r.Zn().equals(paramn.field_userName))
    {
      AppMethodBeat.o(35894);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.xPe;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(35894);
        return false;
      }
      paramn = r.Zn();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramn.equals(((cea)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(35894);
          return true;
        }
      }
    }
    AppMethodBeat.o(35894);
    return false;
  }
  
  public static long b(n paramn, SnsObject paramSnsObject)
  {
    long l = 0L;
    AppMethodBeat.i(35897);
    if (paramn == null)
    {
      AppMethodBeat.o(35897);
      return 0L;
    }
    Object localObject1 = paramSnsObject;
    if (paramSnsObject == null) {
      localObject1 = ak.q(paramn);
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(35897);
      return 0L;
    }
    paramSnsObject = ((SnsObject)localObject1).SnsRedEnvelops;
    if (paramSnsObject == null)
    {
      AppMethodBeat.o(35897);
      return 0L;
    }
    Object localObject2 = paramSnsObject.xPe;
    if (localObject2 == null)
    {
      AppMethodBeat.o(35897);
      return 0L;
    }
    paramSnsObject = paramn.rCU;
    if (bo.isNullOrNil(paramSnsObject)) {}
    for (paramn = g.w(paramn.field_content) + g.w(paramn.field_attrBuf);; paramn = paramSnsObject)
    {
      localObject1 = (HashMap)rcv.get();
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramn)))
      {
        l = ((Long)((HashMap)localObject1).get(paramn)).longValue();
        AppMethodBeat.o(35897);
        return l;
      }
      paramSnsObject = ((List)localObject2).iterator();
      for (;;)
      {
        if (paramSnsObject.hasNext())
        {
          cea localcea = (cea)paramSnsObject.next();
          localObject2 = new aur();
          try
          {
            ((aur)localObject2).parseFrom(aa.a(localcea.xOb));
            l += ((aur)localObject2).cNd;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.e("MicrMsg.SnsLuckyUtil", localException.getMessage() + "hbBuffer is error");
            }
          }
        }
      }
      paramSnsObject = (SnsObject)localObject1;
      if (localObject1 == null) {
        paramSnsObject = new HashMap();
      }
      paramSnsObject.put(paramn, Long.valueOf(l));
      rcv.set(paramSnsObject);
      AppMethodBeat.o(35897);
      return l;
    }
  }
  
  public static boolean k(n paramn)
  {
    AppMethodBeat.i(35893);
    boolean bool = a(paramn, ak.q(paramn));
    AppMethodBeat.o(35893);
    return bool;
  }
  
  public static int l(n paramn)
  {
    AppMethodBeat.i(35895);
    if (paramn == null)
    {
      AppMethodBeat.o(35895);
      return 0;
    }
    paramn = ak.q(paramn);
    if (paramn == null)
    {
      AppMethodBeat.o(35895);
      return 0;
    }
    paramn = paramn.SnsRedEnvelops;
    if ((paramn == null) || (paramn.xPe.size() == 0))
    {
      AppMethodBeat.o(35895);
      return 0;
    }
    int i = paramn.xPe.size();
    AppMethodBeat.o(35895);
    return i;
  }
  
  public static long m(n paramn)
  {
    AppMethodBeat.i(35896);
    long l = b(paramn, null);
    AppMethodBeat.o(35896);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.m
 * JD-Core Version:    0.7.0.1
 */