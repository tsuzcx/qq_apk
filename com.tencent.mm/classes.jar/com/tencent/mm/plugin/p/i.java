package com.tencent.mm.plugin.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MainDBProvider;", "Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;", "()V", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-livestorage_release"})
public final class i
  implements c
{
  public final ISQLiteDatabase eLT()
  {
    AppMethodBeat.i(254405);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).getDataDB();
    p.j(localObject, "db");
    if (((com.tencent.mm.storagebase.h)localObject).isOpen())
    {
      localObject = (ISQLiteDatabase)localObject;
      AppMethodBeat.o(254405);
      return localObject;
    }
    AppMethodBeat.o(254405);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.i
 * JD-Core Version:    0.7.0.1
 */