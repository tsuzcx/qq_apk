package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c ENv;
  private static Map<Integer, Boolean> ENw;
  
  static
  {
    AppMethodBeat.i(32577);
    ENv = null;
    ENw = new HashMap();
    AppMethodBeat.o(32577);
  }
  
  public static void o(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32575);
    ad.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    ENw.put(Integer.valueOf(paramInt), Boolean.TRUE);
    ad.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + ENw.size());
    AppMethodBeat.o(32575);
  }
  
  public static void p(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32576);
    ad.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    ENw.remove(Integer.valueOf(paramInt));
    ad.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + ENw.size());
    if (ENw.size() == 0)
    {
      Process.killProcess(Process.myPid());
      ad.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      ad.eFx();
    }
    AppMethodBeat.o(32576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */