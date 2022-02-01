package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"})
public final class f
  implements a
{
  public static final a xlE;
  
  static
  {
    AppMethodBeat.i(204960);
    xlE = new a((byte)0);
    AppMethodBeat.o(204960);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(204959);
    if ((paramArrayOfString != null) && (k.g("//scan", paramArrayOfString[0])) && (k.g("showDebug", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramContext = aw.aKU("ScanDebug");
      if (bs.getInt(paramArrayOfString[2], 0) == 1) {
        bool = true;
      }
      paramContext.putBoolean("scan_debug_show_debug_view", bool);
      paramContext.apply();
      AppMethodBeat.o(204959);
      return true;
    }
    AppMethodBeat.o(204959);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", "init", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f
 * JD-Core Version:    0.7.0.1
 */