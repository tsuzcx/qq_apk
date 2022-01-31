package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.b;

final class t$4
  implements Runnable
{
  t$4(t paramt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(4604);
    if (this.tzi.tyS != null)
    {
      VoipMgr localVoipMgr = this.tzi.tyS;
      String str = this.val$tips;
      if (localVoipMgr.txc != null)
      {
        localVoipMgr.txI = str;
        localVoipMgr.txc.aeH(str);
      }
    }
    AppMethodBeat.o(4604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t.4
 * JD-Core Version:    0.7.0.1
 */