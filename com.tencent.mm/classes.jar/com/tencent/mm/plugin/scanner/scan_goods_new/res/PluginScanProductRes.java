package com.tencent.mm.plugin.scanner.scan_goods_new.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/res/PluginScanProductRes;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginScanProductRes
  extends f
  implements d
{
  public static final a OWF;
  
  static
  {
    AppMethodBeat.i(313982);
    OWF = new a((byte)0);
    AppMethodBeat.o(313982);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(314008);
    if ((paramg != null) && (paramg.bbA()))
    {
      Log.i("MicroMsg.PluginScanProductRes", "PluginScanProductRes configure");
      pin((com.tencent.mm.kernel.b.c)new y(c.class));
    }
    AppMethodBeat.o(314008);
  }
  
  public final void execute(g paramg) {}
  
  public final String name()
  {
    return "plugin-scanProductRes";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/scan_goods_new/res/PluginScanProductRes$Companion;", "", "()V", "TAG", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.scan_goods_new.res.PluginScanProductRes
 * JD-Core Version:    0.7.0.1
 */