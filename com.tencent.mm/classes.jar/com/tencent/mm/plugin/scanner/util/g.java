package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.n;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"})
public final class g
  implements a
{
  public static final a IYZ;
  
  static
  {
    AppMethodBeat.i(193384);
    IYZ = new a((byte)0);
    AppMethodBeat.o(193384);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(193382);
    if ((paramArrayOfString != null) && (p.h("//scan", paramArrayOfString[0])) && (p.h("showDebug", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramContext = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 0) == 1) {
        bool1 = true;
      }
      paramContext.putBoolean("scan_debug_show_debug_view", bool1);
      paramContext.apply();
      AppMethodBeat.o(193382);
      return true;
    }
    if ((paramArrayOfString != null) && (p.h("//scan", paramArrayOfString[0])) && (p.h("clearSearch", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      paramContext = z.bcZ();
      paramContext = MultiProcessMMKV.getMMKV(paramContext + "__image_gallery_search_preview_slot_mmkv_key__");
      if (paramContext != null) {
        paramContext.clearAll();
      }
      AppMethodBeat.o(193382);
      return true;
    }
    if ((paramArrayOfString != null) && (p.h("//scan", paramArrayOfString[0])) && (p.h("clearConfig", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      paramContext = z.bcZ();
      paramContext = MultiProcessMMKV.getMMKV(paramContext + "_scan_config_mmkv");
      if (paramContext != null) {
        paramContext.clearAll();
      }
      AppMethodBeat.o(193382);
      return true;
    }
    if ((paramArrayOfString != null) && (p.h("//scan", paramArrayOfString[0])) && (p.h("wordDetect", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      bool1 = bool2;
      if (Util.getInt(paramArrayOfString[2], 1) == 0) {
        bool1 = true;
      }
      n.xk(bool1);
      AppMethodBeat.o(193382);
      return true;
    }
    AppMethodBeat.o(193382);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", "init", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */