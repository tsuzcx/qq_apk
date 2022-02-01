package com.tencent.mm.plugin.sns.cover.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expansions.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/cover/config/SnsCoverConfig;", "", "()V", "COVER_SIZE", "", "DURATION", "TAG", "", "checkErrorType", "", "enableCoverPostReport", "enableCoverPreviewReport", "getCoverImageParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getCoverVideoParam", "needCheckFinderValid", "lastCheckTimeMs", "", "useNewVersion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QkS;
  
  static
  {
    AppMethodBeat.i(307343);
    QkS = new a();
    AppMethodBeat.o(307343);
  }
  
  public static boolean hes()
  {
    AppMethodBeat.i(307314);
    b localb = b.yFu;
    if (!b.isInstalled("xlab"))
    {
      Log.w("MicroMsg.SnsCoverConfig", "Expansions not yet installed, do not use new version");
      AppMethodBeat.o(307314);
      return false;
    }
    switch (h.baE().ban().getInt(at.a.adgF, 0))
    {
    default: 
      boolean bool = ((c)h.ax(c.class)).a(c.a.yWj, false);
      AppMethodBeat.o(307314);
      return bool;
    case 2: 
      AppMethodBeat.o(307314);
      return false;
    }
    AppMethodBeat.o(307314);
    return true;
  }
  
  public static boolean het()
  {
    AppMethodBeat.i(307319);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yWp, true);
    AppMethodBeat.o(307319);
    return bool;
  }
  
  public static VideoTransPara heu()
  {
    AppMethodBeat.i(307327);
    VideoTransPara localVideoTransPara = new VideoTransPara();
    localVideoTransPara.width = 960;
    localVideoTransPara.height = 960;
    try
    {
      Object localObject = ((c)h.ax(c.class)).a(c.a.yWn, "");
      Log.i("MicroMsg.SnsCoverConfig", s.X("getCoverImageParam:", localObject));
      localObject = new JSONObject((String)localObject);
      if ((((JSONObject)localObject).optInt("width", 0) > 0) && (((JSONObject)localObject).optInt("height", 0) > 0))
      {
        localVideoTransPara.width = ((JSONObject)localObject).optInt("width", 0);
        localVideoTransPara.height = ((JSONObject)localObject).optInt("height", 0);
        AppMethodBeat.o(307327);
        return localVideoTransPara;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SnsCoverConfig", "getCoverImageParam get config error");
      AppMethodBeat.o(307327);
    }
    return localVideoTransPara;
  }
  
  public static VideoTransPara hev()
  {
    AppMethodBeat.i(307332);
    VideoTransPara localVideoTransPara = e.bIg().bIl();
    localVideoTransPara.oCa = 960;
    localVideoTransPara.duration = 30;
    try
    {
      Object localObject = ((c)h.ax(c.class)).a(c.a.yWo, "");
      Log.i("MicroMsg.SnsCoverConfig", s.X("getCoverVideoParam:", localObject));
      localObject = new JSONObject((String)localObject);
      if ((((JSONObject)localObject).optInt("width", 0) > 0) && (((JSONObject)localObject).optInt("height", 0) > 0))
      {
        localVideoTransPara.width = ((JSONObject)localObject).optInt("width", 720);
        localVideoTransPara.height = ((JSONObject)localObject).optInt("height", 1280);
        if (((JSONObject)localObject).optInt("thumbSize", 0) > 0) {
          localVideoTransPara.oCa = ((JSONObject)localObject).optInt("thumbSize", 960);
        }
        if (((JSONObject)localObject).optInt("duration", 0) > 0) {
          localVideoTransPara.duration = ((JSONObject)localObject).optInt("duration", 30);
        }
        s.s(localVideoTransPara, "para");
        AppMethodBeat.o(307332);
        return localVideoTransPara;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SnsCoverConfig", "getCoverImageParam get config error");
      s.s(localVideoTransPara, "para");
      AppMethodBeat.o(307332);
    }
    return localVideoTransPara;
  }
  
  public static boolean hew()
  {
    AppMethodBeat.i(307335);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yWk, true);
    Log.i("MicroMsg.SnsCoverConfig", s.X("enableUserPageReport:", Boolean.valueOf(bool)));
    AppMethodBeat.o(307335);
    return bool;
  }
  
  public static boolean uz(long paramLong)
  {
    AppMethodBeat.i(307316);
    if (h.baE().ban().getInt(at.a.adgG, -1) == 1)
    {
      AppMethodBeat.o(307316);
      return true;
    }
    int i = ((c)h.ax(c.class)).a(c.a.yWm, 3600);
    if (System.currentTimeMillis() - paramLong > i * 1000)
    {
      AppMethodBeat.o(307316);
      return true;
    }
    AppMethodBeat.o(307316);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.cover.b.a
 * JD-Core Version:    0.7.0.1
 */