package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.c;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class ax
{
  public static String E(cvt paramcvt)
  {
    AppMethodBeat.i(95958);
    if (paramcvt == null)
    {
      AppMethodBeat.o(95958);
      return null;
    }
    paramcvt = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.i(paramcvt);
    Log.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { paramcvt });
    AppMethodBeat.o(95958);
    return paramcvt;
  }
  
  public static String XS(String paramString)
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
  
  public static String a(String paramString, cvt paramcvt)
  {
    AppMethodBeat.i(95959);
    if (paramcvt == null) {
      localObject = null;
    }
    while (u.agG((String)localObject))
    {
      Log.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(95959);
      return localObject;
      localObject = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + t.o(paramcvt);
      Log.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    paramcvt = E(paramcvt);
    boolean bool = u.agG(paramcvt);
    Object localObject = bao(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        Log.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, paramcvt });
        AppMethodBeat.o(95959);
        return paramcvt;
      }
      Log.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(95959);
      return null;
    }
    if ((bool) && (((w)localObject).bqS()))
    {
      Log.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, paramcvt });
      AppMethodBeat.o(95959);
      return paramcvt;
    }
    Log.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((w)localObject).status) });
    AppMethodBeat.o(95959);
    return null;
  }
  
  public static String bam(String paramString)
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
  
  public static String ban(String paramString)
  {
    AppMethodBeat.i(95957);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95957);
      return null;
    }
    String str = aq.kD(aj.getAccSnsPath(), paramString);
    Log.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(95957);
    return str;
  }
  
  public static w bao(String paramString)
  {
    AppMethodBeat.i(95963);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95963);
      return null;
    }
    paramString = y.Yk(XS(paramString));
    AppMethodBeat.o(95963);
    return paramString;
  }
  
  public static boolean c(w paramw, int paramInt)
  {
    AppMethodBeat.i(95961);
    paramw.status = 130;
    paramw.iVf = paramInt;
    paramw.cUP = 268435712;
    boolean bool = s.bqB().c(paramw);
    Log.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { paramw.getFileName(), Boolean.valueOf(bool) });
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
  
  public static boolean gh(String paramString, int paramInt)
  {
    AppMethodBeat.i(95960);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(95960);
      return false;
    }
    paramString = XS(paramString);
    w localw = new w();
    localw.fileName = paramString;
    localw.createTime = Util.nowSecond();
    localw.status = 130;
    localw.iVf = paramInt;
    boolean bool = s.bqB().b(localw);
    Log.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(95960);
    return bool;
  }
  
  public static boolean kF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95962);
    w localw = bao(paramString1);
    if (localw == null)
    {
      localw = new w();
      localw.fileName = XS(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      localw.createTime = Util.nowSecond();
      localw.fVg = paramString2;
      localw.status = 199;
      if (i != 0) {}
      for (boolean bool = s.bqB().b(localw);; bool = s.bqB().c(localw))
      {
        Log.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(95962);
        return bool;
        localw.cUP = 33555200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax
 * JD-Core Version:    0.7.0.1
 */