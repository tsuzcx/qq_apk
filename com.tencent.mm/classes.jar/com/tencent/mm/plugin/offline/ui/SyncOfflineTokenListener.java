package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aaj;
import com.tencent.mm.autogen.a.aaj.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class SyncOfflineTokenListener
  extends IListener<aaj>
{
  private MMHandler mHandler;
  
  public SyncOfflineTokenListener()
  {
    super(f.hfK);
    AppMethodBeat.i(66399);
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.__eventId = aaj.class.getName().hashCode();
    AppMethodBeat.o(66399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.SyncOfflineTokenListener
 * JD-Core Version:    0.7.0.1
 */