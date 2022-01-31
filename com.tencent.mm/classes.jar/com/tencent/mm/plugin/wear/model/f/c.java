package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.vx;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c
  extends d
{
  protected final void execute()
  {
    if (com.tencent.mm.plugin.wear.model.a.cYy().uGC.cYD())
    {
      vx localvx = new vx();
      localvx.cNm.coO = 11;
      com.tencent.mm.sdk.b.a.ymk.l(localvx);
      send();
      return;
    }
    ab.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
  }
  
  protected abstract void send();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.c
 * JD-Core Version:    0.7.0.1
 */