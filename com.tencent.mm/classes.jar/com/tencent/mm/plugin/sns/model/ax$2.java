package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;

final class ax$2
  implements Runnable
{
  ax$2(ax paramax) {}
  
  public final void run()
  {
    Object localObject1 = null;
    AppMethodBeat.i(36683);
    if (ag.coN())
    {
      ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      AppMethodBeat.o(36683);
      return;
    }
    ax.b(this.riW);
    if (ag.coN())
    {
      ab.e("MicroMsg.UploadManager", "is invalid after checkTLE");
      AppMethodBeat.o(36683);
      return;
    }
    Object localObject2 = ag.cpf();
    n localn = new n();
    String str = "select *,rowid from SnsInfo  where " + o.rDq + " order by SnsInfo.rowid asc ";
    localObject2 = ((o)localObject2).db.a(str, null, 2);
    ab.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
    if (!((Cursor)localObject2).moveToFirst()) {
      ((Cursor)localObject2).close();
    }
    while (localObject1 == null)
    {
      ab.d("MicroMsg.UploadManager", "All has post");
      AppMethodBeat.o(36683);
      return;
      localn.convertFrom((Cursor)localObject2);
      ((Cursor)localObject2).close();
      localObject1 = localn;
    }
    if (ag.cpe().DG(localObject1.rCV))
    {
      ab.d("MicroMsg.UploadManager", "checking isPosting " + localObject1.rCV);
      AppMethodBeat.o(36683);
      return;
    }
    ab.d("MicroMsg.UploadManager", "checking startPost " + localObject1.csH());
    ax.a(this.riW, localObject1);
    AppMethodBeat.o(36683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax.2
 * JD-Core Version:    0.7.0.1
 */