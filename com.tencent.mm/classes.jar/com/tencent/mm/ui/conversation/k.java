package com.tencent.mm.ui.conversation;

import android.os.HandlerThread;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

public final class k
{
  ListView AgN;
  h Ahr;
  boolean AlF;
  private al AlG;
  private Runnable AlH;
  int AlI;
  d efo;
  
  public k()
  {
    AppMethodBeat.i(34576);
    this.AlF = false;
    this.AlI = -1;
    this.efo = new d(new k.1(this));
    AppMethodBeat.o(34576);
  }
  
  final void dMY()
  {
    AppMethodBeat.i(34577);
    if (!this.AlF)
    {
      ab.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.AlF = true;
    }
    if ((this.AlG != null) && (this.AlH != null)) {
      this.AlG.caB().removeCallbacks(this.AlH);
    }
    if (this.AlG != null)
    {
      this.AlG.oNc.quit();
      this.AlG = null;
    }
    AppMethodBeat.o(34577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k
 * JD-Core Version:    0.7.0.1
 */