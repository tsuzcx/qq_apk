package com.tencent.mm.plugin.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

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
      long l1 = com.tencent.mm.plugin.backup.b.g.agv(paramString1 + paramString2);
      i = f(paramString1, paramString2, paramArrayOfByte);
      long l2 = com.tencent.mm.plugin.backup.b.g.agv(paramString1 + paramString2);
      if ((i == 0) && (l2 >= paramArrayOfByte.length))
      {
        AppMethodBeat.o(26543);
        return;
      }
      Log.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramArrayOfByte.length) });
    }
    AppMethodBeat.o(26543);
  }
  
  public static String elv()
  {
    AppMethodBeat.i(26540);
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = c.azM() + "msgsynchronize/syncFile/";
    AppMethodBeat.o(26540);
    return localObject;
  }
  
  public static String elw()
  {
    AppMethodBeat.i(26541);
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = c.azM() + "msgsynchronize/";
    AppMethodBeat.o(26541);
    return localObject;
  }
  
  public static String elx()
  {
    AppMethodBeat.i(26542);
    try
    {
      Object localObject = new StringBuilder();
      bg.aVF();
      localObject = c.azM() + "msgsynchronize.zip";
      o localo = new o((String)localObject);
      if (!localo.exists()) {
        localo.createNewFile();
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
      o localo = new o(paramString1);
      if (!localo.exists()) {
        localo.mkdirs();
      }
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new o(paramString1);
      if (!paramString2.exists()) {
        paramString2.createNewFile();
      }
      int i = s.e(paramString1, paramArrayOfByte, paramArrayOfByte.length);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.q.g
 * JD-Core Version:    0.7.0.1
 */