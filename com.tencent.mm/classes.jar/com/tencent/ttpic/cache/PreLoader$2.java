package com.tencent.ttpic.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;

class PreLoader$2
  implements Runnable
{
  PreLoader$2(PreLoader paramPreLoader, int paramInt) {}
  
  public void run()
  {
    AppMethodBeat.i(81831);
    this.this$0.preloadNewImages(this.val$index);
    PreLoader.access$002(this.this$0, false);
    AppMethodBeat.o(81831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.cache.PreLoader.2
 * JD-Core Version:    0.7.0.1
 */