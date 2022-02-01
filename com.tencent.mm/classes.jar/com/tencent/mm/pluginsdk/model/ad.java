package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;

public final class ad
{
  private static String TAG = "MicroMsg.VideoUploadConfig";
  
  public static boolean bpP(String paramString)
  {
    AppMethodBeat.i(215967);
    long l = u.bBQ(paramString);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vvT, true);
    Log.i(TAG, "C2C send big file:%s size:%s enable:%s", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool) });
    if ((l >= 25165824L) && (bool))
    {
      AppMethodBeat.o(215967);
      return true;
    }
    AppMethodBeat.o(215967);
    return false;
  }
  
  public static boolean bpQ(String paramString)
  {
    AppMethodBeat.i(215969);
    long l = u.bBQ(paramString);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vvS, true);
    Log.i(TAG, "SNS send big file:%s size:%s enable:%s", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool) });
    if ((l >= 25165824L) && (bool))
    {
      AppMethodBeat.o(215969);
      return true;
    }
    AppMethodBeat.o(215969);
    return false;
  }
  
  public static int hhm()
  {
    AppMethodBeat.i(215968);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vvT, true);
    int i = ((b)h.ae(b.class)).a(b.a.vvU, 100);
    Log.i(TAG, "getBigVideoSize  enable:%s configMB:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if (bool)
    {
      AppMethodBeat.o(215968);
      return i * 1024 * 1024;
    }
    AppMethodBeat.o(215968);
    return 26214400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.ad
 * JD-Core Version:    0.7.0.1
 */