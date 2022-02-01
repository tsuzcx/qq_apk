package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> DGc;
  
  static
  {
    AppMethodBeat.i(95195);
    DGc = new ThreadLocal();
    AppMethodBeat.o(95195);
  }
  
  public static boolean a(SnsInfo paramSnsInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95191);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    cnc localcnc = paramSnsInfo.getPostInfo();
    if (paramSnsInfo.getTypeFlag() != 21)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (localcnc.egZ == 1)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (com.tencent.mm.model.z.aTY().equals(paramSnsInfo.getUserName()))
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.Naf;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(95191);
        return false;
      }
      paramSnsInfo = com.tencent.mm.model.z.aTY();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramSnsInfo.equals(((dzx)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(95191);
          return true;
        }
      }
    }
    AppMethodBeat.o(95191);
    return false;
  }
  
  public static boolean aOH(String paramString)
  {
    AppMethodBeat.i(95189);
    paramString = aj.faO().aQm(paramString);
    boolean bool = a(paramString, an.C(paramString));
    AppMethodBeat.o(95189);
    return bool;
  }
  
  public static long b(SnsInfo paramSnsInfo, SnsObject paramSnsObject)
  {
    long l = 0L;
    AppMethodBeat.i(95194);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    Object localObject1 = paramSnsObject;
    if (paramSnsObject == null) {
      localObject1 = an.C(paramSnsInfo);
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
    Object localObject2 = paramSnsObject.Naf;
    if (localObject2 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = paramSnsInfo.contentByteMd5;
    if (Util.isNullOrNil(paramSnsObject)) {}
    for (paramSnsInfo = g.getMessageDigest(paramSnsInfo.field_content) + g.getMessageDigest(paramSnsInfo.field_attrBuf);; paramSnsInfo = paramSnsObject)
    {
      localObject1 = (HashMap)DGc.get();
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(paramSnsInfo)))
      {
        l = ((Long)((HashMap)localObject1).get(paramSnsInfo)).longValue();
        AppMethodBeat.o(95194);
        return l;
      }
      paramSnsObject = ((List)localObject2).iterator();
      for (;;)
      {
        if (paramSnsObject.hasNext())
        {
          dzx localdzx = (dzx)paramSnsObject.next();
          localObject2 = new cbd();
          try
          {
            ((cbd)localObject2).parseFrom(com.tencent.mm.platformtools.z.a(localdzx.MYW));
            l += ((cbd)localObject2).eht;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("MicrMsg.SnsLuckyUtil", localException.getMessage() + "hbBuffer is error");
            }
          }
        }
      }
      paramSnsObject = (SnsObject)localObject1;
      if (localObject1 == null) {
        paramSnsObject = new HashMap();
      }
      paramSnsObject.put(paramSnsInfo, Long.valueOf(l));
      DGc.set(paramSnsObject);
      AppMethodBeat.o(95194);
      return l;
    }
  }
  
  public static boolean w(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95190);
    boolean bool = a(paramSnsInfo, an.C(paramSnsInfo));
    AppMethodBeat.o(95190);
    return bool;
  }
  
  public static int x(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95192);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramSnsInfo = an.C(paramSnsInfo);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramSnsInfo = paramSnsInfo.SnsRedEnvelops;
    if ((paramSnsInfo == null) || (paramSnsInfo.Naf.size() == 0))
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    int i = paramSnsInfo.Naf.size();
    AppMethodBeat.o(95192);
    return i;
  }
  
  public static long y(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95193);
    long l = b(paramSnsInfo, null);
    AppMethodBeat.o(95193);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.m
 * JD-Core Version:    0.7.0.1
 */