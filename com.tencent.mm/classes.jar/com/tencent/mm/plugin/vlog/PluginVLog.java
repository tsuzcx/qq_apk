package com.tencent.mm.plugin.vlog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.vlog.api.c;
import com.tencent.mm.plugin.vlog.model.aj;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/PluginVLog;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/vlog/api/IPluginVLog;", "()V", "TAG", "", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginVLog
  extends com.tencent.mm.kernel.b.f
  implements c
{
  private final String TAG = "MicroMsg.PluginVLog";
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(281170);
    paramg = com.tencent.mm.videocomposition.effect.f.agEN;
    com.tencent.mm.videocomposition.effect.f.aY((b)new a(this));
    paramg = aj.Ubd;
    AppMethodBeat.o(281170);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<com.tencent.mm.videocomposition.effect.f, ah>
  {
    a(PluginVLog paramPluginVLog)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.PluginVLog
 * JD-Core Version:    0.7.0.1
 */