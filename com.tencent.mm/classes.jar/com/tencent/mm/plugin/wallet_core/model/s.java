package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum s
{
  public String klM = null;
  public boolean klN = false;
  private Signature qyA = null;
  public j qyB = null;
  
  private s() {}
  
  public final void reset()
  {
    y.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
    this.qyA = null;
    this.klM = null;
    this.klN = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */