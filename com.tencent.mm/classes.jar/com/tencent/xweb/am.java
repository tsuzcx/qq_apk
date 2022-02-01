package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public final class am
{
  private static p aifZ;
  private static final List<Object> eTv;
  
  static
  {
    AppMethodBeat.i(212462);
    eTv = new ArrayList();
    AppMethodBeat.o(212462);
  }
  
  public static void a(p paramp)
  {
    AppMethodBeat.i(212438);
    Log.i("XWebPreferences", "setWebPreferences:".concat(String.valueOf(paramp)));
    aifZ = paramp;
    if (!eTv.isEmpty())
    {
      paramp = eTv.iterator();
      while (paramp.hasNext()) {
        paramp.next();
      }
    }
    AppMethodBeat.o(212438);
  }
  
  public static boolean getBooleanValue(String paramString)
  {
    AppMethodBeat.i(212455);
    if (aifZ != null)
    {
      boolean bool = aifZ.getBooleanValue(paramString);
      AppMethodBeat.o(212455);
      return bool;
    }
    Log.w("XWebPreferences", "getBooleanValue, web preferences not set, key:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(212455);
    return false;
  }
  
  public static void setValue(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212447);
    if (aifZ != null)
    {
      aifZ.setValue(paramString1, paramString2);
      AppMethodBeat.o(212447);
      return;
    }
    Log.w("XWebPreferences", "setValue, web preferences not set, key:".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(212447);
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212442);
    if (aifZ != null)
    {
      aifZ.setValue(paramString, paramBoolean);
      AppMethodBeat.o(212442);
      return;
    }
    Log.w("XWebPreferences", "setValue, web preferences not set, key:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(212442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.am
 * JD-Core Version:    0.7.0.1
 */