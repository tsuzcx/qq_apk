package org.extra.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e
  implements c.b
{
  public final void bLp(String paramString)
  {
    AppMethodBeat.i(187296);
    System.load(paramString);
    AppMethodBeat.o(187296);
  }
  
  public final String bLq(String paramString)
  {
    AppMethodBeat.i(187305);
    if ((paramString.startsWith("lib")) && (paramString.endsWith(".so")))
    {
      AppMethodBeat.o(187305);
      return paramString;
    }
    paramString = System.mapLibraryName(paramString);
    AppMethodBeat.o(187305);
    return paramString;
  }
  
  public final String bLr(String paramString)
  {
    AppMethodBeat.i(187315);
    paramString = paramString.substring(3, paramString.length() - 3);
    AppMethodBeat.o(187315);
    return paramString;
  }
  
  public final String[] kJy()
  {
    AppMethodBeat.i(187324);
    if ((Build.VERSION.SDK_INT >= 21) && (Build.SUPPORTED_ABIS.length > 0))
    {
      localObject = Build.SUPPORTED_ABIS;
      AppMethodBeat.o(187324);
      return localObject;
    }
    if (!f.bB(Build.CPU_ABI2))
    {
      localObject = Build.CPU_ABI;
      String str = Build.CPU_ABI2;
      AppMethodBeat.o(187324);
      return new String[] { localObject, str };
    }
    Object localObject = Build.CPU_ABI;
    AppMethodBeat.o(187324);
    return new String[] { localObject };
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(187288);
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "org/extra/relinker/SystemLibraryLoader", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "org/extra/relinker/SystemLibraryLoader", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(187288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.extra.a.e
 * JD-Core Version:    0.7.0.1
 */