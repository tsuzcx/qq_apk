package com.tencent.mm.plugin.performance.diagnostic;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.sdk.event.IListener;

class DiagnosticPush$1
  extends IListener<gh>
{
  DiagnosticPush$1(q paramq)
  {
    super(paramq);
    AppMethodBeat.i(300855);
    this.__eventId = gh.class.getName().hashCode();
    AppMethodBeat.o(300855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.DiagnosticPush.1
 * JD-Core Version:    0.7.0.1
 */