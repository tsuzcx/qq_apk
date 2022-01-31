package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.f;
import java.io.File;
import org.xwalk.core.Log;

public final class a
  extends c
{
  public final int a(d paramd)
  {
    AppMethodBeat.i(4177);
    Log.i("FullScreenVideoPlugin", "performInstall");
    if (com.tencent.xweb.util.d.gP(paramd.path, paramd.cqq))
    {
      TI(paramd.version);
      Log.i("FullScreenVideoPlugin", "performInstall success");
      AppMethodBeat.o(4177);
      return 0;
    }
    Log.e("FullScreenVideoPlugin", "performInstall failed, md5 not match");
    paramd = new File(paramd.path);
    if (paramd.exists()) {
      paramd.delete();
    }
    f.dZI();
    AppMethodBeat.o(4177);
    return -1;
  }
  
  public final String aP(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4176);
    String str = TJ(paramInt);
    if ((str == null) || (str.isEmpty()))
    {
      AppMethodBeat.o(4176);
      return "";
    }
    if (!paramBoolean)
    {
      str = str + File.separator + "xweb_fullscreen_video.js";
      AppMethodBeat.o(4176);
      return str;
    }
    str = str + File.separator + "patch";
    AppMethodBeat.o(4176);
    return str;
  }
  
  public final String eak()
  {
    return "FullScreenVideo";
  }
  
  public final boolean eal()
  {
    return true;
  }
  
  public final void eam()
  {
    AppMethodBeat.i(151452);
    Log.i("FullScreenVideoPlugin", "checkVersionFiles, skip");
    AppMethodBeat.o(151452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.a
 * JD-Core Version:    0.7.0.1
 */