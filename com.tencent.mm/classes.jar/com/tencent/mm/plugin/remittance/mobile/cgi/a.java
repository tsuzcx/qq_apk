package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.wallet_core.c.r;

public abstract class a
  extends r
{
  private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitBase";
  protected f callback;
  protected b rr;
  
  public int doScene(e parame, f paramf)
  {
    this.callback = paramf;
    return dispatch(parame, this.rr, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.a
 * JD-Core Version:    0.7.0.1
 */