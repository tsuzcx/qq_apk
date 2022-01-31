package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;

final class aw$2
  implements Runnable
{
  aw$2(aw paramaw) {}
  
  public final void run()
  {
    Object localObject1 = null;
    if (af.bDo())
    {
      y.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      return;
    }
    aw.b(this.ouc);
    if (af.bDo())
    {
      y.e("MicroMsg.UploadManager", "is invalid after checkTLE");
      return;
    }
    Object localObject2 = af.bDF();
    n localn = new n();
    String str = "select *,rowid from SnsInfo  where " + o.oLF + " order by SnsInfo.rowid asc ";
    localObject2 = ((o)localObject2).dXw.a(str, null, 2);
    y.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
    if (!((Cursor)localObject2).moveToFirst()) {
      ((Cursor)localObject2).close();
    }
    while (localObject1 == null)
    {
      y.d("MicroMsg.UploadManager", "All has post");
      return;
      localn.d((Cursor)localObject2);
      ((Cursor)localObject2).close();
      localObject1 = localn;
    }
    if (af.bDE().xG(localObject1.oLk))
    {
      y.d("MicroMsg.UploadManager", "checking isPosting " + localObject1.oLk);
      return;
    }
    y.d("MicroMsg.UploadManager", "checking startPost " + localObject1.bGE());
    aw.a(this.ouc, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw.2
 * JD-Core Version:    0.7.0.1
 */