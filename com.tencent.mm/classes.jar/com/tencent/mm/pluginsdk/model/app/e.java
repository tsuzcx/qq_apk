package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class e
  implements com.tencent.mm.am.h
{
  private Map<Integer, Set<y>> our;
  
  public e()
  {
    AppMethodBeat.i(151661);
    this.our = new HashMap();
    com.tencent.mm.kernel.h.baD().mCm.a(452, this);
    AppMethodBeat.o(151661);
  }
  
  public static void a(int paramInt, ae paramae)
  {
    AppMethodBeat.i(151664);
    paramae = new af(paramInt, paramae);
    com.tencent.mm.kernel.h.baD().mCm.a(paramae, 0);
    AppMethodBeat.o(151664);
  }
  
  public final void a(final int paramInt, final y paramy)
  {
    AppMethodBeat.i(151662);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151658);
        if (!e.a(e.this).containsKey(Integer.valueOf(paramInt))) {
          e.a(e.this).put(Integer.valueOf(paramInt), new HashSet());
        }
        if ((e.a(e.this).get(Integer.valueOf(paramInt)) != null) && (!((Set)e.a(e.this).get(Integer.valueOf(paramInt))).contains(paramy))) {
          ((Set)e.a(e.this).get(Integer.valueOf(paramInt))).add(paramy);
        }
        AppMethodBeat.o(151658);
      }
    });
    AppMethodBeat.o(151662);
  }
  
  public final void b(final int paramInt, final y paramy)
  {
    AppMethodBeat.i(151663);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151659);
        if (e.a(e.this).get(Integer.valueOf(paramInt)) != null) {
          ((Set)e.a(e.this).get(Integer.valueOf(paramInt))).remove(paramy);
        }
        AppMethodBeat.o(151659);
      }
    });
    AppMethodBeat.o(151663);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(151665);
    if (!(paramp instanceof af))
    {
      Log.i("MicroMsg.AppCenterNetSceneService", "onSceneEnd, the scene is not a instance of NetSceneAppCenter");
      AppMethodBeat.o(151665);
      return;
    }
    paramp = (af)paramp;
    Set localSet = (Set)this.our.get(Integer.valueOf(paramp.XSN));
    if ((localSet != null) && (localSet.size() > 0))
    {
      Object localObject = new HashSet();
      ((Set)localObject).addAll(localSet);
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        y localy = (y)((Iterator)localObject).next();
        if ((localy != null) && (localSet.contains(localy))) {
          localy.a(paramInt1, paramInt2, paramString, paramp.XSO);
        }
      }
    }
    AppMethodBeat.o(151665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.e
 * JD-Core Version:    0.7.0.1
 */