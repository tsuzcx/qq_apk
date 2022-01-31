package org.a.a.b.a;

import java.io.PrintStream;
import java.io.PrintWriter;

public class d
  extends RuntimeException
  implements b
{
  private Throwable cause = null;
  protected c xul = new c(this);
  
  public d(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
  }
  
  public final void a(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String getMessage()
  {
    if (super.getMessage() != null) {
      return super.getMessage();
    }
    if (this.cause != null) {
      return this.cause.toString();
    }
    return null;
  }
  
  public void printStackTrace()
  {
    this.xul.printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    this.xul.printStackTrace(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    this.xul.printStackTrace(paramPrintWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.a.a.b.a.d
 * JD-Core Version:    0.7.0.1
 */