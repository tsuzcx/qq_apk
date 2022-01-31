package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
  extends j<e>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(62848);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "EmojiSuggestDescInfo") };
    AppMethodBeat.o(62848);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    this(parame, e.info, "EmojiSuggestDescInfo");
  }
  
  private f(com.tencent.mm.sdk.e.e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.db = parame;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean an(ArrayList<ArrayList<String>> paramArrayList)
  {
    AppMethodBeat.i(62847);
    if (paramArrayList.isEmpty())
    {
      ab.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
      AppMethodBeat.o(62847);
      return false;
    }
    h localh;
    long l;
    if ((this.db instanceof h))
    {
      localh = (h)this.db;
      l = localh.kr(Thread.currentThread().getId());
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
          if (!bo.isNullOrNil(str))
          {
            ab.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[] { String.valueOf(i), str });
            insert(new e(String.valueOf(i), str));
          }
        }
        i += 1;
      }
      label219:
      for (;;)
      {
        break;
        if (localh != null) {
          localh.nY(l);
        }
        AppMethodBeat.o(62847);
        return false;
      }
      l = -1L;
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.f
 * JD-Core Version:    0.7.0.1
 */