package com.tencent.mm.sdk;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class c
{
  public static Set dsb()
  {
    AppMethodBeat.i(153759);
    Object localObject;
    try
    {
      HashSet localHashSet = new HashSet();
      localObject = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
      ab.i("MicroMsg.NativeLibraries", "Dump NativeLibrares:");
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
      ab.printErrStackTrace("MicroMsg.NativeLibraries", localThrowable, "", new Object[0]);
      AppMethodBeat.o(153759);
      return null;
    }
    while (((Iterator)localObject).hasNext()) {
      ab.i("MicroMsg.NativeLibraries", String.valueOf((String)((Iterator)localObject).next()));
    }
    AppMethodBeat.o(153759);
    return localThrowable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.c
 * JD-Core Version:    0.7.0.1
 */