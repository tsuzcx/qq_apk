package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class av
{
  public static String D(byn parambyn)
  {
    AppMethodBeat.i(95958);
    if (parambyn == null)
    {
      AppMethodBeat.o(95958);
      return null;
    }
    parambyn = ao.jo(ag.getAccSnsPath(), parambyn.Id) + q.i(parambyn);
    ad.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { parambyn });
    AppMethodBeat.o(95958);
    return parambyn;
  }
  
  public static String Hg(String paramString)
  {
    AppMethodBeat.i(95955);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95955);
      return "";
    }
    String str = "SNS_".concat(String.valueOf(paramString));
    ad.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[] { paramString, str });
    AppMethodBeat.o(95955);
    return str;
  }
  
  public static String a(String paramString, byn parambyn)
  {
    AppMethodBeat.i(95959);
    if (parambyn == null) {
      localObject = null;
    }
    while (i.fv((String)localObject))
    {
      ad.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(95959);
      return localObject;
      localObject = ao.jo(ag.getAccSnsPath(), parambyn.Id) + q.o(parambyn);
      ad.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    parambyn = D(parambyn);
    boolean bool = i.fv(parambyn);
    Object localObject = azf(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        ad.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, parambyn });
        AppMethodBeat.o(95959);
        return parambyn;
      }
      ad.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(95959);
      return null;
    }
    if ((bool) && (((s)localObject).aMY()))
    {
      ad.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, parambyn });
      AppMethodBeat.o(95959);
      return parambyn;
    }
    ad.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((s)localObject).status) });
    AppMethodBeat.o(95959);
    return null;
  }
  
  public static String azd(String paramString)
  {
    AppMethodBeat.i(95956);
    if (bt.isNullOrNil(paramString))
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
  
  public static String aze(String paramString)
  {
    AppMethodBeat.i(95957);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95957);
      return null;
    }
    String str = ao.jo(ag.getAccSnsPath(), paramString);
    ad.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(95957);
    return str;
  }
  
  public static s azf(String paramString)
  {
    AppMethodBeat.i(95963);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95963);
      return null;
    }
    paramString = u.Hy(Hg(paramString));
    AppMethodBeat.o(95963);
    return paramString;
  }
  
  public static boolean c(s params, int paramInt)
  {
    AppMethodBeat.i(95961);
    params.status = 130;
    params.fJH = paramInt;
    params.dDp = 268435712;
    boolean bool = o.aMJ().c(params);
    ad.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { params.getFileName(), Boolean.valueOf(bool) });
    AppMethodBeat.o(95961);
    return bool;
  }
  
  public static String cb(int paramInt, String paramString)
  {
    AppMethodBeat.i(95954);
    paramString = c.a("snsvideo", paramInt, "sns", paramString);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95954);
      return null;
    }
    AppMethodBeat.o(95954);
    return paramString;
  }
  
  public static boolean eX(String paramString, int paramInt)
  {
    AppMethodBeat.i(95960);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(95960);
      return false;
    }
    paramString = Hg(paramString);
    s locals = new s();
    locals.fileName = paramString;
    locals.createTime = bt.aQJ();
    locals.status = 130;
    locals.fJH = paramInt;
    boolean bool = o.aMJ().b(locals);
    ad.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(95960);
    return bool;
  }
  
  public static boolean jq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95962);
    s locals = azf(paramString1);
    if (locals == null)
    {
      locals = new s();
      locals.fileName = Hg(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      locals.createTime = bt.aQJ();
      locals.dIs = paramString2;
      locals.status = 199;
      if (i != 0) {}
      for (boolean bool = o.aMJ().b(locals);; bool = o.aMJ().c(locals))
      {
        ad.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(95962);
        return bool;
        locals.dDp = 33555200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.av
 * JD-Core Version:    0.7.0.1
 */