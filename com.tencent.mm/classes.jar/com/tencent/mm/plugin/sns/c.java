package com.tencent.mm.plugin.sns;

import com.tencent.mm.h.a.fm;
import com.tencent.mm.h.a.fm.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends com.tencent.mm.sdk.b.c<fm>
{
  public c()
  {
    this.udX = fm.class.getName().hashCode();
  }
  
  private boolean a(fm paramfm)
  {
    if (!(paramfm instanceof fm))
    {
      y.f("MicroMsg.ExtStartSnsServerAndCallbackOnFpSetSizeEventListener", "mismatched event");
      return false;
    }
    am.a locala = af.bDv();
    locala.a(paramfm.bMm.type, paramfm.bMm.username, new c.1(this, paramfm));
    locala.a(1, paramfm.bMm.username, paramfm.bMm.bMo, paramfm.bMm.bMp);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.c
 * JD-Core Version:    0.7.0.1
 */