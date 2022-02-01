package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c NEa;
  private static Map<Integer, Boolean> NEb;
  
  static
  {
    AppMethodBeat.i(32577);
    NEa = null;
    NEb = new HashMap();
    AppMethodBeat.o(32577);
  }
  
  public static void q(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32575);
    Log.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    NEb.put(Integer.valueOf(paramInt), Boolean.TRUE);
    Log.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + NEb.size());
    AppMethodBeat.o(32575);
  }
  
  public static void r(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32576);
    Log.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    NEb.remove(Integer.valueOf(paramInt));
    Log.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + NEb.size());
    if (NEb.size() == 0)
    {
      paramObject = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramObject.axQ(), "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramObject.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
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