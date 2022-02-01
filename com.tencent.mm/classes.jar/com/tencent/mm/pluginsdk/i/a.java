package com.tencent.mm.pluginsdk.i;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.db;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements MStorageEx.IOnStorageChange
{
  public static a JYc;
  private static Set<String> JYd;
  private static Set<String> JYe;
  private static boolean JYg;
  private volatile boolean JYf;
  private IListener<db> JYh;
  
  static
  {
    AppMethodBeat.i(223817);
    JYc = new a();
    JYd = new HashSet();
    JYe = new HashSet();
    AppMethodBeat.o(223817);
  }
  
  private a()
  {
    AppMethodBeat.i(223811);
    this.JYh = new IListener() {};
    if ((((b)g.af(b.class)).a(b.a.spn, 0) == 1) || (d.KyR) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (boolean bool = true;; bool = false)
    {
      JYg = bool;
      Log.i("MicroMsg.ContactBlackListHelper", "asyncNotifyChange = %b", new Object[] { Boolean.valueOf(JYg) });
      this.JYh.alive();
      AppMethodBeat.o(223811);
      return;
    }
  }
  
  private static void bdS(String paramString)
  {
    AppMethodBeat.i(223813);
    as localas = ((l)g.af(l.class)).aSN().Kn(paramString);
    if ((localas != null) && ((int)localas.gMZ > 0))
    {
      Log.i("MicroMsg.ContactBlackListHelper", "onContactStorageNotifyChange isBLackListContact: %s, isSnsBlack: %s,", new Object[] { Boolean.valueOf(localas.ary()), Boolean.valueOf(localas.arB()) });
      for (;;)
      {
        synchronized (JYd)
        {
          if (localas.ary()) {
            JYd.add(paramString);
          }
        }
        synchronized (JYe)
        {
          if (localas.arB())
          {
            JYe.add(paramString);
            AppMethodBeat.o(223813);
            return;
            JYd.remove(paramString);
            continue;
            paramString = finally;
            AppMethodBeat.o(223813);
            throw paramString;
          }
          else
          {
            JYe.remove(paramString);
          }
        }
      }
    }
    AppMethodBeat.o(223813);
  }
  
  public static List<String> gnp()
  {
    AppMethodBeat.i(223814);
    long l;
    synchronized (JYd)
    {
      if (!JYd.isEmpty()) {
        break label194;
      }
      l = System.currentTimeMillis();
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      try
      {
        g.aAi();
        localCursor1 = localCursor2;
        localCursor2 = ((l)g.af(l.class)).aSN().mR("@black.android", "");
        localCursor1 = localCursor2;
        localCursor2.moveToFirst();
        for (;;)
        {
          localCursor1 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break;
          }
          localCursor1 = localCursor2;
          JYd.add(localCursor2.getString(0));
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
        Log.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(223814);
      }
    }
    if (localObject2 != null) {
      localObject2.close();
    }
    Log.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    label194:
    Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { JYd });
    ArrayList localArrayList = new ArrayList(JYd);
    AppMethodBeat.o(223814);
    return localArrayList;
  }
  
  public static List<String> gnq()
  {
    AppMethodBeat.i(223815);
    synchronized (JYe)
    {
      if (JYe.isEmpty())
      {
        long l = System.currentTimeMillis();
        JYe.addAll(ab.aVa());
        Log.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      }
      Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { JYe });
      ArrayList localArrayList = new ArrayList(JYe);
      AppMethodBeat.o(223815);
      return localArrayList;
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(223812);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(223812);
      return;
    }
    paramObject = (String)paramObject;
    Log.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", new Object[] { paramObject });
    if ((paramMStorageEx instanceof bv))
    {
      if (this.JYf)
      {
        AppMethodBeat.o(223812);
        return;
      }
      if (!Util.isNullOrNil(paramObject))
      {
        if (JYg)
        {
          h.RTc.b(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(223810);
              a.bdT(paramObject);
              AppMethodBeat.o(223810);
            }
          }, "Thread-ContactBlackListHelper-onNotifyChange");
          AppMethodBeat.o(223812);
          return;
        }
        bdS(paramObject);
      }
    }
    AppMethodBeat.o(223812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.a
 * JD-Core Version:    0.7.0.1
 */