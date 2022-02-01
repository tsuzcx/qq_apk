package io.flutter.view;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum a$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(9824);
    MHA = new a("ACCESSIBLE_NAVIGATION", 0, 1);
    MHB = new a("INVERT_COLORS", 1, 2);
    MHC = new a("DISABLE_ANIMATIONS", 2, 4);
    MHD = new a[] { MHA, MHB, MHC };
    AppMethodBeat.o(9824);
  }
  
  private a$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.view.a.a
 * JD-Core Version:    0.7.0.1
 */