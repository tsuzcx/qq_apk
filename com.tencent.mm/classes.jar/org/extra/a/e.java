package org.extra.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements c.b
{
  public final void bdV(String paramString)
  {
    AppMethodBeat.i(220066);
    System.load(paramString);
    AppMethodBeat.o(220066);
  }
  
  public final String bdW(String paramString)
  {
    AppMethodBeat.i(220068);
    paramString = paramString.substring(3, paramString.length() - 3);
    AppMethodBeat.o(220068);
    return paramString;
  }
  
  public final String[] gyl()
  {
    AppMethodBeat.i(220069);
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0))
    {
      localObject = Build.SUPPORTED_ABIS;
      AppMethodBeat.o(220069);
      return localObject;
    }
    if (!f.isEmpty(Build.CPU_ABI2))
    {
      localObject = Build.CPU_ABI;
      String str = Build.CPU_ABI2;
      AppMethodBeat.o(220069);
      return new String[] { localObject, str };
    }
    Object localObject = Build.CPU_ABI;
    AppMethodBeat.o(220069);
    return new String[] { localObject };
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(220065);
    System.loadLibrary(paramString);
    AppMethodBeat.o(220065);
  }
  
  public final String mapLibraryName(String paramString)
  {
    AppMethodBeat.i(220067);
    if ((paramString.startsWith("lib")) && (paramString.endsWith(".so")))
    {
      AppMethodBeat.o(220067);
      return paramString;
    }
    paramString = System.mapLibraryName(paramString);
    AppMethodBeat.o(220067);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.e
 * JD-Core Version:    0.7.0.1
 */