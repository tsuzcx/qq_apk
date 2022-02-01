package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements a
{
  public static final a PiL;
  
  static
  {
    AppMethodBeat.i(314116);
    PiL = new a((byte)0);
    AppMethodBeat.o(314116);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(314126);
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("showDebug", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramContext = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 0) == 1) {}
      for (bool = true;; bool = false)
      {
        paramContext.putBoolean("scan_debug_show_debug_view", bool);
        paramContext.apply();
        AppMethodBeat.o(314126);
        return true;
      }
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("clearSearch", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      paramContext = MultiProcessMMKV.getMMKV(s.X(z.bAM(), "__image_gallery_search_preview_slot_mmkv_key__"));
      if (paramContext != null) {
        paramContext.clearAll();
      }
      AppMethodBeat.o(314126);
      return true;
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("clearConfig", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      paramContext = MultiProcessMMKV.getMMKV(s.X(z.bAM(), "_scan_config_mmkv"));
      if (paramContext != null) {
        paramContext.clearAll();
      }
      AppMethodBeat.o(314126);
      return true;
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("wordDetect", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      if (Util.getInt(paramArrayOfString[2], 1) == 0) {
        bool = true;
      }
      n.BV(bool);
      AppMethodBeat.o(314126);
      return true;
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("loadLocalSo", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramString = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 0) == 1) {}
      for (bool = true;; bool = false)
      {
        paramString.putBoolean("loadSoFromSDCard", bool);
        aa.makeText(paramContext, (CharSequence)"success", 0).show();
        paramString.apply();
        AppMethodBeat.o(314126);
        return true;
      }
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("loadLocalConfig", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramString = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (s.p(paramArrayOfString[2], "null"))
      {
        paramString.putString("debugFFEngineConfig", "");
        aa.makeText(paramContext, (CharSequence)"cancel success", 0).show();
        AppMethodBeat.o(314126);
        return true;
      }
      if (y.ZC(paramArrayOfString[2]))
      {
        paramString.putString("debugFFEngineConfig", y.bEn(paramArrayOfString[2]));
        aa.makeText(paramContext, (CharSequence)"success", 0).show();
        AppMethodBeat.o(314126);
        return true;
      }
      aa.makeText(paramContext, (CharSequence)"config file not exist", 0).show();
      paramString.apply();
      AppMethodBeat.o(314126);
      return false;
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("skipFrame", paramArrayOfString[1])) && (paramArrayOfString.length >= 2))
    {
      paramString = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      paramString.putInt("skipFrame", Util.getInt(paramArrayOfString[2], -1));
      aa.makeText(paramContext, (CharSequence)"success", 0).show();
      paramString.apply();
      AppMethodBeat.o(314126);
      return true;
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("serverDetect", paramArrayOfString[1])) && (paramArrayOfString.length >= 2))
    {
      paramString = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 0) == 1) {}
      for (bool = true;; bool = false)
      {
        paramString.putBoolean("serverDetect", bool);
        aa.makeText(paramContext, (CharSequence)"success", 0).show();
        paramString.apply();
        AppMethodBeat.o(314126);
        return true;
      }
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("localDetect", paramArrayOfString[1])) && (paramArrayOfString.length >= 2))
    {
      paramString = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 1) == 1) {}
      for (bool = true;; bool = false)
      {
        paramString.putBoolean("localDetect", bool);
        aa.makeText(paramContext, (CharSequence)"success", 0).show();
        paramString.apply();
        AppMethodBeat.o(314126);
        return true;
      }
    }
    if ((paramArrayOfString != null) && (s.p("//scan", paramArrayOfString[0])) && (s.p("enableMerge", paramArrayOfString[1])) && (paramArrayOfString.length >= 2))
    {
      paramString = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 1) == 1) {}
      for (bool = true;; bool = false)
      {
        paramString.putBoolean("enableMerge", bool);
        aa.makeText(paramContext, (CharSequence)"success", 0).show();
        paramString.apply();
        AppMethodBeat.o(314126);
        return true;
      }
    }
    AppMethodBeat.o(314126);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", "getDebugEnableLocalDetect", "", "getDebugEnableScanMerge", "getDebugEnableServerDetect", "getDebugFFEngineConfig", "getDebugTrackSkipFrameNum", "", "init", "", "loadSoFromLocal", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.h
 * JD-Core Version:    0.7.0.1
 */