package com.tencent.xweb.xwalk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.updater.Scheduler;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkUpdater;

public final class a
{
  public static com.tencent.xweb.a.a ey(Object paramObject)
  {
    int j = 1;
    com.tencent.xweb.a.a locala;
    String str1;
    try
    {
      AppMethodBeat.i(154150);
      locala = new com.tencent.xweb.a.a();
      if ((paramObject == null) || (!(paramObject instanceof com.tencent.xweb.internal.a.a))) {
        AppMethodBeat.o(154150);
      }
      for (;;)
      {
        return locala;
        com.tencent.xweb.internal.a.a locala1 = (com.tencent.xweb.internal.a.a)paramObject;
        str1 = locala1.IPN;
        paramObject = locala1.IPO;
        if (!locala1.IPN.equals("executeCommand")) {
          break label385;
        }
        paramObject = com.tencent.xweb.a.aOO(locala1.IPO);
        if ((paramObject != null) && (paramObject.length >= 2)) {
          break;
        }
        AppMethodBeat.o(154150);
      }
      str1 = paramObject[0];
    }
    finally {}
    paramObject = paramObject[1];
    label113:
    int i = -1;
    switch (str1.hashCode())
    {
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(154150);
        break;
        if (!str1.equals("revertToVersion")) {
          break label388;
        }
        i = 0;
        break label388;
        if (!str1.equals("fix_dex")) {
          break label388;
        }
        i = 1;
        break label388;
        if (!str1.equals("cStrClearInstallEmbedVersionRecord")) {
          break label388;
        }
        i = 2;
        break label388;
        if (!str1.equals("clearSchedule")) {
          break label388;
        }
        i = 3;
        break label388;
        locala.IMj = true;
        try
        {
          i = Integer.parseInt(paramObject);
          o.aN(XWalkEnvironment.getApplicationContext(), i);
          AppMethodBeat.o(154150);
        }
        catch (Exception localException)
        {
          Log.e("ConfigCmdProc", "parse revertapk cmdvalue to int failed , value is ".concat(String.valueOf(paramObject)));
          AppMethodBeat.o(154150);
        }
      }
      break;
      locala.IMj = true;
      if (o.ftb())
      {
        continue;
        locala.IMj = true;
        XWalkUpdater.clearLastTryEmebedVersion();
        continue;
        Log.i("ConfigCmdProc", "got command : ".concat(String.valueOf(localException)));
        String str2 = com.tencent.xweb.a.lW("clearSchedule", "tools");
        if ((!TextUtils.isEmpty(paramObject)) && (!paramObject.equals(str2))) {
          Log.i("ConfigCmdProc", "this command value changed from " + str2 + " to " + paramObject);
        }
        for (i = j; i != 0; i = 0)
        {
          Scheduler.ftt();
          break;
        }
        label385:
        break label113;
        label388:
        switch (i)
        {
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a
 * JD-Core Version:    0.7.0.1
 */