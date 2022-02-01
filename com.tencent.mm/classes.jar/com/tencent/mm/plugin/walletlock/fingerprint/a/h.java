package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
{
  public com.tencent.soter.a.a.a WfU = null;
  
  public final void release()
  {
    AppMethodBeat.i(129702);
    Log.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
    if (this.WfU != null) {
      this.WfU.Os(true);
    }
    AppMethodBeat.o(129702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.h
 * JD-Core Version:    0.7.0.1
 */