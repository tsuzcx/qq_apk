package com.tencent.mm.ui;

import com.tencent.mm.cl.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class MMAppMgr$1
  implements am.a
{
  MMAppMgr$1(MMAppMgr paramMMAppMgr) {}
  
  public final boolean tC()
  {
    String str = bk.bC(ae.getContext());
    if ((str != null) && (str.toLowerCase().startsWith(ae.getPackageName())))
    {
      y.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
      return false;
    }
    y.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
    b.afs("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.1
 * JD-Core Version:    0.7.0.1
 */