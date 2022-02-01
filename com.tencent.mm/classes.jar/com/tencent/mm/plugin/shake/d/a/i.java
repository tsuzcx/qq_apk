package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.protobuf.ddb;
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
      paramArrayOfByte = (ddb)new ddb().parseFrom(paramArrayOfByte);
      f localf = new f();
      localf.ihe = 4;
      localf.ihg = String.valueOf(paramArrayOfByte.HrN);
      localf.ihh = paramArrayOfByte.ihh;
      localf.ihk = z.b(paramArrayOfByte.GCc);
      localf.ihl = z.b(paramArrayOfByte.GCd);
      localf.ihq = a.auC(localf.ihl);
      localf.ihf = paramArrayOfByte.ihf;
      localf.ihp = z.b(paramArrayOfByte.GCb);
      localf.ihi = z.b(paramArrayOfByte.HrO);
      localf.ihj = z.b(paramArrayOfByte.HrP);
      localf.iho = z.b(paramArrayOfByte.HrS);
      localf.ihm = z.b(paramArrayOfByte.HrQ);
      localf.ihn = z.b(paramArrayOfByte.HrR);
      localf.ihz = paramLong;
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
  
  public static String dPs()
  {
    AppMethodBeat.i(28306);
    if (!ba.ajx())
    {
      ad.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
      AppMethodBeat.o(28306);
      return null;
    }
    Object localObject = new StringBuilder();
    ba.aBQ();
    localObject = new e(c.getAccPath() + "shakemusic/");
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
    {
      ad.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[] { q.B(((e)localObject).fOK()) });
      ((e)localObject).mkdirs();
    }
    e locale = new e((e)localObject, ".nomedia");
    if (!locale.exists()) {
      ad.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[] { q.B(((e)localObject).fOK()) });
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
      localObject = q.B(((e)localObject).fOK()) + "/";
      AppMethodBeat.o(28306);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.i
 * JD-Core Version:    0.7.0.1
 */