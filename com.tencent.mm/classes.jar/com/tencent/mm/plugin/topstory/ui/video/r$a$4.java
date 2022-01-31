package com.tencent.mm.plugin.topstory.ui.video;

final class r$a$4
  implements Runnable
{
  r$a$4(r.a parama, String paramString, int paramInt) {}
  
  public final void run()
  {
    if ((this.pGG.pGD.pGu != null) && (this.pGG.pGD.pEp != null))
    {
      com.tencent.mm.plugin.topstory.a.b.a locala = this.pGG.pGD.pEp.bNt().pGq;
      if ((locala != null) && (locala.pDq == 0L)) {
        locala.pDq = (System.currentTimeMillis() - locala.pDe);
      }
      this.pGG.pGD.pGu.V(this.BF, this.pGH);
      if (this.pGH != 0) {
        com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(9);
      }
    }
    else
    {
      return;
    }
    com.tencent.mm.plugin.websearch.api.a.a.jdMethod_if(27);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.r.a.4
 * JD-Core Version:    0.7.0.1
 */