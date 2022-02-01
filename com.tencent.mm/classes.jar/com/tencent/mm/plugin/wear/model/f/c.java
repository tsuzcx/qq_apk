package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.xx;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (com.tencent.mm.plugin.wear.model.a.egV().ehf())
    {
      xx localxx = new xx();
      localxx.dEk.dbV = 11;
      com.tencent.mm.sdk.b.a.ESL.l(localxx);
      send();
      return;
    }
    ad.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */