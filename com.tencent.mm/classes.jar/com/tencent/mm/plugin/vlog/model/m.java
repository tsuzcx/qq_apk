package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
import java.io.File;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell;", "", "()V", "KEY_CONFIG_PATH", "", "KEY_REPORT_DATA_PATH", "KEY_TARGET_VIDEO_PATH", "TAG", "cdnUploadTime", "", "configVideoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getConfigVideoParam", "()Lcom/tencent/mm/modelcontrol/VideoTransPara;", "setConfigVideoParam", "(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V", "crop60sTick", "<set-?>", "", "enableSoftEncodeFallback", "getEnableSoftEncodeFallback", "()I", "exitAlbumTick", "firstFrameTick", "hevcEncodeOption", "getHevcEncodeOption", "isInVideoTest", "", "()Z", "listener", "com/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1", "Lcom/tencent/mm/plugin/vlog/model/FinderVideoShell$listener$1;", "longVideoRemuxFinishTick", "longVideoStartRemuxTick", "postUIShowTick", "pressEditFinishTick", "remuxFinishTick", "reportDataPath", "startPostTick", "startRemuxTick", "targetVideoPath", "useNormalRemux", "getUseNormalRemux", "setUseNormalRemux", "(I)V", "useTavkitRemux", "getUseTavkitRemux", "setUseTavkitRemux", "videoQualityScore", "", "createFinderDefaultConfig", "destroy", "", "exec", "intent", "Landroid/content/Intent;", "markCdnUploadTime", "cost", "markExitAlbum", "markFirstFrameShow", "markPressEditFinish", "markRemuxFinish", "path", "qualityScore", "isLongVideo", "markShowCrop60s", "markShowPostUI", "markStartPost", "markStartRemux", "parseTestConfig", "config", "reportVideoResult", "reset", "setup", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m TYW;
  private static String TYX;
  private static String TYY;
  private static VideoTransPara TYZ;
  private static int TZa;
  private static int TZb;
  private static long TZc;
  private static long TZd;
  private static long TZe;
  private static long TZf;
  private static long TZg;
  private static long TZh;
  private static long TZi;
  private static long TZj;
  private static long TZk;
  private static long TZl;
  private static long TZm;
  private static float TZn;
  private static int TZo;
  private static int TZp;
  private static final FinderVideoShell.listener.1 TZq;
  
  static
  {
    AppMethodBeat.i(283609);
    TYW = new m();
    TYX = "";
    TYY = "";
    TZb = 1;
    TZq = new FinderVideoShell.listener.1(f.hfK);
    AppMethodBeat.o(283609);
  }
  
  public static void FN(boolean paramBoolean)
  {
    AppMethodBeat.i(283554);
    Log.i("MicroMsg.FinderVideoShell", s.X("markStartRemux, isLongVideo:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      TZl = Util.currentTicks();
      AppMethodBeat.o(283554);
      return;
    }
    TZk = Util.currentTicks();
    AppMethodBeat.o(283554);
  }
  
  public static void c(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(283561);
    s.u(paramString, "path");
    Log.i("MicroMsg.FinderVideoShell", "markRemuxFinish, qualityScore:" + paramFloat + ", path:" + paramString + ", isLongVideo:" + paramBoolean);
    if (paramBoolean) {
      TZj = Util.currentTicks();
    }
    for (;;)
    {
      String str2 = TYX;
      String str1 = str2;
      if (paramBoolean) {
        str1 = s.X(str2, "_long");
      }
      y.O(paramString, str1, false);
      TZn = paramFloat;
      AppMethodBeat.o(283561);
      return;
      TZi = Util.currentTicks();
    }
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(283498);
    Log.i("MicroMsg.FinderVideoShell", "destroy");
    TZq.dead();
    AppMethodBeat.o(283498);
  }
  
  public static void hQA()
  {
    AppMethodBeat.i(283545);
    Log.i("MicroMsg.FinderVideoShell", "markStartPost");
    if (TZh <= 0L) {
      TZh = Util.currentTicks();
    }
    AppMethodBeat.o(283545);
  }
  
  public static void hQB()
  {
    long l2 = 0L;
    AppMethodBeat.i(283583);
    if (!hQq())
    {
      reset();
      AppMethodBeat.o(283583);
      return;
    }
    Object localObject2 = new JSONObject();
    Object localObject1 = new JSONObject();
    long l1;
    int i;
    if (TZd > 0L)
    {
      l1 = TZd - TZc;
      ((JSONObject)localObject1).put("stage_1", l1);
      ((JSONObject)localObject1).put("stage_2", TZe - TZc);
      l1 = l2;
      if (TZg > 0L)
      {
        l1 = l2;
        if (TZf > 0L) {
          l1 = TZg - TZf;
        }
      }
      ((JSONObject)localObject1).put("stage_3", l1);
      ((JSONObject)localObject1).put("stage_4", TZi - TZk);
      ((JSONObject)localObject1).put("stage_5", TZj - TZl);
      ((JSONObject)localObject1).put("stage_6", TZm);
      ((JSONObject)localObject2).put("time_cost", localObject1);
      ((JSONObject)localObject2).put("quality_score", Float.valueOf(TZn));
      Log.i("MicroMsg.FinderVideoShell", "reportVideoResult:" + localObject2 + ", path:" + TYY);
      if (((CharSequence)TYY).length() <= 0) {
        break label362;
      }
      i = 1;
      label243:
      if (i == 0) {
        break label367;
      }
      y.bDX(new File(TYY).getParentFile().getAbsolutePath());
      localObject1 = TYY;
      localObject2 = ((JSONObject)localObject2).toString();
      s.s(localObject2, "json.toString()");
      localObject2 = ((String)localObject2).getBytes(d.UTF_8);
      s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
      y.f((String)localObject1, (byte[])localObject2, localObject2.length);
    }
    label362:
    label367:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new Intent("wechat.shell.FINDER_VIDEO_TEST_FINISH");
      ((Intent)localObject1).putExtra("success", bool);
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject1);
      AppMethodBeat.o(283583);
      return;
      l1 = 0L;
      break;
      i = 0;
      break label243;
    }
  }
  
  public static boolean hQq()
  {
    AppMethodBeat.i(283453);
    if ((WeChatEnvironment.hasDebugger()) && (TYZ != null))
    {
      if (((CharSequence)TYX).length() > 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(283453);
        return true;
      }
    }
    AppMethodBeat.o(283453);
    return false;
  }
  
  public static VideoTransPara hQr()
  {
    return TYZ;
  }
  
  public static int hQs()
  {
    int i = 1;
    if (TZa == 1) {
      i = 0;
    }
    return i;
  }
  
  public static int hQt()
  {
    return TZo;
  }
  
  public static int hQu()
  {
    return TZp;
  }
  
  public static void hQv()
  {
    AppMethodBeat.i(283507);
    Log.i("MicroMsg.FinderVideoShell", "markExitAlbum");
    if (TZc <= 0L) {
      TZc = Util.currentTicks();
    }
    AppMethodBeat.o(283507);
  }
  
  public static void hQw()
  {
    AppMethodBeat.i(283516);
    Log.i("MicroMsg.FinderVideoShell", "markShowCrop60s");
    if (TZd <= 0L) {
      TZd = Util.currentTicks();
    }
    AppMethodBeat.o(283516);
  }
  
  public static void hQx()
  {
    AppMethodBeat.i(283522);
    Log.i("MicroMsg.FinderVideoShell", "markFirstFrameShow");
    if (TZe <= 0L) {
      TZe = Util.currentTicks();
    }
    AppMethodBeat.o(283522);
  }
  
  public static void hQy()
  {
    AppMethodBeat.i(283527);
    Log.i("MicroMsg.FinderVideoShell", "markPressEditFinish");
    if (TZf <= 0L) {
      TZf = Util.currentTicks();
    }
    AppMethodBeat.o(283527);
  }
  
  public static void hQz()
  {
    AppMethodBeat.i(283536);
    Log.i("MicroMsg.FinderVideoShell", "markShowPostUI");
    if (TZg <= 0L) {
      TZg = Util.currentTicks();
    }
    AppMethodBeat.o(283536);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(283592);
    Log.i("MicroMsg.FinderVideoShell", "reset");
    TZc = 0L;
    TZd = 0L;
    TZe = 0L;
    TZf = 0L;
    TZg = 0L;
    TZh = 0L;
    TZi = 0L;
    AppMethodBeat.o(283592);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(283488);
    if (WeChatEnvironment.hasDebugger())
    {
      Log.i("MicroMsg.FinderVideoShell", "setup");
      TZq.alive();
    }
    AppMethodBeat.o(283488);
  }
  
  public static void wy(long paramLong)
  {
    AppMethodBeat.i(283571);
    Log.i("MicroMsg.FinderVideoShell", "markCdnUploadCost");
    if (TZm <= 0L) {
      TZm = paramLong;
    }
    AppMethodBeat.o(283571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.m
 * JD-Core Version:    0.7.0.1
 */