package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c URx;
  private static Map<Integer, Boolean> URy;
  
  static
  {
    AppMethodBeat.i(32577);
    URx = null;
    URy = new HashMap();
    AppMethodBeat.o(32577);
  }
  
  public static void u(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32575);
    Log.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    URy.put(Integer.valueOf(paramInt), Boolean.TRUE);
    Log.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + URy.size());
    AppMethodBeat.o(32575);
  }
  
  public static void v(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32576);
    Log.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    URy.remove(Integer.valueOf(paramInt));
    Log.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + URy.size());
    if (URy.size() == 0)
    {
      paramObject = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramObject.aFh(), "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramObject.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Log.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      Log.appenderFlushSync();
    }
    AppMethodBeat.o(32576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */