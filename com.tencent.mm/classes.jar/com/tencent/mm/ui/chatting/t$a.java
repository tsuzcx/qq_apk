package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.viewitems.bk;

public final class t$a
  extends t.b
{
  public t$a(a parama)
  {
    super(parama);
  }
  
  public final void a(Intent paramIntent, bk parambk)
  {
    AppMethodBeat.i(34589);
    if (!bu.isNullOrNil(parambk.KDS)) {
      paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", parambk.KDS);
    }
    AppMethodBeat.o(34589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.a
 * JD-Core Version:    0.7.0.1
 */