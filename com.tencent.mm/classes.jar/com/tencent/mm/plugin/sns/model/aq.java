package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ak.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class aq
{
  public static String D(awd paramawd)
  {
    if (paramawd == null) {
      return null;
    }
    paramawd = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.j(paramawd);
    y.i("MicroMsg.SnsVideoLogic", "get sns video path %s", new Object[] { paramawd });
    return paramawd;
  }
  
  public static String NK(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    int i = paramString.indexOf("SNS_");
    if (i < 0) {
      return "";
    }
    try
    {
      paramString = paramString.substring(i + 4);
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String NL(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    String str = an.eJ(af.getAccSnsPath(), paramString);
    y.i("MicroMsg.SnsVideoLogic", "get sns video dir %s mediaId %s", new Object[] { str, paramString });
    return str;
  }
  
  public static s NM(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return u.oe(nR(paramString));
  }
  
  public static String a(String paramString, awd paramawd)
  {
    if (paramawd == null) {
      localObject = null;
    }
    while (e.bK((String)localObject))
    {
      y.i("MicroMsg.SnsVideoLogic", "it needn't download video[%s] because of the video is self. %s", new Object[] { paramString, localObject });
      return localObject;
      localObject = an.eJ(af.getAccSnsPath(), paramawd.lsK) + i.p(paramawd);
      y.i("MicroMsg.SnsVideoLogic", "get sns video tmp path %s", new Object[] { localObject });
    }
    paramawd = D(paramawd);
    boolean bool = e.bK(paramawd);
    Object localObject = NM(paramString);
    if (localObject == null)
    {
      if (bool)
      {
        y.i("MicroMsg.SnsVideoLogic", "it old version already download video[%s]. path :%s", new Object[] { paramString, paramawd });
        return paramawd;
      }
      y.i("MicroMsg.SnsVideoLogic", "video info is null and file is no exists, return null.[%s]", new Object[] { paramString });
      return null;
    }
    if ((bool) && (((s)localObject).SG()))
    {
      y.i("MicroMsg.SnsVideoLogic", "it had download sns video[%s] finish. %s", new Object[] { paramString, paramawd });
      return paramawd;
    }
    y.i("MicroMsg.SnsVideoLogic", "it don't download video[%s] finish. file[%b] status[%d], return null.", new Object[] { paramString, Boolean.valueOf(bool), Integer.valueOf(((s)localObject).status) });
    return null;
  }
  
  public static String aI(int paramInt, String paramString)
  {
    String str = c.a("snsvideo", paramInt, "sns", paramString);
    paramString = str;
    if (bk.bl(str)) {
      paramString = null;
    }
    return paramString;
  }
  
  public static boolean c(s params, int paramInt)
  {
    params.status = 130;
    params.dmi = paramInt;
    params.bcw = 268435712;
    boolean bool = o.Sr().c(params);
    y.i("MicroMsg.SnsVideoLogic", "update sns Record filename %s, update %b", new Object[] { params.getFileName(), Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean ct(String paramString, int paramInt)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.SnsVideoLogic", "init sns record, but snsLocalId is null");
      return false;
    }
    paramString = nR(paramString);
    s locals = new s();
    locals.fileName = paramString;
    locals.createTime = bk.UX();
    locals.status = 130;
    locals.dmi = paramInt;
    boolean bool = o.Sr().b(locals);
    y.i("MicroMsg.SnsVideoLogic", "init sns Record filename %s, insert %b", new Object[] { paramString, Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean eL(String paramString1, String paramString2)
  {
    s locals = NM(paramString1);
    if (locals == null)
    {
      locals = new s();
      locals.fileName = nR(paramString1);
    }
    for (int i = 1;; i = 0)
    {
      locals.createTime = bk.UX();
      locals.bZs = paramString2;
      locals.status = 199;
      if (i != 0) {}
      for (boolean bool = o.Sr().b(locals);; bool = o.Sr().c(locals))
      {
        y.i("MicroMsg.SnsVideoLogic", "post sns video snsLocalId %s, md5 %s ret %b", new Object[] { paramString1, paramString2, Boolean.valueOf(bool) });
        return bool;
        locals.bcw = 33555200;
      }
    }
  }
  
  public static String nR(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    String str = "SNS_" + paramString;
    y.d("MicroMsg.SnsVideoLogic", "gen sns[%s] video file name [%s]", new Object[] { paramString, str });
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aq
 * JD-Core Version:    0.7.0.1
 */