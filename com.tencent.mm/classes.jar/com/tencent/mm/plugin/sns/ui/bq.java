package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/SnsVideoPlayConfig;", "", "()V", "TAG", "", "getSnsVideoShowSeekBarDurationMs", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
{
  public static final bq REM;
  
  static
  {
    AppMethodBeat.i(308347);
    REM = new bq();
    AppMethodBeat.o(308347);
  }
  
  public static int getSnsVideoShowSeekBarDurationMs()
  {
    AppMethodBeat.i(308344);
    int i = ((c)h.ax(c.class)).a(c.a.zfs, 16000);
    Log.i("MicroMsg.SnsVideoConfig", s.X("getSnsVideoShowSeekBarDurationMs: ", Integer.valueOf(i)));
    AppMethodBeat.o(308344);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bq
 * JD-Core Version:    0.7.0.1
 */