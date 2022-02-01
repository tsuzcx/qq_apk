package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

public final class a
  extends com.tencent.mm.kernel.a.c.a
{
  public final void execute(g paramg)
  {
    AppMethodBeat.i(133029);
    if (!j.KX("wcdb"))
    {
      getClass().getClassLoader();
      j.KW("wcdb");
    }
    com.tencent.wcdb.support.Log.setLogger(new Log.LogCallback()
    {
      private final HashSet<String> QRj;
      
      public final void println(int paramAnonymousInt, String arg2, String paramAnonymousString2)
      {
        AppMethodBeat.i(133028);
        Log.LogImp localLogImp = com.tencent.mm.sdk.platformtools.Log.getImpl();
        int i = Process.myPid();
        int j = Process.myTid();
        switch (paramAnonymousInt)
        {
        default: 
          AppMethodBeat.o(133028);
          return;
        case 2: 
          localLogImp.logV(0L, ???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        case 3: 
          localLogImp.logD(0L, ???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        case 4: 
          localLogImp.logI(0L, ???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        case 5: 
          localLogImp.logW(0L, ???, "", "", 0, i, j, i, paramAnonymousString2);
          if ((???.equals("WCDB.SQLite")) && (paramAnonymousString2.startsWith("[SQLite ErrCode: 284] automatic index on ")))
          {
            paramAnonymousString2 = paramAnonymousString2.substring(41);
            synchronized (this.QRj)
            {
              boolean bool = this.QRj.add(paramAnonymousString2);
              if (bool) {}
            }
          }
          AppMethodBeat.o(133028);
          return;
        case 6: 
          localLogImp.logE(0L, ???, "", "", 0, i, j, i, paramAnonymousString2);
          AppMethodBeat.o(133028);
          return;
        }
        localLogImp.logF(0L, ???, "", "", 0, i, j, i, paramAnonymousString2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a
 * JD-Core Version:    0.7.0.1
 */