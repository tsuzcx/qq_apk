package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.zc;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (com.tencent.mm.plugin.wear.model.a.eKv().eKF())
    {
      zc localzc = new zc();
      localzc.dOj.dkM = 11;
      com.tencent.mm.sdk.b.a.IbL.l(localzc);
      send();
      return;
    }
    ad.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */