package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "()V", "CLASS", "", "getCLASS", "()Ljava/lang/String;", "setCLASS", "(Ljava/lang/String;)V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "Companion", "plugin-recordvideo_release"})
public final class PluginVideoRes
  extends f
  implements d
{
  public static final a HUT;
  private String CLASS = "com.tencent.mm.plugin.recordvideo.res.PluginVideoRes";
  
  static
  {
    AppMethodBeat.i(220986);
    HUT = new a((byte)0);
    AppMethodBeat.o(220986);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(220982);
    if ((paramg != null) && (paramg.aIE()))
    {
      Log.i("MicroMsg.PluginVideoRes", "PluginVideoRes configure");
      pin((com.tencent.mm.kernel.b.c)new y(c.class));
    }
    AppMethodBeat.o(220982);
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
    AppMethodBeat.i(220980);
    p.k(paramString, "<set-?>");
    this.CLASS = paramString;
    AppMethodBeat.o(220980);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.PluginVideoRes
 * JD-Core Version:    0.7.0.1
 */