package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.wallet_core.c.r;

public abstract class a
  extends r
{
  private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitBase";
  protected i callback;
  protected d rr;
  
  public int doScene(g paramg, i parami)
  {
    this.callback = parami;
    return dispatch(paramg, this.rr, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.a
 * JD-Core Version:    0.7.0.1
 */