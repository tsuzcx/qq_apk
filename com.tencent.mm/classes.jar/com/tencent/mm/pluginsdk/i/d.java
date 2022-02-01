package com.tencent.mm.pluginsdk.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class d
  implements n.b
{
  public static d EOP;
  private static Set<String> EOQ;
  private static Set<String> EOR;
  private volatile boolean EOS;
  private c<cx> EOT;
  
  static
  {
    AppMethodBeat.i(195424);
    EOP = new d();
    EOQ = new HashSet();
    EOR = new HashSet();
    AppMethodBeat.o(195424);
  }
  
  private d()
  {
    AppMethodBeat.i(195420);
    this.EOT = new c() {};
    this.EOT.alive();
    AppMethodBeat.o(195420);
  }
  
  public static List<String> far()
  {
    AppMethodBeat.i(195422);
    long l;
    synchronized (EOQ)
    {
      if (!EOQ.isEmpty()) {
        break label194;
      }
      l = System.currentTimeMillis();
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      try
      {
        g.ajD();
        localCursor1 = localCursor2;
        localCursor2 = ((l)g.ab(l.class)).azp().lW("@black.android", "");
        localCursor1 = localCursor2;
        localCursor2.moveToFirst();
        for (;;)
        {
          localCursor1 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break;
          }
          localCursor1 = localCursor2;
          EOQ.add(localCursor2.getString(0));
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
        ad.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(195422);
      }
    }
    if (localObject2 != null) {
      localObject2.close();
    }
    ad.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    label194:
    ad.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { EOQ });
    ArrayList localArrayList = new ArrayList(EOQ);
    AppMethodBeat.o(195422);
    return localArrayList;
  }
  
  public static List<String> fas()
  {
    AppMethodBeat.i(195423);
    synchronized (EOR)
    {
      if (EOR.isEmpty())
      {
        long l = System.currentTimeMillis();
        EOR.addAll(w.aBn());
        ad.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      ad.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { EOR });
      ArrayList localArrayList = new ArrayList(EOR);
      AppMethodBeat.o(195423);
      return localArrayList;
    }
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(195421);
    if (!(paramObject instanceof String))
    {
      ad.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(195421);
      return;
    }
    paramObject = (String)paramObject;
    ad.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", new Object[] { paramObject });
    if ((paramn instanceof bp))
    {
      if (this.EOS)
      {
        AppMethodBeat.o(195421);
        return;
      }
      if (!bt.isNullOrNil(paramObject))
      {
        paramn = ((l)g.ab(l.class)).azp().Bf(paramObject);
        if ((paramn != null) && ((int)paramn.gfj > 0))
        {
          ad.i("MicroMsg.ContactBlackListHelper", "onContactStorageNotifyChange isBLackListContact: %s, isSnsBlack: %s,", new Object[] { Boolean.valueOf(paramn.adk()), Boolean.valueOf(paramn.adn()) });
          for (;;)
          {
            synchronized (EOQ)
            {
              if (paramn.adk()) {
                EOQ.add(paramObject);
              }
            }
            synchronized (EOR)
            {
              if (paramn.adn())
              {
                EOR.add(paramObject);
                AppMethodBeat.o(195421);
                return;
                EOQ.remove(paramObject);
                continue;
                paramn = finally;
                AppMethodBeat.o(195421);
                throw paramn;
              }
              else
              {
                EOR.remove(paramObject);
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(195421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.d
 * JD-Core Version:    0.7.0.1
 */