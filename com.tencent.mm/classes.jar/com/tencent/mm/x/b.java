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
  m grs;
  a grt;
  private n.b gru;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.gru = new n.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.sdk.e.n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.agB())
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
            b.this.grs.a(65636, new b.f(b.this, paramAnonymousn));
            AppMethodBeat.o(127632);
            return;
            if (paramAnonymousn == null)
            {
              b.this.grs.a(65636, new b.c(b.this));
              AppMethodBeat.o(127632);
              return;
            }
            b.this.grs.a(65636, new b.d(b.this, paramAnonymousn));
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
    paramj = this.grs.a(-65536, paramj);
    AppMethodBeat.o(127647);
    return paramj;
  }
  
  public final boolean agA()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.gru);
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
    this.grt = ((a)((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(1280));
    this.grs = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
    this.grs.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.gru);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String bVF;
    String dzn;
    String grw;
    String grx;
    String gry;
    String grz;
    long id;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.a.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.a.a.Js(parama.Lb());
      this.realName = parama.aSy();
      this.grw = parama.aSA();
      this.grx = parama.aSz();
      this.bVF = parama.getNickName();
      this.gry = parama.aSC();
      this.grz = parama.aSB();
      this.userName = parama.getUsername();
      this.dzn = parama.aSD();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    public boolean grA;
    private HashSet<Long> grB;
    private long grC;
    private int grD;
    private HashMap<int[], b.e> grE;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.grA = false;
      this.grB = null;
      this.grC = -9223372036854775808L;
      this.grD = -1;
      this.grE = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127635);
      ad.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.grA = b.agB();
      if (this.grD < 0) {
        this.grD = 0;
      }
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.grA), Integer.valueOf(this.grD) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.grD == 0) {
        if (this.grA)
        {
          if (!this.grE.containsKey(c.tsW)) {
            this.grE.put(c.tsW, new b.e((byte)0));
          }
          if (this.grB == null)
          {
            this.grB = new HashSet();
            localObject1 = b.this.grt.a(c.tsW, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.grB.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.grC) });
          i = 50;
          while (((Cursor)localObject1).moveToNext())
          {
            if (Thread.interrupted())
            {
              ((Cursor)localObject1).close();
              b.this.grt.commit();
              localObject1 = new InterruptedException();
              AppMethodBeat.o(127635);
              throw ((Throwable)localObject1);
            }
            l = ((Cursor)localObject1).getLong(0);
            this.grC = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).grw = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).grx = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).bVF = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).gry = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).grz = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).dzn = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.grB.remove(Long.valueOf(((b.a)localObject2).id))))
            {
              if (i < 50) {
                break label793;
              }
              b.this.grt.commit();
              b.this.grt.beginTransaction();
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
            localObject2 = (b.e)this.grE.get(c.tsW);
            i = j;
            ((b.e)localObject2).grH += 1;
            i = j;
          }
          catch (Exception localException)
          {
            ad.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.grE.get(c.tsW);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.this.grt.commit();
        localObject1 = this.grB.iterator();
        i = 50;
        if (((Iterator)localObject1).hasNext())
        {
          if (i < 50) {
            break label790;
          }
          b.this.grt.commit();
          b.this.grt.beginTransaction();
          i = 0;
        }
        for (;;)
        {
          l = ((Long)((Iterator)localObject1).next()).longValue();
          b.this.grt.c(c.tsW, l);
          locale = (b.e)this.grE.get(c.tsW);
          locale.grI += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.this.grt.commit();
          this.grB = null;
          this.grC = -9223372036854775808L;
          this.grD = -1;
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
      if (this.grE.containsKey(c.tsW))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.grE.get(c.tsW)).grH + ", removed: " + ((b.e)this.grE.get(c.tsW)).grI + ", failed: " + ((b.e)this.grE.get(c.tsW)).mFailedCount + "]";
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
    private int grF = 0;
    private int mCount = 0;
    
    public c() {}
    
    public final boolean execute()
    {
      AppMethodBeat.i(127637);
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.grF) });
      if (this.grF == 0) {
        this.mCount = b.this.grt.j(c.tsW, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.grF + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int grF;
    private String grG;
    
    public d(String paramString)
    {
      this.grG = paramString;
      this.grF = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127639);
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.grG, Integer.valueOf(this.grF) });
      if (this.grF == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.a.a.Js(this.grG);
        b.this.grt.c(c.tsW, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.grG + "\", " + this.grF + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int grH = 0;
    public int grI = 0;
    public int mFailedCount = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.a
  {
    private int grF;
    private String grG;
    private boolean grJ = false;
    
    public f(String paramString)
    {
      this.grG = paramString;
      this.grF = 0;
    }
    
    public final boolean execute()
    {
      AppMethodBeat.i(127641);
      ad.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.grG, Integer.valueOf(this.grF) });
      if (this.grF == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Jx(this.grG);
        if (localObject == null)
        {
          this.grJ = true;
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
        this.grJ = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.grG).append("\", ").append(this.grF).append(")");
      if (this.grJ) {}
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
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */