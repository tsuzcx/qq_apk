package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  com.tencent.mm.plugin.fts.a.m hgI;
  a hgJ;
  private MStorageEx.IOnStorageChange hgK;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.hgK = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.axb())
        {
          AppMethodBeat.o(127632);
          return;
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)))
        {
          paramAnonymousMStorageEx = (String)paramAnonymousObject;
          switch (paramAnonymousInt)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(127632);
          return;
          paramAnonymousMStorageEx = null;
          break;
          if (paramAnonymousMStorageEx != null)
          {
            b.this.hgI.a(65636, new b.f(b.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(127632);
            return;
            if (paramAnonymousMStorageEx == null)
            {
              b.this.hgI.a(65636, new b.c(b.this));
              AppMethodBeat.o(127632);
              return;
            }
            b.this.hgI.a(65636, new b.d(b.this, paramAnonymousMStorageEx));
          }
        }
      }
    };
    AppMethodBeat.o(127644);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(127647);
    paramj = new g(paramj);
    paramj = this.hgI.a(-65536, paramj);
    AppMethodBeat.o(127647);
    return paramj;
  }
  
  public final boolean axa()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().remove(this.hgK);
    AppMethodBeat.o(127646);
    return true;
  }
  
  public final String getName()
  {
    return "FTS5SearchFriendLogic";
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(127645);
    if (!((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(127645);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.hgJ = ((a)((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.hgI = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.hgI.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().add(this.hgK);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String dSf;
    String hgM;
    String hgN;
    String hgO;
    String hgP;
    long id;
    String nickName;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.a.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.a.a.SQ(parama.getMd5());
      this.realName = parama.bnK();
      this.hgM = parama.bnM();
      this.hgN = parama.bnL();
      this.nickName = parama.getNickName();
      this.hgO = parama.bnO();
      this.hgP = parama.bnN();
      this.userName = parama.getUsername();
      this.dSf = parama.bnP();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    public boolean hgQ;
    private HashSet<Long> hgR;
    private long hgS;
    private int hgT;
    private HashMap<int[], b.e> hgU;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.hgQ = false;
      this.hgR = null;
      this.hgS = -9223372036854775808L;
      this.hgT = -1;
      this.hgU = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127635);
      Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.hgQ = b.axb();
      if (this.hgT < 0) {
        this.hgT = 0;
      }
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.hgQ), Integer.valueOf(this.hgT) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.hgT == 0) {
        if (this.hgQ)
        {
          if (!this.hgU.containsKey(c.wUM)) {
            this.hgU.put(c.wUM, new b.e((byte)0));
          }
          if (this.hgR == null)
          {
            this.hgR = new HashSet();
            localObject1 = b.this.hgJ.a(c.wUM, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.hgR.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.hgS) });
          i = 50;
          while (((Cursor)localObject1).moveToNext())
          {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              b.this.hgJ.commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(127635);
              throw ((Throwable)localObject1);
            }
            l = ((Cursor)localObject1).getLong(0);
            this.hgS = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).hgM = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).hgN = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).nickName = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).hgO = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).hgP = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).dSf = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.hgR.remove(Long.valueOf(((b.a)localObject2).id))))
            {
              if (i < 50) {
                break label793;
              }
              b.this.hgJ.commit();
              b.this.hgJ.beginTransaction();
            }
          }
        }
      }
      label790:
      label793:
      for (int j = 0;; j = i)
      {
        b.e locale;
        for (;;)
        {
          i = j;
          try
          {
            j += b.a(b.this, (b.a)localObject2);
            i = j;
            localObject2 = (b.e)this.hgU.get(c.wUM);
            i = j;
            ((b.e)localObject2).hgX += 1;
            i = j;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.hgU.get(c.wUM);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.this.hgJ.commit();
        localObject1 = this.hgR.iterator();
        i = 50;
        if (((Iterator)localObject1).hasNext())
        {
          if (i < 50) {
            break label790;
          }
          b.this.hgJ.commit();
          b.this.hgJ.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          b.this.hgJ.c(c.wUM, l);
          locale = (b.e)this.hgU.get(c.wUM);
          locale.hgY += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.this.hgJ.commit();
          this.hgR = null;
          this.hgS = -9223372036854775808L;
          this.hgT = -1;
          AppMethodBeat.o(127635);
          return true;
        }
      }
    }
    
    public final int getId()
    {
      return 2;
    }
    
    public final String getName()
    {
      return "BuildFriendIndexTask";
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127636);
      if (this.hgU.containsKey(c.wUM))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.hgU.get(c.wUM)).hgX + ", removed: " + ((b.e)this.hgU.get(c.wUM)).hgY + ", failed: " + ((b.e)this.hgU.get(c.wUM)).mFailedCount + "]";
        AppMethodBeat.o(127636);
        return str;
      }
      AppMethodBeat.o(127636);
      return "";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int hgV = 0;
    private int mCount = 0;
    
    public c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(127637);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.hgV) });
      if (this.hgV == 0) {
        this.mCount = b.this.hgJ.j(c.wUM, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.hgV + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int hgV;
    private String hgW;
    
    public d(String paramString)
    {
      this.hgW = paramString;
      this.hgV = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127639);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.hgW, Integer.valueOf(this.hgV) });
      if (this.hgV == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.SQ(this.hgW);
        b.this.hgJ.c(c.wUM, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.hgW + "\", " + this.hgV + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int hgX = 0;
    public int hgY = 0;
    public int mFailedCount = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int hgV;
    private String hgW;
    private boolean hgZ = false;
    
    public f(String paramString)
    {
      this.hgW = paramString;
      this.hgV = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127641);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.hgW, Integer.valueOf(this.hgV) });
      if (this.hgV == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(this.hgW);
        if (localObject == null)
        {
          this.hgZ = true;
          AppMethodBeat.o(127641);
          return true;
        }
        localObject = new b.a((com.tencent.mm.plugin.account.friend.a.a)localObject);
        if (!b.a((b.a)localObject)) {
          break label112;
        }
        b.a(b.this, (b.a)localObject);
      }
      for (;;)
      {
        AppMethodBeat.o(127641);
        return true;
        label112:
        this.hgZ = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.hgW).append("\", ").append(this.hgV).append(")");
      if (this.hgZ) {}
      for (String str = " [skipped]";; str = "")
      {
        str = str;
        AppMethodBeat.o(127642);
        return str;
      }
    }
  }
  
  final class g
    extends i
  {
    private int[] hha;
    private int[] hhb;
    
    public g(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
      this.hha = paramj.wWU;
      this.hhb = paramj.wWV;
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(127643);
      super.a(paramk);
      Object localObject3 = b.this.hgJ;
      Object localObject5 = paramk.wWd.wWD;
      Object localObject2 = this.hha;
      Object localObject1 = this.hhb;
      Object localObject4 = d.I((String[])localObject5);
      localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((com.tencent.mm.plugin.fts.a.a)localObject3).dOu(), Integer.valueOf(localObject5.length) });
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject1 = " AND subtype IN " + d.C((int[])localObject1);
        if ((localObject2 == null) || (localObject2.length <= 0)) {
          break label369;
        }
      }
      label369:
      for (localObject2 = " AND type IN " + d.C((int[])localObject2);; localObject2 = "")
      {
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.a.a)localObject3).dOt(), ((com.tencent.mm.plugin.fts.a.a)localObject3).dOt(), ((com.tencent.mm.plugin.fts.a.a)localObject3).dOu(), ((com.tencent.mm.plugin.fts.a.a)localObject3).dOt(), ((com.tencent.mm.plugin.fts.a.a)localObject3).dOu(), ((com.tencent.mm.plugin.fts.a.a)localObject3).dOu(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).wUt.ayh((String)localObject1);
        localObject2 = new HashMap();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject3 = new com.tencent.mm.plugin.fts.a.a.n().i((Cursor)localObject1);
          if (!this.wWO.wWX.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).wVX))
          {
            localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(Long.valueOf(((com.tencent.mm.plugin.fts.a.a.n)localObject3).wXe));
            if ((localObject4 == null) || (d.f(c.wUV, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).wVW, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).wVW) < 0))
            {
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).dOC();
              ((HashMap)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.fts.a.a.n)localObject3).wXe), localObject3);
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
      paramk.wXb = new ArrayList();
      paramk.wXb.addAll(((HashMap)localObject2).values());
      if (this.wWO.wWY != null) {
        Collections.sort(paramk.wXb, this.wWO.wWY);
      }
      AppMethodBeat.o(127643);
    }
    
    public final String getName()
    {
      return "FTS5SearchFriendLogic.NormalSearchTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.w.b
 * JD-Core Version:    0.7.0.1
 */