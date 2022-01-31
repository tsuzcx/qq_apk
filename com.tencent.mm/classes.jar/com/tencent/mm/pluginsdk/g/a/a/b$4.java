package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$4
  implements Runnable
{
  b$4(b paramb, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(79472);
    s locals = q.a.dmz().alQ(this.vNc);
    int i = this.onf;
    int j = this.ong;
    int k = this.gTU;
    int m = this.gXD;
    String str1 = this.vNd;
    boolean bool2 = this.vNb;
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(locals)));
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", new Object[] { Integer.valueOf(k) });
    boolean bool1 = false;
    String str2;
    if (locals != null) {
      if (bo.getInt(locals.field_fileVersion, 0) <= k)
      {
        bool1 = true;
        str2 = i.hd(i, j);
        String str3 = i.alH(str2);
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", new Object[] { Boolean.valueOf(bool1), str3 });
        if (!bool1) {
          break label443;
        }
        q.a.dmz().BI(str2);
        b.c.dmg().f(i, j, 2, bool2);
        if (!(a.alT(str3) & true & a.alT(str3 + ".decompressed") & a.alT(str3 + ".decrypted"))) {
          break label390;
        }
        if (locals != null)
        {
          j.B(locals.field_reportId, 21L);
          j.a(locals.field_resType, locals.field_subType, k, bool2, locals.field_sampleId);
        }
      }
    }
    for (;;)
    {
      if (locals != null) {
        break label420;
      }
      locals = new s();
      locals.field_urlKey = str2;
      locals.field_resType = i;
      locals.field_subType = j;
      locals.field_deleted = true;
      locals.field_fileVersion = String.valueOf(k);
      locals.field_reportId = m;
      locals.field_sampleId = str1;
      q.a.dmz().h(locals);
      AppMethodBeat.o(79472);
      return;
      j.B(locals.field_reportId, 47L);
      j.B(locals.field_reportId, 22L);
      break;
      j.B(m, 47L);
      j.B(m, 22L);
      bool1 = true;
      break;
      label390:
      if (locals != null)
      {
        j.B(locals.field_reportId, 22L);
        j.B(locals.field_reportId, 47L);
      }
    }
    label420:
    locals.field_deleted = true;
    locals.field_fileVersion = String.valueOf(k);
    q.a.dmz().h(locals);
    label443:
    AppMethodBeat.o(79472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.4
 * JD-Core Version:    0.7.0.1
 */