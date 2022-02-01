package okhttp3.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.f;
import j.j;
import j.y;
import java.io.IOException;

class e
  extends j
{
  private boolean ajPh;
  
  e(y paramy)
  {
    super(paramy);
  }
  
  public final void b(f paramf, long paramLong)
  {
    AppMethodBeat.i(187036);
    if (this.ajPh)
    {
      paramf.Ci(paramLong);
      AppMethodBeat.o(187036);
      return;
    }
    try
    {
      super.b(paramf, paramLong);
      AppMethodBeat.o(187036);
      return;
    }
    catch (IOException paramf)
    {
      this.ajPh = true;
      kHt();
      AppMethodBeat.o(187036);
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(187053);
    if (this.ajPh)
    {
      AppMethodBeat.o(187053);
      return;
    }
    try
    {
      super.close();
      AppMethodBeat.o(187053);
      return;
    }
    catch (IOException localIOException)
    {
      this.ajPh = true;
      kHt();
      AppMethodBeat.o(187053);
    }
  }
  
  public void flush()
  {
    AppMethodBeat.i(187043);
    if (this.ajPh)
    {
      AppMethodBeat.o(187043);
      return;
    }
    try
    {
      super.flush();
      AppMethodBeat.o(187043);
      return;
    }
    catch (IOException localIOException)
    {
      this.ajPh = true;
      kHt();
      AppMethodBeat.o(187043);
    }
  }
  
  protected void kHt() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.a.e
 * JD-Core Version:    0.7.0.1
 */