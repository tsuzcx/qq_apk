package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;
import com.tencent.xweb.util.l;
import com.tencent.xweb.xwalk.updater.d;
import java.io.File;
import org.xwalk.core.Log;

public final class c
  extends g
{
  public final int a(d paramd)
  {
    AppMethodBeat.i(213101);
    Log.i("FullScreenVideo", "performInstall version " + paramd.version);
    if (h.rb(paramd.path, paramd.aiiJ))
    {
      aJM(paramd.version);
      Log.i("FullScreenVideo", "performInstall " + this.aipK + " success");
      AppMethodBeat.o(213101);
      return 0;
    }
    Log.e("FullScreenVideo", "performInstall failed, md5 not match");
    paramd = new File(paramd.path);
    if (paramd.exists()) {
      paramd.delete();
    }
    l.eN("FullScreenVideo", false);
    AppMethodBeat.o(213101);
    return -1;
  }
  
  public final String dg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157176);
    String str = getVersionDir(paramInt);
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
  
  public final String kjs()
  {
    return "FullScreenVideo";
  }
  
  public final boolean kjt()
  {
    return true;
  }
  
  public final boolean kjw()
  {
    return true;
  }
  
  public final void kjx()
  {
    AppMethodBeat.i(157178);
    Log.i("FullScreenVideo", "checkFiles, skip");
    AppMethodBeat.o(157178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.c
 * JD-Core Version:    0.7.0.1
 */