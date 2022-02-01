package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell;", "", "()V", "KEY_CONFIG_PATH", "", "KEY_REPORT_DATA_PATH", "KEY_TARGET_VIDEO_PATH", "TAG", "configVideoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getConfigVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setConfigVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "crop60sTick", "", "<set-?>", "", "enableSoftEncodeFallback", "getEnableSoftEncodeFallback", "()I", "exitAlbumTick", "firstFrameTick", "hevcEncodeOption", "getHevcEncodeOption", "isInVideoTest", "", "()Z", "listener", "com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1;", "postUIShowTick", "pressEditFinishTick", "remuxFinishTick", "reportDataPath", "startPostTick", "targetVideoPath", "useNormalRemux", "getUseNormalRemux", "setUseNormalRemux", "(I)V", "useTavkitRemux", "getUseTavkitRemux", "setUseTavkitRemux", "videoQualityScore", "", "createFinderDefaultConfig", "destroy", "", "exec", "intent", "Landroid/content/Intent;", "markExitAlbum", "markFirstFrameShow", "markPressEditFinish", "markRemuxFinish", "path", "qualityScore", "markShowCrop60s", "markShowPostUI", "markStartPost", "parseTestConfig", "config", "reportVideoResult", "reset", "setup", "plugin-vlog_release"})
public final class m
{
  private static String GxS;
  private static String GxT;
  private static VideoTransPara GxU;
  private static int GxV;
  private static int GxW;
  private static long GxX;
  private static long GxY;
  private static long GxZ;
  private static long Gya;
  private static long Gyb;
  private static long Gyc;
  private static long Gyd;
  private static float Gye;
  private static int Gyf;
  private static int Gyg;
  private static final a Gyh;
  public static final m Gyi;
  
  static
  {
    AppMethodBeat.i(190579);
    Gyi = new m();
    GxS = "";
    GxT = "";
    GxW = 1;
    Gyh = new a();
    AppMethodBeat.o(190579);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(190569);
    Log.i("MicroMsg.FinderVideoShell", "destroy");
    Gyh.dead();
    AppMethodBeat.o(190569);
  }
  
  public static boolean fAU()
  {
    AppMethodBeat.i(190567);
    if ((WeChatEnvironment.hasDebugger()) && (GxU != null))
    {
      if (((CharSequence)GxS).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(190567);
        return true;
      }
    }
    AppMethodBeat.o(190567);
    return false;
  }
  
  public static VideoTransPara fAV()
  {
    return GxU;
  }
  
  public static int fAW()
  {
    int i = 1;
    if (GxV == 1) {
      i = 0;
    }
    return i;
  }
  
  public static int fAX()
  {
    return Gyf;
  }
  
  public static int fAY()
  {
    return Gyg;
  }
  
  public static void fAZ()
  {
    AppMethodBeat.i(190570);
    Log.i("MicroMsg.FinderVideoShell", "markExitAlbum");
    if (GxX <= 0L) {
      GxX = Util.currentTicks();
    }
    AppMethodBeat.o(190570);
  }
  
  public static void fBa()
  {
    AppMethodBeat.i(190571);
    Log.i("MicroMsg.FinderVideoShell", "markShowCrop60s");
    if (GxY <= 0L) {
      GxY = Util.currentTicks();
    }
    AppMethodBeat.o(190571);
  }
  
  public static void fBb()
  {
    AppMethodBeat.i(190572);
    Log.i("MicroMsg.FinderVideoShell", "markFirstFrameShow");
    if (GxZ <= 0L) {
      GxZ = Util.currentTicks();
    }
    AppMethodBeat.o(190572);
  }
  
  public static void fBc()
  {
    AppMethodBeat.i(190573);
    Log.i("MicroMsg.FinderVideoShell", "markPressEditFinish");
    if (Gya <= 0L) {
      Gya = Util.currentTicks();
    }
    AppMethodBeat.o(190573);
  }
  
  public static void fBd()
  {
    AppMethodBeat.i(190574);
    Log.i("MicroMsg.FinderVideoShell", "markShowPostUI");
    if (Gyb <= 0L) {
      Gyb = Util.currentTicks();
    }
    AppMethodBeat.o(190574);
  }
  
  public static void fBe()
  {
    AppMethodBeat.i(190575);
    Log.i("MicroMsg.FinderVideoShell", "markStartPost");
    if (Gyc <= 0L) {
      Gyc = Util.currentTicks();
    }
    AppMethodBeat.o(190575);
  }
  
  public static void fBf()
  {
    long l2 = 0L;
    AppMethodBeat.i(190577);
    if (!fAU())
    {
      reset();
      AppMethodBeat.o(190577);
      return;
    }
    Object localObject2 = new JSONObject();
    Object localObject1 = new JSONObject();
    long l1;
    int i;
    if (GxY > 0L)
    {
      l1 = GxY - GxX;
      ((JSONObject)localObject1).put("stage_1", l1);
      ((JSONObject)localObject1).put("stage_2", GxZ - GxX);
      l1 = l2;
      if (Gyb > 0L)
      {
        l1 = l2;
        if (Gya > 0L) {
          l1 = Gyb - Gya;
        }
      }
      ((JSONObject)localObject1).put("stage_3", l1);
      ((JSONObject)localObject1).put("stage_4", Gyd - Gyc);
      ((JSONObject)localObject2).put("time_cost", localObject1);
      ((JSONObject)localObject2).put("quality_score", Float.valueOf(Gye));
      Log.i("MicroMsg.FinderVideoShell", "reportVideoResult:" + localObject2 + ", path:" + GxT);
      if (((CharSequence)GxT).length() <= 0) {
        break label307;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new File(GxT).getParentFile();
        p.g(localObject1, "File(reportDataPath).parentFile");
        s.boN(((File)localObject1).getAbsolutePath());
        localObject1 = GxT;
        localObject2 = ((JSONObject)localObject2).toString();
        p.g(localObject2, "json.toString()");
        Charset localCharset = d.UTF_8;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(190577);
          throw ((Throwable)localObject1);
          l1 = 0L;
          break;
          label307:
          i = 0;
          continue;
        }
        localObject2 = ((String)localObject2).getBytes(localCharset);
        p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        s.C((String)localObject1, (byte[])localObject2);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new Intent("wechat.shell.FINDER_VIDEO_TEST_FINISH");
      ((Intent)localObject1).putExtra("success", bool);
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject1);
      AppMethodBeat.o(190577);
      return;
    }
  }
  
  public static void l(String paramString, float paramFloat)
  {
    AppMethodBeat.i(190576);
    p.h(paramString, "path");
    Log.i("MicroMsg.FinderVideoShell", "markRemuxFinish, qualityScore:" + paramFloat + ", path:" + paramString);
    Gyd = Util.currentTicks();
    s.nw(paramString, GxS);
    Gye = paramFloat;
    AppMethodBeat.o(190576);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(190578);
    Log.i("MicroMsg.FinderVideoShell", "reset");
    GxX = 0L;
    GxY = 0L;
    GxZ = 0L;
    Gya = 0L;
    Gyb = 0L;
    Gyc = 0L;
    Gyd = 0L;
    AppMethodBeat.o(190578);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(190568);
    if (WeChatEnvironment.hasDebugger())
    {
      Log.i("MicroMsg.FinderVideoShell", "setup");
      Gyh.alive();
    }
    AppMethodBeat.o(190568);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-vlog_release"})
  public static final class a
    extends IListener<uq>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.m
 * JD-Core Version:    0.7.0.1
 */