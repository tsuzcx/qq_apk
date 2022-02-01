package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

final class a$1
  implements Log.LogCallback
{
  private final HashSet<String> XMP;
  
  a$1(a parama)
  {
    AppMethodBeat.i(133027);
    this.XMP = new HashSet();
    AppMethodBeat.o(133027);
  }
  
  public final void println(int paramInt, String arg2, String paramString2)
  {
    AppMethodBeat.i(133028);
    Log.LogImp localLogImp = Log.getImpl();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(133028);
      return;
    case 2: 
      localLogImp.logV(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    case 3: 
      localLogImp.logD(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    case 4: 
      localLogImp.logI(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    case 5: 
      localLogImp.logW(0L, ???, "", "", 0, i, j, i, paramString2);
      if ((???.equals("WCDB.SQLite")) && (paramString2.startsWith("[SQLite ErrCode: 284] automatic index on ")))
      {
        paramString2 = paramString2.substring(41);
        synchronized (this.XMP)
        {
          boolean bool = this.XMP.add(paramString2);
          if (bool) {}
        }
      }
      AppMethodBeat.o(133028);
      return;
    case 6: 
      localLogImp.logE(0L, ???, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(133028);
      return;
    }
    localLogImp.logF(0L, ???, "", "", 0, i, j, i, paramString2);
    AppMethodBeat.o(133028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a.1
 * JD-Core Version:    0.7.0.1
 */