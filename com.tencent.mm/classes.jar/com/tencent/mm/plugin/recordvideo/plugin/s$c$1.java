package com.tencent.mm.plugin.recordvideo.plugin;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1$1"})
final class s$c$1
  implements Runnable
{
  s$c$1(s.c paramc, z.f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(75590);
    Log.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { (String)this.BRm.SYG });
    this.BRl.BRk.setVisibility(0);
    this.BRl.BRk.setText((CharSequence)this.BRm.SYG);
    AppMethodBeat.o(75590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s.c.1
 * JD-Core Version:    0.7.0.1
 */