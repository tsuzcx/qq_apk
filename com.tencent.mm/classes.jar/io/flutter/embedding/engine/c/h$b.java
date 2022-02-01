package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$b
{
  public String name;
  
  static
  {
    AppMethodBeat.i(10268);
    JaB = new b("light", 0, "light");
    JaC = new b("dark", 1, "dark");
    JaD = new b[] { JaB, JaC };
    AppMethodBeat.o(10268);
  }
  
  private h$b(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.engine.c.h.b
 * JD-Core Version:    0.7.0.1
 */