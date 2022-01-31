package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ak.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedList;
import java.util.Map;

public final class ar$5
  implements Runnable
{
  public ar$5(ar paramar, String paramString, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    o.Ss().k(this.otP, this.ejq);
    if ((this.otO.otJ != null) && (bk.isEqual(this.otO.otJ.eFo, this.otP))) {
      ar.a(this.otO);
    }
    ay localay = (ay)this.otO.otL.get(this.otP);
    this.otO.otK.remove(localay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.5
 * JD-Core Version:    0.7.0.1
 */