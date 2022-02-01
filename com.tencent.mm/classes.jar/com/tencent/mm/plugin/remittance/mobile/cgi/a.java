package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.mm.am.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.wallet_core.model.r;

public abstract class a
  extends r
{
  private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitBase";
  protected h callback;
  protected c rr;
  
  public int doScene(g paramg, h paramh)
  {
    this.callback = paramh;
    return dispatch(paramg, this.rr, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.cgi.a
 * JD-Core Version:    0.7.0.1
 */