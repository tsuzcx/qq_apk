package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.sdk.platformtools.ad;
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
      paramArrayOfByte = (csf)new csf().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.hnn = 4;
      localf.hnp = String.valueOf(paramArrayOfByte.Ekh);
      localf.hnq = paramArrayOfByte.hnq;
      localf.hnt = z.b(paramArrayOfByte.Dxn);
      localf.hnu = z.b(paramArrayOfByte.Dxo);
      localf.hnz = a.akx(localf.hnu);
      localf.hno = paramArrayOfByte.hno;
      localf.hny = z.b(paramArrayOfByte.Dxm);
      localf.hnr = z.b(paramArrayOfByte.Eki);
      localf.hns = z.b(paramArrayOfByte.Ekj);
      localf.hnx = z.b(paramArrayOfByte.Ekm);
      localf.hnv = z.b(paramArrayOfByte.Ekk);
      localf.hnw = z.b(paramArrayOfByte.Ekl);
      localf.hnI = paramLong;
      AppMethodBeat.o(28307);
      return localf;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.ShakeMusicLogic", paramArrayOfByte, "", new Object[0]);
      ad.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
      AppMethodBeat.o(28307);
    }
    return null;
  }
  
  public static String dpF()
  {
    AppMethodBeat.i(28306);
    if (!az.afw())
    {
      ad.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    az.arV();
    localObject = new e(c.getAccPath() + "shakemusic/");
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
    {
      ad.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { q.B(((e)localObject).fhU()) });
      ((e)localObject).mkdirs();
    }
    e locale = new e((e)localObject, ".nomedia");
    if (!locale.exists()) {
      ad.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { q.B(((e)localObject).fhU()) });
    }
    try
    {
      locale.createNewFile();
      if (!((e)localObject).exists())
      {
        ad.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
        AppMethodBeat.o(28306);
        return null;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ShakeMusicLogic", localIOException, "", new Object[0]);
      }
      localObject = q.B(((e)localObject).fhU()) + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */