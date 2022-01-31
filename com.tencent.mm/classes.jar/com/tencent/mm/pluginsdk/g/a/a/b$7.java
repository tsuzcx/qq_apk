package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class b$7
  implements Runnable
{
  b$7(b paramb, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(79475);
    b localb = this.vMZ;
    int i = this.onf;
    int j = this.ong;
    String str1 = this.val$filePath;
    int k = this.vNj;
    String str2 = this.iiy;
    Object localObject = i.hd(i, j);
    localObject = q.a.dmz().alQ((String)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(79475);
      return;
    }
    boolean bool = ((s)localObject).field_fileUpdated;
    ((s)localObject).field_fileUpdated = false;
    q.a.dmz().h((s)localObject);
    if (k == bo.getInt(((s)localObject).field_fileVersion, 0))
    {
      if (q.a.dmz().handler == null)
      {
        ab.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
        AppMethodBeat.o(79475);
        return;
      }
      q.a.dmz().handler.post(new b.8(localb, i, j, str1, k, bool, str2));
    }
    AppMethodBeat.o(79475);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.7
 * JD-Core Version:    0.7.0.1
 */