package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class z
{
  private static String TAG = "MicroMsg.VideoUploadConfig";
  
  public static boolean bdv(String paramString)
  {
    AppMethodBeat.i(240892);
    long l = s.boW(paramString);
    boolean bool = ((b)g.af(b.class)).a(b.a.rPI, true);
    Log.i(TAG, "C2C send big file:%s size:%s enable:%s", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool) });
    if ((l >= 25165824L) && (bool))
    {
      AppMethodBeat.o(240892);
      return true;
    }
    AppMethodBeat.o(240892);
    return false;
  }
  
  public static boolean bdw(String paramString)
  {
    AppMethodBeat.i(240894);
    long l = s.boW(paramString);
    boolean bool = ((b)g.af(b.class)).a(b.a.rPH, true);
    Log.i(TAG, "SNS send big file:%s size:%s enable:%s", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool) });
    if ((l >= 25165824L) && (bool))
    {
      AppMethodBeat.o(240894);
      return true;
    }
    AppMethodBeat.o(240894);
    return false;
  }
  
  public static int gmL()
  {
    AppMethodBeat.i(240893);
    boolean bool = ((b)g.af(b.class)).a(b.a.rPI, true);
    int i = ((b)g.af(b.class)).a(b.a.rPJ, 100);
    Log.i(TAG, "getBigVideoSize  enable:%s configMB:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if (bool)
    {
      AppMethodBeat.o(240893);
      return i * 1024 * 1024;
    }
    AppMethodBeat.o(240893);
    return 26214400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.z
 * JD-Core Version:    0.7.0.1
 */