package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, k=1, mv={1, 4, 1})
final class z
  extends d
{
  private final Socket cBb;
  
  public z(Socket paramSocket)
  {
    AppMethodBeat.i(186314);
    this.cBb = paramSocket;
    AppMethodBeat.o(186314);
  }
  
  protected final IOException g(IOException paramIOException)
  {
    AppMethodBeat.i(186317);
    SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
    if (paramIOException != null) {
      localSocketTimeoutException.initCause((Throwable)paramIOException);
    }
    paramIOException = (IOException)localSocketTimeoutException;
    AppMethodBeat.o(186317);
    return paramIOException;
  }
  
  protected final void kHd()
  {
    AppMethodBeat.i(186320);
    try
    {
      this.cBb.close();
      AppMethodBeat.o(186320);
      return;
    }
    catch (Exception localException)
    {
      p.kIW().log(Level.WARNING, "Failed to close timed out socket " + this.cBb, (Throwable)localException);
      AppMethodBeat.o(186320);
      return;
    }
    catch (AssertionError localAssertionError)
    {
      if (p.a(localAssertionError))
      {
        p.kIW().log(Level.WARNING, "Failed to close timed out socket " + this.cBb, (Throwable)localAssertionError);
        AppMethodBeat.o(186320);
        return;
      }
      Throwable localThrowable = (Throwable)localAssertionError;
      AppMethodBeat.o(186320);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.z
 * JD-Core Version:    0.7.0.1
 */