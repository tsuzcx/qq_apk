package com.tencent.mm.plugin.qmessage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.sp;
import com.tencent.mm.sdk.event.IListener;

public class QMsgOperationListener
  extends IListener<sp>
{
  public QMsgOperationListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161423);
    this.__eventId = sp.class.getName().hashCode();
    AppMethodBeat.o(161423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.QMsgOperationListener
 * JD-Core Version:    0.7.0.1
 */