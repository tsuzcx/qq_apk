package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum QImageView$a
{
  final int HBA;
  
  static
  {
    AppMethodBeat.i(156563);
    HBs = new a("MATRIX", 0, 0);
    HBt = new a("FIT_XY", 1, 1);
    HBu = new a("FIT_START", 2, 2);
    HBv = new a("FIT_CENTER", 3, 3);
    HBw = new a("FIT_END", 4, 4);
    HBx = new a("CENTER", 5, 5);
    HBy = new a("CENTER_CROP", 6, 6);
    HBz = new a("CENTER_INSIDE", 7, 7);
    HBB = new a[] { HBs, HBt, HBu, HBv, HBw, HBx, HBy, HBz };
    AppMethodBeat.o(156563);
  }
  
  private QImageView$a(int paramInt)
  {
    this.HBA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView.a
 * JD-Core Version:    0.7.0.1
 */