package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ab.a;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

final class a$1
  implements Log.LogCallback
{
  private final HashSet<String> vJm;
  
  a$1(a parama)
  {
    AppMethodBeat.i(58777);
    this.vJm = new HashSet();
    AppMethodBeat.o(58777);
  }
  
  public final void println(int paramInt, String arg2, String paramString2)
  {
    AppMethodBeat.i(58778);
    ab.a locala = ab.dsH();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(58778);
      return;
    case 2: 
      locala.logV(???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58778);
      return;
    case 3: 
      locala.logD(???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58778);
      return;
    case 4: 
      locala.logI(???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58778);
      return;
    case 5: 
      locala.logW(???, "", "", 0, i, j, i, paramString2);
      if ((???.equals("WCDB.SQLite")) && (paramString2.startsWith("[SQLite ErrCode: 284] automatic index on ")))
      {
        paramString2 = paramString2.substring(41);
        synchronized (this.vJm)
        {
          boolean bool = this.vJm.add(paramString2);
          if (bool) {}
        }
      }
      AppMethodBeat.o(58778);
      return;
    case 6: 
      locala.logE(???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58778);
      return;
    }
    locala.logF(???, "", "", 0, i, j, i, paramString2);
    AppMethodBeat.o(58778);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a.1
 * JD-Core Version:    0.7.0.1
 */