package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class s$a
  extends s.b
{
  public s$a(a parama)
  {
    super(parama);
  }
  
  public final void a(Intent paramIntent, bi parambi)
  {
    AppMethodBeat.i(34589);
    if (!bt.isNullOrNil(parambi.GQT)) {
      paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", parambi.GQT);
    }
    AppMethodBeat.o(34589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.a
 * JD-Core Version:    0.7.0.1
 */