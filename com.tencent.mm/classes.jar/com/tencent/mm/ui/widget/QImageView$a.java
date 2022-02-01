package com.tencent.mm.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum QImageView$a
{
  final int Ydo;
  
  static
  {
    AppMethodBeat.i(156563);
    Ydg = new a("MATRIX", 0, 0);
    Ydh = new a("FIT_XY", 1, 1);
    Ydi = new a("FIT_START", 2, 2);
    Ydj = new a("FIT_CENTER", 3, 3);
    Ydk = new a("FIT_END", 4, 4);
    Ydl = new a("CENTER", 5, 5);
    Ydm = new a("CENTER_CROP", 6, 6);
    Ydn = new a("CENTER_INSIDE", 7, 7);
    Ydp = new a[] { Ydg, Ydh, Ydi, Ydj, Ydk, Ydl, Ydm, Ydn };
    AppMethodBeat.o(156563);
  }
  
  private QImageView$a(int paramInt)
  {
    this.Ydo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.QImageView.a
 * JD-Core Version:    0.7.0.1
 */