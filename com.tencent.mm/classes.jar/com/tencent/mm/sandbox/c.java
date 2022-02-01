package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c HWv;
  private static Map<Integer, Boolean> HWw;
  
  static
  {
    AppMethodBeat.i(32577);
    HWv = null;
    HWw = new HashMap();
    AppMethodBeat.o(32577);
  }
  
  public static void n(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32575);
    ad.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    HWw.put(Integer.valueOf(paramInt), Boolean.TRUE);
    ad.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + HWw.size());
    AppMethodBeat.o(32575);
  }
  
  public static void o(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(32576);
    ad.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    HWw.remove(Integer.valueOf(paramInt));
    ad.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + HWw.size());
    if (HWw.size() == 0)
    {
      paramObject = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramObject.ahp(), "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramObject.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/sandbox/SandBoxCore", "unregLifeCycle", "(ILjava/lang/Object;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      ad.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      ad.fkv();
    }
    AppMethodBeat.o(32576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */