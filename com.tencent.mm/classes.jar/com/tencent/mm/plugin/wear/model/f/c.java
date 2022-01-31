package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.h.a.ub;
import com.tencent.mm.sdk.platformtools.y;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (com.tencent.mm.plugin.wear.model.a.bYL().qRu.bYQ())
    {
      ub localub = new ub();
      localub.cez.bHz = 11;
      com.tencent.mm.sdk.b.a.udP.m(localub);
      send();
      return;
    }
    y.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  public abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */