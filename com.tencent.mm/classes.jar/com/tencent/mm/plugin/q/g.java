package com.tencent.mm.plugin.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;

public final class g
{
  public static String bSx()
  {
    AppMethodBeat.i(22916);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = c.Rp() + "msgsynchronize/syncFile/";
    AppMethodBeat.o(22916);
    return localObject;
  }
  
  public static String bSy()
  {
    AppMethodBeat.i(22917);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = c.Rp() + "msgsynchronize/";
    AppMethodBeat.o(22917);
    return localObject;
  }
  
  public static String bSz()
  {
    AppMethodBeat.i(22918);
    try
    {
      Object localObject = new StringBuilder();
      aw.aaz();
      localObject = c.Rp() + "msgsynchronize.zip";
      b localb = new b((String)localObject);
      if (!localb.exists()) {
        localb.createNewFile();
      }
      AppMethodBeat.o(22918);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", localException, "", new Object[0]);
      AppMethodBeat.o(22918);
    }
    return "";
  }
  
  public static void f(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22919);
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfByte == null))
    {
      ab.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(22919);
      return;
    }
    int j;
    for (int i = 3;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      long l1 = com.tencent.mm.plugin.backup.b.g.Gf(paramString1 + paramString2);
      i = g(paramString1, paramString2, paramArrayOfByte);
      long l2 = com.tencent.mm.plugin.backup.b.g.Gf(paramString1 + paramString2);
      if ((i == 0) && (l2 >= paramArrayOfByte.length))
      {
        AppMethodBeat.o(22919);
        return;
      }
      ab.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramArrayOfByte.length) });
    }
    AppMethodBeat.o(22919);
  }
  
  private static int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22920);
    try
    {
      b localb = new b(paramString1);
      if (!localb.exists()) {
        localb.mkdirs();
      }
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new b(paramString1);
      if (!paramString2.exists()) {
        paramString2.createNewFile();
      }
      int i = e.a(paramString1, paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(22920);
      return i;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(22920);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.q.g
 * JD-Core Version:    0.7.0.1
 */