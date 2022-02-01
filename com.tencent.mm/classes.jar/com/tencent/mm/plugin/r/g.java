package com.tencent.mm.plugin.r;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public final class g
{
  public static String drB()
  {
    AppMethodBeat.i(26540);
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = c.ajw() + "msgsynchronize/syncFile/";
    AppMethodBeat.o(26540);
    return localObject;
  }
  
  public static String drC()
  {
    AppMethodBeat.i(26541);
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = c.ajw() + "msgsynchronize/";
    AppMethodBeat.o(26541);
    return localObject;
  }
  
  public static String drD()
  {
    AppMethodBeat.i(26542);
    try
    {
      Object localObject = new StringBuilder();
      bc.aCg();
      localObject = c.ajw() + "msgsynchronize.zip";
      k localk = new k((String)localObject);
      if (!localk.exists()) {
        localk.createNewFile();
      }
      AppMethodBeat.o(26542);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", localException, "", new Object[0]);
      AppMethodBeat.o(26542);
    }
    return "";
  }
  
  public static void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26543);
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfByte == null))
    {
      ae.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(26543);
      return;
    }
    int j;
    for (int i = 3;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      long l1 = com.tencent.mm.plugin.backup.b.g.Wz(paramString1 + paramString2);
      i = f(paramString1, paramString2, paramArrayOfByte);
      long l2 = com.tencent.mm.plugin.backup.b.g.Wz(paramString1 + paramString2);
      if ((i == 0) && (l2 >= paramArrayOfByte.length))
      {
        AppMethodBeat.o(26543);
        return;
      }
      ae.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramArrayOfByte.length) });
    }
    AppMethodBeat.o(26543);
  }
  
  private static int f(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26544);
    try
    {
      k localk = new k(paramString1);
      if (!localk.exists()) {
        localk.mkdirs();
      }
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new k(paramString1);
      if (!paramString2.exists()) {
        paramString2.createNewFile();
      }
      int i = o.e(paramString1, paramArrayOfByte, paramArrayOfByte.length);
      AppMethodBeat.o(26544);
      return i;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(26544);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.r.g
 * JD-Core Version:    0.7.0.1
 */