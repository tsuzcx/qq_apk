package com.tencent.mm.plugin.offline.ui;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ade;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;

class OfflineLogicMgr$1
  extends IListener<ade>
{
  OfflineLogicMgr$1(c paramc, q paramq, PayInfo paramPayInfo)
  {
    super(paramq);
    AppMethodBeat.i(269165);
    this.__eventId = ade.class.getName().hashCode();
    AppMethodBeat.o(269165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineLogicMgr.1
 * JD-Core Version:    0.7.0.1
 */