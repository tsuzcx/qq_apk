package com.tencent.mm.plugin.report.service;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  public static Set<Integer> OzJ;
  private static boolean hasInit;
  
  static
  {
    AppMethodBeat.i(261702);
    OzJ = new HashSet();
    hasInit = false;
    AppMethodBeat.o(261702);
  }
  
  public static boolean aht(int paramInt)
  {
    AppMethodBeat.i(261700);
    synchronized (OzJ)
    {
      if (!hasInit)
      {
        Object localObject1 = MMApplicationContext.getContext().getResources().openRawResource(e.a.invalid_idkey);
        try
        {
          localObject1 = new BufferedReader(new InputStreamReader((InputStream)localObject1));
          for (;;)
          {
            String str = ((BufferedReader)localObject1).readLine();
            if (str == null) {
              break;
            }
            int i = Integer.parseInt(str);
            OzJ.add(Integer.valueOf(i));
          }
        }
        catch (IOException localIOException)
        {
          Log.e("IDKeyInvalidList", "invalid value in R file");
          hasInit = true;
        }
      }
      if (OzJ.contains(Integer.valueOf(paramInt)))
      {
        AppMethodBeat.o(261700);
        return true;
      }
    }
    AppMethodBeat.o(261700);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.c
 * JD-Core Version:    0.7.0.1
 */