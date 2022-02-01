package com.tencent.mm.sdk;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.q;
import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
{
  public static Set fnB()
  {
    AppMethodBeat.i(32814);
    Object localObject;
    try
    {
      HashSet localHashSet = new HashSet();
      localObject = new BufferedReader(new q("/proc/" + Process.myPid() + "/maps"));
      ae.i("MicroMsg.NativeLibraries", "Dump NativeLibrares:");
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        if (str.endsWith(".so")) {
          localHashSet.add(str.substring(str.lastIndexOf(" ") + 1));
        }
      }
      localObject = localThrowable.iterator();
    }
    catch (Throwable localThrowable)
    {
      ae.printErrStackTrace("MicroMsg.NativeLibraries", localThrowable, "", new Object[0]);
      AppMethodBeat.o(32814);
      return null;
    }
    while (((Iterator)localObject).hasNext()) {
      ae.i("MicroMsg.NativeLibraries", String.valueOf((String)((Iterator)localObject).next()));
    }
    AppMethodBeat.o(32814);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b
 * JD-Core Version:    0.7.0.1
 */