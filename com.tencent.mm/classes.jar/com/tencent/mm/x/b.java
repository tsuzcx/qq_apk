package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m fUc;
  a fUd;
  private n.b fUe;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.fUe = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.acP())
        {
          AppMethodBeat.o(127632);
          return;
        }
        if ((paramAnonymousObject != null) && ((paramAnonymousObject instanceof String)))
        {
          paramAnonymousn = (String)paramAnonymousObject;
          switch (paramAnonymousInt)
          {
          }
        }
        for (;;)
        {
          AppMethodBeat.o(127632);
          return;
          paramAnonymousn = null;
          break;
          if (paramAnonymousn != null)
          {
            b.this.fUc.a(65636, new b.f(b.this, paramAnonymousn));
            AppMethodBeat.o(127632);
            return;
            if (paramAnonymousn == null)
            {
              b.this.fUc.a(65636, new b.c(b.this));
              AppMethodBeat.o(127632);
              return;
            }
            b.this.fUc.a(65636, new b.d(b.this, paramAnonymousn));
          }
        }
      }
    };
    AppMethodBeat.o(127644);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.j paramj)
  {
    AppMethodBeat.i(127647);
    paramj = new b.g(this, paramj);
    paramj = this.fUc.a(-65536, paramj);
    AppMethodBeat.o(127647);
    return paramj;
  }
  
  public final boolean acO()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.fUe);
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
    if (!((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady())
    {
      ad.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(127645);
      return false;
    }
    ad.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.fUd = ((a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.fUc = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.fUc.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.fUe);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String bNK;
    String dpO;
    String fUg;
    String fUh;
    String fUi;
    String fUj;
    long id;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.a.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.a.a.Ca(parama.JS());
      this.realName = parama.aIv();
      this.fUg = parama.aIx();
      this.fUh = parama.aIw();
      this.bNK = parama.getNickName();
      this.fUi = parama.aIz();
      this.fUj = parama.aIy();
      this.userName = parama.getUsername();
      this.dpO = parama.aIA();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    public boolean fUk;
    private HashSet<Long> fUl;
    private long fUm;
    private int fUn;
    private HashMap<int[], b.e> fUo;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.fUk = false;
      this.fUl = null;
      this.fUm = -9223372036854775808L;
      this.fUn = -1;
      this.fUo = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127635);
      ad.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.fUk = b.acP();
      if (this.fUn < 0) {
        this.fUn = 0;
      }
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.fUk), Integer.valueOf(this.fUn) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.fUn == 0) {
        if (this.fUk)
        {
          if (!this.fUo.containsKey(c.rnB)) {
            this.fUo.put(c.rnB, new b.e((byte)0));
          }
          if (this.fUl == null)
          {
            this.fUl = new HashSet();
            localObject1 = b.this.fUd.a(c.rnB, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.fUl.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.fUm) });
          i = 50;
          while (((Cursor)localObject1).moveToNext())
          {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              b.this.fUd.commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(127635);
              throw ((Throwable)localObject1);
            }
            l = ((Cursor)localObject1).getLong(0);
            this.fUm = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).fUg = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).fUh = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).bNK = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).fUi = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).fUj = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).dpO = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.fUl.remove(Long.valueOf(((b.a)localObject2).id))))
            {
              if (i < 50) {
                break label793;
              }
              b.this.fUd.commit();
              b.this.fUd.beginTransaction();
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
            localObject2 = (b.e)this.fUo.get(c.rnB);
            i = j;
            ((b.e)localObject2).fUr += 1;
            i = j;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.fUo.get(c.rnB);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.this.fUd.commit();
        localObject1 = this.fUl.iterator();
        i = 50;
        if (((Iterator)localObject1).hasNext())
        {
          if (i < 50) {
            break label790;
          }
          b.this.fUd.commit();
          b.this.fUd.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          b.this.fUd.c(c.rnB, l);
          locale = (b.e)this.fUo.get(c.rnB);
          locale.fUs += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.this.fUd.commit();
          this.fUl = null;
          this.fUm = -9223372036854775808L;
          this.fUn = -1;
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
      if (this.fUo.containsKey(c.rnB))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.fUo.get(c.rnB)).fUr + ", removed: " + ((b.e)this.fUo.get(c.rnB)).fUs + ", failed: " + ((b.e)this.fUo.get(c.rnB)).mFailedCount + "]";
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
    private int fUp = 0;
    private int mCount = 0;
    
    public c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(127637);
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.fUp) });
      if (this.fUp == 0) {
        this.mCount = b.this.fUd.g(c.rnB, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.fUp + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int fUp;
    private String fUq;
    
    public d(String paramString)
    {
      this.fUq = paramString;
      this.fUp = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127639);
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.fUq, Integer.valueOf(this.fUp) });
      if (this.fUp == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.Ca(this.fUq);
        b.this.fUd.c(c.rnB, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.fUq + "\", " + this.fUp + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int fUr = 0;
    public int fUs = 0;
    public int mFailedCount = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int fUp;
    private String fUq;
    private boolean fUt = false;
    
    public f(String paramString)
    {
      this.fUq = paramString;
      this.fUp = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127641);
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.fUq, Integer.valueOf(this.fUp) });
      if (this.fUp == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cf(this.fUq);
        if (localObject == null)
        {
          this.fUt = true;
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
        this.fUt = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.fUq).append("\", ").append(this.fUp).append(")");
      if (this.fUt) {}
      for (String str = " [skipped]";; str = "")
      {
        str = str;
        AppMethodBeat.o(127642);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */