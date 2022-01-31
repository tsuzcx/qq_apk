package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c yjU;
  private static Map<Integer, Boolean> yjV;
  
  static
  {
    AppMethodBeat.i(28778);
    yjU = null;
    yjV = new HashMap();
    AppMethodBeat.o(28778);
  }
  
  public static void m(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(28776);
    ab.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    yjV.put(Integer.valueOf(paramInt), Boolean.TRUE);
    ab.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + yjV.size());
    AppMethodBeat.o(28776);
  }
  
  public static void n(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(28777);
    ab.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    yjV.remove(Integer.valueOf(paramInt));
    ab.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + yjV.size());
    if (yjV.size() == 0)
    {
      Process.killProcess(Process.myPid());
      ab.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      ab.dsJ();
    }
    AppMethodBeat.o(28777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */