package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

final class f$b
{
  static void a(r paramr, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(151957);
    if (paramr == null)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
      AppMethodBeat.o(151957);
      return;
    }
    String str1 = paramr.field_urlKey;
    String str2 = paramr.field_filePath;
    String str3 = paramr.field_md5;
    boolean bool1 = paramr.field_fileCompress;
    boolean bool2 = paramr.field_fileEncrypt;
    byte[] arrayOfByte = paramr.field_eccSignature;
    int i = Util.getInt(paramr.field_fileVersion, 0);
    int j = paramr.field_keyVersion;
    String str4 = paramr.field_encryptKey;
    boolean bool3 = paramr.field_deleted;
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + bool3 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + paramr.field_originalMd5 + ", fileCompress = " + bool1 + ", fileEncrypt = " + bool2 + ", eccSignature = " + arrayOfByte + ", fileVersion = " + i + ", (encrypt key == empty) = " + Util.isNullOrNil(str4));
    Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", new Object[] { str4 });
    if (!bool2)
    {
      if (paramBoolean1)
      {
        j.F(paramr.field_reportId, 53L);
        j.F(paramr.field_reportId, 45L);
      }
      if (!bool1)
      {
        Log.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
        AppMethodBeat.o(151957);
        return;
      }
    }
    if ((j != i) && (bool2))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= 0)
      {
        j.F(paramr.field_reportId, 52L);
        j.F(paramr.field_reportId, 45L);
      }
      AppMethodBeat.o(151957);
      return;
    }
    if (bool3)
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
      j.F(paramr.field_reportId, 51L);
      j.F(paramr.field_reportId, 45L);
      AppMethodBeat.o(151957);
      return;
    }
    if ((Util.isNullOrNil(str4)) && (bool2))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
      j.F(paramr.field_reportId, 54L);
      j.F(paramr.field_reportId, 45L);
      AppMethodBeat.o(151957);
      return;
    }
    if ((!Util.isNullOrNil(str3)) && (!Util.isNullOrNil(str2)))
    {
      if (p.a.hiK().bqD(str1))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", new Object[] { str1 });
        AppMethodBeat.o(151957);
        return;
      }
      if (!Util.nullAsNil(u.buc(str2)).equals(str3))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
        paramr.field_status = 3;
        p.a.hiK().h(paramr);
        j.F(paramr.field_reportId, 56L);
        j.F(paramr.field_reportId, 45L);
        AppMethodBeat.o(151957);
        return;
      }
      if (!p.a.hiK().bqD(str1))
      {
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", new Object[] { paramr.field_urlKey });
        b.hii().h(paramr.field_resType, paramr.field_subType, 1, Util.nullAsNil(paramr.field_groupId2).equals("NewXml"));
        if (paramBoolean2)
        {
          b.hii();
          b.c(paramr);
          AppMethodBeat.o(151957);
          return;
        }
        b.hii().b(paramr);
        AppMethodBeat.o(151957);
      }
    }
    else
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", new Object[] { str3, str2 });
    }
    AppMethodBeat.o(151957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.f.b
 * JD-Core Version:    0.7.0.1
 */