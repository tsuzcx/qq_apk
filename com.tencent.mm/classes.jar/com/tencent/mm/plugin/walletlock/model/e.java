package com.tencent.mm.plugin.walletlock.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;

public final class e
{
  public IListener WhH;
  public IListener WhI;
  private IListener WhJ;
  public IListener WhK;
  
  public e()
  {
    AppMethodBeat.i(129916);
    this.WhH = new StartWalletLockUIListener();
    this.WhI = new WalletLockInitTask.1(this, f.hfK);
    this.WhJ = new WalletLockInitTask.2(this, f.hfK);
    this.WhK = new WalletLockInitTask.3(this, f.hfK);
    AppMethodBeat.o(129916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.e
 * JD-Core Version:    0.7.0.1
 */