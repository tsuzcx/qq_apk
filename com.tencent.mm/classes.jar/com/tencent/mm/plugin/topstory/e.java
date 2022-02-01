package com.tencent.mm.plugin.topstory;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.fuu;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class e
{
  private static void a(Context paramContext, int paramInt, a.a parama)
  {
    try
    {
      AppMethodBeat.i(271626);
      paramContext = new a(paramContext, paramInt, parama);
      paramContext.hks = true;
      if (paramContext.hks)
      {
        paramContext.hku = new a.2(paramContext);
        MMHandlerThread.postToMainThreadDelayed(paramContext.hku, 200L);
      }
      paramContext.hkt = new a.1(paramContext);
      MMHandlerThread.postToMainThreadDelayed(paramContext.hkt, 60000L);
      h.baD().mCm.a(4071, paramContext);
      paramContext = new b(paramContext.zZv);
      h.baD().mCm.a(paramContext, 0);
      AppMethodBeat.o(271626);
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext, int paramInt, final a parama)
  {
    AppMethodBeat.i(271630);
    a(paramContext, paramInt, new a.a()
    {
      public final void b(boolean paramAnonymousBoolean, fuu paramAnonymousfuu)
      {
        AppMethodBeat.i(271616);
        if ((paramAnonymousfuu == null) || (!paramAnonymousBoolean))
        {
          parama.cjC();
          AppMethodBeat.o(271616);
          return;
        }
        parama.a(paramAnonymousfuu);
        AppMethodBeat.o(271616);
      }
    });
    AppMethodBeat.o(271630);
  }
  
  public static abstract interface a
  {
    public abstract void a(fuu paramfuu);
    
    public abstract void cjC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.e
 * JD-Core Version:    0.7.0.1
 */