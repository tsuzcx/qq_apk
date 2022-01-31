package com.tencent.mm.plugin.talkroom.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

final class a$1
  extends ak
{
  a$1(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(25888);
    super.handleMessage(paramMessage);
    a.a(this.tdu).dismiss();
    AppMethodBeat.o(25888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a.1
 * JD-Core Version:    0.7.0.1
 */