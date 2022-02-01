package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/SnsVideoPlayConfig;", "", "()V", "TAG", "", "getSnsVideoShowSeekBarDurationMs", "", "plugin-sns_release"})
public final class bp
{
  public static final bp LeB;
  
  static
  {
    AppMethodBeat.i(194421);
    LeB = new bp();
    AppMethodBeat.o(194421);
  }
  
  public static int getSnsVideoShowSeekBarDurationMs()
  {
    AppMethodBeat.i(194418);
    int i = ((b)h.ae(b.class)).a(b.a.vNt, 16000);
    Log.i("MicroMsg.SnsVideoConfig", "getSnsVideoShowSeekBarDurationMs: ".concat(String.valueOf(i)));
    AppMethodBeat.o(194418);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bp
 * JD-Core Version:    0.7.0.1
 */