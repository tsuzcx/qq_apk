package org.apache.commons.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;

public class d
  extends RuntimeException
  implements b
{
  protected c ajXI;
  private Throwable cause;
  
  public d()
  {
    AppMethodBeat.i(40724);
    this.ajXI = new c(this);
    this.cause = null;
    AppMethodBeat.o(40724);
  }
  
  public d(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    AppMethodBeat.i(40726);
    this.ajXI = new c(this);
    this.cause = null;
    this.cause = paramThrowable;
    AppMethodBeat.o(40726);
  }
  
  public d(Throwable paramThrowable)
  {
    AppMethodBeat.i(40725);
    this.ajXI = new c(this);
    this.cause = null;
    this.cause = paramThrowable;
    AppMethodBeat.o(40725);
  }
  
  public final void a(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(40731);
    super.printStackTrace(paramPrintWriter);
    AppMethodBeat.o(40731);
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String getMessage()
  {
    AppMethodBeat.i(40727);
    String str;
    if (super.getMessage() != null)
    {
      str = super.getMessage();
      AppMethodBeat.o(40727);
      return str;
    }
    if (this.cause != null)
    {
      str = this.cause.toString();
      AppMethodBeat.o(40727);
      return str;
    }
    AppMethodBeat.o(40727);
    return null;
  }
  
  public void printStackTrace()
  {
    AppMethodBeat.i(40728);
    this.ajXI.printStackTrace(System.err);
    AppMethodBeat.o(40728);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    AppMethodBeat.i(40729);
    this.ajXI.printStackTrace(paramPrintStream);
    AppMethodBeat.o(40729);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(40730);
    this.ajXI.printStackTrace(paramPrintWriter);
    AppMethodBeat.o(40730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.b.d
 * JD-Core Version:    0.7.0.1
 */