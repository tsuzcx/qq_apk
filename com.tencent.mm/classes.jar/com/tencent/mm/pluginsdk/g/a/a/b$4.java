package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$4
  implements Runnable
{
  b$4(b paramb, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    s locals = q.a.clL().Wl(this.rWl);
    int i = this.lPI;
    int j = this.lPJ;
    int k = this.iiK;
    int m = this.fFi;
    String str1 = this.rWm;
    boolean bool2 = this.rWk;
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record " + locals);
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
    boolean bool1 = false;
    String str2;
    if (locals != null) {
      if (bk.getInt(locals.field_fileVersion, 0) <= k)
      {
        bool1 = true;
        str2 = i.eW(i, j);
        String str3 = i.Wg(str2);
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
        if (bool1)
        {
          q.a.clL().Wn(str2);
          b.c.clv().e(i, j, 2, bool2);
          if (!(a.Wp(str3) & true & a.Wp(str3 + ".decompressed") & a.Wp(str3 + ".decrypted"))) {
            break label387;
          }
          if (locals != null)
          {
            j.s(locals.field_reportId, 21L);
            j.a(locals.field_resType, locals.field_subType, k, bool2, locals.field_sampleId);
          }
        }
      }
    }
    for (;;)
    {
      if (locals != null) {
        break label417;
      }
      locals = new s();
      locals.field_urlKey = str2;
      locals.field_resType = i;
      locals.field_subType = j;
      locals.field_deleted = true;
      locals.field_fileVersion = String.valueOf(k);
      locals.field_reportId = m;
      locals.field_sampleId = str1;
      q.a.clL().g(locals);
      return;
      j.s(locals.field_reportId, 47L);
      j.s(locals.field_reportId, 22L);
      break;
      j.s(m, 47L);
      j.s(m, 22L);
      bool1 = true;
      break;
      label387:
      if (locals != null)
      {
        j.s(locals.field_reportId, 22L);
        j.s(locals.field_reportId, 47L);
      }
    }
    label417:
    locals.field_deleted = true;
    locals.field_fileVersion = String.valueOf(k);
    q.a.clL().g(locals);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.4
 * JD-Core Version:    0.7.0.1
 */