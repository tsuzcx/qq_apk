package com.tencent.mm.plugin.scanner.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "scan-sdk_release"})
public final class f
  implements a
{
  public static final a yzG;
  
  static
  {
    AppMethodBeat.i(218770);
    yzG = new a((byte)0);
    AppMethodBeat.o(218770);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(218769);
    if ((paramArrayOfString != null) && (p.i("//scan", paramArrayOfString[0])) && (p.i("showDebug", paramArrayOfString[1])) && (paramArrayOfString.length > 2))
    {
      paramContext = ax.aQA("ScanDebug");
      if (bt.getInt(paramArrayOfString[2], 0) == 1) {
        bool = true;
      }
      paramContext.putBoolean("scan_debug_show_debug_view", bool);
      paramContext.apply();
      AppMethodBeat.o(218769);
      return true;
    }
    AppMethodBeat.o(218769);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/util/ScanProcessorCommand$Companion;", "", "()V", "COMMAND_SCAN", "", "SCAN_DEBUG", "SCAN_DEBUG_SHOW_DEBUG_VIEW", "init", "", "scan-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.f
 * JD-Core Version:    0.7.0.1
 */