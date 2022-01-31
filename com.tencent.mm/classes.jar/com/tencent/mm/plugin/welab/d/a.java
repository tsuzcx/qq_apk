package com.tencent.mm.plugin.welab.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends j<com.tencent.mm.plugin.welab.d.a.a>
{
  private e db;
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.plugin.welab.d.a.a.info, "LabAppInfo", null);
    this.db = parame;
  }
  
  private boolean d(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(80582);
    com.tencent.mm.plugin.welab.d.a.a locala = new com.tencent.mm.plugin.welab.d.a.a();
    locala.field_LabsAppId = parama.field_LabsAppId;
    get(locala, new String[0]);
    if ((parama.field_expId == locala.field_expId) && (parama.field_sequence < locala.field_sequence))
    {
      ab.i("LabAppInfoStorage", "sequence old origin.seq " + locala.field_sequence + " old.seq " + parama.field_sequence);
      AppMethodBeat.o(80582);
      return false;
    }
    boolean bool = super.replace(parama);
    AppMethodBeat.o(80582);
    return bool;
  }
  
  public final void c(com.tencent.mm.plugin.welab.d.a.a parama)
  {
    AppMethodBeat.i(80581);
    if (!d(parama)) {
      insert(parama);
    }
    AppMethodBeat.o(80581);
  }
  
  public final List<com.tencent.mm.plugin.welab.d.a.a> dht()
  {
    AppMethodBeat.i(80579);
    Cursor localCursor = getAll();
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      com.tencent.mm.plugin.welab.d.a.a locala = new com.tencent.mm.plugin.welab.d.a.a();
      locala.convertFrom(localCursor);
      localArrayList.add(locala);
    }
    localCursor.close();
    AppMethodBeat.o(80579);
    return localArrayList;
  }
  
  public final void ek(List<com.tencent.mm.plugin.welab.d.a.a> paramList)
  {
    AppMethodBeat.i(80580);
    h localh = null;
    if ((this.db instanceof h)) {
      localh = (h)this.db;
    }
    for (long l = localh.kr(-1L);; l = 0L)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((com.tencent.mm.plugin.welab.d.a.a)paramList.next());
      }
      if (localh != null) {
        localh.nY(l);
      }
      AppMethodBeat.o(80580);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a
 * JD-Core Version:    0.7.0.1
 */