package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

final class b$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  public boolean dBX = false;
  private HashSet<Long> dBY = null;
  private long dBZ = -9223372036854775808L;
  private int dCa = -1;
  private HashMap<int[], b.e> dCb = new HashMap();
  
  private b$b(b paramb) {}
  
  public final boolean execute()
  {
    y.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
    this.dBX = b.BC();
    if (this.dCa < 0) {
      this.dCa = 0;
    }
    y.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[] { Boolean.valueOf(this.dBX), Integer.valueOf(this.dCa) });
    Object localObject1;
    long l;
    int i;
    Object localObject2;
    if (this.dCa == 0) {
      if (this.dBX)
      {
        if (!this.dCb.containsKey(c.kuX)) {
          this.dCb.put(c.kuX, new b.e((byte)0));
        }
        if (this.dBY == null)
        {
          this.dBY = new HashSet();
          localObject1 = this.dBR.dBP.a(c.kuX, false, true, false, false, false);
          while (((Cursor)localObject1).moveToNext())
          {
            l = ((Cursor)localObject1).getLong(0);
            this.dBY.add(Long.valueOf(l));
          }
          ((Cursor)localObject1).close();
        }
        if (Thread.interrupted()) {
          throw new InterruptedException();
        }
        localObject1 = ((n)g.t(n.class)).getFTSMainDB().g("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[] { Long.toString(this.dBZ) });
        i = 50;
        while (((Cursor)localObject1).moveToNext())
        {
          if (Thread.interrupted())
          {
            ((Cursor)localObject1).close();
            this.dBR.dBP.commit();
            throw new InterruptedException();
          }
          l = ((Cursor)localObject1).getLong(0);
          this.dBZ = l;
          localObject2 = new b.a();
          ((b.a)localObject2).id = l;
          ((b.a)localObject2).dBS = ((Cursor)localObject1).getString(1);
          ((b.a)localObject2).dBT = ((Cursor)localObject1).getString(2);
          ((b.a)localObject2).dBU = ((Cursor)localObject1).getString(3);
          ((b.a)localObject2).aVr = ((Cursor)localObject1).getString(4);
          ((b.a)localObject2).dBV = ((Cursor)localObject1).getString(5);
          ((b.a)localObject2).dBW = ((Cursor)localObject1).getString(6);
          ((b.a)localObject2).userName = ((Cursor)localObject1).getString(7);
          ((b.a)localObject2).status = ((Cursor)localObject1).getInt(8);
          ((b.a)localObject2).bSe = ((Cursor)localObject1).getString(9);
          ((b.a)localObject2).type = 0;
          if (((b.a)localObject2).status == 65536) {
            ((b.a)localObject2).status = 0;
          }
          if ((b.a((b.a)localObject2)) && (!this.dBY.remove(Long.valueOf(((b.a)localObject2).id))))
          {
            if (i < 50) {
              break label765;
            }
            this.dBR.dBP.commit();
            this.dBR.dBP.beginTransaction();
          }
        }
      }
    }
    label762:
    label765:
    for (int j = 0;; j = i)
    {
      b.e locale;
      for (;;)
      {
        i = j;
        try
        {
          j += b.a(this.dBR, (b.a)localObject2);
          i = j;
          localObject2 = (b.e)this.dCb.get(c.kuX);
          i = j;
          ((b.e)localObject2).dCe += 1;
          i = j;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", localException, "Build mobile friend index failed with exception.", new Object[0]);
          locale = (b.e)this.dCb.get(c.kuX);
          locale.mFailedCount += 1;
        }
      }
      break;
      ((Cursor)localObject1).close();
      this.dBR.dBP.commit();
      localObject1 = this.dBY.iterator();
      i = 50;
      if (((Iterator)localObject1).hasNext())
      {
        if (i < 50) {
          break label762;
        }
        this.dBR.dBP.commit();
        this.dBR.dBP.beginTransaction();
        i = 0;
      }
      for (;;)
      {
        l = ((Long)((Iterator)localObject1).next()).longValue();
        this.dBR.dBP.c(c.kuX, l);
        locale = (b.e)this.dCb.get(c.kuX);
        locale.dCf += 1;
        ((Iterator)localObject1).remove();
        i += 1;
        break;
        this.dBR.dBP.commit();
        this.dBY = null;
        this.dBZ = -9223372036854775808L;
        this.dCa = -1;
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
    if (this.dCb.containsKey(c.kuX)) {
      return "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((b.e)this.dCb.get(c.kuX)).dCe + ", removed: " + ((b.e)this.dCb.get(c.kuX)).dCf + ", failed: " + ((b.e)this.dCb.get(c.kuX)).mFailedCount + "]";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.x.b.b
 * JD-Core Version:    0.7.0.1
 */