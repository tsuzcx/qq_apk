package com.tencent.mm.plugin.performance.elf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

final class MainProcessChecker$1
  implements Runnable
{
  MainProcessChecker$1(MainProcessChecker paramMainProcessChecker) {}
  
  public final void run()
  {
    AppMethodBeat.i(111057);
    if (this.psS.psl.psp)
    {
      ab.w(this.psS.getTag(), "[onCallUp] My God, you saw me!");
      e.qrI.idkeyStat(959L, 7L, 1L, true);
      AppMethodBeat.o(111057);
      return;
    }
    ab.w(this.psS.getTag(), "[onCallUp] you can't see me, perry!");
    AppMethodBeat.o(111057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.MainProcessChecker.1
 * JD-Core Version:    0.7.0.1
 */