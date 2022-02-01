package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

final class a$1
  implements Log.LogCallback
{
  private final HashSet<String> Fbm;
  
  a$1(a parama)
  {
    AppMethodBeat.i(133027);
    this.Fbm = new HashSet();
    AppMethodBeat.o(133027);
  }
  
  public final void println(int paramInt, String arg2, String paramString2)
  {
    AppMethodBeat.i(133028);
    ae.a locala = ae.fon();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(133028);
      return;
    case 2: 
      locala.logV(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    case 3: 
      locala.logD(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    case 4: 
      locala.logI(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    case 5: 
      locala.logW(0L, ???, "", "", 0, i, j, i, paramString2);
      if ((???.equals("WCDB.SQLite")) && (paramString2.startsWith("[SQLite ErrCode: 284] automatic index on ")))
      {
        paramString2 = paramString2.substring(41);
        synchronized (this.Fbm)
        {
          boolean bool = this.Fbm.add(paramString2);
          if (bool) {}
        }
      }
      AppMethodBeat.o(133028);
      return;
    case 6: 
      locala.logE(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    }
    locala.logF(0L, ???, "", "", 0, i, j, i, paramString2);
    AppMethodBeat.o(133028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a.1
 * JD-Core Version:    0.7.0.1
 */