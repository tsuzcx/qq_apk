package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.aap;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (a.fVM().fVW())
    {
      aap localaap = new aap();
      localaap.ehC.dDe = 11;
      EventCenter.instance.publish(localaap);
      send();
      return;
    }
    Log.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */