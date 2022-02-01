package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c IqD;
  private static Map<Integer, Boolean> IqE;
  
  static
  {
    AppMethodBeat.i(32577);
    IqD = null;
    IqE = new HashMap();
    AppMethodBeat.o(32577);
  }
  
  public static void n(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32575);
    ae.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    IqE.put(Integer.valueOf(paramInt), Boolean.TRUE);
    ae.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + IqE.size());
    AppMethodBeat.o(32575);
  }
  
  public static void o(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32576);
    ae.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    IqE.remove(Integer.valueOf(paramInt));
    ae.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + IqE.size());
    if (IqE.size() == 0)
    {
      paramObject = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramObject.ahE(), "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramObject.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      ae.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      ae.fop();
    }
    AppMethodBeat.o(32576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */