package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum QImageView$a
{
  final int AEF;
  
  static
  {
    AppMethodBeat.i(115515);
    AEx = new a("MATRIX", 0, 0);
    AEy = new a("FIT_XY", 1, 1);
    AEz = new a("FIT_START", 2, 2);
    AEA = new a("FIT_CENTER", 3, 3);
    AEB = new a("FIT_END", 4, 4);
    AEC = new a("CENTER", 5, 5);
    AED = new a("CENTER_CROP", 6, 6);
    AEE = new a("CENTER_INSIDE", 7, 7);
    AEG = new a[] { AEx, AEy, AEz, AEA, AEB, AEC, AED, AEE };
    AppMethodBeat.o(115515);
  }
  
  private QImageView$a(int paramInt)
  {
    this.AEF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView.a
 * JD-Core Version:    0.7.0.1
 */