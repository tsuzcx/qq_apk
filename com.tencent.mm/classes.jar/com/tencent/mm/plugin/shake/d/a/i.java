package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class i
{
  public static f f(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(28307);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(28307);
      return null;
    }
    try
    {
      paramArrayOfByte = (eha)new eha().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.lVr = 4;
      localf.lVt = String.valueOf(paramArrayOfByte.Ujt);
      localf.lVu = paramArrayOfByte.lVu;
      localf.lVx = z.b(paramArrayOfByte.Tjp);
      localf.lVy = z.b(paramArrayOfByte.Tjq);
      localf.lVD = a.aUH(localf.lVy);
      localf.lVs = paramArrayOfByte.lVs;
      localf.lVC = z.b(paramArrayOfByte.Tjo);
      localf.lVv = z.b(paramArrayOfByte.Uju);
      localf.lVw = z.b(paramArrayOfByte.Ujv);
      localf.lVB = z.b(paramArrayOfByte.Ujy);
      localf.lVz = z.b(paramArrayOfByte.Ujw);
      localf.lVA = z.b(paramArrayOfByte.Ujx);
      localf.lVM = paramLong;
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
  
  public static String fHR()
  {
    AppMethodBeat.i(28306);
    if (!bh.aHB())
    {
      Log.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    bh.beI();
    localObject = new q(c.getAccPath() + "shakemusic/");
    if ((!((q)localObject).ifE()) || (!((q)localObject).isDirectory()))
    {
      Log.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { ((q)localObject).bOF() });
      ((q)localObject).ifK();
    }
    q localq = new q((q)localObject, ".nomedia");
    if (!localq.ifE()) {
      Log.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { ((q)localObject).bOF() });
    }
    try
    {
      localq.ifM();
      if (!((q)localObject).ifE())
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
      localObject = ((q)localObject).bOF() + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */