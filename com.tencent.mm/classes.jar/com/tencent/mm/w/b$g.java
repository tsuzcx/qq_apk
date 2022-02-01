package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.n;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class b$g
  extends i
{
  private int[] gul;
  private int[] gum;
  
  public b$g(b paramb, j paramj)
  {
    super(paramj);
    this.gul = paramj.tFV;
    this.gum = paramj.tFW;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(127643);
    super.a(paramk);
    Object localObject3 = this.gtW.gtU;
    Object localObject5 = paramk.tFe.tFE;
    Object localObject2 = this.gul;
    Object localObject1 = this.gum;
    Object localObject4 = d.G((String[])localObject5);
    localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((a)localObject3).cVl(), Integer.valueOf(localObject5.length) });
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = " AND subtype IN " + d.A((int[])localObject1);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label369;
      }
    }
    label369:
    for (localObject2 = " AND type IN " + d.A((int[])localObject2);; localObject2 = "")
    {
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((a)localObject3).cVk(), ((a)localObject3).cVk(), ((a)localObject3).cVl(), ((a)localObject3).cVk(), ((a)localObject3).cVl(), ((a)localObject3).cVl(), localObject4 });
      localObject1 = ((a)localObject3).tDu.ald((String)localObject1);
      localObject2 = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new n().i((Cursor)localObject1);
        if (!this.tFP.tFY.contains(((n)localObject3).tEY))
        {
          localObject4 = (m)((HashMap)localObject2).get(Long.valueOf(((n)localObject3).tGf));
          if ((localObject4 == null) || (d.f(c.tDW, ((n)localObject3).tEX, ((m)localObject4).tEX) < 0))
          {
            ((n)localObject3).cVt();
            ((HashMap)localObject2).put(Long.valueOf(((n)localObject3).tGf), localObject3);
          }
        }
      }
      localObject1 = "";
      break;
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted())
    {
      paramk = new InterruptedException();
      AppMethodBeat.o(127643);
      throw paramk;
    }
    paramk.tGc = new ArrayList();
    paramk.tGc.addAll(((HashMap)localObject2).values());
    if (this.tFP.tFZ != null) {
      Collections.sort(paramk.tGc, this.tFP.tFZ);
    }
    AppMethodBeat.o(127643);
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic.NormalSearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.w.b.g
 * JD-Core Version:    0.7.0.1
 */