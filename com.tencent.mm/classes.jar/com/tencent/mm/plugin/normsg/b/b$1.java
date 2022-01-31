package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import java.util.List;

final class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, View paramView, List paramList, boolean[] paramArrayOfBoolean) {}
  
  public final void run()
  {
    b.b(this.mHC, this.mHy, this.mHz, this.mHA);
    synchronized (this.mHB)
    {
      this.mHB[0] = true;
      this.mHB.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.1
 * JD-Core Version:    0.7.0.1
 */