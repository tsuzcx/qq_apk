package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;
import java.io.File;
import org.xwalk.core.Log;

public final class c
  extends g
{
  public final int a(com.tencent.xweb.xwalk.b.d paramd)
  {
    AppMethodBeat.i(195806);
    Log.i("FullScreenVideo", "performInstall version " + paramd.version);
    if (com.tencent.xweb.util.d.pe(paramd.path, paramd.aakv))
    {
      aCY(paramd.version);
      Log.i("FullScreenVideo", "performInstall " + this.aajM + " success");
      AppMethodBeat.o(195806);
      return 0;
    }
    Log.e("FullScreenVideo", "performInstall failed, md5 not match");
    paramd = new File(paramd.path);
    if (paramd.exists()) {
      paramd.delete();
    }
    h.dY("FullScreenVideo", false);
    AppMethodBeat.o(195806);
    return -1;
  }
  
  public final String cm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157176);
    String str = aCZ(paramInt);
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
  
  public final boolean izb()
  {
    return true;
  }
  
  public final void izc()
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