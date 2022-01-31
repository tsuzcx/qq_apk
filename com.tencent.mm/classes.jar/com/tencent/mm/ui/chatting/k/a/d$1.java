package com.tencent.mm.ui.chatting.k.a;

import android.os.Bundle;
import com.tencent.mm.ui.chatting.b.b.g;

final class d$1
  implements Runnable
{
  d$1(d paramd, Bundle paramBundle, int paramInt) {}
  
  public final void run()
  {
    g localg = (g)this.vAh.byx.ac(g.class);
    if (this.vzR.getInt("SCENE", 0) == 1) {
      this.vAh.HH(this.vAg);
    }
    while (this.vzR.getInt("SCENE", 0) != 2) {
      return;
    }
    localg.GX(this.vAg);
    this.vAh.byx.bE(this.vAg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.d.1
 * JD-Core Version:    0.7.0.1
 */