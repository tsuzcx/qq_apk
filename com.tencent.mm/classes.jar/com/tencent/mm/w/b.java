package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m gtT;
  a gtU;
  private n.b gtV;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.gtV = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.agP())
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
            b.this.gtT.a(65636, new b.f(b.this, paramAnonymousn));
            AppMethodBeat.o(127632);
            return;
            if (paramAnonymousn == null)
            {
              b.this.gtT.a(65636, new b.c(b.this));
              AppMethodBeat.o(127632);
              return;
            }
            b.this.gtT.a(65636, new b.d(b.this, paramAnonymousn));
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
    paramj = this.gtT.a(-65536, paramj);
    AppMethodBeat.o(127647);
    return paramj;
  }
  
  public final boolean agO()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.gtV);
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
      ae.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(127645);
      return false;
    }
    ae.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.gtU = ((a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.gtT = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.gtT.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.gtV);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String bVF;
    String dAs;
    String gtX;
    String gtY;
    String gtZ;
    String gua;
    long id;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.a.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.a.a.JR(parama.Lj());
      this.realName = parama.aSX();
      this.gtX = parama.aSZ();
      this.gtY = parama.aSY();
      this.bVF = parama.getNickName();
      this.gtZ = parama.aTb();
      this.gua = parama.aTa();
      this.userName = parama.getUsername();
      this.dAs = parama.aTc();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    public boolean gub;
    private HashSet<Long> guc;
    private long gud;
    private int gue;
    private HashMap<int[], b.e> guf;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.gub = false;
      this.guc = null;
      this.gud = -9223372036854775808L;
      this.gue = -1;
      this.guf = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127635);
      ae.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.gub = b.agP();
      if (this.gue < 0) {
        this.gue = 0;
      }
      ae.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.gub), Integer.valueOf(this.gue) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.gue == 0) {
        if (this.gub)
        {
          if (!this.guf.containsKey(c.tDN)) {
            this.guf.put(c.tDN, new b.e((byte)0));
          }
          if (this.guc == null)
          {
            this.guc = new HashSet();
            localObject1 = b.this.gtU.a(c.tDN, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.guc.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.gud) });
          i = 50;
          while (((Cursor)localObject1).moveToNext())
          {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              b.this.gtU.commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(127635);
              throw ((Throwable)localObject1);
            }
            l = ((Cursor)localObject1).getLong(0);
            this.gud = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).gtX = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).gtY = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).bVF = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).gtZ = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).gua = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).dAs = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.guc.remove(Long.valueOf(((b.a)localObject2).id))))
            {
              if (i < 50) {
                break label793;
              }
              b.this.gtU.commit();
              b.this.gtU.beginTransaction();
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
            localObject2 = (b.e)this.guf.get(c.tDN);
            i = j;
            ((b.e)localObject2).gui += 1;
            i = j;
          }
          catch (Exception localException)
          {
            ae.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.guf.get(c.tDN);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.this.gtU.commit();
        localObject1 = this.guc.iterator();
        i = 50;
        if (((Iterator)localObject1).hasNext())
        {
          if (i < 50) {
            break label790;
          }
          b.this.gtU.commit();
          b.this.gtU.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          b.this.gtU.c(c.tDN, l);
          locale = (b.e)this.guf.get(c.tDN);
          locale.guj += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.this.gtU.commit();
          this.guc = null;
          this.gud = -9223372036854775808L;
          this.gue = -1;
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
      if (this.guf.containsKey(c.tDN))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.guf.get(c.tDN)).gui + ", removed: " + ((b.e)this.guf.get(c.tDN)).guj + ", failed: " + ((b.e)this.guf.get(c.tDN)).mFailedCount + "]";
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
    private int gug = 0;
    private int mCount = 0;
    
    public c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(127637);
      ae.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.gug) });
      if (this.gug == 0) {
        this.mCount = b.this.gtU.j(c.tDN, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.gug + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int gug;
    private String guh;
    
    public d(String paramString)
    {
      this.guh = paramString;
      this.gug = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127639);
      ae.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.guh, Integer.valueOf(this.gug) });
      if (this.gug == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.JR(this.guh);
        b.this.gtU.c(c.tDN, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.guh + "\", " + this.gug + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int gui = 0;
    public int guj = 0;
    public int mFailedCount = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int gug;
    private String guh;
    private boolean guk = false;
    
    public f(String paramString)
    {
      this.guh = paramString;
      this.gug = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127641);
      ae.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.guh, Integer.valueOf(this.gug) });
      if (this.gug == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).JW(this.guh);
        if (localObject == null)
        {
          this.guk = true;
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
        this.guk = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.guh).append("\", ").append(this.gug).append(")");
      if (this.guk) {}
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