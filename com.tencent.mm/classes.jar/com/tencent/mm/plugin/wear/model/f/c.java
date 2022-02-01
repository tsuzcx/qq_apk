package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.yi;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (com.tencent.mm.plugin.wear.model.a.ewp().ewz())
    {
      yi localyi = new yi();
      localyi.dBW.cZu = 11;
      com.tencent.mm.sdk.b.a.GpY.l(localyi);
      send();
      return;
    }
    ac.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */