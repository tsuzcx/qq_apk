package com.tencent.mm.plugin.welab.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends MAutoStorage<com.tencent.mm.plugin.welab.d.a.a>
{
  private ISQLiteDatabase db;
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo", null);
    this.db = paramISQLiteDatabase;
  }
  
  private boolean d(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146253);
    com.tencent.mm.plugin.welab.d.a.a locala = new com.tencent.mm.plugin.welab.d.a.a();
    locala.field_LabsAppId = parama.field_LabsAppId;
    get(locala, new String[0]);
    if ((parama.field_expId == locala.field_expId) && (parama.field_sequence < locala.field_sequence))
    {
      Log.i("LabAppInfoStorage", "sequence old origin.seq " + locala.field_sequence + " old.seq " + parama.field_sequence);
      AppMethodBeat.o(146253);
      return false;
    }
    boolean bool = super.replace(parama);
    AppMethodBeat.o(146253);
    return bool;
  }
  
  public final void c(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(146252);
    if (!d(parama)) {
      insert(parama);
    }
    AppMethodBeat.o(146252);
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> iDI()
  {
    AppMethodBeat.i(146250);
    Cursor localCursor = getAll();
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = new com.tencent.mm.plugin.welab.d.a.a();
      locala.convertFrom(localCursor);
      localArrayList.add(locala);
    }
    localCursor.close();
    AppMethodBeat.o(146250);
    return localArrayList;
  }
  
  public final void mp(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(146251);
    h localh = null;
    if ((this.db instanceof h)) {
      localh = (h)this.db;
    }
    for (long l = localh.beginTransaction(-1L);; l = 0L)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((com.tencent.mm.plugin.welab.d.a.a)paramList.next());
      }
      if (localh != null) {
        localh.endTransaction(l);
      }
      AppMethodBeat.o(146251);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a
 * JD-Core Version:    0.7.0.1
 */