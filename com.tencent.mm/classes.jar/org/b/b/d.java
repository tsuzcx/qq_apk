package org.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends b
{
  public d(String paramString, Exception paramException)
  {
    super(String.format("Error while signing string: %s", new Object[] { paramString }), paramException);
    AppMethodBeat.i(40505);
    AppMethodBeat.o(40505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.b.b.d
 * JD-Core Version:    0.7.0.1
 */