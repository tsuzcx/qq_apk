package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class au
{
  public static String D(btz parambtz)
  {
    AppMethodBeat.i(95958);
    if (parambtz == null)
    {
      AppMethodBeat.o(95958);
      return null;
    }
    parambtz = an.jc(af.getAccSnsPath(), parambtz.Id) + q.i(parambtz);
    ac.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { parambtz });
    AppMethodBeat.o(95958);
    return parambtz;
  }
  
  public static String DU(String paramString)
  {
    AppMethodBeat.i(95955);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95955);
      return "";
    }
    String str = "SNS_".concat(String.valueOf(paramString));
    ac.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[] { paramString, str });
    AppMethodBeat.o(95955);
    return str;
  }
  
  public static String a(String paramString, btz parambtz)
  {
    AppMethodBeat.i(95959);
    if (parambtz == null) {
      localObject = null;
    }
    while (i.eA((String)localObject))
    {
      ac.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(95959);
      return localObject;
      localObject = an.jc(af.getAccSnsPath(), parambtz.Id) + q.o(parambtz);
      ac.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    parambtz = D(parambtz);
    boolean bool = i.eA(parambtz);
    Object localObject = aua(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        ac.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, parambtz });
        AppMethodBeat.o(95959);
        return parambtz;
      }
      ac.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(95959);
      return null;
    }
    if ((bool) && (((s)localObject).aJN()))
    {
      ac.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, parambtz });
      AppMethodBeat.o(95959);
      return parambtz;
    }
    ac.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((s)localObject).status) });
    AppMethodBeat.o(95959);
    return null;
  }
  
  public static String atY(String paramString)
  {
    AppMethodBeat.i(95956);
    if (bs.isNullOrNil(paramString))
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
  
  public static String atZ(String paramString)
  {
    AppMethodBeat.i(95957);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95957);
      return null;
    }
    String str = an.jc(af.getAccSnsPath(), paramString);
    ac.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(95957);
    return str;
  }
  
  public static s aua(String paramString)
  {
    AppMethodBeat.i(95963);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95963);
      return null;
    }
    paramString = u.Ej(DU(paramString));
    AppMethodBeat.o(95963);
    return paramString;
  }
  
  public static String bU(int paramInt, String paramString)
  {
    AppMethodBeat.i(95954);
    paramString = c.a("snsvideo", paramInt, "sns", paramString);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95954);
      return null;
    }
    AppMethodBeat.o(95954);
    return paramString;
  }
  
  public static boolean c(s params, int paramInt)
  {
    AppMethodBeat.i(95961);
    params.status = 130;
    params.fry = paramInt;
    params.drx = 268435712;
    boolean bool = o.aJy().c(params);
    ac.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { params.getFileName(), Boolean.valueOf(bool) });
    AppMethodBeat.o(95961);
    return bool;
  }
  
  public static boolean eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(95960);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(95960);
      return false;
    }
    paramString = DU(paramString);
    s locals = new s();
    locals.fileName = paramString;
    locals.createTime = bs.aNx();
    locals.status = 130;
    locals.fry = paramInt;
    boolean bool = o.aJy().b(locals);
    ac.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(95960);
    return bool;
  }
  
  public static boolean je(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95962);
    s locals = aua(paramString1);
    if (locals == null)
    {
      locals = new s();
      locals.fileName = DU(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      locals.createTime = bs.aNx();
      locals.dwi = paramString2;
      locals.status = 199;
      if (i != 0) {}
      for (boolean bool = o.aJy().b(locals);; bool = o.aJy().c(locals))
      {
        ac.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(95962);
        return bool;
        locals.drx = 33555200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.au
 * JD-Core Version:    0.7.0.1
 */