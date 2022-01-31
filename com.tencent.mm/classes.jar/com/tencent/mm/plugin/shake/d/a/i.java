package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.IOException;

public final class i
{
  public static String clS()
  {
    AppMethodBeat.i(24636);
    if (!aw.RG())
    {
      ab.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(24636);
      return null;
    }
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = new b(c.getAccPath() + "shakemusic/");
    if ((!((b)localObject).exists()) || (!((b)localObject).isDirectory()))
    {
      ab.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { j.p(((b)localObject).dQJ()) });
      ((b)localObject).mkdirs();
    }
    b localb = new b((b)localObject, ".nomedia");
    if (!localb.exists()) {
      ab.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { j.p(((b)localObject).dQJ()) });
    }
    try
    {
      localb.createNewFile();
      if (!((b)localObject).exists())
      {
        ab.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
        AppMethodBeat.o(24636);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ShakeMusicLogic", localIOException, "", new Object[0]);
      }
      localObject = j.p(((b)localObject).dQJ()) + "/";
      AppMethodBeat.o(24636);
    }
    return localObject;
  }
  
  public static e d(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(24637);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(24637);
      return null;
    }
    try
    {
      paramArrayOfByte = (cbn)new cbn().parseFrom(paramArrayOfByte);
      e locale = new e();
      locale.fKh = 4;
      locale.fKj = String.valueOf(paramArrayOfByte.xMj);
      locale.fKk = paramArrayOfByte.fKk;
      locale.fKn = aa.b(paramArrayOfByte.xex);
      locale.fKo = aa.b(paramArrayOfByte.xey);
      locale.fKt = a.WX(locale.fKo);
      locale.fKi = paramArrayOfByte.fKi;
      locale.fKs = aa.b(paramArrayOfByte.xew);
      locale.fKl = aa.b(paramArrayOfByte.xMk);
      locale.fKm = aa.b(paramArrayOfByte.xMl);
      locale.fKr = aa.b(paramArrayOfByte.xMo);
      locale.fKp = aa.b(paramArrayOfByte.xMm);
      locale.fKq = aa.b(paramArrayOfByte.xMn);
      locale.fKC = paramLong;
      AppMethodBeat.o(24637);
      return locale;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      ab.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(24637);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */