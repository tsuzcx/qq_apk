package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
  extends MAutoStorage<h>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105107);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(h.info, "EmojiSuggestDescInfo") };
    AppMethodBeat.o(105107);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, h.info, "EmojiSuggestDescInfo");
  }
  
  private i(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
    this.db = paramISQLiteDatabase;
  }
  
  public final boolean cc(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(105106);
    if (paramArrayList.isEmpty())
    {
      Log.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
      AppMethodBeat.o(105106);
      return false;
    }
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((this.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)this.db;
      l = localh.beginTransaction(Thread.currentThread().getId());
    }
    for (;;)
    {
      this.db.delete("EmojiSuggestDescInfo", "", null);
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      if (paramArrayList.hasNext())
      {
        Object localObject = (ArrayList)paramArrayList.next();
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label219;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!Util.isNullOrNil(str))
          {
            Log.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[] { String.valueOf(i), str });
            insert(new h(String.valueOf(i), str));
          }
        }
        i += 1;
      }
      label219:
      for (;;)
      {
        break;
        if (localh != null) {
          localh.endTransaction(l);
        }
        AppMethodBeat.o(105106);
        return false;
      }
      l = -1L;
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.i
 * JD-Core Version:    0.7.0.1
 */