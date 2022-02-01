package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class i
  extends j<h>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(105107);
    SQL_CREATE = new String[] { j.getCreateSQLs(h.info, "EmojiSuggestDescInfo") };
    AppMethodBeat.o(105107);
  }
  
  public i(e parame)
  {
    this(parame, h.info, "EmojiSuggestDescInfo");
  }
  
  private i(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean aW(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(105106);
    if (paramArrayList.isEmpty())
    {
      ac.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
      AppMethodBeat.o(105106);
      return false;
    }
    com.tencent.mm.storagebase.h localh;
    long l;
    if ((this.db instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)this.db;
      l = localh.vE(Thread.currentThread().getId());
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
          if (!bs.isNullOrNil(str))
          {
            ac.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[] { String.valueOf(i), str });
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
          localh.qL(l);
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