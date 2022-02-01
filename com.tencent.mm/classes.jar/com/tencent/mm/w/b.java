package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m fXX;
  a fXY;
  private n.b fXZ;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.fXZ = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.adV())
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
            b.this.fXX.a(65636, new b.f(b.this, paramAnonymousn));
            AppMethodBeat.o(127632);
            return;
            if (paramAnonymousn == null)
            {
              b.this.fXX.a(65636, new b.c(b.this));
              AppMethodBeat.o(127632);
              return;
            }
            b.this.fXX.a(65636, new b.d(b.this, paramAnonymousn));
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
    paramj = this.fXX.a(-65536, paramj);
    AppMethodBeat.o(127647);
    return paramj;
  }
  
  public final boolean adU()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.fXZ);
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
      ac.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(127645);
      return false;
    }
    ac.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.fXY = ((a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.fXX = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.fXX.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.fXZ);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String bLs;
    String dnz;
    String fYb;
    String fYc;
    String fYd;
    String fYe;
    long id;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.a.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.a.a.Gd(parama.JC());
      this.realName = parama.aPm();
      this.fYb = parama.aPo();
      this.fYc = parama.aPn();
      this.bLs = parama.getNickName();
      this.fYd = parama.aPq();
      this.fYe = parama.aPp();
      this.userName = parama.getUsername();
      this.dnz = parama.aPr();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    public boolean fYf;
    private HashSet<Long> fYg;
    private long fYh;
    private int fYi;
    private HashMap<int[], b.e> fYj;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.fYf = false;
      this.fYg = null;
      this.fYh = -9223372036854775808L;
      this.fYi = -1;
      this.fYj = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127635);
      ac.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.fYf = b.adV();
      if (this.fYi < 0) {
        this.fYi = 0;
      }
      ac.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.fYf), Integer.valueOf(this.fYi) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.fYi == 0) {
        if (this.fYf)
        {
          if (!this.fYj.containsKey(c.swv)) {
            this.fYj.put(c.swv, new b.e((byte)0));
          }
          if (this.fYg == null)
          {
            this.fYg = new HashSet();
            localObject1 = b.this.fXY.a(c.swv, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.fYg.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.fYh) });
          i = 50;
          while (((Cursor)localObject1).moveToNext())
          {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              b.this.fXY.commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(127635);
              throw ((Throwable)localObject1);
            }
            l = ((Cursor)localObject1).getLong(0);
            this.fYh = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).fYb = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).fYc = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).bLs = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).fYd = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).fYe = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).dnz = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.fYg.remove(Long.valueOf(((b.a)localObject2).id))))
            {
              if (i < 50) {
                break label793;
              }
              b.this.fXY.commit();
              b.this.fXY.beginTransaction();
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
            localObject2 = (b.e)this.fYj.get(c.swv);
            i = j;
            ((b.e)localObject2).fYm += 1;
            i = j;
          }
          catch (Exception localException)
          {
            ac.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.fYj.get(c.swv);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.this.fXY.commit();
        localObject1 = this.fYg.iterator();
        i = 50;
        if (((Iterator)localObject1).hasNext())
        {
          if (i < 50) {
            break label790;
          }
          b.this.fXY.commit();
          b.this.fXY.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          b.this.fXY.c(c.swv, l);
          locale = (b.e)this.fYj.get(c.swv);
          locale.fYn += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.this.fXY.commit();
          this.fYg = null;
          this.fYh = -9223372036854775808L;
          this.fYi = -1;
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
      if (this.fYj.containsKey(c.swv))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.fYj.get(c.swv)).fYm + ", removed: " + ((b.e)this.fYj.get(c.swv)).fYn + ", failed: " + ((b.e)this.fYj.get(c.swv)).mFailedCount + "]";
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
    private int fYk = 0;
    private int mCount = 0;
    
    public c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(127637);
      ac.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.fYk) });
      if (this.fYk == 0) {
        this.mCount = b.this.fXY.j(c.swv, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.fYk + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int fYk;
    private String fYl;
    
    public d(String paramString)
    {
      this.fYl = paramString;
      this.fYk = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127639);
      ac.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.fYl, Integer.valueOf(this.fYk) });
      if (this.fYk == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.Gd(this.fYl);
        b.this.fXY.c(c.swv, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.fYl + "\", " + this.fYk + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int fYm = 0;
    public int fYn = 0;
    public int mFailedCount = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int fYk;
    private String fYl;
    private boolean fYo = false;
    
    public f(String paramString)
    {
      this.fYl = paramString;
      this.fYk = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127641);
      ac.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.fYl, Integer.valueOf(this.fYk) });
      if (this.fYk == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Gi(this.fYl);
        if (localObject == null)
        {
          this.fYo = true;
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
        this.fYo = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.fYl).append("\", ").append(this.fYk).append(")");
      if (this.fYo) {}
      for (String str = " [skipped]";; str = "")
      {
        str = str;
        AppMethodBeat.o(127642);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.b
 * JD-Core Version:    0.7.0.1
 */