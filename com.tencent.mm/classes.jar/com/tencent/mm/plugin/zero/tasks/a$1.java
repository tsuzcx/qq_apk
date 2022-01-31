package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.sdk.platformtools.y.a;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

final class a$1
  implements Log.LogCallback
{
  private final HashSet<String> rSs = new HashSet();
  
  a$1(a parama) {}
  
  public final void println(int paramInt, String arg2, String paramString2)
  {
    y.a locala = y.cqK();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        return;
        locala.logV(???, "", "", 0, i, j, i, paramString2);
        return;
        locala.logD(???, "", "", 0, i, j, i, paramString2);
        return;
        locala.logI(???, "", "", 0, i, j, i, paramString2);
        return;
        locala.logW(???, "", "", 0, i, j, i, paramString2);
        if ((???.equals("WCDB.SQLite")) && (paramString2.startsWith("[SQLite ErrCode: 284] automatic index on ")))
        {
          paramString2 = paramString2.substring(41);
          synchronized (this.rSs)
          {
            boolean bool = this.rSs.add(paramString2);
            if (!bool) {
              try
              {
                f.nEG.d("DBAutoIndex", paramString2, null);
                return;
              }
              catch (Exception ???)
              {
                y.e("DBLogger", "Cannot report automatic index: " + ???.getMessage());
                return;
              }
            }
          }
        }
      }
    case 6: 
      locala.logE(???, "", "", 0, i, j, i, paramString2);
      return;
    }
    locala.logF(???, "", "", 0, i, j, i, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.tasks.a.1
 * JD-Core Version:    0.7.0.1
 */