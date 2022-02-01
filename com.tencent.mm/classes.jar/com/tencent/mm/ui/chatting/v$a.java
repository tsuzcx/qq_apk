package com.tencent.mm.ui.chatting;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bz;

public final class v$a
  extends v.b
{
  public v$a(a parama)
  {
    super(parama);
  }
  
  public final void a(Intent paramIntent, bz parambz)
  {
    AppMethodBeat.i(34589);
    if (!Util.isNullOrNil(parambz.aeXQ)) {
      paramIntent.putExtra("Contact_BIZ_KF_WORKER_ID", parambz.aeXQ);
    }
    AppMethodBeat.o(34589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.a
 * JD-Core Version:    0.7.0.1
 */