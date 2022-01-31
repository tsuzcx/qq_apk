package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class bf$3
  implements Runnable
{
  bf$3(bf parambf) {}
  
  public final void run()
  {
    AppMethodBeat.i(39888);
    ab.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + this.scY.scR + " position:" + this.scY.position + " list.bottom:" + this.scY.list.getBottom());
    AppMethodBeat.o(39888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.3
 * JD-Core Version:    0.7.0.1
 */