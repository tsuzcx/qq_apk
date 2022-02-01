package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

public final class af
{
  private static String TAG = "MicroMsg.VideoUploadConfig";
  
  public static boolean bpG(String paramString)
  {
    AppMethodBeat.i(244763);
    long l = y.bEl(paramString);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yIU, true);
    Log.i(TAG, "C2C send big file:%s size:%s enable:%s", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool) });
    if ((l >= 25165824L) && (bool))
    {
      AppMethodBeat.o(244763);
      return true;
    }
    AppMethodBeat.o(244763);
    return false;
  }
  
  public static boolean bpH(String paramString)
  {
    AppMethodBeat.i(244773);
    long l = y.bEl(paramString);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yIT, true);
    Log.i(TAG, "SNS send big file:%s size:%s enable:%s", new Object[] { paramString, Long.valueOf(l), Boolean.valueOf(bool) });
    if ((l >= 25165824L) && (bool))
    {
      AppMethodBeat.o(244773);
      return true;
    }
    AppMethodBeat.o(244773);
    return false;
  }
  
  public static int iIm()
  {
    AppMethodBeat.i(244770);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yIU, true);
    int i = ((c)h.ax(c.class)).a(c.a.yIV, 100);
    Log.i(TAG, "getBigVideoSize  enable:%s configMB:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
    if (bool)
    {
      AppMethodBeat.o(244770);
      return i * 1024 * 1024;
    }
    AppMethodBeat.o(244770);
    return 26214400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.af
 * JD-Core Version:    0.7.0.1
 */