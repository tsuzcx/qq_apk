package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class f$b
{
  static void a(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(79514);
    if (params == null)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
      AppMethodBeat.o(79514);
      return;
    }
    String str1 = params.field_urlKey;
    String str2 = params.field_filePath;
    String str3 = params.field_md5;
    boolean bool1 = params.field_fileCompress;
    boolean bool2 = params.field_fileEncrypt;
    byte[] arrayOfByte = params.field_eccSignature;
    int i = bo.getInt(params.field_fileVersion, 0);
    int j = params.field_keyVersion;
    String str4 = params.field_encryptKey;
    boolean bool3 = params.field_deleted;
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + bool3 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + params.field_originalMd5 + ", fileCompress = " + bool1 + ", fileEncrypt = " + bool2 + ", eccSignature = " + arrayOfByte + ", fileVersion = " + i + ", (encrypt key == empty) = " + bo.isNullOrNil(str4));
    ab.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", new Object[] { str4 });
    if (!bool2)
    {
      if (paramBoolean1)
      {
        j.B(params.field_reportId, 53L);
        j.B(params.field_reportId, 45L);
      }
      if (!bool1)
      {
        ab.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
        AppMethodBeat.o(79514);
        return;
      }
    }
    if ((j != i) && (bool2))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j >= 0)
      {
        j.B(params.field_reportId, 52L);
        j.B(params.field_reportId, 45L);
      }
      AppMethodBeat.o(79514);
      return;
    }
    if (bool3)
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
      j.B(params.field_reportId, 51L);
      j.B(params.field_reportId, 45L);
      AppMethodBeat.o(79514);
      return;
    }
    if ((bo.isNullOrNil(str4)) && (bool2))
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
      j.B(params.field_reportId, 54L);
      j.B(params.field_reportId, 45L);
      AppMethodBeat.o(79514);
      return;
    }
    if ((!bo.isNullOrNil(str3)) && (!bo.isNullOrNil(str2)))
    {
      if (q.a.dmz().alR(str1))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", new Object[] { str1 });
        AppMethodBeat.o(79514);
        return;
      }
      if (!bo.nullAsNil(g.getMD5(str2)).equals(str3))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
        params.field_status = 3;
        q.a.dmz().h(params);
        j.B(params.field_reportId, 56L);
        j.B(params.field_reportId, 45L);
        AppMethodBeat.o(79514);
        return;
      }
      if (!q.a.dmz().alR(str1))
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", new Object[] { params.field_urlKey });
        b.c.dmg().f(params.field_resType, params.field_subType, 1, bo.nullAsNil(params.field_groupId2).equals("NewXml"));
        if (paramBoolean2)
        {
          b.c.dmg();
          b.c(params);
          AppMethodBeat.o(79514);
          return;
        }
        b.c.dmg().b(params);
        AppMethodBeat.o(79514);
      }
    }
    else
    {
      ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", new Object[] { str3, str2 });
    }
    AppMethodBeat.o(79514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.f.b
 * JD-Core Version:    0.7.0.1
 */