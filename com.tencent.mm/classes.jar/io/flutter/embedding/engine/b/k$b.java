package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$b
{
  public String name;
  
  static
  {
    AppMethodBeat.i(10268);
    aatK = new b("light", 0, "light");
    aatL = new b("dark", 1, "dark");
    aatM = new b[] { aatK, aatL };
    AppMethodBeat.o(10268);
  }
  
  private k$b(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.b.k.b
 * JD-Core Version:    0.7.0.1
 */