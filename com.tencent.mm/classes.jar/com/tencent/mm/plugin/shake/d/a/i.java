package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
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
      paramArrayOfByte = (ddv)new ddv().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.ijX = 4;
      localf.ijZ = String.valueOf(paramArrayOfByte.HLp);
      localf.ika = paramArrayOfByte.ika;
      localf.ikd = z.b(paramArrayOfByte.GVC);
      localf.ike = z.b(paramArrayOfByte.GVD);
      localf.ikj = a.avR(localf.ike);
      localf.ijY = paramArrayOfByte.ijY;
      localf.iki = z.b(paramArrayOfByte.GVB);
      localf.ikb = z.b(paramArrayOfByte.HLq);
      localf.ikc = z.b(paramArrayOfByte.HLr);
      localf.ikh = z.b(paramArrayOfByte.HLu);
      localf.ikf = z.b(paramArrayOfByte.HLs);
      localf.ikg = z.b(paramArrayOfByte.HLt);
      localf.iks = paramLong;
      AppMethodBeat.o(28307);
      return localf;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      ae.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(28307);
    }
    return null;
  }
  
  public static String dSP()
  {
    AppMethodBeat.i(28306);
    if (!bc.ajM())
    {
      ae.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    bc.aCg();
    localObject = new k(c.getAccPath() + "shakemusic/");
    if ((!((k)localObject).exists()) || (!((k)localObject).isDirectory()))
    {
      ae.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { w.B(((k)localObject).fTh()) });
      ((k)localObject).mkdirs();
    }
    k localk = new k((k)localObject, ".nomedia");
    if (!localk.exists()) {
      ae.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { w.B(((k)localObject).fTh()) });
    }
    try
    {
      localk.createNewFile();
      if (!((k)localObject).exists())
      {
        ae.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
        AppMethodBeat.o(28306);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ShakeMusicLogic", localIOException, "", new Object[0]);
      }
      localObject = w.B(((k)localObject).fTh()) + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */