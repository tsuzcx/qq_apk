package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vt;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell;", "", "()V", "KEY_CONFIG_PATH", "", "KEY_REPORT_DATA_PATH", "KEY_TARGET_VIDEO_PATH", "TAG", "configVideoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getConfigVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setConfigVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "crop60sTick", "", "<set-?>", "", "enableSoftEncodeFallback", "getEnableSoftEncodeFallback", "()I", "exitAlbumTick", "firstFrameTick", "hevcEncodeOption", "getHevcEncodeOption", "isInVideoTest", "", "()Z", "listener", "com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1;", "longVideoRemuxFinishTick", "longVideoStartRemuxTick", "postUIShowTick", "pressEditFinishTick", "remuxFinishTick", "reportDataPath", "startPostTick", "startRemuxTick", "targetVideoPath", "useNormalRemux", "getUseNormalRemux", "setUseNormalRemux", "(I)V", "useTavkitRemux", "getUseTavkitRemux", "setUseTavkitRemux", "videoQualityScore", "", "createFinderDefaultConfig", "destroy", "", "exec", "intent", "Landroid/content/Intent;", "markExitAlbum", "markFirstFrameShow", "markPressEditFinish", "markRemuxFinish", "path", "qualityScore", "isLongVideo", "markShowCrop60s", "markShowPostUI", "markStartPost", "markStartRemux", "parseTestConfig", "config", "reportVideoResult", "reset", "setup", "plugin-vlog_release"})
public final class n
{
  private static long NlA;
  private static long NlB;
  private static long NlC;
  private static long NlD;
  private static long NlE;
  private static long NlF;
  private static long NlG;
  private static long NlH;
  private static long NlI;
  private static float NlJ;
  private static int NlK;
  private static int NlL;
  private static final a NlM;
  public static final n NlN;
  private static String Nlu;
  private static String Nlv;
  private static VideoTransPara Nlw;
  private static int Nlx;
  private static int Nly;
  private static long Nlz;
  
  static
  {
    AppMethodBeat.i(223809);
    NlN = new n();
    Nlu = "";
    Nlv = "";
    Nly = 1;
    NlM = new a();
    AppMethodBeat.o(223809);
  }
  
  public static void Ao(boolean paramBoolean)
  {
    AppMethodBeat.i(223770);
    Log.i("MicroMsg.FinderVideoShell", "markStartRemux, isLongVideo:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      NlI = Util.currentTicks();
      AppMethodBeat.o(223770);
      return;
    }
    NlH = Util.currentTicks();
    AppMethodBeat.o(223770);
  }
  
  public static void c(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(223786);
    p.k(paramString, "path");
    Log.i("MicroMsg.FinderVideoShell", "markRemuxFinish, qualityScore:" + paramFloat + ", path:" + paramString + ", isLongVideo:" + paramBoolean);
    if (paramBoolean) {
      NlG = Util.currentTicks();
    }
    for (;;)
    {
      String str2 = Nlu;
      String str1 = str2;
      if (paramBoolean) {
        str1 = str2 + "_long";
      }
      u.on(paramString, str1);
      NlJ = paramFloat;
      AppMethodBeat.o(223786);
      return;
      NlF = Util.currentTicks();
    }
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(223740);
    Log.i("MicroMsg.FinderVideoShell", "destroy");
    NlM.dead();
    AppMethodBeat.o(223740);
  }
  
  public static boolean gsU()
  {
    AppMethodBeat.i(223730);
    if ((WeChatEnvironment.hasDebugger()) && (Nlw != null))
    {
      if (((CharSequence)Nlu).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(223730);
        return true;
      }
    }
    AppMethodBeat.o(223730);
    return false;
  }
  
  public static VideoTransPara gsV()
  {
    return Nlw;
  }
  
  public static int gsW()
  {
    int i = 1;
    if (Nlx == 1) {
      i = 0;
    }
    return i;
  }
  
  public static int gsX()
  {
    return NlK;
  }
  
  public static int gsY()
  {
    return NlL;
  }
  
  public static void gsZ()
  {
    AppMethodBeat.i(223744);
    Log.i("MicroMsg.FinderVideoShell", "markExitAlbum");
    if (Nlz <= 0L) {
      Nlz = Util.currentTicks();
    }
    AppMethodBeat.o(223744);
  }
  
  public static void gta()
  {
    AppMethodBeat.i(223746);
    Log.i("MicroMsg.FinderVideoShell", "markShowCrop60s");
    if (NlA <= 0L) {
      NlA = Util.currentTicks();
    }
    AppMethodBeat.o(223746);
  }
  
  public static void gtb()
  {
    AppMethodBeat.i(223749);
    Log.i("MicroMsg.FinderVideoShell", "markFirstFrameShow");
    if (NlB <= 0L) {
      NlB = Util.currentTicks();
    }
    AppMethodBeat.o(223749);
  }
  
  public static void gtc()
  {
    AppMethodBeat.i(223752);
    Log.i("MicroMsg.FinderVideoShell", "markPressEditFinish");
    if (NlC <= 0L) {
      NlC = Util.currentTicks();
    }
    AppMethodBeat.o(223752);
  }
  
  public static void gtd()
  {
    AppMethodBeat.i(223756);
    Log.i("MicroMsg.FinderVideoShell", "markShowPostUI");
    if (NlD <= 0L) {
      NlD = Util.currentTicks();
    }
    AppMethodBeat.o(223756);
  }
  
  public static void gte()
  {
    AppMethodBeat.i(223761);
    Log.i("MicroMsg.FinderVideoShell", "markStartPost");
    if (NlE <= 0L) {
      NlE = Util.currentTicks();
    }
    AppMethodBeat.o(223761);
  }
  
  public static void gtf()
  {
    long l2 = 0L;
    AppMethodBeat.i(223803);
    if (!gsU())
    {
      reset();
      AppMethodBeat.o(223803);
      return;
    }
    Object localObject2 = new JSONObject();
    Object localObject1 = new JSONObject();
    long l1;
    int i;
    if (NlA > 0L)
    {
      l1 = NlA - Nlz;
      ((JSONObject)localObject1).put("stage_1", l1);
      ((JSONObject)localObject1).put("stage_2", NlB - Nlz);
      l1 = l2;
      if (NlD > 0L)
      {
        l1 = l2;
        if (NlC > 0L) {
          l1 = NlD - NlC;
        }
      }
      ((JSONObject)localObject1).put("stage_3", l1);
      ((JSONObject)localObject1).put("stage_4", NlF - NlH);
      ((JSONObject)localObject1).put("stage_5", NlG - NlI);
      ((JSONObject)localObject2).put("time_cost", localObject1);
      ((JSONObject)localObject2).put("quality_score", Float.valueOf(NlJ));
      Log.i("MicroMsg.FinderVideoShell", "reportVideoResult:" + localObject2 + ", path:" + Nlv);
      if (((CharSequence)Nlv).length() <= 0) {
        break label323;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = new File(Nlv).getParentFile();
        p.j(localObject1, "File(reportDataPath).parentFile");
        u.bBD(((File)localObject1).getAbsolutePath());
        localObject1 = Nlv;
        localObject2 = ((JSONObject)localObject2).toString();
        p.j(localObject2, "json.toString()");
        Charset localCharset = d.UTF_8;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(223803);
          throw ((Throwable)localObject1);
          l1 = 0L;
          break;
          label323:
          i = 0;
          continue;
        }
        localObject2 = ((String)localObject2).getBytes(localCharset);
        p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
        u.H((String)localObject1, (byte[])localObject2);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new Intent("wechat.shell.FINDER_VIDEO_TEST_FINISH");
      ((Intent)localObject1).putExtra("success", bool);
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject1);
      AppMethodBeat.o(223803);
      return;
    }
  }
  
  public static void reset()
  {
    AppMethodBeat.i(223806);
    Log.i("MicroMsg.FinderVideoShell", "reset");
    Nlz = 0L;
    NlA = 0L;
    NlB = 0L;
    NlC = 0L;
    NlD = 0L;
    NlE = 0L;
    NlF = 0L;
    AppMethodBeat.o(223806);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(223737);
    if (WeChatEnvironment.hasDebugger())
    {
      Log.i("MicroMsg.FinderVideoShell", "setup");
      NlM.alive();
    }
    AppMethodBeat.o(223737);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ShellExecEvent;", "callback", "", "event", "plugin-vlog_release"})
  public static final class a
    extends IListener<vt>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n
 * JD-Core Version:    0.7.0.1
 */