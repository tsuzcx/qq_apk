package com.tencent.mm.plugin.performance.elf;

import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AbstractProcessChecker$1
  implements Runnable
{
  AbstractProcessChecker$1(AbstractProcessChecker paramAbstractProcessChecker, Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(111040);
    if ("ACTION_ELF_CHECK".equals(this.val$intent.getAction()))
    {
      ElfCheckRequest localElfCheckRequest = (ElfCheckRequest)this.val$intent.getParcelableExtra("MicroMsg.ElfCheckRequest");
      if (localElfCheckRequest == null)
      {
        ab.w("MicroMsg.AbstractProcessChecker", "pass this check,because request is null! ????");
        AppMethodBeat.o(111040);
        return;
      }
      boolean bool = this.psn.S(Process.myPid(), localElfCheckRequest.bQx);
      ab.i("MicroMsg.AbstractProcessChecker", "[onReceive] begin to check process[%s] isCanKill:%s isNeedReCall:%s", new Object[] { AbstractProcessChecker.getProcessName(), Boolean.valueOf(bool), Boolean.valueOf(this.psn.caA()) });
      if (bool)
      {
        this.psn.caC();
        AppMethodBeat.o(111040);
        return;
      }
      AbstractProcessChecker.a(this.psn);
    }
    AppMethodBeat.o(111040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.AbstractProcessChecker.1
 * JD-Core Version:    0.7.0.1
 */