package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.autogen.a.adt;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (a.inI().inU())
    {
      adt localadt = new adt();
      localadt.iie.hAf = 11;
      localadt.publish();
      send();
      return;
    }
    Log.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */