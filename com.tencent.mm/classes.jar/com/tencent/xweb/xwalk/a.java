package com.tencent.xweb.xwalk;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.b.c;
import com.tencent.xweb.xwalk.b.k;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  public static com.tencent.xweb.a.a eS(Object paramObject)
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
        str1 = locala1.aadP;
        paramObject = locala1.aadQ;
        if (!locala1.aadP.equals("executeCommand")) {
          break label396;
        }
        paramObject = com.tencent.xweb.a.bEK(locala1.aadQ);
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
          break label399;
        }
        i = 0;
        break label399;
        if (!str1.equals("fix_dex")) {
          break label399;
        }
        i = 1;
        break label399;
        if (!str1.equals("cStrClearInstallEmbedVersionRecord")) {
          break label399;
        }
        i = 2;
        break label399;
        if (!str1.equals("clearSchedule")) {
          break label399;
        }
        i = 3;
        break label399;
        locala.ZZA = true;
        try
        {
          i = Integer.parseInt(paramObject);
          p.bq(XWalkEnvironment.getApplicationContext(), i);
          AppMethodBeat.o(154150);
        }
        catch (Exception localException)
        {
          Log.e("ConfigCmdProc", "parse revertapk cmdvalue to int failed , value is ".concat(String.valueOf(paramObject)));
          AppMethodBeat.o(154150);
        }
      }
      break;
      locala.ZZA = true;
      if (p.iyT())
      {
        continue;
        locala.ZZA = true;
        XWalkUpdater.iyM();
        continue;
        Log.i("ConfigCmdProc", "got command : ".concat(String.valueOf(localException)));
        String str2 = com.tencent.xweb.a.oO("clearSchedule", "tools");
        if ((!TextUtils.isEmpty(paramObject)) && (!paramObject.equals(str2))) {
          Log.i("ConfigCmdProc", "this command value changed from " + str2 + " to " + paramObject);
        }
        for (i = j; i != 0; i = 0)
        {
          c.IY(false).izt();
          c.IY(true).izt();
          break;
        }
        label396:
        break label113;
        label399:
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