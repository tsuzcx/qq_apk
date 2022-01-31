package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$a
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(35767);
    rad = new a("PlayIcon", 0, 1);
    rae = new a("EnterFullScreen", 1, 2);
    raf = new a("EnterCompleteVideo", 2, 3);
    rag = new a("DetailInVideo", 3, 4);
    rah = new a("LeavelFullScreen", 4, 5);
    rai = new a("LeaveCompleteVideo", 5, 6);
    raj = new a("SightLoaded", 6, 7);
    rak = new a("DetailTimeline", 7, 8);
    ral = new a[] { rad, rae, raf, rag, rah, rai, raj, rak };
    AppMethodBeat.o(35767);
  }
  
  private k$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.k.a
 * JD-Core Version:    0.7.0.1
 */