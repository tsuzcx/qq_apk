package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class aw
{
  public static String D(bzh parambzh)
  {
    AppMethodBeat.i(95958);
    if (parambzh == null)
    {
      AppMethodBeat.o(95958);
      return null;
    }
    parambzh = ap.jv(ah.getAccSnsPath(), parambzh.Id) + r.i(parambzh);
    ae.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { parambzh });
    AppMethodBeat.o(95958);
    return parambzh;
  }
  
  public static String HI(String paramString)
  {
    AppMethodBeat.i(95955);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95955);
      return "";
    }
    String str = "SNS_".concat(String.valueOf(paramString));
    ae.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[] { paramString, str });
    AppMethodBeat.o(95955);
    return str;
  }
  
  public static String a(String paramString, bzh parambzh)
  {
    AppMethodBeat.i(95959);
    if (parambzh == null) {
      localObject = null;
    }
    while (com.tencent.mm.vfs.o.fB((String)localObject))
    {
      ae.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(95959);
      return localObject;
      localObject = ap.jv(ah.getAccSnsPath(), parambzh.Id) + r.o(parambzh);
      ae.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    parambzh = D(parambzh);
    boolean bool = com.tencent.mm.vfs.o.fB(parambzh);
    Object localObject = aAw(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        ae.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, parambzh });
        AppMethodBeat.o(95959);
        return parambzh;
      }
      ae.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(95959);
      return null;
    }
    if ((bool) && (((s)localObject).aNw()))
    {
      ae.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, parambzh });
      AppMethodBeat.o(95959);
      return parambzh;
    }
    ae.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((s)localObject).status) });
    AppMethodBeat.o(95959);
    return null;
  }
  
  public static String aAu(String paramString)
  {
    AppMethodBeat.i(95956);
    if (bu.isNullOrNil(paramString))
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
  
  public static String aAv(String paramString)
  {
    AppMethodBeat.i(95957);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95957);
      return null;
    }
    String str = ap.jv(ah.getAccSnsPath(), paramString);
    ae.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(95957);
    return str;
  }
  
  public static s aAw(String paramString)
  {
    AppMethodBeat.i(95963);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95963);
      return null;
    }
    paramString = u.Ia(HI(paramString));
    AppMethodBeat.o(95963);
    return paramString;
  }
  
  public static boolean c(s params, int paramInt)
  {
    AppMethodBeat.i(95961);
    params.status = 130;
    params.fLK = paramInt;
    params.dEu = 268435712;
    boolean bool = com.tencent.mm.modelvideo.o.aNh().c(params);
    ae.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { params.getFileName(), Boolean.valueOf(bool) });
    AppMethodBeat.o(95961);
    return bool;
  }
  
  public static String cb(int paramInt, String paramString)
  {
    AppMethodBeat.i(95954);
    paramString = c.a("snsvideo", paramInt, "sns", paramString);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95954);
      return null;
    }
    AppMethodBeat.o(95954);
    return paramString;
  }
  
  public static boolean fg(String paramString, int paramInt)
  {
    AppMethodBeat.i(95960);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(95960);
      return false;
    }
    paramString = HI(paramString);
    s locals = new s();
    locals.fileName = paramString;
    locals.createTime = bu.aRi();
    locals.status = 130;
    locals.fLK = paramInt;
    boolean bool = com.tencent.mm.modelvideo.o.aNh().b(locals);
    ae.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(95960);
    return bool;
  }
  
  public static boolean jx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95962);
    s locals = aAw(paramString1);
    if (locals == null)
    {
      locals = new s();
      locals.fileName = HI(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      locals.createTime = bu.aRi();
      locals.dJw = paramString2;
      locals.status = 199;
      if (i != 0) {}
      for (boolean bool = com.tencent.mm.modelvideo.o.aNh().b(locals);; bool = com.tencent.mm.modelvideo.o.aNh().c(locals))
      {
        ae.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(95962);
        return bool;
        locals.dEu = 33555200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw
 * JD-Core Version:    0.7.0.1
 */