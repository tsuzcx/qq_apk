package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ap;

public final class d
  extends c<wg>
{
  private ap mHandler;
  
  public d()
  {
    AppMethodBeat.i(66399);
    this.mHandler = new ap(Looper.getMainLooper());
    this.__eventId = wg.class.getName().hashCode();
    AppMethodBeat.o(66399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d
 * JD-Core Version:    0.7.0.1
 */