package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ay
{
  public static String E(cnb paramcnb)
  {
    AppMethodBeat.i(95958);
    if (paramcnb == null)
    {
      AppMethodBeat.o(95958);
      return null;
    }
    paramcnb = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.j(paramcnb);
    Log.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { paramcnb });
    AppMethodBeat.o(95958);
    return paramcnb;
  }
  
  public static String Qv(String paramString)
  {
    AppMethodBeat.i(95955);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95955);
      return "";
    }
    String str = "SNS_".concat(String.valueOf(paramString));
    Log.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[] { paramString, str });
    AppMethodBeat.o(95955);
    return str;
  }
  
  public static String a(String paramString, cnb paramcnb)
  {
    AppMethodBeat.i(95959);
    if (paramcnb == null) {
      localObject = null;
    }
    while (com.tencent.mm.vfs.s.YS((String)localObject))
    {
      Log.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(95959);
      return localObject;
      localObject = ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.p(paramcnb);
      Log.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    paramcnb = E(paramcnb);
    boolean bool = com.tencent.mm.vfs.s.YS(paramcnb);
    Object localObject = aPs(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        Log.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, paramcnb });
        AppMethodBeat.o(95959);
        return paramcnb;
      }
      Log.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(95959);
      return null;
    }
    if ((bool) && (((com.tencent.mm.modelvideo.s)localObject).bhy()))
    {
      Log.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, paramcnb });
      AppMethodBeat.o(95959);
      return paramcnb;
    }
    Log.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.modelvideo.s)localObject).status) });
    AppMethodBeat.o(95959);
    return null;
  }
  
  public static String aPq(String paramString)
  {
    AppMethodBeat.i(95956);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95956);
      return "";
    }
    int i = paramString.indexOf("SNS_");
    if (i < 0)
    {
      AppMethodBeat.o(95956);
      return "";
    }
    String str = "";
    try
    {
      paramString = paramString.substring(i + 4);
      AppMethodBeat.o(95956);
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
  
  public static String aPr(String paramString)
  {
    AppMethodBeat.i(95957);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95957);
      return null;
    }
    String str = ar.ki(aj.getAccSnsPath(), paramString);
    Log.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(95957);
    return str;
  }
  
  public static com.tencent.mm.modelvideo.s aPs(String paramString)
  {
    AppMethodBeat.i(95963);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95963);
      return null;
    }
    paramString = u.QN(Qv(paramString));
    AppMethodBeat.o(95963);
    return paramString;
  }
  
  public static boolean c(com.tencent.mm.modelvideo.s params, int paramInt)
  {
    AppMethodBeat.i(95961);
    params.status = 130;
    params.gqW = paramInt;
    params.cSx = 268435712;
    boolean bool = o.bhj().c(params);
    Log.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { params.getFileName(), Boolean.valueOf(bool) });
    AppMethodBeat.o(95961);
    return bool;
  }
  
  public static String cs(int paramInt, String paramString)
  {
    AppMethodBeat.i(95954);
    paramString = c.a("snsvideo", paramInt, "sns", paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95954);
      return null;
    }
    AppMethodBeat.o(95954);
    return paramString;
  }
  
  public static boolean fE(String paramString, int paramInt)
  {
    AppMethodBeat.i(95960);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(95960);
      return false;
    }
    paramString = Qv(paramString);
    com.tencent.mm.modelvideo.s locals = new com.tencent.mm.modelvideo.s();
    locals.fileName = paramString;
    locals.createTime = Util.nowSecond();
    locals.status = 130;
    locals.gqW = paramInt;
    boolean bool = o.bhj().b(locals);
    Log.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(95960);
    return bool;
  }
  
  public static boolean kk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95962);
    com.tencent.mm.modelvideo.s locals = aPs(paramString1);
    if (locals == null)
    {
      locals = new com.tencent.mm.modelvideo.s();
      locals.fileName = Qv(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      locals.createTime = Util.nowSecond();
      locals.ebj = paramString2;
      locals.status = 199;
      if (i != 0) {}
      for (boolean bool = o.bhj().b(locals);; bool = o.bhj().c(locals))
      {
        Log.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(95962);
        return bool;
        locals.cSx = 33555200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ay
 * JD-Core Version:    0.7.0.1
 */