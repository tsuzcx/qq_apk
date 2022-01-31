package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.ch.a;
import com.tencent.mm.g.a.ch.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.d;

final class TVInfoUI$6$1
  implements h.d
{
  TVInfoUI$6$1(TVInfoUI.6 param6) {}
  
  public final void ca(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24915);
    switch (paramInt2)
    {
    default: 
      ab.d("MicroMsg.TVInfoUI", "do del cancel");
    }
    ch localch;
    do
    {
      AppMethodBeat.o(24915);
      return;
      localch = new ch();
      localch.cpK.cpM = this.qRQ.qRP.getIntent().getLongExtra("key_favorite_local_id", -1L);
      a.ymk.l(localch);
      ab.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[] { Long.valueOf(localch.cpK.cpM), Boolean.valueOf(localch.cpL.cpz) });
    } while (!localch.cpL.cpz);
    this.qRQ.qRP.finish();
    AppMethodBeat.o(24915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.6.1
 * JD-Core Version:    0.7.0.1
 */