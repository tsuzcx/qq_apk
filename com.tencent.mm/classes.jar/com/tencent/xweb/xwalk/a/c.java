package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.g;
import com.tencent.xweb.xwalk.updater.SchedulerConfig;
import java.io.File;
import org.xwalk.core.Log;

public final class c
  extends f
{
  public final int a(SchedulerConfig paramSchedulerConfig)
  {
    AppMethodBeat.i(197118);
    Log.i("FullScreenVideo", "performInstall version " + paramSchedulerConfig.version);
    if (d.nh(paramSchedulerConfig.path, paramSchedulerConfig.Mys))
    {
      aiJ(paramSchedulerConfig.version);
      Log.i("FullScreenVideo", "performInstall " + this.MxJ + " success");
      AppMethodBeat.o(197118);
      return 0;
    }
    Log.e("FullScreenVideo", "performInstall failed, md5 not match");
    paramSchedulerConfig = new File(paramSchedulerConfig.path);
    if (paramSchedulerConfig.exists()) {
      paramSchedulerConfig.delete();
    }
    g.jdMethod_do("FullScreenVideo", false);
    AppMethodBeat.o(197118);
    return -1;
  }
  
  public final String bq(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157176);
    String str = aiK(paramInt);
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
  
  public final boolean gdi()
  {
    return true;
  }
  
  public final void gdj()
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
 * Qualified Name:     com.tencent.xweb.xwalk.a.c
 * JD-Core Version:    0.7.0.1
 */