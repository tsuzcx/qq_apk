package org.apache.commons.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.io.Writer;

public final class b
  extends Writer
  implements Serializable
{
  private final StringBuilder EjO;
  
  public b()
  {
    AppMethodBeat.i(10311);
    this.EjO = new StringBuilder();
    AppMethodBeat.o(10311);
  }
  
  public b(byte paramByte)
  {
    AppMethodBeat.i(10312);
    this.EjO = new StringBuilder(4);
    AppMethodBeat.o(10312);
  }
  
  public final Writer append(char paramChar)
  {
    AppMethodBeat.i(10313);
    this.EjO.append(paramChar);
    AppMethodBeat.o(10313);
    return this;
  }
  
  public final Writer append(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(10314);
    this.EjO.append(paramCharSequence);
    AppMethodBeat.o(10314);
    return this;
  }
  
  public final Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10315);
    this.EjO.append(paramCharSequence, paramInt1, paramInt2);
    AppMethodBeat.o(10315);
    return this;
  }
  
  public final void close() {}
  
  public final void flush() {}
  
  public final String toString()
  {
    AppMethodBeat.i(10318);
    String str = this.EjO.toString();
    AppMethodBeat.o(10318);
    return str;
  }
  
  public final void write(String paramString)
  {
    AppMethodBeat.i(10316);
    if (paramString != null) {
      this.EjO.append(paramString);
    }
    AppMethodBeat.o(10316);
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10317);
    if (paramArrayOfChar != null) {
      this.EjO.append(paramArrayOfChar, paramInt1, paramInt2);
    }
    AppMethodBeat.o(10317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.apache.commons.a.a.b
 * JD-Core Version:    0.7.0.1
 */