package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class h
{
  public com.tencent.soter.a.a.a DLR = null;
  
  public final void release()
  {
    AppMethodBeat.i(129702);
    ae.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
    if (this.DLR != null) {
      this.DLR.zF(true);
    }
    AppMethodBeat.o(129702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.h
 * JD-Core Version:    0.7.0.1
 */