package com.tencent.mm.pluginsdk.platformtools;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dp;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements MStorageEx.IOnStorageChange
{
  public static a XUF;
  private static Set<String> XUG;
  private static Set<String> XUH;
  private static volatile boolean XUI;
  private static volatile boolean XUJ;
  private volatile boolean maI;
  private IListener<dp> maL;
  
  static
  {
    AppMethodBeat.i(244648);
    XUF = new a();
    XUG = new HashSet();
    XUH = new HashSet();
    XUI = false;
    XUJ = false;
    AppMethodBeat.o(244648);
  }
  
  private a()
  {
    AppMethodBeat.i(244635);
    this.maL = new ContactBlackListHelper.1(this, f.hfK);
    this.maL.alive();
    AppMethodBeat.o(244635);
  }
  
  public static List<String> iIW()
  {
    AppMethodBeat.i(244639);
    Log.i("MicroMsg.ContactBlackListHelper", "getBlackListContacts");
    long l;
    synchronized (XUG)
    {
      Log.i("MicroMsg.ContactBlackListHelper", "getBlackListContacts cacheReady = %b", new Object[] { Boolean.valueOf(XUI) });
      if ((!XUG.isEmpty()) || (XUI)) {
        break label233;
      }
      l = System.currentTimeMillis();
      Cursor localCursor2 = null;
      Cursor localCursor1 = localCursor2;
      try
      {
        com.tencent.mm.kernel.h.baF();
        localCursor1 = localCursor2;
        localCursor2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().pH("@black.android", "");
        localCursor1 = localCursor2;
        localCursor2.moveToFirst();
        for (;;)
        {
          localCursor1 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break;
          }
          localCursor1 = localCursor2;
          XUG.add(localCursor2.getString(0));
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
        AppMethodBeat.o(244639);
      }
    }
    Object localObject2 = localObject3;
    XUI = true;
    if (localObject3 != null) {
      localObject3.close();
    }
    Log.i("MicroMsg.ContactBlackListHelper", "[select black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    label233:
    Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { XUG });
    localObject2 = new ArrayList(XUG);
    AppMethodBeat.o(244639);
    return localObject2;
  }
  
  public static List<String> iIX()
  {
    AppMethodBeat.i(244641);
    Log.i("MicroMsg.ContactBlackListHelper", "getSnsBlackListContacts");
    synchronized (XUH)
    {
      Log.i("MicroMsg.ContactBlackListHelper", "getSnsBlackListContacts snsCacheReady = %b", new Object[] { Boolean.valueOf(XUJ) });
      if (XUH.isEmpty())
      {
        boolean bool = XUJ;
        if (bool) {}
      }
      try
      {
        long l = System.currentTimeMillis();
        XUH.addAll(ab.bBU());
        XUI = true;
        Log.i("MicroMsg.ContactBlackListHelper", "[select sns black list] cost:%d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Log.i("MicroMsg.ContactBlackListHelper", "[get black list] %s", new Object[] { XUH });
        ArrayList localArrayList = new ArrayList(XUH);
        AppMethodBeat.o(244641);
        return localArrayList;
      }
      finally
      {
        for (;;)
        {
          Log.e("MicroMsg.ContactBlackListHelper", "getSnsBlackListContacts failed, message = %s", new Object[] { localObject1.getMessage() });
        }
      }
    }
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, final Object paramObject)
  {
    AppMethodBeat.i(244658);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ContactBlackListHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(244658);
      return;
    }
    paramObject = (String)paramObject;
    Log.i("MicroMsg.ContactBlackListHelper", "onNotifyChange %s", new Object[] { paramObject });
    if ((paramMStorageEx instanceof bx))
    {
      if (this.maI)
      {
        AppMethodBeat.o(244658);
        return;
      }
      if (!Util.isNullOrNil(paramObject)) {
        com.tencent.threadpool.h.ahAA.g(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(244642);
            a.bqc(paramObject);
            AppMethodBeat.o(244642);
          }
        }, "Thread-ContactBlackListHelper-onNotifyChange");
      }
    }
    AppMethodBeat.o(244658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.platformtools.a
 * JD-Core Version:    0.7.0.1
 */