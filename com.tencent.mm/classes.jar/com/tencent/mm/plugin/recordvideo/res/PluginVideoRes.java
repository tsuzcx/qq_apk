package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "()V", "CLASS", "", "getCLASS", "()Ljava/lang/String;", "setCLASS", "(Ljava/lang/String;)V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "Companion", "plugin-recordvideo_release"})
public final class PluginVideoRes
  extends f
  implements d
{
  public static final a BYf;
  private String CLASS = "com.tencent.mm.plugin.recordvideo.res.PluginVideoRes";
  
  static
  {
    AppMethodBeat.i(237480);
    BYf = new a((byte)0);
    AppMethodBeat.o(237480);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(237479);
    if ((paramg != null) && (paramg.aBb()))
    {
      Log.i("MicroMsg.PluginVideoRes", "PluginVideoRes configure");
      pin((com.tencent.mm.kernel.b.c)new y(c.class));
    }
    AppMethodBeat.o(237479);
  }
  
  public final void execute(g paramg) {}
  
  public final String getCLASS()
  {
    return this.CLASS;
  }
  
  public final String name()
  {
    return "plugin-videoRes";
  }
  
  public final void setCLASS(String paramString)
  {
    AppMethodBeat.i(237478);
    p.h(paramString, "<set-?>");
    this.CLASS = paramString;
    AppMethodBeat.o(237478);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.PluginVideoRes
 * JD-Core Version:    0.7.0.1
 */