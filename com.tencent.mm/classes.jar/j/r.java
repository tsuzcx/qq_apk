package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "close", "", "flush", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 4, 1})
final class r
  implements y
{
  private final ab ajTo;
  private final OutputStream out;
  
  public r(OutputStream paramOutputStream, ab paramab)
  {
    AppMethodBeat.i(186266);
    this.out = paramOutputStream;
    this.ajTo = paramab;
    AppMethodBeat.o(186266);
  }
  
  public final void b(f paramf, long paramLong)
  {
    AppMethodBeat.i(186274);
    s.u(paramf, "source");
    c.C(paramf.size, 0L, paramLong);
    while (paramLong > 0L)
    {
      this.ajTo.kIV();
      v localv = paramf.ajTb;
      s.checkNotNull(localv);
      int i = (int)Math.min(paramLong, localv.limit - localv.pos);
      this.out.write(localv.data, localv.pos, i);
      localv.pos += i;
      long l = paramLong - i;
      paramf.size -= i;
      paramLong = l;
      if (localv.pos == localv.limit)
      {
        paramf.ajTb = localv.kJa();
        w.b(localv);
        paramLong = l;
      }
    }
    AppMethodBeat.o(186274);
  }
  
  public final void close()
  {
    AppMethodBeat.i(186280);
    this.out.close();
    AppMethodBeat.o(186280);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(186275);
    this.out.flush();
    AppMethodBeat.o(186275);
  }
  
  public final ab kHm()
  {
    return this.ajTo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186286);
    String str = "sink(" + this.out + ')';
    AppMethodBeat.o(186286);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     j.r
 * JD-Core Version:    0.7.0.1
 */