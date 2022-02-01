package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"})
public final class g
  implements a
{
  public static final a CTH;
  
  static
  {
    AppMethodBeat.i(194778);
    CTH = new a((byte)0);
    AppMethodBeat.o(194778);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(194777);
    if ((paramArrayOfString != null) && (p.j("//scan", paramArrayOfString[0])) && (p.j("showDebug", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramContext = MultiProcessMMKV.getSingleMMKV("ScanDebug");
      if (Util.getInt(paramArrayOfString[2], 0) == 1) {
        bool = true;
      }
      paramContext.putBoolean("scan_debug_show_debug_view", bool);
      paramContext.apply();
      AppMethodBeat.o(194777);
      return true;
    }
    if ((paramArrayOfString != null) && (p.j("//scan", paramArrayOfString[0])) && (p.j("clearSearch", paramArrayOfString[1])) && (paramArrayOfString.length > 1))
    {
      paramContext = z.aTY();
      paramContext = MultiProcessMMKV.getMMKV(paramContext + "__image_gallery_search_preview_slot_mmkv_key__");
      if (paramContext != null) {
        paramContext.clearAll();
      }
      AppMethodBeat.o(194777);
      return true;
    }
    AppMethodBeat.o(194777);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", "init", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */