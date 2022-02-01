package com.tencent.mm.x;

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
  private int[] grK;
  private int[] grL;
  
  public b$g(b paramb, j paramj)
  {
    super(paramj);
    this.grK = paramj.tve;
    this.grL = paramj.tvf;
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(127643);
    super.a(paramk);
    Object localObject3 = this.grv.grt;
    Object localObject5 = paramk.tun.tuN;
    Object localObject2 = this.grK;
    Object localObject1 = this.grL;
    Object localObject4 = d.G((String[])localObject5);
    localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((a)localObject3).cSG(), Integer.valueOf(localObject5.length) });
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = " AND subtype IN " + d.z((int[])localObject1);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label369;
      }
    }
    label369:
    for (localObject2 = " AND type IN " + d.z((int[])localObject2);; localObject2 = "")
    {
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((a)localObject3).cSF(), ((a)localObject3).cSF(), ((a)localObject3).cSG(), ((a)localObject3).cSF(), ((a)localObject3).cSG(), ((a)localObject3).cSG(), localObject4 });
      localObject1 = ((a)localObject3).tsD.akf((String)localObject1);
      localObject2 = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new n().i((Cursor)localObject1);
        if (!this.tuY.tvh.contains(((n)localObject3).tuh))
        {
          localObject4 = (m)((HashMap)localObject2).get(Long.valueOf(((n)localObject3).tvo));
          if ((localObject4 == null) || (d.f(c.ttf, ((n)localObject3).tug, ((m)localObject4).tug) < 0))
          {
            ((n)localObject3).cSO();
            ((HashMap)localObject2).put(Long.valueOf(((n)localObject3).tvo), localObject3);
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
    paramk.tvl = new ArrayList();
    paramk.tvl.addAll(((HashMap)localObject2).values());
    if (this.tuY.tvi != null) {
      Collections.sort(paramk.tvl, this.tuY.tvi);
    }
    AppMethodBeat.o(127643);
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic.NormalSearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.x.b.g
 * JD-Core Version:    0.7.0.1
 */