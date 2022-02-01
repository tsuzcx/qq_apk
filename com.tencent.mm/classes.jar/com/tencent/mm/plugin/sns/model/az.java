package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class az
{
  public static String E(dmz paramdmz)
  {
    AppMethodBeat.i(95958);
    if (paramdmz == null)
    {
      AppMethodBeat.o(95958);
      return null;
    }
    paramdmz = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.i(paramdmz);
    Log.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { paramdmz });
    AppMethodBeat.o(95958);
    return paramdmz;
  }
  
  public static String PW(String paramString)
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
  
  public static String a(String paramString, dmz paramdmz)
  {
    AppMethodBeat.i(95959);
    if (paramdmz == null) {
      localObject = null;
    }
    while (y.ZC((String)localObject))
    {
      Log.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      AppMethodBeat.o(95959);
      return localObject;
      localObject = as.mg(al.getAccSnsPath(), paramdmz.Id) + t.o(paramdmz);
      Log.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    paramdmz = E(paramdmz);
    boolean bool = y.ZC(paramdmz);
    Object localObject = aYH(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        Log.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, paramdmz });
        if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zxn, false))
        {
          AppMethodBeat.o(95959);
          return paramdmz;
        }
        ha(paramString, 30);
        Log.w("MicroMsg.SnsVideoLogic", "recreate VideoInfo for %s", new Object[] { paramString });
        AppMethodBeat.o(95959);
        return null;
      }
      Log.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      AppMethodBeat.o(95959);
      return null;
    }
    if ((bool) && (((z)localObject).bOx()))
    {
      Log.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, paramdmz });
      AppMethodBeat.o(95959);
      return paramdmz;
    }
    Log.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((z)localObject).status) });
    AppMethodBeat.o(95959);
    return null;
  }
  
  public static String aYF(String paramString)
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
  
  public static String aYG(String paramString)
  {
    AppMethodBeat.i(95957);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95957);
      return null;
    }
    String str = as.mg(al.getAccSnsPath(), paramString);
    Log.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    AppMethodBeat.o(95957);
    return str;
  }
  
  public static z aYH(String paramString)
  {
    AppMethodBeat.i(95963);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95963);
      return null;
    }
    paramString = ab.Qo(PW(paramString));
    AppMethodBeat.o(95963);
    return paramString;
  }
  
  public static boolean c(z paramz, int paramInt)
  {
    AppMethodBeat.i(95961);
    paramz.status = 130;
    paramz.lxk = paramInt;
    paramz.eQp = 268435712;
    boolean bool = v.bOh().c(paramz);
    Log.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { paramz.getFileName(), Boolean.valueOf(bool) });
    AppMethodBeat.o(95961);
    return bool;
  }
  
  public static String de(int paramInt, String paramString)
  {
    AppMethodBeat.i(95954);
    paramString = com.tencent.mm.modelcdntran.h.a("snsvideo", paramInt, "sns", paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95954);
      return null;
    }
    AppMethodBeat.o(95954);
    return paramString;
  }
  
  public static boolean ha(String paramString, int paramInt)
  {
    AppMethodBeat.i(95960);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      AppMethodBeat.o(95960);
      return false;
    }
    paramString = PW(paramString);
    z localz = new z();
    localz.fileName = paramString;
    localz.createTime = Util.nowSecond();
    localz.status = 130;
    localz.lxk = paramInt;
    boolean bool = v.bOh().b(localz);
    Log.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    AppMethodBeat.o(95960);
    return bool;
  }
  
  public static boolean mk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95962);
    z localz = aYH(paramString1);
    if (localz == null)
    {
      localz = new z();
      localz.fileName = PW(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      localz.createTime = Util.nowSecond();
      localz.ibd = paramString2;
      localz.status = 199;
      if (i != 0) {}
      for (boolean bool = v.bOh().b(localz);; bool = v.bOh().c(localz))
      {
        Log.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        AppMethodBeat.o(95962);
        return bool;
        localz.eQp = 33555200;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.az
 * JD-Core Version:    0.7.0.1
 */