package com.tencent.mm.pluginsdk.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class j
  implements n.b
{
  public static j Has;
  private static Set<String> Hat;
  private static Set<String> Hau;
  private volatile boolean ICF;
  private c<cu> ICG;
  
  static
  {
    AppMethodBeat.i(210357);
    Has = new j();
    Hat = new HashSet();
    Hau = new HashSet();
    AppMethodBeat.o(210357);
  }
  
  private j()
  {
    AppMethodBeat.i(210353);
    this.ICG = new c() {};
    this.ICG.alive();
    AppMethodBeat.o(210353);
  }
  
  public static List<String> fdj()
  {
    AppMethodBeat.i(210355);
    long l;
    synchronized (Hat)
    {
      if (!Hat.isEmpty()) {
        break label194;
      }
      l = System.currentTimeMillis();
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      try
      {
        g.agS();
        localCursor1 = localCursor2;
        localCursor2 = ((k)g.ab(k.class)).awB().ly("@black.android", "");
        localCursor1 = localCursor2;
        localCursor2.moveToFirst();
        for (;;)
        {
          localCursor1 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break;
          }
          localCursor1 = localCursor2;
          Hat.add(localCursor2.getString(0));
          localCursor1 = localCursor2;
          localCursor2.moveToNext();
        }
        localObject1 = finally;
      }
      finally
      {
        if (localCursor1 != null) {
          localCursor1.close();
        }
        ac.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(210355);
      }
    }
    if (localObject2 != null) {
      localObject2.close();
    }
    ac.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    label194:
    ac.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { Hat });
    ArrayList localArrayList = new ArrayList(Hat);
    AppMethodBeat.o(210355);
    return localArrayList;
  }
  
  public static List<String> fdk()
  {
    AppMethodBeat.i(210356);
    synchronized (Hau)
    {
      if (Hau.isEmpty())
      {
        long l = System.currentTimeMillis();
        Hau.addAll(w.ayn());
        ac.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      ac.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { Hau });
      ArrayList localArrayList = new ArrayList(Hau);
      AppMethodBeat.o(210356);
      return localArrayList;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(210354);
    if (!(paramObject instanceof String))
    {
      ac.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(210354);
      return;
    }
    paramObject = (String)paramObject;
    ac.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", new Object[] { paramObject });
    if ((paramn instanceof bj))
    {
      if (this.ICF)
      {
        AppMethodBeat.o(210354);
        return;
      }
      if (!bs.isNullOrNil(paramObject))
      {
        paramn = ((k)g.ab(k.class)).awB().aNt(paramObject);
        if ((paramn != null) && ((int)paramn.fLJ > 0))
        {
          ac.i("MicroMsg.ContactBlackListHelper", "onContactStorageNotifyChange isBLackListContact: %s, isSnsBlack: %s,", new Object[] { Boolean.valueOf(paramn.aaH()), Boolean.valueOf(paramn.aaK()) });
          for (;;)
          {
            synchronized (Hat)
            {
              if (paramn.aaH()) {
                Hat.add(paramObject);
              }
            }
            synchronized (Hau)
            {
              if (paramn.aaK())
              {
                Hau.add(paramObject);
                AppMethodBeat.o(210354);
                return;
                Hat.remove(paramObject);
                continue;
                paramn = finally;
                AppMethodBeat.o(210354);
                throw paramn;
              }
              else
              {
                Hau.remove(paramObject);
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(210354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.j
 * JD-Core Version:    0.7.0.1
 */