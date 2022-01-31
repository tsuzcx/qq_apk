package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.b.c;

public final class m
  implements a
{
  Runnable AaN;
  h Ahr;
  c AlP;
  c AlQ;
  ConversationListView All;
  Activity cup;
  MessageQueue.IdleHandler jZm;
  c lfx;
  
  public m()
  {
    AppMethodBeat.i(34608);
    this.lfx = null;
    this.AlP = null;
    this.AlQ = null;
    this.AaN = new m.10(this);
    AppMethodBeat.o(34608);
  }
  
  public final void k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(34609);
    if (this.Ahr != null) {
      this.Ahr.notifyDataSetChanged();
    }
    AppMethodBeat.o(34609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m
 * JD-Core Version:    0.7.0.1
 */