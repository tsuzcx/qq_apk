package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class ar
{
  public static String D(bcs parambcs)
  {
    AppMethodBeat.i(36638);
    if (parambcs == null)
    {
      AppMethodBeat.o(36638);
      return null;
    }
    parambcs = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.j(parambcs);
    ab.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { parambcs });
    AppMethodBeat.o(36638);
    return parambcs;
  }
  
  public static String a(String paramString, bcs parambcs)
  {
    AppMethodBeat.i(36639);
    if (parambcs == null) {
      localObject = null;
    }
    while (e.cN((String)localObject))
    {
      ab.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(36639);
      return localObject;
      localObject = ao.gl(ag.getAccSnsPath(), parambcs.Id) + i.p(parambcs);
      ab.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    parambcs = D(parambcs);
    boolean bool = e.cN(parambcs);
    Object localObject = aaG(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        ab.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, parambcs });
        AppMethodBeat.o(36639);
        return parambcs;
      }
      ab.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(36639);
      return null;
    }
    if ((bool) && (((s)localObject).alS()))
    {
      ab.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, parambcs });
      AppMethodBeat.o(36639);
      return parambcs;
    }
    ab.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((s)localObject).status) });
    AppMethodBeat.o(36639);
    return null;
  }
  
  public static String aaE(String paramString)
  {
    AppMethodBeat.i(36636);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36636);
      return "";
    }
    int i = paramString.indexOf("SNS_");
    if (i < 0)
    {
      AppMethodBeat.o(36636);
      return "";
    }
    String str = "";
    try
    {
      paramString = paramString.substring(i + 4);
      AppMethodBeat.o(36636);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = str;
      }
    }
  }
  
  public static String aaF(String paramString)
  {
    AppMethodBeat.i(36637);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36637);
      return null;
    }
    String str = ao.gl(ag.getAccSnsPath(), paramString);
    ab.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(36637);
    return str;
  }
  
  public static s aaG(String paramString)
  {
    AppMethodBeat.i(36643);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36643);
      return null;
    }
    paramString = u.vr(ve(paramString));
    AppMethodBeat.o(36643);
    return paramString;
  }
  
  public static String be(int paramInt, String paramString)
  {
    AppMethodBeat.i(36634);
    paramString = c.a("snsvideo", paramInt, "sns", paramString);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36634);
      return null;
    }
    AppMethodBeat.o(36634);
    return paramString;
  }
  
  public static boolean c(s params, int paramInt)
  {
    AppMethodBeat.i(36641);
    params.status = 130;
    params.edL = paramInt;
    params.bsY = 268435712;
    boolean bool = o.alE().c(params);
    ab.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { params.getFileName(), Boolean.valueOf(bool) });
    AppMethodBeat.o(36641);
    return bool;
  }
  
  public static boolean dp(String paramString, int paramInt)
  {
    AppMethodBeat.i(36640);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(36640);
      return false;
    }
    paramString = ve(paramString);
    s locals = new s();
    locals.fileName = paramString;
    locals.createTime = bo.aox();
    locals.status = 130;
    locals.edL = paramInt;
    boolean bool = o.alE().b(locals);
    ab.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(36640);
    return bool;
  }
  
  public static boolean gn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(36642);
    s locals = aaG(paramString1);
    if (locals == null)
    {
      locals = new s();
      locals.fileName = ve(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      locals.createTime = bo.aox();
      locals.cHH = paramString2;
      locals.status = 199;
      if (i != 0) {}
      for (boolean bool = o.alE().b(locals);; bool = o.alE().c(locals))
      {
        ab.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(36642);
        return bool;
        locals.bsY = 33555200;
      }
    }
  }
  
  public static String ve(String paramString)
  {
    AppMethodBeat.i(36635);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36635);
      return "";
    }
    String str = "SNS_".concat(String.valueOf(paramString));
    ab.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[] { paramString, str });
    AppMethodBeat.o(36635);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar
 * JD-Core Version:    0.7.0.1
 */