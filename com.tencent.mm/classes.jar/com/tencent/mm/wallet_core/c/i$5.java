package com.tencent.mm.wallet_core.c;

import android.app.Activity;

final class i$5
  implements d
{
  i$5(i parami, e parame, Activity paramActivity) {}
  
  public final void bTn()
  {
    if (this.wAo.cMu()) {
      this.wAq.bgs();
    }
  }
  
  public final void bTo()
  {
    if (this.wAo.cMu())
    {
      this.wAq.bgs();
      return;
    }
    this.eRW.finish();
  }
  
  public final void onCancel()
  {
    if (this.wAo.cMu())
    {
      this.wAq.bgs();
      return;
    }
    this.eRW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.i.5
 * JD-Core Version:    0.7.0.1
 */