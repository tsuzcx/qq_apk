package com.tencent.mm.plugin.x;

import android.text.TextUtils;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class g
{
  public static String bkx()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return c.FT() + "msgsynchronize/syncFile/";
  }
  
  public static String bky()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    au.Hx();
    return c.FT() + "msgsynchronize/";
  }
  
  public static String bkz()
  {
    try
    {
      Object localObject = new StringBuilder();
      au.Hx();
      localObject = c.FT() + "msgsynchronize.zip";
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", localException, "", new Object[0]);
    }
    return "";
  }
  
  public static void f(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramArrayOfByte == null))
    {
      y.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[] { paramString1, paramString2 });
      return;
    }
    int j;
    for (int i = 3;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      long l1 = com.tencent.mm.plugin.backup.b.g.xn(paramString1 + paramString2);
      i = g(paramString1, paramString2, paramArrayOfByte);
      long l2 = com.tencent.mm.plugin.backup.b.g.xn(paramString1 + paramString2);
      if ((i == 0) && (l2 >= paramArrayOfByte.length)) {
        break;
      }
      y.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(paramArrayOfByte.length) });
    }
  }
  
  private static int g(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      File localFile = new File(paramString1);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramString1 = paramString1 + "/" + paramString2;
      paramString2 = new File(paramString1);
      if (!paramString2.exists()) {
        paramString2.createNewFile();
      }
      int i = e.a(paramString1, paramArrayOfByte, paramArrayOfByte.length);
      return i;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.MsgSynchronizeUtil", paramString1, "", new Object[0]);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.x.g
 * JD-Core Version:    0.7.0.1
 */