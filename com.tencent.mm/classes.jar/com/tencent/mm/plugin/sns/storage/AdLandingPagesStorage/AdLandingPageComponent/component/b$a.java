package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$a
{
  int count;
  boolean isVisible;
  long ruE;
  long time;
  
  private b$a(b paramb) {}
  
  final void cqM()
  {
    AppMethodBeat.i(37013);
    if (this.isVisible)
    {
      AppMethodBeat.o(37013);
      return;
    }
    this.isVisible = true;
    this.ruE = System.currentTimeMillis();
    this.count += 1;
    AppMethodBeat.o(37013);
  }
  
  final void cqN()
  {
    AppMethodBeat.i(37014);
    if (this.isVisible)
    {
      this.isVisible = false;
      if (this.ruE > 0L)
      {
        this.time += System.currentTimeMillis() - this.ruE;
        this.ruE = 0L;
      }
    }
    AppMethodBeat.o(37014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b.a
 * JD-Core Version:    0.7.0.1
 */