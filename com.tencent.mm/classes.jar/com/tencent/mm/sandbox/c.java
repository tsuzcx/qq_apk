package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c ubF = null;
  private static Map<Integer, Boolean> ubG = new HashMap();
  
  public static void j(int paramInt, Object paramObject)
  {
    y.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    ubG.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    y.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + ubG.size());
  }
  
  public static void k(int paramInt, Object paramObject)
  {
    y.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + paramInt + ", class=%s", new Object[] { paramObject.getClass().getName() });
    ubG.remove(Integer.valueOf(paramInt));
    y.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + ubG.size());
    if (ubG.size() == 0)
    {
      Process.killProcess(Process.myPid());
      y.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
      y.cqM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.c
 * JD-Core Version:    0.7.0.1
 */