package com.tencent.mm.plugin.normsg.b;

import android.view.View;

final class b$2
  implements Runnable
{
  b$2(b paramb, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, View paramView) {}
  
  public final void run()
  {
    this.mHB[0] = b.b(this.mHC, this.byD, this.mHy, this.mHz);
    synchronized (this.mHB)
    {
      this.mHB[1] = true;
      this.mHB.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.2
 * JD-Core Version:    0.7.0.1
 */