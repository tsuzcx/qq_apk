package com.tencent.mm.pluginsdk.j;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.df;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  public static a QYE;
  private static Set<String> QYF;
  private static Set<String> QYG;
  private static volatile boolean QYH;
  private static volatile boolean QYI;
  private static boolean QYJ;
  private volatile boolean jxo;
  private IListener<df> jxr;
  
  static
  {
    AppMethodBeat.i(192332);
    QYE = new a();
    QYF = new HashSet();
    QYG = new HashSet();
    QYH = false;
    QYI = false;
    AppMethodBeat.o(192332);
  }
  
  private a()
  {
    AppMethodBeat.i(192277);
    this.jxr = new IListener() {};
    if ((((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.wbj, 0) == 1) || (com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) {}
    for (boolean bool = true;; bool = false)
    {
      QYJ = bool;
      Log.i("MicroMsg.ContactBlackListHelper", "asyncNotifyChange = %b", new Object[] { Boolean.valueOf(QYJ) });
      this.jxr.alive();
      AppMethodBeat.o(192277);
      return;
    }
  }
  
  private static void bqo(String paramString)
  {
    AppMethodBeat.i(192297);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((localas != null) && ((int)localas.jxt > 0))
    {
      Log.i("MicroMsg.ContactBlackListHelper", "onContactStorageNotifyChange isBLackListContact: %s, isSnsBlack: %s,", new Object[] { Boolean.valueOf(localas.ayc()), Boolean.valueOf(localas.ayi()) });
      for (;;)
      {
        synchronized (QYF)
        {
          if (localas.ayc()) {
            QYF.add(paramString);
          }
        }
        synchronized (QYG)
        {
          if (localas.ayi())
          {
            QYG.add(paramString);
            AppMethodBeat.o(192297);
            return;
            QYF.remove(paramString);
            continue;
            paramString = finally;
            AppMethodBeat.o(192297);
            throw paramString;
          }
          else
          {
            QYG.remove(paramString);
          }
        }
      }
    }
    AppMethodBeat.o(192297);
  }
  
  public static List<String> hhV()
  {
    AppMethodBeat.i(192316);
    Log.i("MicroMsg.ContactBlackListHelper", "getBlackListContacts");
    long l;
    synchronized (QYF)
    {
      Log.i("MicroMsg.ContactBlackListHelper", "getBlackListContacts cacheReady = %b", new Object[] { Boolean.valueOf(QYH) });
      if ((!QYF.isEmpty()) || (QYH)) {
        break label233;
      }
      l = System.currentTimeMillis();
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      try
      {
        com.tencent.mm.kernel.h.aHH();
        localCursor1 = localCursor2;
        localCursor2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().nI("@black.android", "");
        localCursor1 = localCursor2;
        localCursor2.moveToFirst();
        for (;;)
        {
          localCursor1 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break;
          }
          localCursor1 = localCursor2;
          QYF.add(localCursor2.getString(0));
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
        AppMethodBeat.o(192316);
      }
    }
    Object localObject2 = localObject3;
    QYH = true;
    if (localObject3 != null) {
      localObject3.close();
    }
    Log.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    label233:
    Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { QYF });
    localObject2 = new ArrayList(QYF);
    AppMethodBeat.o(192316);
    return localObject2;
  }
  
  public static List<String> hhW()
  {
    AppMethodBeat.i(192327);
    Log.i("MicroMsg.ContactBlackListHelper", "getSnsBlackListContacts");
    synchronized (QYG)
    {
      Log.i("MicroMsg.ContactBlackListHelper", "getSnsBlackListContacts snsCacheReady = %b", new Object[] { Boolean.valueOf(QYI) });
      if (QYG.isEmpty())
      {
        boolean bool = QYI;
        if (bool) {}
      }
      try
      {
        long l = System.currentTimeMillis();
        QYG.addAll(ab.bed());
        QYH = true;
        Log.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { QYG });
        ArrayList localArrayList = new ArrayList(QYG);
        AppMethodBeat.o(192327);
        return localArrayList;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.ContactBlackListHelper", "getSnsBlackListContacts failed, message = %s", new Object[] { localThrowable.getMessage() });
        }
      }
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(192286);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(192286);
      return;
    }
    paramObject = (String)paramObject;
    Log.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", new Object[] { paramObject });
    if ((paramMStorageEx instanceof bv))
    {
      if (this.jxo)
      {
        AppMethodBeat.o(192286);
        return;
      }
      if (!Util.isNullOrNil(paramObject))
      {
        if (QYJ)
        {
          com.tencent.e.h.ZvG.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(201854);
              a.bqp(paramObject);
              AppMethodBeat.o(201854);
            }
          }, "Thread-ContactBlackListHelper-onNotifyChange");
          AppMethodBeat.o(192286);
          return;
        }
        bqo(paramObject);
      }
    }
    AppMethodBeat.o(192286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a
 * JD-Core Version:    0.7.0.1
 */