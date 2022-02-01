package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.zi;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (com.tencent.mm.plugin.wear.model.a.eOd().eOn())
    {
      zi localzi = new zi();
      localzi.dPz.dlO = 11;
      com.tencent.mm.sdk.b.a.IvT.l(localzi);
      send();
      return;
    }
    ae.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */