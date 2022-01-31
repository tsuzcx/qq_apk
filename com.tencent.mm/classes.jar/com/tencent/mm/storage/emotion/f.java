package com.tencent.mm.storage.emotion;

import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
  extends i<e>
  implements g.a
{
  public static final String[] dXp = { i.a(e.buS, "EmojiSuggestDescInfo") };
  private com.tencent.mm.sdk.e.e dXw;
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    this(parame, e.buS, "EmojiSuggestDescInfo");
  }
  
  private f(com.tencent.mm.sdk.e.e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    this.dXw = parame;
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final boolean af(ArrayList<ArrayList<String>> paramArrayList)
  {
    if (paramArrayList.isEmpty())
    {
      y.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
      return false;
    }
    h localh;
    long l;
    if ((this.dXw instanceof h))
    {
      localh = (h)this.dXw;
      l = localh.eV(Thread.currentThread().getId());
    }
    for (;;)
    {
      this.dXw.delete("EmojiSuggestDescInfo", "", null);
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      if (paramArrayList.hasNext())
      {
        Object localObject = (ArrayList)paramArrayList.next();
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label204;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if (!bk.bl(str))
          {
            y.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[] { String.valueOf(i), str });
            b(new e(String.valueOf(i), str));
          }
        }
        i += 1;
      }
      label204:
      for (;;)
      {
        break;
        if (localh == null) {
          break label205;
        }
        localh.hI(l);
        return false;
      }
      label205:
      break;
      l = -1L;
      localh = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.f
 * JD-Core Version:    0.7.0.1
 */