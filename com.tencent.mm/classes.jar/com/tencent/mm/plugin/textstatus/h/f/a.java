package com.tencent.mm.plugin.textstatus.h.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import com.tencent.mm.storagebase.h;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusDBProvider;", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "()V", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements IMvvmDBProvider
{
  public final ISQLiteDatabase getDB()
  {
    AppMethodBeat.i(290699);
    Object localObject = f.TjQ;
    if (f.getDataDB().isOpen())
    {
      localObject = f.TjQ;
      localObject = (ISQLiteDatabase)f.getDataDB();
      AppMethodBeat.o(290699);
      return localObject;
    }
    AppMethodBeat.o(290699);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.a
 * JD-Core Version:    0.7.0.1
 */