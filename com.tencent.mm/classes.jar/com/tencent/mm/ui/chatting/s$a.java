package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.az;

public final class s$a
  extends s.b
{
  public s$a(a parama)
  {
    super(parama);
  }
  
  public final void a(Intent paramIntent, az paramaz)
  {
    AppMethodBeat.i(30717);
    if (!bo.isNullOrNil(paramaz.zYJ)) {
      paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", paramaz.zYJ);
    }
    AppMethodBeat.o(30717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.a
 * JD-Core Version:    0.7.0.1
 */