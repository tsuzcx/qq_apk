package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private com.tencent.mm.plugin.fts.a.m jSC;
  private a jSD;
  private MStorageEx.IOnStorageChange jSE;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.jSE = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.aEu())
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
            b.b(b.this).a(65636, new b.f(b.this, paramAnonymousMStorageEx));
            AppMethodBeat.o(127632);
            return;
            if (paramAnonymousMStorageEx == null)
            {
              b.b(b.this).a(65636, new b.c(b.this));
              AppMethodBeat.o(127632);
              return;
            }
            b.b(b.this).a(65636, new b.d(b.this, paramAnonymousMStorageEx));
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
    paramj = this.jSC.a(-65536, paramj);
    AppMethodBeat.o(127647);
    return paramj;
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg().remove(this.jSE);
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
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(127645);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.jSD = ((a)((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.jSC = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.jSC.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg().add(this.jSE);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String fLC;
    long id;
    String jSG;
    String jSH;
    String jSI;
    String jSJ;
    String nickName;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.a.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.a.a.aaw(parama.getMd5());
      this.realName = parama.bxT();
      this.jSG = parama.bxV();
      this.jSH = parama.bxU();
      this.nickName = parama.getNickName();
      this.jSI = parama.bxX();
      this.jSJ = parama.bxW();
      this.userName = parama.getUsername();
      this.fLC = parama.bxY();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    public boolean jSK;
    private HashSet<Long> jSL;
    private long jSM;
    private int jSN;
    private HashMap<int[], b.e> jSO;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.jSK = false;
      this.jSL = null;
      this.jSM = -9223372036854775808L;
      this.jSN = -1;
      this.jSO = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(127635);
      Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.jSK = b.aEu();
      if (this.jSN < 0) {
        this.jSN = 0;
      }
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.jSK), Integer.valueOf(this.jSN) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.jSN == 0) {
        if (this.jSK)
        {
          if (!this.jSO.containsKey(c.BGI)) {
            this.jSO.put(c.BGI, new b.e((byte)0));
          }
          if (this.jSL == null)
          {
            this.jSL = new HashSet();
            localObject1 = b.a(b.this).a(c.BGI, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.jSL.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().h("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.jSM) });
          i = 50;
          while (((Cursor)localObject1).moveToNext())
          {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              b.a(b.this).commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(127635);
              throw ((Throwable)localObject1);
            }
            l = ((Cursor)localObject1).getLong(0);
            this.jSM = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).jSG = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).jSH = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).nickName = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).jSI = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).jSJ = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).fLC = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.jSL.remove(Long.valueOf(((b.a)localObject2).id))))
            {
              if (i < 50) {
                break label793;
              }
              b.a(b.this).commit();
              b.a(b.this).beginTransaction();
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
            localObject2 = (b.e)this.jSO.get(c.BGI);
            i = j;
            ((b.e)localObject2).jSR += 1;
            i = j;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.jSO.get(c.BGI);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.a(b.this).commit();
        localObject1 = this.jSL.iterator();
        i = 50;
        if (((Iterator)localObject1).hasNext())
        {
          if (i < 50) {
            break label790;
          }
          b.a(b.this).commit();
          b.a(b.this).beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          b.a(b.this).c(c.BGI, l);
          locale = (b.e)this.jSO.get(c.BGI);
          locale.jSS += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.a(b.this).commit();
          this.jSL = null;
          this.jSM = -9223372036854775808L;
          this.jSN = -1;
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
      if (this.jSO.containsKey(c.BGI))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.jSO.get(c.BGI)).jSR + ", removed: " + ((b.e)this.jSO.get(c.BGI)).jSS + ", failed: " + ((b.e)this.jSO.get(c.BGI)).mFailedCount + "]";
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
    private int jSP = 0;
    private int mCount = 0;
    
    public c() {}
    
    public final boolean aEv()
    {
      AppMethodBeat.i(127637);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.jSP) });
      if (this.jSP == 0) {
        this.mCount = b.a(b.this).j(c.BGI, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.jSP + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int jSP;
    private String jSQ;
    
    public d(String paramString)
    {
      this.jSQ = paramString;
      this.jSP = 0;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(127639);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.jSQ, Integer.valueOf(this.jSP) });
      if (this.jSP == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.aaw(this.jSQ);
        b.a(b.this).c(c.BGI, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.jSQ + "\", " + this.jSP + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int jSR = 0;
    public int jSS = 0;
    public int mFailedCount = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int jSP;
    private String jSQ;
    private boolean jST = false;
    
    public f(String paramString)
    {
      this.jSQ = paramString;
      this.jSP = 0;
    }
    
    public final boolean aEv()
    {
      AppMethodBeat.i(127641);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.jSQ, Integer.valueOf(this.jSP) });
      if (this.jSP == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).aaA(this.jSQ);
        if (localObject == null)
        {
          this.jST = true;
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
        this.jST = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.jSQ).append("\", ").append(this.jSP).append(")");
      if (this.jST) {}
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
    private int[] jSU;
    private int[] jSV;
    
    public g(com.tencent.mm.plugin.fts.a.a.j paramj)
    {
      super();
      this.jSU = paramj.BIP;
      this.jSV = paramj.BIQ;
    }
    
    public final void a(k paramk)
    {
      AppMethodBeat.i(127643);
      super.a(paramk);
      Object localObject3 = b.a(b.this);
      Object localObject5 = paramk.BHY.BIy;
      Object localObject2 = this.jSU;
      Object localObject1 = this.jSV;
      Object localObject4 = d.H((String[])localObject5);
      localObject5 = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { ((com.tencent.mm.plugin.fts.a.a)localObject3).eqJ(), Integer.valueOf(localObject5.length) });
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
        localObject1 = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + (String)localObject5 + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + (String)localObject2 + "" + " AND status >= 0" + (String)localObject1 + ";", new Object[] { ((com.tencent.mm.plugin.fts.a.a)localObject3).eqI(), ((com.tencent.mm.plugin.fts.a.a)localObject3).eqI(), ((com.tencent.mm.plugin.fts.a.a)localObject3).eqJ(), ((com.tencent.mm.plugin.fts.a.a)localObject3).eqI(), ((com.tencent.mm.plugin.fts.a.a)localObject3).eqJ(), ((com.tencent.mm.plugin.fts.a.a)localObject3).eqJ(), localObject4 });
        localObject1 = ((com.tencent.mm.plugin.fts.a.a)localObject3).BGp.aHA((String)localObject1);
        localObject2 = new HashMap();
        while (((Cursor)localObject1).moveToNext())
        {
          localObject3 = new com.tencent.mm.plugin.fts.a.a.n().k((Cursor)localObject1);
          if (!this.BIJ.BIS.contains(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHS))
          {
            localObject4 = (com.tencent.mm.plugin.fts.a.a.m)((HashMap)localObject2).get(Long.valueOf(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BIZ));
            if ((localObject4 == null) || (d.e(c.BGR, ((com.tencent.mm.plugin.fts.a.a.n)localObject3).BHR, ((com.tencent.mm.plugin.fts.a.a.m)localObject4).BHR) < 0))
            {
              ((com.tencent.mm.plugin.fts.a.a.n)localObject3).eqT();
              ((HashMap)localObject2).put(Long.valueOf(((com.tencent.mm.plugin.fts.a.a.n)localObject3).BIZ), localObject3);
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
      paramk.BIW = new ArrayList();
      paramk.BIW.addAll(((HashMap)localObject2).values());
      if (this.BIJ.BIT != null) {
        Collections.sort(paramk.BIW, this.BIJ.BIT);
      }
      AppMethodBeat.o(127643);
    }
    
    public final String getName()
    {
      return "FTS5SearchFriendLogic.NormalSearchTask";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */