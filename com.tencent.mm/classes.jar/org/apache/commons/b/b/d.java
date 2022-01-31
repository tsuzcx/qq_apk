package org.apache.commons.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.io.PrintWriter;

public class d
  extends RuntimeException
  implements b
{
  protected c CRu;
  private Throwable cause;
  
  public d(Throwable paramThrowable)
  {
    AppMethodBeat.i(116948);
    this.CRu = new c(this);
    this.cause = null;
    this.cause = paramThrowable;
    AppMethodBeat.o(116948);
  }
  
  public final void b(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(116953);
    super.printStackTrace(paramPrintWriter);
    AppMethodBeat.o(116953);
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String getMessage()
  {
    AppMethodBeat.i(116949);
    String str;
    if (super.getMessage() != null)
    {
      str = super.getMessage();
      AppMethodBeat.o(116949);
      return str;
    }
    if (this.cause != null)
    {
      str = this.cause.toString();
      AppMethodBeat.o(116949);
      return str;
    }
    AppMethodBeat.o(116949);
    return null;
  }
  
  public void printStackTrace()
  {
    AppMethodBeat.i(116950);
    this.CRu.printStackTrace(System.err);
    AppMethodBeat.o(116950);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    AppMethodBeat.i(116951);
    this.CRu.printStackTrace(paramPrintStream);
    AppMethodBeat.o(116951);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    AppMethodBeat.i(116952);
    this.CRu.printStackTrace(paramPrintWriter);
    AppMethodBeat.o(116952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.b.d
 * JD-Core Version:    0.7.0.1
 */