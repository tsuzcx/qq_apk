package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  static final String crl;
  
  static
  {
    AppMethodBeat.i(215076);
    crl = a.SMF.name();
    AppMethodBeat.o(215076);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(215035);
      SMF = new a("opaque", 0);
      SMG = new a("transparent", 1);
      SMH = new a[] { SMF, SMG };
      AppMethodBeat.o(215035);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.d
 * JD-Core Version:    0.7.0.1
 */