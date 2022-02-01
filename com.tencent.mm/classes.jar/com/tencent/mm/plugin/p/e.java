package com.tencent.mm.plugin.p;

import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveDB;", "Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB;", "()V", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "isCreated", "", "create", "dbPath", "", "getDB", "Companion", "plugin-livestorage_release"})
public abstract class e
  extends a
{
  public static final a EiU = new a((byte)0);
  private volatile boolean dfI;
  private h lvy;
  
  public final boolean aNf(String paramString)
  {
    p.k(paramString, "dbPath");
    if ((!this.dfI) && (this.lvy == null))
    {
      long l1 = cm.bfE();
      Object localObject1 = u.bBT(paramString);
      if (!u.agG((String)localObject1)) {
        u.bBD((String)localObject1);
      }
      this.lvy = new h();
      localObject1 = collectFinderDatabaseFactory();
      Object localObject2 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String[] arrayOfString = ((h.b)((Map.Entry)((Iterator)localObject2).next()).getValue()).getSQLs();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            Log.i("MicroMsg.Mvvm.MMLiveDB", "run sql: ".concat(String.valueOf(arrayOfString[i])));
            i += 1;
          }
        }
      }
      localObject2 = this.lvy;
      if (localObject2 != null) {}
      for (localObject1 = Boolean.valueOf(((h)localObject2).a(paramString, (HashMap)localObject1, true));; localObject1 = null)
      {
        if ((p.h(localObject1, Boolean.TRUE) ^ true))
        {
          Log.i("MicroMsg.Mvvm.MMLiveDB", "create db error, dbPath:".concat(String.valueOf(paramString)));
          this.lvy = null;
        }
        eLS();
        long l2 = cm.bfE();
        this.dfI = true;
        Log.i("MicroMsg.Mvvm.MMLiveDB", "initDB params %d %s %s", new Object[] { Long.valueOf(l2 - l1), Util.getSizeMB(u.bBQ(paramString), 100.0D), paramString });
        if (localObject1 == null) {
          break;
        }
        return ((Boolean)localObject1).booleanValue();
      }
      return false;
    }
    return false;
  }
  
  public final h getDB()
  {
    return this.lvy;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveDB$Companion;", "", "()V", "TAG", "", "plugin-livestorage_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.p.e
 * JD-Core Version:    0.7.0.1
 */