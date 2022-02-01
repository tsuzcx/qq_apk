package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j$b
{
  public String name;
  
  static
  {
    AppMethodBeat.i(10268);
    SRl = new b("light", 0, "light");
    SRm = new b("dark", 1, "dark");
    SRn = new b[] { SRl, SRm };
    AppMethodBeat.o(10268);
  }
  
  private j$b(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.c.j.b
 * JD-Core Version:    0.7.0.1
 */