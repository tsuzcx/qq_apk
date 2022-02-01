package com.tencent.mm.plugin.notification.base;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abo;
import com.tencent.mm.sdk.event.IListener;

class AbstractSendMsgFailNotification$1
  extends IListener<abo>
{
  AbstractSendMsgFailNotification$1(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(271947);
    this.__eventId = abo.class.getName().hashCode();
    AppMethodBeat.o(271947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.base.AbstractSendMsgFailNotification.1
 * JD-Core Version:    0.7.0.1
 */