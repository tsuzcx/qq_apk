package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$7
  implements Runnable
{
  b$7(b paramb, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public final void run()
  {
    b localb = this.rWi;
    int i = this.lPI;
    int j = this.lPJ;
    String str = this.val$filePath;
    int k = this.rWs;
    Object localObject = i.eW(i, j);
    localObject = q.a.clL().Wl((String)localObject);
    if (localObject == null) {}
    boolean bool;
    do
    {
      return;
      bool = ((s)localObject).field_fileUpdated;
      ((s)localObject).field_fileUpdated = false;
      q.a.clL().g((s)localObject);
    } while (k != bk.getInt(((s)localObject).field_fileVersion, 0));
    if (q.a.clL().handler == null)
    {
      y.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
      return;
    }
    q.a.clL().handler.post(new b.8(localb, i, j, str, k, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.7
 * JD-Core Version:    0.7.0.1
 */