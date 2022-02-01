package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l
{
  static
  {
    AppMethodBeat.i(215028);
    SNS = new l("opaque", 0);
    SNT = new l("transparent", 1);
    SNU = new l[] { SNS, SNT };
    AppMethodBeat.o(215028);
  }
  
  private l() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.l
 * JD-Core Version:    0.7.0.1
 */