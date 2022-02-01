package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.yq;
import com.tencent.mm.f.a.yq.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class d
  extends IListener<yq>
{
  private MMHandler mHandler;
  
  public d()
  {
    AppMethodBeat.i(66399);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.__eventId = yq.class.getName().hashCode();
    AppMethodBeat.o(66399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.d
 * JD-Core Version:    0.7.0.1
 */