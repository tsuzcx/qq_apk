package com.tencent.mm.plugin.ringtone.uic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.d.c;
import com.tencent.mm.plugin.ringtone.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtonePlayController;", "", "()V", "lifeScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifeScope", "()Lkotlinx/coroutines/CoroutineScope;", "mPreviewHelper", "Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;", "getMPreviewHelper", "()Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;", "setMPreviewHelper", "(Lcom/tencent/mm/plugin/ringtone/feed/RingtonePlayerFlow;)V", "onPauseRingtone", "", "onPlayRingtone", "item", "Lcom/tencent/mm/plugin/ringtone/params/TPMediaInfoDesc;", "id", "", "play", "", "release", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a OFm;
  private final aq OFn;
  private c OFo;
  
  static
  {
    AppMethodBeat.i(273349);
    OFm = new g.a((byte)0);
    AppMethodBeat.o(273349);
  }
  
  public g()
  {
    AppMethodBeat.i(273339);
    this.OFn = ar.d((f)bg.kCi());
    this.OFo = new c(this.OFn);
    this.OFo.gOy();
    AppMethodBeat.o(273339);
  }
  
  public final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(273364);
    s.u(paramd, "item");
    Log.i("MicroMsg.RingtonePlayUIC", "on play ringtone " + paramd.toJson() + ",and id is 0 with action is play " + paramBoolean);
    this.OFo.a(paramd, 0L, paramBoolean);
    AppMethodBeat.o(273364);
  }
  
  public final void release()
  {
    AppMethodBeat.i(273373);
    Log.i("MicroMsg.RingtonePlayUIC", "release");
    this.OFo.gOx();
    this.OFo.release();
    ar.a(this.OFn, null);
    AppMethodBeat.o(273373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.g
 * JD-Core Version:    0.7.0.1
 */