package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public final class i
{
  public static f e(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(28307);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(28307);
      return null;
    }
    try
    {
      paramArrayOfByte = (dwz)new dwz().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.jeT = 4;
      localf.jeV = String.valueOf(paramArrayOfByte.MWY);
      localf.jeW = paramArrayOfByte.jeW;
      localf.jeZ = z.b(paramArrayOfByte.LZW);
      localf.jfa = z.b(paramArrayOfByte.LZX);
      localf.jff = a.aKj(localf.jfa);
      localf.jeU = paramArrayOfByte.jeU;
      localf.jfe = z.b(paramArrayOfByte.LZV);
      localf.jeX = z.b(paramArrayOfByte.MWZ);
      localf.jeY = z.b(paramArrayOfByte.MXa);
      localf.jfd = z.b(paramArrayOfByte.MXd);
      localf.jfb = z.b(paramArrayOfByte.MXb);
      localf.jfc = z.b(paramArrayOfByte.MXc);
      localf.jfo = paramLong;
      AppMethodBeat.o(28307);
      return localf;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      Log.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(28307);
    }
    return null;
  }
  
  public static String eUQ()
  {
    AppMethodBeat.i(28306);
    if (!bg.aAc())
    {
      Log.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    bg.aVF();
    localObject = new o(c.getAccPath() + "shakemusic/");
    if ((!((o)localObject).exists()) || (!((o)localObject).isDirectory()))
    {
      Log.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { aa.z(((o)localObject).her()) });
      ((o)localObject).mkdirs();
    }
    o localo = new o((o)localObject, ".nomedia");
    if (!localo.exists()) {
      Log.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { aa.z(((o)localObject).her()) });
    }
    try
    {
      localo.createNewFile();
      if (!((o)localObject).exists())
      {
        Log.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
        AppMethodBeat.o(28306);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ShakeMusicLogic", localIOException, "", new Object[0]);
      }
      localObject = aa.z(((o)localObject).her()) + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */