package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k=1, mv={1, 4, 1})
final class o
  implements aa
{
  private final ab ajTo;
  private final InputStream dJc;
  
  public o(InputStream paramInputStream, ab paramab)
  {
    AppMethodBeat.i(186248);
    this.dJc = paramInputStream;
    this.ajTo = paramab;
    AppMethodBeat.o(186248);
  }
  
  public final long a(f paramf, long paramLong)
  {
    AppMethodBeat.i(186255);
    s.u(paramf, "sink");
    if (paramLong == 0L)
    {
      AppMethodBeat.o(186255);
      return 0L;
    }
    if (paramLong >= 0L) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramf = (Throwable)new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)).toString());
      AppMethodBeat.o(186255);
      throw paramf;
    }
    try
    {
      this.ajTo.kIV();
      localv = paramf.aNm(1);
      i = (int)Math.min(paramLong, 8192 - localv.limit);
      i = this.dJc.read(localv.data, localv.limit, i);
      if (i == -1)
      {
        if (localv.pos == localv.limit)
        {
          paramf.ajTb = localv.kJa();
          w.b(localv);
        }
        AppMethodBeat.o(186255);
        return -1L;
      }
    }
    catch (AssertionError paramf)
    {
      v localv;
      if (p.a(paramf))
      {
        paramf = (Throwable)new IOException((Throwable)paramf);
        AppMethodBeat.o(186255);
        throw paramf;
        localv.limit += i;
        paramf.size += i;
        paramLong = i;
        AppMethodBeat.o(186255);
        return paramLong;
      }
      paramf = (Throwable)paramf;
      AppMethodBeat.o(186255);
      throw paramf;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(186258);
    this.dJc.close();
    AppMethodBeat.o(186258);
  }
  
  public final ab kHm()
  {
    return this.ajTo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186263);
    String str = "source(" + this.dJc + ')';
    AppMethodBeat.o(186263);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.o
 * JD-Core Version:    0.7.0.1
 */