package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.ui.b;

final class r$4
  implements Runnable
{
  r$4(r paramr, String paramString) {}
  
  public final void run()
  {
    if (this.pTG.pTr != null)
    {
      o localo = this.pTG.pTr;
      String str = this.val$tips;
      if (localo.pRU != null)
      {
        localo.pSz = str;
        localo.pRU.Qa(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.r.4
 * JD-Core Version:    0.7.0.1
 */