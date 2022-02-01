package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ad.a;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

public final class a
  extends com.tencent.mm.kernel.a.c.a
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(133029);
    if (!j.pr("wcdb"))
    {
      getClass().getClassLoader();
      j.pq("wcdb");
    }
    Log.setLogger(new Log.LogCallback()
    {
      private final HashSet<String> BML;
      
      public final void println(int paramAnonymousInt, String arg2, String paramAnonymousString2)
      {
        AppMethodBeat.i(133028);
        ad.a locala = ad.eFv();
        int i = Process.myPid();
        int j = Process.myTid();
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(133028);
          return;
        case 2: 
          locala.logV(???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        case 3: 
          locala.logD(???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        case 4: 
          locala.logI(???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        case 5: 
          locala.logW(???, "", "", 0, i, j, i, paramAnonymousString2);
          if ((???.equals("WCDB.SQLite")) && (paramAnonymousString2.startsWith("[SQLite ErrCode: 284] automatic index on ")))
          {
            paramAnonymousString2 = paramAnonymousString2.substring(41);
            synchronized (this.BML)
            {
              boolean bool = this.BML.add(paramAnonymousString2);
              if (bool) {}
            }
          }
          AppMethodBeat.o(133028);
          return;
        case 6: 
          locala.logE(???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        }
        locala.logF(???, "", "", 0, i, j, i, paramAnonymousString2);
        AppMethodBeat.o(133028);
      }
    });
    AppMethodBeat.o(133029);
  }
  
  public final String name()
  {
    return "boot-db-prepare";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a
 * JD-Core Version:    0.7.0.1
 */