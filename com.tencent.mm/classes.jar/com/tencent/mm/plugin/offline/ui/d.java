package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.g.a.xk.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class d
  extends IListener<xk>
{
  private MMHandler mHandler;
  
  public d()
  {
    AppMethodBeat.i(66399);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.__eventId = xk.class.getName().hashCode();
    AppMethodBeat.o(66399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d
 * JD-Core Version:    0.7.0.1
 */