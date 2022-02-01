package org.extra.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements c.b
{
  public final void bIu(String paramString)
  {
    AppMethodBeat.i(194668);
    System.load(paramString);
    AppMethodBeat.o(194668);
  }
  
  public final String bIv(String paramString)
  {
    AppMethodBeat.i(194670);
    if ((paramString.startsWith("lib")) && (paramString.endsWith(".so")))
    {
      AppMethodBeat.o(194670);
      return paramString;
    }
    paramString = System.mapLibraryName(paramString);
    AppMethodBeat.o(194670);
    return paramString;
  }
  
  public final String bIw(String paramString)
  {
    AppMethodBeat.i(194673);
    paramString = paramString.substring(3, paramString.length() - 3);
    AppMethodBeat.o(194673);
    return paramString;
  }
  
  public final String[] iVa()
  {
    AppMethodBeat.i(194677);
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0))
    {
      localObject = Build.SUPPORTED_ABIS;
      AppMethodBeat.o(194677);
      return localObject;
    }
    if (!f.bk(Build.CPU_ABI2))
    {
      localObject = Build.CPU_ABI;
      String str = Build.CPU_ABI2;
      AppMethodBeat.o(194677);
      return new String[] { localObject, str };
    }
    Object localObject = Build.CPU_ABI;
    AppMethodBeat.o(194677);
    return new String[] { localObject };
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(194665);
    System.loadLibrary(paramString);
    AppMethodBeat.o(194665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.extra.a.e
 * JD-Core Version:    0.7.0.1
 */