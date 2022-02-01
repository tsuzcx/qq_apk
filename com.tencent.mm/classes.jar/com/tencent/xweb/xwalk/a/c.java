package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.g;
import java.io.File;
import org.xwalk.core.Log;

public final class c
  extends f
{
  public final int a(com.tencent.xweb.xwalk.updater.c paramc)
  {
    AppMethodBeat.i(217436);
    Log.i("FullScreenVideo", "performInstall version " + paramc.version);
    if (d.nn(paramc.path, paramc.MVw))
    {
      ajt(paramc.version);
      Log.i("FullScreenVideo", "performInstall " + this.MUN + " success");
      AppMethodBeat.o(217436);
      return 0;
    }
    Log.e("FullScreenVideo", "performInstall failed, md5 not match");
    paramc = new File(paramc.path);
    if (paramc.exists()) {
      paramc.delete();
    }
    g.dr("FullScreenVideo", false);
    AppMethodBeat.o(217436);
    return -1;
  }
  
  public final String bz(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157176);
    String str = aju(paramInt);
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
  
  public final boolean ghK()
  {
    return true;
  }
  
  public final void ghL()
  {
    AppMethodBeat.i(157178);
    Log.i("FullScreenVideo", "checkVersionFiles, skip");
    AppMethodBeat.o(157178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.c
 * JD-Core Version:    0.7.0.1
 */