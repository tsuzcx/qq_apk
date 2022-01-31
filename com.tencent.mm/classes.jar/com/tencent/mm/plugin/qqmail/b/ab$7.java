package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import java.util.ArrayList;
import java.util.HashMap;

final class ab$7
  implements com.tencent.mm.ai.g
{
  ab$7(ab paramab) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(68043);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { this.pKx.pKq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.pKx.pKp.size()) });
    if (paramInt1 >= paramInt2)
    {
      this.pKx.pKs.put(this.pKx.pKr, ((u)paramm).cdJ().pIF);
      paramm = ((u)paramm).cdJ();
      if (this.pKx.pKu != null) {
        this.pKx.pKu.e(this.pKx.pKv - this.pKx.pKp.size(), this.pKx.pKv, this.pKx.pKr, paramm.pIF);
      }
      if (this.pKx.pKp.isEmpty())
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finished send all files");
        if (this.pKx.pKt != null) {
          this.pKx.pKt.cdN();
        }
        AppMethodBeat.o(68043);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
      paramm = (ab.g)this.pKx.pKp.remove(0);
      this.pKx.pKq = paramm.fileId;
      this.pKx.pKr = paramm.fileName;
      paramm = new u(this.pKx.pKr, this.pKx.pKq, this);
      com.tencent.mm.kernel.g.RK().eHt.a(paramm, 0);
    }
    AppMethodBeat.o(68043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.7
 * JD-Core Version:    0.7.0.1
 */