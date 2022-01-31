package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class b$a
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(111069);
    ab.i("MicroMsg.ProcessElf", "send check broadcast!");
    ElfCheckRequest localElfCheckRequest = new ElfCheckRequest();
    localElfCheckRequest.bQx = b.caE();
    Intent localIntent = new Intent("ACTION_ELF_CHECK");
    localIntent.putExtra("MicroMsg.ElfCheckRequest", localElfCheckRequest);
    ah.getContext().sendBroadcast(localIntent);
    b.caJ().postDelayed(this, b.caE());
    AppMethodBeat.o(111069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.b.a
 * JD-Core Version:    0.7.0.1
 */