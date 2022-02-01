package com.tencent.mm.plugin.performance.elf;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$b$1
  implements Runnable
{
  b$b$1(b.b paramb, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(124997);
    Intent localIntent = new Intent(this.val$context, ElfCallUpReceiver.class);
    localIntent.setAction(ElfCallUpReceiver.class.getName());
    this.val$context.sendBroadcast(localIntent);
    AppMethodBeat.o(124997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.b.b.1
 * JD-Core Version:    0.7.0.1
 */