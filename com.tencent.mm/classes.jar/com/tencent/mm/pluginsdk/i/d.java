package com.tencent.mm.pluginsdk.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d
  implements n.b
{
  public static d Fhk;
  private static Set<String> Fhl;
  private static Set<String> Fhm;
  private volatile boolean Fhn;
  private com.tencent.mm.sdk.b.c<cy> Fho;
  
  static
  {
    AppMethodBeat.i(218877);
    Fhk = new d();
    Fhl = new HashSet();
    Fhm = new HashSet();
    AppMethodBeat.o(218877);
  }
  
  private d()
  {
    AppMethodBeat.i(218873);
    this.Fho = new com.tencent.mm.sdk.b.c() {};
    this.Fho.alive();
    AppMethodBeat.o(218873);
  }
  
  public static List<String> fef()
  {
    AppMethodBeat.i(218875);
    long l;
    synchronized (Fhl)
    {
      if (!Fhl.isEmpty()) {
        break label194;
      }
      l = System.currentTimeMillis();
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      try
      {
        g.ajS();
        localCursor1 = localCursor2;
        localCursor2 = ((l)g.ab(l.class)).azF().md("@black.android", "");
        localCursor1 = localCursor2;
        localCursor2.moveToFirst();
        for (;;)
        {
          localCursor1 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break;
          }
          localCursor1 = localCursor2;
          Fhl.add(localCursor2.getString(0));
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
        ae.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(218875);
      }
    }
    if (localObject2 != null) {
      localObject2.close();
    }
    ae.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    label194:
    ae.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { Fhl });
    ArrayList localArrayList = new ArrayList(Fhl);
    AppMethodBeat.o(218875);
    return localArrayList;
  }
  
  public static List<String> feg()
  {
    AppMethodBeat.i(218876);
    synchronized (Fhm)
    {
      if (Fhm.isEmpty())
      {
        long l = System.currentTimeMillis();
        Fhm.addAll(x.aBD());
        ae.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      ae.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { Fhm });
      ArrayList localArrayList = new ArrayList(Fhm);
      AppMethodBeat.o(218876);
      return localArrayList;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(218874);
    if (!(paramObject instanceof String))
    {
      ae.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(218874);
      return;
    }
    paramObject = (String)paramObject;
    ae.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", new Object[] { paramObject });
    if ((paramn instanceof bq))
    {
      if (this.Fhn)
      {
        AppMethodBeat.o(218874);
        return;
      }
      if (!bu.isNullOrNil(paramObject))
      {
        paramn = ((l)g.ab(l.class)).azF().BH(paramObject);
        if ((paramn != null) && ((int)paramn.ght > 0))
        {
          ae.i("MicroMsg.ContactBlackListHelper", "onContactStorageNotifyChange isBLackListContact: %s, isSnsBlack: %s,", new Object[] { Boolean.valueOf(paramn.adv()), Boolean.valueOf(paramn.ady()) });
          for (;;)
          {
            synchronized (Fhl)
            {
              if (paramn.adv()) {
                Fhl.add(paramObject);
              }
            }
            synchronized (Fhm)
            {
              if (paramn.ady())
              {
                Fhm.add(paramObject);
                AppMethodBeat.o(218874);
                return;
                Fhl.remove(paramObject);
                continue;
                paramn = finally;
                AppMethodBeat.o(218874);
                throw paramn;
              }
              else
              {
                Fhm.remove(paramObject);
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(218874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.d
 * JD-Core Version:    0.7.0.1
 */