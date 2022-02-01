package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.cxo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;

public final class i
{
  public static f d(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(28307);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(28307);
      return null;
    }
    try
    {
      paramArrayOfByte = (cxo)new cxo().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.hNQ = 4;
      localf.hNS = String.valueOf(paramArrayOfByte.FHf);
      localf.hNT = paramArrayOfByte.hNT;
      localf.hNW = z.b(paramArrayOfByte.ESJ);
      localf.hNX = z.b(paramArrayOfByte.ESK);
      localf.hOc = a.apw(localf.hNX);
      localf.hNR = paramArrayOfByte.hNR;
      localf.hOb = z.b(paramArrayOfByte.ESI);
      localf.hNU = z.b(paramArrayOfByte.FHg);
      localf.hNV = z.b(paramArrayOfByte.FHh);
      localf.hOa = z.b(paramArrayOfByte.FHk);
      localf.hNY = z.b(paramArrayOfByte.FHi);
      localf.hNZ = z.b(paramArrayOfByte.FHj);
      localf.hOl = paramLong;
      AppMethodBeat.o(28307);
      return localf;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      ac.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(28307);
    }
    return null;
  }
  
  public static String dDP()
  {
    AppMethodBeat.i(28306);
    if (!az.agM())
    {
      ac.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    az.ayM();
    localObject = new e(c.getAccPath() + "shakemusic/");
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
    {
      ac.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { q.B(((e)localObject).fxV()) });
      ((e)localObject).mkdirs();
    }
    e locale = new e((e)localObject, ".nomedia");
    if (!locale.exists()) {
      ac.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { q.B(((e)localObject).fxV()) });
    }
    try
    {
      locale.createNewFile();
      if (!((e)localObject).exists())
      {
        ac.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
        AppMethodBeat.o(28306);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.ShakeMusicLogic", localIOException, "", new Object[0]);
      }
      localObject = q.B(((e)localObject).fxV()) + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */