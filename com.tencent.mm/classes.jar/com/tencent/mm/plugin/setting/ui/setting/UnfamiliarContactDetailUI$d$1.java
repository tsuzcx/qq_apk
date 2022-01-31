package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class UnfamiliarContactDetailUI$d$1
  implements Runnable
{
  UnfamiliarContactDetailUI$d$1(UnfamiliarContactDetailUI.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(127662);
    if (this.qLB.qLw != null)
    {
      this.qLB.qLw.fs(UnfamiliarContactDetailUI.b(this.qLB.qLi).size(), this.qLB.qLy);
      UnfamiliarContactDetailUI.b(this.qLB.qLi).clear();
    }
    AppMethodBeat.o(127662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d.1
 * JD-Core Version:    0.7.0.1
 */