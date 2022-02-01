package com.tencent.tbs.one.impl.c.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.optional.TBSOneStandaloneService;
import java.io.File;
import java.io.IOException;

public final class c
{
  public static Boolean a;
  
  public static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(173817);
    String str = new File(paramString2).getName();
    if (!TextUtils.isEmpty(str))
    {
      int i = str.lastIndexOf('.');
      if (i > 0)
      {
        paramString2 = new String[2];
        paramString2[0] = str.substring(0, i);
        paramString2[1] = str.substring(i + 1);
      }
    }
    for (;;)
    {
      paramString1 = new File(paramString1, paramString2[0] + ".dex");
      if (paramString1.exists()) {
        break;
      }
      f.a("The odex file %s does not exist", new Object[] { paramString1.getAbsolutePath() });
      AppMethodBeat.o(173817);
      return true;
      paramString2 = new String[2];
      paramString2[0] = str;
      paramString2[1] = null;
    }
    if (d.a(paramString1)) {
      try
      {
        new d(paramString1);
        f.a("The odex file %s is well-kept", new Object[] { paramString1.getAbsolutePath() });
        AppMethodBeat.o(173817);
        return true;
      }
      catch (IOException paramString2)
      {
        f.a("The odex file %s has broken", new Object[] { paramString1.getAbsolutePath() });
        AppMethodBeat.o(173817);
        return false;
      }
    }
    f.a("The odex file %s is not a elf file", new Object[] { paramString1.getAbsolutePath() });
    AppMethodBeat.o(173817);
    return true;
  }
  
  public static File b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(173818);
    paramString1 = new File(paramString1, paramString2 + ".opt");
    AppMethodBeat.o(173818);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.c
 * JD-Core Version:    0.7.0.1
 */