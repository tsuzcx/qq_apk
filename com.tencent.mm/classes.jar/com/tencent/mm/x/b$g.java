package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.a.p;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class b$g
  extends k
{
  private int[] mtm;
  private int[] mtn;
  
  public b$g(b paramb, l paraml)
  {
    super(paraml);
    this.mtm = paraml.Htx;
    this.mtn = paraml.Hty;
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(127643);
    super.a(paramm);
    Object localObject3 = b.a(this.msX);
    Object localObject5 = paramm.FWt.Htg;
    Object localObject2 = this.mtm;
    Object localObject1 = this.mtn;
    Object localObject4 = d.I((String[])localObject5);
    localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((a)localObject3).fxo(), Integer.valueOf(localObject5.length) });
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = " AND subtype IN " + d.G((int[])localObject1);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label369;
      }
    }
    label369:
    for (localObject2 = " AND type IN " + d.G((int[])localObject2);; localObject2 = "")
    {
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((a)localObject3).fxn(), ((a)localObject3).fxn(), ((a)localObject3).fxo(), ((a)localObject3).fxn(), ((a)localObject3).fxo(), ((a)localObject3).fxo(), localObject4 });
      localObject1 = ((a)localObject3).HqR.aDY((String)localObject1);
      localObject2 = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new p().l((Cursor)localObject1);
        if (!this.Htr.HtA.contains(((p)localObject3).Hsz))
        {
          localObject4 = (o)((HashMap)localObject2).get(Long.valueOf(((p)localObject3).HtI));
          if ((localObject4 == null) || (d.j(c.Hrv, ((p)localObject3).subtype, ((o)localObject4).subtype) < 0))
          {
            ((p)localObject3).fxB();
            ((HashMap)localObject2).put(Long.valueOf(((p)localObject3).HtI), localObject3);
          }
        }
      }
      localObject1 = "";
      break;
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted())
    {
      paramm = new InterruptedException();
      AppMethodBeat.o(127643);
      throw paramm;
    }
    paramm.HtF = new ArrayList();
    paramm.HtF.addAll(((HashMap)localObject2).values());
    if (this.Htr.HtB != null) {
      Collections.sort(paramm.HtF, this.Htr.HtB);
    }
    AppMethodBeat.o(127643);
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic.NormalSearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.x.b.g
 * JD-Core Version:    0.7.0.1
 */