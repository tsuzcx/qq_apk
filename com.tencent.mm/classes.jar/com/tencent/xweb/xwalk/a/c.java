package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import java.io.File;
import org.xwalk.core.Log;

public final class c
  extends g
{
  public final int a(com.tencent.xweb.xwalk.updater.c paramc)
  {
    AppMethodBeat.i(219102);
    Log.i("FullScreenVideo", "performInstall version " + paramc.version);
    if (d.oi(paramc.path, paramc.SID))
    {
      atc(paramc.version);
      Log.i("FullScreenVideo", "performInstall " + this.SHU + " success");
      AppMethodBeat.o(219102);
      return 0;
    }
    Log.e("FullScreenVideo", "performInstall failed, md5 not match");
    paramc = new File(paramc.path);
    if (paramc.exists()) {
      paramc.delete();
    }
    h.dM("FullScreenVideo", false);
    AppMethodBeat.o(219102);
    return -1;
  }
  
  public final String ca(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157176);
    String str = atd(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(157176);
      return "";
    }
    if (!paramBoolean)
    {
      str = str + File.separator + "xweb_fullscreen_video.js";
      AppMethodBeat.o(157176);
      return str;
    }
    str = str + File.separator + "patch";
    AppMethodBeat.o(157176);
    return str;
  }
  
  public final String getPluginName()
  {
    return "FullScreenVideo";
  }
  
  public final boolean hvi()
  {
    return true;
  }
  
  public final void hvj()
  {
    AppMethodBeat.i(157178);
    Log.i("FullScreenVideo", "checkVersionFiles, skip");
    AppMethodBeat.o(157178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.c
 * JD-Core Version:    0.7.0.1
 */