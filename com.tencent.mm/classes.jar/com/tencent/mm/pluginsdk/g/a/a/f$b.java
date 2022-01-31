package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$b
{
  static void a(s params, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (params == null) {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
    }
    String str1;
    String str2;
    String str3;
    do
    {
      boolean bool2;
      int j;
      String str4;
      boolean bool3;
      do
      {
        return;
        str1 = params.field_urlKey;
        str2 = params.field_filePath;
        str3 = params.field_md5;
        boolean bool1 = params.field_fileCompress;
        bool2 = params.field_fileEncrypt;
        byte[] arrayOfByte = params.field_eccSignature;
        int i = bk.getInt(params.field_fileVersion, 0);
        j = params.field_keyVersion;
        str4 = params.field_encryptKey;
        bool3 = params.field_deleted;
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + bool3 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + params.field_originalMd5 + ", fileCompress = " + bool1 + ", fileEncrypt = " + bool2 + ", eccSignature = " + arrayOfByte + ", fileVersion = " + i + ", (encrypt key == empty) = " + bk.bl(str4));
        y.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", new Object[] { str4 });
        if (!bool2)
        {
          if (paramBoolean1)
          {
            j.s(params.field_reportId, 53L);
            j.s(params.field_reportId, 45L);
          }
          if (!bool1)
          {
            y.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
            return;
          }
        }
        if ((j == i) || (!bool2)) {
          break;
        }
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      } while (j < 0);
      j.s(params.field_reportId, 52L);
      j.s(params.field_reportId, 45L);
      return;
      if (bool3)
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
        j.s(params.field_reportId, 51L);
        j.s(params.field_reportId, 45L);
        return;
      }
      if ((bk.bl(str4)) && (bool2))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
        j.s(params.field_reportId, 54L);
        j.s(params.field_reportId, 45L);
        return;
      }
      if ((bk.bl(str3)) || (bk.bl(str2))) {
        break;
      }
      if (q.a.clL().Wm(str1))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", new Object[] { str1 });
        return;
      }
      if (!bk.pm(g.bQ(str2)).equals(str3))
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
        params.field_status = 3;
        q.a.clL().g(params);
        j.s(params.field_reportId, 56L);
        j.s(params.field_reportId, 45L);
        return;
      }
    } while (q.a.clL().Wm(str1));
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request %s", new Object[] { params.field_urlKey });
    b.c.clv().e(params.field_resType, params.field_subType, 1, bk.pm(params.field_groupId2).equals("NewXml"));
    if (paramBoolean2)
    {
      b.c.clv();
      y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", new Object[] { params.field_urlKey });
      k.f(params);
      return;
    }
    b.c.clv().b(params);
    return;
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", new Object[] { str3, str2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.f.b
 * JD-Core Version:    0.7.0.1
 */