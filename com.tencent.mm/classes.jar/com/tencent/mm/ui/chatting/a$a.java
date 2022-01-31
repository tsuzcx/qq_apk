package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a$a
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(30250);
    zuX = new a("PlayIcon", 0, 1);
    zuY = new a("EnterFullScreen", 1, 2);
    zuZ = new a("EnterCompleteVideo", 2, 3);
    zva = new a("DetailInVideo", 3, 4);
    zvb = new a("LeavelFullScreen", 4, 5);
    zvc = new a("LeaveCompleteVideo", 5, 6);
    zvd = new a("SightLoaded", 6, 7);
    zve = new a[] { zuX, zuY, zuZ, zva, zvb, zvc, zvd };
    AppMethodBeat.o(30250);
  }
  
  private a$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a
 * JD-Core Version:    0.7.0.1
 */