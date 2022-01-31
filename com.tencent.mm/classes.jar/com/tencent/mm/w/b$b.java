package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class b$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  public boolean ezo;
  private HashSet<Long> ezp;
  private long ezq;
  private int ezr;
  private HashMap<int[], b.e> ezs;
  
  private b$b(b paramb)
  {
    AppMethodBeat.i(124476);
    this.ezo = false;
    this.ezp = null;
    this.ezq = -9223372036854775808L;
    this.ezr = -1;
    this.ezs = new HashMap();
    AppMethodBeat.o(124476);
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(124477);
    ab.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
    this.ezo = b.Pq();
    if (this.ezr < 0) {
      this.ezr = 0;
    }
    ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.ezo), Integer.valueOf(this.ezr) });
    Object localObject1;
    long l;
    int i;
    Object localObject2;
    if (this.ezr == 0) {
      if (this.ezo)
      {
        if (!this.ezs.containsKey(c.mQK)) {
          this.ezs.put(c.mQK, new b.e((byte)0));
        }
        if (this.ezp == null)
        {
          this.ezp = new HashSet();
          localObject1 = this.ezi.ezg.a(c.mQK, false, true, false, false, false);
          while (((Cursor)localObject1).moveToNext())
          {
            l = ((Cursor)localObject1).getLong(0);
            this.ezp.add(Long.valueOf(l));
          }
          ((Cursor)localObject1).close();
        }
        if (Thread.interrupted())
        {
          localObject1 = new InterruptedException();
          AppMethodBeat.o(124477);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((n)g.G(n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.ezq) });
        i = 50;
        while (((Cursor)localObject1).moveToNext())
        {
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            this.ezi.ezg.commit();
            localObject1 = new InterruptedException();
            AppMethodBeat.o(124477);
            throw ((Throwable)localObject1);
          }
          l = ((Cursor)localObject1).getLong(0);
          this.ezq = l;
          localObject2 = new b.a();
          ((b.a)localObject2).id = l;
          ((b.a)localObject2).ezj = ((Cursor)localObject1).getString(1);
          ((b.a)localObject2).ezk = ((Cursor)localObject1).getString(2);
          ((b.a)localObject2).ezl = ((Cursor)localObject1).getString(3);
          ((b.a)localObject2).blZ = ((Cursor)localObject1).getString(4);
          ((b.a)localObject2).ezm = ((Cursor)localObject1).getString(5);
          ((b.a)localObject2).ezn = ((Cursor)localObject1).getString(6);
          ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
          ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
          ((b.a)localObject2).czF = ((Cursor)localObject1).getString(9);
          ((b.a)localObject2).type = 0;
          if (((b.a)localObject2).status == 65536) {
            ((b.a)localObject2).status = 0;
          }
          if ((b.a((b.a)localObject2)) && (!this.ezp.remove(Long.valueOf(((b.a)localObject2).id))))
          {
            if (i < 50) {
              break label793;
            }
            this.ezi.ezg.commit();
            this.ezi.ezg.beginTransaction();
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
          j += b.a(this.ezi, (b.a)localObject2);
          i = j;
          localObject2 = (b.e)this.ezs.get(c.mQK);
          i = j;
          ((b.e)localObject2).ezv += 1;
          i = j;
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
          locale = (b.e)this.ezs.get(c.mQK);
          locale.mFailedCount += 1;
        }
      }
      break;
      ((Cursor)localObject1).close();
      this.ezi.ezg.commit();
      localObject1 = this.ezp.iterator();
      i = 50;
      if (((Iterator)localObject1).hasNext())
      {
        if (i < 50) {
          break label790;
        }
        this.ezi.ezg.commit();
        this.ezi.ezg.beginTransaction();
        i = 0;
      }
      for (;;)
      {
        l = ((Long)((Iterator)localObject1).next()).longValue();
        this.ezi.ezg.c(c.mQK, l);
        locale = (b.e)this.ezs.get(c.mQK);
        locale.ezw += 1;
        ((Iterator)localObject1).remove();
        i += 1;
        break;
        this.ezi.ezg.commit();
        this.ezp = null;
        this.ezq = -9223372036854775808L;
        this.ezr = -1;
        AppMethodBeat.o(124477);
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
    AppMethodBeat.i(124478);
    if (this.ezs.containsKey(c.mQK))
    {
      String str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.ezs.get(c.mQK)).ezv + ", removed: " + ((b.e)this.ezs.get(c.mQK)).ezw + ", failed: " + ((b.e)this.ezs.get(c.mQK)).mFailedCount + "]";
      AppMethodBeat.o(124478);
      return str;
    }
    AppMethodBeat.o(124478);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.b.b
 * JD-Core Version:    0.7.0.1
 */