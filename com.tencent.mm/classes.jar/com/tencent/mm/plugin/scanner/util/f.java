package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"})
public final class f
  implements a
{
  public static final a way;
  
  static
  {
    AppMethodBeat.i(190156);
    way = new a((byte)0);
    AppMethodBeat.o(190156);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(190155);
    if ((paramArrayOfString != null) && (k.g("//scan", paramArrayOfString[0])) && (k.g("showDebug", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramContext = ax.aFD("ScanDebug");
      if (bt.getInt(paramArrayOfString[2], 0) == 1) {
        bool = true;
      }
      paramContext.putBoolean("scan_debug_show_debug_view", bool);
      paramContext.apply();
      AppMethodBeat.o(190155);
      return true;
    }
    AppMethodBeat.o(190155);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", "init", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f
 * JD-Core Version:    0.7.0.1
 */