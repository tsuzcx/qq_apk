package com.tencent.mm.plugin.p;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveMainDBExt;", "Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB;", "()V", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "isCreated", "", "create", "", "mainDB", "getDB", "Companion", "plugin-livestorage_release"})
public abstract class g
  extends a
{
  public static final a EiV = new a((byte)0);
  private volatile boolean dfI;
  private h lvy;
  
  public final void d(h paramh)
  {
    p.k(paramh, "mainDB");
    if ((!this.dfI) && (this.lvy == null))
    {
      this.lvy = paramh;
      paramh = ((Map)collectFinderDatabaseFactory()).entrySet().iterator();
      while (paramh.hasNext())
      {
        String[] arrayOfString = ((h.b)((Map.Entry)paramh.next()).getValue()).getSQLs();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            Log.i("MicroMsg.Mvvm.MMLiveMainDBExt", "run sql: ".concat(String.valueOf(str)));
            h localh = this.lvy;
            if (localh != null) {
              localh.execSQL("", str);
            }
            i += 1;
          }
        }
      }
      eLS();
      this.dfI = true;
    }
  }
  
  public final h getDB()
  {
    return this.lvy;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/MMLiveMainDBExt$Companion;", "", "()V", "TAG", "", "plugin-livestorage_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.p.g
 * JD-Core Version:    0.7.0.1
 */