package com.tencent.mm.ui.conversation;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;

final class n$7
  implements Runnable
{
  n$7(n paramn) {}
  
  public final void run()
  {
    if (!ae.cqO())
    {
      ae.ms(true);
      ai.l(new n.7.1(this), 100L);
    }
    g.wJ(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.7
 * JD-Core Version:    0.7.0.1
 */