package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.fef;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  private static final ThreadLocal<HashMap<String, Long>> Qqa;
  
  static
  {
    AppMethodBeat.i(95195);
    Qqa = new ThreadLocal();
    AppMethodBeat.o(95195);
  }
  
  public static long A(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95193);
    long l = b(paramSnsInfo, null);
    AppMethodBeat.o(95193);
    return l;
  }
  
  public static boolean a(SnsInfo paramSnsInfo, SnsObject paramSnsObject)
  {
    AppMethodBeat.i(95191);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    dna localdna = paramSnsInfo.getPostInfo();
    if (paramSnsInfo.getTypeFlag() != 21)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (localdna.ihz == 1)
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (z.bAM().equals(paramSnsInfo.getUserName()))
    {
      AppMethodBeat.o(95191);
      return true;
    }
    if (paramSnsObject.SnsRedEnvelops != null)
    {
      paramSnsObject = paramSnsObject.SnsRedEnvelops.abEG;
      if ((paramSnsObject == null) || (paramSnsObject.size() == 0))
      {
        AppMethodBeat.o(95191);
        return false;
      }
      paramSnsInfo = z.bAM();
      paramSnsObject = paramSnsObject.iterator();
      while (paramSnsObject.hasNext()) {
        if (paramSnsInfo.equals(((fef)paramSnsObject.next()).Username))
        {
          AppMethodBeat.o(95191);
          return true;
        }
      }
    }
    AppMethodBeat.o(95191);
    return false;
  }
  
  public static boolean aXP(String paramString)
  {
    AppMethodBeat.i(95189);
    paramString = al.hgB().aZL(paramString);
    boolean bool = a(paramString, ap.E(paramString));
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
      localObject1 = ap.E(paramSnsInfo);
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
    Object localObject2 = paramSnsObject.abEG;
    if (localObject2 == null)
    {
      AppMethodBeat.o(95194);
      return 0L;
    }
    paramSnsObject = paramSnsInfo.contentByteMd5;
    if (Util.isNullOrNil(paramSnsObject)) {}
    for (paramSnsInfo = g.getMessageDigest(paramSnsInfo.field_content) + g.getMessageDigest(paramSnsInfo.field_attrBuf);; paramSnsInfo = paramSnsObject)
    {
      localObject1 = (HashMap)Qqa.get();
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
          fef localfef = (fef)paramSnsObject.next();
          localObject2 = new czh();
          try
          {
            ((czh)localObject2).parseFrom(com.tencent.mm.platformtools.w.a(localfef.abDk));
            l += ((czh)localObject2).ihV;
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
      Qqa.set(paramSnsObject);
      AppMethodBeat.o(95194);
      return l;
    }
  }
  
  public static boolean y(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95190);
    boolean bool = a(paramSnsInfo, ap.E(paramSnsInfo));
    AppMethodBeat.o(95190);
    return bool;
  }
  
  public static int z(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(95192);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramSnsInfo = ap.E(paramSnsInfo);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    paramSnsInfo = paramSnsInfo.SnsRedEnvelops;
    if ((paramSnsInfo == null) || (paramSnsInfo.abEG.size() == 0))
    {
      AppMethodBeat.o(95192);
      return 0;
    }
    int i = paramSnsInfo.abEG.size();
    AppMethodBeat.o(95192);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.a.m
 * JD-Core Version:    0.7.0.1
 */