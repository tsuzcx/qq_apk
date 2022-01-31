package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m dBO;
  a dBP;
  private m.b dBQ = new b.1(this);
  
  protected final boolean BB()
  {
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.dBQ);
    return true;
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(i parami)
  {
    parami = new g(parami);
    return this.dBO.a(-65536, parami);
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)com.tencent.mm.kernel.g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.dBP = ((a)((n)com.tencent.mm.kernel.g.t(n.class)).getFTSIndexStorage(1280));
    this.dBO = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSTaskDaemon();
    this.dBO.a(131172, new b.b(this, (byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.dBQ);
    return true;
  }
  
  private final class g
    extends com.tencent.mm.plugin.fts.a.a.h
  {
    private int[] dCh;
    private int[] dCi;
    
    public g(i parami)
    {
      super();
      this.dCh = parami.kxa;
      this.dCi = parami.kxb;
    }
    
    protected final void a(j paramj)
    {
      super.a(paramj);
      Object localObject3 = b.this.dBP;
      Object localObject5 = paramj.kwi.kwI;
      Object localObject2 = this.dCh;
      Object localObject1 = this.dCi;
      Object localObject4 = d.v((String[])localObject5);
      localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((com.tencent.mm.plugin.fts.a.a)localObject3).aVt(), Integer.valueOf(localObject5.length) });
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND subtype IN " + d.l((int[])localObject1);
        if ((localObject2 == null) || (localObject2.length <= 0)) {
          break label364;
        }
      }
      label364:
      for (localObject2 = " AND type IN " + d.l((int[])localObject2);; localObject2 = "")
      {
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.a.a)localObject3).aVs(), ((com.tencent.mm.plugin.fts.a.a)localObject3).aVs(), ((com.tencent.mm.plugin.fts.a.a)localObject3).aVt(), ((com.tencent.mm.plugin.fts.a.a)localObject3).aVs(), ((com.tencent.mm.plugin.fts.a.a)localObject3).aVt(), ((com.tencent.mm.plugin.fts.a.a)localObject3).aVt(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).kuE.DI((String)localObject1);
        localObject2 = new HashMap();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject3 = new com.tencent.mm.plugin.fts.a.a.m().j((Cursor)localObject1);
          if (!this.kwT.kxd.contains(((com.tencent.mm.plugin.fts.a.a.m)localObject3).kwg))
          {
            localObject4 = (l)((HashMap)localObject2).get(Long.valueOf(((com.tencent.mm.plugin.fts.a.a.m)localObject3).kxk));
            if ((localObject4 == null) || (d.e(c.kvg, ((com.tencent.mm.plugin.fts.a.a.m)localObject3).kwf, ((l)localObject4).kwf) < 0))
            {
              ((com.tencent.mm.plugin.fts.a.a.m)localObject3).aVA();
              ((HashMap)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.fts.a.a.m)localObject3).kxk), localObject3);
            }
          }
        }
        localObject1 = "";
        break;
      }
      ((Cursor)localObject1).close();
      if (Thread.interrupted()) {
        throw new InterruptedException();
      }
      paramj.kxh = new ArrayList();
      paramj.kxh.addAll(((HashMap)localObject2).values());
      if (this.kwT.kxe != null) {
        Collections.sort(paramj.kxh, this.kwT.kxe);
      }
    }
    
    public final String getName()
    {
      return "FTS5SearchFriendLogic.NormalSearchTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */