package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bq;

public final class t$a
  extends t.b
{
  public t$a(a parama)
  {
    super(parama);
  }
  
  public final void a(Intent paramIntent, bq parambq)
  {
    AppMethodBeat.i(34589);
    if (!Util.isNullOrNil(parambq.PQF)) {
      paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", parambq.PQF);
    }
    AppMethodBeat.o(34589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.a
 * JD-Core Version:    0.7.0.1
 */