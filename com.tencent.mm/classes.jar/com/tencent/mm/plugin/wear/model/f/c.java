package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.f.a.abw;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (a.gOt().gOG())
    {
      abw localabw = new abw();
      localabw.gbS.fvK = 11;
      EventCenter.instance.publish(localabw);
      gOA();
      return;
    }
    Log.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void gOA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */