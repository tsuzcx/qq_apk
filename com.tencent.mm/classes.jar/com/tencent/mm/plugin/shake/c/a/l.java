package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.shake.c.b.a;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.fba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.IOException;

public final class l
{
  public static f a(dli paramdli)
  {
    AppMethodBeat.i(273622);
    if (paramdli == null)
    {
      AppMethodBeat.o(273622);
      return null;
    }
    try
    {
      f localf = new f();
      localf.oOt = 4;
      localf.oOv = String.valueOf(paramdli.ZTv);
      localf.oOw = paramdli.offset;
      localf.oOz = paramdli.ZTy;
      localf.oOE = paramdli.aaRv;
      localf.oOx = paramdli.ZTw;
      localf.oOy = paramdli.ZTx;
      localf.oOD = paramdli.aaRu;
      localf.oOB = paramdli.ZTB;
      localf.oOC = paramdli.ZTB;
      localf.oOZ = paramdli.aaRm;
      localf.oOA = paramdli.aaRo;
      localf.oOM = paramdli.aaRp;
      localf.oPa = true;
      AppMethodBeat.o(273622);
      return localf;
    }
    catch (Exception paramdli)
    {
      Log.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramdli, "", new Object[0]);
      Log.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(273622);
    }
    return null;
  }
  
  public static f cw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(273619);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      AppMethodBeat.o(273619);
      return null;
    }
    try
    {
      paramArrayOfByte = (fba)new fba().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.oOt = 4;
      localf.oOv = String.valueOf(paramArrayOfByte.abAY);
      localf.oOw = paramArrayOfByte.oOw;
      localf.oOz = w.b(paramArrayOfByte.aawS);
      localf.oOA = w.b(paramArrayOfByte.aawT);
      localf.oOF = a.aRP(localf.oOA);
      localf.oOu = paramArrayOfByte.oOu;
      localf.oOE = w.b(paramArrayOfByte.aawR);
      localf.oOx = w.b(paramArrayOfByte.abAZ);
      localf.oOy = w.b(paramArrayOfByte.abBa);
      localf.oOD = w.b(paramArrayOfByte.abBd);
      localf.oOB = w.b(paramArrayOfByte.abBb);
      localf.oOC = w.b(paramArrayOfByte.abBc);
      localf.oOO = 0L;
      AppMethodBeat.o(273619);
      return localf;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      Log.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(273619);
    }
    return null;
  }
  
  public static String gXG()
  {
    AppMethodBeat.i(28306);
    if (!bh.baz())
    {
      Log.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    bh.bCz();
    localObject = new u(c.getAccPath() + "shakemusic/");
    if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory()))
    {
      Log.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { ah.v(((u)localObject).jKT()) });
      ((u)localObject).jKY();
    }
    u localu = new u((u)localObject, ".nomedia");
    if (!localu.jKS()) {
      Log.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { ah.v(((u)localObject).jKT()) });
    }
    try
    {
      localu.jKZ();
      if (!((u)localObject).jKS())
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
      localObject = ah.v(((u)localObject).jKT()) + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.l
 * JD-Core Version:    0.7.0.1
 */