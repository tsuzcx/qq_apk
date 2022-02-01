package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.g;
import java.io.File;
import org.xwalk.core.Log;

public final class b
  extends e
{
  public final int a(f paramf)
  {
    AppMethodBeat.i(157177);
    Log.i("FullScreenVideo", "performInstall version " + paramf.version);
    if (d.mi(paramf.path, paramf.md5))
    {
      adn(paramf.version);
      Log.i("FullScreenVideo", "performInstall " + this.IUH + " success");
      AppMethodBeat.o(157177);
      return 0;
    }
    Log.e("FullScreenVideo", "performInstall failed, md5 not match");
    paramf = new File(paramf.path);
    if (paramf.exists()) {
      paramf.delete();
    }
    g.de("FullScreenVideo", false);
    AppMethodBeat.o(157177);
    return -1;
  }
  
  public final String bd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157176);
    String str = ado(paramInt);
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
  
  public final boolean ftg()
  {
    return true;
  }
  
  public final void fth()
  {
    AppMethodBeat.i(157178);
    Log.i("FullScreenVideo", "checkVersionFiles, skip");
    AppMethodBeat.o(157178);
  }
  
  public final String getPluginName()
  {
    return "FullScreenVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.b
 * JD-Core Version:    0.7.0.1
 */