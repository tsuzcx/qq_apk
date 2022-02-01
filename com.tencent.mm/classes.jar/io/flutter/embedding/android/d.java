package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  static final String vlc;
  
  static
  {
    AppMethodBeat.i(197929);
    vlc = a.MYs.name();
    AppMethodBeat.o(197929);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(197896);
      MYs = new a("opaque", 0);
      MYt = new a("transparent", 1);
      MYu = new a[] { MYs, MYt };
      AppMethodBeat.o(197896);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.d
 * JD-Core Version:    0.7.0.1
 */