package com.tencent.mm.plugin.vlog.model.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/config/VideoCompositionExptConfig;", "", "()V", "TAG", "", "getMuxMiniDuration", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Ubw;
  
  static
  {
    AppMethodBeat.i(283356);
    Ubw = new b();
    AppMethodBeat.o(283356);
  }
  
  public static int hRq()
  {
    AppMethodBeat.i(283348);
    int i = ((c)h.ax(c.class)).a(c.a.yMe, 800);
    Log.i("MicroMsg.VideoCompositionExptConfig", s.X("getMuxMiniDuration: ", Integer.valueOf(i)));
    AppMethodBeat.o(283348);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.config.b
 * JD-Core Version:    0.7.0.1
 */