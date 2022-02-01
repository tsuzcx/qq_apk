package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class z
{
  public static long qr(String paramString1, String paramString2)
  {
    boolean bool = true;
    AppMethodBeat.i(238291);
    int i;
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED))
    {
      i = 1;
      if (i == 0) {
        break label71;
      }
    }
    for (;;)
    {
      long l = y.O(paramString1, paramString2, bool);
      AppMethodBeat.o(238291);
      return l;
      if (!"0".equals(d.dNI().a("clicfg_enable_refcount_linking", "0", false, true)))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label71:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.z
 * JD-Core Version:    0.7.0.1
 */