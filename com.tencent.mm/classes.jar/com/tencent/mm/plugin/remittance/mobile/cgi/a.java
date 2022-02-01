package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.mm.al.b;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.wallet_core.c.r;

public abstract class a
  extends r
{
  private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitBase";
  protected g callback;
  protected b rr;
  
  public int doScene(e parame, g paramg)
  {
    this.callback = paramg;
    return dispatch(parame, this.rr, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.a
 * JD-Core Version:    0.7.0.1
 */