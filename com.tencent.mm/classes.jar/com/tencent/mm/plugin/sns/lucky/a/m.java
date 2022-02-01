package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> JSY;
  
  static
  {
    AppMethodBeat.i(95195);
    JSY = new ThreadLocal();
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
    cvu localcvu = paramSnsInfo.getPostInfo();
    if (paramSnsInfo.getTypeFlag() != 21)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (localcvu.gbp == 1)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (com.tencent.mm.model.z.bcZ().equals(paramSnsInfo.getUserName()))
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.Umz;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(95191);
        return false;
      }
      paramSnsInfo = com.tencent.mm.model.z.bcZ();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramSnsInfo.equals(((ejx)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(95191);
          return true;
        }
      }
    }
    AppMethodBeat.o(95191);
    return false;
  }
  
  public static boolean aZC(String paramString)
  {
    AppMethodBeat.i(95189);
    paramString = aj.fOI().bbl(paramString);
    boolean bool = a(paramString, an.D(paramString));
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
      localObject1 = an.D(paramSnsInfo);
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
    Object localObject2 = paramSnsObject.Umz;
    if (localObject2 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = paramSnsInfo.contentByteMd5;
    if (Util.isNullOrNil(paramSnsObject)) {}
    for (paramSnsInfo = g.getMessageDigest(paramSnsInfo.field_content) + g.getMessageDigest(paramSnsInfo.field_attrBuf);; paramSnsInfo = paramSnsObject)
    {
      localObject1 = (HashMap)JSY.get();
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
          ejx localejx = (ejx)paramSnsObject.next();
          localObject2 = new cje();
          try
          {
            ((cje)localObject2).parseFrom(com.tencent.mm.platformtools.z.a(localejx.Ulq));
            l += ((cje)localObject2).gbJ;
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
      JSY.set(paramSnsObject);
      AppMethodBeat.o(95194);
      return l;
    }
  }
  
  public static boolean x(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95190);
    boolean bool = a(paramSnsInfo, an.D(paramSnsInfo));
    AppMethodBeat.o(95190);
    return bool;
  }
  
  public static int y(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95192);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramSnsInfo = an.D(paramSnsInfo);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramSnsInfo = paramSnsInfo.SnsRedEnvelops;
    if ((paramSnsInfo == null) || (paramSnsInfo.Umz.size() == 0))
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    int i = paramSnsInfo.Umz.size();
    AppMethodBeat.o(95192);
    return i;
  }
  
  public static long z(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95193);
    long l = b(paramSnsInfo, null);
    AppMethodBeat.o(95193);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.m
 * JD-Core Version:    0.7.0.1
 */