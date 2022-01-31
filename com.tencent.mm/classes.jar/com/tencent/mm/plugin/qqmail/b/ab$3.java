package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

final class ab$3
  implements ab.c
{
  ab$3(ab paramab) {}
  
  public final void btC()
  {
    y.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
    this.nfi.wm(90);
    ab localab = this.nfi;
    if ((localab.nfa != null) && (localab.nfa.size() > 0)) {
      localab.nfa.clear();
    }
    this.nfi.btB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.3
 * JD-Core Version:    0.7.0.1
 */