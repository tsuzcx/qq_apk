package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.av.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class i
{
  public static String bAy()
  {
    if (!au.DK())
    {
      y.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      return null;
    }
    Object localObject = new StringBuilder();
    au.Hx();
    localObject = new b(c.FU() + "shakemusic/");
    if ((!((b)localObject).exists()) || (!((b)localObject).isDirectory()))
    {
      y.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { j.n(((b)localObject).cLr()) });
      ((b)localObject).mkdirs();
    }
    b localb = new b((b)localObject, ".nomedia");
    if (!localb.exists()) {
      y.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { j.n(((b)localObject).cLr()) });
    }
    try
    {
      localb.createNewFile();
      if (!((b)localObject).exists())
      {
        y.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ShakeMusicLogic", localIOException, "", new Object[0]);
      }
    }
    return j.n(((b)localObject).cLr()) + "/";
  }
  
  public static e d(byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    try
    {
      paramArrayOfByte = (brc)new brc().aH(paramArrayOfByte);
      e locale = new e();
      locale.euv = 4;
      locale.eux = String.valueOf(paramArrayOfByte.tHR);
      locale.euy = paramArrayOfByte.euy;
      locale.euB = aa.b(paramArrayOfByte.tfY);
      locale.euC = aa.b(paramArrayOfByte.tfZ);
      locale.euH = a.KR(locale.euC);
      locale.euw = paramArrayOfByte.euw;
      locale.euG = aa.b(paramArrayOfByte.tfX);
      locale.euz = aa.b(paramArrayOfByte.tHS);
      locale.euA = aa.b(paramArrayOfByte.tHT);
      locale.euF = aa.b(paramArrayOfByte.tHW);
      locale.euD = aa.b(paramArrayOfByte.tHU);
      locale.euE = aa.b(paramArrayOfByte.tHV);
      locale.euQ = paramLong;
      return locale;
    }
    catch (Exception paramArrayOfByte)
    {
      y.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      y.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */