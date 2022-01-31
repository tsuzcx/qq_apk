package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;

final class ab$7
  implements com.tencent.mm.ah.g
{
  ab$7(ab paramab) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    y.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[] { this.nfi.nfb, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.nfi.nfa.size()) });
    if (paramInt1 >= paramInt2)
    {
      this.nfi.nfd.put(this.nfi.nfc, ((u)paramm).bty().ndn);
      paramm = ((u)paramm).bty();
      if (this.nfi.nff != null) {
        this.nfi.nff.e(this.nfi.nfg - this.nfi.nfa.size(), this.nfi.nfg, this.nfi.nfc, paramm.ndn);
      }
      if (!this.nfi.nfa.isEmpty()) {
        break label193;
      }
      y.i("MicroMsg.ShareModeMailAppService", "finished send all files");
      if (this.nfi.nfe != null) {
        this.nfi.nfe.btC();
      }
    }
    return;
    label193:
    y.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
    paramm = (ab.g)this.nfi.nfa.remove(0);
    this.nfi.nfb = paramm.fileId;
    this.nfi.nfc = paramm.fileName;
    paramm = new u(this.nfi.nfc, this.nfi.nfb, this);
    com.tencent.mm.kernel.g.DO().dJT.a(paramm, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.7
 * JD-Core Version:    0.7.0.1
 */