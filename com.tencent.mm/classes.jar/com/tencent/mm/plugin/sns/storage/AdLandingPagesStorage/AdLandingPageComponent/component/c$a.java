package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

final class c$a
{
  int count;
  boolean isVisible;
  long oFd;
  long time;
  
  private c$a(c paramc) {}
  
  final void bFh()
  {
    if (this.isVisible)
    {
      this.isVisible = false;
      if (this.oFd > 0L)
      {
        this.time += System.currentTimeMillis() - this.oFd;
        this.oFd = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.a
 * JD-Core Version:    0.7.0.1
 */