package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

final class b$g
  extends com.tencent.mm.plugin.fts.a.a.h
{
  private int[] ezy;
  private int[] ezz;
  
  public b$g(b paramb, i parami)
  {
    super(parami);
    this.ezy = parami.mSP;
    this.ezz = parami.mSQ;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(124485);
    super.a(paramj);
    Object localObject3 = this.ezi.ezg;
    Object localObject5 = paramj.mRX.mSy;
    Object localObject2 = this.ezy;
    Object localObject1 = this.ezz;
    Object localObject4 = d.z((String[])localObject5);
    localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((a)localObject3).bBS(), Integer.valueOf(localObject5.length) });
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localObject1 = " AND subtype IN " + d.v((int[])localObject1);
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label369;
      }
    }
    label369:
    for (localObject2 = " AND type IN " + d.v((int[])localObject2);; localObject2 = "")
    {
      localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((a)localObject3).bBR(), ((a)localObject3).bBR(), ((a)localObject3).bBS(), ((a)localObject3).bBR(), ((a)localObject3).bBS(), ((a)localObject3).bBS(), localObject4 });
      localObject1 = ((a)localObject3).mQr.OR((String)localObject1);
      localObject2 = new HashMap();
      while (((Cursor)localObject1).moveToNext())
      {
        localObject3 = new m().i((Cursor)localObject1);
        if (!this.mSJ.mSS.contains(((m)localObject3).mRV))
        {
          localObject4 = (l)((HashMap)localObject2).get(Long.valueOf(((m)localObject3).mSZ));
          if ((localObject4 == null) || (d.f(c.mQT, ((m)localObject3).mRU, ((l)localObject4).mRU) < 0))
          {
            ((m)localObject3).bCa();
            ((HashMap)localObject2).put(Long.valueOf(((m)localObject3).mSZ), localObject3);
          }
        }
      }
      localObject1 = "";
      break;
    }
    ((Cursor)localObject1).close();
    if (Thread.interrupted())
    {
      paramj = new InterruptedException();
      AppMethodBeat.o(124485);
      throw paramj;
    }
    paramj.mSW = new ArrayList();
    paramj.mSW.addAll(((HashMap)localObject2).values());
    if (this.mSJ.mST != null) {
      Collections.sort(paramj.mSW, this.mSJ.mST);
    }
    AppMethodBeat.o(124485);
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic.NormalSearchTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.b.g
 * JD-Core Version:    0.7.0.1
 */