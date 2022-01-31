package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class a
{
  public static com.tencent.xweb.a.a db(Object paramObject)
  {
    int i = 0;
    com.tencent.xweb.a.a locala;
    String str;
    try
    {
      AppMethodBeat.i(85120);
      locala = new com.tencent.xweb.a.a();
      if ((paramObject == null) || (!(paramObject instanceof com.tencent.xweb.c.a.a))) {
        AppMethodBeat.o(85120);
      }
      for (;;)
      {
        return locala;
        com.tencent.xweb.c.a.a locala1 = (com.tencent.xweb.c.a.a)paramObject;
        str = locala1.BGk;
        paramObject = locala1.BGl;
        if (!locala1.BGk.equals("executeCommand")) {
          break label235;
        }
        paramObject = com.tencent.xweb.a.axO(locala1.BGl);
        if ((paramObject != null) && (paramObject.length >= 2)) {
          break;
        }
        AppMethodBeat.o(85120);
      }
      str = paramObject[0];
    }
    finally {}
    paramObject = paramObject[1];
    label111:
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(85120);
        break;
        if (!str.equals("revertToVersion")) {
          break label238;
        }
        break label240;
        if (!str.equals("fix_dex")) {
          break label238;
        }
        i = 1;
        break label240;
        locala.cyy = true;
        try
        {
          i = Integer.parseInt(paramObject);
          n.aH(XWalkEnvironment.getApplicationContext(), i);
          AppMethodBeat.o(85120);
        }
        catch (Exception localException)
        {
          Log.e("ConfigCmdProc", "parse revertapk cmdvalue to int failed , value is ".concat(String.valueOf(paramObject)));
          AppMethodBeat.o(85120);
        }
      }
      break;
      locala.cyy = true;
      n.eaj();
      continue;
      label235:
      break label111;
      label238:
      i = -1;
      label240:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a
 * JD-Core Version:    0.7.0.1
 */