package com.tencent.mm.plugin.welab.c;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends i<com.tencent.mm.plugin.welab.c.a.a>
{
  private e dXw;
  
  public a(e parame)
  {
    super(parame, com.tencent.mm.plugin.welab.c.a.a.buS, "LabAppInfo", null);
    this.dXw = parame;
  }
  
  private boolean d(com.tencent.mm.plugin.welab.c.a.a parama)
  {
    com.tencent.mm.plugin.welab.c.a.a locala = new com.tencent.mm.plugin.welab.c.a.a();
    locala.field_LabsAppId = parama.field_LabsAppId;
    b(locala, new String[0]);
    if (parama.field_sequence <= locala.field_sequence)
    {
      y.i("LabAppInfoStorage", "sequence old origin.seq " + locala.field_sequence + " old.seq " + parama.field_sequence);
      return false;
    }
    return super.a(parama);
  }
  
  public final void c(com.tencent.mm.plugin.welab.c.a.a parama)
  {
    if (!d(parama)) {
      b(parama);
    }
  }
  
  public final List<com.tencent.mm.plugin.welab.c.a.a> chl()
  {
    Cursor localCursor = aAn();
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
    {
      com.tencent.mm.plugin.welab.c.a.a locala = new com.tencent.mm.plugin.welab.c.a.a();
      locala.d(localCursor);
      localArrayList.add(locala);
    }
    localCursor.close();
    return localArrayList;
  }
  
  public final void de(List<com.tencent.mm.plugin.welab.c.a.a> paramList)
  {
    h localh = null;
    if ((this.dXw instanceof h)) {
      localh = (h)this.dXw;
    }
    for (long l = localh.eV(-1L);; l = 0L)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((com.tencent.mm.plugin.welab.c.a.a)paramList.next());
      }
      if (localh != null) {
        localh.hI(l);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.a
 * JD-Core Version:    0.7.0.1
 */