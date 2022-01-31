package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum x
{
  public String mGC = null;
  public boolean mGD = false;
  private Signature ulj = null;
  public j ulk = null;
  
  static
  {
    AppMethodBeat.i(46896);
    uli = new x("IML");
    ull = new x[] { uli };
    AppMethodBeat.o(46896);
  }
  
  private x() {}
  
  public final void reset()
  {
    AppMethodBeat.i(46895);
    ab.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.ulj = null;
    this.mGC = null;
    this.mGD = false;
    AppMethodBeat.o(46895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.x
 * JD-Core Version:    0.7.0.1
 */