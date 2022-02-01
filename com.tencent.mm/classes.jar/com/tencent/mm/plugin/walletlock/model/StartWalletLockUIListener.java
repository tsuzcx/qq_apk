package com.tencent.mm.plugin.walletlock.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.zv;
import com.tencent.mm.sdk.event.IListener;

public class StartWalletLockUIListener
  extends IListener<zv>
{
  public StartWalletLockUIListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161150);
    this.__eventId = zv.class.getName().hashCode();
    AppMethodBeat.o(161150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.StartWalletLockUIListener
 * JD-Core Version:    0.7.0.1
 */