package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ElfCheckResponse$1
  implements Runnable
{
  ElfCheckResponse$1(ElfCheckResponse paramElfCheckResponse, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(111051);
    ab.i("MicroMsg.ElfCheckResponse", "call this response %s", new Object[] { this.psw.toString() });
    Intent localIntent = new Intent(this.val$context, ElfCallUpReceiver.class);
    localIntent.setAction(ElfCallUpReceiver.class.getName());
    if (ElfCheckResponse.a(this.psw) != null) {
      localIntent.putExtras(ElfCheckResponse.a(this.psw));
    }
    this.val$context.sendBroadcast(localIntent);
    AppMethodBeat.o(111051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCheckResponse.1
 * JD-Core Version:    0.7.0.1
 */