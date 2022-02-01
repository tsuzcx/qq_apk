package org.extra.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements c.b
{
  public final void bvp(String paramString)
  {
    AppMethodBeat.i(236785);
    System.load(paramString);
    AppMethodBeat.o(236785);
  }
  
  public final String bvq(String paramString)
  {
    AppMethodBeat.i(236787);
    paramString = paramString.substring(3, paramString.length() - 3);
    AppMethodBeat.o(236787);
    return paramString;
  }
  
  public final String[] hPR()
  {
    AppMethodBeat.i(236788);
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0))
    {
      localObject = Build.SUPPORTED_ABIS;
      AppMethodBeat.o(236788);
      return localObject;
    }
    if (!f.isEmpty(Build.CPU_ABI2))
    {
      localObject = Build.CPU_ABI;
      String str = Build.CPU_ABI2;
      AppMethodBeat.o(236788);
      return new String[] { localObject, str };
    }
    Object localObject = Build.CPU_ABI;
    AppMethodBeat.o(236788);
    return new String[] { localObject };
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(236784);
    System.loadLibrary(paramString);
    AppMethodBeat.o(236784);
  }
  
  public final String mapLibraryName(String paramString)
  {
    AppMethodBeat.i(236786);
    if ((paramString.startsWith("lib")) && (paramString.endsWith(".so")))
    {
      AppMethodBeat.o(236786);
      return paramString;
    }
    paramString = System.mapLibraryName(paramString);
    AppMethodBeat.o(236786);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.extra.a.e
 * JD-Core Version:    0.7.0.1
 */