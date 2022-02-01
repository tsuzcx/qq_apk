package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c GkJ;
  private static Map<Integer, Boolean> GkK;
  
  static
  {
    AppMethodBeat.i(32577);
    GkJ = null;
    GkK = new HashMap();
    AppMethodBeat.o(32577);
  }
  
  public static void o(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32575);
    ac.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    GkK.put(Integer.valueOf(paramInt), Boolean.TRUE);
    ac.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + GkK.size());
    AppMethodBeat.o(32575);
  }
  
  public static void p(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32576);
    ac.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    GkK.remove(Integer.valueOf(paramInt));
    ac.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + GkK.size());
    if (GkK.size() == 0)
    {
      Process.killProcess(Process.myPid());
      ac.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      ac.eUR();
    }
    AppMethodBeat.o(32576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */