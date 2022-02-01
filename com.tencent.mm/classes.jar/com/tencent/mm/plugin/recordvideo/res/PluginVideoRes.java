package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/kernel/plugin/IPlugin;", "()V", "CLASS", "", "getCLASS", "()Ljava/lang/String;", "setCLASS", "(Ljava/lang/String;)V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginVideoRes
  extends f
  implements d
{
  public static final a NRJ;
  private String CLASS = "com.tencent.mm.plugin.recordvideo.res.PluginVideoRes";
  
  static
  {
    AppMethodBeat.i(279656);
    NRJ = new a((byte)0);
    AppMethodBeat.o(279656);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(279679);
    if ((paramg != null) && (paramg.bbA()))
    {
      Log.i("MicroMsg.PluginVideoRes", "PluginVideoRes configure");
      pin((com.tencent.mm.kernel.b.c)new y(c.class));
    }
    AppMethodBeat.o(279679);
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
    AppMethodBeat.i(279669);
    s.u(paramString, "<set-?>");
    this.CLASS = paramString;
    AppMethodBeat.o(279669);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/PluginVideoRes$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.PluginVideoRes
 * JD-Core Version:    0.7.0.1
 */