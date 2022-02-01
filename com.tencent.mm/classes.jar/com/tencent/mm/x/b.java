package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  private m msU;
  private a msV;
  private MStorageEx.IOnStorageChange msW;
  
  public b()
  {
    AppMethodBeat.i(127644);
    this.msW = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(127632);
        if (!b.aXy())
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
  
  public final com.tencent.mm.plugin.fts.a.a.c a(l paraml)
  {
    AppMethodBeat.i(127647);
    paraml = new b.g(this, paraml);
    paraml = this.msU.a(-65536, paraml);
    AppMethodBeat.o(127647);
    return paraml;
  }
  
  public final boolean aXx()
  {
    AppMethodBeat.i(127646);
    ((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg().remove(this.msW);
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
    if (!((n)h.az(n.class)).isFTSContextReady())
    {
      Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
      AppMethodBeat.o(127645);
      return false;
    }
    Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
    this.msV = ((a)((n)h.az(n.class)).getFTSIndexStorage(1280));
    this.msU = ((n)h.az(n.class)).getFTSTaskDaemon();
    this.msU.a(131172, new b((byte)0));
    ((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg().add(this.msW);
    AppMethodBeat.o(127645);
    return true;
  }
  
  static final class a
  {
    String hRk;
    long id;
    String msY;
    String msZ;
    String mta;
    String mtb;
    String nickName;
    String realName;
    int status;
    int type;
    String userName;
    
    a() {}
    
    a(com.tencent.mm.plugin.account.friend.model.a parama)
    {
      AppMethodBeat.i(127633);
      this.id = com.tencent.mm.plugin.account.friend.model.a.SQ(parama.getMd5());
      this.realName = parama.bWI();
      this.msY = parama.bWK();
      this.msZ = parama.bWJ();
      this.nickName = parama.getNickName();
      this.mta = parama.bWM();
      this.mtb = parama.bWL();
      this.userName = parama.getUsername();
      this.hRk = parama.bWN();
      this.type = parama.type;
      this.status = parama.status;
      AppMethodBeat.o(127633);
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    public boolean mtc;
    private HashSet<Long> mtd;
    private long mte;
    private int mtf;
    private HashMap<int[], b.e> mtg;
    
    private b()
    {
      AppMethodBeat.i(127634);
      this.mtc = false;
      this.mtd = null;
      this.mte = -9223372036854775808L;
      this.mtf = -1;
      this.mtg = new HashMap();
      AppMethodBeat.o(127634);
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(127635);
      Log.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
      this.mtc = b.aXy();
      if (this.mtf < 0) {
        this.mtf = 0;
      }
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.mtc), Integer.valueOf(this.mtf) });
      Object localObject1;
      long l;
      int i;
      Object localObject2;
      if (this.mtf == 0) {
        if (this.mtc)
        {
          if (!this.mtg.containsKey(com.tencent.mm.plugin.fts.a.c.Hrm)) {
            this.mtg.put(com.tencent.mm.plugin.fts.a.c.Hrm, new b.e((byte)0));
          }
          if (this.mtd == null)
          {
            this.mtd = new HashSet();
            localObject1 = b.a(b.this).a(com.tencent.mm.plugin.fts.a.c.Hrm, false, true, false, false, false);
            while (((Cursor)localObject1).moveToNext())
            {
              l = ((Cursor)localObject1).getLong(0);
              this.mtd.add(Long.valueOf(l));
            }
            ((Cursor)localObject1).close();
          }
          if (Thread.interrupted())
          {
            localObject1 = new InterruptedException();
            AppMethodBeat.o(127635);
            throw ((Throwable)localObject1);
          }
          localObject1 = ((n)h.az(n.class)).getFTSMainDB().h("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.mte) });
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
            this.mte = l;
            localObject2 = new b.a();
            ((b.a)localObject2).id = l;
            ((b.a)localObject2).realName = ((Cursor)localObject1).getString(1);
            ((b.a)localObject2).msY = ((Cursor)localObject1).getString(2);
            ((b.a)localObject2).msZ = ((Cursor)localObject1).getString(3);
            ((b.a)localObject2).nickName = ((Cursor)localObject1).getString(4);
            ((b.a)localObject2).mta = ((Cursor)localObject1).getString(5);
            ((b.a)localObject2).mtb = ((Cursor)localObject1).getString(6);
            ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
            ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
            ((b.a)localObject2).hRk = ((Cursor)localObject1).getString(9);
            ((b.a)localObject2).type = 0;
            if (((b.a)localObject2).status == 65536) {
              ((b.a)localObject2).status = 0;
            }
            if ((b.a((b.a)localObject2)) && (!this.mtd.remove(Long.valueOf(((b.a)localObject2).id))))
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
            localObject2 = (b.e)this.mtg.get(com.tencent.mm.plugin.fts.a.c.Hrm);
            i = j;
            ((b.e)localObject2).mtj += 1;
            i = j;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
            locale = (b.e)this.mtg.get(com.tencent.mm.plugin.fts.a.c.Hrm);
            locale.mFailedCount += 1;
          }
        }
        break;
        ((Cursor)localObject1).close();
        b.a(b.this).commit();
        localObject1 = this.mtd.iterator();
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
          b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrm, l);
          locale = (b.e)this.mtg.get(com.tencent.mm.plugin.fts.a.c.Hrm);
          locale.mtk += 1;
          ((Iterator)localObject1).remove();
          i += 1;
          break;
          b.a(b.this).commit();
          this.mtd = null;
          this.mte = -9223372036854775808L;
          this.mtf = -1;
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
      if (this.mtg.containsKey(com.tencent.mm.plugin.fts.a.c.Hrm))
      {
        String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.mtg.get(com.tencent.mm.plugin.fts.a.c.Hrm)).mtj + ", removed: " + ((b.e)this.mtg.get(com.tencent.mm.plugin.fts.a.c.Hrm)).mtk + ", failed: " + ((b.e)this.mtg.get(com.tencent.mm.plugin.fts.a.c.Hrm)).mFailedCount + "]";
        AppMethodBeat.o(127636);
        return str;
      }
      AppMethodBeat.o(127636);
      return "";
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int mCount = 0;
    private int mth = 0;
    
    public c() {}
    
    public final boolean aXz()
    {
      AppMethodBeat.i(127637);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", new Object[] { Integer.valueOf(this.mth) });
      if (this.mth == 0) {
        this.mCount = b.a(b.this).w(com.tencent.mm.plugin.fts.a.c.Hrm, -1).size();
      }
      AppMethodBeat.o(127637);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127638);
      String str = "DeleteAllFriends [" + this.mCount + ", " + this.mth + "]";
      AppMethodBeat.o(127638);
      return str;
    }
  }
  
  final class d
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int mth;
    private String mti;
    
    public d(String paramString)
    {
      this.mti = paramString;
      this.mth = 0;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(127639);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.mti, Integer.valueOf(this.mth) });
      if (this.mth == 0)
      {
        long l = com.tencent.mm.plugin.account.friend.model.a.SQ(this.mti);
        b.a(b.this).c(com.tencent.mm.plugin.fts.a.c.Hrm, l);
      }
      AppMethodBeat.o(127639);
      return true;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127640);
      String str = "DeleteFriend(\"" + this.mti + "\", " + this.mth + ")";
      AppMethodBeat.o(127640);
      return str;
    }
  }
  
  static final class e
  {
    public int mFailedCount = 0;
    public int mtj = 0;
    public int mtk = 0;
  }
  
  final class f
    extends com.tencent.mm.plugin.fts.a.a.c
  {
    private int mth;
    private String mti;
    private boolean mtl = false;
    
    public f(String paramString)
    {
      this.mti = paramString;
      this.mth = 0;
    }
    
    public final boolean aXz()
    {
      AppMethodBeat.i(127641);
      Log.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", new Object[] { this.mti, Integer.valueOf(this.mth) });
      if (this.mth == 0)
      {
        Object localObject = ((com.tencent.mm.plugin.account.friend.model.b)((com.tencent.mm.plugin.account.sdk.a.a)h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).SU(this.mti);
        if (localObject == null)
        {
          this.mtl = true;
          AppMethodBeat.o(127641);
          return true;
        }
        localObject = new b.a((com.tencent.mm.plugin.account.friend.model.a)localObject);
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
        this.mtl = true;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(127642);
      StringBuilder localStringBuilder = new StringBuilder("InsertFriend(\"").append(this.mti).append("\", ").append(this.mth).append(")");
      if (this.mtl) {}
      for (String str = " [skipped]";; str = "")
      {
        str = str;
        AppMethodBeat.o(127642);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */