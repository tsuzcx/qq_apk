package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin$showVideoDebugInfoIfNeed$1$1$1"})
final class p$c$1
  implements Runnable
{
  p$c$1(p.c paramc, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(150679);
    ab.i("MicroMsg.EditVideoPlayPlugin", "DEBUG showVideoDebugInfoIfNeed %s", new Object[] { this.qcK });
    this.qcJ.qcI.setVisibility(0);
    this.qcJ.qcI.setText((CharSequence)this.qcK);
    AppMethodBeat.o(150679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.p.c.1
 * JD-Core Version:    0.7.0.1
 */