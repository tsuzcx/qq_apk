package io.flutter.embedding.android;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TransparencyMode
{
  static
  {
    AppMethodBeat.i(190472);
    opaque = new TransparencyMode("opaque", 0);
    transparent = new TransparencyMode("transparent", 1);
    $VALUES = new TransparencyMode[] { opaque, transparent };
    AppMethodBeat.o(190472);
  }
  
  private TransparencyMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.TransparencyMode
 * JD-Core Version:    0.7.0.1
 */