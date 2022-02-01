package com.tencent.mm.plugin.performance.watchdogs;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.sdk.event.IListener;

class MemoryWatchDog$3
  extends IListener<oc>
{
  MemoryWatchDog$3(d paramd, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(301001);
    this.__eventId = oc.class.getName().hashCode();
    AppMethodBeat.o(301001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.MemoryWatchDog.3
 * JD-Core Version:    0.7.0.1
 */