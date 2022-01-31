package com.tencent.mm.ui.conversation;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class m$1
  extends ak
{
  m$1(m paramm) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(34591);
    if (this.AlR.Ahr != null)
    {
      this.AlR.Ahr.clearCache();
      this.AlR.Ahr.notifyDataSetChanged();
    }
    AppMethodBeat.o(34591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.1
 * JD-Core Version:    0.7.0.1
 */