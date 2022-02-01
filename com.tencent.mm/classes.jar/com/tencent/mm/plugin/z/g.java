package com.tencent.mm.plugin.z;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;

public final class g
{
  public static void e(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26543);
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfByte == null))
    {
      Log.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[] { paramString1, paramString2 });
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
      long l1 = com.tencent.mm.plugin.backup.b.g.anZ(paramString1 + paramString2);
      i = f(paramString1, paramString2, paramArrayOfByte);
      long l2 = com.tencent.mm.plugin.backup.b.g.anZ(paramString1 + paramString2);
      if ((i == 0) && (l2 >= paramArrayOfByte.length))
      {
        AppMethodBeat.o(26543);
        return;
      }
      Log.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramArrayOfByte.length) });
    }
    AppMethodBeat.o(26543);
  }
  
  public static String eVe()
  {
    AppMethodBeat.i(26540);
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = c.aHl() + "msgsynchronize/syncFile/";
    AppMethodBeat.o(26540);
    return localObject;
  }
  
  public static String eVf()
  {
    AppMethodBeat.i(26541);
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = c.aHl() + "msgsynchronize/";
    AppMethodBeat.o(26541);
    return localObject;
  }
  
  public static String eVg()
  {
    AppMethodBeat.i(26542);
    try
    {
      Object localObject = new StringBuilder();
      bh.beI();
      localObject = c.aHl() + "msgsynchronize.zip";
      q localq = new q((String)localObject);
      if (!localq.ifE()) {
        localq.ifM();
      }
      AppMethodBeat.o(26542);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", localException, "", new Object[0]);
      AppMethodBeat.o(26542);
    }
    return "";
  }
  
  private static int f(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26544);
    try
    {
      q localq = new q(paramString1);
      if (!localq.ifE()) {
        localq.ifL();
      }
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new q(paramString1);
      if (!paramString2.ifE()) {
        paramString2.ifM();
      }
      int i = u.F(paramString1, paramArrayOfByte);
      AppMethodBeat.o(26544);
      return i;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(26544);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.z.g
 * JD-Core Version:    0.7.0.1
 */